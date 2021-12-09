# Using a Docker container<a name="automate-proceed"></a>

This section includes information about how to build your own Docker container\. There is a security risk if you re\-use Docker containers built by third parties: these containers can execute arbitrary code with your user permissions\. Make sure you trust the author of any third\-party container before using it\.

Here are the steps you would take to set up periodic data analysis on data which has arrived since the last analysis was performed:

1. Create a Docker container that contains your data application plus any required libraries or other dependencies\.

   The IotAnalytics Jupyter extension provides a containerization API to assist in the containerization process\. You can also run images of your own creation in which you create or assemble your application toolset to perform the desired data analysis or computation\. AWS IoT Analytics enables you to define the source of the input data to the containerized application and the destination for the output data of the Docker container by means of variables\. \([Custom Docker container Input/Output variables](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate-custom-docker) contains more information about using variables with a custom container\.\)

1. Upload the container to an [Amazon ECR](https://docs.aws.amazon.com/AmazonECR/latest/userguide/docker-basics.html#use-ecr) registry\.

1. Create a data store to receive and store messages \(data\) from devices \(`iotanalytics: [CreateDatastore](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdatastore)`\)

1. Create a channel where the messages are sent \(`iotanalytics: [CreateChannel](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createchannel)`\)\.

1. Create a pipeline to connect the channel to the data store \(`iotanalytics: [CreatePipeline](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createpipeline)`\)\.

1. Create an IAM role that grants permission to send message data to an AWS IoT Analytics channel \(`iam: [CreateRole](https://docs.aws.amazon.com/IAM/latest/APIReference/API_CreateRole.html).`\)

1. Create an IoT rule that uses a SQL query to connect a channel to the source of the message data \(`iot: [CreateTopicRule](https://docs.aws.amazon.com/iot/latest/apireference/API_CreateTopicRule.html)` field `topicRulePayload:actions:iotAnalytics`\)\. When a device sends a message with the appropriate topic visa MQTT, it is routed to your channel\. Or, you can use `iotanalytics: [BatchPutMessage](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-batchputmessage)` to send messages directly into a channel from a device capable of using the AWS SDK or AWS CLI\.

1. Create a SQL dataset whose creation is triggered by a time schedule \(`iotanalytics: [CreateDataset,](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset)` field `actions: queryAction:sqlQuery`\)\.

   You also specify a pre\-filter to be applied to the message data to help limit the messages to those which have arrived since the last execution of the action\. \(Field `actions:queryAction:filters:deltaTime:timeExpression` gives an expression by which the time of a message may be determined\. while field `actions:queryAction:filters:deltaTime:offsetSeconds` specifies possible latency in the arrival of a message\.\)

   The pre\-filter, along with the trigger schedule, determines your delta window\. Each new SQL dataset is created using messages received since the last time the SQL dataset was created\. \(What about the first time the SQL dataset is created? An estimate of when the last time the dataset would have been created is made based on the schedule and the pre\-filter\.\)

1. Create another dataset that is triggered by the creation of the first \( [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset) field `trigger:dataset`\)\. For this dataset, you specify a container action \(filed `actions:containerAction`\) that points to, and gives information needed to run, the Docker container you created in the first step\. Here you also specify:
   + The ARN of the docker container stored in your account \(`image`\.\)
   + The ARN of the role which gives permission to the system to access needed resources in order to run the container action \(`executionRoleArn`\)\.
   + The configuration of the resource that executes the container action \(`resourceConfiguration`\.\)
   + The type if the compute resource used to execute the container action \(`computeType` with possible values: `ACU_1 [vCPU=4, memory=16GiB] or ACU_2 [vCPU=8, memory=32GiB]`\)\.
   + The size \(GB\) of the persistent storage available to the resource instance used to execute the container action \(`volumeSizeInGB`\)\.
   + The values of variables used within the context of the execution of the application \(basically, parameters passed to the application\) \(`variables`\)\.

     These variables are replaced at the time a container is executed\. This enables you to run the same container with different variables \(parameters\) which are supplied at the time the dataset content is created\. The IotAnalytics Jupyter extension simplifies this process by automatically recognizing the variables in a notebook and making them available as part of the containerization process\. You can choose the recognized variables or add custom variables of your own\. Before it runs a container, the system replaces each of these variables with the value current at the time of execution\.
   + One of the variables is the name of the dataset whose latest content is used as input to the application \(this is the name of the dataset you created in the previous step\) \(`datasetContentVersionValue:datasetName`\)\.

With the SQL query and delta window to generate the dataset, and the container with your application, AWS IoT Analytics creates a scheduled production dataset that runs at the interval you specify on data from the delta window, producing your desired output and sending notifications\.

You can pause your production dataset application and resume it whenever you choose to do so\. When you resume your production dataset application, AWS IoT Analytics, by default, catches up all the data that has arrived since last execution, but hasn't been analyzed yet\. You can also configure how you want to resume your production dataset job window length\) by performing a series of consecutive runs\. Alternatively, you can resume your production dataset application by capturing only the newly arrived data that fits within the specified size of your delta window\.

Please note the following limitations when creating or defining a dataset which is triggered by the creation of another dataset:
+ Only container datasets can be triggered by SQL datasets\.
+ A SQL dataset can trigger at most 10 container datasets\.

The following errors may be returned when creating a container dataset which is triggered by a SQL dataset:
+ "Triggering dataset can only be added on a container dataset"
+ "There can only be one triggering dataset"

  This error occurs if you attempt to define a container dataset which is triggered by two different SQL dataset\. 
+ "The triggering dataset <dataset\-name> cannot be triggered by a container dataset"

  This error occurs if you attempt to define another container dataset which is triggered by another container dataset\.
+ "<N> datasets are already dependent on <dataset\-name> dataset\."

  This error occurs if you attempt to define another container dataset which is triggered by a SQL dataset which already triggers 10 container datasets\.
+ "Exactly one trigger type should be provided"

  This error occurs is you attempt to define a dataset which is triggered by both a schedule trigger and a dataset trigger\.

## Custom Docker container input/output variables<a name="automate-custom-docker"></a>

This section demonstrates how the program which is run by your custom Docker image may read input variables and upload its output\. 

**Params File**

The input variables and the destinations to which you want to upload output are stored in a JSON file located at `/opt/ml/input/data/iotanalytics/params` on the instance that executes your docker image\. Here is an example of the contents of that file\.

```
{
   "Context": {
       "OutputUris": {
           "html": "s3://aws-iot-analytics-dataset-xxxxxxx/notebook/results/iotanalytics-xxxxxxx/output.html",
           "ipynb": "s3://aws-iot-analytics-dataset-xxxxxxx/notebook/results/iotanalytics-xxxxxxx/output.ipynb"
       }
   },
   "Variables": {
       "source_dataset_name": "mydataset",
       "source_dataset_version_id": "xxxx",
       "example_var": "hello world!",
       "custom_output": "s3://aws-iot-analytics/dataset-xxxxxxx/notebook/results/iotanalytics-xxxxxxx/output.txt"
   }
}
```

In addition to the name and version ID of your dataset, the `Variables` section contains the variables specified in the `iotanalytics:CreateDataset` invocation\-\- in this example, a variable `example_var` was given the value `hello world!`\. A custom output URI was also provided in the `custom_output` variable\. The `OutputUris` field contains default locations to which the container can upload its output\-\- in this example, default output URIs were provided for both ipynb and html output\.

**Input variables**

The program launched by your Docker image can read variables from the `params` file\. Here is an example program which opens the `params` file, parses it, and prints the value of the `example_var` variable\.

```
import json

with open("/opt/ml/input/data/iotanalytics/params") as param_file:
    params = json.loads(param_file.read())
example_var = params["Variables"]["example_var"]
print(example_var)
```

**Uploading output**

The program launched by your Docker image might also store its output in an Amazon S3 location\. The output must be loaded with a "bucket\-owner\-full\-control" [access control list](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html)\. The access list grants the AWS IoT Analytics service control over the uploaded output\. In this example we extend the previous one to upload the contents of `example_var` to the Amazon S3 location defined by `custom_output` in the `params` file\.

```
import boto3
import json
from urllib.parse import urlparse

ACCESS_CONTROL_LIST = "bucket-owner-full-control"

with open("/opt/ml/input/data/iotanalytics/params") as param_file:
    params = json.loads(param_file.read())
example_var = params["Variables"]["example_var"]

outputUri = params["Variables"]["custom_output"]
# break the S3 path into a bucket and key
bucket = urlparse(outputUri).netloc
key = urlparse(outputUri).path.lstrip("/")

s3_client = boto3.client("s3")
s3_client.put_object(Bucket=bucket, Key=key, Body=example_var, ACL=ACCESS_CONTROL_LIST)
```
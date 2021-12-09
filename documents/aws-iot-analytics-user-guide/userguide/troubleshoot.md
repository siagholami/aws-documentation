# AWS IoT Analytics Troubleshooting Guide<a name="troubleshoot"></a>

 **Q: How do I know if my messages are getting into AWS IoT Analytics?** 
+ Check if the rule to inject data into the channel through the rules\-engine is configured correctly:

  ```
  aws iot get-topic-rule --rule-name <your-rule-name>
  ```

  The response should look like:

  ```
  {
      "ruleArn": "arn:aws:iot:us-west-2:<your-account-id>:rule/<your-rule-name>",
      "rule": {
          "awsIotSqlVersion": "2016-03-23",
          "sql": "SELECT * FROM 'iot/<your-rule-name>'",
          "ruleDisabled": false,
          "actions": [
              {
                  "iotAnalytics": {
                      "channelArn": "arn:aws:iotanalytics:<region>:<your_account_number>:channel/<your-channel-name>"
                  }
              }
          ],
          "ruleName": "<your-rule-name>"
      }
  }
  ```

  Make sure the region and channel name used in the rule are correct\. To ensure your data is reaching the rules engine and the rule is being executed correctly, you might want to add a new target to store incoming messages in the S3 bucket temporarily\.

 **Q: Why is my pipeline losing messages? How do I fix it?** 
+ An activity has received an invalid JSON input:

  All activities, except Lambda activities, specifically require a valid JSON string as input\. If the JSON received by an activity is invalid, then the message is dropped and does not make its way into the data store\. Make sure you are ingesting valid JSON messages into the service\. In case of binary input, make sure the first activity in your pipeline is a Lambda activity that converts the binary data to valid JSON before passing it to the next activity or storing it in the data store\. See [Lambda Function Example 2](pipeline-activities.md#aws-iot-analytics-pipeline-activities-lambda-ex2) for more information\.
+ A Lambda function invoked by a Lambda activity has insufficient permissions:

  Make sure that each Lambda function in a Lambda activity has permission to be invoked from the AWS IoT Analytics service\. You can use the following CLI command to grant permission:

  ```
  aws lambda add-permission --function-name <name> --region <region> --statement-id <id> --principal iotanalytics.amazonaws.com --action lambda:InvokeFunction
  ```
+ A filter or removeAttribute activity is incorrectly defined:

  Make sure the definitions of any `filter` or `removeAttribute` activities are correct\. If you filter out a message or remove all attributes from a message, that message is not added to the data store\.

 **Q: Why is there no data in my data store?** 
+ There is a delay between data ingestion and data availability:

  It might take several minutes after data is ingested into a channel before that data is available in the data store\. The time varies based on the number of pipeline activities and the definition of any custom Lambda activities in your pipeline\.
+ Messages are being filtered out in your pipeline:

  Make sure you are not dropping messages in the pipeline\. \(See the previous question and response\.\)
+ Your data set query is incorrect:

  Make sure the query that generates the data set from the data store is correct\. Remove any unnecessary filters from the query to ensure your data reaches your data store\.

 **Q: Why does my data set just show :code:`\_\_dt`?** 
+ This column is added by the service automatically and contains the approximate ingestion time of the data\. It may be used to optimize your queries\. If your data set contains nothing but this, see the previous question and response\.

 **Q: How do I code an event driven by the data set completion?** 
+ You must set up polling based on the `describe-dataset` command to check if the status of the data set with a particular timestamp is `SUCCEEDED`\.

 **Q: How do I correctly configure my notebook instance to use the IotAnalytics Service?** 
+ Follow these steps to make sure the IAM role you are using to create the notebook instance has the required permissions:

  1. Go to the Amazon SageMaker console and create a notebook instance\.

  1. Fill in the details and choose **create a new role**\. Make a note of the role ARN\.

  1. Create the notebook instance\. This also creates a role that Amazon SageMaker can use\.

  1. Go to the IAM console and modify the newly created Amazon SageMaker role\. When you open that role, it should have a managed policy\.

  1. Click **add inline policy**, choose `IotAnalytics` as the service, and under read permission, select **GetDatasetContent**\.

  1. Review the policy, add a policy name, and then **create** it\. The newly created role now has policy permission to read a data set from AWS IoT Analytics\.

  1. Go to the AWS IoT Analytics console and create notebooks in the notebook instance\.

  1. Wait for the notebook instance to be in the "In Service" state\.

  1. Choose **create notebooks**, and select the notebook instance you created\. This creates a Jupyter notebook with the selected template that can access your data sets\.

 **Q: Why can't I create notebooks in an instance?** 
+ Make sure you create a notebook instance with the correct IAM policy\. \(Follow the steps in the previous question\.\)
+ Make sure the notebook instance is in the "In Service" state\. \(When you create an instance, it starts in a "Pending" state\. It usually takes about five minutes for it to go into the "In Service" state\. If the notebook instance goes into the "Failed" state after about five minutes, check the permissions again\.\)

 **Q: Why is my notebook unable to pull data from my data sets?** 
+ Make sure the notebook instance has all the required permissions as described earlier\. The notebook instance must have read permission to the data set's content\.

 **Q: Why am I not seeing my data sets in QuickSight?** 
+ Follow these steps to make sure you have given QuickSight read permission for data set content:

  1. Click the icon in the upper\-right corner \(mentioning the account name\) and choose **Manage QuickSight** 

  1. Choose **Account settings**, and then under **Connected products & services** choose **Add or remove** 

  1. Check the box next to **AWS IoT Analytics**, then select **Update**\. This gives QuickSight read permissions to your data sets\.

  1. Try again to visualize your data\.

 **Q: Why am I not seeing the containerize button on my existing Jupyter Notebook?** 
+ This is caused by a missing AWS IoT Analytics Containerization Plugin\. If you created your SageMaker notebook instance before August 23, 2018, you need to manually install the plugin by following the instructions in [Containerizing A Notebook](automate.md#aws-iot-analytics-automate-containerize)\. Or, you can create a SageMaker notebook instance from the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home) where the plugin is automatically installed for you\. If the SageMaker notebook instance was created in the SageMaker console, install the plugin manually\.
+ If you restarted the notebook instance after manually installing the plugin, you may lose the plugin and have to re\-install it by following the instructions in [Containerizing A Notebook](automate.md#aws-iot-analytics-automate-containerize)\.
+ If you don't see the containerize button after creating the SageMaker notebook instance from the AWS IoT Analytics console or manually installing it, please reach out to AWS IoT Analytics Technical Support\.

 **Q: Why is my containerization plugin installation failing?** 
+ Usually, the plugin installation fails because of missing permissions in the SageMaker notebook instance\. For the required permissions for the notebook instance, see [Permissions](automate.md#aws-iot-analytics-automate-permissions) and add the required permissions to the notebook instance role\. If the problem persists, create a new notebook instance from the AWS Iot Analytics console\.
+ You can safely ignore the following message in the log if it appears during installation of the plugin: "To initialize this nbextension in the browser every time the notebook \(or other app\) loads\."

 **Q: Why is my containerization plugin throwing an error?** 
+ Containerization can fail and generate errors for multiple reasons\. Make sure that you're using the correct kernel before containerizing your notebook\. Containerized kernels begin with the "Containerized" prefix\.
+ Since the plugin creates and saves a docker image in an ECR repository, make sure that your notebook instance role has sufficient permissions to read, list and create ECR repositories\. For the required permissions for the notebook instance, see [Permissions](automate.md#aws-iot-analytics-automate-permissions) and add the required permissions to the notebook instance role\.
+ Also make sure that the name of the repository complies with ECR requirements\. ECR repository names must start with a letter and can contain only lower\-case letters, numbers, hyphens, underscores, and forward slashes\.
+ If the containerization process fails with the error: "This instance has insufficient free space to run containerization" try using a larger instance to resolve the issue\.
+ If you see connection errors or an image creation error, please retry\. If the problem persists, restart the instance and install the latest plugin version\.

 **Q: Why don't I see my variables during the containerization\.** 
+ The AWS Iot Analytics containerization plugin automatically recognizes all variables in your notebook after it runs the notebook with the "Containerized" kernel\. Use one of the containerized kernels to run the notebook, and then perform containerization\.

 **Q: What variables can I add to my container as an input?** 
+ You can add any variable whose value you want to modify during the runtime as an input to your container\. This enables you to run the same container with different parameters that need to be supplied at the time of dataset creation\. The AWS IoT Analytics containerization Jupyter plugin simplifies this process by automatically recognizing the variables in the notebook and making them available as part of the containerization process\.

 **Q: How do I set my container output as an input for subsequent analysis?** 
+ A specific S3 location where the executed artifacts can be stored is created for each run of your container dataset\. To access this output location, create a variable with type `outputFileUriValue` in your container dataset\. The value of this variable should be an S3 path that is used for storing your additional output files\. To access these saved artifacts in subsequent runs, you can use the code:*getDatasetContent* API and pick the appropriate output file required for the subsequent run\.

 **Q: Why is my container dataset failing?** 
+ Make sure that you're passing the correct executionRole to the container dataset\. The trust policy of the executionRole must include both "iotanalytics\.amazonaws\.com" and "sagemaker\.amazonaws\.com"\.
+ If you see "AlgorithmError" as the reason for the failure, try to debug your container code manually\. This happens if there is a bug in the container code or the execution role doesn't have permission to execute the container\. If you containerized by using the AWS Iot Analytics Jupyter plugin, create a new SageMaker notebook instance with the same role as the executionRole of the containerDataset and try running the notebook manually\. If the container was created outside of the Jupyter plugin, try manually running the code and limiting the permission to the executionRole\.
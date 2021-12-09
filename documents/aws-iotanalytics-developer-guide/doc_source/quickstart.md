# AWS IoT Analytics console quickstart guide<a name="quickstart"></a>

This section show you how to use the AWS IoT Analytics console to collect, store, process, and query your device data\. Follow the instructions below to see details of how to create a channel, data store, pipeline and data set, and how to use the AWS IoT Core console to send messages that will be ingested into AWS IoT Analytics

**Note**  
Be aware as you enter the names of AWS IoT Analytics entities \(channel, data set, data store, and pipeline\) in the steps that follow, that any uppercase letters you use are automatically changed to lowercase by the system\. The names of entities must start with a lowercase letter and contain only lowercase letters, underscores and digits

The AWS IoT Analytics console also has a **Quick start** feature that enables you to create a channel, data store, pipeline and data set with one click\. Look for this page when you enter the AWS IoT Analytics console\.

![\[Screenshot of the quick start feature in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-quickstart.png)

**Topics**
+ [Sign in to the AWS IoT Analytics console](#quickstart-console-signin)
+ [Create a channel](#quickstart-create-channel)
+ [Create a data store](#quickstart-create-datastore)
+ [Create a pipeline](#quickstart-create-pipeline)
+ [Create a dataset](#quickstart-create-dataset)
+ [Send an AWS IoT message](#send-iotcore-messages)
+ [Check the progress of IoT messages](#check-iotcore-messages)
+ [Access the query results](#access-query-results)
+ [Explore your data](#explore-data)
+ [Notebook templates](#notebook-templates)

## Sign in to the AWS IoT Analytics console<a name="quickstart-console-signin"></a>

If you don't have an AWS account, create one\.

1. To create an AWS account, navigate to the [https://aws.amazon.com/](https://aws.amazon.com/) and choose **Create AWS Account\.**

1. Follow the online instructions\. Part of the sign\-up procedure involves receiving a phone call and entering a PIN using your phone's keypad\.

1. Sign in to the AWS Management Console and navigate to the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/)\.

## Create a channel<a name="quickstart-create-channel"></a>

Incoming messages are sent to a channel\.

1. On the AWS IoT Analytics console landing page, in the **Prepare your data with IoT Analytics** section, under **Channels**, choose **View channels**\.  
![\[Screenshot of the "Prepare your data with AWS IoT Analytics".\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/prepare-your-data.png)

1. On the **Collect device messages** page, choose **Create a channel**\.  
![\[Screenshot of the "Collect device messages" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel.png)

1. On the **Set ID, source, and data retention period** page, enter a channel ID\.  
![\[Screenshot of "Set ID" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry.png)

1. Under **Choose the storage type**, choose **Service\-managed store**\.  
![\[Screenshot of "Choose the storage type" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/choose-storage-type.png)

1. Choose **Next**  
![\[Screenshot of "Tags" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry2.png)

1. Enter an AWS IoT Core \(MQTT\) topic filter\. Make a note of the topic filter you entered here, because you need it in a later step in order to create a message that gets picked up by your channel\. This example uses a topic filter with a wildcard, `"update/environment/#"`\.  
![\[Screenshot of "AWS IoT Core topic filter" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry3.png)

1. In the **IAM role name** area, choose **Create new**\. In the **Create a new role** window, enter a **Name** for the role, then choose **Create role**\. This automatically creates a role with an appropriate policy attached to it\.  
![\[Screenshot of "Create a new role" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-new-role.png)

1. Choose **Create channel**\.  
![\[Screenshot of "Create Channel" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry4.png)

   You successfully created a channel\.

## Create a data store<a name="quickstart-create-datastore"></a>

A data store receives and stores your messages\. You can create multiple data stores to store data according to your needs\. For this example, you create a single data store to receive your AWS IoT messages\.

1. On the **Channels** page, in the left navigation pane, choose **Data stores**\.  
![\[Screenshot of "Channels" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-return.png)

1. On the **Create a data store** page, choose a data store\.  
![\[Screenshot of "Create a data store" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore.png)

1. Enter an **ID** for your data store\. Under **Choose the storage type**, choose **Service\-managed store**, then choose **Create data store**\.  
![\[Screenshot of "ID" and "Choose the storage type" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore-entry.png)  
![\[Screenshot of "Configure how long you want to keep your processed data" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore-entry2.png)

   You have successfully created a data store\.

## Create a pipeline<a name="quickstart-create-pipeline"></a>

To connect a channel to a data store, you need to create a pipeline\. The simplest possible pipeline contains no activities other than specifying the channel that collects the data and identifying the data store to which the messages are sent\. For more information, see [Pipeline activities](https://docs.aws.amazon.com/iotanalytics/latest/userguide/pipeline-activities.html#aws-iot-analytics-pipeline-activities)\.

For this example, you create a pipeline that does nothing other than connect a channel to a data store\. You can see how raw data flows to the data store\. Later, you can introduce pipeline activities to process this data\. 

1. On the ** Data stores** page, in the left navigation pane, choose **Pipelines**\.  
![\[Screenshot of "Data stores" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore-return.png)

1. On the **Process messages with pipelines** page, choose **Create a pipeline**\.  
![\[Screenshot of "Process messages with pipelines" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline.png)

1. Enter a **Pipeline ID**\. In **Pipeline source**, choose **Edit**, then choose the channel that you created before, and then choose **Next**\.  
![\[Screenshot of "Set pipeline ID and source" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-enter-id.png)

1. On the **Set attributes of your messages** page, enter an attribute name, choose a type from the list, and enter an example value, then choose **Add new**\. Repeat this for as many attributes as you want\. When done, choose **Next**\.   
![\[Screenshot of "Set attributes of your messages" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-set-attributes.png)

1. You won't be adding any pipeline activities right now, so on the **Enrich, transform, and filter messages** page, choose **Next**\.  
![\[Screenshot of "Enrich, transform, and filter messages" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-activities.png)

1. On the **Save your processed messages in a data store** page, choose **Edit**, choose the data store your created earlier, and then choose **Create pipeline**\.  
![\[Screenshot of "Save your processed messages in a data store" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-select-datastore.png)

   You have successfully created a pipeline\.

## Create a dataset<a name="quickstart-create-dataset"></a>

You now have a channel that routes data to a pipeline that stores data in a data store where it can be queried\. To query the data, you create a data set\. A data set contains SQL expressions that you use to query the data store along with an optional schedule that repeats the query at a day and time you choose\. You can create the optional schedules by using expressions similar to [Amazon CloudWatch schedule expressions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/ScheduledEvents.html)\.

1. On the **Pipelines** page, in the left navigation pane, choose **Data sets**\.  
![\[Screenshot of "Pipelines" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-return.png)

1. On the **Explore your data with a data set** page, choose ** Create a data set**\.  
![\[Screenshot of "Explore your data with a data set" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset.png)

1. On the **Select a type** page, choose **Create SQL**\.   
![\[Screenshot of "Select a type" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-select-type.png)

1. On the **Set ID and source** page, enter an **ID**\. In **Select data store source**, choose **Edit** and choose the data store you created earlier\. Then choose **Next**\.  
![\[Screenshot of "Set ID and source" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-enter-id.png)

1. On the **Author SQL Query** page, in the **Query** area, enter a SQL expression that selects your attributes, or with a wildcard expression which selects all attributes, and then choose **Next**\. This example uses a SQL expression with a wildcard\.

   ```
   SELECT * FROM my_datastore
   ```  
![\[Screenshot of "Author SQL query" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-sql.png)

   You can choose **Test query** to validate that the **SQL Query** you input is correct\. It will run the query in Amazon Athena and display the results in a window below the query\. The following example is a successful test\.  
![\[Screenshot of "Author SQL query" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/test-query-results.png)

   Note that running a query at this point might return no, or few, results depending on how much data is in your data store\. You might see only `__dt` at this point\. Amazon Athena also [limits the maximum number of running queries](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html#amazon-athena-limits)\. Because of this, you must be careful to limit the SQL query to a reasonable size so that it does not run for an extended period\. We suggest using a `LIMIT` clause in the SQL query during testing, such as the following example\.

   ```
   SELECT * FROM my_datastore LIMIT 5
   ```

   After the test is successful, you can remove the `LIMIT 5`\.

1. You won't configure a data selection filter at this point, so on the **Configure data selection filter** page, choose **Next**\.  
![\[Screenshot of "Configure data selection filter" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-selection-filter.png)

1. You won't schedule a recurring run of the query at this point, so on the **Set query schedule** page, choose **Next**\.  
![\[Screenshot of "Set query schedule (optional)" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-schedule.png)

1. You can use the default data set retention period \(90 days\) and leave **Versioning** "Disabled", so on the **Configure the results of your analytics** page, choose **Next**\.  
![\[Screenshot of "Configure the results of your analytics" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-retention.png)

1. On the **Configure the delivery rules of your analytics results** page, choose **Create data set**\.  
![\[Screenshot of "Configure the delivery rules of your analytics results" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-delivery.png)

   You successfully created a data set\.

## Send an AWS IoT message<a name="send-iotcore-messages"></a>

To generate some sample data, use the AWS IoT console to send an AWS IoT message\.

**Note**  
The field names of message payloads \(data\) that you send to AWS IoT Analytics:  
Must contain only alphanumeric characters and underscores \(`_`\); no other special characters are allowed\.
Must begin with an alphabetic character or single underscore\(`_`\)\.
Cannot contain hyphens \(`-`\)\.
In regular expression terms: "`^[A-Za-z_]([A-Za-z0-9]*|[A-Za-z0-9][A-Za-z0-9_]*)$`"\.
Cannot be greater than 255 characters\.
Are case\-insensitive\. Fields named `foo` and `FOO` in the same payload are considered duplicates\.
For example, `{"temp_01";: 29}` or `{"_temp_01": 29}` are valid, but `{"temp-01": 29}`, `{"01_temp": 29}` or `{"__temp_01": 29}` are invalid in message payloads\.

1. In the [AWS IoT console](https://console.aws.amazon.com/iot/), in the left navigation pane, choose **Test**\.  
![\[Screenshot of "Monitor" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/choose-test.png)

1. On the **MQTT client** page, in the **Publish** section, in **Specify a topic**, type a topic that will match the topic filter you entered when you created a channel\. This example uses `update/environment/dht1`\. In the message payload section, enter the following JSON contents\.

   ```
   {
       "thingid": "dht1",
       "temperature": 26,
       "humidity": 29,
       "datetime": "2018-01-26T07:06:01"
   }
   ```

1. Choose **images/publish\-environment\.png**\.  
![\[Screenshot of "Monitor" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/choose-test.png)

   If you have followed the example to this point, then this publishes a message that is captured by your channel, and then routed by your pipeline to your data store\.

## Check the progress of IoT messages<a name="check-iotcore-messages"></a>

You can check that messages are being ingested into your channel by following these steps\.

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/), in the left navigation pane, choose **Channels**, then choose the name of the channel that you created earlier\.  
![\[Screenshot of "Channels" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analytics-console-return.png)

1. On the channel detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of messages ingested into this channel during the specified time frame\.  
![\[Screenshot of "Channel size" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/channel-monitoring.png)

A similar monitoring capability exists for checking pipeline activity executions\. You can monitor activity execution errors on the pipeline's detail page\. You haven't specified activities as part of the pipeline, so you shouldn't see any execution errors\.

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/), in the left navigation pane, choose **Pipelines**, then choose the name of a pipeline that you created earlier\.  
![\[Screenshot of "Pipelines" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-prepare-pipelines.png)

1. On the pipeline detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of pipeline activity execution errors during the specified time frame\.  
![\[Screenshot of "Monitoring" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/pipeline-monitoring.png)

## Access the query results<a name="access-query-results"></a>

The data set content is the result of your query in a file, in CSV format\.

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/), in the left navigation pan, choose **Data sets**\.  
![\[Screenshot of the "Data set" page in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analyze-datasets.png)

1. On the **Data sets** page, choose the name of the data set that you created previously\.  
![\[Screenshot of your data sets in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/select-dataset.png)

1. On the data set information page, in the upper\-right corner, choose **Run now**\.  
![\[Screenshot of "Run now" for your data set in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/dataset-run-query.png)

1. To check if the data set is ready, look for **SUCCEEDED** under the name of the data set in the upper left\-hand corner\. The details section contains the query results\.  
![\[Screenshot of "Data set ARN" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/dataset-succeeded1.png)

1. In the left navigation pane, choose **Content**, and then choose **Download** to view or save the CSV file that contains the query results\.  
![\[Screenshot of how to download your dataset in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/dataset-succeeded.png)

   It should look similar to the following example\.

   ```
   "thingid","temperature","humidity","datetime","__dt"
   "dht1","26","29","2018-01-26T07:06:01","2019-02-27 00:00:00.000"
   ```

   AWS IoT Analytics can also embed the HTML portion of a Jupyter notebook on this **Data Set** content page\. For more information see [ Visualizing AWS IoT Analytics data with the console](https://docs.aws.amazon.com/iotanalytics/latest/userguide/visualization-console.html#aws-iot-analytics-console-visualization)\.

1. Choose the left arrow in the upper\-left corner to return to the main page of the AWS IoT Analytics console\.

## Explore your data<a name="explore-data"></a>

You have several options for storing, analyzing and visualizing your data\.

Amazon Simple Storage Service  
You can send data set contents to an [Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) bucket, enabling integration with your existing data lakes or access from in\-house applications and visualization tools\. See the field `contentDeliveryRules::destination::s3DestinationConfiguration` in the [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset) operation\.

AWS IoT Events  
You can send data set contents as an input to AWS IoT Events, a service which enables you to monitor devices or processes for failures or changes in operation, and to trigger additional actions when such events occur\.  
To do this, create a data set using the [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset) operation and specify an AWS IoT Events input in the field `contentDeliveryRules :: destination :: iotEventsDestinationConfiguration :: inputName`\. You must also specify the `roleArn` of a role, which grants AWS IoT Analytics permissions to execute `iotevents:BatchPutMessage`\. Whenever the data set's contents are created, AWS IoT Analytics will send each data set content entry as a message to the specified AWS IoT Events input\. For example, if your data set contains the following content\.  

```
"what","who","dt"
"overflow","sensor01","2019-09-16 09:04:00.000"
"overflow","sensor02","2019-09-16 09:07:00.000"
"underflow","sensor01","2019-09-16 11:09:00.000"
...
```
Then AWS IoT Analytics sends messages that contain fields like the following\.  

```
{ "what": "overflow", "who": "sensor01", "dt": "2019-09-16 09:04:00.000" }
```

```
{ "what": "overflow", "who": "sensor02", "dt": "2019-09-16 09:07:00.000" } 
```
You will want to create an AWS IoT Events input that recognizes the fields you are interested in \(one or more of `what`, `who`, `dt`\) and to create an AWS IoT Events detector model that uses these input fields in events to trigger actions or set internal variables\.

Jupyter Notebook  
[Jupyter Notebook](https://jupyter.org/) is an open source solution for advanced analyses and ad\-hoc data exploration\. Notebooks enable you to use templates and scripting language, typically Python, to apply different transformations or normalizations to the data, aggregate metrics, and analyze and visualize data using data science libraries\. You can even apply more complex analytics and machine learning, such as k\-means clustering, to your data using these notebooks\.  
AWS IoT Analytics uses SageMaker notebook instances to host its Jupyter notebooks\. Before you create a notebook instance, you must create a relationship between AWS IoT Analytics and SageMaker:  

1. Navigate to the [SageMaker console](https://console.aws.amazon.com/sagemaker/) and create a notebook instance:

   1. Fill in the details, and then choose **Create a new role**\. Make a note the role ARN\.

   1. Create a notebook instance\.

1. Go to the [IAM console](https://console.aws.amazon.com/iam/) and modify the SageMaker role:

   1. Open the role\. It should have one managed policy\.

   1. Choose **Add inline policy**, and then for **Service**, choose **iotAnalytics**\. Choose **Select actions**, and then enter **GetDatasetContent** in the search box and choose it\. Choose **Review Policy**\.

   1. Review the policy for accuracy, enter a name, and then choose **Create policy**\.

   This gives the newly created role permission to read a data set from AWS IoT Analytics\. 

1. Return to the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/), and in the left navigation pane, choose **Notebooks**\. On the **Gain deeper insight from IoT data** page, choose **Create a notebook**:  
![\[Screenshot of "Notebooks" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analyze-notebooks.png)

1. On the **Selected method** page, choose **Blank Notebook**\.  
![\[Screenshot of "Create notebooks" in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebook-select-method.png)

1. On the **Set up notebook** page, enter a name for the notebook\. In **Select data set sources**, choose **Select**, and then choose the data set you created earlier\. In **Select a Notebook Instance**, choose **Select**, and then choose the notebook instance you created in SageMaker\. Choose **Create Notebook**\.  
![\[Screenshot of your notebook in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebook-setup.png)

1. On the **Notebooks** page, use the triangles to open your notebook instance and the **IoTAnalytics** directory\. Use the links to explore your data in Jupyter Notebook\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebook-select-jupyter.png)
You can download and [install](https://jupyter.org/install.html) Jupyter Notebook on your computer\. Additional integration with an Amazon hosted notebook solution is also available\.

## Notebook templates<a name="notebook-templates"></a>

The AWS IoT Analytics notebook templates contain AWS\-authored machine learning models and visualizations to help you get started with AWS IoT Analytics use cases\. These notebook templates can be explored as\-is for educational purposes, or re\-purposed to fit your data and deliver immediate value\.

AWS IoT Analytics provides the following notebook templates:

1. Detecting Contextual Anomalies: Application of contextual anomaly detection in measured wind speed with a PEWMA model for time series data\.

1. Solar Panel Output Forecasting: Application of piecewise, seasonal, linear time series models with trend to predicting the output of solar panels\.

1. Predictive Maintenance on Jet Engines: Application of multivariate LSTM neural networks and logistic regression to predict remaining useful life of jet engines\.

1. Smart Home Customer Segmentation: Application of k\-means and PCA analysis to detect different customer segments in smart home usage data\.

1. Smart City Congestion Forecasting: Application of LSTM to predict the utilization rates for city highways\.

1. Smart City Air Quality Forecasting: Application of LSTM to predict particulate pollution in city centers\.

You can find more information about notebook templates in the AWS IoT Analytics console under **Analyze/Notebooks**\. 
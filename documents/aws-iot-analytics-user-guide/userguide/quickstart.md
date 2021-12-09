# AWS IoT Analytics Console Quickstart Guide<a name="quickstart"></a>

This section shows you how to use the AWS IoT Analytics console to collect, store, process, and query your device data\. Follow the instructions below to see details of how to create a channel, data store, pipeline and data set, and how to use the IoT Core console to send messages that will be ingested into AWS IoT Analytics\.

**Note**  
Be aware as you enter the names of AWS IoT Analytics entities \(channel, data set, data store, and pipeline\) in the steps that follow, that any upper\-case letters you use are automatically changed to lower\-case by the system\. The names of entities must start with a lower\-case letter and contain only lower\-case letters, underscores and digits\.

The AWS IoT Analytics console also has a **Quick start** feature that allows you to create a channel, data store, pipeline and data set with one click\. Look for this page when you enter the AWS IoT Analytics console:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-quickstart.png)

## Sign in to the AWS IoT Analytics Console<a name="aws-iot-analytics-quick-console-signin"></a>

If you do not have an AWS account, create one\.

1. To create an AWS account, open the [AWS home page](https://aws.amazon.com) and choose **Create an AWS Account**\.

1. Follow the online instructions\. Part of the sign\-up procedure involves receiving a phone call and entering a PIN using your phone's keypad\.

1. Sign in to the AWS Management Console and open the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home)\.

## Create a Channel<a name="aws-iot-analytics-quick-create-channel"></a>

Incoming messages are sent to a channel\.

1. On the AWS IoT Analytics console landing page, in the **Prepare your data with IoT Analytics** section, under **Channels** choose **Create a channel**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/prepare-your-data.png)

1. Enter the channel ID, then scroll down and choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry2.png)

1. Enter an IoT Core \(MQTT\) topic filter\. Make a note of the topic filter you entered here, because you need it in a later step in order to create a message that gets picked up by your channel\. \(For this example, we are using a topic filter with a wildcard: `update/environment/#`\.\)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry3.png)

1. In the **IAM role name** area choose **Create new**\. In the **Create a new role** window enter a **Name** for the role, then select **Create role**\. This automatically creates a new role with an appropriate policy attached to it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-new-role.png)

1. Choose **Create channel**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-channel-entry4.png)

## Create a Data store<a name="aws-iot-analytics-quick-create-datastore"></a>

A data store receives and stores your messages\. You can create multiple data stores to store data according to your needs\. For this example, you create a single data store to receive your AWS IoT messages:

1. On the AWS IoT Analytics console landing page, in the **Prepare your data with IoT Analytics** section, under **Data stores** choose **View data stores**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/prepare-your-data.png)

1. On the **Create a data store** page, choose **Create a data store**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore.png)

1. Enter the **ID** for your data store, and then choose **Create data store**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore-entry.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datastore-entry2.png)

## Create a Pipeline<a name="aws-iot-analytics-quick-create-pipeline"></a>

To connect a channel to a data store, you need to create a pipeline\. The simplest possible pipeline contains no activities other than specifying the channel that collects the data and identifying the data store to which the messages are sent\. We explore more complicated pipelines in [Pipeline Activities](pipeline-activities.md#aws-iot-analytics-pipeline-activities)\.

For this example, you create a pipeline that does nothing other than connect a channel to a data store\. You can see how raw data flows to the data store\. Later, you can introduce pipeline activities to process this data\.

1. On the AWS IoT Analytics console landing page, in the **Prepare your data with IoT Analytics** section, under **Pipelines** choose **View pipelines**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/prepare-your-data.png)

1. On the **Process messages with pipelines** page, choose **Create a pipeline**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline.png)

1. Enter a **Pipeline ID**\. In **Pipeline source**, choose **Edit**, then select the channel you created before\. Then choose **Next**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-enter-id.png)

1. On the **Set attributes of your messages** page, enter an attribute name, select a type from the pull\-down list, and enter an example value, then choose **Add new**\. Repeat this for as many attributes as you want\. When done, choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-set-attributes.png)

1. You won't be adding any pipeline activities right now, so on the **Enrich, transform, and filter messages** page, just choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-activities.png)

1. On the **Save your processed messages in a data store** page, choose **Edit**, select the data store you created earlier, and then choose **Create pipeline**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-pipeline-select-datastore.png)

## Create a Data Set<a name="aws-iot-analytics-quick-create-dataset"></a>

You now have a channel that routes data to a pipeline that stores data in a data store where it can be queried\. To query the data, you create a data set\. A data set contains SQL expressions that you use to query the data store along with an optional schedule that repeats the query at a day and time you choose\. You can create the optional schedules by using expressions similar to [Amazon CloudWatch schedule expressions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/ScheduledEvents.html)\.

1. On the left navigation pane, choose **Analyze**, and then choose **Data Sets**\. On the **Explore your data with a data set** page, choose **Create a data set**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-datasets.png)

1. On the **Select a type** page, choose **Create SQL**\. choose **Edit**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-select-type.png)

1. On the **Set ID and source** page, enter an **ID**\. In **Select data store source** choose **Edit** and select the data store you created earlier\. Then choose **Next**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-enter-id.png)

1. On the **Author SQL Query** page, in the **Query** area, enter a SQL expression that selects your attributes, or with a wildcard expression which selects all attributes, and then choose **Next**\. In this example we are using a SQL expression with a wildcard:

   ```
   SELECT * FROM my_datastore
   ```  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-sql.png)

1. You won't configure a data selection filter at this point, so on the **Configure data selection filter** page just choose **Next**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-selection-filter.png)

1. You won't schedule a recurring run of the query at this point, so on the **Set query schedule** page just choose **Next**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-schedule.png)

1. You can use the default data set retention period \(90 days\), so on the **Configure the results of your analytics** page just choose **Next**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-retention.png)

1. On the **Configure the delivery rules of your analytics results** page choose **Create data set**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/create-dataset-delivery.png)

## Send an AWS IoT Message<a name="aws-iot-analytics-quick-send-message"></a>

To generate some sample data, use the AWS IoT console to send an AWS IoT message\.

**Note**  
The field names of message payloads \(data\) that you send to AWS IoT Analytics:  
Must contain only alphanumeric characters and underscores \(\_\); no other special characters are allowed\.
Must begin with an alphabetic character or single underscore \(\_\)\.
Cannot contain hyphens \(\-\)\.
In regular expression terms: `"^[A-Za-z_]([A-Za-z0-9]*|[A-Za-z0-9][A-Za-z0-9_]*)$"`\.
Cannot be greater than 255 characters\.
Are case\-insensitive\. \(Fields named "foo" and "FOO" in the same payload are considered duplicates\.\)
For example, `{"temp_01": 29}` or `{"_temp_01": 29}` are valid, but `{"temp-01": 29}`, `{"01_temp": 29}` or `{"__temp_01": 29}` are invalid in message payloads\.

1. In the [AWS IoT console](https://console.aws.amazon.com/iot/home), in the left navigation pane, choose **Test**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/choose-test.png)

1. On the **MQTT client** page, in the **Publish** section, in **Specify a topic**, type a topic that will match the topic filter you entered when you created a channel\. \(For this example, we use `update/environment/dht1`\)\. In the message payload section, enter the following JSON contents:

   ```
   {
       "thingid": "dht1",
       "temperature": 26,
       "humidity": 29,
       "datetime": "2018-01-26T07:06:01"
   }
   ```

1. Choose **Publish to topic**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/publish-environment.png)

   If you have followed the example to this point, then this publishes a message that is captured by your channel, and then routed by your pipeline to your data store\.

## Check the Progress of IoT Messages<a name="aws-iot-analytics-quick-check-message"></a>

You can check that messages are being ingested into your channel by following these steps:

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home), in the left navigation pane, choose **Prepare** and \(if necessary\) choose **Channels**, then choose the name of the channel you created earlier:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analytics-console-return.png)

1. On the channel detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of messages ingested into this channel during the specified time frame:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/channel-monitoring.png)

A similar monitoring capability exists for checking pipeline activity executions\. You can monitor activity execution errors on the pipeline's detail page\. \(We haven't specified activities as part of our pipeline, so 0 execution errors should be displayed\.\)

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home), in the left navigation pane, choose **Prepare** and then choose **Pipelines**, then choose the name of a pipeline you created earlier:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-prepare-pipelines.png)

1. On the pipeline detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of pipeline activity execution errors during the specified time frame:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/pipeline-monitoring.png)

## Access the Query Results<a name="aws-iot-analytics-quick-access-results"></a>

The data set content is the result of your query in a file, in CSV format\.

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home), in the left navigation pane, choose **Analyze**, choose **Data sets**\. On the **Explore your data with a data set** page, choose **Create a data set**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analyze-datasets.png)

1. On the **Data sets** page, choose the name of the data set you created previously:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/select-dataset.png)

1. On the data set information page, in the upper\-right corner, choose **Actions**, and then choose **Run now**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/dataset-run-query.png)

1. To check if the data set is ready, look for **SUCCEEDED** under the name of the data set in the upper left\-hand corner\. The **Details** section contains the query results:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/dataset-succeeded1.png)

1. In the left navigation pane, click **Content:**\. Choose **Download** \(to the right of the name of the most recent version\) to view or save the CSV file that contains the query results\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/dataset-succeeded.png)

   It should look similar to this:

   ```
   "thingid","temperature","humidity","datetime","__dt"
   "dht1","26","29","2018-01-26T07:06:01","2019-02-27 00:00:00.000"
   ```

   AWS IoT Analytics can also embed the HTML portion of a Jupyter notebook on this **Data Set** content page\. For more information see [Visualizing AWS IoT Analytics Data with the Console](visualization-console.md#aws-iot-analytics-console-visualization)\.

1. Choose the left arrow in the upper\-left corner to return to the main page of the **AWS IoT Analytics console**\.

## Explore Your Data<a name="aws-iot-analytics-quick-explore"></a>

You have several options for storing, analyzing and visualizing your data\.\.\.

### Amazon S3<a name="amazon-s3"></a>

You can send data set contents to an [Amazon Simple Storage Service \(S3\)](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) bucket, enabling integration with your existing data lakes or access from in\-house applications and visualization tools\. See the field `contentDeliveryRules::destination::s3DestinationConfiguration` in [CreateDataset](api.md#cli-iotanalytics-createdataset)\.

### AWS IoT Events<a name="aws-iot-events"></a>

You can send data set contents as an input to [AWS IoT Events](https://docs.aws.amazon.com/iotevents/latest/developerguide/what-is-iotevents.html), a service which enables you to monitor devices or processes for failures or changes in operation, and to trigger additional actions when such events occur\. See the field `contentDeliveryRules::destination::iotEventsDestinationConfiguration` in [CreateDataset](api.md#cli-iotanalytics-createdataset)\.

### Jupyter Notebooks<a name="jupyter-notebooks"></a>

 [Jupyter Notebooks](http://jupyter.org) is an open source solution for advanced analyses and ad\-hoc data exploration\. Notebooks enable you to use templates and a scripting language, typically Python, to apply different transformations or normalizations to the data, aggregate metrics, and analyze and visualize data using data science libraries\. You can even apply more complex analytics and machine learning, such as k\-means clustering, to your data using these notebooks\.

AWS IoT Analytics uses Amazon SageMaker notebook instances to host its Jupyter notebooks\. Before you create a notebook instance, you must create a relationship between AWS IoT Analytics and Amazon SageMaker:

1. Go to the [Amazon SageMaker console](https://console.aws.amazon.com/sagemaker/home?#/notebook-instances/create) and create a notebook instance:

   1. Fill in the details, and then choose **Create a new role**\. Make a note the role ARN\.

   1. Create a notebook instance\.

   This creates a role that Amazon SageMaker can use and a new notebook instance

1. Go to the [IAM console](https://console.aws.amazon.com/iam/home?#/roles) and modify the Amazon SageMaker role:

   1. Open the role\. It should have one managed policy\.

   1. Choose **add inline policy**, and then for **Service**, choose IotAnalytics\. Choose **Select actions**, and then type "GetDatasetContent" in the search box and select it\. Choose **Review policy**\.

   1. Review the policy for accuracy, give it a name, and then choose **Create policy**\.

   This gives the newly created role permission to read a data set from AWS IoT Analytics\.

1. Return to the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home), and in the left navigation pane, choose **Analyze**, and then **Notebooks**\. In the **Gain deeper insight from IoT Data** page choose **Create a notebook**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analyze-notebooks.png)

1. On the **Notebooks** page, choose **Create**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebooks-list.png)

1. On the **Select method** page, choose **Blank Notebook**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebook-select-method.png)

1. On the **Set up notebook** page, enter a name for the notebook\. In **Select data set sources**, choose **Select**, and then select the data set you created earlier\. In **Select a Notebook Instance**, choose **Select**, and then choose the notebook instance you created in Amazon SageMaker\. Choose **Create Notebook**:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebook-setup.png)

1. On the **Notebooks** page, use the triangles to open your notebook instance and the **IoTAnalytics** folder\. Use the links to explore your data in Jupyter Notebooks:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/notebook-select-jupyter.png)

You can download and [install](http://jupyter.org/install.html) Jupyter Notebooks on your computer\. Additional integration with an Amazon hosted notebook solution is also available\.

## Notebook Templates<a name="aws-iot-analytics-notebook-templates"></a>

The AWS IoT Analytics notebook templates contain AWS\-authored machine learning models and visualizations to help you get started with AWS IoT Analytics use cases\. These notebook templates can be explored as\-is for educational purposes, or re\-purposed to fit your data and deliver immediate value\.

AWS IoT Analytics provides the following notebook templates:

1. Detecting Contextual Anomalies: Application of contextual anomaly detection in measured wind speed with a PEWMA model for time series data\.

1. Solar Panel Output Forecasting: Application of piecewise, seasonal, linear time series models with trend to predicting the output of solar panels\.

1. Predictive Maintenance on Jet Engines: Application of multivariate LSTM neural networks and logistic regression to predict remaining useful life of jet engines\.

1. Smart Home Customer Segmentation: Application of k\-means and PCA analysis to detect different customer segments in smart home usage data\.

1. Smart City Congestion Forecasting: Application of LSTM to predict the utilization rates for city highways\.

1. Smart City Air Quality Forecasting: Application of LSTM to predict particulate pollution in city centers\.

You can find more information about notebook templates in the AWS IoT Analytics console under **Analyze**/**Notebooks**\.
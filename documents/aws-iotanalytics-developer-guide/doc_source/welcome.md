# What is AWS IoT Analytics?<a name="welcome"></a>

AWS IoT Analytics automates the steps required to analyze data from IoT devices\. AWS IoT Analytics filters, transforms, and enriches IoT data before storing it in a time\-series data store for analysis\. You can set up the service to collect only the data you need from your devices, apply mathematical transforms to process the data, and enrich the data with device\-specific metadata such as device type and location before storing it\. Then, you can analyze your data by running queries using the built\-in SQL query engine, or perform more complex analytics and machine learning inference\. AWS IoT Analytics enables advanced data exploration through integration with [Jupyter Notebook](http://jupyter.org)\. AWS IoT Analytics also enables data visualization through integration with [Amazon QuickSight](https://quicksight.aws)\. Amazon QuickSight is available in the following [Regions](https://docs.aws.amazon.com/general/latest/gr/rande.html#quicksight_region)\. 

Traditional analytics and business intelligence tools are designed to process structured data\. Raw IoT data often comes from devices that record less structured data \(such as temperature, motion, or sound\)\. As a result the data from these devices can have significant gaps, corrupted messages, and false readings that must be cleaned up before analysis can occur\. Also, IoT data is often only meaningful in the context of other data from external sources\. AWS IoT Analytics lets you to address these issues and collect large amounts of device data, process messages, and store them\. You can then query the data and analyze it\. AWS IoT Analytics includes pre\-built models for common IoT use cases so that you can answer questions like which devices are about to fail or which customers are at risk of abandoning their wearable devices\. 

## What's new with AWS IoT Analytics?<a name="aws-iot-analytics-whats-new"></a>

The following table describes what's new and changed with AWS IoT Analytics\.


| Change | Description | Date | 
| --- | --- | --- | 
|  AWS IoT Analytics is now available in the Asia Pacific \(Sydney\) Region\.  |  You can use the Asia Pacific \(Sydney\) Region endpoint to programmatically connect to AWS IoT Analytics: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/welcome.html) For more information about supported AWS Regions, see [AWS IoT Analytics endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-analytics.html) in the *AWS General Reference*\.  |  July 16, 2020  | 

## How to use AWS IoT Analytics<a name="aws-iot-analytics-how"></a>

The following graphic shows an overview of how you can use AWS IoT Analytics\.

![\[An overview of how to use AWS IoT Analytics\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/HowitWorksIoTAnalytics.png)

### Key features<a name="aws-iot-analytics-features"></a>

**Collect**  
+ Integrated with AWS IoT Core—AWS IoT Analytics is fully integrated with AWS IoT Core so it can receive messages from connected devices as they stream in\.
+ Use a batch API to add data from any source—AWS IoT Analytics can receive data from any source through HTTP\. That means that any device or service that is connected to the internet can send data to AWS IoT Analytics For more information about the `BatchPutMessage` command, see the [AWS IoT Analytics commands](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-batchputmessage)\.
+ Collect only the data you want to store and analyze—You can use the AWS IoT Analytics console to configure AWS IoT Analytics to receive messages from devices through MQTT topic filters in various formats and frequencies\. AWS IoT Analytics validates that the data is within specific parameters you define and creates channels\. Then, the service routes the channels to appropriate pipelines for message processing, transformation, and enrichment\.

**Process**  
+ Cleanse and filter—AWS IoT Analytics lets you define AWS Lambda functions that are triggered when AWS IoT Analytics detects missing data, so you can run code to estimate and fill gaps\. You can also define maximum and minimum filters and percentile thresholds to remove outliers in your data\. 
+ Transform—AWS IoT Analytics can transform messages using mathematical or conditional logic you define, so that you can perform common calculations like Celsius into Fahrenheit conversion\. 
+ Enrich—AWS IoT Analytics can enrich data with external data sources such as a weather forecast, and then route the data to the AWS IoT Analytics data store\. 

**Store**  
+ Time\-series data store—AWS IoT Analytics stores the device data in an optimized time\-series data store for faster retrieval and analysis\. You can also manage access permissions, implement data retention policies and export your data to external access points\. 
+ Store processed and raw data—AWS IoT Analytics stores the processed data and also automatically stores the raw ingested data so you can process it at a later time\. 

**Analyze**  
+ Run Ad\-hoc SQL queries—AWS IoT Analytics provides a SQL query engine so you can run ad\-hoc queries and get results quickly\. The service enables you to use standard SQL queries to extract data from the data store to answer questions like the average distance traveled for a fleet of connected vehicles or how many doors in a smart building are locked after 7pm\. These queries can be re\-used even if connected devices, fleet size, and analytic requirements change\. 
+ Time\-series analysis—AWS IoT Analytics supports time\-series analysis so you can analyze the performance of devices over time and understand how and where they are being used, continuously monitor device data to predict maintenance issues, and monitor sensors to predict and react to environmental conditions\. 
+ Hosted notebooks for sophisticated analytics and machine learning—AWS IoT Analytics includes support for hosted notebooks in Jupyter Notebook for statistical analysis and machine learning\. The service includes a set of notebook templates that contain AWS\-authored machine learning models and visualizations\. You can use the templates to get started with IoT use cases related to device failure profiling, forecasting events such as low usage that might signal the customer will abandon the product, or segmenting devices by customer usage levels \(for example heavy users, weekend users\) or device health\. After you author a notebook, you can containerize and execute it on a schedule that you specify\. For more information, see [Automating your workflow](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate)\. 
+ Prediction—You can do statistical classification through a method called logistic regression\. You can also use Long\-Short\-Term Memory \(LSTM\), which is a powerful neural network technique for predicting the output or state of a process that varies over time\. The pre\-built notebook templates also support the K\-means clustering algorithm for device segmentation, which clusters your devices into cohorts of like devices\. These templates are typically used to profile device health and device state such as HVAC units in a chocolate factory or wear and tear of blades on a wind turbine\. Again, these notebook templates can be contained and executed on a schedule\. 

**Build and visualize**  
+ Amazon QuickSight integration—AWS IoT Analytics provides a connector to Amazon QuickSight so that you can visualize your data sets in a QuickSight dashboard\. 
+ Console integration—You can also visualize the results or your ad\-hoc analysis in the embedded Jupyter Notebook in the AWS IoT Analytics' console\. 

### AWS IoT Analytics components and concepts<a name="aws-iot-analytics-components"></a>

**Channel**  
A channel collects data from an MQTT topic and archives the raw, unprocessed messages before publishing the data to a pipeline\. You can also send messages to a channel directly using the [BatchPutMessage](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-batchputmessage) API\. The unprocessed messages are stored in an Amazon Simple Storage Service \(Amazon S3\) bucket that you or AWS IoT Analytics manage\. 

**Pipeline**  
A pipeline consumes messages from a channel and enables you to process the messages before storing them in a data store\. The processing steps, called **activities** \([Pipeline activities](https://docs.aws.amazon.com/iotanalytics/latest/userguide/pipeline-activities.html#aws-iot-analytics-pipeline-activities)\), perform transformations on your messages such as removing, renaming or adding message attributes, filtering messages based on attribute values, invoking your Lambda functions on messages for advanced processing or performing mathematical transformations to normalize device data\. 

**Data store**  
Pipelines store their processed messages in a data store\. A data store is not a database, but it is a scalable and queryable repository of your messages\. You can have multiple data stores for messages coming from different devices or locations, or filtered by message attributes depending on your pipeline configuration and requirements\. As with unprocessed channel messages, a data store's processed messages are stored in an [Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) bucket that you or AWS IoT Analytics manage\. 

**Data set**  
You retrieve data from a data store by creating a data set\. AWS IoT Analytics enables you to create a SQL data set or a container data set\.   
After you have a data set, you can explore and gain insights into your data through integration using [Amazon QuickSight](https://quicksight.aws)\. You can also perform more advanced analytical functions through integration with [Jupyter Notebook](http://jupyter.org)\. Jupyter Notebook provides powerful data science tools that can perform machine learning and a range of statistical analyses\. For more information, see [ Notebook templates](https://docs.aws.amazon.com/iotanalytics/latest/userguide/quickstart.html#aws-iot-analytics-notebook-templates)\.   
You can send data set contents to an [Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) bucket, enabling integration with your existing data lakes or access from in\-house applications and visualization tools\. You can also send data set contents as an input to [AWS IoT Events](https://docs.aws.amazon.com/iotevents/latest/developerguide/what-is-iotevents.html), a service which enables you to monitor devices or processes for failures or changes in operation, and to trigger additional actions when such events occur\. 

**SQL data set**  
A SQL data set is similar to a materialized view from a SQL database\. You can create a SQL data set by applying a SQL action\. SQL data sets can be generated automatically on a recurring schedule by specifying a trigger\. 

**Container data set**  
A container data set enables you to automatically run your analysis tools and generate results\. For more information, see [ Automating your workflow](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate)\. It brings together a SQL data set as input, a Docker container with your analysis tools and needed library files, input and output variables, and an optional schedule trigger\. The input and output variables tell the executable image where to get the data and store the results\. The trigger can run your analysis when a SQL data set finishes creating its content or according to a time schedule expression\. A container data set automatically runs, generates and then saves the results of the analysis tools\. 

**Trigger**  
You can automatically create a data set by specifying a trigger\. The trigger can be a time interval \(for example, create this data set every two hours\) or when another data set's content has been created \(for example, create this data set when `myOtherDataset` finishes creating its content\)\. Or, you can generate data set content manually by using [CreateDatasetContent](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdatasetcontent) API\. 

**Docker container**  
You can create your own Docker contain to package your analysis tools or use options that SageMaker provides\. For more information, see [Docker container](https://www.docker.com/resources/what-container)\. You can create your own Docker container to package your analysis tools or use options provided by [SageMaker](https://docs.aws.amazon.com/sagemaker/latest/dg/your-algorithms.html)\. You can store a container in an [Amazon ECR](https://docs.aws.amazon.com/AmazonECR/latest/userguide/what-is-ecr.html) registry that you specify so it is available to install on your desired platform\. Docker containers are capable of running your custom analytical code prepared with Matlab, Octave, Wise\.io, SPSS, R, Fortran, Python, Scala, Java, C\+\+, and so on\. For more information, see [Containerizing a notebook](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate-containerize)\.

**Delta windows**  
Delta windows are a series of user\-defined, non\-overlapping and contiguous time intervals\. Delta windows enable you to create the data set content with, and perform analysis on, new data that has arrived in the data store since the last analysis\. You create a delta window by setting the `deltaTime` in the `filters` portion of a `queryAction` of a data set\. For more information, see the [https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset) API\. Usually, you'll want to create the data set content automatically by also setting up a time interval trigger \(`triggers:schedule:expression`\)\. This lets you filter messages that have arrived during a specific time window, so the data contained in messages from previous time windows doesn't get counted twice\. For more information, see [ Example 6 \-\- creating a SQL dataset with a Delta window \(CLI\)](https://docs.aws.amazon.com/iotanalytics/latest/userguide/automate.html#aws-iot-analytics-automate-example-createdataset6)\. 

## Access AWS IoT Analytics<a name="aws-iot-analytics-accessing-analytics"></a>

As part of AWS IoT, AWS IoT Analytics provides the following interfaces to enable your devices to generate data and your applications to interact with the data they generate: 

**AWS Command Line Interface \(AWS CLI\)**  
Run commands for AWS IoT Analytics on Windows, OS X, and Linux\. These commands enable you to create and manage things, certificates, rules, and policies\. To get started, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html)\. For more information about the commands for AWS IoT, see [iot](https://docs.aws.amazon.com/cli/latest/reference/iot/index.html) in the *AWS Command Line Interface Reference*\.   
Use the `aws iotanalytics` command to interact with AWS IoT Analytics\. Use the `aws iot` command to interact with other parts of the IoT system\. 

**AWS IoT API**  
Build your IoT applications using HTTP or HTTPS requests\. These API actions enable you to create and manage things, certificates, rules, and policies\. For more information, see [Actions](https://docs.aws.amazon.com/iot/latest/apireference/API_Operations.html) in the *AWS IoT API Reference*\. 

**AWS SDKs**  
Build your AWS IoT Analytics applications using language\-specific APIs\. These SDKs wrap the HTTP and HTTPS API and enable you to program in any of the supported languages\. For more information, see [AWS SDKs and tools](https://aws.amazon.com/tools/#sdk)\. 

**AWS IoT Device SDKs**  
Build applications that run on your devices that send messages to AWS IoT Analytics\. For more information, see [AWS IoT SDKs](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sdks.html)\. 

**AWS IoT Analytics Console**  
You can build the components to visualize the results in the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/)\. 

## Use cases<a name="aws-iot-analytics-uses"></a>

**Predictive maintenance**  
AWS IoT Analytics provides templates to build predictive maintenance models and apply them to your devices\. For example, you can use AWS IoT Analytics to predict when heating and cooling systems are likely to fail on connected cargo vehicles so the vehicles can be rerouted to prevent shipment damage\. Or, an auto manufacturer can detect which of its customers have worn brake pads and alert them to seek maintenance for their vehicles\. 

**Proactive replenishing of supplies**  
AWS IoT Analytics lets you build IoT applications that can monitor inventories in real time\. For example, a food and drink company can analyze data from food vending machines and proactively reorder merchandise whenever the supply is running low\. 

**Process efficiency scoring**  
With AWS IoT Analytics, you can build IoT applications that constantly monitor the efficiency of different processes and take action to improve the process\. For example, a mining company can increase the efficiency of its ore trucks by maximizing the load for each trip\. With AWS IoT Analytics, the company can identify the most efficient load for a location or truck over time, and the compare any deviations from the target load in real time, and better plan leading guidelines to improve efficiency\. 

**Smart agriculture**  
AWS IoT Analytics can enrich IoT device data with contextual metadata using AWS IoT registry data or public data sources so that your analysis factors in time, location, temperature, altitude, and other environmental conditions\. With that analysis, you can write models that output recommended actions for your devices to take in the field\. For example, to determine when to water, irrigation systems might enrich humidity sensor data with data on rainfall, enabling more efficient water usage\. 
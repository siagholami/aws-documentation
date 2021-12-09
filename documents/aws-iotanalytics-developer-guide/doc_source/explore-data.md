# Exploring AWS IoT Analytics data<a name="explore-data"></a>

You have several options for storing, analyzing and visualizing your AWS IoT Analytics data\.

**Topics**
+ [Amazon S3](#amazon-s3)
+ [AWS IoT Events](#aws-iot-events)
+ [Amazon QuickSight](#quicksight)
+ [Jupyter Notebook](#jupyter-noteboo)

## Amazon S3<a name="amazon-s3"></a>

You can send data set contents to an [Amazon Simple Storage Service \(Amazon S3\)](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) bucket, enabling integration with your existing data lakes or access from in\-house applications and visualization tools\. See the field `contentDeliveryRules::destination::s3DestinationConfiguration` in [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset)\. 

## AWS IoT Events<a name="aws-iot-events"></a>

You can send data set contents as an input to AWS IoT Events, a service which enables you to monitor devices or processes for failures or changes in operation, and to trigger additional actions when such events occur\.

To do this, create a data set using [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/userguide/api.html#cli-iotanalytics-createdataset) and specify an AWS IoT Events input in the field `contentDeliveryRules :: destination :: iotEventsDestinationConfiguration :: inputName`\. You must also specify the `roleArn` of a role which grants AWS IoT Analytics permission to execute "iotevents:BatchPutMessage"\. Whenever the data set's contents are created, AWS IoT Analytics will send each data set content entry as a message to the specified AWS IoT Events input\. For example, if your data set contains:

```
"what","who","dt"
"overflow","sensor01","2019-09-16 09:04:00.000"
"overflow","sensor02","2019-09-16 09:07:00.000"
"underflow","sensor01","2019-09-16 11:09:00.000"
...
```

then AWS IoT Analytics will send messages containing fields like this:

```
{ "what": "overflow", "who": "sensor01", "dt": "2019-09-16 09:04:00.000" }
```

```
{ "what": "overflow", "who": "sensor02", "dt": "2019-09-16 09:07:00.000" }
```

and you will want to create an AWS IoT Events input that recognized the fields you are interested in \(one or more of `what`, `who`, `dt`\) and to create an AWS IoT Events detector model that uses these input fields in events to trigger actions or set internal variables\. 

## Amazon QuickSight<a name="quicksight"></a>

AWS IoT Analytics provides direct integration with [Amazon QuickSight](https://aws.amazon.com/quicksight/)\. Amazon QuickSight is a fast business analytics service you can use to build visualizations, perform ad\-hoc analysis, and quickly get business insights from your data\. Amazon QuickSight enables organizations to scale to hundreds of thousands of users, and delivers responsive performance by using a robust in\-memory engine \(SPICE\)\. Amazon QuickSight is available in [these regions](https://docs.aws.amazon.com/general/latest/gr/quicksight.html)\. 

## Jupyter Notebook<a name="jupyter-noteboo"></a>

AWS IoT Analytics data sets can also be directly consumed by Jupyter Notebook in order to perform advanced analytics and data exploration\. Jupyter Notebook is an open source solution\. You can install and download from [http://jupyter\.org/install\.html](https://jupyter.org/install.html)\. Additional integration with SageMaker, an Amazon hosted notebook solution, is also available\. 
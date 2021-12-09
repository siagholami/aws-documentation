# Getting Started<a name="getting-started"></a>

To get started using Amazon Forecast, you do the following\. 
+ Create an Forecast dataset and import training data\.
+ Create a Forecast predictor\. The algorithm that you choose, trains a predictor using the datasets\. You specify both the algorithm and dataset when you create the predictor\.
+ Generate a forecast\.

In this exercise, you use a modified version of a publicly available electricity usage dataset to train predictors\. For more information, see [ElectricityLoadDiagrams20112014 Data Set](https://archive.ics.uci.edu/ml/datasets/ElectricityLoadDiagrams20112014)\. The following are sample rows from the dataset:

```
2014-01-01 01:00:00,   2.53807106598985, client_0
2014-01-01 01:00:00, 23.648648648648624, client_1
2014-01-01 02:00:00,  9.648648648612345, client_0
```

For this exercise, you use the dataset to train a predictor, and then predict the hourly electricity usage by client\. 

You can use either the Forecast console or the AWS Command Line Interface \(AWS CLI\) for this exercise\. Pay attention to the default regions of the Amazon Forecast console, the AWS CLI, and the Amazon Forecast SDKs, as Amazon Forecast resources are not shared across regions\.

**Important**  
Before you begin, make sure that you have an AWS account and have installed the AWS CLI\. For more information, see [Setting Up](setup.md)\. We also recommend that you review [How Amazon Forecast Works](how-it-works.md)\.

**Topics**
+ [Prepare Input Data](#gs-upload-data-to-s3)
+ [Getting Started \(Console\)](gs-console.md)
+ [Getting Started \(AWS CLI\)](gs-cli.md)
+ [Getting Started \(Python Notebook\)](getting-started-python.md)
+ [Clean Up Resources](#gs-cleanup)

## Prepare Input Data<a name="gs-upload-data-to-s3"></a>

Regardless of whether you use the Amazon Forecast console or the AWS Command Line Interface \(AWS CLI\) to set up a forecasting project, you need to set up your input data\. To prepare your data, you do the following:
+ Download training data to your computer and upload it to an Amazon Simple Storage Service \(Amazon S3\) bucket in your AWS account\. To import your data to an Amazon Forecast dataset, you must store it in an Amazon S3 bucket\. 
+ Create an AWS Identity and Access Management \(IAM\) role\. You give Amazon Forecast permission to access your S3 bucket with the IAM role\. For more information about IAM roles, see [IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) in the *IAM User Guide*\. 

**To prepare training data**

1. Download the zip file, [electricityusagedata\.zip](samples/electricityusagedata.zip)\. 

   For this exercise, you use the individual household electric power consumption dataset\. \(Dua, D\. and Karra Taniskidou, E\. \(2017\)\. UCI Machine Learning Repository \[[http://archive\.ics\.uci\.edu/ml](http://archive.ics.uci.edu/ml)\]\. Irvine, CA: University of California, School of Information and Computer Science\.\) We aggregate the usage data hourly\.

1. Unzip the content and save it locally as `electricityusagedata.csv`\.

1. Upload the data file to an S3 bucket\. 

   For step\-by\-step instructions, see [Uploading Files and Folders by Using Drag and Drop](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html) in the *Amazon Simple Storage Service Console User Guide\.*

1. Create an IAM role\. 

   If you want to use the AWS CLI for the Getting Started exercise, you must create an IAM role\. If you use the console, you can have it create the role for you\. For step\-by\-step instructions, see [Set Up Permissions for Amazon Forecast](aws-forecast-iam-roles.md)\. 

Now, use the Amazon Forecast console or the AWS CLI to train a predictor, generate a forecast, and see the forecast\.
+ [Getting Started \(Console\)](gs-console.md)
+ [Getting Started \(AWS CLI\)](gs-cli.md)

## Clean Up Resources<a name="gs-cleanup"></a>

To avoid incurring unnecessary charges, delete the resources you created after you're done with the getting started exercise\. To delete the resources, use either the Amazon Forecast console or the `Delete` APIs from the SDKs or the AWS Command Line Interface \(AWS CLI\)\. For example, use the [DeleteDataset](API_DeleteDataset.md) API to delete a dataset\.

To delete a resource, its status must be `ACTIVE`, `CREATE_FAILED`, or `UPDATE_FAILED`\. Check the status using the `Describe` APIs, for example, [DescribeDataset](API_DescribeDataset.md)\.

Some resources must be deleted before others, as shown in the following table\. This process can take some time\.

To delete the training data you uploaded, ` electricityusagedata.csv`, see [How Do I Delete Objects from an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/delete-objects.html)\.


| Resource to Delete | Delete This First | Notes | 
| --- | --- | --- | 
| ForecastExportJob |  |  | 
| Forecast |  | You can't delete a forecast while it is being exported\. After a forecast is deleted, you can no longer query the forecast\. | 
| Predictor | All associated forecasts\. |  | 
| DatasetImportJob |  | Can not be deleted\. | 
| Dataset |  |  All `DatasetImportJob`s that target the dataset are also deleted\. You can't delete a `Dataset` that is used by a predictor\.  | 
| DatasetSchema | All datasets that reference the schema\. |  | 
| DatasetGroup | All associated predictorsAll associated forecasts\.All datasets in the dataset group\. |  You can't delete a `DatasetGroup` that contains a `Dataset` used by a predictor\.  | 
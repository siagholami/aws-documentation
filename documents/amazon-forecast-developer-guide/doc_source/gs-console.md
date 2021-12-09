# Getting Started \(Console\)<a name="gs-console"></a>

In this exercise, you use the Amazon Forecast console to import time\-series data of electricity usage, create an Amazon Forecast predictor based on the input dataset, and make predictions of future electricity usage based on the input time interval\.

For this exercise, we use the individual household electric power consumption dataset\. \(Dua, D\. and Karra Taniskidou, E\. \(2017\)\. UCI Machine Learning Repository \[[http://archive\.ics\.uci\.edu/ml](http://archive.ics.uci.edu/ml)\]\. Irvine, CA: University of California, School of Information and Computer Science\.\) We aggregate the usage data hourly\.

**Prerequisites**
+ An AWS account\. If you don't already have an AWS account, create one as described in [Sign Up for AWS](aws-forecast-set-up-aws-account.md)\.
+ Training data in your Amazon Simple Storage Service \(Amazon S3\) bucket\. For more information, see [Prepare Input Data](getting-started.md#gs-upload-data-to-s3)\.
+ An AWS Identity and Access Management \(IAM\) role that allows Amazon Forecast to read and write to your S3 buckets\. For more information, see [Create an IAM Role for Amazon Forecast \(IAM Console\)](aws-forecast-iam-roles.md#aws-forecast-create-iam-role-with-console)\.

## Step 1: Import Training Data<a name="gs-console-create-dataset"></a>

To import time\-series data into Amazon Forecast, create a dataset group, choose a domain for your dataset group, specify the details of your data, and point Amazon Forecast to the S3 location of your data\. You use a time series of [historical electricity usage](getting-started.md#gs-upload-data-to-s3) as an example for the target time series data\.

**Note**  
This exercise assumes that you haven't created any dataset groups\. If you previously created a dataset group, what you see will vary slightly from the following screenshots and instructions\.

**To import time\-series data for forecasting**

1. Sign in to the AWS Management Console and open the Amazon Forecast console at [https://console\.aws\.amazon\.com/forecast/](https://console.aws.amazon.com/forecast/)\.

1. On the Amazon Forecast home page, choose **Create dataset group**\.

1. On the **Create dataset group** page, for **Dataset group details**, provide the following information:
   + **Dataset group name** – Enter a name for your dataset group\.
   + **Forecasting domain** – From the drop\-down menu, choose **Custom**\. For more information about how to choose a forecasting domain, see [How Amazon Forecast Works](how-it-works.md) and [dataset domains and types](howitworks-domains-ds-types.md)\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step1-create-dsgroup.png)

1. Choose **Next**\.

1. On the **Create target time series dataset** page, for **Dataset details**, provide the following information:
   + **Dataset name** – Enter a name for your dataset\.
   + **Frequency of your data** – Keep the default value of **1**, and choose **hour** from the drop\-down menu\. This setting must be consistent with the input time series data\. The time interval in the sample electricity\-usage data is an hour\.
   + **Data schema** – Update the schema to match the columns of the time\-series data in data types and order\. For the electricity usage input data, the columns correspond to: a timestamp, the electricity usage at the specified time \(target\_value\), and the ID of the customer charged for the electricity usage \(string\), in that order\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step1-create-dataset.png)

1. Choose **Next**\.

1. On the **Import target time series data** page, for **Dataset import job details**, provide the following information:
   + **Dataset import job name** – Enter a name for your dataset\.
   + **Timestamp format** – Leave the default \(**yyyy\-MM\-dd HH:mm:ss**\)\. The format must be consistent with the input time series data\.
   + **IAM role** – Keep the default **Enter a custom IAM role ARN**\.

     Alternatively, you can have Amazon Forecast create the required IAM role for you by choosing **Create a new role** from the drop\-down menu and following the on\-screen instructions\.
   + **Custom IAM role ARN** – Enter the Amazon Resource Name \(ARN\) of the IAM role that you created in [Create an IAM Role for Amazon Forecast \(IAM Console\)](aws-forecast-iam-roles.md#aws-forecast-create-iam-role-with-console)\.
   + **Data location** – Use the following format to enter the location of your \.csv file on Amazon S3:

     **s3://<name of your S3 bucket>/<folder path>/<filename\.csv>**

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step1-import-data.png)

1. Choose **Start import**\.

1. The dataset group's **Dashboard** page is displayed\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step1-importing.png)

   Under **Target time series data**, you will see the status of the import job\. Wait for Amazon Forecast to finish importing your time\-series data\. The process can take several minutes or longer\. When your dataset has been imported, the status transitions to **Active**\. Additionally, the banner at the top of the dashboard, changes to display the following message:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step1-imported-banner.png)

   Now that your target time series dataset has been imported, you can train a predictor\.

## Step 2: Train a Predictor<a name="gs-console-create-predictor"></a>

To create a predictor, which is a trained model, choose an algorithm and the number \(length times frequency\) of predictions to make\. You can choose a particular algorithm, or you can choose **AutoML** to have Amazon Forecast process your data and choose an algorithm to best suit your dataset group\. For information about algorithms, see [Choosing an Amazon Forecast Algorithm](aws-forecast-choosing-recipes.md)\.

**To train a predictor**

1. After your target time series dataset has finished importing, your dataset group's **Dashboard** should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step2-start.png)

   Under **Train a predictor**, choose **Start**\. The **Train predictor** page is displayed\.
**Note**  
The `Status` of the **Target time series data** must be `Active`, which signifies that the import successfully finished, before you can train the predictor\.

1. On the **Train predictor** page, for **Predictor details**, provide the following information:
   + **Predictor name** – Enter a name for your predictor\.
   + **Forecast horizon** – Choose how far into the future to make predictions\. This number multiplied by the data entry frequency \(`hourly`\) that you specified in `Step 1: Import the Training Data` determines how far into the future to make predictions\. For this exercise, set the number to `36`, to provide predictions for 36 hours\.
   + **Forecast frequency** – Keep the default value of **1**\. From the drop\-down menu, choose **hour**\. This setting must be consistent with the input time series data\. The time interval in the sample electricity\-usage data is an hour\.
   + **Algorithm selection** – Keep the default value **Manual**\. From the drop\-down menu, choose the **ETS** algorithm\. For more information about recipes, see [Choosing an Amazon Forecast Algorithm](aws-forecast-choosing-recipes.md)\.

   The remaining settings are optional, so leave the default values\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step2-predictor-details.png)

1. Choose **Train predictor**\. Your dataset group's **Dashboard** page is displayed\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step2-training.png)

   Under **Predictor training**, you will see the training status\. Wait for Amazon Forecast to finish training the predictor\. The process can take several minutes or longer\. When your predictor has been trained, the status transitions to **Active**\. Additionally, the banner at the top of the dashboard changes to display the following message:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step2-trained-banner.png)

   Now that your predictor has been trained, you can create a forecast\.

## Step 3: Create a Forecast<a name="gs-console-retrieve-forecast"></a>

To make predictions \(inferences\), you use a predictor to create a forecast\. A forecast is a group of predictions, one for every item in the target dataset\. To retrieve the prediction for a single item, you query the forecast\. To retrieve the complete forecast, you create an export job\.

**To get and view your forecast**

1. After your predictor has finished training, your dataset group's **Dashboard** should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step3-trained.png)

   Under **Forecast generation**, choose **Start**\. The **Create a forecast** page is displayed\.
**Note**  
The `Status` of **Predictor training** must be `Active` before you can generate a forecast\.

1. On the **Create a forecast** page, for **Forecast details**, provide the following information:
   + **Forecast name** – Enter a name for your forecast\.
   + **Predictor** – From the drop\-down menu, choose the predictor that you created in `Step 2: Train a Predictor`\.

   The remaining setting is optional, so leave the default value\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step3-forecast-details.png)

1. Choose **Create a forecast**\. The dataset group's **Dashboard** page is displayed\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step3-creating-forecast.png)

   Under **Forecast generation**, you should see the status of forecast generation\. Wait for Amazon Forecast to finish creating the forecast\. The process can take several minutes or longer\. When your forecast has been created, the progress transitions to **Active**\. Additionally, the banner at the top of the dashboard changes to display the following message:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step3-created-banner.png)

   Now that your forecast has been created, you can query or export the forecast\.

## Step 4: Retrieve a Forecast<a name="gs-console-retrieve-forecast"></a>

After the forecast has been created, you can query for a single item or export the complete forecast\.

**To query for a single item**

1. If the dashboard is not displayed, in the navigation pane, under your dataset group, choose **Dashboard**\.

1. In the Dashboard, under **Generate forecasts**, choose **Lookup forecast**\. The **Forecast lookup** page is displayed\.

1. On the **Forecast lookup** page, for **Forecast details**, provide the following information\.
   + **Forecast** – From the drop\-down menu, choose the forecast that you created in `Step 3: Create a Forecast`\.
   + **Start date** – Enter **2015/01/01**\. Keep the default time of `00:00:00`\.
   + **End date** – Enter **2015/01/02**\. Change the time to `12:00:00`\.

     The date range of 36 hours corresponds to the **Forecast horizon** that you specified in `Step 2: Train a Predictor`\.
   + **Choose which keys/filters** – Choose **Add forecast key**\.
   + **Forecast key** – From the drop\-down menu, choose `item_id`\.
   + **Value** – Enter a value from the `item_id` column of the input time series of the electricity usage data\. An `item_id` \(for example, `client_21`\) identifies a particular client who is included in the dataset\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step4-lookup.png)

1. Choose **Get Forecast**\. When the forecast is displayed, review the forecast for electricity usage demand by `client_21`\.

   The forecast should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step4-forecast-graph.png)

**To export the complete forecast**

1. In the navigation pane, under your dataset group, choose **Forecasts**\.

1. Choose the radio button next to the forecast that you created in `Step 3: Create a Forecast`\.

1. Choose **Create forecast export**\. The **Create forecast export** page is displayed\.

1. On the **Create forecast export** page, for **Export details**, provide the following information\.
   + **Export name** – Enter a name for your forecast export job\.
   + **Generated forecast** – From the drop\-down menu, choose the forecast that you created in `Step 3: Create a Forecast`\.
   + **IAM role** – Keep the default **Enter a custom IAM role ARN**\.

     Alternatively, you can have Amazon Forecast create the required IAM role for you by choosing **Create a new role** from the drop\-down menu and following the on\-screen instructions\.
   + **Custom IAM role ARN** – Enter the Amazon Resource Name \(ARN\) of the IAM role that you created in [Create an IAM Role for Amazon Forecast \(IAM Console\)](aws-forecast-iam-roles.md#aws-forecast-create-iam-role-with-console)\.
   + **S3 forecast export location** – Use the following format to enter the location of your Amazon Simple Storage Service \(Amazon S3\) bucket or folder in the bucket:

     **s3://<name of your S3 bucket>/<folder path>/**

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step4-create-export.png)

1. Choose **Create forecast export**\. The **my\_forecast** page is displayed\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/gs-step4-exporting.png)

   You should see the status progress\. Wait for Amazon Forecast to finish exporting the forecast\. The process can take several minutes or longer\. When your forecast has been exported, the status transitions to **Active** and you can find the forecast files in your S3 bucket\.
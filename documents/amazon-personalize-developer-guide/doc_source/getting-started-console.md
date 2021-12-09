# Getting Started \(Console\)<a name="getting-started-console"></a>

In this exercise, you use the Amazon Personalize console to create a campaign that returns movie recommendations for a given user\.

Before you start this exercise, review the Getting Started [Getting Started Prerequisites](gs-prerequisites.md)\.

After you finish this exercise, see [Clean Up Resources](gs-cleanup.md)\.

## Step 1: Import Training Data<a name="getting-started-console-import-dataset"></a>

In this procedure, you first create a dataset group\. Next, you create an Amazon Personalize *user\-item interaction* dataset in the dataset group and a schema to match your training data\. Next, you import your training data into the dataset\.

**To import training data**

1. Open the Amazon Personalize console at [https://console\.aws\.amazon\.com/personalize/](https://console.aws.amazon.com/personalize/) and sign in to your account\.

1. Choose **Create dataset group**\.

1. If this is your first time using Amazon Personalize, on the **Create dataset group** page, in **New dataset group**, choose **Get started**\.

1. In **Dataset group details**, for **Dataset group name**, specify a name for your dataset group\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-1-dataset-group-v02.png)

1. Choose **Next**\. 

1. On the **Create user\-item interaction data** page, in **Dataset details**, for **Dataset name**, specify a name for your dataset\.

1. In **Schema details**, for **Schema selection**, choose **Create new schema**\. A minimal Interactions schema is displayed in the **Schema definition** field\. The schema matches the headers you previously added to the `ratings.csv` file\. For more information see [Creating the Training Data](gs-prerequisites.md#gs-upload-to-bucket)\. 

1. For **New schema name**, specify a name for the new schema\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-2-schema.png)

1. Choose **Next**\. 

1. On the **Import user\-item interaction data** page, in **Dataset import job details**, for **Dataset import job name**, specify a name for your import job\.

1. For **IAM service role**, keep the default selection of **Enter a custom IAM role ARN**\.

1. For **Custom IAM role ARN**, specify the role that you created in [Creating an IAM Role for Amazon Personalize](aws-personalize-set-up-permissions.md#set-up-create-role-with-permissions)\.

1. In the informational dialog box named **Additional S3 bucket policy required**, follow the [instructions](data-prep-upload-s3.md) to add the required Amazon S3 bucket policy\.

1. For **Data location**, specify where your movie data file is stored in Amazon Simple Storage Service \(S3\)\. Use the following syntax:

   **s3://<name of your S3 bucket>/<folder path>/<CSV filename>**

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-4-job-details.png)

1. Choose **Finish**\. The data import job starts and the **Dashboard Overview** page is displayed\.

1. Initially, in **Upload datasets**, the **User\-item interaction data** status is **Create pending** \(followed by **Create in progress**\), and the **Create solutions \- Start** button is disabled\.
**Note**  
The time it takes for the data to be imported depends on the size of the dataset\.

   When the data import job has finished, the **User\-item interaction data** status changes to **Active** and the **Create solutions \- Start** button is enabled\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-2-dataset-uploaded.png)

1. After the import job has finished, choose the **Create solutions \- Start** button\. The **Create solution** page is displayed\.

## Step 2: Create a Solution<a name="getting-started-console-create-solution"></a>

In this procedure, you use the dataset that you imported in the previous step to train a model\. A trained model is referred to as a *solution version*\.

**To create a solution**

1. If the **Create solution** page is not already displayed, in the navigation pane, under the dataset group that you created, choose the Solution creation **Start** button\.

1. For **Solution name**, specify a name for your solution\.

1. For **Recipe**, choose **aws\-user\-personalization**\. Leave the optional **Solution configuration** fields unchanged\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-create-solution.png)

1. Choose **Next** to display the **Create solution version** screen\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-create-solution-version-console.png)

1. There's no need to modify the **Solution config**, so choose **Finish**\. Model training starts and the **Dashboard Overview** page is displayed\.

1. Initially, in **Create solutions**, the **Solution creation** status is **Create pending** \(followed by **Create in progress**\), the **Launch campaigns \- Start** button is disabled, and a banner is displayed on the top of the console showing the progress\.
**Note**  
The time it takes to train a model depends on the size of the dataset and the chosen recipe\.

1. After training has finished, in the navigation pane choose Dashboard and choose **Create new campaign**\. 

## Step 3: Create a Campaign<a name="getting-started-console-deploy-solution"></a>

In this procedure, you create a campaign by deploying the solution version you created in the previous step\.

**To create a campaign**

1. If the **Create new campaign** page is not already displayed, in the navigation pane, in the dataset group that you created, choose **Dashboard**, and then choose **Create new campaign**\.

1. In **Campaign details**, for **Campaign name**, specify a name for your campaign\.

1. For **Solution**, choose the solution you created in the previous step and for **Solution version ID** keep the default\.

1. For **Minimum provisioned transactions per second**, keep the default of `1`\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/getting-started-create-new-campaign.png)

1. Choose **Create campaign**\. Campaign creation starts and the **Campaign** page appears with the **Campaign inference** section displayed\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-6-campaign-inference-in-progress.png)
**Note**  
Creating a campaign takes time\.

   After the campaign is created, the page is updated to show the **Test campaign results** section\. Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-campaign-test-before-results.png)

## Step 4: Get Recommendations<a name="getting-started-console-get-recommendations"></a>

In this procedure, use the campaign that you created in the previous step to get recommendations\.

**To get recommendations**

1. In **Test campaign results**, for **User ID**, specify a value from the *ratings* dataset, for example, **83**\. For **Filter name** keep the default selection of *None*\.

1. Choose **Get recommendations**\. The **Recommended item ID** list displays the recommended item IDs\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/gs-test-campaign-with-results.png)
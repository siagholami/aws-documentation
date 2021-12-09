# Using other AWS services to view Trusted Advisor reports<a name="use-other-aws-services-with-trusted-advisor-reports"></a>

Follow this tutorial to upload and view your data by using other AWS services\. In this topic, you create an Amazon Simple Storage Service \(Amazon S3\) bucket to store your report and an AWS CloudFormation template to create resources in your account\. Then, you can use Amazon Athena to analyze or run queries for your report or Amazon QuickSight to visualize that data in a dashboard\.

## Prerequisites<a name="set-up-trusted-advisor-with-amazon-athena-prerequisites"></a>

Before you start this tutorial, you must meet the following requirements:
+ Sign in as an AWS Identity and Access Management \(IAM\) user with administrator permissions\.
+ Use the US East \(N\. Virginia\) AWS Region to quickly set up your AWS services and resources\. 
+ Create an Amazon QuickSight account\. For more information, see [Getting Started with Data Analysis in Amazon QuickSight](https://docs.aws.amazon.com/quicksight/latest/user/getting-started.html) in the *Amazon QuickSight User Guide*\.

## Upload the report to Amazon S3<a name="setting-up-s3"></a>

After you download your `resources.json` report, upload the file to Amazon S3\. You must use a bucket in the US East \(N\. Virginia\) Region\.

**To upload the report to an Amazon S3 bucket**

1. Sign in to the AWS Management Console at [https://console\.aws\.amazon\.com/](https://console.aws.amazon.com/)\.

1. Use the **Region selector** and choose the US East \(N\. Virginia\) Region\.

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose an S3 bucket and copy the name\. You use the name in the next procedure\.

1. Choose **Create folder**, enter the name **folder1**, and choose **Save**\. 

1. Choose the **folder1**\.

1. In **folder1**, choose **Upload** and choose the `resources.json` file\.

1. Choose **Next**, keep the default options, and then choose **Upload**\.
**Note**  
If you upload a new report to this bucket, rename the `.json` files each time you upload them so that you don't override the existing reports\. For example, you can add the timestamp to each file, such as `resources-timestamp.json`, `resources-timestamp2.json`, and so on\.

## Create your resources using AWS CloudFormation<a name="setting-up-cloudformation"></a>

After you upload your report to Amazon S3, upload the following YAML template to AWS CloudFormation\. This template tells AWS CloudFormation what resources to create for your account so that other services can use the report data in the S3 bucket\. The template creates resources for IAM, AWS Lambda, and AWS Glue\.

**To create your resources with AWS CloudFormation**

1. Download the [trusted\-advisor\-reports\-template\.zip](samples/trusted-advisor-reports-template.zip) file\.

1. Unzip the file\.

1. Open the template file in a text editor, replace the *<BucketName>* tag with the bucket name in your account, and then save the file\.

1. Open the AWS CloudFormation console at [https://console\.aws\.amazon\.com/cloudformation](https://console.aws.amazon.com/cloudformation/)\.

1. If you haven't already, in the **Region selector**, choose the US East \(N\. Virginia\) Region\.

1. In the navigation pane, choose **Stacks**\.

1. Choose **Create stack** and choose **With new resources \(standard\)**\.

1. On the **Create stack** page, under **Specify template**, choose **Upload a template file**, and then choose **Choose file**\.

1. Choose the YAML file and choose **Next**\.

1. On the **Specify stack details** page, enter a stack name such as **Organizational\-view\-Trusted\-Advisor\-reports**, and choose **Next**\.

1. On the **Configure stack options** page, keep the default options, and then choose **Next**\.

1. On the **Review **Organizational\-view\-Trusted\-Advisor\-reports** ** page, review your options\. At the bottom of the page, select the check box for **I acknowledge that AWS CloudFormation might create IAM resources**\.

1. Choose **Create stack**\.

   The stack takes about 5 minutes to create\.

1. After the stack creates successfully, the **Resources** tab appears like the following example\.  
![\[Screenshot of example resources created by AWS CloudFormation for Trusted Advisor reports.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-cloud-formation-resources.png)

## Query the data in Amazon Athena<a name="setting-up-athena"></a>

After you have your resources, you can view the data in Athena\. Use Athena to create queries and analyze the results of the report, such as looking up specific check results for accounts in the organization\.

**To query the data in Athena**

1. Open the Athena console at [https://console\.aws\.amazon\.com/athena/](https://console.aws.amazon.com/athena/home)\.

1. If you haven't already, in the **Region selector**, choose the US East \(N\. Virginia\) Region\.

1. Choose **Saved Queries** and in search field, enter **Show sample**\.

1. Choose the query that appears, such as **Show sample entries of TA report**\.   
![\[Screenshot of an example saved query in the Athena console.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-athena.png)

   The query should look like the following\.

   ```
   SELECT * FROM "athenatacfn"."folder1" limit 10
   ```

1. Choose **Run query**\. Your query results appear\. 

**Example : Athena query**  
The following example shows 10 sample entries from the report\.  

![\[Screenshot of the example query in the Athena console.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-query-results.png)
For more information, see [Running SQL Queries Using Amazon Athena](https://docs.aws.amazon.com/athena/latest/ug/querying-athena-tables.html) in the *Amazon Athena User Guide*\.

## Create a dashboard in Amazon QuickSight<a name="setting-up-quicksight"></a>

You can also set up Amazon QuickSight so that you can view your data in a dashboard and visualize your report information\.

**Note**  
You must use the US East \(N\. Virginia\) Region\.

**To create a dashboard in Amazon QuickSight**

1. Navigate to the Amazon QuickSight console and sign in to your account at [https://us\-east\-1\.quicksight\.aws\.amazon\.com](https://us-east-1.quicksight.aws.amazon.com)\.

1. Choose **New analysis**, **New dataset**, and then choose **Athena**\.

1. In the **New Athena data source** dialog box, enter a data source name such as **AthenaTA**, and then choose **Create data source**\.  
![\[Screenshot of a new data source in the Amazon QuickSight console.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-athena-data-source.png)

1. In the **Choose your table** dialog box, choose the **athenatacfn** table, choose **folder1**, and then choose **Select**\.  
![\[Screenshot of choosing your Athena table in the Amazon QuickSight console.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/quicksight-choose-athena-table.png)

1. In the **Finish data set creation** dialog box, choose **Directly query your data**, and then choose **Visualize**\.  
![\[Screenshot of creating a data set in the Amazon QuickSight console.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/quick-sight-visualize-data.png)

You can now create a dashboard in Amazon QuickSight\. For more information, see [Working with Dashboards](https://docs.aws.amazon.com/quicksight/latest/user/working-with-dashboards.html) in the *Amazon QuickSight User Guide*\.

**Example : Amazon QuickSight dashboard**  
The following example dashboard shows information about the Trusted Advisor checks, such as the following:  
+ Affected account IDs
+ Summary by AWS Regions
+ Check categories
+ Check statuses
+ Number of entries in the report for each account

![\[Screenshot of visualizing report data in Amazon QuickSight.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/quick-sight-visualize-data-example-2.png)

**Note**  
If you have permission errors while creating your dashboard, make sure that Amazon QuickSight can use Athena\. For more information, see [I Can't Connect to Amazon Athena](https://docs.aws.amazon.com/quicksight/latest/user/troubleshoot-connect-athena.html) in the *Amazon QuickSight User Guide*\.
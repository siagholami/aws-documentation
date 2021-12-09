# Setting Up Athena Using AWS CloudFormation Templates<a name="use-athena-cf"></a>

**Important**  
Before moving on to this procedure, you must wait for the first AWS CUR to be delivered to your Amazon S3 bucket\. It might take up to 8 hours for AWS to deliver your first report\.

To use Athena, you must set up an AWS Glue crawler, an AWS Glue database, and an AWS Lambda event\. Billing and Cost Management provides an AWS CloudFormation template that does this setup for you\. Be sure to align the Region when using the template\. This process shows how to use the Athena AWS CloudFormation template\.<a name="use-athena-cf-steps"></a>

**To use the Athena AWS CloudFormation template**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. From the list of buckets, choose your bucket name\.

1. Navigate your folders until you find the `.yml` template file\.

   The `.yml` file is usually found in the prefix name folder, or report name folder\. The location varies depending on how your report is formatted\.

1. Select the `.yml` template file\.

1. Select **download**\.

1. Open the AWS CloudFormation console at [https://console\.aws\.amazon\.com/cloudformation](https://console.aws.amazon.com/cloudformation/)\.

1. Choose **Create New Stack** if you have never used AWS CloudFormation before\. Otherwise, choose **Create Stack**\.

1. Under **Prepare template**, choose **Template is ready**\.

1. Under **Template source**, choose **Upload a template file**\.

1. Select **Choose file**\.

1. Choose the downloaded `.yml` template, and then choose **Open**\.

1. Choose **Next**\.

1. For **Stack name**, enter a name for your template and choose **Next**\.

1. Choose **Next**\.

1. At the bottom of the page, select **I acknowledge that AWS CloudFormation might create IAM resources\.** This template creates the following resources:
   + Three IAM roles
   + An AWS Glue database
   + An AWS Glue crawler
   + Two Lambda functions
   + An Amazon S3 notification

1. Choose **Create**\.
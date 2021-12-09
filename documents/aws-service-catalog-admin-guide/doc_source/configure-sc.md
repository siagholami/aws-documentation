# Configuring AWS Service Catalog<a name="configure-sc"></a>

Now that you have created two IAM users with baseline permissions in each account, the next step is to configure AWS Service Catalog\. This section describes how to configure AWS Service Catalog to have a portfolio that includes an Amazon S3 bucket product\. Use the Amazon S3 template located at [Creating an Amazon S3 Bucket for Website Hosting for your preliminary product](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/quickref-s3.html#scenario-s3-bucket-website)\. Copy and save the Amazon S3 template to your device\.

**To configure AWS Service Catalog**

1. Create a portfolio by following the steps at [Create an AWS Service Catalog Portfolio](getstarted-portfolio.md)\.

1.  To add the Amazon S3 bucket product to the portfolio you just created, in the AWS Service Catalog console, on the **Upload new product** page, enter product details\. 

1.  For **Select template**, choose the Amazon S3 bucket AWS CloudFormation template you saved to your device\. 

1.  Set **Constraint type** to **Launch** for the product that you just created with the SCConnectLaunch role in the baseline permissions\. For additional launch constraint instructions, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\. 
**Note**  
The AWS configuration design requires each AWS Service Catalog product to have a launch constraint\. Failure to follow this step may result in an “Unable to Retrieve Parameter” message within ServiceNow Service Catalog\. 

1. Add the SnowEndUser IAM role to the AWS Service Catalog portfolio\. For additional user access instructions, see [Granting Access to Users](catalogs_portfolios_users.md)\. 
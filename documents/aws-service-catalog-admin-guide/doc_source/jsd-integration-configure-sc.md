# Configuring AWS Service Catalog<a name="jsd-integration-configure-sc"></a>

 Now that you have created two IAM users with baseline permissions in each account, the next step is to configure AWS Service Catalog\. This section describes how to configure AWS Service Catalog to have a portfolio that includes an Amazon S3 bucket product\. Use the Amazon S3 template located at [Creating an Amazon S3 Bucket for Website Hosting](https://https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/quickref-s3.html#scenario-s3-bucket-website) for your preliminary product\. Copy and save the Amazon S3 template to your device\. 

**To configure AWS Service Catalog**

1. Create a portfolio by following the steps at [Step 3: Create an AWS Service Catalog Portfolio](getstarted-portfolio.md)\.

1. To add the Amazon S3 bucket product to the portfolio you just created, in the AWS Service Catalog console, on the **Upload new product** page, enter product details\. 

1. For **Select template**, choose the Amazon S3 bucket AWS CloudFormation template you saved to your device\. 

1. Set **Constraint type** to **Launch** for the product that you just created with the SCConnectLaunch role in the baseline permissions\. For additional launch constraint instructions, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\. 

**Note**  
The AWS configuration design requires each AWS Service Catalog product to have either a launch or StackSet constraint\. Failure to follow this step may result in an *Unable to Retrieve Parameter* message within Jira Service Desk Service Catalog\.

## Creating Stack Set Constraint<a name="creating-stackset-constraint"></a>

 AWS CloudFormation StackSets enable users to create products that are deployed across multiple accounts and regions\. In AWS Service Catalog, a stack set constraint allows you to configure product deployment options\. 

**To apply a stack set constraint to an AWS Service Catalog product**

1.  Go to AWS Service Catalog as a catalog administrator\. 

1.  Choose the portfolio that contains the product you want to apply a constraint to\. 

1.  Expand **Constraints** and choose **Add constraints**\. 

1.  Choose the product from **Product** and set **Constraint type** to **Stack Set**\. Choose **Continue**\. 

1.  On the **Stack set constraint** page, enter a description\. 

1.  Choose the accounts in which you want to create products\. 

1.  Choose the regions in which you want to deploy products\. Products are deployed in these regions in the order that you specify\. 

1.  Choose the **AWSCloudFormationStackSetAdministratorRole** role that will be used to manage your target accounts\. 

1.  Choose the **AWSCloudFormationStackSetExecutionRole** role that the administrator role will assume\. 

1.  Choose **Submit**\. 

    Note that the [Connector for Jira Service Desk v1\.5\.0 \- AWS Commercial Regions](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_Commercial_final.yml) and [Connector for Jira Service Desk v1\.5\.0 \- AWS GovCloud West Region](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_GovCloud_final.json) templates create the permissions as well as the outputs needed for stack set constraints\. Example stack set outputs: 

   ```
                       SCStackSetAdministratorRoleARN 
                       arn:aws:iam::123456789123:role/AWSCloudFormationStackSetAdministrationRole SCIAMStackSetExecutionRoleName 
                       AWSCloudFormationStackSetExecutionRole  
                       SCIAMAdminRoleARN 
                       arn:aws:iam::123456789123:role/AWSCloudFormationStackSetAdministrationRole
   ```

    Note that AWS Service Catalog products can have either a stack set or a launch constraint, but not both\. 
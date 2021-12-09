# Baseline Permissions<a name="baseline-permissions"></a>

This section provides instructions on how to set up the baseline AWS users and permissions needed for the AWS Service Catalog Connector for ServiceNow\. For each AWS account, the Connector for ServiceNow requires two IAM users and three roles:
+ **AWS Service Catalog Sync User**: IAM user to sync AWS portfolios and products to ServiceNow catalog items \(**AWSServiceCatalogAdminReadOnlyAccess** managed policy\)\.
+ **AWS Service Catalog End User role**: IAM role configured as an AWS Service Catalog end user and assigned to each AWS Service Catalog portfolio\.
+ **AWS Service Catalog End User**: Enables Connector for ServiceNow to provision AWS products by assuming a role that contains the trust relationship with the account and policies needed for the end user privileges in AWS Service Catalog\.
+ **SCConnect Launch role**: IAM role used to place baseline AWS service permissions into the AWS Service Catalog launch constraints\. Configuring this role enables segregation of duty through provisioning product resources on behalf of the ServiceNow end user\. The SCConnectLaunch role baseline contains permissions to Amazon EC2 and Amazon S3 services\. If your products contain more AWS services, you must either include those services in the  `SCConnectLaunch` role or create new launch roles\.

## Creating AWS Service Catalog Sync User<a name="scsyncuser"></a>

The following section describes how to create the AWS Service Catalog Sync user and associate the appropriate IAM permission\. To perform this task, you need IAM permissions to create new users\.

**To create AWS Service Catalog sync user**

1. Go to [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)\. Following the instructions there, create a policy called **SCConnectorAdmin** for ServiceNow administrators to delete AWS Service Catalog products in ServiceNow that do not have self\-service actions associated\. ServiceNow administrators can also view budgets associated to AWS Service Catalog portfolios and products\. Copy the following policy and paste it into **Policy Document**:

   ```
     {
            "Version": "2012-10-17",
            "Statement": [{
               "Sid": "VisualEditor0",
               "Effect": "Allow",
               "Action": [
                  "servicecatalog:DisassociateProductFromPortfolio",
                  "servicecatalog:DeleteProduct",
                  "servicecatalog:DeleteConstraint",
                  "servicecatalog:DeleteProvisionedProductPlan",
                  "servicecatalog:DeleteProvisioningArtifact",
                  "servicecatalog:ListBudgetsForResource",
                  "servicecatalog:SearchProductsAsAdmin",
                  "servicecatalog:ListPortfoliosForProduct",
                  "servicecatalog:ListPrincipalsForPortfolio",
                  "servicecatalog:ListAcceptedPortfolioShares",            
                  "budgets:ViewBudget"
               ],
               "Resource": "*"
            }]
         }
   ```

1. Go to [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\. Following the instructions there, create a sync user \(that is, SCSyncUser\)\. The user needs programmatic and AWS Management Console access to follow the Connector for ServiceNow installation instructions\.

1. Set permissions for your sync user \(SCSyncUser\)\. Choose **Attach existing policies directly** and select the ****AWSServiceCatalogAdminReadOnlyAccess**** and **SCConnectorAdmin** policies\.
**Note**  
The **ServiceCatalogAdminReadOnlyAccess** policy was deprecated\. If you are using a current version of the Connector for ServiceNow, update your SCSyncUser with the correct managed policy: ****AWSServiceCatalogAdminReadOnlyAccess****\.

1. Review and choose **Create User**\.

1. Note the Access and Secret Access information\. Download the \.csv file that contains the user credential information\.

## Creating AWS Service Catalog End User<a name="scenduser"></a>

 The following section describes how to create the AWS Service Catalog end user and associate the appropriate IAM permission\. This AWS end user \(SCEndUser\) requires you to first create an AWS role \(such as SnowEndUser\) with the required IAM permissions\. The AWS end user will assume the AWS role\. To perform this task, you need IAM permissions to create new users\. 

 If you are upgrading from an earlier version of the Connector, note that the **ServiceCatalogServiceNowAdditionalPermissions** AWS policy is no longer needed for the Connector for ServiceNow\. Proceed to the **Create a SnowEndUser** role step\. 

**To create AWS Service Catalog end user**

1.  You need to first create the AWS role \(such as SnowEndUser\)\. Go to [Create a role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html)\. 

    For products using AWS CloudFormation StackSets, you need to create a StackSet inline policy\. With AWS CloudFormation StackSets, you are able to create products that are deployed across multiple accounts and regions\. Using an administrator account, you define and manage an AWS Service Catalog product, and use it as the basis for provisioning stacks into selected target accounts across specified regions\. You need to have the necessary permissions defined in your AWS accounts\. 

    To set up the necessary permissions, go to [Granting Permissions for Stack Set Operations](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacksets-prereqs.html)\. Following the instructions there, create an **AWSCloudFormationStackSetAdministrationRole** and an **AWSCloudFormationStackSetExecutionRole**\. 

    Create the StackSet inline policy to enable provisioning a product across multiple regions within one account\. 

   ```
       {
           "Version": "2012-10-17",
           "Statement": [
               {
                   "Action": [
                       "sts:AssumeRole"
                   ],
                   "Resource": [
                   "arn:aws:iam::123456789123:role/AWSCloudFormationStackSetExecutionRole"
                   ],
                   "Effect": "Allow"
               },
               {
                   "Effect": "Allow",
                   "Action": [
                       "iam:GetRole",
                       "iam:PassRole"
                   ],
       "Resource":       "arn:aws:iam::123456789123:role/AWSCloudFormationStackSetAdministrationRole"
               }
           ]
       }
   ```
**Note**  
Replace **123456789123** with your account information\. The [Connector for ServiceNow v2\.3\.4 \- AWS Commercial Regions](https://servicecatalogconnector.s3.amazonaws.com/SC_ConnectorForServiceNowv2.3.4+-AWS_Configurations_final.json) and [Connector for ServiceNow v2\.3\.4 \- AWS GovCloud West Region](https://servicecatalogconnector.s3.amazonaws.com/SC_ConnectorForServiceNowv2.3.4+-AWS_Configurations_GovCloud_final.json) files include the stack set permissions\.

1. Add the following permissions \(policies\) to the SnowEndUser role:
   + **AWSServiceCatalogEndUserFullAccess** \- Note: The **ServiceCatalogEndUserFullAccess** policy was deprecated\. If you are using a current version of the Connector for ServiceNow, update the SCSyncUser with the correct AWS managed policy\.
   + **StackSet \(inline policy\)**
   + **AmazonEC2ReadOnlyAccess**
   + **AmazonS3ReadOnlyAccess** \- Note: For AWS Service Catalog products using AWS CloudFormation StackSets, you need to modify the SnowEndUser role to include the ReadOnly permissions for the service\(s\) you want to provision\. For example, to provision an Amazon S3 bucket, include the AmazonS3ReadOnlyAccess policy to the SnowEndUser role\.
   + Create a trust relationship on the SnowEndUser role to the account\. Copy and paste the following text into the Trust Relationship \(replacing the number string for ARN with your account information\):

     ```
                                                 {
                       "Version": "2012-10-17",
                       "Statement": [
                         {
                           "Effect": "Allow",
                           "Principal": {
                             "AWS": "arn:aws:iam::123456789123:root"
                           },
                           "Action": "sts:AssumeRole",
                           "Condition": {}
                         }
                       ]
                     }
     ```

1. Go to [Create a policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)\. Following the instructions there, create a policy called **StsAssume\-SC**\. Copy and paste the following text into the JSON editor \(replacing the number string for ARN with your account information\):

   ```
                                   {
                   "Version": "2012-10-17",
                   "Statement": [
                       {
                           "Sid": "VisualEditor0",
                           "Effect": "Allow",
                           "Action": "sts:AssumeRole",
                           "Resource": "arn:aws:iam:: 123456789123:role/SnowEndUser"
                       }
                   ]
               }
   ```

1.  Go to [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\. Following the instructions there, create a user \(such as SCEndUser\)\. The user needs programmatic and AWS Management Console access to follow the ServiceNow Connector installation instructions\. 

1.  Attach the assume policy \(StsAssume\-SC\) to your end user \(SCEndUser\)\. Choose **Attach existing policies directly** and select **StsAssume\-SC**\. 

1. Review and choose **Create User**\.

1. Note the Access and Secret Access information\. Download the \.csv file that contains the user credential information\.

## Creating SCConnectLaunch Role<a name="scconnectlaunchrole"></a>

The following section describes how to create the **SCConnectLaunch** role\. This role is used to place baseline AWS service permissions into the AWS Service Catalog launch constraints\. For more information, see [AWS Service Catalog Launch Constraints](https://docs.aws.amazon.com/servicecatalog/latest/adminguide/constraints-launch.html)\.

**To create SCConnectLaunch role**

1. Create the **AWSCloudFormationFullAccess** policy\. Choose **create policy** and then paste the following in the JSON editor:

   ```
                               {
               "Version": "2012-10-17",
               "Statement": [
                   {
                       "Effect": "Allow",
                       "Action": [
                       "cloudformation:DescribeStackResource",
                       "cloudformation:DescribeStackResources",
                       "cloudformation:GetTemplate",
                       "cloudformation:List*",
                       "cloudformation:DescribeStackEvents",
                       "cloudformation:DescribeStacks",
                       "cloudformation:CreateStack",
                       "cloudformation:DeleteStack",
                       "cloudformation:DescribeStackEvents",
                       "cloudformation:DescribeStacks",
                       "cloudformation:GetTemplateSummary",
                       "cloudformation:SetStackPolicy",
                       "cloudformation:ValidateTemplate",
                       "cloudformation:UpdateStack",
                       "cloudformation:CreateChangeSet",
                       "cloudformation:DescribeChangeSet",
                       "cloudformation:ExecuteChangeSet",
                       "cloudformation:DeleteChangeSet",
                       "s3:GetObject"
                       ],
                       "Resource": "*"
                   }
               ]
           }
   ```
**Note**  
**AWSCloudFormationFullAccess** now includes additional permissions for ChangeSets\.

1.  Create a policy called **ServiceCatalogSSMActionsBaseline**\. Follow the instructions on [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html), and paste the following into the JSON editor: 

   ```
                               {
               "Version": "2012-10-17",
               "Statement": [
                   {
                       "Sid": "Stmt1536341175150",
                       "Action": [
                           "servicecatalog:ListServiceActionsForProvisioningArtifact",
                           "servicecatalog:ExecuteprovisionedProductServiceAction",
                           "ssm:DescribeDocument",
                           "ssm:GetAutomationExecution",
                           "ssm:StartAutomationExecution",
                           "ssm:StopAutomationExecution",
                           "cloudformation:ListStackResources",
                           "ec2:DescribeInstanceStatus",
                           "ec2:StartInstances",
                           "ec2:StopInstances"
                       ],
                       "Effect": "Allow",
                       "Resource": "*"
                   }
               ]
           }
   ```

1. Create the **SCConnectLaunch** role\. Assign the trust relationship to AWS Service Catalog\.

   ```
                               {
             "Version": "2012-10-17",
             "Statement": [
               {
                 "Sid": "",
                 "Effect": "Allow",
                 "Principal": {
                   "Service": "servicecatalog.amazonaws.com"
                 },
                 "Action": "sts:AssumeRole"
               }
             ]
           }
   ```

1. Attach the relevant policies to the **SCConnectLaunch** role\. Attach the following baseline IAM policies:
   + **AmazonEC2FullAccess** \(AWS managed policy\)
   + **AmazonS3FullAccess** \(AWS managed policy\)
   + **AWSCloudFormationFullAccess** \(custom managed policy\)
   + **ServiceCatalogSSMActionsBaseline**
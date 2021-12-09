# Baseline Permissions<a name="jsd-integration-baseline-permissions"></a>

 This section provides instructions on how to set up the baseline AWS users and permissions needed for the AWS Service Management Connector for Jira Service Desk\. For each AWS account, the Connector for Jira Service Desk requires two sets of an access key identifier and a secret key for API access\. These correspond to users in AWS Identity and Access Management \(IAM\)\. Specifically, you should set up:
+ An IAM user to sync AWS resources to Jira Service Desk\.
+ An IAM user able to perform end user functionality to provision and execute requests exposed through Jira Service Desk, including assuming any roles required to perform the provisioning and execution \(launch roles are recommended for AWS Service Catalog\)\.

 These can be the same user and can be an existing user, but in line with the best practice to give minimal permissions it is recommended these be two new users for Connector\. 

 Full details of the permissions required by these users is included below, with an AWS CloudFormation template to facilitate setting this up\. Baseline permissions enable an end user to provision the following AWS services: Amazon Simple Storage Service and Amazon Elastic Compute Cloud\. To allow end users to provision AWS services beyond the baseline permissions, you must include the additional AWS service permissions to the appropriate roles\. 

**Note**  
 To use an AWS CloudFormation template to set up the AWS configurations of the Connector for Jira Service Desk, see the two JSON AWS Configurations for [Connector for Jira Service Desk v1\.5\.0 \- AWS Commercial Regions](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_Commercial_final.yml) and [Connector for Jira Service Desk v1\.5\.0 \- AWS GovCloud West Region](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_GovCloud_final.json)\.

## Creating AWS Service Management Connector Sync User<a name="jsd-creating-sc-sync-user"></a>

 The following section describes how to create the AWS Connector sync user and associate the appropriate IAM permissions\. To perform this task, you need IAM permissions to create new users\. 

**To create AWS Service Management Connector sync user**

1. Go to [Creating an IAM User in Your AWS Account](https://https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\. Following the instructions there, create a sync user \(that is, SCSyncUser\)\. The user needs programmatic and AWS Management Console access to follow the Connector for Jira Service Desk installation instructions\.

1.  Set permissions for your sync user \(SCSyncUser\)\. Choose **Attach existing policies directly** and select the ****AWSServiceCatalogAdminReadOnlyAccess**** policy and the **AmazonSSMReadOnlyAccess ** policy\. 

1.  Also add a policy allowing **budgets:ViewBudget** on all resources \(\*\)\. 

1.  Review and choose **Create User**\. 

1. Note the access and secret access information\. Download the \.csv file that contains the user credential information\.

## Creating AWS Service Management Connector End User<a name="jsd-creating-sc-end-user"></a>

 The following section describes how to create the AWS Service Management Connector end user and associate the appropriate IAM permissions\. To perform this task, you need IAM permissions to create new users\. 

**To create AWS Service Management Connector end user**

1. Go to [Creating an IAM User in Your AWS Account](https://https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\. Following the instructions there, create a user \(such as SCEndUser\)\. The user needs programmatic and AWS Management Console access to follow the Connector for Jira Service Desk installation instructions\.

1.  For products with AWS CloudFormation StackSets, you need to create a stack set inline policy\. With AWS CloudFormation StackSets, you can create products that are deployed across multiple accounts and regions\. Using an administrator account, you define and manage an AWS Service Catalog product and use it as the basis for provisioning stacks into selected target accounts across specified regions\. You need to have the necessary permissions defined in your AWS accounts\. 

    To set up the necessary permissions, go to [Granting Permissions for Stack Set Operations](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacksets-prereqs.html)\. Following the instructions there, create an **AWSCloudFormationStackSetAdministrationRole** and an **AWSCloudFormationStackSetExecutionRole**\. 

1.  Create the stack set inline policy to enable provisioning a product across multiple regions in one account, replacing the `arn` number string with your account number\. 

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
 The [Connector for Jira Service Desk v1\.5\.0 \- AWS Commercial Regions](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_Commercial_final.yml) and [Connector for Jira Service Desk v1\.5\.0 \- AWS GovCloud West Region](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_GovCloud_final.json) templates include the AWS CloudFormation StackSet permissions\. 

1.  Add the following permissions \(policies\) to the user **SCEndUser**: 
   + **AWSServiceCatalogEndUserFullAccess** \- \(AWS managed policy\)
   + StackSet \- \(inline policy\)
   + AmazonS3ReadOnlyAccess
   + AmazonEC2ReadOnlyAccess
   + AWSConfigUserAccess
**Note**  
 For AWS Service Catalog products with AWS CloudFormation StackSets, you need to include the read only permissions for the services you want to provision\. For example, to provision an Amazon S3 bucket, include the **AmazonS3ReadOnlyAccess** policy to the **SCEndUser** role\. 

1. Also add a policy allowing the following on all resources \(\*\): **ssm:DescribeAutomationExecutions**, **ssm:DescribeDocument**, and ssm:**StartAutomationExecution**\. 

1.  Review and choose **Create User**\. 

1. Note the access and secret access information\. Download the \.csv file that contains the user credential information\.

## Creating SCConnectLaunch Role<a name="jsd-creating-scconnectlaunch-role"></a>

 The following section describes how to create the **SCConnectLaunch** role\. This role is used to place baseline AWS service permissions into the AWS Service Catalog launch constraints\. For more information, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\. 

**To create SCConnectLaunch role**

1. Create the **AWSCloudFormationFullAccess** policy\. Choose **create policy** and then paste the following in the JSON editor\.

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

1. Create a policy called **ServiceCatalogSSMActionsBaseline**\. Follow the instructions on [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html), and paste the following into the JSON editor\. 

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
   + **AmazonS3FullAccess ** \(AWS managed policy\)
   + **AWSCloudFormationFullAccess** \(custom managed policy\)
   + **ServiceCatalogSSMActionsBaseline** \(custom managed policy\)

**Note**  
 To use an AWS CloudFormation template to set up the AWS configurations of the Connector for Jira Service Desk, see the two JSON AWS Configurations for [Connector for Jira Service Desk v1\.5\.0 \- AWS Commercial Regions](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_Commercial_final.yml) and [Connector for Jira Service Desk v1\.5\.0 \- AWS GovCloud West Region](https://servicecatalogconnector.s3.amazonaws.com/SM_ConnectorForJSDv1.5.0+-AWS_Configurations_GovCloud_final.json)\.
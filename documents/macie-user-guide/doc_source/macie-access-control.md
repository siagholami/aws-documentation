# Controlling Access to Amazon Macie<a name="macie-access-control"></a>

AWS uses security credentials to identify you and to grant you access to your AWS resources\. You can use features of AWS Identity and Access Management \(IAM\) to allow other users, services, and applications to use your AWS resources fully or in a limited way\. You can do this without sharing your security credentials\.

By default, IAM users don't have permission to create, view, or modify AWS resources\. To allow an IAM user to access resources such as a load balancer, and to perform tasks, you:

1. Create an IAM policy that grants the IAM user permission to use the specific resources and API actions they need\.

1. Attach the policy to the IAM user or the group that the IAM user belongs to\.

When you attach a policy to a user or group of users, it allows or denies the users permission to perform the specified tasks on the specified resources\.

For example, you can use IAM to create users and groups under your AWS account\. An IAM user can be a person, a system, or an application\. Then you grant permissions to the users and groups to perform specific actions on the specified resources using an IAM policy\.

For more information, see the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\.

## Granting Administrator Access to Macie<a name="admin-access"></a>

The master account users have access to the Macie console, where they can configure Macie and use it to monitor and protect the resources in both master and member accounts\. For more information about master and member accounts, see [Concepts and Terminology](macie-concepts.md) and [Integrating Member Accounts and Amazon S3 with Amazon Macie](macie-integration.md)\. 

For the master account users to be able to use the Macie console, they must be granted the required permissions\. To ensure this, use the following policy document to create and attach an IAM policy to any user identity type that belongs to your master Macie account\. This policy grants master account users permissions to use the Macie console in its full capacity\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect": "Allow",
         "Resource": "*",
         "Action":[
            "macie:*"
         ]
      },
      {
         "Effect": "Allow",
         "Action": "iam:CreateServiceLinkedRole",
         "Resource": "*",
         "Condition": {
            "StringLike": {
               "iam:AWSServiceName": "macie.amazonaws.com"
            }
         }
      }
   ]
}
```

## Granting Read\-Only Access to Macie<a name="read-access"></a>

For a user to view any data in the Macie console, they must be granted the required permissions\. To grant read\-only access, create a custom policy using the following policy document and attach it to a IAM user, group, or role\. This policy grants users permissions to only view information in the Macie console\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "macie:Get*",
                "macie:List*",
                "macie:Describe*"
            ],
            "Resource": [
                "*"
            ],
            "Effect": "Allow"
        }
    ]
}
```

## Predefined AWS Managed Policies for Macie<a name="managed-policies"></a>

The managed policies created by AWS grant the required permissions for common use cases\. You can attach these policies to IAM users in your AWS account, based on the access to Macie that they require:
+ **AmazonMacieFullAccess** – Grants full access to Macie
+ **AmazonMacieHandshakeRole** – Grants permission to create the service\-linked role for Macie

The following are legacy policies that have been replaced by a service\-linked role\. For more information, see [Legacy Roles for Macie](using-service-linked-roles.md#macie-legacy-roles)\.
+ **AmazonMacieServiceRole** – Grants Macie read\-only access to resource dependencies in your account in order to enable data analysis
+ **AmazonMacieSetupRole** – Grants Macie access to your AWS account

## Creating a Handshake Role<a name="create-handshake-role"></a>

You can create a role that grants the permissions in the **AmazonMacieHandshakeRole** policy to Macie from the master account as follows\.<a name="create-iam-role-console"></a>

**To create AWSMacieServiceCustomerHandshakeRole using the IAM console**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**\.

1. Choose **Create role** and do the following:

   1. For **Select type of trusted entity**, choose **AWS service**\.

   1. For **Choose a use case**, select **EC2**\.

   1. Choose **Next: Permissions**\.

1. On the **Attach permissions policies** page, select the checkbox for the **AmazonMacieHandshakeRole** policy and choose **Next: Tags**\.

1. \(Optional\) Add tags to your role and then choose **Next: Review**\.

1. On the **Review** page, do the following:

   1. For **Role name**, enter **AWSMacieServiceCustomerHandshakeRole**\.

   1. For **Role description**, enter the following: Allows the master account to create service\-linked roles in the member accounts\.

   1. Choose **Create role**\.

1. Edit the trust policy as follows:

   1. Select **AWSMacieServiceCustomerHandshakeRole**, which you just created\.

   1. On the **Trust relationships** tab, choose **Edit trust relationship**\.

   1. Enter the following trust policy:

      ```
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Effect": "Allow",
            "Principal": { 
              "Service": "macie.amazonaws.com"
            },
            "Action": "sts:AssumeRole",
            "Condition": {
              "StringEquals": {
                "sts:ExternalId": "master-account-id"
              }
            }
          }
        ]
      }
      ```

   1. Choose **Update Trust Policy**\.<a name="create-iam-role-cli"></a>

**To create AWSMacieServiceCustomerHandshakeRole using the AWS CLI**

1. Create the following trust policy and save it in a text file named `macie-handshake-trust-policy.json`\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": { 
           "Service": "macie.amazonaws.com"
         },
         "Action": "sts:AssumeRole",
         "Condition": {
           "StringEquals": {
             "sts:ExternalId": "master-account-id"
           }
         }
       }
     ]
   }
   ```

1. Create the role and specify the trust policy that you created in the previous step using the [create\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/create-role.html) command\.

   ```
   aws iam create-role --role-name AWSMacieServiceCustomerHandshakeRole --assume-role-policy-document file://macie-handshake-trust-policy.json
   ```

1. Attach the **AmazonMacieHandshakeRole** policy to the role using the [attach\-role\-policy](https://docs.aws.amazon.com/cli/latest/reference/iam/attach-role-policy.html) command\.

   ```
   aws iam attach-role-policy --role-name AWSMacieServiceCustomerHandshakeRole --policy-arn arn:aws:iam::aws:policy/service-role/AmazonMacieHandshakeRole
   ```
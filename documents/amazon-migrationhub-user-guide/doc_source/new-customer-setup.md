# New User IAM Setup<a name="new-customer-setup"></a>

This section provides an overview of the four managed policies that can be used with AWS Migration Hub as well as instructions on how to setup access to either the Migration Hub console or its APIs for users or migration tools\.

## Required Managed Policies<a name="required-managed-policies"></a>

The following AWS managed policies, which you can attach to users in your account, are specific to Migration Hub and are grouped by use case scenario:
+ **AWSMigrationHubDiscoveryAccess** – \(Included in the **migrationhub\-discovery** role\) – Grants permission to allow the Migration Hub service to call Application Discovery Service\.
+ **AWSMigrationHubFullAccess** – Grants access to the Migration Hub console and API/CLI for a user who's not an administrator\.
+ **AWSMigrationHubSMSAccess** – Grants permission for Migration Hub to receive notifications from the AWS Server Migration Service migration tool\.
+ **AWSMigrationHubDMSAccess** – Grants permission for Migration Hub to receive notifications from the AWS Database Migration Service migration tool\.

If you want to grant Migration Hub rights to non\-admin IAM users, then see [Migration Hub Service API and Console Managed Access](#api-console-access-managed)\.

If you want to authorize \(that is, connect\) AWS migration tools, see [AWS Server Migration Service \(SMS\)](#sms-managed) or [AWS Database Migration Service \(DMS\)](#dms-managed)\.

### Migration Hub Service API and Console Managed Access<a name="api-console-access-managed"></a>

An administrator can create users and grant them permission to access the Migration Hub console using managed policies\.

1. Navigate to the IAM console\. 

1. Create a user\. 

1. Once the user is created, on the permissions tab select "Add Permissions"\. 

1. Select "Attach existing policies directly"\. 

1. Search for and attach the policy "AWSMigrationHubFullAccess"\. 

### migrationhub\-discovery Role<a name="adscaller-role-managed"></a>

To use Migration Hub, the `migrationhub-discovery` role \(which contains the `AWSMigrationHubDiscoveryAccess` policy\) must be added to your AWS account\. It allows Migration Hub to access the Application Discovery Service on your behalf\.

The AWS Migration Hub console creates the `migrationhub-discovery` role that is automatically attached to your AWS account when you use the Migration Hub console as an administrator\. If you use the AWS Command Line Interface \(AWS CLI\) or the AWS Migration Hub API without also using the console, you need to manually add this role to your account\.

1. Navigate to the IAM console [Roles section](https://console.aws.amazon.com/iam/home?#/roles)\.

1. Choose **Create new role**\.

1. Select "Amazon EC2" from AWS Service Role\.

1. Attach the "AWSApplicationDiscoveryServiceFullAccess" managed policy\.

1. Name the role "migrationhub\-discovery" *\(required role name using exact case and spelling\)*\.

1. Access the new role and on the Trust Relationships tab, choose **Edit Trust Relationship**\.

1. Add the trust policy below\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "migrationhub.amazonaws.com"
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

### Migration Tools \(Managed Policies\)<a name="migration-tools-managed"></a>

Roles and policies are needed for each migration tool in order for the Migration Hub to receive notifications from migration tools\. These permissions allow AWS services like SMS and DMS to send updates to Migration Hub\.

#### AWS Server Migration Service \(SMS\)<a name="sms-managed"></a>

1. Navigate to the IAM console [Roles section](https://console.aws.amazon.com/iam/home?#/roles)\.

1. Choose **Create new role**\.

1. Select "Amazon EC2" from AWS Service Role\.

1. Attach the "AWSMigrationHubSMSAccess" managed policy\.

1. Name the role "migrationhub\-sms" *\(required role name using exact case and spelling\)*\.

1. Access the new role, and on the Trust Relationships tab, choose **Edit Trust Relationship**\.

1. Add the trust policy below\. 

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": [
             "sms.amazonaws.com"
           ]
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

#### AWS Database Migration Service \(DMS\)<a name="dms-managed"></a>

1. Navigate to the IAM console [Roles section](https://console.aws.amazon.com/iam/home?#/roles)\.

1. Choose **Create new role**\.

1. Select "Amazon EC2" from AWS Service Role\.

1. Attach the "AWSMigrationHubDMSAccess" managed policy\.

1. Name the role "migrationhub\-dms" *\(required role name using exact case and spelling\)*\.

1. Access the new role, and on the Trust Relationships tab, choose **Edit Trust Relationship**\.

1. Add the trust policy below\. 

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": [
             "dms.amazonaws.com"
           ]
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```
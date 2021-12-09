# Managing an Agreement for Multiple Accounts<a name="manageorgagreement"></a>

If you are the owner of the master account of an AWS Organizations organization, you can accept an agreement on behalf of all accounts in your organization\. You must be signed in to the master account with the correct AWS Artifact permissions to accept or terminate organization agreements\. Users of member accounts with `describeOrganizations` permissions can view the organization agreements that are accepted on their behalf\. 

If your account is not part of an organization, you can create or join an organization by following the instructions in [Creating and Managing an AWS Organizations](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_org.html)\.

**Notes**  
AWS Organizations has two available feature sets: *consolidated billing features* and *all features*\. To use AWS Artifact for your organization, the organization that you belong to must be enabled for [all features](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_getting-started_concepts.html#feature-set)\. If your organization is configured only for consolidated billing, see [Enabling All Features in Your Organization](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_org_support-all-features.html)\.
If a member account is removed from an organization, that member account will no longer be covered by organization agreements\. Master account administrators should communicate this to member accounts before removing member accounts from the organization, so that member accounts can put new agreements in place if necessary\. A list of active organization agreements can be viewed in [AWS Artifact Organization Agreements](http://console.aws.amazon.com/artifact/home?#!/agreements?tab=organizationAgreements)\.

For more information about AWS Organizations and master accounts, see [Managing the AWS Accounts in Your Organization](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_accounts.html)\. For more information about setting up an administrator account for AWS Artifact, see [Step 1: Create an Administrators Group and Add an IAM User](getting-started.md#create-an-admin)\.

## Accepting an Agreement for Your Organization<a name="org-agreement"></a>

You can accept an agreement on behalf of all member accounts in your organization in AWS Organizations\. To accept an agreement, the owner of the master account must have the following permissions:

```
artifact:DownloadAgreement
artifact:AcceptAgreement
organizations:DescribeOrganization 
organizations:EnableAWSServiceAccess 
organizations:ListAWSServiceAccessForOrganization
iam:ListRoles 
iam:CreateRole 
iam:AttachRolePolicy
```

For more information about these permissions, see [Create an IAM Policy](controlling-access.md#create-iam-policy)\.

**Important**  
Before you accept an agreement, we recommend that you consult with your legal, privacy, and compliance team\.<a name="enter-org-agreement"></a>

**To accept an agreement for an organization**

1. Sign in to the AWS Management Console and open the AWS Artifact console at [https://console\.aws\.amazon\.com/artifact/](https://console.aws.amazon.com/artifact/)\.

1. On the AWS Artifact dashboard, choose **Agreements**\.

1. Choose the **Organization agreements** tab\.

1. Expand the section of the agreement that you want\.

1. Choose **Download and review**\.

1. In the **Terms and conditions** dialog box, choose **Accept and download**\.
**Note**  
The NDA is a legally binding contract\. We recommend that you read it closely\.

1. Review the agreement and then select the check boxes to indicate that you agree with the content\.

1. Choose **Accept** to accept the agreement for all existing and future accounts in your organization\.\.

## Terminating an Organization Agreement<a name="terminate-org-agreement"></a>

If you used the AWS Artifact console to accept an agreement on behalf of all member accounts in an organization, you can use the console to terminate that agreement\. To terminate an agreement, the owner of the master account must have the following permissions:

```
artifact:DownloadAgreement
artifact:TerminateAgreement
organizations:DescribeOrganization 
organizations:EnableAWSServiceAccess 
organizations:ListAWSServiceAccessForOrganization
iam:ListRoles 
iam:CreateRole 
iam:AttachRolePolicy
```

For more information about creating policies, see [Create an IAM Policy](controlling-access.md#create-iam-policy)\.

**Note**  
If you didn't use the AWS Artifact console to accept an agreement, you can't use the console to terminate the agreement\.   
For more information, see [Managing an Existing Offline Agreement](manageofflineagreement.md)\.

**To terminate your online organization agreement with AWS**

1. Sign in to the AWS Management Console and open the AWS Artifact console at [https://console\.aws\.amazon\.com/artifact/](https://console.aws.amazon.com/artifact/)\.

1. On the AWS Artifact dashboard, choose **Agreements**\.

1. Choose the **Organization agreements** tab\.

1. For the agreement that you want to terminate, choose **Terminate agreement for this account**\. 

1. Choose the **Terminate** section\. 

1. Select all check boxes to indicate that you agree to terminate the agreement\. 

1. Choose the **Terminate** button\. When prompted, choose it again\.
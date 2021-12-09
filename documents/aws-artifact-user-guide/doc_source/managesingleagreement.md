# Managing an Agreement for a Single Account<a name="managesingleagreement"></a>

You can accept agreements for just your account,  even if your account is a member account in an organization in AWS Organizations\. For more information about AWS Organizations, see the [AWS Organizations User Guide](https://docs.aws.amazon.com/organizations/latest/userguide/)\. 

## Accepting an Agreement with AWS<a name="enteragreement"></a>

If you're an administrator of an account, you can give IAM users and federated users with roles the permissions to access and manage one or more of your agreements\. By default, only users with administrative privileges can accept an agreement\. To accept an agreement, IAM and federated users must have the following permissions:

```
artifact:DownloadAgreement
artifact:AcceptAgreement
```

For more information about these permissions, see [Create an IAM Policy](controlling-access.md#create-iam-policy)\.

**Important**  
Before you accept an agreement, we recommend that you consult with your legal, privacy, and compliance team\.

**To accept an agreement with AWS**

1. Sign in to the AWS Management Console and open the AWS Artifact console at [https://console\.aws\.amazon\.com/artifact/](https://console.aws.amazon.com/artifact/)\.

1. On the AWS Artifact navigation pane, choose **Agreements**\.

1. Choose the **Account agreements** tab\.

1. Expand the section of the agreement that you want\.

1. Choose **Download and review**\.

1. In the **Terms and conditions** dialog box, choose **Accept and download**\.
**Note**  
The NDA is a legally binding contract\. We recommend that you read it closely\.

1. Review the agreement and then select the check boxes to indicate that you agree with the content\.

1. Choose **Accept** to accept the agreement for just your account\.

## Terminating an Agreement with AWS<a name="terminateagreement"></a>

If you used the AWS Artifact console to accept an agreement, you can use the console to terminate that agreement\. To terminate an agreement, IAM and federated users must have the following permissions:

```
artifact:TerminateAgreement
```

For more information about these permissions, see [Create an IAM Policy](controlling-access.md#create-iam-policy)\.

**Note**  
If you didn't use the AWS Artifact console to accept an agreement, you can't use the console to terminate the agreement\. For more information, see [Managing an Existing Offline Agreement](manageofflineagreement.md)\.

**To terminate your online agreement with AWS**

1. Sign in to the AWS Management Console and open the AWS Artifact console at [https://console\.aws\.amazon\.com/artifact/](https://console.aws.amazon.com/artifact/)\.

1. On the AWS Artifact navigation pane, choose **Agreements**\.

1. Choose the **Account agreements** tab\.

1. For the agreement that you want to terminate, choose **Terminate agreement for this account**\. 

1. Choose the **Terminate** section\. 

1. Select all check boxes to indicate that you agree to terminate the agreement\. 

1. Choose the **Terminate** button\. When prompted, choose it again\.
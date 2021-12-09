# Grant Permissions to AWS Service Catalog End Users<a name="getstarted-iamenduser"></a>

Before the end user can use AWS Service Catalog, you must grant access to the AWS Service Catalog end user console view\. To grant access, you attach policies to the IAM user, group, or role that is used by the end user\. In the following procedure, we attach the ****AWSServiceCatalogEndUserFullAccess**** policy to an IAM group\. For more information, see [Predefined AWS Managed Policies](controlling_access.md#permissions-managed-policies)\.

**To grant permissions to an end user group**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Groups**\.

1. Choose **Create New Group** and do the following:

   1. For **Group Name**, type **Endusers**, and then choose **Next Step**\.

   1. In the search field, type **AWSServiceCatalog** to filter the policy list\.

   1. Select the checkbox for the ****AWSServiceCatalogEndUserFullAccess**** policy, and then choose **Next Step**\. You also have the option to choose ****AWSServiceCatalogEndUserReadOnlyAccess**** instead\.

   1. On the **Review page**, choose **Create Group**\.

1. In the navigation pane, choose **Users**\.

1. Choose **Add user** and do the following:

   1. For **User name**, type a name for the user\.

   1. Select **AWS Management Console access**\.

   1. Choose **Next: Permissions**\.

   1. Choose **Add user to group**\.

   1. Select the checkbox for the **Endusers** group and choose **Next: Tags** and then **Next: Review**\.

   1. On the **Review** page, choose **Create user**\. Download or copy the credentials and then choose **Close**\.
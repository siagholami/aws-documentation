# Tagging an organization<a name="org-tag"></a>

Tagging an Amazon WorkMail organization resource lets you do the following:
+ Differentiate between organizations in the AWS Billing and Cost Management console\.
+ Control access to Amazon WorkMail organization resources by adding them to the `Resource` element of AWS Identity and Access Management \(IAM\) permission policy statements\.

For more information about Amazon WorkMail resource\-level permissions, see [Resources](security_iam_service-with-iam.md#security_iam_service-with-iam-id-based-policies-resources)\. For more information about controlling access based on tags, see [Authorization based on Amazon WorkMail tags](security_iam_service-with-iam.md#security_iam_service-with-iam-tags)\.

Amazon WorkMail administrators can tag organizations using the Amazon WorkMail console\.

**To add tags to an Amazon WorkMail organization**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. Choose **Tags**\.

1. For **Organization tags**, choose **Add new tag**\.

1. For **Key**, enter a string to identify the tag\.

1. \(Optional\) For **Value**, enter a value for the tag\.

1. \(Optional\) Repeat steps 4\-6 to add more tags to your organization\. You can add up to 50 tags\.

1. Choose **Submit** to save your changes\.

You can view your organization tags in the Amazon WorkMail console\.

Developers can also tag organizations using the AWS SDK or AWS Command Line Interface \(AWS CLI\)\. For more information, see the `TagResource`, `ListTagsForResource`, and `UntagResource` commands in the [Amazon WorkMail API Reference](https://docs.aws.amazon.com/workmail/latest/APIReference/Welcome.html) or the [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/workmail/index.html)\.

You can remove tags from an organization at any time, using the Amazon WorkMail console\.

**To remove tags from an Amazon WorkMail organization**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. Choose **Tags**\.

1. For **Organization tags**, choose **Remove** next to the tag to remove\.

1. Choose **Submit** to save your changes\.
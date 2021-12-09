# Tagging Resources<a name="tags"></a>

A tag consists of a key and a value, both of which you define\. When you tag an Athena resource, you assign custom metadata to it\. You can use tags to categorize your AWS resources in different ways; for example, by purpose, owner, or environment\. In Athena, workgroups and data catalogs are taggable resources\. For example, you can create a set of tags for workgroups in your account that helps you track workgroup owners, or identify workgroups by their purpose\. We recommend that you that you use [AWS tagging best practices](https://d1.awsstatic.com/whitepapers/aws-tagging-best-practices.pdf) to create a consistent set of tags to meet your organization requirements\.

You can work with tags using the Athena console or the API operations\. 

**Topics**
+ [Tag Basics](#tag-basics)
+ [Tag Restrictions](#tag-restrictions)
+ [Working with Tags on Workgroups in the Console](tags-console.md)
+ [Using Tag Operations](tags-operations.md)
+ [Tag\-Based IAM Access Control Policies](tags-access-control.md)

## Tag Basics<a name="tag-basics"></a>

A tag is a label that you assign to an Athena resource\. Each tag consists of a key and an optional value, both of which you define\.

Tags enable you to categorize your AWS resources in different ways\. For example, you can define a set of tags for your account's workgroups that helps you track each workgroup owner or purpose\.

You can add tags when creating a new Athena workgroup or data catalog, or you can add, edit, or remove tags from them\. You can edit a tag in the console\. To use API operations to edit a tag, remove the old tag and add a new one\. If you delete a resource, any tags for the resource are also deleted\.

Athena does not automatically assign tags to your resources\. You can edit tag keys and values, and you can remove tags from a resource at any time\. You can set the value of a tag to an empty string, but you can't set the value of a tag to null\. Do not add duplicate tag keys to the same resource\. If you do, Athena issues an error message\. If you use the TagResource action to tag a resource using an existing tag key, the new tag value overwrites the old value\.

In IAM, you can control which users in your AWS account have permission to create, edit, remove, or list tags\. For more information, see [Tag\-Based IAM Access Control Policies](tags-access-control.md)\.

For a complete list of Amazon Athena tag actions, see the API action names in the [Amazon Athena API Reference](https://docs.aws.amazon.com/athena/latest/APIReference/)\.

You can use tags for billing\. For more information, see [Using Tags for Billing](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/custom-tags.html) in the *AWS Billing and Cost Management User Guide*\.

For more information, see [Tag Restrictions](#tag-restrictions)\.

## Tag Restrictions<a name="tag-restrictions"></a>

Tags have the following restrictions:
+ In Athena, you can tag workgroups and data catalogs\. You cannot tag queries\.
+ The maximum number of tags per resource is 50\. To stay within the limit, review and delete unused tags\.
+ For each resource, each tag key must be unique, and each tag key can have only one value\. Do not add duplicate tag keys at the same time to the same resource\. If you do, Athena issues an error message\. If you tag a resource using an existing tag key in a separate `TagResource` action, the new tag value overwrites the old value\.
+ Tag key length is 1\-128 Unicode characters in UTF\-8\.
+ Tag value length is 0\-256 Unicode characters in UTF\-8\.

  Tagging operations, such as adding, editing, removing, or listing tags, require that you specify an ARN for the workgroup resource\.
+ Athena allows you to use letters, numbers, spaces represented in UTF\-8, and the following characters: \+ \- = \. \_ : / @\.
+ Tag keys and values are case\-sensitive\.
+ The `"aws:"` prefix in tag keys is reserved for AWS use\. You can't edit or delete tag keys with this prefix\. Tags with this prefix do not count against your per\-resource tags limit\.
+ The tags you assign are available only to your AWS account\.
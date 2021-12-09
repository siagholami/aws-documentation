# Tagging AWS Elemental MediaStore resources<a name="tagging"></a>

A *tag* is a custom attribute label that you assign or that AWS assigns to an AWS resource\. Each tag has two parts:
+ A *tag key* \(for example, `CostCenter`, `Environment`, or `Project`\)\. Tag keys are case sensitive\.
+ An optional field known as a *tag value* \(for example, `111122223333` or `Production`\)\. Omitting the tag value is the same as using an empty string\. Like tag keys, tag values are case sensitive\.

Tags help you do the following:
+ Identify and organize your AWS resources\. Many AWS services support tagging, so you can assign the same tag to resources from different services to indicate that the resources are related\. For example, you could assign the same tag to an AWS Elemental MediaStore *container* that you assign to an AWS Elemental MediaLive input\.
+ Track your AWS costs\. You activate these tags on the AWS Billing and Cost Management dashboard\. AWS uses the tags to categorize your costs and deliver a monthly cost allocation report to you\. For more information, see [Use Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the [AWS Billing and Cost Management User Guide](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/)\.

The following sections provide more information about tags for AWS Elemental MediaStore\.

## Supported resources in AWS Elemental MediaStore<a name="supported-resources"></a>

The following resources in AWS Elemental MediaStore support tagging: 
+ *container*

For information about adding and managing tags, see [Managing tags](#tagging-add-edit-delete)\.

AWS Elemental MediaStore doesn't support the tag\-based access control feature of AWS Identity and Access Management \(IAM\)\. 

## Tag naming and usage conventions<a name="tagging-restrictions"></a>

The following basic naming and usage conventions apply to using tags with AWS Elemental MediaStore resources:
+ Each resource can have a maximum of 50 tags\.
+ For each resource, each tag key must be unique, and each tag key can have only one value\.
+ The maximum tag key length is 128 Unicode characters in UTF\-8\.
+ The maximum tag value length is 256 Unicode characters in UTF\-8\.
+ Allowed characters are letters, numbers, spaces representable in UTF\-8, and the following characters:*** \. : \+ = @ \_ / \-*** \(hyphen\)\. Amazon EC2 resources allow any characters\.
+ Tag keys and values are case sensitive\. As a best practice, decide on a strategy for capitalizing tags, and consistently implement that strategy across all resource types\. For example, decide whether to use `Costcenter`, `costcenter`, or `CostCenter`, and use the same convention for all tags\. Avoid using similar tags with inconsistent case treatment\. 
+ The `aws:` prefix is prohibited for tags; it's reserved for AWS use\. You can't edit or delete tag keys or values with this prefix\. Tags with this prefix do not count against your tags per resource quota\.

## Managing tags<a name="tagging-add-edit-delete"></a>

Tags are made up of the `Key` and `Value` properties on a resource\. You can use the AWS CLI or the MediaStore API to add, edit, or delete the values for these properties\. For information about working with tags, see the following sections in the *AWS Elemental MediaStore API Reference*:
+ [CreateContainer](https://docs.aws.amazon.com/mediastore/latest/apireference/API_CreateContainer.html)
+ [ListTagsForResource](https://docs.aws.amazon.com/mediastore/latest/apireference/API_ListTagsForResource.html)
+ [Resources](https://docs.aws.amazon.com/mediastore/latest/apireference/API_Tag.html)
+ [TagResource](https://docs.aws.amazon.com/mediastore/latest/apireference/API_TagResource.html)
+ [UntagResource](https://docs.aws.amazon.com/mediastore/latest/apireference/API_UntagResource.html)
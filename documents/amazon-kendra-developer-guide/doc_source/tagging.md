--------

--------

# Tags<a name="tagging"></a>

Manage your indexes, data sources, and FAQs by assigning metadata to them with *tags*\. Use tags to categorize your Amazon Kendra resources in various ways, for example, by purpose, owner, or application, or any combination\. Each tag consists of a *key* and a *value*, both of which you define\. 

Tags help you to:
+ Identify and organize your AWS resources\. Many AWS services support tagging, so you can assign the same tag to resources in different services to indicate that the resources are related\. For example, you can tag an index and the Amazon Lex bot that uses it with the same tag\.
+ Allocate costs\. You activate tags on the AWS Billing and Cost Management dashboard\. AWS uses tags to categorize your costs and deliver a monthly cost allocation report to you\. For more information, see [Cost Allocation and Tagging](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in *About AWS Billing and Cost Management*\.
+ Control access to your resources\. You can use tags in AWS Identity and Access Management \(IAM\) polices that control access to Amazon Kendra resources\. You can attach these policies to an IAM role or user to enable tag\-based access control\. For more information, see [Authorization based on Amazon Kendra tags](security_iam_service-with-iam.md#security_iam_service-with-iam-tags)\. 

You can create and manage tags using the AWS Management Console, the AWS Command Line Interface \(AWS CLI\), or the Amazon Kendra API\.

## Tagging resources<a name="tagging-resources"></a>

If you're using the Amazon Kendra console, you can tag resources when you create them or add them later\. You can also use the console to update or remove tags\. 

If you're using the AWS Command Line Interface \(AWS CLI\) or the Amazon Kendra API, use the following operations to manage tags for your resources:
+ [CreateDataSource](API_CreateDataSource.md) – Apply tags when you create a data source\.
+ [CreateFaq](API_CreateFaq.md) – Apply tags when you create an FAQ\.
+ [CreateIndex](API_CreateIndex.md) – Apply tags when you create an index\.
+ [ListTagsForResource](API_ListTagsForResource.md) – View the tags associated with a resource\.
+ [TagResource](API_TagResource.md) – Add and modify tags for a resource\.
+ [UntagResource](API_UntagResource.md) – Remove tags from a resource\.

## Tag restrictions<a name="tag-restrictions"></a>

The following restrictions apply to tags on Amazon Kendra resources:
+ Maximum number of tags – 50
+ Maximum key length – 128 characters
+ Maximum value length – 256 characters
+ Valid characters for key and value – a–z, A–Z, space, and the following characters: \_ \. : / = \+ \- and @
+ Keys and values are case sensitive
+ Don't use `aws:` as a prefix for keys; it's reserved for AWS use
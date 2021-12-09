# Tagging AWS Elemental MediaPackage Resources<a name="tagging"></a>

Tagging is available with only live workflows in AWS Elemental MediaPackage\. You can't use tags on video on demand \(VOD\) or harvested live\-to\-VOD assets\.

A *tag* is a metadata label that you assign or that AWS assigns to an AWS resource\. Each tag consists of a *key* and a *value*\. For tags that you assign, you define the key and value\. For example, you might define the key as `stage` and the value for one resource as `test`\.

Tags help you do the following:
+ Identify and organize your AWS resources\. Many AWS services support tagging, so you can assign the same tag to resources from different services to indicate that the resources are related\. For example, you could assign the same tag to an AWS Elemental MediaPackage channel and endpoint that you assign to an AWS Elemental MediaTailor configuration\.
+ Track your AWS costs\. You activate these tags on the AWS Billing and Cost Management dashboard\. AWS uses the tags to categorize your costs and deliver a monthly cost allocation report to you\. For more information, see [Use Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the [AWS Billing and Cost Management User Guide](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/)\.

For tips on using tags, see the [AWS Tagging Strategies](https://aws.amazon.com/answers/account-management/aws-tagging-strategies/) post on the *AWS Answers* blog\. 

The following sections provide more information about tags for AWS Elemental MediaPackage\.

## Supported Resources in AWS Elemental MediaPackage<a name="supported-resources"></a>

The following resources in AWS Elemental MediaPackage support tagging: 
+ Channels
+ Endpoints

Video on demand \(VOD\) resources don't support tagging\. This includes assets, packaging groups, and packaging configurations\.

For information about adding and managing tags, see [Managing Tags](#tagging-add-edit-delete)\.

## Tag Restrictions<a name="tagging-restrictions"></a>

The following basic restrictions apply to tags on AWS Elemental MediaPackage resources:
+ Only live content workflows are supported in MediaPackage
+ Maximum number of tags that you can assign to a resource – 50 
+ Maximum key length – 128 Unicode characters 
+ Maximum value length – 256 Unicode characters 
+ Valid characters for key and value – a\-z, A\-Z, 0\-9, space, and the following characters: \_ \. : / = \+ \- and @
+ Keys and values are case sensitive
+ Don't use `aws:` as a prefix for keys; it's reserved for AWS use

## Managing Tags<a name="tagging-add-edit-delete"></a>

Tags are made up of the `Key` and `Value` properties on a resource\. You can use the AWS Elemental MediaPackage API or the AWS CLI to add, edit, or delete the values for these properties\. For more information, see the [Resources](https://docs.aws.amazon.com/mediapackage/latest/apireference/resources.html) topic in the *AWS Elemental MediaPackage API Reference*\.
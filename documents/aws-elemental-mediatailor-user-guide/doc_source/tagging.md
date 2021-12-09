# Tagging AWS Elemental MediaTailor Resources<a name="tagging"></a>

A *tag* is a metadata label that you assign or that AWS assigns to an AWS resource\. Each tag consists of a *key* and a *value*\. For tags that you assign, you define the key and value\. For example, you might define the key as `stage` and the value for one resource as `test`\.

Tags help you do the following:
+ Identify and organize your AWS resources\. Many AWS services support tagging, so you can assign the same tag to resources from different services to indicate that the resources are related\. For example, you could assign the same tag to an AWS Elemental MediaPackage channel and endpoint that you assign to an AWS Elemental MediaTailor configuration\.
+ Track your AWS costs\. You activate these tags on the AWS Billing and Cost Management dashboard\. AWS uses the tags to categorize your costs and deliver a monthly cost allocation report to you\. For more information, see [Use Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the [AWS Billing and Cost Management User Guide](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/)\.
+ Control access to your AWS resources\. For more information, see [Controlling Access Using Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\. 

For tips on using tags, see the [AWS Tagging Strategies](https://aws.amazon.com/answers/account-management/aws-tagging-strategies/) post on the *AWS Answers* blog\. 

The following sections provide more information about tags for AWS Elemental MediaTailor\.

## Supported Resources in AWS Elemental MediaTailor<a name="supported-resources"></a>

The following resource in AWS Elemental MediaTailor supports tagging:
+ Configurations

## Tag Restrictions<a name="tagging-restrictions"></a>

The following basic restrictions apply to tags on AWS Elemental MediaTailor resources:
+ Maximum number of tags that you can assign to a resource – 50 
+ Maximum key length – 128 Unicode characters 
+ Maximum value length – 256 Unicode characters 
+ Valid characters for key and value – a\-z, A\-Z, 0\-9, space, and the following characters: \_ \. : / = \+ \- and @
+ Keys and values are case sensitive
+ Don't use `aws:` as a prefix for keys; it's reserved for AWS use

## Managing Tags in AWS Elemental MediaTailor<a name="tagging-add-edit-delete"></a>

You set tags as properties on a resource\. You can add, edit, and delete tags through the AWS Elemental MediaTailor API or the AWS CLI\. For more information, see the [https://docs.aws.amazon.com/mediatailor/latest/apireference/](https://docs.aws.amazon.com/mediatailor/latest/apireference/)\.
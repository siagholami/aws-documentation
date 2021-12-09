# Tagging in AWS Global Accelerator<a name="tagging-in-global-accelerator"></a>

Tags are words or phrases that you use to identify and organize your AWS resources\. You can add multiple tags to each resource, and each tag includes a key and a value that you define\. For example, the key might be `environment` and the value might be `production`\. You can search and filter your resources based on the tags you add\. In AWS Global Accelerator, you can tag accelerators\.

The following are two examples of how it can be useful to work with tags in Global Accelerator:
+ Use tags to track billing information in different categories\. To do this, apply tags to accelerators or other AWS resources \(such as Network Load Balancers, Application Load Balancers, or Amazon EC2 instances\) and activate the tags\. Then AWS generates a cost allocation report as a comma\-separated value \(CSV file\) with your usage and costs aggregated by your active tags\. You can apply tags that represent business categories \(such as cost centers, application names, or owners\) to organize your costs across multiple services\. For more information, see [Using Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the *AWS Billing and Cost Management User Guide*\.
+ Use tags to enforce tag\-based permissions for accelerators\. To do this, create IAM policies that specify tags and tag values to allow or disallow actions\. For more information, see [ Tag\-based policies](auth-and-access-control.md#access-control-manage-access-tag-policies)\.

For usage conventions and links to other resources about tagging, see [Tagging AWS Resources](https://docs.aws.amazon.com/general/latest/gr/aws_tagging.html) in the *AWS General Reference*\. For tips on using tags, see [ Tagging Best Practices: AWS Resource Tagging Strategy](https://d1.awsstatic.com/whitepapers/aws-tagging-best-practices.pdf) in the *AWS Whitepapers* blog\.

For the maximum number of tags that you can add to a resource in Global Accelerator, see [Quotas for AWS Global Accelerator](limits-global-accelerator.md)\.

You can add and update tags by using the AWS console, AWS CLI, or Global Accelerator API\. This chapter includes steps for working with tagging in the console\. For more information about working with tags by using the AWS CLI and the Global Accelerator API, including CLI examples, see the following operations in the *AWS Global Accelerator API Reference*:
+ [CreateAccelerator](https://docs.aws.amazon.com/global-accelerator/latest/api/CreateAccelerator.html) 
+ [TagResource](https://docs.aws.amazon.com/global-accelerator/latest/api/TagResource.html) 
+ [UntagResource](https://docs.aws.amazon.com/global-accelerator/latest/api/UntagResource.html) 
+ [ListTagsForResource](https://docs.aws.amazon.com/global-accelerator/latest/api/ListTagsForResource.html) 

## Tagging support in Global Accelerator<a name="tagging-supported"></a>

AWS Global Accelerator supports tagging for accelerators\.

Global Accelerator supports the tag\-based access control feature of AWS Identity and Access Management \(IAM\)\. For more information, see [ Tag\-based policies](auth-and-access-control.md#access-control-manage-access-tag-policies)\.

## Adding, editing, and deleting tags in Global Accelerator<a name="tagging-add-edit-delete"></a>

The following procedure explains how to add, edit, and delete tags for accelerators in the Global Accelerator console\.

**Note**  
You can add or remove tags using the console, the AWS CLI, or Global Accelerator API operations\. For more information, including CLI examples, see [TagResource](https://docs.aws.amazon.com/global-accelerator/latest/api/API_TagResource.html) in the *AWS Global Accelerator API Reference*\.<a name="tagging-add-edit-delete-procedure"></a>

**To add tags, edit, or delete tags in Global Accelerator**

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. Choose the accelerator that you want to add or update tags for\.

1. In the **Tags** section, you can do the following:  
**Add a tag**  
Choose **Add tag**, then enter a key and, optionally, a value for the tag\.  
**Edit a tag**  
Update the text for a key, value, or both\. You can also clear the value for a tag, but the key is required\.  
**Delete a tag**  
Choose **Remove** on the right side of the value field\.

1. Choose **Save changes**\.
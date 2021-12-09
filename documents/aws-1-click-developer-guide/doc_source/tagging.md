# Tagging Your AWS IoT 1\-Click Resources<a name="tagging"></a>

To help you manage your AWS IoT 1\-Click resources, you can optionally assign your own metadata to any ARN\-based resource using tags\. This chapter describes tags and shows you how to create them\.

## Tag Basics<a name="tag-basics"></a>

Tags enable you to categorize your AWS IoT 1\-Click resources in different ways, for example, by purpose, owner, or environment\. This is useful when you have many resources of the same type – you can quickly search for and identify a specific resource based on the tags you've assigned to it\. Each tag consists of a key and optional value, both of which you define\. For example, you could define a set of tags for a multiple buttons owned by a particular manager or account\. You can search and filter the resources based on the tags you add\. We recommend that you devise a set of tag keys that meets your needs for each resource type\. Using a consistent set of tag keys makes it easier for you to manage your resources\. For more information, see [AWS Tagging Strategies](https://aws.amazon.com/answers/account-management/aws-tagging-strategies/)\.

You can also use tags to categorize and track your costs\. When you apply tags to resources, AWS generates a cost allocation report as a comma\-separated value \(CSV\) file with your usage and costs aggregated by your tags\. You can apply tags that represent business categories \(such as cost centers, application names, or owners\) to organize your costs across multiple services\. For more information about using tags for cost allocation, see [Use Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the [AWS Billing and Cost Management User Guide](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/)\. 

For ease of use, you can use the Tag Editor in the AWS Management Console, which provides a central, unified way to create and manage your tags\. For more information, see [Working with Tag Editor](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/tag-editor.html) in [Getting Started with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.

You can also work with tags using the AWS CLI and the AWS IoT 1\-Click Device and Project APIs\. You can associate tags with AWS IoT 1\-Click projects and devices when you create them by using the *tags* field in the following commands: 
+ [CreateProject](https://docs.aws.amazon.com/iot-1-click/latest/projects-apireference/API_CreateProject.html) \(Projects API\)
+ [Finalize Claim](https://docs.aws.amazon.com/iot-1-click/1.0/devices-apireference//devices-deviceid-finalize-claim.html) \(Devices API\)

You can add, modify, or delete tags for existing resources using the following commands:

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iot-1-click/latest/developerguide/tagging.html)

You can edit tag keys and values, and you can remove tags from a resource at any time\. You can set the value of a tag to an empty string, but you can't set the value of a tag to null\. If you add a tag that has the same key as an existing tag on that resource, the new value overwrites the old value\. If you delete a resource, any tags associated with the resource are also deleted\. 

## Tag Restrictions<a name="tag-restrictions"></a>

The following basic restrictions apply to tags:
+ Maximum number of tags per resource – 50
+ Maximum key length – 127 Unicode characters in UTF\-8
+ Maximum value length – 255 Unicode characters in UTF\-8
+ Tag keys and values are case\-sensitive\.
+ Do not use the *aws:* prefix in your tag names or values because it is reserved for AWS use\. You can't edit or delete tag names or values with this prefix\. Tags with this prefix do not count against your tags per resource limit\. 
+ If your tagging schema is used across multiple services and resources, remember that other services may have restrictions on allowed characters\. Generally, allowed characters are: letters, spaces, and numbers representable in UTF\-8, plus the following special characters: \+ \- = \. \_ : / @
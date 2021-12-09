# Tagging Your AWS IoT Analytics Resources<a name="tagging"></a>

To help you manage your channels, data sets, data stores and pipelines, you can optionally assign your own metadata to each of these resources in the form of tags\. This chapter describes tags and shows you how to create them\.

## Tag Basics<a name="aws-iot-analytics-tagging-basics"></a>

Tags enable you to categorize your AWS IoT Analytics resources in different ways, for example, by purpose, owner, or environment\. This is useful when you have many resources of the same type — you can quickly identify a specific resource based on the tags you've assigned to it\. Each tag consists of a key and optional value, both of which you define\. For example, you could define a set of tags for your channels that helps you track the type of device responsible for each channel's message source\. We recommend that you devise a set of tag keys that meets your needs for each resource type\. Using a consistent set of tag keys makes it easier for you to manage your resources\. You can search and filter the resources based on the tags you add\.

You can also use tags to categorize and track your costs\. When you apply tags to channels, data sets, data stores, or pipelines, AWS generates a cost allocation report as a comma\-separated value \(CSV\) file with your usage and costs aggregated by your tags\. You can apply tags that represent business categories \(such as cost centers, application names, or owners\) to organize your costs across multiple services\. For more information about using tags for cost allocation, see [Use Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html) in the [AWS Billing and Cost Management User Guide](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/)\.

For ease of use, use the Tag Editor in the AWS Management Console, which provides a central, unified way to create and manage your tags\. For more information, see [Working with Tag Editor](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/tag-editor.html) in [Getting Started with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.

You can also work with tags using the AWS CLI and the AWS IoT Analytics API\. You can associate tags with channels, data sets, data stores and pipelines when you create them; use the *Tags* field in the following commands:
+  [CreateChannel](api.md#cli-iotanalytics-createchannel) 
+  [CreateDataset](api.md#cli-iotanalytics-createdataset) 
+  [CreateDatastore](api.md#cli-iotanalytics-createdatastore) 
+  [CreatePipeline](api.md#cli-iotanalytics-createpipeline) 

You can add, modify, or delete tags for existing resources that support tagging; use the following commands:
+  [TagResource](api.md#cli-iotanalytics-tagresource) 
+  [ListTagsForResource](api.md#cli-iotanalytics-listtagsforresource) 
+  [UntagResource](api.md#cli-iotanalytics-untagresource) 

You can edit tag keys and values, and you can remove tags from a resource at any time\. You can set the value of a tag to an empty string, but you can't set the value of a tag to null\. If you add a tag that has the same key as an existing tag on that resource, the new value overwrites the old value\. If you delete a resource, any tags associated with the resource are also deleted\.

## Using Tags with IAM Policies<a name="aws-iot-analytics-tagging-iam"></a>

You can use the `Condition` element \(also called the `Condition` block\) with the following condition context keys/values in an IAM policy to control user access \(permissions\) based on a resource's tags:
+ Use `iotanalytics:ResourceTag/<tag-key>: <tag-value>` to allow or deny user actions on resources with specific tags\.
+ Use `aws:RequestTag/<tag-key>: <tag-value>` to require that a specific tag be used \(or not used\) when making an API request to create or modify a resource that allows tags\.
+ Use `aws:TagKeys: [<tag-key>, ...]` to require that a specific set of tag keys be used \(or not used\) when making an API request to create or modify a resource that allows tags\.

**Note**  
The condition context keys/values in an IAM policy only apply to those AWS IoT Analytics actions where an identifier for a resource capable of being tagged is a required parameter\. For example, the use of [DescribeLoggingOptions](api.md#cli-iotanalytics-describeloggingoptions) is not allowed/denied on the basis of condition context keys/values because no taggable resource \(channel, data set, data store or pipeline\) is referenced in this request\.

 [Controlling Access Using Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the AWS Identity and Access Management User Guide has additional information on using tags\. The [IAM JSON Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) section of that guide has detailed syntax, descriptions and examples of the elements, variables, and evaluation logic of JSON policies in IAM\.

The following example policy applies two tag\-based restrictions\. An IAM user restricted by this policy:
+ cannot give a resource the tag "env=prod" \(see the line `"aws:RequestTag/env" : "prod"` in the example\)\.
+ cannot modify or access a resource that has an existing tag "env=prod" \(see the line `"iotanalytics:ResourceTag/env" : "prod"` in the example\)\.

```
{
  "Version" : "2012-10-17",
  "Statement" :
  [
    {
      "Effect" : "Deny",
      "Action" : "iotanalytics:*",
      "Resource" : "*",
      "Condition" : {
        "StringEquals" : {
          "aws:RequestTag/env" : "prod"
        }
      }
    },
    {
      "Effect" : "Deny",
      "Action" : "iotanalytics:*",
      "Resource" : "*",
      "Condition" : {
        "StringEquals" : {
          "iotanalytics:ResourceTag/env" : "prod"
        }
      }
    },
    {
      "Effect": "Allow",
      "Action": [
        "iotanalytics:*"
      ],
      "Resource": "*"
    }
  ]
}
```

You can also specify multiple tag values for a given tag key by enclosing them in a list, like this:

```
"StringEquals" : {
  "iotanalytics:ResourceTag/env" : ["dev", "test"]
}
```

**Note**  
If you allow/deny users access to resources based on tags, it is important to consider explicitly denying users the ability to add those tags to or remove them from the same resources\. Otherwise, it is possible for a user to circumvent your restrictions and gain access to a resource by modifying its tags\.

## Tag Restrictions<a name="aws-iot-analytics-tagging-restrict"></a>

The following basic restrictions apply to tags:
+ Maximum number of tags per resource — 50
+ Maximum key length — 127 Unicode characters in UTF\-8
+ Maximum value length — 255 Unicode characters in UTF\-8
+ Tag keys and values are case\-sensitive\.
+ Do not use the *aws:* prefix in your tag names or values because it is reserved for AWS use\. You can't edit or delete tag names or values with this prefix\. Tags with this prefix do not count against your tags per resource limit\.
+ If your tagging schema is used across multiple services and resources, remember that other services may have restrictions on allowed characters\. Generally, allowed characters are: letters, spaces, and numbers representable in UTF\-8, plus the following special characters: \+ \- = \. \_ : / @\.
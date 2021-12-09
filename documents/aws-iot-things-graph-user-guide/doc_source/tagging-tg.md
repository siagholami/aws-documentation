--------

--------

# Tagging Your AWS IoT Things Graph Resources<a name="tagging-tg"></a>

To help you manage and organize your system instances, you can optionally assign your own metadata to each of these resources in the form of tags\. 

This topic describes tags and shows you how to create them\.

## Tag Basics<a name="tagging-tg-basics"></a>

Tags enable you to categorize your AWS IoT Things Graph resources in different ways, for example, by purpose, owner, or environment\. This is useful when you have many resources of the same type—you can quickly identify a specific resource based on the tags you've assigned to it\. 

Each tag consists of a key and optional value, both of which you define\. For example, you could define a set of tags for your system instances that helps you track them by location\. We recommend that you create a set of tag keys that meets your needs for each kind of resource\. Using a consistent set of tag keys makes it easier for you to manage your resources\.

The Tag Editor in the AWS Management Console provides a central, unified way to create and manage your tags\. For more information, see [Working with Tag Editor](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/tag-editor.html) in [ Working with the AWS Management Console](http://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.

You can also work with tags by using the AWS CLI and the AWS IoT Things Graph API\. You can associate tags with system instances when you create them by using the "`Tags`" field in the following command: 
+ [CreateSystemInstance](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateSystemInstance.html)

You can add, modify, or delete tags for existing resources that support tagging by using the following commands:
+ [TagResource](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_TagResource.html)
+ [ListTagsForResource](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_ListTagsForResource.html)
+ [UntagResource](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_UntagResource.html)

You should know the following\.
+ You can edit tag keys and values, and you can remove tags from a resource at any time\.
+ You can set the value of a tag to an empty string, but you can't set the value of a tag to null\.
+ If you add a tag that has the same key as an existing tag on that resource, the new value overwrites the old value\.
+ If you delete a resource, any tags associated with the resource are also deleted\.

For more information, see [AWS Tagging Strategies](https://aws.amazon.com/answers/account-management/aws-tagging-strategies/)\.

### Tag Restrictions and Limitations<a name="tagging-iot-restrict"></a>

The following basic restrictions apply to tags:
+ Maximum number of tags per resource – 50\.
+ Maximum key length – 127 Unicode characters in UTF\-8\.
+ Maximum value length – 255 Unicode characters in UTF\-8

  \.
+ Tag keys and values are case sensitive\.
+ Don't use the "`aws:`" prefix in your tag names or values because it's reserved for AWS use\. You can't edit or delete tag names or values with this prefix\. Tags with this prefix don't count against your tags per resource limit\.
+ If your tagging schema is used across multiple services and resources, remember that other services might have restrictions on allowed characters\. Generally, allowed characters are letters \(uppercase and lowercase\), spaces, and numbers that can be represented in UTF\-8, and the following special characters: \+ \- = \. \_ : / @ 

## Using Tags with IAM Policies<a name="tagging-tg-iam"></a>

You can apply tag\-based resource\-level permissions in the IAM policies you use for AWS IoT API actions\. This gives you better control over what resources a user can create, modify, or use\. 

You use the `Condition` element \(also called the `Condition` block\) with the following condition context keys and values in an IAM policy to control user access \(permissions\) based on a resource's tags: 
+ `aws:ResourceTag/tag-key: tag-value` – Allow or deny user actions on resources with specific tags\.
+ `aws:RequestTag/tag-key: tag-value` – Require that a specific tag be used \(or not used\) when making an API request to create or modify a resource that allows tags\.
+ `aws:TagKeys: [tag-key, ...]` – Require that a specific set of tag keys be used \(or not used\) when making an API request to create or modify a resource that allows tags\.

**Note**  
The condition context keys and values in an IAM policy apply only to those AWS IoT actions where an identifier for a resource that's capable of being tagged is a required parameter\. For example, the use of [CreateFlowTemplate](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateFlowTemplate.html) will not be allowed or denied on the basis of condition context keys and values, because no taggable resource \(thing groups, thing types, topic rules, jobs, or security profile\) is referenced in this request\.

[Controlling Access Using Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the *AWS Identity and Access Management User Guide* has additional information about using tags\. The [IAM JSON Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) section of that guide has detailed syntax, descriptions, and examples of the elements, variables, and evaluation logic of JSON policies in IAM\.

The following example policy applies two tag\-based restrictions\. An IAM user restricted by this policy cannot do the following:
+ Give a resource the tag "`env=prod`" \(in the example, see the line `"aws:RequestTag/env" : "prod"`\)
+ Modify or access a resource that has an existing tag "`env=prod`" \(in the example, see the line `"aws:ResourceTag/env" : "prod"`\)

```
{
    "Version" : "2012-10-17",
    "Statement" : [
        {
          "Effect" : "Deny",
          "Action" : "iotthingsgraph:*",
          "Resource" : "*",
          "Condition" : {
            "StringEquals" : {
              "aws:RequestTag/env" : "prod"
            }
          }
        },
        {
          "Effect" : "Deny",
          "Action" : "iotthingsgraph:*",
          "Resource" : "*",
          "Condition" : {
            "StringEquals" : {
              "aws:ResourceTag/env" : "prod"
            }
          }
        },
        {
          "Effect": "Allow",
          "Action": [
            "iotthingsgraph:*"
          ],
          "Resource": "*"
        }
    ]
}
```

You can also specify multiple tag values for a given tag key by enclosing them in a list, as shown\. 

```
            "StringEquals" : {
              "aws:ResourceTag/env" : ["dev", "test"]
            }
```

**Note**  
If you use tags to allow or deny users access to resources, you must consider explicitly denying users the ability to add those tags to or remove them from the same resources\. Otherwise, a user could circumvent your restrictions and gain access to a resource by modifying its tags\.
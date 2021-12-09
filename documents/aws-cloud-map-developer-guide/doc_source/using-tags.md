# Tagging your AWS Cloud Map resources<a name="using-tags"></a>

To help you manage your AWS Cloud Map resources, you can assign your own metadata to each resource in the form of *tags*\. This topic describes tags and shows you how to create them\.

**Topics**
+ [Tag basics](#tag-basics)
+ [Tagging your resources](#tag-resources)
+ [Tag restrictions](#tag-restrictions)
+ [Working with tags using the CLI or API](#tag-resources-api-sdk)

## Tag basics<a name="tag-basics"></a>

A tag is a label that you assign to an AWS resource\. Each tag consists of a *key* and an optional *value*, both of which you define\.

Tags enable you to categorize your AWS resources by, for example, purpose, owner, or environment\. When you have many resources of the same type, you can quickly identify a specific resource based on the tags you've assigned to it\. For example, you can define a set of tags for your AWS Cloud Map services to help you track each service's owner and stack level\. We recommend that you devise a consistent set of tag keys for each resource type\.

Tags are not automatically assigned to your resources\. After you add a tag, you can edit tag keys and values or remove tags from a resource at any time\. If you delete a resource, any tags for the resource are also deleted\.

Tags don't have any semantic meaning to AWS Cloud Map and are interpreted strictly as a string of characters\. You can set the value of a tag to an empty string, but you can't set the value of a tag to null\. If you add a tag that has the same key as an existing tag on that resource, the new value overwrites the old value\.

You can work with tags using the AWS CLI, and the AWS Cloud Map API\.

If you're using AWS Identity and Access Management \(IAM\), you can control which users in your AWS account have permission to create, edit, or delete tags\.

## Tagging your resources<a name="tag-resources"></a>

You can tag new or existing AWS Cloud Map namespaces and services\.\.

If you're using the AWS Cloud Map API, the AWS CLI, or an AWS SDK, you can apply tags to new resources using the `tags` parameter on the relevant API action or to existing resources using the `TagResource` API action\. For more information, see [TagResource](https://docs.aws.amazon.com/cloud-map/latest/api/API_TagResource.html)\.

Some resource\-creating actions enable you to specify tags for a resource when the resource is created\. If tags cannot be applied during resource creation, the resource creation process fails\. This ensures that resources you intended to tag on creation are either created with specified tags or not created at all\. If you tag resources at the time of creation, you don't need to run custom tagging scripts after resource creation\.

The following table describes the AWS Cloud Map resources that can be tagged, and the resources that can be tagged on creation\.


**Tagging support for AWS Cloud Map resources**  

| Resource | Supports tags | Supports tag propagation | Supports tagging on creation \(AWS Cloud Map API, AWS CLI, AWS SDK\) | 
| --- | --- | --- | --- | 
|  AWS Cloud Map namespaces  |  Yes  | No\. Namespace tags do not propagate to any other resources associated with the namespace\. |  Yes  | 
|  AWS Cloud Map services  |  Yes  | No\. Service tags do not propagate to any other resources associated with the service\. |  Yes  | 

## Tag restrictions<a name="tag-restrictions"></a>

The following basic restrictions apply to tags:
+ Maximum number of tags per resource – 50
+ For each resource, each tag key must be unique, and each tag key can have only one value\.
+ Maximum key length – 128 Unicode characters in UTF\-8
+ Maximum value length – 256 Unicode characters in UTF\-8
+ If your tagging schema is used across multiple AWS services and resources, remember that other services may have restrictions on allowed characters\. Generally allowed characters are letters, numbers, spaces representable in UTF\-8, and the following characters: \+ \- = \. \_ : / @\.
+ Tag keys and values are case sensitive\.
+ Don't use `aws:`, `AWS:`, or any upper or lowercase combination of such as a prefix for either keys or values, as it is reserved for AWS use\. You can't edit or delete tag keys or values with this prefix\. Tags with this prefix do not count against your tags\-per\-resource limit\.

## Working with tags using the CLI or API<a name="tag-resources-api-sdk"></a>

Use the following AWS CLI commands or AWS Cloud Map API operations to add, update, list, and delete the tags for your resources\.


**Tagging support for AWS Cloud Map resources**  

| Task | API action | AWS CLI | AWS Tools for Windows PowerShell | 
| --- | --- | --- | --- | 
|  Add or overwrite one or more tags\.  |  [TagResource](https://docs.aws.amazon.com/cloud-map/latest/api/API_TagResource.html)  |  [tag\-resource](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/tag-resource.html)  |  [Add\-SDResourceTag](https://docs.aws.amazon.com/powershell/latest/reference/items/Add-SDResourceTag.html)  | 
|  Delete one or more tags\.  |  [UntagResource](https://docs.aws.amazon.com/cloud-map/latest/api/API_UntagResource.html)  |  [untag\-resource](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/untag-resource.html)  |  [Remove\-SDResourceTag](https://docs.aws.amazon.com/powershell/latest/reference/items/Remove-SDResourceTag.html)  | 
| List tags for a resource |  [ListTagsForResource](https://docs.aws.amazon.com/cloud-map/latest/api/API_ListTagsForResource.html)  |  [list\-tags\-for\-resource](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/list-tags-for-resource.html)  |  [Get\-SDResourceTag](https://docs.aws.amazon.com/powershell/latest/reference/items/Get-SDResourceTag.html)  | 

The following examples show how to tag or untag resources using the AWS CLI\.

**Example 1: Tag an existing resource**  
The following command tags an existing resource\.

```
aws servicediscovery tag-resource --resource-arn resource_ARN --tags team=devs
```

**Example 2: Untag an existing resource**  
The following command deletes a tag from an existing resource\.

```
aws servicediscovery untag-resource --resource-arn resource_ARN --tag-keys tag_key
```

**Example 3: List tags for a resource**  
The following command lists the tags associated with an existing resource\.

```
aws servicediscovery list-tags-for-resource --resource-arn resource_ARN
```

Some resource\-creating actions enable you to specify tags when you create the resource\. The following actions support tagging on creation\.


| Task | API action | AWS CLI | AWS Tools for Windows PowerShell | 
| --- | --- | --- | --- | 
| Create an HTTP namespace | [CreateHttpNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateHttpNamespace.html) | [create\-http\-namespace](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/create-http-namespace.html) | [New\-SDHttpNamespace](https://docs.aws.amazon.com/powershell/latest/reference/items/New-SDHttpNamespace.html) | 
| Create a private namespace based on DNS | [CreatePrivateDnsNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreatePrivateDnsNamespace.html) | [create\-private\-dns\-namespace](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/create-private-dns-namespace.html) | [New\-SDPrivateDnsNamespace](https://docs.aws.amazon.com/powershell/latest/reference/items/New-SDPrivateDnsNamespace.html) | 
| Create a public namespace based on DNS | [CreatePublicDnsNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreatePublicDnsNamespace.html) | [create\-public\-dns\-namespace](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/create-public-dns-namespace.html) | [New\-SDPublicDnsNamespace](https://docs.aws.amazon.com/powershell/latest/reference/items/New-SDPublicDnsNamespace.html) | 
| Create a service | [CreateService](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateService.html) | [create\-service](https://docs.aws.amazon.com/cli/latest/reference/servicediscovery/create-service.html) | [New\-SDService](https://docs.aws.amazon.com/powershell/latest/reference/items/New-SDService.html) | 
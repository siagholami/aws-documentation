# Tagging your AWS IoT SiteWise resources<a name="tag-resources"></a>

With tags, you can organize and manage your resources in AWS IoT SiteWise\. You can use tags to assign metadata to your resources, and you can use tags in IAM policies to define conditional access to your resources\.

## Using tags in AWS IoT SiteWise<a name="tag-basics"></a>

You can use tags to categorize your AWS IoT SiteWise resources by purpose, owner, environment, or any other classification for your use case\. When you have many resources of the same type, you can quickly identify a specific resource based on its tags\.

Each tag consists of a key and an optional value, both of which you define\. For example, you could define a set of tags for your asset models that helps you track them by the industrial processes to which assets of each model contribute\. We recommend that you create a set of tag keys that meets your needs for each kind of resource\. By using a consistent set of tag keys, you can more easily manage your resources\.

### Tagging with the AWS Management Console<a name="tags-console"></a>

The **Tag Editor** in the AWS Management Console provides a central, unified way for you to create and manage your tags for resources from all AWS services\. For more information, see [Tag Editor](https://docs.aws.amazon.com/ARG/latest/userguide/tag-editor.html) in the *AWS Resource Groups User Guide*\.

### Tagging with the AWS IoT SiteWise API<a name="tags-api"></a>

You can also work with tags by using the AWS IoT SiteWise API\. Before you create tags, be aware of tagging restrictions\. For more information, see [Tag naming and usage conventions](https://docs.aws.amazon.com/general/latest/gr/aws_tagging.html#tag-conventions) in the *AWS General Reference*\.
+ To add tags when you create a resource, define them in the `tags` property of the resource\.
+ To add tags to an existing resource, or to update tag values, use the [TagResource](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_TagResource.html) operation\.
+ To remove tags from a resource, use the [UntagResource](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UntagResource.html) operation\.
+ To retrieve the tags that are associated with a resource, use the [ListTagsForResource](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListTagsForResource.html) operation, or describe the resource and inspect its `tags` property\.

The following table lists resources you can tag using the AWS IoT SiteWise API and their corresponding `Create` and `Describe` operations\.


**Taggable AWS IoT SiteWise resources**  

| Resource | Create operation | Describe operation | 
| --- | --- | --- | 
| Asset model | [CreateAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAssetModel.html) | [DescribeAssetModel](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAssetModel.html) | 
| Asset | [CreateAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAsset.html) | [DescribeAsset](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAsset.html) | 
| Gateway | [CreateGateway](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateGateway.html) | [DescribeGateway](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeGateway.html) | 
| Portal | [CreatePortal](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreatePortal.html) | [DescribePortal](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribePortal.html) | 
| Project | [CreateProject](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateProject.html) | [DescribeProject](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeProject.html) | 
| Dashboard | [CreateDashboard](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateDashboard.html) | [DescribeDashboard](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeDashboard.html) | 
| Access policy | [CreateAccessPolicy](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAccessPolicy.html) | [DescribeAccessPolicy](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribeAccessPolicy.html) | 

Use the following operations to view and manage tags for resources that support tagging:
+ [TagResource](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_TagResource.html) – Adds tags to a resource, or updates an existing tag's value\.
+ [ListTagsForResource](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListTagsForResource.html) – Lists the tags for a resource\.
+ [UntagResource](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UntagResource.html) – Removes tags from a resource\.

You can add or remove tags for a resource at any time\. To change the value of a tag key, add a tag to the reosurce that defines the same key and the new value\. The new value replaces the old value\. You can set a value to an empty string, but you can't set a value to null\.

When you delete a resource, tags that are associated with that resource are also deleted\.

## Using tags with IAM policies<a name="tags-iam"></a>

In your IAM policies, you can use resource tags to control user access and permissions\. For example, policies can allow users to create only those resources that have a specific tag\. Policies can also restrict users from creating or modifying resources that have certain tags\.

**Note**  
If you use tags to allow or deny users' access to resources, you should deny users the ability to add or remove those tags for the same resources\. Otherwise, a user could circumvent your restrictions and gain access to a resource by modifying its tags\.

You can use the following condition context keys and values in the `Condition` element \(also called the `Condition` block\) of a policy statement\.

`iotsitewise:ResourceTag/tag-key: tag-value`  
Allow or deny actions on resources with specific tags\.

`aws:RequestTag/tag-key: tag-value`  
Require that a specific tag be used \(or not used\) when creating or modifying a taggable resource\.

`aws:TagKeys: [tag-key, ...]`  
Require that a specific set of tag keys be used \(or not used\) when creating or modifying a taggable resource\.

**Note**  
The condition context keys and values in an IAM policy apply only to actions that have a taggable resource as a required parameter\. For example, you can set tag\-based conditional access for [ListAssets](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_ListAssets.html)\. You can't set tag\-based conditional access on [PutLoggingOptions](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_PutLoggingOptions.html) because no taggable resource is referenced in the request\.

For more information, see [Controlling access to AWS resources using resource tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) and [IAM JSON policy reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

**Example IAM policies using tags**
+ [Viewing AWS IoT SiteWise assets based on tags](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-view-asset-tags)
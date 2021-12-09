# Using AWS CloudFormation StackSets<a name="using-stacksets"></a>

**Note**  
 This feature is currently in beta mode\. AutoTags are not currently supported with AWS CloudFormation StackSets\. 

You can use AWS CloudFormation StackSets to launch AWS Service Catalog products across multiple regions and accounts\. You can specify the order in which products deploy sequentially within regions\. Across accounts, products are deployed in parallel\. When launching, users can specify failure tolerance and the maximum number of accounts in which to deploy in parallel\. For more information, see [Working with AWS CloudFormation StackSets](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/what-is-cfnstacksets.html)\.

## Stack sets vs\. stack instances<a name="stacksets-vs-stack-instances"></a>

A *stack* lets you create stacks in AWS accounts across regions by using a single AWS CloudFormation template\.

A *stack instance* refers to a stack in a target account within a region and is associated with only one stack set\.

For more information, see [StackSets Concepts](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacksets-concepts.html)\.

## Stack set constraints<a name="stackset-constraints"></a>

In AWS Service Catalog, you can use stack set constraints to configure product deployment options\.

For more information, see [AWS Service Catalog Stack Set Constraints](constraints-stackset.md)\.
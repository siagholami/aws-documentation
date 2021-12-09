# What is AWS Resource Groups?<a name="welcome"></a>

You can use *resource groups* to organize your AWS resources\. Resource groups make it easier to manage and automate tasks on large numbers of resources at one time\. This guide shows you how to create and manage resource groups in AWS Resource Groups\.

You can access Resource Groups through any of the following entry points\.
+ On the navigation bar of the [AWS Management Console](https://console.aws.amazon.com/console/home)\.
+ In the AWS Systems Manager console, from the left navigation pane entry for Resource Groups\.
+ By using the Resource Groups API, in AWS CLI commands or AWS SDK programming languages\.

**To work with resource groups on the AWS Management Console home**

1. Sign in to the AWS Management Console\.

1. On the navigation bar, choose **Resource Groups**\.  
![\[AWS Management Console home with Resource Groups menu open.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-entry-consolehome.png)

1. Choose a resource group from **Saved Groups**, or choose **Create a Group**\.

## What are resource groups?<a name="resource-groups-intro"></a>

In AWS, a *resource* is an entity that you can work with\. Examples include an Amazon EC2 instance, an AWS CloudFormation stack, or an Amazon S3 bucket\. If you work with multiple resources, you might find it useful to manage them as a group rather than move from one AWS service to another for each task\. If you manage large numbers of related resources, such as EC2 instances that make up an application layer, you likely need to perform bulk actions on these resources at one time\. Examples of bulk actions include:
+ Applying updates or security patches\.
+ Upgrading applications\.
+ Opening or closing ports to network traffic\.
+ Collecting specific log and monitoring data from your fleet of instances\.

A *resource group* is a collection of AWS resources that are all in the same AWS region, and that match criteria provided in a query\. In Resource Groups, there are two types of queries on which you can build a group\. Both query types include resources that are specified in the format `AWS::service::resource`\.
+ **Tag\-based**

  Tag\-based queries include lists of resources and tags\. *Tags* are keys that help identify and sort your resources within your organization\. Optionally, tags include values for keys\.
**Important**  
Do not store personally identifiable information \(PII\) or other confidential or sensitive information in tags\. We use tags to provide you with billing and administration services\. Tags are not intended to be used for private or sensitive data\.
+ **AWS CloudFormation stack\-based**

  In an AWS CloudFormation stack\-based query, you choose an AWS CloudFormation stack in your account in the current region, and then choose resource types within the stack that you want to be in the group\. You can base your query on only one AWS CloudFormation stack\.

Resource groups can be *nested*; a resource group can contain existing resource groups in the same region\.

### Use cases for resource groups<a name="resource-groups-intro-usecases"></a>

By default, the AWS Management Console is organized by AWS service\. But with Resource Groups, you can create a custom console that organizes and consolidates information based on criteria specified in tags, or the resources in an AWS CloudFormation stack\. The following list describes some of the cases in which resource grouping can help organize your resources\.
+ An application that has different phases, such as development, staging, and production\.
+ Projects managed by multiple departments or individuals\.
+ A set of AWS resources that you use together for a common project or that you want to manage or monitor as a group\.
+ A set of resources related to applications that run on a specific platform, such as Android or iOS\.

For example, you are developing a web application, and you are maintaining separate sets of resources for your alpha, beta, and release stages\. Each version runs on Amazon EC2 with an Amazon Elastic Block Store storage volume\. You use Elastic Load Balancing to manage traffic and Route 53 to manage your domain\. Without Resource Groups, you might have to access multiple consoles just to check the status of your services or modify the settings for one version of your application\.

With Resource Groups, you use a single page to view and manage your resources\. For example, let’s say you use the tool to create a resource group for each version—alpha, beta, and release—of your application\. To check your resources for the alpha version of your application, open your resource group\. Then view the consolidated information on your resource group page\. To modify a specific resource, choose the resource's links on your resource group page to access the service console that has the settings that you need\.

## AWS Resource Groups and permissions<a name="how-resourcegroups-works"></a>

Resource Groups feature permissions are at the account level\. As long as users who are sharing your account have the correct IAM permissions, they can work with resource groups that you create\. For information about creating IAM users, see [Creating an IAM User](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_SettingUpUser.html) in the *IAM User Guide*\.

Tags are properties of a resource, so they are shared across your entire account\. Users in a department or specialized group can draw from a common vocabulary \(tags\) to create resource groups that are meaningful to their roles and responsibilities\. Having a common pool of tags also means that when users share a resource group, they don't have to worry about missing or conflicting tag information\.

## AWS Resource Groups resources<a name="resourcegroups-arns"></a>

In Resource Groups, the only available resource is a group\. Groups have unique Amazon Resource Names \(ARNs\) associated with them\. For more information about ARNs, see [Amazon Resource Names \(ARN\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html) in the *Amazon Web Services General Reference*\.


|  Resource Type  |  ARN Format  | 
| --- | --- | 
|  Resource Group  |  `arn:aws:resource-groups:region:account:group/group-name`  | 

## How tagging works<a name="how-tagging-works"></a>

Tags are key and value pairs that act as metadata for organizing your AWS resources\. With most AWS resources, you have the option of adding tags when you create the resource, whether it's an Amazon EC2 instance, an Amazon S3 bucket, or other resource\. However, you can also add tags to multiple, supported resources at once by using Tag Editor\. You build a query for resources of various types, and then add, remove, or replace tags for the resources in your search results\. Tag\-based queries assign an `AND` operator to tags, so any resource that matches the specified resource types and all specified tags is returned by the query\.

**Important**  
Do not store personally identifiable information \(PII\) or other confidential or sensitive information in tags\. We use tags to provide you with billing and administration services\. Tags are not intended to be used for private or sensitive data\.

For more information about tagging, see [Tag Editor](tag-editor.md) in this guide\. You can tag [supported resources](supported-resources.md) by using Tag Editor, and some additional resources by using tagging functionality in the service console in which you create and manage the resource\.
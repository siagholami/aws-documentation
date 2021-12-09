# Using Identity\-Based Policies \(IAM Policies\) for AWS Cloud Map<a name="access-control-managing-permissions"></a>

This topic provides examples of identity\-based policies that demonstrate how an account administrator can attach permissions policies to IAM identities \(users, groups, and roles\) and thereby grant permissions to perform actions on AWS Cloud Map resources\.

**Important**  
We recommend that you first review the introductory topics that explain the basic concepts and options to manage access to your AWS Cloud Map resources\. For more information, see [Overview of Managing Access Permissions to Your AWS Cloud Map Resources](access-control-overview.md)\. 

**Topics**
+ [Permissions Required to Use the AWS Cloud Map Console](#console-required-permissions)
+ [AWS Managed \(Predefined\) Policies for AWS Cloud Map](#access-policy-examples-aws-managed)
+ [Customer Managed Policy Examples](#access-policy-examples-for-sdk-cli)

The following example shows a permissions policy that grants a user permission to register, deregister, and register service instances\. The `Sid`, or statement ID, is optional:

```
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Sid" : "AllowInstancePermissions",
         "Effect": "Allow",
         "Action": [
            "servicediscovery:RegisterInstance",
            "servicediscovery:DeregisterInstance",
            "servicediscovery:DiscoverInstances",
            "servicediscovery:Get*",
            "servicediscovery:List*",
            "route53:GetHostedZone",
            "route53:ListHostedZonesByName",
            "route53:ChangeResourceRecordSets",
            "route53:CreateHealthCheck",
            "route53:GetHealthCheck",
            "route53:DeleteHealthCheck",
            "route53:UpdateHealthCheck"
         ],
         "Resource": "*"
      }
   ]
}
```

The policy grants permissions to the actions that are required to register and manage service instances\. The Route 53 permission is required if you're using public or private DNS namespaces because AWS Cloud Map creates, updates, and deletes Route 53 records and health checks when you register and deregister instances\. The wildcard character \(\*\) in `Resource` grants access to all AWS Cloud Map instances, and Route 53 records and health checks that are owned by the current AWS account\. 

For a list of actions and the ARN that you specify to grant or deny permission to use each action, see [AWS Cloud Map API Permissions: Actions, Resources, and Conditions Reference](cloud-map-api-permissions-ref.md)\.

## Permissions Required to Use the AWS Cloud Map Console<a name="console-required-permissions"></a>

To grant full access to the AWS Cloud Map console, you grant the permissions in the following permissions policy: 

```
{
   "Version": "2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action":[
            "servicediscovery:*",
            "route53:GetHostedZone",
            "route53:ListHostedZonesByName",
            "route53:CreateHostedZone",
            "route53:DeleteHostedZone",
            "route53:ChangeResourceRecordSets",
            "route53:CreateHealthCheck",
            "route53:GetHealthCheck",
            "route53:DeleteHealthCheck",
            "route53:UpdateHealthCheck",
            "ec2:DescribeVpcs",
            "ec2:DescribeRegions"
         ],
         "Resource":"*"
      }
   ]
}
```

Here's why the permissions are required:

**`servicediscovery:*`**  
Lets you perform all AWS Cloud Map actions\.

**`route53:CreateHostedZone`, `route53:GetHostedZone`, `route53:ListHostedZonesByName`, `route53:DeleteHostedZone`**  
Lets AWS Cloud Map manage hosted zones when you create and delete public and private DNS namespaces\.

**`route53:CreateHealthCheck`, `route53:GetHealthCheck`, `route53:DeleteHealthCheck`, `route53:UpdateHealthCheck`**  
Lets AWS Cloud Map manage health checks when you include Amazon Route 53 health checks when you create a service\.

**`ec2:DescribeVpcs` and `ec2:DescribeRegions`**  
Let AWS Cloud Map manage private hosted zones\.

## AWS Managed \(Predefined\) Policies for AWS Cloud Map<a name="access-policy-examples-aws-managed"></a>

AWS addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. These AWS managed policies grant necessary permissions for common use cases so that you can avoid having to investigate what permissions are needed\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\. For AWS Cloud Map, IAM provides the following managed policies: 
+ **AWSCloudMapDiscoverInstanceAccess** – Grants access to the AWS Cloud Map [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) API action
+ **AWSCloudMapReadOnlyAccess** – Grants read\-only access to all AWS Cloud Map actions
+ **AWSCloudMapRegisterInstanceAccess** – Grants read\-only access to namespaces and services, and grants permission to register and deregister service instances
+ **AWSCloudMapFullAccess** – Provides full access to all AWS Cloud Map actions

**Note**  
You can review these permissions policies by signing in to the IAM console and searching for specific policies there\. You can also create your own custom IAM policies to allow permissions for AWS Cloud Map API actions\. You can attach these custom policies to the IAM users or groups that require those permissions\.

## Customer Managed Policy Examples<a name="access-policy-examples-for-sdk-cli"></a>

You can create your own custom IAM policies to allow permissions for AWS Cloud Map actions\. You can attach these custom policies to the IAM users or groups that require the specified permissions\. These policies work when you are using the AWS Cloud Map API, the AWS SDKs, or the AWS CLI\. The following examples show permissions for several common use cases\. For the policy that grants a user full access to AWS Cloud Map, see [Permissions Required to Use the AWS Cloud Map Console](#console-required-permissions)\.

**Topics**
+ [Example 1: Allow Read Access to All AWS Cloud Map Resources](#access-policy-example-allow-read-hosted-zones)
+ [Example 2: Allow Creation of All Types of Namespaces](#access-policy-example-allow-create-delete-hosted-zones)

### Example 1: Allow Read Access to All AWS Cloud Map Resources<a name="access-policy-example-allow-read-hosted-zones"></a>

The following permissions policy grants the user read\-only access to all AWS Cloud Map resources:

```
{
   "Version": "2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action":[
            "servicediscovery:Get*",
            "servicediscovery:List*",
            "servicediscovery:DiscoverInstances"

         ],
         "Resource":"*"
      }
   ]
}
```

### Example 2: Allow Creation of All Types of Namespaces<a name="access-policy-example-allow-create-delete-hosted-zones"></a>

The following permissions policy allows users to create all types of namespaces: 

```
{
   "Version": "2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action":[
            "servicediscovery:CreateHttpNamespace",
            "servicediscovery:CreatePrivateDnsNamespace",
            "servicediscovery:CreatePublicDnsNamespace",
            "route53:CreateHostedZone",
            "route53:GetHostedZone",
            "route53:ListHostedZonesByName",
            "ec2:DescribeVpcs",
            "ec2:DescribeRegions"
         ],
         "Resource":"*"
      }
   ]
}
```
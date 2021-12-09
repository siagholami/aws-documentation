# Authentication and Access control for AWS IoT 1\-Click<a name="1click-authentication"></a>

Access to AWS IoT 1\-Click APIs requires credentials\. Those credentials must have permissions to access AWS resources, such as an AWS IoT 1\-Click project or device\. The following sections provide details on how you can use AWS Identity and Access Management \(IAM\) and AWS IoT 1\-Click to help secure access to your resources\.

 Every AWS resource is owned by an AWS account, and permissions to create or access a resource are governed by permissions policies\. An account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\), and some services \(such as AWS Lambda\) also support attaching permissions policies to resources\. When granting permissions, the administrator decides who is getting the permissions, the resources they get permissions for, and the specific actions that they want to allow on those resources\. 

## AWS IoT 1\-Click Resources and Operations<a name="1click-iam-resources"></a>

In AWS IoT 1\-Click, the primary resources are projects and devices\. In a policy, you use an Amazon Resource Name \(ARN\) to identify the resource that the policy applies to\. These resources have unique Amazon Resource Names \(ARNs\) associated with them, as shown in the following table\.


****  

| Resource Type | ARN Format | 
| --- | --- | 
| Device | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| Project | arn:aws:iot1click:region:account\-id:projects/project\-name | 

AWS IoT 1\-Click implements APIs to work with AWS IoT 1\-Click resources\. These are referred to as Actions in IAM\. For a list of available operations, see the table at the end of this topic\.

## Using Identity\-Based Policies \(IAM Policies\) for AWS IoT 1\-Click<a name="1click-iam-policies"></a>

This topic provides examples of identity\-based policies that demonstrate how an account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\) and thereby grant permissions to perform operations on AWS IoT 1\-Click resources\.

The following shows an example of a permissions policy\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iot1click:CreateProject"
            ],
            "Resource": "*"
        }
    ]
}
```

The policy has one statement \- which grants permissions for one AWS IoT 1\-Click action \(`iot1click:CreateProject`\) on a resource using the Amazon Resource Name \(ARN\) for the application\. The ARN in this case specifies a wildcard character \(\*\) to indicate that the permission is granted for any resource\.

For a table showing all of the AWS IoT 1\-Click API operations and the resources that they apply to, see [AWS IoT 1\-Click API Permissions: Actions, Permissions, and Resources Reference](#1click-ac)\.

### AWS Managed \(Predefined\) Policies for AWS IoT 1\-Click<a name="1click-iam-managed-policies"></a>

Amazon Web Services addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. These AWS managed policies grant necessary permissions for common use cases so that you can avoid having to investigate what permissions are needed\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\.

The following AWS managed policies, which you can attach to users in your account, are specific to AWS IoT 1\-Click and are grouped by use case scenario:
+ `AWSIoT1ClickFullAccess`: Grants full access to AWS IoT 1\-Click resources by using the AWS Management Console\. The granted permissions include all AWS IoT 1\-Click actions to manage devices and projects\.
+ `AWSIoT1ClickReadOnlyAccess`: Grants read\-only access to AWS IoT 1\-Click resources by using the AWS Management Console\. This access enables a user to list AWS IoT 1\-Click devices and projects, and to review project configuration\.

**Note**  
You can review these permission policies by signing in to the IAM Console \([https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\) and searching for the specific policy name\(s\) there\.

You can also create your own custom IAM policies to allow permissions for AWS IoT 1\-Click actions and resources\. You can attach these custom policies to the IAM users or groups that require those permissions\.

#### AWS IoT 1\-Click API Permissions: Actions, Permissions, and Resources Reference<a name="1click-ac"></a>

When you are setting up Access Control in the AWS Cloud and writing a permissions policy that you can attach to an IAM identity \(identity\-based policies\), you can use the following table as a reference\. The table lists each AWS IoT 1\-Click API operation, the corresponding actions for which you can grant permissions to perform the action, and the AWS resource for which you can grant the permissions\. You specify the actions in the policy's `Action` field, and you specify the resource value in the policy's `Resource` field\.

You can use AWS\-wide condition keys in your AWS IoT 1\-Click policies to express conditions\. For a complete list of AWS\-wide keys, see [Available Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\.

**Note**  
To specify an action, use the `iot1click:` prefix followed by the API operation name \(for example, `iot1click:ListProjects`\)\.


****  

|  **IoT 1\-Click Operations**  |  **Required Permissions \(API Actions\)**  | Resources | 
| --- | --- | --- | 
| ListDevices | iot1click:ListDevices | \* | 
| DescribeDevice | iot1click:DescribeDevice | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| GetDeviceMethods | iot1click:GetDeviceMethods | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| UpdateDeviceState | iot1click:UpdateDeviceState | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| InvokeDeviceMethod | iot1click:InvokeDeviceMethod | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| ListDeviceEvents | iot1click:ListDeviceEvents | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| InitializeDeviceClaim | iot1click:InitializeDeviceClaim | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| FinalizeDeviceClaim | iot1click:FinalizeDeviceClaim | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| UnclaimDevice | iot1click:UnclaimDevice | arn:aws:iot1click:region:account\-id:devices/device\-id | 
| ClaimDeviceByClaimCode | iot1click:ClaimDeviceByClaimCode | \* | 
| CreateProject | iot1click:CreateProject | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| UpdateProject | iot1click:UpdateProject | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| DescribeProject | iot1click:DescribeProject | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| ListProjects | iot1click:ListProjects | \* | 
| DeleteProject | iot1click:DeleteProject | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| CreatePlacement | iot1click:CreatePlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| UpdatePlacement | iot1click:UpdatePlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| DescribePlacement | iot1click:DescribePlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| ListPlacements | iot1click:ListPlacements | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| DeletePlacement | iot1click:DeletePlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| AssociateDeviceWithPlacement | iot1click:AssociateDeviceWithPlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| DissacociateDeviceFromPlacement | iot1click:DissacociateDeviceFromPlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
| GetDevicesInPlacement | iot1click:GetDevicesInPlacement | arn:aws:iot1click:region:account\-id:projects/project\-name | 
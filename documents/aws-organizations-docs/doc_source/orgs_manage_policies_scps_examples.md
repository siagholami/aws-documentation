# Example service control policies<a name="orgs_manage_policies_scps_examples"></a>

The example [service control policies \(SCPs\)](orgs_manage_policies_scps.md) displayed in this topic are for information purposes only\.

**Before using these examples**  
Before you use these example SCPs in your organization, do the following:  
Carefully review and customize the SCPs for your unique requirements\.
Test your SCPs before using them in a production capacity\. Remember that an SCP affects every user and role and even the root user in every account that it's attached to\. 

**Tip**  
You can use [service last accessed data](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_access-advisor.html) in [IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) to update your SCPs to restrict access to only the AWS services that you need\. For more information, see [Viewing Organizations Service Last Accessed Data for Organizations](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_access-advisor-view-data-orgs.html) in the *IAM User Guide\.* 

Each of the following policies is an example of a [deny list policy](orgs_manage_policies_scps_strategies.md#orgs_policies_denylist) strategy\. Deny list policies must be attached along with other policies that allow the approved actions in the affected accounts\. For example, the default `FullAWSAccess` policy permits the use of all services in an account\. This policy is attached by default to the root, all organizational units \(OUs\), and all accounts\. It doesn't actually grant the permissions; no SCP does\. Instead, it enables administrators in that account to delegate access to those actions by attaching standard AWS Identity and Access Management \(IAM\) permissions policies to users, roles, or groups in the account\. Each of these deny list policies then overrides any policy by blocking access to the specified services or actions\.

**Topics**
+ [General examples](#examples_general)
+ [Example SCPs for AWS Config](#examples_config)
+ [Example SCPs for Amazon CloudWatch](#examples_cloudwatch)
+ [Example SCPs for Amazon Elastic Compute Cloud \(Amazon EC2\)](#examples_ec2)
+ [Example SCPs for Amazon GuardDuty](#examples_guardduty)
+ [Example SCPs for AWS Resource Access Manager](#examples_ram)
+ [Example SCPs for Amazon Virtual Private Cloud \(Amazon VPC\)](#examples_vpc)
+ [Example SCPs for tagging resources](#examples_tagging)

## General examples<a name="examples_general"></a>

### Example: Deny access to AWS based on the requested AWS Region<a name="example-scp-deny-region"></a>

This SCP denies access to any operations outside of the specified Regions\. Replace `eu-central-1` and `eu-west-1` with the AWS Regions you want to use\. It provides exemptions for operations in approved global services\. This example also shows how to exempt requests made by either of two specified administrator roles\. 

**Important**  
If you use AWS Control Tower in your organization, we recommend that you do not use this example policy\. AWS Control Tower works across AWS Regions in a way that is not compatible with this example policy\.

This policy uses the `Deny` effect to deny access to all requests for operations that don't target one of the two approved regions \(`eu-central-1` and `eu-west-1`\)\. The [NotAction](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_notaction.html) element enables you to list services whose operations \(or individual operations\) are exempted from this restriction\. Because global services have endpoints that are physically hosted by the `us-east-1` Region , they must be exempted in this way\. With an SCP structured this way, requests made to global services in the `us-east-1` Region are allowed if the requested service is included in the `NotAction` element\. Any other requests to services in the `us-east-1` Region are denied by this example policy\.

**Note**  
***This example might not include all of the latest global AWS services or operations\.*** Replace the list of services and operations in red italicized text with the global services used by accounts in your organization\.   
You can view the[ service last accessed data in the IAM console](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_access-advisor.html) to determine what global services your organization uses\. The **Access Advisor** tab on the details page for an IAM user, group, or role displays the AWS services that have been used by that entity, sorted by most recent access\. 

**Considerations**  
AWS KMS and AWS Certificate Manager support Regional endpoints\. However, if you want to use them with a global service such as Amazon CloudFront you must include them in the global service exclusion list in the following examle SCP\. A global service like AWS CloudFormation typically requires access to AWS KMS and ACM in the same region, which for a global service is the US East \(N\. Virginia\) Region \(`us-east-1`\)\.
By default, AWS STS is a global service and must be included in the global service exclusion list\. However, you can enable AWS STS to use Region endpoints instead of a single global endpoint\. If you do this, you can remove STS from the global service exemption list in the following example SCP\. For more information see [Managing AWS STS in an AWS Region](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_enable-regions.html)\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "DenyAllOutsideEU",
            "Effect": "Deny",
            "NotAction": [
                "a4b:*",
                "acm:*",
                "aws-marketplace-management:*",
                "aws-marketplace:*",
                "aws-portal:*",
                "awsbillingconsole:*",
                "budgets:*",
                "ce:*",
                "chime:*",
                "cloudfront:*",
                "config:*",
                "cur:*",
                "directconnect:*",
                "ec2:DescribeRegions",
                "ec2:DescribeTransitGateways",
                "ec2:DescribeVpnGateways",
                "fms:*",
                "globalaccelerator:*",
                "health:*",
                "iam:*",
                "importexport:*",
                "kms:*",
                "mobileanalytics:*",
                "networkmanager:*",
                "organizations:*",
                "pricing:*",
                "route53:*",
                "route53domains:*",
                "s3:GetAccountPublic*",
                "s3:ListAllMyBuckets",
                "s3:ListBuckets",
                "s3:PutAccountPublic*",
                "shield:*",
                "sts:*",
                "support:*",
                "trustedadvisor:*",
                "waf-regional:*",
                "waf:*",
                "wafv2:*",
                "wellarchitected:*"
            ],
            "Resource": "*",
            "Condition": {
                "StringNotEquals": {
                    "aws:RequestedRegion": [
                        "eu-central-1",
                        "eu-west-1"
                    ]
                },
                "ArnNotLike": {
                    "aws:PrincipalARN": [
                        "arn:aws:iam::*:role/Role1AllowedToBypassThisSCP",
                        "arn:aws:iam::*:role/Role2AllowedToBypassThisSCP"
                    ]
                }
            }
        }
    ]
}
```

### Example: Prevent IAM principals from making certain changes<a name="example-scp-restricts-iam-principals"></a>

This SCP restricts IAM principals from making changes to the specified IAM role that you created in all accounts in your organization\.

```
{    
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "DenyAccessToASpecificRole",
      "Effect": "Deny",
      "Action": [
        "iam:AttachRolePolicy",
        "iam:DeleteRole",
        "iam:DeleteRolePermissionsBoundary",
        "iam:DeleteRolePolicy",
        "iam:DetachRolePolicy",
        "iam:PutRolePermissionsBoundary",
        "iam:PutRolePolicy",
        "iam:UpdateAssumeRolePolicy",
        "iam:UpdateRole",
        "iam:UpdateRoleDescription"
      ],
      "Resource": [
        "arn:aws:iam::*:role/name-of-role-to-deny"
      ]
    }
  ]
}
```

### Example: Prevent IAM principals from making specified changes, with an exception for a specified admin role<a name="example-scp-restricts-with-exception"></a>

This SCP builds on the previous example to make an exception for administrators\. It prevents IAM principals in accounts from making changes to a common administrative IAM role created in all accounts in your organization *except* for administrators using a specified role\. 

```
{    
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "DenyAccessWithException",
      "Effect": "Deny",
      "Action": [
        "iam:AttachRolePolicy",
        "iam:DeleteRole",
        "iam:DeleteRolePermissionsBoundary",
        "iam:DeleteRolePolicy",
        "iam:DetachRolePolicy",
        "iam:PutRolePermissionsBoundary",
        "iam:PutRolePolicy",
        "iam:UpdateAssumeRolePolicy",
        "iam:UpdateRole",
        "iam:UpdateRoleDescription"
      ],
      "Resource": [
        "arn:aws:iam::*:role/name-of-role-to-deny"
      ],
      "Condition": {
        "StringNotLike": {
          "aws:PrincipalARN":"arn:aws:iam::*:role/name-of-admin-role-to-allow"
        }
      }
    }
  ]
}
```

### Example 10: Require MFA to perform an API action<a name="example-ec2-mfa"></a>

Use an SCP like the following to require that multi\-factor authentication \(MFA\) is enabled before a principal an perform an action\. In this example, the action is to stop an Amazon EC2 instance\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "DenyStopAndTerminateWhenMFAIsNotPresent",
      "Effect": "Deny",
      "Action": [
        "ec2:StopInstances",
        "ec2:TerminateInstances"
      ],
      "Resource": "*",
      "Condition": {"BoolIfExists": {"aws:MultiFactorAuthPresent": false}}
    }
  ]
}
```

### Example: Block service access for the root user<a name="example-ec2-root-user"></a>

The following policy restricts all access to the specified actions for the [root user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_root-user.html) in an account\. If you want to prevent your accounts from using root credentials in specific ways, add your own actions to this policy\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "RestrictEC2ForRoot",
      "Effect": "Deny",
      "Action": [
        "ec2:*"
      ],
      "Resource": [
        "*"
      ],
      "Condition": {
        "StringLike": {
          "aws:PrincipalArn": [
            "arn:aws:iam::*:root"
          ]
        }
      }
    }
  ]
}
```

## Example SCPs for AWS Config<a name="examples_config"></a>

### Example: Prevent users from disabling AWS Config or changing its rules<a name="example_scp_4"></a>

This SCP prevents users or roles in any affected account from running AWS Config operations that could disable AWS Config or alter its rules or triggers\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Deny",
      "Action": [
        "config:DeleteConfigRule",
        "config:DeleteConfigurationRecorder",
        "config:DeleteDeliveryChannel",
        "config:StopConfigurationRecorder"
      ],
      "Resource": "*"
    }
  ]
}
```

## Example SCPs for Amazon CloudWatch<a name="examples_cloudwatch"></a>

### Example: Prevent users from disabling CloudWatch or altering its configuration<a name="example_scp_2"></a>

A lower\-level CloudWatch operator needs to monitor dashboards and alarms\. However, the operator must not be able to delete or change any dashboard or alarm that senior people might put into place\. This SCP prevents users or roles in any affected account from running any of the CloudWatch commands that could delete or change your dashboards or alarms\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Deny",
      "Action": [
        "cloudwatch:DeleteAlarms",
        "cloudwatch:DeleteDashboards",
        "cloudwatch:DisableAlarmActions",
        "cloudwatch:PutDashboard",
        "cloudwatch:PutMetricAlarm",
        "cloudwatch:SetAlarmState"
      ],
      "Resource": "*"
    }
  ]
}
```

## Example SCPs for Amazon Elastic Compute Cloud \(Amazon EC2\)<a name="examples_ec2"></a>

### Example: Require Amazon EC2 instances to use a specific type<a name="example-ec2-instances"></a>

With this SCP, any instance launches not using the `t2.micro` instance type are denied\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "RequireMicroInstanceType",
      "Effect": "Deny",
      "Action": "ec2:RunInstances",
      "Resource": "arn:aws:ec2:*:*:instance/*",
      "Condition": {
        "StringNotEquals":{               	
          "ec2:InstanceType":"t2.micro"
        }
      }
    }
  ]
}
```

## Example SCPs for Amazon GuardDuty<a name="examples_guardduty"></a>

### Example: Prevent users from disabling GuardDuty or modifying its configuration<a name="example_scp_1"></a>

This SCP prevents users or roles in any affected account from disabling GuardDuty or altering its configuration, either directly as a command or through the console\. It effectively enables read\-only access to the GuardDuty information and resources\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [ 
                "guardduty:AcceptInvitation",
                "guardduty:ArchiveFindings",
                "guardduty:CreateDetector",
                "guardduty:CreateFilter",
                "guardduty:CreateIPSet",
                "guardduty:CreateMembers",
                "guardduty:CreatePublishingDestination",
                "guardduty:CreateSampleFindings",
                "guardduty:CreateThreatIntelSet",
                "guardduty:DeclineInvitations",
                "guardduty:DeleteDetector",
                "guardduty:DeleteFilter",
                "guardduty:DeleteInvitations",
                "guardduty:DeleteIPSet",
                "guardduty:DeleteMembers",
                "guardduty:DeletePublishingDestination",
                "guardduty:DeleteThreatIntelSet",
                "guardduty:DisassociateFromMasterAccount",
                "guardduty:DisassociateMembers",
                "guardduty:InviteMembers",
                "guardduty:StartMonitoringMembers",
                "guardduty:StopMonitoringMembers",
                "guardduty:TagResource",
                "guardduty:UnarchiveFindings",
                "guardduty:UntagResource",
                "guardduty:UpdateDetector",
                "guardduty:UpdateFilter",
                "guardduty:UpdateFindingsFeedback",
                "guardduty:UpdateIPSet",
                "guardduty:UpdatePublishingDestination",
                "guardduty:UpdateThreatIntelSet"
            ],      
            "Resource": "*"
        }
    ]
}
```

## Example SCPs for AWS Resource Access Manager<a name="examples_ram"></a>

### Example: Preventing external sharing<a name="example_ram_1"></a>

The following example SCP prevents users from creating resource shares that allow sharing with principals that aren't part of the organization\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "ram:CreateResourceShare",
                "ram:UpdateResourceShare"
            ],
            "Resource": "*",
            "Condition": {
                "Bool": {
                    "ram:RequestedAllowsExternalPrincipals": "true"
                }
            }
        }
    ]
}
```

### Example: Allowing specific accounts to share only specified resource types<a name="example_ram_2"></a>

The following SCP allows accounts `111111111111` and `222222222222` to create resource shares that share prefix lists, and to associate prefix lists with existing resource shares\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "OnlyNamedAccountsCanSharePrefixLists",
            "Effect": "Deny",
            "Action": [
                "ram:AssociateResourceShare",
                "ram:CreateResourceShare"
            ],
            "Resource": "*",
            "Condition": {
                "StringNotEquals": {
                    "aws:PrincipalAccount": [
                        "111111111111",
                        "222222222222"
                    ]
                },
                "StringEquals": {
                    "ram:RequestedResourceType": "ec2:PrefixList"
                }
            }
        }
    ]
}
```

### Example: Prevent sharing with organizations or organizational units \(OUs\)<a name="example_ram_3"></a>

The following SCP prevents users from creating resource shares that share resources with an AWS Organization or OUs\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "ram:CreateResourceShare",
                "ram:AssociateResourceShare"
            ],
            "Resource": "*",
            "Condition": {
                "ForAnyValue:StringLike": {
                    "ram:Principal": [
                        "arn:aws:organizations::*:organization/*",
                        "arn:aws:organizations::*:ou/*"
                    ]
                }
            }
        }
    ]
}
```

### Example: Allow sharing with only specified principals<a name="example_ram_4"></a>

The following example SCP allows users to share resources with *only* organization `o-12345abcdef`, organizational unit `ou-98765fedcba`, and account `111111111111`\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "ram:AssociateResourceShare",
                "ram:CreateResourceShare"
            ],
            "Resource": "*",
            "Condition": {
                "ForAnyValue:StringNotEquals": {
                    "ram:Principal": [
                        "arn:aws:organizations::123456789012:organization/o-12345abcdef",
                        "arn:aws:organizations::123456789012:ou/o-12345abcdef/ou-98765fedcba",
                        "111111111111"
                    ]
                }
            }
        }
    ]
}
```

## Example SCPs for Amazon Virtual Private Cloud \(Amazon VPC\)<a name="examples_vpc"></a>

### Example: Prevent users from deleting Amazon VPC flow logs<a name="example_scp_3"></a>

This SCP prevents users or roles in any affected account from deleting Amazon Elastic Compute Cloud \(Amazon EC2\) flow logs or CloudWatch log groups or log streams\. 

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Deny",
      "Action": [
        "ec2:DeleteFlowLogs",
        "logs:DeleteLogGroup",
        "logs:DeleteLogStream"
      ],
      "Resource": "*"
    }
  ]
 }
```

### Example: Prevent any VPC that doesn't already have internet access from getting it<a name="example_scp_5"></a>

This SCP prevents users or roles in any affected account from changing the configuration of your Amazon EC2 virtual private clouds \(VPCs\) to grant them direct access to the internet\. It doesn't block existing direct access or any access that routes through your on\-premises network environment\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Deny",
      "Action": [
        "ec2:AttachInternetGateway",
        "ec2:CreateInternetGateway",
        "ec2:CreateEgressOnlyInternetGateway",
        "ec2:CreateVpcPeeringConnection",
        "ec2:AcceptVpcPeeringConnection",
        "globalaccelerator:Create*",
        "globalaccelerator:Update*"
      ],
      "Resource": "*"
    }
  ]
}
```

## Example SCPs for tagging resources<a name="examples_tagging"></a>

### Example: Require a tag on specified created resources<a name="example-require-tag-on-create"></a>

The following SCP prevents account principals from creating certain resource types if the request doesn't include the specified tags\. 

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "DenyCreateSecretWithNoProjectTag",
      "Effect": "Deny",
      "Action": "secretsmanager:CreateSecret",
      "Resource": "*",
      "Condition": {
        "Null": {
          "aws:RequestTag/Project": "true"
        }
      }
    },
    {
      "Sid": "DenyRunInstanceWithNoProjectTag",
      "Effect": "Deny",
      "Action": "ec2:RunInstances",
      "Resource": [
        "arn:aws:ec2:*:*:instance/*",
        "arn:aws:ec2:*:*:volume/*"
      ],
      "Condition": {
        "Null": {
          "aws:RequestTag/Project": "true"
        }
      }
    },
    {
      "Sid": "DenyCreateSecretWithNoCostCenterTag",
      "Effect": "Deny",
      "Action": "secretsmanager:CreateSecret",
      "Resource": "*",
      "Condition": {
        "Null": {
          "aws:RequestTag/CostCenter": "true"
        }
      }
    },
    {
      "Sid": "DenyRunInstanceWithNoCostCenterTag",
      "Effect": "Deny",
      "Action": "ec2:RunInstances",
      "Resource": [
        "arn:aws:ec2:*:*:instance/*",
        "arn:aws:ec2:*:*:volume/*"
      ],
      "Condition": {
        "Null": {
          "aws:RequestTag/CostCenter": "true"
        }
      }
    }
  ]
}
```

For a list of all the services and the actions that they support in both AWS Organizations SCPs and IAM permission policies, see [Actions, Resources, and Condition Keys for AWS Services](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_actionsconditions.html) in the *IAM User Guide*\.
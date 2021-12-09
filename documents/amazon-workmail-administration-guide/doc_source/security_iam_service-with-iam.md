# How Amazon WorkMail works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Amazon WorkMail, you should understand what IAM features are available to use with Amazon WorkMail\. To get a high\-level view of how Amazon WorkMail and other AWS services work with IAM, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Amazon WorkMail identity\-based policies](#security_iam_service-with-iam-id-based-policies)
+ [Amazon WorkMail resource\-based policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization based on Amazon WorkMail tags](#security_iam_service-with-iam-tags)
+ [Amazon WorkMail IAM roles](#security_iam_service-with-iam-roles)

## Amazon WorkMail identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Amazon WorkMail supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Amazon WorkMail use the following prefix before the action: `workmail:`\. For example, to grant someone permission to retrieve a list of users with the Amazon WorkMail `ListUsers` API operation, you include the `workmail:ListUsers` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Amazon WorkMail defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "workmail:ListUsers",
      "workmail:DeleteUser"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `List`, include the following action:

```
"Action": "workmail:List*"
```



To see a list of Amazon WorkMail actions, see [Actions defined by Amazon WorkMail](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonworkmail.html#amazonworkmail-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

Amazon WorkMail supports resource\-level permissions for Amazon WorkMail organizations\.

The Amazon WorkMail organization resource has the following ARN:

```
arn:aws:workmail:${Region}:${Account}:organization/${OrganizationId}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS service namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `m-n1pq2345678r901st2u3vx45x6789yza` organization in your statement, use the following ARN\.

```
"Resource": "arn:aws:workmail:us-east-1:111122223333:organization/m-n1pq2345678r901st2u3vx45x6789yza"
```

To specify all organizations that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:workmail:us-east-1:111122223333:organization/*"
```

Some Amazon WorkMail actions, such as those for creating resources, cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To see a list of Amazon WorkMail resource types and their ARNs, see [Resources defined by Amazon WorkMail](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonworkmail.html#amazonworkmail-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify for the ARN of each resource, see [Actions, resources, and condition keys for Amazon WorkMail](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonworkmail.html)\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Amazon WorkMail does not provide any service\-specific condition keys, but it does support using the following global condition keys\.
+ `aws:CurrentTime`
+ `aws:EpochTime`
+ `aws:MultiFactorAuthAge`
+ `aws:MultiFactorAuthPresent`
+ `aws:PrincipalOrgID`
+ `aws:PrincipalArn`
+ `aws:RequestedRegion`
+ `aws:SecureTransport`
+ `aws:UserAgent`

The following example policy grants access to the Amazon WorkMail console only from MFA authenticated IAM principals in the `eu-west-1` AWS Region\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "ses:Describe*",
                "ses:Get*",
                "workmail:Describe*",
                "workmail:Get*",
                "workmail:List*",
                "workmail:Search*",
                "lambda:ListFunctions",
                "iam:ListRoles",
                "logs:DescribeLogGroups",
                "cloudwatch:GetMetricData"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "aws:RequestedRegion": [
                        "eu-west-1"
                    ]
                },
                "Bool": {
                    "aws:MultiFactorAuthPresent": true
                }
            }
        }
    ]
}
```

To see all AWS global condition keys, see [AWS global condition context keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Amazon WorkMail identity\-based policies, see [Amazon WorkMail identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## Amazon WorkMail resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Amazon WorkMail does not support resource\-based policies\.

## Authorization based on Amazon WorkMail tags<a name="security_iam_service-with-iam-tags"></a>

You can attach tags to Amazon WorkMail resources or pass tags in a request to Amazon WorkMail\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `workmail:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\. For more information about tagging Amazon WorkMail resources, see [Tagging an organization](org-tag.md)\.

## Amazon WorkMail IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with Amazon WorkMail<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Amazon WorkMail supports using temporary credentials\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Amazon WorkMail supports service\-linked roles\. For details about creating or managing Amazon WorkMail service\-linked roles, see [Using service\-linked roles for Amazon WorkMail](using-service-linked-roles.md)\.

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Amazon WorkMail supports service roles\.
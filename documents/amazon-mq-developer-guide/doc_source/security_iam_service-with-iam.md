# How Amazon MQ Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Amazon MQ, you should understand what IAM features are available to use with Amazon MQ\. To get a high\-level view of how Amazon MQ and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

Amazon MQ uses IAM for creating, updating, and deleting operations, but native ActiveMQ authentication for brokers\. For more information, see [Messaging Authentication and Authorization for ActiveMQ](security-authentication-authorization.md)\.

**Topics**
+ [Amazon MQ Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [Amazon MQ Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization Based on Amazon MQ Tags](#security_iam_service-with-iam-tags)
+ [Amazon MQ IAM Roles](#security_iam_service-with-iam-roles)

## Amazon MQ Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Amazon MQ supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Amazon MQ use the following prefix before the action: `mq:`\. For example, to grant someone permission to run an Amazon MQ instance with the Amazon MQ `CreateBroker` API operation, you include the `mq:CreateBroker` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Amazon MQ defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "mq:action1",
      "mq:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "mq:Describe*"
```



To see a list of Amazon MQ actions, see [Actions Defined by Amazon MQ](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



In the Amazon MQ, the primary AWS resources are an Amazon MQ message broker and its configuration\. Amazon MQ brokers and configurations each have unique Amazon Resource Names \(ARNs\) associated with them, as shown in the following table\.


****  

| Resource Types | ARN | Condition Keys | 
| --- | --- | --- | 
|   brokers  |  arn:$\{Partition\}:mq:$\{Region\}:$\{Account\}:broker:$\{broker\-id\}  |   [ aws:ResourceTag/$\{TagKey\} ](#amazonmq-aws_ResourceTag___TagKey_)   | 
|   configurations  |  arn:$\{Partition\}:mq:$\{Region\}:$\{Account\}:configuration:$\{configuration\-id\}  |   [ aws:ResourceTag/$\{TagKey\} ](#amazonmq-aws_ResourceTag___TagKey_)   | 

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `i-1234567890abcdef0` broker in your statement, use the following ARN:

```
"Resource": "arn:aws:ec2:us-east-1:123456789012:broker/i-1234567890abcdef0"
```

To specify all brokers that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:ec2:us-east-1:123456789012:broker/*"
```

Some Amazon MQ actions, such as those for creating resources, cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

 The API action `CreateTags` requires both a broker and a configuration\. To specify multiple resources in a single statement, separate the ARNs with commas\. 

```
"Resource": [
      "resource1",
      "resource2"
```

To see a list of Amazon MQ resource types and their ARNs, see [Resources Defined by Amazon MQ](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by Amazon MQ](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-actions-as-permissions)\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can build conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 


****  

| Condition Keys | Description | Type | 
| --- | --- | --- | 
|   aws:RequestTag/$\{TagKey\}  |  | String | 
|   aws:ResourceTag/$\{TagKey\}  |  | String | 
|   aws:TagKeys  |  | String | 

Amazon MQ defines its own set of condition keys and also supports using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.



To see a list of Amazon MQ condition keys, see [Condition Keys for Amazon MQ](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-policy-keys) in the *IAM User Guide*\. To learn with which actions and resources you can use a condition key, see [Actions Defined by Amazon MQ](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmq.html#amazonmq-actions-as-permissions)\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Amazon MQ identity\-based policies, see [Amazon MQ Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## Amazon MQ Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Currently, Amazon MQ doesn't support IAM authentication using resource\-based permissions or resource\-based policies\.

## Authorization Based on Amazon MQ Tags<a name="security_iam_service-with-iam-tags"></a>

You can attach tags to Amazon MQ resources or pass tags in a request to Amazon MQ\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `mq:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\.

Amazon MQ supports policies based on tags\. For instance, you could deny access to Amazon MQ resources that include a tag with the key `environment` and the value `production`:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": [
                "mq:DeleteBroker",
                "mq:RebootBroker",
                "mq:DeleteTag"
            ],
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "aws:ResourceTag/environment": "production"
                }
            }
        }
    ]
}
```

This policy will `Deny` the ability to delete or reboot an Amazon MQ broker that includes the tag `environment/production`\.

For more information on tagging, see:
+ [Tagging resources](amazon-mq-tagging.md)
+ [Controlling Access Using IAM Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_iam-tags.html)

## Amazon MQ IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with Amazon MQ<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Amazon MQ supports using temporary credentials\. 

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Amazon MQ supports service roles\. 
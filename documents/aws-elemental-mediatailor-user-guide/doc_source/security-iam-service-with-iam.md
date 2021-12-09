# How AWS Elemental MediaTailor Works with IAM<a name="security-iam-service-with-iam"></a>

To get a high\-level view of how AWS Elemental MediaTailor and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [AWS Elemental MediaTailor Identity\-Based Policies](#security-iam-service-with-iam-id-based-policies)
+ [AWS Elemental MediaTailor Resource\-Based Policies](#security-iam-service-with-iam-resource-based-policies)
+ [Authorization Based on AWS Elemental MediaTailor Tags](#security-iam-service-with-iam-tags)
+ [AWS Elemental MediaTailor IAM Roles](#security-iam-service-with-iam-roles)

## AWS Elemental MediaTailor Identity\-Based Policies<a name="security-iam-service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. AWS Elemental MediaTailor supports specific actions, resources, and condition keys\. To learn about all of the elements, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security-iam-service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in AWS Elemental MediaTailor prefix the action with `mediatailor:`\. For example, to grant someone permission to run the MediaTailor `ListTagsForResource` API operation, you include the `mediatailor:ListTagsForResource` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. MediaTailor defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows\.

```
"Action": [
      "mediatailor:action1",
      "mediatailor:action2"
]
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `List`, include the following action:

```
"mediatailor:List*"
```



For a list of AWS Elemental MediaTailor actions, see [Actions Defined by AWS Elemental MediaTailor](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediatailor.html#awselementalmediatailor-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security-iam-service-with-iam-id-based-policies-resources"></a>

AWS Elemental MediaTailor doesn't support specifying resource ARNs in a policy\.

### Condition Keys<a name="security-iam-service-with-iam-id-based-policies-conditionkeys"></a>

AWS Elemental MediaTailor doesn't provide service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security-iam-service-with-iam-id-based-policies-examples"></a>



To view examples of AWS Elemental MediaTailor identity\-based policies, see [AWS Elemental MediaTailor Identity\-Based Policy Examples](security-iam-id-based-policy-examples.md)\.

## AWS Elemental MediaTailor Resource\-Based Policies<a name="security-iam-service-with-iam-resource-based-policies"></a>

AWS Elemental MediaTailor doesn't support resource\-based policies\.

## Authorization Based on AWS Elemental MediaTailor Tags<a name="security-iam-service-with-iam-tags"></a>

You can attach tags to AWS Elemental MediaTailor resources and pass tags in a request to MediaTailor\. To control access using tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `mediatailor:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\. For more information about tagging MediaTailor resources, see [Tagging AWS Elemental MediaTailor Resources](tagging.md)\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing AWS Elemental MediaTailor Configurations Based on Tags](security-iam-id-based-policy-examples.md#security-iam-examples-view-configuration-based-on-tags)\.

## AWS Elemental MediaTailor IAM Roles<a name="security-iam-service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with AWS Elemental MediaTailor<a name="security-iam-service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

AWS Elemental MediaTailor supports using temporary credentials\. 

### Service\-Linked Roles<a name="security-iam-service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

AWS Elemental MediaTailor doesn't support service\-linked roles\. 

### Service Roles<a name="security-iam-service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

AWS Elemental MediaTailor doesn't support service roles\. 
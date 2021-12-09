# How Amazon Detective works with IAM<a name="security_iam_service-with-iam"></a>

Detective uses IAM identity\-based policies to grant permissions for the following types of users and actions:
+ **Master accounts** – The master account is the owner of a behavior graph, which uses data from their account\. Master accounts can invite member accounts to also contribute their data to the behavior graph\. They also use the behavior graph for triage and investigation of findings and resources associated with those accounts\.

  You can set up different policies to allow different users from the master account to perform different types of tasks\. For example, a user from a master account might only have permissions to manage member accounts\. Another user might only have permissions to use the behavior graph for investigation\.
+ **Member accounts** – A member account is an account that is invited to contribute data to a behavior graph\. A member account responds to an invitation\. After accepting an invitation, a member account can remove their account from the behavior graph\.

To get a high\-level view of how Detective and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

## Detective identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources, as well as the conditions under which actions are allowed or denied\. Detective supports specific actions, resources, and condition keys\.

To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy statements must include either an `Action` element or a `NotAction` element\. The `Action` element lists the actions allowed by the policy\. The `NotAction` element lists the actions that are not allowed\.

The actions defined for Detective reflect tasks that you can perform using Detective\. Policy actions in Detective have the following prefix: `detective:`\.

For example, to grant permission to use the `CreateMembers` API operation to invite member accounts to a behavior graph, you include the `detective:CreateMembers` action in their policy\.

To specify multiple actions in a single statement, separate them with commas\. For example, for a member account, the policy includes the set of actions related to managing an invitation:

```
"Action": [
      "detective:ListInvitations",
      "detective:AcceptInvitation",
      "detective:RejectInvitation",
      "detective:DisassociateMembership
]
```

You can also use wildcards \(\*\) to specify multiple actions\. For example, to manage the data used in their behavior graph, master accounts in Detective must be able to perform the following tasks:
+ View their list of member accounts \(`ListMembers`\)\.
+ Get information about selected member accounts \(`GetMembers`\)\.
+ Invite member accounts to their behavior graph \(`CreateMembers`\)\.
+ Remove members from their behavior graph \(`DeleteMembers`\)\.

Instead of listing these actions separately, you can grant access to all actions that end with the word `Members`\. The policy for that could include the following action:

```
"Action": "detective:*Members"
```



To see a list of Detective actions, see [Actions Defined by Amazon Detective](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazondetective.html#amazondetective-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For Detective, the only resource type is the behavior graph\. The behavior graph resource in Detective has the following ARN:

```
arn:aws:detective:${Region}:${AccountId}:graph:${GraphId}
```

For example, a behavior graph has the following values:
+ The Region for the behavior graph is `us-east-1`\.
+ The account ID for the master account ID is `111122223333`\.
+ The graph ID of the behavior graph is `027c7c4610ea4aacaf0b883093cab899`\.

To identify this behavior graph in a `Resource` statement, you would use the following ARN:

```
"Resource": "arn:aws:detective:us-east-1:111122223333:graph:027c7c4610ea4aacaf0b883093cab899"
```

To specify multiple resources in a `Resource` statement, use commas to separate them\.

```
"Resource": [
      "resource1",
      "resource2"
]
```

For example, the same AWS account may be invited to be a member account in more than one behavior graph\. In the policy for that member account, the `Resource` statement would list the behavior graphs they were invited to\.

```
"Resource": [
      "arn:aws:detective:us-east-1:111122223333:graph:027c7c4610ea4aacaf0b883093cab899",
      "arn:aws:detective:us-east-1:444455556666:graph:056d2a9521xi2bbluw1d164680eby416"
]
```

Some Detective actions, such as creating a behavior graph, listing behavior graphs, and listing behavior graph invitations, are not performed on a specific behavior graph\. For those actions, the `Resource` statement must use the wildcard \(\*\)\.

```
"Resource": "*"
```

For master account actions, Detective always verifies that the user making the request belongs to the master account for the affected behavior graph\. For member account actions, Detective always verifies that the user making the request belongs to the member account\. Even if an IAM policy grants access to a behavior graph, if the user does not belong to the correct account, the user cannot perform the action\.

For all actions that are performed on a specific behavior graph, the IAM policy should include the graph ARN\. The graph ARN can be added later\. For example, when an account first enables Detective, the initial IAM policy provides access to all Detective actions, using the wildcard for the graph ARN\. This allows the user to immediately start to manage member accounts for and conduct investigations in their behavior graph\. After the behavior graph is created, you can update the policy to add the graph ARN\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can create conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

Detective does not define its own set of condition keys\. It does support using global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.



To learn which actions and resources allow you to use a condition key, see [Actions Defined by Amazon Detective](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazondetective.html#amazondetective-actions-as-permissions)\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Detective identity\-based policies, see [Amazon Detective identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## Detective resource\-based policies \(Not supported\)<a name="security_iam_service-with-iam-resource-based-policies"></a>

Detective does not support resource\-based policies\.

## Authorization based on Detective tags \(Not supported\)<a name="security_iam_service-with-iam-tags"></a>

Detective does not support tagging resources or controlling access based on tags\.

## Detective IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with Detective<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Detective supports using temporary credentials\.

### Service\-linked roles \(Not supported\)<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Detective does not support service\-linked roles\.

### Service roles \(Not supported\)<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Detective does not support service roles\.
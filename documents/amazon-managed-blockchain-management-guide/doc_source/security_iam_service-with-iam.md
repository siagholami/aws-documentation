# How Amazon Managed Blockchain Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Managed Blockchain, you should understand what IAM features are available to use with Managed Blockchain\. To get a high\-level view of how Managed Blockchain and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Managed Blockchain Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [Managed Blockchain Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization Based on Managed Blockchain Tags](#security_iam_service-with-iam-tags)

## Managed Blockchain Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Managed Blockchain supports specific actions and resources\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Managed Blockchain use the following prefix before the action: `managedblockchain:`\. For example, to grant someone permission to vote on a proposal with the Managed Blockchain `VoteOnProposal` API operation, you include the `managedblockchain:VoteOnProposal` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Managed Blockchain defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "managedblockchain:action1",
      "managedblockchain:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `List`, include the following action:

```
"Action": "managedblockchain:List*"
```

To see a list of Managed Blockchain actions, see [Actions Defined by Amazon Managed Blockchain](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmanagedblockchain.html#amazonmanagedblockchain-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

Managed Blockchain resource types that can be used in IAM permission policy statements include the following:
+ network
+ member
+ node
+ proposal
+ invitation

Members, nodes, and invitations are associated with your account\. Networks and proposals, on the other hand, are scoped to the entire blockchain network and are not associated with a particular account\.

For example a Managed Blockchain network resource has the following ARN:

```
arn:${Partition}:managedblockchain:${Region}::networks/${NetworkId}
```

For example, to specify the `n-MWY63ZJZU5HGNCMBQER7IN6OIU` network in your statement, use the following ARN:

```
"Resource": "arn:aws:managedblockchain:us-east-1::networks/n-MWY63ZJZU5HGNCMBQER7IN6OIU"
```

To specify any network that is visible to your account, use the wildcard \(\*\):

```
"Resource": "arn:aws:managedblockchain:us-east-1::networks/*"
```

Some Managed Blockchain actions, such as `CreateNetwork`, `ListInvitations`, and `ListNetworks` cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To see a list of Managed Blockchain resource types and their ARNs, see [Resources Defined by Amazon Managed Blockchain](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmanagedblockchain.html#amazonmanagedblockchain-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by Amazon Managed Blockchain](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonmanagedblockchain.html#amazonmanagedblockchain-actions-as-permissions)\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Managed Blockchain does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>

To view examples of Managed Blockchain identity\-based policies, see [Amazon Managed Blockchain Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## Managed Blockchain Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Managed Blockchain does not support resource\-based policies\.

## Authorization Based on Managed Blockchain Tags<a name="security_iam_service-with-iam-tags"></a>

Managed Blockchain does not support tagging resources or controlling access based on tags\.
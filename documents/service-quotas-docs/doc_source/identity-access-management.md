# Identity and Access Management for Service Quotas<a name="identity-access-management"></a>

AWS uses security credentials to identify you and to grant you access to your AWS resources\. You can use features of AWS Identity and Access Management \(IAM\) to allow other users, services, and applications to use your AWS resources fully or in a limited way\. You can do this without sharing your security credentials\.

By default, IAM users don't have permission to create, view, or modify AWS resources\. To allow an IAM user to access resources such as a load balancer, and to perform tasks, you:

1. Create an IAM policy that grants the IAM user permission to use the specific resources and API actions they need\.

1. Attach the policy to the IAM user or the group that the IAM user belongs to\.

When you attach a policy to a user or group of users, it allows or denies the users permission to perform the specified tasks on the specified resources\.

For example, you can use IAM to create users and groups under your AWS account\. An IAM user can be a person, a system, or an application\. Then you grant permissions to the users and groups to perform specific actions on the specified resources using an IAM policy\.

## Grant Permissions Using IAM Policies<a name="iam-policies"></a>

When you attach a policy to a user or group of users, it allows or denies the users permission to perform the specified tasks on the specified resources\.

An IAM policy is a JSON document that consists of one or more statements\. Each statement is structured as shown in the following example\.

```
{
  "Version": "2012-10-17",
  "Statement":[{
    "Effect": "effect",
    "Action": "action",
    "Resource": "resource-arn",
    "Condition": {
      "condition": {
        "key":"value"
      }
    }
  }]
}
```
+ **Effect**— The *effect* can be `Allow` or `Deny`\. By default, IAM users don't have permission to use resources and API actions, so all requests are denied\. An explicit allow overrides the default\. An explicit deny overrides any allows\.
+ **Action**— The *action* is the specific API action for which you are granting or denying permission\. For more information about specifying *action*, see [API Actions for Service Quotas](#api-actions)\.
+ **Resource**— The resource that's affected by the action\. With some Service Quotas API actions, you can restrict the permissions granted or denied to a specific quota\. To do so, specify its Amazon Resource Name \(ARN\) in this statement\. Otherwise, you can use the \* wildcard to specify all Service Quotas resources\. For more information, see [Service Quotas Resources](#resources)\.
+ **Condition**— You can optionally use conditions to control when your policy is in effect\. For more information, see [Condition Keys for Service Quotas](#condition-keys)\.

For more information, see the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\.

## API Actions for Service Quotas<a name="api-actions"></a>

In the **Action** element of your IAM policy statement, you can specify any API action that Service Quotas offers\. You must prefix the action name with the lowercase string `servicequotas:`, as shown in the following example\.

```
"Action": "servicequotas:GetServiceQuota"
```

To specify multiple actions in a single statement, enclose them in square brackets and separate them with a comma, as shown in the following example\.

```
"Action": [
    "servicequotas:ListRequestedServiceQuotaChangeHistory",
    "servicequotas:ListRequestedServiceQuotaChangeHistoryByQuota"
]
```

You can also specify multiple actions using the \* wildcard\. The following example specifies all API action names for Service Quotas that start with `Get`\.

```
"Action": "servicequotas:Get*"
```

To specify all API actions for Service Quotas, use the \* wildcard, as shown in the following example\.

```
"Action": "servicequotas:*"
```

For the list of API actions for Service Quotas, see [Service Quotas Actions](https://docs.aws.amazon.com/servicequotas/2019-06-24/apireference/API_Operations.html)\.

## Service Quotas Resources<a name="resources"></a>

*Resource\-level permissions* refers to the ability to specify which resources users are allowed to perform actions on\. For API actions that support resource\-level permissions, you can control the resources that users are allowed to use with the action\. To specify a resource in a policy statement, you must use its Amazon Resource Name \(ARN\)\.

The ARN for a quota has the format shown in the following example\.

```
arn:aws:servicequotas:region-code:account-id:service-code/quota-code
```

For API actions that don't support resource\-level permissions, you must specify the resource statement shown in the following example\.

```
"Resource": "*"
```

## Resource\-Level Permissions for Service Quotas<a name="resource-level-permissions"></a>

The following Service Quotas actions support resource\-level permissions:
+ [PutServiceQuotaIncreaseRequestIntoTemplate](https://docs.aws.amazon.com/servicequotas/2019-06-24/apireference/API_PutServiceQuotaIncreaseRequestIntoTemplate.html)
+ [RequestServiceQuotaIncrease](https://docs.aws.amazon.com/servicequotas/2019-06-24/apireference/API_RequestServiceQuotaIncrease.html)

For more information, see [Actions Defined by Service Quotas](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_servicequotas.html#servicequotas-actions-as-permissions) in the *IAM User Guide*\.

## Condition Keys for Service Quotas<a name="condition-keys"></a>

When you create a policy, you can specify the conditions that control when the policy is in effect\. Each condition contains one or more key\-value pairs\. There are global condition keys and service\-specific condition keys\.

The `servicequotas:service` key is specific to Service Quotas\. The following Service Quotas API actions support this key:
+ [PutServiceQuotaIncreaseRequestIntoTemplate](https://docs.aws.amazon.com/servicequotas/2019-06-24/apireference/API_PutServiceQuotaIncreaseRequestIntoTemplate.html)
+ [RequestServiceQuotaIncrease](https://docs.aws.amazon.com/servicequotas/2019-06-24/apireference/API_RequestServiceQuotaIncrease.html)

For more information about global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

## Predefined AWS Managed Policies for Service Quotas<a name="predefined-policies"></a>

The managed policies created by AWS grant the required permissions for common use cases\. You can attach these policies to your IAM users, based on the access to Service Quotas that they require:
+ **ServiceQuotasFullAccess** — Grants full access required to use Service Quotas features\.
+ **ServiceQuotasReadOnlyAccess** — Grants read\-only access to Service Quotas features\.
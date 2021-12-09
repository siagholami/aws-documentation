# AWS Cloud Map API Permissions: Actions, Resources, and Conditions Reference<a name="cloud-map-api-permissions-ref"></a>

When you set up [Access Control](auth-and-access-control.md#access-control) and write a permissions policy that you can attach to an IAM identity \(identity\-based policies\), you can use the following lists as a reference\. The lists include each AWS Cloud Map API action, the actions that you must grant permissions access to, and the AWS resource that you must grant access to\. You specify the actions in the `Action` field for the policy, and you specify the resource value in the `Resource` field for the policy\. 

You can use AWS Cloud Map–specific condition keys in your IAM policies for some operations\. For more information, see [AWS Cloud Map Condition Keys Reference](#condition-keys-cloud-map-ref)\. You can also use AWS\-wide condition keys\. For a complete list of AWS\-wide keys, see [Available Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\. 

To specify an action, use the `servicediscovery` prefix followed by the API action name, for example, `servicediscovery:CreatePublicDnsNamespace` and `route53:CreateHostedZone`\.

**Topics**
+ [Required Permissions for AWS Cloud Map Actions](#required-permissions-cloud-map)
+ [AWS Cloud Map Condition Keys Reference](#condition-keys-cloud-map-ref)

## Required Permissions for AWS Cloud Map Actions<a name="required-permissions-cloud-map"></a><a name="service-discovery-table"></a>

[CreateHttpNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateHttpNamespace.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:CreateHttpNamespace`
Resources: `*`

[CreatePrivateDnsNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreatePrivateDnsNamespace.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:CreatePrivateDnsNamespace`
+ `route53:CreateHostedZone`
+ `route53:GetHostedZone`
+ `route53:ListHostedZonesByName`
+ `ec2:DescribeVpcs`
+ `ec2:DescribeRegions`
Resources: `*`

[CreatePublicDnsNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreatePublicDnsNamespace.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:CreatePublicDnsNamespace`
+ `route53:CreateHostedZone`
+ `route53:GetHostedZone`
+ `route53:ListHostedZonesByName`
Resources: `*`

[CreateService](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateService.html)  
Required Permissions \(API Action\): `servicediscovery:CreateService`  
Resources: `*`

[DeleteNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_DeleteNamespace.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:DeleteNamespace`
+ `route53:DeleteHostedZone`
Resources: `*`, `arn:aws:servicediscovery:region:account-id:namespace/namespace-id`

[DeleteService](https://docs.aws.amazon.com/cloud-map/latest/api/API_DeleteService.html)  
Required Permissions \(API Action\): `servicediscovery:DeleteService`  
Resources: `*`, `arn:aws:servicediscovery:region:account-id:service/service-id`

[DeregisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_DeregisterInstance.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:DeregisterInstance`
+ `route53:GetHealthCheck`
+ `route53:DeleteHealthCheck`
+ `route53:UpdateHealthCheck`
+ `route53:ChangeResourceRecordSets`
Resources: `*`

[DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html)  
Required Permissions \(API Action\): `servicediscovery:DiscoverInstances`  
Resources: `*`

[GetInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetInstance.html)  
Required Permissions \(API Action\): `servicediscovery:GetInstance`  
Resources: `*`

[GetInstancesHealthStatus](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetInstancesHealthStatus.html)  
Required Permissions \(API Action\): `servicediscovery:GetInstancesHealthStatus`  
Resources: `*`

[GetNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetNamespace.html)  
Required Permissions \(API Action\): `servicediscovery:GetNamespace`  
Resources: `*`, `arn:aws:servicediscovery:region:account-id:namespace/namespace-id`

[GetOperation](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetOperation.html)  
Required Permissions \(API Action\): `servicediscovery:GetOperation`  
Resources: `*`

[GetService](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetService.html)  
Required Permissions \(API Action\): `servicediscovery:GetService`  
Resources: `*`, `arn:aws:servicediscovery:region:account-id:service/service-id`

[ListInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_ListInstances.html)  
Required Permissions \(API Action\): `servicediscovery:ListInstances`  
Resources: `*`

[ListNamespaces](https://docs.aws.amazon.com/cloud-map/latest/api/API_ListNamespaces.html)  
Required Permissions \(API Action\): `servicediscovery:ListNamespaces`  
Resources: `*`

[ListOperations](https://docs.aws.amazon.com/cloud-map/latest/api/API_ListOperations.html)  
Required Permissions \(API Action\): `servicediscovery:ListOperations`  
Resources: `*`

[ListServices](https://docs.aws.amazon.com/cloud-map/latest/api/API_ListServices.html)  
Required Permissions \(API Action\): `servicediscovery:ListServices`  
Resources: `*`

[RegisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_RegisterInstance.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:RegisterInstance`
+ `route53:GetHealthCheck`
+ `route53:CreateHealthCheck`
+ `route53:UpdateHealthCheck`
+ `route53:ChangeResourceRecordSets`
Resources: `*`

[UpdateInstanceCustomHealthStatus](https://docs.aws.amazon.com/cloud-map/latest/api/API_UpdateInstanceCustomHealthStatus.html)  
Required Permissions \(API Action\): `servicediscovery:UpdateInstanceCustomHealthStatus`  
Resources: `*`

[UpdateService](https://docs.aws.amazon.com/cloud-map/latest/api/API_UpdateService.html)  
Required Permissions \(API Action\):  
+ `servicediscovery:UpdateService`
+ `route53:GetHealthCheck`
+ `route53:CreateHealthCheck`
+ `route53:DeleteHealthCheck`
+ `route53:UpdateHealthCheck`
+ `route53:ChangeResourceRecordSets`
Resources: `*`, `arn:aws:servicediscovery:region:account-id:service/service-id`

## AWS Cloud Map Condition Keys Reference<a name="condition-keys-cloud-map-ref"></a>

AWS Cloud Map defines the following condition keys that can be used in the `Condition` element of an IAM policy\. You can use these keys to further refine the conditions under which the policy statement applies\. For more information, see [Specifying Conditions in an IAM Policy](access-control-overview.md#specifying-conditions)\.

**servicediscovery:NamespaceArn**  
A filter that lets you get objects by specifying the Amazon Resource Name \(ARN\) for the related namespace\.

**servicediscovery:NamespaceName**  
A filter that lets you get objects by specifying the name of the related namespace\.

**servicediscovery:ServiceArn**  
A filter that lets you get objects by specifying the Amazon Resource Name \(ARN\) for the related service\.

**servicediscovery:ServiceName**  
A filter that lets you get objects by specifying the name of the related service\.
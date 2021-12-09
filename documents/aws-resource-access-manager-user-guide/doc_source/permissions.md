# AWS RAM Permissions<a name="permissions"></a>

AWS RAM permissions are policy fragments used by AWS RAM\. They control which actions principals are allowed to perform on resources that are shared with them\. AWS RAM permissions are used to generate the resource\-based policies that are attached to shared resources\.

AWS RAM includes default AWS\-managed permissions for each supported shareable resource type\. These managed permissions are created and managed by AWS, and they define the allowed actions for each shareable resource type\. For more information about the default AWS\-managed permissions, see [AWS\-Managed Permissions](#permissions-managed)\.

**Topics**
+ [How AWS RAM Permissions Work](#permissions-work)
+ [AWS\-Managed Permissions](#permissions-managed)

## How AWS RAM Permissions Work<a name="permissions-work"></a>

When you create a resource share, AWS RAM automatically attaches the default permission for each associated resource type to the resource share\. For example, if you create a resource share and associate a subnet and a Capacity Reservation, AWS RAM automatically attaches the subnet and Capacity Reservation permissions to the resource share\. 

After the resource share has been created, the permissions are provided to the respective resource\-owning services\. The resource\-owning service uses the provided permissions to create resource\-based policies for each of the resources included in the resource share\. The resulting resource\-based policies created by the resource\-owning service include the following elements:
+ `Resource`—The resource included in the resource share\.
+ `Effect`—The effect of the AWS RAM permission\. Always `allow`\.
+ `Principal`—The ARNs of the principals associated with the resource share\.
+ `Action`—The standard actions defined in the AWS RAM permission\.

The resource\-based policies are attached to the shared resources\. They allow the specified prinicipals to perform the allowed actions on the resource\.

## AWS\-Managed Permissions<a name="permissions-managed"></a>

AWS RAM provides the following default AWS\-managed permissions:

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/ram/latest/userguide/permissions.html)
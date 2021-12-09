# Using Service\-Linked Roles for Application Discovery Service<a name="using-service-linked-roles"></a>

AWS Application Discovery Service uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Application Discovery Service\. Service\-linked roles are predefined by Application Discovery Service and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up Application Discovery Service easier because you don’t have to manually add the necessary permissions\. Application Discovery Service defines the permissions of its service\-linked roles, and unless defined otherwise, only Application Discovery Service can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting their related resources\. This protects your Application Discovery Service resources because you can't inadvertently remove permission to access the resources\.

**Topics**
+ [Service\-Linked Role Permissions for Application Discovery Service](service-linked-role-permissions.md)
+ [Creating a Service\-Linked Role for Application Discovery Service](create-service-linked-role.md)
+ [Deleting a Service\-Linked Role for Application Discovery Service](delete-service-linked-role.md)

For information about other services that support service\-linked roles, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.
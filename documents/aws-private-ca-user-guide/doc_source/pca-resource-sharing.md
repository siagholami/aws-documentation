# Cross\-Account Access to Private CAs<a name="pca-resource-sharing"></a>

An ACM Private CA administrator can share a CA with principals \(users, roles, etc\.\) in another AWS account using any of several methods\. When a share has been received and accepted, the principal can use the CA to issue end\-entity certificates using ACM Private CA or AWS Certificate Manager resources\.

**Important**  
Charges associated with a certificate issued in a cross\-account scenario are billed to the AWS account that issues the certificate\.

ACM Private CA administrators can choose among the following methods:
+ Use AWS Resource Access Manager \(RAM\) to share the CA as a resource with a principal in another account or with AWS Organizations\. RAM is a standard method for sharing AWS resources across accounts\. For more information about RAM, see the [AWS RAM User Guide](https://docs.aws.amazon.com/ram/latest/userguide/)\. For more information about AWS Organizations, see the [AWS Organizations User Guide](https://docs.aws.amazon.com/organizations/latest/userguide/)\.
+ Use the ACM Private CA API or CLI to attach a resource\-based policy to a CA, thereby granting access to a principal in another account\. For more information, see [Resource\-Based Policies](pca-rbp.md)\.

The [Enabling Access to a Private CA](granting-ca-access.md) section of this guide provides workflows for granting access to CAs in both single\-account and cross\-account scenarios\.
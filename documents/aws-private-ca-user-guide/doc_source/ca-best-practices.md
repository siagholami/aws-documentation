# ACM Private CA Best Practices<a name="ca-best-practices"></a>

Best practices are recommendations that can help you use ACM Private CA effectively\. The following best practices are based on real\-world experience from current AWS Certificate Manager and ACM Private CA customers\. 

## Documenting CA Structure and Policies<a name="document-ca"></a>

AWS recommends documenting all of your policies and practices for operating your CA\. This might include:
+ Reasoning for your decisions about CA structure
+ A diagram showing your CAs and their relationships
+ Policies on CA validity periods
+ Planning for CA succession
+ Policies on path length
+ Catalog of permissions
+ Description of administrative control structures
+ Security

You can capture this information in two documents, known as Certification Policy \(CP\) and Certification Practices Statement \(CPS\)\. Refer to [RFC 3647](https://www.ietf.org/rfc/rfc3647.txt) for a framework for capturing important information about your CA operations\.

## Minimize Use of the Root CA if Possible<a name="minimize-root-use"></a>

A root CA should in general only be used to issue certificates for intermediate CAs\. This allows the root CA to be stored out of harm's way while the intermediate CAs perform the daily task of issuing end\-entity certificates\.

However, if your organization's current practice is to issue end\-entity certificates directly from a root CA, ACM Private CA can support this workflow while improving security and operational controls\. Issuing end\-entity certificates in this scenario requires an IAM permissions policy that permits your root CA to use an end\-entity certificate template\. For information about IAM policies, see [Identity and Access Management for AWS Certificate Manager Private Certificate Authority](security-iam.md)\.

**Note**  
This configuration imposes limitations that may result in operational challenges\. For example, if your root CA is compromised or lost, you must create a new root CA and distribute it to all of the clients in your environment\. Until this recovery process is complete, you will not be able to issue new certificates\. Issuing certificates directly from a root CA also prevents you from restricting access and limiting the number of certificates issued from your root, which are both considered best practices for managing a root CA\. 

## Give the Root CA its own AWS Account<a name="isolate-root-account"></a>

Creating a root CA and subordinate CA in two different AWS accounts is a recommended best practice\. Doing so can provide you with additional protection and access controls for your root CA\. You can do so by exporting the CSR from the subordinate CA in one account, and signing it with a root CA in a different account\. The benefit of this approach is that you can separate control of your CAs by account\. The disadvantage is that you cannot use the AWS management console wizard to simplify the process of signing the CA certificate of a subordinate CA from your Root CA\.

## Separate Administrator and Issuer Roles<a name="role-separation"></a>

The CA administrator role should be separate from users who need only to issue end\-entity certificates\. If your CA administrator and certificate issuer reside in the same AWS account, you can limit issuer permissions by creating an IAM user specifically for that purpose\. 

## Turn on AWS CloudTrail<a name="use-cloudtrail"></a>

Turn on CloudTrail logging before you create and start operating a private CA\. With CloudTrail you can retrieve a history of AWS API calls for your account to monitor your AWS deployments\. This history includes API calls made from the AWS Management Console, the AWS SDKs, the AWS Command Line Interface, and higher\-level AWS services\. You can also identify which users and accounts called the PCA API operations, the source IP address the calls were made from, and when the calls occurred\. You can integrate CloudTrail into applications using the API, automate trail creation for your organization, check the status of your trails, and control how administrators turn CloudTrail logging on and off\. For more information, see [Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)\. Go to [Using CloudTrail](PcaCtIntro.md) to see example trails for ACM Private CA operations\. 

## Rotate the CA Private Key<a name="rotate-keys"></a>

It is a best practice to periodically update the private key for your private CA\. You can update a key by importing a new CA certificate, or you can replace the private CA with a new CA\.

## Delete an Unused CA<a name="delete-unused-ca"></a>

You can permanently delete a private CA\. You might want to do so if you no longer need the CA or if you want to replace it with a CA that has a newer private key\. To safely delete a CA, we recommend that you follow the process outlined in [Deleting Your Private CA](PCADeleteCA.md)\.

**Note**  
AWS bills you for a CA until it has been deleted\.
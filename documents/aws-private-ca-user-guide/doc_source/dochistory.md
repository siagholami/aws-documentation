# Document History<a name="dochistory"></a>

The following table describes significant changes to this documentation since January 2018\. In addition to major changes listed here, we also update the documentation frequently to improve the descriptions and examples, and to address the feedback that you send to us\. To be notified about significant changes, use the link in the upper right corner to subscribe to the RSS feed\.

| Change | Description | Date | 
| --- |--- |--- |
| [New and updated Java implementation examples](#dochistory) | See [Using the ACM Private CA API \(Java Examples\)](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaApiIntro.html)\. | September 9, 2020 | 
| [New region support](#dochistory) | Endpoints added for Africa \(Cape Town\) and Europe \(Milan\)\. For a complete list of ACM PCA endpoints, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\. | August 27, 2020 | 
| [Cross\-account private CA access supported](#dochistory) | AWS Certificate Manager users can be authorized to issue certificates using private CAs that they do not own\. For more information, see [Cross\-Account Access to Private CAs](https://docs.aws.amazon.com/acm-pca/latest/userguide/pca-resource-sharing.html)\. | August 17, 2020 | 
| [VPC endpoints \(PrivateLink\) support](#dochistory) | Added support for use of VPC endpoints \(AWSPrivateLink\) for enhanced network security\. For more information, see [ACM Private CA VPC Endpoints \(AWS PrivateLink\)](https://docs.aws.amazon.com/acm-pca/latest/userguide/vpc-endpoints.html)\. | March 26, 2020 | 
| [Dedicated security section added](#dochistory) | Security documentation for AWS has been consolidated into a dedicated security section\. For information about security, see [Security in AWS Certificate Manager Private Certificate Authority](https://docs.aws.amazon.com/acm-pca/latest/userguide/security.html)\. | March 26, 2020 | 
| [Template ARN added to audit reports\.](#dochistory) | For more information, see [Creating an Audit Report for Your Private CA](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaAuditReport.html)\. | March 6, 2020 | 
| [CloudFormation support](#dochistory) | Support added for AWS CloudFormation\. For more information, see [ACMPCA Resource Type Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/AWS_ACMPCA.html) in the AWS CloudFormation User Guide\. | January 22, 2020 | 
| [CloudWatch Events integration](#dochistory) | Integration with CloudWatch Events for asynchronous events, including CA creation, certificate issuance, and CRL creation\. For more information, see [Using CloudWatch Events](https://docs.aws.amazon.com/acm-pca/latest/userguide/CloudWatchEvents.html)\. | December 23, 2019 | 
| [FIPS endpoints](#dochistory) | FIPS endpoints added for AWS GovCloud \(US\-East\) and AWS GovCloud \(US\-West\)\. For a complete list of ACM PCA endpoints, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\. | December 13, 2019 | 
| [Tag\-based permissions](#dochistory) | Tag\-based permissions supported using the new APIs `TagResource`, `UntagResource`, and `ListTagsForResource`\. For general information about tag\-based controls, see [Controlling Access to and for IAM Users and Roles Using IAM Resource Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_iam-tags.html)\. | November 5, 2019 | 
| [Name constraints enforcement](#dochistory) | Added support for enforcing subject name constraints on imported CA certificates\. For more information, see [Enforcing Name Constraints on a Private CA](https://docs.aws.amazon.com/acm-pca/latest/userguide/name_constraints.html)\. | October 28, 2019 | 
| [New certificate templates](#dochistory) | New certificate templates added, including templates for code signing with AWS Signer\. For more information, see [Using Templates](https://docs.aws.amazon.com/acm-pca/latest/userguide/UsingTemplates.html)\. | October 1, 2019 | 
| [Planning your CA](#dochistory) | New section added on planning your PKI using ACM PCA\. For more information, see [Planning Your ACM Private CA Deployment](https://docs.aws.amazon.com/acm-pca/latest/userguide/PcaPlanning.html)\. | September 30, 2019 | 
| [Added region support](#dochistory) | Added region support for the AWS Asia Pacific \(Hong Kong\) Region\. For a complete list of supported regions, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\. | July 24, 2019 | 
| [Added complete private CA hierarchy support](#dochistory) | Support for creating and hosting root CAs removes need for an external parent\. | June 20, 2019 | 
| [Added region support](#dochistory) | Added region support for the AWS GovCloud \(US\-West and US\-East\) Regions\. For a complete list of supported regions, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\. | May 8, 2019 | 
| [Added region support](#dochistory) | Added region support for the AWS Asia Pacific \(Mumbai and Seoul\), US West \(N\. California\), and EU \(Paris and Stockholm\) Regions\. For a complete list of supported regions, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\. | April 4, 2019 | 
| [Testing certificate renewal workflow](#dochistory) | Customers can now manually test the configuration of their ACM managed renewal workflow\. For more information, see [Testing ACM's Managed Renewal Configuration](https://docs.aws.amazon.com/acm/latest/userguide/manual-renewal.html)\. | March 14, 2019 | 
| [Added region support](#dochistory) | Added region support for the AWS EU \(London\) Region\. For a complete list of supported regions, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\. | August 1, 2018 | 
| [Restore deleted CAs](#dochistory) | Private CA restore allows customers to restore certificate authorities \(CAs\) for up to 30 days after they have been deleted\. For more information, see [Restoring Your Private CA](https://docs.aws.amazon.com/acm-pca/latest/userguide/PCARestoreCA.html)\. | June 20, 2018 | 

## Earlier Updates<a name="earlier-updates"></a>

The following table describes the documentation release history of AWS Certificate Manager Private Certificate Authority before June 2018\.


****  

| Change | Description | Date | 
| --- | --- | --- | 
| New guide | This release introduces AWS Certificate Manager Private Certificate Authority\. | April 04, 2018 | 
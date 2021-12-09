# Data Protection in AWS Elemental MediaTailor<a name="data-protection"></a>

AWS Elemental MediaTailor doesn't encrypt or decrypt data in its management of content manifests or in its communication with servers, CDNs, or players\. MediaTailor doesn't require that you supply any customer data or other sensitive information\.

Don't put sensitive information, like customer account numbers, credit card information, or passwords, into free\-form fields or query parameters\. This applies to all use of AWS Elemental MediaTailor, including the console, API, SDKs, and the AWS CLI\. Any data that you enter into the service might get picked up for inclusion in diagnostic logs\.

When you provide a URL to an external server, don't include unencrypted credentials information in the URL to validate your request to that server\. 
--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Authorization with the Amazon S3 API Adapter for Snowball<a name="auth-adapter"></a>

When you use the Amazon S3 Adapter for Snowball, every interaction is signed with the AWS Signature Version 4 algorithm by default\. This authorization is used only to verify the data traveling from its source to the adapter\. All encryption and decryption happens in your workstation's memory\. Unencrypted data is never stored on the workstation or the Snowball\. 

When using the adapter, keep the following in mind:
+ **You can disable signing** – After you've installed the adapter on your workstation, you can disable signing by modifying the snowball\-adapter\.config file\. This file, saved to /\.aws/snowball/config, has a value named `auth.enabled` set to true by default\. If you change this value to `false`, you disable signing through the Signature Version 4 algorithm\. You might not want to disable signing, because signing is used to prevent modifications or changes to data traveling between the adapter and your data storage\. You can also enable HTTPS and provide your own certificate when communicating with the adapter\. To do so, you start the adapter with additional options\. For more information, see [Options for the Amazon S3 Adapter for Snowball](using-adapter-options.md)\.
**Note**  
Data traveling to or from a Snowball is always encrypted, regardless of your signing solution\.
+ **The encryption key is not changed by what AWS credentials you use** – Because signing with the Signature Version 4 algorithm is only used to verify the data traveling from its source to the adapter, it never factors into the encryption keys used to encrypt your data on the Snowball\.
+ **You can use any AWS profile** – The Amazon S3 Adapter for Snowball never connects back to AWS to verify your AWS credentials, so you can use any AWS profile with the adapter to sign the data traveling between the workstation and the adapter\.
+ **The Snowball doesn't contain any AWS credentials** – You manage access control and authorization to a Snowball on\-premises\. No software on the Snowball or adapter differentiates access between one user and another\. When someone has access to a Snowball, the manifest, and the unlock code, that person has complete and total access to the device and all data on it\. We recommend that you plan physical and network access for the Snowball accordingly\.
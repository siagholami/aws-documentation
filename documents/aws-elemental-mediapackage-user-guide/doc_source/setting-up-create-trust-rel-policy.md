# Step 1: Create a Policy<a name="setting-up-create-trust-rel-policy"></a>

The IAM policy defines the permissions that AWS Elemental MediaPackage requires to access other services\. 
+ For video on demand \(VOD\) workflows, create a policy that allows MediaPackage to read from the Amazon S3 bucket, verify the billing method, and retrieve content\. For the billing method, MediaPackage must verify that the bucket *does not* require the requester to pay for requests\. If the bucket has **requestPayment** enabled, MediaPackage can't ingest content from that bucket\.
+ For live\-to\-VOD workflows, create a policy that allows MediaPackage to read from the Amazon S3 bucket and store the live\-to\-VOD asset in it\.
+ For content delivery network \(CDN\) authorization headers, create a policy that allows MediaPackage to read from a secret in Secrets Manager\.

The following sections describe how to create these policies\.

**Topics**
+ [Amazon S3 Access for VOD Workflows](setting-up-create-trust-rel-policy-vod.md)
+ [Amazon S3 Access for Live\-to\-VOD Workflows](setting-up-create-trust-rel-policy-ltov.md)
+ [Secrets Manager Access for CDN Authorization](setting-up-create-trust-rel-policy-cdn.md)
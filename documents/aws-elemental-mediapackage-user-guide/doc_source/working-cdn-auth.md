# Using Content Delivery Network \(CDN\) Authorization<a name="working-cdn-auth"></a>

CDN authorization is available for live workflows\. It is not supported for video on demand \(VOD\)\.

With CDN authorization, content requests must include a specific HTTP origin header and authorization code\. MediaPackage verifies this code before it serves content to the requesting device\. When you set up CDN authorization, you have to create the authorization code, configure your CDN to include the appropriate header and code, store the code as a secret in AWS Secrets Manager, and enable the feature on the endpoint\. This section describes how to perform those steps\.

For more information about how CDN authorization works, see [Content Delivery Network \(CDN\) Authorization in AWS Elemental MediaPackage](cdn-auth.md)\.

The following sections provide procedures for working with CDN authorization\.

**Topics**
+ [Setting Up CDN Authorization](#cdn-auth-setup)
+ [Rotating the CDN Authorization Code](#cdn-auth-rotate)

## Setting Up CDN Authorization<a name="cdn-auth-setup"></a>

To use CDN authorization, you must take action in multiple services:
+ AWS Identity and Access Management \(IAM\) 
+ A CDN, such as Amazon CloudFront
+ AWS Secrets Manager
+ MediaPackage

The following procedures describe what to do in each of these services\.

### Step 1: Allow MediaPackage to Access Secrets Manager<a name="cdn-aut-setup-iam"></a>

MediaPackage has to access Secrets Manager to verify the authorization code in playback requests\. Use IAM to create a policy that allows access to Secrets Manager\. Attach the policy to a role that MediaPackage can assume to gain access\. Follow the steps in [Allowing AWS Elemental MediaPackage to Access Other AWS Services](setting-up-create-trust-rel.md)\.

### Step 2: Create the Authorization Code<a name="cdn-aut-setup-code"></a>

The authorization code is shared between Secrets Manager and your CDN\. When MediaPackage receives a playback request, it verifies that your CDN has provided the correct code\. 

The authorization code must be between 8 and 128 characters long\. We recommend that you use a version 4 UUID\.

### Step 3: Create a Custom Header in Your CDN<a name="cdn-aut-setup-cdn"></a>

In your CDN, configure a custom HTTP request header that contains the authorization code\. Use the header **X\-MediaPackage\-CDNIdentifier**\.

**To create a custom header in Amazon CloudFront**

1. Sign in to the AWS Management Console and open the CloudFront console at [https://console\.aws\.amazon\.com/cloudfront/](https://console.aws.amazon.com/cloudfront/)\.

1. Create or edit a distribution\.

1. In **Origin Settings**, complete the fields\.
   + For **Header Name**, enter **X\-MediaPackage\-CDNIdentifier**\.
   + For **Value**, enter the authorization code that you stored in Secrets Manager\.

1. Complete the remaining fields as needed and save the distribution\.

For more information about custom headers in CloudFront, see [Forwarding Customer Headers to Your Origin](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/forward-custom-headers.html) in *Amazon CloudFront Developer Guide*\.

### Step 4: Store the Authorization Code in Secrets Manager<a name="cdn-aut-setup-secret"></a>

Create a secret in AWS Secrets Manager\. 

To use CDN authorization for endpoints in AWS Elemental MediaPackage, you must create a secret in AWS Secrets Manager to store your authorization code\. This secret must be in the same AWS account and Region to create the secret that you use to create the AWS Elemental MediaPackage resources \(channel and endpoint\) that uses the secret\. AWS Elemental MediaPackage does not support cross\-account or cross\-Region sharing of secrets\. You can, however, use the same secret across multiple endpoints in the same Region and on the same account\.

**To store an authorization code in Secrets Manager**

1. Sign in to the AWS Secrets Manager console at [https://console\.aws\.amazon\.com/secretsmanager/](https://console.aws.amazon.com/secretsmanager/)\.

1. On the **Store a new secret** page, for **Select secret type**, choose **Other type of secrets**\.

1. For **Specify the key/value pairs to be stored in this secret**, choose **Secret key/pair**\.

1. Complete the empty boxes\.
   + In the box on the left, enter your key\. The key is **MediaPackageCDNIdentifier**\.
   + In the box on the right, enter your value\. The value is the authorization code that you created in [Step 2: Create the Authorization Code](#cdn-aut-setup-code)\. If you use a version 4 UUID, the authorization code is similar to this `b8ebbd11-c417-4951-93fb-20fba5c41062`\.

1. For **Select the encryption key**, keep the default set to **DefaultEncryptionKey**\.

1. Choose **Next**\.

1. For **Secret name**, specify a name for your secret that will help you identify it later\. We recommend that you prefix the secret name with **MediaPackage/** to help differentiate it from other secrets\. For example, **MediaPackage/2019\_12\_17\_bball**\.

1. Choose **Next**\.

1. For **Configure automatic rotation** section, choose **Disable automatic rotation**\. 

   If you need to rotate the authorization code later, see [Rotating the CDN Authorization Code](#cdn-auth-rotate)\.

1. Choose **Next**, and then choose **Store**\.

   The details page for your new secret appears, showing information such as the secret ARN\.

1. Make a note of the secret ARN from Secrets Manager\. You will need this information in the next procedure\.

### Step 5: Enable CDN Authorization in MediaPackage<a name="cdn-aut-setup-endpoint"></a>

When you have created a secret and stored the authorization code in Secrets Manager and your CDN, enable CDN authorization on the endpoint in MediaPackage\.

**Tip**  
Use the same secret across multiple endpoints in the same Region and on the same account\. You can reduce costs by creating a new secret only when necessary for your workflow\.

**To enable CDN authorization on the endpoint**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. If you don't already have a channel, create one\. For help, see [Creating a Channel](channels-create.md)\.

1. Create or edit an endpoint\.

1. In **Access control settings**, select **Use authorization**\. Complete the fields:
   + In **Secrets role ARN**, enter the Amazon Resource Name \(ARN\) for the IAM role that you created in [Step 1: Allow MediaPackage to Access Secrets Manager](#cdn-aut-setup-iam)\.
   + In **CDN identifier secret**, enter the ARN for the secret that holds your authorization code in Secrets Manager\.

1. Complete the remaining fields as needed and save the endpoint\.

You have now completed the setup for CDN authorization\. Requests to this endpoint must contain the same authorization code that you saved in Secrets Manager\.

## Rotating the CDN Authorization Code<a name="cdn-auth-rotate"></a>

Since there is no integration between Secrets Manager and your CDN, you have to manually update the CDN if you change the authorization code\. For this reason, you must use a static value for the secret\. The following procedure describes how to rotate your authorization code and ensure your CDN sends the correct code\.

**To rotate the CDN authorization code**

1. Update the authorization code in Secrets Manager as described in [Modifying a Secret](https://docs.aws.amazon.com/secretsmanager/latest/userguide/manage_update-secret.html) in the *AWS Secrets Manager User Guide*\.

   To ensure continued playback for active streams, MediaPackage authorizes requests that use either the current authorization code in Secrets Manager or one version back\. To disable the previous authorization code, save the new code two times\. This way, both the current and previous secret versions have the same value\.

1. Wait 10 minutes for MediaPackage to recognize that the authorization code has changed in Secrets Manager\.

1. In your CDN, update the value in `X-MediaPackage-CDNIdentifier` to the new authorization code\.

1. Wait for your CDN to update fully with the new value before you send any requests through it to MediaPackage\.
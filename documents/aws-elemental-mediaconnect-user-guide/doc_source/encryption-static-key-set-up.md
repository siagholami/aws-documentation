# Setting up static key encryption using AWS Elemental MediaConnect<a name="encryption-static-key-set-up"></a>

Before you can create a flow with an encrypted source or an output or entitlement that uses static key encryption, you must perform the following steps:

**[Step 1](#encryption-static-key-set-up-store-key)** – Store your encryption key as a secret in AWS Secrets Manager\.

**[Step 2](#encryption-static-key-set-up-create-iam-policy)** – Create an IAM policy that allows AWS Elemental MediaConnect to read the secret that you stored in AWS Secrets Manager\.

**[Step 3](#encryption-static-key-set-up-create-iam-role)** – Create an IAM role and attach the policy that you created in step 2\. Next, set up AWS Elemental MediaConnect as a trusted entity that is allowed to assume this role and make requests on behalf of your account\.

**Note**  
Static key encryption is supported only for entitlements, and for sources and outputs that use the Zixi protocol\.

## Step 1: Store your encryption key in AWS Secrets Manager<a name="encryption-static-key-set-up-store-key"></a>

To use static key encryption to encrypt your AWS Elemental MediaConnect content, you must create a secret in AWS Secrets Manager to store your encryption key\. You also must use the same AWS account to create the secret that you use to create the AWS Elemental MediaConnect resource \(source, output, or entitlement\) that uses the secret\. AWS Elemental MediaConnect does not support cross\-account sharing of secrets\.

**Note**  
 If you use two flows to distribute video from one AWS Region to another, you must create two secrets \(one secret in each Region\)\. 

**To store an encryption key in Secrets Manager**

1. Obtain the encryption key from the entity that manages the source\.

1. Sign in to the AWS Secrets Manager console at [https://console\.aws\.amazon\.com/secretsmanager/](https://console.aws.amazon.com/secretsmanager/)\.

1. On the **Store a new secret** page, for **Select secret type**, choose **Other type of secrets**\.

1. For **Specify the key/value pairs to be stored in this secret**, choose **Plaintext**\.

1. Clear any text in the box and replace it with the encryption key\.

1. For **Select the encryption key**, keep the default set to **DefaultEncryptionKey**\.

1. Choose **Next**\.

1. For **Secret name**, specify a name for your secret that will help you identify it later\. For example, **2018\-12\-01\_baseball\-game\-source**\.

1. Choose **Next**\.

1. For **Configure automatic rotation** section, choose **Disable automatic rotation**\. 

1. Choose **Next**, and then choose **Store**\.

   The details page for your new secret appears, showing information such as the secret ARN\.

1. Make a note of the secret ARN from Secrets Manager\. You will need this information in the next procedure\.

## Step 2: Create an IAM policy to allow AWS Elemental MediaConnect to access your secret<a name="encryption-static-key-set-up-create-iam-policy"></a>

In [step 1](#encryption-static-key-set-up-store-key), you created a secret and stored it in AWS Secrets Manager\. In this step, you create an IAM policy that allows AWS Elemental MediaConnect to read the secret that you stored\.

**To create an IAM policy that allows MediaConnect to access your secret**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane of the IAM console, choose **Policies**\.

1. Choose **Create policy**, and then choose the **JSON** tab\.

1. Enter a policy that uses the following format:

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": [
           "secretsmanager:GetResourcePolicy",
           "secretsmanager:GetSecretValue",
           "secretsmanager:DescribeSecret",
           "secretsmanager:ListSecretVersionIds"
         ],
         "Resource": [
           "arn:aws:secretsmanager:us-west-2:111122223333:secret:aes256-7g8H9i"
         ]
       }
     ]
   }
   ```

   In the `Resource` section, each line represents the ARN of a different secret that you created\. For more examples, see [IAM policy examples for secrets in AWS Secrets Manager](iam-policy-examples-asm-secrets.md)\.

1. Choose **Review policy**\.

1. For **Name**, enter a name for your policy such as **SecretsManagerForMediaConnect**\.

1. Choose **Create policy**\.

## Step 3: Create an IAM role with a trusted relationship<a name="encryption-static-key-set-up-create-iam-role"></a>

In [step 2](#encryption-static-key-set-up-create-iam-policy), you created an IAM policy that allows read access to the secret that you stored in AWS Secrets Manager\. In this step, you create an IAM role and assign the policy to that role\. Then you define AWS Elemental MediaConnect as a trusted entity that can assume the role\. This allows MediaConnect to have read access to your secret\.

**To create a role with a trusted relationship**

1. In the navigation pane of the IAM console, choose **Roles**\.

1. On the **Role** page, choose **Create role**\. 

1. On the **Create role** page, for **Select type of trusted entity**, choose **AWS service** \(the default\)\.

1. For **Choose the service that will use this role**, choose **EC2**\. 

   You choose EC2 because AWS Elemental MediaConnect is not currently included in this list\. Choosing EC2 lets you create a role\. In a later step, you change this role to include MediaConnect instead of EC2\.

1. Choose **Next: Permissions**\.

1. For **Attach permissions policies**, enter the name of the policy that you created in [step 2](#encryption-static-key-set-up-create-iam-policy), such as **SecretsManagerForMediaConnect**\. 

1. For **SecretsManagerReadWrite**, select the check box, and then choose **Next: Review**\.

1. For **Role name**, enter a name\. We highly recommend that you don't use the name `MediaConnectAccessRole` because it is reserved\. Instead, use a name that includes `MediaConnect` and describes this role's purpose, such as **MediaConnect\-ASM**\.

1. For **Role description**, replace the default text with a description that will help you remember the purpose of this role\. For example, **Allows MediaConnect to view secrets stored in AWS Secrets Manager\.**

1. Choose **Create role**\.

1. In the confirmation message that appears across the top of your page, choose the name of the role that you just created\.

1. Choose **Trust relationships**, and then choose **Edit Trust Relationship**\.

1. For **Policy Document**, change `ec2.amazonaws.com` to `mediaconnect.amazonaws.com`\. 

   The policy document should now look like this: 

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "mediaconnect.amazonaws.com",
         },
         "Action": "sts:AssumeRole",
       },
     ],
   }
   ```

1. Choose **Update Trust Policy**\.

1. On the **Summary** page, make a note of the value for **Role ARN**\. It looks like this: `arn:aws:iam::111122223333:role/MediaConnectASM`\.
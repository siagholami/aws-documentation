# Setting up AWS Elemental MediaConnect as a trusted service<a name="security-iam-trusted-entity"></a>

You can use AWS Identity and Access Management \(IAM\) to control which AWS resources can be accessed by which users and applications\. This includes setting up permissions to allow AWS Elemental MediaConnect to communicate with other services on behalf of your account\. To set up AWS Elemental MediaConnect as a trusted entity, you must perform the following steps:

**[Step 1\.](#security-iam-trusted-entity-create-policy)** – Create an IAM policy that governs which actions you want to allow\.

**[Step 2](#security-iam-trusted-entity-create-role)** – Create an IAM role with a trusted relationship, and attach the policy that you created in the previous step\.

## Step 1: Create an IAM policy to allow specific actions<a name="security-iam-trusted-entity-create-policy"></a>

In this step, you create an IAM policy that governs which actions you want to allow\.

**To create the IAM policy**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**\.

1. Choose **Create policy**, and then choose the **JSON** tab\.

1. Enter a policy that uses the JSON format\. For examples, see the following:
   + [ Policy example for connecting to your VPC](security_iam_resource-based-policy-examples.md#iam-policy-examples-for-mediaconnect-vpc)
   + [Policy examples for secrets in AWS Secrets Manager](iam-policy-examples-asm-secrets.md)

1. Choose **Review policy**\.

1. For **Name**, enter a name for your policy\.

1. Choose **Create policy**\.

## Step 2: Create an IAM role with a trusted relationship<a name="security-iam-trusted-entity-create-role"></a>

In [step 1](#security-iam-trusted-entity-create-policy), you created an IAM policy that governs which actions you want to allow\. In this step, you create an IAM role and assign the policy to that role\. Then you define AWS Elemental MediaConnect as a trusted entity that can assume the role\.

**To create a role with a trusted relationship**

1. In the navigation pane of the IAM console, choose **Roles**\.

1. On the **Role** page, choose **Create role**\. 

1. On the **Create role** page, for **Select type of trusted entity**, choose **AWS service** \(the default\)\.

1. For **Choose the service that will use this role**, choose **EC2**\. 

   You choose EC2 because MediaConnect is not currently included in this list\. Choosing EC2 lets you create a role\. In a later step, you change this role to include MediaConnect instead of EC2\.

1. Choose **Next: Permissions**\.

1. For **Attach permissions policies**, enter the name of the policy that you created in [step 1](#security-iam-trusted-entity-create-policy)\. 

1. Select the check box next to the name of the policy, and then choose **Next: Tags**\.

1. \(Optional\) Add metadata to the user by attaching tags as key\-value pairs\. For more information about using tags in IAM, see [Tagging IAM Entities](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_tags.html) in the *IAM User Guide*\.

1. Choose **Next: Review**\.

1. For **Role name**, enter a name\. The name `MediaConnectAccessRole` is reserved, so you can't use it\. Instead, use a name that includes `MediaConnect` and describes this role's purpose\.

1. For **Role description**, replace the default text with a description that will help you remember the purpose of this role\.

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
                   "Service": "mediaconnect.amazonaws.com"
               },
               "Action": "sts:AssumeRole"
           }
       ]
   }
   ```

1. Choose **Update Trust Policy**\.

1. On the **Summary** page, make a note of the value for **Role ARN**\. It looks like this: `arn:aws:iam::111122223333:role/MediaConnectASM`\.
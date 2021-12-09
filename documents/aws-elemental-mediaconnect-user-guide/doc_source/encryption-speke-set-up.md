# Setting up SPEKE encryption using AWS Elemental MediaConnect<a name="encryption-speke-set-up"></a>

Before you can grant an entitlement that uses SPEKE encryption, you must perform the following steps:

**[Step 1\.](#encryption-speke-set-up-on-board-key-provider)** – Get on board with a conditional access \(CA\) platform key provider who will manage your encryption key\. During this process, you create an API in Amazon API Gateway that sends requests on behalf of AWS Elemental MediaConnect to the key provider\. 

**[Step 2](#encryption-speke-set-up-create-iam-policy)** – Create an IAM policy that allows the API that you created in step 1 to act as a proxy to make requests to the key provider\.

**[Step 3\.](#encryption-speke-set-up-create-iam-role)** – Create an IAM role and attach the policy that you created in step 2\. Next, set up AWS Elemental MediaConnect as a trusted entity that is allowed to assume this role and access the API Gateway endpoint on your behalf\.

## Step 1: Get on board with a CA provider<a name="encryption-speke-set-up-on-board-key-provider"></a>

To use SPEKE with AWS Elemental MediaConnect, you must have a CA platform key provider\. The following AWS partners provide conditional access \(CA\) solutions for the MediaConnect customization of SPEKE:
+ [Verimatrix](https://aws.amazon.com/partners/find/partnerdetails/?n=Verimatrix&id=001E000000be2SEIAY)

If you are a content originator, contact your CA platform key provider for assistance with the onboarding process\. With the help of your CA platform key provider, you manage who gets access to which content\. 

During the onboarding process, make a note of the following:
+ **ARN of the `POST` method request** – The Amazon Resource Name \(ARN\) that AWS assigns to the request that you create in API Gateway\.
+ **Constant initialization vector \(optional\)** – A 128\-bit, 16\-byte hex value represented by a 32\-character string, to be used with the key for encrypting content\.
+ **Device ID** – A unique identifier for each device that you configure with the key provider\. Each device represents a different recipient for your content\.
+ **Resource ID** – A unique identifier that you create for each piece of content that you configure with the key provider\.
+ **URL** – The URL assigned by AWS for the API that you create in Amazon API Gateway\.

You need these values later, when you configure the [entitlement](entitlements-grant.md) in MediaConnect\. 

## Step 2: Create an IAM policy to allow API Gateway to act as your proxy<a name="encryption-speke-set-up-create-iam-policy"></a>

In [step 1](#encryption-speke-set-up-on-board-key-provider), you worked with a CA platform key provider who manages your encryption key\. In this step, you create an IAM policy that allows API Gateway to make requests on your behalf\. API Gateway acts as a proxy for communication between your account and the key provider\. 

**To create an IAM policy for an API Gateway proxy**

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
           "execute-api:Invoke"
         ],
         "Resource": [
           "arn:aws:execute-api:us-west-2:111122223333:1abcdefghi/*/POST/*"
         ]
       }
     ]
   }
   ```

   In the `Resource` section, replace the sample Amazon Resource Name \(ARN\) with the ARN of the `POST` method request that you created in API Gateway with the CA platform key provider\.

1. Choose **Review policy**\.

1. For **Name**, enter **APIGateway\-Proxy\-Access**\.

1. Choose **Create policy**\.

## Step 3: Create an IAM role with a trusted relationship<a name="encryption-speke-set-up-create-iam-role"></a>

In [step 2](#encryption-speke-set-up-create-iam-policy), you created an **APIGateway\-Proxy\-Access** policy that allows API Gateway to act as a proxy and make requests on your behalf\. In this step, you create an IAM role and attach the following permissions: 
+ The **APIGateway\-Proxy\-Access** policy allows Amazon API Gateway to act as a proxy on your behalf so that it can make requests between your account and the CA platform key provider\. This is the policy you created in step 1\.
+ A **trust relationship** policy allows AWS Elemental MediaConnect to assume the role on your behalf\. You will create this policy as part of the following procedure\.

**To create an IAM role with a trusted relationship**

1. In the navigation pane of the IAM console, choose **Roles**\.

1. On the **Role** page, choose **Create role**\. 

1. On the **Create role** page, for **Select type of trusted entity**, choose **AWS service** \(the default\)\.

1. For **Choose the service that will use this role**, choose **EC2**\. 

   You choose EC2 because AWS Elemental MediaConnect is not currently included in this list\. Choosing EC2 lets you create a role\. In a later step, you change this role to include MediaConnect instead of EC2\.

1. Choose **Next: Permissions**\.

1. For **Filter policies**, choose **Customer managed**\.

1. Select the check box next to **APIGateway\-Proxy\-Access**, and then choose **Next: Tags**\.

1. Enter tag values \(optional\), and then choose **Next: Review**\.

1. For **Role name**, enter a name such as **SpekeAccess**\.

1. For **Role description**, replace the default text with a description that will help you remember the purpose of this role\. For example, **Allows AWS Elemental MediaConnect to talk to API Gateway on my behalf\.**

1. Choose **Create role**\.

1. In the confirmation message that appears across the top of your page, choose the name of the role that you just created\.

1. Choose **Trust relationships**, and then choose **Edit Trust Relationship**\.

1. For **Policy Document**, change the policy to look like this: 

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

1. On the **Summary** page, make a note of the value for **Role ARN**\. It looks like this: `arn:aws:iam::111122223333:role/SpekeAccess`\.
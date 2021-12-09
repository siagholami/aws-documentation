# Step 2: Create a Key Pair<a name="getstarted-keypair"></a>

To enable your end users to launch the product that is based on the sample template for this tutorial, you must create an Amazon EC2 key pair\. A key pair is a combination of a public key that is used to encrypt data and a private key that is used to decrypt data\. For more information about key pairs, see [Amazon EC2 Key Pairs](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html) in the *Amazon EC2 User Guide for Linux Instances*\.

The AWS CloudFormation template for this tutorial, `development-environment.template`, includes the `KeyName` parameter:

```
. . .
  "Parameters" : {
    "KeyName": {
      "Description" : "Name of an existing EC2 key pair for SSH access to the EC2 instance.",
      "Type": "AWS::EC2::KeyPair::KeyName"
    },
. . .
```

End users must specify the name of a key pair when they use AWS Service Catalog to launch the product that is based on the template\.

If you already have a key pair in your account that you would prefer to use, you can skip ahead to [Step 3: Create an AWS Service Catalog Portfolio](getstarted-portfolio.md)\. Otherwise, complete the following steps\.

**To create a key pair**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. In the navigation pane, under **Network & Security**, choose **Key Pairs**\.

1. On the **Key Pairs** page, choose **Create Key Pair**\.

1. For **Key pair name**, type a name that is easy for you to remember, and then choose **Create**\.

1. When the console prompts you to save the private key file, save it in a safe place\.
**Important**  
This is the only chance for you to save the private key file\.
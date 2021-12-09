# Prerequisites and Considerations<a name="get-started-prerequisites"></a>

To complete this tutorial, you must have the resources listed in this section\. Unless specifically stated otherwise, the requirements apply to both network creators and invited members\.

**Topics**
+ [An AWS account](#w22aab9b9b7)
+ [A Linux Client \(EC2 Instance\)](#w22aab9b9b9)
+ [A VPC](#w22aab9b9c11)
+ [Permissions to Create an Interface VPC Endpoint](#vpc-endpoint-permissions)
+ [EC2 Security Groups That Allow Communication on Required Ports](#get-started-prerequisites-sgs)
+ [Additional Considerations](#additional-considerations)

## An AWS account<a name="w22aab9b9b7"></a>

Before you use Managed Blockchain for the first time, you must sign up for an Amazon Web Services \(AWS\) account\.

If you do not have an AWS account, complete the following steps to create one\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

## A Linux Client \(EC2 Instance\)<a name="w22aab9b9b9"></a>

You must have a Linux computer with access to resources in the VPC to serve as your Hyperledger Fabric client\. This computer must have a version of the AWS CLI installed that includes the `managedblockchain` command\. We recommend creating an Amazon Elastic Compute Cloud \(Amazon EC2\) instance in the same VPC and AWS region as the VPC endpoint for the Managed Blockchain network\. This is the setup that the tutorial uses\. For instructions to set up a Hyperledger Fabric client using this configuration, see [Step 3: Create an Amazon EC2 Instance and Set Up the Hyperledger Fabric Client](get-started-create-client.md)\.

An AWS CloudFormation template to create a Hyperledger Fabric client is available in [amazon\-managed\-blockchain\-client\-templates repository](https://github.com/awslabs/amazon-managed-blockchain-client-templates) on Github\. For more information, see the [readme\.md](https://github.com/awslabs/amazon-managed-blockchain-client-templates/blob/master/README.md) in that repository\. For more information about using AWS CloudFormation, see [Getting Started](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/GettingStarted.Walkthrough.html) in the *AWS CloudFormation User Guide*\.

## A VPC<a name="w22aab9b9c11"></a>

You must have a [VPC](https://docs.aws.amazon.com/vpc/latest/userguide/) with an IPv4 CIDR block, and the `enableDnsHostnames` and `enableDnsSupport` options must be set to `true`\. If you will connect to the Hyperledger Fabric client using SSH, the VPC must have an internet gateway, and the security group configuration associated with the Hyperledger Framework client must allow inbound SSH access from your SSH client\.
+ For more information about creating a suitable network, see [Getting Started with IPv4 for Amazon VPC](https://docs.aws.amazon.com/vpc/latest/userguide/getting-started-ipv4.html) tutorial in the *Amazon VPC User Guide*\.
+ For information about using SSH to connect to an Amazon EC2 Instance, see [Connecting to Your Linux Instance Using SSH](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstancesLinux.html) in the *Amazon EC2 User Guide for Linux Instances*\.
+ For instructions about how to verify if DNS options are enabled, see [Using DNS with Your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-dns.html) in the *Amazon VPC User Guide*\.

## Permissions to Create an Interface VPC Endpoint<a name="vpc-endpoint-permissions"></a>

The IAM principal \(user\) identity that you are using must have sufficient IAM permissions to create an interface VPC endpoint in your AWS account\. For more information, see [Controlling Access \- Creating and Managing VPC Endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_IAM.html#vpc-endpoints-iam) in the *Amazon VPC User Guide*\.

## EC2 Security Groups That Allow Communication on Required Ports<a name="get-started-prerequisites-sgs"></a>

The EC2 security groups associated with the Hyperledger Fabric client Amazon EC2 instance and the Interface VPC Endpoint that you create during this tutorial must have rules that allow traffic between them for required Hyperledger Fabric services\. EC2 security groups are restrictive by default, so you need to create security group rules that allow required access\. In addition, a security group associated with the Hyperledger Fabric client Amazon EC2 instance must have an inbound rule that allows SSH traffic \(Port 22\) from trusted SSH clients\.

For the purposes of simplicity in this tutorial, we recommend that you create an EC2 security group that you associate only with the Hyperledger Fabric client Amazon EC2 instance and the Interface VPC Endpoint\. Then create an inbound rule that allows all traffic from within the security group\. In addition, create another security group to associate with the Hyperledger Fabric client Amazon EC2 instance that allows inbound SSH traffic from trusted clients\.

**Important**  
This security group configuration is recommended for this tutorial only\. Carefully consider security group settings for your desired security posture\. For information about the minimum required rules, see [Configuring Security Groups](managed-blockchain-security-sgs.md)\.

**To create a security group that allows traffic between the Hyperledger Fabric client and the interface VPC endpoint for use in this tutorial**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Security groups** in the navigation pane, and then choose **Create security group**\.

1. Enter a **Security group name** and **Description** for the security group that helps you find it\. For example, **HFClientAndEndpoint**\.

1. Make sure that the VPC you select is the default VPC for your account\. This is the VPC in which Hyperledger Fabric network resources and the interface VPC endpoint are created\.

1. Choose **Create**\.

1. Select the security group that you just created from the list, choose **Inbound**, and then choose **Edit**\.

1. Under **Type**, select **All traffic** from the list\.

1. Under **Source**, leave **Custom** selected, and then begin typing the name or ID of this same security group—for example, **HFClientAndEndpoint**—and then select the security group so that its ID appears under **Source**\.

1. Choose **Save**\.

   You reference this security group later in this tutorial in [Step 2: Create and Configure the Interface VPC Endpoint](get-started-create-endpoint.md) and [Step 3: Create an Amazon EC2 Instance and Set Up the Hyperledger Fabric Client](get-started-create-client.md)\.

**To create a security group for the Hyperledger Fabric client that allows inbound SSH connections from the computer that you are working with**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Security groups** in the navigation pane, and then choose **Create security group**\.

1. Enter a **Security group name** and **Description** for the security group that helps you find it\. For example, **HFClientSSH**\.

1. Make sure that the VPC you select is the same VPC that you will select for the interface VPC endpoint\.

1. Choose **Inbound**, and then choose **Add rule**\.

1. Under **Type**, select **SSH** from the list\.

1. Under **Source**, select **My IP**\. This adds the detected IP address of your current computer\. Optionally, you can create additional rules for SSH connections from additional IP addresses or sources if required\.

1. Choose **Create**\.

   You will reference this security group later in this tutorial in [Step 3: Create an Amazon EC2 Instance and Set Up the Hyperledger Fabric Client](get-started-create-client.md)\.

## Additional Considerations<a name="additional-considerations"></a>
+ All commands in the tutorial assume that you are using an Amazon EC2 instance with an Amazon Linux AMI\. Unless noted otherwise, instructions also assume that you are running commands in the default home directory \(`/home/ec2-user`\)\. If you have a different configuration, modify instructions to fit your home directory as necessary\.
+ Hyperledger Fabric 1\.2 requires that a channel ID contain only lowercase ASCII alphanumeric characters, dots \(\.\), and dashes \(\-\)\. It must start with a letter, and must be fewer than 250 characters\.
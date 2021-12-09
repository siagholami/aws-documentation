# Using Cloud Directory Interface VPC Endpoints<a name="getting_started_using_vpc_endpoints"></a>

If you use Amazon Virtual Private Cloud \(Amazon VPC\) to host your AWS resources, you can establish a private connection between your VPC and Cloud Directory\. You can use this connection to enable Cloud Directory to communicate with your resources on your VPC without going through the public internet\.

Amazon VPC is an AWS service that you can use to launch AWS resources in a virtual network that you define\. With a VPC, you have control over your network settings, such as the IP address range, subnets, route tables, and network gateways\. To connect your VPC to Cloud Directory, you define an *interface VPC endpoint* for Cloud Directory\. The endpoint provides reliable, scalable connectivity to Cloud Directory without requiring an internet gateway, network address translation \(NAT\) instance, or VPN connection\. For more information, see [What Is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Introduction.html) in the *Amazon VPC User Guide*\.

Interface VPC endpoints are powered by AWS PrivateLink, an AWS technology that enables private communication between AWS services using an elastic network interface with private IP addresses\. For more information, see [AWS PrivateLink for AWS Services](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Introduction.html#what-is-privatelink)\.

The following steps are for users of Amazon VPC\. For more information, see [Getting Started with Amazon VPC](https://docs.aws.amazon.com/vpc/latest/userguide/GetStarted.html) in the *Amazon VPC User Guide*\.

## Availability<a name="vpc_endpoints_availability"></a>

Cloud Directory currently supports VPC endpoints in the following Regions:
+ US East \(Ohio\)
+ US East \(N\. Virginia\)
+ US West \(Oregon\)
+ Asia Pacific \(Singapore\)
+ Asia Pacific \(Sydney\)
+ Canada \(Central\)
+ Europe \(Frankfurt\)
+ Europe \(Ireland\)
+ Europe \(London\)
+ AWS GovCloud \(US\-West\)

## Create a VPC for Cloud Directory<a name="vpc_endpoints_create"></a>

To start using Cloud Directory with your VPC, use the Amazon VPC console to create an interface VPC endpoint for Cloud Directory\. For more information, see [Creating an Interface Endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#create-interface-endpoint)\. 
+ For **Service Category**, choose **AWS services**\.
+ For **Service Name**, choose **`com.amazonaws.region.clouddirectory`**\. This creates a VPC endpoint for Cloud Directory operations\.

For general information, see [What is Amazon VPC?](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html) in the *Amazon VPC User Guide*\.

### Control Access to Your Cloud Directory VPC Endpoint<a name="vpc_endpoints_control_access"></a>

A VPC endpoint policy is an IAM resource policy that you attach to an endpoint when you create or modify the endpoint\. If you don't attach a policy when you create an endpoint, we attach a default policy for you that allows full access to the service\. An endpoint policy doesn't override or replace IAM user policies or service\-specific policies\. It's a separate policy for controlling access from the endpoint to the specified service\.

Endpoint policies must be written in JSON format\. For more information, see [Controlling Access to Services with VPC Endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints-access.html) in the *Amazon VPC User Guide*\.

The following is an example of an endpoint policy for Cloud Directory\. This policy enables users connecting to Cloud Directory through the VPC to list directories and prevents them from performing other Cloud Directory actions\.

```
{
  "Statement": [
    {
      "Sid": "ReadOnly",
      "Principal": "*",
      "Action": [
        "clouddirectory:ListDirectories"
      ],
      "Effect": "Allow",
      "Resource": "*"
    }
  ]
}
```

**To modify the VPC endpoint policy for Cloud Directory**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the navigation pane, choose **Endpoints**\.

1. If you have not already created the endpoint for Cloud Directory, choose **Create Endpoint**\. Then select **`com.amazonaws.region.clouddirectory`** and choose **Create endpoint**\.

1. Select the **`com.amazonaws.region.clouddirectory`** endpoint and choose the **Policy** tab in the lower half of the screen\.

1. Choose **Edit Policy** and make the changes to the policy\.

For more information, see [Controlling Access to Services with VPC Endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/GetStarted.html) in the *Amazon VPC User Guide*\.
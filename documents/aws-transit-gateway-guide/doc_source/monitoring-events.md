# Monitoring your global network with CloudWatch Events<a name="monitoring-events"></a>

CloudWatch Events delivers a near\-real\-time stream of system events that describe changes in your resources\. Using simple rules that you can quickly set up, you can match events and route them to one or more target functions or streams\. For more information, see the [Amazon CloudWatch Events User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/)\.

Transit Gateway Network Manager sends the following types of events to CloudWatch Events:
+ Topology changes
+ Routing updates
+ Status updates

## Getting started<a name="monitoring-events-onboarding"></a>

Before you can view events for your global network, you must onboard to CloudWatch Logs Insights\. In the Network Manager console, choose the ID of your global network\. In the **Network events summary** section, choose **Onboard to CloudWatch Log Insights**\.

An IAM principal in your account, such as an IAM user, must have sufficient permissions to onboard to CloudWatch Logs Insights\. Ensure that the IAM policy contains the following permissions\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "events:PutTargets",
                "events:DescribeRule",
                "logs:PutResourcePolicy",
                "logs:DescribeLogGroups",
                "logs:DescribeResourcePolicies",
                "events:PutRule",
                "logs:CreateLogGroup"
            ],
            "Resource": "*"
        }
    ]
}
```

The preceding policy does not grant permission to create, modify, or delete Network Manager resources\. For more information about IAM policies for working with Network Manager, see [Identity and access management for Transit Gateway Network Manager](nm-security-iam.md)\.

When you onboard to CloudWatch Logs Insights, the following occurs:
+ A CloudWatch event rule with the name `DON_NOT_DELETE_networkmanager_rule` is created in the US West \(Oregon\) Region\.
+ A CloudWatch Logs log group with the name `/aws/events/networkmanagerloggroup` is created in the US West \(Oregon\) Region\.
+ The CloudWatch event rule is configured with the CloudWatch Logs log group as a target\.
+ A CloudWatch resource policy with the name `DON_NOT_DELETE_networkmanager_TrustEventsToStoreLogEvents` is created in the US West \(Oregon\) Region\. To view this policy, use the following AWS CLI command: `aws logs describe-resource-policies --region us-west-2`

To view events for your global network in the Network Manager console, choose the ID of your global network, and choose **Events**\. 

## Topology change events<a name="network-topology-events"></a>

Topology change events occur when there have been changes to the resources in your global network\. These events include the following:
+ A transit gateway was registered in the global network
+ A transit gateway was deregistered from the global network
+ A transit gateway in the global network was deleted
+ A VPN connection was created for a transit gateway
+ A VPN connection was deleted on a transit gateway
+ The customer gateway for a VPN connection was changed
+ The target gateway for a VPN connection was changed
+ A VPC was attached to a transit gateway
+ A VPC was detached from a transit gateway
+ An AWS Direct Connect gateway was attached to a transit gateway
+ An AWS Direct Connect gateway was detached from a transit gateway
+ A transit gateway peering connection attachment was created
+ A transit gateway peering connection attachment was deleted

The following is an example of an event where a transit gateway VPC attachment was deleted \(the VPC was detached from the transit gateway\)\.

```
{
  "account": "123456789012",
  "region": "us-west-2",
  "detail-type": "Network Manager Topology Change",
  "source": "aws.networkmanager",
  "version": "0",
  "time": "2019-06-30T23:18:50Z",
  "id": "fb1d3015-c091-4bf9-95e2-d9example",
  "resources": [
     "arn:aws:networkmanager::123456789012:global-network/global-network-08eb4a99cb6example",
     "arn:aws:ec2:us-east-1:123456789012:transit-gateway/tgw-11111111111122222"
  ],
  "detail": {
     "change-type": "VPC-ATTACHMENT-DELETED",
     "change-description": "A VPC attachment has been deleted.",
     "region": "us-east-1",
     "transit-gateway-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway/tgw-11111111111122222",
     "transit-gateway-attachment-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway-attachment/tgw-attach-012345678abc12345",
     "vpc-arn": "arn:aws:ec2:us-east-1:123456789012:vpc/vpc-11223344556677aab"
  }
}
```

## Routing update events<a name="routing-changes-events"></a>

Routing update events occur when there have been changes to the transit gateway route tables in your global network\. These events include the following:
+ A transit gateway attachment's route table association changed
+ A route was created in a transit gateway route table
+ A route was deleted in a transit gateway route table

The following is an example of an event where a transit gateway route table was associated with an attachment\.

```
{
  "account": "123456789012",
  "region": "us-west-2",
  "detail-type": "Network Manager Routing Update",
  "source": "aws.networkmanager",
  "version": "0",
  "time": "2019-06-30T23:18:50Z",
  "id": "fb1d3015-c091-4bf9-95e2-d9852example",
  "resources": [
     "arn:aws:networkmanager::123456789012:global-network/global-network-08eb4a99cb6example",
     "arn:aws:ec2:us-east-1:123456789012:transit-gateway/tgw-11111111111122222"
  ],
  "detail": {
     "change-type": "TGW-ROUTE-TABLE-ASSOCIATED",
     "change-description": "A Transit Gateway attachment has been associated to a route table.",
     "region": "us-east-1",
     "transit-gateway-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway/tgw-11111111111122222",
     "transit-gateway-attachment-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway-attachment/tgw-attach-012345678abc12345",
     "transit-gateway-route-table-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway-route-table/tgw-rtb--123abc123abc123ab"
  }
}
```

## Status update events<a name="network-status-events"></a>

Status update events occur when there have been changes to the status of the connectivity of your VPN connections in the global network\. These events include the following:
+ A VPN tunnel's IPsec session went down
+ A VPN tunnel's IPsec session went up \(after being down\)
+ A VPN tunnel's BGP session went down
+ A VPN tunnel's BGP session went up \(after being down\)

The following is an example of an event where a VPN tunnel's IPsec session came up\.

```
{
  "account": "123456789012",
  "region": "us-west-2",
  "detail-type": "Network Manager Status Update",
  "source": "aws.networkmanager",
  "version": "0",
  "time": "2019-06-30T23:18:50Z",
  "id": "fb1d3015-c091-4bf9-95e2-d98example",
  "resources": [
     "arn:aws:networkmanager::123456789012:global-network/global-network-08eb4a99cb6example",
     "arn:aws:ec2:us-east-1:123456789012:vpn-connection/vpn-33333333333344444"
  ],
  "detail": {
     "status-change": "VPN-CONNECTION-IPSEC-UP",
     "change-description": "IPsec for a VPN connection has come up.",
     "region": "us-east-1",
     "transit-gateway-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway/tgw-11111111111122222",
     "transit-gateway-attachment-arn": "arn:aws:ec2:us-east-1:123456789012:transit-gateway-attachment/tgw-attach-1122334455aaaaaaa",
     "vpn-connection-arn": "arn:aws:ec2:us-east-1:123456789012:vpn-connection/vpn-33333333333344444",
     "outside-ip-address": "198.51.100.3"
  }
}
```
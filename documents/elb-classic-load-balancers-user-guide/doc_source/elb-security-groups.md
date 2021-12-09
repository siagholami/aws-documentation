# Configure security groups for your Classic Load Balancer<a name="elb-security-groups"></a>

A *security group* acts as a firewall that controls the traffic allowed to and from one or more instances\. When you launch an EC2 instance, you can associate one or more security groups with the instance\. For each security group, you add one or more rules to allow traffic\. You can modify the rules for a security group at any time; the new rules are automatically applied to all instances associated with the security group\. For more information, see [Amazon EC2 security groups](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-network-security.html) in the *Amazon EC2 User Guide for Linux Instances*\.

There is a significant difference between the way Classic Load Balancers support security groups in EC2\-Classic and in a VPC\. In EC2\-Classic, the load balancer provides a special source security group that you can use to ensure that instances receive traffic only from your load balancer\. You can't modify this source security group\. In a VPC, you provide the security group for your load balancer, which enables you to choose the ports and protocols to allow\. For example, you can open Internet Control Message Protocol \(ICMP\) connections for the load balancer to respond to ping requests \(however, ping requests are not forwarded to any instances\)\.

In both EC2\-Classic and in a VPC, you must ensure that the security groups for your instances allow the load balancer to communicate with your instances on both the listener port and the health check port\. In a VPC, your security groups and network access control lists \(ACL\) must allow traffic in both directions on these ports\.

**Topics**
+ [Security groups for load balancers in a VPC](#elb-vpc-security-groups)
+ [Security groups for instances in a VPC](#elb-vpc-instance-security-groups)
+ [Network ACLs for load balancers in a VPC](#elb-vpc-nacl)
+ [Security groups for instances in EC2\-Classic](#elb-classic-security-groups)

## Security groups for load balancers in a VPC<a name="elb-vpc-security-groups"></a>

When you use the AWS Management Console to create a load balancer in a VPC, you can choose an existing security group for the VPC or create a new security group for the VPC\. If you choose an existing security group, it must allow traffic in both directions to the listener and health check ports for the load balancer\. If you choose to create a security group, the console automatically adds rules to allow all traffic on these ports\.

\[Nondefault VPC\] If you use the AWS CLI or API create a load balancer in a nondefault VPC, but you don't specify a security group, your load balancer is automatically associated with the default security group for the VPC\.

\[Default VPC\] If you use the AWS CLI or API to create a load balancer in your default VPC, you can't choose an existing security group for your load balancer\. Instead, Elastic Load Balancing provides a security group with rules to allow all traffic on the ports specified for the load balancer\. Elastic Load Balancing creates only one such security group per AWS account, with a name of the form default\_elb\_*id* \(for example, `default_elb_fc5fbed3-0405-3b7d-a328-ea290EXAMPLE`\)\. Subsequent load balancers that you create in the default VPC also use this security group\. Be sure to review the security group rules to ensure that they allow traffic on the listener and health check ports for the new load balancer\. When you delete your load balancer, this security group is not deleted automatically\.

If you add a listener to an existing load balancer, you must review your security groups to ensure they allow traffic on the new listener port in both directions\.

**Topics**
+ [Recommended rules for load balancer security groups](#recommended-sg-rules)
+ [Manage security groups using the console](#assign-sg-console)
+ [Manage security groups using the AWS CLI](#assign-sg-cli)

### Recommended rules for load balancer security groups<a name="recommended-sg-rules"></a>

The security groups for your load balancers must allow them to communicate with your instances\. The recommended rules depend on the type of load balancer \(internet\-facing or internal\)\.

The following table shows the recommended rules for an internet\-facing load balancer\.


| 
| 
| Inbound | 
| --- |
|  Source  |  Protocol  |  Port Range  |  Comment  | 
| 0\.0\.0\.0/0 | TCP | *listener* | Allow all inbound traffic on the load balancer listener port | 
|   Outbound   | 
| --- |
|  Destination  |  Protocol  |  Port Range  |  Comment  | 
| *instance security group* | TCP | *instance listener* | Allow outbound traffic to instances on the instance listener port | 
| *instance security group* | TCP | *health check* | Allow outbound traffic to instances on the health check port | 

The following table shows the recommended rules for an internal load balancer\.


| 
| 
| Inbound | 
| --- |
|  Source  |  Protocol  |  Port Range  |  Comment  | 
| *VPC CIDR* | TCP | *listener* | Allow inbound traffic from the VPC CIDR on the load balancer listener port | 
|   Outbound   | 
| --- |
|  Destination  |  Protocol  |  Port Range  |  Comment  | 
| *instance security group* | TCP | *instance listener* | Allow outbound traffic to instances on the instance listener port | 
| *instance security group* | TCP | *health check* | Allow outbound traffic to instances on the health check port | 

### Manage security groups using the console<a name="assign-sg-console"></a>

Use the following procedure to change the security groups associated with your load balancer in a VPC\.

**To update a security group assigned to your load balancer**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Description** tab, choose **Edit security groups**\.

1. On the **Edit security groups** page, select or clear security groups as needed\.

1. When you are finished, choose **Save**\.

### Manage security groups using the AWS CLI<a name="assign-sg-cli"></a>

Use the following [apply\-security\-groups\-to\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/apply-security-groups-to-load-balancer.html) command to associate a security group with a load balancer in a VPC\. The specified security groups override the previously associated security groups\.

```
aws elb apply-security-groups-to-load-balancer --load-balancer-name my-loadbalancer --security-groups sg-53fae93f
```

The following is an example response:

```
{
  "SecurityGroups": [
     "sg-53fae93f"
  ]
}
```

## Security groups for instances in a VPC<a name="elb-vpc-instance-security-groups"></a>

The security groups for your instances must allow them to communicate with the load balancer\. The following table shows the recommended rules\.


| 
| 
| Inbound | 
| --- |
|  Source  |  Protocol  |  Port Range  |  Comment  | 
| *load balancer security group* | TCP | *instance listener* | Allow traffic from the load balancer on the instance listener port | 
| *load balancer security group* | TCP | *health check* | Allow traffic from the load balancer on the health check port | 

We also recommend that you allow inbound ICMP traffic to support Path MTU Discovery\. For more information, see [Path MTU Discovery](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/network_mtu.html#path_mtu_discovery) in the *Amazon EC2 User Guide for Linux Instances*\.

## Network ACLs for load balancers in a VPC<a name="elb-vpc-nacl"></a>

The default network access control list \(ACL\) for the VPC allows all inbound and outbound traffic\. If you create custom network ACLs, you must add rules that allow the load balancer and instances to communicate\.

The recommended rules for the subnet for your load balancer depend on the type of load balancer \(internet\-facing or internal\)\.

The following are the recommended rules for an internet\-facing load balancer\.


| 
| 
|  Inbound  | 
| --- |
| Source | Protocol | Port | Comment | 
|  0\.0\.0\.0/0  |  TCP  |  *listener*  |  Allow all inbound traffic on the load balancer listener port  | 
|  *VPC CIDR*  |  TCP  |  1024\-65535  |  Allow inbound traffic from the VPC CIDR on the ephemeral ports  | 
|   Outbound   | 
| --- |
| Destination | Protocol | Port | Comment | 
|  *VPC CIDR*  |  TCP  |  *instance listener*  |  Allow all outbound traffic on the instance listener port  | 
|  *VPC CIDR*  |  TCP  |  *health check*  |  Allow all outbound traffic on the health check port  | 
|  0\.0\.0\.0/0  |  TCP  |  1024\-65535  |  Allow all outbound traffic on the ephemeral ports  | 

The following are the recommended rules for an internal load balancer\.


| 
| 
|  Inbound  | 
| --- |
| Source | Protocol | Port | Comment | 
|  *VPC CIDR*  |  TCP  |  *listener*  |  Allow inbound traffic from the VPC CIDR on the load balancer listener port  | 
|  *VPC CIDR*  |  TCP  |  1024\-65535  |  Allow inbound traffic from the VPC CIDR on the ephemeral ports  | 
|   Outbound   | 
| --- |
| Destination | Protocol | Port | Comment | 
|  *VPC CIDR*  |  TCP  |  *instance listener*  |  Allow outbound traffic to the VPC CIDR on the instance listener port  | 
|  *VPC CIDR*  |  TCP  |  *health check*  |  Allow outbound traffic to the VPC CIDR on the health check port  | 
|  *VPC CIDR*  |  TCP  |  1024\-65535  |  Allow outbound traffic to the VPC CIDR on the ephemeral ports  | 

The recommended rules for the subnet for your instances depend on whether the subnet is private or public\. The following rules are for a private subnet\. If your instances are in a public subnet, change the source and destination from the CIDR of the VPC to `0.0.0.0/0`\.


| 
| 
|  Inbound  | 
| --- |
| Source | Protocol | Port | Comment | 
|  *VPC CIDR*  |  TCP  |  *instance listener*  |  Allow inbound traffic from the VPC CIDR on the instance listener port  | 
|  *VPC CIDR*  |  TCP  |  *health check*  |  Allow inbound traffic from the VPC CIDR on the health check port  | 
|   Outbound   | 
| --- |
| Destination | Protocol | Port | Comment | 
|  *VPC CIDR*  |  TCP  |  1024\-65535  |  Allow outbound traffic to the VPC CIDR on the ephemeral ports  | 

## Security groups for instances in EC2\-Classic<a name="elb-classic-security-groups"></a>

To allow communication between your load balancer and your instances launched in EC2\-Classic, create an inbound rule for the security group for your instances that allows inbound traffic from either all IP addresses \(using the `0.0.0.0/0` CIDR block\) or only from the load balancer \(using the source security group provided by Elastic Load Balancing\)\.

Use the following procedure to lock down traffic between your load balancer and your instances in EC2\-Classic\.

**To lock down traffic between your load balancer and instances using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Description** tab, copy the name of the source security group\.  
![\[ELB Source Security Group\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/ELB-SourceSecurityGroup.png)

1. On the **Instances** tab, select the instance ID of one of the instances registered with your load balancer\.

1. On the **Description** tab, for **Security groups**, select the name of the security group\.

1. On the **Inbound** tab, choose **Edit**, **Add Rule**\.

1. From the **Type** column, select the protocol type\. The **Protocol** and **Port Range** columns are populated\. From the **Source** column, select `Custom IP` and then paste the name of the source security group that you copied earlier \(for example, `amazon-elb/amazon-elb-sg`\)\.

1. \(Optional\) If your security group has rules that are less restrictive than the rule that you just added, remove the less restrictive rule using its delete icon\.

**To lock down traffic between your load balancer and instances using the AWS CLI**

1. Use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to display the name and owner of the source security group for your load balancer:

   ```
   aws elb describe-load-balancers --load-balancer-name my-loadbalancer
   ```

   The response includes the name and owner in the `SourceSecurityGroup` field\. For example:

   ```
   {
       "LoadBalancerDescriptions": [
           {
               ...
               "SourceSecurityGroup": {
                   "OwnerAlias": "amazon-elb", 
                   "GroupName": "amazon-elb-sg"
               }
           }
       ]
   }
   ```

1. Add a rule to the security group for your instances as follows:

   1. If you do not know the name of the security group for your instances, use the following [describe\-instances](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-instances.html) command to get the name and ID of the security group for the specified instance:

      ```
      aws ec2 describe-instances --instance-ids i-315b7e51
      ```

      The response includes the name and ID of the security group in the `SecurityGroups` field\. Make a note of the name of the security group; you'll use it in the next step\.

   1. Use the following [authorize\-security\-group\-ingress](https://docs.aws.amazon.com/cli/latest/reference/ec2/authorize-security-group-ingress.html) command to add a rule to the security group for your instance to allow traffic from your load balancer:

      ```
      aws ec2 authorize-security-group-ingress --group-name my-security-group --source-security-group-name amazon-elb-sg  --source-security-group-owner-id amazon-elb
      ```

1. \(Optional\) Use the following [describe\-security\-groups](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-security-groups.html) command to verify that the security group has the new rule:

   ```
   aws ec2 describe-security-groups --group-names my-security-group
   ```

   The response includes a `UserIdGroupPairs` data structure that lists the security groups that are granted permissions to access the instance\. 

   ```
   {
       "SecurityGroups": [
           {
               ...
               "IpPermissions": [
                   {
                       "IpRanges": [],
                       "FromPort": -1,
                       "IpProtocol": "icmp",
                       "ToPort": -1,
                       "UserIdGroupPairs": [
                           {
                               "GroupName": "amazon-elb-sg",
                               "GroupId": "sg-5a9c116a",
                               "UserId": "amazon-elb"
                           }
                       ]
                   },
                   {
                       "IpRanges": [],
                       "FromPort": 1,
                       "IpProtocol": "tcp",
                       "ToPort": 65535,
                       "UserIdGroupPairs": [
                           {
                               "GroupName": "amazon-elb-sg",
                               "GroupId": "sg-5a9c116a",
                               "UserId": "amazon-elb"
                           }
                       ]
                   },
                   {
                       "IpRanges": [],
                       "FromPort": 1,
                       "IpProtocol": "udp",
                       "ToPort": 65535,
                       "UserIdGroupPairs": [
                           {
                               "GroupName": "amazon-elb-sg",
                               "GroupId": "sg-5a9c116a",
                               "UserId": "amazon-elb"
                           }
                       ]
                   },
                   . . .  
   }
   ```

1. \(Optional\) If your security group has rules that are less restrictive than the rule you just added, use the [revoke\-security\-group\-ingress](https://docs.aws.amazon.com/cli/latest/reference/ec2/revoke-security-group-ingress.html) command to remove the less restrictive rules\. For example, the following command removes a rule that allows TCP traffic from everyone \(CIDR range `0.0.0.0/0`\):

   ```
   aws ec2 revoke-security-group-ingress --group-name my-security-group --protocol tcp --port 80 --cidr 0.0.0.0/0
   ```
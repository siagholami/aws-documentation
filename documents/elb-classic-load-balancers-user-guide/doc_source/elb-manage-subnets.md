# Add or remove subnets for your Classic Load Balancer in a VPC<a name="elb-manage-subnets"></a>

When you add a subnet to your load balancer, Elastic Load Balancing creates a load balancer node in the Availability Zone\. Load balancer nodes accept traffic from clients and forward requests to the healthy registered instances in one or more Availability Zones\. For load balancers in a VPC, we recommend that you add one subnet per Availability Zone for at least two Availability Zones\. This improves the availability of your load balancer\. Note that you can modify the subnets for your load balancer at any time\.

Select subnets from the same Availability Zones as your instances\. If your load balancer is an internet\-facing load balancer, you must select public subnets in order for your back\-end instances to receive traffic from the load balancer \(even if the back\-end instances are in private subnets\)\. If your load balancer is an internal load balancer, we recommend that you select private subnets\. For more information about subnets for your load balancer, see [Prepare your VPC and EC2 instances](elb-backend-instances.md#set-up-ec2)\.

After you add a subnet, the load balancer starts routing requests to the registered instances in the corresponding Availability Zone\. By default, the load balancer routes requests evenly across the Availability Zones for its subnets\. To route requests evenly across the registered instances in the Availability Zones for its subnets, enable cross\-zone load balancing\. For more information, see [Configure cross\-zone load balancing for your Classic Load Balancer](enable-disable-crosszone-lb.md)\.

You might want to remove a subnet from your load balancer temporarily when its Availability Zone has no healthy registered instances, or when you want to troubleshoot or update the registered instances\. After you've removed a subnet, the load balancer stops routing requests to the registered instances in its Availability Zone, but continues to route requests to the registered instances in the Availability Zones for the remaining subnets\.

If your load balancer is in EC2\-Classic, see [Add or remove Availability Zones for your load balancer in EC2\-Classic](enable-disable-az.md)\.

**Topics**
+ [Requirements](#elb-subnet-requirements)
+ [Add a subnet](#attach-subnet)
+ [Remove a subnet](#remove-subnet)

## Requirements<a name="elb-subnet-requirements"></a>

When you update the subnets for your load balancer, you must meet the following requirements:
+ The load balancer must have at least one subnet at all times\.
+ You can add at most one subnet per Availability Zone\.
+ You cannot add a Local Zone subnet\.

Because there are separate APIs to add and remove subnets from a load balancer, you must consider the order of operations carefully when swapping the current subnets for new subnets in order to meet these requirements\. Also, you must temporarily add a subnet from another Availability Zone if you need to swap all subnets for your load balancer\. For example, if your load balancer has a single Availability Zone and you need to swap its subnet for another subnet, you must first add a subnet from a second Availability Zone\. Then you can remove the subnet from the original Availability Zone \(without going below one subnet\), add a new subnet from the original Availability Zone \(without exceeding one subnet per Availability Zone\), and then remove the subnet from the second Availability Zone \(if it is only needed to perform the swap\)\.

## Add a subnet<a name="attach-subnet"></a>

You can expand the availability of your load balancer to an additional subnet\. Register the instances in this subnet with the load balancer, then attach a subnet to the load balancer that is from the same Availability Zone as the instances\. For more information, see [Register or deregister EC2 instances for your Classic Load Balancer](elb-deregister-register-instances.md)\.

**To add a subnet to your load balancer using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. In the bottom pane, select the **Instances** tab\.

1. Choose **Edit Availability Zones**\.

1. For **Available Subnets**, select the subnet using its add \(\+\) icon\. The subnet is moved under **Selected subnets**\.

   Note that you can select at most one subnet per Availability Zone\. If you select a subnet from an Availability Zone where there is already an selected subnet, this subnet replaces the currently selected subnet for the Availability Zone\.

1. Choose **Save**\.

**To add a subnet to your load balancer using the CLI**  
Use the following [attach\-load\-balancer\-to\-subnets](https://docs.aws.amazon.com/cli/latest/reference/elb/attach-load-balancer-to-subnets.html) command to add two subnets to your load balancer:

```
aws elb attach-load-balancer-to-subnets --load-balancer-name my-load-balancer --subnets subnet-dea770a9 subnet-fb14f6a2
```

The response lists all subnets for the load balancer\. For example:

```
{
    "Subnets": [
        "subnet-5c11033e",
        "subnet-dea770a9",
        "subnet-fb14f6a2"
    ]
}
```

## Remove a subnet<a name="remove-subnet"></a>

You can remove a subnet from your load balancer\. Note that after you remove a subnet, the instances in that subnet remain registered with the load balancer\. For more information, see [Register or deregister EC2 instances for your Classic Load Balancer](elb-deregister-register-instances.md)\.

**To remove a subnet using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. In the bottom pane, select the **Instances** tab\.

1. Choose **Edit Availability Zones**\.

1. For **Selected subnets**, remove the subnet using its delete \(\-\) icon\. The subnet is moved under **Available Subnets**\.

1. Choose **Save**\.

**To remove a subnet using the AWS CLI**  
Use the following [detach\-load\-balancer\-from\-subnets](https://docs.aws.amazon.com/cli/latest/reference/elb/detach-load-balancer-from-subnets.html) command to remove the specified subnets from the specified load balancer:

```
aws elb detach-load-balancer-from-subnets --load-balancer-name my-loadbalancer --subnets subnet-450f5127
```

The response lists the remaining subnets for the load balancer\. For example:

```
{
    "Subnets": [
        "subnet-15aaab61"
    ]
}
```
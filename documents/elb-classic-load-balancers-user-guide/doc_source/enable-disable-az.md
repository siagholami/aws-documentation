# Add or remove Availability Zones for your load balancer in EC2\-Classic<a name="enable-disable-az"></a>

When you add an Availability Zone to your load balancer, Elastic Load Balancing creates a load balancer node in the Availability Zone\. Load balancer nodes accept traffic from clients and forward requests to the healthy registered instances in one or more Availability Zones\.

You can set up your load balancer in EC2\-Classic to distribute incoming requests across EC2 instances in a single Availability Zone or multiple Availability Zones\. First, launch EC2 instances in all the Availability Zones that you plan to use\. Next, register these instances with your load balancer\. Finally, add the Availability Zones to your load balancer\. After you add an Availability Zone, the load balancer starts routing requests to the registered instances in that Availability Zone\. Note that you can modify the Availability Zones for your load balancer at any time\.

By default, the load balancer routes requests evenly across its Availability Zones\. To route requests evenly across the registered instances in the Availability Zones, enable cross\-zone load balancing\. For more information, see [Configure cross\-zone load balancing for your Classic Load Balancer](enable-disable-crosszone-lb.md)\.

You might want to remove an Availability Zone from your load balancer temporarily when it has no healthy registered instances or when you want to troubleshoot or update the registered instances\. After you've removed an Availability Zone, the load balancer stops routing requests to the registered instances in this Availability Zone but continues to route requests to the registered instances in the remaining Availability Zones\.

If your load balancer is in a VPC, see [Add or remove subnets for your Classic Load Balancer in a VPC](elb-manage-subnets.md)\.

**Topics**
+ [Add an Availability Zone](#add-availability-zone)
+ [Remove an Availability Zone](#remove-availability-zone)

## Add an Availability Zone<a name="add-availability-zone"></a>

You can expand the availability of your application to an additional Availability Zone\. Register the instances in this Availability Zone with the load balancer, then add the Availability Zone\. For more information, see [Register or deregister EC2 instances for your Classic Load Balancer](elb-deregister-register-instances.md)\.

**To add an Availability Zone using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Instances** tab, choose **Edit Availability Zones**\.

1. On the **Add and Remove Availability Zones** page, select the Availability Zone\.

1. Choose **Save**\.

**To add an Availability Zone using the AWS CLI**  
Use the following [enable\-availability\-zones\-for\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/enable-availability-zones-for-load-balancer.html) command to add an Availability Zone:

```
aws elb enable-availability-zones-for-load-balancer --load-balancer-name my-loadbalancer --availability-zones us-west-2b
```

The response lists all Availability Zones for the load balancer\. For example:

```
{
  "AvailabilityZones": [
    "us-west-2a",
    "us-west-2b"
  ]
}
```

## Remove an Availability Zone<a name="remove-availability-zone"></a>

You can remove an Availability Zone from your load balancer\. Note that after you remove an Availability Zone, the instances in that Availability Zone remain registered with the load balancer\. For more information, see [Register or deregister EC2 instances for your Classic Load Balancer](elb-deregister-register-instances.md)\.

**To remove an Availability Zone using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Instances** tab, choose **Edit Availability Zones**\.

1. On the **Add and Remove Availability Zones** page, clear the Availability Zone\.

1. Choose **Save**\.

**To remove an Availability Zone using the AWS CLI**  
Use the following [disable\-availability\-zones\-for\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/disable-availability-zones-for-load-balancer.html) command:

```
aws elb disable-availability-zones-for-load-balancer --load-balancer-name my-loadbalancer --availability-zones us-west-2a
```

The response lists the remaining Availability Zones for the load balancer\. For example:

```
{
    "AvailabilityZones": [
        "us-west-2b"
    ]
}
```
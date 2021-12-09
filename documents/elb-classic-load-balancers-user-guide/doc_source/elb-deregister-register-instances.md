# Register or deregister EC2 instances for your Classic Load Balancer<a name="elb-deregister-register-instances"></a>

Registering an EC2 instance adds it to your load balancer\. The load balancer continuously monitors the health of registered instances in its enabled Availability Zones, and routes requests to the instances that are healthy\. If demand on your instances increases, you can register additional instances with the load balancer to handle the demand\.

Deregistering an EC2 instance removes it from your load balancer\. The load balancer stops routing requests to an instance as soon as it is deregistered\. If demand decreases, or you need to service your instances, you can deregister instances from the load balancer\. An instance that is deregistered remains running, but no longer receives traffic from the load balancer, and you can register it with the load balancer again when you are ready\.

When you deregister an instance, Elastic Load Balancing waits until in\-flight requests have completed if connection draining is enabled\. For more information, see [Configure connection draining for your Classic Load Balancer](config-conn-drain.md)\.

If your load balancer is attached to an Auto Scaling group, instances in the group are automatically registered with the load balancer\. If you detach a load balancer from your Auto Scaling group, the instances in the group are deregistered\.

Elastic Load Balancing registers your EC2 instance with your load balancer using its IP address\.

\[EC2\-VPC\] When you register an instance with an elastic network interface \(ENI\) attached, the load balancer routes requests to the primary IP address of the primary interface \(eth0\) of the instance\.

**Topics**
+ [Prerequisites](#elb-register-instances-prereq)
+ [Register an instance](#elb-register-instances)
+ [Deregister an instance](#elb-deregister-instances)

## Prerequisites<a name="elb-register-instances-prereq"></a>

The instance must be a running instance in the same network as the load balancer \(EC2\-Classic or the same VPC\)\. If you have EC2\-Classic instances and a load balancer in a VPC with ClassicLink enabled, you can link the EC2\-Classic instances to that VPC and then register them with a load balancer in the VPC\.

## Register an instance<a name="elb-register-instances"></a>

When you are ready, register your instance with your load balancer\. If the instance is an in Availability Zone that is enabled for the load balancer, the instance is ready to receive traffic from the load balancer as soon as it passes the required number of health checks\.

**To register your instances using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. In the bottom pane, select the **Instances** tab\.

1. Choose **Edit Instances**\.

1. Select the instance to register with your load balancer\.

1. Choose **Save**\.

**To register your instances using the AWS CLI**  
Use the following [register\-instances\-with\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/register-instances-with-load-balancer.html) command:

```
aws elb register-instances-with-load-balancer --load-balancer-name my-loadbalancer --instances i-4e05f721
```

The following is an example response that lists the instances registered with the load balancer:

```
{
    "Instances": [
        {
            "InstanceId": "i-315b7e51"
        }, 
        {
            "InstanceId": "i-4e05f721"
        }
    ]
}
```

## Deregister an instance<a name="elb-deregister-instances"></a>

You can deregister an instance from your load balancer if you no longer need the capacity or if you need to service the instance\.

If your load balancer is attached to an Auto Scaling group, detaching the instance from the group also deregisters it from the load balancer\. For more information, see [Detach EC2 instances from your Auto Scaling group](https://docs.aws.amazon.com/autoscaling/ec2/userguide/detach-instance-asg.html) in the *Amazon EC2 Auto Scaling User Guide*\.

**To deregister your instances using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. In the bottom pane, select the **Instances** tab\.

1. In **Actions** column for the instance, choose **Remove from Load Balancer**\.

1. When prompted for confirmation, choose **Yes, Remove**\.

**To deregister your instances using the AWS CLI**  
Use the following [deregister\-instances\-from\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/deregister-instances-from-load-balancer.html) command:

```
aws elb deregister-instances-from-load-balancer --load-balancer-name my-loadbalancer --instances i-4e05f721
```

The following is an example response that lists the remaining instances registered with the load balancer:

```
{
    "Instances": [
        {
            "InstanceId": "i-315b7e51"
        }
    ]
}
```
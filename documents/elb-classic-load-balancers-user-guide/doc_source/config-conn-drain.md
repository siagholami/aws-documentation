# Configure connection draining for your Classic Load Balancer<a name="config-conn-drain"></a>

To ensure that a Classic Load Balancer stops sending requests to instances that are de\-registering or unhealthy, while keeping the existing connections open, use *connection draining*\. This enables the load balancer to complete in\-flight requests made to instances that are de\-registering or unhealthy\.

When you enable connection draining, you can specify a maximum time for the load balancer to keep connections alive before reporting the instance as de\-registered\. The maximum timeout value can be set between 1 and 3,600 seconds \(the default is 300 seconds\)\. When the maximum time limit is reached, the load balancer forcibly closes connections to the de\-registering instance\.

While in\-flight requests are being served, the load balancer reports the state of a de\-registering instance as `InService: Instance deregistration currently in progress`\. When the de\-registering instance is finished serving all in\-flight requests, or when the maximum timeout limit is reached, the load balancer reports the instance state as `OutOfService: Instance is not currently registered with the LoadBalancer`\.

If an instance becomes unhealthy, the load balancer reports the instance state as `OutOfService`\. If there are in\-flight requests made to the unhealthy instance, they are completed\. The maximum timeout limit does not apply to connections to unhealthy instances\.

If your instances are part of an Auto Scaling group and connection draining is enabled for your load balancer, Auto Scaling waits for the in\-flight requests to complete, or for the maximum timeout to expire, before terminating instances due to a scaling event or health check replacement\.

You can disable connection draining if you want your load balancer to immediately close connections to the instances that are de\-registering or have become unhealthy\. When connection draining is disabled, any in\-flight requests made to instances that are de\-registering or unhealthy are not completed\.

**Topics**
+ [Enable connection draining](#enable-conn-drain)
+ [Disable connection draining](#disable-conn-drain)

## Enable connection draining<a name="enable-conn-drain"></a>

You can enable connection draining for your load balancer at any time\.

**To enable connection draining using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Instances** tab, for **Connection Draining**, choose **\(Edit\)**\.

1. On the **Configure Connection Draining** page, select **Enable Connection Draining**\.

1. \(Optional\) For **Timeout**, type a value between 1 and 3,600 seconds\.

1. Choose **Save**\.

**To enable connection draining using the AWS CLI**  
Use the following [modify\-load\-balancer\-attributes](https://docs.aws.amazon.com/cli/latest/reference/elb/modify-load-balancer-attributes.html) command:

```
aws elb modify-load-balancer-attributes --load-balancer-name my-loadbalancer --load-balancer-attributes "{\"ConnectionDraining\":{\"Enabled\":true,\"Timeout\":300}}"
```

The following is an example response:

```
{
    "LoadBalancerAttributes": {
        "ConnectionDraining": {
            "Enabled": true, 
            "Timeout": 300
        }
    }, 
    "LoadBalancerName": "my-loadbalancer"
}
```

## Disable connection draining<a name="disable-conn-drain"></a>

You can disable connection draining for your load balancer at any time\.

**To disable connection draining using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Instances** tab, for **Connection Draining**, choose **\(Edit\)**\.

1. On the **Configure Connection Draining** page, clear **Enable Connection Draining**\.

1. Choose **Save**\.

**To disable connection draining using the AWS CLI**  
Use the following [modify\-load\-balancer\-attributes](https://docs.aws.amazon.com/cli/latest/reference/elb/modify-load-balancer-attributes.html) command:

```
aws elb modify-load-balancer-attributes --load-balancer-name my-loadbalancer --load-balancer-attributes "{\"ConnectionDraining\":{\"Enabled\":false}}"
```

The following is an example response:

```
{
    "LoadBalancerAttributes": {
        "ConnectionDraining": {
            "Enabled": false, 
            "Timeout": 300
        }
    }, 
    "LoadBalancerName": "my-loadbalancer"
}
```
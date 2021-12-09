# Configure health checks for your Classic Load Balancer<a name="elb-healthchecks"></a>

Your Classic Load Balancer periodically sends requests to its registered instances to test their status\. These tests are called *health checks*\. The status of the instances that are healthy at the time of the health check is `InService`\. The status of any instances that are unhealthy at the time of the health check is `OutOfService`\. The load balancer performs health checks on all registered instances, whether the instance is in a healthy state or an unhealthy state\.

The load balancer routes requests only to the healthy instances\. When the load balancer determines that an instance is unhealthy, it stops routing requests to that instance\. The load balancer resumes routing requests to the instance when it has been restored to a healthy state\.

The load balancer checks the health of the registered instances using either the default health check configuration provided by Elastic Load Balancing or a health check configuration that you configure\.

If you have associated your Auto Scaling group with a Classic Load Balancer, you can use the load balancer health check to determine the health state of instances in your Auto Scaling group\. By default an Auto Scaling group periodically determines the health state of each instance\. For more information, see [Add Elastic Load Balancing health checks to your Auto Scaling group](https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-add-elb-healthcheck.html) in the *Amazon EC2 Auto Scaling User Guide*\.

**Topics**
+ [Health check configuration](#health-check-configuration)
+ [Update the health check configuration](#update-health-check-config)
+ [Check the health of your instances](#check-instance-health)
+ [Troubleshoot health checks](#troubleshoot-health-checks)

## Health check configuration<a name="health-check-configuration"></a>

A health configuration contains the information that a load balancer uses to determine the health state of the registered instances\. The following table describes the health check configuration fields\.


| Field | Description | 
| --- | --- | 
|  Ping Protocol  |  The protocol to use to connect with the instance\. Valid values: `TCP`, `HTTP`, `HTTPS`, and `SSL` Console default: `HTTP` CLI/API default: `TCP`  | 
|  Ping Port  |  The port to use to connect with the instance, as a `protocol:port` pair\. If the load balancer fails to connect with the instance at the specified port within the configured response timeout period, the instance is considered unhealthy\. Ping protocols: `TCP`, `HTTP`, `HTTPS`, and `SSL` Ping port range: 1 to 65535 Console default: `HTTP:80` CLI/API default: `TCP:80`  | 
|  Ping Path  |  The destination for the HTTP or HTTPS request\. An HTTP or HTTPS GET request is issued to the instance on the ping port and the ping path\. If the load balancer receives any response other than "200 OK" within the response timeout period, the instance is considered unhealthy\. If the response includes a body, your application must either set the Content\-Length header to a value greater than or equal to zero, or specify Transfer\-Encoding with a value set to 'chunked'\. Default: `/index.html`  | 
|  Response Timeout  |  The amount of time to wait when receiving a response from the health check, in seconds\. Valid values: 2 to 60 Default: 5  | 
|  HealthCheck Interval  |  The amount of time between health checks of an individual instance, in seconds\. Valid values: 5 to 300 Default: 30  | 
|  Unhealthy Threshold  |  The number of consecutive failed health checks that must occur before declaring an EC2 instance unhealthy\. Valid values: 2 to 10 Default: 2  | 
|  Healthy Threshold  |  The number of consecutive successful health checks that must occur before declaring an EC2 instance healthy\. Valid values: 2 to 10 Default: 10  | 

The load balancer sends a health check request to each registered instance every `Interval` seconds, using the specified port, protocol, and ping path\. Each health check request is independent and lasts the entire interval\. The time it takes for the instance to respond does not affect the interval for the next health check\. If the health checks exceed **UnhealthyThresholdCount** consecutive failures, the load balancer takes the instance out of service\. When the health checks exceed **HealthyThresholdCount** consecutive successes, the load balancer puts the instance back in service\.

An HTTP/HTTPS health check succeeds if the instance returns a 200 response code within the health check interval\. A TCP health check succeeds if the TCP connection succeeds\. An SSL health check succeeds if the SSL handshake succeeds\.

## Update the health check configuration<a name="update-health-check-config"></a>

You can update the health check configuration for your load balancer at any time\.

**To update the health check configuration for your load balancer using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Health Check** tab, choose **Edit Health Check**\.

1. On the **Configure Health Check** page, update the configuration as needed\.

1. Choose **Save**\.

**To update the health check configuration for your load balancer using the AWS CLI**  
Use the following [configure\-health\-check](http://docs.aws.amazon.com/cli/latest/reference/elb/configure-health-check.html) command:

```
aws elb configure-health-check --load-balancer-name my-load-balancer --health-check Target=HTTP:80/ping,Interval=30,UnhealthyThreshold=2,HealthyThreshold=2,Timeout=3
```

## Check the health of your instances<a name="check-instance-health"></a>

You can check the health status of your registered instances\.

**To check the health status of your instances using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Description** tab, **Status** indicates how many instances are in service\.

1. On the **Instances** tab, the **Status** column indicates the status of each instance\.

**To check the health status of your instances using the AWS CLI**  
Use the following [describe\-instance\-health](http://docs.aws.amazon.com/cli/latest/reference/elb/describe-instance-health.html) command:

```
aws elb describe-instance-health --load-balancer-name my-load-balancer
```

## Troubleshoot health checks<a name="troubleshoot-health-checks"></a>

Your registered instances can fail the load balancer health check for several reasons\. The most common reasons for failing a health check are where EC2 instances close connections to your load balancer or where the response from the EC2 instances times out\. For information about potential causes and steps you can take to resolve failed health check issues, see [Troubleshoot a Classic Load Balancer: Health checks](ts-elb-healthcheck.md)\.
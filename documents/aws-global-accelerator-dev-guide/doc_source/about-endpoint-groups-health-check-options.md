# Health check options<a name="about-endpoint-groups-health-check-options"></a>

AWS Global Accelerator regularly sends requests to endpoints to test their status\. These health checks run automatically\. The guidance for determining the health of each endpoint and the timing for the health checks depend on the type of endpoint resource\. 

**Important**  
Global Accelerator requires your router and firewall rules to allow inbound traffic from the IP addresses associated with Route 53 health checkers to complete health checks for EC2 instance or Elastic IP address endpoints\. You can find information about the IP address ranges associated with Amazon Route 53 health checkers in [Health Checks for Your Target Groups](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/route-53-ip-addresses.html) in the *Amazon Route 53 Developer Guide*\.

You can configure the following health check options for an endpoint group\. If you specify health check options, Global Accelerator uses the settings for EC2 instance or Elastic IP address health checks but not for Network Load Balancers or Application Load Balancers\.
+ For Application Load Balancer or Network Load Balancer endpoints, you configure health checks for the resources by using Elastic Load Balancing configuration options\. For more information, see [Health Checks for Your Target Groups](https://docs.aws.amazon.com/elasticloadbalancing/latest/network/target-group-health-checks.html)\. Health check options that you choose in Global Accelerator do not affect Application Load Balancers or Network Load Balancers that you've added as endpoints\.
+ For EC2 instance or Elastic IP address endpoints that are added to a listener configured with TCP, you can specify the port to use for health checks\. By default, if you don't specify a port for health checks, Global Accelerator uses the listener port that you specified for your accelerator\.
+ For EC2 instance or Elastic IP address endpoints with UDP listeners, Global Accelerator uses the listener port and the TCP protocol for health checks, so you must have a TCP server on your endpoint\.
**Note**  
Be sure to check that the port that you've configured for the TCP server on each endpoint is the same as the port that you specify for the health check in Global Accelerator\. If the port numbers aren't the same, or if you haven't set up a TCP server for the endpoint, Global Accelerator marks the endpoint as unhealthy, regardless of the endpoint's health\.

**Health check port**  
The port to use when Global Accelerator performs health checks on endpoints that are part of this endpoint group\.

**Health check protocol**  
The protocol to use when Global Accelerator performs health checks on endpoints that are part of this endpoint group\.

**Health check interval**  
The interval, in seconds, between each health check for an endpoint\.

**Threshold count**  
The number of consecutive health checks required before considering an unhealthy target healthy or a healthy target unhealthy\.

Each listener routes requests only to healthy endpoints\. After you add an endpoint, it must pass a health check to be considered healthy\. After each health check is completed, the listener closes the connection that was established for the health check\.
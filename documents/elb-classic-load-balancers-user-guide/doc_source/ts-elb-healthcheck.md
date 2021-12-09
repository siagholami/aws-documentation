# Troubleshoot a Classic Load Balancer: Health checks<a name="ts-elb-healthcheck"></a>

Your load balancer checks the health of its registered instances using either the default health check configuration provided by Elastic Load Balancing or a custom health check configuration that you specify\. The health check configuration contains information such as the protocol, ping port, ping path, response timeout, and health check interval\. An instance is considered healthy if it returns a 200 response code within the health check interval\. For more information, see [Configure health checks for your Classic Load Balancer](elb-healthchecks.md)\.

If the current state of some or all your instances is `OutOfService` and the description field displays the message that the `Instance has failed at least the Unhealthy Threshold number of health checks consecutively`, the instances have failed the load balancer health check\. The following are the issues to look for, the potential causes, and the steps you can take to resolve the issues\.

**Topics**
+ [Health check target page error](#ts-elb-healthcheck-targetpage)
+ [Connection to the instances has timed out](#ts-elb-healthcheck-failed)
+ [Public key authentication is failing](#ts-elb-healthcheck-publickey)
+ [Instance is not receiving traffic from the load balancer](#ts-elb-healthcheck-securitygroup)
+ [Ports on instance are not open](#ts-elb-healthcheck-ports)
+ [Instances in an Auto Scaling group are failing the ELB health check](#ts-elb-healthcheck-autoscaling)

## Health check target page error<a name="ts-elb-healthcheck-targetpage"></a>

**Problem**: An HTTP GET request issued to the instance on the specified ping port and the ping path \(for example, HTTP:80/index\.html\) receives a non\-200 response code\.

**Cause 1**: No target page is configured on the instance\.

**Solution 1**: Create a target page \(for example, `index.html`\) on each registered instance and specify its path as the ping path\.

**Cause 2**: The value of the Content\-Length header in the response is not set\.

**Solution 2**: If the response includes a body, then either set the Content\-Length header to a value greater than or equal to zero, or set the Transfer\-Encoding value to 'chunked'\.

**Cause 3**: The application is not configured to receive requests from the load balancer or to return a 200 response code\.

**Solution 3**: Check the application on your instance to investigate the cause\.

## Connection to the instances has timed out<a name="ts-elb-healthcheck-failed"></a>

**Problem**: Health check requests from your load balancer to your EC2 instances are timing out or failing intermittently\.

First, verify the issue by connecting directly with the instance\. We recommend that you connect to your instance from within the network using the private IP address of the instance\.

Use the following command for a TCP connection:

```
telnet private-IP-address-of-the-instance port
```

Use the following command for an HTTP or HTTPS connection:

```
curl –I private-IP-address-of-the-instance:port/health-check-target-page
```

If you are using an HTTP/HTTPS connection and getting a non\-200 response, see [Health check target page error](#ts-elb-healthcheck-targetpage)\. If you are able to connect directly to the instance, check for the following:

**Cause 1**: The instance is failing to respond within the configured response timeout period\.

**Solution 1**: Adjust the response timeout settings in your load balancer health check configuration\.

**Cause 2**: The instance is under significant load and is taking longer than your configured response timeout period to respond\.

**Solution 2**:
+ Check the monitoring graph for over\-utilization of CPU\. For information, see [Get statistics for a specific EC2 instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/US_SingleMetricPerInstance.html) in the *Amazon EC2 User Guide for Linux Instances*\.
+ Check the utilization of other application resources, such as memory or limits, by connecting to your EC2 instances\.
+ If necessary, add more instances or enable Auto Scaling\. For more information, see the [Amazon EC2 Auto Scaling User Guide](https://docs.aws.amazon.com/autoscaling/ec2/userguide/)\.

**Cause 3**: If you are using an HTTP or an HTTPS connection and the health check is being performed on a target page specified in the ping path field \(for example, `HTTP:80/index.html`\), the target page might be taking longer to respond than your configured timeout\.

**Solution 3**: Use a simpler health check target page or adjust the health check interval settings\.

## Public key authentication is failing<a name="ts-elb-healthcheck-publickey"></a>

**Problem**: A load balancer configured to use the HTTPS or SSL protocol with back\-end authentication enabled fails public key authentication\.

**Cause**: The public key on the SSL certificate does not match the public key configured on the load balancer\. Use the `s_client` command to see the list of server certificates in the certificate chain\. For more information, see [s\_client](https://www.openssl.org/docs/man1.1.1/man1/openssl-s_client.html) in the OpenSSL documentation\.

**Solution**: Your might need to update your SSL certificate\. If your SSL certificate is current, try re\-installing it on your load balancer\. For more information, see [Replace the SSL certificate for your Classic Load Balancer](elb-update-ssl-cert.md)\.

## Instance is not receiving traffic from the load balancer<a name="ts-elb-healthcheck-securitygroup"></a>

**Problem**: The security group for the instance is blocking the traffic from the load balancer\.

Do a packet capture on the instance to verify the issue\. Use the following command:

```
# tcpdump port health-check-port
```

**Cause 1**: The security group associated with the instance does not allow traffic from the load balancer\.

**Solution 1**: Edit the instance security group to allow traffic from the load balancer\. Add a rule to allow all traffic from the load balancer security group\.

**Cause 2**: The security group of your load balancer in a VPC does not allow traffic to the EC2 instances\.

**Solution 2**: Edit the security group of your load balancer to allow traffic to the subnets and the EC2 instances\.

For information about managing security groups for EC2\-Classic, see [Security groups for instances in EC2\-Classic](elb-security-groups.md#elb-classic-security-groups)\.

For information about managing security groups for a VPC, see [Security groups for load balancers in a VPC](elb-security-groups.md#elb-vpc-security-groups)\.

## Ports on instance are not open<a name="ts-elb-healthcheck-ports"></a>

**Problem**: The health check sent to the EC2 instance by the load balancer is blocked by the port or a firewall\.

Verify the issue by using the following command:

```
netstat –ant
```

**Cause**: The specified health port or the listener port \(if configured differently\) is not open\. Both the port specified for the health check and the listener port must be open and listening\.

**Solution**: Open up the listener port and the port specified in your health check configuration \(if configured differently\) on your instances to receive load balancer traffic\.

## Instances in an Auto Scaling group are failing the ELB health check<a name="ts-elb-healthcheck-autoscaling"></a>

**Problem**: Instances in your Auto Scaling group pass the default Auto Scaling health check but fail the ELB health check\.

**Cause**: Auto Scaling uses EC2 status checks to detect hardware and software issues with the instances, but the load balancer performs health checks by sending a request to the instance and waiting for a 200 response code, or by establishing a TCP connection \(for a TCP\-based health check\) with the instance\.

An instance might fail the ELB health check because an application running on the instance has issues that cause the load balancer to consider the instance out of service\. This instance might pass the Auto Scaling health check; it would not be replaced by the Auto Scaling policy because it is considered healthy based on the EC2 status check\.

**Solution**: Use the ELB health check for your Auto Scaling group\. When you use the ELB health check, Auto Scaling determines the health status of your instances by checking the results of both the instance status check and the ELB health check\. For more information, see [Adding health checks to your Auto Scaling group](https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-add-elb-healthcheck.html) in the *Amazon EC2 Auto Scaling User Guide*\.
# Viewing Client IP Addresses in AWS Global Accelerator<a name="introduction-how-it-works-client-ip"></a>

Your options for viewing the client IP address for AWS Global Accelerator depend on the endpoints that you have set up with your accelerator\. When you use an Application Load Balancer \(ALB\) as an endpoint with Global Accelerator \(internal ALBs and internet\-facing ALBs\), you can choose to preserve the source IP address of the client for incoming packets\. If you enable this *client IP address preservation*, you can apply logic that is specific to a user's IP address in your applications that run on the servers behind that ALB endpoint\.

For example, your application can use IP\-address\-based filters such as [Security Groups on Application Load Balancers](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/        load-balancer-update-security-groups.html) or location\-based filters, or you can choose to serve custom content for applications that are fronted by an accelerator\. You can also gather connection statistics based on client IP addresses\.

When you create a new accelerator with Application Load Balancer endpoints, you can choose to enable or disable client IP address preservation for each ALB endpoint\. For existing accelerators, you can transition ALB endpoints to endpoints that enable client IP preservation in supported AWS Regions\. \(For a list of supported Regions, see [ Supported Regions for Client IP Address Preservation](#introduction-how-it-works-client-ip.regions)\.\) We recommend that to do this, you add a duplicate ALB endpoint and enable client IP address preservation, and then slowly move traffic from the corresponding original ALB to the new ALB\. For more information, see [ Transitioning Your ALB Endpoints to Use Client IP Address Preservation](about-endpoints.transition-to-IP-preservation.md)\. 

For endpoints that don’t have client IP preservation enabled, the accelerator appears to be the requesting user's IP address\. The user connection information—such as the IP address of the client and the client's port—is not preserved as traffic travels to applications behind an accelerator\. This works fine for applications that are available to all users, such as public websites\. But for other applications, you might want to use the client IP address, for example, to do the following:
+ To allow or restrict specific users from accessing an application fronted by an accelerator, by configuring security firewalls, or by using AWS security groups or AWS WAF\.
+ To serve custom content to users, or configure custom policies based on the geographical location of users\.
+ To use existing application code that gathers real\-time user statistics, such as compiling the geographical distribution of users\.

For endpoints that don't have client IP preservation, you can filter for the client IP address that Global Accelerator uses\. You can see information about the client IP addresses of incoming packets by reviewing your Global Accelerator flows logs\. For more information, see [IP Address Ranges of Global Accelerator Edge Servers](introduction-ip-ranges.md) and [Flow Logs in AWS Global Accelerator](monitoring-global-accelerator.flow-logs.md)\. 

**Topics**
+ [HTTP Headers and Client IP Address Preservation](#introduction-how-it-works-client-ip.headers)
+ [Best Practices for Client IP Address Preservation](#best-practices-aga)
+ [Supported Regions for Client IP Address Preservation](#introduction-how-it-works-client-ip.regions)

## HTTP Headers and Client IP Address Preservation<a name="introduction-how-it-works-client-ip.headers"></a>

HTTP requests and HTTP responses use header fields to send information about the HTTP messages\. Header fields are colon\-separated name\-value pairs that are separated by a carriage return \(CR\) and a line feed \(LF\)\. A standard set of HTTP header fields is defined in RFC 2616, [ Message Headers](https://tools.ietf.org/html/rfc2616#section-4.2)\. There are also non\-standard HTTP headers available that are widely used by the applications\. Some of the non\-standard HTTP headers have an `X-Forwarded` prefix\. AWS Global Accelerator supports an `X-Forwarded` header, `X-Forwarded-For`, to provide the IP address of a client\.

The `X-Forwarded-For` request header helps you identify the IP address of a client when you use Global Accelerator\. Because Global Accelerator intercepts traffic between clients and endpoints, your server access logs contain only the IP address of your accelerator\. To see the IP address of the client, use the `X-Forwarded-For` request header\. Global Accelerator stores the IP address of the client in the `X-Forwarded-For` request header and passes the header to your server\.

The `X-Forwarded-For` request header is formatted like this:

```
X-Forwarded-For: client-ip-address
```

The following is an example `X-Forwarded-For` request header for a client with an IP address of 203\.0\.113\.7\.

```
X-Forwarded-For: 203.0.113.7
```

## Best Practices for Client IP Address Preservation<a name="best-practices-aga"></a>

An elastic network interface \(ENI\) is a logical networking component in a VPC that represents a virtual network card\. To support client IP address preservation, AWS Global Accelerator creates ENIs in your AWS account—one for each subnet that an endpoint uses\. Global Accelerator uses these ENIs to route traffic to the endpoints configured behind an accelerator\.

The following is information about ENIs and security groups to keep in mind when you use client IP address preservation in AWS Global Accelerator, along with best practices\.

**Elastic network interfaces \(ENIs\)**  
+ When you have ALBs with client IP address preservation enabled, the number of subnets that those ALBs are in determines the number of ENIs that Global Accelerator creates in your account\. Global Accelerator creates one ENI for each subnet that has at least one ALB in it that is fronted by an accelerator in your account\.

  For example:
  + If an ALB has instances in subnetA and subnetB, and then you add the ALB as an accelerator endpoint, Global Accelerator creates two ENIs, one in each subnet\.
  + If you add, for example, an ALB1 that has instances in subnetA and subnetB to Accelerator1, and then add an ALB2 in subnetA and subnetB to Accelerator2, Global Accelerator creates only 2 ENIs: one in subnetA and one in subnetB\.
+ Evaluate the number of subnets that are used by endpoints in your accelerators to determine the number of ENIs that Global Accelerator will create\. Before you create an accelerator, make sure that you have enough capacity for the required ENIs, or request a limit increase\. In addition, if you don't have enough IP addresses, you must create a larger subnet\. 
+ ENIs are reused across accelerators if endpoints in the same subnet are placed behind multiple accelerators\. 

**Security groups**  
+ Global Accelerator creates security groups that are associated to these ENIs, in addition to the ENIs\. You should not edit any of the security group settings for these groups\.
+ If you modify the security group rules created by Global Accelerator, the endpoint might become unhealthy\. If that happens, get assistance by contacting [AWS Support](https://console.aws.amazon.com/support/home)\. 
+ Global Accelerator creates a specific security group for each virtual private cloud \(VPC\)\. Endpoints that are within a specific VPC all use the same security group\.
+ When Global Accelerator determines that a security group is not associated with any ENIs in your account, Global Accelerator deletes the security group\.

## Supported Regions for Client IP Address Preservation<a name="introduction-how-it-works-client-ip.regions"></a>

You can enable client IP address preservation for AWS Global Accelerator in the following AWS Regions:

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/introduction-how-it-works-client-ip.html)
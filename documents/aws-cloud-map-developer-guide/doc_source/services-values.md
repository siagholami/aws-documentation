# Values That You Specify When You Create Services<a name="services-values"></a>

When you create an AWS Cloud Map service, you specify the following values\.

**Note**  
You can't change any values in a service after you create it\.

**Values**
+ [Service name](#service-creating-values-name)
+ [Service description](#service-creating-values-description)
+ [Routing policy](#service-creating-values-routing-policy)
+ [Record type](#service-creating-values-record-type)
+ [TTL](#service-creating-values-ttl)
+ [Health check options](#service-creating-values-health-check-options)
+ [Failure threshold](#service-creating-values-failure-threshold)
+ [Health check protocol](#service-creating-values-health-check-protocol)
+ [Health check path](#service-creating-values-health-check-path)

**Service name**  
Enter a name that describes the instances that you will register using this service\. The value is used to discover AWS Cloud Map service instances either in API calls or in DNS queries, depending on the instance discovery method that you chose when you created the namespace:  
+ **API calls** – When your application calls [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html), the API call includes the namespace and service names\.
+ **API calls and DNS queries in VPCs** or **API calls and public DNS queries** – When you register service instances, AWS Cloud Map creates DNS records in the Amazon Route 53 private or public hosted zone that AWS Cloud Map created when you created the namespace\. The names of the records are in the following format:

  *service\-name*\.*namespace\-name*

  When your application submits a DNS query to discover service instances, the query is for a record that includes the name of the service in the record name\.
If you want AWS Cloud Map to create an **SRV** record when you register an instance, and if you're using a system that requires a specific **SRV** format, such as [HAProxy](http://www.haproxy.org/), specify the following for **Service name**:  
+ Start the name with an underscore \(\_\), such as **\_exampleservice**
+ End the name with *\.\_protocol*, such as **\.\_tcp**
When you register an instance, AWS Cloud Map creates an **SRV** record and assigns a name by concatenating the service name and the namespace name, for example:  
**\_exampleservice\.\_tcp\.example\.com**

**Service description**  
Enter a description for the service\. The value that you enter here appears on the **Services** page and on the detail page for each service\.

**Routing policy \(public and private DNS namespaces only\)**  
If you're using a public or private DNS name space to create the service, choose the Amazon Route 53 routing policy for the DNS records that AWS Cloud Map creates when you register instances\. \(Public DNS namespaces have a value of **API calls and public DNS queries** for **Instance discovery**, and private DNS namespaces have a value of **API calls and DNS queries in VPCs**\.\)   
You can't use the console to configure AWS Cloud Map to create a Route 53 alias record when you register an instance\. If you want AWS Cloud Map to create alias records for Elastic Load Balancing load balancer when you register instances programmatically, choose **Weighted routing** for **Routing policy**\.
AWS Cloud Map supports the following Route 53 routing policies:    
**Weighted routing**  
Route 53 returns the applicable value from one randomly selected instance from among the instances that you registered using the same service\. All records have the same weight, so you can't route more or less traffic to any instances\.  
For example, suppose the service includes configurations for one **A** record and a health check, and you use the service to register 10 instances\. Route 53 responds to DNS queries with the IP address for one randomly selected instance from among the healthy instances\. If no instances are healthy, Route 53 responds to DNS queries as if all the instances were healthy\.  
If you don't define a health check for the service, Route 53 assumes that all instances are healthy and returns the applicable value for one randomly selected instance\.  
For more information, see [Weighted Routing](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy.html#routing-policy-weighted) in the *Amazon Route 53 Developer Guide*\.  
**Multivalue answer routing**  
If you define a health check for the service and the health check is healthy, Route 53 returns the applicable value for up to eight instances\.  
For example, suppose the service includes configurations for one **A** record and a health check, and you use the service to register 10 instances\. Route 53 responds to DNS queries with IP addresses for up to eight healthy instances\. If fewer than eight instances are healthy, Route 53 responds to every DNS query with the IP addresses for all the healthy instances\.  
If you don't define a health check for the service, Route 53 assumes that all instances are healthy and returns the values for up to eight instances\.  
For more information, see [Multivalue Answer Routing](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy.html#routing-policy-multivalue) in the *Amazon Route 53 Developer Guide*\.

**Record type \(public and private DNS namespaces only\)**  
If you're using a public or private DNS name space to create the service, choose the DNS record type for the records that AWS Cloud Map creates when you register instances\. Amazon Route 53 returns the applicable value in response to DNS queries for registered instances\.   
The following record types are supported:    
**A**  
When you register an instance, you specify the IP address of the resource in IPv4 format, such as **192\.0\.2\.44**\.  
**AAAA**  
When you register an instance, you specify the IP address of the resource in IPv6 format, such as **2001:0db8:85a3:0000:0000:abcd:0001:2345**\.  
**CNAME**  
When you register an instance, you specify the domain name of the resource, such as www\.example\.com\. Note the following:  
+ If you want to choose **CNAME**, you must choose **Weighted routing** for **Routing policy**\. 
+ If you choose **CNAME**, you can't choose **Route 53 health check** for **Health check options**\.  
**SRV**  
The value for an **SRV** record uses the following values:  
`priority weight port service-hostname`  
Note the following about the values:  
+ The values of `priority` and `weight` are both set to 1 and can't be changed\.
+ For `port`, AWS Cloud Map uses the value that you specify for **Port** when you register an instance\.
+ The value of `service-hostname` is a concatenation of the following values:
  + The value that you specify for **Service instance ID** when you register an instance
  + The name of the service
  + The name of the namespace

  For example, suppose you specify **test** for **Service instance ID** when you register an instance, and the name of the service is **backend** and the name of the namespace is **example\.com**\. AWS Cloud Map assigns the following value to the `service-hostname` attribute in the **SRV** record:

  `test.backend.example.com`
If you specify settings for an **SRV** record, note the following:  
+ If you specify values for **IPv4 address**, **IPv6 address**, or both, AWS Cloud Map automatically creates **A** and/or **AAAA** records that have the same name as the value of `service-hostname` in the **SRV** record\.
+ If you're using a system that requires a specific **SRV** format, such as [HAProxy](http://www.haproxy.org/), see [service name](#service-creating-values-name) for information about how to specify the correct name format\.
You can specify record types in the following combinations:   
+ **A**
+ **AAAA**
+ **A** and **AAAA**
+ **CNAME**
+ **SRV**
If you specify **A** and **AAAA** record types, you can specify an IPv4 IP address, an IPv6 IP address, or both when you register an instance\.

**TTL \(public and private DNS namespaces only\)**  
If you're using a public or private DNS name space to create the service, enter a value for **TTL**, or time to live\. The value of **TTL** determines how long DNS resolvers cache information for this record before the resolvers forward another DNS query to Amazon Route 53 to get updated settings\.

**Health check options**    
**No health check**  
If you don't configure a health check, traffic will be routed to service instances regardless of whether they're healthy\.  
**Route 53 health check \(not supported for private DNS namespaces\)**  
If you specify settings for an Amazon Route 53 health check, AWS Cloud Map creates a Route 53 health check whenever you register an instance and deletes the health check when you deregister the instance\.  
For public DNS namespaces, AWS Cloud Map associates the health check with the Route 53 record that AWS Cloud Map creates when you register an instance\.  
For namespaces for which you use API calls to discover instances, AWS Cloud Map creates a Route 53 health check, but there's no DNS record for AWS Cloud Map to associate the health check with\. To determine whether a health check is healthy, you can configure monitoring using either the Route 53 console or using Amazon CloudWatch\. For more information about using the Route 53 console, see [Get Notified When a Health Check Fails](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/health-checks-creating-values.html#health-checks-creating-values-alarm) in the *Amazon Route 53 Developer Guide*\. For more information about using CloudWatch, see [PutMetricAlarm](https://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_PutMetricAlarm.html) in the *Amazon CloudWatch API Reference*\.   
For information about the charges for Route 53 health checks, see [Route 53 Pricing](https://aws.amazon.com/route53/pricing/)\.  
**Custom health check**  
If you configure AWS Cloud Map to use a custom health check when you register an instance, you must use a third\-party health checker to evaluate the health of your resources\. Custom health checks are useful in the following circumstances:  
+ You can't use a Route 53 health check because the resource isn't available over the internet\. For example, you can use a custom health check when the instance is in an Amazon VPC\. \(To check the health of resources in a VPC, the health checker must also be in the VPC\.\) 
+ You want to use a third\-party health checker regardless of where your resources are\.

**Failure threshold \(Route 53 health check only\)**  
The number of consecutive Route 53 health checks that a resource must pass or fail for Amazon Route 53 to change the current status of the resource from healthy to unhealthy or vice versa\. For more information, see [How Amazon Route 53 Determines Whether a Health Check Is Healthy](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-failover-determining-health-of-endpoints.html) *Amazon Route 53 Developer Guide*\. 

**Health check protocol \(Route 53 health check only\)**  
The method that you want Amazon Route 53 to use to check the health of your resource:    
**HTTP**  
Route 53 tries to establish a TCP connection\. If successful, Route 53 submits an HTTP request and waits for an HTTP status code of 2xx or 3xx\.  
**HTTPS**  
Route 53 tries to establish a TCP connection\. If successful, Route 53 submits an HTTPS request and waits for an HTTP status code of 2xx or 3xx\.  
If you choose HTTPS, the resource must support TLS v1\.0 or later\.
If you choose HTTPS for the value of **Health check protocol**, an additional charge applies\. For more information, see [Route 53 Pricing](https://aws.amazon.com/route53/pricing/)\.  
**TCP**  
Route 53 tries to establish a TCP connection\.
For more information, see [How Amazon Route 53 Determines Whether a Health Check Is Healthy](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-failover-determining-health-of-endpoints.html)\.

**Health check path \(Route 53 HTTP and HTTPS health checks only\)**  
The path that you want Amazon Route 53 to request when performing health checks\. The path can be any value for which your resource will return an HTTP status code of 2xx or 3xx when the resource is healthy, such as the file `/docs/route53-health-check.html`\. You can also include query string parameters, for example, `/welcome.html?language=jp&login=y`\. The AWS Cloud Map console automatically adds a leading slash \(/\) character\. 
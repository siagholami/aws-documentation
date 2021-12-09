# How the client IP address is preserved in AWS Global Accelerator<a name="preserve-client-ip-address.headers"></a>

AWS Global Accelerator preserves the source IP address of the client differently for Amazon EC2 instances and Application Load Balancers:
+ For an EC2 instance endpoint, the client’s IP address is preserved for all traffic\.
+ For an Application Load Balancer endpoint with client IP address preservation, Global Accelerator works together with the Application Load Balancer to provide an `X-Forwarded` header, `X-Forwarded-For`, that includes the IP address of the original client so that your web tier can access it\.

HTTP requests and HTTP responses use header fields to send information about the HTTP messages\. Header fields are colon\-separated name\-value pairs that are separated by a carriage return \(CR\) and a line feed \(LF\)\. A standard set of HTTP header fields is defined in RFC 2616, [ Message Headers](https://tools.ietf.org/html/rfc2616#section-4.2)\. There are also non\-standard HTTP headers available that are widely used by the applications\. Some of the non\-standard HTTP headers have an `X-Forwarded` prefix\.

Because an Application Load Balancer terminates incoming TCP connections and creates new connections to your backend targets, it does not preserve client IP addresses all the way to your target code \(such as instances, containers, or Lambda code\)\. The source IP address that your targets see in the TCP packet is the IP address of the Application Load Balancer\. However, an Application Load Balancer does preserve the original client IP address by removing it from the original packet’s reply address and inserting it into an HTTP header before it sends the request to your backend over a new TCP connection\.

The `X-Forwarded-For` request header is formatted like this:

```
X-Forwarded-For: client-ip-address
```

The following example shows an `X-Forwarded-For` request header for a client with an IP address of 203\.0\.113\.7\.

```
X-Forwarded-For: 203.0.113.7
```
# Troubleshoot a Classic Load Balancer: HTTP errors<a name="ts-elb-error-message"></a>

The HTTP method \(also called the *verb*\) specifies the action to be performed on the resource receiving an HTTP request\. The standard methods for HTTP requests are defined in RFC 2616, [Method Definitions](http://tools.ietf.org/html/rfc2616#section-9)\. The standard methods include GET, POST, PUT, HEAD, and OPTIONS\. Some web applications require \(and sometimes introduce\) methods that are extensions of HTTP/1\.1 methods\. Common examples of HTTP extended methods include PATCH, REPORT, MKCOL, PROPFIND, MOVE, and LOCK\. Elastic Load Balancing accepts all standard and non\-standard HTTP methods\.

HTTP requests and responses use header fields to send information about the HTTP messages\. Header fields are colon\-separated name\-value pairs that are separated by a cariage return \(CR\) and a line feed \(LF\)\. A standard set of HTTP header fields is definied in RFC 2616, [Message Headers](http://tools.ietf.org/html/rfc2616#section-4.2)\. For more information, see [HTTP headers and Classic Load Balancers](x-forwarded-headers.md)\.

When a load balancer receives an HTTP request, it checks for malformed requests and for the length of the method\. The total method length in an HTTP request to a load balancer must not exceed 127 characters\. If the HTTP request passes both checks, the load balancer sends the request to the EC2 instance\. If the method field in the request is malformed, the load balancer responds with an [HTTP 400: BAD\_REQUEST](#ts-elb-errorcodes-http400) error\. If the length of the method in the request exceeds 127 characters, the load balancer responds with an [HTTP 405: METHOD\_NOT\_ALLOWED](#ts-elb-errorcodes-http405) error\.

The EC2 instance processes a valid request by implementing the method in the request and sending a response back to the client\. Your instances must be configured to handle both supported and unsupported methods\.

The following are error messages returned by your load balancer, the potential causes, and the steps you can take to resolve the issues\.

**Topics**
+ [HTTP 400: BAD\_REQUEST](#ts-elb-errorcodes-http400)
+ [HTTP 405: METHOD\_NOT\_ALLOWED](#ts-elb-errorcodes-http405)
+ [HTTP 408: Request timeout](#ts-elb-errorcodes-http408)
+ [HTTP 502: Bad gateway](#ts-elb-errorcodes-http502)
+ [HTTP 503: Service unavailable](#ts-elb-errorcodes-http503)
+ [HTTP 504: Gateway timeout](#ts-elb-errorcodes-http504)

## HTTP 400: BAD\_REQUEST<a name="ts-elb-errorcodes-http400"></a>

**Description**: Indicates that the client sent a bad request\.

**Cause 1**: The client sent a malformed request that does not meet HTTP specifications\. For example, a request can't have spaces in the URL\.

**Cause 2**: The client used the HTTP CONNECT method, which is not supported by Elastic Load Balancing\.

**Solution**: Connect directly to your instance and capture the details of the client request\. Review the headers and the URL for malformed requests\. Verify that the request meets HTTP specifications\. Verify that HTTP CONNECT is not used\.

## HTTP 405: METHOD\_NOT\_ALLOWED<a name="ts-elb-errorcodes-http405"></a>

**Description**: Indicates that the method length is not valid\. 

**Cause**: The length of the method in the request header exceeds 127 characters\. 

**Solution**: Check the length of the method\.

## HTTP 408: Request timeout<a name="ts-elb-errorcodes-http408"></a>

**Description**: Indicates that the client cancelled the request or failed to send a full request\.

**Cause 1**: A network interruption or a bad request construction, such as partially formed headers; specified content size doesn't match the actual content size transmitted; and so on\.

**Solution 1**: Inspect the code that is making the request and try sending it directly to your registered instances \(or a development / test environment\) where you have more control over inspecting the actual request\. 

**Cause 2**: Connection to the client is closed \(load balancer could not send a response\)

**Solution 2**: Verify that the client is not closing the connection before a response is sent by using a packet sniffer on the machine making the request\.

## HTTP 502: Bad gateway<a name="ts-elb-errorcodes-http502"></a>

**Description**: Indicates that the load balancer was unable to parse the response sent from a registered instance\.

**Cause**: Malformed response from the instance or potentially an issue with the load balancer\.

**Solution**: Verify that the response being sent from the instance conforms to HTTP specifications\. Go to the [AWS Support Center](https://console.aws.amazon.com/support/home#/) for assistance\.

## HTTP 503: Service unavailable<a name="ts-elb-errorcodes-http503"></a>

**Description**: Indicates that either the load balancer or the registered instances are causing the error\.

**Cause 1**: Insufficient capacity in the load balancer to handle the request\.

**Solution 1**: This should be a transient issue and should not last more than a few minutes\. If it persists, go to the [AWS Support Center](https://console.aws.amazon.com/support/home#/) for assistance\.

**Cause 2**: There are no registered instances\.

**Solution 2**: Register at least one instance in every Availability Zone that your load balancer is configured to respond in\. Verify this by looking at the `HealthyHostCount` metrics in CloudWatch\. If you can't ensure that an instance is registered in each Availability Zone, we recommend enabling cross\-zone load balancing\. For more information, see [Configure cross\-zone load balancing for your Classic Load Balancer](enable-disable-crosszone-lb.md)\.

**Cause 3**: There are no healthy instances\.

**Solution 3**: Ensure that you have healthy instances in every Availability Zone that your load balancer is configured to respond in\. Verify this by looking at the `HealthyHostCount` metric\.

**Cause 4**: The surge queue is full\.

**Solution 4**: Ensure that your instances have sufficient capacity to handle the request rate\. Verify this by looking at the `SpilloverCount` metric\.

## HTTP 504: Gateway timeout<a name="ts-elb-errorcodes-http504"></a>

**Description**: Indicates that the load balancer closed a connection because a request did not complete within the idle timeout period\.

**Cause 1**: The application takes longer to respond than the configured idle timeout\.

**Solution 1**: Monitor the `HTTPCode_ELB_5XX` and `Latency` metrics\. If there is an increase in these metrics, it could be due to the application not responding within the idle timeout period\. For details about the requests that are timing out, enable access logs on the load balancer and review the 504 response codes in the logs that are generated by Elastic Load Balancing\. If necessary, you can increase your capacity or increase the configured idle timeout so that lengthy operations \(such as uploading a large file\) can complete\. For more information, see [Configure the idle connection timeout for your Classic Load Balancer](config-idle-timeout.md) and [How do I troubleshoot Elastic Load Balancing high latency](https://aws.amazon.com/premiumsupport/knowledge-center/elb-latency-troubleshooting/)\.

**Cause 2**: Registered instances closing the connection to Elastic Load Balancing\.

**Solution 2**: Enable keep\-alive settings on your EC2 instances and make sure that the keep\-alive timeout is greater than the idle timeout settings of your load balancer\. 
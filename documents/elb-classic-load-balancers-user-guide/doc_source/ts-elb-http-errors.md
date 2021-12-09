# Troubleshoot a Classic Load Balancer: Response code metrics<a name="ts-elb-http-errors"></a>

Your load balancer sends metrics to Amazon CloudWatch for the HTTP response codes sent to clients, identifying the source of the errors as either the load balancer or the registered instances\. You can use the metrics returned by CloudWatch for your load balancer to troubleshoot issues\. For more information, see [CloudWatch metrics for your Classic Load Balancer](elb-cloudwatch-metrics.md)\.

The following are response code metrics returned by CloudWatch for your load balancer, the potential causes, and the steps you can take to resolve the issues\.

**Topics**
+ [HTTPCode\_ELB\_4XX](#ts-elb-error-metrics-ELB_4XX)
+ [HTTPCode\_ELB\_5XX](#ts-elb-error-metrics-ELB_5XX)
+ [HTTPCode\_Backend\_2XX](#ts-elb-error-metrics-Backend_2XX)
+ [HTTPCode\_Backend\_3XX](#ts-elb-error-metrics-Backend_3XX)
+ [HTTPCode\_Backend\_4XX](#ts-elb-error-metrics-Backend_4XX)
+ [HTTPCode\_Backend\_5XX](#ts-elb-error-metrics-Backend_5XX)

## HTTPCode\_ELB\_4XX<a name="ts-elb-error-metrics-ELB_4XX"></a>

**Cause**: A malformed or canceled request from the client\.

**Solutions**
+ See [HTTP 400: BAD\_REQUEST](ts-elb-error-message.md#ts-elb-errorcodes-http400)\.
+ See [HTTP 405: METHOD\_NOT\_ALLOWED](ts-elb-error-message.md#ts-elb-errorcodes-http405)\.
+ See [HTTP 408: Request timeout](ts-elb-error-message.md#ts-elb-errorcodes-http408)\.

## HTTPCode\_ELB\_5XX<a name="ts-elb-error-metrics-ELB_5XX"></a>

**Cause**: Either the load balancer or the registered instance is causing the error or the load balancer is unable to parse the response\.

**Solutions**
+ See [HTTP 502: Bad gateway](ts-elb-error-message.md#ts-elb-errorcodes-http502)\.
+ See [HTTP 503: Service unavailable](ts-elb-error-message.md#ts-elb-errorcodes-http503)\.
+ See [HTTP 504: Gateway timeout](ts-elb-error-message.md#ts-elb-errorcodes-http504)\.

## HTTPCode\_Backend\_2XX<a name="ts-elb-error-metrics-Backend_2XX"></a>

**Cause**: A normal, successful response from the registered instances\.

**Solution**: None\.

## HTTPCode\_Backend\_3XX<a name="ts-elb-error-metrics-Backend_3XX"></a>

**Cause**: A redirect response sent from the registered instances\.

**Solution**: View the access logs or the error logs on your instance to determine the cause\. Send requests directly to the instance \(bypassing the load balancer\) to view the responses\.

## HTTPCode\_Backend\_4XX<a name="ts-elb-error-metrics-Backend_4XX"></a>

**Cause**: A client error response sent from the registered instances\.

**Solution**: View the access or error logs on your instances to determine the cause\. Send requests directly to the instance \(bypass the load balancer\) to view the responses\.

**Note**  
If the client cancels an HTTP request that was initiated with a `Transfer-Encoding: chunked` header, there is a known issue where the load balancer forwards the request to the instance even though the client canceled the request\. This can cause backend errors\.

## HTTPCode\_Backend\_5XX<a name="ts-elb-error-metrics-Backend_5XX"></a>

**Cause**: A server error response sent from the registered instances\.

**Solution**: View the access logs or the error logs on your instances to determine the cause\. Send requests directly to the instance \(bypass the load balancer\) to view the responses\.

**Note**  
If the client cancels an HTTP request that was initiated with a `Transfer-Encoding: chunked` header, there is a known issue where the load balancer forwards the request to the instance even though the client canceled the request\. This can cause backend errors\.
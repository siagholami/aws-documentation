# Access logs for your Classic Load Balancer<a name="access-log-collection"></a>

Elastic Load Balancing provides access logs that capture detailed information about requests sent to your load balancer\. Each log contains information such as the time the request was received, the client's IP address, latencies, request paths, and server responses\. You can use these access logs to analyze traffic patterns and to troubleshoot issues\.

Access logging is an optional feature of Elastic Load Balancing that is disabled by default\. After you enable access logging for your load balancer, Elastic Load Balancing captures the logs and stores them in the Amazon S3 bucket that you specify\. You can disable access logging at any time\.

Each access log file is automatically encrypted using SSE\-S3 before it is stored in your S3 bucket and decrypted when you access it\. You do not need to take any action; the encryption and decryption is performed transparently\. Each log file is encrypted with a unique key, which is itself encrypted with a master key that is regularly rotated\. For more information, see [Protecting data using server\-side encryption with Amazon S3\-managed encryption keys \(SSE\-S3\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html) in the *Amazon Simple Storage Service Developer Guide*\.

There is no additional charge for access logs\. You will be charged storage costs for Amazon S3, but will not be charged for the bandwidth used by Elastic Load Balancing to send log files to Amazon S3\. For more information about storage costs, see [Amazon S3 Pricing](https://aws.amazon.com/s3/pricing/)\.

**Topics**
+ [Access log files](#access-log-file-format)
+ [Access log entries](#access-log-entry-format)
+ [Processing access logs](#log-processing-tools)
+ [Enable access logs for your Classic Load Balancer](enable-access-logs.md)
+ [Disable access logs for your Classic Load Balancer](disable-access-logs.md)

## Access log files<a name="access-log-file-format"></a>

Elastic Load Balancing publishes a log file for each load balancer node at the interval you specify\. You can specify a publishing interval of either 5 minutes or 60 minutes when you enable the access log for your load balancer\. By default, Elastic Load Balancing publishes logs at a 60\-minute interval\. If the interval is set for 5 minutes, the logs are published at 1:05, 1:10, 1:15, and so on\. The start of log delivery is delayed up to 5 minutes if the interval is set to 5 minutes, and up to 15 minutes if the interval is set to 60 minutes\. You can modify the publishing interval at any time\.

The load balancer can deliver multiple logs for the same period\. This usually happens if the site has high traffic, multiple load balancer nodes, and a short log publishing interval\.

The file names of the access logs use the following format:

```
bucket[/prefix]/AWSLogs/aws-account-id/elasticloadbalancing/region/yyyy/mm/dd/aws-account-id_elasticloadbalancing_region_load-balancer-name_end-time_ip-address_random-string.log
```

*bucket*  
The name of the S3 bucket\.

*prefix*  
The prefix \(logical hierarchy\) in the bucket\. If you don't specify a prefix, the logs are placed at the root level of the bucket\.

*aws\-account\-id*  
The AWS account ID of the owner\.

*region*  
The Region for your load balancer and S3 bucket\.

*yyyy*/*mm*/*dd*  
The date that the log was delivered\.

*load\-balancer\-name*  
The name of the load balancer\.

*end\-time*  
The date and time that the logging interval ended\. For example, an end time of 20140215T2340Z contains entries for requests made between 23:35 and 23:40 if the publishing interval is 5 minutes\.

*ip\-address*  
The IP address of the load balancer node that handled the request\. For an internal load balancer, this is a private IP address\.

*random\-string*  
A system\-generated random string\.

The following is an example log file name:

```
s3://my-loadbalancer-logs/my-app/AWSLogs/123456789012/elasticloadbalancing/us-west-2/2014/02/15/123456789012_elasticloadbalancing_us-west-2_my-loadbalancer_20140215T2340Z_172.160.001.192_20sg8hgm.log
```

You can store your log files in your bucket for as long as you want, but you can also define Amazon S3 lifecycle rules to archive or delete log files automatically\. For more information, see [Object lifecycle management](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lifecycle-mgmt.html) in the *Amazon Simple Storage Service Developer Guide*\.

## Access log entries<a name="access-log-entry-format"></a>

Elastic Load Balancing logs requests sent to the load balancer, including requests that never made it to the back\-end instances\. For example, if a client sends a malformed request, or there are no healthy instances to respond, the requests are still logged\.

**Important**  
Elastic Load Balancing logs requests on a best\-effort basis\. We recommend that you use access logs to understand the nature of the requests, not as a complete accounting of all requests\.

### Syntax<a name="access-log-entry-syntax"></a>

Each log entry contains the details of a single request made to the load balancer\. All fields in the log entry are delimited by spaces\. Each entry in the log file has the following format:

```
timestamp elb client:port backend:port request_processing_time backend_processing_time response_processing_time elb_status_code backend_status_code received_bytes sent_bytes "request" "user_agent" ssl_cipher ssl_protocol
```

The following table describes the fields of an access log entry\.


| Field | Description | 
| --- | --- | 
| time | The time when the load balancer received the request from the client, in ISO 8601 format\. | 
| elb | The name of the load balancer | 
| client:port | The IP address and port of the requesting client\. | 
| backend:port |  The IP address and port of the registered instance that processed this request\. If the load balancer can't send the request to a registered instance, or if the instance closes the connection before a response can be sent, this value is set to `-`\. This value can also be set to `-` if the registered instance does not respond before the idle timeout\.  | 
| request\_processing\_time |  \[HTTP listener\] The total time elapsed, in seconds, from the time the load balancer received the request until the time it sent it to a registered instance\. \[TCP listener\] The total time elapsed, in seconds, from the time the load balancer accepted a TCP/SSL connection from a client to the time the load balancer sends the first byte of data to a registered instance\. This value is set to `-1` if the load balancer can't dispatch the request to a registered instance\. This can happen if the registered instance closes the connection before the idle timeout or if the client sends a malformed request\. Additionally, for TCP listeners, this can happen if the client establishes a connection with the load balancer but does not send any data\. This value can also be set to `-1` if the registered instance does not respond before the idle timeout\.  | 
| backend\_processing\_time |  \[HTTP listener\] The total time elapsed, in seconds, from the time the load balancer sent the request to a registered instance until the instance started to send the response headers\. \[TCP listener\] The total time elapsed, in seconds, for the load balancer to successfully establish a connection to a registered instance\. This value is set to `-1` if the load balancer can't dispatch the request to a registered instance\. This can happen if the registered instance closes the connection before the idle timeout or if the client sends a malformed request\. This value can also be set to `-1` if the registered instance does not respond before the idle timeout\.  | 
| response\_processing\_time |  \[HTTP listener\] The total time elapsed \(in seconds\) from the time the load balancer received the response header from the registered instance until it started to send the response to the client\. This includes both the queuing time at the load balancer and the connection acquisition time from the load balancer to the client\. \[TCP listener\] The total time elapsed, in seconds, from the time the load balancer received the first byte from the registered instance until it started to send the response to the client\. This value is set to `-1` if the load balancer can't dispatch the request to a registered instance\. This can happen if the registered instance closes the connection before the idle timeout or if the client sends a malformed request\. This value can also be set to `-1` if the registered instance does not respond before the idle timeout\.  | 
| elb\_status\_code | \[HTTP listener\] The status code of the response from the load balancer\. | 
| backend\_status\_code | \[HTTP listener\] The status code of the response from the registered instance\. | 
| received\_bytes |  The size of the request, in bytes, received from the client \(requester\)\. \[HTTP listener\] The value includes the request body but not the headers\. \[TCP listener\] The value includes the request body and the headers\.  | 
| sent\_bytes |  The size of the response, in bytes, sent to the client \(requester\)\. \[HTTP listener\] The value includes the response body but not the headers\. \[TCP listener\] The value includes the request body and the headers\. | 
| request |  The request line from the client enclosed in double quotes and logged in the following format: HTTP Method \+ Protocol://Host header:port \+ Path \+ HTTP version\. The load balancer preserves the URL sent by the client, as is, when recording the request URI\. It does not set the content type for the access log file\. When you process this field, consider how the client sent the URL\. \[TCP listener\] The URL is three dashes, each separated by a space, and ending with a space \("\- \- \- "\)\.  | 
| user\_agent |  \[HTTP/HTTPS listener\] A User\-Agent string that identifies the client that originated the request\. The string consists of one or more product identifiers, product\[/version\]\. If the string is longer than 8 KB, it is truncated\.  | 
| ssl\_cipher |  \[HTTPS/SSL listener\] The SSL cipher\. This value is recorded only if the incoming SSL/TLS connection was established after a successful negotiation\. Otherwise, the value is set to `-`\.  | 
| ssl\_protocol |  \[HTTPS/SSL listener\] The SSL protocol\. This value is recorded only if the incoming SSL/TLS connection was established after a successful negotiation\. Otherwise, the value is set to `-`\.  | 

### Examples<a name="access-log-entry-examples"></a>

**Example HTTP entry**  
The following is an example log entry for an HTTP listener \(port 80 to port 80\):

```
2015-05-13T23:39:43.945958Z my-loadbalancer 192.168.131.39:2817 10.0.0.1:80 0.000073 0.001048 0.000057 200 200 0 29 "GET http://www.example.com:80/ HTTP/1.1" "curl/7.38.0" - -
```

**Example HTTPS entry**  
The following is an example log entry for an HTTPS listener \(port 443 to port 80\):

```
2015-05-13T23:39:43.945958Z my-loadbalancer 192.168.131.39:2817 10.0.0.1:80 0.000086 0.001048 0.001337 200 200 0 57 "GET https://www.example.com:443/ HTTP/1.1" "curl/7.38.0" DHE-RSA-AES128-SHA TLSv1.2
```

**Example TCP entry**  
The following is an example log entry for an TCP listener \(port 8080 to port 80\):

```
2015-05-13T23:39:43.945958Z my-loadbalancer 192.168.131.39:2817 10.0.0.1:80 0.001069 0.000028 0.000041 - - 82 305 "- - - " "-" - -
```

**Example SSL entry**  
The following is an example log entry for an SSL listener \(port 8443 to port 80\):

```
2015-05-13T23:39:43.945958Z my-loadbalancer 192.168.131.39:2817 10.0.0.1:80 0.001065 0.000015 0.000023 - - 57 502 "- - - " "-" ECDHE-ECDSA-AES128-GCM-SHA256 TLSv1.2
```

## Processing access logs<a name="log-processing-tools"></a>

If there is a lot of demand on your website, your load balancer can generate log files with gigabytes of data\. You might not be able to process such a large amount of data using line\-by\-line processing\. Therefore, you might have to use analytical tools that provide parallel processing solutions\. For example, you can use the following analytical tools to analyze and process access logs:
+ Amazon Athena is an interactive query service that makes it easy to analyze data in Amazon S3 using standard SQL\. For more information, see [Querying Classic Load Balancer logs](https://docs.aws.amazon.com/athena/latest/ug/elasticloadbalancer-classic-logs.html) in the *Amazon Athena User Guide*\.
+ [Loggly](https://www.loggly.com/docs/s3-ingestion-auto/)
+ [Splunk](https://splunkbase.splunk.com/app/1274/)
+ [Sumo Logic](https://www.sumologic.com/application/elb/)
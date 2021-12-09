# Troubleshoot your Classic Load Balancer<a name="elb-troubleshooting"></a>

The following tables list the troubleshooting resources that you'll find useful as you work with a Classic Load Balancer\.


**API errors**  

| Error | 
| --- | 
| [CertificateNotFound: Undefined](ts-elb-error-api-response.md#ts-elb-error-message-certificate) | 
| [OutofService: A transient error occurred](ts-elb-error-api-response.md#ts-elb-error-message-service) | 


**HTTP errors**  

| Error | 
| --- | 
| [HTTP 400: BAD\_REQUEST](ts-elb-error-message.md#ts-elb-errorcodes-http400) | 
| [HTTP 405: METHOD\_NOT\_ALLOWED](ts-elb-error-message.md#ts-elb-errorcodes-http405) | 
| [HTTP 408: Request timeout](ts-elb-error-message.md#ts-elb-errorcodes-http408) | 
| [HTTP 502: Bad gateway](ts-elb-error-message.md#ts-elb-errorcodes-http502) | 
| [HTTP 503: Service unavailable](ts-elb-error-message.md#ts-elb-errorcodes-http503) | 
| [HTTP 504: Gateway timeout](ts-elb-error-message.md#ts-elb-errorcodes-http504) | 


**Response code metrics**  

| Response code metric | 
| --- | 
| [HTTPCode\_ELB\_4XX](ts-elb-http-errors.md#ts-elb-error-metrics-ELB_4XX) | 
| [HTTPCode\_ELB\_5XX](ts-elb-http-errors.md#ts-elb-error-metrics-ELB_5XX) | 
| [HTTPCode\_Backend\_2XX](ts-elb-http-errors.md#ts-elb-error-metrics-Backend_2XX) | 
| [HTTPCode\_Backend\_3XX](ts-elb-http-errors.md#ts-elb-error-metrics-Backend_3XX) | 
| [HTTPCode\_Backend\_4XX](ts-elb-http-errors.md#ts-elb-error-metrics-Backend_4XX) | 
| [HTTPCode\_Backend\_5XX](ts-elb-http-errors.md#ts-elb-error-metrics-Backend_5XX) | 


**Health check issues**  

| Issue | 
| --- | 
| [Health check target page error](ts-elb-healthcheck.md#ts-elb-healthcheck-targetpage) | 
| [Connection to the instances has timed out](ts-elb-healthcheck.md#ts-elb-healthcheck-failed) | 
| [Public key authentication is failing](ts-elb-healthcheck.md#ts-elb-healthcheck-publickey) | 
| [Instance is not receiving traffic from the load balancer](ts-elb-healthcheck.md#ts-elb-healthcheck-securitygroup) | 
| [Ports on instance are not open](ts-elb-healthcheck.md#ts-elb-healthcheck-ports) | 
| [Instances in an Auto Scaling group are failing the ELB health check](ts-elb-healthcheck.md#ts-elb-healthcheck-autoscaling) | 


**Connectivity issues**  

| Issue | 
| --- | 
| [Clients cannot connect to the load balancer](ts-elb-connection-failed.md) | 


**Instance registration issues**  

| Issue | 
| --- | 
| [Taking too long to register an EC2 instance](ts-elb-register-instance.md#ts-elb-register-too-long) | 
| [Unable to register an instance launched from a paid AMI](ts-elb-register-instance.md#ts-elb-paid-ami-instance) | 
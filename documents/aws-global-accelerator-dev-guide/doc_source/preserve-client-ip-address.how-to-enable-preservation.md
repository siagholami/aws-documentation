# How to enable client IP address preservation<a name="preserve-client-ip-address.how-to-enable-preservation"></a>

When you create a new accelerator, client IP address preservation is enabled, by default, for supported endpoints\. 

Be aware of the following:
+ Internal Application Load Balancers and EC2 instances always have client IP address preservation enabled\. You can't disable the option for these endpoints\.
+ When you use the AWS console to create a new accelerator, the option for client IP address preservation is enabled by default for Application Load Balancer endpoints\. You can disable the option at any time if you don't want client IP address preservation for an internet\-facing Application Load Balancer endpoint\.
+ When you use the AWS CLI or an API action to create a new accelerator and you don't specify the option for client IP address preservation, internet\-facing Application Load Balancer endpoints have client IP address preservation enabled by default\.
+ Global Accelerator does not support client IP address preservation for Network Load Balancer and Elastic IP address endpoints\.

For existing accelerators, you can transition endpoints without client IP address preservation to endpoints that do preserve the client IP address\. Existing Application Load Balancer endpoints can be transitioned to new Application Load Balancer endpoints, and existing Elastic IP address endpoints can be transitioned to EC2 instance endpoints\. \(Network Load Balancer endpoints don't support client IP address preservation\.\) To transition to the new endpoints, we recommend that you move traffic slowly from an existing endpoint to a new endpoint that has client IP address preservation by doing the following:
+ For existing Application Load Balancer endpoints, first add to Global Accelerator a duplicate Application Load Balancer endpoint that targets the same backends and, if it's an internet\-facing Application Load Balancer, enable client IP address preservation for it\. Then adjust the weights on the endpoints to slowly move traffic from the load balancer that does *not* have client IP address preservation enabled to the load balancer *with* client IP address preservation\.
+ For an existing Elastic IP address endpoint, you can move traffic to an EC2 instance endpoint with client IP address preservation\. First add an EC2 instance endpoint to Global Accelerator, and then adjust the weights on the endpoints to slowly move traffic from the Elastic IP address endpoint to the EC2 instance endpoint\.

For step\-by\-step transition guidance, see [ Transitioning endpoints to use client IP address preservation](about-endpoints.transition-to-IP-preservation.md)\.
# HTTPS listeners for your Classic Load Balancer<a name="elb-https-load-balancers"></a>

You can create a load balancer that uses the SSL/TLS protocol for encrypted connections \(also known as *SSL offload*\)\. This feature enables traffic encryption between your load balancer and the clients that initiate HTTPS sessions, and for connections between your load balancer and your EC2 instances\.

Elastic Load Balancing uses Secure Sockets Layer \(SSL\) negotiation configurations, known as *security policies*, to negotiate connections between the clients and the load balancer\. When you use HTTPS/SSL for your front\-end connections, you can use either a predefined security policy or a custom security policy\. You must deploy an SSL certificate on your load balancer\. The load balancer uses this certificate to terminate the connection and then decrypt requests from clients before sending them to the instances\. The load balancer uses a static cipher suite for back\-end connections\. You can optionally choose to enable authentication on your instances\.

Elastic Load Balancing does not support Server Name Indication \(SNI\) on your load balancer\. You can use one of the following alternatives instead:
+ Deploy one certificate on the load balancer, and add a Subject Alternative Name \(SAN\) for each additional website\. SANs enable you to protect multiple host names using a single certificate\. Check with your certificate provider for more information about the number of SANs they support per certificate and how to add and remove SANs\.
+ Use TCP listeners on port 443 for the front\-end and back\-end connections\. The load balancer passes the request through as is, so you can handle HTTPS termination from the EC2 instance\.

**Topics**
+ [SSL/TLS certificates for Classic Load Balancers](ssl-server-cert.md)
+ [SSL negotiation configurations for Classic Load Balancers](elb-ssl-security-policy.md)
+ [Create a Classic Load Balancer with an HTTPS listener](elb-create-https-ssl-load-balancer.md)
+ [Configure an HTTPS listener for your Classic Load Balancer](elb-add-or-delete-listeners.md)
+ [Replace the SSL certificate for your Classic Load Balancer](elb-update-ssl-cert.md)
+ [Update the SSL negotiation configuration of your Classic Load Balancer](ssl-config-update.md)
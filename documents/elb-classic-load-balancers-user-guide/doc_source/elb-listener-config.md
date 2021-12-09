# Listeners for your Classic Load Balancer<a name="elb-listener-config"></a>

Before you start using Elastic Load Balancing, you must configure one or more *listeners* for your Classic Load Balancer\. A listener is a process that checks for connection requests\. It is configured with a protocol and a port for front\-end \(client to load balancer\) connections, and a protocol and a port for back\-end \(load balancer to back\-end instance\) connections\.

Elastic Load Balancing supports the following protocols:
+ HTTP
+ HTTPS \(secure HTTP\)
+ TCP
+ SSL \(secure TCP\)

The HTTPS protocol uses the SSL protocol to establish secure connections over the HTTP layer\. You can also use the SSL protocol to establish secure connections over the TCP layer\.

If the front\-end connection uses TCP or SSL, then your back\-end connections can use either TCP or SSL\. If the front\-end connection uses HTTP or HTTPS, then your back\-end connections can use either HTTP or HTTPS\.

Back\-end instances can listen on ports 1\-65535\.

Load balancers can listen on the following ports:
+ \[EC2\-VPC\] 1\-65535
+ \[EC2\-Classic\] 25, 80, 443, 465, 587, 1024\-65535

**Topics**
+ [Protocols](#elb-listener-protocols)
+ [HTTPS/SSL listeners](#https-ssl-listeners)
+ [Listener configurations for Classic Load Balancers](using-elb-listenerconfig-quickref.md)
+ [HTTP headers and Classic Load Balancers](x-forwarded-headers.md)

## Protocols<a name="elb-listener-protocols"></a>

Communication for a typical web application goes through layers of hardware and software\. Each layer provides a specific communication function\. The control over the communication function is passed from one layer to the next, in sequence\. The Open System Interconnection \(OSI\) defines a model framework for implementing a standard format for communication, called a *protocol*, in these layers\. For more information, see [OSI model](http://en.wikipedia.org/wiki/OSI_model) in Wikipedia\.

When you use Elastic Load Balancing, you need a basic understanding of layer 4 and layer 7\. Layer 4 is the transport layer that describes the Transmission Control Protocol \(TCP\) connection between the client and your back\-end instance, through the load balancer\. Layer 4 is the lowest level that is configurable for your load balancer\. Layer 7 is the application layer that describes the use of Hypertext Transfer Protocol \(HTTP\) and HTTPS \(secure HTTP\) connections from clients to the load balancer and from the load balancer to your back\-end instance\.

The Secure Sockets Layer \(SSL\) protocol is primarily used to encrypt confidential data over insecure networks such as the internet\. The SSL protocol establishes a secure connection between a client and the back\-end server, and ensures that all the data passed between your client and your server is private and integral\.

### TCP/SSL protocol<a name="using-elb-tcp-layer4"></a>

When you use TCP \(layer 4\) for both front\-end and back\-end connections, your load balancer forwards the request to the back\-end instances without modifying the headers\. After your load balancer receives the request, it attempts to open a TCP connection to the back\-end instance on the port specified in the listener configuration\.

Because load balancers intercept traffic between clients and your back\-end instances, the access logs for your back\-end instance contain the IP address of the load balancer instead of the originating client\. You can enable proxy protocol, which adds a header with the connection information of the client, such as the source IP address, destination IP address, and port numbers\. The header is then sent to the back\-end instance as a part of the request\. You can parse the first line in the request to retrieve the connection information\. For more information, see [Configure proxy protocol support for your Classic Load Balancer](enable-proxy-protocol.md)\.

Using this configuration, you do not receive cookies for session stickiness or X\-Forwarded headers\.

### HTTP/HTTPS protocol<a name="using-elb-http-layer7"></a>

When you use HTTP \(layer 7\) for both front\-end and back\-end connections, your load balancer parses the headers in the request and terminates the connection before sending the request to the back\-end instances\.

For every registered and healthy instance behind an HTTP/HTTPS load balancer, Elastic Load Balancing opens and maintains one or more TCP connections\. These connections ensure that there is always an established connection ready to receive HTTP/HTTPS requests\.

The HTTP requests and HTTP responses use header fields to send information about HTTP messages\. Elastic Load Balancing supports `X-Forwarded-For` headers\. Because load balancers intercept traffic between clients and servers, your server access logs contain only the IP address of the load balancer\. To see the IP address of the client, use the `X-Forwarded-For` request header\. For more information, see [X\-Forwarded\-For](x-forwarded-headers.md#x-forwarded-for)\.

When you use HTTP/HTTPS, you can enable sticky sessions on your load balancer\. A sticky session binds a user's session to a specific back\-end instance\. This ensures that all requests coming from the user during the session are sent to the same back\-end instance\. For more information, see [Configure sticky sessions for your Classic Load Balancer](elb-sticky-sessions.md)\.

Not all HTTP extensions are supported in the load balancer\. You may need to use a TCP listener if the load balancer is not able to terminate the request due to unexpected methods, response codes, or other non\-standard HTTP 1\.0/1\.1 implementations\.

## HTTPS/SSL listeners<a name="https-ssl-listeners"></a>

You can create a load balancer with the following security features\.

### SSL server certificates<a name="ssl-cert"></a>

If you use HTTPS or SSL for your front\-end connections, you must deploy an X\.509 certificate \(SSL server certificate\) on your load balancer\. The load balancer decrypts requests from clients before sending them to the back\-end instances \(known as *SSL termination*\)\. For more information, see [SSL/TLS certificates for Classic Load Balancers](ssl-server-cert.md)\.

If you don't want the load balancer to handle the SSL termination \(known as *SSL offloading*\), you can use TCP for both the front\-end and back\-end connections, and deploy certificates on the registered instances handling requests\.

### SSL negotiation<a name="using-elb-cipher-settings"></a>

Elastic Load Balancing provides predefined SSL negotiation configurations that are used for SSL negotiation when a connection is established between a client and your load balancer\. The SSL negotiation configurations provide compatibility with a broad range of clients and use high\-strength cryptographic algorithms called *ciphers*\. However, some use cases might require all data on the network to be encrypted and allow only specific ciphers\. Some security compliance standards \(such as PCI, SOX, and so on\) might require a specific set of protocols and ciphers from clients to ensure that the security standards are met\. In such cases, you can create a custom SSL negotiation configuration, based on your specific requirements\. Your ciphers and protocols should take effect within 30 seconds\. For more information, see [SSL negotiation configurations for Classic Load Balancers](elb-ssl-security-policy.md)\.

### Back\-end server authentication<a name="using-elb-backend-auth"></a>

If you use HTTPS or SSL for your back\-end connections, you can enable authentication of your registered instances\. You can then use the authentication process to ensure that the instances accept only encrypted communication, and to ensure that each registered instance has the correct public key\.

For more information, see [Configure Back\-end Server Authentication](elb-create-https-ssl-load-balancer.md#configure_backendauth_clt)\.
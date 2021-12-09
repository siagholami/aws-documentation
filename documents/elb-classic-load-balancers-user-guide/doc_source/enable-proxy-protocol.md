# Configure proxy protocol support for your Classic Load Balancer<a name="enable-proxy-protocol"></a>

Proxy protocol is an internet protocol used to carry connection information from the source requesting the connection to the destination for which the connection was requested\. Elastic Load Balancing uses proxy protocol version 1, which uses a human\-readable header format\.

By default, when you use Transmission Control Protocol \(TCP\) for both front\-end and back\-end connections, your Classic Load Balancer forwards requests to the instances without modifying the request headers\. If you enable proxy protocol, a human\-readable header is added to the request header with connection information such as the source IP address, destination IP address, and port numbers\. The header is then sent to the instance as part of the request\.

**Note**  
The AWS Management Console does not support enabling proxy protocol\.

**Topics**
+ [Proxy protocol header](#proxy-protocol)
+ [Prerequisites for enabling proxy protocol](#proxy-protocol-prerequisites)
+ [Enable proxy protocol using the AWS CLI](#enable-proxy-protocol-cli)
+ [Disable proxy protocol using the AWS CLI](#proxy-protocol-disable-policy-cli)

## Proxy protocol header<a name="proxy-protocol"></a>

The proxy protocol header helps you identify the IP address of a client when you have a load balancer that uses TCP for back\-end connections\. Because load balancers intercept traffic between clients and your instances, the access logs from your instance contain the IP address of the load balancer instead of the originating client\. You can parse the first line of the request to retrieve your client's IP address and the port number\.

The address of the proxy in the header for IPv6 is the public IPv6 address of your load balancer\. This IPv6 address matches the IP address that is resolved from your load balancer's DNS name, which begins with either `ipv6` or `dualstack`\. If the client connects with IPv4, the address of the proxy in the header is the private IPv4 address of the load balancer, which is not resolvable through a DNS lookup outside of the EC2\-Classic network\.

The proxy protocol line is a single line that ends with a carriage return and line feed \(`"\r\n"`\), and has the following form:

```
PROXY_STRING + single space + INET_PROTOCOL + single space + CLIENT_IP + single space + PROXY_IP + single space + CLIENT_PORT + single space + PROXY_PORT + "\r\n"
```

**Example: IPv4**  
The following is an example of the proxy protocol line for IPv4\.

```
PROXY TCP4 198.51.100.22 203.0.113.7 35646 80\r\n
```

**Example: IPv6 \(EC2\-Classic only\)**  
The following is an example of the proxy protocol line for IPv6\.

```
PROXY TCP6 2001:DB8::21f:5bff:febf:ce22:8a2e 2001:DB8::12f:8baa:eafc:ce29:6b2e 35646 80\r\n
```

## Prerequisites for enabling proxy protocol<a name="proxy-protocol-prerequisites"></a>

Before you begin, do the following:
+ Confirm that your load balancer is not behind a proxy server with proxy protocol enabled\. If proxy protocol is enabled on both the proxy server and the load balancer, the load balancer adds another header to the request, which already has a header from the proxy server\. Depending on how your instance is configured, this duplication might result in errors\.
+ Confirm that your instances can process the proxy protocol information\.
+ Confirm that your listener settings support proxy protocol\. For more information, see [Listener configurations for Classic Load Balancers](using-elb-listenerconfig-quickref.md)\.

## Enable proxy protocol using the AWS CLI<a name="enable-proxy-protocol-cli"></a>

To enable proxy protocol, you must create a policy of type `ProxyProtocolPolicyType` and then enable the policy on the instance port\.

Use the following procedure to create a new policy for your load balancer of type `ProxyProtocolPolicyType`, set the newly created policy to the instance on port `80`, and verify that the policy is enabled\.

**To enable proxy protocol for your load balancer**

1. \(Optional\) Use the following [describe\-load\-balancer\-policy\-types](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancer-policy-types.html) command to list the policies supported by Elastic Load Balancing:

   ```
   aws elb describe-load-balancer-policy-types
   ```

   The response includes the names and descriptions of the supported policy types\. The following shows the output for the `ProxyProtocolPolicyType` type:

   ```
   {
       "PolicyTypeDescriptions": [
           ...
           {
               "PolicyAttributeTypeDescriptions": [
                   {
                       "Cardinality": "ONE",
                       "AttributeName": "ProxyProtocol",
                       "AttributeType": "Boolean"
                   }
               ],
               "PolicyTypeName": "ProxyProtocolPolicyType",
               "Description": "Policy that controls whether to include the IP address and port of the originating 
   request for TCP messages. This policy operates on TCP/SSL listeners only"
           },
           ...
       ]
   }
   ```

1. Use the following [create\-load\-balancer\-policy](https://docs.aws.amazon.com/cli/latest/reference/elb/create-load-balancer-policy.html) command to create a policy that enables proxy protocol:

   ```
   aws elb create-load-balancer-policy --load-balancer-name my-loadbalancer --policy-name my-ProxyProtocol-policy --policy-type-name ProxyProtocolPolicyType --policy-attributes AttributeName=ProxyProtocol,AttributeValue=true
   ```

1. Use the following [set\-load\-balancer\-policies\-for\-backend\-server](https://docs.aws.amazon.com/cli/latest/reference/elb/set-load-balancer-policies-for-backend-server.html) command to enable the newly created policy on the specified port\. Note that this command replaces the current set of enabled policies\. Therefore, the `--policy-names` option must specify both the policy that you are adding to the list \(for example, `my-ProxyProtocol-policy`\) and any policies that are currently enabled \(for example, `my-existing-policy`\)\.

   ```
   aws elb set-load-balancer-policies-for-backend-server --load-balancer-name my-loadbalancer --instance-port 80 --policy-names my-ProxyProtocol-policy my-existing-policy
   ```

1. \(Optional\) Use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to verify that proxy protocol is enabled:

   ```
   aws elb describe-load-balancers --load-balancer-name my-loadbalancer
   ```

   The response includes the following information, which shows that the `my-ProxyProtocol-policy` policy is associated with port `80`\.

   ```
   {
       "LoadBalancerDescriptions": [
           {
               ...
               "BackendServerDescriptions": [
                   {
                       "InstancePort": 80, 
                       "PolicyNames": [
                           "my-ProxyProtocol-policy"
                       ]
                   }
               ], 
               ...
           }
       ]
   }
   ```

## Disable proxy protocol using the AWS CLI<a name="proxy-protocol-disable-policy-cli"></a>

You can disable the policies associated with your instance and then enable them at a later time\.

**To disable the proxy protocol policy**

1. Use the following [set\-load\-balancer\-policies\-for\-backend\-server](https://docs.aws.amazon.com/cli/latest/reference/elb/set-load-balancer-policies-for-backend-server.html) command to disable the proxy protocol policy by omitting it from the `--policy-names` option, but including the other policies that should remain enabled \(for example, `my-existing-policy`\)\.

   ```
   aws elb set-load-balancer-policies-for-backend-server --load-balancer-name my-loadbalancer --instance-port 80 --policy-names my-existing-policy
   ```

   If there are no other policies to enable, specify an empty string with `--policy-names` option as follows:

   ```
   aws elb set-load-balancer-policies-for-backend-server --load-balancer-name my-loadbalancer --instance-port 80 --policy-names "[]"
   ```

1. \(Optional\) Use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to verify that the policy is disabled:

   ```
   aws elb describe-load-balancers --load-balancer-name my-loadbalancer
   ```

   The response includes the following information, which shows that no ports are associated with a policy\.

   ```
   {
       "LoadBalancerDescriptions": [
           {
               ...
               "BackendServerDescriptions": [],
               ...
           }
       ]
   }
   ```
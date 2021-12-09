# Predefined SSL security policies for Classic Load Balancers<a name="elb-security-policy-table"></a>

You can choose one of the predefined security policies for your HTTPS/SSL listeners\. We recommend the default predefined security policy, `ELBSecurityPolicy-2016-08`, for compatibility\. You can use one of the `ELBSecurityPolicy-TLS` policies to meet compliance and security standards that require disabling certain TLS protocol versions\. For more information about updating the SSL negotiation configuration, see [Update the SSL negotiation configuration of your Classic Load Balancer](ssl-config-update.md)\.

The RSA\- and DSA\-based ciphers are specific to the signing algorithm used to create SSL certificate\. Make sure to create an SSL certificate using the signing algorithm that is based on the ciphers that are enabled for your security policy\.

The following table describes the most recent predefined security policies, including their enabled SSL protocols and SSL ciphers\. If you select a policy that is enabled for Server Order Preference, the load balancer uses the ciphers in the order that they are specified in this table to negotiate connections between the client and load balancer\. Otherwise, the load balancer uses the ciphers in the order that they are presented by the client\.


| Security policy | 2016\-08 | TLS\-1\-1\-2017\-01 | TLS\-1\-2\-2017\-01 | 2015\-05 | 2015\-03 | 2015\-02 | 
| --- |--- |--- |--- |--- |--- |--- |
| **SSL Protocols** | 
| --- |
| Protocol\-TLSv1 | ♦ |  |  | ♦ | ♦ | ♦ | 
| Protocol\-TLSv1\.1 | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| Protocol\-TLSv1\.2 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| **SSL Options** | 
| --- |
| Server Order Preference | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| **SSL Ciphers** | 
| --- |
| ECDHE\-ECDSA\-AES128\-GCM\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-RSA\-AES128\-GCM\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-ECDSA\-AES128\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-RSA\-AES128\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-ECDSA\-AES128\-SHA | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| ECDHE\-RSA\-AES128\-SHA | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| DHE\-RSA\-AES128\-SHA |  |  |  |  | ♦ | ♦ | 
| ECDHE\-ECDSA\-AES256\-GCM\-SHA384 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-RSA\-AES256\-GCM\-SHA384 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-ECDSA\-AES256\-SHA384 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-RSA\-AES256\-SHA384 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| ECDHE\-RSA\-AES256\-SHA | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| ECDHE\-ECDSA\-AES256\-SHA | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| AES128\-GCM\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| AES128\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| AES128\-SHA | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| AES256\-GCM\-SHA384 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| AES256\-SHA256 | ♦ | ♦ | ♦ | ♦ | ♦ | ♦ | 
| AES256\-SHA | ♦ | ♦ |  | ♦ | ♦ | ♦ | 
| DHE\-DSS\-AES128\-SHA |  |  |  |  | ♦ | ♦ | 
| DES\-CBC3\-SHA |  |  |  | ♦ | ♦ |  | 

**Predefined security policies**

The following are the predefined security policies for Classic Load Balancers\. To describe a predefined policy, use the [describe\-load\-balancer\-policies](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancer-policies.html) command\.
+ ELBSecurityPolicy\-2016\-08
+ ELBSecurityPolicy\-TLS\-1\-2\-2017\-01
+ ELBSecurityPolicy\-TLS\-1\-1\-2017\-01
+ ELBSecurityPolicy\-2015\-05
+ ELBSecurityPolicy\-2015\-03
+ ELBSecurityPolicy\-2015\-02
+ ELBSecurityPolicy\-2014\-10
+ ELBSecurityPolicy\-2014\-01
+ ELBSecurityPolicy\-2011\-08
+ ELBSample\-ELBDefaultNegotiationPolicy or ELBSample\-ELBDefaultCipherPolicy
+ ELBSample\-OpenSSLDefaultNegotiationPolicy or ELBSample\-OpenSSLDefaultCipherPolicy
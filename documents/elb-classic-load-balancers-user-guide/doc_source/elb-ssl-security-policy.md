# SSL negotiation configurations for Classic Load Balancers<a name="elb-ssl-security-policy"></a>

Elastic Load Balancing uses a Secure Socket Layer \(SSL\) negotiation configuration, known as a *security policy*, to negotiate SSL connections between a client and the load balancer\. A security policy is a combination of SSL protocols, SSL ciphers, and the Server Order Preference option\. For more information about configuring an SSL connection for your load balancer, see [Listeners for your Classic Load Balancer](elb-listener-config.md)\.

**Topics**
+ [Security policies](#security-policy-types)
+ [SSL protocols](#ssl-protocols)
+ [Server Order Preference](#server-order-preference)
+ [SSL ciphers](#ssl-ciphers)
+ [Predefined SSL security policies for Classic Load Balancers](elb-security-policy-table.md)

## Security policies<a name="security-policy-types"></a>

A security policy determines which ciphers and protocols are supported during SSL negotiations between a client and a load balancer\. You can configure your Classic Load Balancers to use either predefined or custom security policies\.

Note that a certificate provided by AWS Certificate Manager \(ACM\) contains an RSA public key\. Therefore, you must include a cipher suite that uses RSA in your security policy if you use a certificate provided by ACM; otherwise, the TLS connection fails\.

**Predefined security policies**  
The names of the most recent predefined security policies includes version information based on the year and month that they were released\. For example, the default predefined security policy is `ELBSecurityPolicy-2016-08`\. Whenever a new predefined security policy is released, you can update your configuration to use it\.

For information about the protocols and ciphers enabled for the predefined security policies, see [Predefined SSL security policies](elb-security-policy-table.md)\.

**Custom security policies**  
You can create a custom negotiation configuration with the ciphers and protocols that you need\. For example, some security compliance standards \(such as PCI and SOC\) might require a specific set of protocols and ciphers to ensure that the security standards are met\. In such cases, you can create a custom security policy to meet those standards\.

For information about creating a custom security policy, see [Update the SSL negotiation configuration of your Classic Load Balancer](ssl-config-update.md)\.

## SSL protocols<a name="ssl-protocols"></a>

The *SSL protocol* establishes a secure connection between a client and a server, and ensures that all the data passed between the client and your load balancer is private\.

Secure Sockets Layer \(SSL\) and Transport Layer Security \(TLS\) are cryptographic protocols that are used to encrypt confidential data over insecure networks such as the internet\. The TLS protocol is a newer version of the SSL protocol\. In the Elastic Load Balancing documentation, we refer to both SSL and TLS protocols as the SSL protocol\.

**SSL protocols**

The following versions of the SSL protocol are supported:
+ TLS 1\.2
+ TLS 1\.1
+ TLS 1\.0
+ SSL 3\.0

**Deprecated SSL protocol**  
If you previously enabled the SSL 2\.0 protocol in a custom policy, we recommend that you update your security policy to the default predefined security policy\.

## Server Order Preference<a name="server-order-preference"></a>

Elastic Load Balancing supports the *Server Order Preference* option for negotiating connections between a client and a load balancer\. During the SSL connection negotiation process, the client and the load balancer present a list of ciphers and protocols that they each support, in order of preference\. By default, the first cipher on the client's list that matches any one of the load balancer's ciphers is selected for the SSL connection\. If the load balancer is configured to support Server Order Preference, then the load balancer selects the first cipher in its list that is in the client's list of ciphers\. This ensures that the load balancer determines which cipher is used for SSL connection\. If you do not enable Server Order Preference, the order of ciphers presented by the client is used to negotiate connections between the client and the load balancer\.

## SSL ciphers<a name="ssl-ciphers"></a>

An *SSL cipher* is an encryption algorithm that uses encryption keys to create a coded message\. SSL protocols use several SSL ciphers to encrypt data over the internet\.

Note that a certificate provided by AWS Certificate Manager \(ACM\) contains an RSA public key\. Therefore, you must include a cipher suite that uses RSA in your security policy if you use a certificate provided by ACM; otherwise, the TLS connection fails\.

Elastic Load Balancing supports the following ciphers for use with Classic Load Balancers\. A subset of these ciphers are used by the predefined SSL policies\. All of these ciphers are available for use in a custom policy\. We recommend that you use only the ciphers included in the default security policy \(those with an asterisk\)\. Many of the other ciphers are not secure and should be used at your own risk\.

**Ciphers**
+ ECDHE\-ECDSA\-AES128\-GCM\-SHA256 \*
+ ECDHE\-RSA\-AES128\-GCM\-SHA256 \*
+ ECDHE\-ECDSA\-AES128\-SHA256 \*
+ ECDHE\-RSA\-AES128\-SHA256 \*
+ ECDHE\-ECDSA\-AES128\-SHA \*
+ ECDHE\-RSA\-AES128\-SHA \*
+ DHE\-RSA\-AES128\-SHA
+ ECDHE\-ECDSA\-AES256\-GCM\-SHA384 \*
+ ECDHE\-RSA\-AES256\-GCM\-SHA384 \*
+ ECDHE\-ECDSA\-AES256\-SHA384 \*
+ ECDHE\-RSA\-AES256\-SHA384 \*
+ ECDHE\-RSA\-AES256\-SHA \*
+ ECDHE\-ECDSA\-AES256\-SHA \*
+ AES128\-GCM\-SHA256 \*
+ AES128\-SHA256 \*
+ AES128\-SHA \*
+ AES256\-GCM\-SHA384 \*
+ AES256\-SHA256 \*
+ AES256\-SHA \*
+ DHE\-DSS\-AES128\-SHA
+ CAMELLIA128\-SHA
+ EDH\-RSA\-DES\-CBC3\-SHA
+ DES\-CBC3\-SHA
+ ECDHE\-RSA\-RC4\-SHA
+ RC4\-SHA
+ ECDHE\-ECDSA\-RC4\-SHA
+ DHE\-DSS\-AES256\-GCM\-SHA384
+ DHE\-RSA\-AES256\-GCM\-SHA384
+ DHE\-RSA\-AES256\-SHA256
+ DHE\-DSS\-AES256\-SHA256
+ DHE\-RSA\-AES256\-SHA
+ DHE\-DSS\-AES256\-SHA
+ DHE\-RSA\-CAMELLIA256\-SHA
+ DHE\-DSS\-CAMELLIA256\-SHA
+ CAMELLIA256\-SHA
+ EDH\-DSS\-DES\-CBC3\-SHA
+ DHE\-DSS\-AES128\-GCM\-SHA256
+ DHE\-RSA\-AES128\-GCM\-SHA256
+ DHE\-RSA\-AES128\-SHA256
+ DHE\-DSS\-AES128\-SHA256
+ DHE\-RSA\-CAMELLIA128\-SHA
+ DHE\-DSS\-CAMELLIA128\-SHA
+ ADH\-AES128\-GCM\-SHA256
+ ADH\-AES128\-SHA
+ ADH\-AES128\-SHA256
+ ADH\-AES256\-GCM\-SHA384
+ ADH\-AES256\-SHA
+ ADH\-AES256\-SHA256
+ ADH\-CAMELLIA128\-SHA
+ ADH\-CAMELLIA256\-SHA
+ ADH\-DES\-CBC3\-SHA
+ ADH\-DES\-CBC\-SHA
+ ADH\-RC4\-MD5
+ ADH\-SEED\-SHA
+ DES\-CBC\-SHA
+ DHE\-DSS\-SEED\-SHA
+ DHE\-RSA\-SEED\-SHA
+ EDH\-DSS\-DES\-CBC\-SHA
+ EDH\-RSA\-DES\-CBC\-SHA
+ IDEA\-CBC\-SHA
+ RC4\-MD5
+ SEED\-SHA
+ DES\-CBC3\-MD5
+ DES\-CBC\-MD5
+ RC2\-CBC\-MD5
+ PSK\-AES256\-CBC\-SHA
+ PSK\-3DES\-EDE\-CBC\-SHA
+ KRB5\-DES\-CBC3\-SHA
+ KRB5\-DES\-CBC3\-MD5
+ PSK\-AES128\-CBC\-SHA
+ PSK\-RC4\-SHA
+ KRB5\-RC4\-SHA
+ KRB5\-RC4\-MD5
+ KRB5\-DES\-CBC\-SHA
+ KRB5\-DES\-CBC\-MD5
+ EXP\-EDH\-RSA\-DES\-CBC\-SHA
+ EXP\-EDH\-DSS\-DES\-CBC\-SHA
+ EXP\-ADH\-DES\-CBC\-SHA
+ EXP\-DES\-CBC\-SHA
+ EXP\-RC2\-CBC\-MD5
+ EXP\-KRB5\-RC2\-CBC\-SHA
+ EXP\-KRB5\-DES\-CBC\-SHA
+ EXP\-KRB5\-RC2\-CBC\-MD5
+ EXP\-KRB5\-DES\-CBC\-MD5
+ EXP\-ADH\-RC4\-MD5
+ EXP\-RC4\-MD5
+ EXP\-KRB5\-RC4\-SHA
+ EXP\-KRB5\-RC4\-MD5

\* These are the recommended ciphers included in the default security policy\.
# Update the SSL negotiation configuration of your Classic Load Balancer<a name="ssl-config-update"></a>

Elastic Load Balancing provides security policies that have predefined SSL negotiation configurations to use to negotiate SSL connections between clients and your load balancer\. If you are using the HTTPS/SSL protocol for your listener, you can use one of the predefined security policies, or use your own custom security policy\.

For more information about the security policies, see [SSL negotiation configurations for Classic Load Balancers](elb-ssl-security-policy.md)\. For information about the configurations of the security policies provided by Elastic Load Balancing, see [Predefined SSL security policies](elb-security-policy-table.md)\.

If you create an HTTPS/SSL listener without associating a security policy, Elastic Load Balancing associates the default predefined security policy, `ELBSecurityPolicy-2016-08`, with your load balancer\.

If you have an existing load balancer with an SSL negotiation configuration that does not use the latest protocols and ciphers, we recommend that you update your load balancer to use ELBSecurityPolicy\-2016\-08\. If you prefer, you can create a custom configuration\. We strongly recommend that you test the new security policies before you upgrade your load balancer configuration\.

The following examples show you how to update the SSL negotiation configuration for an HTTPS/SSL listener\. Note that the change does not affect requests that were received by a load balancer node and are pending routing to a healthy instance, but the updated configuration will be used with new requests that are received\.

**Topics**
+ [Update the SSL negotiation configuration using the console](#ssl-config-update-console)
+ [Update the SSL negotiation configuration using the AWS CLI](#ssl-config-update-cli)

## Update the SSL negotiation configuration using the console<a name="ssl-config-update-console"></a>

By default, Elastic Load Balancing associates the latest predefined policy with your load balancer\. When a new predefined policy is added, we recommend that you update your load balancer to use the new predefined policy\. Alternatively, you can select a different predefined security policy or create a custom policy\.

**To update SSL negotiation configuration for an HTTPS/SSL load balancer**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Listeners** tab, for **Cipher**, choose **Change**\.

1. On the **Select a Cipher** page, select a security policy using one of the following options:
   + \(Recommended\) Select **Predefined Security Policy**, keep the default policy, **ELBSecurityPolicy\-2016\-08**, and then choose **Save**\.
   + Select **Predefined Security Policy**, select a predefined policy other than the default, and then choose **Save**\.
   + Select **Custom Security Policy** and enable at least one protocol and one cipher as follows:

     1. For **SSL Protocols**, select one or more protocols to enable\.

     1. For **SSL Options**, select **Server Order Preference** to use the order listed in the [Predefined SSL security policies](elb-security-policy-table.md) for SSL negotiation\.

     1. For **SSL Ciphers**, select one or more ciphers to enable\. If you already have an SSL certificate, you must enable the cipher that was used to create the certificate, because DSA and RSA ciphers are specific to the signing algorithm\.

     1. Choose **Save**\.

## Update the SSL negotiation configuration using the AWS CLI<a name="ssl-config-update-cli"></a>

You can use the default predefined security policy, `ELBSecurityPolicy-2016-08`, a different predefined security policy, or a custom security policy\.

**To use a predefined SSL security policy**

1. Use the following [describe\-load\-balancer\-policies](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancer-policies.html) command to list the predefined security policies provided by Elastic Load Balancing\. The syntax that you use depends on the operating system and shell that you are using\.

   **Linux**

   ```
   aws elb describe-load-balancer-policies --query 'PolicyDescriptions[?PolicyTypeName==`SSLNegotiationPolicyType`].{PolicyName:PolicyName}' --output table
   ```

   **Windows**

   ```
   aws elb describe-load-balancer-policies --query "PolicyDescriptions[?PolicyTypeName==`SSLNegotiationPolicyType`].{PolicyName:PolicyName}" --output table
   ```

   The following is example output:

   ```
   ------------------------------------------
   |      DescribeLoadBalancerPolicies      |
   +----------------------------------------+
   |               PolicyName               |
   +----------------------------------------+
   |  ELBSecurityPolicy-2016-08             |
   |  ELBSecurityPolicy-TLS-1-2-2017-01     |
   |  ELBSecurityPolicy-TLS-1-1-2017-01     |
   |  ELBSecurityPolicy-2015-05             |
   |  ELBSecurityPolicy-2015-03             |
   |  ELBSecurityPolicy-2015-02             |
   |  ELBSecurityPolicy-2014-10             |
   |  ELBSecurityPolicy-2014-01             |
   |  ELBSecurityPolicy-2011-08             |
   |  ELBSample-ELBDefaultCipherPolicy      |
   |  ELBSample-OpenSSLDefaultCipherPolicy  |
   +----------------------------------------+
   ```

   To determine which ciphers are enabled for a policy, use the following command:

   ```
   aws elb describe-load-balancer-policies --policy-names ELBSecurityPolicy-2016-08 --output table
   ```

   For information about the configuration for the predefined security policies, see [Predefined SSL security policies](elb-security-policy-table.md)\.

1. Use the [create\-load\-balancer\-policy](https://docs.aws.amazon.com/cli/latest/reference/elb/create-load-balancer-policy.html) command to create an SSL negotiation policy using one of the predefined security policies that you described in the previous step\. For example, the following command uses the default predefined security policy:

   ```
   aws elb create-load-balancer-policy --load-balancer-name my-loadbalancer
   --policy-name my-SSLNegotiation-policy  --policy-type-name SSLNegotiationPolicyType
   --policy-attributes AttributeName=Reference-Security-Policy,AttributeValue=ELBSecurityPolicy-2016-08
   ```

   If you exceed the limit on the number of policies for the load balancer, use the [delete\-load\-balancer\-policy](https://docs.aws.amazon.com/cli/latest/reference/elb/delete-load-balancer-policy.html) command to delete any unused policies\.

1. \(Optional\) Use the following [describe\-load\-balancer\-policies](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancer-policies.html) command to verify that the policy is created:

   ```
   aws elb describe-load-balancer-policies --load-balancer-name my-loadbalancer --policy-name my-SSLNegotiation-policy
   ```

   The response includes the description of the policy\.

1. Use the following [set\-load\-balancer\-policies\-of\-listener](https://docs.aws.amazon.com/cli/latest/reference/elb/set-load-balancer-policies-of-listener.html) command to enable the policy on load balancer port 443:

   ```
   aws elb set-load-balancer-policies-of-listener --load-balancer-name my-loadbalancer --load-balancer-port 443 --policy-names my-SSLNegotiation-policy
   ```
**Note**  
The `set-load-balancer-policies-of-listener` command replaces the current set of policies for the specified load balancer port with the the specified set of policies\. The `--policy-names` list must include all policies to be enabled\. If you omit a policy that is currently enabled, it is disabled\.

1. \(Optional\) Use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to verify that the new policy is enabled for the load balancer port:

   ```
   aws elb describe-load-balancers --load-balancer-name my-loadbalancer
   ```

   The response shows that the policy is enabled on port 443\.

   ```
   ...
     {
         "Listener": {
             "InstancePort": 443,
             "SSLCertificateId": "ARN",
             "LoadBalancerPort": 443,
             "Protocol": "HTTPS",
             "InstanceProtocol": "HTTPS"
         },
         "PolicyNames": [
             "my-SSLNegotiation-policy"
         ]
     }
   ...
   ```

When you create a custom security policy, you must enable at least one protocol and one cipher\. The DSA and RSA ciphers are specific to the signing algorithm and are used to create the SSL certificate\. If you already have an SSL certificate, be sure to enable the cipher that was used to create the certificate\. The name of your custom policy must not begin with `ELBSecurityPolicy-` or `ELBSample-`, as these prefixes are reserved for the names of the predefined security policies\.

**To use a custom SSL security policy**

1. Use the [create\-load\-balancer\-policy](https://docs.aws.amazon.com/cli/latest/reference/elb/create-load-balancer-policy.html) command to create an SSL negotiation policy using a custom security policy\. For example:

   ```
   aws elb create-load-balancer-policy --load-balancer-name my-loadbalancer 
    --policy-name my-SSLNegotiation-policy --policy-type-name SSLNegotiationPolicyType 
    --policy-attributes AttributeName=Protocol-TLSv1.2,AttributeValue=true 
    AttributeName=Protocol-TLSv1.1,AttributeValue=true 
    AttributeName=DHE-RSA-AES256-SHA256,AttributeValue=true 
    AttributeName=Server-Defined-Cipher-Order,AttributeValue=true
   ```

   If you exceed the limit on the number of policies for the load balancer, use the [delete\-load\-balancer\-policy](https://docs.aws.amazon.com/cli/latest/reference/elb/delete-load-balancer-policy.html) command to delete any unused policies\.

1. \(Optional\) Use the following [describe\-load\-balancer\-policies](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancer-policies.html) command to verify that the policy is created:

   ```
   aws elb describe-load-balancer-policies --load-balancer-name my-loadbalancer --policy-name my-SSLNegotiation-policy
   ```

   The response includes the description of the policy\.

1. Use the following [set\-load\-balancer\-policies\-of\-listener](https://docs.aws.amazon.com/cli/latest/reference/elb/set-load-balancer-policies-of-listener.html) command to enable the policy on load balancer port 443:

   ```
   aws elb set-load-balancer-policies-of-listener --load-balancer-name my-loadbalancer --load-balancer-port 443 --policy-names my-SSLNegotiation-policy
   ```
**Note**  
The `set-load-balancer-policies-of-listener` command replaces the current set of policies for the specified load balancer port with the the specified set of policies\. The `--policy-names` list must include all policies to be enabled\. If you omit a policy that is currently enabled, it is disabled\.

1. \(Optional\) Use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to verify that the new policy is enabled for the load balancer port:

   ```
   aws elb describe-load-balancers --load-balancer-name my-loadbalancer
   ```

   The response shows that the policy is enabled on port 443\.

   ```
   ...
     {
         "Listener": {
             "InstancePort": 443,
             "SSLCertificateId": "ARN",
             "LoadBalancerPort": 443,
             "Protocol": "HTTPS",
             "InstanceProtocol": "HTTPS"
         },
         "PolicyNames": [
             "my-SSLNegotiation-policy"
         ]
     }
   ...
   ```
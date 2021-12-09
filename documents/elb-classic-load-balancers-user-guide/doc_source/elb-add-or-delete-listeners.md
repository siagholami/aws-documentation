# Configure an HTTPS listener for your Classic Load Balancer<a name="elb-add-or-delete-listeners"></a>

A *listener* is a process that checks for connection requests\. It is configured with a protocol and a port for front\-end \(client to load balancer\) connections and a protocol and a port for back\-end \(load balancer to instance\) connections\. For information about the ports, protocols, and listener configurations supported by Elastic Load Balancing, see [Listeners for your Classic Load Balancer](elb-listener-config.md)\.

If you have a load balancer with a listener that accepts HTTP requests on port 80, you can add a listener that accepts HTTPS requests on port 443\. If you specify that the HTTPS listener sends requests to the instances on port 80, the load balancer terminates the SSL requests and communication from the load balancer to the instances is not encrypted\. If the HTTPS listener sends requests to the instances on port 443, communication from the load balancer to the instances is encrypted\.

If your load balancer uses an encrypted connection to communicate with instances, you can optionally enable authentication of the instances\. This ensures that the load balancer communicates with an instance only if its public key matches the key that you specified to the load balancer for this purpose\.

For information about creating a new HTTPS listener, see [Create a Classic Load Balancer with an HTTPS listener](elb-create-https-ssl-load-balancer.md)\.

**Topics**
+ [Prerequisites](#add-listener-prerequisites)
+ [Add an HTTPS listener using the console](#add-listener-console)
+ [Add an HTTPS listener using the AWS CLI](#add-listener-cli)

## Prerequisites<a name="add-listener-prerequisites"></a>

To enable HTTPS support for an HTTPS listener, you must deploy an SSL server certificate on your load balancer\. The load balancer uses the certificate to terminate and then decrypt requests before sending them to the instances\. If you do not have an SSL certificate, you can create one\. For more information, see [SSL/TLS certificates for Classic Load Balancers](ssl-server-cert.md)\.

## Add an HTTPS listener using the console<a name="add-listener-console"></a>

You can add an HTTPS listener to an existing load balancer\.

**To add an HTTPS listener to your load balancer**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Select your load balancer\.

1. On the **Listeners** tab, choose **Edit**\.

1. On the **Edit listeners** page, choose **Add**\.

1. For **Load Balancer Protocol**, select **HTTPS \(Secure HTTP\)**\. This updates **Load Balancer Port**, **Instance Protocol**, and **Instance Port**\.
**Important**  
By default, the instance protocol is HTTP\. If you want to set up back\-end instance authentication, change the instance protocol to HTTPS \(Secure HTTP\)\. This also updates the instance port\.

1. For **Cipher**, choose **Change**\. Verify that **Predefined Security Policy** is selected and set to **ELBSecurityPolicy\-2016\-08**\. We recommend that you always use the latest predefined security policy\. If you need to use a different predefined security policy or create a custom policy, see [Update the SSL Negotiation Configuration](ssl-config-update.md#ssl-config-update-console)\.

1. If you already have a certificate deployed on your load balancer and want to continue using it, you can skip this step\.

   For **SSL Certificate**, choose **Change**, and then do one of the following:
   + If you create or imported a certificate using AWS Certificate Manager, select **Choose an existing certificate from AWS Certificate Manager \(ACM\)**, select the certificate from **Certificate**, and then choose **Save**\.
**Note**  
This option is available only in Regions that support AWS Certificate Manager\.
   + If you imported a certificate using IAM, select **Choose an existing certificate from AWS Identity and Access Management \(IAM\)**, select the certificate from **Certificate**, and then choose **Save**\.
   + If you have an SSL certificate to import but ACM is not supported in this Region, select **Upload a new SSL Certificate to AWS Identity and Access Management \(IAM\)**\. Type the name of the certificate\. In **Private Key**, copy and paste the contents of the private key file \(PEM\-encoded\)\. In **Public Key Certificate**, copy and paste the contents of the public key certificate file \(PEM\-encoded\)\. In **Certificate Chain**, copy and paste the contents of the certificate chain file \(PEM\-encoded\), unless you are using a self\-signed certificate and it's not important that browsers implicitly accept the certificate\.

1. \(Optional\) Choose **Add** to add additional listeners\.

1. Choose **Save** to add the listeners you just configured\.

1. \(Optional\) To set up back\-end instance authentication for an existing load balancer, you must use the AWS CLI or an API, as this task is not supported using the console\. For more information, see [Configure Back\-end Instance Authentication](elb-create-https-ssl-load-balancer.md#configure_backendauth_clt)\.

## Add an HTTPS listener using the AWS CLI<a name="add-listener-cli"></a>

You can add an HTTPS listener to an existing load balancer\.

**To add an HTTPS listener to your load balancer using the AWS CLI**

1. Get the Amazon Resource Name \(ARN\) of the SSL certificate\. For example:

   **ACM**

   ```
   arn:aws:acm:region:123456789012:certificate/12345678-1234-1234-1234-123456789012
   ```

   **IAM**

   ```
   arn:aws:iam::123456789012:server-certificate/my-server-certificate
   ```

1. Use the following [create\-load\-balancer\-listeners](https://docs.aws.amazon.com/cli/latest/reference/elb/create-load-balancer-listeners.html) command to add a listener to your load balancer that accepts HTTPS requests on port 443 and sends the requests to the instances on port 80 using HTTP:

   ```
   aws elb create-load-balancer-listeners --load-balancer-name my-load-balancer --listeners Protocol=HTTPS,LoadBalancerPort=443,InstanceProtocol=HTTP,InstancePort=80,SSLCertificateId=ARN
   ```

   If you want to set up back\-end instance authentication, use the following command to add a listener that accepts HTTPS requests on port 443 and sends the requests to the instances on port 443 using HTTPS:

   ```
   aws elb create-load-balancer-listeners --load-balancer-name my-load-balancer --listeners Protocol=HTTPS,LoadBalancerPort=443,InstanceProtocol=HTTPS,InstancePort=443,SSLCertificateId=ARN
   ```

1. \(Optional\) You can use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to view the updated details of your load balancer:

   ```
   aws elb describe-load-balancers --load-balancer-name my-load-balancer
   ```

   The following is an example response:

   ```
   {
       "LoadBalancerDescriptions": [
           {
               ...
               "ListenerDescriptions": [
                   {
                       "Listener": {
                           "InstancePort": 80, 
                           "SSLCertificateId": "ARN", 
                           "LoadBalancerPort": 443, 
                           "Protocol": "HTTPS", 
                           "InstanceProtocol": "HTTP"
                       }, 
                       "PolicyNames": [
                           "ELBSecurityPolicy-2016-08"
                       ]
                   }, 
                   {
                       "Listener": {
                           "InstancePort": 80, 
                           "LoadBalancerPort": 80, 
                           "Protocol": "HTTP", 
                           "InstanceProtocol": "HTTP"
                       }, 
                       "PolicyNames": []
                   }
               ], 
               ...
           }
       ]
   }
   ```

1. \(Optional\) Your HTTPS listener was created using the default security policy\. If you want to specify a different predefined security policy or a custom security policy, use the [create\-load\-balancer\-policy](https://docs.aws.amazon.com/cli/latest/reference/elb/create-load-balancer-policy.html) and [set\-load\-balancer\-policies\-of\-listener](https://docs.aws.amazon.com/cli/latest/reference/elb/set-load-balancer-policies-of-listener.html) commands\. For more information, see [Update the SSL negotiation configuration using the AWS CLI](ssl-config-update.md#ssl-config-update-cli)\.

1. \(Optional\) To set up back\-end instance authentication, use the [set\-load\-balancer\-policies\-for\-backend\-server](https://docs.aws.amazon.com/cli/latest/reference/elb/set-load-balancer-policies-for-backend-server.html) command\. For more information, see [Configure Back\-end Instance Authentication](elb-create-https-ssl-load-balancer.md#configure_backendauth_clt)\.
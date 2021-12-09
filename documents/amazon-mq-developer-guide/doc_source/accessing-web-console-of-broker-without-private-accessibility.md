# Accessing the ActiveMQ Web Console of a Broker without Public Accessibility<a name="accessing-web-console-of-broker-without-private-accessibility"></a>

If you disable public accessibility for your broker, you must perform the following steps to be able to access your broker's ActiveMQ Web Console\.

**Note**  
The names of the VPCs and security groups are specific to the following example\.

## Prerequisites<a name="accessing-web-console-of-broker-without-private-accessibility-prerequisites"></a>

To perform the following steps, you must configure the following:
+ **VPCs**
  + The VPC without an internet gateway, to which the Amazon MQ broker is attached, named `private-vpc`\.
  + A second VPC, with an internet gateway, named `public-vpc`\.
  + Both VPCs must be connected \(for example, using [VPC peering](https://docs.aws.amazon.com/vpc/latest/peering/Welcome.html)\) so that the Amazon EC2 instances in the public VPC can communicate with the EC2 instances in the private VPC\.
  + If you use VPC peering, the route tables for both VPCs must be configured for the peering connection\.
+ **Security Groups**
  + The security group used to create the Amazon MQ broker, named `private-sg`\.
  + A second security group used for the EC2 instance in the `public-vpc` VPC, named `public-sg`\.
  + `private-sg` must allow inbound connections from `public-sg`\. We recommend restricting this security group to port 8162\.
  + `public-sg` must allow inbound connections from your machine on port 22\.

## To Access the ActiveMQ Web Console of a Broker without Public Accessibility<a name="accessing-web-console-of-broker-without-private-accessibility-tutorial"></a>

1. Create a Linux EC2 instance in `public-vpc` \(with a public IP, if necessary\)\.

1. To verify that your VPC is configured correctly, establish an `ssh` connection to the EC2 instance and use the `curl` command with the URI of your broker\.

1. From your machine, create an `ssh` tunnel to the EC2 instance using the path to your private key file and the IP address of your broker instance\. For example:

   ```
   ssh -i ~/.ssh/id_rsa -N -C -q -f -D 8080 ec2-user@203.0.113.0
   ```

   A forward proxy server is started on your machine\.

1. Install a proxy client such as [FoxyProxy](https://getfoxyproxy.org/) on your machine\.

1. Configure your proxy client using the following settings:
   + For proxy type, specify `SOCKS5`\.
   + For IP address, DNS name, and server name, specify `localhost`\.
   + For port, specify `8080`\.
   + Remove any existing URL patterns\.
   + For the URL pattern, specify `*.mq.*.amazonaws.com*`
   + For the connection type, specify `HTTP(S)`\.

   When you enable your proxy client, you can access the ActiveMQ Web Console on your machine\.
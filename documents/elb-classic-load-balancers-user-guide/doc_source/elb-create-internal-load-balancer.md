# Create an internal Classic Load Balancer<a name="elb-create-internal-load-balancer"></a>

You can create an internal load balancer to distribute traffic to your EC2 instances from clients with access to the VPC for the load balancer\.

**Topics**
+ [Prerequisites](#create-internal-lb-prereq)
+ [Create an internal load balancer using the console](#create-internal-lb)
+ [Create an internal load balancer using the AWS CLI](#create-internal-lb-cli)

## Prerequisites<a name="create-internal-lb-prereq"></a>
+ If you have not yet created a VPC for your load balancer, you must create it before you get started\. For more information, see [Prepare your VPC and EC2 instances](elb-backend-instances.md#set-up-ec2)\.
+ Launch the EC2 instances that you plan to register with your internal load balancer\. Ensure that you launch them in private subnets in the VPC intended for the load balancer\.

## Create an internal load balancer using the console<a name="create-internal-lb"></a>

By default, Elastic Load Balancing creates an internet\-facing load balancer\. Use the following procedure to create an internal load balancer and register your EC2 instances with the newly created internal load balancer\.

**To create an internal load balancer**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, under **LOAD BALANCING**, choose **Load Balancers**\.

1. Choose **Create Load Balancer**\.

1. For **Select load balancer type**, choose **Classic Load Balancer**\.

1. On the **Define Load Balancer** page, do the following:

   1. For **Load Balancer name**, type a name for your load balancer\.

      The name of your Classic Load Balancer must be unique within your set of Classic Load Balancers for the region, can have a maximum of 32 characters, can contain only alphanumeric characters and hyphens, and must not begin or end with a hyphen\.

   1. For **Create LB inside**, select a VPC for your load balancer\.

   1. Choose **Create an internal load balancer**\.

   1. \[Default VPC\] If you selected a default VPC and would like to select subnets for your load balancer, choose **Enable advanced VPC configuration**\.

   1. Leave the default listener configuration\.  
![\[Define your internal load balancer\]](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/images/DefineLB_Internal.png)

   1. For **Available subnets**, select at least one available subnet using its add icon\. The subnet is moved under **Selected subnets**\. To improve the availability of your load balancer, select more than one subnet\.
**Note**  
If you selected a default VPC as your network, but did not select **Enable advanced VPC configuration**, you do not have the option to select subnets\.

      You can attach at most one subnet per Availability Zone\. If you select a subnet from an Availability Zone where there is already an attached subnet, this subnet replaces the currently attached subnet for the Availability Zone\.

   1. Choose **Next: Assign Security Groups**\.

1. On the **Assign Security Groups** page, choose **Create a new security group**\. Enter a name and description for your security group, or leave the default name and description\. This new security group contains a rule that allows traffic to the port that you configured your load balancer to use\. If you will use a different port for the health checks, you must choose **Add Rule** to add a rule that allows inbound traffic to that port as well\. Choose **Next: Configure Security Settings**\.

1. On the **Configure Security Settings** page, choose **Next: Configure Health Check** to continue to the next step\. If you prefer to create a HTTPS load balancer, see [HTTPS listeners for your Classic Load Balancer](elb-https-load-balancers.md)\.

1. On the **Configure Health Check** page, configure the health check settings that your application requires, and then choose **Next: Add EC2 Instances**\.

1. On the **Add EC2 Instances** page, select the instances to register with your load balancer, and then choose **Next: Add Tags**\.
**Note**  
When you register an instance with an elastic network interface \(ENI\) attached, the load balancer routes traffic to the primary IP address of the primary interface \(eth0\) of the instance\.

1. \(Optional\) You can add tags to your load balancer\. When you are finished adding tags, choose **Review and Create**\.

1. On the **Review** page, check your settings\. If you need to make changes, choose the corresponding link to edit the settings\. When you are finished, choose **Create**\.

1. After you are notified that your load balancer was created, choose **Close**\.

1. Select your new load balancer\.

1. On the **Description** tab, note that **DNS name** and **Scheme** indicate that the load balancer is internal\.

   Check the **Status** row\. If it indicates that some of your instances are not in service, its probably because they are still in the registration process\. For more information, see [Troubleshoot a Classic Load Balancer: Instance registration](ts-elb-register-instance.md)\.

## Create an internal load balancer using the AWS CLI<a name="create-internal-lb-cli"></a>

By default, Elastic Load Balancing creates an internet\-facing load balancer\. Use the following procedure to create an internal load balancer and register your EC2 instances with the newly created internal load balancer\.

**To create an internal load balancer**

1. Use the [create\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/create-load-balancer.html) command with the `--scheme` option set to `internal`, as follows:

   ```
   aws elb create-load-balancer --load-balancer-name my-internal-loadbalancer --listeners Protocol=HTTP,LoadBalancerPort=80,InstanceProtocol=HTTP,InstancePort=80
    --subnets subnet-4e05f721 --scheme internal --security-groups sg-b9ffedd5
   ```

   The following is an example response\. Note that the name indicates that this is an internal load balancer\.

   ```
   {
       "DNSName": "internal-my-internal-loadbalancer-786501203.us-west-2.elb.amazonaws.com"
   }
   ```

1. Use the following [register\-instances\-with\-load\-balancer](https://docs.aws.amazon.com/cli/latest/reference/elb/register-instances-with-load-balancer.html) command to add instances:

   ```
   aws elb register-instances-with-load-balancer --load-balancer-name my-internal-loadbalancer --instances i-4f8cf126 i-0bb7ca62
   ```

   The following is an example response:

   ```
   {
       "Instances": [
           {
               "InstanceId": "i-4f8cf126"
           },
           {
               "InstanceId": "i-0bb7ca62"
           }
       ]
   }
   ```

1. \(Optional\) Use the following [describe\-load\-balancers](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-load-balancers.html) command to verify the internal load balancer: 

   ```
   aws elb describe-load-balancers --load-balancer-name my-internal-loadbalancer
   ```

   The response includes the `DNSName` and `Scheme` fields, which indicate that this is an internal load balancer\.

   ```
   {
       "LoadBalancerDescriptions": [
           {
               ...
               "DNSName": "internal-my-internal-loadbalancer-1234567890.us-west-2.elb.amazonaws.com", 
               "SecurityGroups": [
                   "sg-b9ffedd5"
               ], 
               "Policies": {
                   "LBCookieStickinessPolicies": [], 
                   "AppCookieStickinessPolicies": [], 
                   "OtherPolicies": []
               }, 
               "LoadBalancerName": "my-internal-loadbalancer", 
               "CreatedTime": "2014-05-22T20:32:19.920Z", 
               "AvailabilityZones": [
                   "us-west-2a"
               ], 
               "Scheme": "internal",
               ...
           }
       ]
   }
   ```
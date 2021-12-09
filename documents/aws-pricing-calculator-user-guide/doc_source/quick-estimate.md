# Quick estimates<a name="quick-estimate"></a>

The quick estimate path is designed to give you a ballpark estimate while requiring minimal information and parameters\. This way you can get a rough idea of how much AWS might cost you even when you don't have all, or even many, of the details of how you plan to use AWS\.

Each parameter has a default setting, so if you don't know what you want for that particular parameter, you can still generate an estimate\.

The quick estimate path has the following sections and parameters:
+ [Amazon EC2 specifications](#quick-ec2-specifications)
+ [Pricing strategy](#quick-pricing-strategy)
+ [Amazon EBS](#quick-ebs)

## Amazon EC2 specifications<a name="quick-ec2-specifications"></a>

These settings determine the Amazon EC2 instance that AWS Pricing Calculator uses to generate an estimate for you\.

**Select your operating system**  
The default value for the operating system \(OS\) is Linux\. 

**Number of EC2 instances**  
The default value is one\. AWS Pricing Calculator uses this default because it's the minimum number that you might need\.

**Enter requirements per instance**  
To find an instance, search either by minimum requirements or by name\. Minimum requirements are most useful when you know the specifications of the instances that you want, and instance name is more useful if you already know the instance family or size of the instance that you want\. For example, you can search either for an instance with a minimum of four vCPUs and 16 GB of memory or for a t2 or medium instance\.   
There are multiple defaults when you search for an instance by instance requirements\. The default value for **vCPUs** is four, and the default for **Memory** is 16 \(GB\)\. AWS Pricing Calculator uses these defaults because they're the minimum required to do general\-purpose processing\.

**Instance name**  
To find an instance, search either by minimum requirements or by name\. Minimum requirements are most useful when you know the specifications of the instances that you want, and instance name is more useful if you already know the instance family or size of the instance that you want\. For example, you can search either for an instance with a minimum of 4 vCPUs and 16 GB of memory or for a t2 or medium instance\.  
There is no default value for the instance name because AWS Pricing Calculator searches the available instances for the least expensive option, which can change over time\.  
For information about the available Amazon EC2 instance families, see [Instance type](advanced-estimate.md#ec2-advanced-instance-type)\.

## Pricing strategy<a name="quick-pricing-strategy"></a>

These settings determine the pricing strategy that AWS Pricing Calculator uses to generate an estimate for you\.

**Pricing model**  
The pricing model determines whether you are searching for a pay\-as\-you\-use instance or an instance that you can reserve in advance\. Reserving an instance is not the same as paying for the use of an instance\. For Reserved Instance \(RI\) payment options, see [](#quick-ec2-payment-options)\.   
The default value is Standard Reserved Instances\. AWS Pricing Calculator uses this default because they are the most common Amazon EC2 purchase and offer the most flexibility and the highest discount for most use cases\.

**Contract terms**  
When you reserve an RI, you purchase a reservation for the period of your contract\. Contracts can be for either one or three years\.   
The default value is one year\. AWS Pricing Calculator uses this default because it's the least expensive option for trying out AWS\.

**Payment options**  
For RIs, payment options determine when you pay for your reservation\. You can pay for the entire reservation upfront, which is a hefty single\-time payment but you have no monthly payments\. You can pay for the RI with a partial upfront payment and a monthly payment, which gives you a smaller upfront cost but accrues monthly costs\. You can also pay with no upfront payment, which means you pay only on a monthly basis\. All upfront gives you the best discount, but no upfront and partial upfront spread your costs out over a greater period of time\.  
The default value for the payment options is No Upfront\. AWS Pricing Calculator uses this default because it gives you the least expensive start\-up price\.

## Amazon EBS<a name="quick-ebs"></a>

These settings determine the Amazon EBS settings that AWS Pricing Calculator uses to generate an estimate for you\. Amazon Elastic Block Store \(Amazon EBS\) is a type of storage that you can connect to your Amazon EC2 instance\. It enables you to do things such as back up your instance, create a boot volume, or run a database on your instance\. For more information on how you can use Amazon EBS, see the [Amazon Elastic Block Store documentation](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AmazonEBS.html)\.

**Storage volume**  
The storage volume determines what kind of storage that Amazon EBS assigns to your instance\. Different types have different capabilities, such as better I/O, faster calculations, or slower, less expensive options for use cases such as boot volumes and backups\.  
The default value is the General Purpose SSD\. AWS Pricing Calculator uses this default because it's good at both I/O and storage while not being expensive\.

**Storage amount**  
The storage amount determines how much storage your Amazon EBS volume has\.  
The default value is 30 GB\. AWS Pricing Calculator uses this default because it's a decent amount of storage for a decent price\.
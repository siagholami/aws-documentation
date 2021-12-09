# Advanced estimates<a name="advanced-estimate"></a>

The advanced estimate path is designed to give you a more accurate estimate, more parameter flexibility when generating an estimate, and the ability to fine\-tune your estimate\. It requires more in\-depth knowledge of your Amazon EC2 needs and requirements than an estimate that you generate using the quick estimate path\.

Use the advanced estimate path for estimates that need to account for workload, data transfer costs, additional storage options, and other, less common instance requirements\. For example, you know that you get a lot of traffic on Mondays but not much traffic throughout the rest of the week, and you want an estimate that accounts for this workload\. 

The advanced estimate path has the following sections and parameters:
+ [Operating system](#ec2-advanced-os)
+ [Instance type](#ec2-advanced-instance-type)
+ [Workload](#ec2-advanced-workload)
+ [Pricing](#ec2-advanced-pricing)
+ [Data transfer](#ec2-advanced-data-transfer)
+ [Memory \(block storage\)](#ec2-advanced-memory)

## Operating system<a name="ec2-advanced-os"></a>

This setting is the OS on an Amazon EC2 instance\. AWS Pricing Calculator generates your estimate using Amazon Machine Images \(AMIs\) that match your chosen OS\. Choose the OS that best matches your needs\.

**Linux**  
AWS Pricing Calculator generates your estimate using a standard Linux AMI\.

**Linux SQL**  
AWS Pricing Calculator generates your estimate using a Linux SQL AMI\.

**Red Hat Enterprise Linux**  
AWS Pricing Calculator generates your estimate using a Red Hat Enterprise Linux AMI\.

**SUSE Linux Enterprise Server**  
AWS Pricing Calculator generates your estimate using a SUSE Linux Enterprise AMI\.

**Windows Server**  
AWS Pricing Calculator generates your estimate using a standard Windows Server AMI\.

**Windows Server Bring Your Own License**  
AWS Pricing Calculator generates your estimate without including your license costs\.

**Windows Server with SQL Server Enterprise**  
AWS Pricing Calculator generates your estimate using a Windows Server with SQL server Enterprise AMI\.

**Windows Server with SQL Server Standard**  
AWS Pricing Calculator generates your estimate using a Windows Server with SQL Server Standard AMI\.

**Windows Server with SQL Server Web**  
AWS Pricing Calculator generates your estimate using a Windows Server with SQL Server Web AMI\.

## Instance type<a name="ec2-advanced-instance-type"></a>

AWS Pricing Calculator lists all available instance types\. AWS Pricing Calculator starts with the default instance type **t2\.xlarge** selected\. You can use the search bar to filter the instance list by column names\. If you don't select a column to filter by, AWS Pricing Calculator uses the **API name** column as the default\.

For more information about the prices of available instance types, see the [Amazon EC2 Pricing](https://aws.amazon.com/ec2/pricing/) page\. 

## Workload<a name="ec2-advanced-workload"></a>

Workloads are the usage patterns that match your Amazon EC2 usage\. Choosing the workload that most closely matches what you use reduces the number of On\-Demand and unused RI hours that you might purchase by covering your usage with the best combination of RIs and On\-Demand Instances\. You can define more than one workload for your estimate\. 

**Constant usage**  
This workload is best for a use case that has a constant, predicable load, such as logging traffic to a website or running a process in the background\.

**Daily spike**  
This workload is best for usage patterns that peak once a day, such as running several jobs at midnight or a morning news spike\.

**Weekly spike**  
This workload is best for patterns that peak once a week, such as blogs that post once a week or when you air a weekly television show\. 

**Monthly spike**  
This workload is best for traffic that spikes once a month, such as monthly invoices, payroll, or other monthly reports\. 

## Pricing<a name="ec2-advanced-pricing"></a>

The AWS Pricing Calculator advanced estimate path offers three pricing models for Amazon EC2 instances: Cost optimized, On\-Demand, or Reserved\. Cost optimized combines On\-Demand Instances and RIs for the least expensive option\. 

### Pricing model<a name="advanced-pricing-model"></a>

The pricing model determines whether you are looking for a pay\-as\-you\-use instance, or an instance that you can reserve in advance\. Reserving an instance is not the same as using an instance\. 

**Cost optimized**  
The default value for the pricing model is **Cost optimized**\. AWS Pricing Calculator uses **Cost optimized** as the default because it provides a balance between On\-Demand Instances and RIs\. This means that AWS Pricing Calculator tries to generate an estimate where you aren't buying more RI hours than you need, but you still have the coverage that you need for your peak traffic periods, which your RIs might not cover\. AWS Pricing Calculator does this by determining the break\-even point between the utilization and prices of On\-Demand and Reserved Instances\. For example, if RIs provide a 33% discount then any RIs that are utilized less than 67% would be underutilized, and an On\-Demand Instance would be more cost\-effective\.   
For example, you might need only two RIs to cover your day\-to\-day traffic, but every week you expect a period of traffic where you need four instances\. AWS Pricing Calculator generates an estimate that assumes that you purchase two instances for use during the entire week and that you use On\-Demand Instances to cover your peak traffic\. This enables you to take advantage of the RI discount for your normal traffic, but you avoid paying for two instance reservations that go largely unused\.

**On\-Demand**  
On\-Demand Instances let you pay for an instance's compute capacity by the hour or second \(for a minimum of 60 seconds\) with no long\-term commitments\. This means that you don't need to plan, purchase, or maintain instances that you don't use often\.  
For example, you're demoing a program to a friend\. You don't need the program to run for long, but your local computer can't handle the load\. You can use an On\-Demand Instance to run the program and show it off, but you don't need to worry about paying for the server once you're done with it\.

**Reserved**  
RIs provide a discount compared to On\-Demand Instance pricing and can be purchased for a one\-year or three\-year term\. Depending on the type of RI, you can change your Availability Zone, instance size, and networking type or your instance family, operating system, and tenancy\. This enables you to pay less for instances that you use for long periods of time\.  
For example, you run a website\. You're not going to take down your website often, so you want to leave the server running all of the time\. You can purchase a reservation and run your website on the RI\.

**Dedicated**  
Dedicated Instances are available for On\-Demand and Reserved Instances\. You pay the normal hourly usage fee as well as an hourly region fee\. Dedicated Instances run in a VPC on hardware that is dedicated to a single customer\. They're physically isolated at the host hardware level from instances that belong to other AWS accounts\.  
For example, you run a server with a server\-bound software license\. A Dedicated Instance enables you to bind your license to a specific instance and meet corporate compliance and regulatory requirements\.

### Contract terms<a name="advanced-contract-terms"></a>

When you purchase an RI, you agree to pay for the entire term of the RI, upfront, monthly, or with a combination of the two options\. The terms can last for one or three years\. Paying upfront is a bigger one\-time cost, but less expensive overall\. Paying monthly enables you to spread out your costs over multiple billing periods\.

**No contract**  
No contract means that you're using On\-Demand Instances instead of an RI\. There are no upfront or monthly costs, and you pay only for what you use\. However, you pay full price instead of the discounted rate provided by purchasing an RI\.

**1 YR No Upfront**  
For a one\-year no\-upfront term, you agree to purchase an RI for a one\-year period\. There is no upfront fee, but you pay a monthly fee\.

**1 YR Partial Upfront**  
For a one\-year partial\-upfront term, you agree to purchase an RI for a one\-year period\. There is an upfront fee, but you also pay a monthly fee\. This means that the upfront cost is higher than if you had a no\-upfront term, but the monthly cost is lower, and you pay an overall lower price than for a no\-upfront RI\.

**1 YR No Upfront \- Convertible Reserved Instances**  
For a one\-year no\-upfront term, you agree to purchase an RI for a one\-year period\. There is no upfront fee, but you pay a monthly fee\. For a Convertible RI, you can change the instance families, operating systems, or tenancies of your Convertible RIs over the course of your RI term\. 

**1 YR Partial Upfront \- Convertible Reserved Instances**  
For a one\-year partial\-upfront term, you agree to purchase an RI for a one\-year period\. There is an upfront fee, but you also pay a monthly fee\. This means that the upfront cost is higher than if you had a no\-upfront term, but the monthly cost is lower, and you pay an overall lower price than for a no\-upfront RI\. For a Convertible RI, you can change the instance families, operating systems, or tenancies of your Convertible RIs over the course of your RI term\. 

**1 YR Full Upfront \- Convertible Reserved Instances**  
For a one\-year full\-upfront term, you agree to purchase an RI for a one\-year period\. There is no monthly fee—you pay the entire cost when you purchase the RI\. For a Convertible RI, you can change the instance families, operating systems, or tenancies of your Convertible RIs over the course of your RI term\. 

**3 YR No Upfront**  
For a three\-year no\-upfront term, you agree to purchase an RI for a three\-year period\. There is no upfront fee, but you pay a monthly fee\.

**3 YR Partial Upfront**  
For a three\-year partial\-upfront term, you agree to purchase an RI for a three\-year period\. There is an upfront fee, but you also pay a monthly fee\. This means that the upfront cost is higher than if you had a no\-upfront term, but the monthly cost is lower, and you pay an overall lower price than for a no\-upfront RI\.

**3 YR Full Upfront**  
For a three\-year full\-upfront term, you agree to purchase an RI for a three\-year period\. There is no monthly fee—you pay the entire cost when you purchase the RI\.

**3 YR No Upfront \- Convertible Reserved Instances**  
For a three\-year no\-upfront term, you agree to purchase an RI for a three\-year period\. There is no upfront fee, but you pay a monthly fee\. For a Convertible RI, you can change the instance families, operating systems, or tenancies of your Convertible RIs over the course of your RI term\. 

**3 YR Partial Upfront \- Convertible Reserved Instances**  
For a three\-year partial\-upfront term, you agree to purchase an RI for a three\-year period\. There is an upfront fee, but you also pay a monthly fee\. This means that the upfront cost is higher than if you had a no\-upfront term, but the monthly cost is lower, and you pay an overall lower price than for a no\-upfront RI\. For a Convertible RI, you can change the instance families, operating systems, or tenancies of your Convertible RIs over the course of your RI term\. 

**3 YR Full Upfront \- Convertible Reserved Instances**  
For a three\-year full\-upfront term, you agree to purchase an RI for a three\-year period\. There is no monthly fee—you pay the entire cost when you purchase the RI\. For a Convertible RI, you can change the instance families, operating systems, or tenancies of your Convertible RIs over the course of your RI term\. 

## Data transfer<a name="ec2-advanced-data-transfer"></a>

You can accrue additional costs by transferring data into and out of Amazon EC2\. If you know how much data you can expect to upload or download in a month, you can add these costs to your estimate\. For more information, see the **Data Transfer** section of the [On\-Demand Pricing](https://aws.amazon.com/ec2/pricing/on-demand/) page\.

## Memory \(block storage\)<a name="ec2-advanced-memory"></a>

You can add estimates for storage attached to your instance or for snapshots taken of your instance\. Attaching storage to your instance enables you to run databases, store logs, or create boot volumes for your instance\. Snapshots create backups of the data on your instance, and you can add estimates for regular snapshots to your main estimate\.

### Generating Amazon EBS estimates<a name="ebs-estimates"></a>

You can back up the data on your Amazon EBS volumes to Amazon Simple Storage Service \(Amazon S3\) by taking point\-in\-time snapshots\. Snapshots are incremental backups, which means that only the blocks on the device that have changed since your most recent snapshot are saved\. This minimizes the time required to create the snapshot and saves on storage costs by not duplicating data\. When you delete a snapshot, only the data unique to that snapshot is removed\. Each snapshot contains all of the information that you need to restore your data \(from the moment when the snapshot was taken\) to a new Amazon EBS volume\. 

The total cost for a snapshot is the cost of the initial snapshot plus the incremental snapshots\. AWS Pricing Calculator calculates prices with the assumption that you use AWS Step Functions and Amazon CloudWatch to create an automated monthly retention period for your snapshots, meaning that your snapshots are replaced every month\.

#### Calculating Amazon EBS prices<a name="ebs-calculating-prices"></a>

Snapshots are saved at a specific frequency \(monthly, weekly, daily, or hourly\), so the retention period of each incremental snapshot for a month decreases as the month progresses\. AWS Pricing Calculator tries to estimate the cost of the services that you selected on a monthly basis\.

The prices for snapshots reflect the initial snapshot and the incremental snapshots\.

##### Calculating weekly incremental Amazon EBS prices<a name="ebs-calculating-weekly"></a>

AWS Pricing Calculator uses 7 to 30 different data points to calculate the estimate for any specific incremental snapshot\. We can express the monthly calculation using the following mathematical formula for a snapshot that is scheduled to be taken weekly and has a monthly retention rate\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pricing-calculator/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pricing-calculator/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pricing-calculator/latest/userguide/)

Let's use this formula in an example\. For snapshot storage, you specify the frequency as weekly and the storage amount changed as 30 GB\. Each snapshot storage costs $0\.05/GB\. 


****  

| Week | Snapshot size | Retention length | Cost formula | Snapshot cost | 
| --- | --- | --- | --- | --- | 
|  Snapshot for Week 1  |  30 GB  |  Three weeks  |  30 x $0\.0375 \[$0\.05 x ¾\]  |  $1\.125  | 
|  Snapshot for Week 2  |  30 GB  |  Two weeks  |  30 x $0\.025 \[$0\.05 x ½\]  |  $0\.75  | 
|  Snapshot for Week 3  |  30 GB  |  One week  |  30 x $0\.0125 \[$0\.05 x ¼\]  |  $0\.375  | 

The total monthly cost of these three incremental snapshots, taking the retention period into consideration, is $2\.25\.

By comparison, if we don't take the retention period into consideration, the calculation for the snapshot behaves as though each snapshot is stored for the entire duration\. We can express this using the following mathematical formula\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pricing-calculator/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pricing-calculator/latest/userguide/)![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pricing-calculator/latest/userguide/)

Let's use the same example as before but without taking the retention period into consideration\. For snapshot storage, you specify the frequency as weekly and the storage amount changed as 30 GB\. Each snapshot storage costs $0\.05/GB\.


****  

| Week | Snapshot size | Retention length | Cost formula | Snapshot cost | 
| --- | --- | --- | --- | --- | 
|  Snapshot for Week 1  |  30 GB  |  Not considered  |  30 x $0\.05  |  $1\.50  | 
|  Snapshot for Week 2  |  30 GB  |  Not considered  |  30 x $0\.05  |  $1\.50  | 
|  Snapshot for Week 3  |  30 GB  |  Not considered  |  30 x $0\.05  |  $1\.50  | 

In this case, the total monthly cost of these three incremental snapshots, without taking the retention period into consideration, is $4\.50\.

In other words, the cost of a snapshot calculated with retention is 50% lower than the cost of a snapshot calculated without retention\.
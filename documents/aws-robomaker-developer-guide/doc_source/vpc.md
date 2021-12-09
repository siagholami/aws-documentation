# Configuring an AWS RoboMaker Simulation Job to Access Resources in an Amazon VPC<a name="vpc"></a>

When you create resources in the Amazon Virtual Private Cloud \(Amazon VPC\), they cannot be read through the public internet\. Example resources could be Amazon Redshift data warehouses or Amazon ElastiCache clusters\. They could also be your services on an Amazon Elastic Compute Cloud instance\. By default, resources in an Amazon VPC are not accessible to an AWS RoboMaker simulation job\. 

AWS RoboMaker runs your simulation job in an Amazon VPC by default\. However, to allow your job to access resources in your Amazon VPC, you must provide VPC\-specific data that includes Amazon VPC subnet IDs and security group IDs\. AWS RoboMaker uses this data to set up elastic network interfaces [\(ENIs\)](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_ElasticNetworkInterfaces.html)\. ENIs help your job to connect securely to other resources in your private Amazon VPC\.

AWS RoboMaker does not connect to resources within dedicated tenancy VPCs\. For more information, see [Dedicated VPCs](https://docs.aws.amazon.com/vpc/latest/userguide/dedicated-instance.html)\.

## Configuring an AWS RoboMaker Simulation Job for Amazon VPC Access<a name="vpc-configuring"></a>

Add Amazon VPC data to your AWS RoboMaker simulation job by using the `VpcConfig` parameter at the time you create a job \(see [CreateSimulationJob](API_CreateSimulationJob.md)\)\. Here is an AWS CLI example\.
+ The `create-simulation-job` CLI command specifies the `--vpc-config` parameter\. Use it to provide VPC data at the time you create a simulation job\. In this example, a public IP is assigned\.

  ```
  $ aws robomaker create-simulation-job \
  --output-location s3Bucket=my-bucket,s3Prefix=my-output-folder \
  --max-job-duration-in-seconds 3600 \
  --iam-role my-role-arn \
  --failure-behavior Continue \
  --robot-applications application='my-robot-application-arn,launchConfig={packageName="hello_world_robot",launchFile="rotate.launch"}' \
  --simulation-applications application='my-simulation-application-arn,launchConfig={packageName="hello_world_simulation",launchFile="empty_world.launch"}' \
  --vpc-config assignPublicIp=true,subnets=comma-separated-vpc-subnet-ids,securityGroups=comma-separated-security-group-ids
  ```

  When a simulation job is configured to run in a VPC, it incurs an ENI penalty\. Address resolution may be delayed when you try to connect to network resources\.

## Internet Access for Simulation Jobs<a name="vpc-internet"></a>

AWS RoboMaker uses the VPC data you provide to set up ENIs\. ENIs allow your job to access VPC resources\. Each ENI is assigned a private IP address from the range in the subnets you specify\. The ENI is not assigned any public IP addresses by default\.

If your job requires internet access \(perhaps to find AWS services that do not have VPC endpoints\), you can set up a NAT inside your VPC\. You can use the Amazon VPC NAT gateway\. You can request RoboMaker to assign a public IP\. For more information, see [NAT Gateways](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html) in the *Amazon VPC User Guide*\. You cannot use an internet gateway attached to your VPC\. That requires the ENI to have public IP addresses\. 

To configure internet access when using public Subnets, set `assignPublicIp=true` to assign a public IP to your ENI\.
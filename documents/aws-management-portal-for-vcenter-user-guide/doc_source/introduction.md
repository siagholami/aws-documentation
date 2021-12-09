# What Is AWS Management Portal for vCenter?<a name="introduction"></a>

AWS Management Portal for vCenter provides a simple, easy\-to\-use interface for creating and managing AWS resources from VMware vCenter\. For more information, see [AWS Management Portal for vCenter](http://aws.amazon.com/ec2/vcenter-portal/)\.

**Note**  
For most VM import needs we recommend that you use AWS Server Migration Service\. AWS SMS automates the import process \(reducing the workload of migrating large VM infrastructures\), adds support for incremental updates of changing VMs, and converts your imported VMs into ready\-to\-use Amazon machine images \(AMIs\)\.  
If any of the following are true, you should consider using AWS SMS:  
You are using vCenter 6\.5\.
You want to specify BYOL licenses during migration\.
You are interested in migrating VMs to Amazon EC2\.
You want to use incremental migration\.
You should only use AWS Management Portal for vCenter if you want to manage Amazon EC2 resources from within vSphere Client\. AWS Management Portal for vCenter does not support vCenter 6\.5 or later\.  
To get started with AWS SMS, see [AWS Server Migration Service](https://aws.amazon.com/server-migration-service)\.

## Usage<a name="usage"></a>
+ Administrators manage AWS networks, organize AWS resources using environments, and grant permissions to users at the environment level\.
+ Users can view the instances in the environments that they have permission to read, and create and manage EC2 instances in the environments that they have permission to modify\.
+ Users can import their virtual machines to AWS using the AWS Connector for vCenter\.

## Limitations<a name="limitations"></a>
+ You can connect each vCenter with one AWS account and one authentication provider\.
+ Users can't access the management portal unless they have an account that they can use to log in to vCenter\. When users log in to vCenter and open the management portal, they can see environments, and AWS resources created in that environment, only if an administrator granted them permissions to access the environment\. An administrator can grant users permissions only if their domain and user names meet certain requirements\. Domain and user names are case\-sensitive\. If a user is a domain user, *domain*\\*user* must not exceed 32 characters\. If a user is a local user, *user* must not exceed 32 characters\. The *domain* and *user* values must each begin with a letter and contain only the following characters: a\-z, A\-Z, 0\-9, periods \(\.\), underscores \(\_\), and dashes \(\-\)\. 
+ The management portal primarily supports Amazon EC2 resources\. Future releases might support resources for additional services\.
+ You can't launch EC2 instances into EC2\-Classic; you must launch instances into a VPC\.
+ This is not a comprehensive tool for creating and managing AWS resources\. The management portal enables vCenter users to get started quickly with basic tasks, such as creating a VPC and subnet, and launching an EC2 instance\. To complete more advanced tasks, users must use the AWS Management Console, AWS CLI, or an AWS SDK\. For more information, see [Accessing Amazon EC2](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts.html#access-ec2) in the *Amazon EC2 User Guide*\.

## Requirements<a name="requirements"></a>
+ An AWS account
+ vCenter version 5\.1, 5\.5, or 6\.0\. \(Web client is supported on vCenter 5\.5 and 6\.0 only\)\.
+ Internet Explorer version 10
+ Internet Explorer is set to allow cookies
+ Network connectivity:
  + DHCP: Allow the connector to reach the DHCP server\.
  + DNS: Allow the connector to initiate connections to port 53 for name resolution\. Ensure that your firewall is stateful for these connections\.
  + HTTPS outgoing: Allow the connector to initiate connections on port 443\. Ensure that your firewall is stateful for these connections\.
  + ICMP outgoing: Allow the connector outgoing connections using ICMP\.
  + NTP: Allow the connector to initiate connections to port 123 to synchronize the time with the NTP servers\. Ensure that your firewall is stateful for these connections\.

## How to Get Started<a name="get-started"></a>
+ [Setting Up AWS Management Portal for vCenter](setting-up.md)
+ [Administering AWS Resources Using AWS Management Portal for vCenter](administer-resources.md)
+ [Managing EC2 Instances Using AWS Management Portal for vCenter](manage-instances.md)
+ [Migrating Your Virtual Machine to Amazon EC2 Using AWS Connector for vCenter](migrate-vms.md)
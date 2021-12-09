# What is AWS SMS?<a name="server-migration"></a>

AWS Server Migration Service automates the migration of your on\-premises VMware vSphere, Microsoft Hyper\-V/SCVMM, and Azure virtual machines to the AWS Cloud\. AWS SMS incrementally replicates your server VMs as cloud\-hosted Amazon Machine Images \(AMIs\) ready for deployment on Amazon EC2\. Working with AMIs, you can easily test and update your cloud\-based images before deploying them in production\.

By using AWS SMS to manage your server migrations, you can:
+ **Simplify the cloud migration process\.** You can begin migrating a group of servers with just a few clicks in the AWS Management Console\. After the migration has initiated, AWS SMS manages all the complexities of the migration process, including automatically replicating volumes of live servers to AWS and creating new AMIs periodically\. You can quickly launch EC2 instances from AMIs in the console\.
+ **Orchestrate multi\-server migrations\.** AWS SMS orchestrates server migrations by allowing you to schedule replications and track progress of a group of servers that constitutes an *application*\. You can schedule initial replications, configure replication intervals, and track progress for each server using the console\. When you launch a migrated application, you can apply customized configuration scripts that run during startup\.
+ **Test server migrations incrementally:** With support for incremental replication, AWS SMS allows fast, scalable testing of migrated servers\. Because AWS SMS replicates incremental changes to your on\-premises servers and transfers only the delta to the cloud, you can test small changes iteratively and save on network bandwidth\.
+ **Support the most widely used operating systems\.** AWS SMS supports the replication of operating system images containing Windows, as well as several major Linux distributions\.
+ **Minimize downtime\.** Incremental AWS SMS replication minimizes the business impact associated with application downtime during the final cutover\.

Use of AWS SMS is limited as follows:
+ 50 concurrent VM migrations per account, unless a customer requests a limit increase\.
+ 90 days of service usage per VM \(not per account\), beginning with the initial replication of a VM\. We terminate an ongoing replication after 90 days unless a customer requests a limit increase\.
+ 50 concurrent application migrations per account, with a limit of 10 groups and 50 servers in each application\.

## Pricing<a name="pricing"></a>

There is no additional fee to use Server Migration Service\. You pay the standard fees for the S3 buckets, EBS volumes, and data transfer used during the migration process, and for the EC2 instances that you run\. For more information, see [AWS Server Migration Service pricing](http://aws.amazon.com/server-migration-service/pricing/)\.
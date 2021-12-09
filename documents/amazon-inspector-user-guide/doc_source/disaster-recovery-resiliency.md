# Resilience in Amazon Inspector<a name="disaster-recovery-resiliency"></a>

The AWS global infrastructure is built around AWS Regions and Availability Zones\. AWS Regions provide multiple physically separated and isolated Availability Zones, which are connected with low\-latency, high\-throughput, and highly redundant networking\. With Availability Zones, you can design and operate applications and databases that automatically fail over between zones without interruption\. Availability Zones are more highly available, fault tolerant, and scalable than traditional single or multiple data center infrastructures\. 

For more information about AWS Regions and Availability Zones, see [AWS Global Infrastructure](http://aws.amazon.com/about-aws/global-infrastructure/)\.

Amazon Inspector is highly available and executes queries using compute resources across multiple Availability Zones\. It automatically routes queries appropriately if a particular Availability Zone is unreachable\.

Amazon Inspector uses Amazon S3 as its underlying data store, which makes your data highly available and durable\. Amazon S3 provides durable infrastructure to store important data\. It is designed for durability of 99\.999999999% of objects\. Your data is redundantly stored across multiple facilities and multiple devices in each facility\.
# Resilience in AWS Certificate Manager Private Certificate Authority<a name="disaster-recovery-resilience"></a>

The AWS global infrastructure is built around AWS Regions and Availability Zones\. AWS Regions provide multiple physically separated and isolated Availability Zones, which are connected with low\-latency, high\-throughput, and highly redundant networking\. With Availability Zones, you can design and operate applications and databases that automatically fail over between zones without interruption\. Availability Zones are more highly available, fault tolerant, and scalable than traditional single or multiple data center infrastructures\. 

For more information about AWS Regions and Availability Zones, see [AWS Global Infrastructure](http://aws.amazon.com/about-aws/global-infrastructure/)\.

## Redundancy and Disaster Recovery<a name="disaster-recovery"></a>

Consider redundancy and DR when planning your CA hierarchy\. ACM Private CA is available in multiple [Regions](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html), which allows you to create redundant CAs in multiple Regions\. The ACM Private CA service operates with a [service level agreement](https://aws.amazon.com/certificate-manager/private-certificate-authority/sla/) \(SLA\) of 99\.9% availability\. There are at least two approaches that you can consider for redundancy and disaster recovery\. You can configure redundancy at the root CA or at the highest subordinate CA\. Each approach has pros and cons\. 

1. You can create two root CAs in two different AWS Regions for redundancy and disaster recovery\. With this configuration, each root CA operates independently in an AWS Region, protecting you in the event of a single\-Region disaster\. Creating redundant root CAs does, however, increase operational complexity: You will need to distribute both root CA certificates to the trust stores of browsers and operating systems in your environment\. 

1. You can also create two redundant subordinate CAs that chain to the same root CA\. The benefit of this approach is that you need to distribute only a single root CA certificate to the trust stores in your environment\. The limitation is that you don’t have a redundant root CA in the event of a disaster that affects the AWS Region in which your root CA exists\.
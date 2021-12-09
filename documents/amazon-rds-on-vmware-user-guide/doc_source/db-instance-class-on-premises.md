# Choosing the On\-Premises DB Instance Class<a name="db-instance-class-on-premises"></a>

The DB instance class determines the computation and memory capacity of an Amazon RDS DB instance\. Determine which DB instance class most closely matches your VMware cluster\. You specify the DB instance class when you create your on\-premises DB instance\.

## On\-Premises DB Instance Class Types<a name="db-instance-class-on-premises.types"></a>

Amazon RDS on VMware supports three types of on\-premises DB instance classes: General, Compute Optimized, and Memory Optimized\.

The following are the on\-premises DB instance classes available:
+ **db\.mv11** – Current\-generation general DB instance classes that provide a balance of compute and memory resources for a variety of workloads\. 
+ **db\.cv11** – Current\-generation DB instance classes optimized for compute\-intensive workloads\. 
+ **db\.rv11** – Current\-generation DB instance classes optimized for memory\-intensive applications\. 

## Terminology for DB Instance Class Hardware Specifications<a name="db-instance-class-on-premises.terminology"></a>

The following terminology is used to describe hardware specifications for DB instance classes:
+ **vCPU** – The number of virtual central processing units \(CPUs\)
+ **Memory \(GiB\)** – The RAM memory, in gibibytes, allocated to the DB instance

## Specifications for All Available On\-Premises DB Instance Classes<a name="db-instance-class-on-premises.summary"></a>

The following table provides details of the on\-premises Amazon RDS DB instance classes\. 


****  

| Instance Class | vCPU | Memory \(GiB\) | 
| --- | --- | --- | 
| db\.mv11 – Current Generation General | 
| db\.mv11\.medium | 1 | 4 | 
| db\.mv11\.large | 2 | 8 | 
| db\.mv11\.xlarge | 4 | 16 | 
| db\.mv11\.2xlarge | 8 | 32 | 
| db\.mv11\.4xlarge | 16 | 64 | 
| db\.mv11\.12xlarge | 48 | 192 | 
| db\.mv11\.24xlarge | 96 | 384 | 
| db\.cv11 – Current Generation Compute Optimized | 
| db\.cv11\.small | 1 | 1 | 
| db\.cv11\.medium | 1 | 2 | 
| db\.cv11\.large | 2 | 4 | 
| db\.cv11\.xlarge | 4 | 8 | 
| db\.cv11\.2xlarge | 8 | 16 | 
| db\.cv11\.4xlarge | 16 | 32 | 
| db\.cv11\.9xlarge | 36 | 72 | 
| db\.cv11\.18xlarge | 72 | 144 | 
| db\.rv11 – Current Generation Memory Optimized | 
| db\.rv11\.large | 2 | 16 | 
| db\.rv11\.xlarge | 4 | 32 | 
| db\.rv11\.2xlarge | 8 | 64 | 
| db\.rv11\.4xlarge | 16 | 128 | 
| db\.rv11\.12xlarge | 48 | 384 | 
| db\.rv11\.24xlarge | 96 | 768 | 
# Amazon EC2 Instance Recommendations<a name="ec2-recommendations"></a>

Amazon EC2 instance recommendations provide you with the ability to estimate the cost of running your existing servers in AWS\. This feature analyzes the details about each server, including server specification, CPU, and memory utilization data\. The compiled data is then used to recommend the least expensive Amazon EC2 instance type that can handle the existing performance workload\. Recommendations are returned along with per\-hour instance pricing\.

Based on your business needs, you can choose additional preferences such as billing options, region, EC2 instance type exclusions and the CPU/RAM sizing \(average, peak, percentile\) to further optimize your EC2 instance recommendations and associated costs\.

## Prerequisites<a name="ec2-recommendation-prerequisites"></a>

Before you can get Amazon EC2 instance recommendations, you must have data about your on\-premises servers in Migration Hub\. This data can come from the discovery tools \(Discovery Connector or Discovery Agent\) or from Migration Hub import\. For more information on using these tools and features, see the following links:
+ [Migration Hub import](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-import.html) – This allows you to import details of your on\-premises environment directly into Migration Hub using a pre\-defined CSV template\.
+ [Discovery Connector](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-connector.html) – This is a VMware appliance that can collect information only about VMware virtual machines \(VMs\)\.
+ [Discovery Agent](https://docs.aws.amazon.com/application-discovery/latest/userguide/discovery-agent.html) – This is AWS software that you install on on\-premises servers and VMs targeted for discovery and migration\.

**Note**  
Percentile\-based recommendations are only generated for servers with data collected by a Discovery Connector from March 12th, 2019 onwards, or by a Discovery Agent\.

## How EC2 Instance Recommendations Work<a name="how-ec2-recommendations-work"></a>

This feature recommends the most cost\-effective EC2 instance type that can satisfy your existing server specifications and utilization requirements while taking into account your selected instance preferences\. The server specifications that are used to generate your recommendations are:
+ Number of processors
+ Number of logical cores
+ Total amount of RAM
+ Operating system family
+ Usage data including peak, average, and percentiles of CPU and RAM

EC2 instance recommendations returns the best Amazon EC2 instance type match based on server specification as well as the performance dimensions you provided\. To match the performance dimensions, the service adjusts the server’s specification by multiplying the original CPU and RAM values by the usage percentage\.

## Generating Amazon EC2 Recommendations<a name="generating-ec2-recommendations"></a>

In the **Export EC2 instance recommendations** page of the Migration Hub console, you'll choose your recommendation preferences\. These preferences include resource sizing, instance type preferences, and instance type exclusions\. Use the following procedure to generate your Amazon EC2 instance recommendations\.

**To generate Amazon EC2 instance recommendations**

1. Open a browser and sign into the Migration Hub console at https://console\.aws\.amazon\.com/migrationhub\.

1. On the left\-side navigation, from **Assess**, choose **EC2 instance recommendations**\.

1. Choose your Amazon EC2 instance size preferences for your discovered servers\. You can choose one of the following options\.
   + **Current server specification** – You have the two options of **Direct match** or **Custom match**\.
     + **Custom match** – Scales the CPU and RAM specifications for your instances relative to the collected specification data\. For example setting CPU to 50% and RAM to 60% will generate recommendations that assume 50% utilization of your discovered CPU usage and 60% utilization of your total RAM usage\.
     + **Direct match** – Matches the recommendations based off of the exact CPU and RAM specification data collected by the discovery tools you used to get the data into Migration Hub\.
   + **Maximum utilization** – This option sizes your instance recommendations based off of the maximum \(peak\) CPU and RAM utilization data that was collected by the discovery tools\.
   + **Average utilization** – This option sizes your instance recommendations based off of the average CPU and RAM utilization data that was imported or collected by the discovery tools\.
   + **Percentile of utilization** – If you used an AWS Application Discovery Agent or an AWS Agentless Discovery Connector to collect your server data, you can generate your recommendations using percentiles of time\-series utilization data\. Percentile\-based recommendations are only generated for servers with data collected by a Discovery Connector from March 12th, 2019 onwards, or by a Discovery Agent\.

     For all the data points collected for CPU and RAM utilization, a percentile is a value that exists below a given percentage of utilization since data has been discovered\. For example, the 75th percentile represents the value under 75 percent of all the RAM and CPU utilization data that has been discovered\.

1. Choose your Amazon EC2 instance type preferences, including AWS Region, tenancy, and pricing model\.
   + **Region** – Your AWS Region selection affects EC2 instance availability and pricing\.
   + **Tenancy** – This defines how EC2 instances are distributed across physical hardware and affects pricing\.
     + **Shared** – Multiple customers may share the same physical hardware\.
     + **Dedicated** – Only your instances will run on the same physical hardware\.
   + **Pricing Model** – This defines the kind of billing and commitment you intend to use for your instances\.
     + **On\-Demand** – Requires no long\-term commitment\.
     + **Reserved** – requires 1\-3 year commitment and provides discounts and additional confidence in your ability to launch instances when needed\. For more information on reserved instance pricing model information, see [Reserved Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-reserved-instances.html) in the *Amazon EC2 User Guide for Linux Instances* 

1. Optionally, choose any Amazon EC2 instance type exclusions to prevent specific types of instances from appearing in your recommendations\.

1. When you're done setting your preferences, choose **Export recommendations**\. This will begin generating your recommendations\. 

When the process is complete, your browser will automatically download a compressed archive \(ZIP\) file, containing a comma\-separated values \(CSV\) file with your recommendations\. The file is named `EC2InstanceRecommendations-sizing-preferences-year-month-day-hour-minute.csv`\.

Large datasets can take a few minutes to generate recommendations\. You can generate new recommendations at any time by repeating this procedure with a different set of preferences\.

## Understanding Your Amazon EC2 Recommendations<a name="understanding-ec2-recommendations"></a>

The downloaded CSV file has the following categories of information within it:
+ **Server identification** – This information identifies each server\. Each row of the CSV file contains information specific to a single server identified by a `ServerID`, `HostName`, and/or `ExternalId`\.
+ **Requested recommendations** – These are your generated results based on your CPU/RAM sizing preferences\.
+ **User preferences** – These are the preferences that were specified while requesting recommendations\. This information can be used to track and compare different results from generating multiple recommendations for the same set of servers\.
+ **Server configuration** – This information defines the set of on\-premises servers that were used to generate your recommendations\.

The following table defines the different columns for an Amazon EC2 recommendations CSV file\.


| Import Field Name | Description | Examples | 
| --- | --- | --- | 
| ServerId | A unique ID created by AWS and applied to a server after it's been discovered\. | d\-server\-00qag3caex2sjm d\-server\-01op2h5rnypwjy  | 
| Server\.ExternalId | A custom identifier that allows you to mark each record as unique\. For example, ExternalId can be the inventory ID for the server in your data center\. | Inventory Id 1 Server 2 CMBD Id 3  | 
| Server\.HostName | The host name of the server\. We recommend using the fully qualified domain name \(FQDN\) for this value\. | ip\-1\-2\-3\-4localhost\.domain | 
| Server\.VMware\.VMName | The name of the virtual machine\. | Corp1 | 
| Recommendation\.EC2\.Remarks | Error messages and other important information about a specific server's Amazon EC2 instance recommendation\. | Server\.OS\.Name wasn't recognized\. "Linux" was used as the default operating system for this instance recommendation\. | 
| Server\.OS\.Name | The name of the operating system\. | LinuxWindows\.Hat | 
| Server\.OS\.Version | The version of the operating system\. | 16\.04\.3NT 6\.2\.8 | 
| Server\.CPU\.NumberOfProcessors | For bare hardware servers discovered by an agent, this is the number of Physical CPUs\. For data collected by agents running in virtualized environments, this can be the number of vCPUs allocated\. However this varies depending on the virtualization platform\. | 4 | 
| Server\.CPU\.NumberOfCores | For bare hardware servers discovered by an agent, this is the total number of physical cores for all processors\. For data collected by agents in virtualized environments, this varies depending on the virtualization platform\. | 8 | 
| Server\.CPU\.NumberOfLogicalCores | The total number of threads that can run concurrently on all CPUs in a server\. Some CPUs support multiple threads to run concurrently on a single CPU core\. In those cases, this number will be larger than the number of physical \(or virtual\) cores\. | 16 | 
| Recommendation\.EC2\.RequestedCPU\.UsagePct | The percent of Server\.CPU\.NumberOfCores used to create the recommendation\. | 0\.9 | 
| Recommendation\.EC2\.RequestedvCPU | The Server\.CPU\.NumberOfLogicalCores value multiplied by the Recommendation\.EC2\.RequestedCPUPercentUse value, rounded up to the next integer\. | 16 | 
| Server\.RAM\.TotalSizeInMB | The total RAM, in MB, available on the server\. | 64128 | 
| Recommendation\.EC2\.RequestedRAM\.UsagePct | The percent of the RAM usage for a discovered server\. This is used if you chose Current server specification with a Custom match when you chose your sizing preferences\. | 0\.8 | 
| Recommendation\.EC2\.RequestedRAMinMB | The Server\.RAM\.TotalSizeInMB value multiplied by the Recommendation\.EC2\.RequestedRAMPercentUse value\. | 800 | 
| Recommendation\.EC2\.Instance\.Model | The recommended Amazon EC2 instance model\. | c5\.18xlarge | 
| Recommendation\.EC2\.Instance\.vCPUCount | The number of vCPUs in the recommended Amazon EC2 instance model\. | 12 | 
| Recommendation\.EC2\.Instance\.RAM\.TotalSizeinMB | The amount of memory for the recommended Amazon EC2 instance model\. |  1000 | 
| Recommendation\.EC2\.Instance\.Price\.UpfrontCost | This is the upfront cost to reserve the instance, in US dollars\. | 1343\.50 | 
| Recommendation\.EC2\.Instance\.Price\.HourlyRate | The hourly rate for the instance, in US dollars\. | 1\.32 | 
| Recommendation\.EC2\.Instance\.Price\.AmoritzedHourlyRate | The hourly price based on the instance type preferences you chose, in US dollars\. For long term contracts this value includes the upfront cost plus the hourly cost averaged over the contract\. For all upfront pricing, this value is zero\. | 2\.12 | 
| Recommendation\.EC2\.Instance\.Price\.EffectiveDate\.UTC | The effective date for an hourly instance price, recorded in the UTC time zone\. | 2019\-04\-23 14:23:00 | 
| Recommendation\.EC2\.Instance\.OSType | The operating system used to create the recommendation and pricing\. Currently only Linux, Windows, RHEL, and SLES are supported\. | Red Hat Enterprise Linux | 
| UserPreference\.Recommendation\.CPUSizing | The CPU preference you chose for CPU/RAM sizing on the sizing preferences\. | Custom Match \- 50% of CPU Spec | 
| UserPreference\.Recommendation\.RAMSizing | The RAM preference you chose for CPU/RAM sizing on the preferences\. | Custom Match \- 70% of RAM Spec | 
| UserPreference\.Region | The region you selected for the price and availability of Amazon EC2 recommendations\. | US West \(Oregon\) | 
| UserPreference\.EC2\.Tenancy | Tenancy used to determine instance type and instance price per hour\. | Shared | 
| UserPreference\.EC2\.PricingModel | Pricing model to determine the instance price per model\. This value can be either On Demand or Reserved\. | On Demand | 
| UserPreference\.EC2\.PricingModel\.ContractTerm | Contract term to determine instance price per hour\. | 3\-year Standard "ONE\_YEAR"\|"THREE\_YEAR" | 
| UserPreference\.EC2\.PricingModel\.Payment | Payment model to determine instance price per hour\. | "ALL\_UPFRONT"\|"PARTIAL\_UPFRONT"\|"NO\_UPFRONT" | 
| UserPreference\.EC2\.ExcludedInstances | The instances that you chose to exclude from your recommendations\. | t2\.large, m4 family | 
| Applications | A comma\-delimited list of applications that include this server, in quotes\. This value can include existing applications and/or new applications that are created upon import\. | Application1"Application2, Application3" | 
| Tags | A comma\-delimited list of tags formatted as name:value\. | "zone:1, critical:yes""zone:3, critical:no, zone:1" | 
| Server\.SMBiosId | System management BIOS \(SMBIOS\) ID\. |  | 
| Server\.VMware\.MoRefId | The managed object reference ID\. Must be provided with a VMware\.VCenterId\. |  | 
| Server\.VMware\.VCenterId | Virtual machine unique identifier\. Must be provided with a VMware\.MoRefId\. |  | 
| Server\.VMware\.vCenterName | The name of the Center where the VM is managed\. |  | 
| Server\.VMware\.vmFolderPath | The directory path of the VM files\. |  | 
| Server\.CPU\.UsagePct\.Avg | The average CPU utilization when the discovery tool was collecting data\. | 4523\.9 | 
| Server\.CPU\.UsagePct\.Max | The maximum CPU utilization when the discovery tool was collecting data\. | 55\.3424 | 
| Server\.RAM\.UsedSizeInMB\.Avg | The average amount of RAM used in the given server, in MB\. |  | 
| Server\.RAM\.UsedSizeInMB\.Max | The maximum amount of RAM used in the given server, in MB\. |  | 
| Server\.RAM\.UsagePct\.Avg | The average RAM utilization when the discovery tool was collecting data\. |  | 
| Server\.RAM\.UsagePct\.Max | The maximum RAM utilization when the discovery tool was collecting data\. |  | 
| Server\.NumberOfDisks | The number of physical hard disks on a host\. |  | 
| Server\.DiskReadsPerSecondInKB\.Avg | The average number of disk reads per second, in KB\. | 115984506 | 
| Server\.DiskWritesPerSecondInKB\.Avg | The average number of disk writes per second, in KB\. | 1996197 | 
| Server\.DiskReadsPerSecondInKB\.Max | The maximum number of disk reads per second, in KB\. | 37892869962 | 
| Server\.DiskWritesPerSecondInKB\.Max | The maximum number of disk writes per second, in KB\. | 184361808 | 
| Server\.DiskReadsOpsPerSecond\.Avg | The average number of disk read operations per second\. | 4528 | 
| Server\.DiskWritesOpsPerSecond\.Avg | The average number of disk write operations per second\. | 83 | 
| Server\.DiskReadsOpsPerSecond\.Max | The maximum number of disk read operations per second\. | 1083176 | 
| Server\.DiskWritesOpsPerSecond\.Max | The maximum number of disk write operations per second\. | 53571 | 
| Server\.NetworkReadsPerSecondInKB\.Avg | The average number of network read operations per second, in KB\. | 4528 | 
| Server\.NetworkWritesPerSecondInKB\.Avg | The average number of network write operations per second, in KB\. | 83 | 
| Server\.NetworkReadsPerSecondInKB\.Max | The maximum number of network read operations per second, in KB\. | 1083176 | 
| Server\.NetworkWritesPerSecondInKB\.Max | The maximum number of network write operations per second, in KB\. | 53571 | 

## Additional Considerations<a name="ec2-rec-considerations"></a>

Keep the following considerations in mind when generating EC2 instance recommendations\.
+ Burstable instances \(T2 and T3\) have an additional pricing mechanism that is computed based on CPU credits\. For the burstable instances, we use the provided `average` and `peak` CPU data points to compute an estimated number of consumed CPU credits\. This is translated into an adjusted overall recommendation\.
+ Only current generation instances are recommended\. The following types of instances are excluded from recommendations:
  + Previous generation instances \(C3, for example\)
  + Bare Metal instances
  + ARM instances \(A1, for example\)
  + 32\-bit instances
+ If the operating system for a server is not supported by Amazon EC2, that server's returned recommendation will be `Linux`\. Additional information can be found in the `Recommendation.EC2.Remarks` column for each affected server\.
# Amazon Inspector service limits<a name="inspector_limits"></a>

 The following table shows the Amazon Inspector limits for an AWS account\.

**Important**  
Currently, your assessment targets can consist only of EC2 instances\. 

The following are Amazon Inspector limits per AWS account per region:


| Resource | Default Limit | Comments | 
| --- | --- | --- | 
| Instances in running assessments | 500 | The maximum number of EC2 instances that can be included across all running assessments per account per region\. | 
| Assessment runs | 50000 | The maximum number of assessment runs that you can create per account per region\. You can have multiple assessment runs happening at the same time as long as the assessment targets used for these runs do not contain overlapping EC2 instances\. | 
| Assessment Templates | 500 | The maximum number of assessment templates that you can have at any given time per account per region\. | 
| Assessment Targets | 50 | The maximum number of assessment targets that you can have at any given time per account per region\. | 

Unless otherwise noted, these limits can be increased upon request by contacting the [AWS Support Center](https://console.aws.amazon.com/support/home#/)\.
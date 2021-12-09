# Supported CloudWatch Metrics<a name="PcaCloudWatch"></a>

Amazon CloudWatch is a monitoring service for AWS resources\. You can use CloudWatch to collect and track metrics, set alarms, and automatically react to changes in your AWS resources\. ACM Private CA supports the following CloudWatch metrics\. 


****  

| Metric | Description | 
| --- | --- | 
| CRLGenerated | A certificate revocation list \(CRL\) was generated\. This metric applies only to a private CA\. | 
| MisconfiguredCRLBucket | The S3 bucket specified for the CRL is not correctly configured\. Check the bucket policy\. This metric applies only to a private CA\. | 
| Time | This metric specifies the time at which the certificate was issued\. This metric applies only to the IssueCertificate operation\.  | 
| Success | A certificate was successfully issued\. This metric applies only to the IssueCertificate operation\. | 
| Failure | An operation failed\. This metric applies only to the IssueCertificate operation\. | 

For more information about CloudWatch metrics, see the following topics:
+ [Using Amazon CloudWatch Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/working_with_metrics.html)
+ [Creating Amazon CloudWatch Alarms](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/AlarmThatSendsEmail.html)
# Logging and Monitioring in AWS RAM<a name="monitoring-overview"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS RAM and your AWS solutions\. You should collect monitoring data from all parts of your AWS solution so that you can more easily debug a multi\-point failure if one occurs\. AWS provides several tools for monitoring your AWS RAM resources and responding to potential incidents:

**Amazon CloudWatch Events**  
Delivers a near\-real\-time stream of system events that describe changes in AWS resources\. CloudWatch Events enables automated event\-driven computing, as you can write rules that watch for certain events and trigger automated actions in other AWS services when these events happen\. For more information, see [Monitoring with CloudWatch Events](using-cloudwatch-events.md)\.

**AWS CloudTrail**  
Captures API calls and related events made by or on behalf of your AWS account and delivers the log files to an Amazon S3 bucket that you specify\. You can identify which users and accounts called AWS, the source IP address from which the calls were made, and when the calls occurred\. For more information, see [Logging AWS RAM API Calls with AWS CloudTrail](logging-using-cloudtrail.md)\.
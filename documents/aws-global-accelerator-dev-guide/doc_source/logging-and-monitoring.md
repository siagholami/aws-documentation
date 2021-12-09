# Logging and monitoring in AWS Global Accelerator<a name="logging-and-monitoring"></a>

Monitoring is an important part of maintaining the availability and performance of Global Accelerator and your AWS solutions\. You should collect monitoring data from all of the parts of your AWS solution so that you can more easily debug a multi\-point failure if one occurs\. AWS provides several tools for monitoring your Global Accelerator resources and activity, and responding to potential incidents:

**AWS Global Accelerator flow logs**  
Server flow logs provide detailed records about traffic that flows through an accelerator to an endpoint\. Server flow logs are useful for many applications\. For example, flow log information can be useful in security and access audits\. For more information, see [Flow logs in AWS Global Accelerator](monitoring-global-accelerator.flow-logs.md)\.

**Amazon CloudWatch metrics and alarms**  
Using CloudWatch, you can monitor, in real time, your AWS resources and the applications that you run on AWS\. CloudWatch collects and tracks metrics, which are variables that you measure over time\. You can create alarms that watch specific metrics, and then send notifications or automatically make changes to the resources you are monitoring when the metric exceeds a certain threshold for a period of time\. For more information, see [Using Amazon CloudWatch with AWS Global Accelerator](cloudwatch-monitoring.md)\. 

**AWS CloudTrail logs**  
CloudTrail provides a record of actions taken by a user, role, or an AWS service in Global Accelerator\. CloudTrail captures all API calls for Global Accelerator as events, including calls from the Global Accelerator console and from code calls to the Global Accelerator API\. For more information, see [Using AWS CloudTrail to log AWS Global Accelerator API calls](logging-using-cloudtrail.md)\.
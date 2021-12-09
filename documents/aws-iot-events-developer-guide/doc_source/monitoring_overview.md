# Monitoring AWS IoT Events<a name="monitoring_overview"></a>

Monitoring is an important part of maintaining the reliability, availability, and performance of AWS IoT Events and your AWS solutions\. You should collect monitoring data from all parts of your AWS solution so that you can more easily debug a multi\-point failure if one occurs\. Before you start monitoring AWS IoT Events, you should create a monitoring plan that includes answers to the following questions:
+ What are your monitoring goals?
+ Which resources will you monitor?
+ How often will you monitor these resources?
+ Which monitoring tools will you use?
+ Who will perform the monitoring tasks?
+ Who should be notified when something goes wrong?

The next step is to establish a baseline for normal AWS IoT Events performance in your environment, by measuring performance at various times and under different load conditions\. As you monitor AWS IoT Events, store historical monitoring data so that you can compare it with current performance data, identify normal performance patterns and performance anomalies, and devise methods to address issues\.

For example, if you're using Amazon EC2, you can monitor CPU utilization, disk I/O, and network utilization for your instances\. When performance falls outside your established baseline, you might need to reconfigure or optimize the instance to reduce CPU utilization, improve disk I/O, or reduce network traffic\.

**Topics**
+ [Monitoring tools](monitoring_automated_manual.md)
+ [Monitoring with Amazon CloudWatch](monitoring-cloudwatch.md)
+ [Logging AWS IoT Events API calls with AWS CloudTrail](iotevents-using-cloudtrail.md)
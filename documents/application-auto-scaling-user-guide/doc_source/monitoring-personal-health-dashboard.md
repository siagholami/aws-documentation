# Personal Health Dashboard Notifications for Application Auto Scaling<a name="monitoring-personal-health-dashboard"></a>

To help you manage failed scaling events, your Personal Health Dashboard provides support for notifications that are emitted by Application Auto Scaling\. Only scale out events that are specific to your DynamoDB resources are currently available\. 

The Personal Health Dashboard is part of the AWS Health service\. It requires no setup and can be viewed by any user that is authenticated in your account\. For more information, see [Getting Started with the AWS Personal Health Dashboard](https://docs.aws.amazon.com/health/latest/ug/getting-started-phd.html)\. 

If your DynamoDB resources are not scaling out due to your DynamoDB service quota limits, you receive a message similar to the following\. If you receive this message, it should be treated as an alarm to take action\.

```
  Hello,

  A scaling action has attempted to scale out your DynamoDB resources in the
  eu-west-1 region. This operation has been prevented because it would have exceeded a
  table-level write throughput limit (Provisioned mode). This limit restricts the
  provisioned write capacity of the table and all of its associated global secondary
  indexes. To address the issue, refer to the Amazon DynamoDB Developer Guide for
  current limits and how to request higher limits [1].

  To identify your DynamoDB resources that are impacted, use the 
  describe-scaling-activities command or the DescribeScalingActivities operation [2][3].
  Look for a scaling activity with StatusCode “Failed” and a StatusMessage similar to
  “Failed to set write capacity units to 45000. Reason: The requested WriteCapacityUnits,
  45000, is above the per table maximum for the account in eu-west-1. Per table maximum:
  40000.” You can also view these scaling activities from the Capacity tab of your tables 
  in the AWS Management Console for DynamoDB. 

  We strongly recommend that you address this issue to ensure that your tables
  are prepared to handle increases in traffic. This notification is sent only once in 
  each 12 hour period, even if another failed scaling action occurs. 

  [1] https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Limits.html#default-limits-throughput-capacity-modes
  [2] https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-activities.html
  [3] https://docs.aws.amazon.com/autoscaling/application/APIReference/API_DescribeScalingActivities.html
        
  Sincerely, 
  Amazon Web Services
```
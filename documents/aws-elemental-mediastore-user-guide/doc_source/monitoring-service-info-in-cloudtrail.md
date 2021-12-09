# AWS Elemental MediaStore information in CloudTrail<a name="monitoring-service-info-in-cloudtrail"></a>

CloudTrail is enabled on your AWS account when you create the account\. When supported event activity occurs in AWS Elemental MediaStore, that activity is recorded in a CloudTrail event along with other AWS service events in **Event history**\. You can view, search, and download recent events in your AWS account\. For more information, see [Viewing Events with CloudTrail Event History](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/view-cloudtrail-events.html)\. 

For an ongoing record of events in your AWS account, including events for MediaStore, create a trail\. A trail enables CloudTrail to deliver log files to an Amazon S3 bucket\. By default, when you create a trail in the console, the trail applies to all AWS Regions\. The trail logs events from all Regions in the AWS partition and delivers the log files to the Amazon S3 bucket that you specify\. Additionally, you can configure other AWS services to further analyze and act upon the event data collected in CloudTrail logs\. For more information, see the following topics: 
+ [Overview for Creating a Trail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-create-and-update-a-trail.html)
+ [CloudTrail Supported Services and Integrations](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-aws-service-specific-topics.html#cloudtrail-aws-service-specific-topics-integrations)
+ [Configuring Amazon SNS Notifications for CloudTrail](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/getting_notifications_top_level.html)
+ [Receiving CloudTrail Log Files from Multiple Regions](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/receive-cloudtrail-log-files-from-multiple-regions.html) and [Receiving CloudTrail Log Files from Multiple Accounts](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-receive-logs-from-multiple-accounts.html)

AWS Elemental MediaStore supports logging the following operations as events in CloudTrail log files:
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_CreateContainer.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_CreateContainer.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_DeleteContainer.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_DeleteContainer.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_DeleteContainerPolicy.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_DeleteContainerPolicy.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_API_DeleteCorsPolicy.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_API_DeleteCorsPolicy.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_DescribeContainer.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_DescribeContainer.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_GetContainerPolicy.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_GetContainerPolicy.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_GetCorsPolicy.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_GetCorsPolicy.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_ListContainers.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_ListContainers.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_PutContainerPolicy.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_PutContainerPolicy.html)
+ [https://docs.aws.amazon.com/mediastore/latest/apireference/API_PutCorsPolicy.html](https://docs.aws.amazon.com/mediastore/latest/apireference/API_PutCorsPolicy.html)

Every event or log entry contains information about who generated the request\. The identity information helps you determine the following: 
+ Whether the request was made with root or IAM user credentials
+ Whether the request was made with temporary security credentials for a role or federated user
+ Whether the request was made by another AWS service

For more information, see the [CloudTrail userIdentity Element](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-event-reference-user-identity.html)\.
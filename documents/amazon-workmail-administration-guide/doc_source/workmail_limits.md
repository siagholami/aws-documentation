# Amazon WorkMail quotas<a name="workmail_limits"></a>

Amazon WorkMail can be used by enterprise customers as well as small business owners\. Although we support most use cases without the need to configure any changes in quotas, we also protect our users and the internet against abuse of the product\. Therefore, some customers may run into quotas that we have set\. This section describes these quotas and how to change them\.

Some quota values can be changed, and some are hard quotas that cannot be changed\. For more information about requesting a quota increase, see [AWS Service quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) in the *Amazon Web Services General Reference*\.

## Amazon WorkMail organization and user quotas<a name="user_limits"></a>

You can add up to 25 users for a 30\-day free trial\. After this period ends, you are charged for all active users unless you remove them or close your Amazon WorkMail account\.

All messages that are sent to another user are considered when evaluating these quotas\. These include emails, meeting requests, meeting responses, task requests, and messages that are forwarded or redirected automatically as the result of a rule\.

**Note**  
When requesting a quota increase request only for a specific organization, include the organization name in your request\.


| Resource | Default quota  | Upper bound for change requests  | 
| --- | --- | --- | 
|  Users per Amazon WorkMail organization  |  1,000  |  Can be increased depending on the directory type that is used for the organization: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workmail/latest/adminguide/workmail_limits.html) \*If you are using Simple AD or AD Connector, see [AWS Directory Service](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/what_is.html) for additional information\.  | 
| Free trial users |  Up to 25 users in the first 30 days  |  The free trial period is only applicable for the first 25 users in any organization\. Any additional users are not included in the free trial offer\.  | 
| Recipients addressed per AWS account per day  | 100,000 recipients external to the organization, with no hard quota on recipients internal to the organization | There is no upper bound\. However, Amazon WorkMail is a business email service and not intended to be used for bulk email services\. For bulk email services, see [Amazon SES](https://aws.amazon.com/ses/) or [Amazon Pinpoint](https://aws.amazon.com/pinpoint/)\. | 
| Recipients addressed per AWS account per day using any of the test domains | 200 recipients, regardless of destination | There is no upper bound\. However, the test mail domain is not intended for long\-term usage\. Instead, we recommend that you add your own domain and use it as the default domain\. | 

Quotas for groups are set by the underlying directory\.

## WorkMail organization setting quotas<a name="organization_limits"></a>


| Resource | Default quota | 
| --- | --- | 
| Number of domains per Amazon WorkMail organization | 1,000This is a hard quota and cannot be changed\.  | 
|  Number of sender patterns in email flow rules per rule  |  250 This is a hard quota and cannot be changed\.  | 
|  Number of sender patterns in email flow rules per organization  |  1,000 This is a hard quota and cannot be changed\.  | 

## Per\-user quotas<a name="per_user_limits"></a>

All messages that are sent to another user are considered when evaluating these quotas\. These include emails, meeting requests, meeting responses, task requests, and messages that are forwarded or redirected automatically as the result of a rule\.


| Resource | Default quota | Upper quota for change requests | 
| --- | --- | --- | 
| Maximum size of mailbox | 50 GB |  50 GB  | 
| Maximum number of aliases per user |  100 This is a hard quota and cannot be changed\.  |  N/A  | 
| Recipients addressed per user per day using the domain that you own | 10,000 recipients external to the organization, with no hard quota on recipients internal to the organization\. | There is no upper bound\. However, Amazon WorkMail is a business email service and not intended to be used for bulk email services\. For bulk email services, see [Amazon SES](https://aws.amazon.com/ses/) or [Amazon Pinpoint](https://aws.amazon.com/pinpoint/)\. | 

## Message quotas<a name="message_limits"></a>

All messages that are sent to another user are considered when evaluating these quotas\. These include emails, meeting requests, meeting responses, task requests, and messages that are forwarded or redirected automatically as the result of a rule\.


| Resource  | Default quota  | 
| --- | --- | 
|  Maximum size of incoming message  | 25 MBThis is a hard quota and cannot be changed\. | 
| Maximum size of outgoing message | 25 MBThis is a hard quota and cannot be changed\. | 
|  Number of recipients per message  | 500This is a hard quota and cannot be changed\. | 
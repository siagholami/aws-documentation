# Application Auto Scaling Service Quotas<a name="application-auto-scaling-limits"></a>

Your AWS account has the following default quotas, formerly referred to as limits, for Application Auto Scaling\. 

To request an increase, use the [Application Auto Scaling Limits form](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-application-auto-scaling)\. Make sure that you specify the type of resource with your request for an increase, for example, Amazon ECS or DynamoDB\.


**Default Quotas Per Region Per Account**  

| Item | Default | 
| --- | --- | 
| Maximum number of scalable targets per resource type |  Quotas vary depending on resource type\.  Up to 3000 Amazon DynamoDB scalable targets and 500 scalable targets each for all other resource types\.  | 
| Maximum number of scaling policies per scalable target  | 50Includes both step scaling policies and target tracking policies\. | 
| Maximum number of scheduled actions per scalable target | 200 | 
| Maximum number of step adjustments per step scaling policy | 20 | 

Keep service quotas in mind as you scale out your workloads\. For example, when you reach the maximum number of capacity units allowed by a service, scaling out will stop\. If demand drops and the current capacity decreases, Application Auto Scaling can scale out again\. To avoid reaching this service quota limit again, you can request an increase\. Each service has its own default quotas for the maximum capacity of the resource\. For information about the default quotas for other AWS services, see [Service Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/aws-service-information.html) in the *Amazon Web Services General Reference*\. 
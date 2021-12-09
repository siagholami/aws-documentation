# AWS Auto Scaling Service Quotas<a name="auto-scaling-limits"></a>

Your AWS account has the following default quotas, formerly referred to as limits, for AWS Auto Scaling\. 

To request an increase, use the [Auto Scaling Limits form](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-auto-scaling)\. Make sure that you specify the type of resource with your request for an increase, for example, Amazon EC2 Auto Scaling, Amazon ECS, or DynamoDB\.


**Default Quotas Per Region Per Account**  

| Item | Default | 
| --- | --- | 
| Maximum number of scalable resources per resource type |  Quotas vary depending on resource type\.  Amazon DynamoDB: 3000 Amazon EC2 Auto Scaling groups: 200 All other resource types: 500  | 
| Maximum number of scaling plans | 100 | 
| Maximum number of scaling instructions per scaling plan | 500 | 
| Maximum number of target tracking configurations per scaling instruction | 10 | 

Keep service quotas in mind as you scale out your workloads\. For example, when you reach the maximum number of capacity units allowed by a service, scaling out will stop\. If demand drops and the current capacity decreases, AWS Auto Scaling can scale out again\. To avoid reaching this service quota limit again, you can request an increase\. Each service has its own default quotas for the maximum capacity of the resource\. For information about the default quotas for other AWS services, see [Service Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/aws-service-information.html) in the *Amazon Web Services General Reference*\. 
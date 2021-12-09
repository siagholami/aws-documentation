# What Is AWS Cloud Map?<a name="what-is-cloud-map"></a>

AWS Cloud Map is a fully managed service that you can use to create and maintain a map of the backend services and resources that your applications depend on\. Here's how AWS Cloud Map works:

1. You create a namespace that identifies the name that you want to use to locate your resources and also specifies how you want to locate resources: using AWS Cloud Map `DiscoverInstances` API calls, DNS queries in a VPC, or public DNS queries\. Typically, a namespace contains all the services for an application, such as a billing application\.

1. You create an AWS Cloud Map service for each type of resource for which you want to use AWS Cloud Map to locate endpoints\. For example, you might create services for web servers and database servers\.

   A service is a template that AWS Cloud Map uses when your application adds another resource, such as another web server\. If you chose to locate resources using DNS when you created the namespace, a service contains information about the types of records that you want to use to locate the web server\. A service also indicates whether you want to check the health of the resource and, if so, whether you want to use Amazon Route 53 health checks or a third\-party health checker\. 

1. When your application adds a resource, it can call the AWS Cloud Map `RegisterInstance` API action, which creates a service instance\. The service instance contains information about how your application can locate the resource, whether using DNS or using the AWS Cloud Map `DiscoverInstances` API action\.

1. When your application needs to connect to a resource, it calls `DiscoverInstances` and specifies the namespace and service that are associated with the resource\. AWS Cloud Map returns information about how to locate one or more resources\. If you specified health checking when you created the service, AWS Cloud Map returns only healthy instances\.

AWS Cloud Map is tightly integrated with Amazon Elastic Container Service \(Amazon ECS\)\. As new container tasks spin up or down, they automatically register with AWS Cloud Map\. You can use the Kubernetes ExternalDNS connector to integrate Amazon Elastic Container Service for Kubernetes with AWS Cloud Map\. You can also use AWS Cloud Map to register and locate any cloud resources, such as Amazon EC2 instances, Amazon DynamoDB tables, Amazon S3 buckets, Amazon Simple Queue Service \(Amazon SQS\) queues, or APIs deployed on top of Amazon API Gateway, among others\. You can specify attribute values for services instances, and clients can use these attributes to filter the resources that AWS Cloud Map returns\. For example, an application can request resources in a particular deployment stage, like BETA or PROD\.

**Topics**
+ [Accessing AWS Cloud Map](welcome-accessing-cloud-map.md)
+ [AWS Identity and Access Management](IAMRoute53.md)
+ [AWS Cloud Map Pricing](cloud-map-pricing.md)
+ [AWS Cloud Map and AWS Cloud Compliance](compliance.md)
# Using AWS Cloud Map<a name="using-cloud-map"></a>

AWS Cloud Map is a managed solution that lets you map logical names to the resources for an application, and allows your applications to discover resources using one of the AWS SDKs, RESTful API calls, or DNS queries\. AWS Cloud Map serves only healthy resources, which can be Amazon DynamoDB \(DynamoDB\) tables, Amazon Simple Queue Service \(Amazon SQS\) queues, or any higher\-level application services that are built using Amazon Elastic Compute Cloud \(Amazon EC2\) instances or Amazon Elastic Container Service \(Amazon ECS\) tasks\.

**Topics**
+ [Overview of How to Use AWS Cloud Map](#overview-service-discovery-tasks)
+ [Configuring AWS Cloud Map Using the Console](configuring-cloud-map.md)

## Overview of How to Use AWS Cloud Map<a name="overview-service-discovery-tasks"></a>

Here's an overview of how you use AWS Cloud Map:

1. Create a namespace, which is a logical grouping of services\. When you create a namespace, you specify the name that you want your applications to use to discover instances\. You also specify how you want to discover service instances that you register with AWS Cloud Map: using API calls or using DNS queries\. 

   For more information, see the following topics:
   + [Creating Namespaces](creating-namespaces.md)
   + [CreatePublicDnsNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreatePublicDnsNamespace.html), [CreatePrivateDnsNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreatePrivateDnsNamespace.html), and [CreateHttpNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateHttpNamespace.html) in the *AWS Cloud Map API Reference*

   If you create a public or private DNS namespace, AWS Cloud Map automatically creates an Amazon Route 53 public or private hosted zone that has the same name as the namespace\. Even with public and private DNS namespaces, you can still discover instances using AWS Cloud Map [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) requests\.

   For a list of the endpoints that you can submit AWS Cloud Map API requests to, see [AWS Cloud Map](https://docs.aws.amazon.com/general/latest/gr/rande.html#cloud_map_region) in the "AWS Regions and Endpoints" chapter in the *Amazon Web Services General Reference*\.

1. If you created a public DNS namespace, perform the following steps to change the name servers for the domain registration to the name servers for the Route 53 hosted zone that AWS Cloud Map created when you created the namespace:

   1. If you already registered a domain that has the same name as the public DNS namespace, skip to step 2b\.

      If you haven't registered a domain that has the same name as the namespace, register a domain\. If you want to use Route 53 for domain registration, see [Registering a New Domain](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/domain-register.html) in the *Amazon Route 53 Developer Guide*\. Then skip to step 3\.

   1. Use the `OperationId` that was returned when you created the namespace to get the namespace ID\. For more information, see [GetOperation](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetOperation.html)\.
**Note**  
If you're using a programmatic method to perform these steps, you'll also use the namespace ID later in the process to create a service\.

   1. Use the namespace ID that you got in step 2b to get the ID of the Route 53 hosted zone that AWS Cloud Map created\. For more information, see [GetNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_GetNamespace.html) in the *AWS Cloud Map API Reference*\.

   1. Using the hosted zone ID that you got in step 2c, get the names of the name servers that Route 53 assigned to your hosted zone\. For more information, see [Getting the Name Servers for a Public Hosted Zone](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/GetInfoAboutHostedZone.html)\.

   1. Change the name servers that are assigned to the domain\. If the domain is registered with Route 53, see [Adding or Changing Name Servers and Glue Records for a Domain ](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/domain-name-servers-glue-records.html) for more information\.

1. Create a service, which contains the service instances that identify how to contact the resources for an application, such as a web server, a DynamoDB table, or an Amazon S3 bucket\. 

   If you created a public or private DNS namespace in step 1, the name that you specify for the service becomes part of the names of records in the Route 53 public or private hosted zone that AWS Cloud Map created automatically in step 1\. When you register an instance in the next step, AWS Cloud Map creates records in the hosted zone\. The record names are a combination of the name of the service \(such as `backend`\) and the name of the namespace \(such as `example.com`\): `backend.example.com`\.

   When you create a service, you can also choose whether you want to check the health of the resources that service instances point to:
   + If you choose no health checking, AWS Cloud Map or Route 53 return service instances regardless of the health of the corresponding resources\.
   + If you choose Route 53 health checking \(only available for public DNS namespaces\), AWS Cloud Map automatically creates a Route 53 health check and associates it with the corresponding Route 53 record\. Route 53 responds to DNS queries only with records for healthy resources\.
   + If you choose custom health checking, you use a third\-party application to determine the health of your resources\. Based on the results of the third\-party health checks, you send [UpdateInstanceCustomHealthStatus](https://docs.aws.amazon.com/cloud-map/latest/api/API_UpdateInstanceCustomHealthStatus.html) requests to AWS Cloud Map to update the status of the service instances\.

   If you configure health checking, either AWS Cloud Map or Route 53 returns only service instances for healthy resources in response to [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) requests or DNS queries\.

   For more information, see the following topics:
   + [Creating Services](creating-services.md)
   + [CreateService](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateService.html) in the *AWS Cloud Map API Reference*

1. Register one or more service instances\. Each service instance contains information about how your application can contact one resource for an application\.

   For more information, see the following topics:
   + [Registering Instances](registering-instances.md)
   + [RegisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_RegisterInstance.html) in the *AWS Cloud Map API Reference*

1. Write your application to discover instances using either the AWS Cloud Map [DiscoverInstances](https://docs.aws.amazon.com/cloud-map/latest/api/API_DiscoverInstances.html) API action or using DNS queries:
   + If your application uses `DiscoverInstances`, AWS Cloud Map returns information about the available instances that meet the specified criteria\.
   + If your application uses DNS queries, Route 53 returns one or more records\. 

   If you specified settings for a health check when you created the service, AWS Cloud Map or Route 53 returns values only for healthy instances\.

1. When you want to stop using a resource, deregister the corresponding service instance\. AWS Cloud Map automatically deletes the associated Route 53 record and health check, if any\. 

   For more information, see the following topics:
   + [Deregistering Service Instances](deregistering-instances.md)
   + [DeregisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_DeregisterInstance.html) in the *AWS Cloud Map API Reference*

1. If you don't need a service and namespace any longer, you can delete them\. Note the following:
   + Before you can delete a service, you must deregister all instances that were registered using the service\.
   + Before you can delete a namespace, you must delete all services that were created in the namespace\.

   For more information, see the following topics:
   + [Deleting Services](deleting-services.md)
   + [Deleting Namespaces](deleting-namespaces.md)
   + [DeleteService](https://docs.aws.amazon.com/cloud-map/latest/api/API_DeleteService.html) in the *AWS Cloud Map API Reference*
   + [DeleteNamespace](https://docs.aws.amazon.com/cloud-map/latest/api/API_DeleteNamespace.html) in the *AWS Cloud Map API Reference*
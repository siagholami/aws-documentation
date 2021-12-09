# AWS Cloud Map Features That Aren't Available on the Console<a name="configuring-cloud-map-feature-not-available"></a>

The following AWS Cloud Map features aren't available on the console\. To use these features, you must use a programmatic method to access AWS Cloud Map:

**Creating Route 53 alias records when you register service instances**  
When you register a service instance using the console, you can't create an alias record that routes traffic to an Elastic Load Balancing \(ELB\) load balancer\. Note the following:  
+ When you create a service, you must specify `WEIGHTED` for `RoutingPolicy`\. You can do this using the console\. For more information, see [Creating Services](creating-services.md)\.

  For information about creating a service using the AWS Cloud Map API, see [CreateService](https://docs.aws.amazon.com/cloud-map/latest/api/API_CreateService.html) in the *AWS Cloud Map API Reference*\.
+ When you register an instance, you must include the `AWS_ALIAS_DNS__NAME` attribute\. For more information, see [RegisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_RegisterInstance.html) in the *AWS Cloud Map API Reference*\.

**Specifying the initial health status for custom health checks**  
If you register an instance using a service that includes a custom health check, you can't specify the initial status for the custom health check\. By default, the initial status of a custom health checks is **Healthy**\. If you want the initial health status to be **Unhealthy**, register the instance programmatically and include the `AWS_INIT_HEALTH_STATUS` attribute\. For more information, see [RegisterInstance](https://docs.aws.amazon.com/cloud-map/latest/api/API_RegisterInstance.html) in the *AWS Cloud Map API Reference*\.

**Getting the status of an incomplete operation**  
If you close a browser window after you create a namespace but before creating the namespace has completed, the console doesn't provide a way to see the current status\. You can get the status by using `ListOperations`\. For more information, see [ListOperations](https://docs.aws.amazon.com/cloud-map/latest/api/API_ListOperations.html) in the *AWS Cloud Map API Reference*\. 
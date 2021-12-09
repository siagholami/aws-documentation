# How to get started with AWS Global Accelerator<a name="introduction-get-started"></a>

You can get started with setting up AWS Global Accelerator by using the API or by using the AWS Global Accelerator console\. Because Global Accelerator is a global service, it’s not tied to a specific AWS Region\. 

To get started using Global Accelerator, you follow these general steps: 

1. **Configure the initial setup for Global Accelerator:** Provide a name for your accelerator\.  Then configure one or more listeners to process inbound connections from clients, based on the protocol and port \(or port range\) that you specify\.

1. **Configure regional endpoint groups for your accelerator:** You can select one or more regional endpoint groups to add to your listener by specifying the Regions that you want to distribute traffic to\. The listener routes requests to the endpoints that you've added to an endpoint group\. Global Accelerator monitors the health of endpoints within the group by using the health check settings that are defined for each of your endpoints\. For each endpoint group, you can configure a *traffic dial* percentage to control the percentage of traffic that an endpoint group will accept\. The percentage is applied only to traffic that is already directed to the endpoint group, not all listener traffic\. By default, the traffic dial is set to 100% for all regional endpoint groups\.

1. **Add endpoints to endpoint groups:** You can add one or more regional resources, such as load balancers or EC2 instances endpoints, to each endpoint group\. Next, you can decide how much traffic you want to route to each endpoint by setting endpoint weights\.

For detailed steps about how to create an accelerator using the AWS Global Accelerator console, see [Getting started with AWS Global Accelerator](getting-started.md)\. To work with API operations, see [Common actions that you can use with AWS Global Accelerator](global-accelerator-actions.md) and the [AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.
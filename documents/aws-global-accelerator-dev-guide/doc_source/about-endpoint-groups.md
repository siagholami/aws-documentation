# Endpoint groups in AWS Global Accelerator<a name="about-endpoint-groups"></a>

An endpoint group routes requests to one or more registered endpoints in AWS Global Accelerator\. When you add a listener, you specify the endpoint groups for Global Accelerator to direct traffic to\. An endpoint group, and all the endpoints in it, must be in one AWS Region\. You can add different endpoint groups for different purposes, for example, for blue/green deployment testing\.

Global Accelerator directs traffic to endpoint groups based on the location of the client and the health of the endpoint group\. If you like, you can also set the percentage of traffic to send to an endpoint group\. You do that by using the traffic dial to increase \(dial up\) or decrease \(dial down\) traffic to the group\. The percentage is applied only to the traffic that Global Accelerator is already directing to the endpoint group, not all traffic coming to a listener\. 

You can define health check settings for Global Accelerator for each endpoint group\. By updating health check settings, you can change your requirements for polling and verifying the health of EC2 instance and Elastic IP address endpoints\. For Network Load Balancer and Application Load Balancer endpoints, configure health check settings on the Elastic Load Balancing console\. 

Global Accelerator continually monitors the health of all endpoints that are included in an endpoint group, and routes requests only to the active endpoints that are healthy\. If there aren't any healthy endpoints to route traffic to, Global Accelerator routes requests to all endpoints\.

This section explains how to work with endpoint groups on the AWS Global Accelerator console\. If you want to use API operations with AWS Global Accelerator, see the [ AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.

**Topics**
+ [Adding, editing, or removing an endpoint group](about-endpoint-groups.create-endpoint-group.md)
+ [Adjusting traffic flow with traffic dials](about-endpoint-groups-traffic-dial.md)
+ [Health check options](about-endpoint-groups-health-check-options.md)
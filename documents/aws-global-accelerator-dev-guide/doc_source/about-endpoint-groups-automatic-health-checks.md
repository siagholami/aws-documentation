# Health Checks for AWS Global Accelerator<a name="about-endpoint-groups-automatic-health-checks"></a>

AWS Global Accelerator automatically checks the health of the endpoints that are associated with your static IP addresses, and then directs user traffic only to healthy endpoints\.

If you've configured custom health check settings—in Global Accelerator or by configuring settings directly for Network Load Balancer or Application Load Balancer load balancers—Global Accelerator uses those settings as follows:
+ For Network Load Balancer and Application Load Balancer endpoints, Global Accelerator follows the health check settings that you've configured for the load balancers on the Elastic Load Balancing console\.
+ For Elastic IP address endpoints, you can configure custom health check settings in Global Accelerator\. By default, Global Accelerator uses the listener port and protocol for health checks\. For UDP listeners with Elastic IP address endpoints, Global Accelerator uses the listener port and the TCP protocol for health checks, so you must have a TCP server on your endpoint\. 

When you add an endpoint, it must pass a health check to be considered healthy before traffic is directed to it\. If Global Accelerator doesn’t have any healthy endpoints to route traffic to, it routes requests to all endpoints\. 

Global Accelerator includes default health checks that are run automatically, but you can configure the timing for the checks and other options\. For more information, see [Health Check Options](about-endpoint-groups-health-check-options.md)\.
# Adjusting traffic flow with traffic dials<a name="about-endpoint-groups-traffic-dial"></a>

For each endpoint group, you can set a traffic dial to control the percentage of traffic that is directed to the group\. The percentage is applied only to traffic that is already directed to the endpoint group, not to all listener traffic\.

By default, the traffic dial is set to 100 \(that is, 100%\) for all regional endpoint groups in an accelerator\. The traffic dial lets you easily do performance testing or blue/green deployment testing for new releases across different AWS Regions, for example\. 

Here are a few examples to illustrate how you can use traffic dials to change the traffic flow to endpoint groups\.

**Upgrade your application by Region**  
If you want to upgrade an application in a Region or do maintenance, first set the traffic dial to 0 to cut off traffic for the Region\. When you complete the work and you're ready bring the Region back into service, adjust the traffic dial to 100 to dial the traffic back up\. 

**Mix traffic between two Regions**  
This example shows how traffic flow works when you change the traffic dials for two regional endpoint groups at the same time\. Let’s say that you have two endpoint groups for your accelerator—one for the `us-west-2` Region and one for the `us-east-1` Region—and you've set the traffic dials to 50% for each endpoint group\.  
Now, say you have 100 requests coming to your accelerator, with 50 from the East Coast of the United States and 50 from the West Coast\. The accelerator directs the traffic as follows:  
+ The first 25 requests on each coast \(50 requests in total\) are served from their nearby endpoint group\. That is, 25 requests are directed to the endpoint group in `us-west-2` and 25 are directed to the endpoint group in `us-east-1`\.
+ The next 50 requests are directed to the opposite Regions\. That is, the next 25 requests from the East Coast are served by `us-west-2`, and the next 25 requests from the West Coast are served by `us-east-1`\.
The result in this scenario is that both endpoint groups serve the same amount of traffic\. However, each one receives a mix of traffic from both Regions\.
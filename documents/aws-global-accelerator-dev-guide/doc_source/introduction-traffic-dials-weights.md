# Customizing Traffic Flow by using Traffic Dials and Endpoint Weights<a name="introduction-traffic-dials-weights"></a>

There are two ways that you can customize how AWS Global Accelerator sends traffic to your endpoints:
+ Change the traffic dial to cap the traffic for one or more endpoint groups
+ Specify weights to change the proportion of traffic to the endpoints in a group

## How Traffic Dials Work<a name="introduction-traffic-dials-weights.traffic-dial"></a>

For each endpoint group in an accelerator, you can set a traffic dial to control the percentage of traffic that is sent to the endpoint group\. The percentage is applied only to traffic that is already directed to the endpoint group, not to all listener traffic\. 

The traffic dial limits the portion of traffic that an endpoint group accepts, expressed as a percentage of traffic directed to that endpoint group\. For example, if you set the traffic dial for an endpoint group in US\-East\-1 to 50 \(that is, 50%\) and the accelerator directs 100 user requests to that endpoint group, only 50 requests are accepted by the group\. The accelerator directs the remaining 50 requests to endpoint groups in other Regions\.

For more information, see [Adjusting Traffic Flow With Traffic Dials](about-endpoint-groups-traffic-dial.md)\. 

## How Weights Work<a name="introduction-traffic-dials-weights.weights"></a>

For each endpoint, you can specify weights, which are numbers that change the proportion of traffic that the accelerator routes to each endpoint\. This can be useful, for example, to do performance testing within a Region\.

A weight is a value that determines the proportion of traffic that the accelerator directs to an endpoint\. By default, the weight for an endpoint is 128—that is, half of the maximum value for a weight, 255\.

The accelerator calculates the sum of the weights for the endpoints in an endpoint group, and then directs traffic to the endpoints based on the ratio of each endpoint's weight to the total\. For an example of how weights work, see [Endpoint Weights](about-endpoints-endpoint-weights.md)\.

## Using Traffic Dials and Weights Together<a name="introduction-traffic-dials-weights.both"></a>

Traffic dials and weights affect how the accelerator serves traffic in different ways: 
+ You configure traffic dials for *endpoint groups*\. The traffic dial lets you cut off a percentage of traffic—or all traffic—to the group, by "dialing down" traffic that the accelerator has already directed to it based on other factors, such as proximity\.
+ You use weights, on the other hand, to set values for *individual endpoints* within an endpoint group\. Weights provide a way to divide up traffic within the endpoint group—for example, if you want to do performance testing for specific endpoints in a Region\.
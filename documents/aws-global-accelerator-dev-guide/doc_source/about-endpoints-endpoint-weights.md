# Endpoint weights<a name="about-endpoints-endpoint-weights"></a>

A weight is a value that determines the proportion of traffic that Global Accelerator directs to an endpoint\. Global Accelerator calculates the sum of the weights for the endpoints in an endpoint group, and then directs traffic to the endpoints based on the ratio of each endpoint's weight to the total\.

Weighted routing lets you choose how much traffic is routed to a resource in an endpoint group\. This can be useful in several ways, including load balancing and testing new versions of an application\.

## How endpoint weights work<a name="about-endpoints-endpoint-weights.how-it-works"></a>

To use weights, you assign each endpoint in an endpoint group a relative weight that corresponds with how much traffic that you want to send to it\. By default, the weight for an endpoint is 128—that is, half of the maximum value for a weight, 255\. Global Accelerator sends traffic to an endpoint based on the weight that you assign to it as a proportion of the total weight for all endpoints in the group:

![\[How relative weights work for endpoints\]](http://docs.aws.amazon.com/global-accelerator/latest/dg/)

For example, if you want to send a tiny portion of your traffic to one endpoint and the rest to another endpoint, you might specify weights of 1 and 255\. The endpoint with a weight of 1 gets 1/256 of the traffic \(1/1\+255\), and the other endpoint gets 255/256 \(255/1\+255\)\. You can gradually change the balance by changing the weights\. If you want Global Accelerator to stop sending traffic to an endpoint, you can change the weight for that resource to 0\.

## Failover for unhealthy endpoints<a name="about-endpoints-endpoint-weights.unhealthy-endpoints"></a>

If there are no healthy endpoints in an endpoint group that have a weight greater than zero, Global Accelerator tries to failover to a healthy endpoint with a weight greater than zero in another endpoint group\. For this failover, Global Accelerator ignores the traffic dial setting\. So if, for example, an endpoint group has a traffic dial set to zero, Global Accelerator still includes that endpoint group in the failover attempt\.

If Global Accelerator doesn't find a healthy endpoint with a weight greater than zero after trying three additional endpoint groups \(that is, three AWS Regions\), it routes traffic to a random endpoint in the endpoint group that is closest to the client\. That is, it *fails open*\.

Note the following:
+ The endpoint group chosen for failover might be one that has a traffic dial set to zero\.
+ The nearest endpoint group might not be the original endpoint group\. This is because Global Accelerator considers account traffic dial settings when it chooses the original endpoint group\.

For example, let's say your configuration has two endpoints, one healthy and one unhealthy, and you've set the weight for each of them to be greater than zero\. In this case, Global Accelerator routes traffic to the healthy endpoint\. However, now say you set the weight of the only healthy endpoint to zero\. Global Accelerator then tries three additional endpoint groups to find a healthy endpoint with a weight greater than zero\. If it doesn't find one, Global Accelerator routes traffic to a random endpoint in the endpoint group that is closest to the client\.
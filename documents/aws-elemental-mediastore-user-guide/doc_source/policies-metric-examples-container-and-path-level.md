# Example metric policy: Container\-level and path\-level metrics<a name="policies-metric-examples-container-and-path-level"></a>

This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should send metrics for objects in two specific folders: `baseball/saturday` and `football/saturday`\. The metrics for MediaStore requests are as follows:
+ Requests to the `baseball/saturday` folder have a CloudWatch dimension of `ObjectGroupName=baseballGroup`\.
+ Requests to the `football/saturday` folder have a CloudWatch dimension `ObjectGroupName=footballGroup`\.

```
{
   "ContainerLevelMetrics": "ENABLED",
   "MetricPolicyRules": [
     {
       "ObjectGroup": "baseball/saturday",
       "ObjectGroupName": "baseballGroup"
     },
     {
       "ObjectGroup": "football/saturday",
       "ObjectGroupName": "footballGroup"
     }
   ]
}
```
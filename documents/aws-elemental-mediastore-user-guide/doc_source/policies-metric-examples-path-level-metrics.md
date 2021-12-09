# Example metric policy: Path\-level metrics<a name="policies-metric-examples-path-level-metrics"></a>

This example policy indicates that AWS Elemental MediaStore should not send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should send metrics for objects in two specific folders: `baseball/saturday` and `football/saturday`\. The metrics for MediaStore requests are as follows:
+ Requests to the `baseball/saturday` folder have a CloudWatch dimension of `ObjectGroupName=baseballGroup`\.
+ Requests to the `football/saturday` folder have a dimension `ObjectGroupName=footballGroup`\.

```
{
   "ContainerLevelMetrics": "DISABLED",
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
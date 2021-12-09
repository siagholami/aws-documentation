# Example metric policy: Path\-level metrics with overlapping rules<a name="policies-metric-examples-overlapping-rules"></a>

This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should send metrics for two folders: `sports/football/saturday` and `sports/football`\. 

The metrics for MediaStore requests to the `sports/football/saturday` folder have a CloudWatch dimension of `ObjectGroupName=footballGroup1`\. Because objects that are stored in the `sports/football` folder match both rules, CloudWatch displays two data points for these objects: one with a dimension of `ObjectGroupName=footballGroup1` and the second with a dimension of `ObjectGroupName=footballGroup2`\.

```
{
   "ContainerLevelMetrics": "ENABLED",
   "MetricPolicyRules": [
     {
       "ObjectGroup": "sports/football/saturday",
       "ObjectGroupName": "footballGroup1"
     },
     {
       "ObjectGroup": "sports/football",
       "ObjectGroupName": "footballGroup2"
     }
   ]
 }
```
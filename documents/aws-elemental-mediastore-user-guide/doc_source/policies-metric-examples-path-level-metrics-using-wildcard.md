# Example metric policy: Path\-level metrics using wildcards<a name="policies-metric-examples-path-level-metrics-using-wildcard"></a>

This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should also send metrics for objects based on their file name\. A wildcard indicates that the objects can be stored anywhere in the container and they can have any file name, as long as it ends with a `.m3u8` extension\. 

```
{
   "ContainerLevelMetrics": "ENABLED",
   "MetricPolicyRules": [
     {
       "ObjectGroup": "*.m3u8",
       "ObjectGroupName": "index"
     }
   ]
 }
```
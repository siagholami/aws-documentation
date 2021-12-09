# Example metric policy: Container\-level metrics<a name="policies-metric-examples-container-level-metrics"></a>

This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. For example, this includes the `RequestCount` metric that counts the number of `Put` requests made to the container\. Alternatively, you can set this to `DISABLED`\. 

Because there are no rules in this policy, MediaStore does not send metrics at the path level\. For example, you can't see how many `Put` requests were made to a particular folder within this container\.

```
{
   "ContainerLevelMetrics": "ENABLED"
}
```
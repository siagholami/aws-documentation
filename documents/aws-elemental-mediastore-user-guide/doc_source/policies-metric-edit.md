# Editing a metric policy<a name="policies-metric-edit"></a>

A metric policy contains rules that dictate which metrics AWS Elemental MediaStore sends to Amazon CloudWatch\. When you edit an existing metric policy, it takes up to 20 minutes for the new policy to take effect\. For examples of metric policies, see [ Example metric policiesExample metric policies  View example metric policies constructed for different use cases\.   The following examples show metric policies that are constructed for different use cases\. Topics  Example metric policy: Container\-level metricsContainer\-level metrics  This example policy indicates that AWS Elemental MediaStore should send container\-level metrics to Amazon CloudWatch\. For example, you can see the total number of `Put` requests made to the container\.    This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. For example, this includes the `RequestCount` metric that counts the number of `Put` requests made to the container\. Alternatively, you can set this to `DISABLED`\.  Because there are no rules in this policy, MediaStore does not send metrics at the path level\. For example, you can't see how many `Put` requests were made to a particular folder within this container\. 

```
{
   "ContainerLevelMetrics": "ENABLED"
}
```   Example metric policy: Path\-level metricsPath\-level metrics  This example policy indicates that AWS Elemental MediaStore should not send container\-level metrics to Amazon CloudWatch\. However, it includes two rules to indicate that MediaStore should send metrics for activity in two specific folders\.   This example policy indicates that AWS Elemental MediaStore should not send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should send metrics for objects in two specific folders: `baseball/saturday` and `football/saturday`\. The metrics for MediaStore requests are as follows:   Requests to the `baseball/saturday` folder have a CloudWatch dimension of `ObjectGroupName=baseballGroup`\.   Requests to the `football/saturday` folder have a dimension `ObjectGroupName=footballGroup`\.   

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
```   Example metric policy: Container\-level and path\-level metricsContainer\-level and path\-level metrics  This example policy indicates that AWS Elemental MediaStore should send container\-level metrics to Amazon CloudWatch\. In addition, it includes two rules to indicate that MediaStore should send metrics for activity in two specific folders\.   This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should send metrics for objects in two specific folders: `baseball/saturday` and `football/saturday`\. The metrics for MediaStore requests are as follows:   Requests to the `baseball/saturday` folder have a CloudWatch dimension of `ObjectGroupName=baseballGroup`\.   Requests to the `football/saturday` folder have a CloudWatch dimension `ObjectGroupName=footballGroup`\.   

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
```   Example metric policy: Path\-level metrics using wildcardsPath\-level metrics using wildcards  This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should also send metrics for objects based on their file name\. A wildcard indicates that the objects can be stored anywhere in the container and they can have any file name, as long as it ends with a `.m3u8` extension\.    This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should also send metrics for objects based on their file name\. A wildcard indicates that the objects can be stored anywhere in the container and they can have any file name, as long as it ends with a `.m3u8` extension\.  

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
```   Example metric policy: Path\-level metrics with overlapping rulesPath\-level metrics with overlapping rules  This example policy indicates that AWS Elemental MediaStore should send container\-level metrics to Amazon CloudWatch\. In addition, it includes two rules to indicate that MediaStore should send metrics for activity in two specific folders\.   This example policy indicates that AWS Elemental MediaStore should send metrics to Amazon CloudWatch at the container level\. In addition, MediaStore should send metrics for two folders: `sports/football/saturday` and `sports/football`\.  The metrics for MediaStore requests to the `sports/football/saturday` folder have a CloudWatch dimension of `ObjectGroupName=footballGroup1`\. Because objects that are stored in the `sports/football` folder match both rules, CloudWatch displays two data points for these objects: one with a dimension of `ObjectGroupName=footballGroup1` and the second with a dimension of `ObjectGroupName=footballGroup2`\. 

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
```  ](policies-metric-examples.md)\.

**To edit a metric policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the container name\.

1. In the **Metric policy** section, choose **Edit metric policy**\. 

1. Make the appropriate changes, and then choose **Save**\.
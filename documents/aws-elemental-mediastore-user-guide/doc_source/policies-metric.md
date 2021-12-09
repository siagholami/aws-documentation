# Metric policies in AWS Elemental MediaStore<a name="policies-metric"></a>

For each container, you can add a metric policy to allow AWS Elemental MediaStore to send metrics to Amazon CloudWatch\. It takes up to 20 minutes for the new policy to take effect\. For a description of each MediaStore metric, see [MediaStore metrics](monitor-with-cloudwatch-metrics.md#monitor-with-cloudwatch-metrics-for-mediastore)\.

A metric policy contains the following:
+ A setting to enable or disable metrics at the container level\.
+ Anywhere from zero to five rules that enable metrics at the object level\. If the policy contains rules, each rule must include both of the following:
  + An object group that defines which objects to include in the group\. The definition can be a path or a file name, but it can't have more than 900 characters\. Valid characters are: a\-z, A\-Z, 0\-9, \_ \(underscore\), = \(equal\), : \(colon\), \. \(period\), \- \(hyphen\), \~ \(tilde\), / \(forward slash\), and \* \(asterisk\)\. Wildcards \(\*\) are acceptable\.
  + An object group name that allows you to refer to the object group\. The name can't have more than 30 characters\. Valid characters are: a\-z, A\-Z, 0\-9, and \_ \(underscore\)\.

If an object matches multiple rules, CloudWatch displays a data point for each matching rule\. For example, if an object matches two rules named `rule1` and `rule2`, CloudWatch displays two data points for these rules\. The first has a dimension of `ObjectGroupName=rule1` and the second has a dimension of `ObjectGroupName=rule2`\.

**Topics**
+ [Adding a metric policy](policies-metric-add.md)
+ [Viewing a metric policy](policies-metric-view.md)
+ [Editing a metric policy](policies-metric-edit.md)
+ [Example metric policies](policies-metric-examples.md)
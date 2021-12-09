# Generating Amazon EC2 estimates<a name="ec2-estimates"></a>

There are two ways to generate an Amazon EC2 estimate: the quick estimate path and the advanced estimate path\. Use the quick estimate path for a fast route to a rough estimate\. Use the advanced estimate path for a more detailed estimate that accounts for workload, data transfer costs, additional storage options, and other, less common instance requirements\.

The quick and advanced paths require different information, but the results are identical on the group level\. That means that you can use both paths to configure Amazon EC2 in the same group\. You can also toggle between quick and advanced\. If you have a good idea of which Amazon EC2 instance you need for some parts of your planned AWS usage, but don't know many details about that usage, you can still get an estimate that covers both cases\.

**Note**  
If you toggle between the quick and advanced paths, your estimate might be higher than if you only used the quick path\. The advanced path sets defaults that can carry over to the quick path and raise your estimate\.

For example, say that Márcia knows that she needs an Amazon EC2 instance with Amazon EBS snapshots taken every hour\. She also knows that she needs some Amazon EC2 instances with more flexible snapshot requirements, but she doesn't know how many hours she needs for the more flexible instances\. The quick estimate path enables her to generate an estimate for the Amazon EC2 instances that don't have the hourly snapshot requirement and for which she doesn't know how many hours she needs\. The advanced estimate path enables her to generate an estimate for the Amazon EC2 instances with an hourly snapshot requirement\.

**Topics**
+ [Quick estimates](quick-estimate.md)
+ [Advanced estimates](advanced-estimate.md)
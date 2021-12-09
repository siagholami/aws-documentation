# AWS Elemental MediaConnect metrics to monitor output health<a name="monitor-with-cloudwatch-metrics-output-health"></a>

AWS Elemental MediaConnect sends metrics to CloudWatch\. You can review specific metrics to evaluate the health of the output of your flow\. 

**Note**  
Metrics tracked by MediaConnect adhere to the standard as defined by the TR 101 290 spec\.


| Metric | Description | 
| --- | --- | 
| ConnectedOutputs |  The number of outputs that are currently connected\. This metric applies only to outputs that use the Zixi protocol\.  Units: Count Valid dimensions:  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-output-health.html)  | 
| OutputConnected |  The status of the output\. A value of one indicates that the output is connected, and a value of zero indicates that the output is disconnected\. This metric applies only to outputs that use the Zixi protocol\. Units: None Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-output-health.html)  | 
| OutputDisconnections |  The number of times that the output status changed from connected to disconnected\. This metric applies only to outputs that use the Zixi protocol\. Units: Count Valid dimensions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/monitor-with-cloudwatch-metrics-output-health.html)  | 
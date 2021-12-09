# AWS IoT 1\-Click Devices<a name="1click-devices"></a>

AWS IoT 1\-Click\-supported devices:
+ Are ready\-made\. Customers do not need to design or manufacture them\. 
+ Can be added to AWS IoT 1\-Click accounts by using the [claim feature](claiming-devices.md)\.
+ Are pre\-provisioned with certificates at the point of manufacture and configured to connect securely to AWS IoT\. You don't need to spend time installing certificates for AWS IoT 1\-Click devices\.
+ Each AWS IoT 1\-Click device *type* emits events in a standard format defined by AWS IoT 1\-Click\. For example, all AWS IoT 1\-Click devices of the `button` type have the same event format, regardless of the manufacturer\.
+ Have a device type and a product type\. The device type indicates the format of events emitted by the device and the device methods it supports\. For more information, see [AWS IoT 1\-Click Programming Model](1click-programming.md)\. The product type provides manufacturer and the branding details\. For example, if the device type is `button`, the product type might be AT&T LTE\-M Button\.

**Important**  
AWS IoT 1\-Click\-supported devices are configured in the factory to connect to a particular [AWS Region](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.RegionsAndAvailabilityZones.html)\. These are called *device regions*\. This association of a device to a *device region* is required to ensure that devices connect securely to AWS IoT without additional user input\. For this reason, the device region cannot be changed\.   
Events emitted by AWS IoT 1\-Click devices are always routed through the pre\-configured device region, so you can access device\-related Amazon CloudWatch Logs and AWS CloudTrail metrics in this same AWS Region\. The device region is also where enabled devices are billed\.  
 Placement, template, and project data is stored in the AWS Region associated with your account\.This region can be different from the device region\.

For information about AWS IoT 1\-Click supported devices, including how to purchase and [claim](1click-claiming.md) them, see [AWS IoT 1\-Click Appendix](1click-appendix.md)\.
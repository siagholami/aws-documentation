--------

--------

# Security Best Practices for AWS IoT Things Graph<a name="security-best-practices"></a>

AWS IoT Things Graph provides a number of security features to consider as you develop and implement your own security policies\. The following best practices are general guidelines and don't represent a complete security solution\. Because these best practices might not be appropriate or sufficient for your environment, treat them as helpful considerations rather than prescriptions\.

To learn about security in AWS IoT, see [Security Best Practices in AWS IoT](https://docs.aws.amazon.com/iot/latest/developerguide/security-best-practices.html) in the *AWS IoT Developer Guide*\.

For information about hardware security in AWS IoT Greengrass, see [Hardware Security Integration](https://docs.aws.amazon.com/greengrass/latest/developerguide/hardware-security.html) in the *AWS IoT Greengrass Developer Guide*\.

Cloud deployments require you to use an IAM role to execute AWS IoT Things Graph flows on your behalf\. AWS IoT Greengrass deployments require you to use an IAM role for AWS IoT Greengrass to execute flows\. These roles should have policies that allow AWS IoT Things Graph to perform all of the actions in your flow\. Make sure that these roles have only the permissions that they need to execute your flows\.
+ For information about setting up an environment for cloud deployments, see [Prepare for Cloud Deployments](iot-tg-gs-environment-cloud.md)\.
+ For information about setting up an environment for AWS IoT Greengrass deployments, see [Setting Up Your Environment for AWS IoT Greengrass Deployments](iot-tg-gs-environment.md)\.
--------

--------

# Encryption in Transit<a name="encryption-in-transit"></a>

In cloud deployments, AWS IoT Things Graph protects data in transit by using the Transport Layer Security \(TLS\) protocol\. For more information, see [Transport Security in AWS IoT](https://docs.aws.amazon.com/iot/latest/developerguide/transport-security.html) in the *AWS IoT Developer Guide*\.

In AWS IoT Greengrass deployments, AWS IoT Things Graph uses the data protection features of AWS IoT Greengrass\. AWS IoT Greengrass supports the following modes of data in transit:
+ The AWS IoT Greengrass core communicates with AWS IoT over the internet\. This data is encrypted\.

  AWS IoT Greengrass uses TLS to encrypt all communication over the internet\. All data sent to the AWS Cloud goes through a TLS connection using either the MQTT or HTTPS protocol, so it's secure by default\.
+ The AWS IoT Greengrass core device and connected devices communicate over the local network\. This data is encrypted\.

  AWS IoT Greengrass uses TLS to encrypt all communication over the local network between the AWS IoT Greengrass core and connected devices\. For supported TLS cipher suites, see [Supported Cipher Suites for Local Network Communication](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-sec.html#gg-cipher-suites) in the *AWS IoT Greengrass Developer Guide*\.
+ Components on the AWS IoT Greengrass core, including the AWS IoT Things Graph connector, communicate with each other\. This data isn't encrypted\.

  AWS IoT Greengrass doesn't encrypt data in transit locally between components on the AWS IoT Greengrass core because it doesn't leave the device\. This includes communication from group members \(such as AWS Lambda functions and connectors\), the AWS IoT Greengrass Core SDK, and stream manager\.
+ AWS IoT Greengrass doesn't enforce network isolation for user\-defined Lambda functions, whether or not they run in an [AWS IoT Greengrass container](https://docs.aws.amazon.com/greengrass/latest/developerguide/lambda-group-config.html#lambda-containerization-considerations)\.

  It's possible that user\-defined Lambda functions can communicate with other processes that run in the system or outside the network\.

Additionally, when AWS IoT Things Graph installs a flow to your AWS IoT Greengrass core, it first uploads a file that contains all of the flow's dependencies to an Amazon S3 bucket\. AWS IoT Things Graph uploads this file by using the HTTPS protocol, so it's secure in transit by default\. It's your responsibility to secure the Amazon S3 bucket\.
# Use the Alexa for Business Gateway<a name="a4b-gateway"></a>

The Alexa for Business gateway enables you to connect Alexa for Business to your Cisco TelePresence and Polycom Group Series endpoints to control meetings with your voice\. The gateway software runs on your on\-premises hardware and securely proxies conferencing directives from Alexa for Business to your Cisco endpoint\. The gateway is available for both Windows and Linux\.

The gateway needs two pairs of AWS credentials to communicate with Alexa for Business\. We recommend that you create two limited\-access IAM users for your Alexa for Business gateways, one for installing the gateway and one for operating the gateway\.

**To create new IAM users**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Users**, **Add user**\.

1. Enter a user name \(for example, AlexaforBusinessGatewayInstaller\)\.

1. For **Access type**, choose **Programmatic access**\.

1. Choose **Next**, **Attach existing policies directly**, **AlexaForBusinessFullAccess** in the list of policies, and then choose **Next**\.

1. Choose **Create user**\.

1. Download and save the IAM access key and secret key\. You need them later when you configure the Alexa for Business gateway\.

1. To create a second user that is used to run the Alexa for Business gateway, repeat steps 2\-7\. Enter a user name \(for example, AlexaforBusinessGateway\) and choose **AlexaForBusinessGatewayExecution** in the list of policies\.

**Topics**
+ [Installing the Gateway](install-gateway.md)
+ [Running Multiple Gateways](run-gateways.md)
+ [Maintaining the Gateway](maintain-gateway.md)
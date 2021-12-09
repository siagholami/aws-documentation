# AVS Permissions<a name="AVS-permissions"></a>

To register an Alexa Voice Service \(AVS\) device with Alexa for Business, you must first give access to the Alexa built\-in device maker\. To do this, use the following steps to create an IAM role in the Alexa for Business console that allows the AVS device maker to register and manage devices with Alexa for Business on your behalf\.

**To grant AVS permissions**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Settings**, **AVS permissions**\.

1. From the **AVS device** maker drop\-down menu, choose the device maker or **Other**\.

1. Enter the **AVS device maker AWS account ID** and **Amazon ID** provided by the device maker\.

1. Choose **Create IAM role**\.

1. Make note of the **Role ARN** and **External ID** that are displayed\. These must be entered in the device maker's management tool\. \(The experience might be different across device makers\.\)
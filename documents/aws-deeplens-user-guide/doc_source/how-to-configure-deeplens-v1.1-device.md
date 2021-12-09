# Name Your AWS DeepLens 2019 Edition Device and Complete the Registration<a name="how-to-configure-deeplens-v1.1-device"></a>

After your AWS DeepLens 2019 Edition device is connected to the internet and its software updated, name the device for future reference and agree to the AWS access permissions that are granted on your behalf in order to complete the registration\. 

**To name your AWS DeepLens 2019 Edition device, agree to AWS permissions, and complete the registration**

1. Under **Name your device**, give the device a name\. 

1. Under **Permissions**, check the box to confirm **I agree that required IAM roles containing necessary permissions be created on my behalf\.** 

1. Choose **Register device** to complete the registration\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/v1.1-device-naming-and-registering.png)

The device registration is now underway\. The asynchronous process involves the following tasks:
+ The device communicates with the AWS DeepLens service on the cloud through the specified Wi\-Fi network\.
+ The AWS DeepLens service has necessary IAM roles with the required AWS permissions created for you\. 
+ The AWS Cloud creates device representation with AWS IoT and other AWS services\.
+ The device downloads its AWS certificate of your account from the AWS Cloud\.

To verify that the registration is successfully completed, follow the [next step](#how-to-verify-deeplens-v1.1-device-registration)\.

## Verify Your AWS DeepLens 2019 Edition Device Registration<a name="how-to-verify-deeplens-v1.1-device-registration"></a>

After the registration is complete, verify the device registration is successful by checking the device's registration status\. 

**To verify your AWS DeepLens 2019 Edition device registration**

1. Wait for the device registration to complete\. Make sure the **Registration status** under **Device Status** shows **Registered**\.   
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/v1.1-device-completed-registration.png)

1. Optionally, note the MQTT topic Id \(e\.g\., **$aws/things/deeplens\_cTsBnnQxT0mMx45HGLJ4DA/infer**\) displayed under **Project Output**\. You'll need this Id to [view a deployed project output in the AWS IoT console](deeplens-viewing-project-output-json.md)\.
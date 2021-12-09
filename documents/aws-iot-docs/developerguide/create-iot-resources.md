# Create AWS IoT resources<a name="create-iot-resources"></a>

In this tutorial, you'll create the AWS IoT resources that a device requires to connect to AWS IoT and exchange messages\. 

![\[Create AWS IoT resources\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/iot-gs-create-resources.png)

1. Create an AWS IoT policy document, which will authorize your device to interact with AWS IoT services\.

1. Create a thing object in AWS IoT and its X\.509 device certificate, and then attach the policy document\. The thing object is the virtual representation of your device in the AWS IoT registry\. The certificate authenticates your device to AWS IoT Core, and the policy document authorizes your device to interact with AWS IoT\.
**Note**  
If you are planning to [Create a virtual device with Amazon EC2](creating-a-virtual-thing.md), you can skip this page and continue to [Configure your device](configure-device.md)\. You will create these resources when you create your virtual thing\.

This tutorial uses the AWS IoT console to create the AWS IoT resources\. If your device supports a web browser, it might be easier to run this procedure on the device's web browser because you will be able to download the certificate files directly to your device\. If you run this procedure on another computer, you will need to copy the certificate files to your device before they can be used by the sample app\.

## Create an AWS IoT policy<a name="create-iot-policy"></a>

X\.509 certificates are used to authenticate your device with AWS IoT Core\. AWS IoT policies are attached to the certificate that authenticates the device to determine the AWS IoT operations, such as subscribing or publishing to MQTT topics that the device is permitted to perform\. Your device presents its certificate when it connects and sends messages to AWS IoT Core\.

In this procedure, you will create a policy that allows your device to perform the AWS IoT operations necessary to run the example program\. You must create the AWS IoT policy first, so that you can attach it to the device certificate that you will create later\.

**To create an AWS IoT policy**

1. In the left menu, choose **Secure**, and then choose **Policies**\. On the **You don't have a policy yet** page, choose **Create a policy**\.

   If your account has existing policies, choose **Create**\.

1. On the **Create a policy** page:

   1. In the **Name** field, enter a name for the policy \(for example, **My\_Iot\_Policy**\)\. Do not use personally identifiable information in your policy names\.

   1. In the **Action** field, enter **iot:Connect,iot:Receive,iot:Publish,iot:Subscribe**\. These are the actions that the device will need permission to perform when it runs the example program from the Device SDK\.

      For more information about IoT policies, see [AWS IoT Core policies](iot-policies.md)\.

   1. In the **Resource ARN** field, enter **\***\. This selects any client \(device\)\.
**Note**  
In this quick start, the wildcard \(\*\) character is used for simplicity\. For higher security, you should restrict which clients \(devices\) can connect and publish messages by specifying a client ARN \(Amazon resource name\) instead of the wildcard character as the resource\. Client ARNs follow this format:  
 `arn:aws:iot:your-region:your-aws-account:client/my-client-id`   
However, you must first create the resource \(client device, thing shadow, etc\.\) before you can assign its ARN to a policy\.

   1. Choose the **Allow** check box\.

      These values allows all clients that have this policy attached to their certificate to perform the actions listed in the **Action** field\.  
![\[Create policy\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/gs-create-policy.png)

1. After you have entered the information for your policy, choose **Create**\.

For more information, see [IAM policies](iam-policies.md)\. 

## Create a thing object<a name="create-aws-thing"></a>

Devices connected to AWS IoT are represented by *thing objects* in the AWS IoT registry\. A *thing object* represents a specific device or logical entity\. It can be a physical device or sensor \(for example, a light bulb or a light switch on the wall\)\. It can also be a logical entity, like an instance of an application or physical entity that does not connect to AWS IoT, but is related to other devices that do \(for example, a car that has engine sensors or a control panel\)\.

**To create a thing in the AWS IoT console**

1. In the [AWS IoT console](https://console.aws.amazon.com/iot/home), on the **Welcome to the AWS IoT Console** page, in the left menu, choose **Manage**\.

1. On **You don't have any things yet**, choose **Register a thing**\.

   If your account already has some things, choose **Create**\.

1. On **Creating AWS IoT things**, choose **Create a single thing**\.

1. On the **Add your device to the thing registry** page, in the **Name** field, enter a name for your thing, such as **MyIotThing**\.

   When naming things, choose the name carefully, because you can't change a thing name after you create it\.

   To change a thing's name, you must create a new thing, give it the new name, and then delete the old thing\.
**Note**  
Do not use personally identifiable information in your thing name\. The thing name can appear in unencrypted communications and reports\.

   Leave the rest of the fields on this page empty, for now\.

   Choose **Next**\.

1.  On **Add a certificate for your thing**, choose **Create certificate**\. 

1. On the **Certificate created\!** page:

   1. Download the each of the certificate and key files and save them for later\. You will need to install these files on your device\.

      When you save your certificate files, give them the names in the following table\. These are the file names used in later examples\.  
**Certificate file names**    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iot/latest/developerguide/create-iot-resources.html)

   1. Download the root CA file for these files by choosing the **A root CA for AWS IoT Download** link and downloading the **RSA 2048 bit key: Amazon Root CA 1** certificate file\. 
**Important**  
You must save the certificate files before you leave this page\. After you leave this page in the console, you will no longer have access to the certificate files\.  
If you forgot to download the certificate files that you created in this step, you must exit this console screen, go to the list of things in the console, delete the thing object you created, and then restart this procedure from the beginning\.

   1.  Choose **Activate**, to enable the certificate for connections to AWS IoT\. 

   1.  Choose **Attach a policy**, to attach the policy you created in the previous section to this certificate\. 

   1. On **Add a policy for your thing**, select the policy you created in the previous section\. In that section, the policy was named, **My\_Iot\_Policy**\.

   1.  Choose **Register Thing**\. 

After you complete this procedure, you should see the new thing object in your list of things\.
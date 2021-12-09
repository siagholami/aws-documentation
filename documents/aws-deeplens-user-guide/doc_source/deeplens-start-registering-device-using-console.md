# Configure Your AWS Account for AWS DeepLens Device<a name="deeplens-start-registering-device-using-console"></a>

Configuring your AWS account for your AWS DeepLens device involves naming the device, grant AWS access permissions, and download a certificate for the device to be authenticated by AWS\.

**To configure your AWS account for AWS DeepLens device**

1. Sign in to the AWS Management Console for AWS DeepLens at [https://console\.aws\.amazon\.com/deeplens/home?region=us\-east\-1\#firstrun](https://console.aws.amazon.com/deeplens/home?region=us-east-1#firstrun)\.

1. Choose **Register a device**\. If you don't see a **Register a device** button, choose **Devices** on the main navigation pane\.

1. On the **Choose a hardware version** dialog window, choose the **HW v1** radio button for your AWS DeepLens device\. Then choose **Start**\. 

1. In the **Name your device** section on the **Configure your AWS account** page, type a name \(e\.g\., `My_DeepLens_1`\) for your AWS DeepLens device in the **Device name** text field \.

   The device name can have up to 100 characters\. Valid characters are a\-z, A\-Z, 0\-9, and \- \(hyphen\) only\.   
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-registration-name-device.png)

1. In the **Permissions** section, choose **Create roles** for the AWS DeepLens console to create [the required IAM roles with relevant permissions](deeplens-required-iam-roles.md) on your behalf\. 

   After the roles are successfully created, you'll be informed that you have the necessary permissions for setting the AWS DeepLens device\. If the roles already exist in your account, the same message will be displayed\.

1.  In the **Certificate** section, choose **Download certificate** to save the device certificate\. 
**Important**  
The downloaded device certificate is a \.zip file\. Don’t unzip it\.   
Certificates aren't reusable\. You must generate a new certificate every time you register your device\.

1. After the certificate is downloaded, choose **Next** to proceed to joining your computer to your device's \(`AMDC-NNNN`\) Wi\-Fi network in order to start the device setup application hosted on the device\. 
**Note**  
On devices of certain earlier versions, the legacy device setup app assumes that your home or office Wi\-Fi network's name \(SSID\) and password do not contain special characters, including space, backward slash \(`\`\), single quote \(`'`\), double quote \(`"`\) or colon \(`;`\)\. If you've got such a device and your home or office Wi\-Fi network name or password contains such special characters, the legacy device setup app will be blocked when you attempt to configure its network connection\.   
If you have such a legacy device, after choosing **Next**, you will be prompted with a modal dialog to review requirements for your home or office Wi\-Fi network, as shown as follows:  

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-registration-wifi-network-requirements.png)
If your home or office network name or password contains any special character, choose **Yes, my network has special characters** and follow [this troubleshooting guide](troubleshooting-device-registration.md#troubleshooting-device-wifi-connection) to establish an SSH session to configure the Wi\-Fi network connection between your device and the internet and, then, to move on to configuring the rest of the device settings\. After that, you should update the device software to its latest version\. 
If your home or office network name or password do not contain any special character, choose **No, my network has no special characters** to be directed to [the **Connect to your device** page](deeplens-getting-started-connect.md)\. 
If you have a more recent device or your device software is updated, you will be directed to [the **Connect to your device** page](deeplens-getting-started-connect.md) without the modal dialog after choosing **Next**\. 
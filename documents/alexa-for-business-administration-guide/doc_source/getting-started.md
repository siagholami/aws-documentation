# Getting Started with Shared Devices<a name="getting-started"></a>

After setting your IAM permissions, you can now get started with your shared devices\. The following devices can be set up as shared devices:
+ Echo \(1st and 2nd generation\)
+ Echo Dot \(2nd generation\)
+ Echo Plus

**Topics**
+ [Get Recommended Hardware](#get-hardware)
+ [Prepare Your Devices](#prepare-devices)
+ [Import Your Devices](#import)
+ [Create an IAM User for Device Setup Tool](#create-IAM-user)
+ [Run the Device Setup Tool](#run-tool)
+ [Create Room Profile, Skill Group, and Room](#create-resources)

## Get Recommended Hardware<a name="get-hardware"></a>

We recommend that you obtain the following hardware to simplify the setup process:
+ Label printer or other equipment to print asset or identification tags for your devices
+ Power strips appropriately spaced for Echo or Echo Dot power adapters
+ Extra power adapters
+ Windows laptop or desktop with Wi\-Fi controller
**Note**  
The Device Setup Tool requires a Windows laptop\. It doesn't work on any virtual desktop running in the cloud or on Apple hardware\.

## Prepare Your Devices<a name="prepare-devices"></a>

There are several tips for preparing your devices before setup:
+ After you unpack a brand new device, keep the device connected for at least 15 minutes to download the latest firmware\. If your device doesn't have the latest firmware, assigning the device to a room fails\. 
+ As you unpack your devices, label them with the last three characters of the device serial numbers \(DSN\), printed on the box\. DSNs are not printed on some devices, and clearly labeling them helps you track them during setup\. You can also create asset tags that have the full DSNs and barcode on the label\.
+ You need to be within a certain distance of your devices, so we recommend that you use power strips and set them up on one or two long tables\.
+ If it’s the first time they’re turned on, the devices automatically enter setup mode\. If the devices have been turned on previously, hold the action button on the top of the devices for 8 seconds until the light ring turns orange\.
+ If you are setting up hundreds of devices, leave the power cord for each Echo or Echo Dot plugged into the power strips and move the devices without power cords through your setup station\.

## Import Your Devices<a name="import"></a>

Use the Alexa Companion app to set up your devices using your Amazon\.com or Amazon Business account, then import your devices into Alexa for Business\. Alternatively, you can create an IAM user for the Device Setup Tool provided by Alexa for Business, then use the Device Setup Tool to set up your devices\. For more information, see [Create an IAM User for Device Setup Tool](#create-IAM-user) and [Run the Device Setup Tool](#run-tool)\. 

**Note**  
 If you need your devices to connect to WPA2 Enterprise Wi\-Fi, you must use the Device Setup Tool\. 

Follow these steps to import your devices into Alexa for Business using the Alexa Companion app\.

**To import your devices**

1. Sign in to the Alexa Companion app using your Amazon\.com or Amazon Business account credentials\.

1. Set up your devices by following the instructions in the Alexa Companion app\.

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices**\.

1. Choose **Import devices**\.

1. Sign in with the same Amazon\.com or Amazon Business credentials that you used to sign in to the Alexa Companion app\.

1. For **Choose device\(s\)**, select the Echo devices to be imported in Alexa for Business, and choose **Import**\.

After your devices are set up, they are listed on the **Shared devices** page of the Alexa for Business console\. 

## Create an IAM User for Device Setup Tool<a name="create-IAM-user"></a>

Before you can use the Device Setup Tool, you must create an IAM user for it\.

**To create an IAM user for the Device Setup Tool**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Choose **Users**, **Create new users**\.

1. Enter a user name \(for example, **DeviceSetupTool**\), and choose **Programmatic access**, **Next**\.

1. Choose **Attach existing policy directly**, **AlexaforBusinessDeviceSetup** from the list, and **Next**\.

1. \(Optional\) If you plan to use **WPA2 Enterprise** for the **Network security type** in the **Device Setup Tool**, attach the following custom policy for additional ACM PCA permissions: 
**Note**  
We recommend that you use scoped down permissions for specific CAs\.

   ```
   { 
      "Version": "2012-10-17",
      "Statement": [ 
         { 
            "Effect": "Allow",
            "Action": [ 
               "acm-pca:ListCertificateAuthorities"
            ],
            "Resource": "*"
         },
         { 
            "Effect": "Allow",
            "Action": [ 
               "acm-pca:IssueCertificate",
               "acm-pca:GetCertificate"
            ],
            "Resource": "arn:aws:acm-pca:region:account:certificate-authority/11111111-1111-1111-111111111111"
         }
      ]
   }
   ```

    If you want don't want to be restricted to a specific PCA CA, attach the following policy:

   ```
   { 
      "Version": "2012-10-17",
      "Statement": [ 
         { 
            "Effect": "Allow",
            "Action": [ 
               "acm-pca:ListCertificateAuthorities",
               "acm-pca:IssueCertificate",
               "acm-pca:GetCertificate"
            ],
            "Resource": "*"
         }
      ]
   }
   ```

1. Choose **Create user**\.

1. Download and save the IAM access key and secret key\. You need them later when you configure the Device Setup Tool\.

## Run the Device Setup Tool<a name="run-tool"></a>

After you create an IAM user for the Device Setup Tool, you can run the Device Setup Tool to set up your devices\.

Follow these steps to run the Device Setup Tool on a Windows computer enabled with Wi\-Fi\.

**To run the Device Setup Tool**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Shared devices**\.

1. Choose **Set up devices**\.

1. On the **Set up your Alexa devices** page, choose the first button, **Download and run Device Setup Tool**\.

1. Install and open the Device Setup Tool\. 

1. On the home page of the application, choose **Get started**\.

1. Enter the **Access key ID** and **Secret access key** that you created for the Device Setup Tool user, and choose **Next**\.

1. Enter the following Wi\-Fi information of the network to connect to your Alexa devices, and choose **Save**\.
   + **Network SSID** \- Type the name of the network SSID\.
   + **Network security type** \- From the drop\-down menu, choose from one of the following options:
     + **None**
     + **WEP**
     + **WPA Personal**
     + **WPA2 Personal**
     + **WPA2 Enterprise**

1. If you chose **WPA2 Enterprise**, complete the following steps\. Otherwise, skip to step 9\.

   1. From the drop\-down menus, select the **EAP method** and **AWS certificate authority** that you created earlier, and choose **Save**\.

   1. On the **Set up Authentication Server Trust** page, provide the root certificate of your authentication server \(RADIUS\)\. This certificate is installed on your devices and used to trust your authentication server during EAP negotiation\. Select the certificate from a file on disk or paste it from your clipboard\. The certificate must be in PEM format\. When you're done, choose **Save**\.
**Note**  
If you have more than one root certificate, you can add only one at a time\.

1. After entering the Wi\-Fi information of the network to connect to your Alexa devices, enter the Wi\-Fi information of the network to connect to your computer during setup, and choose **Next**\.
**Note**  
To change this information later, choose **Change Wi\-Fi** from the **Device setup** home page\.

1. Put your Alexa devices into setup mode by powering them on for the first time, or by holding the action button on the top of the Echo device\.

1. From the **Device setup** home page, choose **Start setup** to scan for all Alexa devices in setup mode nearby and register them to your Alexa for Business organization\.
**Note**  
If you don't want to set up all Alexa devices in setup mode near your computer, choose **Select devices** and select from the list the devices to set up\. To download a \.csv file with the MAC address for your selected devices, choose **Download MAC info**\. 

1. Wait for the tool to complete\. You can monitor progress in the tool to see which device is being set up, as well as the status of each device \(**Successful** or **Failed**\)\.
**Note**  
After the status for a device changes to **Successful**, you can unplug the device even if the light ring is still orange\. If all devices show as **Failed**, make sure that you have a strong connection to the network and that the Wi\-Fi information is entered correctly\. 

After all of your devices have been set up, they are listed on the **Shared devices** page of the Alexa for Business console\. To set up more devices, repeat steps 1–12 for the additional devices\. 

## Create Room Profile, Skill Group, and Room<a name="create-resources"></a>

After you set up your devices with the Device Setup Tool, you are ready to create the following resources:
+ [A room](manage-rooms.md)
+ [A room profile](manage-profiles.md)
+ [A skill group](manage-skill-groups.md)
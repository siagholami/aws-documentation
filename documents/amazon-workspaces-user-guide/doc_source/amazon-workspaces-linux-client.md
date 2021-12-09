# Amazon WorkSpaces Linux Client Application<a name="amazon-workspaces-linux-client"></a>

The following information will help you get started with the Amazon WorkSpaces Linux client application\.

**Topics**
+ [Requirements](#linux-requirements)
+ [Setup and Installation](#linux_setup)
+ [Connecting to Your WorkSpace](#linux_connecting)
+ [Managing Your Login Information \(3\.0\+ Clients Only\)](#manage-login-info-linx)
+ [Client Views](#linux_views)
+ [Client Language](#linux_client_lang)
+ [Display Support](#linux-display-support)
+ [Proxy Server](#linux_proxy_server)
+ [Command Shortcuts](#linux_shortcuts)
+ [Clipboard Redirection](#linux_clipboard)
+ [Disconnect](#linux_disconnect)
+ [Release Notes](#linux-release-notes)

## Requirements<a name="linux-requirements"></a>

The Amazon WorkSpaces Linux client application requires 64\-bit Ubuntu 18\.04 \(AMD64\)\.

**Note**  
By default, Linux client access is disabled\. To use this client with your WorkSpace, your Amazon WorkSpaces administrator must enable Linux client access for your WorkSpaces directory\. For more information, see [ Control Device Access](https://docs.aws.amazon.com/workspaces/latest/adminguide/update-directory-details.html#control-device-access) in the *Amazon WorkSpaces Administration Guide*\.

## Setup and Installation<a name="linux_setup"></a>

Download and install the Amazon WorkSpaces Linux client application from [Amazon WorkSpaces Client Downloads](https://clients.amazonworkspaces.com/)\. Detailed installation instructions are included on the Linux client page on the Client Downloads site\.

To launch the Linux client from the command line, use:

`/opt/workspacesclient/workspacesclient`

## Connecting to Your WorkSpace<a name="linux_connecting"></a>

To connect to your WorkSpace, complete the following procedure\.

**To connect to your WorkSpace**

1. The first time that you run the client application, you are prompted for your registration code, which is contained in your welcome email\. The Amazon WorkSpaces client application uses the registration code and user name to identify which WorkSpace to connect to\. When you launch the client application later, the same registration code is used\. You can enter a different registration code by launching the client application and choosing **Settings**, **Manage Login Information** on the login screen menu\.

1. Enter your user name and password in the login screen and choose **Sign In**\. If your Amazon WorkSpaces administrator has enabled multi\-factor authentication for your organization's WorkSpaces, you are prompted for a passcode to complete your login\. Your Amazon WorkSpaces administrator will provide more information about how to obtain your passcode\.

1. If your Amazon WorkSpaces administrator has not disabled the **Keep me logged in** feature, you can select the **Keep me logged in** check box at the bottom of the login screen to save your credentials securely so that you can connect to your WorkSpace easily while the client application remains running\. Your credentials are securely cached up to the maximum lifetime of your Kerberos ticket\.

   After the client application connects to your WorkSpace, your WorkSpace desktop is displayed\.

An interruption of network connectivity causes an active session to be disconnected\. This can be caused by events such as closing the laptop lid, or the loss of your wireless network connection\. The Amazon WorkSpaces client application for Linux attempts to reconnect the session automatically if network connectivity is regained within a certain amount of time\. The default session resume timeout is 20 minutes, but this timeout can be modified by your network administrator\.

## Managing Your Login Information \(3\.0\+ Clients Only\)<a name="manage-login-info-linx"></a>

You can view your registration code and what Region your WorkSpace is in\. You can specify whether you want the WorkSpaces client application to save your current registration code, and you can assign a name to your WorkSpace\. You can also specify if you want Amazon WorkSpaces to keep you logged in to a WorkSpace until you quit or your login period expires\.

**To manage your login information for a WorkSpace**

1. In the Amazon WorkSpaces client application, go to **Settings**, **Manage Login Information**\.

1. In the **Manage Login Information** dialog box, you can see the registration code and Region information for your WorkSpace\.

1. \(Optional\) If you want the WorkSpaces client to remember your current registration code, select the **Remember Registration Code** check box\.

1. Under **Saved registration codes**, select the WorkSpace you want to name\.

1. In the **WorkSpace name** box, enter a name for the WorkSpace\.

1. \(Optional\) If you want WorkSpaces to keep you logged in until you quit or your login period expires, select the **Keep me logged in** check box\.

1. Choose **Save**\.

## Client Views<a name="linux_views"></a>

You can switch to full screen mode by choosing **View**, **Enter Full Screen** in the client application menu\.

While in full screen mode, you can switch back to window mode by moving the pointer to the top of the screen\. The client application menu is displayed, and you can choose **View**, **Leave Full Screen** in the client application menu\.

You can also toggle full screen mode by pressing Ctrl\+Alt\+Enter\.

## Client Language<a name="linux_client_lang"></a>

You can select the language displayed by the client by performing the following steps\.

**Note**  
In the client, Japanese is available in all Regions\. However, Japanese is only available in Tokyo for individual WorkSpaces\.

**To select the client language**

1. In the Amazon WorkSpaces client application, go to **Settings**, **Change Language**\.

1. Enter your desired language in the **Select a language** list and choose **Save**\.

1. Restart the client\.

## Display Support<a name="linux-display-support"></a>

Amazon WorkSpaces Value, Standard, Performance, Power, PowerPro, and GraphicsPro bundles support a maximum of four displays and a maximum resolution of 3840x2160 \(ultra\-high definition, or UHD\)\. The maximum supported resolution depends on the number of displays, as shown in the following table\.


| Displays | Resolution | 
| --- | --- | 
|  2  |  3840x2160  | 
|  4  |  1920x1200  | 

**Note**  
Graphics bundles support only a single monitor configuration with a maximum resolution of 2560x1600\.

The Amazon WorkSpaces client application extracts the Extended Display Information Data \(EDID\) of all attached displays and determines the best compatibility match before starting the session\. If you have a high pixel density \(high DPI\) display, the client application automatically scales the streaming window according to your local DPI settings\. For better maximum resolution with high DPI displays, see [WorkSpaces High DPI Display Support](high_dpi_support.md)\.

**To use multiple monitors with WorkSpaces**

1. Configure your local machine to use multiple monitors\. 

1. Start the WorkSpaces client application and log in to your WorkSpace\.

1. Depending on which client you're using, do one of the following:    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-linux-client.html)

Your WorkSpace should now be extended across your displays\. Whichever display you have designated as your primary display is also the primary display in WorkSpaces when you enter full screen mode\.

**Note**  
Using full screen mode on only some of the displays in a multiple monitor setup isn't possible\. You can, however, press Alt\+F10 or double\-click the title bar to maximize the WorkSpaces client window on a display without extending the WorkSpace to the other displays\.

## Proxy Server<a name="linux_proxy_server"></a>

If your network requires you to use a proxy server to access the internet, you can enable the Amazon WorkSpaces client application to use a proxy for HTTPS \(port 443\) traffic\. Proxy with authentication is not currently supported\.

**Note**  
The Amazon WorkSpaces client applications use the HTTPS port for updates, registration, and authentication\. The desktop streaming connections to the WorkSpace require port 4172 to be enabled, and do not go through the proxy server\. 

**To use a proxy server**

1. In the Amazon WorkSpaces client application, go to **Settings**, **Manage Proxy Server**\.

1. In the **Set Proxy** dialog box, select **Use proxy server**, enter the proxy server address and port, and choose **Save**\.

## Command Shortcuts<a name="linux_shortcuts"></a>

The Amazon WorkSpaces Linux client supports the following command shortcuts:
+ Ctrl\+Alt\+Enter—Toggle full screen display

## Clipboard Redirection<a name="linux_clipboard"></a>

Clipboard redirection is not currently supported for the Linux client application\.

## Disconnect<a name="linux_disconnect"></a>

To disconnect the Linux client application, you have several options: 
+ In the Amazon WorkSpaces client application, go to **Amazon WorkSpaces**, and then choose **Disconnect WorkSpace**\. Your WorkSpace session ends, but the client application continues running in case you want to log in again\.
+ In the Amazon WorkSpaces client application, go to **Amazon WorkSpaces**, and then choose **Quit Amazon WorkSpaces**\. Your WorkSpace session ends, and the client application closes\.
+ In the Amazon WorkSpaces client application, close the WorkSpaces client window by clicking the close \(X\) button in the upper\-right corner\. In the **End Session** dialog box, choose **Yes**\. Your WorkSpace session ends, but the client application continues running in case you want to log in again\.

## Release Notes<a name="linux-release-notes"></a>

The following table describes the changes to each release of the Linux client application\.


| Release | Date | Changes | 
| --- | --- | --- | 
| 3\.0\.10 | September 16, 2020 |  Minor bug fixes and enhancements  | 
| 3\.0\.9 | August 14, 2020 |  Minor bug fixes and enhancements  | 
| 3\.0\.8 | July 30, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-linux-client.html)  | 
|  3\.0\.7  | June 3, 2020 |  Minor bug fixes and enhancements  | 
|  3\.0\.6  | April 29, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-linux-client.html)  | 
|  3\.0\.4  | March 3, 2020 |  Minor bug fixes and enhancements  | 
|  3\.0\.1  | December 19, 2019 |  Bug fixes and UI enhancements  | 
|  3\.0\.0  | November 25, 2019 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-linux-client.html)  | 
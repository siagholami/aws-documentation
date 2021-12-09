# Amazon WorkSpaces Windows Client Application<a name="amazon-workspaces-windows-client"></a>

The following information will help you get started with the Amazon WorkSpaces Windows client application\.

**Topics**
+ [Requirements](#windows-requirements)
+ [Setup and Installation](#windows_setup)
+ [Determining Your Client Version](#determine-version-windows)
+ [Connecting to Your WorkSpace](#windows_connecting)
+ [Managing Your Login Information \(3\.0\+ Clients Only\)](#manage-login-info-windows)
+ [Client Views](#windows_views)
+ [Client Language](#windows_client_lang)
+ [Display Support](#windows-display-support)
+ [Proxy Server](#windows_proxy_server)
+ [Command Shortcuts](#windows_shortcuts)
+ [Disconnect](#windows_disconnect)
+ [Release Notes](#windows-release-notes)

## Requirements<a name="windows-requirements"></a>

The Amazon WorkSpaces Windows client application requires Microsoft Windows 7, Windows 8, or Windows 10\.

## Setup and Installation<a name="windows_setup"></a>

Depending on which version of the client you want, do one of the following:


| If you want to install\.\.\. | Do this | 
| --- | --- | 
| 3\.0\+ client | Go to [Amazon WorkSpaces Client Downloads](https://clients.amazonworkspaces.com/) and find the Amazon WorkSpaces Windows client\. Under Get the latest client, choose the Download button\. | 
| 2\.5\.11 client | Go to [Amazon WorkSpaces Client Downloads](https://clients.amazonworkspaces.com/) and find the Amazon WorkSpaces Windows client\. Under Older version 2\.5\.11, choose the Download button\. | 

You have two choices for how to install the Amazon WorkSpaces Windows client application: 
+ **Install just for you**\. If you choose this option and you share your local machine with other users, the WorkSpaces client application is available only to you\. If other users on the machine also want to use the WorkSpaces client application, they must install the application for their own use\. 
+ **Install for all users of this machine**\. If you choose this option, the WorkSpaces client application is available to anyone who logs on to the local machine, including those with Guest accounts\. 

Installing the WorkSpaces client application for all users requires you to have administrator privileges on your local machine\. Depending on how your local machine is configured, you might not have such privileges\. In that case, you can install the WorkSpaces client application just for yourself\. If you have questions about which option to choose, ask your WorkSpaces administrator for guidance\.

If you're having trouble updating your Amazon WorkSpaces Windows client application to a newer version, use the following procedure to update your client application\.

**To update the WorkSpaces Windows client application to a newer version**

1. On your local machine, open the Windows search box and enter **registry editor** to open the Registry Editor \(regedit\.exe\)\.

1. When asked "Do you want to allow this app to make changes to your device?", choose **Yes**\.

1. In the Registry Editor, navigate to the following registry entry:

   **Computer\\HKEY\_CURRENT\_USER\\Software\\Amazon Web Services\. LLC\\Amazon WorkSpaces\\WinSparkle**

1. Delete the **SkipThisVersion** registry key\. When prompted to confirm the deletion, choose **Yes**, and then close the Registry Editor\.

1. If you have not already entered a registration code in the WorkSpaces Windows client application, do so, and then choose **Amazon WorkSpaces**, **Quit Amazon WorkSpaces** to close the client application\.

1. Restart the WorkSpaces Windows client application\. You should be prompted to update the client\. Accept the update\.

## Determining Your Client Version<a name="determine-version-windows"></a>

To see which version of the WorkSpaces client you have, choose **Amazon WorkSpaces**, **About Amazon WorkSpaces**, or click the gear icon in the upper\-right corner and choose **About Amazon WorkSpaces**\.

## Connecting to Your WorkSpace<a name="windows_connecting"></a>

To connect to your WorkSpace, complete the following procedure\.

### To connect to your WorkSpace for 3\.0\+ clients<a name="windows_connecting-new-clients"></a>

1. The first time that you run the client application, you are prompted for your registration code, which is contained in your welcome email\. The Amazon WorkSpaces client application uses the registration code and user name to identify which WorkSpace to connect to\. When you launch the client application later, the same registration code is used\. To enter a different registration code, launch the client application, and then on the menu bar, choose **Settings**, **Manage Login Information**\.

1. Enter your user name and password in the login screen and choose **Sign In**\. If your Amazon WorkSpaces administrator has enabled multi\-factor authentication for your organization's WorkSpaces, you are prompted for a passcode to complete your login\. Your Amazon WorkSpaces administrator will provide more information about how to obtain your passcode\.

1. If your Amazon WorkSpaces administrator has not disabled the **Keep me logged in** feature, you can select the **Keep me logged in** check box at the bottom of the login screen to save your credentials securely so that you can connect to your WorkSpace easily while the client application remains running\. Your credentials are securely cached up to the maximum lifetime of your Kerberos ticket\.

   After the client application connects to your WorkSpace, your WorkSpace desktop is displayed\.

### To connect to your WorkSpace for 1\.0\+ and 2\.0\+ clients<a name="windows_connecting-legacy-clients"></a>

1. The first time that you run the client application, you are prompted for your registration code, which is contained in your welcome email\. The Amazon WorkSpaces client application uses the registration code and user name to identify which WorkSpace to connect to\. When you launch the client application later, the same registration code is used\. To enter a different registration code, launch the client application, and then on the menu bar, choose **Options**, **Manage Registrations**\.

1. Enter your user name and password in the login screen and choose **Sign In**\. If your Amazon WorkSpaces administrator has enabled multi\-factor authentication for your organization's WorkSpaces, you are prompted for a passcode to complete your login\. Your Amazon WorkSpaces administrator will provide more information about how to obtain your passcode\.

1. If your Amazon WorkSpaces administrator has not disabled the "Remember Me" feature, you are prompted to save your credentials securely so that you can connect to your WorkSpace easily while the client application remains running\. Your credentials are securely cached up to the maximum lifetime of your Kerberos ticket\.

   After the client application connects to your WorkSpace, your WorkSpace desktop is displayed\.

An interruption of network connectivity causes an active session to be disconnected\. This can be caused by events such as closing the laptop lid, or the loss of your wireless network connection\. The Amazon WorkSpaces client application for Windows attempts to reconnect the session automatically if network connectivity is regained within a certain amount of time\. The default session resume timeout is 20 minutes, but this timeout can be modified by your network administrator\.

## Managing Your Login Information \(3\.0\+ Clients Only\)<a name="manage-login-info-windows"></a>

You can view your registration code and what Region your WorkSpace is in\. You can specify whether you want the WorkSpaces client application to save your current registration code, and you can assign a name to your WorkSpace\. You can also specify if you want Amazon WorkSpaces to keep you logged in to a WorkSpace until you quit or your login period expires\.

**To manage your login information for a WorkSpace**

1. In the Amazon WorkSpaces client application, go to **Settings**, **Manage Login Information**\.

1. In the **Manage Login Information** dialog box, you can see the registration code and Region information for your WorkSpace\.

1. \(Optional\) If you want the WorkSpaces client to remember your current registration code, select the **Remember Registration Code** check box\.

1. Under **Saved registration codes**, select the WorkSpace that you want to name\.

1. In the **WorkSpace name** box, enter a name for the WorkSpace\.

1. \(Optional\) If you want WorkSpaces to keep you logged in until you quit or your login period expires, select the **Keep me logged in** check box\.

1. Choose **Save**\.

## Client Views<a name="windows_views"></a>

You can switch to full screen mode by choosing **View**, **Enter Full Screen** \(3\.0\+ clients\) or **View**, **Show Fullscreen** \(1\.0\+ and 2\.0\+ clients\) in the client application menu\.

While in full screen mode, you can switch back to window mode by moving the pointer to the top of the screen\. The client application menu is displayed, and you can choose **View**, **Leave Full Screen** \(3\.0\+ clients\) or **View**, **Exit Fullscreen** \(1\.0\+ and 2\.0\+ clients\) in the client application menu\.

You can also toggle full screen mode by pressing Ctrl\+Alt\+Enter\.

## Client Language<a name="windows_client_lang"></a>

You can select the language displayed by the client by performing the following steps\.

**Note**  
The WorkSpaces client applications support Japanese\. However, Japanese WorkSpaces are available only in the Asia Pacific \(Tokyo\) Region\.

**To select the client language**

1. Depending on which client you're using, do one of the following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)

1. Enter your desired language in the **Select a language** list and choose **Save**\.

1. Restart the client\.

## Display Support<a name="windows-display-support"></a>

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
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)

Your WorkSpace should now be extended across your displays\. Whichever display you have designated as your primary display is also the primary display in WorkSpaces when you enter full screen mode\.

**Note**  
Using full screen mode on only some of the displays in a multiple monitor setup isn't possible\. You can, however, press the Windows logo key \+ Up Arrow or use the maximize button in the upper\-right corner of the WorkSpaces window to maximize the WorkSpaces client window on a display without extending the WorkSpace to the other displays\.

## Proxy Server<a name="windows_proxy_server"></a>

If your network requires you to use a proxy server to access the internet, you can enable the Amazon WorkSpaces client application to use a proxy for HTTPS \(port 443\) traffic\. Proxy with authentication is not currently supported\.

**Note**  
The Amazon WorkSpaces client applications use the HTTPS port for updates, registration, and authentication\. The desktop streaming connections to the WorkSpace require port 4172 to be enabled, and do not go through the proxy server\. 

### To use a proxy server for 3\.0\+ clients<a name="windows_proxy_server-new-clients"></a>

1. In the Amazon WorkSpaces client application, go to **Settings**, **Manage Proxy Server**\.

1. In the **Set Proxy** dialog box, select **Use proxy server**, enter the proxy server address and port, and choose **Save**\.

### To use a proxy server for 1\.0\+ and 2\.0\+ clients<a name="windows_proxy_server-legacy-clients"></a>

1. In the Amazon WorkSpaces client application, open the **Advanced Settings** dialog box\.

1. In the **Proxy Server Setting** area, select **Use Proxy Server**, enter the proxy server address and port, and choose **Save**\.

## Command Shortcuts<a name="windows_shortcuts"></a>

The Amazon WorkSpaces Windows client supports the following command shortcuts:
+ Ctrl\+Alt\+Enter—Toggle full screen display
+ Ctrl\+Alt\+F12—Disconnect session

## Disconnect<a name="windows_disconnect"></a>

To disconnect the Windows client application, you have several options: 
+ In the Amazon WorkSpaces client application, go to **Amazon WorkSpaces**, and then choose **Disconnect WorkSpace**\. Your WorkSpace session ends, but the client application continues running in case you want to log in again\.
+ In the Amazon WorkSpaces client application, go to **Amazon WorkSpaces**, and then choose **Quit Amazon WorkSpaces**\. Your WorkSpace session ends, and the client application closes\.
+ In the Amazon WorkSpaces client application, close the WorkSpaces client window by clicking the close \(X\) button in the upper\-right corner\. In the **End Session** dialog box, choose **Yes**\. Your WorkSpace session ends, but the client application continues running in case you want to log in again\.
+ You can also log off of the WorkSpace\. In the Amazon WorkSpaces client application, go to **View**, and then choose **Send Ctrl\+Alt\+Delete**\. Choose **Sign Out**\. Your WorkSpace session ends, but the client application continues running in case you want to log in again\.

## Release Notes<a name="windows-release-notes"></a>

The following table describes the changes to each release of the Windows client application\.


| Release | Date | Changes | 
| --- | --- | --- | 
| 3\.0\.10 | September 16, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
| 3\.0\.9 | August 14, 2020 |  Minor bug fixes and enhancements  | 
| 3\.0\.8 | July 30, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  3\.0\.7  | June 3, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  3\.0\.6  | April 28, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  3\.0\.5  | March 30, 2020 |  Resolves an issue with the user interface displaying a login prompt if single sign\-on \(SSO\) is enabled for Amazon WorkDocs  | 
|  3\.0\.4  | March 3, 2020 |  Minor bug fixes and enhancements  | 
|  3\.0\.2  | February 14, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  3\.0\.0  | November 25, 2019 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.5\.11  | November 4, 2019 |  Minor bug fixes  | 
|  2\.5\.10  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.5\.9  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.5\.8  |  |  Resolves an intermittent crashing issue related to computer waking up when opening a laptop lid  | 
|  2\.5\.7  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.5\.6  |  |  Minor fixes  | 
|  2\.5\.5  |  |  Minor fixes  | 
|  2\.5\.2  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.5\.1  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.5\.0  |  |  Adds support for user self\-service WorkSpace management capabilities  | 
|  2\.4\.10  |  |  Minor fixes  | 
|  2\.4\.9  |  |  Minor fixes  | 
|  2\.4\.8  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.4\.7  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.4\.6  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.4\.5  |  |  Adds a check to ensure that certificates issued by Amazon Trust Services are trusted by Windows during installation\. By default, an up\-to\-date Windows local Root CA list includes Starfield Service Root Certificate Authority \- G2, and therefore trusts Amazon Trust Services certificates\. If the local Root CA list is outdated, the client installer installs the Starfield Service Root Certificate Authority \- G2 certificate to the system\. If you do not have administrator access to the client device, you'll be prompted to confirm the installation of the Root CA certificate\.  | 
|  2\.4\.4  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.4\.2  |  |  Minor fixes  | 
|  2\.4\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.3\.7  |  |  Addresses a gray screen issue that occurs when displays are in different orientations  | 
|  2\.3\.6  |  |  Localization enhancements  | 
|  2\.3\.5  |  |  Minor improvements  | 
|  2\.3\.3  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.3\.2  |  |  Installer fixes  | 
|  2\.3\.1  |  |  Minor fixes  | 
|  2\.3\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.2\.3  |  |  Resolves minor bugs and improves stability  | 
|  2\.2\.1  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.1\.3  |  |  Closing the client expires the reconnect token\. You can easily reconnect to your WorkSpace as long as the client is running\.  | 
|  2\.1\.1  |  |  Minor improvement to protocol handling  | 
|  2\.1\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.0\.8  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  2\.0\.6  |  |  Resolves bugs and includes other improvements  | 
|  2\.0\.4  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  1\.1\.80  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  1\.1\.6  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  1\.1\.4  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  1\.0\.8  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-windows-client.html)  | 
|  1\.0  |  |  Initial release  | 
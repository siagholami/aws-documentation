# Amazon WorkSpaces iPad Client Application<a name="amazon-workspaces-ipad-client"></a>

The following information will help you get started with the Amazon WorkSpaces iPad client application\.

**Topics**
+ [Requirements](#ipad-requirements)
+ [Setup and Installation](#ipad_setup)
+ [Connecting to Your WorkSpace](#ipad_connecting)
+ [Gestures](#ipad_gestures)
+ [Radial Menu](#ipad_radial_menu)
+ [Keyboard](#ipad_keyboard)
+ [Mouse Modes](#ipad_mouse_modes)
+ [Swiftpoint GT, ProPoint, or PadPoint Mouse](#ipad_gt_mouse)
+ [Disconnect](#ipad_disconnect)
+ [Clipboard Redirection](#ipad_clipboard_redirection)
+ [Release Notes](#ipad-release-notes)

## Requirements<a name="ipad-requirements"></a>

The Amazon WorkSpaces iPad client application requires the following:
+ iPad 2 or later with iOS 8\.0 or later
+ iPad Retina with iOS 8\.0 and later
+ iPad Mini with iOS 8\.0 and later
+ iPad Pro with iOS 9\.0 and later

## Setup and Installation<a name="ipad_setup"></a>

To download and install the client application, complete the following procedure\.

**To download and install the client application**

1. On your iPad, open [Amazon WorkSpaces Client Downloads](https://clients.amazonworkspaces.com/) and choose the **iPad** link\.

1. Download and install the application\.

1. Verify that the Amazon WorkSpaces client application icon appears on one of the iPad desktops\.

## Connecting to Your WorkSpace<a name="ipad_connecting"></a>

To connect to your WorkSpace, complete the following procedure\.

**To connect to your WorkSpace**

1. On your iPad, open the Amazon WorkSpaces client application\.

1. The first time that you run the client application, you are prompted for your registration code, which is contained in your welcome email\. The Amazon WorkSpaces client application uses the registration code and user name to identify which WorkSpace to connect to\. When you launch the client application later, the same registration code is used\. You can enter a different registration code by launching the client application and choosing **Enter new registration code** on the login screen\.

1. Enter your user name and password and choose **Sign In**\. If your Amazon WorkSpaces administrator has enabled multi\-factor authentication for your organization's WorkSpaces, you are prompted for a passcode to complete your login\. Your Amazon WorkSpaces administrator will provide more information about how to obtain your passcode\.

1. If your Amazon WorkSpaces administrator has not disabled the "Remember Me" feature, you are prompted to save your credentials securely so that you can connect to your WorkSpace easily in the future\. Your credentials will be securely cached up to the maximum lifetime of your Kerberos ticket\.

   After the client application connects to your WorkSpace, your WorkSpace desktop is displayed\.

## Gestures<a name="ipad_gestures"></a>

The following gestures are supported for the Amazon WorkSpaces iPad client application\.

Single tap  
Equivalent to a single click in Windows\.

Double tap  
Equivalent to a double click in Windows\.

Two finger single tap  
Equivalent to a right\-click in Windows\.

Two finger double tap  
Toggles the on\-screen keyboard display\.

Swipe from left  
Displays the radial menu\. For more information, see [Radial Menu](#ipad_radial_menu)\.

Two finger scroll  
Scrolls vertically\.

Two finger pinch  
Zooms display in or out\.

Two finger pan  
Pans the desktop when zoomed in\.

## Radial Menu<a name="ipad_radial_menu"></a>

The radial menu is displayed by swiping from the left side of the screen\. 

![\[iPad radial menu\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial.png)

The radial menu provides quick access to the following features:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-settings.png) **Settings** – Displays controls to change the screen resolution, change the scroll direction, or connect or disconnect the [Swiftpoint GT, ProPoint, or PadPoint Mouse](#ipad_gt_mouse)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-connection-status.png) **Connection Status** – Displays the connection status of the WorkSpace\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-power.png) **Disconnect** – Disconnects the client application without logging off\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-direct-mouse.png) **Direct Mouse Mode** – Sets the input to direct mouse mode\. For more information, see [Mouse Modes](#ipad_mouse_modes)\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-help.png) **Help** – Displays the command and gesture tutorial\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-keyboard.png) **Keyboard** – Toggles the display of the on\-screen keyboard\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-windows.png) **Windows Start Menu** – Displays the Windows Start Menu\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/ipad-radial-offset-mouse.png) **Offset Mouse Mode** – Sets the input to offset mouse mode\. For more information, see [Mouse Modes](#ipad_mouse_modes)\. 

## Keyboard<a name="ipad_keyboard"></a>

To toggle the display of the on\-screen keyboard, double\-tap with two fingers anywhere on the screen\. Special key combinations are displayed in the top row of the keyboard\.

## Mouse Modes<a name="ipad_mouse_modes"></a>

The mouse mode is set using the [radial menu](#ipad_radial_menu)\.

### Direct Mode<a name="ipad_mouse_mode_direct"></a>

In direct mouse mode, the mouse cursor is placed wherever you tap your finger\. In this mode, a single tap is equivalent to a left mouse button click and a two finger single tap is equivalent to a right mouse button click\.

### Offset Mode<a name="ipad_mouse_mode_offset"></a>

In offset mouse mode, the mouse cursor tracks the movement of your finger on the screen\. In this mode, simulate a left mouse button click by tapping the left mouse button icon\.

![\[Left mouse button icon\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/mouse-icon-left.png)

Simulate a right mouse button click by tapping the right mouse button icon\.

![\[Right mouse button icon\]](http://docs.aws.amazon.com/workspaces/latest/userguide/images/mouse-icon-right.png)

## Swiftpoint GT, ProPoint, or PadPoint Mouse<a name="ipad_gt_mouse"></a>

You can use the Swiftpoint GT, ProPoint, or PadPoint mouse on an iPad to interact with your WorkSpace\. To do so, before you launch the Amazon WorkSpaces iPad client application, enable Bluetooth on your iPad and pair the Swiftpoint mouse with your iPad \(the Swiftpoint mouse should pair automatically\)\. To connect the Swiftpoint mouse and your iPad client, display the radial menu, and tap **Settings**\. For **SwiftPoint GT Mouse**, choose **Connect**\.

**Note**  
Although the Swiftpoint GT mouse is no longer available, you can use the Swiftpoint ProPoint and PadPoint mice with the Amazon WorkSpaces iPad client application instead\. The Swiftpoint TRACPOINT, PenPoint, and GoPoint mice aren't supported for use with the WorkSpaces iPad client\. For more information, see [Swiftpoint GT Mouse](https://www.swiftpoint.com/products/swiftpoint-gt-ergonomic-mouse/)\.

## Disconnect<a name="ipad_disconnect"></a>

To disconnect the iPad client, display the radial menu, tap the disconnect icon, and tap **Disconnect**\. You can also log off of the WorkSpace, which disconnects the client\.

## Clipboard Redirection<a name="ipad_clipboard_redirection"></a>

The clipboard supports copy and paste of text and HTML content only\.

## Release Notes<a name="ipad-release-notes"></a>

The following table describes the changes to each release of the iPad client application\.


| Release | Date | Changes | 
| --- | --- | --- | 
|  2\.4\.15  | June 28, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.4\.14  | April 17, 2020 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.4\.13  | February 28, 2020 |  Minor bug fixes  | 
|  2\.4\.11  | October 28, 2019 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.4\.9  |  |  Minor bug fixes  | 
|  2\.4\.7  |  |  Closing the WorkSpaces client app now expires the reconnect token\. You can only reconnect to your WorkSpace when the client app is running\.   | 
|  2\.4\.6  |  |  Minor fixes to the on\-screen keyboard  | 
|  2\.4\.5  |  |  Adds support for uniform resource identifiers \(URIs\), which enable login orchestration  | 
|  2\.4\.4  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.4\.3  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.4\.2  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.4\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.2\.4  |  |  Localization enhancements  | 
|  2\.2\.3  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.2\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.1\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  2\.0\.0  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  1\.1  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  1\.0\.11  |  |  Improves stability on iOS 8  | 
|  1\.0\.10  |  |  Improves stability  | 
|  1\.0\.9  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  1\.0\.8  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  1\.0\.7  |  |  Improves the login experience  | 
|  1\.0\.6  |  |  Improves the login experience  | 
|  1\.0\.5  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  1\.0\.4  |  |  Improves the login experience  | 
|  1\.0\.3  |  |  Improves the login experience  | 
|  1\.0\.2  |  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/workspaces/latest/userguide/amazon-workspaces-ipad-client.html)  | 
|  1\.01  |  |  Improves radial functionality  | 
|  1\.0  |  |  Initial release  | 
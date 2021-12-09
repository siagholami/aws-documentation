# PCoIP Zero Client<a name="amazon-workspaces-pcoip-zero-client"></a>

You can set up and use a PCoIP zero client device with Amazon WorkSpaces\. For more information, see *Connecting to Amazon WorkSpaces Desktops* in the [PCoIP Connection Manager User Guide](https://www.teradici.com/web-help/Connecting_ZC_AWS_HTML5/TER1408002_Connecting_ZC_AWS.htm)\.

## Requirements<a name="zero_client_reqs"></a>

To use a PCoIP zero client with Amazon WorkSpaces, you need the following:
+ If your Tera2 zero client device has firmware version 6\.0\.0 or later, you can connect to your WorkSpace directly without using PCoIP Connection Manager\.
+ If your Tera2 zero client device has a firmware version between 4\.6\.0 and 6\.0\.0, your Amazon WorkSpaces administrator must set up an EC2 instance with Teradici PCoIP Connection Manager for Amazon WorkSpaces\. Your administrator also provides you with a server URI that you can use to connect to your WorkSpace\.
+ WorkSpaces multi\-factor authentication requires a Tera2 zero client device with firmware version 6\.0\.0 or later\.

For a list of approved PCoIP zero client devices, see [PCoIP Zero Clients](https://www.teradici.com/product-service-finder/pcoip-zero-clients) on the Teradici website\.

## Set Up the Zero Client Connection<a name="zero_client_setup"></a>

Before you connect your zero client device to your WorkSpace for the first time, you might need to change some settings\. Your Amazon WorkSpaces administrator can provide you with additional setup instructions that are needed for your particular environment\.

### Session Connection<a name="connection_type"></a>

**To set the session connection**

1. From the PCoIP zero client device, choose **Options**, **Configuration**, **Session**\.

1. If the page is locked, choose **Unlock** and type your zero client password \(if required\)\.

1. For **Connection Type**, choose **PCoIP Connection Manager**\.

1. For **Server URI**, copy the server URI provided by your administrator, and then choose **OK**\.

## Connect to Your WorkSpace<a name="zero_client_connect"></a>

If your zero client device has firmware version 6\.0\.0 or later, you can connect directly\. Otherwise, you connect through PCoIP Connection Manager\.

**To connect to your WorkSpace directly \(recommended\)**

1. From the PCoIP zero client device, choose **Options**, **Configuration**, **Session**, and choose the **OSD: Amazon WorkSpaces Session Settings** connection type\.

1. Type the registration code from your welcome email\.

1. Type a name for this registered WorkSpace\.

1. Choose **Connect**\.

**To connect to your WorkSpace using PCoIP Connection Manager**

1. From the PCoIP zero client device, choose **PCoIP Connection Manager for Amazon WorkSpaces** for **Server**\.

1. Choose **Connect**

1. On the login page, type your Amazon WorkSpaces user name and password, and then choose **Login**\.

## Disconnect from the Zero Client<a name="zero_client_disconnect"></a>

To disconnect the zero client from your WorkSpace, you can press Ctrl\+Alt\+F12\. Alternatively, you can log off of the WorkSpace, which disconnects the client\.
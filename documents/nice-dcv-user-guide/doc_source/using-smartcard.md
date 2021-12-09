# Using a Smart Card<a name="using-smartcard"></a>

NICE DCV enables you to use a smart card connected to your client computer, using the standard Personal Computer/Smart Card \(PC/SC\) interface\. The smart card functionality can only be used by one NICE DCV client at a time\. This is especially important in environments where multiple clients are connected to the same session\. 

Smart card access is supported with the Windows, Linux, and macOS clients connected to a session hosted on a Linux NICE DCV server\. It is not supported with the web browser client or Windows NICE DCV servers\.

You must be authorized to use this feature\. If you are not authorized, the functionality is not available in the client\.

**To use a smart card**

1. Launch the client and connect to the NICE DCV session\.

1. Take control of or release the smart card\. No other clients connected to the session can access it while you have control\. When you're done using the smart card, release control\. After it's released, other clients connected to the session can take control\. The smart card is automatically released when you disconnect from the session\.

   1. In the client, choose **Settings**, **Removable Devices**\.

   1. To control the smart card, enable the **Smart Card** toggle\. To release control of the smart card, disable the **Smart Card** toggle\.  
![\[Settings button located in the top-left corner of the interface.\]](http://docs.aws.amazon.com/dcv/latest/userguide/images/smartcard.png)

1. \(Optional\) To have the NICE DCV server cache smart card data, enable the smart card caching feature\. Smart card caching is disabled by default\. With smart card caching enabled, the server caches the results of recent calls to the client's smart card\. This helps to reduce the amount of traffic that is transferred between the client and the server and improves performance\.

   To enable smart card caching, you need to set and export the `DCV_PCSC_ENABLE_SMARTCARD` environment variable\. In the session, open a terminal window and run the following command:

   ```
   $  export DCV_PCSC_ENABLE_SMARTCARD=1
   ```
**Important**  
Be sure to run the following command in the same terminal from which you intend to launch the application \(step 4\)\.
**Note**  
You can permanently enable or disable smart card caching by configuring the `enable-cache` parameter on the NICE DCV server\. You cannot enable smart card caching if it is permanently disabled on the server\. For more information, see [Configuring Smart Card Caching](https://docs.aws.amazon.com/dcv/latest/adminguide/enable-smart-card.html) in the *NICE DCV Administrator Guide*\.

1. Launch the required application with smart card support\. In the session, open a terminal window, and launch the application using the `dcvscrun` command\. For example, to launch `firefox` with smart card support, use the following command:
**Important**  
If you enabled smart card caching, run the following command in the same terminal in which you set and exported the `DCV_PCSC_ENABLE_SMARTCARD` environment variable\.

   ```
   $  dcvscrun firefox
   ```
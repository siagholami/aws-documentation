# Use Cisco TelePresence with Alexa for Business<a name="using-cisco"></a>

Use Alexa for Business to control your Cisco TelePresence systems and join meetings by using your voice\. Alexa for Business supports the following Cisco video conferencing endpoints:
+ Cisco Telepresence DX, EX, MX, and SX series
+ Cisco Spark Room Kit

To have Alexa control your Cisco video conferencing endpoints, run the Alexa for Business gateway within your local network\. The Alexa for Business gateway receives control events from Alexa for Business and issues commands to the Cisco video conferencing endpoints in your meeting rooms\. For example, when a user asks Alexa to join a meeting, an event is sent to the gateway\. The gateway processes this event, connects to the Cisco video conferencing endpoint in the room, and then initiates the dial\-in to the meeting\. The following diagram shows the setup and network boundaries\.

![\[Setup and network boundaries\]](http://docs.aws.amazon.com/a4b/latest/ag/images/setup-network-boundaries-NEW.png)

For more information, see [Use the Alexa for Business Gateway](a4b-gateway.md)\.

To use Alexa for Business to control your Cisco video conferencing endpoints, you must meet the following requirements:
+ You have a Cisco TelePresence system with firmware version TC7\.3\.12 or CE8 or higher\.
+ You have Windows Server 2008 or later, Windows 7 desktop or later, or a Linux server or choice to run the Alexa for Business gateway\. This can be a virtual or physical machine\.
+ Your locally deployed Alexa for Business gateway is allowed to make outbound HTTPS connections and has local network access to control your Cisco TelePresence system\. Incoming external communication or inbound ports aren't required\.
+ Cisco video conferencing endpoints registered with Cisco Spark cloud are currently not supported\.

**To use Cisco TelePresence with Alexa for Business**

1. Set up your conferencing provider in Alexa for Business\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Conference settings** and then choose the name of your default conferencing provider\.

   1. Enter the H323/SIP endpoint if it isn't filled in\. Alexa for Business sends these settings with the meeting ID/PIN to create a dial\-in string that's called on in the Cisco TelePresence system\.

1. Enable the skill\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose** Conference settings** and **Alexa for Cisco TelePresence** in the list of conference equipment\.

   1. Choose **Enable**\.

   1. You receive a prompt to link an account\. Sign in or create an Amazon\.com account \(for example, marymajor@example\.com\)\.

   1. Choose **Skills**, **Enabled skills**, and then select the skill\.

   1. Choose **Assign to skill group** and choose the skill group associated with the rooms where you want to make the skill available\.

1. Install the Alexa for Business gateway\. For more information, see [Use the Alexa for Business Gateway](a4b-gateway.md)\. 

1. Add your Cisco TelePresence system to Alexa for Business and add it to a room\.

   1. Choose **Endpoint**, **Add endpoint**\.

   1. Specify the **Cisco TelePresence** system name\.

   1. Enter a friendly name, which can be used to control the Cisco endpoint using your voice\. For example, "Alexa, turn on <friendly name>\."

   1. \(Optional\) Enter a description\.

   1. Choose the **Cisco TelePresence** model\.

   1. Specify the endpoint URL of your Cisco TelePresence endpoint\. For example, "http://10\.0\.1\.42"\. 
**Note**  
If you don't specify a protocol, "http" is used\.

   1. Choose the Alexa for Business room where the Cisco TelePresence endpoint is located\.

   1. Choose **Add**\.

   1. Choose **Rooms** and the name of the room where you just assigned the Cisco TelePresence endpoint\.

   1. Choose the gateway group to control your Cisco endpoint\.

   1. Choose **Discover devices** to have the endpoint available in your room\.

   1. Test the integration by saying “Alexa, start my meeting,” and say the meeting ID and PIN for your meeting when prompted\. 

**To add a Cisco TelePresence endpoint**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing settings**, **Alexa for Cisco TelePresence**\.

1. In the endpoint section, choose **Add endpoint**\. For **System name**, enter **Cisco TelePresence**\.

1. Enter a friendly name, which can be used to control the Cisco endpoint using your voice\. For example, "Alexa, turn on <friendly name>\." Enter an optional description\.

1. Choose **Cisco TelePresence model** and specify the endpoint URL of your Cisco TelePresence endpoint\. For example, "http://10\.0\.1\.42"\.
**Note**  
If you don't specify a protocol, "http" is used\.

1. Choose the Alexa for Business room where the Cisco TelePresence endpoint is located and choose **Add**\.

1. Choose **Rooms** and the name of the room where you just assigned the Cisco TelePresence endpoint\.

1. Choose the gateway group to control your endpoint\.

1. To have the endpoint available in your room, go to the **Smart Home devices** section and choose **Discover devices**\.

You can now use Alexa to control your Cisco TelePresence endpoint using voice\.

**To remove an endpoint**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing settings**, **Alexa for Cisco TelePresence**\.

1. Go to the endpoint section and select the check box next to the device to deregister\. 

1. Choose **Remove**\.

**To use HTTPS to connect to your Cisco Telepresence endpoints**

1. Choose one of the following options:

   1. To connect Alexa for Business to your Cisco Telepresence systems over Transport Layer Security \(TLS\), the gateway must be able to verify the signature of the certificates\. To enable this capability, install the root CA and other intermediate CAs that signed the certificate on the host where you run the gateway\. If the Cisco system can't be authenticated, the connection isn't established\. 

      You can either install the root CA and other intermediate CAs in the certificate store of your gateway host\. You can also specify the path to the certificates in the gateway config file; for example:\.

      **"rootCAsFile": "path\\\\to\\\\certs\\\\custom\-certs\.pem"**

   1. \(Not secure and not recommended\) If your Cisco endpoints are configured with a self\-signed certificate, you can also disable the certificate validation to allow the gateway to connect regardless of the certificate in use\. To do this, open the gateway configuration file and change the following configuration value:

      **"skipSslVerification": true**

1. To apply the change, restart the gateway\.

1. Verify the gateway log file to confirm that the certificate validation works correctly\. If the certificate validation fails, you see the following message in the log file:

   **handler\-cisco: failed executing request: Get https://<ip\-address>/getxml?location=/Status: x509: certificate signed by unknown authority**

**To debug log files**

1. Go to one of the following locations to see the log files written by the Alexa for Business gateway:
   + On Windows: C:\\ProgramData\\
   + On Linux: /var/log/a4b\-gateway/gateway\.log

1. In the log files, verify that the gateway is listening to the queue for control commands\. Find control requests in the log file by searching for “inbound: worker received request\.” By default, the log shows all the different control commands the gateway is performing\. Looks for errors to determine why the gateway can’t control your Cisco endpoint\.
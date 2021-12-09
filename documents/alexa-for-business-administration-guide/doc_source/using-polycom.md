# Use Polycom Group Series with Alexa for Business<a name="using-polycom"></a>

Use Alexa for Business to control your Polycom Group Series systems and join meetings by using your voice\.

To have Alexa control your Polycom Group Series video conferencing endpoints, run the Alexa for Business gateway within your local network\. The Alexa for Business gateway receives control events from Alexa for Business and issues commands to the Cisco video conferencing endpoints in your meeting rooms\. For example, when a user asks Alexa to join a meeting, an event is sent to the gateway\. The gateway processes this event, connects to the Cisco video conferencing endpoint in the room, and then initiates the dial\-in to the meeting\. 

To use Alexa for Business to control your Polycom Group Series video conferencing endpoints, you must meet the following requirements:
+ You have Polycom Group Series 310, 500, or 700\.
+ You enabled SSH on your Polycom Group Series endpoint\.
+ You have Windows Server 2008 or later, Windows 7 desktop or later, or a Linux server or choice to run the Alexa for Business gateway\. This can be a virtual or physical machine\.
+ Your locally deployed Alexa for Business gateway is allowed to make outbound HTTPS connections and has local network access to control your Polycom Group Series system\. Incoming external communication or inbound ports aren't required\.

**To use Polycom Group Series with Alexa for Business**

1. Set up your Alexa\-enabled devices\. For more information, see [Getting Started with Shared Devices](getting-started.md)\.

1. Link your calendar system to Alexa for Business\. For more information, see [Link Alexa for Business to Your Calendar System](manage-calendaring.md)\.

1. Enable the **Alexa for Cisco TelePresence/Polycom Group** skill\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose** Skill groups**, **Create skill group**, and then enter a name for your skill group \(for example, Conferencing skills\)\.

   1. Choose **Conference settings**, and then in the list of conference equipment, choose **Alexa for Cisco TelePresence/Polycom Group Series**\.

   1. Choose **Enable**\.

   1. You receive a prompt to link an account\. Sign in or create an Amazon\.com account \(for example, marymajor@example\.com\)\.

   1. Choose **Skills**, **Enabled skills**, and then select the skill\.

   1. Choose **Assign to skill group**, and then choose the skill group that you just created\.

1. Install the Alexa for Business gateway\. For more information, see [Use the Alexa for Business Gateway](a4b-gateway.md)\. 

1. Set up your conferencing provider in Alexa for Business\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Conference settings**, and then choose the name of your conferencing provider\.

   1. If you're using Polycom Group Series for Skype for Business, choose **Skype for Business** and make sure the following SIP URI is specified as SIP endpoint:

      sip:\{\{USERNAME\}\}@\{\{DOMAIN\}\};gruu;opaque=app:conf:focus:id:\{\{VIDEOID\}\}

   1. For other conferencing providers, enter the H323/SIP endpoint if the field is empty\. Alexa for Business sends these settings with the meeting ID/PIN to create a dial\-in string that's called in the Polycom Group Series system\.

1. Create your meeting rooms in Alexa for Business\. For more information, see [Managing Rooms](manage-rooms.md)\.

1. Add your Polycom Group Series endpoint to Alexa for Business, and then add it to a room\.

   1. Choose **Endpoint**, **Add endpoint**\.

   1. Specify the system name\.

   1. Enter a friendly name, which can be used to control the endpoint using your voice\. For example, "Alexa, turn on <friendly name>\."

   1. \(Optional\) Enter a description\.

   1. Choose the **Polycom Group Series** model\.

   1. If your Polycom Group Series endpoint is running Skype for Business mode, choose **Skype for Business mode**\.

   1. Specify the IP address or host name of your Polycom Group Series endpoint\. For example, "10\.0\.1\.42"\.

   1. Choose the Alexa for Business room where the Polycom Group Series endpoint is located\.

   1. Choose **Add**\.

   1. Choose **Rooms** and the name of the room where you just assigned the Polycom Group Series endpoint\.

   1. Choose the gateway group to control your Polycom endpoint\.

   1. To have the endpoint available in your room, in the **Smart Home devices** section, choose **Discover devices**\.

   1. To test the integration, schedule a meeting on the room calendar, say "Alexa, start my meeting," and confirm the scheduled meeting when prompted\.

**To add another Polycom Group Series endpoint**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing settings**, **Alexa for Cisco TelePresence/Polycom Group Series**\.

1. Choose **Endpoint**, **Add endpoint**\. 

1. Enter the **System name**\.

1. Enter a friendly name, which can be used to control the endpoint using your voice\. For example, "Alexa, turn on <friendly name>\." 

1. \(Optional\) Enter a description\.

1. Choose the **Polycom Group Series** model\. 

1. If your Polycom Group Series endpoint is running Skype for Business mode, choose **Skype for Business mode**\.

1. Enter the IP address or host name of your Polycom Group Series endpoint\. For example, "10\.0\.1\.42\."

1. Choose the Alexa for Business room where the Polycom Group Series endpoint is located, and then choose **Add**\.

1. Choose **Rooms** and the name of the room where you just assigned the Polycom Group Series endpoint\.

1. Choose the gateway group to control your endpoint\.

1. To have the endpoint available in your room, go to the **Smart Home devices** section and choose **Discover devices**\.

1. When the Polycom Group Series endpoint is listed under **Smart Home device**, setup is complete\. 

1. To test the integration, schedule a meeting on the room calendar, say "Alexa, start my meeting," and confirm the scheduled meeting when prompted\.

You can now use Alexa to control your Polycom Group Series endpoint using voice\.

**To remove an endpoint**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conferencing settings**, **Alexa for Cisco TelePresence/Polycom Group Series**\.

1. Go to the endpoint section and select the check box next to the device to de\-register\. 

1. Choose **Remove**\.
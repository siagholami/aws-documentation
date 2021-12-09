# Sending Announcements<a name="announcements"></a>

You can send Alexa announcements to one or more rooms in your Alexa for Business organization\. When you do this, Alexa wakes and speaks the announcement that you enter, for the rooms that you select\.

You can create an announcement from the Alexa for Business console, or with the SendAnnoucement API\. For more information, see the [Alexa for Business API Reference](https://docs.aws.amazon.com/a4b/latest/APIReference/Welcome.html)\. The API allows developers to trigger a text or audio announcement on Alexa for Business\-managed endpoints from any app\. For example, when a threshold is reached on an IoT sensor, send an alert to the shared devices in an operations team area\. Or, you can turn your Alexa for Business deployment into a PA system\.

**Note**  
Systems using the API need IAM permissions\.

Use the following steps to create an announcement from the console\. Also use these steps with the API, to test how the announcement sounds, or to make sure it reaches the correct rooms\.

**To send or test an announcement from the console**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Announcements**, **Create announcement**\. 

1. On the **Write message** page, next to **Message text**, enter a message for Alexa to announce\. Choose **Next**\.
**Note**  
There is a maximum of 250 characters\.

1. On the **Select rooms** page, choose one of the following options from the **Room selection** drop\-down menu:
   + **Manual selection** \- Select one room from a list of all your rooms\. You can filter by **Room name** and **Profile**\. This option is good for testing an announcement\. You can send it to one room while sitting in that room, to hear how it sounds\. 
   + **Room ARN** \- Enter the ARN of the room or rooms, separated by commas or line breaks\. You can call an API to retrieve room ARNs\.
   + **Room profile** \- Select the name of the room profile and review the list of rooms\.
   + **Room name filter** \- Enter an exact room name, or the prefix of multiple rooms\. For example, enter **Room** to see Room1 and Room2\.
   + **All rooms** \- Select all the rooms in your organization\.

1. Choose **Send announcement**\.
**Note**  
Alexa doesn’t proactively listen for requests after making the announcement\. After hearing an announcement, users must say the wake word to make Alexa requests\.
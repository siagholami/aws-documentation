# Require Users to Restrict Calendars to Voice<a name="voice-restrict"></a>

After users link their work calendars to Alexa, they can restrict their calendars to respond to their voices only\. You have the option in the Alexa for Business console to make this a requirement for all users by registering domains for voice restriction\. The domains must match the email addresses of the linked calendars\. 

**To add domains for calendar voice restriction**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Calendars**, and in the **Calendar voice restriction** section, choose **Add domain**\.

1. Follow the steps to add your email domain \(for example, example\.com\)\.

**To remove domains from calendar voice restriction**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Calendars**, and in the **Calendar voice restriction** section, select the check box next to the domain you want to remove\. 

1. Choose **Remove domain** and follow the steps\.

Enrolled users can set a voice restriction for their linked calendar accounts in the Alexa app\. When users set a voice restriction, Alexa uses voice profiles to determine who is speaking, and when to provide information from their calendar\. 

**Note**  
To set a voice restriction for their calendar, users must first create a voice profile\. If they don’t have one already, they are prompted to create one in the **Voice Restriction** section in their calendar settings\. For more information, see [Create a Voice Profile](https://www.amazon.com/gp/help/customer/display.html?nodeId=202199460)\.

**To set a voice restriction for a calendar**

1. Open the Alexa app, and on the menu, choose **Settings** and **Calendar**\.

1. Choose the linked calendar from the list\.

1. In the **Voice Restriction** section, on the menu, choose one of the following options:
   + **Only My Voice** – Alexa reads calendar events only after recognizing your voice\.
   + **All Enrolled Voices** – Alexa reads calendar events for any recognized speakers in your home with a voice profile\.
   + **No Voice Restriction** – Alexa doesn't restrict access to the calendar\.

The voice restriction selected applies to all of the devices registered to the user's account\.

If there are other adult users in the user's home, users can personalize calendar access across their shared Alexa devices by creating an Amazon Household\. Users can link their calendar accounts to Alexa individually in the Alexa app, then set the **Only My Voice** voice restriction so that Alexa provides information from that calendar only when recognizing each of their voices\. For more information, see [Using Household Profiles on Alexa Devices](https://www.amazon.com/gp/help/customer/display.html?nodeId=201628040)\.
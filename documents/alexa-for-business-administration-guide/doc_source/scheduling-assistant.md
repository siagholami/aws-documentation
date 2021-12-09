# Instruct Users to Use the Alexa Smart Scheduling Assistant<a name="scheduling-assistant"></a>

Alexa for Business allows enrolled users to connect their work calendar to Alexa\. They can then use the Alexa Smart Scheduling Assistant to add, move, or cancel meetings or ask Alexa about what meetings are on their calendar\. They can also invite other users to join conference calls scheduled on their calendar\. 

The following calendars are supported:
+ Google G Suite
+ Microsoft Office 365 
+ Microsoft Exchange 2013 or later

Enrolled users can perform any of the following procedures\.

**To link a work calendar account to Alexa**

1. Open the Alexa app, and on the menu, choose **Settings**, **Calendar**\.

1. Choose your calendar from the list of supported providers, choose **Link**, and follow the steps\.
**Note**  
You may need to provide sign\-in information for your calendar account and verify that you want to give Alexa access to it\. To link your Exchange calendar to Alexa, your IT administrator must set up Exchange\. For more information, see [Set up Microsoft Exchange Access for Users](connect-exchange.md)\.

1. Set your work calendar as the default calendar for new events\.

**Enable Alexa calling and messaging**
+ To join a conference call scheduled on your calendar, see [Sign Up for Alexa Calling and Messaging](https://www.amazon.com/gp/help/customer/display.html?nodeId=202145630)\.

**To manage contacts to use for scheduling or calling**
+ To manage work or personal contacts for your Alexa app, see [Add and Edit Your Contacts to the Alexa App](https://www.amazon.com/gp/help/customer/display.html?nodeId=202136200)\.

**Use utterances to talk to Alexa**
+ You can ask Alexa any of the following questions:
  + To browse events on your calendar:
    + Alexa, what's on my calendar?
    + Alexa, what's on my calendar tomorrow?
    + Alexa, what's on my calendar on \[any day\]?
  + To schedule a meeting:
    + Alexa, schedule a meeting today at 3PM\.
    + Alexa, schedule a one hour meeting with John\. 
    + Alexa, schedule a meeting with John tomorrow\.
  + To move a meeting:
    + Alexa, move my meeting\.
    + Alexa, move my meeting at 2PM today to 4PM today\. 
    + Alexa, move my meeting called \[meeting title\] to 5PM tomorrow\. 
  + To cancel a meeting:
    + Alexa, cancel my meeting at 2PM today\.
    + Alexa, cancel \[meeting title\] from my calendar\.
  + To join a conference call:
    + Alexa, join my meeting\.
  + To call a contact:
    + Alexa, call John\.
    + Alexa, call 222\-555\-0126\.
**Note**  
Emergency services, such as 911, are not supported\. For more information, see [Alexa Calling and Messaging FAQs](https://www.amazon.com/gp/help/customer/display.html/ref=augcmfaqlink4/ref=s9_acss_bw_cg_augfaq_md4_w?nodeId=201602230&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-10&pf_rd_r=18VQ2Z66EYXW8K2E63SK&pf_rd_t=101&pf_rd_p=28d33dbd-44c2-45cb-a990-45d2bfc038a0&pf_rd_i=16713667011#GUID-1CDA0A16-3D5A-47C1-9DD8-FDEDB10381A3__SECTION_6C259AE49F0C4C94B3BBDE26B09FC8A4)\.

## Troubleshooting<a name="troubleshoot-assistant"></a>

If you experience any of the following issues with the Alexa Smart Scheduling Assistant, try these steps:
+ **I can't schedule a meeting with a contact, but I can schedule an event\.**

  Choose **Contacts** in your Alexa companion app and see if the contact is displayed\. If the contact is not in the Alexa app but in your phone contacts, log out of the app and log in again\. 
+ **I can't get availability information when scheduling a meeting\.**

  Open your calendar and check that you have access to the contact's availability information\. Next, verify that the there is an email address associated with your contact in your Alexa companion app\. Then try again \- Alexa may not have recognized the name you spoke\. If you're still having issues, try scheduling a different contact\. If that doesn't work, contact support through the [AWS Forum](https://forums.aws.amazon.com/forum.jspa?forumID=273)\.
+ **I can't get availability for the full day\.**

  For Microsoft Office 365 and Microsoft Exchange, Alexa follows the work hours set on the calendar\. Work hours are set in your provider and can be changed using your calendar client\. To learn more, contact your IT administrator\. 
+ **I show as available on my calendar, but Alexa doesn't offer that time in its suggestion\.**

  Alexa checks availability information across all linked calendars\. For example, if you have Microsoft Office 365 and Gmail linked, then Alexa looks at the availability across both calendars for you as the organizer\. Note that Alexa does check all calendars of the recipient\. 
+ **I see "Created with Alexa <https://aws\.amazon\.com/alexaforbusiness>" in the invite email\.**

  Meeting invites created with Alexa for Business include this text in the invite by default\. 
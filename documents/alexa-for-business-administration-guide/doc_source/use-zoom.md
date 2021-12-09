# Use Zoom Rooms with Alexa for Business<a name="use-zoom"></a>

You can connect Alexa for Business to your Zoom Rooms system to control meetings using your voice\. 

To use the integration, make sure you're using:
+ Zoom Rooms for macOS: Version 4\.1\.20278\.0206 or higher
+ Zoom Rooms for PC: Version 4\.1\.22620\.0319 or higher

**To integrate Alexa for Business with your Zoom Rooms system**

1. Prepare for integration:

   1. Set up your Echo device\. For more information, see [Getting Started with Shared Devices](getting-started.md)\.

   1. Create a new skill group for the Zoom Alexa skill\. For more information, see [Managing Skill Groups](manage-skill-groups.md)\.

   1. Create a room in Alexa for Business, add the skill group, and assign the Echo device to the room\. For more information, see [Managing Rooms](manage-rooms.md)\.

   1. If you're using Office 365 or Microsoft Exchange as your calendar system, link your calendar to Alexa for Business\. For more information, see [Link Alexa for Business to Your Calendar System](manage-calendaring.md)\.

1. Set up Zoom as a conferencing provider:

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Conferencing**, **Add provider**, **Zoom** and save the settings\.

1. Enable the Zoom for Alexa skill:

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Conference settings**, **Zoom for Alexa** in the list of conference equipment, and **Enable**\.

   1. When you're prompted to link an account, sign in with the Zoom account where you registered your Zoom Rooms, and choose **Authorize** to complete the account linking\.

   1. Choose **Skills**, **Enabled skills**, and then select the skill\.

   1. Choose **Assign to skill group**, and choose the skill group associated with the rooms where you want to use Zoom\.

1. Configure the skill for your room:

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Rooms**, open the room where you want to use Zoom integration, and choose **Skills**\.

   1. Choose the pencil icon to edit the skill configuration\. 

   1. For the **Scope value**, type the name of a Zoom room that already exists or will be created in the Zoom web portal\.

1. Discover your Zoom Room device:

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Rooms**, open the room, and in the **Alexa Devices** section, verify that the status is **Synced**\.

   1. Choose **Smart Home devices**, **Discover devices**\. 

   1. If your Zoom Rooms configuration is successfully set up, your Zoom Rooms system displays in the list\.

You can now control your Zoom Rooms by talking to Alexa\. For example, say “Alexa, start my meeting” or “Alexa, join my meeting\.”

When a scheduled meeting associated with your Zoom Room is found on the calendar, you are prompted to join this meeting\. If you don’t want to join the scheduled meeting, you can either start an instant meeting by using the meeting ID 123, or join your personal meeting room by speaking your personal, 10\-digit meeting ID\.

If you encounter any of the following issues, try the these resolutions:
+ Alexa says that the Zoom room isn't found:

  Make sure that the account used for account linking is the same as the account that you used to sign into your Zoom room\. 
+ Alexa can't find an upcoming event on your calendar:

  Make sure that the meeting on your calendar was scheduled as a Zoom meeting\. 
+ Alexa says “It looks like the conference provider is invalid”:

  Make sure that you have the latest version of the Zoom Rooms software\. 
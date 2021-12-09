# Link Alexa for Business to Google G Suite<a name="google"></a>

The following versions of G Suite are supported:
+ G Suite Basic
+ G Suite Business
+ G Suite Enterprise
+ G Suite for Education

**Note**  
If you already linked your account and want to enable room booking, you must re\-link it\.

**To link Alexa for Business to Google G Suite**

1. Make sure that you have a super administrator account and have enabled API access in the Google Admin console\. For more information, see [Enable API access in the Admin console](https://support.google.com/a/answer/60757)\. 

1. Link Alexa for Business to Google G Suite using your administrator account\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Calendar**, **G Suite**\.

   1. Choose **Link account** and sign in with an account that has super administrator privileges\.

   1. Give consent that Alexa for Business has manage permissions to the calendars in your G Suite organization\.

1. Create a new meeting invite in your G Suite client\.

1. Add the room as the resource, add meeting dial\-in information to your meeting invite, and send the invite to book the room\.

1. Associate the email address of your resource mailboxes in G Suite to your Alexa for Business rooms\. 

   1. In the Alexa for Business console, choose **Rooms** and choose the room to which to add the email address\.

   1. Choose **Edit** and enter the email address of your resource mailbox to associate to the Alexa for Business room\. 

   1. Choose **Save**\.

1. Say “Alexa, start the meeting” to the Echo device assigned to the room\. Your Echo device automatically dials into your meeting without prompting you for a meeting ID\.

1. To test room booking, say "Alexa, is this room free?" to the Echo device in the room\. Your Echo device returns that the room is booked\.
# Create a Journey<a name="journeys-create"></a>

The Amazon Pinpoint console lets you create powerful journeys through an easy\-to\-use graphical editor\. This section contains information about planning your journey, as well as information about creating your journey by using the Amazon Pinpoint console\.

## Step 1: Configure the Journey<a name="journeys-create-step-1-configure"></a>

The first step in building your journey is to create and configure it\. You can configure the journey to begin immediately, or at a certain date and time\. You can also configure it to end at a specific date and time\.

**To configure a journey**

1. On the **All projects** page, choose the Amazon Pinpoint project that you want to create a journey in\.
**Note**  
In Amazon Pinpoint, segments and endpoints are unique to each project\. The project that you choose should contain the segments and endpoints that you want to engage with this journey\.

1. In the navigation pane, choose **Journeys**\.

1. Choose **Create journey**\. The journey workspace appears\.

1. On the **Actions** menu, choose **Settings**\. The **Journey settings** dialog box appears\. An example of this dialog box is shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-settings.png)

1. In the **Journey settings** dialog box, do the following:

   1. For **Journey title**, enter a name that describes the journey\.

   1. \(Optional\) For **Start date and time** and **End date and time**, enter the dates and times when the journey should start and end, respectively\. If you don't enter a start date, customers enter the journey 5 minutes after you launch it\. If you don't enter an end date, the journey runs continuously for up to 540 days \(approximately 18 months\)\.

   1. \(Optional\) For **Time zone**, choose the time zone that the start date and end date should be based on\. By default, Amazon Pinpoint chooses a time zone from this list based on your location\. You need to complete this step only if you set a start date or end date\.

      Optionally, choose **Use recipient's local time** to use the time zone value in the endpoint record for each participant\. Note, however, that a participant won't be included in the journey if you choose this option and the participant's endpoint record doesn't specify a time zone\.

   1. \(Optional\) Under **Advanced settings**, configure the following settings:
      + **Quiet time settings** – Choose **Override project\-level settings** to override the quiet time settings for the project that contains this journey\. If a message would be sent to a journey participant between the **Start time** and **End time** that you specify, Amazon Pinpoint doesn't attempt to send the message to the participant\.
      + **Maximum daily messages per endpoint** – Choose **Override project\-level setting** to override the maximum daily message setting for the project that contains this journey\. If you specify a value in this section, Amazon Pinpoint limits the number of messages that are sent to each individual endpoint\.
      + **Maximum number of journey messages per second ** – Choose **Override project\-level setting** to override the maximum messages per second setting for the project that contains this journey\. If you specify a value in this section, Amazon Pinpoint limits the number of messages that the journey can send each second\. The value that you specify should be less than or equal to the maximum sending rate for your account\. You can find the maximum sending rate for your account on the [Email settings](settings-email.md) page on the Amazon Pinpoint console\.
      + **Maximum entries per endpoint** – Choose **Override project\-level setting** to override the maximum entry setting for the project that contains this journey\. If you specify a value in this section, Amazon Pinpoint limits the number of times that a participant can enter the journey\. For example, if you specify a value greater than 1, a participant could enter a journey, complete several activities in the journey, arrive at an **End** activity, and start the journey again\. If a participant is eligible for a journey, but they've already entered the journey the maximum number of times, they are prevented from entering the journey again\.

   1. Choose **Save**\.

## Step 2: Set Up the Journey Entry Activity<a name="journeys-create-step-2-set-entry-activity"></a>

Now you can choose the segment that will participate in the journey\. You can optionally configure the **Journey entry** activity to add new journey participants by periodically searching for new segment members\.

**To set up the journey entry activity**

1. Choose the **Journey entry** activity\. The following image shows what the activity looks like when it's selected\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-entry-activity.png)

1. For **Segments**, choose the segment that you want to add to the journey\.
**Tip**  
You can include only one segment in the **Journey entry** activity\. If you need to add more segments, you can create a new segment that includes all of the segments that you want to add to the journey\. Then, later in the journey, you can use a multivariate split activity to divide journey participants into separate groups based on their segment membership\.

1. \(Optional\) For **Specify how often to add new segment members**, choose how often the segment membership should be evaluated\. For example, if you choose **Once every 12 hours**, Amazon Pinpoint checks for new segment members every 12 hours\. If Amazon Pinpoint finds any new segment members during one of these checks, it adds them to the journey\.

1. \(Optional\) For **Description**, enter text that describes the activity\. When you save the activity, this text appears as its label\. 

1. Choose **Save**\.

## Step 3: Add Activities to the Journey<a name="journeys-create-step-3-add-activities"></a>

Activities are the most important parts of any journey\. Activities represent the steps that are applied to journey participants\. You can use activities to send messages to journey participants, or to split them into smaller groups, or to wait for a period of time\. There are several different types of activities that you can add to a journey\. This section provides basic information about adding activities to a journey\. For detailed information about setting up each type of activity, see [Setting Up Journey Activities](#journeys-create-step-3-add-activities-procedures)\.

**To add activities to a journey**

1. Choose **Add activity**\.

1. For **Add an activity**, choose one of the following types of journey activities:
   + **Send email** – When a participant arrives on this type of activity, Amazon Pinpoint sends them an email\. When you create a **Send email** activity, you specify an [email template](message-templates-creating-email.md)\. Email templates can include message variables, helping you to create a more personalized experience\.
   + **Wait** – When a participant arrives on this type of activity, they remain on the activity until a certain date or for a specific amount of time\.
   + **Yes/No split** – Sends customers down one of two paths based on certain criteria\. For example, you can send all customers who read an email down one path, and all other customers down the other path\.
   + **Multivariate split** – Sends customers down one of up to four paths, based on certain criteria\. Customers who don't meet any of the criteria that you define go down an "Else" path\.
   + **Holdout** – Ends the journey for a specified percentage of users\.
   + **Random split** – Randomly sends customers down one of up to five paths\.
**Tip**  
Amazon Pinpoint automatically saves your journey every few minutes, and every time you configure an activity\. The text in the upper right corner of the screen tells you when your journey was last saved\. You can close the journey workspace at any time and return to it later\.

   For procedures for setting up each of these types of activities, see [Setting Up Journey Activities](#journeys-create-step-3-add-activities-procedures)\.

### Setting Up Journey Activities<a name="journeys-create-step-3-add-activities-procedures"></a>

Each type of journey activity has separate components that you have to configure\. The following sections provide additional information about setting up each type of activity\.

#### Set Up an Email Activity<a name="journeys-create-step-3-add-activities-procedures-email"></a>

When a journey participant arrives on a **Send email** activity, Amazon Pinpoint sends them an email immediately\. Before you can configure an email activity, you have to create an email template\. For more information about creating email templates, see [Creating Email Templates](message-templates-creating-email.md)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-email-activity.png)

**To set up an email activity**

1. Choose the **Send email** activity that you want to configure\.

1. For **Choose an email template**, choose the email template for the message that you want participants to receive\. Then, under **Template version**, specify whether you want Amazon Pinpoint to automatically update the message to include any changes that you might make to the template before the message is sent\. To learn more about these options, see [Managing Versions of Message Templates](message-templates-versioning.md)\.
**Tip**  
You can send yourself a preview of the message, even if your Amazon Pinpoint account doesn't contain an endpoint record for your email address\. To send a preview, choose **Send a test message**\.

1. For **Sender email address**, choose the email address that you want to send the message from\. This list contains all the verified email addresses for your Amazon Pinpoint account in the current AWS Region\. For information about verifying additional email addresses or domains, see [Verifying Email Identities](channels-email-manage-verify.md)\.
**Tip**  
To display a friendly sender name for the message, choose the default email address for the project\. A *friendly sender name* is the name that appears in participants' email clients when they receive the message\. To change the default email address for the project or the friendly sender name for that address, update the project's settings for the email channel\. To do this, choose **Settings** in the left navigation pane, and then choose **Email**\. Then, enter the settings that you want\.

1. \(Optional\) For **Description**, enter text that describes the purpose of the activity\. When you save the activity, this text appears as its label\.

1. When you finish, choose **Save**\.

#### Set Up a Wait Activity<a name="journeys-create-step-3-add-activities-procedures-wait"></a>

When a journey participant arrives on a **Wait** activity, they remain on that activity for a certain period of time or until a specific date and time\. This type of activity is a useful way to schedule the sending of time\-sensitive communications, or to give customers time to interact with messages that you sent earlier in the journey\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-wait-activity.png)

**To set up a wait activity**

1. Choose the **Wait** activity that you want to configure\.

1. Choose one of the following options:
   + **For a period of time** – Choose this option if you want journey participants to remain on this activity for a certain amount of time\. Then, enter the amount of time that you want journey participants to wait on this activity before they proceed to the next activity\. You can specify a value that's as short as 1 hour or as long as 365 days\.
   + **Until a specific date** – Choose this option if you want journey participants to remain on this activity until a specific date and time\. Then, enter the date and time when journey participants should move to the next activity\. You can choose any date and time that precedes the end date of the journey\.

1. \(Optional\) For **Description**, enter text that describes the purpose of the activity\. When you save the activity, this text appears as its label\.

1. When you finish, choose **Save**\.

#### Set Up a Yes/No Split Activity<a name="journeys-create-step-3-add-activities-procedures-yes-no-split"></a>

When journey participants arrive on a **Yes/No split** activity, they're sent down one of two paths based on their attributes or behaviors\. You can use this type of split activity to send journey participants down separate paths based on their membership in a segment\. You can also send participants down separate paths based on their interactions with other journey activities\. For example, you can divide journey participants based on whether they opened an email that was sent earlier in the journey\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-yes-no-split-activity.png)

**To set up a yes/no split activity**

1. Choose the **Yes/No split** activity that you want to configure\.

1. For **Select a condition type**, choose one of the following options:
   + **Segment** – Choose this option to send all members of the chosen segment down the "Yes" path\. Then, for **Segments**, choose a segment\.
   + **Event** – Choose this option to send users down the "Yes" path based on their interactions with a previous step in this journey\. Then, complete the following steps:

     1. For **Events**, choose one of the following options:
        + **Email send** – Amazon Pinpoint accepted the message and will attempt to deliver it\.
        + **Email delivered** – The message was successfully delivered to the recipient\.
        + **Email rejected** – Amazon Pinpoint rejected the message because it contained a virus or malware\.
        + **Email hard bounce** – The email wasn't delivered to the recipient because of a permanent issue\. For example, the recipient's email address might not exist anymore\. When a message generates a hard bounce, Amazon Pinpoint doesn't attempt to re\-deliver it\.
        + **Email soft bounce** – The email wasn't delivered to the recipient because of a temporary issue\. For example, the recipient's inbox could be full, or their email provider might be experiencing a temporary issue\. When a soft bounce occurs, Amazon Pinpoint attempts to re\-deliver the message for a certain period of time\. If the message still can't be delivered, the message becomes a hard bounce\.
        + **Email complaint** – The recipient received the email, but used the "Report spam" or similar button in their email client to report the message as unwanted\.
**Note**  
Amazon Pinpoint relies on complaint reports from email providers to generate complaint events\. Some email providers give us these reports on a regular basis, while others send them infrequently\.
        + **Email open** – The recipient received the email and opened it\.
**Note**  
For Amazon Pinpoint to capture an **Email open** event, the recipient's email client has to download the images contained in the message\. Many common email clients, such as Microsoft Outlook, don't download email images by default\.
        + **Email click** – The recipient received the email and followed one of the links contained in the body of the message\.
        + **Email unsubscribe** – The recipient received the email and used the "Unsubscribe" link to opt out of future messages\.

     1. For **Choose an activity**, choose the activity that the split should be applied to\.

1. For **Condition evaluation**, choose when Amazon Pinpoint should evaluate the condition\. You can choose from the following options:
   + **Evaluate immediately** – If you choose this option, Amazon Pinpoint checks to see if the event condition that you specified has been met the moment when the journey participant arrives on the activity\.
   + **Evaluate after** – If you choose this option, Amazon Pinpoint waits for a specified period of time\. After the specified period of time has elapsed, Amazon Pinpoint checks to see if the event condition that you specified has been met\.
   + **Evaluate on** – If you choose this option, Amazon Pinpoint waits until a specific date and time\. When that date and time arrives, Amazon Pinpoint checks to see if the event condition that you specified has been met\.

1. \(Optional\) For **Description**, enter text that describes the purpose of the activity\. When you save the activity, this text appears as its label\.

1. When you finish, choose **Save**\.

#### Set Up a Multivariate Split Activity<a name="journeys-create-step-3-add-activities-procedures-multivariate-split"></a>

When journey participants arrive on a **Multivariate split** activity, they're sent down one of several paths based on their attributes or behaviors\. This type of split is similar to a yes/no split\. The advantage of using a multivariate split activity is that it can evaluate more than one condition\. Additionally, every multivariate split activity contains an "Else" path\. Journey participants who don't meet any of the conditions that you specified in other paths are automatically sent down the "Else" path\.

You can use this type of split to send journey participants down separate paths based on their membership in a segment\. You can also send participants down separate paths based on their interactions with other journey activities\. For example, you can divide journey participants based on whether they opened an email that was sent earlier in the journey\.

**Note**  
If a journey participant meets more than one condition in a conditional split, they are sent down the first condition that they meet, in alphabetical order\. For example, if a participant meets the conditions in Branch A and Branch D, they're sent down the path that corresponds with Branch A\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-multivariate-split-activity.png)

**To set up a multivariate split activity**

1. Choose the **Multivariate split** activity that you want to configure\.

1. Determine how many different paths \(branches\) you want to create\. Choose **Add another branch** to create additional paths\.

1. On each branch, for **Select a condition type**, choose one of the following options:
   + **Segment** – Choose this option to send all members of the chosen segment down the path\. Then, for **Segments**, choose a segment\.
   + **Event** – Choose this option to send users down the path based on their interactions with a previous step in this journey\. Then, complete the following steps:

     1. For **Events**, choose one of the following options:
        + **Email send** – Amazon Pinpoint accepted the message and will attempt to deliver it\.
        + **Email delivered** – The message was successfully delivered to the recipient\.
        + **Email rejected** – Amazon Pinpoint rejected the message because it contained a virus or malware\.
        + **Email hard bounce** – The email wasn't delivered to the recipient because of a permanent issue\. For example, the recipient's email address might not exist anymore\. When a message generates a hard bounce, Amazon Pinpoint doesn't attempt to re\-deliver it\.
        + **Email soft bounce** – The email wasn't delivered to the recipient because of a temporary issue\. For example, the recipient's inbox could be full, or their email provider might be experiencing a temporary issue\. When a soft bounce occurs, Amazon Pinpoint attempts to re\-deliver the message for a certain period of time\. If the message still can't be delivered, the message becomes a hard bounce\.
        + **Email complaint** – The recipient received the email, but used the "Report spam" or similar button in their email client to report the message as unwanted\.
**Note**  
Amazon Pinpoint relies on complaint reports from email providers to generate complaint events\. Some email providers give us these reports on a regular basis, while others send them infrequently\.
        + **Email open** – The recipient received the email and opened it\.
**Note**  
For Amazon Pinpoint to capture an **Email open** event, the recipient's email client has to download the images contained in the message\. Many common email clients, such as Microsoft Outlook, don't download email images by default\.
        + **Email click** – The recipient received the email and followed one of the links contained in the body of the message\.
        + **Email unsubscribe** – The recipient received the email and used the "Unsubscribe" link to opt out of future messages\.

     1. For **Choose an activity**, choose the activity that the split should be applied to\.

   Repeat this step for each path in the activity\.

1. For **Condition evaluation**, choose when Amazon Pinpoint should evaluate the condition\. You can choose from the following options:
   + **Evaluate immediately** – If you choose this option, Amazon Pinpoint checks to see if the event condition that you specified has been met at the moment the journey participant arrives on the activity\.
   + **Evaluate after** – If you choose this option, Amazon Pinpoint waits for a specified period of time\. After the specified period of time has elapsed, Amazon Pinpoint checks to see if the event condition that you specified has been met\.
   + **Evaluate on** – If you choose this option, Amazon Pinpoint waits until a specific date and time\. When that date and time arrives, Amazon Pinpoint checks to see if the event condition that you specified has been met\.

1. \(Optional\) For **Description**, enter text that describes the purpose of the activity\. When you save the activity, this text appears as its label\.

1. When you finish, choose **Save**\.

#### Set Up a Holdout Activity<a name="journeys-create-step-3-add-activities-procedures-holdout"></a>

When journey participants arrive on a **Holdout** activity, the journey ends for a random selection of participants\. You can specify the percentage of total journey participants who are held out\. Holdout activities can help you measure the impact of a journey by creating a control group that doesn't receive your messages\. When a journey finishes running, you can compare the behaviors of the users who participated in the journey against those who were part of the control group\.

**Note**  
Amazon Pinpoint uses a probability\-based algorithm to determine which journey participants are held out\. The percentage of journey participants who are held out will be very close to the percentage that you specify, but it might not be perfectly equal\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-holdout-activity.png)

**To set up a holdout activity**

1. Choose the **Holdout** activity that you want to configure\.

1. For **Holdout percentage**, enter the percentage of journey participants who should be prevented from proceeding to the next activity in the journey\.

1. \(Optional\) For **Description**, enter text that describes the purpose of the activity\. When you save the activity, this text appears as its label\.

1. When you finish, choose **Save**\.

#### Set Up a Random Split Activity<a name="journeys-create-step-3-add-activities-procedures-random-split"></a>

When journey participants arrive on a **Random split** activity, they're randomly sent down one of up to five paths\. You can create two to five separate paths for this type of activity\. This type of activity is useful when you want to measure the effectiveness of different message variants\.

**Note**  
Amazon Pinpoint uses a probability\-based algorithm to determine which journey participants are sent down each path in a random split activity\. The percentages of journey participants who are sent down each path will be very close to the percentages that you specify, but they might not be perfectly equal\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/journeys-random-split-activity.png)

**To set up a random split activity**

1. Choose the **Random split** activity that you want to configure\.

1. Determine how many different paths \(branches\) you want to create\. Choose **Add another branch** to create each additional path\.

1. In the field next to each branch, enter the percentage of journey participants who should be sent down that branch\. The values that you specify have to be positive numbers, and they can't contain decimals\. The sum of the values that you enter across all branches has to equal exactly 100%\.

1. \(Optional\) For **Description**, enter text that describes the purpose of the activity\. When you save the activity, this text appears as its label\.

1. When you finish, choose **Save**\.

**Next**: [Review and Test a Journey](journeys-review-test.md)
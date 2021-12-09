# Signing in to the Amazon WorkMail web client<a name="web-client"></a>

Amazon WorkMail has a web\-based client that you use to access your Amazon WorkMail account from a web browser\. The Amazon WorkMail web client includes integrated applications, such as Mail, Calendar, and Contacts\. To get started with the Amazon WorkMail web client, you need a broadband internet connection and the latest version of one of the following web browsers:
+ Google Chrome
+ Mozilla Firefox
+ Safari
+ Microsoft Edge

Your Amazon WorkMail system administrator provides you with your initial sign\-in credentials, which consist of a user name and a password\. To recover a lost or forgotten password, contact your administrator\.

Your administrator also provides you with a unique Amazon WorkMail web client URL\. This URL contains a unique alias set up by your Amazon WorkMail site administrator\. The web client URL looks like this: `https://alias.awsapps.com/mail`\. Replace `alias` with the alias you received from your site administrator\.

**To sign in to the Amazon WorkMail web client**

1. In your web browser, enter the web client URL provided by your Amazon WorkMail administrator\. For example, `https://alias.awsapps.com/mail`\.

1. For **Username**, enter the user name provided by your Amazon WorkMail administrator\.
**Note**  
Do not enter your full email address\. User names are case\-sensitive\.

1. For **Password**, enter your password\.

1. Choose **Sign In**\.

## Changing Amazon WorkMail web client settings<a name="settings_overview"></a>

You can change many of the default settings for the Amazon WorkMail web client\.

**To change the Amazon WorkMail web client settings**

1. In the Amazon WorkMail web client, on the menu bar, choose **Settings** \(gear icon\)\.

1. In the navigation pane, select the **General** tab, **Email** tab, **Email Rules** tab, **Automatic response** tab, or **Calendar** tab to update the settings as appropriate\.

1. Press the **F5** key to refresh and activate the new settings\.

For more information about changing specific settings, see the following topics\.

## General settings<a name="general_tab"></a>

View mailbox usage and set your password, preferred language, and default address book from the **General** tab using the following settings\.

****Change password****  
To change your password, choose **Change password**, and then follow the instructions on the screen\.  
If Amazon WorkMail is integrated with your corporate directory, you might have to change your password using Microsoft Windows or corporate password management tools\.

****Language****  
To change the language in which Amazon WorkMail is displayed, select a language from the list\. To change your date format and time format, select a format from the list\.

****Mailbox Usage****  
Shows the current amount of storage space used\. To reduce your mailbox size you can empty the **Deleted Items** folder, delete older messages, or delete messages with large attachments from your folders\.

****Address Book****  
To select a default address book, in **Select Default Folder**, select the address book to use\.  
The default address book is loaded when choosing **Address book** from the main menu bar or when selecting the To, Cc, or Bcc field when composing a new email\.

## Email settings<a name="email_tab"></a>

Change email preview, formatting, font, and other options from the **Email** tab using the following settings\.

****Display preview pane****  
You can choose to view a preview of items to the right of the content pane or below the content pane\. You can also choose to turn off the preview pane\.  
Changing the view from the mail application using the **View** menu updates this **Display preview pane** setting\.

****Close email when responding****  
When this setting is off, if you open an email message in a new tab, a new tab is opened next to the existing one when you reply to the email message\.

****Format****  
You can compose new mail messages as **Plain text** or **HTML**\.

****Default font****  
Specifies the default font used in all new email messages\.

****Default font size****  
Specifies the size of the default font\.

****Always request a read receipt****  
Select this check box to automatically request read receipts for every email message you send\.

****Respond to read receipt****  
Select whether Amazon WorkMail should always send a read receipt, never send a read receipt, or whether you should be prompted before sending a read receipt\.

****Signatures****  
You can create several signatures for different purposes\. For example, you can create a signature for business and one for private use, or create a long signature for new email messages and a short signature for replies and forwards\.  
After you have created one or more signatures, you can \(optionally\) specify which one to use for new email messages and which one to use for replies and forwards\.

## Email rules settings<a name="email_filters_tab"></a>

Email rules can help you focus on important email messages and keep your inbox tidy\. Rules are stored on the server so that they can filter the mail before it arrives in your inbox\.

You can create as many rules as you want and with each rule, you can set various conditions to trigger the rule\. You can also set various follow\-up actions after the rule has been triggered\.

You can construct complex rules to deal with large email volumes or complex workflows\.

**To create a new email rule**

1. From the **Email Rules** tab, choose **New**\.

1. In the **New email rule** dialog box, define the rule\.

You can set various conditions and actions that Amazon WorkMail performs on every email message that meets the criteria you define\.

## Automatic response settings<a name="automatic_response_tab"></a>

Mark yourself in or out of the office from the **Automatic Response** tab\. Specify the message that is sent automatically in reply to all incoming messages while you are away\.

To prevent someone who is sending you several email messages per day from getting a reply on each message, automatic responses are only sent one time to any specific email address\. This also prevents a mail flood in case the person who sends you the email message also has automatic responses turned on\.

When **Automatic response** is enabled, and you sign on to the Amazon WorkMail web client, a warning message is shown to remind you that the **Automatic response** is set\. The warming message prompts you to turn it off\.

## Calendar settings<a name="calendar_tab"></a>

Set your calendar format, default reminder time, and other options using the following settings\.

****First day of the week****  
If your week starts on another day than Monday, you can set it to any other day using this setting\. The calendar then always starts with this day\.

****First week of the year****  
Specify how the calendar should begin the year\.

****Start of workday**, **End of workday****  
Specify the part of the day that is marked as your workday\. The calendar shows this time period in a slightly different color so you can easily see when an appointment or meeting is scheduled outside office hours\. The default values for office hours are 8:30 \- 17:30 \(8:30 AM \- 5:30 PM\)\.

****Calendar resolution****  
If your appointments frequently start at other times than each half or entire hour, or have a duration other than \(multiples of\) 30 minutes, then you can change this value to better fit your needs\.  
Setting the value to less than 30 minutes makes the Amazon WorkMail web application zoom in on the calendar, so you scroll more when you are using a smaller screen\.

****View multiple calendars****  
Specify how multiple calendars should be displayed by default in the Calendar\. **Side\-by\-side** displays all calendars next to each other\. **Overlay** displays all calendars transparently on top of each other, where each calendar has its own color\.  
This setting has no effect when you are only displaying one calendar\.

****Default reminder time****  
Specify how long before the start of the appointment the default reminder should occur\. This setting can be overruled for any appointment by editing it manually in the calendar\. The default is 15 minutes\.

****Default all\-day appointment reminder time****  
Specify the reminder time that is automatically set when you create a new all\-day appointment\. The default is 18 hours\. This setting can be overruled for any appointment by editing it manually in the calendar\.
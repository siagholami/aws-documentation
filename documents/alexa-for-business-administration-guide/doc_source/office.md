# Link Alexa for Business to Office 365<a name="office"></a>

There are two methods to link Alexa for Business to your Office 365 account\. 

Use Method 1 to link your Office 365 account by using a service account that has permissions to read and write to your room calendars\. This method provides you with more control over the calendar resources that Alexa for Business can access\. 

Use Method 2 to use application permissions and set up the calendar only once\. Then you won't need to update permissions when you add Alexa to more rooms\. You must sign in as a global administrator user to link your Office 365 account to Alexa for Business\.

## Method 1: Link with Delegate Permissions \(Recommended\)<a name="office-delegate"></a>

**To link with delegate permissions**

1. Create a service account for Alexa for Business in your Office 365 tenant:

   1. Sign into Office 365 as an administrator\.

   1. Add a user in your Office 365 account that will use a service account\. For more information, see [Add users individually or in bulk to Office 365](https://support.office.com/en-us/article/add-users-individually-or-in-bulk-to-office-365-admin-help-1970f7d6-03b5-442f-b385-5880b9c256ec?CorrelationId=8d4aa47b-49a9-48ad-87fc-dcd9a595f28c&ui=en-US&rs=en-US&ad=US)\.

      For example, if your domain is "mycompany\.com" and you add a user with the user name of "alexaforbusiness," the email address is "alexaforbusiness@mycompany\.com"\.

1. Open PowerShell and connect to Exchange Online\. For more information, see [Connect to Exchange Online PowerShell](https://docs.microsoft.com/en-us/powershell/exchange/exchange-online/connect-to-exchange-online-powershell/connect-to-exchange-online-powershell?view=exchange-ps)\. 

1. Run the following PowerShell command to create a service account with access to the calendars in your organization:

   `New-Mailbox -UserPrincipalName alexaforbusiness@your_domain -Alias “AlexaforBusiness” -Name alexaforbusiness -f Users -FirstName Alexa -LastName “Service Account” -DisplayName "Alexa for Business Service Account"`
**Note**  
Make sure that "your\_domain" is the domain of your organization, and enter your password when prompted\.

1. To look up meeting dial\-in information from your resource mailboxes, configure them to include descriptions\. Run one of the following commands to keep the descriptions in the meeting invites of your resource mailboxes:

   For a single room mailbox:

   `Set-CalendarProcessing “<room name>” -DeleteComments $FALSE` 

   For all room mailboxes:

   `Get-Mailbox -ResultSize unlimited -RecipientTypeDetails “RoomMailbox” | Set-CalendarProcessing -DeleteComments $FALSE`

1. Run one of the following commands to give the service account permissions to access the room calendars in your organization:

   For a single room mailbox:

   `Add-MailboxFolderPermission <room name>:\Calendar -User alexaforbusiness -AccessRights Editor` 

   For all room mailboxes:

   `Get-Mailbox -ResultSize unlimited -RecipientTypeDetails “RoomMailbox” | ForEach-Object {Add-MailboxFolderPermission $_":\calendar" -user alexaforbusiness -AccessRights Editor}`

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Calendar**, **Office 365**\.

1. Choose **Service account using delegate access** and **Link account**, sign in with the service account you created in step 4, and accept the user consent\.

Now you can associate the email address of your resource mailboxes with your rooms in Alexa for Business\.

**To complete room setup**

1. Associate the email address of your resource mailboxes in Office 365 to your Alexa for Business rooms\. 

   1. In the Alexa for Business console, choose **Rooms** and choose the room to which to add the email address\.

   1. Choose **Edit** and enter the email address of your resource mailbox to associate to the Alexa for Business room\. 

   1. Choose **Save**\.

1. Test the calendar integration\. 

   1. Create a new meeting invite in your Microsoft Outlook client\.

   1. Add the room as the resource, add meeting dial\-in information to your meeting invite, and send the invite to book the room\. 

   1. Say “Alexa, start my meeting” to the Echo device assigned to the room\. Your Echo device automatically dials into your meeting without prompting you for a meeting ID\.

   1. To test room booking, say "Alexa, is this room free?" to the Echo device in the room\. 

## Method 2: Link with Application Permissions<a name="office-application"></a>

**To link with application permissions**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Calendar**, **Office 365**\.

1. Choose **Application permissions** and **Link account**, then sign in with the Office 365 account that belongs to the Global Administrators group\.

1. Give consent that Alexa for Business has read and write access to the calendars in your Office 365 organization\.

**To complete room setup**

1. Associate the email address of your resource mailboxes in Office 365 to your Alexa for Business rooms\. 

   1. In the Alexa for Business console, choose **Rooms** and choose the room to which to add the email address\.

   1. Choose **Edit** and enter the email address of your resource mailbox to associate to the Alexa for Business room\. 

   1. Choose **Save**\.

1. Test the calendar integration\. 

   1. Create a new meeting invite in your Microsoft Outlook client\.

   1. Add the room as the resource, add meeting dial\-in information to your meeting invite, and send the invite to book the room\. 

   1. Say “Alexa, start my meeting” to the Echo device assigned to the room\.

Your Echo device automatically dials into your meeting without prompting you for a meeting ID\. 
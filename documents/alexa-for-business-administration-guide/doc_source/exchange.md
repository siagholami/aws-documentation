# Link Alexa for Business to Microsoft Exchange<a name="exchange"></a>

**To link Alexa for Business to Microsoft Exchange**

1. Before you proceed, confirm that you meet the following requirements:
   + You have an administrator account within your Microsoft Exchange server\.
   + Microsoft Exchange is version 2013\.
   + You have a valid Exchange Web Services \(EWS\) endpoint with a valid digital certificate purchased from a trusted public certificate authority \(CA\)\.
   + You have basic authentication enabled on your Exchange Web Servers \(EWS\) endpoint\.

1. Verify that basic authentication is enabled:

   1. Open Microsoft Exchange Management Shell\.

   1. Type **Get\-WebServicesVirtualDirectory \| fl**\.

   1. Verify that the parameter** BasicAuthentication** is set to **True**\.

1. If basic authentication isn't enabled, run the following command to enable it:

   `Set-WebServicesVirtualDirectory -Identity "Contoso\EWS(Default Web Site)" -BasicAuthentication $true`
**Note**  
Contoso\\EWS\(Default Web Site\) is the identity of the Microsoft Exchange Web Services virtual directory\.

1. Create a service account with access to the calendars in your organization\.

   1. Open the Exchange Management Shell\.

   1. Run the following command to create the service account\.

      `New-Mailbox -UserPrincipalName alexaforbusiness@your_domain -Alias Alexa for Business -Name alexaforbusiness -OrganizationalUnit Users -FirstName Alexa -LastName Service Account -DisplayName "Alexa for Business Service Account"`
**Note**  
Make sure that `your_domain` is the domain of your organization\. You are prompted to enter a password\.

1. To look up meeting dial\-in information from your resource mailboxes, configure them to include descriptions:

   1. Run one of the following commands to keep the descriptions in the meeting invites of your resource mailboxes:

     For a single room mailbox:

     `Set-CalendarProcessing <room name> -DeleteComments $FALSE`

     For all room mailboxes:

     `Get-Mailbox -ResultSize unlimited -RecipientTypeDetails 'RoomMailbox' | Set-CalendarProcessing -DeleteComments $FALSE`

1. Set up permissions\. The service account must have permissions to access the room calendars in your organization\. Run one of the following commands to give the service account access to your room resource mailboxes:

   For a single room mailbox:

   `Add-MailboxFolderPermission <room name>:\Calendar -User alexaforbusiness -AccessRights Editor`

   For all room mailboxes:

   `Get-Mailbox -ResultSize unlimited -RecipientTypeDetails 'RoomMailbox' | ForEach-Object {Add-MailboxFolderPermission $_":\calendar" -user alexaforbusiness -AccessRights Editor}`

1. Link the service account to Alexa for Business\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Calendar**, **Microsoft Exchange**\.

   1. Enter the user principal name \(UPN\) of your service account\.

   1. Enter the service account password\.

   1. Enter the URL of your EWS endpoint\. The default URL for EWS is usually in the following format: https://mail\.domain\.com/EWS/Exchange\.asmx\.

   1. For **Access method**, select **Delegation**\.

   1. Choose **Link account**\.

1. Associate the email address of your resource mailboxes in Microsoft Exchange to your Alexa for Business rooms\.

   1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

   1. Choose **Rooms** and choose the room to which to add the email address\.

   1. Choose **Edit**\.

   1. Enter the email address of your resource mailbox that you want to associate to the Alexa for Business room\.

   1. Choose **Save**\.

1. Test the integration\.

   1. Create a new meeting invite in your Microsoft Outlook client\.

   1. Add the room as the resource\.

   1. Add meeting dial\-in information to your meeting invite\.

   1. Send the invite to book the room\.

   1. Say “Alexa, start my meeting” to the Echo device assigned to the room\. Your Echo device prompts you to join the scheduled meeting without asking you for the meeting ID\.

   1. Say, “Alexa, is this room free?” to the Echo device assigned to the room\. Your Echo device returns that the room is booked\.
# Set up Microsoft Exchange Access for Users<a name="connect-exchange"></a>

You can link Alexa for Business to your Microsoft Exchange server\. This enables enrolled users to ask Alexa about their scheduled events or add new events to their Microsoft Exchange calendar\.

To give enrolled users access to their Microsoft Exchange calendar, set up a service account on your Microsoft Exchange server to access the users' calendars\. After the service account is set up, users can link Alexa to their Microsoft Exchange using the Alexa app\.

If you already set up a service account to access your room calendars, skip to step 3 and give the service account permissions to your users' calendars\.

Before your proceed, confirm that you meet the following requirements:
+ You have an administrator account within your Microsoft Exchange server\.
+ Microsoft Exchange is version 2013 or higher\.
+ You have a valid Exchange Web Services \(EWS\) endpoint with a valid digital certificate purchased from a trusted public certificate authority \(CA\)\.
+ Basic authentication is enabled on both your EWS endpoint\.

**To verify that basic authentication is enabled**

1. Open the Exchange Management Shell\.

1. Type **Get\-WebServicesVirtualDirectory \| fl**\.

1. Verify that the parameter `BasicAuthentication` is set to `True`\.

1. If basic authentication isn't enabled, run the following command to enable it:

   `Set-WebServicesVirtualDirectory -Identity "Contoso\EWS(Default Web Site)" -BasicAuthentication $true`
**Note**  
Contoso\\EWS\(Default Web Site\) is the identity of the EWS virtual directory\.

**To create a service account with access to the calendars in your organization**

1. Open the Exchange Management Shell\.

1. Run the following command to create the service account: `New-Mailbox -UserPrincipalName alexaforbusiness@your_domain -Alias Alexa for Business -Name alexaforbusiness -OrganizationalUnit Users -FirstName Alexa -LastName Service Account -DisplayName "Alexa for Business Service Account"`
**Note**  
Make sure that "your\_domain" is the domain of your organization\. You are prompted to enter a password\.

The service account must have permissions to access the calendars in your organization\. You can enable service account access to the calendars in your organization by using one of the following two methods:
+ Set up impersonation, which enables the service account to impersonate a given account so that it can perform all operations using the permissions associated with the given account\.
+ Add the service account as full access and send as permissions for each of your user mailboxes\. 

**To set up impersonation**

1. Open the Exchange Management Shell and run the following command:

   `New-ManagementRoleAssignment –name:impersonationAssignmentName –Role:ApplicationImpersonation –User: alexaforbusiness` 

1. To limit the service account, define the scope\. For example, to only give the service account permissions to the room mailboxes in the organization, run the following command in Exchange Management Shell:

   `New-ManagementScope -Name "UserMailboxes" -RecipientRestrictionFilter {RecipientTypeDetails -eq "UserMailbox"}`

1. To apply permissions to the service account, run the following command:

   `New-ManagementRoleAssignment –Name "ResourceImpersonation" –Role ApplicationImpersonation –User alexaforbusiness –CustomRecipientWriteScope "UserMailboxes"`

**To add the service account as full access**
+ Run one of the following commands to give the service account access to all user mailboxes:

  For a single user:

  `Add-MailboxFolderPermission <username>:\Calendar -user alexaforbusiness -accessrights Editor`

  `Add-ADPermission -Identity <username> –User alexaforbusiness -Extendedrights "Send As`"
**Note**  
Replace `<username>` with the alias of your user\.

  For all user mailboxes:

  `$users = Get-Mailbox -ResultSize unlimited -RecipientTypeDetails UserMailbox | Select -ExpandProperty Name Foreach ($user in $users) { Add-MailboxFolderPermission -Identity $user":\Calendar" -user alexaforbusiness -accessrights Editor Add-ADPermission -Identity $user –User alexaforbusiness -Extendedrights "Send As" }`

**To link the service account to Alexa for Business**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Calendar**, **Microsoft Exchange**\.

1. Enter the user principal name \(UPN\) of your service account and service account password\.

1. Enter the URL of your EWS endpoint\. The default URL for EWS is usually in the following format: https://mail\.domain\.com/EWS/Exchange\.asmx\.

1. Select the access method that you have set up and choose **Link account**\.

**To test integration to access the calendar of an enrolled user**

1. Open the Alexa app as an enrolled user\.

1. Choose **Settings**, **Calendar**\.

1. Choose **Microsoft Exchange** and complete the required steps\.

Alexa can now read back the upcoming events on the calendar\. 

**To troubleshoot Microsoft Exchange access**
+ If you experience one of the following issues, follow these steps:
  + If account linking fails in the Alexa app, verify that the email address you invited the user with matches the email address in your Microsoft Exchange server\. Also, make sure that basic authentication is enabled for your EWS endpoint\.
  + If setting up the Microsoft Exchange account fails in Alexa for Business and you see the error message "The calendar account could not be linked\. If the issue persists, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\. Invalid parameter provided\.”, validate that your EWS endpoint is valid and remotely accessible\. 

**To test the EWS endpoint connection and service account credentials**

1. Open the [Microsoft Remote Connectivity Analyzer](https://testconnectivity.microsoft.com)\. 

1. On the **Exchange Server** tab, choose **Service account access**\.

1. Follow the prompts, fill in the required information, and verify that the service is working correctly\.

1. If you receive one of the following results, follow these steps:
   + If the tool fails, the issue is probably your setup\. Verify the following:
     + You're using the EWS endpoint instead of the OWA endpoint\. EWS endpoints are usually formatted as: https://mail\.domain\.com/EWS/Exchange\.asmx
     + The service account and password are correct\.
     + You're using Microsoft Exchange 2013 or higher\. 
     + Your EWS endpoint is reachable from the internet\.
   + If the tool succeeds, but associating the account still fails in the Alexa for Business console, verify that you have entered the right credentials in the console\. 
   + If the issue persists, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.

**To manage expiring service account passwords**

1. Create a new user principal name \(UPN\) service account and password\.

1. Ensure that the new UPN service account has access to calendars, impersonation, and full access\.

1. Validate that the new account works by testing the EWS endpoint and UPN\.

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Calendar**, **Microsoft Exchange**\. 

1. Enter the new user principal name \(UPN\) of the service account that you just created\.

1. Enter the service account password for the new UPN, and choose **Link account**\.

**Expiring password notifications**  
Alexa for Business sends warning emails to the service account holder at 14 days, 7 days, 3 days, and 1 day before their password expires\. After the password expires, the user receives a daily reminder email\. Users can also see these alerts in their AWS [Personal Health Dashboard](https://phd.aws.amazon.com/phd/home#/dashboard)\.
# Configure availability settings on Amazon WorkMail<a name="enable_interop_wm"></a>

Configure availability settings on Amazon WorkMail and Microsoft Exchange to enable bidirectional sharing of calendar free/busy information\.

**To configure availability settings in the console**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. In the navigation panel, choose **Organization settings**, **Interoperability Settings**\.

1. Choose **Configure availability settings** and provide the following information: 
+ **Domain**—The domain for which to set interoperability between Amazon WorkMail and Microsoft Exchange\.
+ **Exchange Web Services \(EWS\) URL**—The URL to which Amazon WorkMail sends HTTPS requests to access calendar free/busy information of users on Microsoft Exchange\. The EWS URL usually looks like the following: **https://*servername*\.com/EWS/Exchange\.asmx**\. You can obtain the EWS URL in one of the following ways:
  + 

**Using Microsoft Outlook**

    1. Log in to Microsoft Outlook on Windows for any user on your Exchange environment\.

    1. Hold the **Ctrl** key and open the context \(right\-click\) menu on the Microsoft Outlook icon in the task bar\.

    1. Choose **Test E\-mail AutoConfiguration**\.

    1. Enter the Microsoft Exchange user’s email address and password, and choose **Test**\.

    1. From the Results window, copy the value for the **Availability Service URL**\.
  + 

**Using PowerShell**
    + 

      ```
      Get-WebServicesVirtualDirectory |Select name, *url* | fl
      ```

    The external URL returned by the above command is the EWS URL\.
+ **User email address and password**—These are the credentials of the Microsoft Exchange service account and are encrypted and securely stored by Amazon WorkMail\. The email address of the Microsoft Exchange service account should use the Fully Qualified Domain Name \(FQDN\)\. For more information, see [Create service accounts in Microsoft Exchange and Amazon WorkMail](interoperability.md#create-serviceacct)\.

  If your Active Directory domain is not the same as your Microsoft Exchange domain, use the User Principal Name \(UPN\) of the Microsoft Exchange Service account\. This can be obtained with the following PowerShell command:

  ```
  Get-ADUser exchange_service_account_username | select UserPrincipalName
  ```

  In the above example, **exchange\_service\_account\_username** is the username of the Microsoft Exchange Service account\.
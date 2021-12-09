# Sending encrypted or signed email<a name="send_encrypted_email"></a>

With S/MIME, you can send signed or encrypted emails inside and outside of your organization\. After you configure S/MIME in the email client settings, all emails that you send are automatically signed\. Encryption options depend on different email clients and respective platforms\. The Amazon WorkMail web app client is not supported\.

**Note**  
AWS Certificate Manager does not currently provide certificates to sign and encrypt email\. Get the certificate \(`*.p12`\) file from your administrator or a third\-party certificate authority\.

**To configure S/MIME in Windows Outlook**

1. Get the certificate \(`*.p12`\) file from your administrator or third\-party certificate authority and save it to a folder\.

1. Right\-click the file and choose **Install PFX**\.

1. Choose **Current User**, **Next**, select the `*.p12` file, and then choose **Next**\.

1. Enter the password and choose **Next**\.

1. Make sure that **Automatically select the certificate store** is selected and choose **Next**\.

1. Choose **Finish**\. 

1. Perform the following steps in Windows Outlook:

   1. Choose **File**, **Options**, **Trust Center**, **Trust Center Settings**, **Email Security**, and **Settings**\.

   1. In the **Change Email Security** dialog box, choose **Choose** and select the installed certificate\.

   1. Choose **OK**, select one or all applicable options, and choose **OK**\.

1. If all email recipients have certificates in the Global Address List \(GAL\) or Contacts, then all emails sent are automatically encrypted\. Otherwise, you receive a warning message and can decide to send an unencrypted message or cancel\.

**To configure S/MIME in iOS Mail**

1. Get the certificate \(`*.p12`\) file from your administrator or third\-party certificate authority in an email\.

1. Open the email attachment and choose **Install**\.

1. Enter the PIN and follow the instructions\.

1. Choose **Settings**, **Mail**, **Accounts**, select your account, and then choose **Account**, **Advanced Settings**\.

1. Enable S/MIME and choose one or both of the options to sign or encrypt emails\. If you chose **Encrypt by Default**, then all emails sent are automatically encrypted\. 

1. When you type an email address in the **To** field, iOS loads the user certificate from the Global Address List \(GAL\) or from Contacts\. If the certificate is not found, then the red unlocked icon means that the email can’t be encrypted\.

**To configure S/MIME in Android Nine and the Samsung Mobile devices native mail app**

1. Get the certificate \(`*.pfx` or `*.p12`\) file from your administrator or third\-party certificate authority in an email\.

1. Download the attached certificates\.

1. Open the Android Nine app and choose **Email Settings**, **Accounts**, select your account, and then choose **Security options**\.

1. To enable encryption, choose **Encrypt ongoing emails**\. Under **Email encryption cert**, choose **Install**, select your certificate used for encrypting your email message, and then choose **Allow**\.
**Note**  
If you allow **Email encryption cert**, when you send an email, the app loads and validates the user certificate from the Global Address List \(GAL\) or from a contact\. If the certificate is found for the recipient, the email is sent as encrypted\. Otherwise, an error is displayed and the email is not sent\. You must disable the **Email encryption cert** setting\.

1. To enable signing, choose **Sign all outgoing emails**\. Under **Email signing cert**, choose **Install**, select your certificate used for signing your email message, and then choose **Allow**\.

**To configure S/MIME in Outlook 2016 for Mac**

1. Install the certificate on macOS:

   1. Get the certificate \(`*.p12`\) file from your administrator or third\-party certificate authority, and save the file to a folder\.

   1. Double\-click the certificate file to open **Keychain Access** and approve to add the certificate to your keychain\.

   1. In the list of certificates in your keychain, view the newly installed certificate\.

1. In Outlook for Mac, choose **Tools**, **Accounts**, select your account, and then choose **Advanced**, **Security**\.

1. In **Digital signing and Encryption**, choose the newly installed certificate from the list and choose from the following options:
   + To sign all outgoing messages by default, choose **Sign outgoing messages**\.
   + To encrypt all outgoing messages by default, choose **Encrypt outgoing messages**\.
   + To make sure that your signed message can be viewed by all recipients and mail applications, choose **Send digitally signed messages as clear text**\.
   + To enable recipients to send encrypted messages to you, choose **Include my certificates in signed messages**\.

1. Choose **OK**\.

**Note**  
To send an encrypted email to the group, manually expand the group\.
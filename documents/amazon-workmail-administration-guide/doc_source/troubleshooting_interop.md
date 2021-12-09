# Troubleshooting<a name="troubleshooting_interop"></a>

Solutions to the most commonly encountered Amazon WorkMail interoperability and migration errors are listed below\.

**Exchange Web Services \(EWS\) URL is invalid or unreachable** – Check that you have the correct EWS URL\. For more information, see [Configure availability settings on Amazon WorkMail](enable_interop_wm.md)\.

**Connection failure during EWS validation** – This is a general error, and can be caused by:
+ No internet connection in Microsoft Exchange\.
+ Your firewall is not configured to allow access from the internet\. Ensure that port 443 \(the default port for HTTPS requests\) is open\.

If you've confirmed the internet connection and firewall settings, but the error persists, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.

**Invalid username and password when configuring Microsoft Exchange interoperability** – This is a general error, and can be caused by:
+ The username is not in the expected form\. Use the following pattern:

  ```
  DOMAIN\username
  ```
+ Your Microsoft Exchange server is not configured for Basic Authentication for EWS\. For more information, see [Virtual directories: Exchange 2013](https://docs.microsoft.com/en-us/archive/blogs/mvpawardprogram/virtual-directories-exchange-2013) on the Microsoft MVP Award Program Blog\.

**User receives emails with winmail\.dat attachment** – This might happen when encrypted S/MIME email is sent from Exchange to Amazon WorkMail and received in Outlook 2016 for Mac or IMAP client\. The solution is to run the following command in Exchange Management Shell:

Set\-RemoteDomain \-Identity "Default" \-TNEFEnabled $false – If you've confirmed the points above but the error persists, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.
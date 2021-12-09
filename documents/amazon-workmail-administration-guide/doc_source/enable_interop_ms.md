# Configure availability settings in Microsoft Exchange<a name="enable_interop_ms"></a>

To redirect all calendar free/busy information requests for enabled users to Amazon WorkMail, set up an availability address space on Microsoft Exchange\.

Use the following PowerShell command:

```
$credentials = Get-Credential
```

At the prompt, enter the credentials of the Amazon WorkMail service account\. The username should be entered as **domain\\username** \(that is, **orgname\.awsapps\.com\\workmail\_service\_account\_username**\. Here, **orgname** represents the name of the Amazon WorkMail organization\. For more information, see [Create service accounts in Microsoft Exchange and Amazon WorkMail](interoperability.md#create-serviceacct)\.

```
Add-AvailabilityAddressSpace -ForestName orgname.awsapps.com -AccessMethod OrgWideFB -Credentials $credentials
```

For more information, see [Add\-AvailabilityAddressSpace](https://technet.microsoft.com/en-us/library/bb124122.aspx) on Microsoft TechNet\.
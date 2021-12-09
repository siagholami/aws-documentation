# Configuring SSO to ADFS and AWS Management Portal for vCenter<a name="configure-trust-with-aws"></a>

You can configure single sign\-on \(SSO\) between ADFS and the management portal\. When a user requests access to AWS through the management portal, ADFS authenticates the user\.

**Note**  
If you have already set up a trust relationship with AWS, edit the `NameId` claim to match the configuration in step 11 \(the incoming claim type is `Windows account name`, the outgoing claim type is `Name Id`, and `Persistent Identifier` is the outgoing name ID format\)\. Then, continue with step 15\.

**To configure trust between AWS and ADFS**

1. \[ADFS 2\.0\] From the **Start** menu, open **AD FS 2\.0 Management**\.

   \[ADFS 3\.0\] From Server Manager, click **Tools**, and then select **AD FS Management**\.

1. \[ADFS 2\.0\] In the **Actions** pane, click **Add Relying Party Trust**\.

   \[ADFS 3\.0\] Under **AD FS\\Trust Relationships**, right\-click **Relying Party Trusts** and then click **Add Relying Party Trust**\.

1. On the **Welcome** page, click **Start**\.

1. On the **Select Data Source** page, select **Import data about the relying party published online or on a local network**\. Enter "https://signin\.aws\.amazon\.com/static/saml\-metadata\.xml" as the federation metadata address, and then click **Next**\.  
![\[The Select Data Source page\]](http://docs.aws.amazon.com/amp/latest/userguide/images/select_data_source.png)

1. On the **Specify Display Name** page, enter "AWS Management Portal for vCenter" as the display name, and then click **Next**\.  
![\[The Specify Display Name page\]](http://docs.aws.amazon.com/amp/latest/userguide/images/specify_display_name.png)

1. On the **Choose Issuance Authorization Rules** page, select **Permit all users to access this relying party**, and then click **Next**\.

1. On the **Ready to Add Trust** page, review your settings, and then click **Next**\.

1. On the **Finish** page, select **Open the Edit Claim Rules dialog for this relying party trust when the wizard closes**, and then click **Close**\.

1. In the **Edit Claim Rules for AWS Management Portal for vCenter** dialog box, on the **Issuance Transform Rules** tab, click **Add Rule**\.

1. On the **Select Rule Template** page, select the **Send Claims Using a Custom Role** claim rule template from the list, and then click **Next**\.

1. To configure the claim rule, enter `NameId` in **Claim rule name**, enter the following rule in **Custom claim rule**, and then click **Finish**\.

   ```
   c:[Type == "http://schemas.microsoft.com/ws/2008/06/identity/claims/windowsaccountname"] => 
   issue(Type = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier", 
   Issuer = c.Issuer, OriginalIssuer = c.OriginalIssuer, Value = c.Value, ValueType = c.ValueType, 
   Properties["http://schemas.xmlsoap.org/ws/2005/05/identity/claimproperties/format"] = 
   "urn:oasis:names:tc:SAML:2.0:nameid-format:persistent");
   ```

   Use the Windows user name \(*domain*\\*user*\) as the `NameId` claim\. Ensure that these names are less than 32 characters long and are persistent identifiers\.  
![\[The Configure Rule page\]](http://docs.aws.amazon.com/amp/latest/userguide/images/configure_rule.png)

1. Click **Add Rule**\.

1. Select **Send Claims Using a Custom Role**, and then click **Next**\.

1. To configure the claim rule, enter `RoleSessionName` in **Claim rule name**, enter the following rule in **Custom claim rule**, and then click **Finish**\.

   ```
   c:[Type == "http://schemas.microsoft.com/ws/2008/06/identity/claims/windowsaccountname", Issuer == "AD AUTHORITY"] 
   => issue(store = "Active Directory", types = ("https://aws.amazon.com/SAML/Attributes/RoleSessionName"), 
   query = ";mail;{0}", param = c.Value);
   ```

   Use the display name for the user with the SAML assertion\. These names must be less than 32 characters long and contain only the following set of characters: \[a\-zA\-Z\_0\-9\+=,\.@\-\]\.

   The user must have an email address set up in Active Directory\.

1. Click **Add Rule**\.

1. Select **Send Claims Using a Custom Role**, and then click **Next**\.

1. To configure the claim rule, enter `AmpRole` in **Claim rule name**, enter the following rule in **Custom claim rule**, and then click **Finish**\.

   ```
   => issue(Type="https://aws.amazon.com/SAML/Attributes/Role", Value = 
   "arn:aws:iam::account_id:saml-provider/provider_name,arn:aws:iam::account_id:role/saml_role");
   ```

   This rule requires the ARNs of the SAML provider \(arn:aws:iam::*account\_id*:saml\-provider/*provider\_name*\) and the SAML role \(arn:aws:iam::*account\_id*:role/*saml\_role*\)\. You can look up these ARNs using the [AWS Management Portal for vCenter setup console](https://amp.aws.amazon.com/VCPlugin.html#setup)\.

1. Start and stop the ADFS service and test this configuration\. AWS trusts the users authorized by the IdP to assume the SAML role\. Therefore, be sure that your IdP authenticates and authorizes a user in your network before granting an assertion\.
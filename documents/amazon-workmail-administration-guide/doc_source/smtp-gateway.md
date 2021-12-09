# Configuring SMTP gateways<a name="smtp-gateway"></a>

You can configure SMTP gateways to use with outbound email flow rules\. Outbound email flow rules let you route email messages sent from your Amazon WorkMail organization through an SMTP gateway\. For more information, see [Outbound email rule actions](email-flows.md#email-flows-rule-outbound)\.

**Note**  
SMTP gateways configured for outbound email flow rules must support TLS v1\.2 using certificates from major certificate authorities\. Only basic authentication is supported\.

**To configure an SMTP gateway**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. Choose **Organization settings**, **SMTP gateways**\.

1. Choose **Create gateway**\.

1. Enter a name for the gateway, and the server address and port\.

1. For **Basic authentication**, enter the user name and password for authentication with the gateway\.

1. Choose **Create gateway**\.

1. The SMTP gateway is available for use with outbound email flow rules\.

When you configure an SMTP gateway to use in an outbound email flow rule, all outbound email messages that match the rule with the SMTP gateway action are routed to the corresponding SMTP gateway\. The SMTP gateway handles the rest of the email delivery\.

If Amazon WorkMail is unable to reach the SMTP gateway, the email message is bounced back to the sender\. If this occurs, correct the SMTP gateway settings in the Amazon WorkMail console by choosing **Organizations**, the name of your organization, **Organization settings**, **SMTP gateways**\.
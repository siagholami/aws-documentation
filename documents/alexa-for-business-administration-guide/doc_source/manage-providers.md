# Manage Conferencing Providers<a name="manage-providers"></a>

For more information about conference providers, PSTN settings, and SIP/H323 settings, see [Understanding Alexa\-enabled Conferencing](setup-conferencing.md)\.

**To add a conferencing provider**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conference settings**, **Add provider**\.

1. Choose one of the available conferencing providers, which automatically fills in the **Provider** pane\.
**Note**  
If the conference provider used by your organization is not available, choose **Other**\.

1. Review the following settings and edit them as necessary:
   + **Meeting settings** – Specify whether a meeting PIN is required to join the meeting\. \(Required\)
   + **PSTN dial\-in number** – Specify the phone number of your conferencing provider\. This must be a US phone number\.
   + **PSTN dial\-in delays** – Specify the delays before the meeting ID and PIN are sent using DTMF\.
   + **SIP/H323 dial\-in ** – SIP/H323 dial\-in settings are used to dial into meetings using your existing video conferencing equipment\. \(Required\)

1. Choose **Add**\.

You can edit the meeting settings and dial\-in information for a provider at any time\.

**To remove a conferencing provider**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. In the navigation bar, choose **Conference settings**\.

1. On the** Conference settings** page, choose **Remove**\.
**Note**  
You can’t remove a provider that is set as the default\. 

**To edit a conferencing provider**

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conference settings** and choose the name of the provider to edit\. 

1. Edit the following settings as necessary:
   + **Meeting settings** – Specify whether a meeting PIN is required to join the meeting\. \(Required\)
   + **PSTN dial\-in number** – Specify the phone number of your conferencing provider\. This must be a US phone number\.
   + **PSTN dial\-in delays** – Specify the delays before the meeting ID and PIN are sent using DTMF\.
   + **SIP/H323 dial\-in** – SIP/H323 dial\-in settings are used to dial into meetings using your existing video conferencing equipment\. \(Required\)

1. Choose **Save**\.

**To set a conferencing provider as default**

When a user joins a meeting and there is no scheduled meeting, the user is prompted for the meeting ID and PIN of the default provider\. You can only have one default provider for your account\.

1. Open the Alexa for Business console at [https://console\.aws\.amazon\.com/a4b/](https://console.aws.amazon.com/a4b/)\.

1. Choose **Conference settings**\.

1. Select the name of the provider to set as default\. 

1. Choose **Set as default**\.
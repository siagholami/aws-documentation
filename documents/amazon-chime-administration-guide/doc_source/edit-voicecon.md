# Editing Amazon Chime Voice Connector settings<a name="edit-voicecon"></a>

To finish setting up your Amazon Chime Voice Connector, edit the settings from the Amazon Chime console\. Edit the termination and origination settings to allow outbound or inbound calls, or both\.

**Termination settings**  
Termination settings apply to outbound calls from your Amazon Chime Voice Connector\. Here, set up your calling plan and caller ID options\. You can also specify the IP addresses allowed to make outbound calls using your Amazon Chime Voice Connector, and require credentials for making outbound calls to your Amazon Chime Voice Connector\. If no credentials are specified, no authentication is required\.

**Origination settings**  
Origination settings apply to inbound calls to your Amazon Chime Voice Connector\. Here, configure inbound routes for your SIP hosts to receive inbound calls\. Inbound calls are routed to hosts in your SIP infrastructure by the priority and weight you set for each host\. Calls are routed in priority order first, with 1 being the highest priority\. If hosts are equal in priority, calls are distributed among them based on their relative weight\.

**Note**  
Encryption\-enabled Voice Connectors use TLS \(TCP\) protocol for all calls\.

**To edit Amazon Chime Voice Connector settings**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connectors**\.

1. Choose the name of the Amazon Chime Voice Connector to edit\.

1. Edit your settings as follows:

   1. \(Optional\) Choose **General** to update the **Voice connector name**, and enable or disable encryption\.

   1. Choose **Termination**, and select **Enabled**\.

   1. \(Optional\) For **Allowlist**, choose **New**, enter the CIDR notations and values to allowlist, and choose **Add**\.

   1. For **Calling plan**, select the country or countries to add to your calling plan\.

   1. \(Optional\) For **Credentials**, choose **New**, enter a user name and password, and choose **Save**\. Your credentials are updated immediately\.

   1. \(Optional\) For **Caller ID**, choose **Edit**, select a caller ID phone number, and choose **Save**\.

   1. Choose **Save** again\.

   1. Choose **Origination**, and select **Enabled**\.

   1. For **Inbound routes**, choose **New**\.

   1. Enter the values for **Host**, **Port**, **Protocol**, **Priority**, and **Weight**\.

   1. Choose **Add**\.

   1. Choose **Save**\.

   1. \(Optional\) For **Emergency calling**, choose **Add** to add emergency call routing numbers that you have obtained from a third\-party emergency service provider\. For more information, see [Setting up emergency call routing numbers for your Amazon Chime Voice Connector](chime-voice-connector-emergency-calling.md)\.

   1. \(Optional\) For **Streaming**, choose **Start** to send audio to a Kinesis Video Stream, then choose **Save**\.

   1. Choose **Phone numbers**\.

   1. Select one or more phone numbers to assign to the Amazon Chime Voice Connector\.

   1. Choose **Assign**\.

   1. \(Optional\) For **Logging**, choose **Enabled** to send logs to CloudWatch Logs, then choose **Save**\.

For more information about assigning phone numbers to an Amazon Chime Voice Connector, see [Assigning and unassigning Amazon Chime Voice Connector phone numbers](assign-voicecon.md)\.
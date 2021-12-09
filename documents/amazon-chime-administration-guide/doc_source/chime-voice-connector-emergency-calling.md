# Setting up emergency call routing numbers for your Amazon Chime Voice Connector<a name="chime-voice-connector-emergency-calling"></a>

Amazon Chime does not offer emergency calling services\. If you would like to contact emergency calling services in the United States with Amazon Chime, you must obtain an emergency call routing number from a third\-party emergency service provider and provide it to Amazon Chime\. When you place a call to emergency services \(such as a 911 call\), Amazon Chime uses your emergency call routing number to route your call to your emergency services provider via the public switched telephone network \(PSTN\)\. Your third\-party emergency service provider then routes your call to emergency services\.

**Note**  
Amazon Chime is not responsible for routing calls to emergency services\.

**Setting up emergency call routing numbers requires that you perform the following prerequisites:**
+ Obtain emergency call routing numbers from a third\-party emergency service provider\.
+ Turn on and configure termination and origination settings for an Amazon Chime Voice Connector\. For more information, see [Editing Amazon Chime Voice Connector settings](edit-voicecon.md)\.

**To set up emergency call routing numbers for your Amazon Chime Voice Connector**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connectors**\.

1. Choose the name of the Amazon Chime Voice Connector\.

1. Choose **Emergency calling**\.

1. Choose **Add**\.

1. For **Call send method**, choose **DNIS** \(Dialed Number Identification Service\)\.

1. For **Emergency call routing number for calling emergency services**, enter the third\-party phone number for calling emergency services, in E\.164 format\.

1. For **Test routing number for testing calls to emergency services**, enter the third\-party phone number for testing calls to emergency services, in E\.164 format\.

1. For **Country**, select **United States**\.

1. Choose **Add**\.
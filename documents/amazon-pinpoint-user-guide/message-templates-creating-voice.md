# Creating Voice Templates<a name="message-templates-creating-voice"></a>

A *voice template* is a type of message template that contains content and settings that you want to create, save, and reuse in voice messages that you send for any of your Amazon Pinpoint projects\. You can use a voice template in voice messages that you send as direct or test messages\.

When you create a voice template, you specify the content and settings that you want to reuse in various components of voice messages that are based on the template\. These components are referred to as *template parts*\. They can contain the text of the message script or settings, such as the voice to use when delivering the message\. The message script can include static text and, optionally, personalized content that you define\.

When you create a voice message that’s based on a template, Amazon Pinpoint populates the message with the content and settings that you defined in the template\.

**To create a voice template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. Choose **Create template**\.

1. Under **Channel**, choose **Voice**\.

1. Under **Template details**, for **Template name**, enter a name for the template\. The name has to begin with a letter or number\. It can contain up to 128 characters\. The characters can be letters, numbers, underscores \(\_\), or hyphens \(‐\)\.

1. \(Optional\) For **Version description**, enter a brief description of the template\. The description can contain up to 500 characters\.

1. Under **Voice message details**, for **Message**, enter the text that you want to use as the message script for messages that use the template\. The script can contain up to 10,000 characters and has to be in plaintext format\.
**Tip**  
You can include personalized content in the message script\. To do this, add message variables that refer to specific attributes that you or Amazon Pinpoint created, such as an attribute that stores a user's first name\. By using message variables, you can play different content for each recipient of a message that uses the template\.   
To use a message variable, choose the name of an existing attribute from the **Attribute finder**\. Amazon Pinpoint creates a message variable for the attribute and copies it to your clipboard\. Paste the variable in the location that you want\. For more information, see [Adding Personalized Content to Message Templates](message-templates-personalizing.md)\.

1. For **Language and region**, choose the language that the text of the message script is written in\. Amazon Pinpoint uses this setting to determine which phonemes and other language\-specific settings to use when it converts the text of the script to speech\.

1. For **Voice**, choose the voice that you want to speak the message to recipients\. Each voice is created using native language speakers, so there are variations from voice to voice, even within the same language\. Therefore, it's a good idea to test each voice with your script\.

   The list of voices changes based on the language that you choose in step 8\. In most cases, the list includes at least one male and one female voice\. In some cases, only one voice is available\. We continually add support for additional languages and create voices for supported languages\.

1. Choose **Play message** to test how the message will sound when it's delivered to recipients\. Adjust the content and settings until the template has the design that you want\.

1. If you added personalized content to the template by using message variables, specify a default value for each variable\. If you do this, Amazon Pinpoint replaces the variable with the value that you specify, if a corresponding value doesn't exist for a recipient\. We recommend that you do this for each variable in the template\.

   To specify default values for variables, expand the **Default attribute values** section\. Then enter the default value that you want to use for each variable\. If you don't specify a default value and a value doesn't exist for a recipient, Amazon Pinpoint omits all text for the variable when it sends a message to that recipient\.

1. When you finish entering content and settings for the template, choose **Create**\.
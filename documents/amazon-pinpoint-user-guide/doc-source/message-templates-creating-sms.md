# Creating SMS Templates<a name="message-templates-creating-sms"></a>

An *SMS template* is a type of message template that contains content and settings that you want to create, save, and reuse in SMS text messages that you send for any of your Amazon Pinpoint projects\. You can use an SMS template in text messages that you send from campaigns, or to a limited audience as direct or test messages\.

When you create an SMS template, you specify the settings and content that you want to reuse in the body of text messages that are based on the template\. When you create a message that’s based on the template, Amazon Pinpoint populates the message with the settings and content that you defined in the template\.

**To create an SMS template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. Choose **Create template**\.

1. Under **Channel**, choose **SMS**\.

1. Under **Template details**, for **Template name**, enter a name for the template\. The name has to begin with a letter or number\. It can contain up to 128 characters\. The characters can be letters, numbers, underscores \(\_\), or hyphens \(‐\)\.

1. \(Optional\) For **Version description**, enter a brief description of the template\. The description can contain up to 500 characters\.

1. Under **SMS details**, for **Message**, enter the content that you want to display in the body of messages that use the template\. The message body can contain up to 1,600 characters\.
**Tip**  
You can include personalized content in the body of the template\. To do this, add message variables that refer to specific attributes that you or Amazon Pinpoint created, such as an attribute that stores a user's first name\. By using message variables, you can display different content for each recipient of a message that uses the template\.  
To use a message variable, choose the name of an existing attribute from the **Attribute finder**\. Amazon Pinpoint creates a message variable for the attribute and copies it to your clipboard\. Paste the variable in the location that you want\. For more information, see [Adding Personalized Content to Message Templates](message-templates-personalizing.md)\.

1. If you added personalized content to the template by using message variables, specify a default value for each variable\. If you do this, Amazon Pinpoint replaces the variable with the value that you specify, if a corresponding value doesn't exist for a recipient\. We recommend that you do this for each variable in the template\.

   To specify default values for variables, expand the **Default attribute values** section\. Then enter the default value that you want to use for each variable\. If you don't specify a default value and a value doesn't exist for a recipient, Amazon Pinpoint omits all text for the variable when it sends a message to that recipient\.

1. When you finish entering content and settings for the template, choose **Create**\.

If you want to test the template before you use it in a message that you send to users, you can [send a test message](messages-sms.md) that uses the template\. If you do this, ensure that you first complete step 8 to specify default values for all the variables in the template\. Otherwise, the message might not be sent or it might not render correctly\.
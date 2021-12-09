# Creating Email Templates<a name="message-templates-creating-email"></a>

An *email template* is a type of message template that contains content and settings that you want to create, save, and reuse in email messages that you send for any of your Amazon Pinpoint projects\. You can use an email template in any type of email message that you create and send by using Amazon Pinpoint\.

When you create an email template, you specify the content and settings that you want to reuse in various components of email messages that are based on the template\. These components, referred to as *template parts*, can be the message subject, the message body, or both\. The content can be static text, personalized content, images, or other design elements\. A template part can also be a setting, such as the message body to use if a recipient's email application doesn't display HTML content\.

When you create an email message that’s based on a template, Amazon Pinpoint populates the message with the content and settings that you defined in the template\. 

**To create an email template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. Choose **Create template**\.

1. Under **Channel**, choose **Email**\.

1. Under **Template details**, for **Template name**, enter a name for the template\. The name has to begin with a letter or number\. It can contain up to 128 characters\. The characters can be letters, numbers, underscores \(\_\), or hyphens \(‐\)\.

1. \(Optional\) For **Version description**, enter a brief description of the template\. The description can contain up to 500 characters\.

1. Under **Email details**, use the following options to specify the content for messages that use the template:
   + For **Subject**, enter the text that you want to display in the subject line of the message\.
   + For **Message**, enter the content that you want to display in the body of the message\.
**Tip**  
For the message body, you can enter the content by using either the HTML or Design view\. In the HTML view, you can manually enter HTML content, including formatting, links, and other features that you want to include in the message\. In the Design view, you can use a rich text editor to enter the content\. Use the formatting toolbar to apply formatting and add links and other features to the content\. To switch views, choose **HTML** or **Design** from the view selector above the message editor\.  
You can also include personalized content in the subject and body of the template\. To do this, add message variables that refer to specific attributes that you or Amazon Pinpoint created, such as an attribute that stores a user's first name\. By using message variables, you can display different content for each recipient of a message that uses the template\. To use a message variable, choose the name of an existing attribute from the **Attribute finder**\. Amazon Pinpoint creates a message variable for the attribute and copies it to your clipboard\. Paste the variable in the location that you want\. For more information, see [Adding Personalized Content to Message Templates](message-templates-personalizing.md)\.

1. \(Optional\) Under **Plain text version**, enter the content that you want to display in the body of messages that use the template and are sent to recipients whose email applications don't display HTML content\.

1. If you added personalized content to the template by using message variables, specify a default value for each variable\. If you do this, Amazon Pinpoint replaces the variable with the value that you specify, if a corresponding value doesn't exist for a recipient\. We recommend that you do this for each variable in the template\.

   To specify default values for variables, expand the **Default attribute values** section\. Then enter the default value that you want to use for each variable\. If you don't specify a default value and a value doesn't exist for a recipient, Amazon Pinpoint omits all text for the variable when it sends a message to that recipient\.

1. When you finish entering content and settings for the template, choose **Create**\.

If you want to test the template before you use it in an email message that you send to users, you can [send a test message](messages-email.md) that uses the template\. If you do this, ensure that you first complete step 9 to specify default values for all the variables in the template\. Otherwise, the message might not be sent or it might not render correctly\.
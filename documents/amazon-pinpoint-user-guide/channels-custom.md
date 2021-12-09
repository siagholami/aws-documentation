# Custom Channels in Amazon Pinpoint<a name="channels-custom"></a>

You can extend the capabilities of Amazon Pinpoint by creating custom channels\. You can use custom channels to send messages to your customers through any service that has an API—including third\-party services\. For example, you can use custom channels to send messages through third\-party services such as WhatsApp or Facebook Messenger\.

**Note**  
Amazon Web Services isn't responsible for any third\-party service that you use to send messages with custom channels\. Third\-party services may be subject to additional terms\. You should review these terms before you send messages with custom channels\. 

You can configure your campaigns to send messages through custom channels by using the Amazon Pinpoint console\. For more information, see [Amazon Pinpoint Campaigns](campaigns.md)\.

## Setting Up and Managing Custom Channels<a name="channels-custom-setup-manage"></a>

You can create custom channels by using a webhook, or by calling a service's API through an AWS Lambda function\. For more information about creating custom channel functions in Lambda, see [Creating Custom Channels](https://docs.aws.amazon.com/pinpoint/latest/developerguide/channels-custom.html) in the *Amazon Pinpoint Developer Guide*\.

Unlike other channels in Amazon Pinpoint, you don't have to enable the custom channels feature\. Custom channels are enabled by default in all Amazon Pinpoint projects\. You don't have to request production access to use custom channels\.
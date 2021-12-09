# Managing the Amazon Pinpoint Voice Channel<a name="channels-voice-manage"></a>

You can use the Amazon Pinpoint console to enable the voice channel for a project and to manage settings that apply to the voice channel for your Amazon Pinpoint account\. For example, you can request production access for your account, or request dedicated phone numbers for sending voice messages\.

**Topics**
+ [Enabling the Voice Channel](#channels-voice-manage-enable)
+ [Requesting Production Access](#channels-voice-manage-sandbox)
+ [Requesting Phone Numbers](#channels-voice-manage-request-phone-numbers)
+ [Relinquishing Phone Numbers](#channels-voice-manage-remove-phone-numbers)

## Enabling the Voice Channel<a name="channels-voice-manage-enable"></a>

Before you can use Amazon Pinpoint to send voice messages, you have to enable the voice channel for one or more projects\. To learn how to create a new project and enable the voice channel for it, see [Setting Up the Amazon Pinpoint Voice Channel](channels-voice-setup.md)\. To enable the voice channel for an existing project, complete the following steps\.

Note that the settings that you choose for the voice channel also apply to the SMS channel for the project\. If you want to send both voice and SMS messages from the project, choose settings that support your goals for both channels\. To learn more, see [Amazon Pinpoint SMS Channel](channels-sms.md)\.

**To enable the voice channel for an existing project**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to enable the voice channel for\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\.

1. On the **SMS and voice** page, next to **SMS settings**, choose **Edit**\.

1. Select **Enable the SMS channel for this project**\.

1. Choose **Save changes**\.

1. On the **SMS and voice** page, under **Number settings**, refer to the table to determine whether any phone numbers that are already associated with your account can be used to send voice messages\. If there are, the **Voice** column displays **Enabled** next to each phone number that you can use to send voice messages\. If there aren't, [request a phone number for the voice channel](#channels-voice-manage-request-phone-numbers)\.

## Requesting Production Access<a name="channels-voice-manage-sandbox"></a>

When you first start using the voice channel, your account is in the *sandbox*\. While your account is in the sandbox, certain quotas apply to your account\. For more information about these quotas, see [Voice Quotas](https://docs.aws.amazon.com/pinpoint/latest/developerguide/quotas.html#quotas-voice) in the *Amazon Pinpoint Developer Guide*\.

To remove these quotas from your account, you can request to have your account removed from the sandbox\. When your account is removed from the sandbox, it has *production access*\.

**Note**  
Before you request production access, you must send at least one voice message from your Amazon Pinpoint account\. You can send a voice message on the [Test Messaging](messages.md) page, or by using the [SendMessages](https://docs.aws.amazon.com/pinpoint/latest/apireference/apps-application-id-messages.html#SendMessages) API\.

**To request production access**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **Support** menu, choose **Support Center**\.

1. Under **Open support cases**, choose **Create case**\.

1. Choose **Service quota increase**\.

1. Under **Case classification**, for **Quota type**, choose **Pinpoint Voice**\.

1. For **How do you obtain consent to send voice messages to your customers**, explain how users sign up to voluntarily receive your voice messages\.

1. For **How can customers opt out of receiving messages from you**, explain how you ensure that you send voice messages only to recipients who want to receive voice messages from you\.

1. Under **Requests**, for **Region**, choose the AWS Region that you use to send voice messages\.

1. For **Quota**, verify that **Production Access** is selected\.

1. For **New quota value**, enter the maximum amount, in US Dollars, that you want to spend sending voice messages each calendar month\.

1. Under **Case description**, for **Use case description**, provide the following details:
   + The website or app of the company or service that will send voice messages\.
   + The service that's provided by your website or app, and how your voice messages contribute to that service\.

1. When you finish, choose **Submit**\. 

The AWS Support team provides an initial response to your request within 24 hours\.

In order to prevent our systems from being used to send unsolicited or malicious content, we have to consider each request carefully\. If we’re able to do so, we'll grant your request within this 24\-hour period\. However, if we need to obtain additional information from you, it might take longer to resolve your request\.

We might not be able to grant your request if your use case doesn’t align with our policies\.

## Requesting Phone Numbers<a name="channels-voice-manage-request-phone-numbers"></a>

You can use the Amazon Pinpoint console to request and lease phone numbers for sending voice messages\. These phone numbers are referred to as *long codes*\. A *long code* is a standard telephone number that contains up to 15 digits, depending on the country or region that it's based in\. When you lease a long code, the code is *dedicated*—that is, it's reserved for use only by your Amazon Pinpoint account\. You can lease local long codes that are based in a variety of countries or regions\.

**To request a dedicated long code for sending voice messages**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose a project\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\. 

1. Under **Number settings**, choose **Request long codes**\.

1. For **Target country or region**, choose the country or region that the long code should be based in\. The long code that you receive uses the local number format for the country or region that you choose\.
**Note**  
Currently, you can lease long codes for a limited number of countries and regions by using the Amazon Pinpoint console\. To request a long code for a country that isn't listed in the **Target country or region** list, open a new **Account and billing support** case in the [AWS Support Center](https://console.aws.amazon.com/support/v1#/case/create)\.

1. For **Quantity**, choose the number of long codes that you want to lease\.

1. For **Default call type**, choose the option that best describes the type of messages that you plan to send using the long code\.

1. \(Optional\) To lease a long code for an additional country or region, choose **Add a country or region**\. Repeat steps 5 through 7 for each additional country or region\.

1. When you finish, note the price shown next to **Subtotal**\. We charge you this amount each month for use of the long codes\. If you agree to this monthly charge, choose **Request long codes** to submit your request to lease the long codes\.

## Relinquishing Phone Numbers<a name="channels-voice-manage-remove-phone-numbers"></a>

If you don't need a dedicated phone number \(long code\) for your account anymore, you can relinquish and end your lease for it\. When you relinquish a dedicated long code, we stop charging you for it in your bill for the next calendar month\.

**Important**  
If you relinquish a dedicated long code, you might not be able to obtain the same long code again in the future\.

**To relinquish a dedicated long code**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose a project\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\. 

1. Select the long code that you want to relinquish, as shown in the following image\. Choose **Remove long code**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/channels-voice-manage-remove-phone-numbers.png)

1. In the **Remove number confirmation** window, confirm that you want to relinquish the long code, and then choose **Confirm**\.
# Setting Up the Amazon Pinpoint Voice Channel<a name="channels-voice-setup"></a>

To send voice messages by using Amazon Pinpoint, start by creating a new Amazon Pinpoint project\. Then, enable the voice channel for the project and request a dedicated phone number, referred to as a *long code*, for sending voice messages\. A *long code* is a standard telephone number that contains up to 15 digits, depending on the country or region that it's based in\. These phone numbers are *dedicated*—that is, they're reserved for use only by your Amazon Pinpoint account\. You can lease local phone numbers that are based in a variety of countries or regions\.

**Tip**  
You can also enable the voice channel for an existing project\. To do this, use the **SMS and voice** settings page on the Amazon Pinpoint console\. For more information, see [Managing the Amazon Pinpoint Voice Channel](channels-voice-manage.md)\. 

Note that the settings that you choose for the voice channel also apply to the SMS channel for the project\. If you want to send both voice and SMS messages from the project, choose settings that support your goals for both channels\. To learn more about enabling and using the SMS channel, see [Amazon Pinpoint SMS Channel](channels-sms.md)\.

**To set up the voice channel for a new project**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose **Create a project**\.

1. For **Project name**, enter a name, and then choose **Create**\.
**Note**  
The project name can contain up to 64 alphanumeric characters\. It can also include the following characters: comma \(,\), period \(\.\), at sign \(@\), underscore \(\_\), equals sign \(=\), and plus sign \(\+\)\.

1. Under **Project features**, in the **SMS and voice** section, choose **Configure**\.

1. Select **Enable the SMS channel for this project**\.

1. Expand the **Advanced configurations** section, and then choose **Request long codes**\.

1. For **Target country or region**, choose the country or region that the long code should be based in\. The long code that you receive uses the local number format for the country or region that you choose\.
**Note**  
Currently, you can lease long codes for a limited number of countries and regions by using the Amazon Pinpoint console\. To request a long code for a country that isn't listed in the **Target country or region** list, open a new **Account and billing support** case in the [AWS Support Center](https://console.aws.amazon.com/support/v1#/case/create)\.

1. For **Quantity**, choose the number of long codes that you want to lease\.

1. For **Default call type**, choose the option that best describes the type of messages that you plan to send using the long code\.

1. \(Optional\) To lease a long code for an additional country or region, choose **Add a country or region**\. Repeat steps 7 through 9 for each additional country or region\.

1. When you finish, note the price shown next to **Subtotal**\. We charge you this amount each month for use of the long codes\. If you agree to this monthly charge, choose **Request long codes** to submit your request to lease the long codes\.

Now that you've created a project that's enabled for voice messaging, you can start using Amazon Pinpoint to send voice messages directly to your customers\.
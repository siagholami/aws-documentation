# Requesting Dedicated Long Codes for SMS Messaging with Amazon Pinpoint<a name="channels-sms-awssupport-long-code"></a>

A long code \(also referred to as a long virtual number, or LVN\) is a standard phone number that contains up to 12 digits, depending on the country that it's based in\. Long codes are typically meant for low\-volume, person\-to\-person communication\. However, you can also use long codes for sending test messages, or for sending low volumes of messages to your customers\.

**Note**  
In the United States and Canada, sending rates for long codes are restricted to 1 message per second\. This restriction is set by the phone carriers, and isn't a limitation of Amazon Pinpoint\. This restriction might be higher or lower in other countries and regions\. If you send a large volume of messages from a long code, wireless carriers might begin to block your messages\. If you [send SMS messages programmatically](https://docs.aws.amazon.com/pinpoint/latest/developerguide/send-messages-sms.html), your applications should limit the number of messages that they send each second\.

After we receive your request, we send you information about the costs associated with obtaining a long code in your country or region\. We also provide an estimate of the amount of time that's required to provision a long code in your country or region\. 

**Note**  
If you're new to SMS messaging with Amazon Pinpoint, you should also request a monthly SMS spending threshold that meets the expected demands of your SMS use case\. By default, your monthly spending threshold is $1\.00 \(USD\)\. For more information, see [Requesting Increases to Your Monthly SMS Spending Quota for Amazon Pinpoint](channels-sms-awssupport-spend-threshold.md)\.

## Step 1: Open a Support Case<a name="channels-sms-awssupport-long-code-open"></a>

Open a case with AWS Support by completing the following steps\.

**To request a dedicated long code**

1. Sign in to the AWS Management Console at [https://console\.aws\.amazon\.com/](https://console.aws.amazon.com/)\.

1. On the **Support** menu, choose **Support Center**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/console_region_selector.png)

1. On the **My support cases** tab, choose **Create case**\.

1. Under **Create case**, choose **Service quota increase**\.

1. Under **Case classification**, complete the following sections:
   + For **Quota type**, choose **Pinpoint SMS**\.
   + For **Provide a link to the site or app which will be sending SMS messages**, provide information about the website, application, or service that will send SMS messages\.
   + For **What type of messages do you plan to send**, choose the type of messages that you plan to send using your long codes\.
   + For **Which countries do you plan to send messages to**, enter the country or region that you want to purchase long codes in\.

1. Under **Requests**, complete the following sections:
   + For **Resource Type**, choose **Dedicated SMS Long Codes**\.
   + For **Quota**, choose the type of messages that you plan to send using this long code\.
   + For **New quota value**, enter the number of long codes that you want to purchase\.

1. Under **Case description**, for **Use case description**, provide the following information:
   + The AWS Region that you use Amazon Pinpoint in\.
   + A description of your use case\. Include information about the content that you plan to send, how you obtained your customers' contact information, why you requested the number of long codes that you specified earlier, and whether you plan to use the long codes that you obtain to send two\-way SMS messages\.
   + The response that Amazon Pinpoint should automatically send to customers when they respond to your messages with the keyword HELP\.
   + The response that Amazon Pinpoint should automatically send to customers when they respond to your messages with the keyword STOP\.
   + The keyword that customers can send to your long code to opt in to receiving your messages, and the response that Amazon Pinpoint should automatically send to customers when they send this keyword to your long code\.

1. Under **Contact options**, for **Preferred contact language**, choose whether you want to receive communications for this case in **English** or **Japanese**\.

1. When you finish, choose **Submit**\.

After we receive your request, we provide an initial response within 24 hours\. We might contact you to request additional information\.

If we're able to provide you with a long code, we send you information about the costs associated with obtaining it\. We also provide an estimate of the amount of time that's required to provision the long code\. In many countries, we can provide you with a dedicated long code within 24 hours\. However, in some countries and regions, it can take several weeks to obtain a dedicated long code for the SMS channel\.

In order to prevent our systems from being used to send unsolicited or malicious content, we have to consider each request carefully\. We might not be able to grant your request if your use case doesn’t align with our policies\.

## Step 2: Update Your SMS Settings on the Amazon Pinpoint Console<a name="channels-sms-awssupport-long-code-settings"></a>

After AWS notifies you that your long codes have been registered, complete the following steps\.

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose a project that the SMS channel is enabled in\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\. 

1. Under **Number settings**, choose the long code\.

1. Under **Default keywords**, verify that the responses for the *HELP* and *STOP* keywords match the values that you specified in your request\.

1. Under **Registered keyword**, verify that the opt\-in keyword and response match the values that you specified in your request\.

1. \(Optional\) If you want to specify additional keyword responses, or if you want to process inbound messages outside of Amazon Pinpoint, you can enable two\-way SMS\. For more information, see [Two\-Way SMS Settings](settings-sms.md#settings-account-sms-number-2way)\.

1. When you finish, choose **Save**\.

## Next Steps<a name="channels-sms-awssupport-long-code-next"></a>

You've registered a long code and updated your settings in the Amazon Pinpoint console\. Now you can use Amazon Pinpoint to send SMS messages with your long code as the origination number\.

To engage an audience segment with an SMS campaign, see [Amazon Pinpoint Campaigns](campaigns.md)\.

To send an SMS message directly to a limited audience without creating a campaign, see [Send Test Messages with Amazon Pinpoint](messages.md)\.
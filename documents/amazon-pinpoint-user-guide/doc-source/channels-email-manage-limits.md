# Managing Email Sending Quotas<a name="channels-email-manage-limits"></a>

To regulate the number of email messages that you can send and the rate at which you can send them, your AWS account has sending quotas\. These quotas benefit all Amazon Pinpoint users because they help to maintain the trusted relationship between Amazon Pinpoint and Internet service providers \(ISPs\)\. They help you gradually ramp up your sending activity\. They decrease the likelihood that ISPs will block your emails because of sudden, unexpected spikes in your email sending volume or rate\.

Amazon Pinpoint provides the following sending quotas for email:

**Daily Sending Quota**  
The maximum number of emails that you can send during a 24\-hour period\. This quota reflects a rolling time period\. Every time you try to send an email, Amazon Pinpoint checks how many emails you sent during the previous 24 hours\. If the total number of emails that you have sent is less than your quota, your send request is accepted and your email is sent\. If you have already sent your full quota, your send request is rejected with a throttling exception\. For example, if your daily sending quota is 50,000, and you sent 15,000 emails during the previous 24 hours, then you can send another 35,000 emails right away\. If you have already sent 50,000 emails during the previous 24 hours, you cannot send more emails until some of the previous sending rolls out of its 24\-hour window\.

**Maximum Sending Rate**  
The maximum number of emails that Amazon Pinpoint can accept from your account per second\. You can exceed this quota for short bursts, but not for a sustained period of time\.  
The rate at which Amazon Pinpoint accepts your messages might be less than the maximum sending rate\.

When your account is in the Amazon Pinpoint sandbox, your sending quota is 200 messages per 24\-hour period and your maximum sending rate is one message per second\. To increase these values, you can [request production access for email](channels-email-setup-production-access.md)\. After your account moves out of the sandbox and you start sending emails, you can increase your quotas further by submitting a quota increase request to AWS Support\. 

## Increasing Your Sending Quotas<a name="channels-email-manage-limits-increase"></a>

When your account is out of the sandbox, your sending quotas increase if you are sending high\-quality content and we detect that your utilization is approaching your current quotas\. Often, the system automatically increases your quotas, and no further action is needed\.

If your existing quotas are not adequate for your needs and the system did not increase your quotas automatically, you can open an Amazon Pinpoint quota increase case in AWS Support Center\.

**Important**  
Plan ahead\. Be aware of your sending quotas and try to stay within them\. If you anticipate needing higher quotas than the system allocated, open an Amazon Pinpoint quota increase case well before the date when you need the higher quotas\.
If you anticipate needing to send more than one million emails per day, you must open an Amazon Pinpoint quota increase case\.

For Amazon Pinpoint to increase your sending quotas, use the following guidelines: 
+ **Send high\-quality content** – Send content that recipients want and expect\. 
+ **Send real production content** – Send your actual production email\. This enables Amazon Pinpoint to accurately evaluate your sending patterns, and verify that you are sending high\-quality content\.
+ **Send near your current daily quota** – If your volume stays close to your daily sending quota without exceeding it, Amazon Pinpoint detects this usage pattern and can automatically increase your quota\.
+ **Have low bounce and complaint rates** – Try to minimize the numbers of bounces and complaints\. High numbers of bounces and complaints can adversely affect your sending quotas\.
**Important**  
If you send test emails to your own email addresses, they may adversely affect your bounce and complaint metrics, or appear as low\-quality content to our filters\. Whenever possible, use the Amazon Simple Email Service \(Amazon SES\) mailbox simulator to test your system\. Emails that are sent to the mailbox simulator do not count toward your sending metrics or your bounce and complaint rates\. For more information, see [Testing Email Sending in Amazon SES](http://docs.aws.amazon.com/ses/latest/DeveloperGuide/mailbox-simulator.html)\.

## Requesting a Quota Increase<a name="channels-email-manage-limits-increase-case"></a>

To request higher sending quotas for Amazon Pinpoint, open a case in AWS Support Center by using the following instructions\.

**To request a sending quota increase**

1. Sign in to the AWS Management Console at [https://console\.aws\.amazon\.com/](https://console.aws.amazon.com/)\.

1. On the **Support** menu, choose **Support Center**\.

1. On the **My support cases** tab, choose **Create case**\.

1. Choose **Service quota increase**\.

1. Under **Case classification**, complete the following sections:
   + For **Quota type**, choose **Pinpoint Email**\.
   + For **Mail Type**, choose the type of email that you send\. If multiple values apply, choose the option that applies to the majority of the email that you send\.
   + For **Website URL**, enter the URL of your website\. Providing this information helps us better understand the type of content that you send\.
   + For **Describe in detail how you will only send to recipients who have specifically requested your mail**, explain how you ensure that you send email only to recipients who want to receive email from you\.
   + For **Describe in detail the process that you will follow when you receive bounce and complaint notifications**, explain how you process bounces and complaints about the email that you send\.
   + For **Will you comply with AWS Service Terms and AUP**, choose the option that applies to your use case\.

1. Under **Requests**, complete the following sections:
   + For **Region**, choose the AWS Region that your request applies to\.
   + For **Quota**, choose one of the following options:
     + To increase the number of messages that you can send per day, choose **Desired Daily Email Sending Quota**\.
     + To increase the number of messages you can send per second, choose **Desired Maximum Email Send Rate**\.
   + For **New quota value**, enter the new amount that you are requesting for the quota\. Request only the amount that you think you'll need\. We can't guarantee that you'll receive the amount that you request\. The larger your request, the more justification you need to provide to have your request granted\.
**Note**  
Your request applies only to the AWS Region that you chose at the beginning of this step\. To request a quota increase for another AWS Region, choose **Add another request**\. Then complete the **Region**, **Quota**, and **New quota value** fields for the additional Region\. Repeat this process for each Region that you want to request a quota increase for\.

1. Under **Case description**, for **Use case description**, describe how you send email using Amazon Pinpoint, in as much detail as possible\. For example, describe the type of emails that you send and how they fit into your business\. The more you indicate that you send high\-quality email messages to recipients who want and expect them, the more likely we are to approve your request\.

1. Under **Contact options**, for **Preferred contact language**, choose whether you want to receive communications for this case in **English** or **Japanese**\.

1. When you finish, choose **Submit**\.

The AWS Support team provides an initial response to your request within 24 hours\.

In order to prevent our systems from being used to send unsolicited or malicious content, we have to consider each request carefully\. If we’re able to do so, we'll grant your request within this 24\-hour period\. However, if we need to obtain additional information from you, it might take longer to resolve your request\.

We might not be able to grant your request if your use case doesn’t align with our policies\.

## Checking the Status of Your Request<a name="channels-email-setup-check-request-status"></a>

After you submit your request, we review your case\. To check the status of your request, complete the following steps\.

**To check the status of your quota increase request**

1. Sign in to the AWS Management Console at [https://console\.aws\.amazon\.com/](https://console.aws.amazon.com/)\.

1. On the **Support** menu, choose **Support Center**\.

1. On the **My support cases** tab, choose **View all support cases**\.

1. Under **Case history**, choose the sending quota increase request case\.

1. Review the messages in the **Correspondence** section\. The messages in this section tell you if your request was accepted or rejected\. If your request was accepted, the message specifies your daily and per\-second sending quotas\.

If your account is in the email sandbox and you are granted a sending quota increase, your account is automatically taken out of the sandbox\. After your account is out of the sandbox, you can send email to non\-verified addresses\. However, you must still verify your sending addresses and domains\.

Over time, we will gradually increase your sending quotas\. If your needs exceed the gradual increase, you can open another request to increase your sending quotas\.
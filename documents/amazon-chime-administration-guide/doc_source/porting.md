# Porting existing phone numbers<a name="porting"></a>

If you want to turn on Amazon Chime Business Calling for your Amazon Chime users, or if you want to use an Amazon Chime Voice Connector for SIP trunking with an existing phone system, you have the option to provision new phone numbers in the Amazon Chime console\. However, if you want to keep your existing phone numbers, you can port United States phone numbers from your phone carrier\. To start the porting process, submit a support request from the Amazon Chime console\. Porting can take between 2\-4 weeks\.

Before you can port phone numbers for Amazon Chime Voice Connectors, you must create an Amazon Chime Voice Connector\. For more information, see [Creating an Amazon Chime Voice Connector](create-voicecon.md)\.

**Note**  
You can port toll\-free numbers for Amazon Chime Voice Connectors\. Toll\-free numbers are not currently supported for Amazon Chime Business Calling\.

## Porting phone numbers into Amazon Chime<a name="port-in"></a>

Create a support request to port existing phone numbers into Amazon Chime\.

Before you start porting, download the [Letter of Agency \(LOA\) for Local Telephone Number Porting](https://d1.awsstatic.com/whitepapers/AmazonChimeLOA.pdf) and fill it out\. If you are porting phone numbers from different carriers, fill out a separate LOA for each carrier\.

**To port existing phone numbers into Amazon Chime**

1. Do one of the following:
   + Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

     Choose **Support**, **Submit request**\.
   + If you are an AWS Support customer, open the [AWS Support Center](https://console.aws.amazon.com/support/home#/) page, sign in if necessary, and choose **Create case**\. Choose **Technical support**\. For **Service**, choose **Chime**\.

1. For **Category**, choose **Other**\.

1. For **Subject**, enter **Porting phone numbers in**\.

1. For **Issue** or **Description**, enter the following:
   + Existing phone numbers to port in\. Indicate the phone number type, **Business Calling** or **Voice Connector**\.
   + Billing Telephone Number \(BTN\) of the account\.
   + Authorizing person’s name\. This is the person in charge of account billing with the current carrier\.
   + Current carrier, if known\.
   + Service account number, if this information is present with the current carrier\.
   + Service PIN, if available\.
   + Service address and customer name, as they appear in your current carrier contract\.
   + Requested date and time for the port\.
   + \(Optional\) If you are porting your BTN, indicate one of the following options:
     + **I am porting my BTN and I want to replace it with a new BTN that I am providing\. I can confirm that this new BTN is on the same account with the current carrier\.**
     + **I am porting my BTN and I want to close out my account with my current carrier\.**
     + **I am porting my BTN because my account is currently set up so that each phone number is its own BTN\.** \(Select this option only when your account with the current carrier is set up this way\.\)

1. Do one of the following:
   + If you are submitting a support request from the Amazon Chime console, for **Email**, enter the email address associated with your Amazon Chime administrator account\. Choose **Submit request**\.
   + If you are creating a case in [AWS Support Center](https://console.aws.amazon.com/support/home#/), for **Attachments**, choose **Choose files**, and attach the LOA\. For **Contact options**, select a contact method\. Optionally, for **Additional contacts**, enter email addresses of people to be notified of case status updates\.

1. AWS Support responds to your support request to let you know whether your phone numbers can be ported from your existing phone carrier\. You receive responses from AWS Support in one of the following ways:
   + If you submitted a support request from the Amazon Chime console, AWS Support emails the **Operations** contact specified under **Alternate Contacts** in the **Contact Information** for your AWS account\. For more information, see [Editing contact information](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/manage-account-payment.html#manage-account-payment-edit-contacts) in the *AWS Billing and Cost Management User Guide*\.
   + If you created a case in [AWS Support Center](https://console.aws.amazon.com/support/home#/), you receive responses based on your selected contact methods and any email addresses you entered for additional contacts\.

1. If your phone numbers can be ported, one of the following happens:
   + If you submitted a support request from the Amazon Chime console, AWS Support asks you to provide your completed [Letter of Agency \(LOA\)](https://d1.awsstatic.com/whitepapers/AmazonChimeLOA.pdf)\. If you are porting phone numbers from different carriers, fill out a separate LOA for each carrier\. This authorizes your existing phone carrier to release your existing phone numbers for porting\.
   + If you created a case in [AWS Support Center](https://console.aws.amazon.com/support/home#/) and attached your completed LOA, AWS Support proceeds to step 8\.

1. After you provide the LOA, AWS Support confirms with your existing phone carrier that the information on the LOA is correct\. If the information provided on the LOA does not match the information that your phone carrier has on file, AWS Support contacts you to update the information provided on the LOA\.

1. \(Optional\) View the status of your porting request in the Amazon Chime console under **Calling**, **Phone number management**, **Pending**\. AWS Support also contacts you with updates and requests for further information, as needed\. For more information, see [Phone number porting status definitions](#porting-status-definitions)\.

1. Assign the ported phone numbers to individual users as Amazon Chime Business Calling phone numbers, or assign the phone numbers to Amazon Chime Voice Connectors that you create\. The phone numbers are not activated for use until after the Firm Order Commit \(FOC\) date is established, as shown in the following steps\. For more information, see [Managing phone number inventory](phone-inventory.md) and [Creating an Amazon Chime Voice Connector](create-voicecon.md)\.

1. After your existing phone carrier confirms that the LOA is correct, they review and approve the requested port\. Then they provide AWS Support with a Firm Order Commit \(FOC\) date and time for the port to occur\.

1. AWS Support contacts you with the FOC to confirm that the date and time works for you\.

1. On the FOC date, the ported phone numbers are activated for use with Amazon Chime\.

## Porting phone numbers out of Amazon Chime<a name="port-out"></a>

**To port existing phone numbers out of Amazon Chime**

1. Do one of the following:
   + Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

     Choose **Support**, **Submit request**\.
   + If you are an AWS Support customer, open the [AWS Support Center](https://console.aws.amazon.com/support/home#/) page, sign in if necessary, and choose **Create case**\. Choose **Technical support**\. For **Service**, choose **Chime**\.

1. For **Category**, choose **Other**\.

1. For **Subject**, enter **Porting phone numbers out**\.

1. For **Issue** or **Description**, enter the phone numbers to port out\. Indicate the phone number type, **Business Calling** or **Voice Connector**\.

1. Do one of the following:
   + If you are submitting a support request from the Amazon Chime console, for **Email**, enter the email address associated with your Amazon Chime administrator account\. Choose **Submit request**\.
   + If you are creating a case in [AWS Support Center](https://console.aws.amazon.com/support/home#/), for **Contact options**, select a contact method\. Optionally, for **Additional contacts**, enter email addresses of people to be notified of case status updates\.

AWS Support responds with an account ID and PIN to use when requesting the port from your new carrier\. You receive responses from AWS Support in one of the following ways:
+ If you submitted a support request from the Amazon Chime console, AWS Support emails the **Operations** contact specified under **Alternate Contacts** in the **Contact Information** for your AWS account\. For more information, see [Editing contact information](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/manage-account-payment.html#manage-account-payment-edit-contacts) in the *AWS Billing and Cost Management User Guide*\.
+ If you created a case in [AWS Support Center](https://console.aws.amazon.com/support/home#/), you receive responses based on your selected contact methods and any email addresses you entered for additional contacts\.

When the porting process is complete and the phone numbers are ported to your new carrier, unassign and delete the phone numbers from your Amazon Chime inventory\. For more information, see [Managing phone number inventory](phone-inventory.md) and [Deleting phone numbers](delete-phone.md)\.

## Phone number porting status definitions<a name="porting-status-definitions"></a>

After you submit a request to port existing phone numbers into Amazon Chime, you can view the status of your porting request in the Amazon Chime console under **Calling**, **Phone number management**, **Pending**\.

Porting statuses and definitions include the following:

**CANCELLED**  
AWS Support cancelled the porting order because of an issue with the port, such as a cancellation request from the carrier or from you\. AWS Support contacts you with details\.

**CANCEL\_REQUESTED**  
AWS Support is processing a cancellation of the porting order because of an issue with the port, such as a cancellation request from the carrier or from you\. AWS Support contacts you with details\.

**CHANGE\_REQUESTED**  
AWS Support is processing your change request, and the carrier response is pending\. Allow for additional processing time\.

**COMPLETED**  
Your porting order is completed, and your phone numbers are activated\.

**EXCEPTION**  
AWS Support contacts you for additional details needed to complete the port request\. Allow for additional processing time\.

**FOC**  
The FOC date is confirmed with the carrier\. AWS Support contacts you to confirm the date\.

**PENDING DOCUMENTS**  
AWS Support contacts you for additional documents needed to complete the port request\. Allow for additional processing time\.

**SUBMITTED**  
Your porting order is submitted, and the carrier response is pending\.
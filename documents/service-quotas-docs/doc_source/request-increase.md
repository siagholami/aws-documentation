# Requesting a Quota Increase<a name="request-increase"></a>

You can use Service Quotas to request an increase for a quota, or limit\. In AWS services the terms, quotas and limits, can be used interchangeably\.

**Topics**
+ [Using the Console to Request a Quota Increase](#first-concept-chapter)
+ [Viewing Increase Request Details](#view-request-status)

## Using the Console to Request a Quota Increase<a name="first-concept-chapter"></a>

**To request a service quota increase**

Service quota increase requests won't receive priority support\. If you have an urgent or high\-priority service quota increase request, contact AWS Support\.

1. Open the [Service Quotas console](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/dashboard)\.

1. In the navigation pane, choose **AWS services**\.

1. From the list of **AWS services**, select a service\. 

   You can also enter the name of the service in the **Search** dialog\. To find the service by typing, you can enter any portion of the service name\. For example, if you enter **KM**, the list sorts to AWS Key Management Service \(AWS KMS\), because that's the only service that has those adjacent letters in its name\.

1. From the list of service quotas, select the quota you want to increase and choose **Request quota increase**\. 

1. In the **Change quota value** enter the new value\.

   The new value must be a number greater than the current quota value\.

1. To submit your request, choose **Request**\.

   Some requests are submitted to the Support Center console\. Other requests are automatically resolved, and the increase shows in the **Applied quota value** of the **Details** page\. 

   To view the details of the request, go to the Dashboard\. Choose **See details** to view the change request receipt\. Also, once the request has been received, a **View** link appears in the **Outstanding change request** column\.

## Viewing Increase Request Details<a name="view-request-status"></a>

Some quota increase requests trigger a Support Center case number\. To track the status of a quota increase request, you can follow the ticket as it goes from **Pending** to **Quota requested**\. After the Support Center receives the quota request, they generate a case number ticket, which is visible in the quota increase receipt\. 

**To view the details of a requested quota increase**

1. Open the [Service Quotas console](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/dashboard)\.

1. If you submitted a quota increase request, your request appears in the **Pending service quota requests** tile\. In the **Status** column, choose the status of your request\.

   The receipt from your request opens and shows the **Requested quota value**, **Request date**, and **Request status**\.

1. If you submitted a quota increase request, look in **Pending service quota requests** for your request\. Choose the status to open the receipt\.

   If the status is **Quota requested**, then you'll see the Support Center case number\. Choose the case number to open the ticket for your request\.
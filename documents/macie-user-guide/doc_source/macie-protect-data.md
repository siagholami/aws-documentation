# Protecting Data with Amazon Macie<a name="macie-protect-data"></a>

Macie can help you monitor how your sensitive and business\-critical data stored in the cloud is being used\. Macie applies artificial intelligence to understand historical data access patterns and automatically assesses activity of users, applications, and service accounts\. This can help you detect unauthorized access and avoid data leaks\.

After you enable Macie, it uses the following automated methods to protect your data\.

**Topics**
+ [AWS CloudTrail Events](#cloud-trail-events)
+ [AWS CloudTrail Errors](#cloud-trail-errors)

## AWS CloudTrail Events<a name="cloud-trail-events"></a>

Macie analyzes and processes a subset of data that CloudTrail logs and management events \(API calls\) that can occur in your infrastructure\. Macie designates a risk level between 1 and 10 for each of the supported CloudTrail events\. 

You can't modify existing or add new CloudTrail events to the list that Macie manages\. You can enable or disable the supported CloudTrail events, thus instructing Macie to either include or exclude them in its data security process\.<a name="enable-disable-cloud-trail-events"></a>

**To view, enable, or disable supported CloudTrail events**

1. In the Macie console, navigate to the **Settings** page\.

1. In the **Protect data** section, choose **AWS CloudTrail events**\.

1. Choose any of the listed events to view its details\.

   To enable or disable an event, on its details page, use the **Enabled/Disabled** dropdown and then choose **Save**\.

## AWS CloudTrail Errors<a name="cloud-trail-errors"></a>

Macie analyzes and processes errors that can occur when a subset of data that CloudTrail logs and management events \(API calls\) take place in your infrastructure\. Macie designates a risk level between 1 and 10 for each of the supported CloudTrail errors, with 10 being the highest risk and 1 being the lowest\.

You can't modify existing or add new CloudTrail errors to the list that Macie manages\. You can enable or disable the supported CloudTrail errors, thus instructing Macie to either include or exclude them in its data security process\.<a name="enable-disable-cloud-trail-errors"></a>

**To view, enable, or disable supported CloudTrail errors**

1. In the Macie console, navigate to the **Settings** page\.

1. In the **Protect data** section, choose **AWS CloudTrail errors**\.

1. Choose any of the listed errors to view its details\.

   To enable or disable an error, on its details page, use the **Enabled/Disabled** dropdown and then choose **Save**\.
# AWS Service Catalog Notification Constraints<a name="constraints-notification"></a>

A notification constraint specifies an Amazon SNS topic to receive notifications about stack events\. The SNS topic specifies the email address to receive the notifications\.

Use the following procedure to create an SNS topic and subscribe to it\.

**To create an SNS topic and a subscription**

1. Open the Amazon SNS console at [https://console\.aws\.amazon\.com/sns/v3/home](https://console.aws.amazon.com/sns/v3/home)\.

1. Choose **Create topic**\.

1. Type a topic name and then choose **Create topic**\.

1. Choose **Create subscription**\.

1. For **Protocol**, select **Email**\. For **Endpoint**, type an email address that you can use to receive notifications\. Choose **Create subscription**\.

1. You'll receive a confirmation email with the subject line `AWS Notification - Subscription Confirmation`\. Open the email and follow the directions to complete your subscription\.

Use the following procedure to apply a notification constraint using the SNS topic that you created using the previous procedure\.

**To apply a notification constraint to a product**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose the portfolio that contains the product\.

1. Expand **Constraints** and choose **Add constraints**\.

1. Choose the product from **Product** and set **Constraint type** to **Notification**\. Choose **Continue**\.

1. Choose **Choose a topic from your account** and select the SNS topic that you created from **Topic Name**\.

1. Choose **Submit**\.
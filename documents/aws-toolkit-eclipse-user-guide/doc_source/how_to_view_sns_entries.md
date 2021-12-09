# Viewing and Adding Amazon SNS Notifications<a name="how_to_view_sns_entries"></a>

You can use the AWS Toolkit for Eclipse to view Amazon Simple Notification Service \(Amazon SNS\) topics associated with your application\. Amazon SNS is a service that enables your application to send notifications, using a protocol such as email, when specified events occur\. To learn more about Amazon SNS, see the [Amazon SNS Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/)\.

## View an Amazon SNS Notification<a name="view-travel-log-notification"></a>

The following process illustrates how to view an Amazon SNS notification\.

 **To view a notification** 

1. In **AWS Explorer**, click the triangle to the left of the **Amazon SNS** node to expand it and see the Amazon SNS topics it contains\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-tl-sns-aws-explorer.png)

1. Double\-click this SNS topic to open a detail view in the Eclipse editor pane\. In this example, the **Subscription ARN** column says that the topic is pending confirmation\. Amazon SNS requires a confirmation from the individual specified by the email address before SNS will send email notifications to that individual\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-tl-sns-detail.png)

## Add an Amazon SNS Notification<a name="add-travel-log-notification"></a>

You can add new Amazon SNS notifications through AWS Explorer\.

 **To add a new notification** 

1. In **AWS Explorer**, right\-click **Amazon SNS**, and then click **Create New Topic**\. Enter a name for the new topic and click **OK**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-sns-create-new-topic.png)

1. Double\-click the new topic to display the detail view for the topic\. Right\-click in the **Subscriptions** area, and then click **Create Subscription**\. Leave the **Subscription Protocol** box as **Email \(plain text\)** and enter an email address for the endpoint\. Click **OK** \. The detail view for the notification will now include this subscription\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-sns-create-new-proto.png)

1. To delete the subscription, right\-click the entry in the **Protocol** column for the subscription and click **Delete Subscription**\.

**Note**  
The creation of the subscription will cause a verification email to be sent to the individual specified by the subscription “endpoint” email address\. This email address will be used by AWS only to send notifications\. It will not be used for any other purpose by AWS or Amazon\.com\.
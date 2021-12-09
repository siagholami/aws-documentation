# Creating an Amazon SNS rule<a name="iot-sns-rule"></a>

You can define a rule that sends message data to an Amazon SNS topic\. 

In this tutorial, you create a rule that sends the name of the AWS IoT thing that initiated the rule to all subscribers of an Amazon SNS topic\.

**To create a rule with an SNS action**

1. In the [AWS IoT console](https://console.aws.amazon.com/iot/home), in the navigation pane, choose **Act**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/choose-rules.png)

1. On the **Rules** page, choose **Create**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/dashboard-rules.png)

1. Enter a name and brief description for your rule\.
**Note**  
We do not recommend the use of personally identifiable information in rule names or descriptions\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-create-rule.png)

1. In the **Rule query statement** editor, enter the following:

   ```
   SELECT *, topic(3) as thing FROM '$aws/things/+/shadow/update/accepted'
   ```

   \(The topic filter following the `"FROM"` specifies the topics that initiate the rule's action when a message is published to them\. The plus sign \(`+`\) used in the topic filter is a wildcard character that matches any thing name\. The `"topic(3)"` attribute following `"SELECT"` appends the thing name, which is the third topic field, onto the message contents\.\)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-message-source.png)

1. In **Set one or more actions**, choose **Add action**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-add-action.png)

1. Under **Select an action**, choose **Send a message as an SNS push notification**, and then choose **Configure action**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/select-sns-action.png)

1. On the **Configure action** page, for **SNS target**, choose **Create**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-add-topic.png)

1. Enter a topic name in the dialog box, and then choose **Create**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-name-topic.png)

1. On the **Configure action** page, for **SNS target**, choose the SNS topic you just created\. For **Message format**, choose **RAW**\. Under **Choose or create a role to grant AWS IoT access to perform this action**, choose **Create Role**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-configure-action-1.png)

1. Enter a name for the role, and then choose **Create role**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-configure-action-3.png)

1. In **Configure action**, choose **Add action**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/sns-configure-action-4.png)

1. Choose **Create rule**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iot/latest/developerguide/images/create-rule-for-sns-final.png)

To test the rule, add a subscription to the SNS topic you created, and update the shadow of any AWS IoT thing\. 

You can use the AWS IoT console to find a thing, open its details page, and change the device's shadow\. When the Device Shadow service is notified of the change, it publishes a message on `$aws/things/MySNSThing/shadow/update/accepted`\. Your rule is initiated and all subscribers to your SNS topic receive a message that contains your thing's name\. 
# Troubleshooting an AWS IoT SiteWise rule action<a name="troubleshoot-rule"></a>

To troubleshoot your AWS IoT SiteWise rule action in AWS IoT Core, you can do one of the following procedures:
+ Configure CloudWatch Logs
+ Configure a republish error action for your rule

Then, compare the error messages with the errors in this topic to troubleshoot your issue\.

**Topics**
+ [Configuring AWS IoT Core logs](#configure-iot-logs)
+ [Configuring a republish error action](#configure-republish-error-action)
+ [Troubleshooting issues](#troubleshoot-rule-issues)

## Configuring AWS IoT Core logs<a name="configure-iot-logs"></a>

You can configure AWS IoT to log various levels of information to CloudWatch Logs\.

**To configure and access CloudWatch Logs**

1. To configure logging for AWS IoT Core, see [Monitoring with CloudWatch Logs](https://docs.aws.amazon.com/iot/latest/developerguide/cloud-watch-logs.html) in the *AWS IoT Developer Guide*\.

1. Navigate to the [CloudWatch console](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Log groups**\.

1. Choose the **AWSIotLogs** group\.

1. Choose a recent log stream\. By default, CloudWatch displays the most recent log stream first\.

1. Choose a log entry to expand the log message\. Your log entry might look like the following screenshot\.  
![\[CloudWatch "AWS IoT Logs" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/troubleshoot-rule-logs-console.png)

1. Compare the error messages with the errors in this topic to troubleshoot your issue\.

## Configuring a republish error action<a name="configure-republish-error-action"></a>

You can configure an error action on your rule to handle error messages\. In this procedure, you configure the republish rule action as an error action to view error messages in the MQTT test client\.

**Note**  
The republish error action outputs only the equivalent of `ERROR` level logs\. If you want more verbose logs, you must [configure CloudWatch Logs](#configure-iot-logs)\.

**To add a republish error action to a rule**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.

1. Choose your rule\.

1. Under **Error action**, choose **Add action**\.

1. Choose **Republish a message to an AWS IoT topic**\.  
![\[AWS IoT Core "Select an action" page screenshot with the Republish action highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-choose-republish-action-console.png)

1. Choose **Configure action** at the bottom of the page\.

1. In **Topic**, enter a unique topic \(for example, **sitewise/windfarm/rule/error**\)\. AWS IoT Core will republish error messages to this topic\.

1. Choose **Select** to grant AWS IoT Core access to perform the error action\.

1. Choose **Select** next to the role that you created for the rule\.

1. Choose **Update Role** to add the additional permissions to the role\.

1. Choose **Add action**\.

   Your rule's error action should look similar to the following screenshot\.  
![\[AWS IoT Core "Rule" page Republish error action screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/rule-confirm-republish-error-action-console.png)

1. Choose the back arrow in the upper left of the console to return to the AWS IoT console home\.

After you set up the republish error action, you can view the error messages in the MQTT test client in AWS IoT Core\.

In the following procedure, you subscribe to the error topic in the MQTT test client\. In the MQTT test client, you can receive your rule's error messages to troubleshoot the issue\.

**To subscribe to the error action topic**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation page, choose **Test** to open the MQTT test client\.

1. In the **Subscription topic** field, enter the error topic that you configured earlier \(for example, **sitewise/windfarm/rule/error**\) and choose **Subscribe to topic**\.  
![\[AWS IoT Core "MQTT client" page screenshot with the "Subscribe to topic" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/rule-ingestion/troubleshoot-rule-subscribe-error-topic-console.png)

1. Watch for error messages to appear and then expand the `failures` array in any error message\. 

   Next, compare the error messages with the errors in this topic to troubleshoot your issue\.

## Troubleshooting issues<a name="troubleshoot-rule-issues"></a>

Use the following information to troubleshoot rule issues\.

**Topics**
+ [Error: Member must be within 900 seconds before and 300 seconds after the current timestamp](#rule-error-timestamp-out-of-range)
+ [Error: Property value does not match data type <type>](#rule-error-invalid-data-type)
+ [Error: User: <role\-arn> is not authorized to perform: iotsitewise:BatchPutAssetPropertyValue on resource](#rule-error-role-not-authorized)
+ [Error: iot\.amazonaws\.com is unable to perform: sts:AssumeRole on resource: <role\-arn>](#rule-error-unable-to-assume-role)
+ [Info: No requests were sent\. PutAssetPropertyValueEntries was empty after performing substitution templates\.](#rule-info-request-was-empty)

### Error: Member must be within 900 seconds before and 300 seconds after the current timestamp<a name="rule-error-timestamp-out-of-range"></a>

Your timestamp is older than 15 minutes or newer than 5 minutes, compared to current Unix epoch time\. Try the following:
+ Check that your timestamp is in Unix epoch \(UTC\) time\. If you provide a timestamp with a different timezone, you receive this error\.
+ Check that your timestamp is in seconds\. AWS IoT SiteWise expects timestamps split into time in seconds \(in Unix epoch time\) and offset in nanoseconds\.
+ Check that you're uploading data that is timestamped no later than 15 minutes in the past\.

### Error: Property value does not match data type <type><a name="rule-error-invalid-data-type"></a>

An entry in your rule action has a different data type than the target asset property\. For example, your target asset property is a `DOUBLE` and your selected data type is **Integer** or you passed the value in `integerValue`\. Try the following:
+ If you configure the rule from the AWS IoT console, check that you chose the correct **Data type** for each entry\.
+ If you configure the rule from the API or AWS Command Line Interface \(AWS CLI\), check that your `value` object uses the correct type field \(for example, `doubleValue` for a `DOUBLE` property\)\.

### Error: User: <role\-arn> is not authorized to perform: iotsitewise:BatchPutAssetPropertyValue on resource<a name="rule-error-role-not-authorized"></a>

Your rule isn't authorized to access the target asset property, or the target asset property doesn't exist\. Try the following:
+ Check that your property alias is correct and that you have an asset property with the given property alias\. For more information, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.
+ Check that your rule has a role and that the role allows `iotsitewise:BatchPutAssetPropertyValue` permission to the targeted asset property, such as through the target asset's hierarchy\. For more information, see [Granting AWS IoT the required access](iot-rules.md#grant-rule-access)\.

### Error: iot\.amazonaws\.com is unable to perform: sts:AssumeRole on resource: <role\-arn><a name="rule-error-unable-to-assume-role"></a>

Your IAM user isn't authorized to assume the role on your rule\.

Check that your IAM user is allowed `iam:PassRole` permission to the role on your rule\. For more information, see [Pass role permissions](https://docs.aws.amazon.com/iot/latest/developerguide/pass-role.html) in the *AWS IoT Developer Guide*\.

### Info: No requests were sent\. PutAssetPropertyValueEntries was empty after performing substitution templates\.<a name="rule-info-request-was-empty"></a>

**Note**  
This message is an `INFO` level log\.

Your request must have at least one entry with all of the required parameters\.

Check that your rule's parameters, including substitution templates, result in non\-empty values\. Substitution templates can't access values defined in `AS` clauses in your rule query statement\. For more information, see [Substitution templates](https://docs.aws.amazon.com/iot/latest/developerguide/iot-substitution-templates.html) in the *AWS IoT Developer Guide*\.
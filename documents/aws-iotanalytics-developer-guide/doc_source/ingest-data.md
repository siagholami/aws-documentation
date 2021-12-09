# Ingesting data to AWS IoT Analytics<a name="ingest-data"></a>

If you have a channel that routes data to a pipeline that stores data in a data store where it can be queried, then you're ready to send message data into AWS IoT Analytics\. Here we show two methods of getting data into AWS IoT Analytics\. You can send a message using the AWS IoT message broker or use the AWS IoT Analytics `BatchPutMessage` API\.

**Topics**
+ [Using the AWS IoT message broker](#iot-message-broker)
+ [Using the BatchPutMessage API](#batchputmessage-api)

## Using the AWS IoT message broker<a name="iot-message-broker"></a>

To use the AWS IoT message broker, you create a rule using the AWS IoT rules engine\. The rule routes messages with a specific topic into AWS IoT Analytics\. But first, this rule requires you to create a role which grants the required permissions\. 

### Creating an IAM role<a name="create-iam-role"></a>

To have AWS IoT messages routed into an AWS IoT Analytics channel, you set up a rule\. But first, you must create an IAM role that grants that rule permission to send message data to an AWS IoT Analytics channel\.

Run the following command to create the role\.

```
aws iam create-role --role-name myAnalyticsRole --assume-role-policy-document file://arpd.json
```

The contents of the `arpd.json` file should look like the following\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "Service": "iot.amazonaws.com"
            },
            "Action": "sts:AssumeRole"
        }
    ]
}
```

Then, attach a policy document to the role\.

```
aws iam put-role-policy --role-name myAnalyticsRole --policy-name myAnalyticsPolicy --policy-document file://pd.json
```

The contents of the `pd.json` file should look like the following\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "iotanalytics:BatchPutMessage",
            "Resource": [
               "arn:aws:iotanalytics:us-west-2:your-account-number:channel/mychannel"
            ]
        }
    ]
}
```

### Creating a AWS IoT rule<a name="create-iam-rule"></a>

Create an AWS IoT rule that sends messages to your channel\.

```
aws iot create-topic-rule --rule-name analyticsTestRule --topic-rule-payload file://rule.json
```

The contents of the `rule.json` file should look like the following\.

```
{
    "sql": "SELECT * FROM 'iot/test'",
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23",
    "actions": [ {
        "iotAnalytics": {
            "channelName": "mychannel",
            "roleArn": "arn:aws:iam::your-account-number:role/myAnalyticsRole"
        }
    } ]
}
```

Replace `iot/test` with the MQTT topic of the messages that should be routed\. Replace the channel name and the role with the ones you created in the previous sections\.

### Sending MQTT messages to AWS IoT Analytics<a name="send-mqtt-messages"></a>

After you have joined a rule to a channel, a channel to a pipeline, and a pipeline to a data store, any data matching the rule now flows through AWS IoT Analytics to the data store ready to be queried\. To test this, you can use the AWS IoT console to send a message\.

**Note**  
The field names of message payloads \(data\) that you send to AWS IoT Analytics\.  
Must contain only alphanumeric characters and underscores \(\_\); no other special characters are allowed\.
Must begin with an alphabetic character or single underscore \(\_\)\.
Cannot contain hyphens \(\-\)\.
In regular expression terms: "`^[A-Za-z_]([A-Za-z0-9]*|[A-Za-z0-9][A-Za-z0-9_]*)$`"\. 
Cannot be greater than 255 characters
Are case\-insensitive\. Fields named `foo` and `FOO` in the same payload are considered duplicates\.
For example, `{"temp_01": 29}` or `{"_temp_01": 29}` are valid, but `{"temp-01": 29}`, `{"01_temp": 29}` or `{"__temp_01": 29}` are invalid in message payloads\.

1. In the [AWS IoT console](https://console.aws.amazon.com/iot/), in the left navigation pane, choose **Test**\.  
![\[Screenshot of the "Monitor" page in the AWS IoT console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/choose-test.png)

1. On the MQTT client page, in the **Publish** section, in **Specify a topic**, type **iot/test**\. In the message payload section, verify the following JSON contents are present, or type them if not\.

   ```
   {
       "message": "Hello from AWS IoT console"
   }
   ```

1. Choose **Publish to topic**\.  
![\[Screenshot of the "Test" page in the AWS IoT console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/publish.png)

   This publishes a message that is routed to the data store you created earlier\. 

## Using the BatchPutMessage API<a name="batchputmessage-api"></a>

Another way to get message data into AWS IoT Analytics is to use the `BatchPutMessage` API command\. This method does not require that you set up an AWS IoT rule to route messages with a specific topic to your channel\. But it does require that the device which sends its data/messages to the channel is capable of running software created with the AWS SDK or is capable of using the AWS CLI to call `BatchPutMessage`\. 

1. Create a file `messages.json` that contains the messages to be sent \(in this example only one message is sent\)\.

   ```
   [
       { "messageId": "message01", "payload": "{ \"message\": \"Hello from the CLI\" }" }
   ]
   ```

1. Run the `batch-put-message` command\.

   ```
   aws iotanalytics batch-put-message  --channel-name mychannel  --messages file://messages.json
   ```

   If there are no errors, you see the following output\.

   ```
   {
       "batchPutMessageErrorEntries": []
   }
   ```
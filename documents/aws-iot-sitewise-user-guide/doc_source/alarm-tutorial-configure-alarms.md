# Configuring alarms<a name="alarm-tutorial-configure-alarms"></a>

After you configure the alarm detection system, you can configure alarms for asset properties in AWS IoT SiteWise\. To configure an alarm, you must enable property value notifications in AWS IoT SiteWise\. Then, you configure AWS IoT rules to send property data to the alarm detection system's AWS Lambda function\. The Lambda function sends the data to AWS IoT Events, which checks if an alarm should trigger\.

To define an alarm for an asset property, you send a message to AWS IoT Events that contains an alarm definition\. You specify high and low thresholds for an asset property, and the number of data points after which the alarm triggers\. You can also send a message to AWS IoT Events to turn an alarm on or off\. Use the scripts in this tutorial to easily create and send these messages to inputs in AWS IoT Events\.

**Important**  
Before you can configure alarms, you must meet the prerequisites for this tutorial and configure an alarm detection system\. For more information, see [Prerequisites](iot-events-alarms.md#alarm-tutorial-prerequisites) and [Configuring an alarm detection system](alarm-tutorial-configure-alarm-system.md)\.

**Topics**
+ [Enabling asset property notifications in AWS IoT SiteWise](#alarm-tutorial-enable-notifications)
+ [Creating an AWS IoT rule that acts on AWS IoT SiteWise notifications](#alarm-tutorial-create-iot-rule)
+ [Defining an alarm for an asset property](#alarm-tutorial-define-alarm)
+ [Subscribing to Amazon SNS topics to receive alerts](#alarm-tutorial-subscribe-to-sns)
+ [Enabling and disabling alarms](#alarm-tutorial-change-alarm-status)

## Enabling asset property notifications in AWS IoT SiteWise<a name="alarm-tutorial-enable-notifications"></a>

To send property value updates from AWS IoT SiteWise to AWS IoT Events, you must enable asset property notifications for each property for which you define an alarm\. Then, each time a property receives or computes a new data point, AWS IoT SiteWise sends an MQTT message to AWS IoT Core that contains the new value\. Later in this tutorial, you configure an AWS IoT rule to send the property value update to AWS IoT Events through the Lambda function that you created earlier\. For more information, see [Interacting with other AWS services](interact-with-other-services.md)\.

**To enable asset property notifications**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Assets**\.

1. Choose the asset for which you want to configure an alarm\.

1. Choose **Edit**\.

1. Find the property for which you want to configure an alarm, and then choose **ENABLED** for its **Notification status**\.  
![\[AWS IoT SiteWise "Edit asset" page screenshot with "Notification status" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sitewise-enable-property-notifications-console.png)

1. Choose **Save**\.

1. On the page for the asset, find the property for which you enabled notifications

1. Choose the copy icon next the notification topic\. AWS IoT SiteWise publishes MQTT messages to this topic for this property\. You use this notification topic later in this tutorial\.  
![\[AWS IoT SiteWise "Asset details" page screenshot with the "Copy notification topic" icon highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sitewise-copy-notification-topic-console.png)

   The notification topic should look like the following example\.

   ```
   $aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE
   ```

## Creating an AWS IoT rule that acts on AWS IoT SiteWise notifications<a name="alarm-tutorial-create-iot-rule"></a>

AWS IoT rules query and act on MQTT messages\. In this procedure, you create an AWS IoT rule that acts on asset property value updates from AWS IoT SiteWise\. The rule sends values to the Lambda function, which sends messages to the property value input in AWS IoT Events\.

**To create an AWS IoT rule with a Lambda action**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\. If a **Get started** button appears, choose it\.

1. In the left navigation pane, choose **Act**, and then choose **Rules**\.

1. If a **You don't have any rules yet** dialog box appears, choose **Create a rule**\. Otherwise, choose **Create**\.

1. On the **Create a rule** page, do the following:

   1. Enter a **Name** for your rule\.

   1. \(Optional\) Enter a **Description** for your rule\.

   1. In **Rule query statement**, enter the following SQL statement\. Replace the `FROM` topic with the property value notification topic for your asset property\.

      ```
      SELECT
        concat(topic(6), "-", topic(8)) as alarmId,
        payload.values as values
      FROM
        '$aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE'
      ```

      This query statement uses [topic\(index\)](https://docs.aws.amazon.com/iot/latest/developerguide/iot-sql-functions.html#iot-function-topic) to parse asset ID and property ID from the topic\. Then, it concats asset ID and property ID to form the alarm ID key for AWS IoT Events\.
**Note**  
This rule query statement acts on messages from only one asset property\. If you want to configure alarms for a specific property for all assets with that property, you can modify the `FROM` clause to reuse this AWS IoT rule for other alarms\. To do so, update the `FROM` topic to the following topic filter\.  

      ```
      $aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/+/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE
      ```
The `+` character is a single\-level wildcard\. In this topic filter, the `+` character matches all assets\. For more information, see [Topics](https://docs.aws.amazon.com/iot/latest/developerguide/topics.html) in the *AWS IoT Core Developer Guide*\.

   1. Under **Set one or more actions**, choose **Add action**\.  
![\[AWS IoT "Create a rule" page screenshot with the "Add action" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/iot-add-rule-action-console.png)

   1. On the **Select an action** page, choose **Send a message to a Lambda function**, and then choose **Configure action**\.

   1. On the **Configure action** page, do the following:

      1. In **Function name**, choose **Select**, and then choose the Lambda function that you created earlier, **IoTSiteWiseAlarmPayloadConverter**\.  
![\[AWS IoT "Configure action" page screenshot for a Lambda function rule action.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/iot-rule-choose-lambda-function-console.png)

      1. Choose **Add action**\.

   1. Choose **Create rule**\.

## Defining an alarm for an asset property<a name="alarm-tutorial-define-alarm"></a>

To define an alarm in AWS IoT Events, you can send a message to the alarm definition input\. This message must contain the asset property information and the thresholds for the alarm\. Each alarm has a high and a low value threshold\. Each alarm also has a threshold count, which defines how many data points must exceed the threshold before the alarm triggers\. You can increase the threshold count to avoid false alarms if your sensor readings bounce often\. For more information about the structure of the alarm definition input, see [Creating inputs for your alarm detection model in AWS IoT Events](alarm-tutorial-configure-alarm-system.md#alarm-tutorial-create-iot-events-inputs)\.

In this procedure, you download and run a script that creates and sends the alarm definition message for you\. This script inputs an asset ID, property ID, and threshold configuration\. Then, it fetches additional asset property information from AWS IoT SiteWise to complete the message that the input expects\.

Before you can run the script, you must configure your AWS credentials on your local machine\. The script uses these credentials to authenticate with AWS\. You must also install version 1\.12\.49 or later of the SDK for Python \(Boto3\)\. Previous versions don't include AWS IoT SiteWise APIs that this script uses\. For more information, see [Prerequisites](iot-events-alarms.md#alarm-tutorial-prerequisites)\.

You can also run this script to update the threshold configuration for an existing alarm\.

**To define or update an alarm**

1. Create a file called `define_alarm.py` and copy the following Python code into the file\.

   ```
   # Define an alarm detector for an asset property in AWS IoT SiteWise.
   
   import argparse
   import boto3
   import json
   import sys
   import uuid
   
   # Configures the argument parser for this program.
   def configureArgumentParser():
       parser = argparse.ArgumentParser()
       parser.add_argument("-a", "--asset-id", action="store",
                           dest="asset_id", required=True, help="The ID of the asset.")
       parser.add_argument("-p", "--property-id", action="store",
                           dest="property_id", required=True, help="The ID of the property.")
       parser.add_argument("-ht", "--threshold-high", action="store", dest="threshold_high",
                           required=True, type=float, help="The upper threshold value.")
       parser.add_argument("-lt", "--threshold-low", action="store", dest="threshold_low",
                           required=True, type=float, help="The lower threshold value.")
       parser.add_argument("-tc", "--threshold-count", action="store", dest="threshold_count", required=True,
                           type=int, help="The number of data points that exceed a threshold before the alarm triggers.")
       parser.add_argument("-c", "--profile", action="store", dest="profile",
                           help="The AWS credentials profile to use. Defaults to the 'default' profile.")
       parser.add_argument("-r", "--region", action="store", dest="region",
                           help="The AWS Region to use. Defaults to the Region configured for the chosen profile.")
       return parser
   
   # Fetches asset, model, and property names and IDs for an asset property.
   def fetch_asset_property_details(session, asset_id, property_id):
       iot_sitewise_client = session.client("iotsitewise")
   
       # Fetch the asset details.
       try:
           describe_asset_response = iot_sitewise_client.describe_asset(assetId=asset_id)
       except iot_sitewise_client.exceptions.ResourceNotFoundException:
           raise Exception("Asset not found for asset ID: %s" % asset_id)
   
       # Find the property name from the asset details.
       property_name = None
       for asset_property in describe_asset_response["assetProperties"]:
           if asset_property["id"] == property_id:
               property_name = asset_property["name"]
       if property_name is None:
           raise Exception("Property not found for property ID: %s" % property_id)
   
       # Fetch the asset model details.
       asset_model_id = describe_asset_response["assetModelId"]
       describe_asset_model = iot_sitewise_client.describe_asset_model(assetModelId=asset_model_id)
       return {
           "assetModelId": asset_model_id,
           "assetModelName": describe_asset_model["assetModelName"],
           "assetId": asset_id,
           "assetName": describe_asset_response["assetName"],
           "propertyId": property_id,
           "propertyName": property_name
       }
   
   # Sends an alarm definition message to AWS IoT Events for an asset property and thresholds.
   def send_alarm_definition_message(session, asset_id, property_id, threshold_high, threshold_low, threshold_count):
       asset_property = fetch_asset_property_details(session, asset_id, property_id)
   
       iot_events_client = session.client("iotevents-data")
   
       # Create the alarm definition.
       payload = {
           "alarmId": "%s-%s" % (asset_property["assetId"], asset_property["propertyId"]),
           "threshold": {
               "high": threshold_high,
               "low": threshold_low
           },
           "thresholdCount": threshold_count
       }
       # Add the asset property details to the alarm definition.
       payload.update(asset_property)
   
       # Send the alarm definition to AWS IoT Events.
       message = {
           "messageId": str(uuid.uuid4()),
           "inputName": "AlarmDefinition",
           "payload": json.dumps(payload)
       }
       print("Sending alarm definition message to AWS IoT Events:")
       print(message)
       response = iot_events_client.batch_put_message(messages=[message])
       print("Status code: %d" % int(response["ResponseMetadata"]["HTTPStatusCode"]))
   
   
   # Sends an alarm definition message with user arguments.
   if __name__ == "__main__":
       parser = configureArgumentParser()
       args = parser.parse_args()
       try:
           session = boto3.Session(profile_name=args.profile, region_name=args.region)
           send_alarm_definition_message(session, args.asset_id, args.property_id,
                                         args.threshold_high, args.threshold_low, args.threshold_count)
       except Exception as e:
           print(str(e), file=sys.stderr)
           exit(1)
   ```

1. Run `define_alarm.py` from the command line with the following parameters:
   + `-a`, `--asset-id` – The ID of the asset\.
   + `-p`, `--property-id` – The ID of the property\.
   + `-ht`, `--threshold-high` – The upper threshold value\. The alarm triggers if asset property values are higher than this value\.
   + `-lt`, `--threshold-low` – The lower threshold value\. The alarm triggers if asset property values are lower than this value\.
   + `-tc`, `--threshold-count` – The number of data points that exceed a threshold before the alarm triggers\.
   + `-c`, `--profile` – \(Optional\) The AWS credentials profile to use\. If you omit this parameter, the script uses the `default` profile\. For more information, see [Credentials](http://boto3.amazonaws.com/v1/documentation/api/latest/guide/configuration.html) in the *AWS SDK for Python \(Boto3\) Getting Started*\.
   + `-r`, `--region` – \(Optional\) The Region to use\. Specify the Region in which your assets and alarm detection system resides\. If you omit this parameter, the script uses the Region configured for the chosen AWS profile\.

   Your command should look similar to the following example\.

   ```
   python3 define_alarm.py \
     -r us-east-1 \
     -a a1b2c3d4-5678-90ab-cdef-22222EXAMPLE \
     -p a1b2c3d4-5678-90ab-cdef-33333EXAMPLE \
     -ht 260 \
     -lt 230 \
     -tc 5
   ```

   The script outputs the message payload and the result of the API request\. The request succeeded if the output ends with `Status code: 200`\.

## Subscribing to Amazon SNS topics to receive alerts<a name="alarm-tutorial-subscribe-to-sns"></a>

To receive alarm alert messages, you must subscribe to the Amazon SNS topic that you created earlier in this tutorial\. You can create subscriptions to various types of endpoints, including email, SMS, and HTTP/S\. In this procedure, you create an email subscription to receive an email when your alarm triggers\.

**To subscribe to an Amazon SNS topic**

1. Navigate to the [Amazon SNS console](https://console.aws.amazon.com/sns/)\.

1. In the left navigation pane, choose **Topics**\.

1. Choose your topic, **IoTSiteWiseAlarmTopic**\.

1. On the page for your new topic, choose **Create subscription**\.  
![\[Amazon SNS "Topic details" page screenshot with "Create subscription" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sns-choose-create-subscription-console.png)

1. On the **Create subscription** page, do the following:

   1. If **Topic ARN** doesn't contain the ARN of your topic, choose your topic's ARN from the list\.

   1. For **Protocol**, choose **Email**\.

   1. In **Endpoint**, enter your email address\. You must confirm your email address after you create the subscription\.

   1. Choose **Create subscription**\.  
![\[Amazon SNS "Create subscription" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sns-create-alarm-subscription-console.png)

1. You'll receive an email that asks you to confirm your subscription\. In the email, choose **Confirm subscription**\.

   After you confirm your subscription, you should see a page that looks like the following screenshot\.  
![\[Amazon SNS "Subscription confirmed" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sns-confirm-email-subscription-console.png)

## Enabling and disabling alarms<a name="alarm-tutorial-change-alarm-status"></a>

The alarm detection system in this tutorial lets you turn an alarm on or off\. For example, you can use this capability to disable an alarm while you calibrate a sensor\. For more information about the structure of the alarm status input, see [Creating inputs for your alarm detection model in AWS IoT Events](alarm-tutorial-configure-alarm-system.md#alarm-tutorial-create-iot-events-inputs)\.

In this procedure, you download and run a script that creates and sends the alarm status message for you\.

Before you can run the script, you must configure your AWS credentials on your local machine\. The script uses these credentials to authenticate with AWS\. For more information, see [Prerequisites](iot-events-alarms.md#alarm-tutorial-prerequisites)\.

**To change the status of an alarm**

1. Create a file called `set_alarm_status.py` and copy the following Python code into the file\.

   ```
   # Enable or disable an alarm detector for an asset property in AWS IoT SiteWise.
   
   import argparse
   import boto3
   import json
   import sys
   import uuid
   
   # Configures the argument parser for this program.
   def configureArgumentParser():
       parser = argparse.ArgumentParser()
       parser.add_argument("-a", "--asset-id", action="store",
                           dest="asset_id", required=True, help="The ID of the asset.")
       parser.add_argument("-p", "--property-id", action="store",
                           dest="property_id", required=True, help="The ID of the property.")
       parser.add_argument("-s", "--status", action="store",
                           dest="alarm_status", required=True, choices=["ON", "OFF"], help="The status of the alarm.")
       parser.add_argument("-c", "--profile", action="store", dest="profile",
                           help="The AWS credentials profile to use. Defaults to the 'default' profile.")
       parser.add_argument("-r", "--region", action="store", dest="region",
                           help="The AWS Region to use. Defaults to the Region configured for the chosen profile.")
       return parser
   
   # Sends an alarm status message to AWS IoT Events for an asset property.
   def send_alarm_status_message(session, asset_id, property_id, alarm_status):
       iot_events_client = session.client("iotevents-data")
       payload = {
           "alarmId": "%s-%s" % (asset_id, property_id),
           "status": alarm_status
       }
       message = {
           "messageId": str(uuid.uuid4()),
           "inputName": "AlarmStatus",
           "payload": json.dumps(payload)
       }
       print("Sending alarm status message to AWS IoT Events:")
       print(message)
       response = iot_events_client.batch_put_message(messages=[message])
       print("Status code: %d" % int(response["ResponseMetadata"]["HTTPStatusCode"]))
   
   # Sends an alarm status message with user arguments.
   if __name__ == "__main__":
       parser = configureArgumentParser()
       args = parser.parse_args()
       try:
           session = boto3.Session(profile_name=args.profile, region_name=args.region)
           send_alarm_status_message(session, args.asset_id, args.property_id, args.alarm_status)
       except Exception as e:
           print(str(e), file=sys.stderr)
           exit(1)
   ```

1. Run `set_alarm_status.py` from the command line with the following parameters:
   + `-a`, `--asset-id` – The ID of the asset\.
   + `-p`, `--property-id` – The ID of the property\.
   + `-s`, `--status` – The new status for the alarm: `ON` or `OFF`\.
   + `-c`, `--profile` – \(Optional\) The AWS credentials profile to use\. If you omit this parameter, the script uses the `default` profile\. For more information, see [Credentials](http://boto3.amazonaws.com/v1/documentation/api/latest/guide/configuration.html) in the *AWS SDK for Python \(Boto3\) Getting Started*\.
   + `-r`, `--region` – \(Optional\) The Region to use\. Specify the Region in which your assets and alarm detection system resides\. If you omit this parameter, the script uses the Region configured for the chosen AWS profile\.

   Your command should look similar to the following example\.

   ```
   python3 set_alarm_status.py \
     -r us-east-1 \
     -a a1b2c3d4-5678-90ab-cdef-22222EXAMPLE \
     -p a1b2c3d4-5678-90ab-cdef-33333EXAMPLE \
     -s OFF
   ```

   The script outputs the message payload and the result of the API request\. The request succeeded if the output ends with `Status code: 200`\.
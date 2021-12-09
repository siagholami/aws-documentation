# Configuring an alarm detection system<a name="alarm-tutorial-configure-alarm-system"></a>

You can create an alarm detection system that lets you easily configure alarms for your industrial data\. You need to set up the alarm detection system only once in each Region that you use AWS IoT SiteWise\. Then, you can configure alarms for your asset properties to receive an alert when data values exceed low or high thresholds\. For more information, see [Configuring alarms](alarm-tutorial-configure-alarms.md)\.

**Important**  
Before you can configure an alarm detection system, you must meet the prerequisites for this tutorial\. For more information, see [Prerequisites](iot-events-alarms.md#alarm-tutorial-prerequisites)\.

**Topics**
+ [Creating an Amazon SNS topic for alert messages](#alarm-tutorial-create-sns-topic)
+ [Creating inputs for your alarm detection model in AWS IoT Events](#alarm-tutorial-create-iot-events-inputs)
+ [Creating an alarm detection model in AWS IoT Events](#alarm-tutorial-create-detector-model)
+ [Creating a Lambda function to send asset property values to AWS IoT Events](#alarm-tutorial-create-message-lambda)

## Creating an Amazon SNS topic for alert messages<a name="alarm-tutorial-create-sns-topic"></a>

With Amazon SNS, you can publish messages to topics\. Then, you can create subscriptions to receive notifications when a message is published to a topic\. For this alarm detection system, you create a topic that receives alarm messages from AWS IoT Events\. Then, you subscribe to the topic when you configure alarms\.

**To create an Amazon SNS topic**

1. Navigate to the [Amazon SNS console](https://console.aws.amazon.com/sns/)\.

1. Review the [AWS Regions](getting-started.md#requirements) where AWS IoT SiteWise and AWS IoT Events are supported and switch Regions, if needed\.

1. In the left navigation pane, choose **Topics**\.

1. Choose **Create topic**\.

1. On the **Create topic** page, do the following:

   1. In **Name**, enter **IoTSiteWiseAlarmTopic**\.

   1. \(Optional\) Enter a **Display name** for your topic, such as **IoT SiteWise Alarm**\. If you configure email subscriptions, this value is the name of the sender in the emails that you receive\. You must complete this step if you configure SMS subscriptions for this topic\.  
![\[Amazon SNS "Create topic" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sns-create-alarm-topic-console.png)

   1. Choose **Create topic**\.

1. Copy the ARN of your new topic\. You need this ARN later when you create an alarm detector model in AWS IoT Events\.  
![\[Amazon SNS "Topic details" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/sns-record-topic-arn-console.png)

## Creating inputs for your alarm detection model in AWS IoT Events<a name="alarm-tutorial-create-iot-events-inputs"></a>

In AWS IoT Events, inputs define the shape of data messages that detector models consume and act on\. All inputs used in a detector model must share a common key, so the detector model can associate messages from different inputs\. This alarm detection system uses the following three inputs that share a common key, `alarmId`, which is the concatenation of asset ID and property ID for an asset property:
+ **AlarmDefinition** – Defines an alarm with the following properties:
  + `alarmId` – The ID of the alarm, defined as the concatenation of `assetId` and `propertyId`\.
  + `assetModelId` – The ID of the asset's model\.
  + `assetModelName` – The name of the asset's model\.
  + `assetId` – The ID of the asset\.
  + `assetName` – The name of the asset\.
  + `propertyId` – The ID of the property\.
  + `propertyName` – The name of the property\.
  + `threshold` – A structure that defines the following threshold values for the alarm:
    + `high` – The upper threshold value for the alarm\. The alarm triggers if asset property values are higher than this value\.
    + `low` – The lower threshold value for the alarm\. The alarm triggers if asset property values are lower than this value\.
  + `thresholdCount` – The number of data points that exceed a threshold before the alarm triggers\.
+ **AlarmPropertyValue** – Contains an asset property value with the following properties:
  + `alarmId` – The ID of the alarm\.
  + `propertyValue` – A data point for the asset property configured in this alarm\.
+ **AlarmStatus** – Contains the status of an alarm:
  + `alarmId` – The ID of the alarm\.
  + `status` – The status of the alarm: `ON` or `OFF`\.

In this procedure, you create these inputs from sample messages that define the shape of each input\.

**To create inputs for the alarm detection system**

1. Navigate to the [AWS IoT Events console](https://console.aws.amazon.com/iotevents/)\.

1. In the left navigation pane, choose **Inputs**\.

1. To create an input for alarm definitions, do the following:

   1. Create a file called `alarm_definition_message.json` and copy the following JSON object into the file\.

      ```
      {
        "assetModelId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE",
        "assetModelName": "Fabricator Model",
        "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
        "assetName": "Fabricator 3",
        "propertyId": "a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
        "propertyName": "Nozzle Temperature",
        "alarmId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE-a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
        "threshold": {
          "high": 260,
          "low": 230
        },
        "thresholdCount": 5
      }
      ```

   1. Choose **Create input**\.

   1. In **Input name**, enter **AlarmDefinition**\.

   1. \(Optional\) Enter a description to describe this input\.

   1. Choose **Upload file**, and upload the file `alarm_definition_message.json`\.

   1. Choose **Create**\.  
![\[AWS IoT Events "Create input" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/events-create-alarm-definition-input-console.png)

1. To create an input for asset property values in alarms, do the following:

   1. Create a file called `alarm_property_value_message.json` and copy the following JSON object into the file\.

      ```
      {
        "alarmId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE-a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
        "propertyValue": 241
      }
      ```

   1. Choose **Create input**\.

   1. In **Input name**, enter **AlarmPropertyValue**\.

   1. \(Optional\) Enter a description to describe this input\.

   1. Choose **Upload file**, and upload the file `alarm_property_value_message.json`\.

   1. Choose **Create**\.

1. To create an input for alarm status, do the following:

   1. Create a file called `alarm_status_message.json` and copy the following JSON object into the file\.

      ```
      {
        "alarmId": "a1b2c3d4-5678-90ab-cdef-11111EXAMPLE-a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
        "status": "OFF"
      }
      ```

   1. Choose **Create input**\.

   1. In **Input name**, enter **AlarmStatus**\.

   1. \(Optional\) Enter a description to describe this input\.

   1. Choose **Upload file**, and upload the file `alarm_status_message.json`\.

   1. Choose **Create**\.

   You should have three inputs in AWS IoT Events\.  
![\[AWS IoT Events "Inputs" screenshot with three inputs for the alarm detection system.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/events-view-inputs-console.png)

## Creating an alarm detection model in AWS IoT Events<a name="alarm-tutorial-create-detector-model"></a>

Detector models define how AWS IoT Events processes data from inputs\. In the alarm detection system, AWS IoT Events creates a detector from the detector model for each alarm\. Each detector has a state, and this state changes when certain conditions are met\. When data exceeds an alarm threshold, the detector transitions to an alarm state and sends an alert to Amazon SNS\. For more information, see [Create a detector model](https://docs.aws.amazon.com/iotevents/latest/developerguide/iotevents-detector-model.html) in the *AWS IoT Events Developer Guide*\.

**To create an detector model for alarms**

1. Create a file called `AlarmThresholdMonitor.json` and copy the following JSON object into the file\. Replace the three instances of `sns` `targetArn` with the ARN of the Amazon SNS topic you created earlier\.

   ```
   {
     "detectorModelDefinition": {
       "states": [
         {
           "stateName": "VALUE_TOO_LOW",
           "onInput": {
             "events": [
               {
                 "eventName": "normalValueCheck",
                 "condition": "($input.AlarmPropertyValue.propertyValue < $input.AlarmDefinition.threshold.high) && ($input.AlarmPropertyValue.propertyValue > $input.AlarmDefinition.threshold.low)",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachLowCount",
                       "value": "$variable.breachLowCount - 1"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "returnToNormal",
                       "value": "1"
                     }
                   }
                 ]
               },
               {
                 "eventName": "highValueCheck",
                 "condition": "$input.AlarmPropertyValue.propertyValue >= $input.AlarmDefinition.threshold.high",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachHighCount",
                       "value": "$variable.breachHighCount + 1"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "receivedHighValue",
                       "value": "1"
                     }
                   }
                 ]
               }
             ],
             "transitionEvents": [
               {
                 "eventName": "returnToNormal",
                 "condition": "($variable.breachLowCount == 0) || ($variable.receivedHighValue == 1)",
                 "actions": [],
                 "nextState": "NORMAL"
               },
               {
                 "eventName": "turnOff",
                 "condition": "$input.AlarmStatus.status == \"OFF\"",
                 "actions": [],
                 "nextState": "OFF"
               }
             ]
           },
           "onEnter": {
             "events": [
               {
                 "eventName": "sendAlarmLowMessage",
                 "condition": "true",
                 "actions": [
                   {
                     "sns": {
                       "targetArn": "arn:aws:sns:region:123456789012:IoTSiteWiseAlarmTopic",
                       "payload": {
                         "contentExpression": "'An asset property has breached a low value threshold.\n\nAsset: ' + $input.AlarmDefinition.assetName + '\nProperty: ' + $input.AlarmDefinition.propertyName + '\nLatest value: ' + '${$input.AlarmPropertyValue.propertyValue}' + '\nLow threshold: ' + '${$input.AlarmDefinition.threshold.low}' + '\nHigh threshold: ' + '${$input.AlarmDefinition.threshold.high}' + '\nThreshold count: ' + '${$input.AlarmDefinition.thresholdCount}'",
                         "type": "STRING"
                       }
                     }
                   }
                 ]
               },
               {
                 "eventName": "initializeVariable",
                 "condition": "true",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "receivedHighValue",
                       "value": "0"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "returnToNormal",
                       "value": "0"
                     }
                   }
                 ]
               }
             ]
           },
           "onExit": {
             "events": []
           }
         },
         {
           "stateName": "VALUE_TOO_HIGH",
           "onInput": {
             "events": [
               {
                 "eventName": "normalValueCheck",
                 "condition": "($input.AlarmPropertyValue.propertyValue < $input.AlarmDefinition.threshold.high) && ($input.AlarmPropertyValue.propertyValue > $input.AlarmDefinition.threshold.low)",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachHighCount",
                       "value": "$variable.breachHighCount - 1"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "returnToNormal",
                       "value": "1"
                     }
                   }
                 ]
               },
               {
                 "eventName": "lowValueCheck",
                 "condition": "$input.AlarmPropertyValue.propertyValue <= $input.AlarmDefinition.threshold.low",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachLowCount",
                       "value": "$variable.breachLowCount + 1"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "receivedLowValue",
                       "value": "1"
                     }
                   }
                 ]
               }
             ],
             "transitionEvents": [
               {
                 "eventName": "returnToNormal",
                 "condition": "($variable.breachHighCount == 0) || ($variable.receivedLowValue == 1)",
                 "actions": [],
                 "nextState": "NORMAL"
               },
               {
                 "eventName": "turnOff",
                 "condition": "$input.AlarmStatus.status == \"OFF\"",
                 "actions": [],
                 "nextState": "OFF"
               }
             ]
           },
           "onEnter": {
             "events": [
               {
                 "eventName": "sendAlarmHighMessage",
                 "condition": "true",
                 "actions": [
                   {
                     "sns": {
                       "targetArn": "arn:aws:sns:region:123456789012:IoTSiteWiseAlarmTopic",
                       "payload": {
                         "contentExpression": "'An asset property has breached a high value threshold.\n\nAsset: ' + $input.AlarmDefinition.assetName + '\nProperty: ' + $input.AlarmDefinition.propertyName + '\nLatest value: ' + '${$input.AlarmPropertyValue.propertyValue}' + '\nLow threshold: ' + '${$input.AlarmDefinition.threshold.low}' + '\nHigh threshold: ' + '${$input.AlarmDefinition.threshold.high}' + '\nThreshold count: ' + '${$input.AlarmDefinition.thresholdCount}'",
                         "type": "STRING"
                       }
                     }
                   }
                 ]
               },
               {
                 "eventName": "initializeVariable",
                 "condition": "true",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "returnToNormal",
                       "value": "0"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "receivedLowValue",
                       "value": "0"
                     }
                   }
                 ]
               }
             ]
           },
           "onExit": {
             "events": []
           }
         },
         {
           "stateName": "ALARM_NOT_DEFINED",
           "onInput": {
             "events": [],
             "transitionEvents": [
               {
                 "eventName": "defineAlarm",
                 "condition": "currentInput(\"AlarmDefinition\")",
                 "actions": [],
                 "nextState": "NORMAL"
               }
             ]
           },
           "onEnter": {
             "events": []
           },
           "onExit": {
             "events": []
           }
         },
         {
           "stateName": "OFF",
           "onInput": {
             "events": [],
             "transitionEvents": [
               {
                 "eventName": "turnOn",
                 "condition": "$input.AlarmStatus.status == \"ON\"",
                 "actions": [],
                 "nextState": "NORMAL"
               }
             ]
           },
           "onEnter": {
             "events": []
           },
           "onExit": {
             "events": []
           }
         },
         {
           "stateName": "NORMAL",
           "onInput": {
             "events": [
               {
                 "eventName": "setVariables",
                 "condition": "currentInput(\"AlarmPropertyValue\")",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "countValues",
                       "value": "$variable.countValues + 1"
                     }
                   }
                 ]
               },
               {
                 "eventName": "checkHighThresholdBreach",
                 "condition": "$input.AlarmPropertyValue.propertyValue >= $input.AlarmDefinition.threshold.high",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachHighCount",
                       "value": "$variable.breachHighCount + 1"
                     }
                   }
                 ]
               },
               {
                 "eventName": "checkLowThresholdBreach",
                 "condition": "$input.AlarmPropertyValue.propertyValue <= $input.AlarmDefinition.threshold.low",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachLowCount",
                       "value": "$variable.breachLowCount + 1"
                     }
                   }
                 ]
               },
               {
                 "eventName": "checkNoThresholdBreach",
                 "condition": "($input.AlarmPropertyValue.propertyValue < $input.AlarmDefinition.threshold.high) && ($input.AlarmPropertyValue.propertyValue > $input.AlarmDefinition.threshold.low)",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachHighCount",
                       "value": "0"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "breachLowCount",
                       "value": "0"
                     }
                   }
                 ]
               }
             ],
             "transitionEvents": [
               {
                 "eventName": "AlarmHigh",
                 "condition": "$variable.breachHighCount >= $input.AlarmDefinition.thresholdCount",
                 "actions": [],
                 "nextState": "VALUE_TOO_HIGH"
               },
               {
                 "eventName": "AlarmLow",
                 "condition": "$variable.breachLowCount >= $input.AlarmDefinition.thresholdCount",
                 "actions": [],
                 "nextState": "VALUE_TOO_LOW"
               },
               {
                 "eventName": "turnOff",
                 "condition": "$input.AlarmStatus.status == \"OFF\"",
                 "actions": [],
                 "nextState": "OFF"
               }
             ]
           },
           "onEnter": {
             "events": [
               {
                 "eventName": "initializeVariables-1",
                 "condition": "true",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "breachLowCount",
                       "value": "0"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "breachHighCount",
                       "value": "0"
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "countValues",
                       "value": "0"
                     }
                   }
                 ]
               },
               {
                 "eventName": "normalcyCheck",
                 "condition": "$variable.returnToNormal == 1",
                 "actions": [
                   {
                     "sns": {
                       "targetArn": "arn:aws:sns:region:123456789012:IoTSiteWiseAlarmTopic",
                       "payload": {
                         "contentExpression": "'An asset property has returned to normal.\n\nAsset: ' + $input.AlarmDefinition.assetName + '\nProperty: ' + $input.AlarmDefinition.propertyName + '\nLatest value: ' + '${$input.AlarmPropertyValue.propertyValue}' + '\nLow threshold: ' + '${$input.AlarmDefinition.threshold.low}' + '\nHigh threshold: ' + '${$input.AlarmDefinition.threshold.high}' + '\nThreshold count: ' + '${$input.AlarmDefinition.thresholdCount}'",
                         "type": "STRING"
                       }
                     }
                   },
                   {
                     "setVariable": {
                       "variableName": "returnToNormal",
                       "value": "0"
                     }
                   }
                 ]
               },
               {
                 "eventName": "initializeVariables-2",
                 "condition": "true",
                 "actions": [
                   {
                     "setVariable": {
                       "variableName": "returnToNormal",
                       "value": "0"
                     }
                   }
                 ]
               }
             ]
           },
           "onExit": {
             "events": []
           }
         }
       ],
       "initialStateName": "ALARM_NOT_DEFINED"
     },
     "detectorModelDescription": "Defines a detector model for AWS IoT SiteWise alarms.",
     "detectorModelName": "AlarmThresholdMonitor",
     "evaluationMethod": "SERIAL",
     "key": "alarmId"
   }
   ```
**Note**  
This JSON object doesn't include `roleArn` for a service role that AWS IoT Events assumes to run detectors\. In this tutorial, AWS IoT Events creates a role for you when you import and publish the detector model in the AWS Management Console\. If you instead use the AWS CLI to create the detector model, `roleArn` is required\. For more information about how to define a service role for AWS IoT Events, see [Setting up permissions for AWS IoT Events](https://docs.aws.amazon.com/iotevents/latest/developerguide/iotevents-start.html#iotevents-permissions) in the *AWS IoT Events Developer Guide*\.

1. Navigate to the [AWS IoT Events console](https://console.aws.amazon.com/iotevents/)\.

1. In the left navigation pane, choose **Detector models**\.

1. Choose **Action**, and then choose **Import detector model** from the list\.  
![\[AWS IoT Events "Detector models" screenshot with "Import detector model" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/events-import-detector-model-console.png)

1. In the **Import detector model** dialog, choose **Import**, and then choose the `AlarmThresholdMonitor.json` file\.

   AWS IoT Events imports the detector model and displays it in the visual editor\.  
![\[AWS IoT Events "Detector model editor" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/events-view-imported-detector-model-console.png)

1. Choose **Publish** in the upper right\.

1. In the **Publish detector model** dialog, do the following:

   1. \(Optional\) Edit the **Detector model name** or **Description**\.

   1. In **Role**, enter a name for a new service role that AWS IoT Events creates for you, such as **IoTSiteWiseAlarmRole**\. AWS IoT Events requires permissions to send messages to the Amazon SNS topic that you created earlier\. AWS IoT Events assumes this role when it runs the detectors for this model\.

   1. For **Detector evaluation method**, choose **Serial evaluation**\.  
![\[AWS IoT Events "Publish detector model" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/events-publish-detector-model-console.png)

   1. Choose **Save and publish**\.

   Your alarm detector model publishes\.  
![\[AWS IoT Events "Detector models" screenshot with the alarm detector model.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/events-publish-detector-model-success-console.png)

## Creating a Lambda function to send asset property values to AWS IoT Events<a name="alarm-tutorial-create-message-lambda"></a>

In AWS IoT SiteWise you can enable asset property value notifications to send an MQTT message to AWS IoT Core for every new value received\. In this procedure, you create a Lambda function that parses this message and sends property value updates to an input in AWS IoT Events\. When AWS IoT Events receives the data, it sends the value through an alarm detector to check if the values exceed alarm thresholds\.

**To create a Lambda function for the alarm detection system**

1. Navigate to the [Lambda console](https://console.aws.amazon.com/lambda/)\.

1. Choose **Create function**\.

1. On the **Create function** page, do the following:

   1. Choose **Author from scratch**\.

   1. In **Function name**, enter **IoTSiteWiseAlarmPayloadConverter**\.

   1. For **Runtime**, choose **Python 3\.7**\.

   1. For **Execution role**, choose **Create a new role with basic Lambda permissions**\.

   1. Choose **Create function**\.  
![\[Lambda "Create function" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/lambda-create-conversion-function-console.png)

   The page for your new function opens\.  
![\[Lambda "Function" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/lambda-create-function-success-console.png)

1. In the inline code editor under **Function code**, paste the following Lambda function code\.

   ```
   import boto3
   import json
   import uuid
   
   # Flattens messages produced by AWS IoT SiteWise to feed to AWS IoT Events.
   def lambda_handler(event, context):
       print("Received raw message from AWS IoT Core.")
   
       messages = []
       # Flatten the list of values from AWS IoT SiteWise into messages for AWS IoT Events.
       for value in event["values"]:
   		# Include only good quality values.
           if value["quality"] == "GOOD":
               payload = {
                   "alarmId": event["alarmId"]
               }
               if "doubleValue" in value["value"]:
                   payload["propertyValue"] = float(value["value"]["doubleValue"])
               elif "integerValue" in value["value"]:
                   payload["propertyValue"] = int(value["value"]["integerValue"])
               else:
                   continue  # Filter out non-numeric values.
               message = {
                   "messageId": str(uuid.uuid4()),
                   "inputName": "AlarmPropertyValue",
                   "payload": json.dumps(payload)
               }
               messages.append(message)
       
       # Send the flattened messages to AWS IoT Events.
       iote_client = boto3.client("iotevents-data")
       response = iote_client.batch_put_message(messages=messages)
       status = int(response["ResponseMetadata"]["HTTPStatusCode"])
       if status == 200:
           print("Successfully wrote %d values to AWS IoT Events." % (len(messages)))
       else:
           print("Failed to write values to AWS IoT Events. Status code: %d" % (status))
   ```

1. Choose **Save**\.

Lambda requires permissions to send messages to AWS IoT Events when the function runs\. In this procedure, you add the required permissions to the function's role so that Lambda can successfully run the function\.

**To allow Lambda to send messages to AWS IoT Events when the function runs**

1. On the function's page, choose the **Permissions** tab\.  
![\[Lambda "Function" page screenshot with the "Permissions" tab highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/lambda-choose-permissions-console.png)

1. Choose the **Role name**, such as **IoTSiteWiseAlarmPayloadConverter\-role\-r98v76r9**, to open the role in the IAM console\.

1. On the page for the Lambda execution role, choose **Attach policies**\.  
![\[IAM "Role" page screenshot with the "Attach policies" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/lambda-iam-attach-policy-console.png)

1. Choose **Create policy**\.

   The **Create policy** page opens in a new tab\.

1. On the **Create policy** page, do the following:

   1. Choose the **JSON** tab to open the JSON editor\.

   1. Enter the following policy that allows the role to send messages to AWS IoT Events\. Replace *region* and *account\-id* with your Region and AWS account ID\.

      ```
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Sid": "PutAlarmPropertyValues",
            "Effect": "Allow",
            "Action": "iotevents:BatchPutMessage",
            "Resource": "arn:aws:iotevents:region:account-id:input/AlarmPropertyValue"
          }
        ]
      }
      ```

   1. Choose **Review policy**\.  
![\[IAM "Create policy" page screenshot with the "Review policy" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/iam-create-alarm-values-put-policy-console.png)

1. On the **Review policy** page, do the following:

   1. In **Name** enter **IoTSiteWiseAlarmPropertyValuePolicy**\.

   1. \(Optional\) Enter a description for the policy\.

   1. Choose **Create policy**\.  
![\[IAM "Create policy" page screenshot with the "Create policy" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/iam-create-alarm-values-put-policy-finish-console.png)

      Your policy is created but not added to the role\.

1. Return to the browser tab with IAM open to add permissions to the function's execution role\.

1. Choose the box for the new policy, **IoTSiteWiseAlarmPropertyValuePolicy**\. You might need to filter or refresh the policies table to find the policy\.

1. Choose **Attach policy**\.  
![\[IAM "Add permissions" page screenshot with the "Attach policy" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/iam-attach-alarm-values-put-policy-console.png)

   The policy attaches to the Lambda function's execution role\.  
![\[IAM "Role" page screenshot that shows a policy attached.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/alarm-tutorial/iam-attach-alarm-values-put-policy-success-console.png)

Your alarm detection system is configured\. You can now configure alarms for your asset properties in AWS IoT SiteWise\. For more information, see [Configuring alarms](alarm-tutorial-configure-alarms.md)\.
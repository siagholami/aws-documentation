# Send inputs to test the detector model<a name="iotevents-iot-rules-engine"></a>

There are several ways to receive telemetry data in AWS IoT Events \(see [Supported actions](iotevents-supported-actions.md)\)\. This topic shows you how to create an AWS IoT rule in the AWS IoT console that forwards messages as inputs to your AWS IoT Events detector\. You can use the AWS IoT console's MQTT client to send test messages\. You can use this method to get telemetry data into AWS IoT Events when your devices are able to send MQTT messages using the AWS IoT message broker\.

**To send inputs to test the detector model**

1. Open the [AWS IoT core console](https://console.aws.amazon.com/iot/)\. In the navigation pane, choose **Act**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/select-act.png)

1. On the **Rules** page, choose **Create**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/rules-create.png)

1. On the **Create a rule** page, enter a **Name** and **Description**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/rule-name.png)

1. In the **Rule query statement**, enter the following\.

   ```
   SELECT *, topic(2) as motorid FROM 'motors/+/status'
   ```  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/rule-query-stmt.png)

1. In **Set one or more actions**, choose **Add action**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/add-action.png)

1. On the **Select an action** page, select **Send a message to an AWS IoT Events Input** and choose **Configure action**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/select-events-action.png)

1. On the **Configure action** page, do the following:

   1. For **Input name**, enter the name that you created in the previous section\.

   1. For **Role**, choose **Create Role** and in the **Create a new role** window, enter a **Name** and choose **Create role**\. This creates a role with permission to forward messages to AWS IoT Events\.

   1. Back on the **Configure action** page, choose **Add action**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/configure-action.png)

1. On the **Create a rule** page, choose **Create rule**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/select-create-rule.png)

1. On the **Rules** page, in the navigation pane, choose **Test**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/go-test.png)

1. On the **MQTT client** page, choose **Publish to a topic**\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/publish-topic.png)

1. In the **Publish** section, enter the topic, enter the following payload in the editor, and choose **Publish**\.

   ```
   {
     "sensorData": {
       "pressure": 23,
       "temperature": 47
     }
   }
   ```  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/publish-message-1.png)

1. For **Publish**, keep the topic the same, but change the `"pressure"` in the payload to a value greater than the threshold value that you specified in the detector model \(for example, **85**\)\.  
![\[Test a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/publish-message-2.png)

1. Choose **Publish**\.

 The detector instance that you created generates and sends you an SNS message\. Continue to send messages with pressure readings above or below the pressure threshold \(70 for this example\) to see the detector in operation\. 

In this example, you must send three messages with pressure readings below the threshold to transition back to the **Normal** state and receive an SNS message that indicates the overpressure condition has cleared\. Once back in the **Normal** state, one message with a pressure reading above the limit causes the detector to enter the **Dangerous** state and send an SNS message indicating that condition\.

Now that you created a simple input and detector model, try the following\.
+ See more detector model examples \(templates\) on the console\.
+ Follow the steps in [Simple step\-by\-step example](iotevents-simple-example.md) to create an input and detector model using the AWS CLI
+ Learn details of the [Using expressions](iotevents-expressions.md) used in events\. 
+ Learn about [Supported actions](iotevents-supported-actions.md)\.
+ If something isn't working, see [Troubleshooting AWS IoT Events](iotevents-troubleshooting.md)\.
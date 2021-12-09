# Create an input<a name="iotevents-detector-input"></a>

In this topic, you define an *input* to receive telemetry data \(messages\)\.

1. Open the [AWS IoT Events console](https://console.aws.amazon.com/iotevents/)\.

1. In the AWS IoT Events console, choose **Create detector model**\.  
![\[Create a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/start.png)

1. Choose **Create new**\.  
![\[Create a detector model in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/welcome.png)

1. When you construct your detector models and inputs, you might want to gather files containing example message payloads that your devices or processes send to report their status\. This makes it easier for you to define the inputs that you need\.  
**Example**  

   For this example, on your local file system, create a file named `input.json` with the following contents\.

   ```
   {
     "motorid": "Fulton-A32",
     "sensorData": {
       "pressure": 23,
       "temperature": 47
     }
   }
   ```

1. Choose **Create input**\.  
![\[Create an input in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-input.png)

1. For the input, enter an **InputName**, a **Description**, and choose **Upload file**\. In the dialog box, choose the JSON file that contains the example message \("input\.json"\)\.   
![\[Create an input in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-input-name.png)

1. For **Choose input attributes**, select the attributes to use and choose **Create**\. This example selects **motorid** and **sensorData\.pressure** but doesn't use **sensorData\.temperature**\.   
![\[Create an input in the AWS IoT Events console.\]](http://docs.aws.amazon.com/iotevents/latest/developerguide/images/create-input-attr.png)
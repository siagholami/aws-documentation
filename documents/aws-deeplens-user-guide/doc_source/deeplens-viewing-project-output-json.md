# View Your AWS DeepLens Project Output in the AWS IoT Console<a name="deeplens-viewing-project-output-json"></a>

After a successful project deployment, your deployed AWS DeepLens project starts to run on your registered AWS DeepLens device\. If the Lambda function of your project uses the AWS IoT Greengrass SDK \(`greengrasssdk`\) to publish text\-based messages to AWS IoT, including JSON\-formatted inference results as is done in all of the AWS DeepLens sample projects, you can view such project output using the [AWS IoT Core console](https://docs.aws.amazon.com/iot/latest/developerguide/iot-console-signin.html)\.

If the inference Lambda function uses the [OpenCV Library](https://opencv.org/) \(`cv2`\) module to output inference results as video feeds, you can view the video output using a web browser or connecting to the device directly a monitor, mouse and keyboard\. However, viewing text\-based project output is more economical to verify that your deployed project runs as expected\. <a name="deepelens-view-project-json-output-procedure"></a>

**To view your AWS DeepLens project out in the AWS Management Console for AWS IoT Core**

1. Open the AWS DeepLens console and make sure to choose the **US N\. Virginia** region\.

1.  From the AWS DeepLens primary navigation pane, choose **Devices** and then choose your AWS DeepLens project\.

1.  From the **Device details** page of selected device, copy the **MQTT** topic value, of the `$aws/things/deeplens_<uuid>/infer` format\. You will need to paste this AWS IoT topic ID in the AWS IoT console that you'll open next\.

1. Open the [AWS Management Console for IoT Core](https://console.aws.amazon.com/iot/home?region=us-east-1#/home) and make sure to choose **US North Virginia** region\.

1.  From the primary navigation pane, choose **Test**\.

1.  Under **Subscription topic** on the **MQTT client** page, paste the AWS IoT topic ID \(coped in **Step 3** above\) into the **Subscription topic** input field\. Then, choose **Subscribe to topic**\.

1. Inspect the display of the results that your inference Lambda function publishes by calling the `greengrasssdk.publish` method\. The following AWS IoT console display shows example results published by the [Cat\-and\-dog\-recognition sample project function](deeplens-inference-lambda-create.md):  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-view-project-output-json-result.png)
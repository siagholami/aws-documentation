--------

--------

# Troubleshoot Issues with AWS IoT Things Graph<a name="tg-troubleshooting"></a>

Use the following information to help troubleshoot issues in AWS IoT Things Graph\.

If your deployment target is an AWS IoT Greengrass group, you might run into issues that relate directly to AWS IoT Greengrass\. For AWS IoT Greengrass troubleshooting information, see [Troubleshooting AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html)\. You also need to configure your AWS IoT Greengrass group to work with AWS IoT Things Graph\. For information about setting up an environment for deploying AWS IoT Things Graph workflows \(flows\), see [Setting Up Your Environment](https://docs.aws.amazon.com/thingsgraph/latest/ug/iot-tg-gs-environment.html)\.

## General Deployment Issues with AWS IoT Things Graph<a name="gg-troubleshooting-issues-general"></a>


| Symptom | Solution | 
| --- | --- | 
| In the AWS IoT Things Graph console, you see **Deployed in target** in the **Status** column for your system instance, but your flow isn't running\. ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGDeploySuccess.png)  |  The deployment to your AWS IoT Greengrass might have failed\.  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/tg-troubleshooting.html) When you deploy a flow for the first time, a file named **thingsgraph\.db** appears in the **thingsgraph** directory that you created at the root of your AWS IoT Greengrass core device\. You can verify that the flow is running by checking the **ThingsGraph\.log** file in the **/greengrass/ggc/var/log/user/*region*/ThingsGraph** directory\. In that file, you should see the following entry, which indicates that the trigger condition has been met and the flow has started\. <pre><br />                        FlowSchedulerClientGreengrassImpl: StartFlowExecution:<br />                    </pre>  | 
| Your flow contains a service that exposes the capability of an AWS Lambda function\. \(For an example that contains these kinds of services, see [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html)\.\) The AWS IoT Greengrass deployment fails with an error message indicating that the Lambda function doesn't exist in your AWS IoT Greengrass group\. | On the AWS IoT console \([https://console\.aws\.amazon\.com/iot/](https://console.aws.amazon.com/iot/)\), go to the **AWS IoT Greengrass** tab\. Choose the AWS IoT Greengrass group you're using for AWS IoT Things Graph flow deployments, and then choose the **Lambdas** tab\.  Verify that you've added the Lambda function used in your service to the group\. Also verify that you're using the correct version of the function\. For example, the AWS IoT Things Graph services used in [Creating a Flow with Lambda Functions](iot-tg-gs-lambda-sample.html) require you to add version 1 of each function to your group\.  | 

## Modbus Flow Deployment Issues with AWS IoT Things Graph<a name="gg-troubleshooting-issues-modbus"></a>


| Symptom | Solution | 
| --- | --- | 
| Your flow contains a Modbus device\. The flow appears to have deployed, but it isn't running\. | Make sure that you've installed the [Modbus\-RTU Protocol Adapter](https://docs.aws.amazon.com/greengrass/latest/developerguide/modbus-protocol-adapter-connector.html)\. | 
| Your flow contains a Modbus device\. The AWS IoT Greengrass deployment fails with this error: unable to load the group file downloaded file Path path doesn't exist\. | Make sure that you've added your device to your AWS IoT Greengrass group as a local resource\. For instructions about how to add local resources to a group, see [Access Local Resources with Lambda Functions](https://docs.aws.amazon.com/greengrass/latest/developerguide)\. Because AWS IoT Things Graph runs as a Lambda function on your core device, you don't have to add a Lambda function\. AWS IoT Things Graph uses this local resource\. Also make sure that the source path for your device \(which represents the physical Modbus serial port\) is correct on the AWS IoT Greengrass tab on the AWS IoT console \([https://console\.aws\.amazon\.com/iot/](https://console.aws.amazon.com/iot/)\)\. | 
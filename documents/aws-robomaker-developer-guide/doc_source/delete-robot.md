# Deleting a Robot<a name="delete-robot"></a>

When you no longer need a robot, you can delete it\. You can delete a robot that is unregistered or registered as part of a fleet, even if there is an active deployment to the fleet\.

The AWS IoT Greengrass group and other assets created for the robot by AWS RoboMaker are not deleted\. You can create a new robot and reuse the group\. To delete AWS IoT Greengrass resources, use the [https://console\.aws\.amazon\.com/iot/](https://console.aws.amazon.com/iot/)\.

**To delete a robot**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-delete-robot-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet Management**, and then choose **Robots**\.

1. Select the robot you want to delete, then choose **Delete**\.
**Note**  
To delete the underlying AWS IoT Greengrass group and resources, use the [https://console\.aws\.amazon\.com/iot/](https://console.aws.amazon.com/greengrass/)\.

------
#### [ Using the AWS CLI ]<a name="proc-delete-robot-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based delete robot on the other tab\.  
To delete the underlying AWS IoT Greengrass group and resources, use the [https://console\.aws\.amazon\.com/iot/](https://console.aws.amazon.com/greengrass/)\.

```
$ aws robomaker delete-robot --robot my-robot-application-arn
```

------
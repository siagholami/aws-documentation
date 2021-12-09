# Deleting a Robot Application Version<a name="delete-robot-application-version"></a>

Delete robot application versions you no longer need\.

**To delete a robot application version**  
Follow the steps under one of these tabs\.

------
#### [ Using the console ]<a name="proc-delete-robot-application-version-con"></a>

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)` \.

1. In the left navigation pane, choose **Development**, then choose **Robot applications**\.

1. Choose the **Name** of the robot application to see its versions\.

1. In the robot detail page, choose the **Version** to see version details\.

1. In the robot application version details page, choose **Delete**, and then choose **Delete** to confirm\.

------
#### [ Using the AWS CLI ]<a name="proc-delete-robot-application-version-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based steps\.  

```
$ aws robomaker delete-robot-application--version --application my-robot-application-arn --version 1.5
```

------
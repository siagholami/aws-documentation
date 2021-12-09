# Deleting a Robot Application<a name="delete-robot-application"></a>

When you no longer need a AWS RoboMaker robot application and all of its versions, delete it\.

**To delete a robot application**  
Follow the steps under one of these tabs\.

------
#### [ Using the console ]<a name="proc-delete-robot-application-con"></a>

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)` \.

1. In the left navigation pane, choose **Development**, then choose **Robot applications**\.

1. Choose the **Name** of a robot application to see details including the time it was created and last updated\.

1. In the robot application detail page, choose **Delete** and then choose **Delete** to confirm\.

------
#### [ Using the AWS CLI ]<a name="proc-delete-robot-application-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based steps\.  

```
$ aws robomaker delete-robot-application --application my-robot-application-arn
```

------
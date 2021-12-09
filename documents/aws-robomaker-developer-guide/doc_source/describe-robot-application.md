# Viewing a Robot Application<a name="describe-robot-application"></a>

View the details of your robot application including Amazon S3 location, version, and supported architectures\.

**To see the details of a robot application**  
Follow the steps under one of these tabs\.

------
#### [ Using the console ]<a name="proc-describe-robot-application-con"></a>

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)`\.

1. In the left navigation pane, choose **Development**, then choose **Robot applications**\.

1. Choose the **Name** of a robot application\.

------
#### [ Using the AWS CLI ]<a name="proc-describe-robot-application-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based steps\.  

```
$ aws robomaker describe-robot-application --application my-robot-application-arn
```

------
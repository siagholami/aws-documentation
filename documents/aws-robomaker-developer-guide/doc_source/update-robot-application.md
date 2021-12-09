# Updating a Robot Application<a name="update-robot-application"></a>

Update a robot application\.

**To update a robot application**  
Follow the steps under one of these tabs\.

------
#### [ Using the console ]<a name="proc-update-robot-application-con"></a>

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)`\.

1. In the left navigation pane, choose **Development**, then choose **Robot applications**\.

1. Check the box next to the robot application you want to update\.

1. Choose **Actions**, then choose **Update**\.

1. You can add or remove sources, but you must have at least one source robot application file\. 

1. Choose **Update** to update the robot application\.

------
#### [ Using the AWS CLI ]<a name="proc-update-robot-application-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based steps\.  

```
$ aws robomaker update-robot-application ---application my-robot-application-arn --robot-software-suite name=ROS,version=Melodic --sources architecture=X86_64,s3Bucket=my-bucket,s3Key=my-folder/cloud-watch-robot.tar
```

------
# Creating a Robot Application Version<a name="create-robot-application-version"></a>

When you create a robot application, there is only one version—the `$LATEST` version\. The `$LATEST` version can be updated with new a new version of the application any time\. If many people are making changes, or the robot application is updated frequently, you might not know all the details about the `$LATEST` version\. 

When you create a robot application version, you create an immutable snapshot of the `$LATEST` version\. It cannot be updated, so it will not change even if the `$LATEST` version is updated\. This is useful for deployments, when you need to have the same version on all of the robots in a fleet\.

You can use any version of a robot application when you create a simulation job\. For deployments, you must use a numbered version\.

**To create a robot application version**  
Follow the steps under one of these tabs\.

------
#### [ Using the console ]<a name="proc-create-robot-application-version-con"></a>

1. Sign in to the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)`\.

1. In the left navigation pane, choose **Development**, and then choose **Robot applications**\.

1. Choose the robot application **name**\.

1. In the **Robot applications details** page, choose **Create new version**, and then choose **Create**\.

------
#### [ Using the AWS CLI ]<a name="proc-create-robot-application-version-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based steps\.  

```
$ aws robomaker create-robot-application-version --name my-robot-application-arn 
```

------
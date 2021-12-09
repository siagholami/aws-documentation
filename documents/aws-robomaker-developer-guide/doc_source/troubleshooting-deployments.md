# Troubleshooting Deployments<a name="troubleshooting-deployments"></a>

This section can help you fix issues when deploying a robot application to a fleet\.

## My Deployment Failed<a name="troubleshooting-deployments-failed"></a>

See the following topics for common solutions\.

### Is Your Robot Part of a Fleet?<a name="troubleshooting-deployments-notfleet"></a>

A robot must be part of a fleet to receive a deployment\. To check the status of your robots in the AWS RoboMaker console, expand **Fleet management** and then choose **Robots**\. Robots that are registered to a fleet will include the **Fleet name**\. 

### Is AWS IoT Greengrass Running on Your Robot?<a name="troubleshooting-deployments-greengrass-not-started"></a>

To configure and run the AWS IoT Greengrass core software, follow the steps in [Module 1: Environment Setup for Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html), then follow the steps in [Start AWS Greengrass on the Core Device](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-device-start.html)\. 

### Is a Resource Missing?<a name="troubleshooting-deployments-resource-not-found"></a>

In the deployment details page, review the **Failure reason**\. It will list the missing resource\. Verify that the resource exists\. For example, if the robot application is missing, it might have been deleted from the Amazon S3 location\. Also, the Amazon S3 ETag information might be incorrect\. 

### Did the AWS IoT Greengrass Deployment Encounter a Problem?<a name="troubleshooting-deployments-gg-deployment"></a>

In the deployment details page, review the **Failure reason**\. It will contain more details\.

If AWS IoT Greengrass has problems starting or restarting, look at the AWS IoT Greengrass system logs located on the robot at `/greengrass/ggc/var/log/system/runtime.log`\.

To troubleshoot, see [Troubleshooting AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html)\. 

### Do you get Error x509: Certificate Signed by Unknown Authority?<a name="troubleshooting-deployments-gg-certificate"></a>

This error might occur if you recently updated your certification or configuration files from AWS RoboMaker or AWS IoT Greengrass in your robot\. The error appears in the log, `/greengrass/ggc/var/log/system/runtime.log`\. To resolve, upgrade `root.ca.pem` in your robot\. To upgrade, follow step 5 in [Start AWS IoT Greengrass on Core Device](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-device-start.html)\. 

### Was the Failure Threshold Breached?<a name="troubleshooting-deployments-failure-threshold"></a>

Deployment stops if the failure threshold is exceeded\. You can raise the threshold to attempt to deploy to more of your fleet\. 

### Is the Deployment Taking Longer Than Expected?<a name="troubleshooting-deployments-stuck-deploying"></a>

Deployment time depends on the size of the robot application package\. It also depends on the robot network conditions\. If you have many robots and are deploying few concurrently, deployment might take longer\. 

Once started, a single robot deployment timeout is five hours\. Use the deployment detail page to identify robots that have an active deployment\. Use `SSH` to connect\. Use the command `ps aux | grep 'greengrass'` to verify AWS IoT Greengrass is running\. To troubleshoot, see [Troubleshooting AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html)\. 

### Did Your Robot Receive the Deployment Request?<a name="troubleshooting-deployments-receive-request"></a>

Your robot might not receive the deployment request if AWS IoT Greengrass is not properly configured and running\. 

First, verify that your robot received the deployment request\. `SSH` to the robot\. Once connected, use `s aux | grep 'greengrass'` to see if AWS IoT Greengrass is running\. check for errors in the log located at `/greengrass/ggc/var/log/user/region/account/aws-robomaker-deployment-function-robot architecture_DO_NOT_DELETE.log`\.

If there are no errors in the log, make sure you have AWS IoT Greengrass version 1\.7\.0 or later installed\. See [Module 1: Environment Setup for Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html) for more information\.

Next, make sure AWS IoT Greengrass is running with the following command\.

```
ps aux | grep 'greengrass'
```

If it is running, look at the AWS IoT Greengrass system logs located on the robot at `/greengrass/ggc/var/log/system/runtime.log`\. See [Troubleshooting AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html) for additional troubleshooting information\.

### Will an Offline Robot get the Newest Deployment or the Last Deployment to Succeed?<a name="troubleshooting-deployments-robotagentresponsetimeoutexception"></a>

If you received the `RobotAgentResponseTimeoutException` in a new deployment because a robot is unavailable, when it becomes available it downloads the latest \(timed out\) deployment\. The robot status is updated after the robot finishes deployment\. The status changes from `NoResponse` to `InSync`\. 

### Are you Trying to Override Environment Variables Sourced in Bundle Setup Scripts?<a name="troubleshooting-deployments-failure-rosvars"></a>

Environment variables that are sourced from setup bundle scripts can override similar variables that are defined when a job is created\. To avoid this issue, define a new, unique environment variable or change values used in the setup scripts\. 

### ROS did not Restart on Device Reboot<a name="troubleshooting-deployments-failure-no-restart"></a>

Failure to restart happens when the AWS IoT Greengrass daemon is not configured to run on restart\. To modify the device `init` system to run the AWS IoT Greengrass daemon, see [Configure the Init System to Start the Greengrass Daemon](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-core.html#start-on-boot)\. 

### ROS Needs Root Privilege<a name="troubleshooting-deployments-failure-need-root"></a>

You can grant the `ggc_user` root privilege permission by configuring the Linux user profile in `/etc/passwd`\. You can set the `user_id` and `group_id` to `0`\. Use the following command\.

name:password:user\_ID:group\_ID:gecos:home directory:shell ggc\_user:x:*0*:*0*::/home/ggc\_user:/bin/false 

### Managing the Robot Application and Default ROS HOME Directories<a name="troubleshooting-deployments-failure-clean-up"></a>

AWS IoT Greengrass currently downloads the robot application to the `/home/ggc_user` folder if it was created when you created the **ggc\_user**\. Otherwise, it downloads to `/tmp/roboMakerDeploymentPackage`\. The `/tmp` directory may be cleaned up on reboot\.

If you don’t want the bundle to be removed after the reboot, ensure the directory `/home/ggc_user` exists and **ggc\_user** has read and write permissions\. 

The default `ROS_HOME` directory is `/home/ggc_user/ros/home/deployment-id`\. If the **ggc\_user** home directory does not exist, the default directory is `/tmp/ros/home/deployment-id`\. You can also specify the `ROS_HOME` directory by adding it into the environment variables when you create a deployment job\. The **ggc\_user** must have read and write permissions to the folder\.

If `/tmp/roboMakerDeploymentPackage` was added to `tmpfiles.d` configuration file to persist it to the `tmp` folder, remove it\. 

**Note**  
AWS RoboMaker deployment cleans the robot application folder\. It does not clean the `ROS_HOME` folder\. Use a pre\-deployment or post\-deployment script to manage the directory\. 

## How do I Use Local Libraries on Robot?<a name="troubleshooting-deployments-use-local-libs"></a>

You can override or link the deployed bundle to use local ROS libraries\. To do this, provide environment variables when you create the deployment job\. For example, set `ROS_ROOT` to the local ROS\. 

```
"ROS_ROOT":"/opt/ros/kinetic/share/ros"
```
--------

--------

# Setting Up Your Environment for AWS IoT Greengrass Deployments<a name="iot-tg-gs-environment"></a>

This topic describes the tasks you need to do to start working with AWS IoT Things Graph\. You can't deploy and run a flow successfully until you perform the these tasks\. 

Before you get started, make sure that you have an [AWS account](http://aws.amazon.com)\.

## Create an AWS IoT Greengrass Group<a name="iot-tg-gs-environment-gg"></a>

**Note**  
For information about using AWS CloudFormation to create and manage AWS IoT Greengrass groups and resources, see [AWS IoT Greengrass Resource Types Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/AWS_Greengrass.html)\.

To perform the tasks related to setting up your AWS IoT Greengrass core, you need a Mac, Windows, or Linux or Unix system\. The setup instructions in [Getting Started with AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-gs.html) recommend that you start with a Raspberry Pi\.

1. Download and install the AWS IoT Greengrass core software\.

   Follow the instructions in [Installing AWS IoT Greengrass Core Software](https://docs.aws.amazon.com/greengrass/latest/developerguide/module2.html)\.

1. Start the AWS IoT Greengrass software\.

   Follow the instructions in [Deploy Cloud Configurations to an AWS IoT Greengrass Core Device](https://docs.aws.amazon.com/greengrass/latest/developerguide/configs-core.html) to start AWS IoT Greengrass\.

1. Create a directory named **thingsgraph** at the root directory of your AWS IoT Greengrass core device\. AWS IoT Things Graph installs files in this location\. This directory must have read, write, and execute permissions for `ggc_user`\. If your AWS IoT Greengrass core is using a Unix\-like operating system, set these permissions by entering the following commands at a command prompt\.

   `sudo chown ggc_user: /thingsgraph`

   `sudo chmod 700 /thingsgraph`

   The AWS IoT Things Graph logs go into the `/greengrass/ggc/var/log/user/us-east-1/ThingsGraph/` directory\. For information about how to configure AWS IoT Greengrass logs, see [Monitoring with AWS IoT Greengrass Logs](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html)\.

1. Create an [IAM role for AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/config-iam-roles.html) and attach the policies that your flows will need to interact with other AWS services when they're running\. 

   For example, a flow that needs to read and write to an Amazon S3 bucket needs to have the `AmazonS3FullAccess` policy attached to it\. 

1. When AWS IoT Things Graph installs a flow to your AWS IoT Greengrass core, it first uploads a file that contains all of the flow's dependencies to an Amazon S3 bucket\. It then installs the flow and its dependencies from the bucket\. This means that the AWS IoT Greengrass service needs permission to access this bucket\. 

   In the IAM console \([https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\), choose **Roles**\. Select the role named **Greengrass\_ServiceRole**, and attach the `AmazonS3FullAccess` policy to give it access to your S3 bucket\.

## Install Java<a name="iot-tg-gs-environment-java"></a>

To run AWS IoT Things Graph, your AWS IoT Greengrass core device needs to have [Java 8](https://www.java.com/en/download/) installed\. 

If you're using a Linux environment, follow these steps to install the correct version of Java\. See the Java website for instructions on installing Java 8 on Windows and Mac environments\.

1. Run the following command to install Java 8\.

   `sudo yum install java-1.8.0`

1. Run the following command to uninstall Java 7\.

   `sudo yum remove java-1.7.0-openjdk`

1. Run the following command to create a symlink to the newly installed version of Java\.

   `sudo ln /etc/alternatives/java /usr/bin/java8`
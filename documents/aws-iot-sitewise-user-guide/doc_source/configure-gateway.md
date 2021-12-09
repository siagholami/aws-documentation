# Configuring a gateway<a name="configure-gateway"></a>

A gateway serves as the intermediary between your OPC\-UA servers and AWS IoT SiteWise\. You can easily deploy the AWS IoT SiteWise gateway software on any platform that can run AWS IoT Greengrass\. For more information, see [Choosing a gateway platform](choose-gateway-platform.md)\.

To configure a gateway that runs on Amazon EC2, you can create the required dependencies from an AWS CloudFormation template\. For more information, see [Configuring gateway dependencies on Amazon Elastic Compute Cloud](configure-ec2-gateway.md)\.

**Note**  
We recommend that you complete the following steps with someone who has IT administrative access to your local and corporate networks\. These steps might require someone with knowledge of your OPC\-UA servers and the authority to configure firewall settings\.

**Topics**
+ [Setting up the gateway environment](#setup-gateway)
+ [Creating an IAM policy and role](#create-iam-resources)
+ [Configuring an AWS IoT Greengrass group](#attach-iam-role)
+ [Configuring the AWS IoT SiteWise connector](#setup-connector)
+ [Adding the gateway to AWS IoT SiteWise](#add-gateway)
+ [Configuring gateway dependencies on Amazon Elastic Compute Cloud](configure-ec2-gateway.md)

## Setting up the gateway environment<a name="setup-gateway"></a>

In this procedure, you install AWS IoT Greengrass and configure your gateway to use with AWS IoT SiteWise\.

**Note**  
This section includes instructions to install packages using the `apt` command\. This is applicable to systems running Ubuntu or similar\. If you aren't using a similar system, consult the documentation for your distribution and use the recommended package installer\.

**To set up the gateway**

1. As appropriate, modify the [BIOS](https://en.wikipedia.org/wiki/BIOS) settings of the gateway as follows\.

   1. Ensure that the gateway automatically restarts after a potential power failure, if applicable\.

   1. Ensure that the gateway won't hibernate or sleep, if applicable\.

1. Ensure that the gateway connects to the internet\.

1. \(Optional\) To use the gateway without the mouse, keyboard, and monitor, do the following steps to set up `ssh` on the gateway:

   1. If you haven't already installed the SSH package, run the following command\.

      ```
      sudo apt install ssh
      ```

   1. Run the following command\.

      ```
      service ssh status
      ```

   1. Search for `Active: active (running)` in the output to confirm that the SSH server is running, 

   1. Press **Q** to exit\.

   Run the following command to use SSH to connect to the gateway from another computer\. Replace *username* with the user login and *IP* with the IP address of the gateway\.

   ```
   ssh username@IP
   ```

   You can use the `-p port-number` argument to connect to a port other than the default port 22\.

1. Download and install AWS IoT Greengrass Core software v1\.10\.0 or later, and create an AWS IoT Greengrass group for your gateway\. To do so, follow the instructions in [Getting started with AWS IoT Greengrass](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-gs.html) in the *AWS IoT Greengrass Developer Guide*\.

   We recommend that you run the [AWS IoT Greengrass device setup](https://docs.aws.amazon.com/greengrass/latest/developerguide/quick-start.html) script to quickly get started\. If you want to review AWS IoT Greengrass requirements and processes more closely, you can walk through the steps in [Module 1](https://docs.aws.amazon.com/greengrass/latest/developerguide/module1.html) and [Module 2](https://docs.aws.amazon.com/greengrass/latest/developerguide/module2.html) to set up AWS IoT Greengrass\.
**Important**  
Review the [AWS Regions](getting-started.md#requirements) where AWS IoT SiteWise is supported\. When you choose a Region for AWS IoT Greengrass, make sure that the Region also supports AWS IoT SiteWise\. Otherwise, you can't connect your gateway to AWS IoT SiteWise\.

   Before you continue to the next step, you should have AWS IoT Greengrass Core software installed on your gateway\.

1. Run the following commands to install Java 8\.

   ```
   sudo apt update
   sudo apt install openjdk-8-jre
   ```

   The AWS IoT SiteWise gateway software that you install later in this guide uses a Java 8 runtime\.

1. Run the following command to verify that Java installed successfully\.

   ```
   java -version
   ```

1. The AWS IoT Greengrass Core software assumes a `java8` directory\. Run the following command to link your Java installation to that `java8` directory\.

   ```
   sudo ln -s /usr/bin/java /usr/bin/java8
   ```

1. Run the following command to create a `/var/sitewise` data directory and give the `ggc_user` permissions for that directory\. AWS IoT SiteWise stores data in this directory\. You created the `ggc_user` when you set up AWS IoT Greengrass earlier in this procedure\.

   ```
   sudo mkdir /var/sitewise 
   sudo chown ggc_user /var/sitewise
   sudo chmod 700 /var/sitewise
   ```

   The `/var/sitewise` is the default directory that AWS IoT SiteWise uses\. You can customize the directory path \(for example, replace `/var/sitewise` with `/var/custom/path/`\), but doing so requires extra steps after the AWS IoT SiteWise gateway is created\. For more information, see step 6 in [Configuring the AWS IoT SiteWise connector](#setup-connector)\.

1. If needed, ask your IT administrator to add the following endpoints and ports to your local network allow list:
   + Ports: 443, 8443, and 8883
**Important**  
You can configure AWS IoT Greengrass Core to use only port 443 for all network communications\. For more information, see [Connect on port 443 or through a network proxy](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-core.html#alpn-network-proxy) in the *AWS IoT Greengrass Developer Guide*\.
   + The IP address of your gateway \(port 443\)\. To obtain the IP address, run the `ip address` or `ifconfig` command and note the `inet` value \(for example, `203.0.113.0`\)\.
   + The AWS IoT SiteWise data endpoint: `data.iotsitewise.region.amazonaws.com` \(port 443\)\.
   + The following AWS endpoints that the gateway uses\. You can find these in the `/greengrass-root/config/config.json` file\. Replace *greengrass\-root* with the root of your AWS IoT Greengrass installation\.
     + *ggHost*: `greengrass-ats.iot.region.amazonaws.com` \(ports 443, 8443, and 8883\)\.
     + *iotHost*: `prefix-ats.iot.region.amazonaws.com` \(ports 443, 8443, and 8883\)\.

     For more information, see [AWS IoT Greengrass endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/greengrass.html)\.

1. If the AWS IoT Greengrass Core software isn't already running, run the following command to start the AWS IoT Greengrass Core software\. Replace *greengrass\-root* with the root of your AWS IoT Greengrass installation\. The default *greengrass\-root* is `/greengrass`\.

   ```
   cd /greengrass-root/ggc/core
   sudo ./greengrassd start
   ```

   You should see this message: `Greengrass successfully started with PID: some-PID-number`

1. Configure the AWS IoT Greengrass Core software to automatically start when your gateway turns on\. Consult the documentation for your gateway's operating system\.

## Creating an IAM policy and role<a name="create-iam-resources"></a>

You must create an AWS Identity and Access Management \(IAM\) policy and role to allow the gateway to access AWS IoT SiteWise on your behalf\.

**To create an IAM policy and role**

1. Navigate to the [IAM console](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**, and then choose **Create policy**\.  
![\[IAM "Policies" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-create-iam-policy-console.png)

1. On the **JSON** tab, delete the current contents of the policy field, and paste the following policy into the field\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": "iotsitewise:BatchPutAssetPropertyValue",
         "Resource": "*"
       }
     ]
   }
   ```
**Note**  
To improve security, you can specify an AWS IoT SiteWise asset hierarchy path in the `Condition` property\. The following example is a trust policy that specifies an asset hierarchy path\.  

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": "iotsitewise:BatchPutAssetPropertyValue",
         "Resource": "*",
         "Condition": {
           "StringLike": {
             "iotsitewise:assetHierarchyPath": [
               "/root node asset ID",
               "/root node asset ID/*"
             ]
           }
         }
       }
     ]
   }
   ```

1. Choose **Review policy**\.

1. Enter a name and description for the policy, and then choose **Create policy**\.

1. In the navigation pane, choose **Roles**, and then choose **Create role**\.  
![\[IAM "Roles" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-create-iam-role-console.png)

1. Under **Select type of trusted entity**, choose **AWS service**\. Under **Choose the service that will use the role**, choose **Greengrass** as the service that will use the role, and then choose **Next: Permissions**\.  
![\[IAM "Select type of trusted entity" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-role-service-console.png)

1. Search for the policy that you created \(*SiteWiseDemo*\), select the check box, and then choose **Next: Tags**\.  
![\[IAM "Attach permissions policies" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-role-policy-console.png)

1. \(Optional\) Add tags to your role, and then choose **Next: Review**\.

1. Enter a name and description for the role, and then choose **Create role**\.  
![\[IAM "Review" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-name-role-console.png)

1. In the green banner, choose the link to your new role\. You can also use the search field to find the role\.  
![\[IAM "The role SiteWiseDemo has been created" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-find-new-role-console.png)

1. Choose the **Trust relationships** tab, and then choose **Edit trust relationship**\.  
![\[IAM "Summary" page screenshot of the "Trust relationships" tab.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-edit-trust-relationships-console.png)

1. Replace the current contents of the policy field with the following, and then choose **Update Trust Policy**\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "greengrass.amazonaws.com"
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }
   ```

## Configuring an AWS IoT Greengrass group<a name="attach-iam-role"></a>

**To attach an IAM role to a group and enable stream manager**

1. Navigate to the [AWS IoT Greengrass console](https://console.aws.amazon.com/greengrass/)\.

1. In the left navigation pane, under **Greengrass**, choose **Groups**, and then choose the group that you created in [Setting up the gateway environment](#setup-gateway)\.  
![\[AWS IoT Greengrass "Greengrass Groups" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-group-console.png)

1. In the left navigation pane, choose **Settings**\. In the **Group Role** section, choose **Add Role**\.  
![\[AWS IoT Greengrass "Add Role" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-add-role-console.png)

1. Choose the role that you created in [Creating an IAM policy and role](#create-iam-resources), and then choose **Save**\.  
![\[AWS IoT Greengrass "Your Group's IAM Role" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-group-role-console.png)

1. On the **Settings** page, in the **Stream manager** section, choose **Edit**\.

   Stream manager is a feature of AWS IoT Greengrass that enables your AWS IoT Greengrass Core to stream data to the AWS Cloud\. AWS IoT SiteWise gateways require that stream manager is enabled\. For more information, see [Manage data streams on the AWS IoT Greengrass Core](https://docs.aws.amazon.com/greengrass/latest/developerguide/stream-manager.html) in the *AWS IoT Greengrass Developer Guide*\.  
![\[AWS IoT Greengrass "Stream manager" section screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-edit-stream-manager-console.png)

1. Choose **Enable**, and then choose **Save**\.

1. In the upper\-left corner, choose **Services** to prepare for the next procedure\.

## Configuring the AWS IoT SiteWise connector<a name="setup-connector"></a>

In this procedure, you configure the AWS IoT SiteWise connector on your Greengrass group\. Connectors are prebuilt modules that accelerate the development lifecycle for common edge scenarios\. For more information, see [AWS IoT Greengrass connectors](https://docs.aws.amazon.com/greengrass/latest/developerguide/connectors.html) in the *AWS IoT Greengrass Developer Guide*\.

**To configure the AWS IoT SiteWise connector**

1. Navigate to the [AWS IoT Greengrass console](https://console.aws.amazon.com/greengrass/)\.

1. In the left navigation pane, under **Greengrass**, choose **Groups**, and then choose the group that you created in [Setting up the gateway environment](#setup-gateway)\.  
![\[AWS IoT Greengrass "Greengrass Groups" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-group-console.png)

1. In the left navigation page, choose **Connectors**\. On the **Connectors** page, choose **Add a connector**\.  
![\[AWS IoT Greengrass "Connectors" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-add-connector-console.png)

1. Choose **IoT SiteWise** from the list and choose **Next**\.  
![\[AWS IoT Greengrass "Select a connector" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-select-connector-console.png)

1. If your OPC\-UA servers require authentication, you can create AWS Secrets Manager secrets with the server's user name and password\. Then, you can attach each secrets to your Greengrass group and choose them under **List of ARNs for OPC\-UA username/password secrets**\. For more information about how to create and configure secrets, see [Configuring source authentication](configure-source-authentication.md)\. You can also add secrets to your connector later\.  
![\[AWS IoT Greengrass "Configure a connector" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-configure-connector-console.png)

1. If you set up your gateway with a different path than `/var/sitewise`, enter that path for **Local storage path**\.

1. \(Optional\) Enter a maximum disk buffer size for the connector\. If the AWS IoT Greengrass core loses connection to the AWS Cloud, the connector caches data until it can successfully connect\. If the cache size exceeds the maximum disk buffer size, the connector discards the oldest data from the queue\.

1. Choose **Add**\.

1. In the upper\-right corner, in the **Actions** menu, choose **Deploy**\.

1. Choose **Automatic detection** to start the deployment\.

   If the deployment fails, choose **Deploy** again\. If the deployment continues to fail, see [AWS IoT Greengrass deployment troubleshooting](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html#gg-troubleshooting-deploymentissues)\.

## Adding the gateway to AWS IoT SiteWise<a name="add-gateway"></a>

In this procedure, you add your gateway's Greengrass group to AWS IoT SiteWise\. After you register your gateway with AWS IoT SiteWise, the service can deploy your data source configurations to your gateway\.

**To add the gateway to AWS IoT SiteWise**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. Choose **Add gateway**\.

1. On the **Add SiteWise gateway** page, do the following:

   1. Enter a **Name** for the gateway\. Consider including the location of the gateway in the name so that you can easily identify it\.

   1. For **Greengrass group ID**, choose the Greengrass group that you created earlier\.   
**Example**    
![\[AWS IoT SiteWise "Add gateway" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-add-gateway-console.png)

   1. Choose **Add gateway**\.

After your gateway creates, you can add a source for each OPC\-UA server from which you want your gateway to ingest data\. For more information, see [Configuring data sources](configure-sources.md)\.

You can view CloudWatch metrics to verify that your gateway is connected to AWS IoT SiteWise\. For more information, see [Gateway metrics](monitor-cloudwatch-metrics.md#gateway-metrics)\.
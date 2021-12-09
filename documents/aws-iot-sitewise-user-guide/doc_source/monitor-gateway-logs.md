# Monitoring gateway logs<a name="monitor-gateway-logs"></a>

You can configure your gateway to log information to Amazon CloudWatch Logs or the local file system\.

**Topics**
+ [Using Amazon CloudWatch Logs](#gateway-cloudwatch-logs)
+ [Using local file system logs](#gateway-local-logs)

## Using Amazon CloudWatch Logs<a name="gateway-cloudwatch-logs"></a>

You can configure your gateway to send logs to CloudWatch Logs\. You might follow this procedure if you want to use the AWS Management Console to view your gateway's log files\.

**To configure and access CloudWatch Logs**

1. To configure CloudWatch Logs for your gateway, see [Configure logging](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html#config-logs) in the *AWS IoT Greengrass Developer Guide*\.

1. Navigate to the [CloudWatch console](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Log groups**\.

1. You can find the AWS IoT SiteWise connector logs in the following log groups:
   + `/aws/greengrass/Lambda/region/aws/swCollector` – The logs for the gateway's Lambda function that collects data from the gateway's OPC\-UA sources\.
   + `/aws/greengrass/Lambda/region/aws/swPublisher` – The logs for the gateway's Lambda function that publishes OPC\-UA data streams to AWS IoT SiteWise\.

   Choose the log group for the function to debug\.

1. Choose a log stream that has a name that ends with the name of your AWS IoT Greengrass group\. By default, CloudWatch displays the most recent log stream first\.  
![\[CloudWatch Logs "Log groups" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-view-cloudwatch-logs-console.png)

1. To show logs from the last 5 minutes, do the following:

   1. Choose **custom** in the upper\-right corner\.

   1. Choose **Relative**\.

   1. Choose **5** minutes\.

   1. Choose **Apply**\.  
![\[CloudWatch "Logs" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-filter-cloudwatch-logs-console.png)

1. \(Optional\) To see fewer logs, you can choose **1m** from the upper\-right corner\.

1. Scroll to the bottom of the log entries to show the most recent logs\.

## Using local file system logs<a name="gateway-local-logs"></a>

You can configure your gateway to store logs locally\. You might follow this procedure if you want to use the command line or local software to view your gateway's log files\.

**To configure and access local file system logs**

1. To configure local file system logs on your gateway, see [Configure logging](https://docs.aws.amazon.com/greengrass/latest/developerguide/greengrass-logs-overview.html#config-logs) in the *AWS IoT Greengrass Developer Guide*\.
**Note**  
You must have root permissions to read AWS IoT Greengrass logs on the file system\.

1. On your gateway, run the following command to list all AWS IoT SiteWise connector log files and their file details\. Replace *greengrass\-root* with the root of your AWS IoT Greengrass installation, and replace *region* with the Region of the gateway\. The default *greengrass\-root* is `/greengrass`\.

   ```
   sudo ls -l /greengrass-root/ggc/var/log/user/region/aws
   ```

   You can find the most recent AWS IoT SiteWise connector logs in the following files:
   + `swCollector.log` – The most recent logs for the Lambda function that collects data from the gateway's OPC\-UA sources\.
   + `swPublisher.log` – The most recent logs for the Lambda function that publishes OPC\-UA data streams to AWS IoT SiteWise\.

   You can view older logs in the files named `swCollector.log-timestamp` and `swPublisher.log-timestamp`\.

1. Run the following command to view the publisher log file contents, for example\.

   ```
   sudo tail -f /greengrass-root/ggc/var/log/user/region/aws/swPublisher.log
   ```

   The `tail` command shows the end of a file, and the `-f` option shows new lines as they're appended to the file\.
# Upgrading a connector<a name="upgrade-gateway"></a>

**Important**  
Version 6 of the IoT SiteWise connector introduces new requirements: AWS IoT Greengrass Core software v1\.10\.0 and [stream manager](https://docs.aws.amazon.com/greengrass/latest/developerguide/stream-manager.html)\. Before you upgrade your connector, check that your gateway meets these requirements, or you won't be able to deploy your gateway\.

You can easily upgrade your gateway's connector after a new IoT SiteWise connector version is released\.

**Note**  
In this procedure, you redeploy your Greengrass group and restart your gateway\. Your gateway won't ingest data while it's restarting\. The time to restart your gateway depends on the number of OPC\-UA tags on your gateway's OPC\-UA sources\. Restart time can range from a few seconds \(for a gateway with few tags\) to several minutes \(for a gateway with many tags\)\.

**To upgrade an IoT SiteWise connector**

1. Navigate to the [AWS IoT Greengrass console](https://console.aws.amazon.com/greengrass/)\.

1. In the left navigation pane, under **Greengrass**, choose **Groups**, and then choose the group that you created when you set up your gateway\.  
![\[AWS IoT Greengrass "Greengrass Groups" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-choose-group-console.png)

1. In the left navigation pane, choose **Connectors**\.

1. On the **Connectors** page, choose **Available** next to the **IoT SiteWise** connector\.  
![\[AWS IoT Greengrass "Greengrass Connectors" with an available upgrade screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/gateway-upgrade-connector-console.png)

   If you don't see the **Available** element, your connector is already the latest version\.

1. On the **Upgrade connector** page, enter your connector's parameters and then choose **Upgrade**\.

1. In the upper\-right corner, in the **Actions** menu, choose **Deploy**\.

1. Choose **Automatic detection** to start the deployment\.

   If the deployment fails, choose **Deploy** again\. If the deployment continues to fail, see [AWS IoT Greengrass deployment troubleshooting](https://docs.aws.amazon.com/greengrass/latest/developerguide/gg-troubleshooting.html#gg-troubleshooting-deploymentissues)\.
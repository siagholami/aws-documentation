# Monitoring the ingested data<a name="monitor-data"></a>

You can check that the messages you sent are being ingested into your channel by using the AWS IoT Analytics console\. 

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/), in the left navigation pane, choose **Prepare** and \(if necessary\) choose **Channel**, then choose the name of the channel you created earlier\.  
![\[Screenshot of the "Channels" page in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analytics-console-return.png)

1. On the channel detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of messages ingested into this channel during the specified time frame\.  
![\[Screenshot of the "Channel soze" page in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/channel-monitoring.png)

A similar monitoring capability exists for checking pipeline activity executions\. You can monitor activity execution errors on the pipeline's detail page\. If you haven't specified activities as part of your pipeline, then 0 execution errors should be displayed\.

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/), in the left navigation pane, choose **Prepare** and then choose **Pipelines**, then choose the name of a pipeline you created earlier\.  
![\[Screenshot of the "Pipelines" page in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-prepare-pipelines.png)

1. On the pipeline detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of pipeline activity execution errors during the specified time frame\.  
![\[Screenshot of the pipeline activity execution page in the AWS IoT Analytics console.\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/pipeline-monitoring.png)
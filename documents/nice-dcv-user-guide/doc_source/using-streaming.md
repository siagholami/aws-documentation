# Managing Streaming Modes<a name="using-streaming"></a>

NICE DCV uses an adaptive protocol that automatically optimizes the streaming mode depending on the network capabilities\. However, you can specify whether you prefer to prioritize responsiveness or image quality\. Prioritizing responsiveness reduces the image quality to improve the frame rate\. Prioritizing image quality reduces the responsiveness to provide better image quality\.

This functionality is available on the Windows client, web browser client, Linux client, and macOS client\. The steps for setting the streaming mode are the same across all clients\.

**To change the streaming mode**

1. In the client, choose **Settings**, **Streaming Mode**\.  
![\[Settings button located in the top-left corner of the interface.\]](http://docs.aws.amazon.com/dcv/latest/userguide/images/streaming.png)

1. In the Streaming Mode window, choose one of the following options:
   + **Best responsiveness** — This option focuses on a faster response\. It might result in lower image quality\.
   + **Best quality** — This option focuses on higher image quality\. It might result in a slower response\.

1. \(Optional\) For information about network performance, choose **Display Streaming Metrics**\. For more information, see [Managing Streaming Modes](#using-streaming-metrics)\.

1. Close the **Streaming Mode** window\.

## Streaming Metrics<a name="using-streaming-metrics"></a>

The streaming metrics can be used to evaluate your network performance and determine which streaming mode is best suited to your network conditions\. To view the streaming metrics, choose **Settings**, **Streaming Mode**, **Display Streaming Metrics**\.

The streaming metrics provide the following real\-time information:

**Note**  
Metrics are displayed for the current NICE DCV session connection\.
+ **Framerate**—Indicates the number of frames received from the NICE DCV server per second\.
+ **Network latency**—Indicates the amount of time \(in milliseconds\) it takes for a packet of data to be sent to the NICE DCV server and back to the client\.
+ **Bandwidth usage**—Indicates the amount of data being sent and received over the network connection\. The red line shows the peak network throughput, the yellow line shows the average throughput, and the blue line shows the current \(real\-time\) throughput\. 

The following image shows example streaming metric data\.

![\[example streaming metric data.\]](http://docs.aws.amazon.com/dcv/latest/userguide/images/metrics.png)
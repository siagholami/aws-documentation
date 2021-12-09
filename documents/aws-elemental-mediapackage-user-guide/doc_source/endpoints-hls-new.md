# New Endpoint Fields<a name="endpoints-hls-new"></a>

When you're creating an endpoint, do not put sensitive identifying information like customer account numbers into free\-form fields such as the **Name** field\. This includes when you work with AWS Elemental MediaPackage using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

1. For **ID**, enter a name that describes the endpoint\. The ID is the primary identifier for the endpoint, and must be unique for your account in the AWS Region\.

1. \(Optional\) For **Description**, enter any descriptive text that helps you to identify the endpoint later\. 

1. For **Manifest name**, enter a short string that will be appended to the end of the endpoint URL\. The manifest name helps to create a unique path to this endpoint\.

1. \(Optional\) To create a window of the live stream that's available for on\-demand viewing, select **Startover window** and enter the size of the window \(in seconds\)\. Viewers can start\-over or catch\-up on content that falls within the window\. For more information about implementing start\-over and catch\-up TV, see [Time\-shifted Viewing Reference in AWS Elemental MediaPackage](time-shifted.md)\.

1. \(Optional\) To delay when content is available to players, enter the duration \(in seconds\) for the delay in **Time delay**\. The minimum time is 5 seconds\. The maximum time is 86,400 seconds \(24 hours\)\.

   Use time delay to redefine the live point and make content available at a time that equals "now" minus the delay specified\. With a 60\-second time delay, content that AWS Elemental MediaPackage receives at 12:20 isn't available until 12:21\. Requests for playback at 12:20 will be served with content from 12:19\. Likewise, if you're serving content across time zones, you can set a time delay equal to the time zone difference to make content available at, for example, 8:00 local time\.

   When you use time delay in conjunction with a startover window, the time delay duration must be less than the startover window duration\.
**Tip**  
Use a time delay to help reduce buffering during input switching when you're using input redundancy with short output segments\. Note that the delay can increase latency in content playback\.
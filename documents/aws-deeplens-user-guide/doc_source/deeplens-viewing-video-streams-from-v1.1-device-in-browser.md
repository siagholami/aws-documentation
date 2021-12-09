# View Video Streams from AWS DeepLens 2019 Edition Device in Browser<a name="deeplens-viewing-video-streams-from-v1.1-device-in-browser"></a>

 To view project or live streams from the AWS DeepLens 2019 Edition device in a browser, you must have the device's self\-signed streaming certificate downloaded to your computer and then uploaded to a supported browser you'll use\. For instructions on how to download the streaming certificate and install it into the browser, see **Step 6** of [View or Update Your AWS DeepLens 2019 Edition Device Settings](deeplens-v11-device-view-or-edit-settings.md)\.

**To view video streams from AWS DeepLens 2019 Edition device in a browswer**

1. Connect the device to your computer with the provided USB cable, if it's not already connected\.

1. Do one of the following to launch your devices' **AWS DeepLens Stream** viewer:
   + Open the device details page on the AWS DeepLens console and choose **View video stream** under **Video streaming** to open the stream viewer in a new browser tab\. 
   + Alternatively, open a new browser tab manually, type `https://your-device-ip-address:4000` in the address bar, where *your\-device\-ip\-address* stands for the IP address of your device \(e\.g\., 192\.168\.14\.78\) shown under **Device details** in the AWS DeepLens console\.

1. Because the streaming certificate is self\-signed, the browser will display a warning\. To accept the warning, follow browser\-specific instructions on screen to accept the certificate for the stream viewer to be launched\. 

   It may take about 30 seconds for the stream viewer to show up\.

1.  Before any project is deployed, choose **Live stream** to view live videos from your AWS DeepLens device\. After a project is deployed, you can also choose **Project stream** to view processed videos output from the device\.

1.  When done with viewing video streams, disconnect the device from your computer to return the computer to its normal network configuration\. 
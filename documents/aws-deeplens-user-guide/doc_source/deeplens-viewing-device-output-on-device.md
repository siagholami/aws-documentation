# View Video Streams on Your AWS DeepLens Device<a name="deeplens-viewing-device-output-on-device"></a>

In addition to [viewing your AWS DeepLens output streams in a browser](deeplens-viewing-device-output-in-browser.md), you can use `mplayer` to view the streams directly from your AWS DeepLens device after connecting it to a monitor, a keyboard, and a mouse\. This is especially useful when your AWS DeepLens device is not online\.

Instead of connecting to the device directly using a monitor, a keyboard, and a mouse, you can also use `ssh` to connect to the device, if SSH access is enabled on the device when it is registered\. You can then use `mplayer` on your work computer to view the streams\. Make sure that `mplayer` is installed on your computer before viewing the output streams from your AWS DeepLens device\. For more information about the installation, see [`mplayer` download](http://www.mplayerhq.hu/design7/dload.html)\. 

**Topics**
+ [View Live Streams on Your AWS DeepLens Device](#deeplens-viewing-output-device-stream)
+ [View Project Streams on Your AWS DeepLens Device](#deeplens-viewing-output-project-stream)

## View Live Streams on Your AWS DeepLens Device<a name="deeplens-viewing-output-device-stream"></a><a name="deeplens-view-device-stream-on-device-proc"></a>

**To view an unprocessed device stream on your AWS DeepLens device**

1. Plug your AWS DeepLens device into a power outlet and turn it on\.

1. Connect a USB mouse and keyboard to your AWS DeepLens\.

1.  Use the micro HDMI cable to connect your AWS DeepLens to a monitor\. A login screen appears on the monitor\.

1. Sign in to the device using the SSH password that you set when you registered the device\.

1. To see the video stream from your AWS DeepLens, start your terminal and run the following command:

   ```
   mplayer -demuxer lavf /opt/awscam/out/ch1_out.h264
   ```

1. To stop viewing the video stream and end your terminal session, press `Ctrl+C`\.

## View Project Streams on Your AWS DeepLens Device<a name="deeplens-viewing-output-project-stream"></a>

**To view a project stream on your AWS DeepLens device**

1. Plug your AWS DeepLens device to a power outlet and turn it on\.

1. Connect a USB mouse and keyboard to your AWS DeepLens\.

1. Use the micro HDMI cable to connect your AWS DeepLens to a monitor\. A login screen appears on the monitor\.

1. Sign in to the device using the SSH password you set when you registered the device\.

1. To see the video stream from your AWS DeepLens, start your terminal and run the following command:

   ```
   mplayer -demuxer lavf -lavfdopts format=mjpeg:probesize=32 /tmp/results.mjpeg
   ```

1. To stop viewing the video stream and end your terminal session, press `Ctrl+C`\.
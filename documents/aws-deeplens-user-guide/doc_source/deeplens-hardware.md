# AWS DeepLens Hardware<a name="deeplens-hardware"></a>

The AWS DeepLens device has the following specs:
+ A 4\-megapixel camera with MJPEG \(Motion JPEG\)
+ 8 GB of on\-board memory
+ 16 GB of storage capacity
+ A 32\-GB SD \(Secure Digital\) card
+ Wi\-Fi support for both 2\.4 GHz and 5 GHz standard dual\-band networking
+ A micro HDMI display port
+ Audio out and USB ports
+ Power consumption: 20 W
+ Power input: 5V and 4Amps

The following image shows the front and back of the AWS DeepLens hardware\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-device-view-front-back.png)

The following image shows the front and back of the AWS DeepLens 2019 Edition hardware\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens_2019_edition_device_specs.png)

On the front of the device, the power button is located at the bottom\. Above it are three LED indicators show the device statuses:
+ **Power status** indicates if the device is powered on or off\.
+ **Wi\-Fi** shows if the device is in the setup mode \(blinking\), connected to your home or office network \(steady\) or not connected to the Internet \(off\)\. 
+ **Camera status**: when it is on, it indicates that a project is deployed successfully to the device and the project is running\. Otherwise, the LED light is off\.

On the back of the device, you have access to the following:

1. A micro SD card slot for storing and transferring data\.

1. A micro HDMI slot for connecting a display monitor to the device using a micro\-HDMI\-to\-HDMI cable\.

1. Two USB 2\.0 \(AWS DeepLens Edition\)/3\.0 \(AWS DeepLens 2019 Edition\) slots for connecting USB mouse and keyboard, or any other USB\-enabled accessories, to the device\.

1. A reset pinhole for turning the device into the setup mode that allows you to make the device as an access point and to connect your laptop to the device to configure the device\.

1. An audio outlet for connecting to a speaker or earphones\.

1. A power supply connector for plugging in the device to an AC power source\.

The AWS DeepLens camera is powered by an Intel® Atom processor, which can process 100 billion floating\-point operations per second \(GFLOPS\)\. This gives you all of the computing power that you need to perform inference on your device\. The micro HDMI display port, audio out, and USB ports allow you to attach peripherals, so you can get creative with your computer vision applications\.

You can use AWS DeepLens as soon as you register it\. Begin by deploying a sample project, and use it as a template for developing your own computer vision applications\.
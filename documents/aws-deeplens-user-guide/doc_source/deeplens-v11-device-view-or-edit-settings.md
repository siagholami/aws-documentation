# View or Update Your AWS DeepLens 2019 Edition Device Settings<a name="deeplens-v11-device-view-or-edit-settings"></a>

You can view or update the device settings once the device is successfully registered\.

**To view or update your AWS DeepLens 2019 Edition device settings**

1. On the successfully registered device details page in the AWS DeepLens console, choose **Edit device settings**\.

1. Make sure your device is connected to your computer via the USB\-to\-USB cable and then choose **Next** in the **Connect your device to your computer** dialog box\. 

1. After the **Device USB connection** status becomes **Connected**, choose **Next**, again, to open the **Device settings** page\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/v1.1-device-settings-page.png)

1. To use a different network for the device's internet connection, choose **Edit** in **Network details** and then select a network type, choose a Wi\-Fi network, type the password, and choose **Connect**\.

1. To enable SSH connection to the device and set the SSH password, choose **Edit** in **SSH server** and then select the **Enable** option, create a password, confirm the password, and choose **Save changes**\.

1. To enable viewing video output from your device in a browser, install required video streaming certificates for one or more supported browsers\. 

   1. Choose a supported browser from the **Select your browser** drop\-down list\. As an example, we choose **Firefox \(Windows, MacOS Sierra or higher, and Linux\)**\.

   1. Choose **Download streaming certificate** to save the certificate to your computer\.

   1. Follow the remaining instructions thereafter to import the downloaded streaming certificate into the browser\. 
**Note**  
Be sure to use `DeepLens` for the certificate password, when prompted\.

      To verify the certificate is installed properly, follow the instructions given in [View Video Streams from AWS DeepLens 2019 Edition Device in Browser](deeplens-viewing-video-streams-from-v1.1-device-in-browser.md) \.

When done with viewing or updating the device settings, you can disconnect the device from your computer  and use AWS DeepLens\. 
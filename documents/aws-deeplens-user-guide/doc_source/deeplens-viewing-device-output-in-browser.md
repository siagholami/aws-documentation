# View Video Streams from AWS DeepLens Device in Browser<a name="deeplens-viewing-device-output-in-browser"></a>

**Note**  
 To view a project's output in a supported browser, your device must have the `awscam` software version 1\.3\.9 or higher installed\. For information to update the device software, see [Update Your AWS DeepLens Device](deeplens-manual-updates.md)\. 

**Note**  
To view a project's output in Chrome on Mac El Capitan or earlier, you must provide a password to load the streaming certificate for viewing the project output\. If you have such an old Mac operating system and want to use Chrome, skip the procedure below and follow the instructions in [How to View Project Output in the Chrome Browser on Mac El Capitan or Earlier?](troubleshooting-device-registration.md#troubleshooting-view-project-output-in-chrome-on-mac-elcapitan-or-earlier) to set up your browser to view the project output\.<a name="deeplens-view-device-stream-in-browser-proc"></a>

**To view project output from your AWS DeepLens device in a supported web browser**

1. If you have not already downloaded the streaming certificate when [registering your device](deeplens-getting-started-set-up.md) or if you have lost the downloaded copy, do one of the following to download the streaming certificate\. The steps are different depending on whether you use the device setup application or not\.

   1. Download the streaming certificate without using the device setup page:

      1. Establish an SSH connection to your AWS DeepLens device from your computer:

         ```
         ssh aws_cam@device_local_ip_address
         ```

         An example of `device_local_ip_address` would be `192.168.0.47`\. After entering the correct device password, which you specified during the device registration, you're now logged in to the device\. 

      1. Make a local copy \(`my_streaming_cert.pfx`\) of the streaming certificate \(`client.pfx`\) on the device:

         ```
         sudo cp /opt/awscam/awsmedia/certs/client.pfx /home/aws_cam/my_streaming_cert.pfx
         ```

         When prompted, enter the device password to complete the above commands\. 

         Make sure that the owner of the device\-local copy is `aws_cam`\. 

         ```
         sudo chown aws_cam /home/aws_cam/my_streaming_cert.pfx
         ```

         After this, log out of the device:

         ```
         exit
         ```

      1. Transfer the copy of the streaming certificate from the device to your computer:

         ```
         scp aws_cam@device_local_ip_address:/home/aws_cam/my_streaming_cert.pfx ~/Downloads/
         ```

         The example used the `Downloads` folder under the user's home directory \(`~/`\) to transfer the certificate to\. You can choose any other writeable directory as the destination folder\.

   1. Follow the following steps to download the streaming certificate for the AWS DeepLens device:

      1. [Return your device to its setup mode, if necessary, and connect your computer to the device's `ADMC-NNNN` Wi\-Fi network](deeplens-getting-started-connect.md)\.

      1. Start the device setup app at `http://deeplens.config`\. 

      1. Follow the on\-screen instructions to download the streaming certificate for viewing a project's output streams\.

1. Import into your supported web browser the streaming certificate you downloaded during the [device registration](deeplens-getting-started-set-up.md#deeplens-set-up-device-procedure)\.

   1. For FireFox \(Windows and macOS Sierra or higher\), follow these steps:

      1. Choose **Preferences** in FireFox\. 

      1. Choose **Privacy & Security**\.

      1. Choose **View certificate**\.

      1. Choose the **Your Certificates** tab\.

      1. Choose **Import**\.

      1. Choose the downloaded streaming certificate to load into FireFox\.

      1.  When prompted to enter your computer's system password, if your AWS DeepLens software version is 1\.3\.23 or higher, type DeepLens in the password input field\. If your AWS DeepLens software version is 1\.3\.22 or lower, leave the password field blank and follow the on\-screen instruction to finish importing the streaming certificate\.
**Note**  
Depending on the version of the FireFox you use, you may need to follow steps below, instead:  
From **Preferences**, choose **Advanced**\.
Choose the **Certificates** tab\.
Choose **View Certificates**\.
On **Certificate Manager**, choose the **Your certificates** tab\.
Choose **Import**\.
Navigate to and open the downloaded streaming certificate\. 
When prompted for a password, if your AWS DeepLens software version is 1\.3\.23 or higher, type `DeepLens` in the password input field\. If your AWS DeepLens software version is 1\.3\.22 or lower, choose **OK** without entering one\.

   1. For Chrome \(macOS Sierra or higher\), follow these steps:

      1. On your macOS, double\-click the downloaded streaming certificate to add it to **System** under **Keychains** and **My Certificate** under **Category**\.

         Alternatively, open and unlock the **Keychain Access** app, choose **System** under **Keychains** on the left and **My Certificate** under **Category**\. Drag and drop the downloaded streaming certificate into the window\.

      1. Enter your computer's system password\.

      1.  On the next screen, if your AWS DeepLens software version is 1\.3\.23 or higher, type `DeepLens` in the password input field\. If your AWS DeepLens software version is 1\.3\.22 or lower, leave the **Password** field blank and then choose **OK**\.

   1. For Chrome \(Windows and Linux\), follow these steps:

      1. In your Chrome browser, open **Settings** and choose **Advanced settings**\.

      1. In **Privacy and security**, choose **Manage certificates**\. 

      1. Choose **Import**\.

      1. Navigate to the folder containing the downloaded streaming certificate and choose it to load into Chrome\.

      1. When prompted for your computer's system password, if your AWS DeepLens software version is 1\.3\.23 or higher, type `DeepLens` in the password input field\. If your AWS DeepLens software version is 1\.3\.22 or lower, leave the password field blank and follow the on\-screen instructions to finish importing the streaming certificate\.

1. To view output streams, open a supported browser window and navigate to `https://<your-device-ip-address>:4000`\. You can find your device's IP address on the device details page in the AWS DeepLens console\.

   You can also use the AWS DeepLens console to view the project stream\. To do so, follow the steps below:

   1. In the navigation pane, choose **Devices**\.

   1. From the **Devices** page, choose your AWS DeepLens device\.

   1. Under **Project output** on your device's details page, expand the **View the video output** section\.

   1. Choose a supported browser from **Select a browser to import the streaming certificate** drop\-down list and, if necessary, follow the instructions\.

   1. Choose **View stream**, while your computer is connected to the device's Wi\-Fi \(`AMDC-NNNN`\) network\.
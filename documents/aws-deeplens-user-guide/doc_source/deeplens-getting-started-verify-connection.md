# Verify Your AWS DeepLens Device Registration Status<a name="deeplens-getting-started-verify-connection"></a>

After the device setup is complete, choose **Open AWS DeepLens console** to verify the registration status\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-device-setup-complete.png)

Device registration takes a few minutes to process\. When the registration completes successfully, **Registration status** changes to **Registered**\. If the process fails, **Registration status** becomes **Failed**\. In this case, choose **Deregister** and then start the registration all over again\. When the registration is interrupted or otherwise incomplete, **Registration status** remains **Awaiting credentials**\. In this case, [reconnect to the device's `AMDC-NNNN` Wi\-Fi network](deeplens-getting-started-connect.md) to resume the registration\.

When the device's **Registration status** and **Device status** becomes **Registered** and **Online**, respectively, you're ready to create and deploy a project to your AWS DeepLens device\. For example, you can follow these [instructions](deeplens-test-using-device.md) to test your device by creating and deploying a sample project and inspecting a project output\.
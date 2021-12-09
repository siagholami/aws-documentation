--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Unlock the Snowball Edge<a name="unlockdevice"></a>

To unlock the AWS Snowball Edge device, run the `snowballEdge unlock-device` command\. To run this command, the AWS Snowball Edge device that you use for your job must be onsite, plugged into power and network, and turned on\. In addition, the LCD display on the AWS Snowball Edge device's front must indicate that the device is ready for use\.

**To unlock the device with the Snowball client**

1. Get your manifest and unlock code\.

   1. Download a copy of the manifest from the AWS Snowball Management Console\. Your job's manifest is encrypted so that only the job's unlock code can decrypt it\. Make a note of the path to the manifest file on your local server\.

   1. Get the unlock code, a 29\-character code that also appears when you download your manifest\. We recommend that you write down the unlock code and keep it in a separate location from the manifest that you downloaded, to prevent unauthorized access to the AWS Snowball Edge device while it’s at your facility\.

1. Find the IP address for the AWS Snowball Edge device on the AWS Snowball Edge device's LCD display, under the **Connections** tab\. Make a note of that IP address\.

1. Run the `snowballEdge unlock-device` command to authenticate your access to the AWS Snowball Edge device with the AWS Snowball Edge device's endpoint and your credentials, as follows:

   ```
   snowballEdge unlock-device --endpoint https://ip address --manifest-file Path/to/manifest/file --unlock-code
    29 character unlock code
   ```

Following is an example of the command to unlock the Snowball client\.

```
snowballEdge unlock-device --endpoint https://192.0.2.0 --manifest-file /Downloads/JID2EXAMPLE-0c40-49a7-9f53-916aEXAMPLE81-manifest.bin  --unlock-code 12345-abcde-12345-ABCDE-12345
```

In this example, the IP address for the device is `192.0.2.0`, the job manifest file that you downloaded is `JID2EXAMPLE-0c40-49a7-9f53-916aEXAMPLE81-manifest.bin`, and the 29\-character unlock code is `12345-abcde-12345-ABCDE-12345`\.

When you've entered the preceding command with the right variables for your job, you get a confirmation message\. This message means that you're authorized to access the device for this job\.

**Job\-Type Specific Consideration**

If you're unlocking a cluster, you need to specify only the IP address for one of the cluster nodes\. For more information, see [Using the Snowball Client](using-client.md)\.

Now you can begin using the AWS Snowball Edge device\. 

**Next:** [Set Up Local Users](setup-local-iam.md) 
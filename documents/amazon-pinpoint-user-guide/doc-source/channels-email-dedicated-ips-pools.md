# Creating Dedicated IP Pools<a name="channels-email-dedicated-ips-pools"></a>

If you purchased several dedicated IP addresses to use with Amazon Pinpoint, you can create groups of those addresses\. These groups are called *dedicated IP pools*\. A common scenario is to create one pool of dedicated IP addresses for sending marketing communications, and another for sending transactional emails\. Your sender reputation for transactional emails is then isolated from that of your marketing emails\. In this scenario, if a marketing campaign generates a large number of complaints, the delivery of your transactional emails isn't impacted\. 

This section contains procedures for creating dedicated IP pools\. To complete these procedures, you have to use the AWS Command Line Interface \(AWS CLI\)\. For information about installing and configuring the AWS CLI, see [Installing the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) and [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html) in the *AWS Command Line Interface User Guide*\.

**Note**  
You can only use dedicated IP pools if you send email by using the Amazon Pinpoint Email API, or the Amazon Pinpoint Email operations in one of the AWS SDKs\. Currently, you can't use dedicated IP pools if you send email by using the Amazon Pinpoint console\.

## Creating a Dedicated IP Pool<a name="channels-email-dedicated-ips-pools-create"></a>

Before you can use a dedicated IP pool, you have to create the pool itself and assign it to a configuration set\.

**To create a dedicated IP pool by using the AWS CLI**

1. If you haven't already done so, complete the procedures in [Requesting Dedicated IP Addresses](channels-email-dedicated-ips-case.md#channels-email-dedicated-ips-case-request) to request a dedicated IP address for your Amazon Pinpoint account\. You can only complete this procedure if we've already approved your request for dedicated IP addresses, and associated the dedicated IP addresses with your Amazon Pinpoint account\.

1. At the command line, enter the following command to create a dedicated IP pool:

   ```
   aws pinpoint-email create-dedicated-ip-pool --pool-name MyIpPool
   ```

   In the preceding command, replace *MyIpPool* with the name that you want to assign to the dedicated IP pool\. As a best practice, we recommend that you use a name that describes the intended purpose of the IP pool, so that you can easily identify the pool when you add it to a configuration set\.

1. At the command line, enter the following command to associate a dedicated IP address with the dedicated IP pool:

   ```
   aws pinpoint-email put-dedicated-ip-in-pool --ip 203.0.113.0 --destination-pool-name MyIpPool
   ```

   In the preceding command, replace *203\.0\.113\.0* with the IP address that you want to add to the pool\. Also, replace *MyIpPool* with the name of the pool that you created in the previous step\.

1. In a text editor, create a new file\. Paste the following code into the file:

   ```
   {
       "ConfigurationSetName": "MyConfigurationSet",
       "DeliveryOptions": {
           "SendingPoolName": "MyIpPool"
       }
   }
   ```

   Replace *MyConfigurationSet* with the name that you want to give the configuration set\. Also, replace *MyIpPool* with the name of the dedicated IP pool that you created in step 2\.

   Save the file as `createConfigurationSet.json`\.

1. At the command line, enter the following command to create the configuration set:

   ```
   aws pinpoint-email create-configuration-set --cli-input-json file://path/to/createConfigurationSet.json
   ```

   In the preceding command, replace *path/to/createConfigurationSet\.json* with the path to the `createConfigurationSet.json` file that you created in the previous step\.

## Sending Email Using a Dedicated IP Pool<a name="channels-email-dedicated-ips-pools-send"></a>

After you create a dedicated IP pool, you can start using that pool to send email\. To send email using a dedicated IP pool, you have to specify the configuration set that's associated with the pool when you send the email\.

To send an email that uses a configuration set, you have to use the Amazon Pinpoint Email API\. The most common way to send email using the Amazon Pinpoint Email API is to use an AWS SDK\. For more information about using AWS SDKs to send email by using the Amazon Pinpoint Email API, see [Send Email by Using the Amazon Pinpoint Email API](https://docs.aws.amazon.com/pinpoint/latest/developerguide/send-messages-email-sdk.html) in the *Amazon Pinpoint Developer Guide*\.
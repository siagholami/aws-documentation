--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Getting Started with Lambda Powered by AWS IoT Greengrass<a name="function-getting-started"></a>

To get started with AWS Lambda powered by AWS Greengrass functions on a Snowball Edge, take the following steps:

1. [Associating an AWS IoT Greengrass Service Role with Your Account](#gg-associate-role)

1. [Configuring AWS IoT Greengrass with a Snowball Edge](#gg-config)

1. [Creating Your Job](#function-create-job)

1. [Creating a Virtual Network Interface](#create-vnic-lambda)

1. [Starting AWS IoT Greengrass on a Snowball Edge](#starting-greengrass)

1. [Using Lambda Powered by AWS Greengrass Functions on a Snowball Edge](#use-functions)

## Associating an AWS IoT Greengrass Service Role with Your Account<a name="gg-associate-role"></a>

Before you can use AWS IoT Greengrass with a Snowball Edge as a core device, you must associate an AWS IoT Greengrass service role with your account\. This association allows AWS IoT Greengrass to access your Lambda functions and AWS IoT resources\. If you try to create a job for a Snowball Edge before you associate the service role, the job creation request fails\.

The following procedures show how to configure and store your AWS IoT Greengrass settings in the cloud\. This configuration means that you can push Lambda function changes to the Snowball Edge and changes to other devices in your AWS IoT Greengrass group\. The first procedure uses the AWS Identity and Access Management \(IAM\) console, and the second procedure uses the AWS Command Line Interface \(AWS CLI\)\. 

**To create an AWS IoT Greengrass service role in the IAM console**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. For **Role Type**, choose **AWS Greengrass Role**\.

1. Select **AWSGreengrassResourceAccessPolicy**, and then choose **Next Step**\.

1. Type a name for your role, and then choose **Create Role**\.

After creating the role, make a note of the role Amazon Resource Name \(ARN\), and use it in the next procedure\.

**To associate the AWS IoT Greengrass service role with your account**

1. Install the AWS CLI on your computer, if you haven't already\. For more information, see [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html) in the *AWS Command Line Interface User Guide*\.

1. Configure the AWS CLI on your computer, if you haven't already\. For more information, see [Configuring the AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide*\.

1. Open a terminal on your computer and run the following AWS CLI command, with the AWS IoT Greengrass role ARN you created in the first procedure\.

   ```
   aws greengrass associate-service-role-to-account --role-arn arn:aws:iam::123EXAMPLE12:role/GreengrassRole
   ```

Now you can create a job for a Snowball Edge and use AWS Lambda powered by AWS Greengrass\.

## Configuring AWS IoT Greengrass with a Snowball Edge<a name="gg-config"></a>

When you create a compute job for a Snowball Edge, the service automatically configures the following AWS IoT Greengrass elements:
+ **AWS IoT Greengrass Core Software** – The AWS IoT Greengrass distributable has been pre\-installed on the Snowball Edge\.
+ **AWS IoT Greengrass Group** – When you create a compute job, an AWS IoT Greengrass group named `JobID_group` is created and provisioned\. The core of this group is named `JobID_core`, and it has a device in it named `JobID_s3adapter`\. The Amazon S3 Adapter for Snowball is registered as an IoT device in your AWS IoT Greengrass group\. This registration is because the adapter sends MQTT messages for every Amazon S3 PUT object action for the buckets on the Snowball Edge\.

If you have other configuration changes that you want to make for the AWS IoT Greengrass group associated with a Snowball Edge, you can make them after you unlock the device and connect it to the internet\.

## Creating Your Job<a name="function-create-job"></a>

Create a job in the AWS Snowball Management Console and associate the Amazon Resource Name \(ARN\) for at least one published Lambda function with a bucket\. For a walkthrough on creating your first job, see [Getting Started with AWS Snowball Edge: Your First Job](common-get-start.md)\. 

All the Lambda functions that you choose during job creation are triggered by MQTT messages sent by the IoT device associated with the Amazon S3 Adapter for Snowball\. These MQTT messages are triggered whenever an [Amazon S3 PUT object](https://docs.aws.amazon.com/AmazonS3/latest/API/RESTObjectPUT.html) action is made against the bucket on the AWS Snowball Edge device\.

## Creating a Virtual Network Interface<a name="create-vnic-lambda"></a>

When the Snowball Edge arrives, unlock the device, and create a virtual network interface to bind to AWS IoT Greengrass\. Each Snowball Edge has three network interfaces \(NICs\), the physical network interface controllers for the device\. These are the RJ45, SFP, and QSFP ports on the back of the device\.

Each virtual NIC \(VNIC\) is based on the physical one, and you can have any number of VNICs associated with each NIC\. To create a virtual network interface, use the `snowballEdge create-virtual-network-interface` command\. 

**Note**  
`--static-ip-address-configuration` is only a valid option when using `STATIC` for `--ip-address-assignment`\.

**Usage \(configured Snowball client\)**

```
snowballEdge create-virtual-network-interface --ip-address-assignment [DHCP or STATIC] --physical-network-interface-id [physical network interface id] --static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]
```

**Usage \(Snowball client not configured\)**

```
snowballEdge create-virtual-network-interface --endpoint https://[ip address] --manifest-file /path/to/manifest --unlock-code [unlock code] --ip-address-assignment [DHCP or STATIC] --physical-network-interface-id [physical network interface id] --static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]
```

**Example Creating VNICs \(DHCP\)**  

```
./snowballEdge create-virtual-network-interface --ip-address-assignment dhcp --physical-network-interface-id s.ni-8EXAMPLEaEXAMPLEd
{
  "VirtualNetworkInterface" : {
    "VirtualNetworkInterfaceArn" : "arn:aws:snowball-device:::interface/s.ni-8EXAMPLE8EXAMPLEf",
    "PhysicalNetworkInterfaceId" : "s.ni-8EXAMPLEaEXAMPLEd",
    "IpAddressAssignment" : "DHCP",
    "IpAddress" : "192.0.2.0",
    "Netmask" : "255.255.255.0",
    "DefaultGateway" : "192.0.2.1",
    "MacAddress" : "EX:AM:PL:E1:23:45"
  }
}
```

## Starting AWS IoT Greengrass on a Snowball Edge<a name="starting-greengrass"></a>

Before you can use AWS Lambda powered by AWS Greengrass, you need to use the Snowball client to start it\.

**Note**  
It can take several minutes to start AWS IoT Greengrass on a Snowball Edge\. We recommend using the `describe-service` Snowball client command after you start the service to determine when it's active\. For more information, see [Getting Service Status](using-client-commands.md#client-service-status)\.

**To start AWS Lambda powered by AWS Greengrass**

1. Run the `snowballEdge describe-device` command to get the list of network interface IDs\. For more information on this command, see [Getting Device Status](using-client-commands.md#client-status)\.

1. Identify the ID for the physical network interface that you want to use, and make a note of it\. The following examples show running this command with the two different IP address assignment methods, either `DHCP` or `STATIC`\.

   ```
   snowballEdge create-virtual-network-interface \
   --physical-network-interface-id s.ni-abcd1234 \
   --ip-address-assignment DHCP
   	         
   	        //OR//
   	        
   snowballEdge create-virtual-network-interface \
   --physical-network-interface-id s.ni-abcd1234 \
   --ip-address-assignment STATIC \
   --static-ip-address-configuration IpAddress=192.0.2.0,Netmask=255.255.255.0
   ```

1. The command returns a JSON structure that includes the virtual network interface ARN\. Make a note of that ARN\.

1. Start the AWS IoT Greengrass service using the virtual network interface, as in the following example\.

   ```
   snowballEdge start-service \
   --service-id greengrass\
   --virtual-network-interface-arns arn:aws:snowball-device:::interface/s.ni-abcd1234abcd1234a
   ```

AWS Lambda powered by AWS Greengrass has now started\. Anytime you need the IP address or virtual network interface ARN for the AWS IoT Greengrass, you can use the `snowballEdge describe-virtual-network-interfaces` Snowball client command\.

## Connecting to the Internet to Update AWS IoT Greengrass Group Certificates<a name="function-update-certs"></a>

Every time you start the AWS IoT Greengrass service, you must log into the AWS IoT Greengrass Console with the account used to create the job in the AWS Snowball Management Console and initiate a AWS IoT Greengrass Group deployment to the AWS IoT Greengrass Core\. For more information, see [Deploy Cloud Configurations to an AWS Greengrass Core Device](https://docs.aws.amazon.com/greengrass/latest/developerguide/configs-core.html) in the *AWS IoT Greengrass Developer Guide*\. After that, you can disconnect the device from the internet\. The associated AWS IoT Greengrass group then functions in offline mode\.

**Important**  
When the IP address for any device in the local AWS IoT Greengrass group changes, reconnect the Snowball Edge to the internet so it can get new certificates\.

## Using Lambda Powered by AWS Greengrass Functions on a Snowball Edge<a name="use-functions"></a>

Now that the service is started, and you've initiated a AWS IoT Greengrass Group deployment to the AWS IoT Greengrass Core, you can trigger Lambda functions by writing data to the Amazon S3 buckets on the device\. Unless programmed otherwise, Lambda functions are triggered by MQTT messages sent by the IoT device associated with the Amazon S3 Adapter for Snowball\. These MQTT messages are in turn triggered by Amazon S3 PUT object actions\. Amazon S3 PUT object actions occur through the file interface \(with a write operation\), the AWS CLI \(using the Amazon S3 Adapter for Snowball\), or programmatically through one of the SDKs or a REST application of your own design\.

You can use your AWS Lambda powered by AWS Greengrass functions to execute Python code against public endpoints among AWS services in the cloud\. For this Python code execution to work, your AWS Snowball Edge device needs to be connected to the internet\. For more information, see the [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda/latest/dg/)\.

### Updating Existing Functions<a name="update-functions"></a>

You can update existing Lambda functions in the console\. If you do, and if your AWS Snowball Edge device is connected to the internet, a deployment agent notifies each Lambda function of the updated AWS IoT Greengrass group configuration\. For more information, see [Create a Deployment](https://docs.aws.amazon.com/lambda/latest/dg/create-deployment.html) in the *AWS IoT Greengrass Developer Guide*\.

### Adding New Functions<a name="add-new-functions"></a>

After your Snowball Edge arrives and you unlock it and connect it to the internet, you can add or remove additional Lambda functions\. These new Lambda functions don't have to be triggered by Amazon S3 PUT object actions\. Instead, the event that you programmed to trigger the new functions performs function triggering, as with typical Lambda functions running in an AWS IoT Greengrass group\. 

### Testing Lambda Powered by AWS IoT Greengrass Functions<a name="testing-functions"></a>

You can test your Lambda functions before you create your job, or after you've started the AWS IoT Greengrass on the device\. When testing your Python\-coded function in the Lambda console, before creating your job, you might encounter errors\. If that happens, see [Retries on Errors](https://docs.aws.amazon.com/lambda/latest/dg/retries-on-errors.html) in the *AWS Lambda Developer Guide*\.

To test your Lambda functions on\-premises, use the following procedure\.

**To test your Lambda functions on\-premises**

1. Create a subscription in the AWS IoT Greengrass console\. For more information, see [Configure Subscriptions](https://docs.aws.amazon.com/greengrass/latest/developerguide/config_subs.html) in the *AWS IoT Greengrass Developer Guide*\.

1. Deploy the AWS IoT Greengrass Group containing that subscription to the AWS IoT Greengrass Core running on the Snowball Edge device\. In this subscription, you specify the following:
   + The **Source** as the device with Snowball Edge Job ID generated when you created the job\.
   + The **Target** as the AWS IoT service\.

1. After the deployment is successfully completed, log into the AWS IoT console with the account used to create your job\.

1. Choose **Test** and then choose **Subscribe to a topic**\.

1. For **Subscription topic**, enter the name of the bucket on the Snowball Edge to copy an object into\.

1. Choose **Subscribe to topic**\. The MQTT client page then shows you the subscription to the bucket that you specified\.

1. Using the AWS CLI, Amazon S3 Adapter for Snowball, or one of the AWS SDKs, copy an object to the specified bucket\.

A JSON object then display the payloads included in the MQTT message published to the AWS IoT Greengrass Core backing the AWS IoT Greengrass service running on the Snowball Edge device\. This payload includes the name of the object and the name of the bucket the object was PUT into\. 

You've now successfully tested your Lambda function\. The JSON object indicates that the MQTT message published to the AWS IoT Greengrass Core was received successfully, and the associated Lambda function was executed\. For information on adding AWS IoT Greengrass subscriptions to your AWS IoT Greengrass Group, see [Configure Subscriptions](https://docs.aws.amazon.com/greengrass/latest/developerguide/config_subs.html) in the *AWS IoT Greengrass Developer Guide*\.

### Stopping AWS IoT Greengrass<a name="stopping-gg-lambda"></a>

When you're done with AWS Lambda powered by AWS Greengrass, you can stop it with the `snowballEdge stop-service` Snowball client command\. For more information, see [Stopping a Service on Your Snowball Edge](using-client-commands.md#edge-stop-service)\.

AWS Lambda powered by AWS Greengrass running on a Snowball Edge; device is stateless\. As a result, any data \(including AWS IoT Greengrass configuration, certificates, and Lambda functions\) running on the device is lost when the AWS IoT Greengrass service enters the `DEACTIVATING` state or becomes `INACTIVE`\.
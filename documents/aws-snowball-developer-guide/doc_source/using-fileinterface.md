--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Transferring Files to AWS Snowball Edge Using the File Interface<a name="using-fileinterface"></a>

Following, you can find information about using the file interface for the AWS Snowball Edge\. Using this file interface, you can drag and drop files from your computer onto Amazon S3 buckets on the Snowball Edge\.

**Note**  
If you created your job before July 17, 2018, this information doesn't apply to your device\. Instead, see [Using the File Interface for the AWS Snowball Edge](using-fileinterface-old.md)\.

**Topics**
+ [Overview of the File Interface](#fileinterface-overview)
+ [Starting the File Interface](#starting-fileinterface)
+ [Mounting a Bucket with the File Interface](#mounting-fileinterface)
+ [Monitoring the File Interface](#monitor-fileinterface)

## Overview of the File Interface<a name="fileinterface-overview"></a>

The file interface exposes a Network File System \(NFS\) mount point for each bucket on your AWS Snowball Edge device\. You can mount the file share from your NFS client using standard Linux, Microsoft Windows, or Mac commands\. You can use standard file operations to access the file share\.

After the file share has been mounted, a new **file interface** tab appears on the LCD screen on the front of the Snowball Edge\. From this tab, you can get transfer status information, see your NFS point IP addresses, and secure NFS client access to specific buckets\.

You can use the local LCD display on the AWS Snowball Edge device to disable or enable the file interface\. By unlocking the AWS Snowball Edge device, you have all the permissions necessary to read and write data through the file interface\. 

**Topics**
+ [Benefits of the File Interface](#fileinterface-benefits)
+ [Prerequisites for Using the File Interface](#fileinterface-prereqs)
+ [Considerations for Using the File Interface](#fileinterface-considerations)

### Benefits of the File Interface<a name="fileinterface-benefits"></a>

You might want to use the file interface to read and write data because of the following benefits:
+ You can more easily read, write, and delete files by using the file interface\.
+ You can use the local LCD display on the AWS Snowball Edge device to monitor the file interface status\.
+ The file interface preserves user\-defined metadata in objects\. This metadata includes permissions, ownership, and time stamps and can be useful for tracking\.
+ Because files are written to the buckets on the device, adding files can trigger associated AWS Lambda powered by AWS Greengrass functions\.

### Prerequisites for Using the File Interface<a name="fileinterface-prereqs"></a>

Before you can use the file interface, the following steps must occur:
+ You must create a job for your Snowball Edge\. 
+ Your Snowball Edge device must arrive at your location\. 
+ You must unlock your device by using the Snowball client\. 

If one or more of those steps haven't occurred, see the following topics:
+ For more information about creating a job to use a Snowball Edge, see [Getting Started with an AWS Snowball Edge Device](getting-started.md)\.
+ For more information about unlocking a Snowball Edge, see [Transferring Files Using the Amazon S3 Adapter](using-adapter.md)\.

**Important**  
For AWS services to work properly on a Snowball Edge, you must allow the ports for the services\. For details, see [Ports Required to Use AWS Services on an AWS Snowball Edge Device](port-requirements.md)\.

### Considerations for Using the File Interface<a name="fileinterface-considerations"></a>

While using the file interface, keep the following considerations in mind:
+ The maximum size of a file that you can transfer to the file interface on a Snowball Edge is 150 GB\. If you try to transfer a file larger than 150 GB, the file interface will write the first 150 GB of that file, and then return an error message indicating that the file is too large\.
+ We recommend that you use only one method of reading and writing data to each bucket on a Snowball Edge device\. Using both the file interface and the Amazon S3 Adapter for Snowball on the same bucket might result in undefined behavior\.
+ File interface supports all NFS file operations, except truncate, rename, or changing ownership\. Requests that use these unsupported file operations are rejected with error messages sent to your NFS client\. Attempts to change a file’s permissions after the file has been created on the Snowball Edge are ignored without error\.
+ If the Snowball Edge has a power failure or is rebooted, data in the file interface buffer persists\. On reboot, this buffered data is uploaded to buckets on the device\. When **Write status** on the **File interface** tab shows 100 percent with a green progress bar, all data in the file interface buffer is uploaded to the buckets on the device\.
+ Don't write data to a Snowball Edge that is full, or write more data than the size of the remaining available storage\. Either action causes errors that might corrupt your data\. We recommend that you use the Snowball client's `snowballEdge status` command to determine the remaining amount of space on the Snowball Edge\. Then compare that to the amount of data you want to copy over using the file interface before copying the data\.
+ When you've finished copying data to the Snowball Edge using the file interface, you must disable the file interface to avoid losing any data that might be in the buffer but not yet written to the Amazon S3 bucket\. For more information, see [Disabling the File Interface](#fileinterface-cleanup)\.
+ We recommend that you keep a local copy of all data that is written to the file interface until the Snowball Edge has been shipped back to AWS and the data has been ingested to Amazon S3\.

**Note**  
The data transfer rate using the file interface is typically between 25 MB/s and 40 MB/s\. If you need to transfer data faster than this, use the Amazon S3 adapter for Snowball, which has a data transfer rate typically between 250 MB/s and 400 MB/s\. For more information, see [Transferring Files Using the Amazon S3 Adapter](using-adapter.md)\. 

## Starting the File Interface<a name="starting-fileinterface"></a>

Before you can use the file interface, you need to use the Snowball client to start it\.

**Important**  
It can take an hour or more for the file interface to activate\. Don't power off or restart the device during this time\.

**To start the file interface**

1. Run the `snowballEdge describe-device` command to get the list of network interface IDs\. For more information on this command, see [Getting Device Status](using-client-commands.md#client-status)\.

1. Create a virtual network interface\. As part of this, identify the ID for the physical network interface that you want to use, and make a note of it\. The following examples show running the command to create a virtual network interface with the two different IP address assignment methods, either `DHCP` or `STATIC`\.

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
**Example**  

   Output

   ```
   {
        "VirtualNetworkInterface" : {
            "VirtualNetworkInterfaceArn" : "arn:aws:snowball-device:::interface/s.ni-abcd1234",
            "PhysicalNetworkInterfaceId" : "s.ni-abcd1234",
            "IpAddressAssignment" : "DHCP",
            "IpAddress" : "192.0.2.0",
            "Netmask" : "255.255.255.0",
            "DefaultGateway" : "192.0.2.10",
            "MacAddress" : "1a:2b:3c:4d:5e:6f"
        }
   }
   ```

1. When the command returns a JSON structure that includes the IP address, make a note of that IP address\.

1. Start the file interface service using the virtual network interface, as in the following example\.

   ```
   snowballEdge start-service \
   --service-id fileinterface \
   --virtual-network-interface-arns arn:aws:snowball-device:::interface/s.ni-abcd1234abcd1234a
   ```  
**Example**  

   Output

   ```
   Starting the AWS service on your Snowball Edge. You can determine the status of the AWS service using the describe-service command.                    
   ```

1. It can take an hour or more for the file interface to activate\. To see if the service has started, or if it's still activating, you can run the `snowballEdge describe-service --service-id fileinterface` Snowball client command\.

It takes an hour or more for the file interface to activate\. After that time the file interface will start\. Anytime you need the IP address for the file interface, you can use the `snowballEdge describe-virtual-network-interfaces` Snowball client command\.

## Mounting a Bucket with the File Interface<a name="mounting-fileinterface"></a>

The following contains guidance on mounting a file share on Snowball Edge to the NFS client on your computer using the file interface\. It includes information about the supported NFS clients and procedures for enabling those clients on Linux, Mac, and Windows operating systems\.

**Topics**
+ [Supported NFS Clients for the File Interface](#supported-nfs-clients)
+ [Getting the IP Address for the File Share of a Bucket on a Snowball Edge](#fileinterface-ipaddress)
+ [Mounting a File Share with the File Interface on Linux](#mounting-fileinterface-linux)
+ [Mounting a File Share with the File Interface on a Mac](#mounting-fileinterface-mac)
+ [Mounting a File Share with the File Interface on Microsoft Windows](#mounting-fileinterface-windows)

### Supported NFS Clients for the File Interface<a name="supported-nfs-clients"></a>

The file interface supports the following NFS clients:

**Clients with NFSv4 support**
+ Amazon Linux
+ macOS
+ Red Hat Enterprise Linux \(RHEL\) 7
+ Ubuntu 14\.04

**Clients with NFSv3 support**
+ Windows 10, Windows Server 2012, and Windows Server 2016
+ Windows 7 and Windows Server 2008\. For these clients, the maximum supported NFS I/O size is 32 KB\. Because of this factor, you might experience degraded performance on these versions of Windows\.

### Getting the IP Address for the File Share of a Bucket on a Snowball Edge<a name="fileinterface-ipaddress"></a>

You can mount the file shares with a simple command, if you have the IP address for the file share on a Snowball Edge\. You can find the file share's IP address on the LCD display in the **CONNECTION** tab\. You can't use the file interface if this IP address is blank\. Ensure that the file interface gets an IP address\.

**Important**  
The IP address for the file interface is not the IP address that you used to unlock the Snowball Edge device\. The IP address for the file interface can either be a static IP or one issued by your DHCP server\.

**To get the IP address for the file interface**

1. Access the LCD display on the front of the AWS Snowball Edge device\.

1. Tap **CONNECTION** at the top of the LCD display to open the network connection tab\.

1. From the drop\-down list in the center of the page, choose **file interface**\.

   The IP address below this list updates to reflect the DHCP address that the AWS Snowball Edge device requested for the file interface\. You can change it to a static IP address, or leave it as is\.

Now that you have your IP address, you're ready to mount a bucket on the Snowball Edge using the appropriate mount command for your computer's operating system\.

### Mounting a File Share with the File Interface on Linux<a name="mounting-fileinterface-linux"></a>

When you mount file shares on your Linux server, we recommend that you first update your NFS client with the following command\.

```
$sudo yum install nfs-utils
```

When the file interface is enabled, it exposes an NFS mount point for each local bucket on the device\. The file interface supports NFS versions 3, 4\.0, and 4\.1\. You can mount the file shares with a simple command with the IP address for the file interface\. For more information, see [Getting the IP Address for the File Share of a Bucket on a Snowball Edge](#fileinterface-ipaddress)\.

When you have the IP address, you can mount a bucket with the following command\.

```
mount -t nfs –o nolock IP Address:/BucketName local/mount/directory
```

For example, suppose that the IP address for the file interface is 192\.0\.1\.0 and your bucket name is `test-bucket`\. You want to mount your bucket to the `mnt/test-bucket` directory on your local Linux server\. In this case, your command looks like the following\. 

```
mount –o nolock 192.0.1.0:/test-bucket mnt/test-bucket
```

### Mounting a File Share with the File Interface on a Mac<a name="mounting-fileinterface-mac"></a>

You can mount the file shares with a simple command with the IP address for the file interface\. For more information, see [Getting the IP Address for the File Share of a Bucket on a Snowball Edge](#fileinterface-ipaddress)\. When you mount file shares on your Mac, you need to declare the version of the NFS protocol that you're using when you run the mount command\. For example, if you're using the NFSv3\.0 protocol, you use the `vers=3` option\.

```
mount -t nfs –o vers=3,nolock IP Address:/BucketName local mount directory
```

For example, suppose the IP address for the file interface is 192\.0\.1\.0, your bucket name is **test\-bucket**, and you want to mount your bucket to the `private/mybucket` directory on your Mac\. In this case, your command looks like the following\. 

```
sudo mount_nfs -o vers=3,nolock -v 192.0.1.0:/test-bucket private/mybucket
```

### Mounting a File Share with the File Interface on Microsoft Windows<a name="mounting-fileinterface-windows"></a>

When you mount file shares on your Windows server, you need to turn on the Windows Client for NFS\. You also need to assign the mount point a drive letter with the `mount` command\.

**Note**  
For a Windows 7 or Windows Server 2008 server, the maximum supported NFS I/O size is 32 KB\. Because of this limit, you might experience degraded performance for the file interface on these versions of Windows\.

**To turn on Windows Client for NFS**

1. In Windows, from **Start**, search for **Turn Windows features on or off** and choose the application of the same name that appears in the search results\.

1. In the **Windows Features** dialog box that appears, scroll through the list of features until you find **Services for NFS**\.

1. Expand **Services for NFS**, and select the **Client for NFS** check box\.

1. Choose **OK** to close the dialog box with Client for NFS activated\.

You can mount the file shares with a simple command with the IP address for the file interface\. For more information, see [Getting the IP Address for the File Share of a Bucket on a Snowball Edge](#fileinterface-ipaddress)\. You can now mount the file shares on the AWS Snowball Edge device to an unused drive letter on your Windows server as in the following example\.

```
mount -o nolock 192.0.1.0:/test-bucket Z:
```

## Monitoring the File Interface<a name="monitor-fileinterface"></a>

When you use the file interface, it's important to keep an eye on its overall health and current status\. You can perform these tasks by using the **file interface** tab on the LCD display on the front of the AWS Snowball Edge device\.

**Topics**
+ [Getting the Status of the File Interface](#fileinterface-statusinfo)
+ [Securing Your NFS Connection](#fileinterface-secureconnect)
+ [Disabling the File Interface](#fileinterface-cleanup)

### Getting the Status of the File Interface<a name="fileinterface-statusinfo"></a>

On the **file interface** tab, there are two health indicators, **Status** and **Write status**\. The following list describes how to work with these indicators:
+ **Status** indicates the operational status of the file interface as a whole\. It has the following possible values:
  + **Enabled** – The file interface is up and running normally\.
  + **Disabling** – The file interface is stopped, and nothing can be written to it\. 
  + **Disabled** – The file interface has stopped and the mount point is no longer available\. In addition, all the data in the device's memory buffer has been encrypted and written to the local Amazon S3 buckets\.
  + **Error** – An error has occurred\. If you see this status, contact AWS Support\.
+ **Write status** shows you the progress of the current write operation executed on the AWS Snowball Edge device using a progress bar: 
  + At 0–99 percent, a write operation is actively happening on the device and data is in the buffer\. Don't disconnect the device before writing has completed\.
  + At 100 percent, with a green progress bar, the last write operation completed successfully\. There is no data in the buffer, and no new write operations have begun\.

### Securing Your NFS Connection<a name="fileinterface-secureconnect"></a>

When a job for an AWS Snowball Edge device is created on the AWS console, all Amazon S3 buckets selected for the job are enabled by default as active file shares\. When the device arrives at your site, and you set up, connect, and unlock it, anyone on your network who can see the IP address for the file interface can access the file shares for each bucket\.

Therefore, we recommend that you secure the buckets by specifying which NFS clients are allowed to access your buckets\. You can do this from the LCD screen on the front of the Snowball Edge with the following procedure\.

**To allow only certain NFS clients to access the file shares for your buckets on a Snowball Edge**

1. On the LCD display, tap **File interface** to open its tab\.

1. From **Allowed clients**, choose your bucket from the drop\-down list\.

1. Tap **Edit** to reveal the text boxes that you can enter your IP addresses into\.

1. In the top box, use the onscreen keyboard to type in the IP address of a computer that you want to mount the file share for that bucket to\.

1. If you have other computers connected to this same bucket, type in their IP addresses in the subsequent text boxes\.

You have now secured the file share for one of your buckets on the Snowball Edge\. You can repeat this process for all the file shares for the buckets on the Snowball Edge to secure access to the data in your device\.

Once you specify an IP address for an allowed client, you can return that file share to unrestricted again by changing the IP address to `0.0.0.0`\. If the IP address of the computer connected to it ever changes, you need to update the IP address for that allowed client\.

### Disabling the File Interface<a name="fileinterface-cleanup"></a>

When you're done using the file interface, you should disable the file interface after the **Write Status** on the AWS Snowball Edge device is set to **Complete**\. Disabling the file interface helps you avoid data loss by ensuring that all files have been written to the device\.

When you're done with the file interface, you can stop it with the `snowballEdge stop-service` Snowball client command\. For more information, see [Stopping a Service on Your Snowball Edge](using-client-commands.md#edge-stop-service)\.
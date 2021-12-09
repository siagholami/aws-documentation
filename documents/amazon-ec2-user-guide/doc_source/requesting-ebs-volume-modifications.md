# Requesting modifications to your EBS Volumes<a name="requesting-ebs-volume-modifications"></a>

With Elastic Volumes, you can dynamically modify the size, performance, and volume type of your Amazon EBS volumes without detaching them\.

Use the following process when modifying a volume:

1. \(Optional\) Before modifying a volume that contains valuable data, it is a best practice to create a snapshot of the volume in case you need to roll back your changes\. For more information, see [Creating Amazon EBS snapshots](ebs-creating-snapshot.md)\.

1. Request the volume modification\.

1. Monitor the progress of the volume modification\. For more information, see [Monitoring the progress of volume modifications](monitoring-volume-modifications.md)\.

1. If the size of the volume was modified, extend the volume's file system to take advantage of the increased storage capacity\. For more information, see [Extending a Linux file system after resizing a volume](recognize-expanded-volume-linux.md)\.

**Topics**
+ [Modifying an EBS volume using Elastic Volumes \(console\)](#modify-ebs-volume)
+ [Modifying an EBS volume using Elastic Volumes \(AWS CLI\)](#modify-ebs-volume-cli)
+ [Initializing Elastic Volumes support \(if needed\)](#initialize-modification-support)
+ [Modifying an EBS volume if Elastic Volumes is not supported](#modify-volume-stop-start)

## Modifying an EBS volume using Elastic Volumes \(console\)<a name="modify-ebs-volume"></a>

Use the following procedure to modify an EBS volume\.<a name="console-modify-size"></a>

**To modify an EBS volume using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Volumes**, select the volume to modify, and then choose **Actions**, **Modify Volume**\.

1. The **Modify Volume** window displays the volume ID and the volume's current configuration, including type, size, and IOPS\. You can change any or all of these settings in a single action\. Set new configuration values as follows:
   + To modify the type, choose a value for **Volume Type**\.
   + To modify the size, enter an allowed integer value for **Size**\.
   + If you chose **Provisioned IOPS SSD \(io1\)** or **Provisioned IOPS SSD \(io2\)** as the volume type, enter an allowed integer value for **IOPS**\.

1. After you have finished changing the volume settings, choose **Modify**\. When prompted for confirmation, choose **Yes**\.

1. Modifying volume size has no practical effect until you also extend the volume's file system to make use of the new storage capacity\. For more information, see [Extending a Linux file system after resizing a volume](recognize-expanded-volume-linux.md)\.

## Modifying an EBS volume using Elastic Volumes \(AWS CLI\)<a name="modify-ebs-volume-cli"></a>

Use the [modify\-volume](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-volume.html) command to modify one or more configuration settings for a volume\. For example, if you have a volume of type `gp2` with a size of 100 GiB, the following command changes its configuration to a volume of type `io1` with 10,000 IOPS and a size of 200 GiB\.

```
aws ec2 modify-volume --volume-type io1 --iops 10000 --size 200 --volume-id vol-11111111111111111 
```

The following is example output:

```
{
    "VolumeModification": {
        "TargetSize": 200,
        "TargetVolumeType": "io1",
        "ModificationState": "modifying",
        "VolumeId": "vol-11111111111111111",
        "TargetIops": 10000,
        "StartTime": "2017-01-19T22:21:02.959Z",
        "Progress": 0,
        "OriginalVolumeType": "gp2",
        "OriginalIops": 300,
        "OriginalSize": 100
    }
}
```

Modifying volume size has no practical effect until you also extend the volume's file system to make use of the new storage capacity\. For more information, see [Extending a Linux file system after resizing a volume](recognize-expanded-volume-linux.md)\.

## Initializing Elastic Volumes support \(if needed\)<a name="initialize-modification-support"></a>

Before you can modify a volume that was attached to an instance before November 3, 2016 23:40 UTC, you must initialize volume modification support using one of the following actions:
+ Detach and attach the volume
+ Stop and start the instance

Use one of the following procedures to determine whether your instances are ready for volume modification\.

**To determine whether your instances are ready using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. On the navigation pane, choose **Instances**\.

1. Choose the **Show/Hide Columns** icon \(the gear\)\. Select the **Launch Time** and **Block Devices** attributes and then choose **Close**\.

1. Sort the list of instances by the **Launch Time** column\. For instances that were started before the cutoff date, check when the devices were attached\. In the following example, you must initialize volume modification for the first instance because it was started before the cutoff date and its root volume was attached before the cutoff date\. The other instances are ready because they were started after the cutoff date\.  
![\[Check the Launch Time and Block Devices columns.\]](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/images/check-volume-modification-support.png)

**To determine whether your instances are ready using the CLI**  
Use the following [describe\-instances](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-instances.html) command to determine whether the volume was attached before November 3, 2016 23:40 UTC\.

```
aws ec2 describe-instances --query "Reservations[*].Instances[*].[InstanceId,LaunchTime<='2016-11-01',BlockDeviceMappings[*][Ebs.AttachTime<='2016-11-01']]" --output text
```

The first line of the output for each instance shows its ID and whether it was started before the cutoff date \(True or False\)\. The first line is followed by one or more lines that show whether each EBS volume was attached before the cutoff date \(True or False\)\. In the following example output, you must initialize volume modification for the first instance because it was started before the cutoff date and its root volume was attached before the cutoff date\. The other instances are ready because they were started after the cutoff date\.

```
i-e905622e              True
True
i-719f99a8              False
True
i-006b02c1b78381e57     False
False
False
i-e3d172ed              False
True
```

## Modifying an EBS volume if Elastic Volumes is not supported<a name="modify-volume-stop-start"></a>

If you are using a supported instance type, you can use Elastic Volumes to dynamically modify the size, performance, and volume type of your Amazon EBS volumes without detaching them\.

If you cannot use Elastic Volumes but you need to modify the root \(boot\) volume, you must stop the instance, modify the volume, and then restart the instance\.

After the instance has started, you can check the file system size to see if your instance recognizes the larger volume space\. On Linux, use the df \-h command to check the file system size\.

```
[ec2-user ~]$ df -h
Filesystem            Size  Used Avail Use% Mounted on
/dev/xvda1            7.9G  943M  6.9G  12% /
tmpfs                 1.9G     0  1.9G   0% /dev/shm
```

If the size does not reflect your newly expanded volume, you must extend the file system of your device so that your instance can use the new space\. For more information, see [Extending a Linux file system after resizing a volume](recognize-expanded-volume-linux.md)\.
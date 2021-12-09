# Spot Instance interruptions<a name="spot-interruptions"></a>

Demand for Spot Instances can vary significantly from moment to moment, and the availability of Spot Instances can also vary significantly depending on how many unused EC2 instances are available\. It is always possible that your Spot Instance might be interrupted\. Therefore, you must ensure that your application is prepared for a Spot Instance interruption\.

An On\-Demand Instance specified in an EC2 Fleet or Spot Fleet cannot be interrupted\.

**Topics**
+ [Reasons for interruption](#interruption-reasons)
+ [Interruption behaviors](#interruption-behavior)
+ [Specifying the interruption behavior](#specifying-spot-interruption-behavior)
+ [Preparing for interruptions](#using-spot-instances-managing-interruptions)
+ [Preparing for instance hibernation](#prepare-for-instance-hibernation)
+ [Spot Instance interruption notices](#spot-instance-termination-notices)
+ [Finding interrupted Spot Instances](#finding-an-interrupted-Spot-Instance)
+ [Determining whether Amazon EC2 interrupted a Spot Instance](#BidEvictedEvent)
+ [Billing for interrupted Spot Instances](#billing-for-interrupted-spot-instances)

## Reasons for interruption<a name="interruption-reasons"></a>

The following are the possible reasons that Amazon EC2 might interrupt your Spot Instances:
+ Price – The Spot price is greater than your maximum price\.
+ Capacity – If there are not enough unused EC2 instances to meet the demand for Spot Instances, Amazon EC2 interrupts Spot Instances\. The order in which the instances are interrupted is determined by Amazon EC2\.
+ Constraints – If your request includes a constraint such as a launch group or an Availability Zone group, these Spot Instances are terminated as a group when the constraint can no longer be met\.

## Interruption behaviors<a name="interruption-behavior"></a>

You can specify that Amazon EC2 should do one of the following when it interrupts a Spot Instance:
+ Stop the Spot Instance
+ Hibernate the Spot Instance
+ Terminate the Spot Instance

The default is to terminate Spot Instances when they are interrupted\. To change the interruption behavior, see [Specifying the interruption behavior](#specifying-spot-interruption-behavior)\.

### Stopping interrupted Spot Instances<a name="stop-spot-instances"></a>

You can specify the interruption behavior so that Amazon EC2 stops Spot Instances when they are interrupted if the following requirements are met\.

**Requirements**
+ For a Spot Instance request, the type must be `persistent`\. You cannot specify a launch group in the Spot Instance request\.
+ For an EC2 Fleet or Spot Fleet request, the type must be `maintain`\.
+ The root volume must be an EBS volume, not an instance store volume\.

After a Spot Instance is stopped by the Spot service, only the Spot service can restart the Spot Instance, and the same launch specification must be used\.

For a Spot Instance launched by a `persistent` Spot Instance request, the Spot service restarts the stopped instance when capacity is available in the same Availability Zone and for the same instance type as the stopped instance\.

If instances in an EC2 Fleet or Spot Fleet are stopped and the fleet is of type `maintain`, the Spot service launches replacement instances to maintain the target capacity\. The Spot service finds the best pools based on the specified allocation strategy \(`lowestPrice`, `diversified`, or `InstancePoolsToUseCount`\); it does not prioritize the pool with the earlier stopped instances\. Later, if the allocation strategy leads to a pool containing the earlier stopped instances, the Spot service restarts the stopped instances to meet the target capacity\.

For example, consider a Spot Fleet with the `lowestPrice` allocation strategy\. At initial launch, a `c3.large` pool meets the `lowestPrice` criteria for the launch specification\. Later, when the `c3.large` instances are interrupted, the Spot service stops the instances and replenishes capacity from another pool that fits the `lowestPrice` strategy\. This time, the pool happens to be a `c4.large` pool and the Spot service launches `c4.large` instances to meet the target capacity\. Similarly, Spot Fleet could move to a `c5.large` pool the next time\. In each of these transitions, the Spot service does not prioritize pools with earlier stopped instances, but rather prioritizes purely on the specified allocation strategy\. The `lowestPrice` strategy can lead back to pools with earlier stopped instances\. For example, if instances are interrupted in the `c5.large` pool and the `lowestPrice` strategy leads it back to the `c3.large` or `c4.large` pools, the earlier stopped instances are restarted to fulfill target capacity\.

While a Spot Instance is stopped, you can modify some of its instance attributes, but not the instance type\. If you detach or delete an EBS volume, it is not attached when the Spot Instance is started\. If you detach the root volume and the Spot service attempts to start the Spot Instance, instance start fails and the Spot service terminates the stopped instance\.

You can terminate a Spot Instance while it is stopped\. If you cancel a Spot request, an EC2 Fleet, or a Spot Fleet, the Spot service terminates any associated Spot Instances that are stopped\.

While a Spot Instance is stopped, you are charged only for the EBS volumes, which are preserved\. With EC2 Fleet and Spot Fleet, if you have many stopped instances, you can exceed the limit on the number of EBS volumes for your account\.

### Hibernating interrupted Spot Instances<a name="hibernate-spot-instances"></a>

You can specify the interruption behavior so that Amazon EC2 hibernates Spot Instances when they are interrupted if the following requirements are met\.

**Requirements**
+ For a Spot Instance request, the type must be `persistent`\. You cannot specify a launch group in the Spot Instance request\.
+ For an EC2 Fleet or Spot Fleet request, the type must be `maintain`\.
+ The root volume must be an EBS volume, not an instance store volume, and it must be large enough to store the instance memory \(RAM\) during hibernation\.
+ The following instances are supported: C3, C4, C5, M4, M5, R3, and R4, with less than 100 GB of memory\.
+ The following operating systems are supported: Amazon Linux 2, Amazon Linux AMI, Ubuntu with an AWS\-tuned Ubuntu kernel \(linux\-aws\) greater than 4\.4\.0\-1041, and Windows Server 2008 R2 and later\.
+ Install the hibernation agent on a supported operating system, or use one of the following AMIs, which already include the agent:
  + Amazon Linux 2
  + Amazon Linux AMI 2017\.09\.1 or later
  + Ubuntu Xenial 16\.04 20171121 or later
  + Windows Server 2008 R2 AMI 2017\.11\.19 or later
  + Windows Server 2012 or Windows Server 2012 R2 AMI 2017\.11\.19 or later
  + Windows Server 2016 AMI 2017\.11\.19 or later
  + Windows Server 2019
+ Start the agent\. We recommend that you use user data to start the agent on instance startup\. Alternatively, you could start the agent manually\.

**Recommendation**
+ We strongly recommend that you use an encrypted Amazon EBS volume as the root volume, because instance memory is stored on the root volume during hibernation\. This ensures that the contents of memory \(RAM\) are encrypted when the data is at rest on the volume and when data is moving between the instance and volume\. Use one of the following three options to ensure that the root volume is an encrypted Amazon EBS volume:
  + EBS “single\-step” encryption: In a single run\-instances API call, you can launch encrypted EBS\-backed EC2 instances from an unencrypted AMI\. For more information, see [Using encryption with EBS\-backed AMIs](AMIEncryption.md)\.
  + EBS encryption by default: You can enable EBS encryption by default to ensure all new EBS volumes created in your AWS account are encrypted\. For more information, see [Encryption by default](EBSEncryption.md#encryption-by-default)\.
  + Encrypted AMI: You can enable EBS encryption by using an encrypted AMI to launch your instance\. If your AMI does not have an encrypted root snapshot, you can copy it to a new AMI and request encryption\. For more information, see [Encrypt an unencrypted image during copy](AMIEncryption.md#copy-unencrypted-to-encrypted) and [Copying an AMI](CopyingAMIs.md#ami-copy-steps)\. 

When a Spot Instance is hibernated by the Spot service, the EBS volumes are preserved and instance memory \(RAM\) is preserved on the root volume\. The private IP addresses of the instance are also preserved\. Instance storage volumes and public IP addresses, other than Elastic IP addresses, are not preserved\. While the instance is hibernating, you are charged only for the EBS volumes\. With EC2 Fleet and Spot Fleet, if you have many hibernated instances, you can exceed the limit on the number of EBS volumes for your account\.

The agent prompts the operating system to hibernate when the instance receives a signal from the Spot service\. If the agent is not installed, the underlying operating system doesn't support hibernation, or there isn't enough volume space to save the instance memory, hibernation fails and the Spot service stops the instance instead\.

When the Spot service hibernates a Spot Instance, you receive an interruption notice, but you do not have two minutes before the Spot Instance is interrupted\. Hibernation begins immediately\. While the instance is in the process of hibernating, instance health checks might fail\. When the hibernation process completes, the state of the instance is `stopped`\.

**Resuming a hibernated Spot Instance**

After a Spot Instance is hibernated by the Spot service, it can only be resumed by the Spot service\. The Spot service resumes the instance when capacity becomes available with a Spot price that is less than your specified maximum price\.

For more information, see [Preparing for instance hibernation](#prepare-for-instance-hibernation)\.

For information about hibernating On\-Demand Instances, see [Hibernate your Linux instance](Hibernate.md)\.

## Specifying the interruption behavior<a name="specifying-spot-interruption-behavior"></a>

If you do not specify an interruption behavior, the default is to terminate Spot Instances when they are interrupted\. You can specify the interruption behavior when you create a Spot request\. The way in which you specify the interruption behavior is different depending on how you request Spot Instances\.

If you request Spot Instances using the [launch instance wizard](launching-instance.md), you can specify the interruption behavior as follows: Select the **Persistent request** check box and then, from **Interruption behavior**, choose an interruption behavior\.

If you request Spot Instances using the [Spot console](spot-fleet-requests.md#create-spot-fleet), you can specify the interruption behavior as follows: Select the **Maintain target capacity** check box and then, from **Interruption behavior**, choose an interruption behavior\.

If you configure Spot Instances in a [launch template](ec2-launch-templates.md#create-launch-template), you can specify the interruption behavior as follows: In the launch template, expand **Advanced details** and select the **Request Spot Instances** checkbox\. Choose **Customize** and then, from **Interruption behavior**, choose an interruption behavior\.

If you configure Spot Instances in a launch configuration when using the [request\-spot\-fleet](https://docs.aws.amazon.com/cli/latest/reference/ec2/request-spot-fleet.html) CLI, you can specify the interruption behavior as follows: For `InstanceInterruptionBehavior`, specify an interruption behavior\.

If you configure Spot Instances using the [request\-spot\-instances](https://docs.aws.amazon.com/cli/latest/reference/ec2/request-spot-instances.html) CLI, you can specify the interruption behavior as follows: For `--instance-interruption-behavior`, specify an interruption behavior\.

## Preparing for interruptions<a name="using-spot-instances-managing-interruptions"></a>

Here are some best practices to follow when you use Spot Instances:
+ Use the default maximum price, which is the On\-Demand price\.
+ Ensure that your instance is ready to go as soon as the request is fulfilled by using an Amazon Machine Image \(AMI\) that contains the required software configuration\. You can also use user data to run commands at start\-up\.
+ Store important data regularly in a place that isn't affected when the Spot Instance terminates\. For example, you can use Amazon S3, Amazon EBS, or DynamoDB\.
+ Divide the work into small tasks \(using a Grid, Hadoop, or queue\-based architecture\) or use checkpoints so that you can save your work frequently\.
+ Use Spot Instance interruption notices to monitor the status of your Spot Instances\.
+ While we make every effort to provide this warning as soon as possible, it is possible that your Spot Instance is terminated before the warning can be made available\. Test your application to ensure that it handles an unexpected instance termination gracefully, even if you are testing for interruption notices\. You can do so by running the application using an On\-Demand Instance and then terminating the On\-Demand Instance yourself\.

## Preparing for instance hibernation<a name="prepare-for-instance-hibernation"></a>

You must install a hibernation agent on your instance, unless you used an AMI that already includes the agent\. You must run the agent on instance startup, whether the agent was included in your AMI or you installed it yourself\.

The following procedures help you prepare a Linux instance\. For directions to prepare a Windows instance, see [Preparing for instance hibernation](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/spot-interruptions.html#prepare-for-instance-hibernation) in the *Amazon EC2 User Guide for Windows Instances*\.

**To prepare an Amazon Linux instance**

1. Verify that your kernel supports hibernation and update the kernel if necessary\.

1. If your AMI doesn't include the agent, install the agent using the following command\.

   ```
   sudo yum update; sudo yum install hibagent
   ```

1. Add the following to the user data:

   ```
   #!/bin/bash
   /usr/bin/enable-ec2-spot-hibernation
   ```

**To prepare an Ubuntu instance**

1. If your AMI doesn't include the agent, install the agent using the following command\. The hibernation agent is only available on Ubuntu 16\.04 or later\.

   ```
   sudo apt-get install hibagent
   ```

1. Add the following to the user data\.

   ```
   #!/bin/bash
   /usr/bin/enable-ec2-spot-hibernation
   ```

## Spot Instance interruption notices<a name="spot-instance-termination-notices"></a>

The best way for you to gracefully handle Spot Instance interruptions is to architect your application to be fault\-tolerant\. To accomplish this, you can take advantage of *Spot Instance interruption notices*\. A Spot Instance interruption notice is a warning that is issued two minutes before Amazon EC2 stops or terminates your Spot Instance\. If you specify hibernation as the interruption behavior, you receive an interruption notice, but you do not receive a two\-minute warning because the hibernation process begins immediately\.

We recommend that you check for these interruption notices every 5 seconds\. 

The interruption notice is made available as a CloudWatch event and as an item in the [instance metadata](ec2-instance-metadata.md) on the Spot Instance\.

### EC2 Spot Instance interruption notice<a name="ec2-spot-instance-interruption-warning-event"></a>

When Amazon EC2 is going to interrupt your Spot Instance, it emits an event two minutes prior to the actual interruption \(except for hibernation, which gets the interruption notice, but not two minutes in advance, because hibernation begins immediately\)\. This event can be detected by Amazon CloudWatch Events\. For more information about CloudWatch events, see the [Amazon CloudWatch Events User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/)\. For a detailed example that walks you through how to create and use event rules, see [Taking Advantage of Amazon EC2 Spot Instance Interruption Notices](http://aws.amazon.com/blogs/compute/taking-advantage-of-amazon-ec2-spot-instance-interruption-notices/)\.

The following is an example of the event for Spot Instance interruption\. The possible values for `instance-action` are `hibernate`, `stop`, and `terminate`\.

```
{
    "version": "0",
    "id": "12345678-1234-1234-1234-123456789012",
    "detail-type": "EC2 Spot Instance Interruption Warning",
    "source": "aws.ec2",
    "account": "123456789012",
    "time": "yyyy-mm-ddThh:mm:ssZ",
    "region": "us-east-2",
    "resources": ["arn:aws:ec2:us-east-2:123456789012:instance/i-1234567890abcdef0"],
    "detail": {
        "instance-id": "i-1234567890abcdef0",
        "instance-action": "action"
    }
}
```

### instance\-action<a name="instance-action-metadata"></a>

If your Spot Instance is marked to be stopped or terminated by the Spot service, the `instance-action` item is present in your [instance metadata](ec2-instance-metadata.md)\. Otherwise, it is not present\. You can retrieve `instance-action` as follows\.

------
#### [ IMDSv2 ]

```
[ec2-user ~]$ TOKEN=`curl -X PUT "http://169.254.169.254/latest/api/token" -H "X-aws-ec2-metadata-token-ttl-seconds: 21600"` \
&& curl -H "X-aws-ec2-metadata-token: $TOKEN" –v http://169.254.169.254/latest/meta-data/spot/instance-action
```

------
#### [ IMDSv1 ]

```
[ec2-user ~]$ curl http://169.254.169.254/latest/meta-data/spot/instance-action
```

------

The `instance-action` item specifies the action and the approximate time, in UTC, when the action will occur\.

 The following example indicates the time at which this instance will be stopped\.

```
{"action": "stop", "time": "2017-09-18T08:22:00Z"}
```

The following example indicates the time at which this instance will be terminated\.

```
{"action": "terminate", "time": "2017-09-18T08:22:00Z"}
```

If Amazon EC2 is not preparing to stop or terminate the instance, or if you terminated the instance yourself, `instance-action` is not present and you receive an HTTP 404 error when you try to retrieve it\.

### termination\-time<a name="termination-time-metadata"></a>

This item is maintained for backward compatibility; you should use `instance-action` instead\.

If your Spot Instance is marked for termination by the Spot service, the `termination-time` item is present in your instance metadata\. Otherwise, it is not present\. You can retrieve `termination-time` as follows\.

------
#### [ IMDSv2 ]

```
[ec2-user ~]$ TOKEN=`curl -X PUT "http://169.254.169.254/latest/api/token" -H "X-aws-ec2-metadata-token-ttl-seconds: 21600"`
[ec2-user ~]$ if curl -H "X-aws-ec2-metadata-token: $TOKEN" -s http://169.254.169.254/latest/meta-data/spot/termination-time | grep -q .*T.*Z; then echo terminated; fi
```

------
#### [ IMDSv1 ]

```
[ec2-user ~]$ if curl -s http://169.254.169.254/latest/meta-data/spot/termination-time | grep -q .*T.*Z; then echo terminated; fi
```

------

The `termination-time` item specifies the approximate time in UTC when the instance receives the shutdown signal\. For example:

```
2015-01-05T18:02:00Z
```

If Amazon EC2 is not preparing to terminate the instance, or if you terminated the Spot Instance yourself, the `termination-time` item is either not present \(so you receive an HTTP 404 error\) or contains a value that is not a time value\.

If Amazon EC2 fails to terminate the instance, the request status is set to `fulfilled`\. The `termination-time` value remains in the instance metadata with the original approximate time, which is now in the past\.

## Finding interrupted Spot Instances<a name="finding-an-interrupted-Spot-Instance"></a>

In the console, the **Instances** pane displays all instances, including Spot Instances\. You can identify a Spot Instance from the `spot` value in the **Lifecycle** column\. The **Instance State** column indicates whether the instance is `pending`, `running`, `stopping`, `stopped`, `shutting-down`, or `terminated`\. For a hibernated Spot Instance, the instance state is `stopped`\.

**To find an interrupted Spot Instance \(console\)**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. In the navigation pane, choose **Instances**\. In the top right corner, choose the **Show/Hide Columns** icon, and under **Instance Attributes**, select **Lifecycle**\. For Spot Instances, **Lifecycle** is `spot`\.

   Alternatively, in the navigation pane, choose **Spot Requests**\. You can see both Spot Instance requests and Spot Fleet requests\. To view the IDs of the instances, select a Spot Instance request or a Spot Fleet request and choose the **Instances** tab\. Choose an instance ID to display the instance in the **Instances** pane\.

1. For each Spot Instance, you can view its state in the **Instance State** column\.

**To find interrupted Spot Instances \(AWS CLI\)**  
You can list your interrupted Spot Instances using the [describe\-instances](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-instances.html) command with the `--filters` parameter\. To list only the instance IDs in the output, add the `--query` parameter\.

```
aws ec2 describe-instances \
    --filters Name=instance-lifecycle,Values=spot Name=instance-state-name,Values=terminated,stopped \
    --query Reservations[*].Instances[*].InstanceId
```

## Determining whether Amazon EC2 interrupted a Spot Instance<a name="BidEvictedEvent"></a>

If a Spot Instance is stopped, hibernated, or terminated, you can use CloudTrail to see whether Amazon EC2 interrupted the Spot Instance\. In CloudTrail, the event name `BidEvictedEvent` indicates that Amazon EC2 interrupted the Spot Instance\. For more information about using CloudTrail, see [Logging Amazon EC2 and Amazon EBS API calls with AWS CloudTrail](monitor-with-cloudtrail.md)\.

## Billing for interrupted Spot Instances<a name="billing-for-interrupted-spot-instances"></a>

When a Spot Instance \(*not* in a Spot block\) is interrupted, you’re charged as follows\.

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-interruptions.html)

When a Spot Instance *in a Spot block* is interrupted, you’re charged as follows\.

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-interruptions.html)
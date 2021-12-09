# Troubleshooting<a name="troubleshooting"></a>

## File System Mount Fails Right Away<a name="mount-fails-right-away"></a>

The file system mount command fails right away\. The following code shows an example\.

```
mount.lustre: mount fs-0123456789abcdef0.fsx.us-east-1.aws@tcp:/fsx at /lustre
failed: No such file or directory

Is the MGS specification correct?
Is the filesystem name correct?
```

This error can occur if you aren't using the correct `mountname` value when mounting a persistent or scratch 2 file system by using the mount command\. You can get the `mountname` value from the response of the [https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html](https://docs.aws.amazon.com/cli/latest/reference/fsx/describe-file-systems.html) AWS CLI command or the [https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html) API operation\.

## File System Mount Hangs and Then Fails with Timeout Error<a name="mount-hangs-fails-timeout"></a>

The file system mount command hangs for a minute or two, and then fails with a timeout error\. 

The following code shows an example\.

```
sudo mount -t lustre file_system_dns_name@tcp:/mountname /mnt/fsx

[2+ minute wait here]
Connection timed out
```

This error can occur because the security groups for the Amazon EC2 instance or the file system aren't configured properly\.

**Action to Take**

Make sure that your security groups for the file system have the inbound rules specified in [Amazon VPC Security Groups](limit-access-security-groups.md#fsx-vpc-security-groups)\. 

## Automatic Mounting Fails and the Instance Is Unresponsive<a name="lustre-automount-fails"></a>

In some cases, automatic mounting might fail for a file system and your Amazon EC2 instance might stop responding\.

This issue can occur if the `_netdev` option wasn't declared\. If `_netdev` is missing, your Amazon EC2 instance can stop responding\. This result is because network file systems need to be initialized after the compute instance starts its networking\.

**Action to Take**  
If this issue occurs, contact AWS Support\.

## File System Mount Using DNS Name Fails<a name="mount-fails-dns-name"></a>

A file system mount that is using a Domain Name Service \(DNS\) name fails\. The following code shows an example\.

```
sudo mount -t lustre file_system_dns_name@tcp:/mountname /mnt/fsx
mount.lustre: Can't parse NID 
'file_system_dns_name@tcp:/mountname'
```

**Action to Take**

Check your virtual private cloud \(VPC\) configuration\. If you are using a custom VPC, make sure that DNS settings are enabled\. For more information, see [Using DNS with Your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-dns.html) in the *Amazon VPC User Guide*\. 

To specify a DNS name in the `mount` command, do the following:
+ Ensure that the Amazon EC2 instance is in the same VPC as your Amazon FSx for Lustre file system\.
+ Connect your Amazon EC2 instance inside a VPC configured to use the DNS server provided by Amazon\. For more information, see [DHCP Options Sets](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_DHCP_Options.html) in the *Amazon VPC User Guide*\.
+ Ensure that the Amazon VPC of the connecting Amazon EC2 instance has DNS host names enabled\. For more information, see [Updating DNS Support for Your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-dns.html#vpc-dns-updating) in the *Amazon VPC User Guide*\.

A file system mount that is using a Domain Name Service \(DNS\) name fails\. The following code shows an example\.

```
mount -t lustre file_system_dns_name@tcp:/mountname /mnt/fsx
mount.lustre: mount file_system_dns_name@tcp:/mountname at /mnt/fsx failed: Input/output error Is the MGS running?
```

**Action to Take**

 Make sure that the client's VPC security groups have the correct outbound traffic rules applied\. This recommendation holds true especially if you aren't using the default security group, or if you have modified the default security group\. For more information, see [Amazon VPC Security Groups](limit-access-security-groups.md#fsx-vpc-security-groups)\. 

## Misconfigured linked S3 bucket<a name="troubleshooting-misconfigured-data-repository"></a>

In some cases, an Amazon FSx for Lustre file system's linked S3 bucket will have a misconfigured data repository lifecycle state\. For more information, see [Data repository lifecycle state](overview-data-repo.md#data-repository-lifecycles)\. A linked data repository can have a misconfigured lifecycle state under the following conditions:
+ The linked S3 bucket has an existing event notification configuration with event types that overlap with the Amazon FSx event notification configuration \(`s3:ObjectCreated:*`, `s3:ObjectRemoved:*`\)\.
+ The Amazon FSx event notification configuration on the linked S3 bucket was deleted or modified\.
+ Amazon FSx does not have the necessary IAM permissions required to access the linked S3 bucket\.

**Possible cause**

Amazon FSx does not have the necessary IAM permissions required to access the linked S3 bucket\.

**Action to Take**

1. Ensure that your IAM entity \(user, group, or role\) has the appropriate permissions to create file systems\. Doing this includes adding the permissions policy that supports the Amazon FSx for Lustre service\-linked role\. For more information, see [Adding Permissions to Use Data Repositories in Amazon S3](setting-up.md#fsx-adding-permissions-s3)\.

1. Using the Amazon FSx CLI or API, refresh the file system's `AutoImportPolicy` with the `update-file-system` CLI command \([UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) is the equivalent API action\), as follows\. 

   ```
   aws fsx update-file-system \
   --file-system-id fs-0123456789abcdef0 \
   --lustre-configuration AutoImportPolicy=the_existing_AutoImportPolicy
   ```

For more information about service\-linked roles, see [Using Service\-Linked Roles for Amazon FSx for Lustre](using-service-linked-roles.md)\.

**Possible causes**

A linked S3 bucket can have a misconfigured data repository lifecycle state if either of the following conditions exist:
+ The linked S3 bucket has an existing event notification configuration with event types that overlap with the Amazon FSx event notification configuration \(`s3:ObjectCreated:*`, `s3:ObjectRemoved:*`\)\. 
+ The Amazon FSx event notification configuration on the linked S3 bucket was deleted or modified\.

**Action to take**

1. Remove any existing event notification on the linked S3 bucket that uses either of the event types that the FSx event configuration uses, `s3:ObjectCreated:*` and `s3:ObjectRemoved:*`\.

1. Reapply the FSx event notification configuration on the S3 bucket by using the Amazon FSx CLI or API, to refresh the file system's `AutoImportPolicy`\. Do so with the `update-file-system` CLI command \([UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) is the equivalent API action\), as follows\. 

   ```
   aws fsx update-file-system \
   --file-system-id fs-0123456789abcdef0 \
   --lustre-configuration AutoImportPolicy=the_existing_AutoImportPolicy
   ```

## Cannot create a file system that is linked to an S3 bucket<a name="slr-permissions-fails"></a>

If creating a new file system that is linked to an S3 bucket fails with an error message similar to the following\.

```
User: arn:aws:iam::012345678901:user/username is not authorized to perform: iam:PutRolePolicy on resource: resource ARN
```

This error can happen if you try to create a file system linked to an Amazon S3 bucket without the necessary IAM permissions\. The required IAM permissions support the Amazon FSx for Lustre service\-linked role that is used to access the specified Amazon S3 bucket on your behalf\.

**Action to Take**

Ensure that your IAM entity \(user, group, or role\) has the appropriate permissions to create file systems\. Doing this includes adding the permissions policy that supports the Amazon FSx for Lustre service\-linked role\. For more information, see [Adding Permissions to Use Data Repositories in Amazon S3](setting-up.md#fsx-adding-permissions-s3)\.

For more information about service\-linked roles, see [Using Service\-Linked Roles for Amazon FSx for Lustre](using-service-linked-roles.md)\.
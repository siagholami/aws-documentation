# `[raid]` section<a name="raid-section"></a>

**Topics**
+ [`shared_dir`](#raid-shared-dir)
+ [`raid_type`](#raid-type)
+ [`num_of_raid_volumes`](#num-of-raid-volumes)
+ [`volume_type`](#raid-volume-type)
+ [`volume_size`](#raid-volume-size)
+ [`volume_iops`](#raid-volume-iops)
+ [`encrypted`](#raid-encrypted)
+ [`ebs_kms_key_id`](#raid-ebs_kms_key_id)

Defines configuration settings for a RAID array that is built from a number of identical Amazon EBS volumes\. The RAID drive is mounted on the head node and is exported to compute nodes via NFS\.

The format is `[raid raid-name]`\. *raid\-name* must start with a letter, contain no more than 30 characters, and only contain letters, numbers, hyphens \(\-\), and underscores \(\_\)\.

```
[raid rs]
shared_dir = raid
raid_type = 1
num_of_raid_volumes = 2
encrypted = true
```

## `shared_dir`<a name="raid-shared-dir"></a>

Defines the mount point for the RAID array on the head and compute nodes\.

The RAID drive is created only if this parameter is specified\.

Do not use `NONE` or `/NONE` as the shared directory\.

The following example mounts the array at `/raid`\.

```
shared_dir = raid
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)

## `raid_type`<a name="raid-type"></a>

Defines the RAID type for the RAID array\.

The RAID drive is created only if this parameter is specified\.

Valid options are:
+ `0`
+ `1`

For more information on RAID types, see [RAID info](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/raid-config.html) in the *Amazon EC2 User Guide for Linux Instances*\.

The following example creates a RAID `0` array:

```
raid_type = 0
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)

## `num_of_raid_volumes`<a name="num-of-raid-volumes"></a>

Defines the number of Amazon EBS volumes to assemble the RAID array from\.

Minimum number of volumes = `2`\.

Maximum number of volumes = `5`\.

The default value is `2`\.

```
num_of_raid_volumes = 2
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)

## `volume_type`<a name="raid-volume-type"></a>

Defines the type of volume to build\.

Valid options are:
+ `gp2`
+ `io1`
+ `st1`
+ `sc1`

For more information, see [Amazon EBS volume types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html) in the *Amazon EC2 User Guide for Linux Instances*\.

The default value is `gp2`\.

```
volume_type = io1
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)

## `volume_size`<a name="raid-volume-size"></a>

Defines the size of the volume to be created, in GiB\.

The default value is `20`\.

```
volume_size = 20
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)

## `volume_iops`<a name="raid-volume-iops"></a>

Defines the number of IOPS for `io1` type volumes\.

The default value is `100`\.

```
volume_iops = 500
```

[Update policy: This setting can be changed during an update.](using-pcluster-update.md#update-policy-setting-supported)

## `encrypted`<a name="raid-encrypted"></a>

Specifies whether the file system is encrypted\.

The default value is `false`\.

```
encrypted = false
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)

## `ebs_kms_key_id`<a name="raid-ebs_kms_key_id"></a>

Specifies a custom AWS KMS key to use for encryption\.

This parameter must be used together with `encrypted = true`, and it must have a custom [`ec2_iam_role`](cluster-definition.md#ec2-iam-role)\.

For more information, see [Disk encryption with a custom KMS Key](tutorials_04_encrypted_kms_fs.md)\.

```
ebs_kms_key_id = xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
```

[Update policy: If this setting is changed, the update is not allowed.](using-pcluster-update.md#update-policy-fail)
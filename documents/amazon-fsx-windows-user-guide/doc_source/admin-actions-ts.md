# Troubleshooting Failed Storage and Throughput Updates<a name="admin-actions-ts"></a>

Administrative actions include increasing a file system's storage capacity and modifying a file system's throughput capacity\. There are a number of potential causes for administrative actions to fail on your file system, each with their own resolution, as follows\.

**Potential Cause**  
A storage increase request failed because Amazon FSx was unable to access the file system's AWS Key Management Service \(AWS KMS\) encryption key\.

**Resolution**  
You need to ensure that Amazon FSx has access to the AWS KMS key in order to run the administrative action\. Use the following information to resolve the key access issue\. 
+ If the KMS key has been deleted, you must create a new file system from a backup using a new KMS key\. For more information, see [Walkthrough 2: Create a File System from a Backup](walkthrough02-create-from-backup.md)\. You can retry the request after the new file system is available\.
+ If the KMS key is disabled, re\-enable it, and then retry the storage capacity increase request\. For more information, see [Enabling and disabling keys](https://docs.aws.amazon.com/kms/latest/developerguide/enabling-keys.html) in the *AWS Key Management Service Developer Guide*\.
+ If the key is invalid because of its pending deletion, you must create a new file system from a backup using a new KMS key\. You can retry the request after the new file system is available\. For more information, see [Walkthrough 2: Create a File System from a Backup](walkthrough02-create-from-backup.md)\.
+ If the key is invalid because of its pending import, you must wait until the import has completed, and then retry the storage increase request\.
+ If the key's grant limit has been exceeded, you must request an increase in the number of grants for the key\. For more information, see [Resource quotas](https://docs.aws.amazon.com/kms/latest/developerguide/resource-limits.html) in the *AWS Key Management Service Developer Guide*\. When the quota increase is granted, retry the storage increase request\.

**Potential Cause**  
The storage capacity or throughput capacity update request failed because your file system's self\-managed Active Directory is in a misconfigured state\.

**Resolution**  
To resolve the specific misconfigured state, see [File System Is In a Misconfigured State](misconfigured-ad-config.md)\.

**Potential Cause**  
The storage capacity increase request failed because the file system's throughput capacity is set to 8 MB/s\.

**Resolution**  
Increase the file system's throughput capacity to a minimum of 16 MB/s, then retry the request\. For more information, see [Managing Throughput Capacity](managing-throughput-capacity.md)\.

**Potential Cause**  
A request to modify a file system's throughput capacity to 8 MB/s failed because a storage capacity increase request is pending or in progress\.

**Resolution**  
Wait until the storage capacity increase request has completed, and then retry the throughput capacity modification request\.
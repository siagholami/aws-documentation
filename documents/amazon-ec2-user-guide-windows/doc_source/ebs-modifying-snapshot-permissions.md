# Sharing an Amazon EBS snapshot<a name="ebs-modifying-snapshot-permissions"></a>

By modifying the permissions of a snapshot, you can share it with the AWS accounts that you specify\. Users that you have authorized can use the snapshots you share as the basis for creating their own EBS volumes, while your original snapshot remains unaffected\.

If you choose, you can make your unencrypted snapshots available publicly to all AWS users\. You can't make your encrypted snapshots available publicly\. 

When you share an encrypted snapshot, you must also share the customer managed CMK used to encrypt the snapshot\. You can apply cross\-account permissions to a customer managed CMK either when it is created or at a later time\.

**Important**  
When you share a snapshot, you are giving others access to all of the data on the snapshot\. Share snapshots only with people with whom you want to share *all* of your snapshot data\.

## Considerations<a name="share-snapshot-considerations"></a>

The following considerations apply to sharing snapshots:
+ Snapshots are constrained to the Region in which they were created\. To share a snapshot with another Region, copy the snapshot to that Region\. For more information, see [Copying an Amazon EBS snapshot](ebs-copy-snapshot.md)\.
+ If your snapshot uses the longer resource ID format, you can only share it with another account that also supports longer IDs\. For more information, see [Resource IDs](resource-ids.md)\.
+ AWS prevents you from sharing snapshots that were encrypted with your default CMK\. Snapshots that you intend to share must instead be encrypted with a customer managed CMK\. For more information, see [Creating Keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html) in the *AWS Key Management Service Developer Guide*\.
+ Users of your shared CMK who are accessing encrypted snapshots must be granted permissions to perform the following actions on the key: `kms:DescribeKey`, `kms:CreateGrant`, `GenerateDataKey`, and `kms:ReEncrypt`\. For more information, see [Controlling Access to Customer Master Keys](https://docs.aws.amazon.com/kms/latest/developerguide/control-access.html) in the *AWS Key Management Service Developer Guide*\.

## Sharing an unencrypted snapshot using the console<a name="share-unencrypted-snapshot"></a>

**To share a snapshot using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Snapshots** in the navigation pane\.

1. Select the snapshot and then choose **Actions**, **Modify Permissions**\.

1. Make the snapshot public or share it with specific AWS accounts as follows:
   + To make the snapshot public, choose **Public**\.

     This option is not valid for encrypted snapshots or snapshots with an AWS Marketplace product code\.
   + To share the snapshot with one or more AWS accounts, choose **Private**, enter the AWS account ID \(without hyphens\) in **AWS Account Number**, and choose **Add Permission**\. Repeat for any additional AWS accounts\.

1. Choose **Save**\.

**To use an unencrypted snapshot that was privately shared with you**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Snapshots** in the navigation pane\.

1. Choose the **Private Snapshots** filter\.

1. Locate the snapshot by ID or description\. You can use this snapshot as you would any other; for example, you can create a volume from the snapshot or copy the snapshot to a different Region\.

## Sharing an encrypted snapshot using the console<a name="share-encrypted-snapshot"></a>

**To share an encrypted snapshot using the console**

1. Open the AWS KMS console at [https://console\.aws\.amazon\.com/kms](https://console.aws.amazon.com/kms)\.

1. To change the AWS Region, use the Region selector in the upper\-right corner of the page\.

1. Choose **Customer managed keys** in the navigation pane\.

1. In the **Alias** column, choose the alias \(text link\) of the customer managed key that you used to encrypt the snapshot\. The key details open in a new page\.

1. In the **Key policy** section, you see either the *policy view* or the *default view*\. The policy view displays the key policy document\. The default view displays sections for **Key administrators**, **Key deletion**, **Key Use**, and **Other AWS accounts**\. The default view displays if you created the policy in the console and have not customized it\. If the default view is not available, you'll need to manually edit the policy in the policy view\. For more information, see [Viewing a Key Policy \(Console\)](https://docs.aws.amazon.com/kms/latest/developerguide/key-policy-viewing.html#key-policy-viewing-console) in the *AWS Key Management Service Developer Guide*\.

   Use either the policy view or the default view, depending on which view you can access, to add one or more AWS account IDs to the policy, as follows:
   + \(Policy view\) Choose **Edit**\. Add one or more AWS account IDs to the following statements: `"Allow use of the key"` and `"Allow attachment of persistent resources"`\. Choose **Save changes**\. In the following example, the AWS account ID `444455556666` is added to the policy\.

     ```
     {
       "Sid": "Allow use of the key",
       "Effect": "Allow",
       "Principal": {"AWS": [
         "arn:aws:iam::111122223333:user/CMKUser",
         "arn:aws:iam::444455556666:root"
       ]},
       "Action": [
         "kms:Encrypt",
         "kms:Decrypt",
         "kms:ReEncrypt*",
         "kms:GenerateDataKey*",
         "kms:DescribeKey"
       ],
       "Resource": "*"
     },
     {
       "Sid": "Allow attachment of persistent resources",
       "Effect": "Allow",
       "Principal": {"AWS": [
         "arn:aws:iam::111122223333:user/CMKUser",
         "arn:aws:iam::444455556666:root"
       ]},
       "Action": [
         "kms:CreateGrant",
         "kms:ListGrants",
         "kms:RevokeGrant"
       ],
       "Resource": "*",
       "Condition": {"Bool": {"kms:GrantIsForAWSResource": true}}
     }
     ```
   + \(Default view\) Scroll down to **Other AWS accounts**\. Choose **Add other AWS accounts** and enter the AWS account ID as prompted\. To add another account, choose **Add another AWS account** and enter the AWS account ID\. When you have added all AWS accounts, choose **Save changes**\.

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Snapshots** in the navigation pane\.

1. Select the snapshot and then choose **Actions**, **Modify Permissions**\.

1. For each AWS account, enter the AWS account ID in **AWS Account Number** and choose **Add Permission**\. When you have added all AWS accounts, choose **Save**\.

**To use an encrypted snapshot that was shared with you**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. Choose **Snapshots** in the navigation pane\.

1. Choose the **Private Snapshots** filter\. Optionally add the **Encrypted** filter\.

1. Locate the snapshot by ID or description\.

1. Select the snapshot and choose **Actions**, **Copy**\.

1. \(Optional\) Select a destination Region\.

1. The copy of the snapshot is encrypted by the key displayed in **Master Key**\. By default, the selected key is your account's default CMK\. To select a customer managed CMK, click inside the input box to see a list of available keys\.

1. Choose **Copy**\.

## Sharing a snapshot using the command line<a name="share-snapshot-cli"></a>

The permissions for a snapshot are specified using the `createVolumePermission` attribute of the snapshot\. To make a snapshot public, set the group to `all`\. To share a snapshot with a specific AWS account, set the user to the ID of the AWS account\.

**To modify snapshot permissions using the command line**

Use one of the following commands:
+ [modify\-snapshot\-attribute](https://docs.aws.amazon.com/cli/latest/reference/ec2/modify-snapshot-attribute.html) \(AWS CLI\)
+ [Edit\-EC2SnapshotAttribute](https://docs.aws.amazon.com/powershell/latest/reference/items/Edit-EC2SnapshotAttribute.html) \(AWS Tools for Windows PowerShell\)

**To view snapshot permissions using the command line**

Use one of the following commands:
+ [describe\-snapshot\-attribute](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-snapshot-attribute.html) \(AWS CLI\)
+ [Get\-EC2SnapshotAttribute](https://docs.aws.amazon.com/powershell/latest/reference/items/Get-EC2SnapshotAttribute.html) \(AWS Tools for Windows PowerShell\)

For more information about these command line interfaces, see [Accessing Amazon EC2](concepts.md#access-ec2)\.

## Determining the use of shared snapshots<a name="shared-snapshot-cloudtrail-logging"></a>

You can use AWS CloudTrail to monitor whether a snapshot that you have shared with others is copied or used to create a volume\. The following events are logged in CloudTrail:
+ **SharedSnapshotCopyInitiated** — A shared snapshot is being copied\.
+ **SharedSnapshotVolumeCreated** — A shared snapshot is being used to create a volume\.

For more information about using CloudTrail, see [Logging Amazon EC2 and Amazon EBS API calls with AWS CloudTrail](monitor-with-cloudtrail.md)\.
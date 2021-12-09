# Amazon FSx for Lustre API Permissions: Actions, Resources, and Conditions Reference<a name="fsx-api-permissions-ref"></a>

When you are setting up access control and writing a permissions policy that you can attach to an IAM identity \(identity\-based policies\), you can use the following table as a reference\. The table includes each Amazon FSx for Lustre API operation, the corresponding actions for which you can grant permissions to perform the action, and the AWS resource for which you can grant the permissions\. You specify the actions in the policy's `Action` field, and you specify the resource value in the policy's `Resource` field\. 

You can use AWS\-wide condition keys in your Amazon FSx for Lustre policies to express conditions\. For a complete list of AWS\-wide keys, see [Available Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\. 

To specify an action, use the `fsx:` prefix followed by the API operation name \(for example, `fsx:CreateFileSystem`\)\. Each action applies to either a single Amazon FSx for Lustre file system, to all Amazon FSx for Lustre file systems owned by an AWS account\.


**Amazon FSx for Lustre API and Required Permissions for Actions**  

| Amazon FSx for Lustre API Operations | Required Permissions \(API Actions\) | Resource | 
| --- | --- | --- | 
|   [CreateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_CreateFileSystem.html)   |  `fsx:*`  |  `arn:aws:fsx:region:account-id:file-system/*`  | 
| [DeleteFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DeleteFileSystem.html) | fsx:DeleteFileSystem |  `arn:aws:fsx:region:account-id:file-system/*` `arn:aws:fsx:region:account-id:file-system/filesystem-id`  | 
|  [DescribeFileSystems](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html) | fsx:DescribeFileSystems | N/A | 
| [UpdateFileSystem](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UpdateFileSystem.html) |  `fsx:UpdateFileSystem`  |  `arn:aws:fsx:region:account-id:file-system/*` `arn:aws:fsx:region:account-id:file-system/filesystem-id`  | 
| [ListTagsForResource](https://docs.aws.amazon.com/fsx/latest/APIReference/API_ListTagsForResource.html) | fsx:ListTagsForResource |  `arn:aws:fsx:region:account-id:file-system/*` `arn:aws:fsx:region:account-id:file-system/filesystem-id`  | 
| [TagResource](https://docs.aws.amazon.com/fsx/latest/APIReference/API_TagResource.html) | fsx:TagResource |  `arn:aws:fsx:region:account-id:file-system/*` `arn:aws:fsx:region:account-id:file-system/filesystem-id`  | 
| [UntagResource](https://docs.aws.amazon.com/fsx/latest/APIReference/API_UntagResource.html) |  `fsx:UntagResource`  |  `arn:aws:fsx:region:account-id:file-system/*` `arn:aws:fsx:region:account-id:file-system/filesystem-id`  | 
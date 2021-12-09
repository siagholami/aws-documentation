# AWS Migration Hub API Permissions: Actions and Resources Reference<a name="migrationhub-api-permissions-ref"></a>

When you are setting up [Access Control](auth-and-access-control.md#access-control) and writing a permissions policy that you can attach to an IAM identity \(identity\-based policies\), you can use the following table as a reference\. The table lists each Migration Hub API operation, the corresponding actions for which you can grant permissions to perform the action, and the AWS resource for which you can grant the permissions\. You specify the actions in the policy's `Action` field, and you specify the resource value in the policy's `Resource` field\. 

**Note**  
To specify an action, use the `mgh:` prefix followed by the API operation name \(for example, `mgh:CreateProgressUpdateStream`\)\.

Use the scroll bars to see the rest of the table\.


**AWS Migration Hub API and Required Permissions for Actions**  

| Migration Hub API Operations | Required Permissions \(API Actions\) | Resources | 
| --- | --- | --- | 
|  [AssociateCreatedArtifact](http://docs.aws.amazon.com/migrationhub/latest/ug/API_AssociateCreatedArtifact.html)  | mgh:AssociateCreatedArtifact |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
|  [AssociateDiscoveredResource](http://docs.aws.amazon.com/migrationhub/latest/ug/API_AssociateDiscoveredResource.html)  |  mgh:AssociateDiscoveredResource  |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
|  [CreateProgressUpdateStream](http://docs.aws.amazon.com/migrationhub/latest/ug/API_CreateProgressUpdateStream.html)  | mgh:CreateProgressUpdateStream |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id  | 
| [DeleteProgressUpdateStream](http://docs.aws.amazon.com/migrationhub/latest/ug/API_DeleteProgressUpdateStream.html) | mgh:DeleteProgressUpdateStream |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id  | 
| [DescribeApplicationState](http://docs.aws.amazon.com/migrationhub/latest/ug/API_DescribeApplicationState.html)  |  mgh:DescribeApplicationState  |  \*  | 
| [DescribeMigrationTask](http://docs.aws.amazon.com/migrationhub/latest/ug/API_DescribeMigrationTask.html) | mgh:DescribeMigrationTask |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
|  [DisassociateCreatedArtifact](http://docs.aws.amazon.com/migrationhub/latest/ug/API_DisassociateCreatedArtifact.html)  | mgh:DisassociateCreatedArtifact |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
| [DisassociateDiscoveredResource](http://docs.aws.amazon.com/migrationhub/latest/ug/API_DisassociateDiscoveredResource.html) | mgh:DisassociateDiscoveredResource |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
| [ImportMigrationTask](http://docs.aws.amazon.com/migrationhub/latest/ug/API_ImportMigrationTask.html) | mgh:ImportMigrationTask |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
| [ListCreatedArtifacts](http://docs.aws.amazon.com/migrationhub/latest/ug/API_ListCreatedArtifacts.html) | mgh:ListCreatedArtifacts |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
|  [ListDiscoveredResources](http://docs.aws.amazon.com/migrationhub/latest/ug/API_ListDiscoveredResources.html)  | mgh:ListDiscoveredResources |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
|  [ListMigrationTasks](http://docs.aws.amazon.com/migrationhub/latest/ug/API_ListMigrationTasks.html)  | mgh:ListMigrationTasks |  \*  | 
|  [ListProgressUpdateStreams](http://docs.aws.amazon.com/migrationhub/latest/ug/API_ListProgressUpdateStreams.html)  | mgh:ListProgressUpdateStreams |  \*  | 
| [NotifyApplicationState](http://docs.aws.amazon.com/migrationhub/latest/ug/API_NotifyApplicationState.html) | mgh:NotifyApplicationState |  \*  | 
| [NotifyMigrationTaskState](http://docs.aws.amazon.com/migrationhub/latest/ug/API_NotifyMigrationTaskState.html) | mgh:NotifyMigrationTaskState |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 
| [PutResourceAttributes](http://docs.aws.amazon.com/migrationhub/latest/ug/API_PutResourceAttributes.html) | mgh:PutResourceAttributes |  arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id or arn:aws:mgh:region:account\-id:ProgressUpdateStreamName/resource\-id/\*  | 


**AWS Migration Hub Home Region API and Required Permissions for Actions**  

| Migration Hub API Operations | Required Permissions \(API Actions\) | Resources | 
| --- | --- | --- | 
|  [CreateHomeRegionControl](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/API_CreateHomeRegionControl.html)  | mgh:CreateHomeRegionControl |  \*  | 
|  [DescribeHomeRegionControls](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/API_DescribeHomeRegionControls.html)  | mgh:DescribeHomeRegionControls |  \*  | 
|  [GetHomeRegion](https://docs.aws.amazon.com/migrationhub-home-region/latest/APIReference/API_GetHomeRegion.html)  | mgh:GetHomeRegion |  \*  | 

## Related Topics<a name="w33aac23c17c21c29"></a>
+ [Access Control](auth-and-access-control.md#access-control)
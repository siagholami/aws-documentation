# Clean Up Resources<a name="gs-cleanup"></a>

To avoid incurring unnecessary charges, delete the resources you created after you're done with the getting started exercise\. To delete the resources, use either the Amazon Personalize console or the `Delete` APIs from the SDKs or the AWS Command Line Interface \(AWS CLI\)\. For example, use the [DeleteCampaign](API_DeleteCampaign.md) API to delete a campaign\.

You can't delete a resource whose status is CREATE PENDING or IN PROGRESS\. The resource status must be ACTIVE or CREATE FAILED\. Check the status using the `Describe` APIs, for example, [DescribeCampaign](API_DescribeCampaign.md)\.

Some resources must be deleted before others, as shown in the following table\. This process can take some time\.

To delete the training data you uploaded, `ratings.csv`, see [How Do I Delete Objects from an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/delete-objects.html)\.


| Resource to be Deleted | Delete This First | Notes | 
| --- | --- | --- | 
| [Campaign](API_Campaign.md) |  |  | 
| [DatasetImportJob](API_DatasetImportJob.md) |  | Can not be deleted\. | 
| [EventTracker](API_EventTracker.md) |  | The event\-interactions dataset that is associated with the event tracker is not deleted and continues to be used by the solution version\. | 
| [Dataset](API_Dataset.md) |  |  No associated `DatasetImportJob` can have a status of CREATE PENDING or IN PROGRESS\. No associated `SolutionVersion` can have a status of CREATE PENDING or IN PROGRESS\.  | 
| [DatasetSchema](API_DatasetSchema.md) | All datasets that reference the schema\. |  | 
| [Solution](API_Solution.md) | All campaigns based on the solution version\. | No associated SolutionVersion can have a status of CREATE PENDING or IN PROGRESS\. | 
| [SolutionVersion](API_SolutionVersion.md) |  | Deleted when the associated Solution is deleted\. | 
| [DatasetGroup](API_DatasetGroup.md) |  All associated event trackers\. All associated solutions\. All datasets in the dataset group\.  |  | 
# Working with Harvest Jobs<a name="harvest-jobs"></a>

A harvest job represents a request to extract a live\-to\-VOD \(video on demand\) asset from an endpoint for a specific timeframe in the past\. AWS Elemental MediaPackage uses information from the harvest job to determine the start and end times of the asset, and where to store it after the harvest job is complete\.

A harvest job runs only once after it's been created\. MediaPackage keeps a record of the job on your account for reference only\. You can't modify or delete a record once you've created the harvest job\. 

**Topics**
+ [Creating a Harvest Job](hj-create.md)
+ [Viewing Harvest Job Details](hj-view.md)
+ [Editing a Harvest Job](hj-edit.md)
+ [Deleting a Harvest Job](hj-delete.md)
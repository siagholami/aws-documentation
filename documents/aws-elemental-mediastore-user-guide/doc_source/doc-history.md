# Document history for user guide<a name="doc-history"></a>

The following table describes the documentation for this release of AWS Elemental MediaStore\. For notification about updates to this documentation, you can subscribe to an RSS feed\.

| Change | Description | Date | 
| --- |--- |--- |
| [Lifecycle transition rules](policies-object-lifecycle-components.md) | You can now add a lifecycle transition rule to your object lifecycle policy that sets objects to be moved to the infrequent access \(IA\) storage class after they reach a certain age\. | April 20, 2020 | 
| [Empty container](objects-empty-container.md) | You can now delete all objects within a container at once\. | April 7, 2020 | 
| [Support for Amazon CloudWatch metrics](policies-metric.md) | You can set a metric policy to dictate which metrics MediaStore sends to CloudWatch\. | March 30, 2020 | 
| [Wildcards in delete object rules](policies-object-lifecycle-components.md#policies-object-lifecycle-components-rules) | In an object lifecycle policy, you can now use a wildcard in a delete object rule\. This allows you to specify files based on their filename or extension that you want the service to delete after a certain number of days\. | December 20, 2019 | 
| [Object lifecycle policies](policies-object-lifecycle-components.md) | You can now add a rule to your object lifecycle policy that indicates an expiration by age in seconds\. | September 13, 2019 | 
| [AWS CloudFormation support](containers-create.md) | You can now use an AWS CloudFormation template to create a container automatically\. The AWS CloudFormation template manages data for five API actions: creating a container, setting access logging, updating the default container policy, adding a cross\-origin resource sharing \(CORS\) policy, and adding an object lifecycle policy\. | May 17, 2019 | 
| [Quotas for streaming upload availability](quotas.md) | For objects with streaming upload availability \(chunked transfer of objects\), the `PutObject` operation can't exceed 10 TPS and the `GetObject` operation can't exceed 25 TPS\. | April 8, 2019 | 
| [Chunked transfer of objects](objects-upload.md) | Added support for chunked transfer of objects\. This capability allows you to specify that an object is available for downloading before the object is uploaded completely\. | April 5, 2019 | 
| [Access logging](monitoring-cloudwatch-logs.md) | AWS Elemental MediaStore now supports access logging, which provides detailed records for the requests that are made to objects in a container\. | February 25, 2019 | 
| [Object lifecycle policies](policies-object-lifecycle.md) | Added support for object lifecycle policies, which govern the expiration date of objects within the current container\. | December 12, 2018 | 
| [Increased object size quota](quotas.md) | The quota for an object's size is now 25 MB\. | October 10, 2018 | 
| [Increased object size quota](quotas.md) | The quota for an object's size is now 20 MB\. | September 6, 2018 | 
| [AWS CloudTrail integration](logging-using-cloudtrail.md) | The CloudTrail integration content has been updated to align with recent changes to the CloudTrail service\. | July 12, 2018 | 
| [CDN collaboration](cdns.md) | Added information about how to use AWS Elemental MediaStore with a content delivery network \(CDN\) such as Amazon CloudFront\. | April 14, 2018 | 
| [CORS configurations](cors-policy.md) | AWS Elemental MediaStore now supports cross\-origin resource sharing \(CORS\), which allows client web applications that are loaded in one domain to interact with resources in a different domain\. | February 7, 2018 | 
| [New service and guide](what-is.md) | This is the initial release of the video origination and storage service, AWS Elemental MediaStore, and the *AWS Elemental MediaStore User Guide*\. | November 27, 2017 | 

**Note**  
The AWS Media Services are not designed or intended for use with applications or in situations requiring fail‐safe performance, such as life safety operations, navigation or communication systems, air traffic control, or life support machines in which the unavailability, interruption or failure of the services could lead to death, personal injury, property damage or environmental damage\.
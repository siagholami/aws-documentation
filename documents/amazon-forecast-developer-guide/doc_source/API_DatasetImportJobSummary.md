# DatasetImportJobSummary<a name="API_DatasetImportJobSummary"></a>

Provides a summary of the dataset import job properties used in the [ListDatasetImportJobs](API_ListDatasetImportJobs.md) operation\. To get the complete set of properties, call the [DescribeDatasetImportJob](API_DescribeDatasetImportJob.md) operation, and provide the `DatasetImportJobArn`\.

## Contents<a name="API_DatasetImportJobSummary_Contents"></a>

 **CreationTime**   <a name="forecast-Type-DatasetImportJobSummary-CreationTime"></a>
When the dataset import job was created\.  
Type: Timestamp  
Required: No

 **DatasetImportJobArn**   <a name="forecast-Type-DatasetImportJobSummary-DatasetImportJobArn"></a>
The Amazon Resource Name \(ARN\) of the dataset import job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **DatasetImportJobName**   <a name="forecast-Type-DatasetImportJobSummary-DatasetImportJobName"></a>
The name of the dataset import job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **DataSource**   <a name="forecast-Type-DatasetImportJobSummary-DataSource"></a>
The location of the training data to import and an AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the data\. The training data must be stored in an Amazon S3 bucket\.  
If encryption is used, `DataSource` includes an AWS Key Management Service \(KMS\) key\.  
Type: [DataSource](API_DataSource.md) object  
Required: No

 **LastModificationTime**   <a name="forecast-Type-DatasetImportJobSummary-LastModificationTime"></a>
The last time that the dataset was modified\. The time depends on the status of the job, as follows:  
+  `CREATE_PENDING` \- The same time as `CreationTime`\.
+  `CREATE_IN_PROGRESS` \- The current timestamp\.
+  `ACTIVE` or `CREATE_FAILED` \- When the job finished or failed\.
Type: Timestamp  
Required: No

 **Message**   <a name="forecast-Type-DatasetImportJobSummary-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String  
Required: No

 **Status**   <a name="forecast-Type-DatasetImportJobSummary-Status"></a>
The status of the dataset import job\. The status is reflected in the status of the dataset\. For example, when the import job status is `CREATE_IN_PROGRESS`, the status of the dataset is `UPDATE_IN_PROGRESS`\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DatasetImportJobSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DatasetImportJobSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DatasetImportJobSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DatasetImportJobSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DatasetImportJobSummary) 
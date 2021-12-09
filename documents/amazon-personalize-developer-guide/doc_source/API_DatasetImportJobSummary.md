# DatasetImportJobSummary<a name="API_DatasetImportJobSummary"></a>

Provides a summary of the properties of a dataset import job\. For a complete listing, call the [DescribeDatasetImportJob](API_DescribeDatasetImportJob.md) API\.

## Contents<a name="API_DatasetImportJobSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-DatasetImportJobSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the dataset import job was created\.  
Type: Timestamp  
Required: No

 **datasetImportJobArn**   <a name="personalize-Type-DatasetImportJobSummary-datasetImportJobArn"></a>
The Amazon Resource Name \(ARN\) of the dataset import job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **failureReason**   <a name="personalize-Type-DatasetImportJobSummary-failureReason"></a>
If a dataset import job fails, the reason behind the failure\.  
Type: String  
Required: No

 **jobName**   <a name="personalize-Type-DatasetImportJobSummary-jobName"></a>
The name of the dataset import job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-DatasetImportJobSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the dataset was last updated\.  
Type: Timestamp  
Required: No

 **status**   <a name="personalize-Type-DatasetImportJobSummary-status"></a>
The status of the dataset import job\.  
A dataset import job can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DatasetImportJobSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DatasetImportJobSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DatasetImportJobSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DatasetImportJobSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DatasetImportJobSummary) 
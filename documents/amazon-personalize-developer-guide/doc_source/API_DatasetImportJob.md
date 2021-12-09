# DatasetImportJob<a name="API_DatasetImportJob"></a>

Describes a job that imports training data from a data source \(Amazon S3 bucket\) to an Amazon Personalize dataset\. For more information, see [CreateDatasetImportJob](API_CreateDatasetImportJob.md)\.

A dataset import job can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED

## Contents<a name="API_DatasetImportJob_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-DatasetImportJob-creationDateTime"></a>
The creation date and time \(in Unix time\) of the dataset import job\.  
Type: Timestamp  
Required: No

 **datasetArn**   <a name="personalize-Type-DatasetImportJob-datasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset that receives the imported data\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **datasetImportJobArn**   <a name="personalize-Type-DatasetImportJob-datasetImportJobArn"></a>
The ARN of the dataset import job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **dataSource**   <a name="personalize-Type-DatasetImportJob-dataSource"></a>
The Amazon S3 bucket that contains the training data to import\.  
Type: [DataSource](API_DataSource.md) object  
Required: No

 **failureReason**   <a name="personalize-Type-DatasetImportJob-failureReason"></a>
If a dataset import job fails, provides the reason why\.  
Type: String  
Required: No

 **jobName**   <a name="personalize-Type-DatasetImportJob-jobName"></a>
The name of the import job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-DatasetImportJob-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) the dataset was last updated\.  
Type: Timestamp  
Required: No

 **roleArn**   <a name="personalize-Type-DatasetImportJob-roleArn"></a>
The ARN of the AWS Identity and Access Management \(IAM\) role that has permissions to read from the Amazon S3 data source\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-DatasetImportJob-status"></a>
The status of the dataset import job\.  
A dataset import job can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DatasetImportJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DatasetImportJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DatasetImportJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DatasetImportJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DatasetImportJob) 
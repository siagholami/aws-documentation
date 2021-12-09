# DatasetSummary<a name="API_DatasetSummary"></a>

Provides a summary of the properties of a dataset\. For a complete listing, call the [DescribeDataset](API_DescribeDataset.md) API\.

## Contents<a name="API_DatasetSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-DatasetSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the dataset was created\.  
Type: Timestamp  
Required: No

 **datasetArn**   <a name="personalize-Type-DatasetSummary-datasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **datasetType**   <a name="personalize-Type-DatasetSummary-datasetType"></a>
The dataset type\. One of the following values:  
+ Interactions
+ Items
+ Users
+ Event\-Interactions
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-DatasetSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the dataset was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-DatasetSummary-name"></a>
The name of the dataset\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-DatasetSummary-status"></a>
The status of the dataset\.  
A dataset can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DatasetSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DatasetSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DatasetSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DatasetSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DatasetSummary) 
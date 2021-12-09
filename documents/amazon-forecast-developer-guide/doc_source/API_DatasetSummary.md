# DatasetSummary<a name="API_DatasetSummary"></a>

Provides a summary of the dataset properties used in the [ListDatasets](API_ListDatasets.md) operation\. To get the complete set of properties, call the [DescribeDataset](API_DescribeDataset.md) operation, and provide the `DatasetArn`\.

## Contents<a name="API_DatasetSummary_Contents"></a>

 **CreationTime**   <a name="forecast-Type-DatasetSummary-CreationTime"></a>
When the dataset was created\.  
Type: Timestamp  
Required: No

 **DatasetArn**   <a name="forecast-Type-DatasetSummary-DatasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **DatasetName**   <a name="forecast-Type-DatasetSummary-DatasetName"></a>
The name of the dataset\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **DatasetType**   <a name="forecast-Type-DatasetSummary-DatasetType"></a>
The dataset type\.  
Type: String  
Valid Values:` TARGET_TIME_SERIES | RELATED_TIME_SERIES | ITEM_METADATA`   
Required: No

 **Domain**   <a name="forecast-Type-DatasetSummary-Domain"></a>
The domain associated with the dataset\.  
Type: String  
Valid Values:` RETAIL | CUSTOM | INVENTORY_PLANNING | EC2_CAPACITY | WORK_FORCE | WEB_TRAFFIC | METRICS`   
Required: No

 **LastModificationTime**   <a name="forecast-Type-DatasetSummary-LastModificationTime"></a>
When you create a dataset, `LastModificationTime` is the same as `CreationTime`\. While data is being imported to the dataset, `LastModificationTime` is the current time of the `ListDatasets` call\. After a [CreateDatasetImportJob](API_CreateDatasetImportJob.md) operation has finished, `LastModificationTime` is when the import job completed or failed\.  
Type: Timestamp  
Required: No

## See Also<a name="API_DatasetSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DatasetSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DatasetSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DatasetSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DatasetSummary) 
# DatasetGroupSummary<a name="API_DatasetGroupSummary"></a>

Provides a summary of the dataset group properties used in the [ListDatasetGroups](API_ListDatasetGroups.md) operation\. To get the complete set of properties, call the [DescribeDatasetGroup](API_DescribeDatasetGroup.md) operation, and provide the `DatasetGroupArn`\.

## Contents<a name="API_DatasetGroupSummary_Contents"></a>

 **CreationTime**   <a name="forecast-Type-DatasetGroupSummary-CreationTime"></a>
When the dataset group was created\.  
Type: Timestamp  
Required: No

 **DatasetGroupArn**   <a name="forecast-Type-DatasetGroupSummary-DatasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 **DatasetGroupName**   <a name="forecast-Type-DatasetGroupSummary-DatasetGroupName"></a>
The name of the dataset group\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **LastModificationTime**   <a name="forecast-Type-DatasetGroupSummary-LastModificationTime"></a>
When the dataset group was created or last updated from a call to the [UpdateDatasetGroup](API_UpdateDatasetGroup.md) operation\. While the dataset group is being updated, `LastModificationTime` is the current time of the `ListDatasetGroups` call\.  
Type: Timestamp  
Required: No

## See Also<a name="API_DatasetGroupSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DatasetGroupSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DatasetGroupSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DatasetGroupSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DatasetGroupSummary) 
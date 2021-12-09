# DatasetGroupSummary<a name="API_DatasetGroupSummary"></a>

Provides a summary of the properties of a dataset group\. For a complete listing, call the [DescribeDatasetGroup](API_DescribeDatasetGroup.md) API\.

## Contents<a name="API_DatasetGroupSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-DatasetGroupSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the dataset group was created\.  
Type: Timestamp  
Required: No

 **datasetGroupArn**   <a name="personalize-Type-DatasetGroupSummary-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **failureReason**   <a name="personalize-Type-DatasetGroupSummary-failureReason"></a>
If creating a dataset group fails, the reason behind the failure\.  
Type: String  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-DatasetGroupSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the dataset group was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-DatasetGroupSummary-name"></a>
The name of the dataset group\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-DatasetGroupSummary-status"></a>
The status of the dataset group\.  
A dataset group can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DatasetGroupSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DatasetGroupSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DatasetGroupSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DatasetGroupSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DatasetGroupSummary) 
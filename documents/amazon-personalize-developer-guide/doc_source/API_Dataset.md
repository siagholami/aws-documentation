# Dataset<a name="API_Dataset"></a>

Provides metadata for a dataset\.

## Contents<a name="API_Dataset_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-Dataset-creationDateTime"></a>
The creation date and time \(in Unix time\) of the dataset\.  
Type: Timestamp  
Required: No

 **datasetArn**   <a name="personalize-Type-Dataset-datasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset that you want metadata for\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **datasetGroupArn**   <a name="personalize-Type-Dataset-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **datasetType**   <a name="personalize-Type-Dataset-datasetType"></a>
One of the following values:  
+ Interactions
+ Items
+ Users
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-Dataset-lastUpdatedDateTime"></a>
A time stamp that shows when the dataset was updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-Dataset-name"></a>
The name of the dataset\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **schemaArn**   <a name="personalize-Type-Dataset-schemaArn"></a>
The ARN of the associated schema\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-Dataset-status"></a>
The status of the dataset\.  
A dataset can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_Dataset_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/Dataset) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/Dataset) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/Dataset) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/Dataset) 
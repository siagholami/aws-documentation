# DatasetGroup<a name="API_DatasetGroup"></a>

A dataset group is a collection of related datasets \(Interactions, User, and Item\)\. You create a dataset group by calling [CreateDatasetGroup](API_CreateDatasetGroup.md)\. You then create a dataset and add it to a dataset group by calling [CreateDataset](API_CreateDataset.md)\. The dataset group is used to create and train a solution by calling [CreateSolution](API_CreateSolution.md)\. A dataset group can contain only one of each type of dataset\.

You can specify an AWS Key Management Service \(KMS\) key to encrypt the datasets in the group\.

## Contents<a name="API_DatasetGroup_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-DatasetGroup-creationDateTime"></a>
The creation date and time \(in Unix time\) of the dataset group\.  
Type: Timestamp  
Required: No

 **datasetGroupArn**   <a name="personalize-Type-DatasetGroup-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **failureReason**   <a name="personalize-Type-DatasetGroup-failureReason"></a>
If creating a dataset group fails, provides the reason why\.  
Type: String  
Required: No

 **kmsKeyArn**   <a name="personalize-Type-DatasetGroup-kmsKeyArn"></a>
The Amazon Resource Name \(ARN\) of the KMS key used to encrypt the datasets\.  
Type: String  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-DatasetGroup-lastUpdatedDateTime"></a>
The last update date and time \(in Unix time\) of the dataset group\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-DatasetGroup-name"></a>
The name of the dataset group\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **roleArn**   <a name="personalize-Type-DatasetGroup-roleArn"></a>
The ARN of the IAM role that has permissions to create the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):iam::\d{12}:role/?[a-zA-Z_0-9+=,.@\-_/]+`   
Required: No

 **status**   <a name="personalize-Type-DatasetGroup-status"></a>
The current status of the dataset group\.  
A dataset group can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_DatasetGroup_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DatasetGroup) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DatasetGroup) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DatasetGroup) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DatasetGroup) 
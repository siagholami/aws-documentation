# MigrationTaskSummary<a name="API_MigrationTaskSummary"></a>

MigrationTaskSummary includes `MigrationTaskName`, `ProgressPercent`, `ProgressUpdateStream`, `Status`, and `UpdateDateTime` for each task\.

## Contents<a name="API_MigrationTaskSummary_Contents"></a>

 **MigrationTaskName**   <a name="migrationhub-Type-MigrationTaskSummary-MigrationTaskName"></a>
Unique identifier that references the migration task\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: No

 **ProgressPercent**   <a name="migrationhub-Type-MigrationTaskSummary-ProgressPercent"></a>
Indication of the percentage completion of the task\.  
Type: Integer  
Valid Range: Minimum value of 0\. Maximum value of 100\.  
Required: No

 **ProgressUpdateStream**   <a name="migrationhub-Type-MigrationTaskSummary-ProgressUpdateStream"></a>
An AWS resource used for access control\. It should uniquely identify the migration tool as it is used for all updates made by the tool\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: No

 **Status**   <a name="migrationhub-Type-MigrationTaskSummary-Status"></a>
Status of the task\.  
Type: String  
Valid Values:` NOT_STARTED | IN_PROGRESS | FAILED | COMPLETED`   
Required: No

 **StatusDetail**   <a name="migrationhub-Type-MigrationTaskSummary-StatusDetail"></a>
Detail information of what is being done within the overall status state\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 500\.  
Pattern: `^.{0,500}$`   
Required: No

 **UpdateDateTime**   <a name="migrationhub-Type-MigrationTaskSummary-UpdateDateTime"></a>
The timestamp when the task was gathered\.  
Type: Timestamp  
Required: No

## See Also<a name="API_MigrationTaskSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/MigrationTaskSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/MigrationTaskSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/MigrationTaskSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/MigrationTaskSummary) 
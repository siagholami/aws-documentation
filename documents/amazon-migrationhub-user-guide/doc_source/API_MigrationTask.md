# MigrationTask<a name="API_MigrationTask"></a>

Represents a migration task in a migration tool\.

## Contents<a name="API_MigrationTask_Contents"></a>

 **MigrationTaskName**   <a name="migrationhub-Type-MigrationTask-MigrationTaskName"></a>
Unique identifier that references the migration task\. *Do not store personal data in this field\.*   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[^:|]+`   
Required: No

 **ProgressUpdateStream**   <a name="migrationhub-Type-MigrationTask-ProgressUpdateStream"></a>
A name that identifies the vendor of the migration tool being used\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Pattern: `[^/:|\000-\037]+`   
Required: No

 **ResourceAttributeList**   <a name="migrationhub-Type-MigrationTask-ResourceAttributeList"></a>
Information about the resource that is being migrated\. This data will be used to map the task to a resource in the Application Discovery Service repository\.  
Type: Array of [ResourceAttribute](API_ResourceAttribute.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Required: No

 **Task**   <a name="migrationhub-Type-MigrationTask-Task"></a>
Task object encapsulating task information\.  
Type: [Task](API_Task.md) object  
Required: No

 **UpdateDateTime**   <a name="migrationhub-Type-MigrationTask-UpdateDateTime"></a>
The timestamp when the task was gathered\.  
Type: Timestamp  
Required: No

## See Also<a name="API_MigrationTask_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/MigrationTask) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/MigrationTask) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/MigrationTask) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/MigrationTask) 
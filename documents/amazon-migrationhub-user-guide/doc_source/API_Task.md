# Task<a name="API_Task"></a>

Task object encapsulating task information\.

## Contents<a name="API_Task_Contents"></a>

 **ProgressPercent**   <a name="migrationhub-Type-Task-ProgressPercent"></a>
Indication of the percentage completion of the task\.  
Type: Integer  
Valid Range: Minimum value of 0\. Maximum value of 100\.  
Required: No

 **Status**   <a name="migrationhub-Type-Task-Status"></a>
Status of the task \- Not Started, In\-Progress, Complete\.  
Type: String  
Valid Values:` NOT_STARTED | IN_PROGRESS | FAILED | COMPLETED`   
Required: Yes

 **StatusDetail**   <a name="migrationhub-Type-Task-StatusDetail"></a>
Details of task status as notified by a migration tool\. A tool might use this field to provide clarifying information about the status that is unique to that tool or that explains an error state\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 500\.  
Pattern: `^.{0,500}$`   
Required: No

## See Also<a name="API_Task_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/Task) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/Task) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/Task) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/Task) 
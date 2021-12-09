# ApplicationState<a name="API_ApplicationState"></a>

The state of an application discovered through Migration Hub import, the AWS Agentless Discovery Connector, or the AWS Application Discovery Agent\.

## Contents<a name="API_ApplicationState_Contents"></a>

 **ApplicationId**   <a name="migrationhub-Type-ApplicationState-ApplicationId"></a>
The configurationId from the Application Discovery Service that uniquely identifies an application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1600\.  
Pattern: `^.{1,1600}$`   
Required: No

 **ApplicationStatus**   <a name="migrationhub-Type-ApplicationState-ApplicationStatus"></a>
The current status of an application\.  
Type: String  
Valid Values:` NOT_STARTED | IN_PROGRESS | COMPLETED`   
Required: No

 **LastUpdatedTime**   <a name="migrationhub-Type-ApplicationState-LastUpdatedTime"></a>
The timestamp when the application status was last updated\.  
Type: Timestamp  
Required: No

## See Also<a name="API_ApplicationState_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/ApplicationState) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/ApplicationState) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/ApplicationState) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/ApplicationState) 
# CreatedArtifact<a name="API_CreatedArtifact"></a>

An ARN of the AWS cloud resource target receiving the migration \(e\.g\., AMI, EC2 instance, RDS instance, etc\.\)\.

## Contents<a name="API_CreatedArtifact_Contents"></a>

 **Description**   <a name="migrationhub-Type-CreatedArtifact-Description"></a>
A description that can be free\-form text to record additional detail about the artifact for clarity or for later reference\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 500\.  
Pattern: `^.{0,500}$`   
Required: No

 **Name**   <a name="migrationhub-Type-CreatedArtifact-Name"></a>
An ARN that uniquely identifies the result of a migration task\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1600\.  
Pattern: `arn:[a-z-]+:[a-z0-9-]+:(?:[a-z0-9-]+|):(?:[0-9]{12}|):.*`   
Required: Yes

## See Also<a name="API_CreatedArtifact_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/CreatedArtifact) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/CreatedArtifact) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/CreatedArtifact) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/CreatedArtifact) 
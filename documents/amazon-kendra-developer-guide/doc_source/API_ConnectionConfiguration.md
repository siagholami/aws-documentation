--------

--------

# ConnectionConfiguration<a name="API_ConnectionConfiguration"></a>

Provides the information necessary to connect to a database\.

## Contents<a name="API_ConnectionConfiguration_Contents"></a>

 **DatabaseHost**   <a name="Kendra-Type-ConnectionConfiguration-DatabaseHost"></a>
The name of the host for the database\. Can be either a string \(host\.subdomain\.domain\.tld\) or an IPv4 or IPv6 address\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 253\.  
Required: Yes

 **DatabaseName**   <a name="Kendra-Type-ConnectionConfiguration-DatabaseName"></a>
The name of the database containing the document data\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

 **DatabasePort**   <a name="Kendra-Type-ConnectionConfiguration-DatabasePort"></a>
The port that the database uses for connections\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 65535\.  
Required: Yes

 **SecretArn**   <a name="Kendra-Type-ConnectionConfiguration-SecretArn"></a>
The Amazon Resource Name \(ARN\) of credentials stored in AWS Secrets Manager\. The credentials should be a user/password pair\. For more information, see [Using a Database Data Source](https://docs.aws.amazon.com/kendra/latest/dg/data-source-database.html)\. For more information about AWS Secrets Manager, see [ What Is AWS Secrets Manager ](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html) in the *AWS Secrets Manager* user guide\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 **TableName**   <a name="Kendra-Type-ConnectionConfiguration-TableName"></a>
The name of the table that contains the document data\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

## See Also<a name="API_ConnectionConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ConnectionConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ConnectionConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ConnectionConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ConnectionConfiguration) 
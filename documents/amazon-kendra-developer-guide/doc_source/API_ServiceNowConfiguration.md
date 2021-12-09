--------

--------

# ServiceNowConfiguration<a name="API_ServiceNowConfiguration"></a>

Provides configuration information required to connect to a ServiceNow data source\.

## Contents<a name="API_ServiceNowConfiguration_Contents"></a>

 **HostUrl**   <a name="Kendra-Type-ServiceNowConfiguration-HostUrl"></a>
The ServiceNow instance that the data source connects to\. The host endpoint should look like the following: `{instance}.service-now.com.`   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `^(?!(^(https?|ftp|file):\/\/))[a-z0-9-]+(\.service-now\.com)$`   
Required: Yes

 **KnowledgeArticleConfiguration**   <a name="Kendra-Type-ServiceNowConfiguration-KnowledgeArticleConfiguration"></a>
Provides configuration information for crawling knowledge articles in the ServiceNow site\.  
Type: [ServiceNowKnowledgeArticleConfiguration](API_ServiceNowKnowledgeArticleConfiguration.md) object  
Required: No

 **SecretArn**   <a name="Kendra-Type-ServiceNowConfiguration-SecretArn"></a>
The Amazon Resource Name \(ARN\) of the AWS Secret Manager secret that contains the user name and password required to connect to the ServiceNow instance\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 **ServiceCatalogConfiguration**   <a name="Kendra-Type-ServiceNowConfiguration-ServiceCatalogConfiguration"></a>
Provides configuration information for crawling service catalogs in the ServiceNow site\.  
Type: [ServiceNowServiceCatalogConfiguration](API_ServiceNowServiceCatalogConfiguration.md) object  
Required: No

 **ServiceNowBuildVersion**   <a name="Kendra-Type-ServiceNowConfiguration-ServiceNowBuildVersion"></a>
The identifier of the release that the ServiceNow host is running\. If the host is not running the `LONDON` release, use `OTHERS`\.  
Type: String  
Valid Values:` LONDON | OTHERS`   
Required: Yes

## See Also<a name="API_ServiceNowConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ServiceNowConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ServiceNowConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ServiceNowConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ServiceNowConfiguration) 
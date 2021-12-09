--------

--------

# OneDriveConfiguration<a name="API_OneDriveConfiguration"></a>

Provides configuration information for data sources that connect to OneDrive\.

## Contents<a name="API_OneDriveConfiguration_Contents"></a>

 **ExclusionPatterns**   <a name="Kendra-Type-OneDriveConfiguration-ExclusionPatterns"></a>
List of regular expressions applied to documents\. Items that match the exclusion pattern are not indexed\. If you provide both an inclusion pattern and an exclusion pattern, any item that matches the exclusion pattern isn't indexed\.   
The exclusion pattern is applied to the file name\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **FieldMappings**   <a name="Kendra-Type-OneDriveConfiguration-FieldMappings"></a>
A list of `DataSourceToIndexFieldMapping` objects that map Microsoft OneDrive fields to custom fields in the Amazon Kendra index\. You must first create the index fields before you map OneDrive fields\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

 **InclusionPatterns**   <a name="Kendra-Type-OneDriveConfiguration-InclusionPatterns"></a>
A list of regular expression patterns\. Documents that match the pattern are included in the index\. Documents that don't match the pattern are excluded from the index\. If a document matches both an inclusion pattern and an exclusion pattern, the document is not included in the index\.   
The exclusion pattern is applied to the file name\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **OneDriveUsers**   <a name="Kendra-Type-OneDriveConfiguration-OneDriveUsers"></a>
A list of user accounts whose documents should be indexed\.  
Type: [OneDriveUsers](API_OneDriveUsers.md) object  
Required: Yes

 **SecretArn**   <a name="Kendra-Type-OneDriveConfiguration-SecretArn"></a>
The Amazon Resource Name \(ARN\) of an AWS Secrets Manager secret that contains the user name and password to connect to OneDrive\. The user namd should be the application ID for the OneDrive application, and the password is the application key for the OneDrive application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 **TenantDomain**   <a name="Kendra-Type-OneDriveConfiguration-TenantDomain"></a>
Tha Azure Active Directory domain of the organization\.   
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `^([a-zA-Z0-9]+(-[a-zA-Z0-9]+)*\.)+[a-z]{2,}$`   
Required: Yes

## See Also<a name="API_OneDriveConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/OneDriveConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/OneDriveConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/OneDriveConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/OneDriveConfiguration) 
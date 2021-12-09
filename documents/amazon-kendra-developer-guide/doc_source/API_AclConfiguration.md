--------

--------

# AclConfiguration<a name="API_AclConfiguration"></a>

Provides information about the column that should be used for filtering the query response by groups\.

## Contents<a name="API_AclConfiguration_Contents"></a>

 **AllowedGroupsColumnName**   <a name="Kendra-Type-AclConfiguration-AllowedGroupsColumnName"></a>
A list of groups, separated by semi\-colons, that filters a query response based on user context\. The document is only returned to users that are in one of the groups specified in the `UserContext` field of the [Query](API_Query.md) operation\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

## See Also<a name="API_AclConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/AclConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/AclConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/AclConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/AclConfiguration) 
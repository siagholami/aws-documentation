--------

--------

# OneDriveUsers<a name="API_OneDriveUsers"></a>

User accounts whose documents should be indexed\.

## Contents<a name="API_OneDriveUsers_Contents"></a>

 **OneDriveUserList**   <a name="Kendra-Type-OneDriveUsers-OneDriveUserList"></a>
A list of users whose documents should be indexed\. Specify the user names in email format, for example, `username@tenantdomain`\. If you need to index the documents of more than 100 users, use the `OneDriveUserS3Path` field to specify the location of a file containing a list of users\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `^(?!\s).+@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$`   
Required: No

 **OneDriveUserS3Path**   <a name="Kendra-Type-OneDriveUsers-OneDriveUserS3Path"></a>
The S3 bucket location of a file containing a list of users whose documents should be indexed\.  
Type: [S3Path](API_S3Path.md) object  
Required: No

## See Also<a name="API_OneDriveUsers_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/OneDriveUsers) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/OneDriveUsers) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/OneDriveUsers) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/OneDriveUsers) 
--------

--------

# UntagResource<a name="API_UntagResource"></a>

Removes a tag from an index, FAQ, or a data source\.

## Request Syntax<a name="API_UntagResource_RequestSyntax"></a>

```
{
   "ResourceARN": "string",
   "TagKeys": [ "string" ]
}
```

## Request Parameters<a name="API_UntagResource_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [ResourceARN](#API_UntagResource_RequestSyntax) **   <a name="Kendra-UntagResource-request-ResourceARN"></a>
The Amazon Resource Name \(ARN\) of the index, FAQ, or data source to remove the tag from\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1011\.  
Required: Yes

 ** [TagKeys](#API_UntagResource_RequestSyntax) **   <a name="Kendra-UntagResource-request-TagKeys"></a>
A list of tag keys to remove from the index, FAQ, or data source\. If a tag key does not exist on the resource, it is ignored\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Required: Yes

## Response Elements<a name="API_UntagResource_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_UntagResource_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **AccessDeniedException**   
HTTP Status Code: 400

 **InternalServerException**   
HTTP Status Code: 500

 **ResourceUnavailableException**   
HTTP Status Code: 400

 **ThrottlingException**   
HTTP Status Code: 400

 **ValidationException**   
HTTP Status Code: 400

## See Also<a name="API_UntagResource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kendra-2019-02-03/UntagResource) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/UntagResource) 
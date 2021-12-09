# ListTerminologies<a name="API_ListTerminologies"></a>

Provides a list of custom terminologies associated with your account\.

## Request Syntax<a name="API_ListTerminologies_RequestSyntax"></a>

```
{
   "[MaxResults](#Translate-ListTerminologies-request-MaxResults)": number,
   "[NextToken](#Translate-ListTerminologies-request-NextToken)": "string"
}
```

## Request Parameters<a name="API_ListTerminologies_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [MaxResults](#API_ListTerminologies_RequestSyntax) **   <a name="Translate-ListTerminologies-request-MaxResults"></a>
The maximum number of custom terminologies returned per list request\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 500\.  
Required: No

 ** [NextToken](#API_ListTerminologies_RequestSyntax) **   <a name="Translate-ListTerminologies-request-NextToken"></a>
If the result of the request to ListTerminologies was truncated, include the NextToken to fetch the next group of custom terminologies\.   
Type: String  
Length Constraints: Maximum length of 8192\.  
Pattern: `\p{ASCII}{0,8192}`   
Required: No

## Response Syntax<a name="API_ListTerminologies_ResponseSyntax"></a>

```
{
   "[NextToken](#Translate-ListTerminologies-response-NextToken)": "string",
   "[TerminologyPropertiesList](#Translate-ListTerminologies-response-TerminologyPropertiesList)": [ 
      { 
         "[Arn](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-Arn)": "string",
         "[CreatedAt](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-CreatedAt)": number,
         "[Description](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-Description)": "string",
         "[EncryptionKey](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-EncryptionKey)": { 
            "[Id](API_EncryptionKey.md#Translate-Type-EncryptionKey-Id)": "string",
            "[Type](API_EncryptionKey.md#Translate-Type-EncryptionKey-Type)": "string"
         },
         "[LastUpdatedAt](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-LastUpdatedAt)": number,
         "[Name](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-Name)": "string",
         "[SizeBytes](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-SizeBytes)": number,
         "[SourceLanguageCode](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-SourceLanguageCode)": "string",
         "[TargetLanguageCodes](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-TargetLanguageCodes)": [ "string" ],
         "[TermCount](API_TerminologyProperties.md#Translate-Type-TerminologyProperties-TermCount)": number
      }
   ]
}
```

## Response Elements<a name="API_ListTerminologies_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [NextToken](#API_ListTerminologies_ResponseSyntax) **   <a name="Translate-ListTerminologies-response-NextToken"></a>
 If the response to the ListTerminologies was truncated, the NextToken fetches the next group of custom terminologies\.  
Type: String  
Length Constraints: Maximum length of 8192\.  
Pattern: `\p{ASCII}{0,8192}` 

 ** [TerminologyPropertiesList](#API_ListTerminologies_ResponseSyntax) **   <a name="Translate-ListTerminologies-response-TerminologyPropertiesList"></a>
The properties list of the custom terminologies returned on the list request\.  
Type: Array of [TerminologyProperties](API_TerminologyProperties.md) objects

## Errors<a name="API_ListTerminologies_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
An internal server error occurred\. Retry your request\.  
HTTP Status Code: 500

 **InvalidParameterValueException**   
The value of the parameter is invalid\. Review the value of the parameter you are using to correct it, and then retry your operation\.  
HTTP Status Code: 400

 **TooManyRequestsException**   
 You have made too many requests within a short period of time\. Wait for a short time and then try your request again\.  
HTTP Status Code: 400

## See Also<a name="API_ListTerminologies_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/translate-2017-07-01/ListTerminologies) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/ListTerminologies) 
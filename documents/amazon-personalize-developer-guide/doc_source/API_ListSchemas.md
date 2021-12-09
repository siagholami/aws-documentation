# ListSchemas<a name="API_ListSchemas"></a>

Returns the list of schemas associated with the account\. The response provides the properties for each schema, including the Amazon Resource Name \(ARN\)\. For more information on schemas, see [CreateSchema](API_CreateSchema.md)\.

## Request Syntax<a name="API_ListSchemas_RequestSyntax"></a>

```
{
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListSchemas_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [maxResults](#API_ListSchemas_RequestSyntax) **   <a name="personalize-ListSchemas-request-maxResults"></a>
The maximum number of schemas to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListSchemas_RequestSyntax) **   <a name="personalize-ListSchemas-request-nextToken"></a>
A token returned from the previous call to `ListSchemas` for getting the next set of schemas \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListSchemas_ResponseSyntax"></a>

```
{
   "nextToken": "string",
   "schemas": [ 
      { 
         "creationDateTime": number,
         "lastUpdatedDateTime": number,
         "name": "string",
         "schemaArn": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListSchemas_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [nextToken](#API_ListSchemas_ResponseSyntax) **   <a name="personalize-ListSchemas-response-nextToken"></a>
A token used to get the next set of schemas \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

 ** [schemas](#API_ListSchemas_ResponseSyntax) **   <a name="personalize-ListSchemas-response-schemas"></a>
A list of schemas\.  
Type: Array of [DatasetSchemaSummary](API_DatasetSchemaSummary.md) objects  
Array Members: Maximum number of 100 items\.

## Errors<a name="API_ListSchemas_Errors"></a>

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListSchemas_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListSchemas) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListSchemas) 
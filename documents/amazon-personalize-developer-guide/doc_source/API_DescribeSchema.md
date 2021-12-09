# DescribeSchema<a name="API_DescribeSchema"></a>

Describes a schema\. For more information on schemas, see [CreateSchema](API_CreateSchema.md)\.

## Request Syntax<a name="API_DescribeSchema_RequestSyntax"></a>

```
{
   "schemaArn": "string"
}
```

## Request Parameters<a name="API_DescribeSchema_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [schemaArn](#API_DescribeSchema_RequestSyntax) **   <a name="personalize-DescribeSchema-request-schemaArn"></a>
The Amazon Resource Name \(ARN\) of the schema to retrieve\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeSchema_ResponseSyntax"></a>

```
{
   "schema": { 
      "creationDateTime": number,
      "lastUpdatedDateTime": number,
      "name": "string",
      "schema": "string",
      "schemaArn": "string"
   }
}
```

## Response Elements<a name="API_DescribeSchema_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [schema](#API_DescribeSchema_ResponseSyntax) **   <a name="personalize-DescribeSchema-response-schema"></a>
The requested schema\.  
Type: [DatasetSchema](API_DatasetSchema.md) object

## Errors<a name="API_DescribeSchema_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeSchema_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeSchema) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeSchema) 
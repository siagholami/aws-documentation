# CreateSchema<a name="API_CreateSchema"></a>

Creates an Amazon Personalize schema from the specified schema string\. The schema you create must be in Avro JSON format\.

Amazon Personalize recognizes three schema variants\. Each schema is associated with a dataset type and has a set of required field and keywords\. You specify a schema when you call [CreateDataset](API_CreateDataset.md)\.

For more information on schemas, see [Datasets and Schemas](https://docs.aws.amazon.com/personalize/latest/dg/how-it-works-dataset-schema.html)\.

**Related APIs**
+  [ListSchemas](API_ListSchemas.md) 
+  [DescribeSchema](API_DescribeSchema.md) 
+  [DeleteSchema](API_DeleteSchema.md) 

## Request Syntax<a name="API_CreateSchema_RequestSyntax"></a>

```
{
   "name": "string",
   "schema": "string"
}
```

## Request Parameters<a name="API_CreateSchema_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [name](#API_CreateSchema_RequestSyntax) **   <a name="personalize-CreateSchema-request-name"></a>
The name for the schema\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

 ** [schema](#API_CreateSchema_RequestSyntax) **   <a name="personalize-CreateSchema-request-schema"></a>
A schema in Avro JSON format\.  
Type: String  
Length Constraints: Maximum length of 10000\.  
Required: Yes

## Response Syntax<a name="API_CreateSchema_ResponseSyntax"></a>

```
{
   "schemaArn": "string"
}
```

## Response Elements<a name="API_CreateSchema_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [schemaArn](#API_CreateSchema_ResponseSyntax) **   <a name="personalize-CreateSchema-response-schemaArn"></a>
The Amazon Resource Name \(ARN\) of the created schema\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateSchema_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

## See Also<a name="API_CreateSchema_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateSchema) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateSchema) 
# TagResource<a name="API_TagResource"></a>

Adds or edits tags for a AWS RoboMaker resource\.

Each tag consists of a tag key and a tag value\. Tag keys and tag values are both required, but tag values can be empty strings\. 

For information about the rules that apply to tag keys and tag values, see [User\-Defined Tag Restrictions](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/allocation-tag-restrictions.html) in the *AWS Billing and Cost Management User Guide*\. 

## Request Syntax<a name="API_TagResource_RequestSyntax"></a>

```
POST /tags/resourceArn HTTP/1.1
Content-type: application/json

{
   "[tags](#robomaker-TagResource-request-tags)": { 
      "string" : "string" 
   }
}
```

## URI Request Parameters<a name="API_TagResource_RequestParameters"></a>

The request requires the following URI parameters\.

 ** [resourceArn](#API_TagResource_RequestSyntax) **   <a name="robomaker-TagResource-request-resourceArn"></a>
The Amazon Resource Name \(ARN\) of the AWS RoboMaker resource you are tagging\.  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

## Request Body<a name="API_TagResource_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [tags](#API_TagResource_RequestSyntax) **   <a name="robomaker-TagResource-request-tags"></a>
A map that contains tag keys and tag values that are attached to the resource\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: Yes

## Response Syntax<a name="API_TagResource_ResponseSyntax"></a>

```
HTTP/1.1 200
```

## Response Elements<a name="API_TagResource_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_TagResource_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
The specified resource does not exist\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_TagResource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/TagResource) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/TagResource) 
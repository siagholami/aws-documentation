# DescribeFeatureTransformation<a name="API_DescribeFeatureTransformation"></a>

Describes the given feature transformation\.

## Request Syntax<a name="API_DescribeFeatureTransformation_RequestSyntax"></a>

```
{
   "featureTransformationArn": "string"
}
```

## Request Parameters<a name="API_DescribeFeatureTransformation_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [featureTransformationArn](#API_DescribeFeatureTransformation_RequestSyntax) **   <a name="personalize-DescribeFeatureTransformation-request-featureTransformationArn"></a>
The Amazon Resource Name \(ARN\) of the feature transformation to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeFeatureTransformation_ResponseSyntax"></a>

```
{
   "featureTransformation": { 
      "creationDateTime": number,
      "defaultParameters": { 
         "string" : "string" 
      },
      "featureTransformationArn": "string",
      "lastUpdatedDateTime": number,
      "name": "string",
      "status": "string"
   }
}
```

## Response Elements<a name="API_DescribeFeatureTransformation_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [featureTransformation](#API_DescribeFeatureTransformation_ResponseSyntax) **   <a name="personalize-DescribeFeatureTransformation-response-featureTransformation"></a>
A listing of the FeatureTransformation properties\.  
Type: [FeatureTransformation](API_FeatureTransformation.md) object

## Errors<a name="API_DescribeFeatureTransformation_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeFeatureTransformation_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeFeatureTransformation) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeFeatureTransformation) 
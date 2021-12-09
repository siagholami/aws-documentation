# DescribeAlgorithm<a name="API_DescribeAlgorithm"></a>

Describes the given algorithm\.

## Request Syntax<a name="API_DescribeAlgorithm_RequestSyntax"></a>

```
{
   "algorithmArn": "string"
}
```

## Request Parameters<a name="API_DescribeAlgorithm_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [algorithmArn](#API_DescribeAlgorithm_RequestSyntax) **   <a name="personalize-DescribeAlgorithm-request-algorithmArn"></a>
The Amazon Resource Name \(ARN\) of the algorithm to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeAlgorithm_ResponseSyntax"></a>

```
{
   "algorithm": { 
      "algorithmArn": "string",
      "algorithmImage": { 
         "dockerURI": "string",
         "name": "string"
      },
      "creationDateTime": number,
      "defaultHyperParameterRanges": { 
         "categoricalHyperParameterRanges": [ 
            { 
               "isTunable": boolean,
               "name": "string",
               "values": [ "string" ]
            }
         ],
         "continuousHyperParameterRanges": [ 
            { 
               "isTunable": boolean,
               "maxValue": number,
               "minValue": number,
               "name": "string"
            }
         ],
         "integerHyperParameterRanges": [ 
            { 
               "isTunable": boolean,
               "maxValue": number,
               "minValue": number,
               "name": "string"
            }
         ]
      },
      "defaultHyperParameters": { 
         "string" : "string" 
      },
      "defaultResourceConfig": { 
         "string" : "string" 
      },
      "lastUpdatedDateTime": number,
      "name": "string",
      "roleArn": "string",
      "trainingInputMode": "string"
   }
}
```

## Response Elements<a name="API_DescribeAlgorithm_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [algorithm](#API_DescribeAlgorithm_ResponseSyntax) **   <a name="personalize-DescribeAlgorithm-response-algorithm"></a>
A listing of the properties of the algorithm\.  
Type: [Algorithm](API_Algorithm.md) object

## Errors<a name="API_DescribeAlgorithm_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeAlgorithm_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeAlgorithm) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeAlgorithm) 
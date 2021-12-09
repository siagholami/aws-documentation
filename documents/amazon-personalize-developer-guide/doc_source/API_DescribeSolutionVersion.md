# DescribeSolutionVersion<a name="API_DescribeSolutionVersion"></a>

Describes a specific version of a solution\. For more information on solutions, see [CreateSolution](API_CreateSolution.md)\.

## Request Syntax<a name="API_DescribeSolutionVersion_RequestSyntax"></a>

```
{
   "solutionVersionArn": "string"
}
```

## Request Parameters<a name="API_DescribeSolutionVersion_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [solutionVersionArn](#API_DescribeSolutionVersion_RequestSyntax) **   <a name="personalize-DescribeSolutionVersion-request-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the solution version\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeSolutionVersion_ResponseSyntax"></a>

```
{
   "solutionVersion": { 
      "creationDateTime": number,
      "datasetGroupArn": "string",
      "eventType": "string",
      "failureReason": "string",
      "lastUpdatedDateTime": number,
      "performAutoML": boolean,
      "performHPO": boolean,
      "recipeArn": "string",
      "solutionArn": "string",
      "solutionConfig": { 
         "algorithmHyperParameters": { 
            "string" : "string" 
         },
         "autoMLConfig": { 
            "metricName": "string",
            "recipeList": [ "string" ]
         },
         "eventValueThreshold": "string",
         "featureTransformationParameters": { 
            "string" : "string" 
         },
         "hpoConfig": { 
            "algorithmHyperParameterRanges": { 
               "categoricalHyperParameterRanges": [ 
                  { 
                     "name": "string",
                     "values": [ "string" ]
                  }
               ],
               "continuousHyperParameterRanges": [ 
                  { 
                     "maxValue": number,
                     "minValue": number,
                     "name": "string"
                  }
               ],
               "integerHyperParameterRanges": [ 
                  { 
                     "maxValue": number,
                     "minValue": number,
                     "name": "string"
                  }
               ]
            },
            "hpoObjective": { 
               "metricName": "string",
               "metricRegex": "string",
               "type": "string"
            },
            "hpoResourceConfig": { 
               "maxNumberOfTrainingJobs": "string",
               "maxParallelTrainingJobs": "string"
            }
         }
      },
      "solutionVersionArn": "string",
      "status": "string",
      "trainingHours": number,
      "trainingMode": "string",
      "tunedHPOParams": { 
         "algorithmHyperParameters": { 
            "string" : "string" 
         }
      }
   }
}
```

## Response Elements<a name="API_DescribeSolutionVersion_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [solutionVersion](#API_DescribeSolutionVersion_ResponseSyntax) **   <a name="personalize-DescribeSolutionVersion-response-solutionVersion"></a>
The solution version\.  
Type: [SolutionVersion](API_SolutionVersion.md) object

## Errors<a name="API_DescribeSolutionVersion_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeSolutionVersion_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeSolutionVersion) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeSolutionVersion) 
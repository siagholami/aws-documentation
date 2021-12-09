# DescribeSolution<a name="API_DescribeSolution"></a>

Describes a solution\. For more information on solutions, see [CreateSolution](API_CreateSolution.md)\.

## Request Syntax<a name="API_DescribeSolution_RequestSyntax"></a>

```
{
   "solutionArn": "string"
}
```

## Request Parameters<a name="API_DescribeSolution_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [solutionArn](#API_DescribeSolution_RequestSyntax) **   <a name="personalize-DescribeSolution-request-solutionArn"></a>
The Amazon Resource Name \(ARN\) of the solution to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeSolution_ResponseSyntax"></a>

```
{
   "solution": { 
      "autoMLResult": { 
         "bestRecipeArn": "string"
      },
      "creationDateTime": number,
      "datasetGroupArn": "string",
      "eventType": "string",
      "lastUpdatedDateTime": number,
      "latestSolutionVersion": { 
         "creationDateTime": number,
         "failureReason": "string",
         "lastUpdatedDateTime": number,
         "solutionVersionArn": "string",
         "status": "string"
      },
      "name": "string",
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
      "status": "string"
   }
}
```

## Response Elements<a name="API_DescribeSolution_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [solution](#API_DescribeSolution_ResponseSyntax) **   <a name="personalize-DescribeSolution-response-solution"></a>
An object that describes the solution\.  
Type: [Solution](API_Solution.md) object

## Errors<a name="API_DescribeSolution_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeSolution_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeSolution) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeSolution) 
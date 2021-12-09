# CreateSolution<a name="API_CreateSolution"></a>

Creates the configuration for training a model\. A trained model is known as a solution\. After the configuration is created, you train the model \(create a solution\) by calling the [CreateSolutionVersion](API_CreateSolutionVersion.md) operation\. Every time you call `CreateSolutionVersion`, a new version of the solution is created\.

After creating a solution version, you check its accuracy by calling [GetSolutionMetrics](API_GetSolutionMetrics.md)\. When you are satisfied with the version, you deploy it using [CreateCampaign](API_CreateCampaign.md)\. The campaign provides recommendations to a client through the [GetRecommendations](https://docs.aws.amazon.com/personalize/latest/dg/API_RS_GetRecommendations.html) API\.

To train a model, Amazon Personalize requires training data and a recipe\. The training data comes from the dataset group that you provide in the request\. A recipe specifies the training algorithm and a feature transformation\. You can specify one of the predefined recipes provided by Amazon Personalize\. Alternatively, you can specify `performAutoML` and Amazon Personalize will analyze your data and select the optimum USER\_PERSONALIZATION recipe for you\.

 **Status** 

A solution can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS

To get the status of the solution, call [DescribeSolution](API_DescribeSolution.md)\. Wait until the status shows as ACTIVE before calling `CreateSolutionVersion`\.

**Related APIs**
+  [ListSolutions](API_ListSolutions.md) 
+  [CreateSolutionVersion](API_CreateSolutionVersion.md) 
+  [DescribeSolution](API_DescribeSolution.md) 
+  [DeleteSolution](API_DeleteSolution.md) 
+  [ListSolutionVersions](API_ListSolutionVersions.md) 
+  [DescribeSolutionVersion](API_DescribeSolutionVersion.md) 

## Request Syntax<a name="API_CreateSolution_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "eventType": "string",
   "name": "string",
   "performAutoML": boolean,
   "performHPO": boolean,
   "recipeArn": "string",
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
   }
}
```

## Request Parameters<a name="API_CreateSolution_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group that provides the training data\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

 ** [eventType](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-eventType"></a>
When your have multiple event types \(using an `EVENT_TYPE` schema field\), this parameter specifies which event type \(for example, 'click' or 'like'\) is used for training the model\.  
If you do not provide an `eventType`, Amazon Personalize will use all interactions for training with equal weight regardless of type\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 ** [name](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-name"></a>
The name for the solution\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

 ** [performAutoML](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-performAutoML"></a>
Whether to perform automated machine learning \(AutoML\)\. The default is `false`\. For this case, you must specify `recipeArn`\.  
When set to `true`, Amazon Personalize analyzes your training data and selects the optimal USER\_PERSONALIZATION recipe and hyperparameters\. In this case, you must omit `recipeArn`\. Amazon Personalize determines the optimal recipe by running tests with different values for the hyperparameters\. AutoML lengthens the training process as compared to selecting a specific recipe\.  
Type: Boolean  
Required: No

 ** [performHPO](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-performHPO"></a>
Whether to perform hyperparameter optimization \(HPO\) on the specified or selected recipe\. The default is `false`\.  
When performing AutoML, this parameter is always `true` and you should not set it to `false`\.  
Type: Boolean  
Required: No

 ** [recipeArn](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-recipeArn"></a>
The ARN of the recipe to use for model training\. Only specified when `performAutoML` is false\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [solutionConfig](#API_CreateSolution_RequestSyntax) **   <a name="personalize-CreateSolution-request-solutionConfig"></a>
The configuration to use with the solution\. When `performAutoML` is set to true, Amazon Personalize only evaluates the `autoMLConfig` section of the solution configuration\.  
Type: [SolutionConfig](API_SolutionConfig.md) object  
Required: No

## Response Syntax<a name="API_CreateSolution_ResponseSyntax"></a>

```
{
   "solutionArn": "string"
}
```

## Response Elements<a name="API_CreateSolution_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [solutionArn](#API_CreateSolution_ResponseSyntax) **   <a name="personalize-CreateSolution-response-solutionArn"></a>
The ARN of the solution\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateSolution_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_CreateSolution_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateSolution) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateSolution) 
# CreatePredictor<a name="API_CreatePredictor"></a>

Creates an Amazon Forecast predictor\.

In the request, you provide a dataset group and either specify an algorithm or let Amazon Forecast choose the algorithm for you using AutoML\. If you specify an algorithm, you also can override algorithm\-specific hyperparameters\.

Amazon Forecast uses the chosen algorithm to train a model using the latest version of the datasets in the specified dataset group\. The result is called a predictor\. You then generate a forecast using the [CreateForecast](API_CreateForecast.md) operation\.

After training a model, the `CreatePredictor` operation also evaluates it\. To see the evaluation metrics, use the [GetAccuracyMetrics](API_GetAccuracyMetrics.md) operation\. Always review the evaluation metrics before deciding to use the predictor to generate a forecast\.

Optionally, you can specify a featurization configuration to fill and aggregate the data fields in the `TARGET_TIME_SERIES` dataset to improve model training\. For more information, see [FeaturizationConfig](API_FeaturizationConfig.md)\.

For RELATED\_TIME\_SERIES datasets, `CreatePredictor` verifies that the `DataFrequency` specified when the dataset was created matches the `ForecastFrequency`\. TARGET\_TIME\_SERIES datasets don't have this restriction\. Amazon Forecast also verifies the delimiter and timestamp format\. For more information, see [Datasets and Dataset Groups](howitworks-datasets-groups.md)\.

 **AutoML** 

If you want Amazon Forecast to evaluate each algorithm and choose the one that minimizes the `objective function`, set `PerformAutoML` to `true`\. The `objective function` is defined as the mean of the weighted p10, p50, and p90 quantile losses\. For more information, see [EvaluationResult](API_EvaluationResult.md)\.

When AutoML is enabled, the following properties are disallowed:
+  `AlgorithmArn` 
+  `HPOConfig` 
+  `PerformHPO` 
+  `TrainingParameters` 

To get a list of all of your predictors, use the [ListPredictors](API_ListPredictors.md) operation\.

**Note**  
Before you can use the predictor to create a forecast, the `Status` of the predictor must be `ACTIVE`, signifying that training has completed\. To get the status, use the [DescribePredictor](API_DescribePredictor.md) operation\.

## Request Syntax<a name="API_CreatePredictor_RequestSyntax"></a>

```
{
   "AlgorithmArn": "string",
   "EncryptionConfig": { 
      "KMSKeyArn": "string",
      "RoleArn": "string"
   },
   "EvaluationParameters": { 
      "BackTestWindowOffset": number,
      "NumberOfBacktestWindows": number
   },
   "FeaturizationConfig": { 
      "Featurizations": [ 
         { 
            "AttributeName": "string",
            "FeaturizationPipeline": [ 
               { 
                  "FeaturizationMethodName": "string",
                  "FeaturizationMethodParameters": { 
                     "string" : "string" 
                  }
               }
            ]
         }
      ],
      "ForecastDimensions": [ "string" ],
      "ForecastFrequency": "string"
   },
   "ForecastHorizon": number,
   "HPOConfig": { 
      "ParameterRanges": { 
         "CategoricalParameterRanges": [ 
            { 
               "Name": "string",
               "Values": [ "string" ]
            }
         ],
         "ContinuousParameterRanges": [ 
            { 
               "MaxValue": number,
               "MinValue": number,
               "Name": "string",
               "ScalingType": "string"
            }
         ],
         "IntegerParameterRanges": [ 
            { 
               "MaxValue": number,
               "MinValue": number,
               "Name": "string",
               "ScalingType": "string"
            }
         ]
      }
   },
   "InputDataConfig": { 
      "DatasetGroupArn": "string",
      "SupplementaryFeatures": [ 
         { 
            "Name": "string",
            "Value": "string"
         }
      ]
   },
   "PerformAutoML": boolean,
   "PerformHPO": boolean,
   "PredictorName": "string",
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ],
   "TrainingParameters": { 
      "string" : "string" 
   }
}
```

## Request Parameters<a name="API_CreatePredictor_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [AlgorithmArn](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-AlgorithmArn"></a>
The Amazon Resource Name \(ARN\) of the algorithm to use for model training\. Required if `PerformAutoML` is not set to `true`\.  

**Supported algorithms:**
+  `arn:aws:forecast:::algorithm/ARIMA` 
+  `arn:aws:forecast:::algorithm/CNN-QR` 
+  `arn:aws:forecast:::algorithm/Deep_AR_Plus` 
+  `arn:aws:forecast:::algorithm/ETS` 
+  `arn:aws:forecast:::algorithm/NPTS` 
+  `arn:aws:forecast:::algorithm/Prophet` 
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 ** [EncryptionConfig](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-EncryptionConfig"></a>
An AWS Key Management Service \(KMS\) key and the AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the key\.  
Type: [EncryptionConfig](API_EncryptionConfig.md) object  
Required: No

 ** [EvaluationParameters](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-EvaluationParameters"></a>
Used to override the default evaluation parameters of the specified algorithm\. Amazon Forecast evaluates a predictor by splitting a dataset into training data and testing data\. The evaluation parameters define how to perform the split and the number of iterations\.  
Type: [EvaluationParameters](API_EvaluationParameters.md) object  
Required: No

 ** [FeaturizationConfig](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-FeaturizationConfig"></a>
The featurization configuration\.  
Type: [FeaturizationConfig](API_FeaturizationConfig.md) object  
Required: Yes

 ** [ForecastHorizon](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-ForecastHorizon"></a>
Specifies the number of time\-steps that the model is trained to predict\. The forecast horizon is also called the prediction length\.  
For example, if you configure a dataset for daily data collection \(using the `DataFrequency` parameter of the [CreateDataset](API_CreateDataset.md) operation\) and set the forecast horizon to 10, the model returns predictions for 10 days\.  
The maximum forecast horizon is the lesser of 500 time\-steps or 1/3 of the TARGET\_TIME\_SERIES dataset length\.  
Type: Integer  
Required: Yes

 ** [HPOConfig](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-HPOConfig"></a>
Provides hyperparameter override values for the algorithm\. If you don't provide this parameter, Amazon Forecast uses default values\. The individual algorithms specify which hyperparameters support hyperparameter optimization \(HPO\)\. For more information, see [Choosing an Amazon Forecast Algorithm](aws-forecast-choosing-recipes.md)\.  
If you included the `HPOConfig` object, you must set `PerformHPO` to true\.  
Type: [HyperParameterTuningJobConfig](API_HyperParameterTuningJobConfig.md) object  
Required: No

 ** [InputDataConfig](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-InputDataConfig"></a>
Describes the dataset group that contains the data to use to train the predictor\.  
Type: [InputDataConfig](API_InputDataConfig.md) object  
Required: Yes

 ** [PerformAutoML](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-PerformAutoML"></a>
Whether to perform AutoML\. When Amazon Forecast performs AutoML, it evaluates the algorithms it provides and chooses the best algorithm and configuration for your training dataset\.  
The default value is `false`\. In this case, you are required to specify an algorithm\.  
Set `PerformAutoML` to `true` to have Amazon Forecast perform AutoML\. This is a good option if you aren't sure which algorithm is suitable for your training data\. In this case, `PerformHPO` must be false\.  
Type: Boolean  
Required: No

 ** [PerformHPO](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-PerformHPO"></a>
Whether to perform hyperparameter optimization \(HPO\)\. HPO finds optimal hyperparameter values for your training data\. The process of performing HPO is known as running a hyperparameter tuning job\.  
The default value is `false`\. In this case, Amazon Forecast uses default hyperparameter values from the chosen algorithm\.  
To override the default values, set `PerformHPO` to `true` and, optionally, supply the [HyperParameterTuningJobConfig](API_HyperParameterTuningJobConfig.md) object\. The tuning job specifies a metric to optimize, which hyperparameters participate in tuning, and the valid range for each tunable hyperparameter\. In this case, you are required to specify an algorithm and `PerformAutoML` must be false\.  
The following algorithms support HPO:  
+ DeepAR\+
+ CNN\-QR
Type: Boolean  
Required: No

 ** [PredictorName](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-PredictorName"></a>
A name for the predictor\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 ** [Tags](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-Tags"></a>
The optional metadata that you apply to the predictor to help you categorize and organize them\. Each tag consists of a key and an optional value, both of which you define\.  
The following basic restrictions apply to tags:  
+ Maximum number of tags per resource \- 50\.
+ For each resource, each tag key must be unique, and each tag key can have only one value\.
+ Maximum key length \- 128 Unicode characters in UTF\-8\.
+ Maximum value length \- 256 Unicode characters in UTF\-8\.
+ If your tagging schema is used across multiple services and resources, remember that other services may have restrictions on allowed characters\. Generally allowed characters are: letters, numbers, and spaces representable in UTF\-8, and the following characters: \+ \- = \. \_ : / @\.
+ Tag keys and values are case sensitive\.
+ Do not use `aws:`, `AWS:`, or any upper or lowercase combination of such as a prefix for keys as it is reserved for AWS use\. You cannot edit or delete tag keys with this prefix\. Values can have this prefix\. If a tag value has `aws` as its prefix but the key does not, then Forecast considers it to be a user tag and will count against the limit of 50 tags\. Tags with only the key prefix of `aws` do not count against your tags per resource limit\.
Type: Array of [Tag](API_Tag.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.  
Required: No

 ** [TrainingParameters](#API_CreatePredictor_RequestSyntax) **   <a name="forecast-CreatePredictor-request-TrainingParameters"></a>
The hyperparameters to override for model training\. The hyperparameters that you can override are listed in the individual algorithms\. For the list of supported algorithms, see [Choosing an Amazon Forecast Algorithm](aws-forecast-choosing-recipes.md)\.  
Type: String to string map  
Map Entries: Minimum number of 0 items\. Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Key Pattern: `^[a-zA-Z0-9\-\_\.\/\[\]\,\\]+$`   
Value Length Constraints: Maximum length of 256\.  
Value Pattern: `^[a-zA-Z0-9\-\_\.\/\[\]\,\"\\\s]+$`   
Required: No

## Response Syntax<a name="API_CreatePredictor_ResponseSyntax"></a>

```
{
   "PredictorArn": "string"
}
```

## Response Elements<a name="API_CreatePredictor_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [PredictorArn](#API_CreatePredictor_ResponseSyntax) **   <a name="forecast-CreatePredictor-response-PredictorArn"></a>
The Amazon Resource Name \(ARN\) of the predictor\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

## Errors<a name="API_CreatePredictor_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of resources per account has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
There is already a resource with this name\. Try again with a different name\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_CreatePredictor_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/CreatePredictor) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/CreatePredictor) 
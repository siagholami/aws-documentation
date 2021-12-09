# Algorithm<a name="API_Algorithm"></a>

Describes a custom algorithm\.

## Contents<a name="API_Algorithm_Contents"></a>

 **algorithmArn**   <a name="personalize-Type-Algorithm-algorithmArn"></a>
The Amazon Resource Name \(ARN\) of the algorithm\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **algorithmImage**   <a name="personalize-Type-Algorithm-algorithmImage"></a>
The URI of the Docker container for the algorithm image\.  
Type: [AlgorithmImage](API_AlgorithmImage.md) object  
Required: No

 **creationDateTime**   <a name="personalize-Type-Algorithm-creationDateTime"></a>
The date and time \(in Unix time\) that the algorithm was created\.  
Type: Timestamp  
Required: No

 **defaultHyperParameterRanges**   <a name="personalize-Type-Algorithm-defaultHyperParameterRanges"></a>
Specifies the default hyperparameters, their ranges, and whether they are tunable\. A tunable hyperparameter can have its value determined during hyperparameter optimization \(HPO\)\.  
Type: [DefaultHyperParameterRanges](API_DefaultHyperParameterRanges.md) object  
Required: No

 **defaultHyperParameters**   <a name="personalize-Type-Algorithm-defaultHyperParameters"></a>
Specifies the default hyperparameters\.  
Type: String to string map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Value Length Constraints: Maximum length of 1000\.  
Required: No

 **defaultResourceConfig**   <a name="personalize-Type-Algorithm-defaultResourceConfig"></a>
Specifies the default maximum number of training jobs and parallel training jobs\.  
Type: String to string map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Value Length Constraints: Maximum length of 1000\.  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-Algorithm-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the algorithm was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-Algorithm-name"></a>
The name of the algorithm\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **roleArn**   <a name="personalize-Type-Algorithm-roleArn"></a>
The Amazon Resource Name \(ARN\) of the role\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **trainingInputMode**   <a name="personalize-Type-Algorithm-trainingInputMode"></a>
The training input mode\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_Algorithm_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/Algorithm) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/Algorithm) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/Algorithm) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/Algorithm) 
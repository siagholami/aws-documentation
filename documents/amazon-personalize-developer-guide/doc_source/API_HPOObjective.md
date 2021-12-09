# HPOObjective<a name="API_HPOObjective"></a>

The metric to optimize during hyperparameter optimization \(HPO\)\.

## Contents<a name="API_HPOObjective_Contents"></a>

 **metricName**   <a name="personalize-Type-HPOObjective-metricName"></a>
The name of the metric\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **metricRegex**   <a name="personalize-Type-HPOObjective-metricRegex"></a>
A regular expression for finding the metric in the training job logs\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **type**   <a name="personalize-Type-HPOObjective-type"></a>
The type of the metric\. Valid values are `Maximize` and `Minimize`\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_HPOObjective_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/HPOObjective) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/HPOObjective) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/HPOObjective) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/HPOObjective) 
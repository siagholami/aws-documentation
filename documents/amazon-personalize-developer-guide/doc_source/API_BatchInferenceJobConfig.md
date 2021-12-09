# BatchInferenceJobConfig<a name="API_BatchInferenceJobConfig"></a>

The configuration details of a batch inference job\.

## Contents<a name="API_BatchInferenceJobConfig_Contents"></a>

 **itemExplorationConfig**   <a name="personalize-Type-BatchInferenceJobConfig-itemExplorationConfig"></a>
A string to string map specifying the exploration configuration hyperparameters, including `explorationWeight` and `explorationItemAgeCutOff`, you want to use to configure the amount of item exploration Amazon Personalize uses when recommending items\. See [User\-Personalization Recipe](native-recipe-new-item-USER_PERSONALIZATION.md)\.  
Type: String to string map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Value Length Constraints: Maximum length of 1000\.  
Required: No

## See Also<a name="API_BatchInferenceJobConfig_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/BatchInferenceJobConfig) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/BatchInferenceJobConfig) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/BatchInferenceJobConfig) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/BatchInferenceJobConfig) 
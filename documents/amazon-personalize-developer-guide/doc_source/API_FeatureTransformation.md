# FeatureTransformation<a name="API_FeatureTransformation"></a>

Provides feature transformation information\. Feature transformation is the process of modifying raw input data into a form more suitable for model training\.

## Contents<a name="API_FeatureTransformation_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-FeatureTransformation-creationDateTime"></a>
The creation date and time \(in Unix time\) of the feature transformation\.  
Type: Timestamp  
Required: No

 **defaultParameters**   <a name="personalize-Type-FeatureTransformation-defaultParameters"></a>
Provides the default parameters for feature transformation\.  
Type: String to string map  
Map Entries: Maximum number of 100 items\.  
Key Length Constraints: Maximum length of 256\.  
Value Length Constraints: Maximum length of 1000\.  
Required: No

 **featureTransformationArn**   <a name="personalize-Type-FeatureTransformation-featureTransformationArn"></a>
The Amazon Resource Name \(ARN\) of the FeatureTransformation object\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-FeatureTransformation-lastUpdatedDateTime"></a>
The last update date and time \(in Unix time\) of the feature transformation\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-FeatureTransformation-name"></a>
The name of the feature transformation\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-FeatureTransformation-status"></a>
The status of the feature transformation\.  
A feature transformation can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_FeatureTransformation_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/FeatureTransformation) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/FeatureTransformation) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/FeatureTransformation) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/FeatureTransformation) 
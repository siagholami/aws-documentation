# Emotion<a name="API_Emotion"></a>

The emotions that appear to be expressed on the face, and the confidence level in the determination\. The API is only making a determination of the physical appearance of a person's face\. It is not a determination of the person’s internal emotional state and should not be used in such a way\. For example, a person pretending to have a sad face might not be sad emotionally\.

## Contents<a name="API_Emotion_Contents"></a>

 **Confidence**   <a name="rekognition-Type-Emotion-Confidence"></a>
Level of confidence in the determination\.  
Type: Float  
Valid Range: Minimum value of 0\. Maximum value of 100\.  
Required: No

 **Type**   <a name="rekognition-Type-Emotion-Type"></a>
Type of emotion detected\.  
Type: String  
Valid Values:` HAPPY | SAD | ANGRY | CONFUSED | DISGUSTED | SURPRISED | CALM | UNKNOWN | FEAR`   
Required: No

## See Also<a name="API_Emotion_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/rekognition-2016-06-27/Emotion) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/rekognition-2016-06-27/Emotion) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/rekognition-2016-06-27/Emotion) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/rekognition-2016-06-27/Emotion) 
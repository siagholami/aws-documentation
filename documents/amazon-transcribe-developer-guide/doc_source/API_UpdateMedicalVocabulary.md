# UpdateMedicalVocabulary<a name="API_UpdateMedicalVocabulary"></a>

Updates a vocabulary with new values that you provide in a different text file from the one you used to create the vocabulary\. The `UpdateMedicalVocabulary` operation overwrites all of the existing information with the values that you provide in the request\.

## Request Syntax<a name="API_UpdateMedicalVocabulary_RequestSyntax"></a>

```
{
   "LanguageCode": "string",
   "VocabularyFileUri": "string",
   "VocabularyName": "string"
}
```

## Request Parameters<a name="API_UpdateMedicalVocabulary_RequestParameters"></a>

For information about the parameters that are common to all actions, see [Common Parameters](CommonParameters.md)\.

The request accepts the following data in JSON format\.

 ** [LanguageCode](#API_UpdateMedicalVocabulary_RequestSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-request-LanguageCode"></a>
The language code of the language used for the entries in the updated vocabulary\. US English \(en\-US\) is the only valid language code in Amazon Transcribe Medical\.  
Type: String  
Valid Values:` af-ZA | ar-AE | ar-SA | cy-GB | da-DK | de-CH | de-DE | en-AB | en-AU | en-GB | en-IE | en-IN | en-US | en-WL | es-ES | es-US | fa-IR | fr-CA | fr-FR | ga-IE | gd-GB | he-IL | hi-IN | id-ID | it-IT | ja-JP | ko-KR | ms-MY | nl-NL | pt-BR | pt-PT | ru-RU | ta-IN | te-IN | tr-TR | zh-CN`   
Required: Yes

 ** [VocabularyFileUri](#API_UpdateMedicalVocabulary_RequestSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-request-VocabularyFileUri"></a>
The location in Amazon S3 of the text file that contains the you use for your custom vocabulary\. The URI must be in the same AWS Region as the resource that you are calling\. The following is the format for a URI:  
 ` https://s3.<aws-region>.amazonaws.com/<bucket-name>/<keyprefix>/<objectkey> `   
For example:  
 `https://s3.us-east-1.amazonaws.com/AWSDOC-EXAMPLE-BUCKET/vocab.txt`   
For more information about Amazon S3 object names, see [Object Keys](http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-keys) in the *Amazon S3 Developer Guide*\.  
For more information about custom vocabularies in Amazon Transcribe Medical, see [Medical Custom Vocabularies](http://docs.aws.amazon.com/transcribe/latest/dg/how-it-works.html#how-vocabulary)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2000\.  
Pattern: `(s3://|http(s*)://).+`   
Required: No

 ** [VocabularyName](#API_UpdateMedicalVocabulary_RequestSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-request-VocabularyName"></a>
The name of the vocabulary to update\. The name is case sensitive\. If you try to update a vocabulary with the same name as a vocabulary you've already made, you get a `ConflictException` error\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `^[0-9a-zA-Z._-]+`   
Required: Yes

## Response Syntax<a name="API_UpdateMedicalVocabulary_ResponseSyntax"></a>

```
{
   "LanguageCode": "string",
   "LastModifiedTime": number,
   "VocabularyName": "string",
   "VocabularyState": "string"
}
```

## Response Elements<a name="API_UpdateMedicalVocabulary_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [LanguageCode](#API_UpdateMedicalVocabulary_ResponseSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-response-LanguageCode"></a>
The language code for the language of the text file used to update the custom vocabulary\. US English \(en\-US\) is the only language supported in Amazon Transcribe Medical\.  
Type: String  
Valid Values:` af-ZA | ar-AE | ar-SA | cy-GB | da-DK | de-CH | de-DE | en-AB | en-AU | en-GB | en-IE | en-IN | en-US | en-WL | es-ES | es-US | fa-IR | fr-CA | fr-FR | ga-IE | gd-GB | he-IL | hi-IN | id-ID | it-IT | ja-JP | ko-KR | ms-MY | nl-NL | pt-BR | pt-PT | ru-RU | ta-IN | te-IN | tr-TR | zh-CN` 

 ** [LastModifiedTime](#API_UpdateMedicalVocabulary_ResponseSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-response-LastModifiedTime"></a>
The date and time that the vocabulary was updated\.  
Type: Timestamp

 ** [VocabularyName](#API_UpdateMedicalVocabulary_ResponseSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-response-VocabularyName"></a>
The name of the updated vocabulary\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `^[0-9a-zA-Z._-]+` 

 ** [VocabularyState](#API_UpdateMedicalVocabulary_ResponseSyntax) **   <a name="transcribe-UpdateMedicalVocabulary-response-VocabularyState"></a>
The processing state of the update to the vocabulary\. When the `VocabularyState` field is `READY`, the vocabulary is ready to be used in a `StartMedicalTranscriptionJob` request\.  
Type: String  
Valid Values:` PENDING | READY | FAILED` 

## Errors<a name="API_UpdateMedicalVocabulary_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **BadRequestException**   
Your request didn't pass one or more validation tests\. For example, if the entity that you're trying to delete doesn't exist or if it is in a non\-terminal state \(for example, it's "in progress"\)\. See the exception `Message` field for more information\.  
HTTP Status Code: 400

 **ConflictException**   
There is already a resource with that name\.  
HTTP Status Code: 400

 **InternalFailureException**   
There was an internal error\. Check the error message and try your request again\.  
HTTP Status Code: 500

 **LimitExceededException**   
Either you have sent too many requests or your input file is too long\. Wait before you resend your request, or use a smaller file and resend the request\.  
HTTP Status Code: 400

 **NotFoundException**   
We can't find the requested resource\. Check the name and try your request again\.  
HTTP Status Code: 400

## See Also<a name="API_UpdateMedicalVocabulary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/transcribe-2017-10-26/UpdateMedicalVocabulary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/transcribe-2017-10-26/UpdateMedicalVocabulary) 
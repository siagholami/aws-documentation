# TranscriptionJobSummary<a name="API_TranscriptionJobSummary"></a>

Provides a summary of information about a transcription job\.

## Contents<a name="API_TranscriptionJobSummary_Contents"></a>

 **CompletionTime**   <a name="transcribe-Type-TranscriptionJobSummary-CompletionTime"></a>
A timestamp that shows when the job was completed\.  
Type: Timestamp  
Required: No

 **ContentRedaction**   <a name="transcribe-Type-TranscriptionJobSummary-ContentRedaction"></a>
The content redaction settings of the transcription job\.  
Type: [ContentRedaction](API_ContentRedaction.md) object  
Required: No

 **CreationTime**   <a name="transcribe-Type-TranscriptionJobSummary-CreationTime"></a>
A timestamp that shows when the job was created\.  
Type: Timestamp  
Required: No

 **FailureReason**   <a name="transcribe-Type-TranscriptionJobSummary-FailureReason"></a>
If the `TranscriptionJobStatus` field is `FAILED`, a description of the error\.  
Type: String  
Required: No

 **IdentifiedLanguageScore**   <a name="transcribe-Type-TranscriptionJobSummary-IdentifiedLanguageScore"></a>
A value between zero and one that Amazon Transcribe assigned to the language it identified in the source audio\. A higher score indicates that Amazon Transcribe is more confident in the language it identified\.  
Type: Float  
Required: No

 **IdentifyLanguage**   <a name="transcribe-Type-TranscriptionJobSummary-IdentifyLanguage"></a>
Whether automatic language identification was enabled for a transcription job\.  
Type: Boolean  
Required: No

 **LanguageCode**   <a name="transcribe-Type-TranscriptionJobSummary-LanguageCode"></a>
The language code for the input speech\.  
Type: String  
Valid Values:` af-ZA | ar-AE | ar-SA | cy-GB | da-DK | de-CH | de-DE | en-AB | en-AU | en-GB | en-IE | en-IN | en-US | en-WL | es-ES | es-US | fa-IR | fr-CA | fr-FR | ga-IE | gd-GB | he-IL | hi-IN | id-ID | it-IT | ja-JP | ko-KR | ms-MY | nl-NL | pt-BR | pt-PT | ru-RU | ta-IN | te-IN | tr-TR | zh-CN`   
Required: No

 **ModelSettings**   <a name="transcribe-Type-TranscriptionJobSummary-ModelSettings"></a>
The object used to call your custom language model to your transcription job\.  
Type: [ModelSettings](API_ModelSettings.md) object  
Required: No

 **OutputLocationType**   <a name="transcribe-Type-TranscriptionJobSummary-OutputLocationType"></a>
Indicates the location of the output of the transcription job\.  
If the value is `CUSTOMER_BUCKET` then the location is the S3 bucket specified in the `outputBucketName` field when the transcription job was started with the `StartTranscriptionJob` operation\.  
If the value is `SERVICE_BUCKET` then the output is stored by Amazon Transcribe and can be retrieved using the URI in the `GetTranscriptionJob` response's `TranscriptFileUri` field\.  
Type: String  
Valid Values:` CUSTOMER_BUCKET | SERVICE_BUCKET`   
Required: No

 **StartTime**   <a name="transcribe-Type-TranscriptionJobSummary-StartTime"></a>
A timestamp that shows when the job started processing\.  
Type: Timestamp  
Required: No

 **TranscriptionJobName**   <a name="transcribe-Type-TranscriptionJobSummary-TranscriptionJobName"></a>
The name of the transcription job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `^[0-9a-zA-Z._-]+`   
Required: No

 **TranscriptionJobStatus**   <a name="transcribe-Type-TranscriptionJobSummary-TranscriptionJobStatus"></a>
The status of the transcription job\. When the status is `COMPLETED`, use the `GetTranscriptionJob` operation to get the results of the transcription\.  
Type: String  
Valid Values:` QUEUED | IN_PROGRESS | FAILED | COMPLETED`   
Required: No

## See Also<a name="API_TranscriptionJobSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/transcribe-2017-10-26/TranscriptionJobSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/transcribe-2017-10-26/TranscriptionJobSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/transcribe-2017-10-26/TranscriptionJobSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/transcribe-2017-10-26/TranscriptionJobSummary) 
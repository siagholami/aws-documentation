# TextTranslationJobProperties<a name="API_TextTranslationJobProperties"></a>

Provides information about a translation job\.

## Contents<a name="API_TextTranslationJobProperties_Contents"></a>

 **DataAccessRoleArn**   <a name="Translate-Type-TextTranslationJobProperties-DataAccessRoleArn"></a>
The Amazon Resource Name \(ARN\) of an AWS Identity Access and Management \(IAM\) role that granted Amazon Translate read access to the job's input data\.  
Type: String  
Length Constraints: Minimum length of 20\. Maximum length of 2048\.  
Pattern: `arn:aws(-[^:]+)?:iam::[0-9]{12}:role/.+`   
Required: No

 **EndTime**   <a name="Translate-Type-TextTranslationJobProperties-EndTime"></a>
The time at which the translation job ended\.  
Type: Timestamp  
Required: No

 **InputDataConfig**   <a name="Translate-Type-TextTranslationJobProperties-InputDataConfig"></a>
The input configuration properties that were specified when the job was requested\.  
Type: [InputDataConfig](API_InputDataConfig.md) object  
Required: No

 **JobDetails**   <a name="Translate-Type-TextTranslationJobProperties-JobDetails"></a>
The number of documents successfully and unsuccessfully processed during the translation job\.  
Type: [JobDetails](API_JobDetails.md) object  
Required: No

 **JobId**   <a name="Translate-Type-TextTranslationJobProperties-JobId"></a>
The ID of the translation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 32\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`   
Required: No

 **JobName**   <a name="Translate-Type-TextTranslationJobProperties-JobName"></a>
The user\-defined name of the translation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `^([\p{L}\p{Z}\p{N}_.:/=+\-%@]*)$`   
Required: No

 **JobStatus**   <a name="Translate-Type-TextTranslationJobProperties-JobStatus"></a>
The status of the translation job\.  
Type: String  
Valid Values:` SUBMITTED | IN_PROGRESS | COMPLETED | COMPLETED_WITH_ERROR | FAILED | STOP_REQUESTED | STOPPED`   
Required: No

 **Message**   <a name="Translate-Type-TextTranslationJobProperties-Message"></a>
An explanation of any errors that may have occured during the translation job\.  
Type: String  
Required: No

 **OutputDataConfig**   <a name="Translate-Type-TextTranslationJobProperties-OutputDataConfig"></a>
The output configuration properties that were specified when the job was requested\.  
Type: [OutputDataConfig](API_OutputDataConfig.md) object  
Required: No

 **SourceLanguageCode**   <a name="Translate-Type-TextTranslationJobProperties-SourceLanguageCode"></a>
The language code of the language of the source text\. The language must be a language supported by Amazon Translate\.  
Type: String  
Length Constraints: Minimum length of 2\. Maximum length of 5\.  
Required: No

 **SubmittedTime**   <a name="Translate-Type-TextTranslationJobProperties-SubmittedTime"></a>
The time at which the translation job was submitted\.  
Type: Timestamp  
Required: No

 **TargetLanguageCodes**   <a name="Translate-Type-TextTranslationJobProperties-TargetLanguageCodes"></a>
The language code of the language of the target text\. The language must be a language supported by Amazon Translate\.  
Type: Array of strings  
Array Members: Fixed number of 1 item\.  
Length Constraints: Minimum length of 2\. Maximum length of 5\.  
Required: No

 **TerminologyNames**   <a name="Translate-Type-TextTranslationJobProperties-TerminologyNames"></a>
A list containing the names of the terminologies applied to a translation job\. Only one terminology can be applied per [StartTextTranslationJob](API_StartTextTranslationJob.md) request at this time\.  
Type: Array of strings  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `^([A-Za-z0-9-]_?)+$`   
Required: No

## See Also<a name="API_TextTranslationJobProperties_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/translate-2017-07-01/TextTranslationJobProperties) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/translate-2017-07-01/TextTranslationJobProperties) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/translate-2017-07-01/TextTranslationJobProperties) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/translate-2017-07-01/TextTranslationJobProperties) 
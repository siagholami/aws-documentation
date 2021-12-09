# DefineAnalysisScheme<a name="API_DefineAnalysisScheme"></a>

## Description<a name="API_DefineAnalysisScheme_Description"></a>

Configures an analysis scheme that can be applied to a `text` or `text-array` field to define language\-specific text processing options\. For more information, see [Configuring Analysis Schemes](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-analysis-schemes.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DefineAnalysisScheme_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **AnalysisScheme**   
Configuration information for an analysis scheme\. Each analysis scheme has a unique name and specifies the language of the text to be processed\. The following options can be configured for an analysis scheme: `Synonyms`, `Stopwords`, `StemmingDictionary`, `JapaneseTokenizationDictionary` and `AlgorithmicStemming`\.  
Type: [AnalysisScheme](API_AnalysisScheme.md)   
 Required: Yes 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_DefineAnalysisScheme_ResponseElements"></a>

 The following element is returned in a structure named `DefineAnalysisSchemeResult`\. 

 **AnalysisScheme**   
The status and configuration of an `AnalysisScheme`\.  
Type: [AnalysisSchemeStatus](API_AnalysisSchemeStatus.md) 

## Errors<a name="API_DefineAnalysisScheme_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.  
 HTTP Status Code: 400

 **Internal**   
An internal error occurred while processing the request\. If this problem persists, report an issue from the [Service Health Dashboard](http://status.aws.amazon.com/)\.  
 HTTP Status Code: 500

 **InvalidType**   
The request was rejected because it specified an invalid type definition\.  
 HTTP Status Code: 409

 **LimitExceeded**   
The request was rejected because a resource limit has already been met\.  
 HTTP Status Code: 409

 **ResourceNotFound**   
The request was rejected because it attempted to reference a resource that does not exist\.  
 HTTP Status Code: 409
# DefineSuggester<a name="API_DefineSuggester"></a>

## Description<a name="API_DefineSuggester_Description"></a>

Configures a suggester for a domain\. A suggester enables you to display possible matches before users finish typing their queries\. When you configure a suggester, you must specify the name of the text field you want to search for possible matches and a unique name for the suggester\. For more information, see [Getting Search Suggestions](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/getting-suggestions.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DefineSuggester_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

 **Suggester**   
Configuration information for a search suggester\. Each suggester has a unique name and specifies the text field you want to use for suggestions\. The following options can be configured for a suggester: `FuzzyMatching`, `SortExpression`\.   
Type: [Suggester](API_Suggester.md)   
 Required: Yes 

## Response Elements<a name="API_DefineSuggester_ResponseElements"></a>

 The following element is returned in a structure named `DefineSuggesterResult`\. 

 **Suggester**   
The value of a `Suggester` and its current status\.  
Type: [SuggesterStatus](API_SuggesterStatus.md) 

## Errors<a name="API_DefineSuggester_Errors"></a>

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
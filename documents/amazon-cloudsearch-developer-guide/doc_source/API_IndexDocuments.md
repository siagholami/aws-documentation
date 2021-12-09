# IndexDocuments<a name="API_IndexDocuments"></a>

## Description<a name="API_IndexDocuments_Description"></a>

Tells the search domain to start indexing its documents using the latest indexing options\. This operation must be invoked to activate options whose [OptionStatus](API_OptionStatus.md) is `RequiresIndexDocuments`\.

## Request Parameters<a name="API_IndexDocuments_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_IndexDocuments_ResponseElements"></a>

 The following element is returned in a structure named `IndexDocumentsResult`\. 

 **FieldNames**   
The names of the fields that are currently being indexed\.  
Type: String list   
 Length constraints: Minimum length of 1\. Maximum length of 64\. 

## Errors<a name="API_IndexDocuments_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.  
 HTTP Status Code: 400

 **Internal**   
An internal error occurred while processing the request\. If this problem persists, report an issue from the [Service Health Dashboard](http://status.aws.amazon.com/)\.  
 HTTP Status Code: 500

 **ResourceNotFound**   
The request was rejected because it attempted to reference a resource that does not exist\.  
 HTTP Status Code: 409
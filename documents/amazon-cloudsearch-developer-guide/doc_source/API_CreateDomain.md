# CreateDomain<a name="API_CreateDomain"></a>

## Description<a name="API_CreateDomain_Description"></a>

Creates a new search domain\. For more information, see [Creating a Search Domain](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/creating-domains.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_CreateDomain_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A name for the domain you are creating\. Allowed characters are a\-z \(lower\-case letters\), 0\-9, and hyphen \(\-\)\. Domain names must start with a letter or number and be at least 3 and no more than 28 characters long\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_CreateDomain_ResponseElements"></a>

 The following element is returned in a structure named `CreateDomainResult`\. 

 **DomainStatus**   
The current status of the search domain\.  
Type: [DomainStatus](API_DomainStatus.md) 

## Errors<a name="API_CreateDomain_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.  
 HTTP Status Code: 400

 **Internal**   
An internal error occurred while processing the request\. If this problem persists, report an issue from the [Service Health Dashboard](http://status.aws.amazon.com/)\.  
 HTTP Status Code: 500

 **LimitExceeded**   
The request was rejected because a resource limit has already been met\.  
 HTTP Status Code: 409
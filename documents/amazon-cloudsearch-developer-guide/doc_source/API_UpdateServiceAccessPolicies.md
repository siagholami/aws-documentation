# UpdateServiceAccessPolicies<a name="API_UpdateServiceAccessPolicies"></a>

## Description<a name="API_UpdateServiceAccessPolicies_Description"></a>

Configures the access rules that control access to the domain's document and search endpoints\. For more information, see [ Configuring Access for an Amazon CloudSearch Domain](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-access.html)\.

## Request Parameters<a name="API_UpdateServiceAccessPolicies_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **AccessPolicies**   
The access rules you want to configure\. These rules replace any existing rules\.   
Type: String  
 Required: Yes 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_UpdateServiceAccessPolicies_ResponseElements"></a>

 The following element is returned in a structure named `UpdateServiceAccessPoliciesResult`\. 

 **AccessPolicies**   
The access rules configured for the domain\.  
Type: [AccessPoliciesStatus](API_AccessPoliciesStatus.md) 

## Errors<a name="API_UpdateServiceAccessPolicies_Errors"></a>

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
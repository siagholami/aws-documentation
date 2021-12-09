# DeleteDomain<a name="API_DeleteDomain"></a>

## Description<a name="API_DeleteDomain_Description"></a>

Permanently deletes a search domain and all of its data\. Once a domain has been deleted, it cannot be recovered\. For more information, see [Deleting a Search Domain](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/deleting-domains.html) in the *Amazon CloudSearch Developer Guide*\. 

## Request Parameters<a name="API_DeleteDomain_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
The name of the domain you want to permanently delete\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_DeleteDomain_ResponseElements"></a>

 The following element is returned in a structure named `DeleteDomainResult`\. 

 **DomainStatus**   
The current status of the search domain\.  
Type: [DomainStatus](API_DomainStatus.md) 

## Errors<a name="API_DeleteDomain_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.  
 HTTP Status Code: 400

 **Internal**   
An internal error occurred while processing the request\. If this problem persists, report an issue from the [Service Health Dashboard](http://status.aws.amazon.com/)\.  
 HTTP Status Code: 500
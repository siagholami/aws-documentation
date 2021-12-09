# UpdateDomainEndpointOptions<a name="API_UpdateDomainEndpointOptions"></a>

## Description<a name="API_UpdateDomainEndpointOptions_Description"></a>

Updates the domain's endpoint options, specifically whether all requests to the domain must arrive over HTTPS\. For more information, see [Configuring Domain Endpoint Options](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-domain-endpoint-options.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_UpdateDomainEndpointOptions_RequestParameters"></a>

**DomainName**  
A string that represents the name of a domain\.  
Type: String  
Required: Yes 

**DomainEndpointOptions**  
Container for the endpoint options\.  
Type: [DomainEndpointOptions](API_DomainEndpointOptions.md)   
Required: Yes

## Response Elements<a name="API_UpdateDomainEndpointOptions_ResponseElements"></a>

**DomainEndpointOptionsStatus**  
The status and configuration of a domain's endpoint options\.  
Type: [DomainEndpointOptionsStatus](API_DomainEndpointOptionsStatus.md) 

## Errors<a name="API_UpdateDomainEndpointOptions_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

**Base**  
An error occurred while processing the request\.  
HTTP Status Code: 400

**Internal**  
An internal error occurred while processing the request\. If this problem persists, report an issue from the [Service Health Dashboard](http://status.aws.amazon.com/)\.  
HTTP Status Code: 500

InvalidType  
The request was rejected because it specified an invalid type definition\.  
HTTP Status Code: 409

**LimitExceeded**  
The request was rejected because a resource limit has already been met\.  
HTTP Status Code: 409

**ResourceNotFound**  
The request was rejected because it attempted to reference a resource that does not exist\.  
HTTP Status Code: 409

**ValidationException**  
The request contains invalid input or is missing required input\.  
HTTP status code 400\.

 **DisabledOperation**   
The request was rejected because it attempted an operation which is not enabled\.  
HTTP Status Code: 409
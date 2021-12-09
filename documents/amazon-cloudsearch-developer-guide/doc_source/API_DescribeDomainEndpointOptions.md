# DescribeDomainEndpointOptions<a name="API_DescribeDomainEndpointOptions"></a>

## Description<a name="API_DescribeDomainEndpointOptions_Description"></a>

Returns the domain's endpoint options, specifically whether all requests to the domain must arrive over HTTPS\. For more information, see [Configuring Domain Endpoint Options](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-domain-endpoint-options.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DescribeDomainEndpointOptions_RequestParameters"></a>

For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\.

**DomainName**  
A string that represents the name of a domain\.  
Type: String  
Required: Yes

**deployed**  
Whether to retrieve the latest configuration \(which might be in a `Processing` state\) or the current, active configuration \(`?deployed=true`\)\.  
Type: Boolean  
Required: No

## Response Elements<a name="API_DescribeDomainEndpointOptions_ResponseElements"></a>

**DomainEndpointOptions**  
The status and configuration of a search domain's endpoint options\.  
Type: [DomainEndpointOptionsStatus](API_DomainEndpointOptionsStatus.md) 

## Errors<a name="API_DescribeDomainEndpointOptions_Errors"></a>

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

**ResourceNotFound**  
The request was rejected because it attempted to reference a resource that does not exist\.  
HTTP Status Code: 409
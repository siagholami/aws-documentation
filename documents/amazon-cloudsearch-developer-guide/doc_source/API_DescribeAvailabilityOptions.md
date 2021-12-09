# DescribeAvailabilityOptions<a name="API_DescribeAvailabilityOptions"></a>

## Description<a name="API_DescribeAvailabilityOptions_Description"></a>

Gets the availability options configured for a domain\. By default, shows the configuration with any pending changes\. Set the `Deployed` option to `true` to show the active configuration and exclude pending changes\. For more information, see [Configuring Availability Options](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-availability-options.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DescribeAvailabilityOptions_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **Deployed**   
Whether to display the deployed configuration \(`true`\) or include any pending changes \(`false`\)\. Defaults to `false`\.  
Type: Boolean  
 Required: No 

 **DomainName**   
The name of the domain you want to describe\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_DescribeAvailabilityOptions_ResponseElements"></a>

 The following element is returned in a structure named `DescribeAvailabilityOptionsResult`\. 

 **AvailabilityOptions**   
The availability options configured for the domain\. Indicates whether Multi\-AZ is enabled for the domain\.   
Type: [AvailabilityOptionsStatus](API_AvailabilityOptionsStatus.md) 

## Errors<a name="API_DescribeAvailabilityOptions_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.  
 HTTP Status Code: 400

 **DisabledOperation**   
The request was rejected because it attempted an operation which is not enabled\.  
 HTTP Status Code: 409

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
# UpdateAvailabilityOptions<a name="API_UpdateAvailabilityOptions"></a>

## Description<a name="API_UpdateAvailabilityOptions_Description"></a>

Configures the availability options for a domain\. Enabling the Multi\-AZ option expands an Amazon CloudSearch domain to an additional Availability Zone in the same Region to increase fault tolerance in the event of a service disruption\. Changes to the Multi\-AZ option can take about half an hour to become active\. For more information, see [Configuring Availability Options](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-availability-options.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_UpdateAvailabilityOptions_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

 **MultiAZ**   
You expand an existing search domain to a second Availability Zone by setting the Multi\-AZ option to true\. Similarly, you can turn off the Multi\-AZ option to downgrade the domain to a single Availability Zone by setting the Multi\-AZ option to `false`\.   
Type: Boolean  
 Required: Yes 

## Response Elements<a name="API_UpdateAvailabilityOptions_ResponseElements"></a>

 The following element is returned in a structure named `UpdateAvailabilityOptionsResult`\. 

 **AvailabilityOptions**   
The newly\-configured availability options\. Indicates whether Multi\-AZ is enabled for the domain\.   
Type: [AvailabilityOptionsStatus](API_AvailabilityOptionsStatus.md) 

## Errors<a name="API_UpdateAvailabilityOptions_Errors"></a>

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
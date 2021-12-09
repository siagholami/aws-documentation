# UpdateScalingParameters<a name="API_UpdateScalingParameters"></a>

## Description<a name="API_UpdateScalingParameters_Description"></a>

Configures scaling parameters for a domain\. A domain's scaling parameters specify the desired search instance type and replication count\. Amazon CloudSearch will still automatically scale your domain based on the volume of data and traffic, but not below the desired instance type and replication count\. If the Multi\-AZ option is enabled, these values control the resources used per Availability Zone\. For more information, see [Configuring Scaling Options](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-scaling-options.html) in the *Amazon CloudSearch Developer Guide*\. 

## Request Parameters<a name="API_UpdateScalingParameters_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

 **ScalingParameters**   
The desired instance type and desired number of replicas of each index partition\.  
Type: [ScalingParameters](API_ScalingParameters.md)   
 Required: Yes 

## Response Elements<a name="API_UpdateScalingParameters_ResponseElements"></a>

 The following element is returned in a structure named `UpdateScalingParametersResult`\. 

 **ScalingParameters**   
The status and configuration of a search domain's scaling parameters\.   
Type: [ScalingParametersStatus](API_ScalingParametersStatus.md) 

## Errors<a name="API_UpdateScalingParameters_Errors"></a>

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
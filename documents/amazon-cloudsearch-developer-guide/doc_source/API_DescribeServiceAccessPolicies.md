# DescribeServiceAccessPolicies<a name="API_DescribeServiceAccessPolicies"></a>

## Description<a name="API_DescribeServiceAccessPolicies_Description"></a>

Gets information about the access policies that control access to the domain's document and search endpoints\. By default, shows the configuration with any pending changes\. Set the `Deployed` option to `true` to show the active configuration and exclude pending changes\. For more information, see [Configuring Access for a Search Domain](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-access.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DescribeServiceAccessPolicies_RequestParameters"></a>

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

## Response Elements<a name="API_DescribeServiceAccessPolicies_ResponseElements"></a>

 The following element is returned in a structure named `DescribeServiceAccessPoliciesResult`\. 

 **AccessPolicies**   
The access rules configured for the domain specified in the request\.  
Type: [AccessPoliciesStatus](API_AccessPoliciesStatus.md) 

## Errors<a name="API_DescribeServiceAccessPolicies_Errors"></a>

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
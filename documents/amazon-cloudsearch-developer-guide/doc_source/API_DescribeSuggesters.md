# DescribeSuggesters<a name="API_DescribeSuggesters"></a>

## Description<a name="API_DescribeSuggesters_Description"></a>

Gets the suggesters configured for a domain\. A suggester enables you to display possible matches before users finish typing their queries\. Can be limited to specific suggesters by name\. By default, shows all suggesters and includes any pending changes to the configuration\. Set the `Deployed` option to `true` to show the active configuration and exclude pending changes\. For more information, see [Getting Search Suggestions](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/getting-suggestions.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DescribeSuggesters_RequestParameters"></a>

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

 **SuggesterNames\.member\.N**   
The suggesters you want to describe\.  
Type: String list   
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: No 

## Response Elements<a name="API_DescribeSuggesters_ResponseElements"></a>

 The following element is returned in a structure named `DescribeSuggestersResult`\. 

 **Suggesters**   
The suggesters configured for the domain specified in the request\.  
Type: [SuggesterStatus](API_SuggesterStatus.md) list 

## Errors<a name="API_DescribeSuggesters_Errors"></a>

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
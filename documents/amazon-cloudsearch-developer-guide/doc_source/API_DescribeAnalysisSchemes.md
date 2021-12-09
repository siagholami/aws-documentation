# DescribeAnalysisSchemes<a name="API_DescribeAnalysisSchemes"></a>

## Description<a name="API_DescribeAnalysisSchemes_Description"></a>

Gets the analysis schemes configured for a domain\. An analysis scheme defines language\-specific text processing options for a `text` field\. Can be limited to specific analysis schemes by name\. By default, shows all analysis schemes and includes any pending changes to the configuration\. Set the `Deployed` option to `true` to show the active configuration and exclude pending changes\. For more information, see [Configuring Analysis Schemes](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-analysis-schemes.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DescribeAnalysisSchemes_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **AnalysisSchemeNames\.member\.N**   
The analysis schemes you want to describe\.  
Type: String list   
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: No 

 **Deployed**   
Whether to display the deployed configuration \(`true`\) or include any pending changes \(`false`\)\. Defaults to `false`\.  
Type: Boolean  
 Required: No 

 **DomainName**   
The name of the domain you want to describe\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

## Response Elements<a name="API_DescribeAnalysisSchemes_ResponseElements"></a>

 The following element is returned in a structure named `DescribeAnalysisSchemesResult`\. 

 **AnalysisSchemes**   
The analysis scheme descriptions\.  
Type: [AnalysisSchemeStatus](API_AnalysisSchemeStatus.md) list 

## Errors<a name="API_DescribeAnalysisSchemes_Errors"></a>

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
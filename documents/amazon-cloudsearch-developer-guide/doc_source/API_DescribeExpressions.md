# DescribeExpressions<a name="API_DescribeExpressions"></a>

## Description<a name="API_DescribeExpressions_Description"></a>

Gets the expressions configured for the search domain\. Can be limited to specific expressions by name\. By default, shows all expressions and includes any pending changes to the configuration\. Set the `Deployed` option to `true` to show the active configuration and exclude pending changes\. For more information, see [Configuring Expressions](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-expressions.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DescribeExpressions_RequestParameters"></a>

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

 **ExpressionNames\.member\.N**   
Limits the ` DescribeExpressions ` response to the specified expressions\. If not specified, all expressions are shown\.  
Type: String list   
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: No 

## Response Elements<a name="API_DescribeExpressions_ResponseElements"></a>

 The following element is returned in a structure named `DescribeExpressionsResult`\. 

 **Expressions**   
The expressions configured for the domain\.  
Type: [ExpressionStatus](API_ExpressionStatus.md) list 

## Errors<a name="API_DescribeExpressions_Errors"></a>

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
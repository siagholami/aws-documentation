# DefineExpression<a name="API_DefineExpression"></a>

## Description<a name="API_DefineExpression_Description"></a>

Configures an ` Expression ` for the search domain\. Used to create new expressions and modify existing ones\. If the expression exists, the new configuration replaces the old one\. For more information, see [Configuring Expressions](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-expressions.html) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_DefineExpression_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

 **Expression**   
A named expression that can be evaluated at search time\. Can be used to sort the search results, define other expressions, or return computed information in the search results\.   
Type: [Expression](API_Expression.md)   
 Required: Yes 

## Response Elements<a name="API_DefineExpression_ResponseElements"></a>

 The following element is returned in a structure named `DefineExpressionResult`\. 

 **Expression**   
The value of an `Expression` and its current status\.  
Type: [ExpressionStatus](API_ExpressionStatus.md) 

## Errors<a name="API_DefineExpression_Errors"></a>

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
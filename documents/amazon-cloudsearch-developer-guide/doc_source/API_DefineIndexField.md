# DefineIndexField<a name="API_DefineIndexField"></a>

## Description<a name="API_DefineIndexField_Description"></a>

Configures an ` IndexField ` for the search domain\. Used to create new fields and modify existing ones\. You must specify the name of the domain you are configuring and an index field configuration\. The index field configuration specifies a unique name, the index field type, and the options you want to configure for the field\. The options you can specify depend on the ` IndexFieldType `\. If the field exists, the new configuration replaces the old one\. For more information, see [Configuring Index Fields](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-index-fields.html) in the *Amazon CloudSearch Developer Guide*\. 

## Request Parameters<a name="API_DefineIndexField_RequestParameters"></a>

 For information about the common parameters that all actions use, see [Common Parameters](CommonParameters.md)\. 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

 **IndexField**   
The index field and field options you want to configure\.   
Type: [IndexField](API_IndexField.md)   
 Required: Yes 

## Response Elements<a name="API_DefineIndexField_ResponseElements"></a>

 The following element is returned in a structure named `DefineIndexFieldResult`\. 

 **IndexField**   
The value of an `IndexField` and its current status\.  
Type: [IndexFieldStatus](API_IndexFieldStatus.md) 

## Errors<a name="API_DefineIndexField_Errors"></a>

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
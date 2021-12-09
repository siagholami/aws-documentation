# AccessPoliciesStatus<a name="API_AccessPoliciesStatus"></a>

## Description<a name="API_AccessPoliciesStatus_Description"></a>

The configured access rules for the domain's document and search endpoints, and the current status of those rules\.

## Contents<a name="API_AccessPoliciesStatus_Contents"></a>

 **Options**   
Access rules for a domain's document or search service endpoints\. For more information, see [Configuring Access for a Search Domain](http://docs.aws.amazon.com/cloudsearch/latest/developerguide/configuring-access.html) in the *Amazon CloudSearch Developer Guide*\. The maximum size of a policy document is 100 KB\.  
Type: String  
 Required: Yes 

 **Status**   
The status of domain configuration option\.  
Type: [OptionStatus](API_OptionStatus.md)   
 Required: Yes 
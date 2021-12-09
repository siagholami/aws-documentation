# DomainStatus<a name="API_DomainStatus"></a>

## Description<a name="API_DomainStatus_Description"></a>

The current status of the search domain\.

## Contents<a name="API_DomainStatus_Contents"></a>

 **ARN**   
The Amazon Resource Name \(ARN\) of the search domain\. See [Identifiers for IAM Entities](http://docs.aws.amazon.com/IAM/latest/UserGuide/index.html?Using_Identifiers.html) in *Using AWS Identity and Access Management* for more information\.  
Type: String  
 Required: No 

 **Created**   
True if the search domain is created\. It can take several minutes to initialize a domain when [CreateDomain](API_CreateDomain.md) is called\. Newly created search domains are returned from [DescribeDomains](API_DescribeDomains.md) with a false value for Created until domain creation is complete\.  
Type: Boolean  
 Required: No 

 **Deleted**   
True if the search domain has been deleted\. The system must clean up resources dedicated to the search domain when [DeleteDomain](API_DeleteDomain.md) is called\. Newly deleted search domains are returned from [DescribeDomains](API_DescribeDomains.md) with a true value for IsDeleted for several minutes until resource cleanup is complete\.  
Type: Boolean  
 Required: No 

 **DocService**   
The service endpoint for updating documents in a search domain\.  
Type: [ServiceEndpoint](API_ServiceEndpoint.md)   
 Required: No 

 **DomainId**   
An internally generated unique identifier for a domain\.  
Type: String  
 Length constraints: Minimum length of 1\. Maximum length of 64\.   
 Required: Yes 

 **DomainName**   
A string that represents the name of a domain\. Domain names are unique across the domains owned by an account within an AWS region\. Domain names start with a letter or number and can contain the following characters: a\-z \(lowercase\), 0\-9, and \- \(hyphen\)\.  
Type: String  
 Length constraints: Minimum length of 3\. Maximum length of 28\.   
 Required: Yes 

 **Limits**   
Type: [Limits](API_Limits.md)   
 Required: No 

 **Processing**   
True if processing is being done to activate the current domain configuration\.  
Type: Boolean  
 Required: No 

 **RequiresIndexDocuments**   
True if [IndexDocuments](API_IndexDocuments.md) needs to be called to activate the current domain configuration\.  
Type: Boolean  
 Required: Yes 

 **SearchInstanceCount**   
The number of search instances that are available to process search requests\.  
Type: Integer  
 Required: No 

 **SearchInstanceType**   
The instance type that is being used to process search requests\.  
Type: String  
 Required: No 

 **SearchPartitionCount**   
The number of partitions across which the search index is spread\.  
Type: Integer  
 Required: No 

 **SearchService**   
The service endpoint for requesting search results from a search domain\.  
Type: [ServiceEndpoint](API_ServiceEndpoint.md)   
 Required: No 
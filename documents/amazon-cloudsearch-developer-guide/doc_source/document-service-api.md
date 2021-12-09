# Document Service API Reference for Amazon CloudSearch<a name="document-service-api"></a>

You use the document service API to add, replace, or delete documents in your Amazon CloudSearch domain\. For more information managing the documents in your search domain, see [Uploading Data to an Amazon CloudSearch Domain](uploading-data.md)\.

 The other APIs you use to interact with Amazon CloudSearch are: 
+ [Configuration API Reference for Amazon CloudSearch ](configuration-api.md)—Set up and manage your search domain\.
+ [Search API Reference](search-api.md)—Search your domain\.

## Submitting Document Service Requests in Amazon CloudSearch<a name="submitting-document-requests-api"></a>

**Important**  
Before uploading data to an Amazon CloudSearch domain, follow these guidelines:  
Group documents into *batches* before you upload them\. Continuously uploading batches that consist of only one document has a huge, negative impact on the speed at which Amazon CloudSearch can process your updates\. Instead, create batches that are as close to the limit as possible and upload them less frequently\. For more information on maximum batch size and upload frequency, see [Understanding Amazon CloudSearch Limits](limits.md)\.
A domain's document and search endpoints remain the same for the life of the domain\. You should cache the endpoints rather than retrieving them before every upload or search request\. Querying the Amazon CloudSearch configuration service by calling `aws cloudsearch describe-domains` or `DescribeDomains` before every request will likely result in your requests being throttled\.

We recommend using one of the AWS SDKs or the AWS CLI to submit document upload requests\. The SDKs and AWS CLI handle request signing for you and provide an easy way to perform all Amazon CloudSearch actions\. You can also use the Amazon CloudSearch console to upload individual batches and import data from DynamoDB or S3\.

For example, the following request uploads a batch using the AWS CLI\.

```
aws cloudsearchdomain --endpoint-url http://doc-movies-y6gelr4lv3jeu4rvoelunxsl2e.us-east-1.cloudsearch.amazonaws.com upload-documents --content-type
 application/json --documents movie-data-2013.json
```

For development and testing purposes, you can allow anonymous access to your domain's document service and submit unsigned HTTP POST requests directly to your domain's document service\. In a production environment, restrict access to your domain to specific IAM users, groups, or roles and submit signed requests\. For information about controlling access for Amazon CloudSearch, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\. For more information about request signing, see [Signing AWS API Requests](https://docs.aws.amazon.com/general/latest/gr/signing_aws_api_requests.html)\. 

For example, the following POST request uploads a batch of documents formatted in JSON to the domain endpoint doc\-movies\-123456789012\.us\-east\-1\.cloudsearch\.amazonaws\.com\.

```
curl -X POST --upload-file data1.json doc-movies-123456789012.us-east-1.cloudsearch.amazonaws.com/2013-01-01/documents/batch --header "Content-Type: application/json"
```
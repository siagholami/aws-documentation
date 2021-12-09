# AddTags<a name="API_AddTags"></a>

## Description<a name="API_AddTags_Description"></a>

Attaches resource tags to an Amazon CloudSearch domain\. For more information, see [Tagging Amazon CloudSearch Domains](tagging-cloudsearch-domains.md) in the *Amazon CloudSearch Developer Guide*\. Use the `GET` HTTP method with this action\. 

## Request Parameters<a name="API_AddTags_RequestParameters"></a>

`ARN`

Amazon Resource Name \(ARN\) for the Amazon CloudSearch domain to which you want to attach resource tags\. For more information, see [IAM ARNs](http://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns) in the *AWS Identity and Access Management* documentation\.

Type: String

Required: Yes

`TagList`

List of resource tags for the specified Amazon CloudSearch domain\.

Type: TagList, a list of strings specifying the resource tags for the domain\.

Required: Yes

## Response Elements<a name="API_AddTags_ResponseElements"></a>

 Not applicable\. The `AddTags` action does not return a data structure\.

## Errors<a name="API_AddTags_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.

LimitExceededException  
The request contains more than the allowed number and type of Amazon CloudSearch domain resources\. Returns HTTP status code 409\.

ValidationException  
The request contains invalid input or is missing required input\. Returns HTTP status code 400\.

InternalException  
The processing of the request failed because of an internal service error\. Returns HTTP status code 500\.

## Example<a name="w3ab1c28b7c14b7c10"></a>

The following example attaches a single resource tag with a tag key of `project` to the `logs` Amazon CloudSearch domain in the us\-west\-2 region:

Request

```
GET https://cloudsearch.us-west-2.amazonaws.com?Action=AddTags&ARN=arn:aws:cloudsearch:us-west-2:408853051459:domain/logs&TagList.Tag.1.Key='environment'
&TagList.Tag.1.Value='production'&Version=2013-01-01
```

Response

```
<AddTagsResponse xmlns="http://cloudsearch.amazonaws.com/doc/2013-01-01/">
  <ResponseMetadata>
    <RequestId>5646a576-d1ee-11e5-bc4d-27ea242580ce</RequestId>
  </ResponseMetadata>
</AddTagsResponse>
```
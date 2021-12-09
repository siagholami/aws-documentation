# RemoveTags<a name="API_RemoveTags"></a>

## Description<a name="API_RemoveTags_Description"></a>

Removes the specified resource tags from an Amazon ES domain\. For more information, see [Tagging Amazon CloudSearch Domains](tagging-cloudsearch-domains.md) in the *Amazon CloudSearch Developer Guide*\. Use the `GET` HTTP method with this action\. 

## Request Parameters<a name="API_RemoveTags_RequestParameters"></a>

`ARN`

Amazon Resource Name \(ARN\) for the Amazon CloudSearch domain to which you want to attach resource tags\. For more information, see [IAM ARNs](http://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns) in the *AWS Identity and Access Management* documentation\.

Type: String

Required: Yes

`TagKeys`

List of `TagKey` elements for the resource tags that you want to remove from an Amazon CloudSearch domain\. A `TagKey` element is a string with a maximum of 128 characters that contains the name of the resource tag\.

## Response Elements<a name="API_RemoveTags_ResponseElements"></a>

 This operation does not return a response element\.

## Errors<a name="API_RemoveTags_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.

ValidationException  
The request contains invalid input or is missing required input\. Returns HTTP status code 400\.

InternalException  
The processing of the request failed because of an internal service error\. Returns HTTP status code 500\.

## Example<a name="w3ab1c28b7c14c81c10"></a>

The following example deletes a resource tag with a tag key of `project` from the `logs` Amazon CloudSearch domain in the us\-west\-2 region:

```
GET https://cloudsearch.us-west-2.amazonaws.com?Action=RemoveTags&ARN=arn:aws:cloudsearch:us-west-2:408853051459:domain/logs&TagKeys.member.1='environment'&Version=2013-01-01
```

Response

```
<RemoveTagsResponse xmlns="http://cloudsearch.amazonaws.com/doc/2013-01-01/">
  <ResponseMetadata>
    <RequestId>2bf75153-d1f1-11e5-8f64-f17d14275591</RequestId>
  </ResponseMetadata>
</RemoveTagsResponse>
```
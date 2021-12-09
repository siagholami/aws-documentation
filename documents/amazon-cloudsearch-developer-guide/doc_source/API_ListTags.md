# ListTags<a name="API_ListTags"></a>

## Description<a name="API_ListTags_Description"></a>

Displays all of the resource tags for an Amazon CloudSearch domain\. Use the `GET` HTTP method with this action\. For more information, see [Tagging Amazon CloudSearch Domains](tagging-cloudsearch-domains.md) in the *Amazon CloudSearch Developer Guide*\.

## Request Parameters<a name="API_ListTags_RequestParameters"></a>

`ARN`

Amazon Resource Name \(ARN\) for the Amazon CloudSearch domain to which you want to attach resource tags\. For more information, see [IAM ARNs](http://docs.aws.amazon.com/IAM/latest/UserGuide/reference_identifiers.html#identifiers-arns) in the *AWS Identity and Access Management* documentation\.

Type: String

Required: Yes

## Response Elements<a name="API_ListTags_ResponseElements"></a>

 `TagList`

List of resource tags for the specified Amazon CloudSearch domain\.

Type: TagList, a list of strings specifying the resource tags for the domain\.

## Errors<a name="API_ListTags_Errors"></a>

 For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\. 

 **Base**   
An error occurred while processing the request\.

LimitExceededException  
The request contains more than the allowed number and type of Amazon CloudSearch domain resources\. Returns HTTP status code 409\.

ValidationException  
The request contains invalid input or is missing required input\. Returns HTTP status code 400\.

InternalException  
The processing of the request failed because of an internal service error\. Returns HTTP status code 500\.

## Example<a name="w3ab1c28b7c14c77c10"></a>

The following example lists the tags attached to the `logs` Amazon CloudSearch domain in the us\-west\-2 region:

```
GET https://cloudsearch.us-west-2.amazonaws.com?Action=ListTags&ARN=arn:aws:cloudsearch:us-west-2:408853051459:domain/logs&Version=2013-01-01
```

The operation returns the following response:

```
<ListTagsResponse xmlns="http://cloudsearch.amazonaws.com/doc/2013-01-01/">
  <ListTagsResult>
    <TagList>
      <member>
        <Value>environment</Value>
        <Key>production</Key>
      </member>
    </TagList>
  </ListTagsResult>
  <ResponseMetadata>
    <RequestId>29948ea4-d1dc-11e5-8914-51ab8964f46d</RequestId>
  </ResponseMetadata>
</ListTagsResponse>
```
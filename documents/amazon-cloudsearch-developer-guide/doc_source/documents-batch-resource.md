# documents/batch<a name="documents-batch-resource"></a>

This section describes the HTTP request and response messages for the `documents/batch` resource\. 

You create document batches to describe the data that you want to upload to an Amazon CloudSearch domain\. A document batch is a collection of add and delete operations that represent the documents you want to add, update, or delete from your domain\. Batches can be described in either JSON or XML\. A batch provides all of the information Amazon CloudSearch needs for indexing\. Each item that you want to be able to return as a search result \(such as a product\) is represented as a document—a batch is simply a collection of add and delete requests for individual documents\. Every document has a unique ID and one or more fields that contain the data that you want to search and return in results\. 

To update a document, you specify an add request with the document ID of the document you want to update\. For more information, see [Adding and Updating Documents in Amazon CloudSearch](preparing-data.md#adding-documents)\. Similarly, to delete a document, you submit a delete request with the document ID of the document you want to delete\. For information about deleting documents, see [Deleting Documents in Amazon CloudSearch](preparing-data.md#deleting-documents)\.

For more information about submitting data for indexing, see [Uploading Data to an Amazon CloudSearch Domain](uploading-data.md)\.

## documents/batch JSON API<a name="documents-batch-json"></a>

### JSON documents/batch Requests<a name="documents-batch-json-request"></a>

The body of a `documents/batch` request uses JSON or XML to specify the document operations you want to perform\. A JSON representation of a batch is a collection of objects that define individual add and delete operations\. The `type` property identifies whether an object represents an add or delete operation\. For example, the following JSON batch adds one document and deletes one document:

```
[
{ "type": "add",
  "id":   "tt0484562",
  "fields": {
    "title": "The Seeker: The Dark Is Rising",
    "directors": ["Cunningham, David L."],
    "genres": ["Adventure","Drama","Fantasy","Thriller"],
    "actors": ["McShane, Ian","Eccleston, Christopher","Conroy, Frances",
              "Crewson, Wendy","Ludwig, Alexander","Cosmo, James",
              "Warner, Amelia","Hickey, John Benjamin","Piddock, Jim",
              "Lockhart, Emma"]
  }
},
{ "type": "delete",
  "id":   "tt0484575"
}]
```

**Note**  
When specifying document batches in JSON, the value for a field cannot be `null`\.

The [JSON schema](http://json-schema.org/) representation of a batch is shown below:

```
{
    "type": "array",
    "minItems": 1,
    "items": {
        "type": "object",
        "properties": {
            "type": {
                "type": "string",
                "enum": ["add", "delete"],
                "required": true
            },
            "id": {
                "type": "string",
                "pattern": "[a-z0-9][a-z0-9_]{0,127}",
                "minLength": 1,
                "maxLength": 128,
                "required": true
            },
            "fields": {
                "type": "object",
                "patternProperties": {
                    "[a-zA-Z0-9][a-zA-Z0-9_]{0,63}": {
                        "type": "string",
                    }
                }
            }
        }
    }
}
```

#### documents/batch Request Properties \(JSON\)<a name="documents-batch-json-properties"></a>


****  

| Property | Description | Required | 
| --- | --- | --- | 
| type | The operation type, add or delete\.  | Yes | 
| id | An alphanumeric string\. Allowed characters are: A\-Z \(upper\-case letters\), \-a\-z \(lower\-case letters\), 0\-9, \_ \(underscore\), \- \(hyphen\), / \(forward slash\), \# \(hash sign\), : \(colon\)\. The max length is 128 characters\. | Yes | 
| fields | A collection of one or more field\_name properties that define the fields the document contains\. Condition: Required for add operations\. Must contain at least one *field\_name* property\.  | Conditional | 
| field\_name | Specifies a field within the document being added\. Field names must begin with a letter and can contain the following characters: a\-z \(lower case\), 0\-9, and \_ \(underscore\)\. Field names must be at least 3 and no more than 64 characters\. The name score is reserved and cannot be used as a field name\.  To specify multiple values for a field, you specify an array of values instead of a single value\. For example: `"genre": ["Adventure","Drama","Fantasy","Thriller"]`  Condition: At least one field must be specified in the fields object\.  | Conditional | 

### documents/batch Response \(JSON\)<a name="documents-batch-json-response"></a>

The response body lists the number of adds and deletes that were performed and any errors or warnings that were generated\. 

The JSON schema representation of a document service API response is shown below:

```
{
    "type": "object",
    "properties": {
        "status": {
            "type": "text",
            "enum": ["success", "error"],
            "required": true
        },
        "adds": {
            "type": "integer",
            "minimum": 0,
            "required": true
        },
        "deletes": {
            "type": "integer",
            "minimum": 0,
            "required": true
        },
        "errors": {
            "type": "array",
            "required": false,
            "items": {
                "type": "object",
                "properties": {
                    "message": {
                        "type": "string",
                        "required": true
                    }
                }
            }
        },
        "warnings": {
            "type": "array",
            "required": false,
            "items": {
                "type": "object",
                "properties": {
                    "message": {
                        "type": "string",
                        "required": true
                    }
                }
            }
        }
    }
}
```

#### documents/batch Response Properties \(JSON\)<a name="documents-batch-json-response-properties"></a>


****  

| Property | Description | 
| --- | --- | 
| status | The result status, which is either success or error\.  | 
| adds | The number of add document operations that were performed\. Always zero when the status is error\.  | 
| deletes | The number of delete document operations that were performed\. Always zero when the status is error\. For information on permanently deleting documents, see [Deleting Documents in Amazon CloudSearch](preparing-data.md#deleting-documents)\. | 
| errors | Provides information about a parsing or validation error\. Specified only if the status is error\.  | 
| warning | Provides information about a warning generated during parsing or validation\.  | 

## documents/batch Status Codes<a name="documents-batch-status-codes"></a>

A document service request can return three types of status codes:
+ 5xx status codes indicate that there was an internal server error\. We recommend catching and retrying all 5xx error codes as they typically represent transient error conditions\.
+ 4xx status codes indicate that the request was malformed\.
+ 2xx status codes indicate that the request was processed successfully\.


****  

|  Error  |  Description  | HTTP Status Code  | 
| --- | --- | --- | 
|  No Content\-Type  |  The Content\-Type header is missing\.  |  400  | 
|  No Content\-Length  |  The Content\-Length header is missing\.  |  411  | 
|  Incorrect Path  |  URL path does not match ''/YYYY\-MM\-DD/documents/batch''\.  |  404  | 
|  Invalid HTTP Method  |  The HTTP method is not POST\. Requests must be posted to documents/batch\.  |  405  | 
|  Invalid Accept Type  |  Accept header specifies a content type other than ''application/xml'' or ''application/json''\. Responses can be sent only as XML or JSON\.  |  406  | 
|  Request Too Large  |  The length of the request body is larger than the maximum allowed value\.  |  413  | 
|  Invalid Content Type  |  The content type is something other than "application/json" or "application/xml"\.  |  415  | 
|  Invalid Character Set  |  The character set is something other than ''ASCII'', ''ISO\-8859\-1'', or ''UTF\-8''\.  |  415  | 

## Common Request Headers<a name="documents-batch-common-request-headers"></a>


****  

| Name | Description | Required | 
| --- | --- | --- | 
| Content\-Type | A standard MIME type describing the format of the object data\. For more information, see [W3C RFC 2616 Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17)\. Default: application/json  Constraints: application/json or application/xml only  | Required | 
| Content\-Length | The length in bytes of the body of the request\.  | Yes | 
| Accept | A standard MIME type describing the format of the response data\. For more information, see [W3C RFC 2616 Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17)\. Default: the content\-type of the request Constraints: application/json or application/xml only | No | 

## Common Response Headers<a name="documents-batch-common-response-headers"></a>


****  

| Name | Description | 
| --- | --- | 
| Content\-Type | A standard MIME type describing the format of the object data\. For more information, see [W3C RFC 2616 Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17)\. Default: the value of the Accept header in the request, or the Content\-Type of the request if the Accept header is missing or doesn't specify either application/xml or application/json\. Constraints: application/xml or application/json only  | 
| Content\-Length | The length in bytes of the body in the response\.  | 
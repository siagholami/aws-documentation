# Delete Preset<a name="delete-preset"></a>

**Topics**
+ [Description](#delete-preset-description)
+ [Requests](#delete-preset-requests)
+ [Responses](#delete-preset-responses)
+ [Errors](#delete-preset-response-errors)
+ [Examples](#delete-preset-examples)

## Description<a name="delete-preset-description"></a>

To delete a preset, send a DELETE request to the `/2012-09-25/presets/presetId` resource\.

**Note**  
If the preset has been used, you cannot delete it\.

## Requests<a name="delete-preset-requests"></a>

### Syntax<a name="delete-preset-request-syntax"></a>

```
DELETE /2012-09-25/presets/[presetId](#delete-preset-request-preset-id) HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Request Parameters<a name="delete-preset-request-parameters"></a>

This operation takes the following request parameter\. 

**presetId**  
The identifier of the preset for which you want to get detailed information\. 

### Request Headers<a name="delete-preset-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="delete-preset-request-body"></a>

This operation does not have a request body\.

## Responses<a name="delete-preset-responses"></a>

### Syntax<a name="delete-preset-response-syntax"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "[Success](#delete-preset-response-success)":"true"
}
```

### Response Headers<a name="delete-preset-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="delete-preset-response-body"></a>

The response body contains the following JSON object\.

**Success**  
If the preset is successfully deleted, the value of `Success` is `true`\.

## Errors<a name="delete-preset-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="delete-preset-examples"></a>

The following example request deletes the preset that has the ID `5555555555555-abcde5`\.

### Sample Request<a name="delete-preset-examples-sample-request"></a>

```
DELETE /2012-09-25/pipelines/5555555555555-abcde5 HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Sample Response<a name="delete-preset-examples-sample-response"></a>

```
Status: 202 Accepted
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Success":"true"
}
```
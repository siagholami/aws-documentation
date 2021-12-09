# Handling Errors in Elastic Transcoder<a name="error-handling"></a>

**Topics**
+ [API Error Codes \(Client and Server Errors\)](#api-error-codes)
+ [Errors During Job Processing](#job-processing-errors)
+ [Catching Errors](#catching-errors)
+ [Error Retries and Exponential Backoff](#api-retries)

When you send requests to and get responses from the Elastic Transcoder API, you might encounter two types of API errors:
+ **Client errors:** Client errors are indicated by a 4xx HTTP response code\. Client errors indicate that Elastic Transcoder found a problem with the client request, such as an authentication failure or missing required parameters\. Fix the issue in the client application before submitting the request again\.
+ **Server errors:** Server errors are indicated by a 5xx HTTP response code, and need to be resolved by Amazon\. You can resubmit/retry the request until it succeeds\.

For each API error, Elastic Transcoder returns the following values: 
+ A status code, for example, `400`
+ An error code, for example, `ValidationException`
+ An error message, for example, `Supplied AttributeValue is empty, must contain exactly one of the supported datatypes`

For a list of error codes that Elastic Transcoder returns for client and server errors, see [API Error Codes \(Client and Server Errors\)](#api-error-codes)\.

In addition, you might encounter errors while Elastic Transcoder is processing your job\. For more information, see [Errors During Job Processing](#job-processing-errors)\.

## API Error Codes \(Client and Server Errors\)<a name="api-error-codes"></a>

HTTP status codes indicate whether an operation is successful or not\. 

A response code of `200` indicates the operation was successful\. Other error codes indicate either a client error \(4xx\) or a server error \(5xx\)\.

The following table lists the errors returned by Elastic Transcoder\. Some errors are resolved if you simply retry the same request\. The table indicates which errors are likely to be resolved with successive retries\. If the value of the Retry column is:
+ **Yes:** Submit the same request again\.
+ **No:** Fix the problem on the client side before submitting a new request\. 

For more information about retrying requests, see [Error Retries and Exponential Backoff](#api-retries)\.


| HTTP Status Code | Error code | Message | Cause | Retry | 
| --- | --- | --- | --- | --- | 
| 400 | Conditional Check Failed Exception | The conditional request failed\.  | Example: The expected value did not match what was stored in the system\.  | No | 
| 400 | Incomplete Signature Exception | The request signature does not conform to AWS standards\.  | The signature in the request did not include all of the required components\. See [HTTP Header Contents](making-http-requests.md#http-request-header)\. | No | 
| 403 | Missing Authentication Token Exception | The request must contain a valid \(registered\) AWS Access Key ID\. | The request did not include the required x\-amz\-security\-token\. See [Making HTTP Requests to Elastic Transcoder](making-http-requests.md)\. | No | 
| 400 | Validation Exception | Various\.  | One or more values in a request were missing or invalid; for example, a value was empty or was greater than the maximum valid value\. | No | 
| 403 | AccessDenied Exception |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/error-handling.html)  |  You attempted to delete a system preset, the signature in a call to the Elastic Transcoder API was invalid, or an IAM user is not authorized to perform the operation\.  | No | 
| 404 | ResourceNot Found Exception  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/error-handling.html)  | Example: The pipeline to which you're trying to add a job doesn't exist or is still being created\. | No | 
| 409 | Resource InUse Exception |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/error-handling.html)  | Example: You attempted to delete a pipeline that is currently in use\. | No | 
| 429 | Limit Exceeded Exception  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/error-handling.html)  | The current AWS account has exceeded limits on Elastic Transcoder objects\. For more information, see [Limits on the Number of Elastic Transcoder Pipelines, Jobs, and Presets](limits.md)\.  |  | 
| 429 | Provisioned Throughput Exceeded Exception | You exceeded your maximum allowed provisioned throughput\. |  Example: Your request rate is too high\. The AWS SDKs for Elastic Transcoder automatically retry requests that receive this exception\. Your request is eventually successful unless your retry queue is too large to finish\. Reduce the frequency of requests\. For more information, see [Error Retries and Exponential Backoff](#api-retries)\.  If you're polling to determine the status of a request, consider using notifications to determine status\. For more information, see [Notifications of Job Status](notifications.md)\.  | Yes | 
| 429 | Throttling Exception | Rate of requests exceeds the allowed throughput\. |  You are submitting requests too rapidly; for example, requests to create new jobs\. If you're polling to determine the status of a request, consider using notifications to determine status\. For more information, see [Notifications of Job Status](notifications.md)\.  | Yes | 
| 500 | Internal Failure | The server encountered an internal error trying to fulfill the request\.  | The server encountered an error while processing your request\. | Yes | 
| 500 | Internal Server Error | The server encountered an internal error trying to fulfill the request\.  | The server encountered an error while processing your request\. | Yes | 
| 500 | Internal Service Exception |  | The service encountered an unexpected exception while trying to fulfill the request\.  | Yes | 
| 500 | Service Unavailable Exception  | The service is currently unavailable or busy\. | There was an unexpected error on the server while processing your request\. | Yes | 

### Sample Error Response<a name="sample-http-error-response"></a>

The following is an HTTP response indicating that the value for `inputBucket` was null, which is not a valid value\. 

```
HTTP/1.1 400 Bad Request
x-amzn-RequestId: b0e91dc8-3807-11e2-83c6-5912bf8ad066
x-amzn-ErrorType: ValidationException
Content-Type: application/json
Content-Length: 124
Date: Mon, 26 Nov 2012 20:27:25 GMT

{"message":"1 validation error detected: Value null at 'inputBucket' failed to satisfy constraint: Member must not be null"}
```

## Errors During Job Processing<a name="job-processing-errors"></a>

When Elastic Transcoder encounters an error while processing your job, it reports the error in two ways:
+ **Job Status and Output Status:** Elastic Transcoder sets the `Job:Status` object and the `Outputs:Status` object for the failed output to `Error`\. In addition, Elastic Transcoder sets the `Outputs:StatusDetail` JSON object for the failed output to a value that explains the failure\.
+ **SNS Notification:** If you configured the pipeline to send an SNS notification when Elastic Transcoder encounters an error during processing, Elastic Transcoder includes a JSON object in the notification in the following format:

  ```
  {
     "state" : "PROGRESSING|COMPLETED|WARNING|ERROR",
     "errorCode" : "the code of any error that occurred",
     "messageDetails" : "the notification message you created in Amazon SNS",
     "version" : "API version that you used to create the job",
     "jobId" : "value of Job:Id object that Elastic Transcoder 
               returns in the response to a Create Job request",
     "pipelineId" : "value of PipelineId object 
                    in the Create Job request",
     "input" : {
        job Input settings
     },
     "outputKeyPrefix" : "prefix for file names in Amazon S3 bucket",
     "outputs": [
        {
           applicable job Outputs settings,
           "status" : "Progressing|Complete|Warning|Error"
        },
        {...}
     ],
     "playlists": [
        {
           applicable job playlists settings
        }
     ],
     "userMetadata": {
        "metadata key": "metadata value"
     }
  }
  ```


| Value of `errorCode` | Value of `messageDetails` | Cause | 
| --- | --- | --- | 
| 1000 | Validation Error | While processing the job, Elastic Transcoder determined that one or more values in the request were invalid\. | 
| 1001 | Dependency Error | Elastic Transcoder could not generate the playlist because it encountered an error with one or more of the playlists dependencies\. | 
| 2000 | Cannot Assume Role | Elastic Transcoder cannot assume the AWS Identity and Access Management role that is specified in the Role object in the pipeline for this job\. | 
| 3000 | Unclassified Storage Error |  | 
| 3001 | Input Does Not Exist | No file exists with the name that you specified in the Input:Key object for this job\. The file must exist in the Amazon S3 bucket that is specified in the InputBucket object in the pipeline for this job\. | 
| 3002 | Output Already Exists | A file already exists with the name that you specified in the Outputs:Key \(or Output:Key\) object for this job\. The file cannot exist in the Amazon S3 bucket that is specified in the OutputBucket object in the pipeline for this job\. | 
| 3003 | Does Not Have Read Permission | The IAM role specified in the Role object in the pipeline that you used for this job doesn't have permission to read from the Amazon S3 bucket that contains the file you want to transcode\. | 
| 3004 | Does Not Have Write Permission | The IAM role specified in the Role object in the pipeline that you used for this job doesn't have permission to write to the Amazon S3 bucket in which you want to save either transcoded files or thumbnail files\. | 
| 3005 | Bucket Does Not Exist | The specified S3 bucket does not exist: bucket=\{1\}\. | 
| 3006 | Does Not Have Write Permission | Elastic Transcoder was unable to write the key=\{1\} to bucket=\{2\}, as the key is not in the same region as the bucket | 
| 4000 | Bad Input File | The file that you specified in the Input:Key object for this job is in a format that is currently not supported by Elastic Transcoder\.  | 
| 4001 | Bad Input File | The width x height of the file that you specified in the Input:Key object for this job exceeds the maximum allowed width x height\.  | 
| 4002 | Bad Input File | The file size of the file that you specified in the Input:Key object for this job exceeds the maximum allowed size\.  | 
| 4003 | Bad Input File | Elastic Transcoder couldn't interpret the file that you specified in one of the Outputs:Watermarks:InputKey objects for this job\. | 
| 4004 | Bad Input File | The width x height of a file that you specified in one of the Outputs:Watermarks:InputKey objects for this job exceeds the maximum allowed width x height\.  | 
| 4005 | Bad Input File | The size of a file that you specified for one of the \{1\} objects exceeds the maximum allowed size: bucket=\{2\}, key=\{3\}, size\{4\}, max size=\{5\}\. | 
| 4006 | Bad Input File | Elastic Transcoder could not transcode the input file because the format is not supported\. | 
| 4007 | Unhandled Input File | Elastic Transcoder encountered a file type that is generally supported, but was unable to process the file correctly\. This error automatically opened a support case, and we have started to research the cause of the problem\. | 
| 4008 | Bad Input File |  The underlying cause of this is a mismatch between the preset and the input file\. Examples include: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/error-handling.html)  | 
| 4009 | Bad Input File | Elastic Transcoder was unable to insert all of your album art into the output file because you exceeded the maximum number of artwork streams\. | 
| 4010 | Bad Input File | Elastic Transcoder could not interpret the graphic file you specified for AlbumArt:Artwork:InputKey\. | 
| 4011 | Bad Input File | Elastic Transcoder detected an embedded artwork stream, but could not interpret it\. | 
| 4012 | Bad Input File | The image that you specified for AlbumArt:Artwork exceeds the maximum allowed width x height: 4096 x 3072\. | 
| 4013 | Bad Input File | The width x height of the embedded artwork exceeds the maximum allowed width x height: 4096 x 3072\. | 
| 4014 | Bad Input | The value that you specified for starting time of a clip is after the end of the input file\. Elastic Transcoder could not create an output file\. | 
| 4015 | Bad Input | Elastic Transcoder could not generate a manifest file because the generated segments did not match\. | 
| 4016 | Bad Input | Elastic Transcoder could not decrypt the input file from \{1\} using \{2\}\. | 
| 4017 | Bad Input | The AES key was encrypted with a \{2\}\-bit encryption key\. AES supports only 128\-, 192\-, and 256\-bit encryption keys\. MD5=\{1\}\. | 
| 4018 | Bad Input | Elastic Transcoder was unable to decrypt the ciphered key with MD5=\{1\} | 
| 4019 | Bad Input | Elastic Transcoder was unable to generate a data key using the KMS key ARN \{0\}\. | 
| 4020 | Bad Input | Your key must be 128 bits for AES\-128 encryption\. MD5=\{1\}, \{2\} bits\. | 
| 4021 | Bad Input | Your key must be 128 bits for PlayReady DRM\. MD5=\{1\}, strength=\{2\} bits\. | 
| 4022 | Bad Input | The combined size of the \{1\} specified media files exceeds the maximum allowed size: bucket=\{2\}, size=\{3\}\. | 
| 4023 | Bad Input | The \{1\} input files specified for concatenation will not create an output with a consistent resolution with the specified preset\. Use a preset with different PaddingPolicy, SizingPolicy, MaxWidth, and MaxHeight settings\. | 
| 4024 | Bad Input | The \{1\} input files specified for concatenation will not create thumbnails with a consistent resolution with the specified preset\. Use a preset with different thumbnail PaddingPolicy, SizingPolicy, MaxWidth, and MaxHeight settings\. | 
| 4025 | Bad Input | At least one media file \(input \#\{1\}\) doesn't match the others\. All media files must have either video or no video\. | 
| 4026 | Bad Input | At least one media file \(input \#\{1\}\) doesn't match the others\. All media files must have either audio or no audio\. | 
| 4100 | Bad Input File | Elastic Transcoder detected an embedded caption track but could not interpret it\. | 
| 4101 | Bad Input File | Elastic Transcoder could not interpret the specified caption file for Amazon S3 bucket=\{1\}, key=\{2\}\. | 
| 4102 | Bad Input File | Elastic Transcoder could not interpret the specified caption file since it was not UTF\-8 encoded: Amazon S3 bucket=\{1\}, key=\{2\}\. | 
| 4103 | Bad Input File | Elastic Transcoder was unable to process all of your caption tracks because you exceeded \{1\}, the maximum number of caption tracks\.  | 
| 4104 | Bad Input File | Elastic Transcoder could not generate a master playlist because the desired output contains \{1\} embedded captions, when the maximum is 4\. | 
| 4105 | Bad Input File | Elastic Transcoder cannot embed your caption tracks because frame rate \{1\} is not supported for CEA\-708 \- only frame rates \[29\.97, 30\] are supported\. | 
| 4106 | Bad Input File | Elastic Transcoder cannot embed your caption tracks because format \{1\} supports only \{2\} caption track\(s\)\. | 
| 9000 | Internal Service Error |  | 
| 9001 | Internal Service Error |  | 
| 9999 | Internal Service Error |  | 

## Catching Errors<a name="catching-errors"></a>

For your application to run smoothly, you need to build in logic to catch and respond to errors\. One typical approach is to implement your request within a `try` block or `if-then` statement\.

The AWS SDKs perform their own retries and error checking\. If you encounter an error while using one of the AWS SDKs, you should see the error code and description\. You should also see a `Request ID` value\. The `Request ID` value can help troubleshoot problems with Elastic Transcoder support\.

The following example uses the AWS SDK for Java to delete an item within a `try` block and uses a `catch` block to respond to the error\. In this case, it warns the user that the request failed\. The example uses the `AmazonServiceException` class to retrieve information about any operation errors, including the `Request ID`\. The example also uses the `AmazonClientException` class in case the request is not successful for other reasons\.

```
try {
   DeleteJobRequest request = new DeleteJobRequest(jobId);
   DeleteJobResult result = ET.deleteJob(request);
   System.out.println("Result: " + result);
   // Get error information from the service while trying to run the operation	
   }  catch (AmazonServiceException ase) {
      System.err.println("Failed to delete job " + jobId);
      // Get specific error information
      System.out.println("Error Message:    " + ase.getMessage());
      System.out.println("HTTP Status Code: " + ase.getStatusCode());
      System.out.println("AWS Error Code:   " + ase.getErrorCode());
      System.out.println("Error Type:       " + ase.getErrorType());
      System.out.println("Request ID:       " + ase.getRequestId());
   // Get information in case the operation is not successful for other reasons	
   }  catch (AmazonClientException ace) {
      System.out.println("Caught an AmazonClientException, which means"+
      " the client encountered " +
      "an internal error while trying to " +
      "communicate with Elastic Transcoder, " +
      "such as not being able to access the network.");
      System.out.println("Error Message: " + ace.getMessage());
   }
```

## Error Retries and Exponential Backoff<a name="api-retries"></a>

Numerous components on a network, such as DNS servers, switches, load balancers, and others can generate errors anywhere in the life of a given request\.

The usual technique for dealing with these error responses in a networked environment is to implement retries in the client application\. This technique increases the reliability of the application and reduces operational costs for the developer\.

Each AWS SDK supporting Elastic Transcoder implements automatic retry logic\. The AWS SDK for Java automatically retries requests, and you can configure the retry settings using the `ClientConfiguration` class\. For example, in some cases, such as a web page making a request with minimal latency and no retries, you might want to turn off the retry logic\. Use the `ClientConfiguration` class and provide a `maxErrorRetry` value of `0` to turn off the retries\. 

If you're not using an AWS SDK, you should retry original requests that receive server errors \(5xx\)\. However, client errors \(4xx, other than a `ThrottlingException` or a `ProvisionedThroughputExceededException`\) indicate you need to revise the request itself to correct the problem before trying again\. 

**Note**  
If you're polling to determine the status of a request, and if Elastic Transcoder is returning HTTP status code 429 with an error code of `Provisioned Throughput Exceeded Exception` or `Throttling Exception`, consider using notifications instead of polling to determine status\. For more information, see [Notifications of Job Status](notifications.md)\.

In addition to simple retries, we recommend using an exponential backoff algorithm for better flow control\. The idea behind exponential backoff is to use progressively longer waits between retries for consecutive error responses\. For example, you might let one second elapse before the first retry, four seconds before the second retry, 16 seconds before the third retry, and so on\. However, if the request has not succeeded after a minute, the problem might be a hard limit and not the request rate\. For example, you may have reached the maximum number of pipelines allowed\. Set the maximum number of retries to stop around one minute\.

Following is a workflow showing retry logic\. The workflow logic first determines if the error is a server error \(5xx\)\. Then, if the error is a server error, the code retries the original request\.

```
currentRetry = 0
DO
  set retry to false

  execute Elastic Transcoder request

  IF Exception.errorCode = ProvisionedThroughputExceededException
    set retry to true
  ELSE IF Exception.httpStatusCode = 500
    set retry to true
  ELSE IF Exception.httpStatusCode = 400
    set retry to false 
    fix client error (4xx)

  IF retry = true  
    wait for (2^currentRetry * 50) milliseconds
    currentRetry = currentRetry + 1

WHILE (retry = true AND currentRetry < MaxNumberOfRetries)  // limit retries
```
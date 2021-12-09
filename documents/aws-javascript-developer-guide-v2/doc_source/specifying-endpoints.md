# Specifying Custom Endpoints<a name="specifying-endpoints"></a>

Calls to API methods in the SDK for JavaScript are made to service endpoint URIs\. By default, these endpoints are built from the Region you have configured for your code\. However, there are situations in which you need to specify a custom endpoint for your API calls\.

## Endpoint String Format<a name="w4aac14c23b5"></a>

Endpoint values should be a string in the format:

**`https://{service}.{region}.amazonaws.com`**

## Endpoints for the ap\-northeast\-3 Region<a name="w4aac14c23c11"></a>

The `ap-northeast-3` Region in Japan is not returned by Region enumeration APIs, such as [https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/EC2.html#describeRegions-property](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/EC2.html#describeRegions-property)\. To define endpoints for this Region, follow the format described previously\. So the Amazon EC2 endpoint for this Region would be

`ec2.ap-northeast-3.amazonaws.com`

## Endpoints for MediaConvert<a name="w4aac14c23c13"></a>

You need to create a custom endpoint to use with MediaConvert\. Each customer account is assigned its own endpoint, which you must use\. Here is an example of how to use a custom endpoint with MediaConvert\.

```
// Create MediaConvert service object using custom endpoint
var mcClient = new AWS.MediaConvert({endpoint: 'https://abcd1234.mediaconvert.us-west-1.amazonaws.com'});

var getJobParams = {Id: 'job_ID'};

mcClient.getJob(getJobParams, function(err, data)) {
   if (err) console.log(err, err.stack); // an error occurred
   else console.log(data); // successful response
};
```

To get your account API endpoint, see [https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/MediaConvert.html#describeEndpoints-property](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/MediaConvert.html#describeEndpoints-property) in the API Reference\.

Make sure you specify the same Region in your code as the Region in the custom endpoint URI\. A mismatch between the Region setting and the custom endpoint URI can cause API calls to fail\.

For more information on MediaConvert, see the [https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/MediaConvert.html](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/MediaConvert.html) class in the API Reference or the *[AWS Elemental MediaConvert User Guide](https://docs.aws.amazon.com/mediaconvert/latest/ug/)*\.
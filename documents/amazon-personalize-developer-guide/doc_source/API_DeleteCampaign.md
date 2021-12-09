# DeleteCampaign<a name="API_DeleteCampaign"></a>

Removes a campaign by deleting the solution deployment\. The solution that the campaign is based on is not deleted and can be redeployed when needed\. A deleted campaign can no longer be specified in a [GetRecommendations](https://docs.aws.amazon.com/personalize/latest/dg/API_RS_GetRecommendations.html) request\. For more information on campaigns, see [CreateCampaign](API_CreateCampaign.md)\.

## Request Syntax<a name="API_DeleteCampaign_RequestSyntax"></a>

```
{
   "campaignArn": "string"
}
```

## Request Parameters<a name="API_DeleteCampaign_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [campaignArn](#API_DeleteCampaign_RequestSyntax) **   <a name="personalize-DeleteCampaign-request-campaignArn"></a>
The Amazon Resource Name \(ARN\) of the campaign to delete\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Elements<a name="API_DeleteCampaign_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_DeleteCampaign_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DeleteCampaign_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DeleteCampaign) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DeleteCampaign) 
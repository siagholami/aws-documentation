# UpdateCampaign<a name="API_UpdateCampaign"></a>

Updates a campaign by either deploying a new solution or changing the value of the campaign's `minProvisionedTPS` parameter\.

To update a campaign, the campaign status must be ACTIVE or CREATE FAILED\. Check the campaign status using the [DescribeCampaign](API_DescribeCampaign.md) API\.

**Note**  
You must wait until the `status` of the updated campaign is `ACTIVE` before asking the campaign for recommendations\.

For more information on campaigns, see [CreateCampaign](API_CreateCampaign.md)\.

## Request Syntax<a name="API_UpdateCampaign_RequestSyntax"></a>

```
{
   "campaignArn": "string",
   "campaignConfig": { 
      "itemExplorationConfig": { 
         "string" : "string" 
      }
   },
   "minProvisionedTPS": number,
   "solutionVersionArn": "string"
}
```

## Request Parameters<a name="API_UpdateCampaign_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [campaignArn](#API_UpdateCampaign_RequestSyntax) **   <a name="personalize-UpdateCampaign-request-campaignArn"></a>
The Amazon Resource Name \(ARN\) of the campaign\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

 ** [campaignConfig](#API_UpdateCampaign_RequestSyntax) **   <a name="personalize-UpdateCampaign-request-campaignConfig"></a>
The configuration details of a campaign\.  
Type: [CampaignConfig](API_CampaignConfig.md) object  
Required: No

 ** [minProvisionedTPS](#API_UpdateCampaign_RequestSyntax) **   <a name="personalize-UpdateCampaign-request-minProvisionedTPS"></a>
Specifies the requested minimum provisioned transactions \(recommendations\) per second that Amazon Personalize will support\.  
Type: Integer  
Valid Range: Minimum value of 1\.  
Required: No

 ** [solutionVersionArn](#API_UpdateCampaign_RequestSyntax) **   <a name="personalize-UpdateCampaign-request-solutionVersionArn"></a>
The ARN of a new solution version to deploy\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

## Response Syntax<a name="API_UpdateCampaign_ResponseSyntax"></a>

```
{
   "campaignArn": "string"
}
```

## Response Elements<a name="API_UpdateCampaign_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [campaignArn](#API_UpdateCampaign_ResponseSyntax) **   <a name="personalize-UpdateCampaign-response-campaignArn"></a>
The same campaign ARN as given in the request\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_UpdateCampaign_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_UpdateCampaign_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/UpdateCampaign) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/UpdateCampaign) 
# CreateCampaign<a name="API_CreateCampaign"></a>

Creates a campaign by deploying a solution version\. When a client calls the [GetRecommendations](https://docs.aws.amazon.com/personalize/latest/dg/API_RS_GetRecommendations.html) and [GetPersonalizedRanking](https://docs.aws.amazon.com/personalize/latest/dg/API_RS_GetPersonalizedRanking.html) APIs, a campaign is specified in the request\.

 **Minimum Provisioned TPS and Auto\-Scaling** 

A transaction is a single `GetRecommendations` or `GetPersonalizedRanking` call\. Transactions per second \(TPS\) is the throughput and unit of billing for Amazon Personalize\. The minimum provisioned TPS \(`minProvisionedTPS`\) specifies the baseline throughput provisioned by Amazon Personalize, and thus, the minimum billing charge\. 

 If your TPS increases beyond `minProvisionedTPS`, Amazon Personalize auto\-scales the provisioned capacity up and down, but never below `minProvisionedTPS`\. There's a short time delay while the capacity is increased that might cause loss of transactions\.

The actual TPS used is calculated as the average requests/second within a 5\-minute window\. You pay for maximum of either the minimum provisioned TPS or the actual TPS\. We recommend starting with a low `minProvisionedTPS`, track your usage using Amazon CloudWatch metrics, and then increase the `minProvisionedTPS` as necessary\.

 **Status** 

A campaign can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS

To get the campaign status, call [DescribeCampaign](API_DescribeCampaign.md)\.

**Note**  
Wait until the `status` of the campaign is `ACTIVE` before asking the campaign for recommendations\.

**Related APIs**
+  [ListCampaigns](API_ListCampaigns.md) 
+  [DescribeCampaign](API_DescribeCampaign.md) 
+  [UpdateCampaign](API_UpdateCampaign.md) 
+  [DeleteCampaign](API_DeleteCampaign.md) 

## Request Syntax<a name="API_CreateCampaign_RequestSyntax"></a>

```
{
   "campaignConfig": { 
      "itemExplorationConfig": { 
         "string" : "string" 
      }
   },
   "minProvisionedTPS": number,
   "name": "string",
   "solutionVersionArn": "string"
}
```

## Request Parameters<a name="API_CreateCampaign_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [campaignConfig](#API_CreateCampaign_RequestSyntax) **   <a name="personalize-CreateCampaign-request-campaignConfig"></a>
The configuration details of a campaign\.  
Type: [CampaignConfig](API_CampaignConfig.md) object  
Required: No

 ** [minProvisionedTPS](#API_CreateCampaign_RequestSyntax) **   <a name="personalize-CreateCampaign-request-minProvisionedTPS"></a>
Specifies the requested minimum provisioned transactions \(recommendations\) per second that Amazon Personalize will support\.  
Type: Integer  
Valid Range: Minimum value of 1\.  
Required: Yes

 ** [name](#API_CreateCampaign_RequestSyntax) **   <a name="personalize-CreateCampaign-request-name"></a>
A name for the new campaign\. The campaign name must be unique within your account\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

 ** [solutionVersionArn](#API_CreateCampaign_RequestSyntax) **   <a name="personalize-CreateCampaign-request-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the solution version to deploy\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_CreateCampaign_ResponseSyntax"></a>

```
{
   "campaignArn": "string"
}
```

## Response Elements<a name="API_CreateCampaign_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [campaignArn](#API_CreateCampaign_ResponseSyntax) **   <a name="personalize-CreateCampaign-response-campaignArn"></a>
The Amazon Resource Name \(ARN\) of the campaign\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateCampaign_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_CreateCampaign_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateCampaign) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateCampaign) 
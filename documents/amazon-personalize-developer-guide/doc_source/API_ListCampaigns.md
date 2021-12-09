# ListCampaigns<a name="API_ListCampaigns"></a>

Returns a list of campaigns that use the given solution\. When a solution is not specified, all the campaigns associated with the account are listed\. The response provides the properties for each campaign, including the Amazon Resource Name \(ARN\)\. For more information on campaigns, see [CreateCampaign](API_CreateCampaign.md)\.

## Request Syntax<a name="API_ListCampaigns_RequestSyntax"></a>

```
{
   "maxResults": number,
   "nextToken": "string",
   "solutionArn": "string"
}
```

## Request Parameters<a name="API_ListCampaigns_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [maxResults](#API_ListCampaigns_RequestSyntax) **   <a name="personalize-ListCampaigns-request-maxResults"></a>
The maximum number of campaigns to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListCampaigns_RequestSyntax) **   <a name="personalize-ListCampaigns-request-nextToken"></a>
A token returned from the previous call to `ListCampaigns` for getting the next set of campaigns \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

 ** [solutionArn](#API_ListCampaigns_RequestSyntax) **   <a name="personalize-ListCampaigns-request-solutionArn"></a>
The Amazon Resource Name \(ARN\) of the solution to list the campaigns for\. When a solution is not specified, all the campaigns associated with the account are listed\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

## Response Syntax<a name="API_ListCampaigns_ResponseSyntax"></a>

```
{
   "campaigns": [ 
      { 
         "campaignArn": "string",
         "creationDateTime": number,
         "failureReason": "string",
         "lastUpdatedDateTime": number,
         "name": "string",
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListCampaigns_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [campaigns](#API_ListCampaigns_ResponseSyntax) **   <a name="personalize-ListCampaigns-response-campaigns"></a>
A list of the campaigns\.  
Type: Array of [CampaignSummary](API_CampaignSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListCampaigns_ResponseSyntax) **   <a name="personalize-ListCampaigns-response-nextToken"></a>
A token for getting the next set of campaigns \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListCampaigns_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListCampaigns_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListCampaigns) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListCampaigns) 
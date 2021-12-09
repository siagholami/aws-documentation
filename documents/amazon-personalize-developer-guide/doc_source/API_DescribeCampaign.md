# DescribeCampaign<a name="API_DescribeCampaign"></a>

Describes the given campaign, including its status\.

A campaign can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS

When the `status` is `CREATE FAILED`, the response includes the `failureReason` key, which describes why\.

For more information on campaigns, see [CreateCampaign](API_CreateCampaign.md)\.

## Request Syntax<a name="API_DescribeCampaign_RequestSyntax"></a>

```
{
   "campaignArn": "string"
}
```

## Request Parameters<a name="API_DescribeCampaign_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [campaignArn](#API_DescribeCampaign_RequestSyntax) **   <a name="personalize-DescribeCampaign-request-campaignArn"></a>
The Amazon Resource Name \(ARN\) of the campaign\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeCampaign_ResponseSyntax"></a>

```
{
   "campaign": { 
      "campaignArn": "string",
      "campaignConfig": { 
         "itemExplorationConfig": { 
            "string" : "string" 
         }
      },
      "creationDateTime": number,
      "failureReason": "string",
      "lastUpdatedDateTime": number,
      "latestCampaignUpdate": { 
         "campaignConfig": { 
            "itemExplorationConfig": { 
               "string" : "string" 
            }
         },
         "creationDateTime": number,
         "failureReason": "string",
         "lastUpdatedDateTime": number,
         "minProvisionedTPS": number,
         "solutionVersionArn": "string",
         "status": "string"
      },
      "minProvisionedTPS": number,
      "name": "string",
      "solutionVersionArn": "string",
      "status": "string"
   }
}
```

## Response Elements<a name="API_DescribeCampaign_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [campaign](#API_DescribeCampaign_ResponseSyntax) **   <a name="personalize-DescribeCampaign-response-campaign"></a>
The properties of the campaign\.  
Type: [Campaign](API_Campaign.md) object

## Errors<a name="API_DescribeCampaign_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeCampaign_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeCampaign) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeCampaign) 
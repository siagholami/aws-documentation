# CampaignUpdateSummary<a name="API_CampaignUpdateSummary"></a>

Provides a summary of the properties of a campaign update\. For a complete listing, call the [DescribeCampaign](API_DescribeCampaign.md) API\.

## Contents<a name="API_CampaignUpdateSummary_Contents"></a>

 **campaignConfig**   <a name="personalize-Type-CampaignUpdateSummary-campaignConfig"></a>
The configuration details of a campaign\.  
Type: [CampaignConfig](API_CampaignConfig.md) object  
Required: No

 **creationDateTime**   <a name="personalize-Type-CampaignUpdateSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the campaign update was created\.  
Type: Timestamp  
Required: No

 **failureReason**   <a name="personalize-Type-CampaignUpdateSummary-failureReason"></a>
If a campaign update fails, the reason behind the failure\.  
Type: String  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-CampaignUpdateSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the campaign update was last updated\.  
Type: Timestamp  
Required: No

 **minProvisionedTPS**   <a name="personalize-Type-CampaignUpdateSummary-minProvisionedTPS"></a>
Specifies the requested minimum provisioned transactions \(recommendations\) per second that Amazon Personalize will support\.  
Type: Integer  
Valid Range: Minimum value of 1\.  
Required: No

 **solutionVersionArn**   <a name="personalize-Type-CampaignUpdateSummary-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the deployed solution version\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-CampaignUpdateSummary-status"></a>
The status of the campaign update\.  
A campaign update can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_CampaignUpdateSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CampaignUpdateSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CampaignUpdateSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CampaignUpdateSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CampaignUpdateSummary) 
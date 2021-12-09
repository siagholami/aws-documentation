# CampaignSummary<a name="API_CampaignSummary"></a>

Provides a summary of the properties of a campaign\. For a complete listing, call the [DescribeCampaign](API_DescribeCampaign.md) API\.

## Contents<a name="API_CampaignSummary_Contents"></a>

 **campaignArn**   <a name="personalize-Type-CampaignSummary-campaignArn"></a>
The Amazon Resource Name \(ARN\) of the campaign\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **creationDateTime**   <a name="personalize-Type-CampaignSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the campaign was created\.  
Type: Timestamp  
Required: No

 **failureReason**   <a name="personalize-Type-CampaignSummary-failureReason"></a>
If a campaign fails, the reason behind the failure\.  
Type: String  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-CampaignSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the campaign was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-CampaignSummary-name"></a>
The name of the campaign\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-CampaignSummary-status"></a>
The status of the campaign\.  
A campaign can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_CampaignSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CampaignSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CampaignSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CampaignSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CampaignSummary) 
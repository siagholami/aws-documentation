# Campaign<a name="API_Campaign"></a>

Describes a deployed solution version, otherwise known as a campaign\. For more information on campaigns, see [CreateCampaign](API_CreateCampaign.md)\.

## Contents<a name="API_Campaign_Contents"></a>

 **campaignArn**   <a name="personalize-Type-Campaign-campaignArn"></a>
The Amazon Resource Name \(ARN\) of the campaign\.   
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **campaignConfig**   <a name="personalize-Type-Campaign-campaignConfig"></a>
The configuration details of a campaign\.  
Type: [CampaignConfig](API_CampaignConfig.md) object  
Required: No

 **creationDateTime**   <a name="personalize-Type-Campaign-creationDateTime"></a>
The date and time \(in Unix format\) that the campaign was created\.  
Type: Timestamp  
Required: No

 **failureReason**   <a name="personalize-Type-Campaign-failureReason"></a>
If a campaign fails, the reason behind the failure\.  
Type: String  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-Campaign-lastUpdatedDateTime"></a>
The date and time \(in Unix format\) that the campaign was last updated\.  
Type: Timestamp  
Required: No

 **latestCampaignUpdate**   <a name="personalize-Type-Campaign-latestCampaignUpdate"></a>
Provides a summary of the properties of a campaign update\. For a complete listing, call the [DescribeCampaign](API_DescribeCampaign.md) API\.  
Type: [CampaignUpdateSummary](API_CampaignUpdateSummary.md) object  
Required: No

 **minProvisionedTPS**   <a name="personalize-Type-Campaign-minProvisionedTPS"></a>
Specifies the requested minimum provisioned transactions \(recommendations\) per second\.  
Type: Integer  
Valid Range: Minimum value of 1\.  
Required: No

 **name**   <a name="personalize-Type-Campaign-name"></a>
The name of the campaign\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **solutionVersionArn**   <a name="personalize-Type-Campaign-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of a specific version of the solution\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **status**   <a name="personalize-Type-Campaign-status"></a>
The status of the campaign\.  
A campaign can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_Campaign_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/Campaign) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/Campaign) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/Campaign) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/Campaign) 
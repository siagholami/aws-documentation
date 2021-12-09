# Creating a Campaign<a name="campaigns"></a>

A campaign is used to make recommendations for your users\. You create a campaign by deploying a solution version\. For an example using the AWS CLI, see [Step 3: Create a Campaign \(Deploy the Solution\)](getting-started-cli.md#gs-create-campaign)\.

To create a campaign with the SDK, call the [CreateCampaign](API_CreateCampaign.md) API and pass the following:
+ A name for the campaign\.
+ The Amazon Resource Name \(ARN\) of the solution version to deploy\.
+ The minimum provisioned transactions per second \(`minProvisionedTPS`\) that Amazon Personalize will support\. For more information on `minProvisionedTPS`, see the `CreateCampaign` API\.

**Create a campaign using the AWS Python SDK**

1. Create a solution version to deploy\. For more information, see [Creating a Solution](training-deploying-solutions.md)\.

1. Use the following code to create a campaign for a solution version trained using the User\-Personalization recipe with the optional default `explorationWeight` and `explorationItemAgeCutOff` for `itemExplorationConfig`\. For more information, see [User\-Personalization](native-recipe-new-item-USER_PERSONALIZATION.md)

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   create_campaign_response = personalize.create_campaign(
       name = 'campaign name',
       solutionVersionArn = 'solution version arn',
       minProvisionedTPS = 1,
       campaignConfig = {"itemExplorationConfig": {"explorationWeight": "0.3", "explorationItemAgeCutOff": "30"}}
   )
   
   arn = response['campaignArn']
   
   description = personalize.describe_campaign(campaignArn = arn)['campaign']
   print('Name: ' + description['name'])
   print('ARN: ' + description['campaignArn'])
   print('Status: ' + description['status'])
   ```

The campaign isn't ready for use until its status is active\. To get the current status, call [DescribeCampaign](API_DescribeCampaign.md) and check that the `status` field is `ACTIVE`\.

Amazon Personalize provides operations for managing campaigns such as [ListCampaigns](API_ListCampaigns.md) to list the campaigns you have created\. You can delete a campaign by calling [DeleteCampaign](API_DeleteCampaign.md)\. If you delete a campaign, the solution versions that are part of the campaign are not deleted\.

After you have created your campaign, use it to make recommendations\. For more information, see [Getting Recommendations](getting-recommendations.md)\.
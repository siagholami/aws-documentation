# Setting Up a Recommender Model in Amazon Pinpoint<a name="ml-models-rm-setup"></a>

A *recommender model* is a type of machine learning \(ML\) model that's designed to predict what a particular user will prefer from a given set of products or items\. It provides that information as a set of recommendations for the user\. In Amazon Pinpoint, you can use these models to send personalized recommendations to message recipients based on each recipient’s attributes and behavior\.

Before you can use a recommender model in this way, you have to set up a connection between Amazon Pinpoint and the Amazon Personalize campaign that has the model to use\. When you set up the connection, you specify how you want to retrieve and use recommendations from the Amazon Personalize campaign\. You also add settings for attributes that temporarily store recommendations from the campaign\.

## Before You Begin<a name="ml-models-rm-setup-prerequisites"></a>

Before you set up a recommender model in Amazon Pinpoint, review the information in [Preparing to Use a Recommender Model with Amazon Pinpoint](ml-models-rm-prerequisites.md)\. This will help you gather the resources and information that you need to set up the model in Amazon Pinpoint\.

## Step 1: Set Up the Model<a name="ml-models-rm-setup-step1"></a>

For this step, you specify which Amazon Personalize campaign you want to retrieve recommendations from\. You also choose settings that specify how you want to retrieve and use those recommendations\.

**To set up a recommender model**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Machine learning models**\.

1. On the **Machine learning models** page, choose **Add recommender model**\.

1. Under **Model details**, for **Recommender model name**, enter a name for the model in Amazon Pinpoint\. The name has to begin with a letter or number\. It can contain up to 128 characters\. The characters can be letters, numbers, underscores \(\_\), or hyphens \(‐\)\.

1. \(Optional\) For **Recommender model description**, enter a brief description of the model\. The description can contain up to 128 characters\. The characters can be letters, numbers, spaces, or the following symbols: \_ ; \(\) , ‐\.

1. Under **Model configuration**, for **IAM role**, choose the AWS Identity and Access Management \(IAM\) role that authorizes Amazon Pinpoint to connect to and retrieve recommendations from the Amazon Personalize campaign that uses the model\. You have the following options:
   + **Use an existing role** – Choose this option to use an IAM role that already exists for your AWS account\. Then, from the list of roles, choose the role that you want\.
   + **Automatically create a role** – Choose this option to automatically create an IAM role that has the required permissions\. Then, enter a name for the role\.

   Another option is to work with your administrator to create the role manually\. For information about creating the role manually, see [IAM Role for Retrieving Recommendations](https://docs.aws.amazon.com/pinpoint/latest/developerguide/permissions-get-recommendations.html) in the *Amazon Pinpoint Developer Guide*\.

1. For **Recommender model**, choose the Amazon Personalize campaign that you want to retrieve recommendations from\.

   This list displays all the Amazon Personalize campaigns that you're allowed to access with your AWS account in the current AWS Region\. If the list doesn't include the campaign that you want, ask your administrator to give you access to the campaign and verify that you chose the correct IAM role in the preceding step\. Also, verify that the campaign exists in the current AWS Region\.

1. Under **Settings**, for **Identifier to use for recommendations**, specify whether you want to associate unique users in the Amazon Personalize campaign with endpoints \(**Endpoint ID**\) or users \(**User ID**\) in your Amazon Pinpoint projects\.

1. For **Number of recommendations per message**, choose the number of recommended items that you want to retrieve for each endpoint or user in your Amazon Pinpoint projects, depending on your choice in the preceding step\. 

   This setting determines how many recommendations Amazon Pinpoint retrieves and you can add to individual messages\. You can retrieve as many as five recommended items\. If you choose **1**, Amazon Pinpoint retrieves only the first item from the list of recommendations for each message recipient—for example, the most highly recommended movie for a recipient\. If you choose **2**, it retrieves the first and second items from the list for each recipient—for example, the top two recommended movies for a recipient\. And so on, for as many as five recommendations\.

1. For **Processing method**, choose one of the following options to specify how you want Amazon Pinpoint to process the recommendations that it retrieves:
   + **Use the value returned by the model** – With this option, messages display the exact text of the recommendations that are provided by the Amazon Personalize campaign\. In addition, all the recommendations for each endpoint or user are temporarily stored in one standard recommended attribute for each endpoint or user\.
   + **Use a Lambda function** – With this option, messages can display enhanced recommendations instead of or in addition to the text of the recommendations that are provided by the Amazon Personalize campaign\. If you choose this option, Amazon Pinpoint sends recommendations to an AWS Lambda function for additional processing, before it sends a message that includes the recommendations\. In addition, you can temporarily store recommendations in as many as 10 custom recommended attributes for each endpoint or user\.

     If you choose this option, also use the **Lambda function** list to choose the function that you want to use\. This list displays all the Lambda functions that you're allowed to access with your AWS account in the current AWS Region\. If the list doesn't include the function that you want, ask your administrator to give you access to the function\. If the function doesn't exist yet, choose **Create new Lambda function**, and work with your development team to create the function\. For more information, see [Customizing Recommendations with AWS Lambda](https://docs.aws.amazon.com/pinpoint/latest/developerguide/ml-models-rm-lambda.html) in the *Amazon Pinpoint Developer Guide*\.

1. When you finish entering these settings, choose **Next** to proceed to the next step—adding attribute settings for the recommender model\. 

## Step 2: Add Attributes to the Model<a name="ml-models-rm-setup-step2"></a>

After you choose settings for connecting to and retrieving recommendations from the Amazon Personalize campaign, you're ready to enter settings for the attributes that will store the recommendation data\. These options vary depending on the processing method that you chose in the preceding step:

**Use the value returned by the model**  
If you chose this option, recommendations are temporarily stored in one attribute\. This is a standard recommended attribute for each endpoint or user, depending on the option that you chose for the **Identifier to use for recommendations** setting in the preceding step\. The underlying name of this attribute is `RecommendationItems`\.  
For **Display name**, enter a descriptive name for the attribute\. This name will appear in the **Attribute finder** in the template editor when you add a variable for the attribute to a message template\. The name can contain up to 25 characters\. The characters can be letters, numbers, spaces, underscores \(\_\), or hyphens \(‐\)\.

**Use a Lambda function**  
If you chose this option, you can use as many as 10 attributes to store data for each recommendation\. These are custom recommended attributes for each endpoint or user, depending on the option that you chose for the **Identifier to use for recommendations** setting in the preceding step\. For example, if you retrieve one product recommendation for each endpoint or user, the Lambda function can process the recommendation and add the results to three custom attributes for the recommendation—product name, price, and image\.  
For each custom attribute that you want to add, choose **Add attribute**, and then do the following:  
+ For **Attribute name**, enter a name for the attribute\. This name, preceded by the `Recommendations` prefix, will appear in the template editor after you add a variable for the attribute to a message template\. The name has to match the name of an attribute that the Lambda function uses to store recommendation data\.

  An attribute name has to start with a letter or number and it can contain up to 50 characters\. The characters can be letters, numbers, underscores \(\_\), or hyphens \(‐\)\. Attribute names are case sensitive and must be unique\.
+ For **Display name**, enter a descriptive name for the attribute\. This name will appear in the **Attribute finder** in the template editor when you add a variable for the attribute to a message template\. The name has to start with a letter or number and it can contain up to 25 characters\. The characters can be letters, numbers, spaces, underscores \(\_\), or hyphens \(‐\)\.

When you finish entering attribute settings, choose **Next** to proceed to the next step—reviewing and publishing the configuration settings for the recommender model\.

## Step 3: Review and Publish the Model<a name="ml-models-rm-setup-step3"></a>

After you finish entering all the settings for connecting to and using the recommender model, you're ready to review the settings\.

When you finish reviewing the settings, choose **Publish** to save them\. Amazon Pinpoint then checks the settings to verify that they're correct\. If any settings are missing or incorrect, it displays a message for each error to help you determine which setting to fix\. If you need to fix a setting, use the navigation pane to go directly to the page that contains the setting\.

After you publish the settings, you can start using recommendations in messages\.
# Using Recommendations in Messages<a name="ml-models-rm-using"></a>

To add dynamic, personalized recommendations to messages, create and use message templates that include message variables for recommended attributes\. A *message variable* is a placeholder that refers to a specific attribute that you or Amazon Pinpoint created to store information about your users\. A *recommended attribute* is an attribute that temporarily stores recommendations for your users\. Amazon Pinpoint retrieves these recommendations from a recommender model that you deployed as an Amazon Personalize campaign and configured Amazon Pinpoint to use\.

If a template contains message variables, Amazon Pinpoint replaces each variable with the current, corresponding value of the attribute for each recipient\. For recommendations, this process includes retrieving the latest recommendations for each recipient from an Amazon Personalize campaign\. Amazon Pinpoint does this each time it sends a message that uses the template\. This means that you can feel confident that the message contains the latest recommendations for a recipient\.

For example, if your project is an application that recommends movies and TV shows to users, you might have the following attributes for each user:
+ The user's first name\.
+ The rating that the user most recently submitted\.
+ The title of the movie or show that the user most recently rated\.
+ The titles of the top three movies and shows that the model recommends for the user\.

For this project, you could use the following text and message variables in a template:

`Hi {{User.UserAttributes.FirstName}}, based on your recent {{User.UserAttributes.LatestRating}}-star rating for {{User.UserAttributes.LatestRatedTitle}}, we think you might also enjoy: {{RecommendationItems.[0]}}, {{RecommendationItems.[1]}}, and {{RecommendationItems.[2]}}.`

When you send a message that uses the template, Amazon Pinpoint replaces the variables with the current value of each attribute for each recipient\. The following examples show this\.

**Example 1**  
`Hi Sofia, based on your recent 5-star rating for The Marvelous Mrs. Maisel – Season 3, we think you might also enjoy: Fleabag, Late Night, and Catastrophe.`

**Example 2**  
`Hi Alejandro, based on your recent 4-star rating for Tom Clancy's Jack Ryan – Season 2, we think you might also enjoy: Hanna, Hunters, and Agatha Christie's The ABC Murders.`

If you configured a recommender model to enhance recommendations by using an AWS Lambda function, a template and the resulting message might use additional variables and recommended attributes\. For example, they might also use variables for attributes that provide an image and a URL for each recommended movie or show\.

For more information about using message variables in templates, see [Adding Personalized Content to Message Templates](message-templates-personalizing.md)\.

## Adding Recommendations to Messages<a name="ml-models-rm-using-add-variables"></a>

To add personalized recommendations to messages, create and use message templates that include message variables for the recommendations that you want to use\. You can add these variables to the following types of message templates:
+ Email templates, for email messages that you send from campaigns or journeys\.
+ Push notification templates, for push notifications that you send from campaigns\.
+ SMS templates, for SMS text messages that you send from campaigns\.

Each template can use variables and recommended attributes from one recommender model at a time\.

You can add the variables to a new template when you create the template, or to an existing template\. If you add variables to an existing template, Amazon Pinpoint doesn't necessarily apply the changes to messages that use the template and haven't been sent yet, such as campaign messages that are scheduled to be sent at a later time\. This depends on the version of the template that you add variables to and how you configured the messages that use the template\. For more information, see [Managing Versions of Message Templates](message-templates-versioning.md)\.

**To add recommendations to a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, do one of the following: 
   + To create a new template and add recommendations to it, choose **Create template**\. Then, on the template page, enter a name for the template and, optionally, a description of the template\.
   + To add recommendations to an existing template, choose the template that you want\. Then, on the template page, choose **Edit**\. Under **Template details**, use the version selector to choose the version of the template that you want to use as a starting point\. If you choose the most recent version, you can save your changes directly to that version of the template\. Otherwise, you can save your changes as a new version of the template\.

1. In the **Attribute finder**, expand the **Recommended attributes** section\.

   If you haven't selected a recommender model for the template yet, choose **Connect model**\. Next, select the model that you want to retrieve recommendations from when you send messages that use the template\. Then choose **Connect model**\.

1. Under **Recommended attributes**, choose the attribute that you want to add a message variable for\. Amazon Pinpoint creates a variable for the attribute and copies it to your clipboard\. Then, in the message editor, paste the variable where you want the recommendation to appear in messages\.

   After you paste the variable, Amazon Pinpoint displays it as the name of the associated attribute, enclosed in two sets of curly braces—for example, `{{RecommendationItems}}`\.

1. If the recommender model provides more than one recommended attribute, repeat the preceding step for each additional attribute that you want to add a variable for\.

   You can also add variables for other types of attributes\. To do this, expand other sections in the **Attribute finder**, choose each additional attribute that you want, and then paste the variable in the location that you want\. To learn about using variables for other types of attributes, see [Adding Personalized Content to Message Templates](message-templates-personalizing.md)\.

1. To specify a default value for a message variable, expand the **Default attribute values** section\. Then, in the list of variables, enter the default value that you want to use for the variable\. We recommend that you do this for each variable in the template\.

1. When you finish, do one of the following:
   + If you added message variables to a new template, choose **Create**\.
   + If you added message variables to an existing template and you want to save your changes as a new version of the template, choose **Save as new version**\.
   + If you added message variables to an existing template and you want to save your changes as an update to the most recent version of the template, choose **Update version**\. This option is available only if you opened the most recent version of the template in step 3\.

You can now use the template to include personalized recommendations in messages that you send from campaigns and journeys\.

Note that you can't include recommendations in messages that you send to a limited audience as direct or test messages\. Although you can use templates in these messages more generally, Amazon Pinpoint can't correlate recommendations from a model with recipients of a direct or test message\. To test the appearance and formatting of a template that uses recommendations, specify a default value for each message variable that refers to a recommended attribute, and then send a test message that uses the template\.

## Removing Recommendations from Messages<a name="ml-models-using-remove-variables"></a>

To remove personalized recommendations from messages, update the message template that the messages use\. When you update the template, remove all or only some message variables for recommendations\.

If you remove recommendations from a template, Amazon Pinpoint doesn't necessarily apply the changes to messages that use the template and haven't been sent yet, such as campaign messages that are scheduled to be sent at a later time\. This depends on the version of the template that you remove recommendations from and how you configured the messages that use the template\. For more information, see [Managing Versions of Message Templates](message-templates-versioning.md)\.

**To remove recommendations from a message template**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. In the navigation pane, choose **Message templates**\.

1. On the **Message templates** page, choose the template that you want to remove recommendations from\. Then, on the template page, choose **Edit**\.

1. Under **Template details**, use the version selector to choose the version of the template that you want to use as a starting point\. If you choose the most recent version, you can save your changes directly to that version of the template\. Otherwise, you can save your changes as a new version of the template\.

1. In the message editor, delete all the text of the message variable for each recommended attribute that you want to remove\. Each message variable consists of two sets of curly braces and the name of the associated attribute—for example, `{{RecommendationItems}}`\.

   To remove the recommender model from the template completely, delete all the variables for recommended attributes that the model provides\. Then, in the **Attribute finder**, expand the **Recommended attributes** section and choose **X** next to the name of the model\.

1. When you finish, do one of the following:
   + To save your changes as a new version of the template, choose **Save as new version**\.
   + To save your changes as an update to the most recent version of the template, choose **Update version**\. This option is available only if you chose the most recent version of the template in step 4\.
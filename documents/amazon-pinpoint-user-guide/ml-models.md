# Machine Learning Models in Amazon Pinpoint<a name="ml-models"></a>

A *machine learning \(ML\) model* is a mathematical representation of a real\-world problem\. An ML model finds patterns in data and generates predictions based on the patterns that it finds\. These predictions typically improve over time, as an ML model receives more data and people retrain or tune the model to refine and optimize the model's analysis of data\.

In Amazon Pinpoint, you can connect to a certain type of ML model, referred to as a *recommender model*, to predict which items a user will interact with and to send those items to message recipients as personalized recommendations\. A *recommender model* is an ML model that's designed to answer the question, "What will a user like or be interested in?" It predicts what a particular user will prefer from a given set of products or items, and it provides that information as a set of recommendations for the user\. By using recommender models with Amazon Pinpoint, you can send personalized recommendations to message recipients based on each recipient’s attributes and behavior\.

To use a recommender model with Amazon Pinpoint, start by working with your data science team to create and deploy the model as an Amazon Personalize campaign\. Next, configure Amazon Pinpoint to use recommendation data from the Amazon Personalize campaign\. You do this by setting up a connection between Amazon Pinpoint and the Amazon Personalize campaign\. When you set up the connection, you specify how you want to retrieve and use data from the Amazon Personalize campaign\.

After you set up the connection to the Amazon Personalize campaign, you can start adding recommendations to messages\. To do this, create a message template\. In the template, add message variables for the recommendations that you want to use\. You can add these variables to the following types of templates:
+ Email templates, for email messages that you send from campaigns or journeys\.
+ Push notification templates, for push notifications that you send from campaigns\.
+ SMS templates, for SMS text messages that you send from campaigns\.

Then, create a campaign or journey to send messages that use the template\. When you send the messages, Amazon Pinpoint retrieves the latest data from the Amazon Personalize campaign, and replaces each variable with values that your model recommends for each message recipient\.

This feature is available in the following AWS Regions: US East \(N\. Virginia\); US West \(Oregon\); Asia Pacific \(Mumbai\); Asia Pacific \(Sydney\); and, Europe \(Ireland\)\.

The topics in this chapter explain how to configure Amazon Pinpoint to use recommendation data from an Amazon Personalize campaign\. They also explain how to include that data in messages\.

**Topics**
+ [How Recommendations Work in Amazon Pinpoint](ml-models-rm-how-it-works.md)
+ [Preparing to Use a Recommender Model with Amazon Pinpoint](ml-models-rm-prerequisites.md)
+ [Setting Up a Recommender Model in Amazon Pinpoint](ml-models-rm-setup.md)
+ [Using Recommendations in Messages](ml-models-rm-using.md)
+ [Managing Machine Learning Models in Amazon Pinpoint](ml-models-managing.md)
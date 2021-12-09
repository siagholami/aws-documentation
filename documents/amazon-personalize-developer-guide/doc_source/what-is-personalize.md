# What Is Amazon Personalize?<a name="what-is-personalize"></a>

Amazon Personalize is a machine learning service that makes it easy for developers to add individualized recommendations to customers who use their applications\. It reflects the vast experience that Amazon has in building personalization systems\.

You can use Amazon Personalize in a variety of scenarios, such as giving users recommendations based on their preferences and behavior, personalized re\-ranking of results, and personalizing content for emails and notifications\.

Amazon Personalize does not require extensive machine learning experience\. You can build, train, and deploy a solution version \(a trained Amazon Personalize recommendation model\) with the AWS console or programmatically by using the AWS SDK\. As the developer, you only need to do the following:
+ Format input data and upload the data into an Amazon S3 bucket, or send real\-time event data\.
+ Select a training recipe \(algorithm\) to use on the data\.
+ Train a solution version using the recipe\.
+ Deploy the solution version\.

Amazon Personalize can capture live events from your users to achieve real\-time personalization\. Amazon Personalize can blend real\-time user activity data with existing user profile and item information to recommend the most relevant items, according to the user’s current session and activity\. You can also use Amazon Personalize to collect data for new properties, such as a brand new website, and after enough data has been collected, Amazon Personalize can start to make recommendations\.

To give recommendations to your users, call one of the recommendation APIs, and then create personalized experiences for them\.

Amazon Personalize can improve its recommendations over time as new user activity data is collected\. For example, a new movie rental event by a user can result in better movie recommendations\.

Amazon Personalize can provide recommendations based on a user's browsing context\. For example, Amazon Personalize can provide different recommendations when a user is browsing on a mobile device than when that same user is browsing on a desktop\.

With Amazon Personalize you can train a solution for different use cases\. For example, user personalization, items related to an item, and re\-ranking of items\. You choose a recipe based on your use case and provide the input data\. A recipe performs featurization of your data, and applies a choice of learning algorithms, along with default hyperparameters, and hyperparameter optimization job configuration\.

Recipes in Amazon Personalize allow you to create custom personalization models without needing machine learning expertise\. You can choose which recipe to use to train a solution version, or let Amazon Personalize decide on the best recipe to use for your data\. To help you decide which recipe to use, Amazon Personalize provides extensive metrics on the performance of a trained solution version\.

## Are You a First\-Time Amazon Personalize User?<a name="first-time-user"></a>

If you are a first\-time user of Amazon Personalize, we recommend that you read the following sections in order:

1. **[How It Works](how-it-works.md)** – This section introduces various Amazon Personalize components that you work with to create an end\-to\-end experience\.

1. **[Getting Started](getting-started.md)** – In this section you set up your account, and test the Amazon Personalize Console and API\.

1. **[Preparing and Importing Data](data-prep.md)** – This section describes how to prepare and import your training data into Amazon Personalize\.

1. **[Recording Events](recording-events.md)** – This section provides information about improving user recommendations by recording user events\.

1. **[Creating a Solution](training-deploying-solutions.md)** – This section provides information about creating a solution version by training a model\.

1. **[Creating a Campaign](campaigns.md)** – This section provides information about deploying a solution version as a campaign\.

1. **[Getting Recommendations](getting-recommendations.md)** – This section shows how to get recommendations from a campaign\.

## Are You an Experienced Amazon Personalize User?<a name="experienced-user"></a>

If you are an experienced Amazon Personalize user, you can find in\-depth tutorials and code samples in the [amazon\-personalize\-samples GitHub repository](https://github.com/aws-samples/amazon-personalize-samples)\.
# How It Works<a name="how-it-works"></a>

To make recommendations, Amazon Personalize uses a machine learning model that is trained with your data\. The data used to train the model is stored in related datasets in a dataset group\. Each model is trained by using a recipe that contains an algorithm for a specific use case\. In Amazon Personalize, a trained model is known as a solution version\. A solution version is deployed for use in a campaign\. Users of your applications can receive recommendations through the campaign\. For example, a campaign can show movie recommendations on a website or application where the title shown is based on viewing habits that were part of the dataset\.

A dataset can grow over time and your models can be retrained on the new data\. The data can come from new metadata and the consumption of real\-time user event data\. In the previous movie recommendations example, you could add new movies as they are released, and add a movie that is chosen by the signed\-in user\.

Amazon Personalize has an AWS console that you can use to create, manage, and deploy solution versions\. Alternatively, you can use the AWS Command Line Interface \(AWS CLI\) or one of the Amazon Personalize SDKs\.

Amazon Personalize consists of three related components:
+ Amazon Personalize – Use this to create, manage, and deploy solution versions\.
+ Amazon Personalize Events – Use this to record [events](API_UBS_Event.md) to add to your training data\. For more information, see [Recording Events](recording-events.md)\.
+ Amazon Personalize Runtime – Use this to get recommendations from a campaign \(deployed solution version\)\. For more information, see [Getting Recommendations](getting-recommendations.md)\.

**Topics**
+ [Amazon Personalize Workflow](#how-it-works-workflow)
+ [Datasets and Dataset Groups](#how-it-works-dataset)
+ [User Events](#how-it-works-events)
+ [Recipes and Solutions](#how-it-works-personalize-service-training)
+ [Metrics](#how-it-works-evaluation)
+ [Campaigns](#how-it-works-campaigns)
+ [Recommendations](#how-it-works-personalize-recommendations)

## Amazon Personalize Workflow<a name="how-it-works-workflow"></a>

The workflow for training, deploying, and getting recommendations from a campaign is:

1. Create related datasets and a dataset group\.

1. Get training data\.
   + Import historical data to the dataset group\.
   + Record user events to the dataset group\.

1. Create a solution version \(trained model\) using a recipe\.

1. Evaluate the solution version using metrics\.

1. Create a campaign \(deploy the solution version\)\.

1. Provide recommendations for users\.

The following sections provide a brief overview of the above workflow\. Each section includes a link to the main topic that describes the step in depth and which provides a Python example\.

The [Getting Started](getting-started.md) guides provide step\-by\-step procedures using the Amazon Personalize console, the AWS CLI, and a Jupyter \(iPython\) notebook\.

## Datasets and Dataset Groups<a name="how-it-works-dataset"></a>

Amazon Personalize requires data, stored in Amazon Personalize datasets, in order to train a model\.

There are two ways to provide the training data\. You can import historical data from an Amazon S3 bucket, and you can record event data as it is created\.

A dataset group contains related datasets\. Three types of historical datasets are created by the customer \(users, items, and interactions\), and one type is created by Amazon Personalize for live\-event interactions\. A dataset group can contain only one of each kind of dataset\.

You can create dataset groups to serve different purposes\. For example, you might have an application that provides recommendations for purchasing shoes and another that provides recommendations for places to visit in Europe\. In Amazon Personalize, each application would have its own dataset group\.

Historical data must be provided in a CSV file\. Each dataset type has a unique schema that specifies the contents of the CSV file\.

 The minimum data requirements to train a model are as follows: 
+  1000 records of combined interaction data \(after filtering by `eventType` and `eventValueThreshold`, if provided\)\.
+  25 unique users with at least 2 interactions each\. 

**Note**  
Using existing data allows you to immediately start training a model\. If you rely on recorded data as it is created, and there is no historical data, it can take a while before training can begin\.

For more information, see [Preparing and Importing Data](data-prep.md)\.

## User Events<a name="how-it-works-events"></a>

Amazon Personalize can consume real time [user events](API_UBS_Event.md) to be used for model training either alone or combined with historical data\.

For more information, see [Recording Events](recording-events.md)\.

## Recipes and Solutions<a name="how-it-works-personalize-service-training"></a>

After enough data is available in the interactions datasets \(historical and live events\), the data can be used to train a model\. A trained model is known as a solution version\. The model is trained using a recipe\. The recipes available in Amazon Personalize are made of an algorithm and the data processing steps that optimize a solution for a certain type of recommendation based on your input data\.

Amazon Personalize supports a number of predefined recipes\. Amazon Personalize can automatically choose the most appropriate recipe based on its analysis of the training data\. Alternatively, you can choose which recipe to train the model with\. Each recipe has its own use case and you should choose the recipe that best fits your needs\.

Each time you train a model, it is assigned a new solution version\. Use the solution version ARN to identify which version of the solution you want to use for your campaign\.

For more information, see [Creating a Solution](training-deploying-solutions.md)\.

## Metrics<a name="how-it-works-evaluation"></a>

After you have created your solution version, you evaluate the metrics that were created during training\. The metrics give an indication of the solution version's performance\. The console shows you the metrics and allows you to create a new solution version, as necessary\. Alternatively, you can call the [GetSolutionMetrics](API_GetSolutionMetrics.md) API\. Typically, you train your model with multiple recipes and use the recipe that results in the metrics that show the best performance\. After you have created a solution version based on your chosen recipe, the solution version is ready for deployment as a campaign\.

For more information, see [Evaluating a Solution Version](working-with-training-metrics.md)\.

## Campaigns<a name="how-it-works-campaigns"></a>

A deployed solution version is known as a campaign\. A campaign allows Amazon Personalize to make recommendations for your users\. To deploy a solution version, you create a campaign in the console or by calling the [CreateCampaign](API_CreateCampaign.md) API\. You choose which version of the solution to use\.

For more information, see [Creating a Campaign](campaigns.md)\. 

## Recommendations<a name="how-it-works-personalize-recommendations"></a>

After you create a campaign, you are able to get recommendations in real\-time or as part of a batch workflow with purely historical data\. For more information, see [Getting Recommendations](getting-recommendations.md)\.

**Real\-Time Recommendations**

 Get real\-time recommendations in situations where you want to update recommendations as customers use your application\. For example, say you provide movie recommendations to users signed into your application, and you want recommendations to update as they choose different movies\. 

 You are able to get two different types of real\-time recommendations: 
+ For user\-personalization and related\-items recipes, use the [GetRecommendations](API_RS_GetRecommendations.md) API to get a list of recommended items\. For example, movies can be recommended for users who are signed\-in to a website\.
+ For personalized\-ranking recipes, use the [GetPersonalizedRanking](API_RS_GetPersonalizedRanking.md) API to have Amazon Personalize re\-rank a list of recommended items based on a specified query\.

For more information see [Getting Real\-Time Recommendations](getting-real-time-recommendations.md)\.

**Batch Recommendations**

 Get batch recommendations in situations where you have large datasets that do not require real\-time updates\. For instance, you might create a batch inference job to get product recommendations for all users on an email list, or to get [item\-to\-item similarities \(SIMS\)](native-recipe-sims.md) across an inventory\. 

For more information see [Getting Batch Recommendations](recommendations-batch.md)\.
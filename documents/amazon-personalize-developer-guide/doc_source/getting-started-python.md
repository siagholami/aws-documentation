# Getting Started \(AWS SDK for Python\)<a name="getting-started-python"></a>

This topic explains how to get started programming Amazon Personalize with the AWS SDK for Python \(Boto3\)\.

## Prerequisites<a name="gs-sdk-prerequisites"></a>

The following are prerequisite steps for using the Python examples in this guide:
+ Complete the Getting Started [Getting Started Prerequisites](gs-prerequisites.md)\. You can use the same source data that is listed in the [Getting Started \(Console\)](getting-started-console.md) or [Getting Started \(AWS CLI\)](getting-started-cli.md) exercises\. If you are using your own source data, make sure your data is formatted like in the prerequisite step [Creating the Training Data](gs-prerequisites.md#gs-upload-to-bucket)\. For information about preparing your own source data, see [Preparing and Importing Data](data-prep.md)\. 
+ Set up your AWS SDK for Python \(Boto3\) environment, as specified in [Setting Up the AWS SDKs](aws-personalize-set-up-sdks.md)\.

After you finish this exercise, to avoid incurring unnecessary charges, delete the resources you created\. For more information, see [Clean Up Resources](gs-cleanup.md)\.

## Step 1: Verify Your Python Environment<a name="gs-python-example"></a>

After you complete the prerequisites, run the following Python example to confirm that your environment is configured correctly\. If your environment is configured correctly, a list of the available recipes is displayed and you can run the other Python examples in this guide\. 

```
import boto3

personalize = boto3.client('personalize')

response = personalize.list_recipes()

for recipe in response['recipes']:
    print (recipe)
```

## Step 2: Import Training Data<a name="getting-started-python-import-dataset"></a>

After you verify that your Python environment is configured correctly, import your data\. To use a dataset for training, you need to do the following:

1. Add a schema\. The schema allows Amazon Personalize to parse the training dataset\. For a code sample, see [Datasets and Schemas](how-it-works-dataset-schema.md)\.

1. Import the data\. You create a dataset group which contains one or several datasets that Amazon Personalize can use for training\. For a code sample, see [Import Your Data Using the AWS Python SDK](data-prep-importing.md#python-import-ex)\.

1. \(Optional\) Add an event tracker\. To add an event to train a model, you must add a tracking ID to associate the event with your dataset group\. For a code sample, see [Getting a Tracking ID](recording-events.md#event-get-tracker)\.

1. \(Optional\) Add an event record\. To add more data in training and create a better model, you can use events\. Events are recorded user activities such as a search, a view, or a purchase\. For a code sample, see [PutEvents Operation](recording-events.md#event-record-api)\.

## Step 3: Create a Solution<a name="getting-started-python-create-solution"></a>

After you import your data, create a solution and solution version\. The *solution* contains the configurations to train a model\. A *solution version* is a trained model\. For a code sample, see [Creating a Solution](training-deploying-solutions.md)\.

When you create a solution version, evaluate its performance before proceeding\. For a code sample, see [Evaluating a Solution Version](working-with-training-metrics.md)\.

## Step 4: Create a Campaign<a name="getting-started-python-deploy-solution"></a>

After you train and evaluate your solution version, you can deploy it using a campaign\. A campaign is an endpoint used to host a solution version and make recommendations to users\. For a code sample, see [Creating a Campaign](campaigns.md)\.

## Step 5: Get Recommendations<a name="getting-started-python-get-recommendations"></a>

After you create a campaign, you can use it to get recommendations\. For a code sample, see [GetRecommendations](getting-real-time-recommendations.md#recommendations)\.

## Getting Started Using Amazon Personalize APIs with Jupyter \(iPython\) Notebooks<a name="gs-jupyter-notebook"></a>

 To get started using Amazon Personalize using Jupyter notebooks, clone or download a series of notebooks found in the [getting\_started](https://github.com/aws-samples/amazon-personalize-samples/tree/master/getting_started) folder of the [Amazon Personalize Samples](https://github.com/aws-samples/amazon-personalize-samples) repository\. The notebooks walk you through importing training data, creating a solution, creating a campaign, and getting recommendations using Amazon Personalize\.

**Note**  
 Before starting with the notebooks, make sure to build your environment following the steps in the [README\.md](https://github.com/aws-samples/amazon-personalize-samples/blob/master/getting_started/README.md) 
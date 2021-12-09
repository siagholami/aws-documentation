# Quotas in Amazon Personalize<a name="limits"></a>

The following sections contain information about Amazon Personalize guidelines and quotas\.

**Topics**
+ [Supported AWS Regions](#regions)
+ [Compliance](#ompliance)
+ [Service Quotas](#limits-table)
+ [Requesting a Quota Increase](#requesting-limit-increase)

## Supported AWS Regions<a name="regions"></a>

For a list of AWS Regions that support Amazon Personalize, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/personalize.html) in the *Amazon Web Services General Reference*\.

## Compliance<a name="ompliance"></a>

For more information about Amazon Personalize compliance programs, see [AWS Compliance](https://aws.amazon.com/compliance/), [AWS Compliance Programs](https://aws.amazon.com/compliance/programs/), and [AWS Services in Scope by Compliance Program](https://aws.amazon.com/compliance/services-in-scope)\.

## Service Quotas<a name="limits-table"></a>

Your AWS account has the following quotas for Amazon Personalize\.


| Resource | Quota | 
| --- | --- | 
| Maximum amount of data for an individual dataset \(Users, Items, or Interactions\) for HRNN, SIMS, Popularity\-Count, and Personalized\-Ranking recipes\. | 100 GB | 
| Maximum amount of data for Interactions dataset for HRNN\-metadata and HRNN\-coldstart recipes\. | 100 GB | 
| Maximum amount of combined data for Users and Items datasets for HRNN\-metadata and HRNN\-coldstart recipes\. | 5 GB | 
| Maximum number of filters per account | 10 filters | 
| Minimum number of unique combined historical and event interactions \(after filtering by eventType and eventValueThreshold, if provided\) required to train a model \(training a model means you create a solution version\)\. | 1000 | 
| Minimum number of unique users, with at least 2 interactions each, required to train a model \(training a model means you create a solution version\)\. | 25 | 
| Maximum number of interactions that are considered by a model during training\. | 500 million | 
| Maximum number of items that are considered by a model during training\. | 750 thousand | 
| Maximum number of cold start items the HRNN\-Coldstart recipe supports to train a model \(training a model means you create a solution version\)\. | 80,000 | 
| Minimum number of cold start items the HRNN\-Coldstart recipe requires to train a model \(training a model means you create a solution version\)\. | 100 | 
| Maximum transaction rate \(GetRecommendations and GetPersonalizedRanking requests\)\. | 2500/sec | 
| Maximum number of GetRecommendations requests per second per campaign\. | 500/sec | 
| Maximum number of GetPersonalizedRanking requests per second per campaign\. | 500/sec | 
| Maximum rate of PutEvents requests\. | 1000 per second sec | 
| Maximum number of events in a PutEvents call\. | 10 | 
| Maximum size of an event\. | 10 KB | 
| Maximum number of input files in a batch inference job\. | 1000 | 
| Maximum size of batch inference job input\. | 1 GB | 
| Maximum number of records per input file in a batch inference job\. | 50 million | 

Your AWS account has the following quotas per region for Amazon Personalize\.


| Resource | Quota | 
| --- | --- | 
| Total number of active schemas\. | 500 | 
| Total number of active datasets\. | 500 | 
| Total number of active dataset groups\. | 500 | 
| Total number of active event trackers\. | 500 | 
| Total number of active solutions\. | 500 | 
| Total number of active campaigns\. | 5 | 
| Total number of pending or in progress batch inference jobs | 5 | 
| Total number of pending or in progress solution versions | 20 | 

## Requesting a Quota Increase<a name="requesting-limit-increase"></a>

 For adjustable quotas, you can request a quota increase\. The following Amazon Personalize quotas are adjustable: 
+  Total number of active campaigns 
+  Maximum number of filters per account 
+  Total number of pending or in progress batch inference jobs 
+  Total number of pending or in progress solution versions 
+  Maximum rate of `PutEvents` requests 

 To request a quota increase, use the [Service Quotas console](https://console.aws.amazon.com/servicequotas/) and follow the steps in the [Requesting a Quota Increase](https://docs.aws.amazon.com/servicequotas/latest/userguide/request-quota-increase.html) section of the *Service Quotas User Guide*\. 
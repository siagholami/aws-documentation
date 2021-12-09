--------

--------

# What is Amazon Kendra?<a name="what-is-kendra"></a>

Amazon Kendra is an enterprise search service that enables your users to intuitively search unstructured data using natural language\. It returns specific answers to questions, giving users an experience that's close to interacting with a human expert\. It is highly available and scalable, tightly integrated with other AWS services, and offers enterprise\-grade security\.

Amazon Kendra users can ask the following types of questions, or queries:
+ **Factoid questions** — Simple who, what, when, or where questions, such as *Who is Amazon’s CEO?* or *What is the height of the Space Needle?*\. Factoid questions have fact\-based answers that can be returned in the form of a single word or phrase\. The precise answer, however, must be explicitly stated in the ingested text content\.
+ **Descriptive questions** — Questions whose answer could be a sentence, passage, or an entire document\. For example, *How do I connect my Echo Plus to my network?* or *How do I get tax benefits for lower income families?*\. 
+ **Keyword searches**— For questions where the intent and scope isn't clear, for example, *vacation policy* or *health benefits*, Amazon Kendra uses its deep learning models to return relevant documents\. 

## Benefits of Amazon Kendra<a name="what-is-benefits"></a>

Amazon Kendra has the following benefits:
+ **Accuracy** — Unlike traditional search services that use keyword searches where results are based on basic keyword matching and ranking, Amazon Kendra attempts to understand the content, the user context, and the question\. Amazon Kendra searches across your data and goes beyond traditional search to return the most relevant word, snippet, or document for your query\. Amazon Kendra uses machine learning to improve search results over time\. 
+ **Simplicity** — Amazon Kendra provides a console and API for managing the documents that you want to search\. You can use a simple search API to integrate Amazon Kendra into your client applications, such as websites or mobile applications\.
+ **Connectivity** — Amazon Kendra can connect to third\-party data sources to provide search across documents managed in different environments\.

## Amazon Kendra Developer Edition<a name="akde"></a>

The Amazon Kendra Developer Edition provides all of the features of Amazon Kendra at a lower cost\. It includes a free tier that provides 750 hours of use\. The Developer Edition is ideal to explore how Amazon Kendra indexes your documents, to try out features, and to develop applications that use Amazon Kendra\. 

The developer edition provides the following:
+ Up to 5 indexes with up to 5 data sources each
+ 10,000 documents or 3 Gb of extracted text
+ 4,000 queries per day
+ Runs in 1 availability zone \(AZ\)

You should not use the Developer Edition for a production application\. The Developer Edition doesn't provide any guarantees of latency or availability\.

## Amazon Kendra Enterprise Edition<a name="akee"></a>

Use Amazon Kendra Enterprise Edition when you want to index your entire enterprise document library or for when your application is ready for use in a production environment\. The enterprise edition provides the following\. You can increase this quota using the [Service Quotas console](https://console.aws.amazon.com/servicequotas/home)\.
+ Up to 5 indexes with up to 50 data sources each\. 
+ 500,000 documents or 150 Gb of extracted text\.
+ 40,000 queries per day\.
+ Runs in 3 availability zones \(AZ\)

## Pricing for Amazon Kendra<a name="pricing"></a>

You can get started for free with the Amazon Kendra Developer Edition that provides usage of up to 750 hours for the first 30 days\. After your trial expires, you are charged for all provisioned Amazon Kendra indexes, even if they are empty and no queries are executed\. After the trial expires, there are additional charges for scanning and syncing documents using the Amazon Kendra data sources\.

For a complete list of charges and prices, see [ Amazon Kendra pricing](https://aws.amazon.com/kendra/pricing/)\.

## Are you a first\-time Amazon Kendra user?<a name="first-time-user"></a>

If you are a first\-time user of Amazon Kendra, we recommend that you read the following sections in order:

1. [How Amazon Kendra works](how-it-works.md) – Introduces the Amazon Kendra components and describes how you use them to create a search solution\. 

1. [Getting started](getting-started.md) – Explains how to set up your account and test the Amazon Kendra search API\.

1. [Creating an index](create-index.md) – Explains how to use Amazon Kendra to create a search index and to add data sources to sync your documents\.

1. [Adding documents directly to an index](in-adding-documents.md) – Explains how to add documents directly to an Amazon Kendra index\.

1. [Searching indexes](searching.md) – Explains how to use the Amazon Kendra search API to search an index\.

1. [Deploying Amazon Kendra](deploying.md) – Provides a sample application you can use to deploy Amazon Kendra to your website\.
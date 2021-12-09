--------

--------

# Using a Salesforce data source<a name="data-source-salesforce"></a>

Amazon Kendra can connect to your Salesforce server to index your customer relationship information\. When you use Amazon Kendra to index your Salesforce server, you can choose to index up to 17 of the standard Salesforce objects\. You can also index knowledge articles, chatter feeds, and attachments\.

Amazon Kendra uses the Salesforce API version 48\. The Salesforce API limits the number of requests that you can make per day\. If Amazon Kendra exceeds those requests, it retries until it is able to continue\.

Before you can connect Amazon Kendra to your Salesforce server, you must create a Salesforce connected app with OAuth enabled so that Amazon Kendra can connect\. When you create an app, it is assigned a consumer key and a consumer secret that Amazon Kendra uses to connect to the app\.

You must provide Amazon Kendra with credentials to access your Salesforce server\. These credentials identify the user making the connection and the Salesforce connected app that Amazon Kendra connects to\.

The credentials should be for a user with read\-only access to Salesforce\. To create permissions for the user, clone the ReadOnly profile and then add the View All Data and Manage Articles permissions\.

You store the credentials in an AWS Secrets Manager secret\. If you are using the console to create your data source, you can create the secret there, or you can use an existing Secrets Manager secret\. If you are using the API, you must provide the Amazon Resource Name \(ARN\) of an existing secret\.

The secret must contain the following information:
+ `authenticationUrl` – The URL of the OAuth authentication server used to authenticate with Salesforce\. Typically, this is https://login\.salesforce\.com/services/oauth2/token\.
+ `consumerKey` – The consumer key, also called the client ID, of the Salesforce Connected App that is used to index the server\. The app must have permission that allows access to the REST API\.
+ `consumerSecret` – The consumer secret, also called the client secret, of the Salesforce Connected App used to index the server\.
+ `securityToken` – The Salesforce security token associated with the account used to connect to Salesforce\.
+ `password` – The password associated with the account used to connect to Salesforce\.
+ `username` – The user name of the account used to connect to Salesforce\. The account must have read access to the objects and fields that you want to index\.

The credentials are stored as a JSON string in the Secrets Manager secret\. The following is the minimum JSON structure that must be in the secret:

```
{
    "username": "user name",
    "password": "password",
    "securityToken": "token",
    "consumerKey": "key",
    "consumerSecret": "secret",
    "authenticationUrl": "https://login.salesforce.com/services/oauth2/token"
}
```

The data source IAM role must have permission to access the secret\. For more information, see [IAM role for Salesforce data sources](iam-roles.md#iam-roles-ds-sf)\.

The secret can contain more information, however, Amazon Kendra ignores other fields\. For more information, see [ What is AWS Secrets Manager ](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html) in the *AWS Secrets Manager User Guide*\.

You must create an index before you create the Salesforce data source\. For more information, see [Creating an index](create-index.md)\. You provide the ID of the index when you create the data source\.

You specify connection and other information in the console or using an instance of the [SalesforceConfiguration](API_SalesforceConfiguration.md) data type\. You must provide the following information: 
+ The URL of the Salesforce server that contains the information to index\.
+ The credentials required to connect to the Salesforce server\.

You must provide configuration information for indexing at least one of the following:
+ Salesforce objects
+ Salesforce knowledge articles
+ Salesforce chatter feeds

You can optionally:
+ Provide configuration information for indexing attachments\.
+ Indicate whether Amazon Kendra should gather access control information for user context filtering\.

## Standard objects<a name="salesforce-standard-objects"></a>

Salesforce provides an extensive list of standard objects that contain information about your customer relations\. You can choose to index any of these standard objects:
+ Account
+ Campaign
+ Case
+ Contact
+ Contract
+ Chatter
+ Document
+ Group
+ Idea
+ Lead
+ Opportunity
+ Partner
+ Pricebook
+ Product
+ Profile
+ Solution
+ Task
+ User

For each object, you must map an object field to the Amazon Kendra built\-in `_body` field so that Amazon Kendra knows where to find the object content to index\. You can map additional object fields to custom Amazon Kendra fields\. 

Salesforce enables you to add custom fields to standard objects\. To use the custom field with Amazon Kendra, you must use the internal Salesforce field name\. The internal name is the name of the field followed by "\_\_c" \(two underscores and the character c\)\. For example, if you have a custom field named `AccountOriginalOwner`, the internal name is `AccountOriginalOwner__c`\.

You can map fields from multiple objects to a single Amazon Kendra field\. For example, you can map the Account object `Name` field and the Partner object `Name` field to the same Amazon Kendra custom field\.

Once you save the mapping between an Amazon Kendra field and a Salesforce object field, you can't change the mapping\. However, you can add more mappings between Amazon Kendra and Salesforce\.

For more information, see [Mapping data source fields](field-mapping.md)\.

## Knowledge articles<a name="salesforce-knowledge-article"></a>

You can use Amazon Kendra to index the contents of standard knowledge articles or custom knowledge articles\. 

When you index standard knowledge articles, Amazon Kendra will index every article on your server, including the standard fields of custom knowledge articles\. If you index custom knowledge articles, Amazon Kendra indexes only articles of that type\. It won't index the contents of standard knowledge articles\. 

You configure indexing of knowledge articles using the console or the [SalesforceKnowledgeArticleConfiguration](API_SalesforceKnowledgeArticleConfiguration.md) object\. You can indicate the status of the articles that you want to index, you can tell Amazon Kendra to index draft, published, or archived articles\.

For custom knowledge articles, you must specify the name of the custom article type\. You must specify the internal name of the article type, which is the name of the type plus "\_\_kav" \(two underscores followed by the characters kav\)\. For example, if you have a customer article type called `CustomKnowledgeArticleForTech`, the internal name is `CustomKnowledgeArticleForTech__kav`\. You can specify up to 10 article types\.

For both custom and standard knowledge articles, you must specify the name of the field that contains the content of the article\. You can optionally specify the field that contains the title\. You can map additional article fields to custom Amazon Kendra fields using the console or the [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) object\.

## Chatter feeds<a name="salesforce-chatter-feeds"></a>

You can index the contents of your Salesforce chatter feeds\. You configure indexing using the console or the [SalesforceChatterFeedConfiguration](API_SalesforceChatterFeedConfiguration.md) object\. 

You must specify the field in the Salesforce FeedItem table that contains the content of the item\. Typically this is the "Body" column\. You have the option of specifying the title of the item\. Typically, this is the "Title" column of the FeedItem table\. You can map additional fields to custom Amazon Kendra fields using the console or the [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) object\.

By default, Amazon Kendra indexes all items on the chatter feed\. You can use the console or the `IncludeFilterType` field of the `SalesforceChatterFeedConfiguration` object to limit indexing to only those items that are from standard Salesforce users or from active user accounts\.

You can map additional fields to custom Amazon Kendra fields using the console or the [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) object\.

## Attachments<a name="salesforce-attachments"></a>

You can choose to have Amazon Kendra index attachments to standard objects, knowledge articles, and chatter feeds\. You can use the console or the `CrawlAttachments` option on the [SalesforceConfiguration](API_SalesforceConfiguration.md) structure to indicate whether attachments should be indexed\.

By default, Amazon Kendra indexes all attachments\. You can use the console or the API o filter attachments from the list that is indexed\. To filter an attachment, you use a regular expression that is evaluated against the file name of the attachment\. For example, to remove JSON files from the list of indexed files, use a regular expression that filters out files that end with "\.json"\.

You can also restrict indexed documents by specifying the attachments to index\. For example, to index only Microsoft Word files, specify a regular expression that selects files that end with "\.doc" or "\.docx\."
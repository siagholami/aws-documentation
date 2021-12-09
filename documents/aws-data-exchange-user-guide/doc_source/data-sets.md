# Working with Data Sets<a name="data-sets"></a>

This section covers AWS Data Exchange data sets, their components, properties, and related conceptual information\. A data set is a collection of data that can change over time\.
+ **Data Sets** – A data set is a series of one or more revisions\. When you access a data set, you're typically accessing a specific revision in the data set\. This structure enables providers to change the data available in data sets over time without having to worry about changes to historical data\.
+ **Revisions** – A revision is a container for one or more assets\. For example, a collection of CSV files or a single CSV file and a dictionary are grouped to create a revision\. As new data is available, you create revisions and add assets\. For more information, see [Revisions](#revisions)\.
+ **Assets** – An asset in AWS Data Exchange is a piece of data that can be stored as an Amazon S3 object\. The asset can be a structured data file, an image file, or some other data file\. When you upload files to AWS Data Exchange, you create an asset in AWS Data Exchange for each of those files\. For more information, see [Assets](#assets)\.

You can use the AWS Data Exchange console, AWS CLI, your own REST client, or one of the AWS SDKs to create, view, update, or delete data sets\. For more information about programmatically managing AWS Data Exchange data sets, see the [AWS Data Exchange API Reference](https://docs.aws.amazon.com/data-exchange/latest/apireference)\.

## Owned Data Sets<a name="owned-data-sets"></a>

A data set is owned by the account that created it\. Owned data sets can be identified using the origin parameter, which is set to `OWNED`\.

## Entitled Data Sets<a name="entitled-data-sets"></a>

Entitled data sets are a read\-only view of owned data sets\. Entitled data sets are created at time of product publishing and are made available to subscribers who have an active subscription to the product\. Entitled data sets can be identified using the origin parameter, which is set to `ENTITLED`\.

As a data subscriber, you can view and interact with your entitled data sets using the AWS Data Exchange APIs, or in the Console\.

As a data provider, you also have access to the entitled data set view that your subscribers see\. You can do so using the AWS Data Exchange APIs, or the Console, by choosing the data set name in the product page\.

## AWS Regions and Data Sets<a name="data-set-regions"></a>

Your data sets can be in any supported AWS Region, but all data sets in a single product must be in the same AWS Region\.

## Data Sets Published to Multiple Products<a name="data-set-multiple-products"></a>

As a provider, you can add the same data set to multiple products, and choose the revisions that are available in each product\. For example, if you offer data that is updated regularly, you can provide it in two products: one updated weekly and the other daily\.

If the same data set is published into multiple products, a distinct entitled data set is created for each product, each with a distinct data set ID\.

## Tags<a name="data-set-tags"></a>

You can add tags to your owned data sets and their revisions\. When you use tagging, you can also use tag\-based access control in IAM policies to control access to these data sets and revisions\.

Entitled data sets can't be tagged\. Tags of owned data sets and their revisions are not propagated to their corresponding entitled versions\. Specifically, subscribers, who have read\-only access to entitled data sets and revisions, won't see the tags of the original owned data set\.

**Note**  
Currently, assets and jobs don't support tagging\.

## Data Set Structure<a name="data-set-structure"></a>

Data sets have the following parameters:
+ `Name` – The name of the data set\. This value can be up to 256 characters long\.
+ `Description` – A description for the data set\. This value can be up to 16,348 characters long\.
+ `Asset type` – Defines the type of assets the data set contains\. Currently, the only supported asset type is snapshots of Amazon S3 objects\.
+ `Origin` – A property that defines the data set as `Owned` by the account \(for providers\) or `Entitled` to the account \(for subscribers\)\. 
+ `Data set ID` – An ID that uniquely identifies the data set\. Data set IDs are generated at data set creation\. Entitled data sets have a different ID than the original owned data set\.
+ `Amazon Resource Name (ARN)` – A unique identifier for an AWS resource\.
+ `Created and updated dates` – Timestamps for the creation and last update of the data set\.

**Note**  
As a provider, you can change some properties for owned data sets, like the name or description\. Updating properties in an owned data set won't update the properties in the corresponding entitled data set\.

**Example Data Set Resource**  

```
{
    "Origin": "OWNED", 
    "AssetType": "S3_SNAPSHOT", 
    "Name": "MyDataSetName", 
    "CreatedAt": "2019-09-09T19:31:49.704Z", 
    "UpdatedAt": "2019-09-09T19:31:49.704Z", 
    "Id": "fEXAMPLE1fd9a5c8b0d2e6fEXAMPLEe1", 
    "Arn": "arn:aws:dataexchange:us-east-2:123456789109:data-sets/fEXAMPLE1fd9a5c8b0d2e6fEXAMPLEe1", 
    "Description": "This is my data set's description that describes the contents of the data set."
}
```

## Data Set Best Practices<a name="data-set-best-practices"></a>

As a provider, when you create and update data sets, keep the following best practices in mind:
+ The name of the data set is visible in the product details in the catalog\. We recommend that you choose a concise, descriptive name so customers easily understand the content of the data set\.
+ The description is visible to subscribers who have an active subscription to the product\. We recommend that you include coverage information and the features and benefits of the data set\.

## Revisions<a name="revisions"></a>

Data sets can be updated over time\. When you want to add or change a file in a data set, you create a revision\. You can create and add revisions programmatically or through the console\.

When they're created, revisions are not published to products, and therefore are not available to subscribers\. To publish a revision to a data set in a product, the revision must first be *finalized*\. Finalizing a revision tells AWS Data Exchange that your changes to the assets in the revision are complete\. After the revision is in this finalized \(read\-only\) state, you can publish it to your products\.

You can use the AWS Data Exchange console or the AWS Marketplace Catalog API to publish finalized revisions\. If you choose the API, use the [StartChangeSet](https://docs.aws.amazon.com/marketplace-catalog/latest/api-reference/API_StartChangeSet.html) AWS Marketplace Catalog API action\. Revisions are uniquely identified by their ARN\.

Keep the following in mind:
+ A revision must be marked as finalized before it can be published to a product\.
+ To be finalized, a revision must contain at least one asset\.
+ It is your responsibility to ensure that the assets are correct before you finalize your revision\.
+ A finalized revision is staged for publishing\. No changes can be made to it in the finalized state\.
+ Before a finalized revision is published, it can be unfinalized, allowing you to make changes\. After you make your changes, you can finalize it again for publishing\.
+ A finalized revision published to at least one product cannot be unfinalized or changed in any way\.

**Important**  
Any revision published to a product is immutable and can't be edited, changed, or deleted\. If you need to remove published content for compliance reasons, contact [AWS Support](http://aws.amazon.com/premiumsupport)\.

### Revision Structure<a name="revisions-structure"></a>

Revisions have the following parameters:
+ `Data set ID` – The ID of the data set that contains this revision\.
+ `Comment` – A comment about the revision\. This field can be 128 characters long\. 
+ `Finalized state` – Either true or false\. Used to indicate whether the revision is finalized\.
+ `ID` – The unique identifier for the revision generated when it's created\.
+ `Amazon Resource Name (ARN)` – A unique identifier for an AWS resource\.
+ `Created and updated dates` – Timestamps for the creation and last update of the revision\. Entitled revisions are created at the time of publishing\.

**Example Revision Resource**  

```
        {
            "UpdatedAt": "2019-10-11T14:13:31.749Z",
            "DataSetId": "1EXAMPLE404460dc9b005a0d9EXAMPLE2f",
            "Comment": "initial data revision",
            "Finalized": true,
            "Id": "e5EXAMPLE224f879066f9999EXAMPLE42",
            "Arn": "arn:aws:dataexchange:us-east-1:123456789012:data-sets/1EXAMPLE404460dc9b005a0d9EXAMPLE2f/revisions/e5EXAMPLE224f879066f9999EXAMPLE42",
            "CreatedAt": "2019-10-11T14:11:58.064Z"
        }
```

## Assets<a name="assets"></a>

Assets are the *data* in AWS Data Exchange\. Each asset is a snapshot of an Amazon S3 object, with a maximum size of 10 GB\. You can use the console, or programmatically through the AWS CLI, your own REST application, or one of the AWS SDKs to create or copy assets through jobs\.

A data set owner can both import and export, but someone with an entitlement to a data set can only export\.

### Asset Structure<a name="assets-structure"></a>

Assets have the following parameters:
+ `Data set ID` – The ID of the data set that contains this asset\.
+ `Revision ID` – The ID of the revision that contains this asset\.
+ `ID` – A unique ID generated when the asset is created\. 
+ `Amazon Resource Name (ARN)`> – A uniquely identifier for an AWS resource\.
+ `Created and updated dates` – Timestamps for the creation and last update of the asset\.
+ `Asset details` – Information about the asset, including its size\.
+ `Asset Type` – Currently, the only type of asset available is a snapshot of an Amazon S3 object\.

**Example Asset Resource**  

```
{
    "Name": "automation/cloudformation.yaml",
    "Arn": "arn:aws:dataexchange:us-east-1::data-sets/29EXAMPLE24b82c6858af3cEXAMPLEcf/revisions/bbEXAMPLE74c02f4745c660EXAMPLE20/assets/baEXAMPLE660c9fe7267966EXAMPLEf5",
    "Id": "baEXAMPLE660c9fe7267966EXAMPLEf5",
    "CreatedAt": "2019-10-17T21:31:29.833Z",
    "UpdatedAt": "2019-10-17T21:31:29.833Z",
    "AssetType": "S3_SNAPSHOT",
    "RevisionId": "bbEXAMPLE74c02f4745c660EXAMPLE20",
    "DataSetId": "29EXAMPLE24b82c6858af3cEXAMPLEcf",
    "AssetDetails": {
        "S3SnapshotAsset": {
            "Size": 9423
        }
    }
}
```
# AddRevisions<a name="add-revisions"></a>

In order to publish new data set revisions to your AWS Data Exchange product, you need to create a change set of type `AddRevisions`\. To do so, you can use the `StartChangeSet` API and specify the change type, the product id, the product type, and the details including the data set and revision ARNs\.

You can update multiple products in a single `AddRevisions` change set\. Each change is scoped to a single data set within a product\. If your product has more than one data set and you need to update all of them, create a separate change for each data set\.

## Tutorial: Adding New Data Set Revisions to a Published Data Product<a name="add-revisions-tutorial"></a>

This tutorial walks you through detailed steps to publish new AWS Data Exchange data set revisions to an existing product\. The tutorial has the following high\-level steps\.

**Topics**
+ [Set Up IAM Permissions](#catalog-iam-permissions)
+ [Access the AWS Marketplace Catalog API](#access-catalog-api)
+ [Get Your Product ID from the AWS Data Exchange Console](#get-data-exchange-product-id)
+ [Describe Product Details](#describe-product-details)
+ [Start a Change Request](#start-change-request)
+ [Check the Status of Your Change Set](#check-change-status)

### Set Up IAM Permissions<a name="catalog-iam-permissions"></a>

Before you begin, you need IAM permissions for using the AWS Marketplace Catalog API\. These permissions are in addition to the permissions you need for using AWS Data Exchange\.

1. Navigate your browser to the IAM console and sign in using an AWS account that can manage IAM permissions\.

1. From the left navigation pane, choose **Policies**\.

1. Choose **Create policy**\.

1. Choose the **JSON** tab, and provide the following permissions\. This provides full access to the AWS Marketplace Catalog API\. You can restrict access as appropriate for your use case\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": [
           "aws-marketplace:CancelChangeSet",
           "aws-marketplace:ListChangeSets",
           "aws-marketplace:DescribeEntity",
           "aws-marketplace:StartChangeSet",
           "aws-marketplace:ListEntities",
           "aws-marketplace:DescribeChangeSet"
         ],
         "Resource": "*"
       }
     ]
   }
   ```

1. Choose **Review policy**\.

1. Provide a name for the policy \(for example, **CatalogAPIFullAccess**\), and then choose **Create Policy**\.

1. Using the IAM console, choose the users, groups, or roles that you want to attach the policy to\.

### Access the AWS Marketplace Catalog API<a name="access-catalog-api"></a>

To access the AWS Marketplace Catalog API, use the following HTTP client endpoint\.

```
catalog.marketplace.us-east-1.amazonaws.com
```

### Get Your Product ID from the AWS Data Exchange Console<a name="get-data-exchange-product-id"></a>

Before you can use the AWS Marketplace Catalog API to publish new revisions, get your product ID from the AWS Data Exchange console\. Navigate to the **Product Dashboard**, and then copy the product ID you would like to publish revisions for\.

### Describe Product Details<a name="describe-product-details"></a>

Before you add revisions to a data set in your data product, you must make a `DescribeEntity` call with the ID of your product\. The output contains the product details and an `EntityIdentifier` attribute, which is the entity ID \(your product ID\) appended with a `revision number` \(for example, `@9`\)\. The revision number reflects the most recent edit or change made to your published product\.

**Sample Request**

```
https://catalog.marketplace.us-east-1.amazonaws.com/DescribeEntity?catalog=AWSMarketplace&entityId=entity-id
```

**Sample Response**

```
{
    "Details": "{\"Title\":\"Example Data Product\",\"Presentation\":{\"ShortDescription\":\"Descriptive text that appears on the tiles in the Product catalog page\",\"FullDescription\":\"Descriptive text that appears on the product's detail page after the product is published. \",\"Logo\":\"logo-url\",\"Highlights\":[]},\"Lifecycle\":\"Public\",\"ProductCode\":\"product-code\",\"DataSets\":[{\"ProductDataSetId\":\"product-data-set-id\",\"DataSetArn\":\"data-set-arn\",\"Name\":\"Example Data Set\",\"Description\":\"Example Data Set\",\"CreationDate\":\"2019-09-08T16:10:33.011Z\",\"LastRevisionAddedDate\":\"2019-09-08T16:10:33.011Z\",\"PublishedDataSetArn\":\"published-data-set-arn\"}]}",
    "EntityArn": "arn:aws:aws-marketplace:us-east-1:account-id:AWSMarketplace/DataProduct/entity-id",
    "EntityIdentifier": "entity-id@1",
    "EntityType": "DataProduct@1.0",
    "LastModifiedDate": "2019-09-08T16:10:38.287Z"
}
```

**Note**  
If you are using an HTTP client, you must unescape the JSON output to view the data in a nested structure\. You might also need to reform the output to suit your needs\.

### Start a Change Request<a name="start-change-request"></a>

To start a change request to add revisions to a data set in your test product:

1. Copy the `DescribeEntity` response from [Describe Product Details](#describe-product-details) and include the following elements:
   + Entity type with the version number \(for example, `DataProduct@1.0`\)\.
   + Identifier with the revision number \(for example, `product-test@1`\)\.
   + The `DataSetArn` for the data set to which you would like to add revisions \(for example, `arn:aws:dataexchange:us-east-1:account-id:data-sets/data-set-id`\)\.

1. Make a `StartChangeSet` request with an `AddRevisions` change type\. The details of the `AddRevisions` change object, in the request body, should contain the following: 
   + `DataSetArn` should be the data set to which you'd like to add revisions\.
   + `RevisionArns` should be a list of the revisions that you want to publish to the data set in the product\. For more information about the number of revisions that a single change can include, see [AWS Data Exchange Limits](limits.md)\.

**Sample Request**

```
https://catalog.marketplace.us-east-1.amazonaws.com/StartChangeSet
```

**Sample Request Body**

```
{
  "Catalog": "AWSMarketplace",
  "ChangeSetName": "Adding revisions to my test Data Product",
  "ChangeSet": [
    {
      "ChangeType": "AddRevisions",
      "Entity": {
        "Identifier": "entity-id@1",
        "Type": "DataProduct@1.0"
      },
      "Details": "{\"DataSetArn\": \"data-set-arn\", \"RevisionArns\": [\"revision-arn\", \"revision-arn-2\"] }"
    }
  ]
}
```

**Sample Response**

```
{
  "ChangeSetId": "cs-bnEXAMPLE4mkz9oh",
  "ChangeSetArn": "arn:aws:aws-marketplace:us-east-1:account-id:AWSMarketplace/ChangeSet/cs-bnEXAMPLE4mkz9oh"
}
```

### Check the Status of Your Change Set<a name="check-change-status"></a>

After you use the `StartChangeSet` API to start the change request, you can use the `DescribeChangeSet` API to check its status\. Provide the change set ID returned in the `StartChangeSet` API response\.

**Sample Request**

```
https://catalog.marketplace.us-east-1.amazonaws.com/DescribeChangeSet?catalog=AWSMarketplace&changeSetId=cs-bnEXAMPLE4mkz9oh
```

**Sample Request Body**

```
{
"changeSetId":"cs-bnEXAMPLE4mkz9oh"
}
```

**Sample Response**

```
{
    "ChangeSetId": "cs-bnEXAMPLE4mkz9oh",
    "ChangeSetArn": "arn:aws:aws-marketplace:us-east-1:account-id:AWSMarketplace/ChangeSet/cs-bnEXAMPLE4mkz9oh",
    "ChangeSetName": "Adding revisions to my test Data Product",
    "StartTime": "2018-09-20T19:45:03.115+0000",
    "EndTime": "2018-09-20T19:48:12.517+0000",
    "Status": "SUCCEEDED",
    "FailureDescription": null,
    "ChangeSet": [
        {
            "ChangeType": "AddRevisions",
            "Entity": {
                "Type": "DataProduct@1.0",
                "Identifier": "entity-id@1"
            },
            "ErrorList": []
        }
    ]
}
```

## AddRevisions exceptions<a name="catalog-exceptions-revisions"></a>

The following exceptions can occur when you use the AWS Marketplace Catalog API with AWS Data Exchange:

**REVISION\_NOT\_FOUND**  
This happens when the requested resource was not found\. To resolve this issue, make sure that there's not a typo in the revision ARN and that your AWS account owns the resource, and try again\.

**REVISION\_NOT\_FINALIZED**  
Revisions must be finalized prior to being added to AWS Data Exchange products\. To resolve this issue, ensure that the revisions with your specified ARNs are finalized, and try again\.

**DATA\_SET\_NOT\_FOUND**  
This happens when the requested data set was not found\. To resolve this issue, ensure that there's not a typo in the data set ARN and that your AWS account owns the data set, and try again\.

**INVALID\_INPUT**  
The request couldn't be processed due to invalid input\. To resolve this issue, ensure that there's not a typo in the request and that the list of revisions has at least one and no more than five revisions\.

**DATA\_SET\_NOT\_PUBLISHED**  
The requested resource has not been published in this product\. To resolve this issue, ensure that there's not a typo in the ARN\(s\) for the data set\(s\)\. You can also publish a new product that includes those data set\(s\)\.

**REVISION\_DUPLICATE\_PROVIDED**  
This happens when the same revision request occurs more than once\. To resolve this issue, ensure that the revisions aren't duplicates, and try again\.
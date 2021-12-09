# AddDataSets<a name="add-data-sets"></a>

In order to add data sets to your AWS Data Exchange product, you need to start a change set of type `AddDataSets`\. To do so, you can use the `StartChangeSet` API and specify the change type, the product identifier, the product type, and the details including the data set ARN\.

## Tutorial: Adding new data sets to a published data product<a name="add-data-sets-tutorial"></a>

This tutorial walks you through detailed steps to publish new AWS Data Exchange data sets to an existing product\. The tutorial has the following high\-level steps\.

**Topics**
+ [Set Up IAM Permissions](#data-set-catalog-iam-permissions)
+ [Access the AWS Marketplace Catalog API](#data-set-access-catalog-api)
+ [Get Your Product ID from the AWS Data Exchange Console](#get-data-set-exchange-product-id)
+ [Describe Product Details](#describe-data-set-product-details)
+ [Start a Change Request](#start-data-set-change-request)
+ [Check the Status of Your Change Set](#check-data-set-change-status)

### Set Up IAM Permissions<a name="data-set-catalog-iam-permissions"></a>

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

### Access the AWS Marketplace Catalog API<a name="data-set-access-catalog-api"></a>

To access the AWS Marketplace Catalog API, use the following HTTP client endpoint\.

```
catalog.marketplace.us-east-1.amazonaws.com
```

### Get Your Product ID from the AWS Data Exchange Console<a name="get-data-set-exchange-product-id"></a>

Before you can use the AWS Marketplace Catalog API to publish new data sets, get your product ID from the AWS Data Exchange console\. Navigate to the **Product Dashboard**, and then copy the product ID you would like to publish data sets for\.

### Describe Product Details<a name="describe-data-set-product-details"></a>

Before you add new data sets to your data product, you must make a `DescribeEntity` call with the ID of your product\. The output contains the product details and an `EntityIdentifier` attribute, which is the entity ID \(your product ID\) appended with a revision number\. The revision number ensures you are adding data sets to the latest version of the product\.

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

### Start a Change Request<a name="start-data-set-change-request"></a>

To start a change request to new data sets to a data set in your test product:

1. Copy the `DescribeEntity` response from [Describe Product Details](add-revisions.md#describe-product-details) and include the following elements:
   + Entity type with the version number \(for example, `DataProduct@1.0`\)\.
   + Identifier with the revision number \(for example, `product-test@1`\)\.

1. Make a `StartChangeSet` request with an `AddDataSets` change type\.

**Sample Request**

```
https://catalog.marketplace.us-east-1.amazonaws.com/StartChangeSet
```

**Sample Request Body**

```
{
    "Catalog": "AWSMarketplace",
    "ChangeSetName": "Adding Data Set to my test Data Product",
    "ChangeSet": [
        {
            "ChangeType": "AddDataSets",
            "Entity": {
                "Identifier": "entity-id@1",
                "Type": "DataProduct@1.0"
            },
            "Details": "{ \"DataSets\": [ { \"Arn\": \"data-set-arn\" } ] }"
        }
    ]
}
```

**Sample Response**

```
{{
  "ChangeSetId": "cs-bnEXAMPLE4mkz9oh",
  "ChangeSetArn": "arn:aws:aws-marketplace:us-east-1:account-id:AWSMarketplace/ChangeSet/cs-bnEXAMPLE4mkz9oh"
}
```

### Check the Status of Your Change Set<a name="check-data-set-change-status"></a>

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
    "ChangeSetName": "Adding Data Set to my test Data Product",
    "StartTime": "2018-09-20T19:45:03.115+0000",
    "EndTime": "2018-09-20T19:48:12.517+0000",
    "Status": "SUCCEEDED",
    "FailureDescription": null,
    "ChangeSet": [
        {
            "ChangeType": "AddDataSets",
            "Entity": {
                "Type": "DataProduct@1.0",
                "Identifier": "entity-id@1"
            },
            "ErrorList": []
        }
    ]
}
```

## AddDataSets exceptions<a name="catalog-exceptions-data-sets"></a>

The following exceptions can occur when you use the AWS Marketplace Catalog API with AWS Data Exchange:

**DATA\_SET\_NOT\_FOUND**  
This happens when the requested data set was not found\. To resolve this issue, ensure that there's not a typo in the data set ARN and that your AWS account owns the data set, and try again\.

**INVALID\_INPUT**  
The request couldn't be processed due to invalid input\. To resolve this issue, ensure that there's not a typo in the request and that the product does not exceed the maximum number of allowed data sets\.

**DATA\_SET\_ALREADY\_PUBLISHED**  
This happens when the data set has already been previously added to the product\.

**DATA\_SET\_DUPLICATE\_PROVIDED**  
 This happens when the same data set is provided more than once in the request\.
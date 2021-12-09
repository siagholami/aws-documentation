# AWS Data Exchange Limits<a name="limits"></a>

 The following tables lists limits for AWS Data Exchange for an AWS account\. 

## Service Limits<a name="limits-on-resource-fields"></a>


|  **Resource, Descriptor, or Operation**  |  **Default Limit**  |  **Description**  | 
| --- | --- | --- | 
| Products per account | 50 | The maximum number of products per account\. | 
| Data sets per account | 3,000 | The maximum number of data sets per account\. | 
| Products per data set | 100 | The maximum number of products that can contain a given data set\. | 
| Concurrent export jobs \(to S3 or a signed URL\) | 10 | The maximum concurrent number of running export jobs with the IN\_PROGRESS state\. | 
| Concurrent import jobs \(from S3 or a signed URL\) | 10 | The maximum concurrent number of running import jobs with the IN\_PROGRESS state\. | 
| Private offers per account | 10 | The maximum number of private offers that a single account can create\. | 
| BYOS offers per account | 10 | The maximum number of BYOS offers that a single account can create\. | 
| Revisions per addRevisions change set | 5 | The maximum number of revisions that can be published to a product in a single AWS Marketplace Catalog API ChangeSet of type addRevisions\. | 
| Number of assets that can be imported or exported to/from Amazon S3 in a single job | 100 | A single job can import or export up to 100 assets to or from Amazon S3\. | 
| Number of assets per single revision | 10,000  | A single revision can contain up to 10,000 assets\. | 
| Number of revisions per single data set  | 10,000  | A single data set can contain up to 10,000 revisions\. | 
| Number of data sets per single product | 25  | A product can have up to 25 data sets\.  | 
| Asset size in GB | 10 GB  | The maximum size, in GB, of a single asset\. | 

## Limits on Resource Fields<a name="limits-on-resource-fields"></a>


|  **Resources**  |  **Field**  |  **Maximum Length**  | 
| --- | --- | --- | 
| Data set | Name | 256 characters | 
| Data set | Description | 16,384 characters | 
| Revision | Comment | 128 characters | 
| Product | Name | 72 characters | 
| Product | Short description | 500 characters | 
| Product | Long description | 30,000 characters | 
| Product | Logo | 100 KB | 
| Offer | DSA | 10 MB | 
| Offer | Refund policy | 200 characters | 
| Subscription request | company name | 40 characters | 
| Subscription request | name | 40 characters | 
| Subscription request | email address | 100 characters | 
| Subscription request | intended use\-case | 500 characters | 

## Endpoints and AWS Regions<a name="api-endpoints"></a>

The following AWS Regions are endpoints are supported for AWS Data Exchange:
+ US East \(N\. Virginia\) – `dataexchange.us-east-1.amazonaws.com`
+ US East \(Ohio\) – `dataexchange.us-east-2.amazonaws.com`
+ US West \(N\. California\) – `dataexchange.us-west-1.amazonaws.com`
+ US West \(Oregon\) – `dataexchange.us-west-2.amazonaws.com`
+ Asia Pacific \(Tokyo\) – `dataexchange.ap-northeast-1.amazonaws.com`
+ Asia Pacific \(Seoul\) – `dataexchange.ap-northeast-2.amazonaws.com`
+ Asia Pacific \(Singapore\) – `dataexchange.ap-southeast-1.amazonaws.com`
+ Asia Pacific \(Sydney\) – `dataexchange.ap-southeast-2.amazonaws.com`
+ Europe \(Frankfurt\) – `dataexchange.eu-central-1.amazonaws.com`
+ Europe \(Ireland\) – `dataexchange.eu-west-1.amazonaws.com`
+ Europe \(London\) – `dataexchange.eu-west-2.amazonaws.com`
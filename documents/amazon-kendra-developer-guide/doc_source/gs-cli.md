--------

--------

# Getting started \(AWS CLI\)<a name="gs-cli"></a>

The following procedure shows how to create an Amazon Kendra index using the AWS CLI\. The procedure creates a data source, index, and runs a query on the index\.

**To create an Amazon Kendra index \(CLI\)**

1. Do the [Prerequisites](gs-prerequisites.md)\.

1. Enter the following command to create an index

   ```
   aws kendra create-index \
    --name cli-getting-started-index \
    --description "Index for CLI getting started guide." \
    --role-arn arn:aws:iam::account id:role/KendraRoleForGettingStartedIndex
   ```

1. Wait for Amazon Kendra to create the index\. Check the progress using the following command\. When the status field is `ACTIVE`, go on to the next step\.

   ```
   aws kendra describe-index \
    --id index id
   ```

1. At the command prompt, enter the following command to create a data source\.

   ```
   aws kendra create-data-source \
    --index-id index id \
    --name data source name \
    --role-arn arn:aws:iam::account id:role/KendraRoleForGettingStartedDataSource
    --type S3 \
    --configuration '{"S3Configuration":{"BucketName":"S3 bucket name"}}'
   ```

1. It will take Amazon Kendra a while to create the data source\. Enter the following command to check the progress\. When the status is `ACTIVE`, go on to the next step\.

   ```
   aws kendra describe-data-source \
    --id data source ID \
    --index-id index ID
   ```

1. Enter the following command to synchronize the data source\.

   ```
   aws kendra start-data-source-sync-job \
    --id data source ID \
    --index-id index ID
   ```

1. Kendra will index your data source\. The amount of time that it takes depends on the number of documents\. You can check the status of the sync job using the following command\. When the status is `ACTIVE`, go on to the next step\.

   ```
   aws kendra describe-data-source \
    --id data source ID \
    --index-id index ID
   ```

1. Enter the following command to make a query\.

   ```
   aws kendra query \
    --index-id index ID \
    --query-text "search term"
   ```

   The results of the search are displayed in JSON format\.
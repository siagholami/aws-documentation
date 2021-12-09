--------

--------

# Getting started \(AWS SDK for Python \(Boto3\)\)<a name="gs-python"></a>

The following program is an example of using Amazon Kendra in a Python program\. The program performs the following actions:

1. Creates a new index using the [CreateIndex](API_CreateIndex.md) operation\.

1. Waits for index creation to complete\. It uses the [DescribeIndex](API_DescribeIndex.md) operation to monitor the status of the index\.

1. Once the index is active, it creates a data source using the [CreateDataSource](API_CreateDataSource.md) operation\.

1. Waits for data source creation to complete\. It uses the [DescribeDataSource](API_DescribeDataSource.md) operation to monitor the status of the data source\.

1. When the data source is active, it synchronizes the index with the contents of the data source using the [StartDataSourceSyncJob](API_StartDataSourceSyncJob.md) operation\.

```
import boto3
from botocore.exceptions import ClientError
import pprint
import time

kendra = boto3.client("kendra")

print("Create an index")

description = "Getting started index"
index_name = "python-getting-started-index"
index_role_arn = "arn:aws:iam::${accountId}:role/KendraRoleForGettingStartedIndex"

try:
    index_response = kendra.create_index(
        Description = description,
        Name = index_name,
        RoleArn = index_role_arn
    )

    pprint.pprint(index_response)

    index_id = index_response["Id"]

    print("Wait for Kendra to create the index.")

    while True:
        # Get index description
        index_description = kendra.describe_index(
            Id = index_id
        )
        # When status is not CREATING quit.
        status = index_description["Status"]
        print("    Creating index. Status: "+status)
        time.sleep(60)
        if status != "CREATING":
            break

    print("Create an S3 data source")

    data_source_name = "python-getting-started-data-source"
    data_source_description = "Getting started data source."
    s3_bucket_name = "${bucketName}"
    data_source_type = "S3"
    data_source_role_arn = "arn:aws:iam::${accountId}:role/KendraRoleForGettingStartedDataSource"

    configuration = {"S3Configuration":
        {
            "BucketName": s3_bucket_name
        }
    }

    data_source_response=kendra.create_data_source(
        Configuration = configuration,
        Name = data_source_name,
        Description = description,
        RoleArn = data_source_role_arn,
        Type = data_source_type,

        IndexId = index_id
    )

    pprint.pprint(data_source_response)

    data_source_id = data_source_response["Id"]

    print("Wait for Kendra to create the data source.")

    while True:
        data_source_description = kendra.describe_data_source(
            Id = data_source_id,
            IndexId = index_id
        )
        # When status is not CREATING quit.
        status = data_source_description["Status"]
        print("    Creating data source. Status: "+status)
        time.sleep(60)
        if status != "CREATING":
            break

    print("Synchronize the data source.")

    sync_response = kendra.start_data_source_sync_job(
        Id = data_source_id,
        IndexId = index_id
    )

    pprint.pprint(sync_response)

    print("Wait for the data source to sync with the index.")

    while True:

        jobs = kendra.list_data_source_sync_jobs(
            Id=data_source_id,
            IndexId=index_id
        )

        # There should be exactly one job item in response
        status = jobs["History"][0]["Status"]

        print("    Syncing data source. Status: "+status)
        if status != "SYNCING":
            break
        time.sleep(60)

except  ClientError as e:
        print("%s" % e)

print("Program ends.")
```
# Importing Your Data<a name="data-prep-importing"></a>

To import your training data into Amazon Personalize, first create an empty dataset group and then an empty dataset in that dataset group\. Next, create an import job that populates the dataset with data from your Amazon S3 bucket\. For more information about datasets, see [Datasets and Schemas](how-it-works-dataset-schema.md)\.

## Import Your Data Using the AWS Python SDK<a name="python-import-ex"></a>

The following steps show how to create and populate a dataset\. For the equivalent steps using the AWS CLI, see [Step 1: Import Training Data](getting-started-cli.md#gs-create-ds)\.

1. Create a dataset group using the [CreateDatasetGroup](API_CreateDatasetGroup.md) API\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   response = personalize.create_dataset_group(name = 'YourDatasetGroup')
   dsg_arn = response['datasetGroupArn']
   
   description = personalize.describe_dataset_group(datasetGroupArn = dsg_arn)['datasetGroup']
   
   print('Name: ' + description['name'])
   print('ARN: ' + description['datasetGroupArn'])
   print('Status: ' + description['status'])
   ```

   The response from the [DescribeDatasetGroup](API_DescribeDatasetGroup.md) API returns the `datasetGroupArn` and the status of the operation\.
**Note**  
You must wait until the status shows as ACTIVE before you can proceed to the next step\.

1. Create a dataset using the [CreateDataset](API_CreateDataset.md) API\. Specify the `datasetGroupArn` returned in the previous step\. Use the `schemaArn` created earlier in [Datasets and Schemas](how-it-works-dataset-schema.md)\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   response = personalize.create_dataset(
       name = 'YourDataset',
       schemaArn = 'schema_arn',
       datasetGroupArn = 'dataset_group_arn',
       datasetType = 'Interactions')
   
   print ('Dataset Arn: ' + response['datasetArn'])
   ```

1. To add data to your dataset, create and run a dataset import job using the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) API\. Specify the `datasetGroupArn` and set the `dataLocation` to the `bucket-name/file.csv` where you stored the training data\. 

   You can upload multiple CSV files to a dataset in one dataset import job if your CSV files are in a folder in the Amazon S3 bucket\. For `dataLocation`, specify the `bucket-name/folder-name/` instead of the file name\.

   For the `roleArn`, see [Creating an IAM Role for Amazon Personalize](aws-personalize-set-up-permissions.md#set-up-create-role-with-permissions)\. The `roleArn` parameter specifies the AWS Identity and Access Management \(IAM\) role that gives Amazon Personalize permissions to access your S3 bucket\.

   ```
   import boto3
   
   personalize = boto3.client('personalize')
   
   response = personalize.create_dataset_import_job(
       jobName = 'YourImportJob',
       datasetArn = 'dataset_arn',
       dataSource = {'dataLocation':'s3://bucket/file.csv'},
       roleArn = 'role_arn')
   
   dsij_arn = response['datasetImportJobArn']
   
   print ('Dataset Import Job arn: ' + dsij_arn)
   
   description = personalize.describe_dataset_import_job(
       datasetImportJobArn = dsij_arn)['datasetImportJob']
   
   print('Name: ' + description['jobName'])
   print('ARN: ' + description['datasetImportJobArn'])
   print('Status: ' + description['status'])
   ```

   The response returns the `datasetImportJobArn`\. The response from the [DescribeDatasetImportJob](API_DescribeDatasetImportJob.md) API includes the status of the operation\.
**Note**  
You must wait until the status changes to ACTIVE before you can use the data to train a model\.

**Important**  
Imports in Amazon Personalize are a full refresh of the data\. You can't add incremental updates\. If you need to update your data, import the complete updated file\.

Amazon Personalize provides operations for managing datasets, dataset groups, and dataset import jobs\. For example, you can use [ListDatasets](API_ListDatasets.md) to list the datasets in a dataset group and use [DeleteDataset](API_DeleteDataset.md) to delete a dataset\.

After you import your data into the relevant datasets in the dataset group, create a solution version by training a model\. For more information, see [Creating a Solution](training-deploying-solutions.md)\.
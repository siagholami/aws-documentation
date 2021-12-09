# Getting Started \(AWS CLI\)<a name="gs-cli"></a>

In this exercise, you use the AWS Command Line Interface \(CLI\) to explore Amazon Forecast\. You create an Amazon Forecast dataset, train a predictor, and use the resulting predictor to generate a forecast\. Before you begin, make sure that you have an AWS account and that you've set up the AWS CLI\. For more information, see [Setting Up](setup.md)\.

**Note**  
The CLI commands in this exercise were tested on Linux\. For information about using the CLI commands on Windows, see [Specifying Parameter Values for the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html) in the *AWS Command Line Interface User Guide*\.

## Step 1: Import Training Data<a name="gs-create-ds"></a>

Begin by creating a dataset and importing the electricity usage data into it\.

**To create an Amazon Forecast dataset**

1. Decide which domain and dataset type is appropriate\.

   The training data that you will import into the dataset influences your choice of dataset domain and type\. So, let's review a few sample rows of the electricity usage data\.

   ```
   2014-01-01 01:00:00,   2.53807106598985, client_0
   2014-01-01 01:00:00, 23.648648648648624, client_1
   2014-01-01 02:00:00,  9.648648648612345, client_0
   ```

   The data format is CSV \(comma\-separated values\), and it's collected hourly \(as shown by the timestamps\)\. It includes these columns:
   + Column 1 – Timestamps that show when electricity usage was recorded\.
   + Column 2 – Hourly electricity usage values \(note how the timestamp values increase by hour\)\.
   + Column 3 – Client ID values that identify the customers using the electricity\.

   For this data, choose the following predefined dataset domain and dataset type:
   + Custom domain – None of the dataset domains, such as METRICS, RETAIL, or WEB\_TRAFFIC, applies to this data, so choose the Custom domain\.
   + Target time series type – The data is a time series because it tracks electricity usage over time\. It also includes the *target* that we want to forecast \(Column 2, electricity usage\)\. Therefore, choose the target time series dataset type\.

     To understand why you choose this type, see [Predefined Dataset Domains and Dataset Types](howitworks-domains-ds-types.md)\.

1. Decide on a dataset schema\.

   The target time series type for the [CUSTOM Domain](custom-domain.md) requires these fields; `timestamp`, `target_value`, and `item_id`\. The `target_value` field is the target\. Amazon Forecast generates the forecast for this field\.

   To map the required fields to columns in your data, you create a schema\. Each *attribute* in the schema maps to a field in the data\.
**Important**  
The order of attributes in the schema must match the order of fields in the training data\.

   ```
   {
     "Attributes":[
       {
          "AttributeName": "timestamp",
          "AttributeType": "timestamp"
       },
       {
          "AttributeName": "target_value",
          "AttributeType": "float"
       },
       {
          "AttributeName": "item_id",
          "AttributeType": "string"
       }
     ]
   }
   ```

   You now have the information necessary to create a dataset and import data into it\.

1. Create the dataset\.

   ```
   aws forecast create-dataset \
   --dataset-name electricity_demand_ds \
   --domain CUSTOM \
   --dataset-type TARGET_TIME_SERIES \
   --data-frequency H \
   --schema '{
     "Attributes": [
       {
         "AttributeName": "timestamp",
         "AttributeType": "timestamp"
       },
       {
         "AttributeName": "target_value",
         "AttributeType": "float"
       },
       {
         "AttributeName": "item_id",
         "AttributeType": "string"
       }
     ]
   }'
   ```

   In the request, the `data-frequency` value `H` represents a data collection frequency of hourly\. The following is an example response\.

   ```
   {
       "DatasetArn": "arn:aws:forecast:us-west-2:acct-id:dataset/electricity_demand_ds"
   }
   ```

   For more information about this operation, see [CreateDataset](API_CreateDataset.md)\.

1. \(Optional\) Get the description of the dataset\.

   ```
   aws forecast describe-dataset \
   --dataset-arn arn:aws:forecast:us-west-2:acct-id:dataset/electricity_demand_ds
   ```

   The following is an example response\.

   ```
   {
       "DatasetName": "electricity_demand_ds",
       "DatasetArn": "arn:aws:forecast:us-west-2:acct-id:dataset/electricity_demand_ds",
       "CreationTime": 1564533087.907,
       "LastModificationTime": 1564533087.907,
       "Domain": "CUSTOM",
       "DatasetType": "TARGET_TIME_SERIES",
       "DataFrequency": "H",
       "Schema": { ... },
       "EncryptionConfig": {},
       "Status": "ACTIVE"
   }
   ```
**Note**  
The order of the key\-value pairs in the response is arbitrary\.

1. Create a dataset group and add the dataset to it\. The value of the `domain` parameter must match the `domain` of the dataset\.

   ```
   aws forecast create-dataset-group \
   --dataset-group-name electricity_ds_group \
   --dataset-arns arn:aws:forecast:us-west-2:acct-id:ds/electricity_demand_ds \
   --domain CUSTOM
   ```

   The following is an example response\.

   ```
   {
       "DatasetGroupArn": "arn:aws:forecast:us-west-2:acct-id:dataset-group/electricity_ds_group"
   }
   ```

   For more information about this operation, see [CreateDatasetGroup](API_CreateDatasetGroup.md)\.

1. \(Optional\) Get the description of the dataset group\.

   ```
   aws forecast describe-dataset-group \
   --dataset-group-arn arn:aws:forecast:us-west-2:acct-id:dataset-group/electricity_ds_group
   ```

   The following is an example response\.

   ```
   {
       "DatasetGroupName": "electricity_ds_group",
       "DatasetGroupArn": "arn:aws:forecast:us-west-2:acct-id:dataset-group/electricity_ds_group",
       "DatasetArns": [
           "arn:aws:forecast:us-west-2:acct-id:dataset-group/electricity_ds_group"
       ],
       "Domain": "CUSTOM",
       "CreationTime": 1564533719.852,
       "LastModificationTime": 1564533719.852,
       "Status": "ACTIVE"
   }
   ```

1. Import the electricity usage training data from your Amazon S3 bucket to the dataset\. The IAM role that you provide must have permission to read data from your S3 bucket\. For information on how to create an IAM role, see [Create an IAM for Amazon Forecast \(AWS CLI\)](aws-forecast-iam-roles.md#aws-forecast-create-iam-role-with-cli)\.

   ```
   aws forecast create-dataset-import-job \
   --dataset-arn arn:aws:forecast:us-west-2:acct-id:dataset/electricity_demand_ds \
   --dataset-import-job-name electricity_ds_import_job \
   --data-source '{
       "S3Config": {
         "Path": "s3://bucket/electricityusagedata.csv",
         "RoleArn": "arn:aws:iam::acct-id:role/Role"
       }
     }'
   ```

   The following is the shorthand syntax for the `data-source` parameter\.

   ```
   --data-source S3Config="{Path='s3://bucket/electricityusagedata.csv',RoleArn='arn:aws:iam::acct-id:role/Role'}"
   ```

   The following is an example response\.

   ```
   {
       "DatasetImportJobArn": "arn:aws:forecast:us-west-2:acct-id:dataset-import-job/electricity_demand_ds/electricity_ds_import_job"
   }
   ```

   For more information about this operation, see [CreateDatasetImportJob](API_CreateDatasetImportJob.md)\.

1. Check the import status\. 

   ```
   aws forecast describe-dataset-import-job \
   --dataset-import-job-arn arn:aws:forecast:us-west-2:acct-id:dataset-import-job/electricity_demand_ds/electricity_ds_import_job
   ```

   The following is an example response\.

   ```
   {
       "DatasetImportJobName": "electricity_ds_import_job",
       "DatasetImportJobArn": "arn:aws:forecast:us-west-2:acct-id:dataset-import-job/electricity_demand_ds/electricity_ds_import_job",
       "DatasetArn": "arn:aws:forecast:us-west-2:acct-id:dataset/electricity_demand_ds",
       "DataSource": {
           "S3Config": {
               "Path": "s3://bucket/electricityusagedata.csv",
               "RoleArn": "arn:aws:iam::acct-id:role/ForecastRole"
           }
       },
       "DataSize": 0.14639010466635227,
       "TimeStampFormat": "yyyy-MM-dd HH:mm:ss",
       "CreationTime":  1564537011.114,
       "LastModificationTime": 1564537028.223,
       "Status": "CREATE_IN_PROGRESS"
   }
   ```

   When all of the data has been imported, the status changes to ACTIVE and the response includes statistics for the data, as shown in the following example\.

   ```
   {
       "DatasetArn": "arn:aws:forecast:us-west-2:acct-id:dataset/electricity_demand_ds",
       "Status": "ACTIVE",
       "FieldStatistics": {
           "date": {
               "Min": "2014-01-01T01:00:00Z",
               "Max": "2015-01-01T00:00:00Z",
               "Count": 3241200,
               "CountDistinct": 8760,
               "CountNull": 0
           },
           "target": {
               "Min": "0.0",
               "Max": "168200.0",
               "Avg": 606.5167610461679,
               "Stddev": 3518.405223972031,
               "Count": 3241200,
               "CountDistinct": 1196961,
               "CountNull": 0,
               "CountNan": 0
           },
           "item": {
               "Count": 3241200,
               "CountDistinct": 370,
               "CountNull": 0
           }
       },
       ...
   }
   ```
**Important**  
You must wait until the status is ACTIVE before creating a predictor with the dataset group\.

   For more information about this operation, see [DescribeDatasetImportJob](API_DescribeDatasetImportJob.md)\.

## Step 2: Train a Predictor<a name="gs-create-predictor"></a>

To create a predictor, you use the [CreatePredictor](API_CreatePredictor.md) operation and provide the following information\.
+ An algorithm – Amazon Forecast uses the algorithm to train the predictor using the data in the dataset group\. For this exercise, you use an algorithm called `forecast_DEEP_AR_PLUS`, which is provided by Amazon Forecast\. For a list of algorithms that Amazon Forecast provides, see [Choosing an Amazon Forecast Algorithm](aws-forecast-choosing-recipes.md)\.
**Note**  
If you aren't sure which algorithm to use, you can set the `PerformAutoML` flag in the `CreatePredictor` operation to tell Amazon Forecast to run AutoML\. AutoML determines which algorithm to use for predictor training\.
+ A dataset group – You created the dataset group in the preceding step\.

After the predictor is created, you review the accuracy metrics generated by Amazon Forecast\. The metrics help you decide whether to use the predictor for generating a forecast\. For more information about predictors, see [Predictors](howitworks-predictor.md)\.

**To create a predictor and review the accuracy metrics**

1. Create the predictor\.

   ```
   aws forecast create-predictor \
   --predictor-name electricitypredictor \
   --algorithm-arn arn:aws:forecast:::algorithm/Deep_AR_Plus \
   --input-data-config DatasetGroupArn="arn:aws:forecast:us-west-2:acct-id:dsgroup/electricity_ds_group" \
   --forecast-horizon 20 \
   --featurization-config '{
       "ForecastFrequency": "H"
     }'
   ```

   The following is an example response\.

   ```
   {
       "PredictorArn": "arn:aws:forecast:us-west-2:acct-id:predictor/electricitypredictor"
   }
   ```

1. Get the predictor's status\.

   ```
   aws forecast describe-predictor \
   --predictor-arn arn:aws:forecast:us-west-2:acct-id:predictor/electricitypredictor
   ```

   The following is an example response\.

   ```
   {
       "PredictorName": "electricitypredictor",
       "PredictorArn": "arn:aws:forecast:us-west-2:acct-id:predictor/electricitypredictor",
       "AlgorithmArn": "arn:aws:forecast:::algorithm/Deep_AR_Plus",
       "DatasetImportJobArns": [
           "arn:aws:forecast:us-west-2:acct-id:dataset-import-job/electricity_demand_ds/electricity_ds_import_job"
       ],
       "InputDataConfig": {
           "DatasetGroupArn": "arn:aws:forecast:us-west-2:acct-id:dataset-group/electricity_ds_group"
       },
       "ForecastHorizon": 20,
       "FeaturizationConfig": {
           "ForecastFrequency": "H",
           "Featurizations": [
               {
                   "AttributeName": "target_value",
                   "FeaturizationPipeline": [
                       {
                           "FeaturizationMethodName": "filling",
                           "FeaturizationMethodParameters": {
                               "frontfill": "none",
                               "aggregation": "sum",
                               "backfill": "zero",
                               "middlefill": "zero"
                           }
                       }
                   ]
               }
           ]
       },
       "CreationTime": 1564611261.617,
       "LastModificationTime": 1564611279.896,
       "PerformAutoML": false,
       "PerformHPO": false,
       "EvaluationParameters": {
           "BackTestWindowOffset": 20,
           "NumberOfBacktestWindows": 1
       },
       "Status": "CREATE_IN_PROGRESS"
   }
   ```
**Important**  
Model training takes time\. Don't proceed until training has completed and the status of the predictor is ACTIVE\.

1. Get the accuracy metrics for the predictor\.

   ```
   aws forecast get-accuracy-metrics \
   --predictor-arn arn:aws:forecast:us-west-2:acct-id:predictor/electricitypredictor
   ```

   The following is an example response\.

   ```
   {
       "PredictorEvaluationResults": [
           {
               "TestWindows": [
                   {
                       "EvaluationType": "SUMMARY",
                       "Metrics": {
                           "RMSE": 448.19602551622864,
                           "WeightedQuantileLosses": [
                               {
                                   "Quantile": 0.9,
                                   "LossValue": 0.11574311406253326
                               },
                               {
                                   "Quantile": 0.5,
                                   "LossValue": 0.1706269067283527
                               },
                               {
                                   "Quantile": 0.1,
                                   "LossValue": 0.11724164222477837
                               }
                           ]
                       }
                   },
                   {
                       "EvaluationType": "COMPUTED",
                       "Metrics": {
                           "RMSE": 448.19602551622864,
                           "WeightedQuantileLosses": [
                               {
                                   "Quantile": 0.9,
                                   "LossValue": 0.11574311406253326
                               },
                               {
                                   "Quantile": 0.5,
                                   "LossValue": 0.1706269067283527
                               },
                               {
                                   "Quantile": 0.1,
                                   "LossValue": 0.11724164222477837
                               }
                           ]
                       },
                       "TestWindowEnd":   1420070400.0,
                       "TestWindowStart": 1420002000.0
                   }
               ]
           }
       ]
   }
   ```

   The metrics show the error loss for each quantile\. For example, there was an 11\.7% error for the first quantile\. The metrics also show the root\-mean\-square error \(`RMSE`\)\.

   The summary metrics show the average of the computed metrics over all test windows\. Because there was only one test window, the summary and computed metrics are equal\.

   For more information about this operation, see [GetAccuracyMetrics](API_GetAccuracyMetrics.md)\.

## Step 3: Create a Forecast<a name="gs-create-campaign"></a>

Amazon Forecast creates a forecast for the `target_value` field \(as determined by the dataset domain and type\) for each unique `item_id` in the dataset\. In this exercise, the `target_value` field provides electricity usage and the `item_id` provides client IDs\. You get a forecast for the hourly electricity usage by customer\.

After the forecast has been created, you can query for a single item or export the complete forecast\.

**To create, retrieve, and export a forecast**

1. Create the forecast\.

   ```
   aws forecast create-forecast \
   --forecast-name electricityforecast \
   --predictor-arn arn:aws:forecast:us-west-2:acct-id:predictor/electricitypredictor
   ```

   The operation uses the predictor to create a forecast\. In the response, you get the Amazon Resource Name \(ARN\) of the forecast\. You use this ARN to retrieve and export the forecast\. The following is an example response\.

   ```
   {
       "ForecastArn": "arn:aws:forecast:us-west-2:acct-id:forecast/electricityforecast"
   }
   ```

   For more information about this operation, see [CreateForecast](API_CreateForecast.md)\.

1. Retrieve the first two hours of the forecast for `client_1`\.
**Note**  
The service name, `forecastquery`, is different then the service name used elsewhere\.

   ```
   aws forecastquery query-forecast \
   --forecast-arn arn:aws:forecast:us-west-2:acct-id:forecast/electricityforecast \
   --start-date 2015-01-01T00:00:00 \
   --end-date   2015-01-01T02:00:00 \
   --filters '{"item_id":"client_1"}'
   ```

   The operation includes the following parameters\.
   + `start-date` and `end-date` – Specifies an optional date range to retrieve the forecast for\. If you don't specify these parameters, the operation returns the entire forecast for `client_1`\.
   + `filters` – Specifies the `item_id` filter to retrieve the electricity forecast for `client_1`\.

     The following is the shorthand syntax for the `filters` parameter\.

     ```
     --filters item_id="client_1"
     ```

   The following is an example response\.

   ```
   {
       "Forecast": {
           "Predictions": {
               "mean": [
                   {
                       "Timestamp": "2015-01-01T01:00:00",
                       "Value": 20.952411651611328
                   },
                   {
                       "Timestamp": "2015-01-01T02:00:00",
                       "Value": 19.11078453063965
                   }
               ],
               "p90": [
                   {
                       "Timestamp": "2015-01-01T01:00:00",
                       "Value": 24.524038314819336
                   },
                   {
                       "Timestamp": "2015-01-01T02:00:00",
                       "Value": 22.319091796875
                   }
               ],
               "p50": [
                   {
                       "Timestamp": "2015-01-01T01:00:00",
                       "Value": 20.7841739654541
                   },
                   {
                       "Timestamp": "2015-01-01T02:00:00",
                       "Value": 19.237524032592773
                   }
               ],
               "p10": [
                   {
                       "Timestamp": "2015-01-01T01:00:00",
                       "Value": 18.507278442382812
                   },
                   {
                       "Timestamp": "2015-01-01T02:00:00",
                       "Value": 16.15062141418457
                   }
               ]
           }
       }
   }
   ```

   Because this is an hourly forecast, the response shows hourly forecast values\. In the response, note the following:
   + `mean` – For the specific date and time, the mean is the predicted mean electricity usage value for the customer\.
   + `p90`, `p50`, and `p10` – Specify the confidence level that the actual value will be below the listed value at the specified date and time\. For example, at 2015\-01\-01T01:00:00, Amazon Forecast is 90% confident that the electric usage will be below 24\.5\. Amazon Forecast is 50% confident that usage will be below 20\.8, and 10% confident that usage will be below 18\.5\.

   For more information about this operation, see [QueryForecast](API_forecastquery_QueryForecast.md)\.

1. Export the complete forecast to your Amazon S3 bucket\. The IAM role that you provide must have permission to write data to your S3 bucket\. For information on how to create an IAM role, see [Create an IAM for Amazon Forecast \(AWS CLI\)](aws-forecast-iam-roles.md#aws-forecast-create-iam-role-with-cli)\.

   Create a forecast export job\.

   ```
   aws forecast create-forecast-export-job \
   --forecast-export-job-name electricityforecast_exportjob \
   --forecast-arn arn:aws:forecast:us-west-2:acct-id:forecast/electricityforecast \
   --destination S3Config="{Path='s3://bucket',RoleArn='arn:aws:iam::acct-id:role/Role'}"
   ```

   The following is an example response\.

   ```
   {
      "ForecastExportJobArn": "arn:aws:forecast::us-west-2:acct-id:forecast-export/64bbc087"
   }
   ```

   For more information about this operation, see [CreateForecastExportJob](API_CreateForecastExportJob.md)\.

1. Get the status of the export job\.

   ```
   aws forecast describe-forecast-export-job \
   --forecast-export-job-arn arn:aws:forecast:us-west-2:acct-id:forecast/electricityforecast
   ```

   The following is an example response\.

   ```
   {
       "ForecastExportJobArn": "arn:aws:forecast::us-west-2:acct-id:forecast-export/64bbc087",
       "ForecastExportJobName": "electricityforecast_exportjob",
       "Status": "CREATE_IN_PROGRESS"
   }
   ```

   When the status is ACTIVE, you can find the forecast files in the specified S3 bucket\.
# Guidelines and Quotas<a name="limits"></a>

The following sections contain information about Amazon Forecast guidelines and quotas\.

**Topics**
+ [Supported AWS Regions](#regions)
+ [Compliance](#ompliance)
+ [Service Quotas](#limits-table)

## Supported AWS Regions<a name="regions"></a>

For a list of AWS Regions that support Forecast, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#forecast_region) in the *Amazon Web Services General Reference*\.

## Compliance<a name="ompliance"></a>

For more information about Forecast compliance programs, see [AWS Compliance](https://aws.amazon.com/compliance/), [AWS Compliance Programs](https://aws.amazon.com/compliance/programs/), and [AWS Services in Scope by Compliance Program](https://aws.amazon.com/compliance/services-in-scope)\.

## Service Quotas<a name="limits-table"></a>

Forecast has the following service quotas\.


**Quotas Imposed by the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) API**  

| Resource | Default Limit | 
| --- | --- | 
| Maximum number of files in your Amazon S3 bucket | 10,000 | 
| Maximum cumulative size of all files in your Amazon S3 bucket | 30 GB | 
| Maximum number of datasets in a dataset group | 3 \(1 for each type\) | 
| Maximum number of rows in a dataset | 1 billion | 
| Maximum number of columns in a target time series dataset \(required columns \+ additional forecast dimensions\) | 13 \(3 \+ 10\) | 
| Maximum number of columns in a related time series dataset \(required columns \+ additional forecast dimensions \+ related features\) | 25 \(2 \+ 10 \+ 13\) | 
| Maximum number of columns in an item metadata dataset | 10 | 


**Quotas Imposed by the [CreatePredictor](API_CreatePredictor.md) API**  

| Resource | Default Limit | 
| --- | --- | 
| Maximum NumberOfBacktestWindows \([EvaluationParameters](API_EvaluationParameters.md)\) | 5 | 
| Maximum number of forecasts per predictor \(number of items X number of unique values across forecast dimensions in the target time series dataset\) | 1,000,000 across all target time series items and dimensions\. \(For instance, you can have 1,000,000 items, or 100 items in 10,000 locations, or 100 items in 100 warehouses in 100 cities\.\) If you exceed 100,000 items, Forecast supports yearly, monthly, weekly, and daily frequencies instead of more granular frequencies \(such as hourly\)\.  | 
| Forecast horizon | The lesser of 500 data points or 1/3 of the target time series dataset length | 


**General Resource Quotas**  

| Resource | Default Limit | 
| --- | --- | 
| Maximum parallel running CreateDatasetImportJob tasks | 3 | 
| Maximum parallel running CreatePredictor tasks | 3 | 
| Maximum parallel running [CreateForecast](API_CreateForecast.md) tasks | 3 | 
| Maximum number of dataset import jobs | 1000 | 
| Maximum number of dataset groups | 500 | 
| Maximum number of datasets | 1500 | 
| Maximum number of predictors | 500 | 
| Maximum number of forecasts |  10  | 
| Maximum number of forecast export jobs | 1000 | 
| Maximum number of parallel forecast export jobs | 3 | 
| Maximum time for which a forecast can be queried on \(console or [QueryForecast](API_forecastquery_QueryForecast.md) API\) | 30 days | 
| Maximum number of tags you can add to a resource | 50 | 
| Maximum number of forecasts that can be queried using the [QueryForecast](API_forecastquery_QueryForecast.md) API |  10 concurrent forecasts, including 5 created with large datasets \(anything over 20GB or 100,000 items\)\. If you have more than 5 forecasts created with large datasets, `QueryForecast` can access only the 5 most recent large dataset forecasts\.  | 
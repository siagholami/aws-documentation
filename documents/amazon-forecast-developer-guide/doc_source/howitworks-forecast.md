# Forecasts<a name="howitworks-forecast"></a>

After creating an Amazon Forecast predictor, you call the [CreateForecast](API_CreateForecast.md) operation to create a forecast\. During forecast creation, Amazon Forecast trains a model on the entire dataset before hosting the model and doing inference\. This operation creates a forecast for every item \(`item_id`\) in the dataset group that was used to train the predictor\. After a forecast is created, you can query the forecast or export it to your Amazon Simple Storage Service \(Amazon S3\) bucket\.

By default, the forecast frequency is the data collection frequency that you specified when you created the dataset with the [CreateDataset](API_CreateDataset.md) operation\. You can optionally specify an interval that is greater, but not lesser, than the specified frequency for the dataset\. Then, the operation aggregates the forecast data and returns the results\. For example, suppose that your data collection frequency was every day\. You can then get a daily or monthly forecast, but not an hourly forecast\.

You query a forecast using the [QueryForecast](API_forecastquery_QueryForecast.md) operation\. By default, the complete range of the forecast is returned\. You can request a specific date range within the complete forecast\.

When you query a forecast you must specify filtering criteria\. A filter is a key\-value pair\. The key is one of the schema attribute names \(including forecast dimensions\) from one of the datasets used to create the forecast\. The *value* is a valid values for the specified key\. You can specify multiple key\-value pairs\. The returned forecast will only contain items that satisfy all the criteria\.

To export the forecast, you can call the [CreateForecastExportJob](API_CreateForecastExportJob.md) operation\. This operation copies the forecast to your Amazon S3 bucket as a CSV file\. Optionally, you can specify an AWS Key Management Service key to encrypt the data before it is written to the bucket\.

## How It Works: Next Topic<a name="howitworks-forecast-nexttopic"></a>

[Getting Started](getting-started.md)
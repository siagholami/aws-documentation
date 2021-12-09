# Updating Data<a name="updating-data"></a>

As you collect new data, you may want to use it to generate new forecasts\. Forecast does not automatically retrain a predictor when you import an updated dataset, but you can use an existing predictor to generate forecasts with the updated data\. For instance, if you collect daily sales data and want to include new datapoints in your forecast, you could import the updated data and use it to generate a forecast without training a new predictor\. If, however, you want your predictor to be trained off of the new data, you must create a new predictor\.

**To generate a forecast off of new data:**

1. Upload the updated CSV file to an Amazon S3 bucket\. The updated CSV should still contain all of your existing data\.

1. Create a dataset import job with the new data\. The most recent import job is the one that forecasts are generated off of\.

1. Create a new forecast using the existing predictor\.

1. Retreieve the forecast as usual\.
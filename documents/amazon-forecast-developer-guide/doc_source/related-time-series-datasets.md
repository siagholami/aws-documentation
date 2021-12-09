# Using Related Time Series Datasets<a name="related-time-series-datasets"></a>

A related time series dataset includes time\-series data that isn't included in a target time series dataset and might improve the accuracy of your predictor\.

For example, in the demand forecasting domain, a target time series dataset would contain `timestamp` and `item_id` dimensions, while a complimentary related time series dataset also includes the following supplementary features: `item price`, `promotion`, and `weather`\.

A related time series dataset can contain up to 10 forecast dimensions \(the same ones in your target time series dataset\) and up to 13 related time\-series features\.

You can use a related time series dataset when training a predictor with the [CNN\-QR](aws-forecast-algo-cnnqr.md), [DeepAR\+](aws-forecast-recipe-deeparplus.md), and [Prophet](aws-forecast-recipe-prophet.md) algorithms\. [NPTS](aws-forecast-recipe-npts.md), [ARIMA](aws-forecast-recipe-arima.md), and [ETS](aws-forecast-recipe-ets.md) do not accept related time series data\.

## Historical and Forward\-looking Related Time Series<a name="related-time-series-historical-futurelooking"></a>

 Related time series come in two forms: 
+  **Historical time series**: time series *without* data points within the forecast horizon\. 
+  **Forward\-looking time series**: time series *with* data points within the forecast horizon\. 

Historical related time series contain data points up to the forecast horizon, and do not contain any data points within the forecast horizon\. Forward\-looking related time series contain data points up to *and* within the forecast horizon\. A related time series that contains any values within the forecast horizon is treated as a forward\-looking time series\. 

 The following table shows the types of related time series each Amazon Forecast algorithm accepts\. 


|  | CNN\-QR | DeepAR\+ | Prophet | NPTS | ARIMA | ETS | 
| --- | --- | --- | --- | --- | --- | --- | 
|  Historical related time series  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
|  Forward\-looking related time series  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 

 When using AutoML, you can provide both historical and foward\-looking related time series data, and Forecast will only use those time series where applicable\. 

 If you provide *forward\-looking* related time series data, Forecast will use the related data with CNN\-QR, DeepAR\+, and Prophet, and will not use the related data with NPTS, ARIMA and ETS\. If provided *historical* related time series data, Forecast will use the related data with CNN\-QR, and will not use the related data with DeepAR\+, Prophet, NPTS, ARIMA, and ETS\. 

## Related Time Series Dataset Validation<a name="related-time-series-dataset-validation"></a>

A related time series dataset has the following restrictions:
+ It can't include the target value from the target time series\.
+ It must include `item_id` and `timestamp` dimensions, and at least one related feature \(such as `price`\)\.
+ Related time series feature data must be of the `int` or `float` datatypes\.
+ In order to use the entire target time series, all items from the target time series dataset must also be included in the related time series dataset\. If a related time series only contains a subset of items from the target time series, then the model creation and forecast generation will be limited to that specific subset of items\.

   For example, if the target time series contains 1000 items and the related time series dataset only contains 100 items, then the model and forecasts will be based on only those 100 items\. 
+ The frequency at which data is recorded in the related time series dataset must match the interval at which you want to generate forecasts \(the forecasting *granularity*\)\.

  For example, if you want to generate forecasts at a weekly granularity, the frequency at which data is recorded in the related time series must also be weekly, even if the frequency at which data is recorded in the target time series is daily\.
+ The data for each item in the related time series dataset must start on or before the beginning `timestamp` of the corresponding `item_id` in the target time series dataset\.

  For example, if the target time series data for `socks` starts at 2019\-01\-01 and the target time series data for `shoes` starts at 2019\-02\-01, the related time series data for `socks` must begin on or before 2019\-01\-01 and the data for `shoes` must begin on or before 2019\-02\-01\.
+ For forward\-looking related time series datasets, the last timestamp for every item must be on the last timestamp in the user\-designated forecast window \(called the *forecast horizon*\)\.

  In the example related time series file below, the `timestamp` data for both socks and shoes must end on or after 2019\-07\-01 \(the last recorded timestamp\) *plus* the forecast horizon\. If data frequency in the target time series is daily and the forecast horizon is 10 days, daily data points must be provided in the forward\-looking related time series file until 2019\-07\-11\.
+ For historical related time series datasets, the last timestamp for every item must match the last timestamp in the target time series\.

  In the example related time series file below, the `timestamp` data for both socks and shoes must end on 2019\-07\-01 \(the last recorded timestamp\)\.
+ The Forecast dimensions provided in the related time series dataset must be either equal to or a subset of the dimensions designated in the target time series dataset\.
+  Related time series cannot have missing values\. For information on missing values in a related time series dataset, see [Handling Missing Values](howitworks-missing-values.md)\. 

## Example: Forward\-looking Related Time Series File<a name="related-time-series-example"></a>

The following table shows a correctly configured related time series dataset file\. For this example, assume the following:
+ The last data point was recorded in the target time series dataset on 2019\-07\-01\.
+  The forecast horizon is 10 days\. 
+ The forecast granularity is daily \(`D`\)\. 

A "`…`" row indicates all of the data points in between the previous and succeeding rows\.


| `timestamp` | `item_id` | `store` | `price` | 
| --- | --- | --- | --- | 
| 2019\-01\-01 | socks | NYC | 10 | 
| 2019\-01\-02 | socks | NYC | 10 | 
| 2019\-01\-03 | socks | NYC | 15 | 
| \.\.\. | 
| 2019\-06\-01 | socks | NYC | 10 | 
| \.\.\. | 
| 2019\-07\-01 | socks | NYC | 10 | 
| \.\.\. | 
| 2019\-07\-11 | socks | NYC | 20 | 
| 2019\-01\-05 | socks | SFO | 45 | 
| \.\.\. | 
| 2019\-06\-05 | socks | SFO | 10 | 
| \.\.\. | 
| 2019\-07\-01 | socks | SFO | 10 | 
| \.\.\. | 
| 2019\-07\-11 | socks | SFO | 30 | 
| 2019\-02\-01 | shoes | ORD | 50 | 
| \.\.\. | 
| 2019\-07\-01 | shoes | ORD | 75 | 
| \.\.\. | 
| 2019\-07\-11 | shoes | ORD | 60 | 

## Example: Forecasting Granularity<a name="related-time-series-granularity"></a>

The following table shows compatible data recording frequencies for target time series and related time series to forecast at a weekly granularity\. Because data in a related time series dataset can't be aggregated, Forecast accepts only a related time series data frequency that is the same as the chosen forecasting granularity\.


| Target Input Data Frequency | Related Time Series Frequency | Forecasting Granularity | Supported by Forecast? | 
| --- | --- | --- | --- | 
| Daily | Weekly | Weekly | Yes | 
| Weekly | Weekly | Weekly | Yes | 
| N/A | Weekly | Weekly | Yes | 
| Daily | Daily | Weekly | No | 
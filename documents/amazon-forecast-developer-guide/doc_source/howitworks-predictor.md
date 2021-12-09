# Predictors<a name="howitworks-predictor"></a>

A predictor is an Amazon Forecast trained model used for making forecasts based on time\-series data\. During training, Amazon Forecast generates accuracy metrics that you use to evaluate the predictor and decide whether to use the predictor to generate a forecast\.

**Topics**
+ [Creating Predictors](#howitworks-predictor-intro)
+ [Predictor Evaluation](#howitworks-predictor-metrics)
+ [How It Works: Next Topic](#howitworks-solution-nexttopic)

## Creating Predictors<a name="howitworks-predictor-intro"></a>

Amazon Forecast trains forecasting models called predictors\. To create a predictor, you use the [CreatePredictor](API_CreatePredictor.md) operation\.

To create a predictor, you provide the following:
+ A dataset group – Provides data for training the predictor\. For more information, see [Datasets](howitworks-datasets-groups.md#howitworks-dataset)\.
+ A featurization configuration – Specifies the forecast frequency and provides information for transforming the data before model training\. Data is transformed to make it more compatible with the training algorithm\. 
+ A forecast horizon – The number of time\-steps to make\. The forecast horizon is also called the prediction length\.
+ Evaluation parameters – How to split a dataset into training and test datasets\.
+ One of the following:
  + An algorithm – The algorithm is used to train a model and specifies default values for hyperparameter optimization \(only DeepAR\+ and CNN\-QR\), evaluation parameters, and training parameters\. By specifying an algorithm, you also can provide overrides for these parameter values\.
  + Perform AutoML – Amazon Forecast provides a set of predefined algorithms\. If you don't know which algorithm to choose, use the `PerformAutoML` option\. This option tells Amazon Forecast to evaluate all algorithms and choose the best algorithm based on your datasets\. With this option, model training can take longer, but you don't need to worry about choosing the right algorithm and parameters\. AutoML optimizes the average of the weighted P10, P50 and P90 quantile losses, and returns the algorithm with the lowest value\.

For more information on algorithms, see [Choosing an Amazon Forecast Algorithm](aws-forecast-choosing-recipes.md)\.

## Predictor Evaluation<a name="howitworks-predictor-metrics"></a>

After you create a predictor, you can evaluate the accuracy of the forecast it generates by running the [GetAccuracyMetrics](API_GetAccuracyMetrics.md) operation\.

**Evaluation Parameters**

The evaluation parameters define how to split a dataset into training and test datasets for backtest window evaluations, as well as the number of backtest iterations to perform\. These parameters have default values that can be overridden in the [CreatePredictor](API_CreatePredictor.md) request\.

The evaluation parameters consist of the `NumberOfBacktestWindows` and the `BackTestWindowOffset` parameters\.

`NumberOfBacktestWindows` specifies the number of times to split the input data\. The range is 1 through 5\.

`BackTestWindowOffset` defines the point from the end of the dataset where the data is split for model training and testing \(evaluation\)\. The value is specified as the number of data points\. `BackTestWindowOffset` must be greater than or equal to the forecast horizon and less than half of the target time series dataset length\. This parameter can be used to mimic a past virtual forecast start date\.

For more information, see [Evaluating Predictor Accuracy](metrics.md)\.

## How It Works: Next Topic<a name="howitworks-solution-nexttopic"></a>

[Forecasts](howitworks-forecast.md)
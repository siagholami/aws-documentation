# Choosing an Amazon Forecast Algorithm<a name="aws-forecast-choosing-recipes"></a>

An Amazon Forecast predictor uses an algorithm to train a model with your time series datasets\. The trained model is then used to generate metrics and predictions\. 

 If you are unsure of which algorithm to use to train your model, choose AutoML when creating a predictor and let Forecast select the algorithm with the lowest average losses over the 10th, median, and 90th quantiles\. Otherwise, you can manually select one of the built\-in algorithms\. 

## Built\-in Forecast Algorithms<a name="forecast-algos"></a>

 Amazon Forecast provides six built\-in algorithms for you to choose from\. These range from commonly used statistical algorithms like Autoregressive Integrated Moving Average \(ARIMA\), to complex neural network algorithms like CNN\-QR and DeepAR\+\. 

### [CNN\-QR](aws-forecast-algo-cnnqr.md)<a name="cnnqr"></a>

 `arn:aws:forecast:::algorithm/CNN-QR` 

 Amazon Forecast CNN\-QR, Convolutional Neural Network \- Quantile Regression, is a proprietary machine learning algorithm for forecasting time series using causal convolutional neural networks \(CNNs\)\. CNN\-QR works best with large datasets containing hundreds of time series\. It accepts item metadata, and is the only Forecast algorithm that accepts related time series data without future values\. 

### [DeepAR\+](aws-forecast-recipe-deeparplus.md)<a name="deeparplus"></a>

`arn:aws:forecast:::algorithm/Deep_AR_Plus`

 Amazon Forecast DeepAR\+ is a proprietary machine learning algorithm for forecasting time series using recurrent neural networks \(RNNs\)\. DeepAR\+ works best with large datasets containing hundreds of feature time series\. The algorithm accepts forward\-looking related time series and item metadata\. 

### [Prophet](aws-forecast-recipe-prophet.md)<a name="prophet"></a>

`arn:aws:forecast:::algorithm/Prophet`

 Prophet is a time series forecasting algorithm based on an additive model where non\-linear trends are fit with yearly, weekly, and daily seasonality\. It works best with time series with strong seasonal effects and several seasons of historical data\. 

### [NPTS](aws-forecast-recipe-npts.md)<a name="npts"></a>

`arn:aws:forecast:::algorithm/NPTS`

 The Amazon Forecast Non\-Parametric Time Series \(NPTS\) proprietary algorithm is a scalable, probabilistic baseline forecaster\. NPTS is especially useful when working with sparse or intermittent time series\. Forecast provides four algorithm variants: Standard NPTS, Seasonal NPTS, Climatological Forecaster, and Seasonal Climatological Forecaster\. 

### [ARIMA](aws-forecast-recipe-arima.md)<a name="arima"></a>

`arn:aws:forecast:::algorithm/ARIMA`

 Autoregressive Integrated Moving Average \(ARIMA\) is a commonly used statistical algorithm for time\-series forecasting\. The algorithm is especially useful for simple datasets with under 100 time series\. 

### [ETS](aws-forecast-recipe-ets.md)<a name="ets"></a>

`arn:aws:forecast:::algorithm/ETS`

 Exponential Smoothing \(ETS\) is a commonly used statistical algorithm for time\-series forecasting\. The algorithm is especially useful for simple datasets with under 100 time series, and datasets with seasonality patterns\. ETS computes a weighted average over all observations in the time series dataset as its prediction, with exponentially decreasing weights over time\. 

## Comparing Forecast Algorithms<a name="comparing-algos"></a>

 Use the following table to find the best option for your time series datasets\. 


|  | CNN\-QR | DeepAR\+ | Prophet | NPTS | ARIMA | ETS | 
| --- | --- | --- | --- | --- | --- | --- | 
| Computationally intensive training process | High | High | Medium | Low | Low | Low | 
| Accepts historical related time series\* | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Accepts forward\-looking related time series\* | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Accepts item metadata \(product color, brand, etc\) | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Suitable for sparse datasets | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Performs Hyperparameter Optimization \(HPO\) | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Allows overriding default hyperparameter values  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Suitable for What\-if analysis | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 
| Suitable for Cold Start scenarios \(forecasting with little to no historical data\) | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-yes.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/icon-no.png)  | 

\*For more information on related time series, see [Related Time Series](related-time-series-datasets.md)\. 
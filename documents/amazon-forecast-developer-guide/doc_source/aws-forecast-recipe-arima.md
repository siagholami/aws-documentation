# Autoregressive Integrated Moving Average \(ARIMA\) Algorithm<a name="aws-forecast-recipe-arima"></a>

Autoregressive Integrated Moving Average \([ARIMA](https://en.wikipedia.org/wiki/Autoregressive_integrated_moving_average)\) is a commonly\-used local statistical algorithm for time\-series forecasting\. ARIMA captures standard temporal structures \(patterned organizations of time\) in the input dataset\. The Amazon Forecast ARIMA algorithm calls the [Arima function](https://cran.r-project.org/web/packages/forecast/forecast.pdf#Rfn.Arima.1) in the `Package 'forecast'` of the Comprehensive R Archive Network \(CRAN\)\.

## How ARIMA Works<a name="aws-forecast-recipe-arima-how-it-works"></a>

The ARIMA algorithm is especially useful for datasets that can be mapped to stationary time series\. The statistical properties of stationary time series, such as autocorrelations, are independent of time\. Datasets with stationary time series usually contain a combination of signal and noise\. The signal may exhibit a pattern of sinusoidal oscillation or have a seasonal component\. ARIMA acts like a filter to separate the signal from the noise, and then extrapolates the signal in the future to make predictions\.

## ARIMA Hyperparameters and Tuning<a name="aws-forecast-recipe-arima-hyperparamters"></a>

For information about ARIMA hyperparameters and tuning, see the `Arima` function documentation in the [Package 'forecast'](https://cran.r-project.org/web/packages/forecast/forecast.pdf) of [CRAN](https://cran.r-project.org)\.

Amazon Forecast converts the `DataFrequency` parameter specified in the [CreateDataset](API_CreateDataset.md) operation to the `frequency` parameter of the R [ts](https://www.rdocumentation.org/packages/stats/versions/3.6.1/topics/ts) function using the following table:


| DataFrequency \(string\) | R ts frequency \(integer\) | 
| --- | --- | 
| Y | 1 | 
| M | 12 | 
| W | 52 | 
| D | 7 | 
| H | 24 | 
| 30min | 2 | 
| 15min | 4 | 
| 10min | 6 | 
| 5min | 12 | 
| 1min | 60 | 

For frequencies less than 24 or short time series, the hyperparameters are set using the `auto.arima` function of the `Package 'forecast'` of [CRAN](https://cran.r-project.org)\. For frequencies greater than or equal to 24 and long time series, we use a Fourier series with K = 4, as described here, [Forecasting with long seasonal periods](https://robjhyndman.com/hyndsight/longseasonality/)\.

Supported data frequencies that aren't in the table default to a `ts` frequency of 1\.
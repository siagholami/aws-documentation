# Exponential Smoothing \(ETS\) Algorithm<a name="aws-forecast-recipe-ets"></a>

Exponential Smoothing [\(ETS\)](https://en.wikipedia.org/wiki/Exponential_smoothing) is a commonly\-used local statistical algorithm for time\-series forecasting\. The Amazon Forecast ETS algorithm calls the [ets function](https://cran.r-project.org/web/packages/forecast/forecast.pdf#Rfn.ets.1) in the `Package 'forecast'` of the Comprehensive R Archive Network \(CRAN\)\.

## How ETS Works<a name="aws-forecast-recipe-ets-how-it-works"></a>

The ETS algorithm is especially useful for datasets with seasonality and other prior assumptions about the data\. ETS computes a weighted average over all observations in the input time series dataset as its prediction\. The weights are exponentially decreasing over time, rather than the constant weights in simple moving average methods\. The weights are dependent on a constant parameter, which is known as the smoothing parameter\.

## ETS Hyperparameters and Tuning<a name="aws-forecast-recipe-ets-hyperparamters"></a>

For information about ETS hyperparameters and tuning, see the `ets` function documentation in the [Package 'forecast'](https://cran.r-project.org/web/packages/forecast/forecast.pdf) of [CRAN](https://cran.r-project.org)\.

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

Supported data frequencies that aren't in the table default to a `ts` frequency of 1\.
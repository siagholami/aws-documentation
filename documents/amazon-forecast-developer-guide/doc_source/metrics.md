# Evaluating Predictor Accuracy<a name="metrics"></a>

To evaluate the accuracy of an algorithm for various forecasting scenarios and to tune the predictor, use predictor metrics\. Amazon Forecast uses [backtesting](https://en.wikipedia.org/wiki/Backtesting) to produce metrics\.

Forecast automatically splits your input data into two datasets, training and test, as shown in the following figure\. Forecast decides how to split the input data by using the `BackTestWindowOffset` parameter that you specify in the [CreatePredictor](API_CreatePredictor.md) operation, or if not specified, it uses the default value of the `ForecastHorizon` parameter\. For more information, see [EvaluationParameters](API_EvaluationParameters.md)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/evaluation-offset.png)

To evaluate the metrics in multiple backtest scenarios with different virtual forecast start dates, as shown in the following figure, use the `NumberOfBacktestWindows` parameter in the `CreatePredictor` operation\. The default for the `NumberOfBacktestWindows` parameter is 1\. If you use the default, Forecast uses the simple splitting method shown in the preceding figure\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/evaluation-backtests.png)

After training, Amazon Forecast calculates the root mean square error \(RMSE\) and weighted quantile losses to determine how well the model predicted the test data in each backtest window and the average value over all the backtest windows\. These metrics measure the difference between the values predicted by the model and the actual values in the test dataset\. To retrieve the metrics, you use the [GetAccuracyMetrics](API_GetAccuracyMetrics.md) operation\.

**Root Mean Square Error**

*RMSE* is the square of the error term, which is the difference between the actual target value, `yi,t`, and the predicted \(forecasted\) value, `ŷi,t`, where `i` denotes the item index ranging from 1 to the total number of items, `n`, and `t` denotes the time index of the time series ranging from 1 to the final time in the evaluation period, `T`\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/metrics-rmse.png)

The RMSE metric favors a model whose individual errors are of consistent magnitude because large variations in error increase the RMSE\. Because of the squared error, a few poorly predicted values in an otherwise good forecast can increase the RMSE\.

**Prediction Quantiles and MAPE**

*Prediction quantiles* \(intervals\) express the uncertainty in the forecasts\. By calculating prediction quantiles, the model shows how much uncertainty is associated with each forecast\. Without accompanying prediction quantiles, point forecasts have limited value\.

Predicting forecasts at different quantiles is particularly useful when the costs of under and over predicting differ\. Amazon Forecast provides probabilistic predictions at three distinct quantiles—10%, 50%, and 90%—and calculates the associated loss \(error\) at each quantile\. The *weighted quantile loss* \(wQuantileLoss\) calculates how far off the forecast is from actual demand in either direction\. This is calculated as a percentage of demand on average in each quantile\. This metric helps capture the bias inherent in each quantile, which can't be captured by a calculation like MAPE \(Mean Absolute Percentage Error\), where the weights are equal\. As with MAPE and RMSE, lower wQuantileLoss errors indicate better overall forecast accuracy\.

The weighted quantile loss is calculated as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/metrics-quantile-loss.png)

*q**i*,*t*\(τ\) is the τ\-quantile that the model predicts\. τ is in the set \{0\.1, 0\.2, \.\.\., 0\.9\}\.

Amazon Forecast calculates the weighted P10, P50, and P90 quantile losses, where τ is in the set \{0\.1, 0\.5, 0\.9\}, respectively\. This covers the standard 80% confidence interval\. For RMSE, Amazon Forecast uses the P50 forecast to represent the predicted value, for example, `ŷi,t = qi,t(0.5)`\.

When the sum of the exact target over all items and all time is approximately zero in a given backtest window, the weighted quantile loss expression is undefined\. In this case, Amazon Forecast outputs the unweighted quantile loss, which is the numerator in the above wQuantileLoss expression\.

**wQuantileLoss\[0\.1\]**: For the P10 prediction, the true value is expected to be lower than the predicted value 10% of the time\.

For example, suppose that you're a retailer and you want to forecast product demand for winter gloves that sell well only during the fall and winter\. If you don't have a lot of storage space and the cost of invested capital is high, or if the price of being overstocked on winter gloves concerns you, you might use the P10 quantile to order a relatively low number of winter gloves\. You know that the P10 forecast overestimates the demand for your winter gloves only 10% of the time, so 90% of the time you'll be sold out of your winter gloves\.

**wQuantileLoss\[0\.5\]**: For the P50 prediction, the true value is expected to be lower than the predicted value 50% of the time\. In most cases, the point forecasts that you generate internally or with other forecasting tools should match the P50 forecasts\. If τ = 0\.5, both weights are equal and the wQuantileLoss\[0\.5\] reduces to the commonly used Mean Absolute Percentage Error \(MAPE\):

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/metrics-mape.png)

where `ŷi,t = qi,t(0.5)`\.

Forecast uses the scaling factor of 2 in the wQuantileLoss formula to cancel the 0\.5 factor to obtain the exact MAPE expression\.

Continuing the winter gloves example, if you know that there'll be a moderate amount of demand for the gloves and aren't concerned about being overstocked, you might choose to use the P50 quantile to order gloves\.

**wQuantileLoss\[0\.9\]**: For the P90 prediction, the true value is expected to be lower than the predicted value 90% of the time\.

If you determine that being understocked on gloves will result in huge amounts of lost revenue—for example, the cost of not selling gloves is extremely high or the cost of invested capital is low—you might choose to use the P90 quantile to order gloves\.

The following figure of a forecast that has a Gaussian distribution, shows the quantiles that divide the forecast into four regions of equal probability\. For information about the quantiles of a distribution, see [Quantile](https://en.wikipedia.org/wiki/Quantile) on Wikipedia\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/metrics-gaussian.png)
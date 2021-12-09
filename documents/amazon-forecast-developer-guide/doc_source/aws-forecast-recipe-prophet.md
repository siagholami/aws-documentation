# Prophet Algorithm<a name="aws-forecast-recipe-prophet"></a>

[Prophet](https://facebook.github.io/prophet/) is a popular local Bayesian structural time series model\. The Amazon Forecast Prophet algorithm uses the [Prophet class](https://facebook.github.io/prophet/docs/quick_start.html#python-ap) of the Python implementation of Prophet\.

## How Prophet Works<a name="aws-forecast-recipe-prophet-how-it-works"></a>

Prophet is especially useful for datasets that:
+ Contain an extended time period \(months or years\) of detailed historical observations \(hourly, daily, or weekly\)
+ Have multiple strong seasonalities
+ Include previously known important, but irregular, events
+ Have missing data points or large outliers
+ Have non\-linear growth trends that are approaching a limit

Prophet is an additive regression model with a piecewise linear or logistic growth curve trend\. It includes a yearly seasonal component modeled using Fourier series and a weekly seasonal component modeled using dummy variables\.

For more information, see [Prophet: forecasting at scale](https://research.fb.com/prophet-forecasting-at-scale/)\.

## Prophet Hyperparameters and Related Time Series<a name="aws-forecast-recipe-prophet-hyperparamters"></a>

Amazon Forecast uses the default Prophet [hyperparameters](https://facebook.github.io/prophet/docs/quick_start.html#python-ap)\. Prophet also supports related time\-series as features, provided to Amazon Forecast in the related time\-series CSV file\.
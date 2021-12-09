# What Is Amazon Forecast?<a name="what-is-forecast"></a>

Amazon Forecast is a fully managed service for time\-series forecasting\. By providing Amazon Forecast with historical time\-series data, you can predict future points in the series\. Time\-series forecasting is useful in multiple domains, including retail, financial planning, supply chain, and healthcare\. You can also use Amazon Forecast to forecast operational metrics for inventory management, and workforce and resource planning and management\.

For example, you can use Amazon Forecast to forecast the following:
+ Retail product demand, such as the demand for products selling on a website or at a particular store or location
+ Supply chain demand including the quantity of raw goods, services, or other inputs needed by manufacturing
+ Resource requirements, such as the number of call center agents, contract workers, IT staff, and energy needed to meet demand
+ Operational metrics, such as web traffic to servers, AWS usage, or IoT sensor usage
+ Business metrics, such as cash flow, sales, profits, and expenses on a per\-region or per\-service basis

Amazon Forecast greatly simplifies building machine learning models\. In addition to providing a set of predefined algorithms, Forecast provides an *AutoML* option for model training\. AutoML automates complex machine learning tasks, such as algorithm selection, hyperparameter tuning, iterative modeling, and model assessment\. Developers with no machine learning expertise can use the Amazon Forecast APIs, AWS Command Line Interface \(AWS CLI\), or Amazon Forecast console to import training data into one or more Amazon Forecast datasets, train predictors, and generate forecasts\.

Amazon Forecast provides the following additional advantages:
+ Accuracy – Amazon Forecast uses deep neural net and traditional statistical methods for forecasting\. When you have many related time series, forecasts made using the Amazon Forecast deep learning algorithms, such as [DeepAR\+](aws-forecast-recipe-deeparplus.md) and [CNN\-QR](aws-forecast-algo-cnnqr.md) , tend to be more accurate than forecasts made with traditional methods, such as exponential smoothing\.
+ Usability – You can use theAmazon Forecast console to look up and visualize forecasts for any time series at different granularities\. You can also see metrics for the accuracy of your forecasts\.

For more information on Amazon Forecast, including use cases and underlying service principles, see [Time Series Forecasting Principles with Amazon Forecast](https://d1.awsstatic.com/whitepapers/time-series-forecasting-principles-amazon-forecast.pdf?did=wp_card&trk=wp_card)\.

## Are You a First\-Time User of Amazon Forecast?<a name="whatis-firsttimeuser"></a>

If you are a first\-time user of Amazon Forecast, we recommend that you read the following:

1. [How Amazon Forecast Works](how-it-works.md) – Explains key Amazon Forecast concepts and describes how Amazon Forecast builds forecasting predictors\. We recommend that you read this topic from start to finish\.

1. [Getting Started](getting-started.md) – Shows you how to create your first Amazon Forecast forecasting predictor\.

1.  [Actions](API_Operations.md) – Describes the Amazon Forecast API operations\.
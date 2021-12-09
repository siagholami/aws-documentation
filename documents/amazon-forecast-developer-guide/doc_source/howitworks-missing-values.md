# Handling Missing Values<a name="howitworks-missing-values"></a>

A common issue in time\-series forecasting data is the presence of missing values\. Your data might contain missing values for a number of reasons, including measurement failures, formatting problems, human errors, or a lack of information to record\. For instance, if you're forecasting product demand for a retail store and an item is sold out or unavailable, there would be no sales data to record while that item is out of stock\. If prevelant enough, missing values can signficantly impact a model's accuracy\.

Amazon Forecast provides a number of filling methods to handle missing values in your target time series and related time series datasets\. Filling is the process of adding standardized values to missing entries in your dataset\.

Forecast supports the following filling methods:
+ **Middle filling** – Fills any missing values between the dataset's item start and item end date\.
+ **Back filling** – Fills any missing values between the dataset's last recorded data point and the dataset's global end date\.
+ **Future filling \(related time series only\)** – Fills any missing values between the dataset's global end date and the end of the forecast horizon\.

The following image provides a visual representation of different filling methods\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/Filling_types.PNG)

## Choosing Filling Logic<a name="choosing-missing-values"></a>

When choosing a filling logic, you should consider how the logic will be interpreted by your model\. For instance, in a retail scenario, recording 0 sales of an available item is different from recording 0 sales of an unavailable item, as the latter does not imply a lack of customer interest in the item\. Because of this, `0` filling in the target time series might cause the predictor to be under\-biased in its predictions, while `NaN` filling might ignore actual occurances of 0 available items being sold and cause the predictor to be over\-biased\.

The following time\-series graphs illustrate how choosing the wrong filling value can significantly affect the accuracy of your model\. Graphs A and B plot the demand for an item that is partially out\-of\-stock, with the black lines representing actual sales data\. Missing values in A1 are filled with `0`, leading to relatively under\-biased predictions \(represented by the dotted lines\) in A2\. Similarly, missing values in B1 are filled with `NaN`, which leads to predictions that are more exact in B2\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/filling_values.PNG)

For a list of supported filling logic, see the following section\.

## Target Time Series and Related Time Series Filling Logic<a name="filling-restrictions"></a>

You can perform filling on both target time series and related time series datasets\. Each dataset type has different filling guidelines and restrictions\.


**Filling Guidelines**  

| Dataset type | Filling by default? | Supported filling methods | Default filling logic | Accepted filling logic | 
| --- | --- | --- | --- | --- | 
| Target time series | Yes | Middle and back filling | 0 |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/forecast/latest/dg/howitworks-missing-values.html)  | 
| Related time series | No | Middle, back, and future filling | No default |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/forecast/latest/dg/howitworks-missing-values.html)  | 

**Important**  
For both target and related time series datasets, `mean`, `median`, `min`, and `max` are calculated based on a rolling window of the 64 most recent data entries before the missing values\.

## Missing Value Syntax<a name="filling-syntax"></a>

To perform missing value filling, specify the types of filling to implement when you call the [CreatePredictor](API_CreatePredictor.md) operation\. Filling logic is specified in [FeaturizationMethod](API_FeaturizationMethod.md) objects\.

The following excerpt demonstrates a correctly formatted `FeaturizationMethod` object for a target time series attribute and related time series attribute \(`target_value` and `price` respectively\)\.

 To set a filling method to a specific value, set the fill parameter to `value` and define the value in a corresponding `_value` parameter\. As shown below, backfilling for the related time series is set to a value of 2 with the following: `"backfill": "value"` and `"backfill_value":"2"`\. 

```
[
    {
        "AttributeName": "target_value",
        "FeaturizationPipeline": [
            {
                "FeaturizationMethodName": "filling",
                "FeaturizationMethodParameters": {
                    "aggregation": "sum",
                    "middlefill": "zero",
                    "backfill": "zero"
                }
            }
        ]
    },
    {
        "AttributeName": "price",
        "FeaturizationPipeline": [
            {
                "FeaturizationMethodName": "filling",
                "FeaturizationMethodParameters": {
                    "middlefill": "median",
                    "backfill": "value",
                    "backfill_value": "2",
                    "futurefill": "max"               
                    }
            }
        ]
    }
]
```
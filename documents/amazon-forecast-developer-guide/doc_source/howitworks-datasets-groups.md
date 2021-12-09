# Datasets and Dataset Groups<a name="howitworks-datasets-groups"></a>

*Datasets* contain the data used to train a [predictor](howitworks-predictor.md)\. You create one or more Amazon Forecast datasets and import your training data into them\. A *dataset group* is a collection of complimentary datasets that detail a set of changing parameters over a series of time\. After creating a dataset group, you use it to train a predictor\. 

Each dataset group can have up to three datasets, one of each [dataset](#howitworks-dataset-domainstypes) type: target time series, related time series, and item metadata\.

To create and manage Forecast datasets and dataset groups, you can use the Forecast console, AWS Command Line Interface \(AWS CLI\), or AWS SDK\.

For example Forecast datasets, see the [Amazon Forecast Sample GitHub repository](https://github.com/aws-samples/amazon-forecast-samples)\.

**Topics**
+ [Datasets](#howitworks-dataset)
+ [Dataset Groups](#howitworks-datasetgroup)
+ [Resolving Conflicts in Data Collection Frequency](#howitworks-data-alignment)
+ [Using Related Time Series Datasets](related-time-series-datasets.md)
+ [Using Item Metadata Datasets](item-metadata-datasets.md)
+ [Handling Missing Values](howitworks-missing-values.md)
+ [Dataset Guidelines for Forecast](dataset-import-guidelines-troubleshooting.md)

## Datasets<a name="howitworks-dataset"></a>

To create and manage Forecast datasets, you can use the Forecast APIs, including the [CreateDataset](API_CreateDataset.md) and [DescribeDataset](API_DescribeDataset.md) operations\. For a complete list of Forecast APIs, see [API Reference](api-reference.md)\.

When creating a dataset, you provide information, such as the following:
+ The frequency/interval at which you recorded your data\. For example, you might aggregate and record retail item sales every week\. In the [Getting Started](getting-started.md) exercise, you use the average electricity used per hour\.
+ The prediction format \(the *domain*\) and dataset type \(within the domain\)\. A dataset domain specifies which type of forecast you'd like to perform, while a dataset type helps you organize your training data into Forecast\-friendly categories\.
+ The dataset *schema*\. A schema maps the column headers of your dataset\. For instance, when monitoring demand, you might have collected hourly data on the sales of an item at multiple stores\. In this case, your schema would define the order, from left to right, in which timestamp, location, and hourly sales appear in your training data file\. Schemas also define each column's data type, such as `string` or `integer`\.

Each column in your Forecast dataset represents either a forecast *dimension* or *feature*\. Forecast dimensions describe the aspects of your data that do not change over time, such a `store` or `location`\. Forecast features include any parameters in your data that vary across time, such as `price` or `promotion`\. Some dimensions, like `timestamp` or `itemId`, are required in target time series and related time series datasets\.

### Dataset Domains and Dataset Types<a name="howitworks-dataset-domainstypes"></a>

When you create a Forecast dataset, you choose a domain and a dataset type\. Forecast provides domains for a number of use cases, such as forecasting retail demand or web traffic\. You can also create a custom domain\.  For a complete list of Forecast domains, see [Predefined Dataset Domains and Dataset Types](howitworks-domains-ds-types.md)\.

Within each domain, Forecast users can specify the following types of datasets:
+ Target time series dataset \(required\) – Use this dataset type when your training data is a time series *and* it includes the field that you want to generate a forecast for\. This field is called the *target field*\.
+ Related time series dataset \(optional\) – Choose this dataset type when your training data is a time series, but it *doesn't* include the target field\. For instance, if you're forecasting item demand, a related time series dataset might have `price` as a field, but not `demand`\.
+ Item metadata dataset \(optional\) – Choose this dataset type when your training data *isn't* time\-series data, but includes metadata information about the items in the target time series or related time series datasets\. For instance, if you're forecasting item demand, an item metadata dataset might `color` or `brand` as dimensions\. Forecast only considers the data provided by an item metadata dataset type when you use the [CNN\-QR](aws-forecast-algo-cnnqr.md) or [DeepAR\+](aws-forecast-recipe-deeparplus.md) algorithm\.

Depending on the information in your training data and what you want to forecast, you might create more than one dataset\. 

For example, suppose that you want to generate a forecast for the demand of retail items, such as shoes and socks\. You might create the following datasets in the RETAIL domain:
+ Target time series dataset – Includes the historical time\-series demand data for the retail items \(`item_id`, `timestamp`, and the target field `demand`\)\. Because it designates the target field that you want to forecast, you must have at least one target time series dataset in a dataset group\.

  You can also add up to ten other dimensions to a target time series dataset\. If you include only a target time series dataset in your dataset group, you can create forecasts at either the item level or the forecast dimension level of granularity only\. For more information, see [CreatePredictor](API_CreatePredictor.md)\.
+ Related time series dataset – Includes historical time\-series data other than the target field, such as `price` or `revenue`\. Because related time series data must be mappable to target time series data, each related time series dataset must contain the same identifying fields\. In the RETAIL domain, these would be `item_id` and `timestamp`\.

  A related time series dataset might contain data that refines the forecasts made off of your target time series dataset\. For example, you might include `price` data in your related time series dataset on the future dates that you want to generate a forecast for\. This way, Forecast can make predictions with an additional dimension of context\. For more information, see [Using Related Time Series Datasets](related-time-series-datasets.md)\.
+ Item metadata dataset – Includes metadata for the retail items\. Examples of metadata include `brand`, `category`,`color`, and `genre`\.

**Example Dataset with a Forecast Dimension**

Continuing with the preceding example, imagine that you want to forecast the demand for shoes and socks based on a store's previous sales\. In the following target time series dataset, `store` is a time\-series forecast dimension, while `demand` is the target field\. Socks are sold in two store locations \(NYC and SFO\), and shoes are sold only in ORD\.

The first three rows of this table contain the first available sales data for the NYC, SFO, and ORD stores\. The last three rows contain the last recorded sales data for each store\. The `...` row represents all of the item sales data recorded between the first and last entries\.


| `timestamp` | `item_id` | `store` | `demand` | 
| --- | --- | --- | --- | 
| 2019\-01\-01 | socks | NYC |  25  | 
| 2019\-01\-05 | socks | SFO | 45 | 
| 2019\-02\-01 | shoes | ORD | 10 | 
| \.\.\. | 
| 2019\-06\-01 | socks | NYC | 100 | 
| 2019\-06\-05 | socks | SFO | 5 | 
| 2019\-07\-01 | shoes | ORD | 50 | 

### Dataset Schema<a name="howitworks-dataset-schema"></a>

Each dataset requires a schema, a user\-provided JSON mapping of the fields in your training data\. This is where you list both the required and optional dimensions and features that you want to include in your dataset\.

Some domains have optional dimensions that we recommend including\. Optional dimensions are listed in the descriptions of each domain later in this guide\. For an example, see [RETAIL Domain](retail-domain.md)\. All optional dimensions take the data type `string`\.

A schema is required for every dataset\. The following is the accompanying schema for the example target time series dataset above\.

```
{
     "attributes": [
        {
           "AttributeName": "timestamp",
           "AttributeType": "timestamp"
        },
        {
           "AttributeName": "item_id",
           "AttributeType": "string"
        },
        {
           "AttributeName": "store",
           "AttributeType": "string"
        },
        {
           "AttributeName": "demand",
           "AttributeType": "float"
        }
    ]
}
```

When you upload your training data to the dataset that uses this schema, Forecast assumes that the `timestamp` field is column 1, the `item_id` field is column 2, the `store` field is column 3, and the `demand` field, the *target* field, is column 4\.

For the related time series dataset type, all related features must have a float or integer attribute type\. For the item metadata dataset type, all features must have a string attribute type\. For more information, see [SchemaAttribute](API_SchemaAttribute.md)\.

**Note**  
An `attributeName` and `attributeType` pair is required for every column in the dataset\. Forecast reserves a number of names that can't be used as the name of a schema attribute\. For the list of reserved names, see [Reserved Field Names](reserved-field-names.md)\.

## Dataset Groups<a name="howitworks-datasetgroup"></a>

A *dataset group* is a collection of one to three complimentary datasets, one of each dataset type\. You import datasets to a dataset group, then use the dataset group to train a predictor\.

Forecast includes the following operations to create dataset groups and add datasets to them:
+ [CreateDatasetGroup](API_CreateDatasetGroup.md)
+ [UpdateDatasetGroup](API_UpdateDatasetGroup.md)

## Resolving Conflicts in Data Collection Frequency<a name="howitworks-data-alignment"></a>

Forecast can import data that isn't aligned with the collection frequency specified in the [CreateDataset](API_CreateDataset.md) operation\. For example, you can import data for which the collection frequency is hourly and some of the data isn't timestamped at the top of the hour \(02:20, 02:45\)\. Forecast aggregates the data to match the aligned value\. The following tables show an example aggregation\.

**Pre\-transformation**


| Time | Data | At Top of the Hour | 
| --- | --- | --- | 
| 2018\-03\-03 01:00:00 | 100 | Yes | 
| 2018\-03\-03 02:20:00 | 50 | No | 
| 2018\-03\-03 02:45:00 | 20 | No | 
| 2018\-03\-03 04:00:00 | 120 | Yes | 

**Post\-transformation**


| Time | Data | Notes | 
| --- | --- | --- | 
| 2018\-03\-03 01:00:00 | 100 |  | 
| 2018\-03\-03 02:00:00 | 70 | Sum of the values between 02:00:00\-02:59:59 \(50 \+ 20\) | 
| 2018\-03\-03 03:00:00 | Empty | No values between 03:00:00\-03:59:59 | 
| 2018\-03\-03 04:00:00 | 120 |  | 

### Time Boundaries<a name="howitworks-time-boundaries"></a>

**Time Boundaries**

The following table lists the time alignment boundaries Forecast uses when aggregating data\.


| Frequency | Boundary | 
| --- | --- | 
| Year | First day of the year \(January 1\) | 
| Month | First day of the month | 
| Week | Most recent Monday | 
| Hour | Last top of the hour \(09:00:00, 13:00:00\) | 
| Minute | Last top of the minute \(45:00, 06:00\) | 

The following figure shows how Forecast transforms data to fit the weekly boundary:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/forecast/latest/dg/images/data-alignment.png)

### Data Aggregation Guidelines<a name="howitworks-dataset-guidelines"></a>

 When using the `FeaturizationMethod` API, set the aggreaggation method within `FeaturizationMethodParameters`\. The aggregation parameter accepts the following values: `sum`, `avg`, `first`, `min`, and `max`\. The default value is `sum`\.

Forecast doesn't assume that your data is from any specific time zone\. However, it makes the following assumptions when aggregating time series data:
+ All data is from the same time zone\.
+ All forecasts are in the same time zone as the data in the dataset\.
+ If you specify the [SupplementaryFeature](API_SupplementaryFeature.md) holiday feature in the [InputDataConfig](API_InputDataConfig.md) parameter for the [CreatePredictor](API_CreatePredictor.md) operation, the input data is from the same country\. 
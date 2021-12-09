# RETAIL Domain<a name="retail-domain"></a>

The RETAIL domain supports the following dataset types\. For each dataset type, we list required and optional fields\. For information on how to map the fields to columns in your training data, see [Dataset Domains and Dataset Types](howitworks-datasets-groups.md#howitworks-dataset-domainstypes)\.

**Topics**
+ [Target Time Series Dataset Type](#target-time-series-type-retail-domain)
+ [Related Time Series Dataset Type](#related-time-series-type-retail-domain)
+ [Item Metadata Dataset Type](#item-metadata-type-retail-domain)

## Target Time Series Dataset Type<a name="target-time-series-type-retail-domain"></a>

The target time series is the historical time series data for each item or product sold by the retail organization\. The following fields are required: 
+ `item_id ` \(string\) – A unique identifier for the item or product that you want to predict the demand for\.
+ `timestamp` \(timestamp\)
+ `demand` \(float\) – The number of sales for that item at the timestamp\. This is also the *target* field for which Amazon Forecast generates a forecast\.

The following dimension is optional and can be used to change forecasting granularity:
+ `location` \(string\) – The location of the store that the item got sold at\. This should only be used if you have multiple stores/locations\.

Ideally, only these required fields and optional dimensions should be included\. Other additional time series information should be included in a related time series dataset\.

## Related Time Series Dataset Type<a name="related-time-series-type-retail-domain"></a>

You can provide Amazon Forecast with related time series datasets, such as the price or the number of web hits the item received on a particular date\. The more information that you provide, the more accurate the forecast\. The following fields are required: 
+ `item_id ` \(string\)
+ `timestamp `\(timestamp\)

The following fields are optional and might be useful in improving forecast results:
+ `price` \(float\) – The price of the item at the time of the timestamp\.
+ `promotion_applied` \(integer; 1=true, 0=false\) – A flag that specifies whether there was a marketing promotion for that item at the timestamp\.

In addition to the required and suggested optional fields, your training data can include other fields\. To include other fields in the dataset, provide the fields in a schema when you create the dataset\.

## Item Metadata Dataset Type<a name="item-metadata-type-retail-domain"></a>

This dataset provides Amazon Forecast with information about metadata \(attributes\) of the items whose demand is being forecast\. The following fields are required:
+ `item_id `\(string\)

The following fields are optional and might be useful in improving forecast results:
+ `category` \(string\)
+ `brand` \(string\)
+ `color` \(string\)
+ `genre` \(string\)

In addition to the required and suggested optional fields, your training data can include other fields\. To include other fields in the dataset, provide the fields in a schema when you create the dataset\.
# INVENTORY\_PLANNING Domain<a name="inv-planning-domain"></a>

Use the INVENTORY\_PLANNING domain for forecasting demand for raw materials and determining how much inventory of a particular item to stock\. It supports the following dataset types\. For each dataset type, we list required and optional fields\. For information on how to map the fields to columns in your training data, see [Dataset Domains and Dataset Types](howitworks-datasets-groups.md#howitworks-dataset-domainstypes)\.

**Topics**
+ [Target Time Series Dataset Type](#target-time-series-type-inv-planning-domain)
+ [Related Time Series Dataset Type](#related-time-series-type-related time series-domain)
+ [Item Metadata Dataset Type](#item-metadata-type-related time series-domain)

## Target Time Series Dataset Type<a name="target-time-series-type-inv-planning-domain"></a>

The following fields are required: 
+ `item_id` \(string\)
+ `timestamp` \(timestamp\)
+ `demand` \(float\) – This is the `target` field for which Amazon Forecast generates a forecast\.

The following dimension is optional and can be used to change forecasting granularity:
+ `location` \(string\) – The location of the distribution center where the item is stocked\. This should only be used if you have multiple stores/locations\.

Ideally, only these required fields and optional dimensions should be included\. Other additional time series information should be included in a related time series dataset\.

## Related Time Series Dataset Type<a name="related-time-series-type-related time series-domain"></a>

The following fields are required: 
+ `item_id` \(string\)
+ `timestamp` \(timestamp\)

The following fields are optional and might be useful in improving forecast results:
+ `price` \(float\) – The price of the item 

In addition to the required and suggested optional fields, your training data can include other fields\. To include other fields in the dataset, provide the fields in a schema when you create the dataset\.

## Item Metadata Dataset Type<a name="item-metadata-type-related time series-domain"></a>

The following fields are required: 
+ `item_id` \(string\)

The following fields are optional and might be useful in improving forecast results:
+ `category` \(string\) – The category of the item\.
+ `brand` \(string\) – The brand of the item\.
+ `lead_time` \(string\) – The lead time, in days, to manufacture the item\.
+ `order_cycle` \(string\) – The order cycle starts when work begins and ends when the item is ready for delivery\.
+ `safety_stock` \(string\) – The minimum amount of stock to keep on hand for that item\.

In addition to the required and suggested optional fields, your training data can include other fields\. To include other fields in the dataset, provide the fields in a schema when you create the dataset\.
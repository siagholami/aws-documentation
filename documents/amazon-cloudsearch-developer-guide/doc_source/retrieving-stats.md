# Getting Statistics for Numeric Fields in Amazon CloudSearch<a name="retrieving-stats"></a>

Amazon CloudSearch can return the following statistics for facet\-enabled numeric fields:
+ `count`–The number of documents that contain a value in the specified field\.
+ `max`–The maximum value found in the specified field\.
+ `mean`–The average of the values found in the specified field\.
+ `min`–The minimum value found in the specified field\.
+ `missing`–The number of documents that do not contain a value in the specified field\.
+ `stddev`–A measure to quantify the amount of deviation, or variation, in the field values\. A low standard deviation indicates that the values across all documents are close to the mean\. A high standard deviation indicates that the values are spread out over a large range\. The standard deviation is calculated by taking the square root of the variance, which is the average of the squared differences from the mean\. 
+ `sum`–The sum of the field values across all documents\.
+ `sumOfSquares`–The sum of all field values squared\.

To get statistics for a field you use the `stats.FIELD` parameter\. `FIELD` is the name of a facet\-enabled numeric field\. You specify an empty JSON object, `stats.FIELD={}`, to get all of the available statistics for the specified field\. \(The `stats.FIELD` parameter does not support any options; you must pass an empty JSON object\.\) You can request statistics for multiple fields in the same request\.

You can get statistics only for facet\-enabled numeric fields: `date`, `date-array`, `double`, `double-array`, `int`, or `int-array`\. Note that only the `count`, `max`, `min`, and `missing` statistics are returned for `date` and `date-array` fields\. For more information about enabling a field to return facets, see [Configuring Index Fields](configuring-index-fields.md)\.

For example, to search for *star* and get statistics for the *year* field, specify the following:

```
search?q=star&stats.year={}
```
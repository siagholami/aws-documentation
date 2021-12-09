# Querying asset property values and aggregates<a name="query-industrial-data"></a>

You can use the AWS IoT SiteWise API operations to query your asset properties' current values, historical values, and aggregates over specific time intervals\. You can use these features to gain quick insights or develop software solutions that integrate with the industrial data stored in your AWS IoT SiteWise assets\.

You can also explore your asset data live in AWS IoT SiteWise Monitor\. To learn how to configure SiteWise Monitor, see [Monitoring data with AWS IoT SiteWise Monitor](monitor-data.md)\.

The operations described in this section return property value objects that contain timestamp, quality, value \(TQV\) structures\.
+ The `timestamp` contains the current Unix epoch time in seconds with nanosecond offset\.
+ The `quality` contains one of the following strings that indicate the quality of the data point:
  + `GOOD` – The data isn't affected by any issues\.
  + `BAD` – The data is affected by an issue such as sensor failure\.
  + `UNCERTAIN` – The data is affected by an issue such as sensor inaccuracy\.
+ The `value` contains one of the following fields, depending on the type of the property:
  + `booleanValue`
  + `doubleValue`
  + `integerValue`
  + `stringValue`

**Topics**
+ [Querying current asset property values](#current-values)
+ [Querying historical asset property values](#historical-values)
+ [Querying asset property aggregates](#aggregates)

## Querying current asset property values<a name="current-values"></a>

You can use the AWS IoT SiteWise console or API to get the current value of an asset property\.

**Topics**
+ [Querying an asset property's current value \(console\)](#query-current-value-console)
+ [Querying an asset property's current value \(CLI\)](#query-current-value-cli)

### Querying an asset property's current value \(console\)<a name="query-current-value-console"></a>

You can use the AWS IoT SiteWise console to view the current value of an asset property\.

**To get the current value of an asset property \(console\)**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-assets"></a>In the navigation pane, choose **Assets**\.

1. Choose the asset with the property to query\.
**Tip**  <a name="sitewise-expand-asset-hierarchy"></a>
You can choose the arrow icon to expand an asset hierarchy to find your asset\.  

![\[AWS IoT SiteWise "Assets" page screenshot with an asset hierarchy highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-expand-asset-hierarchy-console.png)

1. Choose the tab for the type of property\. For example, choose **Measurements** to view the current value of a measurement property\.  
![\[AWS IoT SiteWise "Asset" page property tabs screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-asset-choose-property-tab-console.png)

1. Find the property to view\. The current value appears in the **Latest value** column\.

### Querying an asset property's current value \(CLI\)<a name="query-current-value-cli"></a>

You can use the AWS Command Line Interface \(AWS CLI\) to query the current value of an asset property\.

Use the [GetAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyValue.html) operation to query an asset property's current value\.

To identify an asset property, you can specify one of the following:
+ The `assetId` and `propertyId` of the asset property that you are sending data to\.
+ The `propertyAlias`, which is a data stream alias \(for example, `/company/windfarm/3/turbine/7/temperature`\)\. To use this option, you must first set your asset property's alias\. To learn how to set property aliases, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

**To get the current value of an asset property \(CLI\)**
+ Run the following command to get the current value of the asset property\. Replace *asset\-id* with the ID of the asset and *property\-id* with the ID of the property\.

  ```
  aws iotsitewise get-asset-property-value \
    --asset-id asset-id \
    --property-id property-id
  ```

  The operation returns a response that contains the current TQV of the property in the following format\.

  ```
  {
    "propertyValue": {
      "value": {
        "booleanValue": Boolean,
        "doubleValue": Number,
        "integerValue": Number,
        "stringValue": "String"
      },
      "timestamp": {
        "timeInSeconds": Number,
        "offsetInNanos": Number
      },
      "quality": "String"
    }
  }
  ```

## Querying historical asset property values<a name="historical-values"></a>

You can use the AWS IoT SiteWise API to get the value history for an asset property\.

Use the [GetAssetPropertyValueHistory](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyValueHistory.html) operation to query the historical values of an asset property\.

To identify an asset property, you can specify one of the following:
+ The `assetId` and `propertyId` of the asset property that you are sending data to\.
+ The `propertyAlias`, which is a data stream alias \(for example, `/company/windfarm/3/turbine/7/temperature`\)\. To use this option, you must first set your asset property's alias\. To learn how to set property aliases, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

You can also pass any of the following parameters to refine your results:
+ `startDate` – The exclusive start of the range from which to query historical data, expressed in seconds in Unix epoch time\.
+ `endDate` – The inclusive end of the range from which to query historical data, expressed in seconds in Unix epoch time\.
+ `maxResults` – The maximum number of results to return in one request\. Defaults to `20` results\.
+ `nextToken` – A pagination token returned from a previous call of this operation\.
+ `timeOrdering` – The ordering to apply to the returned values: `ASCENDING` or `DESCENDING`\.
+ `qualities` – The quality to filter results by: `GOOD`, `BAD`, or `UNCERTAIN`\.

**To query the value history for an asset property \(CLI\)**

1. Run the following command to get the value history for the asset property\. This command queries the property's history over a specific 10 minute interval\. Replace *asset\-id* with the ID of the asset and *property\-id* with the ID of the property\. Replace the date parameters with the interval to query\.

   ```
   aws iotsitewise get-asset-property-value-history \
     --asset-id asset-id \
     --property-id property-id \
     --start-date 1575216000 \
     --end-date 1575216600
   ```

   The operation returns a response that contains the historical TQVs of the property in the following format\.

   ```
   {
     "assetPropertyValueHistory": [
       {
         "value": {
           "booleanValue": Boolean,
           "doubleValue": Number,
           "integerValue": Number,
           "stringValue": "String"
         },
         "timestamp": {
           "timeInSeconds": Number,
           "offsetInNanos": Number
         },
         "quality": "String"
       }
     ],
     "nextToken": "String"
   }
   ```

1. If more value entries exist, you can pass the pagination token from the `nextToken` field to a subsequent call to the [GetAssetPropertyValueHistory](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyValueHistory.html) operation\.

## Querying asset property aggregates<a name="aggregates"></a>

AWS IoT SiteWise automatically computes aggregated asset property values, which are a set of basic metrics calculated over multiple time intervals\. AWS IoT SiteWise computes the following aggregates every minute, hour, and day for your asset properties:
+ **average** – The average \(mean\) of a property's values over a time interval\.
+ **count** – The number of data points for a property over a time interval\.
+ **maximum** – The maximum of a property's values over a time interval\.
+ **minimum** – The minimum of a property's values over a time interval\.
+ **standard deviation** – The standard deviation of a property's values over a time interval\.
+ **sum** – The sum of a property's values over a time interval\.

For non\-numeric properties, such as strings and Booleans, AWS IoT SiteWise computes only the count aggregate\.

You can also compute custom metrics for your asset data\. Metric properties let you define aggregations specific to your operation\. Metric properties offer additional aggregation functions and time intervals that aren't precomputed for the AWS IoT SiteWise API\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

You can use the AWS IoT SiteWise API to get aggregates for an asset property\.

Use the [GetAssetPropertyAggregates](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyAggregates.html) operation to query aggregates of an asset property\.

To identify an asset property, you can specify one of the following:
+ The `assetId` and `propertyId` of the asset property that you are sending data to\.
+ The `propertyAlias`, which is a data stream alias \(for example, `/company/windfarm/3/turbine/7/temperature`\)\. To use this option, you must first set your asset property's alias\. To learn how to set property aliases, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

You must also pass the following required parameters:
+ `aggregateTypes` – The list of aggregates to retrieve\. You can specify any of `AVERAGE`, `COUNT`, `MAXIMUM`, `MINIMUM`, `STANDARD_DEVIATION`, and `SUM`\.
+ `resolution` – The time interval for which to retrieve the metric: `1m` \(1 minute\), `1h` \(1 hour\), or `1d` \(1 day\)\.
+ `startDate` – The exclusive start of the range from which to query historical data, expressed in seconds in Unix epoch time\.
+ `endDate` – The inclusive end of the range from which to query historical data, expressed in seconds in Unix epoch time\.

You can also pass any of the following parameters to refine your results:
+ `maxResults` – The maximum number of results to return in one request\. Defaults to `20` results\.
+ `nextToken` – A pagination token returned from a previous call of this operation\.
+ `timeOrdering` – The ordering to apply to the returned values: `ASCENDING` or `DESCENDING`\.
+ `qualities` – The quality to filter results by: `GOOD`, `BAD`, or `UNCERTAIN`\.

**Note**  
The [GetAssetPropertyAggregates](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyAggregates.html) operation returns a TQV with a different format than other operations described in this section\. The `value` structure contains a field for each of the `aggregateTypes` in the request\. The `timestamp` contains the time that the aggregation occurred, in seconds in Unix epoch time\.

**To query aggregates for an asset property \(CLI\)**

1. Run the following command to get aggregates for the asset property\. This command queries the average and sum with a 1 hour resolution for a specific 1 hour interval\. Replace *asset\-id* with the ID of the asset and *property\-id* with the ID of the property\. Replace the parameters with the aggregates and interval to query\.

   ```
   aws iotsitewise get-asset-property-aggregates \
     --asset-id asset-id \
     --property-id property-id \
     --start-date 1575216000 \
     --end-date 1575219600 \
     --aggregate-types AVERAGE SUM \
     --resolution 1h
   ```

   The operation returns a response that contains the historical TQVs of the property in the following format\. The response includes only the requested aggregates\.

   ```
   {
     "aggregatedValues": [
       {
         "timestamp": Number,
         "quality": "String",
         "value": {
           "average": Number,
           "count": Number,
           "maximum": Number,
           "minimum": Number,
           "standardDeviation": Number,
           "sum": Number
         }
       }
     ],
     "nextToken": "String"
   }
   ```

1. If more value entries exist, you can pass the pagination token from the `nextToken` field to a subsequent call to the [GetAssetPropertyAggregates](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_GetAssetPropertyAggregates.html) operation\.
# Ingesting data using the AWS IoT SiteWise API<a name="ingest-api"></a>

You can use the AWS IoT SiteWise API to send timestamped industrial data to your assets' attribute and measurement properties\. The API accepts a payload that contains timestamp\-quality\-value \(TQV\) structures\.

Use the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation to upload your data\. With this operation, you can upload multiple data entries at a time, so that you can collect data from several devices and send it all in a single request\.

**Important**  
The [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) operation is subject to quotas on the number of entries per request and the number of TQV data points per entry\. AWS IoT SiteWise also rejects any data with a timestamp dated to more than 15 minutes in the past or more than 5 minutes in the future\. For more information about these quotas, see [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) in the *AWS IoT SiteWise API Reference*\.

To identify an asset property, you can specify one of the following:
+ The `assetId` and `propertyId` of the asset property that you are sending data to\.
+ The `propertyAlias`, which is a data stream alias \(for example, `/company/windfarm/3/turbine/7/temperature`\)\. To use this option, you must first set your asset property's alias\. To learn how to set property aliases, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

The following example demonstrates how to send a wind turbine's temperature and rotations per minute \(RPM\) readings from a payload stored in a JSON file\.

```
aws iotsitewise batch-put-asset-property-value --cli-input-json file://batch-put-payload.json
```

The example payload in `batch-put-payload.json` contains the following content\.

```
{
  "entries": [
    {
      "entryId": "unique entry ID",
      "propertyAlias": "/company/windfarm/3/turbine/7/temperature",
      "propertyValues": [
        {
          "value": {
            "integerValue": 38
          },
          "timestamp": {
            "timeInSeconds": 1575691200
          }
        }
      ]
    },
    {
      "entryId": "unique entry ID",
      "propertyAlias": "/company/windfarm/3/turbine/7/rpm",
      "propertyValues": [
        {
          "value": {
            "doubleValue": 15.09
          },
          "timestamp": {
            "timeInSeconds": 1575691200
          },
          "quality": "GOOD"
        }
      ]
    }
  ]
}
```

Each entry in the payload contains an `entryId` that you can define as any unique string\. If any request entries fail, each error will contain the `entryId` of the corresponding request so that you know which requests to retry\.

Each structure in the list of `propertyValues` is a timestamp\-quality\-value \(TQV\) structure that contains a `value`, a `timestamp`, and optionally a `quality`\.
+ `value` – A structure that contains one of the following fields, depending on the type of the property being set:
  + `booleanValue`
  + `doubleValue`
  + `integerValue`
  + `stringValue`
+ `timestamp` – A structure that contains the current Unix epoch time in seconds, `timeInSeconds`\. You can also set the `offsetInNanos` key in the `timestamp` structure if you have temporally precise data\. AWS IoT SiteWise rejects any data points with timestamps older than 15 minutes in the past or newer than 5 minutes in the future\.
+ `quality` – \(Optional\) One of the following quality strings:
  + `GOOD` – \(Default\) The data isn't affected by any issues\.
  + `BAD` – The data is affected by an issue such as sensor failure\.
  + `UNCERTAIN` – The data is affected by an issue such as sensor inaccuracy\.

  For more information about how AWS IoT SiteWise handles data quality in computations, see [Data quality in formula expressions](formula-expressions.md#data-quality)\.
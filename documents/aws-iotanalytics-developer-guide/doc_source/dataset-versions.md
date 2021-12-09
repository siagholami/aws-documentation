# Keeping multiple versions of datasets<a name="dataset-versions"></a>

You can choose how many versions of your data set contents to retain, and for how long, by specifying values for the data set `retentionPeriod and versioningConfiguration` fields when invoking the [CreateDataset](https://docs.aws.amazon.com/iotanalytics/latest/APIReference/API_CreateDataset.html) and [UpdateDataset](https://docs.aws.amazon.com/iotanalytics/latest/APIReference/API_UpdateDataset.html) APIs:

```
...
"retentionPeriod": {
  "unlimited": "boolean",
  "numberOfDays": "integer"
},
"versioningConfiguration": {
  "unlimited": "boolean",
  "maxVersions": "integer"
},
...
```

The settings of these two parameters work together to determine how many versions of data set contents are retained, and for how long, in the following ways\.


|  |  |  |  | 
| --- |--- |--- |--- |
|   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/dataset-versions.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/dataset-versions.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/dataset-versions.html)  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/dataset-versions.html)  |  Only the latest version plus the latest succeeded version \(if different\) are retained for 90 days\.  |  Only the latest version plus the latest succeeded version \(if different\) are retained for an unlimited time\.  |  Only the latest version plus the latest succeeded version \(if different\) are retained for X days\.  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/dataset-versions.html)  |  All versions from the last 90 days will be retained, regardless of how many\.  |  There is no limit to the number of versions retained\.  |  All versions from the last X days will be retained, regardless of how many\.  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/dataset-versions.html)  |  No more than Y versions from the last 90 days will be retained\.  |  Up to Y versions will be retained, regardless of how old they are\.  |  No more than Y versions from the last X days will be retained\.  | 
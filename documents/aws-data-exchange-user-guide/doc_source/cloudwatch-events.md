# CloudWatch Events<a name="cloudwatch-events"></a>

As a subscriber with an active subscription to a product, you receive a CloudWatch event from AWS Data Exchange every time the provider publishes new revisions or adds new data sets to an existing product\. The CloudWatch event contains the `DataSetId` and the list of `RevisionIds` that have been published\.

Revisions and data sets can be added in the console or programmatically\. For more information on adding these programmatically, see [Using AWS Data Exchange with the AWS Marketplace Catalog API](appendices.md)

## CloudWatch Events for adding revisions<a name="events-add-revision"></a>

When adding revisions, the detail type of the CloudWatch event is set to `Revision Published To Data Set`\. Here is an example CloudWatch event body for an added revision:

```
{
    "version": "0",
    "id": "dc529cb6-2e23-4c5f-d020-EXAMPLE92231",
    "detail-type": "Revision Published To Data Set",
    "source": "aws.dataexchange",
    "account": "123456789012",
    "time": "2020-07-29T04:16:28Z",
    "region": "us-east-1",
    "resources": [
        "aae4c2cdEXAMPLE54f9369dEXAMPLE66"
    ],
    "detail": {
        "RevisionIds": [
            "3afc623EXAMPLE099e6fcc8EXAMPLEe7"
        ]
    }
}
```

## CloudWatch Events for adding data sets<a name="events-add-data-sets"></a>

When adding data sets, the detail type of the CloudWatch event is set to `Data Sets Published to Product`\. Here is an example CloudWatch event body for an added data set:

```
{
    "version": "0",
    "id": "dc529cb6-2e23-4c5f-d020-EXAMPLE92231",
    "detail-type": "Data Sets Published To Product",
    "source": "aws.dataexchange",
    "account": "123456789012",
    "time": "2020-07-29T18:24:04Z",
    "region": "us-east-1",
    "resources": [
        "prod-uEXAMPLEabc1d"
    ],
    "detail": {
        "DataSetIds": [
            "4afc623EXAMPLE099e6fcc8EXAMPLEe8",
            "5bgd734EXAMPLE100f7gdd9EXAMPLEe9"
        ]
    }
}
```
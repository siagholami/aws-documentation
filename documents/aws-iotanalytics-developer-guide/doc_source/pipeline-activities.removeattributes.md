# RemoveAttributes activity<a name="pipeline-activities.removeattributes"></a>

A `removeAttributes` activity removes attributes from a message\. For example, given the message that was the result of the `removeAttributes` activity\.

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6, -122.3 ]
    },
    "id": "device-123",
    "lat": 47.6,
    "lon": -122.3
}
```

To normalize that message so that it includes only the required data at the root level, use the following `removeAttributes` activity\.

```
{
    "removeAttributes": {
        "name": "MyRemoveAttributesActivity",
        "attributes": [
            "device"
        ],
        "next": "MyDatastoreActivity"
    }
}
```

This results in the following message flowing along the pipeline\.

```
{
    "id": "device-123",
    "lat": 47.6,
    "lon": -122.3
}
```
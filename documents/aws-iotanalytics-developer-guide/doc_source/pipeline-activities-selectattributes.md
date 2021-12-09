# SelectAttributes activity<a name="pipeline-activities-selectattributes"></a>

The `selectAttributes` activity creates a new message using only the specified attributes from the original message\. Every other attribute is dropped\. `selectAttributes` creates new attributes under the root of the message only\. So given this message:

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6152543, -122.3354883 ],
        "temp": 50,
        "hum": 40
    },
    "light": 90
}
```

and this activity:

```
{
    "selectAttributes": {
        "name": "MySelectAttributesActivity",
        "attributes": [
            "device.temp",
            "device.hum",
            "light"
        ],
        "next": "MyDatastoreActivity"
    }
}
```

The result is the following message flowing through the pipeline\.

```
{
    "temp": 50,
    "hum": 40,
    "light": 90
}
```

Again, `selectAttributes` can only create root\-level objects\. 
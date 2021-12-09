# AddAttributes activity<a name="pipeline-activities-add-attributes"></a>

An `addAttributes` activity adds attributes based on existing attributes in the message\. This lets you alter the shape of the message before it is store\. For example, you can use `addAttributes` to normalize data coming from different generations of device firmware\.

Consider the following input message\.

```
{
    "device": {
        "id": "device-123",
        "coord": [ 47.6152543, -122.3354883 ]
    }
}
```

The `addAttributes` activity looks like the following\.

```
{
    "addAttributes": {
        "name": "MyAddAttributesActivity",
        "attributes": {
            "device.id": "id",
            "device.coord[0]": "lat",
            "device.coord[1]": "lon"
        },
        "next": "MyRemoveAttributesActivity"
    }
}
```

This activity moves the device ID to the root level and extracts the value in the `coord` array, promoting them to top\-level attributes called `lat` and `lon`\. As a result of this activity, the input message is transformed to the following example\.

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

The original device attribute is still present\. If you want to remove it, you can use the `removeAttributes` activity\.
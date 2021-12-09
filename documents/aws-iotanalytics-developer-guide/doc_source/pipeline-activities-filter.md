# Filter activity<a name="pipeline-activities-filter"></a>

A `filter`activity filters a message based on its attributes\. The expression used in this activity looks like an SQL `WHERE` clause which must return a Boolean\.

```
{
    "filter": {
        "name": "MyFilterActivity",
        "filter": "temp > 40 AND hum < 20",
        "next": "MyDatastoreActivity"
    }
}
```
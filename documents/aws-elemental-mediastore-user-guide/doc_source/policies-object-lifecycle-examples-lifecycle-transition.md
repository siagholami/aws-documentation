# Example object lifecycle policy: Transition to infrequent access storage class<a name="policies-object-lifecycle-examples-lifecycle-transition"></a>

The following policy specifies that MediaStore moves objects to the infrequent access \(IA\) storage class when they are 30 days old\. Objects that are stored in the IA storage class have different rates for storage and retrieval than objects that are stored in the standard storage class\.

The `days_since_create` field must be set to `"numeric": [">=" ,30]`\.

```
{
    "rules": [
        {
            "definition": {
                "path": [
                    {"prefix": "Football/"},
                    {"prefix": "Baseball/"}
                ],
                "days_since_create": [
                    {"numeric": [">=" , 30]}
                ]
            },
            "action": "ARCHIVE"
        }
    ]
}
```
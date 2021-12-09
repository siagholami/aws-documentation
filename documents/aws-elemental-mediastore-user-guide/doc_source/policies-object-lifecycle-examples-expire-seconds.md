# Example object lifecycle policy: Expire within seconds<a name="policies-object-lifecycle-examples-expire-seconds"></a>

The following policy specifies that MediaStore deletes objects that match all of the following criteria:
+ The object is added to the container after the policy becomes effective\.
+ The object is stored in the `Football` folder\.
+ The object has a file extension of `m3u8`\.
+ The object has been in the container for more than 20 seconds\.

```
{
    "rules": [
        {
            "definition": {
                "path": [
                    {"wildcard": "Football/*.m3u8"}
                ],
                "seconds_since_create": [
                    {"numeric": [ ">", 20 ]}
                ]
            },
            "action": "EXPIRE"
        }
    ]
}
```
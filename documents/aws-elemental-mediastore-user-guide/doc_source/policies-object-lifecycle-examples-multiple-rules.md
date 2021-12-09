# Example object lifecycle policy: Multiple rules<a name="policies-object-lifecycle-examples-multiple-rules"></a>

The following policy specifies that MediaStore does the following:
+ Move objects that are stored in the `AwardsShow` folder to the infrequent access \(IA\) storage class after 30 days
+ Delete objects that have a file extension of `m3u8` and are stored in the `Football` folder after 20 seconds
+ Delete objects that are stored in the `April` folder after 10 days
+ Delete objects that have a file extension of `ts` and are stored in the `Program` folder after 5 days

```
{
    "rules": [
        {
            "definition": {
                "path": [
                    {"prefix": "AwardsShow/"}
                ],
                "days_since_create": [
                    {"numeric": [ ">=" , 30 ]}
                ]
            },
            "action": "ARCHIVE"
        },
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
        },
        {
            "definition": {
                "path": [
                    {"prefix": "April"}
                ],
                "days_since_create": [
                    {"numeric": [ ">", 10 ]}
                ]
            },
            "action": "EXPIRE"
        },
        {
            "definition": {
                "path": [
                    {"wildcard": "Program/*.ts"}
                ],
                "days_since_create": [
                    {"numeric": [ ">", 5 ]}
                ]
            },
            "action": "EXPIRE"
        }
    ]
}
```
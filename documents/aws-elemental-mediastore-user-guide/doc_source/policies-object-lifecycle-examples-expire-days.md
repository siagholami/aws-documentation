# Example object lifecycle policy: Expire within days<a name="policies-object-lifecycle-examples-expire-days"></a>

The following policy specifies that MediaStore deletes objects that match all of the following criteria:
+ The object is stored in the `Program` folder
+ The object has a file extension of `ts`
+ The object has been in the container for more than 5 days

```
{
    "rules": [
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
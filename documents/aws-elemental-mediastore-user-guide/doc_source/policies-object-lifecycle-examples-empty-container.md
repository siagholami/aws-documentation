# Example object lifecycle policy: Empty container<a name="policies-object-lifecycle-examples-empty-container"></a>

The following object lifecycle policy specifies that MediaStore deletes all objects in the container, including folders and subfolders, 1 day after they are added to the container\. If the container holds any objects before this policy is applied, MediaStore deletes the objects 1 day after the policy becomes effective\. It takes up to 20 minutes for the service to apply the new policy to the container\.

```
{
    "rules": [
        {
            "definition": {
                "path": [
                    {"wildcard": "*"}
                ],
                "days_since_create": [
                    {"numeric": [ ">=", 1 ]}
                ]
            },
            "action": "EXPIRE"
        }
    ]
}
```
# Components of an object lifecycle policy<a name="policies-object-lifecycle-components"></a>

Object lifecycle policies govern how long objects remain in an AWS Elemental MediaStore container\. Each object lifecycle policy consists of one or more rules, which dictate the lifespan of objects\. A rule can apply to one folder, multiple folders, or the entire container\. 

You can attach one object lifecycle policy to a container, and each object lifecycle policy can contain up to 10 rules\. You can't assign an object lifecycle policy to an individual object\. 

## Rules in an object lifecycle policy<a name="policies-object-lifecycle-components-rules"></a>

You can create three types of rules:
+ [Transient data](#policies-object-lifecycle-components-rules-seconds)
+ [Delete object](#policies-object-lifecycle-components-rules-days)
+ [Lifecycle transition](#policies-object-lifecycle-components-rules-lifecycle-transition)

### Transient data<a name="policies-object-lifecycle-components-rules-seconds"></a>

A transient data rule sets objects to expire within seconds\. This type of rule applies only to objects that are added to the container after the policy becomes effective\. It takes up to 20 minutes for MediaStore to apply the new policy to the container\.

An example of a rule for transient data looks like this:

```
        {
            "definition": {
                "path": [ {"wildcard": "Football/index*.m3u8"} ],
                "seconds_since_create": [
                    {"numeric": [">", 120]}
                ]
            },
            "action": "EXPIRE"
        },
```

Transient data rules have three parts:
+ `path`: Always set to `wildcard`\. You use this part to define which objects you want to delete\. You can use one or more wildcards, represented by an asterisk \(\*\)\. Each wildcard represents any combination of zero or more characters\. For example, `"path": [ {"wildcard": "Football/index*.m3u8"} ],` applies to all files in the `Football` folder that match the pattern of `index*.m3u8` \(such as index\.m3u8, index1\.m3us8, and index123456\.m3u8\)\. You can include up to 10 paths in a single rule\.
+ `seconds_since_create`: Always set to `numeric`\. You can specify a value from 1\-300 seconds\. You can also set the operator to greater than \(>\) or greater than or equal to \(>=\)\.
+ `action`: Always set to `EXPIRE`\.

For transient data rules \(objects expire within seconds\), there is no lag between the expiration of an object and the deletion of the object\.

**Note**  
Objects that are subject to a transient data rule are not included in a `list-items` response\.

### Delete object<a name="policies-object-lifecycle-components-rules-days"></a>

A delete object rule sets objects to expire within days\. This type of rule applies to all objects in the container, even if they were added to the container before the policy was created\. It takes up to 20 minutes for MediaStore to apply the new policy, but it can take up to 24 hours for the objects to clear from the container\.

An example of two rules for deleting objects looks like this:

```
        {
            "definition": {
                "path": [ { "prefix": "FolderName/" }  ],
                "days_since_create": [
                    {"numeric": [">" , 5]}
                ]
            },
            "action": "EXPIRE"
        },
        {
            "definition": {
                "path": [ { "wildcard": "Football/*.ts" }  ],
                "days_since_create": [
                    {"numeric": [">" , 5]}
                ]
            },
            "action": "EXPIRE"
        }
```

Delete object rules have three parts:
+ `path`: Set to either `prefix` or `wildcard`\. You can't mix `prefix` and `wildcard` in the same rule\. If you want to use both, you must create one rule for `prefix` and a separate rule for `wildcard`, as shown in the example above\. 
  + `prefix` \- You set the path to `prefix` if you want to delete all objects within a particular folder\. If the parameter is empty \(`"path": [ { "prefix": "" } ],`\), the target is all objects that are stored anywhere within the current container\. You can include up to 10 `prefix` paths in a single rule\.
  + `wildcard` \- You set the path to `wildcard` if you want to delete specific objects based on file name and/or file type\. You can use one or more wildcards, represented by an asterisk \(\*\)\. Each wildcard represents any combination of zero or more characters\. For example, `"path": [ {"wildcard": "Football/*.ts"} ],` applies to all files in the `Football` folder that match the pattern of `*.ts` \(such as filename\.ts, filename1\.ts, and filename123456\.ts\)\. You can include up to 10 `wildcard` paths in a single rule\. 
+ `days_since_create`: Always set to `numeric`\. You can specify a value from 1\-36,500 days\. You can also set the operator to greater than \(>\) or greater than or equal to \(>=\)\. 
+ `action`: Always set to `EXPIRE`\.

For delete object rules \(objects expire within days\), there might be a slight lag between the expiration of an object and the deletion of the object\. However, changes in billing happen as soon as the object expires\. For example, if a lifecycle rule specifies 10 `days_since_create`, the account isn't billed for the object after the object is 10 days old, even if the object isn't deleted yet\.

### Lifecycle transition<a name="policies-object-lifecycle-components-rules-lifecycle-transition"></a>

A lifecycle transition rule sets objects to be moved to the infrequent access \(IA\) storage class after they reach a certain age, measured in days\. Objects that are stored in the IA storage class have different rates for storage and retrieval than objects that are stored in the standard storage class\. For more information, see [MediaStore Pricing](https://aws.amazon.com/mediastore/pricing/)\.

Once an object has moved to the IA storage class, you can't move it back to the standard storage class\.

The lifecycle transition rule applies to all objects in the container, even if they were added to the container before the policy was created\. It takes up to 20 minutes for MediaStore to apply the new policy, but it can take up to 24 hours for the objects to clear from the container\.

An example of a lifecycle transition rule looks like this:

```
        {
            "definition": {
                "path": [ 
                    {"prefix": "AwardsShow/"}
                ],
                "days_since_create": [
                    {"numeric": [">=" , 30]}
                ]
            },
            "action": "ARCHIVE"
        }
```

Lifecycle transition rules have three parts:
+ `path`: Set to either `prefix` or `wildcard`\. You can't mix `prefix` and `wildcard` in the same rule\. If you want to use both, you must create one rule for `prefix` and a separate rule for `wildcard`\. 
  + `prefix` \- You set the path to `prefix` if you want to transition all objects within a particular folder to the IA storage class\. If the parameter is empty \(`"path": [ { "prefix": "" } ],`\), the target is all objects that are saved anywhere within the current container\. You can include up to 10 `prefix` paths in a single rule\.
  + `wildcard` \- You set the path to `wildcard` if you want to transition specific objects to the IA storage class based on file name and/or file type\. You can use one or more wildcards, represented by an asterisk \(\*\)\. Each wildcard represents any combination of zero or more characters\. For example, `"path": [ {"wildcard": "Football/*.ts"} ],` applies to all files in the `Football` folder that match the pattern of `*.ts` \(such as filename\.ts, filename1\.ts, and filename123456\.ts\)\. You can include up to 10 `wildcard` paths in a single rule\. 
+ `days_since_create`: Always set to `"numeric": [">=" , 30]`\. 
+ `action`: Always set to `ARCHIVE`\.

## Example<a name="policies-object-lifecycle-components-example"></a>

Suppose that a container named `LiveEvents` has four subfolders: `Football`, `Baseball`, `Basketball`, and `AwardsShow`\. The object lifecycle policy assigned to the `LiveEvents` folder might look like this:

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
                    {"numeric": [">" , 28]}
                ]
            },
            "action": "EXPIRE"
        },
        {
            "definition": {
                "path": [ { "prefix": "AwardsShow/" }  ],
                "days_since_create": [
                    {"numeric": [">=" , 15]}
                ]
            },
            "action": "EXPIRE"
        },
        {
            "definition": {
                "path": [ { "prefix": "" }  ],
                "days_since_create": [
                    {"numeric": [">" , 40]}
                ]
            },
            "action": "EXPIRE"
        },
        {
            "definition": {
                "path": [ { "wildcard": "Football/*.ts" }  ],
                "days_since_create": [
                    {"numeric": [">" , 20]}
                ]
            },
            "action": "EXPIRE"
        },
        {
            "definition": {
                "path": [ 
                    {"wildcard": "Football/index*.m3u8"}
                ],
                "seconds_since_create": [
                    {"numeric": [">" , 15]}
                ]
            },
            "action": "EXPIRE"
        },
        {
                "definition": {
                    "path": [
                        {"prefix": "Program/"}
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

The preceding policy specifies the following:
+ The first rule instructs AWS Elemental MediaStore to delete objects that are stored in the `LiveEvents/Football` folder and the `LiveEvents/Baseball` folder after they are older than 28 days\.
+ The second rule instructs the service to delete objects that are stored in the `LiveEvents/AwardsShow` folder when they are 15 days old or older\.
+ The third rule instructs the service to delete objects that are stored anywhere in the `LiveEvents` container after they are older than 40 days\. This rule applies to objects stored directly in the `LiveEvents` container, as well as objects stored in any of the container's four subfolders\.
+ The fourth rule instructs the service to delete objects in the `Football` folder that match the pattern `*.ts` after they are older than 20 days\. 
+ The fifth rule instructs the service to delete objects in the `Football` folder that match the pattern `index*.m3u8` after they are older than 15 seconds\. MediaStore deletes these files 16 seconds after they are placed in the container\.
+ The sixth rule instructs the service to move objects in the `Program` folder to the IA storage class after they are 30 days old\.

For more examples of object lifecycle policies, see [Example object lifecycle policies](policies-object-lifecycle-examples.md)\.
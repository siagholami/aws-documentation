# Required Attributes<a name="cd-required-fields"></a>

The following examples show the required fields for classification and detection in a manifest file\.

## Required Fields for Classification<a name="cd-required-fields-classification"></a>

```
 {
    "source-ref": "S3 bucket location", # Required
    "sport":0, # Required
    "sport-metadata": { # Required
        "class-name": "football", # Required
        "confidence": 0.8, # Required
        "type":"groundtruth/image-classification", # Required
        "job-name": "identify-sport", # Not required
        "human-annotated": "yes", # Required
        "creation-date": "2018-10-18T22:18:13.527256" # Required
    }
}
```

## Required Fields for Object Detection<a name="cd-required-fields-detection"></a>

```
{
    "source-ref": "S3 bucket location", # Required
    "bounding-box": { # Required
        "image_size": [ # Required
            {
                "width": 500, # Required
                "height": 400, # Required
                "depth":3 # Required
            }
        ],
        "annotations": [ # Required
            {
                "class_id": 0, # Required
                "left": 111, # Required
                "top": 134, # Required
                "width": 61, # Required
                "height": 128 # Required
            },
            {
                "class_id": 5, # Required
                "left": 161, # Required
                "top": 250, # Required
                "width": 30, # Required
                "height": 30 # Required
            },
            {
                "class_id": 5, # Required
                "left": 20, # Required
                "top": 20, # Required
                "width": 30, # Required
                "height": 30 # Required
            }
        ]
    },
    "bounding-box-metadata": { # Required
        "objects": [ # Required
            {"confidence": 0.8}, # Required
            {"confidence": 0.9}, # Required
            {"confidence": 0.9} # Required
        ],
        "class-map": { # Required
            "0": "dog", # Required
            "5": "bone" # Required
        }, 
        "type": "groundtruth/object-detection", # Required
        "human-annotated": "yes", # Required
        "creation-date": "2018-10-18T22:18:13.527256", # Required
        "job-name": "identify-dogs-and-toys" # Not Required
    }
 }
```
# Viewing an object lifecycle policy<a name="policies-object-lifecycle-view"></a>

An object lifecycle policy specifies how long objects should be kept in a container\. 

**To view an object lifecycle policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container that you want to view the object lifecycle policy for\.

   The container details page appears, with the object lifecycle policy in the **Object lifecycle policy** section\.

**To view an object lifecycle policy \(AWS CLI\)**
+ In the AWS CLI, use the `get-lifecycle-policy` command:

  ```
  aws mediastore get-lifecycle-policy --container-name LiveEvents
  ```

  The following example shows the return value:

  ```
  {
      "LifecyclePolicy": "{
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
              }
          ]
      }"
  }
  ```
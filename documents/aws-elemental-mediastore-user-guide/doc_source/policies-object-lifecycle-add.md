# Adding an object lifecycle policy to a container<a name="policies-object-lifecycle-add"></a>

An object lifecycle policy lets you specify how long to store your objects in a container\. You set an expiration date, and after the expiration date AWS Elemental MediaStore deletes the objects\. It takes up to 20 minutes for the service to apply the new policy to the container\.

For information about how to construct a lifecycle policy, see [Components of an object lifecycle policy](policies-object-lifecycle-components.md)\.

**Note**  
For delete object rules \(objects expire within days\), there might be a slight lag between the expiration of an object and the deletion of the object\. However, changes in billing happen as soon as the object expires\. For example, if a lifecycle rule specifies 10 `days_since_create`, the account isn't billed for the object after the object is 10 days old, even if the object isn't deleted yet\.

**To add an object lifecycle policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container that you want to create an object lifecycle policy for\.

   The container details page appears\. 

1. In the **Object lifecycle policy** section, choose **Create object lifecycle policy**\.

1. Insert the policy in JSON format, and then choose **Save**\.

**To add an object lifecycle policy \(AWS CLI\)**

1. Create a file that defines the object lifecycle policy:

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
                   "path": [ 
                       {"wildcard": "AwardsShow/index*.m3u8"}
                   ],
                   "seconds_since_create": [
                       {"numeric": [">" , 8]}
                   ]
               },
               "action": "EXPIRE"
           }
       ]
   }
   ```

1. In the AWS CLI, use the `put-lifecycle-policy` command:

   ```
   aws mediastore put-lifecycle-policy --container-name LiveEvents --lifecycle-policy file://LiveEventsLifecyclePolicy.json
   ```

   This command has no return value\. The service attaches the specified policy to the container\. 
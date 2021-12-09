# Editing a CORS policy<a name="cors-policy-editing"></a>

Cross\-origin resource sharing \(CORS\) defines a way for client web applications that are loaded in one domain to interact with resources in a different domain\.

**To edit a CORS policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container that you want to edit the CORS policy for\.

   The container details page appears\. 

1. In the **Container CORS policy** section, choose **Edit CORS policy**\.

1. Make your changes to the policy, and then choose **Save**\.

**To edit a CORS policy \(AWS CLI\)**

1. Create a file that defines the updated CORS policy:

   ```
   [
     {
       "AllowedHeaders": [
         "*"
       ],
       "AllowedMethods": [
         "GET",
         "HEAD"
       ],
       "AllowedOrigins": [
         "https://www.example.com"
       ],
       "MaxAgeSeconds": 3000
     }
   ]
   ```

1. In the AWS CLI, use the `put-cors-policy` command\.

   ```
   aws mediastore put-cors-policy --container-name ExampleContainer --cors-policy file://corsPolicy2.json
   ```

   This command has no return value\.
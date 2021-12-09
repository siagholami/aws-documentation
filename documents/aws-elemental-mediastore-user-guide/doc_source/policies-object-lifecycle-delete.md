# Deleting an object lifecycle policy<a name="policies-object-lifecycle-delete"></a>

When you delete an object lifecycle policy, it takes up to 20 minutes for the service to apply the change to the container\. 

**To delete an object lifecycle policy \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container that you want to delete the object lifecycle policy for\.

   The container details page appears\. 

1. In the **Object lifecycle policy** section, choose **Delete lifecycle policy**\.

1. Choose **Continue** to confirm, and then choose **Save**\.

**To delete an object lifecycle policy \(AWS CLI\)**
+ In the AWS CLI, use the `delete-lifecycle-policy` command:

  ```
  aws mediastore delete-lifecycle-policy --container-name LiveEvents
  ```

  This command has no return value\. 
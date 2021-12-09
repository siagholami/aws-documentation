# Deleting a container<a name="containers-delete"></a>

You can delete a container only if it has no objects\. 

**To delete a container \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the option to the left of the container name\.

1. Choose **Delete**\.

**To delete a container \(AWS CLI\)**
+ In the AWS CLI, use the `delete-container` command:

  ```
  aws mediastore delete-container --container-name=ExampleLiveDemo --region us-west-2
  ```

  This command has no return value\.
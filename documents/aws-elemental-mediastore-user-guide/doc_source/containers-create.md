# Creating a container<a name="containers-create"></a>

You can create up to 100 containers for each AWS account\. You can create as many folders as you want, as long as they are not nested more than 10 levels within a container\. In addition, you can upload as many objects as you want to each container\.

**Tip**  
You can also create a container automatically by using an AWS CloudFormation template\. The AWS CloudFormation template manages data for five API actions: creating a container, setting access logging, updating the default container policy, adding a cross\-origin resource sharing \(CORS\) policy, and adding an object lifecycle policy\. For more information, see the [AWS CloudFormation User Guide](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-mediastore-container.html)\.

**To create a container \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose **Create container**\.

1. For **Container** name, enter a name for the container\. For more information, see [Rules for container names](containers-rules-for-names.md)\.

1. Choose **Create container**\. AWS Elemental MediaStore adds the new container to a list of containers\. Initially, the status of the container is **Creating**, and then it changes to **Active**\.

**To create a container \(AWS CLI\)**
+ In the AWS CLI, use the `create-container` command:

  ```
  aws mediastore create-container --container-name ExampleContainer --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "Container": {
          "AccessLoggingEnabled": false,
          "CreationTime": 1563557265.0,
          "Name": "ExampleContainer",
          "Status": "CREATING",
          "ARN": "arn:aws:mediastore:us-west-2:111122223333:container/ExampleContainer"
      }
  }
  ```
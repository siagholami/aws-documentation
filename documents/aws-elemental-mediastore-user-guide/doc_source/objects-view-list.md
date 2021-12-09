# Viewing a list of objects<a name="objects-view-list"></a>

You can use the AWS Elemental MediaStore console to view items \(objects and folders\) stored in the top\-most level of a container or in a folder\. Items stored in a subfolder of the current container or folder will not be displayed\. You can use the AWS CLI to view a list of objects and folders within a container, regardless of how many folders or subfolders are within the container\.

**To view a list of objects in a specific container \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container that has the folder that you want to view\. 

1. Choose the name of the folder from the list\.

   A details page appears, showing all folders and objects that are stored in the folder\.

**To view a list of objects in a specific folder \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container that has the folder that you want to view\. 

   A details page appears, showing all folders and objects that are stored in the container\.

**To view a list of objects and folders in a specific container \(AWS CLI\)**
+ In the AWS CLI, use the `list-items` command:

  ```
  aws mediastore-data list-items --endpoint https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "Items": [
          {
              "ContentType": "image/jpeg",
              "LastModified": 1563571859.379,
              "Name": "filename.jpg",
              "Type": "OBJECT",
              "ETag": "543ab21abcd1a234ab123456a1a2b12345ab12abc12a1234abc1a2bc12345a12",
              "ContentLength": 3784
          },
          {
              "Type": "FOLDER",
              "Name": "ExampleLiveDemo"
          }
      ]
  }
  ```
**Note**  
Objects that are subject to a `seconds_since_create` rule are not included in a `list-items` response\.

**To view a list of objects and folders in a specific folder \(AWS CLI\)**
+ In the AWS CLI, use the `list-items` command, with the specified folder name at the end of the request:

  ```
  aws mediastore-data list-items --endpoint https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com --path /folder_name --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "Items": [
          {
              "Type": "FOLDER",
              "Name": "folder_1"
          },
          {
              "LastModified": 1563571940.861,
              "ContentLength": 2307346,
              "Name": "file1234.jpg",
              "ETag": "111a1a22222a1a1a222abc333a444444b55ab1111ab2222222222ab333333a2b",
              "ContentType": "image/jpeg",
              "Type": "OBJECT"
          }
      ]
  }
  ```
**Note**  
Objects that are subject to a `seconds_since_create` rule are not included in a `list-items` response\.
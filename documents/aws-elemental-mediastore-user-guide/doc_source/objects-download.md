# Downloading an object<a name="objects-download"></a>

You can use the console to download an object\. You can use the AWS CLI to download an object or only part of an object\.

**To download an object \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of container that has the object that you want to download\.

1. If the object that you want to download is in a folder, continue choosing the folder names until you see the object\.

1. Choose the name of the object\.

1. On the **Object** details page, choose **Download**\.

**To download an object \(AWS CLI\)**
+ In the AWS CLI, use the `get-object` command:

  ```
  aws mediastore-data get-object --endpoint https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com --path=/folder_name/README.md README.md --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "ContentLength": "2307346",
      "ContentType": "image/jpeg",
      "LastModified": "Fri, 19 Jul 2019 21:32:20 GMT",
      "ETag": "2aa333bbcc8d8d22d777e999c88d4aa9eeeeee4dd89ff7f555555555555da6d3",
      "StatusCode": 200
  }
  ```

**To download part of an object \(AWS CLI\)**
+ In the AWS CLI, use the `get-object` command, and specify a range\.

  ```
  aws mediastore-data get-object --endpoint https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com --path /folder_name/README.md --range="bytes=0-100" README2.md --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "StatusCode": 206,
      "ContentRange": "bytes 0-100/2307346",
      "ContentLength": "101",
      "LastModified": "Fri, 19 Jul 2019 21:32:20 GMT",
      "ContentType": "image/jpeg",
      "ETag": "2aa333bbcc8d8d22d777e999c88d4aa9eeeeee4dd89ff7f555555555555da6d3"
  }
  ```
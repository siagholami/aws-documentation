# Viewing the details of an object<a name="objects-view-details"></a>

After you upload an object, AWS Elemental MediaStore stores details such as the modification date, content length, ETag \(entity tag\), and content type\. To learn how an object's metadata is used, see [MediaStore's interaction with HTTP caches](cdn-mediastore-interaction-with-http-caches.md)\.

**To view the details of an object \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of container that has the object that you want to view\.

1. If the object that you want to view is in a folder, continue choosing the folder names until you see the object\.

1. Choose the name of the object\.

   A details page appears, showing information about the object\.

**To view the details of an object \(AWS CLI\)**
+ In the AWS CLI, use the `describe-object` command:

  ```
  aws mediastore-data describe-object --endpoint https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com --path /folder_name/file1234.jpg --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "ContentType": "image/jpeg",
      "LastModified": "Fri, 19 Jul 2019 21:32:20 GMT",
      "ContentLength": "2307346",
      "ETag": "2aa333bbcc8d8d22d777e999c88d4aa9eeeeee4dd89ff7f555555555555da6d3"
  }
  ```
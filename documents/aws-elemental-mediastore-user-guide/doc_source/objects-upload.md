# Uploading an object<a name="objects-upload"></a>

You can upload objects to a container or to a folder within a container\. To upload an object to a folder, you specify the path to the folder\. If the folder already exists, AWS Elemental MediaStore stores the object in the folder\. If the folder doesn’t exist, the service creates it, and then stores the object in the folder\. For more information about folders, see [Folders in AWS Elemental MediaStore](folders.md)\.

You can use the MediaStore console or the AWS CLI to upload objects\. 

MediaStore supports chunked transfer of objects, which reduces latency by making an object available for downloading while it is still being uploaded\. To use this capability, set the object's upload availability to `streaming`\. You can set the value of this header when you [upload the object using the API](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_PutObject.html)\. If you don't specify this header in your request, MediaStore assigns the default value of `standard` for the object’s upload availability\. 

Object sizes can't exceed 25 MB for standard upload availability and 10 MB for streaming upload availability\.

**Note**  
Object file names can contain only letters, numbers, periods \(\.\), underscores \(\_\), tildes \(\~\), and hyphens \(\-\)\. 

**To upload an object \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the name of the container\. The details panel for the container appears\.

1. Choose **Upload object**\.

1. For **Target path**, type a path for the folders\. For example, `premium/canada`\. If any of the folders in the path that you specify don’t exist yet, the service creates them automatically\.

1. In the **Object** section, choose **Browse**\.

1. Navigate to the appropriate folder, and choose one object to upload\.

1. Choose **Open**, and then choose **Upload**\.
**Note**  
If a file with the same name already exists in the selected folder, the service replaces the original file with the uploaded file\.

**To upload an object \(AWS CLI\)**
+ In the AWS CLI, use the `put-object` command\. You can also include any of the following parameters: `content-type`, `cache-control` \(to allow the caller to control the object's cache behavior\), and `path` \(to put the object in a folder within the container\)\.
**Note**  
After you upload the object, you can’t edit the `content-type`, `cache-control`, or `path`\.

  ```
  aws mediastore-data put-object --endpoint https://aaabbbcccdddee.data.mediastore.us-west-2.amazonaws.com --body README.md --path /folder_name/README.md --cache-control "max-age=6, public" --content-type binary/octet-stream --region us-west-2
  ```

  The following example shows the return value:

  ```
  {
      "ContentSHA256": "74b5fdb517f423ed750ef214c44adfe2be36e37d861eafe9c842cbe1bf387a9d",
      "StorageClass": "TEMPORAL",
      "ETag": "af3e4731af032167a106015d1f2fe934e68b32ed1aa297a9e325f5c64979277b"
  }
  ```
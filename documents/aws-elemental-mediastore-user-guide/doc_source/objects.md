# Objects in AWS Elemental MediaStore<a name="objects"></a>

AWS Elemental MediaStore assets are called *objects*\. You can upload an object to a container or to a folder within the container\.

In MediaStore, you can upload, download, and delete objects: 
+ **Upload** – Add an object to a container or folder\. This is not the same as creating an object\. You must create your objects locally before you can upload them to MediaStore\.
+ **Download** – Copy an object from MediaStore to another location\. This does not remove the object from MediaStore\.
+ **Delete** – Remove an object from MediaStore completely\. You can delete objects individually, or you can [add an object lifecycle policy](policies-object-lifecycle-add.md) to automatically delete objects within a container after a specified duration\.

MediaStore accepts all file types\. 

**Topics**
+ [Uploading an object](objects-upload.md)
+ [Viewing a list of objects](objects-view-list.md)
+ [Viewing the details of an object](objects-view-details.md)
+ [Downloading an object](objects-download.md)
+ [Deleting objects](objects-delete-main.md)
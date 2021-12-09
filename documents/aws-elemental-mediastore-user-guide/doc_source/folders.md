# Folders in AWS Elemental MediaStore<a name="folders"></a>

Folders are divisions within a container\. You use folders to subdivide your container in the same way that you create subfolders to divide a folder in a file system\. You can create up to 10 levels of folders \(not including the container itself\)\. 

Folders are optional; you can choose to upload your objects directly to a container instead of a folder\. However, folders are an easy way to organize your objects\. 

To upload an object to a folder, you specify the path to the folder\. If the folder already exists, AWS Elemental MediaStore stores the object in the folder\. If the folder doesn’t exist, the service creates it, and then stores the object in the folder\.

For example, suppose you have a container named `movies`, and you upload a file named `mlaw.ts` with the path `premium/canada`\. AWS Elemental MediaStore stores the object in the subfolder canada under the folder premium\. If neither folder exists, the service creates both the `premium` folder and the `canada` subfolder, and then stores your object in the `canada` subfolder\. If you specify only the container `movies` \(with no path\), the service stores the object directly in the container\.

AWS Elemental MediaStore automatically deletes a folder when you delete the last object in that folder\. The service also deletes any empty folders above that folder\. For example, suppose that you have a folder named premium that doesn’t contain any files but does contain one subfolder named `canada`\. The `canada` subfolder contains one file named `mlaw.ts`\. If you delete the file `mlaw.ts`, the service deletes both the `premium` and `canada` folders\. This automatic deletion applies only to folders\. The service does not delete empty containers\.

**Topics**
+ [Rules for folder names](folders-rules-for-names.md)
+ [Creating a folder](folders-create.md)
+ [Deleting a folder](folders-delete.md)
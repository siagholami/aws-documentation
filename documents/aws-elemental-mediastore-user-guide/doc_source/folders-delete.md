# Deleting a folder<a name="folders-delete"></a>

You can delete folders only if the folder is empty; you can’t delete folders that contain objects\. 

AWS Elemental MediaStore automatically deletes a folder when you delete the last object in that folder\. The service also deletes any empty folders above that folder\. For example, suppose that you have a folder named `premium` that doesn’t contain any files but does contain one subfolder named `canada`\. The `canada` subfolder contains one file named `mlaw.ts`\. If you delete the file `mlaw.ts`, the service deletes both the `premium` and `canada` folders\. This automatic deletion applies only to folders\. The service does not delete empty containers\.

For more information, see [Deleting an object](objects-delete.md)\.
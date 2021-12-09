--------

--------

# Using a Microsoft OneDrive data source<a name="data-source-onedrive"></a>

Amazon Kendra can use a data source to connect to Microsoft OneDrive sites to index the documents that your users create\. When you use a OneDrive data source to connect Amazon Kendra to your OneDrive site, you choose the users whose documents are indexed\. You can optionally provide inclusion and exclusion patterns to specify the documents to index\.

To create a OneDrive data source, you must first create an Azure Active Directory \(AD\) application that Amazon Kendra connects to\. You must grant the application the following permissions on the Microsoft Graph option:
+ Read files in all site collections \(File\.Read\.All\)
+ Read all users' full profile \(User\.Read\.All\)
+ Read directory data \(Directory\.Read\.All\)
+ Read all groups \(Group\.Read\.All\)
+ Read items in all site collections \(Site\.Read\.All\)

When you create the active directory application, it is assigned an application ID\. You must use the active directory site to register a secret key for the application\. Amazon Kendra uses the ID and key as credentials to authenticate when it connects to the OneDrive site\. You store the ID and key in an AWS Secrets Manager secret\. If you are using the console to create your OneDrive data source, you can enter the credentials there to create a Secrets Manager secret\. Or you can choose an existing Secrets Manager secret\. If you are using the API, you must provide the Amazon Resource Name \(ARN\) of an existing secret\.

The secret must contain the application ID and secret key that Amazon Kendra uses to access the site in a JSON structure\. The following is the minimum JSON structure that must be stored in the secret:

```
{
    "username": "application ID",
    "password": "secret key"
}
```

The data source AWS Identity and Access Management \(IAM\) role must have permission to access the secret\. For more information, see [IAM roles for Microsoft OneDrive data sources](iam-roles.md#iam-roles-ds-on)\.

The secret can contain more information, but Amazon Kendra ignores it\. For more information, see [ What is AWS Secrets Manager ](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html) in the *AWS Secrets Manager User Guide*\.

You must create an index before you create the OneDrive data source\. For information, see [Creating an index](create-index.md)\. You provide the ID of the index when you create the data source\.

You specify connection and other information in the console or using an instance of the [OneDriveConfiguration](API_OneDriveConfiguration.md) data type\. You must provide the following information: 
+ The credentials required to log in to the OneDrive site\.
+ The tenant domain that contains the OneDrive site\.
+ A list of users whose documents should be indexed\. You can provide a list of user names, or you can provide the user names in a file stored in an Amazon Simple Storage Service \(Amazon S3\) bucket\. If you store the list of user names in an S3 bucket, the IAM policy for the data source must provide access to the bucket and access to the key that the bucket was encrypted with, if any\.

After you create a data source, you can:
+ Modify the list of users\.
+ Change from a list of users to a list stored in an S3 bucket\.
+ Change the S3 bucket location of a list of users\. If you change the bucket location, you must also update the IAM role for the data source so that it has access to the bucket\.
+ Change the content of a user list stored in an S3 bucket\.

You can optionally provide the following information:
+ A list of inclusion and exclusion regular expressions that filter the documents that are included in the index\. The regular expressions are applied to the file name of the document\.
+ Field mappings that map fields from your OneDrive site to Amazon Kendra index fields\. For information, see [Mapping data source fields](field-mapping.md)\.

After you sync the data source, you can't change the inclusion and exclusion patterns or the remove field mapping\. You can map additional fields\.

You can map OneDrive properties to Amazon Kendra index fields\. The following table shows the OneDrive properties that can be mapped and a suggested Amazon Kendra index field\.


| OneDrive field name | Suggested Amazon Kendra field name | 
| --- | --- | 
| body | \_document\_body | 
| createdDateTime | \_created\_at | 
| name | \_document\_title | 
| webUrl | \_document\_id | 
| createdBy\.displayName | od\_createdBy\_displayName | 
| createdBy\.id | od\_createdBy\_id | 
| createdBy\.email | oc\_createdBy\_email | 
| cTag | od\_ctag | 
| eTag | od\_etag | 
| fileSystemInfo\.createdDateTime | od\_fileSystemInfo\_createdDateTime | 
| fileSystemInfo\.lastAccessedDateTime | od\_fileSystemInfo\_lastAccessedDateTime | 
| fileSystemInfo\.lastModifiedDateTime | od\_fileSystemInfo\_lastModifiedDateTime | 
| file\.mimeType | od\_file\_mimeType | 
| lastModifiedDateTime | \_last\_updated\_at | 
| lastModifiedBy\.displayName | od\_lastModififiedBy\_displayName | 
| lastModifiedBy\.id | od\_lastModifiedBy\.id | 
| lastModifiedBy\.email | od\_lastModifiedBy\.email | 
| size | od\_size | 
| webDavUrl | oe\_webDavUrl | 
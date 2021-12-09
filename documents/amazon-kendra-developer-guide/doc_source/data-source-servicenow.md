--------

--------

# Using a ServiceNow data source<a name="data-source-servicenow"></a>

Amazon Kendra can connect to your ServiceNow instance that contains a public knowledge base and service catalog to provide an index of its contents\. For a walkthrough of creating a ServiceNow data source, see [Getting started with a ServiceNow data source \(Console\)](getting-started-servicenow.md)\.

When you use Amazon Kendra to index a ServiceNow instance, you choose the instance to index and whether to index a public knowledge base, a public service catalog, or both\. You can optionally provide inclusion and exclusion patterns for document attachments stored in the knowledge base or service catalog\. 

For public knowledge bases in your ServiceNow instance, Amazon Kendra indexes only public articles\. A knowledge base must have the public role under **Can Read**, and **Cannot Read** must be null or not set

You also must provide Amazon Kendra with the credentials for an administrative user for your ServiceNow instance\.

The user name and password for the ServiceNow instance must be stored in an AWS Secrets Manager secret\. If you are using the Amazon Kendra console, you can enter the ServiceNow credentials there to create a new secret, or you can choose an existing secret\. If you are using the Amazon Kendra API, you must provide the Amazon Resource Name \(ARN\) of an existing secret that contains your ServiceNow user name and password\.

The secret must contain the username and password of the ServiceNow account that you want Amazon Kendra to use to access ServiceNow\. The following is the minimum JSON structure that must be stored in the secret\.

```
{
    "username": "user-name",
    "password": "password"
}
```

The secret can contain other information;but Amazon Kendra ignores it\. For more information, see [What is Secrets Manager](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html) in the *AWS Secrets Manager User Guide*\.

When you create the ServiceNow data source, you specify an IAM role that grants Amazon Kendra permission to access resources required to index your ServiceNow instance\. The data source IAM role must have permission to access the secret and to use the AWS Key Management Service \(AWS KMS\) key that was used to decrypt it\. For more information, see [IAM role for ServiceNow data sources](iam-roles.md#iam-roles-ds-sn)\.

You provide ServiceNow connection information in the Amazon Kendra console or by using an instance of the [ServiceNowConfiguration](API_ServiceNowConfiguration.md) data type\. You must provide the following information:
+ The ARN of the Secrets Manager secret that contains the credentials required to access the ServiceNow instance\.
+ The version of the ServiceNow instance\. For Amazon Kendra, this is `LONDON` for the London version and `OTHERS` for all other ServiceNow versions\.
+ The ServiceNow instance host\. For example, if the URL of the instance is `https://your-domain.service-now.com`, the host is `your-domain.service-now.com`\.
+ Whether to index knowledge articles, service catalogs, or both\. You must also provide the name of the ServiceNow field that contains the document body\.

You can optionally provide the following information:
+ The name of the ServiceNow field that contains document titles\. This is typically the ServiceNow `title` field\. If you don't specify a document title field, Amazon Kendra uses the document ID as the title\.
+ Whether Amazon Kendra should index attachments to knowledge base or catalog items\. If you choose to index attachments, you can specify the file type of attachments to exclude from the index\.
+ Field mappings that map fields in your ServiceNow instance to fields in your Amazon Kendra index\. For more information, see [Mapping data source fields](field-mapping.md)\.
+ An inclusion pattern to specify the file type of document attachments to include in the index\. If you specify an inclusion pattern, any attachment that doesn't match the pattern isn't indexed\. If the pattern includes file types that Amazon Kendra does not support, those files won't be included\. For a list of supported file types, see [Types of documents](index-document-types.md)\.
+ An exclusion pattern to specify the file type of document attachments to exclude from the index\. If you specify an exclusion pattern, any attachment that doesn't match the pattern is indexed\. 

If you specify both an inclusion and an exclusion pattern, attachments that match the exclusion pattern won't be indexed even if they match the inclusion pattern\.

After you sync the data source for the first time, the inclusion and exclusion patterns can't be changed\.

You can map ServiceNow properties to Amazon Kendra index fields\. The following table shows the ServiceNow knowledge article properties that can be mapped and a suggested Amazon Kendra index field\. You can also create custom ServiceNow fields that you map to Amazon Kendra index fields\.


| ServiceNow field name | Suggested Amazon Kendra field name | 
| --- | --- | 
| content | \_document\_body | 
| displayUrl | sn\_display\_url | 
| first\_name | sn\_ka\_first\_name | 
| kb\_category | sn\_ka\_category | 
| kb\_catagory\_name | \_category | 
| kb\_knowledge\_base | sn\_ka\_knowledge\_base | 
| last\_name | sn\_ka\_last\_name | 
| number | sn\_kb\_number | 
| published | sn\_ka\_publish\_date | 
| repItemType | sn\_repItemType | 
| short\_description | \_document\_title | 
| sys\_created\_by | sn\_createdBy | 
| sys\_created\_on | \_created\_at | 
| sys\_id | sn\_sys\_id | 
| sys\_updated\_by | sn\_updatedBy | 
| sys\_updated\_on | \_last\_updated\_at | 
| url | sn\_url | 
| user\_name | sn\_ka\_user\_name | 
| valid\_to | sn\_ka\_valid\_to | 
| workflow\_state | sn\_ka\_workflow\_state | 

The following table shows the ServiceNow catalog properties that can be mapped and a suggested Amazon Kendra field\.


| ServiceNow field name | Suggested Amazon Kendra field name | 
| --- | --- | 
| category | sn\_sc\_category | 
| category\_full\_name | sn\_sc\_category\_full\_name | 
| category\_name | \_category | 
| description | \_document\_body | 
| displayUrl | sn\_display\_url | 
| repItemType | sn\_repItemType | 
| sc\_catalogs | sn\_sc\_catalogs | 
| sc\_catalogs\_name | sn\_sc\_catalogs\_name | 
| short\_description | \_document\_body | 
| sys\_created\_by | sn\_createdBy | 
| sys\_created\_on | \_created\_at | 
| sys\_id | sn\_sys\_id | 
| sys\_updated\_by | sn\_updatedBy | 
| sys\_updated\_on | \_last\_updated\_at | 
| title | \_document\_title | 
| url | sn\_url | 
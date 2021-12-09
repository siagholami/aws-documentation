--------

--------

# Index<a name="hiw-index"></a>

An *index* provides search results for documents and frequently asked questions \(FAQ\) that it has indexed\. The way you add documents to the index depends on the type of document and where they are stored\.
+ If your documents are in a store, such as an S3 bucket or a Microsoft SharePoint site, you use a data source \. 
+ You use the Amazon Kendra API to add documents
+ For FAQ questions and answers, which must be stored in an Amazon Simple Storage Service \(\(Amazon S3\) bucket, you upload them from the bucket\.

An index can contain documents that are indexed from a data source, documents that are added directly to the index, and FAQs\. You can create indexes with the Amazon Kendra console, the AWS CLI, or an AWS SDK\. For information about the types of documents that can be indexed, see [Types of documents](index-document-types.md)\.

For information about using a data source with an index, see [Data sources](hiw-data-source.md)\.

To add documents directly to an index, you call the [BatchPutDocument](API_BatchPutDocument.md) operation\. The documents are supplied as plain text, as a binary blob, or using a path to a document stored in an Amazon S3 bucket\. For an example, see [Adding documents from an Amazon S3 bucket](in-adding-plain-text.md)\.

## Index Fields<a name="index-fields"></a>

An index contains fields that you map to the attributes of your document\. Fields provide the schema for your index\. Amazon Kendra uses the fields to search your documents\. After you map your documents' attributes to fields, you can use the information in the field for searching, for display, and to create facets of the search result\.

Amazon Kendra has six reserved fields, which you can map to your document attributes: 
+ \_category – The category of the document\.
+ \_created\_at – The date and time that the document was created\.
+ \_file\_type – The file type of the document \(html, pdf, and so on\)\.
+ \_last\_updated\_at – The date and time that the document was last updated\.
+ \_version – The version of the document\. 
+ \_view\_count – The number of times that the document has been viewed\. 

You can also create custom fields, which you can use like the reserved fields for search and display, and to create facets\. 

There are four types of custom fields:
+ Date
+ Number
+ String
+ String list

You create a custom field using the console or by using the [UpdateIndex](API_UpdateIndex.md) operation\. After you create a custom field, you map it to a document attribute, just as you do with a reserved field\. If you added a document to the index with [BatchPutDocument](API_BatchPutDocument.md) operation, you map the attributes with the API\. For documents indexed from an Amazon S3 data source, you map the attributes using a metadata file that contains a JSON structure that describes the document attributes\. For documents indexed with a database or SharePoint Online data source, you map attributes with the console or the data source configuration\. For more information, see [Document attributes](hiw-document-attributes.md)\.

## Searching Indexes<a name="index-searching"></a>

After you create an index, you can use it for search queries\. For more information, see [Searching indexes](searching.md)\.
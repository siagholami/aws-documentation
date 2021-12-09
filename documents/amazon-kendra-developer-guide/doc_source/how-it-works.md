--------

--------

# How Amazon Kendra works<a name="how-it-works"></a>

Amazon Kendra provides an interface for indexing and searching documents\. You can use Amazon Kendra to create an updatable index of documents of a variety of types, including plain text, HTML files, Microsoft Word documents, Microsoft PowerPoint presentations, and PDF files\. It has a search API that you can use from a variety of client applications, such as websites or mobile applications\. 

 Amazon Kendra has the following components:
+ The *index*, which provides a search API for client queries\. You create the index from source documents\. 
+ A *source repository*, which contains the documents to index\.
+ A *data source* that syncs the documents in your source repositories to an Amazon Kendra index\. You can automatically synchronize a data source with an Amazon Kendra index so that new, updated, and deleted files in the source repository are updated in the index\. 
+ A *document addition API*, that adds documents  directly to the index\.

To manage indexes and data sources, you can use the Amazon Kendra console or the API\. You can create, update, and delete indexes\. Deleting an index deletes all data sources and permanently deletes all of your document information from Amazon Kendra\.

**Topics**
+ [Index](hiw-index.md)
+ [Documents](hiw-documents.md)
+ [Data sources](hiw-data-source.md)
+ [Queries](hiw-query.md)
+ [Tags](tagging.md)
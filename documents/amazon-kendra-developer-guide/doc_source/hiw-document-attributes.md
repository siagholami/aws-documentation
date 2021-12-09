--------

--------

# Document attributes<a name="hiw-document-attributes"></a>

A document has attributes associated with it\. You can also add your own custom attributes\. Custom attributes are attributes that you can specify for your own needs\. For example, if your index searches tax documents, you might specify a custom attribute for the type of tax document \(W\-2, 1099, and so on\)\.

Before you can use a document attribute in a query, it must be mapped to a database field\. For more information, see [Index Fields](hiw-index.md#index-fields)\.

You can use document attributes to filter responses and to make faceted search suggestions\. For example, you can filter a response to only return a specific version of a document, or you can filter searches to only return 1099 tax documents that match the search term\. For more information, see [Filtering queries](filtering.md)\.

You can also use document attributes to manually tune the query response\. For example, you can choose to increase the importance of the title field to increase the weight that Amazon Kendra assigns to the field when determining which documents to return in the response\. For more information, see [Manually tuning an index](manual-tuning.md)\. 

Before you can add an attribute, you must create an index field to map the attribute to\. You create index fields using the console or by using the [UpdateIndex](API_UpdateIndex.md) operation\.

If you are adding a document directly to an index, you specify the attributes in the [Document](API_Document.md) input parameter to the [BatchPutDocument](API_BatchPutDocument.md) operation\. You specify the custom attribute values in a [DocumentAttribute](API_DocumentAttribute.md) object array\. If you are using a data source, the method that you use to add the document attributes depends on the data source\. For more information, see [Creating custom document attributes](custom-attributes.md)\. 
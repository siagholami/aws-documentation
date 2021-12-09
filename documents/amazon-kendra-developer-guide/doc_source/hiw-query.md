--------

--------

# Queries<a name="hiw-query"></a>

To get answers, users query an index\. Users can use natural language in their queries\. The response contains information, such as the title, a text excerpt, and the location of documents in the index that provide the best answer\.

Amazon Kendra uses all of the information that you provide about your documents, not just the contents of the documents, to determine whether a document is relevant to the query\. For example, if your index contains information about when documents were last updated, you can tell Amazon Kendra to assign a higher relevance to documents that were updated more recently\. 

A query can also contain criteria for how to filter the response so that Amazon Kendra returns only documents that satisfy the filter criteria\. For example, if you created an index field called *department*, you can filter the response so that only documents with the department field set to *legal* are returned\. For more information, see [Filtering queries](filtering.md)\.

You can influence the results of a query by tuning the relevance of individual fields in the index\. Tuning changes the importance of a field on the results\. For example, if you raise the importance of documents with the file type *pdf*, PDF files are more likely to be included in the response\. For more information, see [Manually tuning an index](manual-tuning.md)\.

For more information about using queries, see [Searching indexes](searching.md)\.
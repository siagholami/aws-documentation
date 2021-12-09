--------

--------

# Types of documents<a name="index-document-types"></a>

An index can include both structured and unstructured text:
+ Structured text
  + Frequently asked questions and answers
+ Unstructured text
  + HTML files
  + Microsoft PowerPoint presentations
  + Microsoft Word documents
  + Plain text documents
  + PDFs

You can add documents directly to an index by calling the [BatchPutDocument](API_BatchPutDocument.md) operation\. You can also add documents from a data source\. For information about adding files to a data source, see [Adding documents from a data source](data-source.md)\. For an example that shows how to add Microsoft Word documents directly to an index from an Amazon S3 bucket, see [Adding documents from an Amazon S3 bucket](in-adding-plain-text.md)\. 

An index can contain multiple documents and multiple types of documents\.

## HTML<a name="type-html"></a>

HTML format files\. You add an HTML file to an index the same way that you add a plain text file\. 

## Plain text<a name="type-plain-text"></a>

You can add plain text files to an index using the `BatchPutDocument` operation or from a data source\. For an example of adding a plain text document directly to an index, see [Adding documents with the API](in-adding-binary-doc.md)\.

## Microsoft Word document<a name="type-word"></a>

Microsoft Word format files can be added to an index as binary data, from an Amazon S3 bucket, or from an Amazon Kendra data source\.

## Microsoft PowerPoint document<a name="type-powerpoint"></a>

Microsoft PowerPoint format files can be added to an index as binary data, from an Amazon S3 bucket, or from an Amazon Kendra data source\.

## Portable document format \(PDF\)<a name="type-pdf"></a>

PDF format files can be added to an index either as binary data, from an Amazon S3 bucket, or from an Amazon Kendra data source\. 

## Frequently asked questions and answers<a name="type-question-answer"></a>

Frequently asked question and answer format documents are used to answer questions such as *How tall is the Space Needle?* You can specify multiple questions that return the same answer\. You specify the questions and answers in a comma\-separated values \(CSV\) file stored in an Amazon S3 bucket\. 

For an example, see [Adding questions and answers](in-creating-faq.md)\.
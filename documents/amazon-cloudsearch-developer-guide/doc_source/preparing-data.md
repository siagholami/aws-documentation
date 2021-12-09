# Preparing Your Data for Amazon CloudSearch<a name="preparing-data"></a>

You need to format your data in JSON or XML before you can upload it to your search domain for indexing\. Each item that you want to be able to receive as a search result is represented as a document\. Every document has a unique document ID and one or more fields that contain the data that you want to search and return in results\. These document fields are used to populate the index fields you configure for your domain\. For more information, see [Configuring Index Fields](configuring-index-fields.md)\.

[Creating Document Batches](#creating-document-batches) describes how to format your data\. For a detailed description of the Amazon CloudSearch JSON and XML schemas, see the [Document Service API Reference](document-service-api.md)\. 

**Topics**
+ [Mapping Document Data](#mapping-document-data)
+ [Creating Document Batches](#creating-document-batches)

## Mapping Document Data to Index Fields in Amazon CloudSearch<a name="mapping-document-data"></a>

To populate the fields in your index, Amazon CloudSearch reads the data from the corresponding document fields\. Every field specified in your document data must be configured in your indexing options\. Documents can contain a subset of the fields configured for the domain—every document does not have to contain all fields\. In addition, you can populate additional fields in your index by copying the data from one field to another\. This enables you to use the same source data in different ways by configuring different options for the fields\. 

An array field such as `text-array` can contain up to 1000 values\. At search time, the document is returned as a hit if any of those values match the search query\. 

## Creating Document Batches in Amazon CloudSearch<a name="creating-document-batches"></a>

**Important**  
Before uploading data to an Amazon CloudSearch domain, follow these guidelines:  
Group documents into *batches* before you upload them\. Continuously uploading batches that consist of only one document has a huge, negative impact on the speed at which Amazon CloudSearch can process your updates\. Instead, create batches that are as close to the limit as possible and upload them less frequently\. For more information on maximum batch size and upload frequency, see [Understanding Amazon CloudSearch Limits](limits.md)\.
A domain's document and search endpoints remain the same for the life of the domain\. You should cache the endpoints rather than retrieving them before every upload or search request\. Querying the Amazon CloudSearch configuration service by calling `aws cloudsearch describe-domains` or `DescribeDomains` before every request will likely result in your requests being throttled\.

You create document batches to describe the data that you want to make searchable\. When you send document batches to a domain, the data is indexed automatically according to the domain's indexing options\. The Amazon CloudSearch console can automatically generate document batches from a variety of source documents\. 

A document batch is a collection of add and delete operations that represent the documents you want to add, update, or delete from your domain\. Batches can be described in either JSON or XML\. See [Understanding Amazon CloudSearch Limits](limits.md) for maximum batch size and document size\.

 To get the best possible upload performance, group add and delete operations in batches that are close to the maximum batch size\. Submitting a large volume of single\-document batches to the document service can increase the time it takes for your changes to become visible in search results\. If you have a large amount of data to upload, you can send batches in parallel\. The number of simultaneous uploaders you can use depends on the search instance type\. You can prescale for bulk uploads by setting the desired instance type option for your domain\. For more information, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\. 

For each document in a batch, you must specify:
+ The operation you want to perform: *add* or *delete*\. 
+ A unique ID for the document\. A document ID can contain any letter or number and the following characters: \_ \- = \# ; : / ? @ &\. Document IDs must be at least 1 and no more than 128 characters long\.
+ A name\-value pair for each document field\. To specify the value for a `latlon` field, you specify the latitude and longitude as a comma\-separated list; for example, `"location_field": "35.628611,-120.694152"`\. When specifying documents in JSON, the value for a field cannot be `null`\. \(You can, however, omit the field entirely\.\) 

For example, the following JSON batch adds one document and deletes one document:

```
[
 {"type": "add",
  "id":   "tt0484562",
  "fields": {
    "title": "The Seeker: The Dark Is Rising",
    "directors": ["Cunningham, David L."],
    "genres": ["Adventure","Drama","Fantasy","Thriller"],
    "actors": ["McShane, Ian","Eccleston, Christopher","Conroy, Frances",
              "Crewson, Wendy","Ludwig, Alexander","Cosmo, James",
              "Warner, Amelia","Hickey, John Benjamin","Piddock, Jim",
              "Lockhart, Emma"]
  }
 },
 {"type": "delete",
  "id":   "tt0484575"
 }
]
```

The same batch formatted in XML looks like this:

```
<batch>
 <add  id="tt0484562">
  <field name="title">The Seeker: The Dark Is Rising</field>
  <field name="directors">Cunningham, David L.</field>
  <field name="genres">Adventure</field>
  <field name="genres">Drama</field>
  <field name="genres">Fantasy</field>
  <field name="genres">Thriller</field>
  <field name="actors">McShane, Ian</field>
  <field name="actors">Eccleston, Christopher</field>
  <field name="actors">Conroy, Frances</field>
  <field name="actors">Ludwig, Alexander</field>
  <field name="actors">Crewson, Wendy</field>
  <field name="actors">Warner, Amelia</field>
  <field name="actors">Cosmo, James</field>
  <field name="actors">Hickey, John Benjamin</field>
  <field name="actors">Piddock, Jim</field>
  <field name="actors">Lockhart, Emma</field>
 </add>
 <delete id="tt0484575" />
</batch>
```

Amazon CloudSearch accepts a batch only if all documents in it are valid\. You can verify the validity of your JSON or XML data using tools such as `xmllint` and `jsonlint`\.

Both JSON and XML batches can only contain UTF\-8 characters that are valid in XML\. Valid characters are the control characters tab \(0009\), carriage return \(000D\), and line feed \(000A\), and the legal characters of Unicode and ISO/IEC 10646\. FFFE, FFFF, and the surrogate blocks D800–DBFF and DC00–DFFF are invalid and will cause errors\. \(For more information, see [Extensible Markup Language \(XML\) 1\.0 \(Fifth Edition\)](http://www.w3.org/TR/REC-xml/#charsets)\.\) You can use the following regular expression to match invalid characters so you can remove them: `/[^\u0009\u000a\u000d\u0020-\uD7FF\uE000-\uFFFD]/ `\.

When formatting your data in JSON, quotes \("\) and backslashes \(\\\) within field values must be escaped with a backslash\. For example:

```
"title":"Where the Wild Things Are"
"isbn":"0-06-025492-0"
"image":"images\\covers\\Where_The_Wild_Things_Are_(book)_cover.jpg"
"comment":"Sendak's \"Where the Wild Things Are\" is a children's classic."
```

When formatting your data in XML, ampersands \(&\) and less\-than symbols \(<\) within field values need to be represented with the corresponding entity references \(`&amp;` and `&lt;`\)\.

For example:

```
<field name="title">Little Cow &amp; the Turtle</field>
<field name="isbn">0-84466-4774</field>
<field name="image">images\covers\Little_Cow_&amp;_the_Turtle.jpg</field>
<field name="comment">&lt;insert comment></field>
```

If you have large blocks of user\-generated content, you might want to wrap the entire field in a CDATA section, rather than replacing every occurrence with the entity reference\. For example:

```
<field name="comment"><![CDATA[Monsters & mayhem--what's not to like! ]]>
```

### Adding and Updating Documents in Amazon CloudSearch<a name="adding-documents"></a>

An add operation specifies either a new document that you want to add to the index or an existing document that you want to update\. 

 When you add or update a document, you specify the document's ID and all of the fields the document contains\. You don't have to specify every configured field for every document—documents can contain a subset of the configured fields\. However, every field in the document must correspond to a field configured for the domain\. 

**To add a document to a search domain**

1. Specify an add operation that contains the ID of the document you want to add and each of the fields that you want to be able to search or return in results\. If the document already exists, the add operation will replace it\. \(You cannot update selected fields, the document is overwritten with the new version\.\) For example, the following operation adds document tt0484562: 

   ```
   { "type": "add",
     "id":   "tt0484562",
     "fields": {
       "title": "The Seeker: The Dark Is Rising",
       "directors": ["Cunningham, David L."],
       "genres": ["Adventure","Drama","Fantasy","Thriller"],
       "actors": ["McShane, Ian","Eccleston, Christopher","Conroy, Frances",
                 "Crewson, Wendy","Ludwig, Alexander","Cosmo, James",
                 "Warner, Amelia","Hickey, John Benjamin","Piddock, Jim",
                 "Lockhart, Emma"]
     }
   }
   ```

1. Include the add operation in a document batch and upload the batch to your domain\. You can upload data through the Amazon CloudSearch console or by posting a request directly to the domain's document service endpoint\. For more information, see [Uploading Data to an Amazon CloudSearch Domain](uploading-data.md)\. 

### Deleting Documents in Amazon CloudSearch<a name="deleting-documents"></a>

A delete operation specifies a document that you want to remove from a domain's index\. Once a document is deleted, it will no longer be searchable or returned in results\.

When posting updates to delete documents, you have to specify each document that you want to delete\. 

If your domain has scaled up to accommodate your index size and you delete a large number of documents, the domain scales down the next time the full index is rebuilt\. Although the index is automatically rebuilt periodically, to scale down as quickly as possible you can explicitly [run indexing](indexing.md) when you are done deleting documents\. 

**Note**  
To delete documents, you upload document batches that contain delete operations\. You are billed for the total number of document batches uploaded to your search domain, including batches that contain delete operations\. For more information about Amazon CloudSearch pricing, see [aws\.amazon\.com/cloudsearch/pricing/](http://aws.amazon.com/cloudsearch/pricing/)\. 

**To delete a document from a search domain**

1. Specify a delete operation that contains the ID of the document you want to remove\. For example, the following operation would remove document `tt0484575`: 

   ```
   {
     "type": "delete",
     "id": "tt0484575"
   }
   ```

1. Include the delete operation in a document batch and upload the batch to your domain\. You can upload batches through the Amazon CloudSearch console or by posting a request directly to the domain's document service endpoint\. For more information, see [Uploading Data to an Amazon CloudSearch Domain](uploading-data.md)\.

1. The delete operation removes documents from your index—they won't appear in search results—but to delete them entirely from Amazon CloudSearch, you must also [rebuild your index](API_IndexDocuments.md)\.

### Processing Your Source Data for Amazon CloudSearch<a name="processing-source-data"></a>

To upload data for indexing, you need to format your data in either JSON or XML\. The Amazon CloudSearch console provide a way to automatically generate properly formatted JSON or XML from several common file types: CSV, text, and HTML\. You can also process batches formatted for the Amazon CloudSearch 2011\-02\-01 API to convert them to the 2013\-01\-01 format\.

For most file types, each source file is represented as a separate document in the generated JSON or XML\. If metadata is available for the file, the metadata is mapped to corresponding document fields—the fields generated from the document metadata vary depending on the file type\. The contents of the source file are parsed into a single text field\. If the file contains more than 1 MB of data, the data mapped to the text field is truncated so that the document does not exceed 1 MB\.

CSV files are handled differently\. When processing a CSV file, Amazon CloudSearch uses the contents of the first row to define the document fields, and creates a separate document for each following row\. If there is a column header called *docid*, the values in that column are used as the document IDs\. If necessary, the docid values are normalized to conform to the allowed character set\. A document ID can contain any letter or number and the following characters: \_ \- = \# ; : / ? @ &\. If there is no docid column, a unique ID is generated for each document based on the filename and row number\. 

If you upload multiple types of files, CSV files are parsed row\-by\-row, and non\-CSV files are treated as individual documents\.

**Note**  
Currently, only CSV files are parsed to automatically extract custom field data and generate multiple documents\.

You can also process data stored in DynamoDB\. Amazon CloudSearch represents each item read from the table as a separate document\.

#### Processing Source Data Using the Amazon CloudSearch Console<a name="processing-source-data-console"></a>

When you upload source documents or DynamoDB items through the Amazon CloudSearch console, they are automatically converted to the Amazon CloudSearch JSON format\. You can use the console to upload up to 5 MB of data at a time\. If you choose, you can download the generated JSON file\. For more information about uploading data through the console, see [Uploading Data to an Amazon CloudSearch Domain](uploading-data.md) and [Uploading DynamoDB Data](searching-dynamodb-data.md#searching-dynamodb-data-console)\.
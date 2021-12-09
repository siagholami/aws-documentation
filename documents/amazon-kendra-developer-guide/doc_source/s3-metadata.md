--------

--------

# S3 document metadata<a name="s3-metadata"></a>

You can add metadata, additional information about a document, to documents in an Amazon S3 bucket using a metadata file\. Each metadata file is associated with an indexed document\. 

Your metadata files must be stored in the same bucket as your indexed files\. You can specify a location within the bucket for your metadata files using the console or the `S3Prefix` field of the `DocumentsMetadataConfiguration` parameter when you create an S3 data source\. If you don't specify an S3 prefix, your metadata files must be stored in the same location as your indexed documents\.

If you specify an S3 prefix for your metadata files, they live in a directory structure parallel to your indexed documents\. Amazon Kendra looks only in the specified directory for your metadata\. If the metadata isn't read, check that the directory location matches the location of your metadata\.

The following examples show how the indexed document location maps to the metadata file location\. Note that the document's S3 key is appended to the metadata's S3 prefix and then suffixed with `.metatdata.json` to form the metadata file's S3 path\.

```
Bucket name:
     s3://bucketName
Document path:
     documents
Metadata path:
     none
File mapping
     s3://bucketName/documents/file.txt -> 
        s3://bucketName/documents/file.txt.metadata.json
```

```
Bucket name:
     s3://bucketName
Document path:
     documents/legal
Metadata path:
     metadata
File mapping
     s3://bucketName/documents/legal/file.txt -> 
        s3://bucketName/metadata/documents/legal/file.txt.metadata.json
```

Your document metadata is defined in a JSON file\. The file must be a UTF\-8 text file without a BOM marker\. The file name of the JSON file should be `document.extension.metadata.json`, where "document" is the name of the document that the metadata applies to and "extension" is the file extension for the document\.

The content of the JSON file follows this template\. All of the attributes are optional\. If you don't specify the `_source_uri`, then the links returned by Amazon Kendra in search results point to the S3 bucket that contains the document\. 

```
{
    "DocumentId": "document ID",
    "Attributes": {
        "_category": "document category",
        "_created_at": "ISO 8601 encoded string",
        "_last_updated_at": "ISO 8601 encoded string",
        "_source_uri": "document URI",
        "_version": "file version",
        "_view_count": number of times document has been viewed,
        "custom attribute key": "custom attribute value",
        additional custom attributes
    },
    "AccessControlList": [
         {
             "Name": "user name",
             "Type": "GROUP | USER",
             "Access": "ALLOW | DENY"
         }
    ],
    "Title": "document title",
    "ContentType": "HTML | MS_WORD | PDF | PLAIN_TEXT | PPT"
}
```

The `_created_at` and `_last_updated_at` metadata fields are ISO 8601 encoded dates\. For example, "2019\-09\-24T01:04:41Z"\.

You can add additional information to the `Attributes` field about a document that you use to filter queries or to group query responses\. For more information, see [Creating custom document attributes](custom-attributes.md)\.

The `AccessControlList` field enables you to filter the response from a query so that only certain users and groups have access to documents\. For more information, see [Filtering on user context](user-context-filter.md)\.
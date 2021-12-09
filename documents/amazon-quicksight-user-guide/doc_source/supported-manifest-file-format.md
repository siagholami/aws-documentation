# Supported Formats for Amazon S3 Manifest Files<a name="supported-manifest-file-format"></a>

You use JSON manifest files to specify files in Amazon S3 to import into Amazon QuickSight\. These JSON manifest files can use either the Amazon QuickSight format described following or the Amazon Redshift format described in [Using a Manifest to Specify Data Files](https://docs.aws.amazon.com/redshift/latest/dg/loading-data-files-using-manifest.html)\. You don't have to use Amazon Redshift to use the Amazon Redshift manifest file format\. 

If you use an Amazon QuickSight manifest file, it must have a \.json extension, for example my\_manifest\.json\. If you use an Amazon Redshift manifest file, it can have any extension\. 

If you use an Amazon Redshift manifest file, Amazon QuickSight processes the optional `mandatory` flag similarly to Amazon Redshift, terminating the import process and returning an error if the associated file is not found\.

Files you select for import must be delimited\-text \(for example, \.csv or \.tsv\), log \(\.clf\), or extended log \(\.elf\) format, or JSON \(\.json\)\. All files identified in one manifest file must use the same file format\. Plus, they must have the same number and type of columns\. Amazon QuickSight supports UTF\-8 file encoding, but not UTF\-8 \(with BOM\)\. If you are importing JSON files, then for `globalUploadSettings` you need to specify `format`, but not `delimiter`, `textqualifier`, and `containsHeader`\.

Any files you specify must be in Amazon S3 buckets that you have granted Amazon QuickSight access to\. For information about granting Amazon QuickSight access to AWS resources, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\.

## Manifest File Format for Amazon QuickSight<a name="quicksight-manifest-file-format"></a>

Amazon QuickSight manifest files use the following JSON format\.

```
{
    "fileLocations": [
        {
            "URIs": [
                "uri1",
                "uri2",
                "uri3"
            ]
        },
        {
            "URIPrefixes": [
                "prefix1",
                "prefix2",
                "prefix3"
            ]
        }
    ],
    "globalUploadSettings": {
        "format": "CSV",
        "delimiter": ",",
        "textqualifier": "'",
        "containsHeader": "true"
    }
}
```

Use the fields in the `fileLocations` element to specify the files to import, and the fields in the `globalUploadSettings` element to specify import settings for those files, such as field delimiters\. 

The manifest file elements are described following\.
+ **fileLocations** — Use this element to specify the files to import\. You can use either or both of the `URIs` and `URIPrefixes` arrays to do this\. You must specify at least one value in one or the other of them\.
  + **URIs** — Use this array to list URIs for specific files to import\.

    Amazon QuickSight can access Amazon S3 files that are in any AWS Region\. However, you must use a URI format that identifies the AWS Region of the Amazon S3 bucket if it is different from that used by your Amazon QuickSight account\.

    URIs in the following formats are supported:  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/supported-manifest-file-format.html)
  + **URIPrefixes** — Use this array to list URI prefixes for S3 buckets and folders\. All files in a specified bucket or folder are imported\. Amazon QuickSight recursively retrieves files from child folders\.

    Amazon QuickSight can access Amazon S3 buckets or folders that are in any AWS Region\. However, you must use a URI prefix format that identifies the AWS Region of the Amazon S3 bucket if it is different from that used by your Amazon QuickSight account\.

    URI prefixes in the following formats are supported:  
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/supported-manifest-file-format.html)
+ **globalUploadSettings** — \(Optional\) Use this element to specify import settings for the Amazon S3 files, such as field delimiters\. If this element is not specified, Amazon QuickSight uses the default values for the fields in this section\.
**Important**  
For log \(\.clf\) and extended log \(\.elf\) files, only the **format** field in this section is applicable, so you can skip the other fields\. If you choose to include them, their values are ignored\. 
  + **format** — \(Optional\) Specify the format of the files to be imported\. Valid formats are **CSV**, **TSV**, **CLF**, **ELF**, and **JSON**\. The default value is **CSV**\.
  + **delimiter** — \(Optional\) Specify the file field delimiter\. This must map to the file type specified in the `format` field\. Valid formats are commas \(**,**\) for \.csv files and tabs \(**\\t**\) for \.tsv files\. The default value is comma \(**,**\)\.
  + **textqualifier** — \(Optional\) Specify the file text qualifier\. Valid formats are single quote \(**'**\), double quotes \(**\\"**\), or no value if no qualifier is used\. The leading backslash is a required escape character for a double quote in JSON\. The default value is double quotes \(**\\"**\)\.
  + **containsHeader** — \(Optional\) Specify whether the file has a header row\. Valid formats are **true** or **false**\. The default value is **true**\.

### Manifest File Examples for Amazon QuickSight<a name="quicksight-manifest-file-examples"></a>

The following are some examples of completed Amazon QuickSight manifest files\.

The following example shows a manifest file that identifies two specific \.csv files for import\. These files use double quotes for text qualifiers\. The `format`, `delimiter`, and `containsHeader` fields are skipped because the default values are acceptable\.

```
{
    "fileLocations": [
        {
            "URIs": [
                "https://data_bucket.s3.amazonaws.com/data.csv",
                "https://data_bucket.s3.amazonaws.com/data2.csv"
            ]
        }
    ],
    "globalUploadSettings": {
        "textqualifier": "\""
    }
}
```

The following example shows a manifest file that identifies one specific \.tsv file for import, and also a bucket in another AWS Region that contains additional \.tsv files for import\. The `textqualifier` and `containsHeader` fields are skipped because the default values are acceptable\.

```
{
    "fileLocations": [
        {
            "URIs": [
                "https://s3.amazonaws.com/data_bucket/data.tsv"
            ]
        },
        {
            "URIPrefixes": [
                "https://s3-us-east-1.amazonaws.com/data_bucket/"
            ]
        }
    ],
    "globalUploadSettings": {
        "format": "TSV",
        "delimiter": "\t"
    }
}
```

The following example identifies two buckets that contain \.clf files for import\. One is in the same AWS Region as the Amazon QuickSight account, and one in a different AWS Region\. The `delimiter`, `textqualifier`, and `containsHeader` fields are skipped because they are not applicable to log files\.

```
{
    "fileLocations": [
        {
            "URIPrefixes": [
                "https://data_bucket.s3-us-east-1.amazonaws.com",
                "s3://other_data_bucket/"
            ]
        }
    ],
    "globalUploadSettings": {
        "format": "CLF"
    }
}
```

The following example uses the Amazon Redshift format to identify a \.csv file for import\.

```
{
    "entries": [
        {
            "url": "https://s3-us-west-2.amazonaws.com/myalias-test/Consumer_Complaints3.csv",
            "mandatory": true
        }
    ]
}
```

The following example uses the Amazon Redshift format to identify two JSON files for import\.

```
{
    "fileLocations": [
        {
            "URIs": [
                "https://data_bucket.s3.amazonaws.com/data.json",
                "https://data_bucket.s3.amazonaws.com/data2.json"
            ]
        }
    ],
    "globalUploadSettings": {
        "format": "JSON"
    }
}
```

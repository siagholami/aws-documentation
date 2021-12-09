# Data Sets Based on Multiple Amazon S3 Files<a name="data-sets-based-on-multiple-s3-files"></a>

You can use one of several methods to merge or combine files from Amazon S3 inside Amazon QuickSight:
+ **Combine files by using a manifest** – In this case, the files must have the same number of fields \(columns\)\. The data types must match between fields in the same position in the file\. For example, the first field must have the same data type in each file\. The same goes for the second field, and the third field, and so on\. Amazon QuickSight takes field names from the first file\.

  The files must be listed explicitly in the manifest\. However, they don't have to be inside the same S3 bucket\.

  In addition, the files must follow the rules described in [Supported Formats for Amazon S3 Manifest Files](supported-manifest-file-format.md)\.

  For more details about combining files using a manifest, see [Creating a Data Set Using Amazon S3 Files](create-a-data-set-s3.md)\.
+ **Merge files without using a manifest** – To merge multiple files into one without having to list them individually in the manifest, you can use Athena\. With this method, you can simply query your text files, like they are in a table in a database\. For more information, see the post [Analyzing Data in Amazon S3 Using Athena](https://aws.amazon.com/blogs/big-data/analyzing-data-in-s3-using-amazon-athena/) in the Big Data blog\. 
+ **Use a script to append files before importing** – You can use a script designed to combine your files before uploading\. 
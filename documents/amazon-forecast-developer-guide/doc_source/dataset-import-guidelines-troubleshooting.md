# Dataset Guidelines for Forecast<a name="dataset-import-guidelines-troubleshooting"></a>

Consult to the following guidelines if Amazon Forecast fails to import your dataset, or if your dataset doesn't function as expected\.

**Timestamp Format**  
For Year \(`Y`\), Month \(`M`\), Week \(`W`\), and Day \(`D`\) collection frequencies, Forecast supports the `yyyy-MM-dd` timestamp format \(for example, `2019-08-21`\) and, optionally, the `HH:mm:ss` format \(for example, `2019-08-21 15:00:00`\)\.  
For Hour \(`H`\) and Minute \(`M`\) frequencies, Forecast supports only the `yyyy-MM-dd HH:mm:ss` format \(for example `2019-08-21 15:00:00`\)\.  
Guideline: Change the timestamp format for the collection frequency of your dataset to the supported format\.

**Amazon S3 File or Bucket **  
When you import a dataset, you can specify either the path to the CSV file in your Amazon Simple Storage Service \(Amazon S3\) bucket that contains your data or the name of the S3 bucket that contains your data If you specify a CSV file, Forecast imports just that file\. If you specify an S3 bucket, Forecast imports all of the CSV files in the bucket up to 10,000 files\. If you import multiple files by specifying a bucket name, all CSV files must conform to the specified schema\.  
Guideline: Specify a CSV file or an S3 bucket using the following syntax:  
`s3://bucket-name/example-object.csv`  
`s3://bucket-name/prefix/`  
`s3://bucket-name`

**Dataset Updates**  
Because dataset import jobs are not aggregated, your most recent dataset import is the one that is used when training a predictor or generating a forecast\.  
Guideline: Make sure that your most recent dataset import contains all of the data you want to model off of, and not just the new data collected since the previous import\.

**Attribute Order**  
The order of attributes specified in the schema definition must match the column order in the CSV file that you are importing\. For example, if you defined `timestamp` as the first attribute, then `timestamp` must also be the first column in the input CSV file\.   
Guideline: Verify that the columns in the CSV file are in the same order as the schema attributes that you created\. 

**Dataset Header**  
A dataset header in your input CSV file may cause a validation error\. We recommend omitting a header\.  
Guideline: Delete the dataset header and try the import again\.

**Dataset Status**  
Before you can import training data with the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) operation, the `Status`of the dataset must be `ACTIVE`\.   
Guideline: Use the [DescribeDataset](API_DescribeDataset.md) operation to get the dataset's status\. If the creation or update of the dataset failed, check the formatting of your dataset file and attempt to create it again\.

**File Format and Delimiter**  
Forecast supports only the comma\-separated values \(CSV\) file format\. You can't separate values using tabs, spaces, colons, or any other characters\.  
Guideline: Convert your dataset to CSV format \(using only commas as your delimiter\) and try importing the file again\. 

**File Name**  
File names must contain at least one alphabetic character\. Files with names that are only numeric can't be imported\.  
Guideline: Rename your CSV file to include at least one alphabetic character and try importing the file again\. 
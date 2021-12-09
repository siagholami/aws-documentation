# Preparing and Importing Data<a name="data-prep"></a>

Amazon Personalize uses data that you provide to train a model\. You can provide data from a source file, or you can collect data from live events, such as user activities on a website\.

If you provide a source file to import your data into Amazon Personalize, you must fulfill these requirements: 
+ Format your data as a comma\-separated values \(CSV\) file
+ Provide a schema so that Amazon Personalize can import the data correctly
+ Upload your file into an Amazon Simple Storage Service \(Amazon S3\) bucket that Amazon Personalize can access

You can upload your data by using the AWS SDK\.

This section provides information about formatting and importing your historical data into Amazon Personalize\. For information about recording live event data, see [Recording Events](recording-events.md)\.

**Topics**
+ [Datasets and Schemas](how-it-works-dataset-schema.md)
+ [Formatting Your Input Data](data-prep-formatting.md)
+ [Uploading to an S3 Bucket](data-prep-upload-s3.md)
+ [Importing Your Data](data-prep-importing.md)
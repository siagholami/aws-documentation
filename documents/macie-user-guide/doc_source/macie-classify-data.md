# Classifying Data with Amazon Macie<a name="macie-classify-data"></a>

Macie can help you classify your sensitive and business\-critical data stored in the cloud\. Currently, Macie analyzes and processes data stored in Amazon S3 buckets\. To classify your data, Macie also uses the ability in AWS CloudTrail to capture object\-level API activity on S3 objects \(data events\)\. However, Macie monitors CloudTrail data events only if you specify at least one S3 bucket for Macie to monitor\. 

After you specify the S3 bucket or buckets for Macie to monitor, you enable Macie to continuously monitor and discover new data as it enters your AWS infrastructure\. For more information, see [Specifying Data for Macie to Monitor](macie-integration.md#macie-integration-services)\.

**Limits**
+ Macie has a default limit on the amount of data that it can classify in an account\. After this data limit is reached, Macie stops classifying the data in this account\. The default data classification limit is 3 TB\. You can contact AWS Support and request an increase to the default limit\.
+ If you specify S3 buckets that include files of a format that isn't supported in Macie, Macie doesn't classify them\.
+ Macie's content classification engine processes up to the first 20 MB of an S3 object\.

Your Macie usage charges include only the costs for the content that Macie processes\. For example, Macie can't extract text from \.wav files \(images or movies\); therefore, it doesn’t process that content and you’re not charged for it\.

**Topics**
+ [Supported Compression and Archive File Formats](macie-compression-archive-formats.md)
+ [Content Type](macie-classify-objects-content-type.md)
+ [File Extension](macie-classify-objects-file-extension.md)
+ [Theme](macie-classify-objects-theme.md)
+ [Regex](macie-classify-objects-regex.md)
+ [Personally Identifiable Information](macie-classify-objects-pii.md)
+ [Support Vector Machine–Based Classifier](macie-classify-objects-classifier.md)
+ [Object Risk Level](#compound-score)
+ [Retention Duration for S3 Metadata](#metadata-retention-duration)

## Object Risk Level<a name="compound-score"></a>

Through the automatic classification methods previously described, an object that Macie monitors is assigned various risk levels based on each content type, file extension, theme, regex, and SVM artifact that is assigned to it\. The object's compound \(final\) risk level is then set to the highest value of its assigned risk levels\.

## Retention Duration for S3 Metadata<a name="metadata-retention-duration"></a>

Macie stores metadata about your S3 objects for the default duration of 1 month\. You can extend this duration up to 12 months\.
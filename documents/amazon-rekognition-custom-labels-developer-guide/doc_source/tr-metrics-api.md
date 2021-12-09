# Accessing Amazon Rekognition Custom Labels Training Results \(SDK\)<a name="tr-metrics-api"></a>

The Amazon Rekognition API provides metrics beyond those provided in the console\. 

Like the console, the API provides access to the following metrics as summary information for the training results and as training results for each label:
+ [Precision](tr-metrics-use.md#tr-precision-metric)
+ [Recall](tr-metrics-use.md#tr-recall-metric)
+ [Overall Model Performance](tr-metrics-use.md#tr-f1-metric)

The average threshold for all labels and the threshold for individual labels is returned\.

The API also provides the following metrics for classification and image detection \(object location on image\)\.
+ *Confusion Matrix* for image classification\.
+ *Mean Average Precision \(mAP\)* for image detection\.
+ *Mean Average Recall \(mAR\)* for image detection\.

The API also provides true positive, false positive, false negative, and true negative values\. For more information, see [Metrics for Evaluating Your Model](tr-metrics-use.md)\.

The aggregate F1 score metric is returned directly by the API\. Other metrics are accessible from a [Summary File](tr-summary-file-api.md) and [Evaluation Manifest Snapshot](tr-evaluation-manifest-snapshot-api.md) files stored in an Amazon S3 bucket\. 

For example code, see [Accessing the Summary File and Evaluation Manifest Snapshot \(SDK\)](tr-sdk.md)\.

**Topics**
+ [Summary File](tr-summary-file-api.md)
+ [Evaluation Manifest Snapshot](tr-evaluation-manifest-snapshot-api.md)
+ [Accessing the Summary File and Evaluation Manifest Snapshot \(SDK\)](tr-sdk.md)
+ [Reference: Training Results Summary File](tr-summary-file.md)
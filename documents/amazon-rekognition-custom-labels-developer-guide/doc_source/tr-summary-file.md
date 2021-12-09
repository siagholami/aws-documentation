# Reference: Training Results Summary File<a name="tr-summary-file"></a>

The training results summary contains metrics you can use to evaluate your model\. The summary file is also used to display metrics in the console training results page\. The summary file is stored in an Amazon S3 bucket after training\. To get the summary file, call `DescribeProjectVersion`\. For example code, see [Accessing the Summary File and Evaluation Manifest Snapshot \(SDK\)](tr-sdk.md)\. 

## Summary File<a name="tr-summary-reference"></a>

The following JSON is the format of the summary file\.

**EvaluationDetails \(section 3\)**  
Overview information about the training task\. This includes the ARN of the project that the model belongs to \(`ProjectVersionArn)`, the date and time that training finished, the version of the model that was evaluated \(`EvaluationEndTimestamp`\), and a list of labels detected during training \(`Labels`\)\. Also included is the number of images used for training \(`NumberOfTrainingImages`\) and evaluation \(`NumberOfTestingImages`\)\. 

**AggregatedEvaluationResults \(section 1\)**  
You can use `AggregatedEvaluationResults` to evaluate the overall performance of the trained model when used with the testing dataset\. Aggregated metrics are included for `Precision`, `Recall`, and `F1Score` metrics\. For object detection \(the object location on an image\), `AverageRecall` \(mAR\) and `AveragePrecision` \(mAP\) metrics are returned\. For classification \(the type of object in an image\), a confusion matrix metric is returned\. 

**LabelEvaluationResults \(section 2\)**  
You can use `labelEvaluationResults` to evaluate the performance of individual labels\. The labels are sorted by the F1 score of each label\. The metrics included are `Precision`, `Recall`, `F1Score`, and `Threshold` \(used for classification\)\. 

The file name is formatted as follows: `EvaluationSummary-ProjectName-VersionName.json`\.

```
{
  "Version": "integer",
  // section-3
  "EvaluationDetails": {
    "ProjectVersionArn": "string",
    "EvaluationEndTimestamp": "string",
    "Labels": "[string]",
    "NumberOfTrainingImages": "int",
    "NumberOfTestingImages": "int"
  },
  // section-1
  "AggregatedEvaluationResults": {
    "Metrics": {
      "Precision": "float",
      "Recall": "float",
      "F1Score": "float",
      // The following 2 fields are only applicable to object detection
      "AveragePrecision": "float",
      "AverageRecall": "float",
      // The following field is only applicable to classification
      "ConfusionMatrix":[
        {
          "GroundTruthLabel": "string",
          "PredictedLabel": "string",
          "Value": "float"
        },
        ...
      ],
    }
  },
  // section-2
  "LabelEvaluationResults": [
    {
      "Label": "string",
      "NumberOfTestingImages", "int",
      "Metrics": {
        "Threshold": "float",
        "Precision": "float",
        "Recall": "float",
        "F1Score": "float"
      },
    },
    ...
  ]
}
```
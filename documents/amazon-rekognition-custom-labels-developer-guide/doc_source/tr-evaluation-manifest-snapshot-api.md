# Evaluation Manifest Snapshot<a name="tr-evaluation-manifest-snapshot-api"></a>

The evaluation manifest snapshot contains detailed information about the test results\. The snapshot includes the confidence rating for each prediction, and the classification of the prediction compared \(true positive, true negative, false positive, or false negative\) to the actual classification of the image\. 

The files are a snapshot since only images that could be used for testing and training are included\. Images that can't be verified, such as images in the wrong format, aren't included in the manifest\. The testing snapshot location is accessible from the `TestingDataResult` object returned by `DescribeProjectVersions`\. The training snapshot location is accessible from `TrainingDataResult` object returned by `DescribeProjectVersions`\. 

The snapshot is in Amazon SageMaker Ground Truth manifest output format with fields added to provide additional information, such as the result of a detection's binary classification\. The following snippet shows the additional fields\.

```
"rekognition-custom-labels-evaluation-details": {
    "version": 1,
    "is-true-positive": true,
    "is-true-negative": false,
    "is-false-positive": false,
    "is-false-negative": false,
    "is-present-in-ground-truth": true
    "ground-truth-labelling-jobs": ["rekognition-custom-labels-training-job"]
}
```
+ *version* – The version of the `rekognition-custom-labels-evaluation-details` field format within the manifest snapshot\.
+ *is\-true\-positive\.\.\.* – The binary classification of the prediction based on how the confidence score compares to the minimum threshold for the label\.
+ *is\-present\-in\-ground\-truth* – True if the prediction made by the model is present in the ground truth information used for training, otherwise false\. This value isn't based on whether the confidence score exceeds the minimum threshold calculated by the model\. 
+ *ground\-truth\-labeling\-jobs* – A list of ground truth fields in the manifest line that are used for training\.

For information about the Amazon SageMaker Ground Truth manifest format, see [Output](https://docs.aws.amazon.com/sagemaker/latest/dg/sms-data-output.html)\. 

The following is an example testing manifest snapshot that shows metrics for image classification and object detection\.

```
// For image classification
{
  "source-ref": "s3://test-bucket/dataset/beckham.jpeg",
  "rekognition-custom-labels-training-0": 1,
  "rekognition-custom-labels-training-0-metadata": {
    "confidence": 1.0,
    "job-name": "rekognition-custom-labels-training-job",
    "class-name": "Football",
    "human-annotated": "yes",
    "creation-date": "2019-09-06T00:07:25.488243",
    "type": "groundtruth/image-classification"
  },
  "rekognition-custom-labels-evaluation-0": 1,
  "rekognition-custom-labels-evaluation-0-metadata": {
    "confidence": 0.95,
    "job-name": "rekognition-custom-labels-evaluation-job",
    "class-name": "Football",
    "human-annotated": "no",
    "creation-date": "2019-09-06T00:07:25.488243",
    "type": "groundtruth/image-classification",
    "rekognition-custom-labels-evaluation-details": {
      "version": 1,
      "ground-truth-labelling-jobs": ["rekognition-custom-labels-training-job"],
      "is-true-positive": true,
      "is-true-negative": false,
      "is-false-positive": false,
      "is-false-negative": false,
      "is-present-in-ground-truth": true
    }
  }
}


// For object detection
{
  "source-ref": "s3://test-bucket/dataset/beckham.jpeg",
  "rekognition-custom-labels-training-0": {
    "annotations": [
      {
        "class_id": 0,
        "width": 39,
        "top": 409,
        "height": 63,
        "left": 712
      },
      ...
    ],
    "image_size": [
      {
        "width": 1024,
        "depth": 3,
        "height": 768
      }
    ]
  },
  "rekognition-custom-labels-training-0-metadata": {
    "job-name": "rekognition-custom-labels-training-job",
    "class-map": {
      "0": "Cap",
      ...
    },
    "human-annotated": "yes",
    "objects": [
      {
        "confidence": 1.0
      },
      ...
    ],
    "creation-date": "2019-10-21T22:02:18.432644",
    "type": "groundtruth/object-detection"
  },
  "rekognition-custom-labels-evaluation": {
    "annotations": [
      {
        "class_id": 0,
        "width": 39,
        "top": 409,
        "height": 63,
        "left": 712
      },
      ...
    ],
    "image_size": [
      {
        "width": 1024,
        "depth": 3,
        "height": 768
      }
    ]
  },
  "rekognition-custom-labels-evaluation-metadata": {
    "confidence": 0.95,
    "job-name": "rekognition-custom-labels-evaluation-job",
    "class-map": {
      "0": "Cap",
      ...
    },
    "human-annotated": "no",
    "objects": [
      {
        "confidence": 0.95,
        "rekognition-custom-labels-evaluation-details": {
          "version": 1,
          "ground-truth-labelling-jobs": ["rekognition-custom-labels-training-job"],
          "is-true-positive": true,
          "is-true-negative": false,
          "is-false-positive": false,
          "is-false-negative": false,
          "is-present-in-ground-truth": true
        }
      },
      ...
    ],
    "creation-date": "2019-10-21T22:02:18.432644",
    "type": "groundtruth/object-detection"
  }
}
```
# Step 7: Analyze Images with Your Model<a name="gs-step-detect-custom-label-cli"></a>

To analyze images with your model, you call [DetectCustomLabels](https://docs.aws.amazon.com/rekognition/latest/dg/API_DetectCustomLabels)\. This operation takes an input image from either an Amazon S3 bucket or from a local file system\. The response includes the custom labels for objects, scenes, and concepts found in the input image\. A custom label has an associated confidence score that tells you Amazon Rekognition Custom Labels's confidence in the accuracy of the predicted custom label\. Object location bounding boxes for objects that are detected in the image are also returned\. For more information, see [Analyzing an Image with a Trained Model](detecting-custom-labels.md)\. 

In this step, you analyze an image for custom labels using an image stored in an Amazon S3 bucket\.

**To detect customs labels in an image**

1. Upload an image that contains text to an S3 bucket\. 

   For instructions, see [Uploading Objects into Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/UploadingObjectsintoAmazonS3.html) in the *Amazon Simple Storage Service Console User Guide*\.

1. At the command prompt, enter the following command\. Replace the following values:
   + `bucket` with the name of Amazon S3 bucket that you used in step 1\. 
   + `image` with the name of the input image file you uploaded in step 1\.
   + `model_arn` with the ARN of the model you created in [Step 4: Train Your Model](gs-step-train-model-cli.md)\. 

   ```
   aws rekognition detect-custom-labels --project-version-arn "model_arn"\
      --image '{"S3Object":{"Bucket":"bucket","Name":"image"}}'\
      --min-confidence 70
   ```

The output should be similar to the following\. If you don't get any results, try lowering the value of `--min-confidence.`

```
{
    "CustomLabels": [
        {
            "Name": "MyLogo",
            "Confidence": 77.7729721069336,
            "Geometry": {
                "BoundingBox": {
                    "Width": 0.198987677693367,
                    "Height": 0.31296101212501526,
                    "Left": 0.07924537360668182,
                    "Top": 0.4037395715713501
                }
            }
        }
    ]
}
```
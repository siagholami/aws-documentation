# Step 10: Analyze Images with Your Model<a name="gs-step-get-a-prediction"></a>

After you've started your model, you can use it to analyze images\. In this step, you use example code from the Amazon Rekognition Custom Labels console\. For an example that draws bounding boxes around detected custom labels, see [Analyzing an Image with a Trained Model](detecting-custom-labels.md)\.

To run the example code, you need to set up the AWS SDK\. For more information, see [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)\.

**To analyze an image \(console\)**

1. Upload an image that contains text to an S3 bucket\. 

   For instructions, see [Uploading Objects into Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/UploadingObjectsintoAmazonS3.html) in the *Amazon Simple Storage Service Console User Guide*\.

1. On the **Projects** resources page, choose the project that contains the trained model that you want to use\. The project **Evaluation Summary** page for the model is shown\. 

1. In the **Use Model** section, choose **API code**\. 

1. At the command prompt, use the code snippet that calls `detect-custom-labels` to analyze an image\. It should look like the following example\. The value of `--project-version-arn` should be Amazon Resource Name \(ARN\) of your model\. Change `MY_BUCKET` and `PATH_TO_MY_IMAGE` to the Amazon S3 bucket and image that you used in step 1\. For more information, see [Step 7: Analyze Images with Your Model](gs-step-detect-custom-label-cli.md)\. 

   ```
   aws rekognition detect-custom-labels \
     --project-version-arn "model_arn" \
     --image "{"S3Object": {"Bucket": "MY_BUCKET","Name": "PATH_TO_MY_IMAGE"}}" \
      --region us-east-1
   ```
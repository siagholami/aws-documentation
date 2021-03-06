# Rekognition Custom Labels Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What Is Amazon Rekognition Custom Labels?](what-is.md)
   + [Choosing to Use Amazon Rekognition Custom Labels](wi-choosing.md)
   + [Amazon Rekognition Custom Labels and Machine Learning Terminology](ud-terminology.md)
+ [Setting Up Amazon Rekognition Custom Labels](su-set-up.md)
   + [Step 1: Create an AWS Account](su-account.md)
   + [Step 2: Create an IAM Administrator User and Group](su-account-user.md)
   + [Step 2: Set Up the AWS CLI and AWS SDKs](su-awscli-sdk.md)
   + [Step 4: Set Up Amazon S3 Bucket Permissions for SDK Use](su-sdk-bucket-permssions.md)
   + [Step 5: Set Up Amazon Rekognition Custom Labels Console Permissions](su-console-policy.md)
+ [Getting Started with Amazon Rekognition Custom Labels](gs-introduction.md)
   + [Getting Started with the Amazon Rekognition Custom Labels Console](gs-console.md)
      + [Step 1: Prepare Your Images](gs-step-prepare-images.md)
      + [Step 2: Create Your First Project](gs-step-create-bucket.md)
      + [Step 3: Create a Dataset](gs-step-create-dataset.md)
      + [Step 4: Create Labels](gs-create-labels.md)
      + [Step 5: Identify Scenes and Concepts with Image-Level Labels](gs-add-image-labels.md)
      + [Step 6: Identify Objects with Bounding Boxes](gs-draw-bounding-boxes.md)
      + [Step 7: Train Your Model](gs-step-train-model.md)
      + [Step 8: Evaluate Your Model](gs-step-evaluate-model.md)
      + [Step 9: Start Your Model](gs-step-start-model.md)
      + [Step 10: Analyze Images with Your Model](gs-step-get-a-prediction.md)
      + [Step 11: Stop Your Model](gs-step-stop-model.md)
   + [Getting Started with the Amazon Rekognition Custom Labels SDK](gs-cli.md)
      + [Step 1: Prepare Your Images](gs-step-prepare-images-cli.md)
      + [Step 2: Create a Project](gs-step-create-project-cli.md)
      + [Step 3: Prepare Your Dataset](gs-step-prepare-dataset-cli.md)
      + [Step 4: Train Your Model](gs-step-train-model-cli.md)
      + [Step 5: Evaluate Your Model](gs-step-evaluate-model-cli.md)
      + [Step 6: Start Your Model](gs-step-start-model-cli.md)
      + [Step 7: Analyze Images with Your Model](gs-step-detect-custom-label-cli.md)
      + [Step 8: Stop Your Model](gs-step-stop-model-cli.md)
+ [Managing an Amazon Rekognition Custom Labels Project](cp-manage-project.md)
   + [Creating an Amazon Rekognition Custom Labels Project](cp-create-project.md)
   + [Deleting an Amazon Rekognition Custom Labels Project](cp-delete.md)
+ [Managing a Dataset](cd-managing-datasets.md)
   + [Preparing Images](pi-prepare-images.md)
   + [Creating an Amazon Rekognition Custom Labels Dataset](cd-create-dataset.md)
      + [Manifest Files](cd-manifest-files.md)
         + [Required Attributes](cd-required-fields.md)
         + [Validation Rules](cd-manifest-files-validation-rules.md)
   + [Editing Labels](rv-editing-labels.md)
   + [Assigning Image-Level Labels to an Image](rv-assign-labels.md)
   + [Drawing Bounding Boxes](rv-bounding-box.md)
+ [Managing an Amazon Rekognition Custom Labels Model](um-use-model.md)
   + [Training an Amazon Rekognition Custom Labels Model](tm-train-model.md)
      + [Training a Model (Console)](tm-console.md)
      + [Training a Model (SDK)](tm-sdk.md)
   + [Evaluating a Trained Amazon Rekognition Custom Labels Model](tr-train-results.md)
      + [Metrics for Evaluating Your Model](tr-metrics-use.md)
      + [Accessing Training Results (Console)](tr-console.md)
      + [Accessing Amazon Rekognition Custom Labels Training Results (SDK)](tr-metrics-api.md)
         + [Summary File](tr-summary-file-api.md)
         + [Evaluation Manifest Snapshot](tr-evaluation-manifest-snapshot-api.md)
         + [Accessing the Summary File and Evaluation Manifest Snapshot (SDK)](tr-sdk.md)
         + [Reference: Training Results Summary File](tr-summary-file.md)
   + [Improving an Amazon Rekognition Custom Labels Model](tr-improve-model.md)
   + [Running a Trained Amazon Rekognition Custom Labels Model](rm-run-model.md)
      + [Starting or Stopping an Amazon Rekognition Custom Labels Model (Console)](rm-start-model-console.md)
      + [Starting an Amazon Rekognition Custom Labels Model (SDK)](rm-start-model-sdk.md)
      + [Stopping an Amazon Rekognition Custom Labels Model (SDK)](rm-stop-model-sdk.md)
   + [Deleting an Amazon Rekognition Custom Labels Model](tm-delete.md)
+ [Analyzing an Image with a Trained Model](detecting-custom-labels.md)
+ [Examples](examples.md)
   + [Model Feedback Solution](ex-feedback.md)
   + [Custom Labels Demonstration](ex-custom-labels-demo.md)
   + [Video Analysis](ex-video-extraction.md)
   + [Creating an AWS Lambda Function](ex-lambda.md)
+ [Security](sc-introduction.md)
+ [Limits in Amazon Rekognition Custom Labels](limits.md)
+ [Amazon Rekognition Custom Labels API Reference](custom-labels-api-reference.md)
+ [Document History for Amazon Rekognition Custom Labels](document-history.md)
+ [AWS Glossary](glossary.md)
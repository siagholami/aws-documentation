# Amazon Rekognition Developer Guide

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
+ [What Is Amazon Rekognition?](what-is.md)
+ [How Amazon Rekognition Works](how-it-works.md)
   + [Types of Analysis](how-it-works-types.md)
   + [Image and Video Operations](how-it-works-operations-intro.md)
   + [Non-Storage and Storage API Operations](how-it-works-storage-non-storage.md)
   + [Model Versioning](face-detection-model.md)
+ [Getting Started with Amazon Rekognition](getting-started.md)
   + [Step 1: Set Up an AWS Account and Create an IAM User](setting-up.md)
   + [Step 2: Set Up the AWS CLI and AWS SDKs](setup-awscli-sdk.md)
   + [Step 3: Getting Started Using the AWS CLI and AWS SDK API](get-started-exercise.md)
   + [Step 4: Getting Started Using the Amazon Rekognition Console](getting-started-console.md)
      + [Exercise 1: Detect Objects and Scenes in an Image (Console)](detect-labels-console.md)
      + [Exercise 2: Analyze Faces in an Image (Console)](detect-faces-console.md)
      + [Exercise 3: Compare Faces in Images (Console)](compare-faces-console.md)
      + [Exercise 4: See Aggregated Metrics (Console)](aggregated-metrics.md)
+ [Programming the Amazon Rekognition API](programming.md)
   + [Working with Images](images.md)
      + [Images](images-information.md)
      + [Analyzing Images Stored in an Amazon S3 Bucket](images-s3.md)
      + [Analyzing an Image Loaded from a Local File System](images-bytes.md)
         + [Using JavaScript](image-bytes-javascript.md)
      + [Displaying Bounding Boxes](images-displaying-bounding-boxes.md)
      + [Getting Image Orientation and Bounding Box Coordinates](images-orientation.md)
   + [Working with Stored Videos](video.md)
      + [Calling Amazon Rekognition Video Operations](api-video.md)
      + [Configuring Amazon Rekognition Video](api-video-roles.md)
      + [Analyzing a Video Stored in an Amazon S3 Bucket with Java or Python (SDK)](video-analyzing-with-sqs.md)
      + [Analyzing a Video with the AWS Command Line Interface](video-cli-commands.md)
      + [Tutorial: Creating an Amazon Rekognition Lambda Function](stored-video-lambda.md)
      + [Reference: Video Analysis Results Notification](video-notification-payload.md)
      + [Troubleshooting Amazon Rekognition Video](video-troubleshooting.md)
   + [Working with Streaming Videos](streaming-video.md)
      + [Recognizing Faces in a Streaming Video](recognize-faces-in-a-video-stream.md)
      + [Giving Amazon Rekognition Video Access to Your Kinesis Streams](api-streaming-video-roles.md)
      + [Starting Streaming Video Analysis](streaming-video-starting-analysis.md)
      + [Reading Streaming Video Analysis Results](streaming-video-kinesis-output.md)
      + [Reference: Kinesis Face Recognition Record](streaming-video-kinesis-output-reference.md)
         + [InputInformation](streaming-video-kinesis-output-reference-inputinformation.md)
         + [KinesisVideo](streaming-video-kinesis-output-reference-kinesisvideostreams-kinesisvideo.md)
         + [StreamProcessorInformation](streaming-video-kinesis-output-reference-streamprocessorinformation.md)
         + [FaceSearchResponse](streaming-video-kinesis-output-reference-facesearchresponse.md)
         + [DetectedFace](streaming-video-kinesis-output-reference-detectedface.md)
         + [MatchedFace](streaming-video-kinesis-output-reference-facematch.md)
      + [Troubleshooting Streaming Video](streaming-video-troubleshooting.md)
   + [Error Handling](error-handling.md)
   + [Using Amazon Rekognition as a FedRAMP Authorized Service](fedramp.md)
+ [Best Practices for Sensors, Input Images, and Videos](best-practices.md)
   + [Amazon Rekognition Image Operation Latency](operation-latency.md)
   + [Recommendations for Facial Comparison Input Images](recommendations-facial-input-images.md)
   + [Recommendations for Camera Set-Up (Image and Video)](recommendations-camera-image-video.md)
   + [Recommendations for Camera Setup (Stored and Streaming Video)](recommendations-camera-stored-streaming-video.md)
   + [Recommendations for Camera Set-Up (Streaming Video)](recommendations-camera-streaming-video.md)
+ [Detecting Objects and Scenes](labels.md)
   + [Detecting Labels in an Image](labels-detect-labels-image.md)
   + [Detecting Labels in a Video](labels-detecting-labels-video.md)
   + [Detecting Custom Labels](labels-detecting-custom-labels.md)
+ [Detecting and Analyzing Faces](faces.md)
   + [Overview of Face Detection and Face Comparison](face-feature-differences.md)
   + [Guidelines on Face Attributes](guidance-face-attributes.md)
   + [Detecting Faces in an Image](faces-detect-images.md)
   + [Comparing Faces in Images](faces-comparefaces.md)
   + [Detecting Faces in a Stored Video](faces-sqs-video.md)
+ [Searching Faces in a Collection](collections.md)
   + [Use Cases that Involve Public Safety](considerations-public-safety-use-cases.md)
   + [Creating a Collection](create-collection-procedure.md)
   + [Listing Collections](list-collection-procedure.md)
   + [Describing a Collection](describe-collection-procedure.md)
   + [Deleting a Collection](delete-collection-procedure.md)
   + [Adding Faces to a Collection](add-faces-to-collection-procedure.md)
   + [Listing Faces in a Collection](list-faces-in-collection-procedure.md)
   + [Deleting Faces from a Collection](delete-faces-procedure.md)
   + [Searching for a Face Using Its Face ID](search-face-with-id-procedure.md)
   + [Searching for a Face Using an Image](search-face-with-image-procedure.md)
   + [Searching Stored Videos for Faces](procedure-person-search-videos.md)
+ [People Pathing](persons.md)
+ [Recognizing Celebrities](celebrities.md)
   + [Celebrity Recognition Compared to Face Search](celebrity-recognition-vs-face-search.md)
   + [Recognizing Celebrities in an Image](celebrities-procedure-image.md)
   + [Recognizing Celebrities in a Stored Video](celebrities-video-sqs.md)
   + [Getting Information About a Celebrity](get-celebrity-info-procedure.md)
+ [Detecting Unsafe Content](moderation.md)
   + [Detecting Unsafe Images](procedure-moderate-images.md)
   + [Detecting Unsafe Stored Videos](procedure-moderate-videos.md)
   + [Reviewing Unsafe Content with Amazon Augmented AI](a2i-rekognition.md)
+ [Detecting Text](text-detection.md)
   + [Detecting Text in an Image](text-detecting-text-procedure.md)
   + [Detecting Text in a Stored Video](text-detecting-video-procedure.md)
+ [Amazon Rekognition Security](security.md)
   + [Identity and Access Management for Amazon Rekognition](security-iam.md)
      + [How Amazon Rekognition Works with IAM](security_iam_service-with-iam.md)
      + [Amazon Rekognition Identity-Based Policy Examples](security_iam_id-based-policy-examples.md)
      + [Troubleshooting Amazon Rekognition Identity and Access](security_iam_troubleshoot.md)
   + [Data Protection in Amazon Rekognition](data-protection.md)
      + [Data Encryption](security-data-encryption.md)
      + [Internetwork Traffic Privacy](security-inter-network-privacy.md)
   + [Monitoring Rekognition](rekognition-monitoring.md)
      + [CloudWatch Metrics for Rekognition](cloudwatch-metricsdim.md)
   + [Logging Amazon Rekognition API Calls with AWS CloudTrail](logging-using-cloudtrail.md)
   + [Using Amazon Rekognition with Amazon VPC Endpoints](vpc.md)
   + [Compliance Validation for Amazon Rekognition](rekognition-compliance.md)
   + [Resilience in Amazon Rekognition](disaster-recovery-resiliency.md)
   + [Configuration and Vulnerability Analysis in Amazon Rekognition](vulnerability-analysis-and-management.md)
   + [Infrastructure Security in Amazon Rekognition](infrastructure-security.md)
+ [API Reference](API_Reference.md)
   + [Actions](API_Operations.md)
      + [CompareFaces](API_CompareFaces.md)
      + [CreateCollection](API_CreateCollection.md)
      + [CreateProject](API_CreateProject.md)
      + [CreateProjectVersion](API_CreateProjectVersion.md)
      + [CreateStreamProcessor](API_CreateStreamProcessor.md)
      + [DeleteCollection](API_DeleteCollection.md)
      + [DeleteFaces](API_DeleteFaces.md)
      + [DeleteProject](API_DeleteProject.md)
      + [DeleteProjectVersion](API_DeleteProjectVersion.md)
      + [DeleteStreamProcessor](API_DeleteStreamProcessor.md)
      + [DescribeCollection](API_DescribeCollection.md)
      + [DescribeProjects](API_DescribeProjects.md)
      + [DescribeProjectVersions](API_DescribeProjectVersions.md)
      + [DescribeStreamProcessor](API_DescribeStreamProcessor.md)
      + [DetectCustomLabels](API_DetectCustomLabels.md)
      + [DetectFaces](API_DetectFaces.md)
      + [DetectLabels](API_DetectLabels.md)
      + [DetectModerationLabels](API_DetectModerationLabels.md)
      + [DetectText](API_DetectText.md)
      + [GetCelebrityInfo](API_GetCelebrityInfo.md)
      + [GetCelebrityRecognition](API_GetCelebrityRecognition.md)
      + [GetContentModeration](API_GetContentModeration.md)
      + [GetFaceDetection](API_GetFaceDetection.md)
      + [GetFaceSearch](API_GetFaceSearch.md)
      + [GetLabelDetection](API_GetLabelDetection.md)
      + [GetPersonTracking](API_GetPersonTracking.md)
      + [GetTextDetection](API_GetTextDetection.md)
      + [IndexFaces](API_IndexFaces.md)
      + [ListCollections](API_ListCollections.md)
      + [ListFaces](API_ListFaces.md)
      + [ListStreamProcessors](API_ListStreamProcessors.md)
      + [RecognizeCelebrities](API_RecognizeCelebrities.md)
      + [SearchFaces](API_SearchFaces.md)
      + [SearchFacesByImage](API_SearchFacesByImage.md)
      + [StartCelebrityRecognition](API_StartCelebrityRecognition.md)
      + [StartContentModeration](API_StartContentModeration.md)
      + [StartFaceDetection](API_StartFaceDetection.md)
      + [StartFaceSearch](API_StartFaceSearch.md)
      + [StartLabelDetection](API_StartLabelDetection.md)
      + [StartPersonTracking](API_StartPersonTracking.md)
      + [StartProjectVersion](API_StartProjectVersion.md)
      + [StartStreamProcessor](API_StartStreamProcessor.md)
      + [StartTextDetection](API_StartTextDetection.md)
      + [StopProjectVersion](API_StopProjectVersion.md)
      + [StopStreamProcessor](API_StopStreamProcessor.md)
   + [Data Types](API_Types.md)
      + [AgeRange](API_AgeRange.md)
      + [Asset](API_Asset.md)
      + [Beard](API_Beard.md)
      + [BoundingBox](API_BoundingBox.md)
      + [Celebrity](API_Celebrity.md)
      + [CelebrityDetail](API_CelebrityDetail.md)
      + [CelebrityRecognition](API_CelebrityRecognition.md)
      + [ComparedFace](API_ComparedFace.md)
      + [ComparedSourceImageFace](API_ComparedSourceImageFace.md)
      + [CompareFacesMatch](API_CompareFacesMatch.md)
      + [ContentModerationDetection](API_ContentModerationDetection.md)
      + [CustomLabel](API_CustomLabel.md)
      + [DetectionFilter](API_DetectionFilter.md)
      + [DetectTextFilters](API_DetectTextFilters.md)
      + [Emotion](API_Emotion.md)
      + [EvaluationResult](API_EvaluationResult.md)
      + [Eyeglasses](API_Eyeglasses.md)
      + [EyeOpen](API_EyeOpen.md)
      + [Face](API_Face.md)
      + [FaceDetail](API_FaceDetail.md)
      + [FaceDetection](API_FaceDetection.md)
      + [FaceMatch](API_FaceMatch.md)
      + [FaceRecord](API_FaceRecord.md)
      + [FaceSearchSettings](API_FaceSearchSettings.md)
      + [Gender](API_Gender.md)
      + [Geometry](API_Geometry.md)
      + [GroundTruthManifest](API_GroundTruthManifest.md)
      + [HumanLoopActivationOutput](API_HumanLoopActivationOutput.md)
      + [HumanLoopConfig](API_HumanLoopConfig.md)
      + [HumanLoopDataAttributes](API_HumanLoopDataAttributes.md)
      + [Image](API_Image.md)
      + [ImageQuality](API_ImageQuality.md)
      + [Instance](API_Instance.md)
      + [KinesisDataStream](API_KinesisDataStream.md)
      + [KinesisVideoStream](API_KinesisVideoStream.md)
      + [Label](API_Label.md)
      + [LabelDetection](API_LabelDetection.md)
      + [Landmark](API_Landmark.md)
      + [ModerationLabel](API_ModerationLabel.md)
      + [MouthOpen](API_MouthOpen.md)
      + [Mustache](API_Mustache.md)
      + [NotificationChannel](API_NotificationChannel.md)
      + [OutputConfig](API_OutputConfig.md)
      + [Parent](API_Parent.md)
      + [PersonDetail](API_PersonDetail.md)
      + [PersonDetection](API_PersonDetection.md)
      + [PersonMatch](API_PersonMatch.md)
      + [Point](API_Point.md)
      + [Pose](API_Pose.md)
      + [ProjectDescription](API_ProjectDescription.md)
      + [ProjectVersionDescription](API_ProjectVersionDescription.md)
      + [RegionOfInterest](API_RegionOfInterest.md)
      + [S3Object](API_S3Object.md)
      + [Smile](API_Smile.md)
      + [StartTextDetectionFilters](API_StartTextDetectionFilters.md)
      + [StreamProcessor](API_StreamProcessor.md)
      + [StreamProcessorInput](API_StreamProcessorInput.md)
      + [StreamProcessorOutput](API_StreamProcessorOutput.md)
      + [StreamProcessorSettings](API_StreamProcessorSettings.md)
      + [Summary](API_Summary.md)
      + [Sunglasses](API_Sunglasses.md)
      + [TestingData](API_TestingData.md)
      + [TestingDataResult](API_TestingDataResult.md)
      + [TextDetection](API_TextDetection.md)
      + [TextDetectionResult](API_TextDetectionResult.md)
      + [TrainingData](API_TrainingData.md)
      + [TrainingDataResult](API_TrainingDataResult.md)
      + [UnindexedFace](API_UnindexedFace.md)
      + [Video](API_Video.md)
      + [VideoMetadata](API_VideoMetadata.md)
+ [Limits in Amazon Rekognition](limits.md)
+ [Document History for Amazon Rekognition](document-history.md)
+ [AWS Glossary](glossary.md)
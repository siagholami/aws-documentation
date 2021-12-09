# Document History for Amazon Rekognition<a name="document-history"></a>

The following table describes important changes in each release of the *Amazon Rekognition Developer Guide*\. For notification about updates to this documentation, you can subscribe to an RSS feed\. 
+ **Latest documentation update:** March 3rd, 2020

| Change | Description | Date | 
| --- |--- |--- |
| [Amazon Rekognition now supports Amazon VPC endpoint policies](#document-history) | By specifying a policy you can restrict access to an Amazon Rekognition Amazon VPC endpoint\.  | March 3, 2020 | 
| [Amazon Rekognition now supports Augmented AI \(Preview\) and Amazon Rekognition Customs Labels](#document-history) | With Amazon Rekognition Custom Labels you can detect specialized objects, scenes, and concepts in images by creating your own machine learning model\. DetectModerationLabels now supports Amazon Augmented AI \(Preview\)\.  | December 3, 2019 | 
| [Amazon Rekognition now supports AWS PrivateLink](#document-history) | With AWS PrivateLink you can establish a private connection between your VPC and Amazon Rekognition\.  | September 12, 2019 | 
| [Amazon Rekognition face filtering](#document-history) | Amazon Rekognition adds enhanced face filtering support to the IndexFaces API operation, and introduces face filtering for the CompareFaces and SearchFacesByImage API operations\.  | September 12, 2019 | 
| [Amazon Rekognition Video examples updated](#document-history) | Amazon Rekognition Video example code updated to create and configure the Amazon SNS topic and Amazon SQS queue\.  | September 5, 2019 | 
| [Ruby and Node\.js examples added](#document-history) | Amazon Rekognition Image Ruby and Node\.js examples added for synchronous label and face detection\.  | August 19, 2019 | 
| [Unsafe content detection updated](#document-history) | Amazon Rekognition unsafe content detection can now detect violent content\.  | August 9, 2019 | 
| [GetContentModeration operation updated](#document-history) | GetContentModeration now returns the version of the moderation detection model used to detect unsafe content\.  | February 13, 2019 | 
| [GetLabelDetection and DetectModerationLabels operations updated](#document-history) | GetLabelDetection now returns bounding box information for common objects and a hierarchical taxonomy of detected labels\. The version of the model used for label detection is now returned\. DetectModerationLabels now returns the version of the model used for detecting unsafe content\.  | January 17, 2019 | 
| [DetectFaces and IndexFaces operation updated](#document-history) | This release updates the DetectFaces and IndexFaces operation\. When the Attributes input parameter is set to ALL, the face location landmarks includes 5 new landmarks: upperJawlineLeft, midJawlineLeft, chinBottom, midJawlineRight, upperJawlineRight\.  | November 19, 2018 | 
| [DetectLabels operation updated](#document-history) | Bounding boxes are now returned for certain objects\. A hierarchical taxonomy is now available for labels\. You can now get the version of the detection model used for detection\. | November 1, 2018 | 
| [IndexFaces operation updated](#document-history) | With IndexFaces you can now use the QualityFilter input parameter to filter out faces detected with low quality\. You can also use the MaxFaces input parameter to reduce the number of faces returned based on the quality of the face detection, and the size of the detected face\.  | September 18, 2018 | 
| [DescribeCollection operation added](#document-history) | You can now get information about an existing collection by calling the DescribeCollection operation\.  | August 22, 2018 | 
| [New Python examples](#document-history) | Python examples have been added to the Amazon Rekognition Video content along with some content reorganization\.  | June 26, 2018 | 
| [Updated content layout](#document-history) | The Amazon Rekognition Image content has been reorganized along with new Python and C\# examples\.  | May 29, 2018 | 
| [Amazon Rekognition supports AWS CloudTrail](#document-history) | Amazon Rekognition is integrated with AWS CloudTrail, a service that provides a record of actions taken by a user, role, or an AWS service in Amazon Rekognition\. For more information, see [Logging Amazon Rekognition API Calls with AWS CloudTrail](https://docs.aws.amazon.com/rekognition/latest/dg/logging-using-cloudtrail.html)\.  | April 6, 2018 | 
| [Analyze stored and streaming videos\. New table of contents](#document-history) | For information about analyzing stored videos, see [Working with Stored Videos](https://docs.aws.amazon.com/rekognition/latest/dg/video.html)\. For information about analyzing streaming videos, see [Working with Streaming Videos](https://docs.aws.amazon.com/rekognition/latest/dg/streaming-video.html)\. The table of contents for the Amazon Rekognition documentation has been rearranged to accomodate image and video operations\.  | November 29, 2017 | 
| [Text in Image and Face Detection Models](#document-history) | Amazon Rekognition can now detect text in images\. For more information, see [Detecting Text](https://docs.aws.amazon.com/rekognition/latest/dg/text-detection.html)\. Amazon Rekognition introduces versioning for the face detection deep learning model\. For more information, see [Model Versioning](https://docs.aws.amazon.com/rekognition/latest/dg/face-detection-model.html)\. | November 21, 2017 | 
| [Celebrity Recognition](#document-history) | Amazon Rekognition can now analyze images for celebrities\. For more information, see [Recognizing Celebrities](https://docs.aws.amazon.com/rekognition/latest/dg/celebrities.html)\. | June 8, 2017 | 
| [Image Moderation](#document-history) | Amazon Rekognition can now determine if an image contains explicit or suggestive adult content\. For more information, see [Detecting Unsafe Content](https://docs.aws.amazon.com/rekognition/latest/dg/moderation.html)\. | April 19, 2017 | 
| [Age Range for Detected Faces\. Aggregated Rekognition Metrics Pane](#document-history) | Amazon Rekognition now returns the estimated age range, in years, for faces detected by the Rekognition API\. For more information, see [AgeRange](https://docs.aws.amazon.com/rekognition/latest/dg/API_AgeRange.html)\. The Rekognition console now has a metrics pane showing activity graphs for an aggregate of Amazon CloudWatch metrics for Rekognition over a specified period of time\. For more information, see [Exercise 4: See Aggregated Metrics \(Console\)](https://docs.aws.amazon.com/rekognition/latest/dg/aggregated-metrics.html)\. | February 9, 2017 | 
| [New service and guide](#document-history) | This is the initial release of the image analysis service, Amazon Rekognition, and the *Amazon Rekognition Developer Guide*\. | November 30, 2016 | 
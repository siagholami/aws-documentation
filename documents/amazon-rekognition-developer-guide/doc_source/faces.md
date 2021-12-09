# Detecting and Analyzing Faces<a name="faces"></a>

Amazon Rekognition can detect faces in images and videos\. This section covers non\-storage operations for analyzing faces\. With Amazon Rekognition, you can get information about where faces are detected in an image or video, facial landmarks such as the position of eyes, and detected emotions \(for example, appearing happy or sad\)\. You can also compare a face in an image with faces detected in another image\. 

When you provide an image that contains a face, Amazon Rekognition detects the face in the image, analyzes the facial attributes of the face, and then returns a percent confidence score for the face and the facial attributes that are detected in the image\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/dg/images/sample-detect-faces.png)

This section provides examples for both image and video facial analysis\. For more information about using the Amazon Rekognition API, see [Working with Images](images.md) and [Working with Stored Videos](video.md)\.

**Note**  
The face detection models used by Amazon Rekognition Image and Amazon Rekognition Video don't support the detection of faces in cartoon/animated characters or non\-human entities\. If you want to detect cartoon characters in images or videos, we recommend using Amazon Rekognition Custom Labels\. For more information, see the [Amazon Rekognition Custom Labels Developer Guide](https://docs.aws.amazon.com/rekognition/latest/customlabels-dg/what-is.html)\.

You can use storage operations to save facial metadata for faces detected in an image\. Later you can search for stored faces in both images and videos\. For example, this enables searching for a specific person in a video\. For more information, see [Searching Faces in a Collection](collections.md)\.

**Topics**
+ [Overview of Face Detection and Face Comparison](face-feature-differences.md)
+ [Guidelines on Face Attributes](guidance-face-attributes.md)
+ [Detecting Faces in an Image](faces-detect-images.md)
+ [Comparing Faces in Images](faces-comparefaces.md)
+ [Detecting Faces in a Stored Video](faces-sqs-video.md)
# Choosing to Use Amazon Rekognition Custom Labels<a name="wi-choosing"></a>

You can use Amazon Rekognition Custom Labels to find objects, scenes, and concepts in images by using a machine learning model that you create\. 

**Note**  
Amazon Rekognition Custom Labels is not designed for analyzing faces, detecting text, or finding unsafe image content in images\. To perform these tasks, you can use Amazon Rekognition Image\. For more information, see [What Is Amazon Rekognition](https://docs.aws.amazon.com/rekognition/latest/dg/what-is.html)\.

## Amazon Rekognition Label Detection<a name="wi-label-detection"></a>

Customers across media and entertainment, advertising and marketing, industrial, agricultural, and other segments need to identify, classify, and search for important objects, scenes, and other concepts in their images and videos—at scale\. Amazon Rekognition's label detection feature makes it fast and easy to detect thousands of common objects \(such as cars and trucks, corn and tomatoes, and basketballs and soccer balls\) within images and video by using computer vision and machine learning technologies\. 

However, you can't find specialized objects using Amazon Rekognition label detection\. For example, sports leagues want to identify team logos on player jerseys and helmets during game footage, media networks would like to detect specific sponsor logos to report on advertiser coverage, manufacturers need to distinguish between specific machine parts or products in an assembly line to monitor quality, and other customers want to identify cartoon characters in a media library, or locate products of a specific brand on retail shelves\. Amazon Rekognition labels don't help you detect these specialized objects\. 

## Amazon Rekognition Custom Labels<a name="wi-custom-labels"></a>

You can use Amazon Rekognition Custom Labels to find objects and scenes that are unique to your business needs\. Amazon Rekognition Custom Labels supports use cases such as logos, objects, and scenes\. You can use it to perform image classification \(image level predictions\) or detection \(object/bounding box level predictions\)\. 

For example, while you can find plants and leaves by using Amazon Rekognition label detection, you need Amazon Rekognition Custom Labels to distinguish between healthy, damaged, and infected plants\. Similarly, Amazon Rekognition label detection can identify images with machine parts\. However, to identify specific machine parts such as a *turbocharger* or a *torque converter*, you need to use Amazon Rekognition Custom Labels\. The following are examples of how you can use Amazon Rekognition Custom Labels\. 
+ Detect logos
+ Find animation characters
+ Find your products
+ Identify machine parts
+ Classify agricultural produce quality \(such as rotten, ripe, or raw\)
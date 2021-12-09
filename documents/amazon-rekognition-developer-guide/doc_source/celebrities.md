# Recognizing Celebrities<a name="celebrities"></a>

Amazon Rekognition can recognize thousands of celebrities in a wide range of categories, such as entertainment and media, sports, business, and politics\. With Amazon Rekognition, you can recognize celebrities in images and in stored videos\. You can also get additional information for recognized celebrities\.

The Amazon Rekognition celebrity recognition API is tuned to detect celebrities in different settings, cosmetic makeup, and other conditions\. Social, media, and entertainment customers can build apps that use celebrity recognition\. For example, an entertainment app that identifies celebrity lookalikes or an app that identifies celebrities as part of automated footage tagging\. Amazon Rekognition celebrity recognition is designed to be exclusively used in cases where you expect there may be a known celebrity in an image or a video\. The celebrity recognition API returns the closest found matches, along with a similarity score\. For information about recognizing faces that are not celebrities, see [Searching Faces in a Collection](collections.md)\.

**Note**  
If you are a celebrity and don’t want to be included in this feature, contact [AWS Support](https://aws.amazon.com/contact-us/) or email rekognition\-celebrity\-opt\-out@amazon\.com\.

**Topics**
+ [Celebrity Recognition Compared to Face Search](celebrity-recognition-vs-face-search.md)
+ [Recognizing Celebrities in an Image](celebrities-procedure-image.md)
+ [Recognizing Celebrities in a Stored Video](celebrities-video-sqs.md)
+ [Getting Information About a Celebrity](get-celebrity-info-procedure.md)
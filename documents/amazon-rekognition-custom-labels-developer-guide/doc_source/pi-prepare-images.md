# Preparing Images<a name="pi-prepare-images"></a>

 The images you use to train a model contain the object, scenes, or concepts that you want Amazon Rekognition Custom Labels to find\. 

The content of images should be in a variety of backgrounds and lighting that represent the images that you want the trained model to identify\. Each image needs an assigned label \(or labels\) that identifies the objects, scenes, or concepts in the image\. Images with objects also need bounding boxes\. 

This section provides information about the images you use to train and test a model\.

## Image Format<a name="pi-image-format"></a>

You can train Amazon Rekognition Custom Labels models with images that are in PNG and in JPEG format\. Similarly, to detect custom labels using `DetectCustomLabels`, you need images that are in PNG and JPEG format\.

## Input Image Recommendations<a name="pi-image-recommendations"></a>

### <a name="pi-images-recommmendations"></a>

Amazon Rekognition Custom Labels requires images to train and test your model\. To prepare your images, consider following:
+ Choose a specific domain for the model you want to create\. For example, you could choose a model for scenic views and another model for objects such as machine parts\. Amazon Rekognition Custom Labels works best if your images are in the chosen domain\.
+ Use at least 10 images to train your model\.
+ Images must be in PNG or JPEG format\.
+ Use images that show the object in a variety of lightings, backgrounds, and resolutions\.
+ Training and testing images should be similar to the images that you want to use the model with\. 
+ Decide what labels to assign to the images\. For more information, see [Assigning Image\-Level Labels to an Image](rv-assign-labels.md)\.
+ Ensure that images are sufficiently large in terms of resolution\. For more information, see [Limits in Amazon Rekognition Custom Labels](limits.md)\.
+ Ensure that occlusions don't obscure objects that you want to detect\.
+ Use images that have sufficient contrast with the background\. 
+ Use images that are bright and sharp\. Avoid using images that may be blurry due to subject and camera motion as much as possible\.
+ Use an image where the object occupies a large proportion of the image\.

## Image Set Size<a name="pi-set-size"></a>

Amazon Rekognition Custom Labels uses a set of images to train a model\. At a minimum, you should use at least 10 images for training\. Amazon Rekognition Custom Labels stores training and testing images in datasets\. For more information, see [Creating an Amazon Rekognition Custom Labels Dataset](cd-create-dataset.md)\.
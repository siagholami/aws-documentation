# Assigning Image\-Level Labels to an Image<a name="rv-assign-labels"></a>

To train an Amazon Rekognition Custom Labels model, your images need to be labeled\. A label indicates that an image contains an object, scene or concept\.

A dataset needs at least two labels defined\. Each image needs at least one assigned label that identifies the object, scene, or concept in the image\. 

You can apply labels to an image as a whole\. These are known as image\-level labels\. They are useful for identifying scenes or concepts that you want to detect\. For example, the following image shows the Columbia river\. To train a model to detect rivers, you would add a 'river' label that applies to the entire image\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/pateros.png)

Images that contain objects that you want to detect require labels so that they can be assigned to the object's bounding box\. For information about creating bounding boxes, see [Drawing Bounding Boxes](rv-bounding-box.md)\.

**To assign labels to an image \(console\)**

1. Open the Amazon Rekognition console at [https://console\.aws\.amazon\.com/rekognition/](https://console.aws.amazon.com/rekognition/)\.

1. Choose **Use Custom Labels**\.

1. Choose **Get started**\. 

1. In the left navigation pane, choose the project that contains the dataset you want to use\.

1. In the **Datasets** section, choose the dataset that you want to use\.

1. In the dataset gallery page, choose **Start labeling** to enter labeling mode\.

1. Select one or more images that you want to add labels to\. You can only select images on a single page at a time\. To select the images between a first and second image on a page:

   1. Select the first image\.

   1. Press and hold the shift key\.

   1. Select the second image\. The images between the first and second image are also selected\. 

   1. Release the shift key\.

1. Choose **Assign Labels**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/select-image.png)

1. In **Assign a label to selected images** dialog box, select a label that you want to assign to the image or images\.

1. Choose **Assign** to assign label to the image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/assign-river.png)

1. Repeat labeling until every image is annotated with the required labels\.
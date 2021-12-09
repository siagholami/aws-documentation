# Drawing Bounding Boxes<a name="rv-bounding-box"></a>

Labels can be applied to areas of an image that contain an object that you want to detect\. For example, if your model detect Amazon Echo devices, it needs to identify the types of Echo Devices that are in an image\. To do this, the model needs information about where the devices are in the image, and a corresponding label that identifies the type of the device\. This is known as localization information\. The location of the device is expressed as a bounding box, which is a box that tightly surrounds an object\. The following image shows a bounding box surrounding an Amazon Echo Dot\. The image also contains an Amazon Echo without a bounding box\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/dot.png)

The accuracy of your model is affected by the accuracy of the bounding boxes\. Try to draw them as closes as possible to the object\.

Amazon Rekognition Custom Labels can detect logos and animated characters\. The testing images must contain bounding boxes around the logo or animated character\. 

Before you can add bounding boxes, you must add at least 2 labels to the dataset\. For more information, see [Editing Labels](rv-editing-labels.md)\.

**To draw a bounding box and assign a label \(console\)**

1. Open the Amazon Rekognition console at [https://console\.aws\.amazon\.com/rekognition/](https://console.aws.amazon.com/rekognition/)\.

1. Choose **Use Custom Labels**\.

1. Choose **Get started**\. 

1. In the left navigation pane, choose the project that contains the dataset that you want to use\.

1. In the **Datasets** section, choose the dataset that you want to use\.

1. In the dataset gallery page, choose **Start labeling** to enter labeling mode\.

1. Choose the images that you want to add bounding boxes to\.

1. Choose **Draw bounding box**\. A series of tips are shown before the bounding box editor is displayed\.

1. In the **Labels** pane on the right, select the label that you want to assign to a bounding box\.

1. In the drawing tool, place the pointer at the top\-left area of the desired object\.

1. Press the left mouse button and draw a box around the object\. Try to draw the bounding box as close as possible to the object\. 

1. Release the mouse button and the bounding box is highlighted\.

1. Click **Next** if you have more images to label\. Otherwise, choose **Done** to finish labeling\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/draw-bounding-box.png)

1. Repeat steps 7–11 until you have created a bounding box in each image that contains objects\. 

1. Choose **Save changes** to save your changes\. 

1. Choose **Exit** to exit labeling mode\.
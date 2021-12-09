# Step 5: Identify Scenes and Concepts with Image\-Level Labels<a name="gs-add-image-labels"></a>

To train your model, Amazon Rekognition Custom Labels requires the images in a dataset to be labeled with information about the object, scenes, and concepts in your images\. 

If your image represents a scene or concept, such as a wedding or sport, the image as a whole needs an identifying image\-level label\. For example, to train a model to detect scenic views with rivers, the labels for the following image might be *river*\. An image needs at least one label\. You can add others so that the model can detect different classes of information—for example, *countryside* or *sky*\. In this step, you add image\-level labels to an image\. 

 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/pateros.png)

**Note**  
If you are training your model to detect scenes or concepts, you don't need to do the next step, [Step 6: Identify Objects with Bounding Boxes](gs-draw-bounding-boxes.md)\. Similarly, if you're training a model to detect objects, you don't need to do this step\.

**To assign image\-level labels to images**

1. In the dataset gallery, select one or more images that you want to add labels to\. You can only select images on a single page at a time\. To select the images between a first and second image on a page:

   1. Select the first image\.

   1. Press and hold the shift key\.

   1. Select the second image\. The images between the first and second image are also selected\. 

   1. Release the shift key\.

1. Choose **Assign labels**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/select-image.png)

1. In the **Assign a label to selected images** dialog box, choose a label that you want to assign to the image or images\.

1. Choose **Assign** to assign the label to the image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/assign-river.png)

1. Repeat labeling until every image is assigned the required labels\.

1. Choose **Save changes** to save your changes\.
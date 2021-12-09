# Step 3: Create a Dataset<a name="gs-step-create-dataset"></a>

In this step, you create a training [Dataset](ud-terminology.md#ud-dataset) that holds your images and the label data needed to train your model\. You add images to the dataset using images that you upload from your computer\. You can also add images and label data to a dataset in other ways\. For more information, see [Creating an Amazon Rekognition Custom Labels Dataset](cd-create-dataset.md)\. Later, you create another dataset to test your model by splitting your training dataset\. For information about other ways that you can create a testing dataset, see [Training an Amazon Rekognition Custom Labels Model](tm-train-model.md)\.

For more information about the workflow for creating and managing a dataset, see [Managing a Dataset](cd-managing-datasets.md)\.

To ensure that Amazon Rekognition Custom Labels chooses the best algorithm to train your model, we recommend that you use domain\-specific datasets\. For example, create a dataset specifically for detecting scenic views, and use another dataset for a model that detects company logos\. 

The images you upload won't have labels associated with them\. You add them in subsequent steps\.<a name="gs-create-dataset-procedure"></a>

**To create a training dataset \(console\)**

1. In the **Datasets** section of the project page, choose **Create dataset**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/project-resources.png)

1. On the **Create Dataset** details page, enter a name for your dataset\.

1. Choose **Upload images from your computer\. **

1. Choose **Submit**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/create-dataset.png)

1. A **Tool Guide** is shown\. Choose **Next** to read each page\. After you have finished reading, the dataset gallery is shown\. The gallery is placed in labeling mode so that you can add your images\. 

1. Choose **\+ Add Images**\. The **Add images** dialog box is shown\.

1. Drag and drop your image onto the dialog box, or choose **Choose files** to select the images from your computer\. 

    You can load up to 30 images at a time\.

1. Choose **Add images**\. The images are uploaded, and the dataset is created\. You should see the dataset gallery page\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/add-images-from-computer.png)

1. If you need to add more images, do steps 6\-8 until all of your images are added\. 
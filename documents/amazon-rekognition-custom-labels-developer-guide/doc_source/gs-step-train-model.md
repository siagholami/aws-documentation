# Step 7: Train Your Model<a name="gs-step-train-model"></a>

To train the model, you use the dataset that you created in [Step 3: Create a Dataset](gs-step-create-dataset.md)\. You also need a dataset to test the model\. In this step, you create a testing dataset by splitting the training dataset\. You can also choose to create a new dataset or use an existing dataset for training\. The original dataset remains unchanged\. For more information, see [Training an Amazon Rekognition Custom Labels Model](tm-train-model.md)\.

A new version of a model is created every time the model is trained\. Amazon Rekognition Custom Labels creates a name for the model that is a combination of the project name and the timestamp for when the model is created\. 

**Note**  
You are charged for the amount of time that it takes to train a model\. For more information, see [Training hours](https://aws.amazon.com/rekognition/pricing/#Amazon_Rekognition_Custom_Labels_pricing)\. 

**To a train a model \(console\)**

1. In the dataset gallery, choose **Train Model** and the **Train model** page is displayed\. 

1. In **Training details**, do the following:

   1. In **Choose project**, choose the project that you created earlier\.

   1. In **Choose training set**, choose the training dataset that you previously created\.

   1. In **Create test set**, choose **Split training dataset**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/train-model.png)

1. Choose **Train** to start training the model\. The project resources page is shown\.

1. Wait until training has finished\. You can check the current status in the **Status** field of the **Model** section\.
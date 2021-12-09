# Training an Amazon Rekognition Custom Labels Model<a name="tm-train-model"></a>

Training a model requires labeled images and algorithms to train the model\. Amazon Rekognition Custom Labels simplifies this process by choosing the algorithm for you\. Accurately labeled images are very important to the process because they influence the algorithm that is chosen to train the model\. After training a model, you can evaluate its performance\. For more information, see [Evaluating a Trained Amazon Rekognition Custom Labels Model](tr-train-results.md)\.

Training requires two datasets\. A training dataset that's used to train the model\. A testing dataset that's used to verify how well the trained model predicts the correct custom labels\. The testing dataset also helps determine the algorithm used for training\. The images in the testing dataset shouldn't be images that were previously used for training\. They should include the objects, scenes, and concepts that the model is trained to analyze\. You can provide a testing dataset in the following ways\.
+ Use an existing Amazon Rekognition Custom Labels dataset\. 
+ Create a new dataset\. For more information, see [Creating an Amazon Rekognition Custom Labels Dataset](cd-create-dataset.md)\. 
+ Split your training dataset\. You can use 20% of your training dataset to create a test dataset\. The images chosen are a representative sampling and aren't used in the training dataset\. We recommend splitting your training dataset only if you don't have an alternative dataset that you can use\. Splitting a training dataset reduces the number of images available for training\. 

You can train a model by using the Amazon Rekognition Custom Labels console, or by the Amazon Rekognition Custom Labels API\.

**Note**  
You are charged for the amount of time that it takes to successfully train a model\. Typically training takes from 30 minutes to 24 hours to complete\. For more information, see [Training hours](https://aws.amazon.com/rekognition/pricing/#Amazon_Rekognition_Custom_Labels_pricing)\. 

**Topics**
+ [Training a Model \(Console\)](tm-console.md)
+ [Training a Model \(SDK\)](tm-sdk.md)
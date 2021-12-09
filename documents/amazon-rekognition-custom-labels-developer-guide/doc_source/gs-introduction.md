# Getting Started with Amazon Rekognition Custom Labels<a name="gs-introduction"></a>

The Getting Started instructions show you how to create, train, evaluate, and use a model that detects objects, scenes, and concepts in images\. The general workflow is as follows: 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/overview.png)

To prepare, evaluate, train, and use the model to analyze images, you do the following\.

## Prepare your Images<a name="ud-general-images"></a>

Collect the images that contain the objects, scenes, and concepts that are specific to your business needs\. For example, you can find your logo in social media posts, identify your products on store shelves, classify machine parts in an assembly line, distinguish healthy and infected plants, or detect animated characters in videos\. Later in these Getting Started instructions you label the images so that they can be used to train and test a model\.

## Create a Project<a name="ud-general-project"></a>

Create a project to manage the files used to create a model\. A project is where you manage your model files, train and evaluate your model, and make it ready for use\. The first time you open the Amazon Rekognition Custom Labels console in a supported AWS Region, you are asked to create a bucket to store your project files\. 

## Create a Dataset<a name="ud-general-dataset"></a>

To create a dataset, import labeled or unlabeled images\. A dataset is a set of images and labels that describe those images\. You use datasets to train and test the models you create\. A dataset is stored in the Amazon SageMaker Ground Truth format manifest\. 

You create your dataset by importing the images used to train the model\. You can bring in images from Amazon S3, your local computer, an Amazon SageMaker Ground Truth manifest file, or an already labeled dataset\.

For unlabeled images, you have to annotate the images with the labels you want to train the model with\. This can be at the image level or, for objects within the image, bounding boxes that isolate the object within an image\.

For these Getting Started instructions, you use images loaded from your computer\. The images are unlabeled\. 

## Create a Test Dataset<a name="ud-general-test-dataset"></a>

Train your model by using the training dataset\. Before training your model, you choose the set of images that Amazon Rekognition Custom Labels uses to evaluate your model\. You can create a new test dataset, use an existing test dataset, or split the training dataset that you just created\. For these Getting Started instructions, you split the training dataset\. 

## Train Your Model<a name="ud-general-train-model"></a>

Train your model with the training dataset\. At the start of training, Amazon Rekognition Custom Labels chooses the most suitable algorithm to train the model with\. The model is trained and then tested using the test dataset\. 

## Evaluate Your Model<a name="ud-general-evaluate-model"></a>

Evaluate the performance of your model by using metrics created during testing\. 

Evaluations enable you to understand the performance of your trained model, and decide if you're ready to use it in production\. If improvements are needed, you can add more training data or improve labeling\. 

## Use Your Model<a name="ud-general-use-model"></a>

Start your trained model and use it to detect custom labels in new images\.

## Improve the Performance of Your Model<a name="ud-general-improve-performance"></a>

You can give feedback on the predictions your model makes and use it to make improvements to your model\. For more information, see [Model Feedback Solution](ex-feedback.md)\. 
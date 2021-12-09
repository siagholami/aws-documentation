# What Is Amazon Rekognition Custom Labels?<a name="what-is"></a>

With Amazon Rekognition Custom Labels, you can identify the objects and scenes in images that are specific to your business needs\. For example, you can find your logo in social media posts, identify your products on store shelves, classify machine parts in an assembly line, distinguish healthy and infected plants, or detect animated characters in videos\.

Developing a custom model to analyze images is a significant undertaking that requires time, expertise, and resources\. It often takes months to complete\. Additionally, it can require thousands or tens of thousands of hand\-labeled images to provide the model with enough data to accurately make decisions\. Generating this data can take months to gather, and can require large teams of labelers to prepare it for use in machine learning\.

Amazon Rekognition Custom Labels builds off of Amazon Rekognition’s existing capabilities, which are already trained on tens of millions of images across many categories\. Instead of thousands of images, you can upload a small set of training images \(typically a few hundred images or less\) that are specific to your use case\. You can do this by using the easy\-to\-use console\. If your images are already labeled, Amazon Rekognition Custom Labels can begin training a model in a short time\. If not, you can label the images directly within the labeling interface, or you can use Amazon SageMaker Ground Truth to label them for you\. 

After Amazon Rekognition Custom Labels begins training from your image set, it can produce a custom image analysis model for you in just a few hours\. Behind the scenes, Amazon Rekognition Custom Labels automatically loads and inspects the training data, selects the right machine learning algorithms, trains a model, and provides model performance metrics\. You can then use your custom model through the Amazon Rekognition Custom Labels API and integrate it into your applications\.

## Key Benefits<a name="key-benefits"></a>

**Simplified data labeling**  
The Amazon Rekognition Custom Labels console provides a visual interface to make labeling your images fast and simple\. The interface allows you to apply a label to the entire image\. You can also identify and label specific objects in images using bounding boxes with a click\-and\-drag interface\. Alternately, if you have a large dataset, you can use [Amazon SageMaker Ground Truth](https://aws.amazon.com/sagemaker/groundtruth/) to efficiently label your images at scale\.

**Automated machine learning**  
No machine learning expertise is required to build your custom model\. Amazon Rekognition Custom Labels includes automated machine learning \(AutoML\) capabilities that take care of the machine learning for you\. When the training images are provided, Amazon Rekognition Custom Labels can automatically load and inspect the data, select the right machine learning algorithms, train a model, and provide model performance metrics\.

**Simplified model evaluation, inference, and feedback**  
You evaluate your custom model’s performance on your test set\. For every image in the test set, you can see the side\-by\-side comparison of the model’s prediction vs\. the label assigned\. You can also review detailed performance metrics such as precision, recall, F1 scores, and confidence scores\. You can start using your model immediately for image analysis, or you can iterate and retrain new versions with more images to improve performance\. After you start using your model, you track your predictions, correct any mistakes, and use the feedback data to retrain new model versions and improve performance\.

## Are You a First\-Time Amazon Rekognition Custom Labels User?<a name="first-time-user"></a>

If you're a first\-time user of Amazon Rekognition Custom Labels, we recommend that you read the following sections in order:

1. **[Setting Up Amazon Rekognition Custom Labels](su-set-up.md)** – In this section, you set your account details\.

1. **[Getting Started with Amazon Rekognition Custom Labels](gs-introduction.md)** – In this section, you create your first Amazon Rekognition Custom Labels custom model\.
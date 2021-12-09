# Amazon Rekognition Custom Labels and Machine Learning Terminology<a name="ud-terminology"></a>

The following are common terms used in this documentation\.

**Topics**
+ [Assets](#ud-asset)
+ [Object Detection](#ud-classification-detection)
+ [Confidence Score](#ud-confidence)
+ [Dataset](#ud-dataset)
+ [Evaluation](#ud-evaluate)
+ [Image Label](#ud-image-label)
+ [Bounding Box Label](#ud-localized-label)
+ [Model Performance Metrics](#ud-metric)
+ [Training](#ud-train)
+ [Testing](#ud-testing)

## Assets<a name="ud-asset"></a>

The following are common terms used in this documentation\.

Assets are the images that you use for training and testing an Amazon Rekognition Custom Labels model\. 

## Object Detection<a name="ud-classification-detection"></a>

Object detection detects a known object and its location on an image\. For example, an image might contain several different types of dogs\. A model trained to detect Border Collie dogs is able to detect a Border Collie and its location among the rest of the dogs in the image\. 

To train a model, an image needs to be annotated with a label for the desired object, and the location of the object on the image\. You mark the location of the object by using a bounding box\. A bounding box is a set of coordinates that isolate an object on an image\. 

Amazon Rekognition provides a single API, `DetectCustomLabels`, to get predictions from a model\. The operation returns classification and object detection information in the results of a single call\. For example, the following JSON shows the label name \(class\) and the bounding box \(location\) information for a house\.

```
{
    "CustomLabels": [
       {
          "BoundingBox": {
            "Width": 0.053907789289951324, 
            "Top": 0.08913730084896088, 
            "Left": 0.11085548996925354, 
            "Height": 0.013171200640499592
        },
          "Name: "House",
          "Confidence": 99.56285858154297
       },
    ]
}
```

## Confidence Score<a name="ud-confidence"></a>

Amazon Rekognition Custom Labels helps you train a custom model that makes a prediction about the presence of each custom label \(that you specify during training\) in an image\. For each prediction, the custom model returns a confidence score, which is a number between 0 and 100 that indicates how confident Amazon Rekognition Custom Labels is in the presence of that label \(and the bounding box location of the object\)\. A lower value represents lower confidence\. 

In general, as confidence score increases, the algorithm overall makes more correct predictions, but returns fewer results\. At lower confidence values, the algorithm makes more mistakes, but returns more results\. You can use the confidence score to sort your predictions for an individual label, and set a threshold value that applies to your use case\. 

## Dataset<a name="ud-dataset"></a>

A dataset is a collection of images and associated labels\. For each image in a dataset, one or more associated labels identify objects, scenes, or concepts in the image\. Datasets are used to train and test an Amazon Rekognition Custom Labels model\.

## Evaluation<a name="ud-evaluate"></a>

When a training is complete, Amazon Rekognition Custom Labels uses a test dataset to measure, or evaluate, the quality of the trained model\. The results of evaluation are expressed as metrics that you can use as guidance to further improve the performance of the model\. 

## Image Label<a name="ud-image-label"></a>

An image label specifies whether a scene \(such as a wedding or a beach\), or an object \(such as a dog or a car\), is present in that image\.

## Bounding Box Label<a name="ud-localized-label"></a>

 A bounding box label specifies labels that are localized within an image and are indicated by a specific polygon \(a bounding box with coordinates\)\. Typically, these are physical objects that are well differentiated and easily visible—for example, dogs, cats, tables, or machine parts\. 

## Model Performance Metrics<a name="ud-metric"></a>

Metrics are values that Amazon Rekognition Custom Labels provides after testing\. You use metrics to improve the performance of your model\. 

The Amazon Rekognition Custom Labels console provides metrics for the overall performance of a model and metrics for individual labels\. The Amazon Rekognition Custom Labels console provides metrics for F1 score, precision, and recall\. For more information, see [Metrics for Evaluating Your Model](tr-metrics-use.md)\. The Amazon Rekognition Custom Labels API provides other metrics\. For more information, see [Accessing Amazon Rekognition Custom Labels Training Results \(SDK\)](tr-metrics-api.md)\. 

## Training<a name="ud-train"></a>

Training is the process of creating a model to predict custom labels in images\. Internally, Amazon Rekognition Custom Labels uses machine learning algorithms to train the model using a dataset of training images that you provide\. Model training requires training images that accurately represent the image dataset that you want to make model predictions on\. Every time you train a model, a new version of the model is created\. 

## Testing<a name="ud-testing"></a>

Testing is the process of determining how well a trained model performs on individual labels and images, and as an aggregate\. You test a trained model by using a test dataset of labeled images\. A test dataset should have images that represent the scenarios and environments in which the predictions are required to be made\.
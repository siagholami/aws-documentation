# Improving an Amazon Rekognition Custom Labels Model<a name="tr-improve-model"></a>

The performance of machine learning models is largely dependent on factors such as the complexity and variability of your custom labels \(the specific objects and scenes you are interested in\), the quality and representative power of the training dataset you provide, and the model frameworks and machine learning methods used to train the model\. 

Amazon Rekognition Custom Labels, makes this process simpler, and no machine learning expertise is required\. However, the process of building a good model often involves iterations over data and model improvements to achieve desired performance\. The following is information on how to improve your model\.

## Data<a name="tr-data"></a>

In general, you can improve the quality of your model with larger quantities of better quality data\. Use training images that clearly show the object or scene and aren't cluttered with things you don’t care about\. For bounding boxes around objects, use training images that show the object fully visible and not occluded by other objects\. 

Make sure that your training and test datasets match the type of images that you will eventually run inference on\. For objects, such as logos, where you have just a few training examples, you should provide bounding boxes around the logo in your test images\. These images represent or depict the scenarios in which you want to localize the object\.

## Reducing False Positives \(Better Precision\)<a name="tr-reduce-false-positives"></a>
+ First, check if increasing the confidence threshold lets you keep the correct predictions, while eliminating false positives\. At some point, this has diminishing gains because of the trade\-off between precision and recall for a given model\.
+ You might see one or more of your custom labels of interest \(A\) consistently get confused with the same class of objects \(but not a label that you're interested in\) \(B\)\. To help, add B as an object class label to your training dataset \(along with the images that you got the false positive on\)\. Effectively, you're helping the model learn to predict B and not A through the new training images\.
+ You might find that the model is confused between two of your custom labels \(A and B\)—the test image with label A is predicted as having label B and vice versa\. In this case, first check for mislabeled images in your training and test sets\. Also, adding more training images that reflect this confusion will help a retrained model learn to better discriminate between A and B\.

## Reducing False Negatives \(Better Recall\)<a name="tr-reduce-false-negatives"></a>
+ Lower the confidence threshold to improve recall\.
+ Use better examples to model the variety of both the object and the images in which they appear\.
+ Split your label into two classes that are easier to learn\. For example, instead of good cookies and bad cookies, you might want good cookies, burnt cookies, and broken cookies to help the model learn each unique concept better\. 
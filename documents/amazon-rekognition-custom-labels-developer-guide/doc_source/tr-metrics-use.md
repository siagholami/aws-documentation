# Metrics for Evaluating Your Model<a name="tr-metrics-use"></a>

After your model is trained, Amazon Rekognition Custom Labels returns a number of metrics from model testing that you can use to evaluate the performance of your model\. This topic describes the metrics available to you, and how to understand if your trained model is performing well\. 

The Amazon Rekognition Custom Labels console provides the following metrics as a summary of the training results and as metrics for each label: 
+ [Precision](#tr-precision-metric)
+ [Recall](#tr-recall-metric)
+ [Overall Model Performance](#tr-f1-metric)

Each metric we provide is a commonly used metric for evaluating the performance of a Machine Learning model\. Amazon Rekognition Custom Labels returns metrics for the results of testing across the entire test dataset, as well as metrics for each custom label\. You are also able to review the performance of your trained custom model for each image in your test dataset\.

## Evaluating Model Performance<a name="tr-evaluate-performance"></a>

During testing, Amazon Rekognition Custom Labels predicts if a test image contains a custom label\. The confidence score is a value that quantifies the certainty of the model’s prediction\.

If the confidence score for a custom label exceeds the threshold value, the model output will include this label\. Predictions can be categorized in the following ways:
+ *True positive* – The Amazon Rekognition Custom Labels model correctly predicts the presence of the custom label in the test image\. That is, the predicted label is also a "ground truth" label for that image\. For example, Amazon Rekognition Custom Labels correctly returns a soccer ball label when a soccer ball is present in an image\. 
+ *False positive* – The Amazon Rekognition Custom Labels model incorrectly predicts the presence of a custom label in a test image\. That is, the predicted label isn’t a ground truth label for the image\. For example, Amazon Rekognition Custom Labels returns a soccer ball label, but there is no soccer ball label in the ground truth for that image\.
+ *False negative* – The Amazon Rekognition Custom Labels model doesn't predict that a custom label is present in the image, but the "ground truth" for that image includes this label\. For example, Amazon Rekognition Custom Labels doesn’t return a ‘soccer ball’ custom label for an image that contains a soccer ball\. 
+ *True negative* – The Amazon Rekognition Custom Labels model correctly predicts that a custom label isn't present in the test image\. For example, Amazon Rekognition Custom Labels doesn’t return a soccer ball label for an image that doesn’t contain a soccer ball\. 

The console provides access to true positive, false positive, and false negative values for each image in your test dataset\.

These prediction results are used to calculate the following metrics for each label, as well as an aggregate for your entire test set\. The same definitions apply to predictions made by the model at the bounding box level, with the distinction that all metrics are calculated over each bounding box \(prediction or ground truth\) in each test image\.

## Assumed Threshold<a name="tr-assumed-threshold"></a>

Amazon Rekognition Custom Labels automatically calculates an assumed threshold value \(0\-1\) for each of your custom labels\. The *assumed threshold* for each label is the value above which a prediction is counted as a true or false positive\. It is set based on your test dataset\. 

### Precision<a name="tr-precision-metric"></a>

Amazon Rekognition Custom Labels provides precision metrics for each label and an average precision metric for the entire test dataset\. 

*Precision* is the fraction of correct predictions \(true positives\) over all model predictions \(true and false positives\) at the assumed threshold for an individual label\. As the threshold is increased, the model might make fewer predictions\. In general, however, it will have a higher ratio of true positives over false positives compared to a lower threshold\. Possible values for precision range from 0–1, and higher values indicate higher precision\.

For example, when the model predicts that a soccer ball is present in an image, how often is that prediction correct? Suppose there’s an image with 8 soccer balls and 5 rocks\. If the model predicts 9 soccer balls—8 correctly predicted and 1 false positive—then the precision for this example is 0\.89\. However, if the model predicted 13 soccer balls in the image with 8 correct predictions and 5 incorrect, then the resulting precision is lower\.

For more information, see [Precision and recall](https://en.wikipedia.org/wiki/Precision_and_recall)\.

### Recall<a name="tr-recall-metric"></a>

Amazon Rekognition Custom Labels provides average recall metrics for each label and an average recall metric for the entire test dataset\. 

*Recall* is the fraction of your test set labels that were predicted correctly above the assumed threshold\. It is a measure of how often the model can predict a custom label correctly when it's actually present in the images of your test set\. The range for recall is 0–1\. Higher values indicate a higher recall\.

For example, if an image contains 8 soccer balls, how many of them are detected correctly? In the preceding example where an image has 8 soccer balls and 5 rocks, if the model detects 5 of the soccer balls, then the recall value is 0\.62\. If after retraining, the new model detected 9 soccer balls, including all 8 that were present in the image, then the recall value is 1\.0\.

For more information, see [Precision and recall](https://en.wikipedia.org/wiki/Precision_and_recall)\.

### Overall Model Performance<a name="tr-f1-metric"></a>

Amazon Rekognition Custom Labels provides an average model performance score for each label and an average model performance score for the entire test dataset\.

*Model performance* is an aggregate measure that takes into account both precision and recall over all labels \(for example, F1 score or average precision\)\. The model performance score is a value between 0 and 1\. The higher the value, the better the model is performing for both recall and precision\. Specifically, model performance for classification tasks is commonly measured by F1 score, which is the harmonic mean of the precision and recall scores at the assumed threshold\. For example, for a model with precision of 0\.9 and a recall of 1\.0, the F1 score if 0\.947\.

A high value for F1 score indicates that the model is performing well for both precision and recall\. If the model isn't performing well, for example, with a low precision of 0\.30 and a high recall of 1\.0, the F1 score is 0\.46\. Similarly if the precision is high \(0\.95\) and the recall is low \(0\.20\), the F1 score is 0\.33\. In both cases, the F1 score is low and indicates problems with the model\. 

For more information, see [F1 score](https://en.wikipedia.org/wiki/F1_score)\.

### Using Metrics<a name="using-metrics"></a>

For a given model that you have trained and depending on your application, you can make a trade\-off between *precision* and *recall* by changing the threshold\. At a higher threshold, you will generally get higher *precision* \(more correct predictions of soccer balls\), but lower *recall* \(more actual soccer balls will be missed\)\. At a lower threshold, you will get higher *recall* \(more actual soccer balls will be correctly predicted\), but lower *precision* \(more of the soccer ball predictions will be wrong\)\. 

The metrics also inform you on the steps you might take to improve model performance if needed\. For more information, see [Improving an Amazon Rekognition Custom Labels Model](tr-improve-model.md)\. 

**Note**  
`DetectCustomLabels` returns predictions ranging from 0 to 100 which correspond to the metric range of 0\-1\.
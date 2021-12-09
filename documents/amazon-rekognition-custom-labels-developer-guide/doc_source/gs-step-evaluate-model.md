# Step 8: Evaluate Your Model<a name="gs-step-evaluate-model"></a>

During training, the model is evaluated for its performance against the test dataset\. The labels in the test dataset are considered 'ground truth' as they represent what the actual image represents\. During evaluation, the model makes predictions using the test dataset\. The predicted labels are compared with the ground truth labels and the results are available in the console evaluation page\.

The Amazon Rekognition Custom Labels console shows summary metrics for the entire model and metrics for individual labels\. The metrics available in the console are precision recall, F1 score, confidence, and confidence threshold\. For more information, see [Evaluating a Trained Amazon Rekognition Custom Labels Model](tr-train-results.md)\.

You can use the console to focus on individual metrics\. For example, to investigate precision issues for a label, you can filter the training results by label and by *false positive* results\. For more information, see [Metrics for Evaluating Your Model](tr-metrics-use.md)\.

After training, the training dataset is read\-only\. If you decide to improve the model, you can copy the training dataset to a new dataset\. You use the copy of the dataset to train a new version of the model\. 

In this step, you use the console to access the training results in the console\. 

**To access training results \(console\)**

1. On the **Projects** resources page, choose the project that contains the trained model that you want to evaluate\.

1. In the **Model** section, choose the model that you want to see training results for\. The summary results are shown\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/rekognition/latest/customlabels-dg/images/evaluation-results.png)

1. Choose **View test results** to see the test results for individual images\. A series of tips is shown before the test results are shown\. For more information about image test results, see [Metrics for Evaluating Your Model](tr-metrics-use.md)\.

1. Use the metrics to evaluate the performance of the model\. For more information, see [Improving an Amazon Rekognition Custom Labels Model](tr-improve-model.md)\. 
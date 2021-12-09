# Model Feedback Solution<a name="ex-feedback"></a>

The Model Feedback solution enables you to give feedback on your model's predictions and make improvements by using human verification\. Depending on the use case, you can be successful with a training dataset that has only a few images\. A larger annotated training set might be required to enable you to build a more accurate model\. The Model Feedback solution allows you to create larger dataset through model assistance\.

To install and configure the Model Feedback solution, see [Model Feedback Solution](https://github.com/aws-samples/amazon-rekognition-custom-labels-feedback-solution)\.

The workflow for continuous model improvement is as follows:

1. Train the first version of your model \(possibly with a small training dataset\)\.

1. Provide an unannotated dataset for the Model Feedback solution\.

1. The Model Feedback solution uses the current model\. It starts human verification jobs to annotate a new dataset\.

1. Based on human feedback, the Model Feedback solution generates a manifest file that you use to create a new model\. 
# Amazon Rekognition Custom Labels API Reference<a name="custom-labels-api-reference"></a>

The Amazon Rekognition Custom Labels API is documented as part of the Amazon Rekognition API reference content\. This is a list of the Amazon Rekognition Custom Labels API operations with links to the appropriate Amazon Rekognition API reference topic\. Also, API reference links within this document go to the appropriate Amazon Rekognition Developer Guide API reference topic\.

## Training Your Model<a name="ref-train-model"></a>
+ [CreateProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProject) — Creates your Amazon Rekognition Custom Labels project which is a logical grouping of resources \(images, Labels, models\) and operations \(training, evaluation and detection\)\.
+ [CreateProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_CreateProjectVersion) — Trains your Amazon Rekognition Custom Labels model using the provided training and test datasets\. Optionally you can autosplit a training dataset to create a test dataset\.
+ [DeleteProject](https://docs.aws.amazon.com/rekognition/latest/dg/API_DeleteProject) — Deletes an Amazon Rekognition Custom Labels project\.
+ [DeleteProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_DeleteProjectVersion) — Deletes an Amazon Rekognition Custom Labels model\.
+ [DescribeProjects](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjects) — Returns a list of all your projects\. 
+ [DescribeProjectVersions](https://docs.aws.amazon.com/rekognition/latest/dg/API_DescribeProjectVersions) — Returns a list of all the custom labels models within a specific project\.

## Using Your Model<a name="ref-use-model"></a>
+ [DetectCustomLabels](https://docs.aws.amazon.com/rekognition/latest/dg/API_DetectCustomLabels) — Analyzes an image with your custom labels model\. 
+ [StartProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StartProjectVersion) — Starts your custom labels model\.
+ [StopProjectVersion](https://docs.aws.amazon.com/rekognition/latest/dg/API_StopProjectVersion) — Stops your custom labels model\. 
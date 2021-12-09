# AWS DeepLens Device Library<a name="deeplens-device-library"></a>

 The AWS DeepLens device library consists of a set of Python modules that provide objects and methods for various device operations: 
+ The `awscam` module for running inference code based on a project's model\.
+  The `mo` module for converting your Caffe, Apache MXNet or TensorFlow deep learning model artifacts into AWS DeepLens model artifacts and performing necessary optimization\.
+ The `DeepLens_Kinesis_Video` module for integrating with Kinesis Video Streams to manage streaming from the AWS DeepLens device to a Kinesis Video Streams stream\.

**Topics**
+ [`awscam` Module for Inference](deeplens-library-awscam-module.md)
+ [Model Optimization \(mo\) Module](deeplens-model-optimizer-api.md)
+ [DeepLens\_Kinesis\_Video Module for Amazon Kinesis Video Streams Integration](deeplens-kinesis-video-streams-api.md)
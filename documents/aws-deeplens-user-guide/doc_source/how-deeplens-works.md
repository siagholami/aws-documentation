# AWS DeepLens Project Workflow<a name="how-deeplens-works"></a>

The following diagram illustrates the basic workflow of a deployed AWS DeepLens project\.

![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-hiw-general.png)

1. When turned on, the AWS DeepLens captures a video stream\.

1. Your AWS DeepLens produces two output streams:
   + **Device stream**—The video stream passed through without processing\.
   + **Project stream**—The results of the model's processing video frames

1. The Inference Lambda function receives unprocessed video frames\.

1. The Inference Lambda function passes the unprocessed frames to the project's deep learning model, where they are processed\.

1. The Inference Lambda function receives the processed frames from the model and passes the processed frames on in the project stream\.  
![\[\]](http://docs.aws.amazon.com/deeplens/latest/dg/images/deeplens-sample-output.png)

For more information, see [Viewing AWS DeepLens Output Streams](deeplens-viewing-output.md)\.
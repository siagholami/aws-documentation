# Self\-Driving using Reinforcement Learning<a name="gs-selfdrive"></a>

In this section, you teach a race car to drive in a simulation\. You use reinforcement learning and a coach reinforcement learning library\. View the reward metrics in Amazon CloudWatch Metrics to explore how the machine learning model improves over time\. Customize your reward function to improve the machine learning algorithm used for training\. 

Before you use AWS RoboMaker for the first time, complete the tasks in [Create an Account](gs-set-up.md)\. Then, in the AWS RoboMaker console, launch the Self\-Driving using Reinforcement Learning sample application\.

**Topics**
+ [View Training Metrics](#gs-selfdrive-metrics)
+ [View Trained Machine Learning Models](#gs-selfdrive-tensorflow)

## View Training Metrics<a name="gs-selfdrive-metrics"></a>

The Self\-Driving using Reinforcement Learning sample application uses AWS RoboMaker cloud extensions to write training metrics to Amazon CloudWatch\.

**To view robot training metrics**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the CloudWatch console, select **Metrics**\. 

1. On the **Metrics** page, in the **All metrics** tab, select **AWSRoboMakerSimulation**\. 

1. Select the metric named **DeepRacerRewardPerEpisode**\. 

1. Hover over the graph to see values for that moment\. This graph plots the total reward received by the robot in each trial or episode\. An increased reward over time indicates that the race car is improving its performance on the race track\.

## View Trained Machine Learning Models<a name="gs-selfdrive-tensorflow"></a>

When a simulation job runs, a frozen TensorFlow graph with weights is written to an Amazon S3 bucket\. This file can be deployed to a DeepRacer\.

**To view the TensorFlow data**

1. Open the Amazon Simple Storage Service console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\. Open the bucket name beginning with **awsrobomakerdeepracer**\.

1. In the bucket, open the folder named **model\-store/model**, and then select `model.pb`\. 
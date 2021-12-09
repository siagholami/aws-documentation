# Object Following using Reinforcement Learning<a name="gs-following"></a>

In this section, you teach a robot to track and follow an object through reinforcement learning in simulation using the Coach Reinforcement Learning Library\.  View the reward metrics in Amazon CloudWatch Metrics to explore how the machine learning model improves over time\. Customize your reward function to improve the machine learning algorithm used for training\. 

Before you use AWS RoboMaker for the first time, complete the tasks in [Create an Account](gs-set-up.md)\. Then, in the AWS RoboMaker console, launch the Object Following using Reinforcement Learning sample application\.

**Topics**
+ [View Training Metrics](#gs-following-metrics)
+ [View Trained Machine Learning Models](#gs-following-tensorflow)

## View Training Metrics<a name="gs-following-metrics"></a>

The Object Following using Reinforcement Learning sample application uses AWS RoboMaker cloud extensions to write training metrics to Amazon CloudWatch\.

**To view robot training metrics**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the CloudWatch console, select **Metrics**\. 

1. On the **Metrics** page, in the **All metrics** tab, select **AWSRoboMakerSimulation**\. 

1. Select the metric named **ObjectTrackerRewardPerEpisode**\. 

1. Hover over the graph to see values for that moment\. This graph plots the total reward received by the robot in each trial/episode\. An increase in reward with time indicates that the robot is getting better at finding and following the target object\.

## View Trained Machine Learning Models<a name="gs-following-tensorflow"></a>

When a simulation job runs, a frozen TensorFlow graph with weights is written to an Amazon S3 bucket\. This file can be deployed to a robot\.

**To view the TensorFlow data**

1. Open the Amazon Simple Storage Service console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\. Open the bucket name beginning with **awsrobomakerobjecttracker**\.

1. In the bucket, open the folder named **model\-store/model**, and then select `model.pb`\. 
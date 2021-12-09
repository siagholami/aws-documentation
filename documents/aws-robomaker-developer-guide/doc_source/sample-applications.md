# Sample Applications<a name="sample-applications"></a>

AWS RoboMaker comes with sample programs you can launch in the AWS RoboMaker console\. You can also download and build them on your own\. Each sample has a repo on GitHub\. The `readme` file describes the sample and how to build it\. The `readme` tells how it can be run on your desktop and in AWS RoboMaker\. 
+ **[Hello world](https://github.com/aws-robotics/aws-robomaker-sample-application-helloworld)** — Learn the basics of how to create your robot applications and simulation applications\. Start from a basic project template including a robot in an empty world\. 
+ **[Robot monitoring](https://github.com/aws-robotics/aws-robomaker-sample-application-cloudwatch)** — Monitor health and operational metrics for a robot in a simulated bookstore\. Use Amazon CloudWatch Metrics and Amazon CloudWatch Logs\. 
+ **[Navigation and person recognition](https://github.com/aws-robotics/aws-robomaker-sample-application-persondetection)** — The robot navigates between goal locations in a simulated home and recognizes faces in photos\. It also streams camera images to Kinesis Video Streams, receives face recognition results from Amazon Rekognition, and speaks the names of recognized people using Amazon Polly\. 
+ **[Voice commands](https://github.com/aws-robotics/aws-robomaker-sample-application-voiceinteraction)** — Command a robot through natural language text and voice in a simulated bookstore using Amazon Lex\. Default commands include "move", "turn" and "stop"\. 
+ **[Self\-driving using reinforcement learning](https://github.com/aws-robotics/aws-robomaker-sample-application-deepracer)** — Teach a race car to drive in a simulation through reinforcement learning in simulation using the Coach Reinforcement Learning Library\. View reward metrics in Amazon CloudWatch Metrics and customize the reward function to improve the machine learning algorithm used for training\. 
+ **[Object following using reinforcement learning](https://github.com/aws-robotics/aws-robomaker-sample-application-objecttracker)** — Teach a robot to track and follow an object through reinforcement learning in simulation using the Coach Reinforcement Learning Library\. View reward metrics in Amazon CloudWatch Metrics and customize the reward function to improve the machine learning algorithm used for training\. 

In this section, you learn how to launch a sample application in the AWS RoboMaker console\. You will also how to configure permissions if you want to provide your own IAM role when launching a sample application\. 

**Topics**
+ [Launching a Sample Application](sample-applications-launching.md)
+ [Configuring Permissions](sample-applications-permissions.md)
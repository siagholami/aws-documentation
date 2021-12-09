# Viewing a Simulation Job<a name="describe-simulation-job"></a>

You can view information about a simulation job and, if the job is running, launch Gazebo, rviz, rqt, or a terminal to interact with the simulation\. You can also view details about the simulation job and manage tags\.

**To see the details of a simulation job**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-describe-simulation-job-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, then choose **Simulation jobs**\.

1. Select the **Id** of a simulation job to view its details including the time it was created and launch commands for the robot application and simulation application\.

------
#### [ Using the AWS CLI ]<a name="proc-describe-simulation-job-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based view simulation job on the other tab\.  

```
$ aws robomaker list-simulation-jobs
$ aws robomaker describe-simulation-job --job my-simulation-job-arn
```

------
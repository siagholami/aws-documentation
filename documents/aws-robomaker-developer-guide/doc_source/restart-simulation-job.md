# Restarting a Simulation Job<a name="restart-simulation-job"></a>

Running simulation jobs can be restarted\. When restarted, the simulation job will use the robot application and simulation application source files in the Amazon S3 location and all other configuration settings specified when the simulation job was created\.

**To restart a simulation job**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-restart-simulation-job-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, then choose **Simulation jobs**\.

1. Select the **Id** of a running simulation job you would like to restart\.

1. In the **Simulation job detail** page, under **Actions**, choose **Restart**\.

1. In the **Restart simulation job** page, select **Yes, restart**\.

------
#### [ Using the AWS CLI ]<a name="proc-restart-simulation-job-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based restart simulation job on the other tab\. The simulation job must be running\.  

```
$ aws robomaker restart-simulation-job --job my-simulation-job-arn
```

------
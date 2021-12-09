# Cancelling a Simulation Job<a name="cancel-simulation-job"></a>

A simulation job can be cancelled if it is running and no longer needed\.

**To cancel a simulation job**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-cancel-simulation-job-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, then choose **Simulation jobs**\.

1. Select the **Id** of the simulation job you want to cancel\.

1. In the **Simulation job detail** page, under **Actions**, choose **Cancel**\.

1. In the **Cancel simulation job** page, select **Yes, cancel**\.

------
#### [ Using the AWS CLI ]<a name="proc-cancel-simulation-job-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based cancel simulation job on the other tab\.  

```
$ aws robomaker list-simulation-jobs
$ aws robomaker cancel-simulation-job --job my-simulation-job-arn
```

------
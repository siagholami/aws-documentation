# Cancelling a Simulation Job Batch<a name="simulation-job-batch-cancel"></a>

A simulation job can be cancelled if it is running and no longer needed\.

**To cancel a simulation job**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-cancel-simulation-job-batch-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, then choose **Simulation job batches**\.

1. Select the **Id** of the simulation job batch you want to cancel\.

1. In the **Simulation job batch detail** page, under **Batch actions**, choose **Cancel batch**\.

1. In the **Cancel simulation job batch** page, select **Cancel**\. 

------
#### [ Using the AWS CLI ]<a name="proc-cancel-simulation-job-batch-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based cancel simulation job batch on the other tab\.  

```
$ aws robomaker list-simulation-job-batches
$ aws robomaker cancel-simulation-job-batch --job my-simulation-job-batch-arn
```

------
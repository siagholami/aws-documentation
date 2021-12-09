# Viewing a Simulation Job Batch<a name="simulation-job-batch-describe"></a>

You can view information about a simulation job batch including details about simulation job requests in the batch\. 

**To see the details of a simulation job batch**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-describe-simulation-job-batch-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Simulations**, then choose **Simulation job batches**\. 

1. Select the **Id** of a simulation job batch to view its details\. 

------
#### [ Using the AWS CLI ]<a name="proc-describe-simulation-job-batch-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based view simulation job on the other tab\.  

```
$ aws robomaker list-simulation-job-batches
$ aws robomaker describe-simulation-job-batch --job my-simulation-job-batch-arn
```

------
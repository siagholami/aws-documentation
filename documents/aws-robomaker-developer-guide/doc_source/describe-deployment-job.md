# Viewing a Deployment Job<a name="describe-deployment-job"></a>

Once a deployment job is created, you can view its details and track the deployment status\.

**To see the details of a deployment job**  
Follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-describe-deployment-job-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet management**, then choose **Deployments**\.

1. Click on the **Id** of a deployment job to see details about the job including the time it was created and robot application version, deployment status, and the status of each robot in the fleet\.

------
#### [ Using the AWS CLI ]<a name="proc-describe-deployment-job-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based view deployment job on the other tab\.  

```
$ aws robomaker list-deployment-jobs
$ aws robomaker describe-deployment-job --job my-deployment-job-arn
```

------
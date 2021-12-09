# Viewing a Simulation Application<a name="describe-simulation-application"></a>

View the details of a simulation application\.

**To see the details of a simulation application**  
Follow the steps under one of the following tabs\.

------
#### [ Using the console ]<a name="proc-describe-simulation-application-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Development**, then choose **Simulation applications**\.

1. Select the **Name** of a simulation application to see details including the time it was created and last updated\.

------
#### [ Using the AWS CLI ]<a name="proc-describe-simulation-application-api"></a>

Use the following commands to describe a simulation application\.
+ **API/SDK:** [https://docs.aws.amazon.com/robomaker/latest/dg/API_DescribeSimulationApplication.html](https://docs.aws.amazon.com/robomaker/latest/dg/API_DescribeSimulationApplication.html)
+ **AWS CLI:** [https://docs.aws.amazon.com/cli/latest/reference/robomaker/describe-simulation-application.html](https://docs.aws.amazon.com/cli/latest/reference/robomaker/describe-simulation-application.html)

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based describe simulation application on the other tab\.  

```
$ aws robomaker describe-simulation-application \
--job my-simulation-job-arn
```

------
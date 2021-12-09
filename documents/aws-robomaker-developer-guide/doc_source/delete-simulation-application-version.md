# Deleting a Simulation Application Version<a name="delete-simulation-application-version"></a>

You can delete simulation application versions you no longer need\.

**To delete a simulation application version**  
Follow the steps under one of the following tabs\.

------
#### [ Using the console ]<a name="proc-delete-simulation-application-version-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Development**, then choose **Simulation applications**\.

1. Select the **Name** of the simulation application to see its versions\.

1. In the simulation detail page, choose **Version** to see details\.

1. In the details page, choose **Delete**, and then choose **Delete** to confirm\.

------
#### [ Using the AWS CLI ]<a name="proc-delete-simulation-application-version-api"></a>

You can use the following commands to delete a simulation application version\.
+ **API/SDK:** [https://docs.aws.amazon.com/robomaker/latest/dg/API_DeleteSimulationApplicationVersion.html](https://docs.aws.amazon.com/robomaker/latest/dg/API_DeleteSimulationApplicationVersion.html)
+ **AWS CLI:** [https://docs.aws.amazon.com/cli/latest/reference/robomaker/delete-simulation-application-version.html](https://docs.aws.amazon.com/cli/latest/reference/robomaker/delete-simulation-application-version.html)

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based delete simulation application on the other tab\.  

```
$ aws robomaker delete-simulation-application-version \
--application my-robot-application-arn 
--version 1.5
```

------
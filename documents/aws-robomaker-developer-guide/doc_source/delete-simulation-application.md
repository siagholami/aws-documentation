# Deleting a Simulation Application<a name="delete-simulation-application"></a>

When you no longer need a AWS RoboMaker simulation application and all of its versions, delete it\.

**To delete a simulation application**  
Follow the steps under one of the following tabs\.

------
#### [ Using the console ]<a name="proc-delete-simulation-application-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Development**, then choose **Simulation applications**\.

1. Select the **Name** of a simulation application\. This shows details such as the time it was created and last updated\.

1. In the simulation application detail page, choose **Delete** and then choose **Delete** to delete to confirm\.

------
#### [ Using the AWS CLI ]<a name="proc-delete-simulation-application-api"></a>

You can use the following commands to delete a simulation application:
+ **API/SDK:** [https://docs.aws.amazon.com/robomaker/latest/dg/API_DeleteSimulationApplication.html](https://docs.aws.amazon.com/robomaker/latest/dg/API_DeleteSimulationApplication.html)
+ **AWS CLI:** [https://docs.aws.amazon.com/cli/latest/reference/robomaker/delete-simulation-application.html](https://docs.aws.amazon.com/cli/latest/reference/robomaker/delete-simulation-application.html)

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based delete simulation application on the other tab\.  

```
$ aws robomaker delete-simulation-application --application my-robot-application-arn
```

------
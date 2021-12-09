# Updating a Simulation Application<a name="update-simulation-application"></a>

Update a simulation application\.

**To update a simulation application**  
Follow the steps under one of the following tabs\.

------
#### [ Using the console ]<a name="proc-update-simulation-application-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Development**, then choose **Simulation applications**\.

1. Check the box next to the simulation application you want to update\.

1. Select **Actions**, then select **Update**\.

1. You can add or remove sources, but you must have at least one source simulation application file\.

1. Select **Update** to update the simulation application\.

------
#### [ Using the AWS CLI ]<a name="proc-update-simulation-application-api"></a>

You can use the following commands to update a simulation application:
+ **API/SDK:** [https://docs.aws.amazon.com/robomaker/latest/dg/API_UpdateSimulationApplication.html](https://docs.aws.amazon.com/robomaker/latest/dg/API_UpdateSimulationApplication.html)
+ **AWS CLI:** [https://docs.aws.amazon.com/cli/latest/reference/robomaker/update-simulation-application.html](https://docs.aws.amazon.com/cli/latest/reference/robomaker/update-simulation-application.html)

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based update simulation application on the other tab\.  

```
$ aws robomaker update-simulation-application \
--application my-robot-application-arn \
--rendering-engine name=OGRE,version=1.x \
--simulation-software-suite name=Gazebo,version=7 \
--sources architecture=X86_64,s3Bucket=my-bucket-name,s3Key=my-key-name/hello-world-simulation.tar
```

------
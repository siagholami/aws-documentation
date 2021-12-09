# Troubleshooting Simulation Jobs<a name="troubleshooting-simulation-jobs"></a>

This section can help you fix issues with AWS RoboMaker simulation jobs\.

## Simulation Job Failed<a name="troubleshooting-jobfailed"></a>

If your simulation job failed, see the following common solutions\. 

### Are Your Amazon S3 Resources in the Same Region as AWS RoboMaker?<a name="troubleshooting-s3-region"></a>

Your robot application, simulation application, and output locations must be in the same Region as AWS RoboMaker\. Verify your application sources and simulation job output locations\. 

### Did Your Robot Application Exit Abnormally?<a name="troubleshooting-missing-segfault"></a>

There was a problem setting up your robot application for simulation\. Review the robot application logs for the simulation job in Amazon CloudWatch\.

Logs are accessed from the simulation job detail screen\. Select **Logs**, and then select a log stream\. To look for specific issues, use the filter\. For example, **WARNING** or **ERROR**\. 

### Is Your Application Missing an `.so` File?<a name="troubleshooting-missing-so"></a>

If your application crashed, it might be missing a dependent *shared object* \(`.so`\) file\. Extract your application bundle in your environment and verify that the shared object libraries you need are in `/usr/lib` or `/usr/local/lib`\. Make sure the dependency is added to your package \.xml file\. 

### Did You Use the ARN of your Role with the CLI?<a name="troubleshooting-full-arn"></a>

When you call create\-simulation\-job from the AWS CLI, use the full Amazon Resource Name \(ARN\) of the role, not just the role name\. 

### Does Your Role Have a Trust Policy for AWS RoboMaker?<a name="troubleshooting-trust-robomaker"></a>

If you are passing the full Amazon Resource Name \(ARN\) of the IAM role when you call create\-simulation\-job from the AWS CLI, your trust policy might have insufficient privileges\. Check the role to make sure it has a trust relationship with `robomaker.amazonaws.com`\.

See [Modifying a Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_manage_modify.html) for more information on viewing role access and adding a trust policy to an IAM role\.

### Does Your Role Have Permissions to Publish to Amazon S3?<a name="troubleshooting-s3-output"></a>

If you specify an output S3 bucket for a simulation job, your role must have write permissions to the bucket\. Update your trust policy to include write permissions\. The example trust policy below adds read, list, and write permissions to an S3 bucket\.

```
{
    "Action": "s3:ListBucket",
    "Resource": [
        "my-bucket"
    ],
    "Effect": "Allow"
},
{
    "Action": [
        "s3:Get*",
        "s3:List*"
    ],
    "Resource": [
        "my-bucket"
    ],
    "Effect": "Allow"
},
{
    "Action": "s3:Put*",
    "Resource": [
        "my-bucket"
    ],
    "Effect": "Allow"
}
```

### Does Your Role Have Permission to Publish to Amazon CloudWatch?<a name="troubleshooting-access-cloudwatch"></a>

Update the permissions policies of your IAM role with CloudWatch access\. 

```
{
   "Effect": "Allow",
   "Action": [
       "logs:CreateLogGroup",
       "logs:CreateLogStream",
       "logs:PutLogEvents",
       "logs:DescribeLogStreams"
    ],
    "Resource": "*"
}
```

### Does your Application Have a Mismatched Entity Tag?<a name="troubleshooting-etag"></a>

The entity tag \(ETag\) is a hash of the Amazon S3 object provided while creating the simulation\. The ETag reflects changes only to the contents of an object, not its metadata\. If you change the content of the robot application or simulation bundle in Amazon S3 before AWS RoboMaker has consumed it, there will be a version mismatch\.

To resolve this, create a new robot application or simulation application version and provide the key location for the updated application bundle\. For more information, see [Creating a Robot Application Version](create-robot-application-version.md) or [Creating a Simulation Application Version](create-robot-application-version.md)\. 

### Is Your Subnet ENI Limit Exceeded?<a name="troubleshooting-eni-limit"></a>

AWS RoboMaker uses one elastic network interface \(ENI\) for each concurrent simulation job in the subnet in which the simulation job is run\. Each of these must be assigned an IP address\. To resolve this, you can:
+ Delete unused ENIs to free up IP addresses in the subnet\. To delete an unused ENI, see [Deleting a Network Interface](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html#delete_eni)\. 
+ Request a [service limit increase](https://aws.amazon.com/support/createCase?serviceLimitIncreaseType=elastic-ips&type=service_limit_increase) for ENIs in a specific AWS Region\.

### Is the Launch Command Properly Configured?<a name="troubleshooting-preparing"></a>

Gazebo can take a few minutes to launch if your simulation is complex\. If AWS RoboMaker spends more than 10 minutes preparing the simulation job, there might be a problem with the launch command\.

Cancel the job and then create a new simulation job\. If the problem persists, contact AWS Support\.

It's also possible that one of the ROS nodes did not start or experienced problems\. Check the simulation logs for errors\. You can also use the terminal simulation to connect and troubleshoot the running simulation job\.

### Are Your Subnets in Zones AWS RoboMaker Supports?<a name="troubleshooting-subnet-zones"></a>

Provide subnets in two of the AWS Availability Zones supported by AWS RoboMaker\. API response contains a list of supported AWS Availability Zones\.

### Are the Launch File and Package Name Correct?<a name="troubleshooting-launch-filepack"></a>

Use CloudWatch Logs to verify the package name and launch file used by the simulation job\. Filter to `roslaunch` events, and then expand each event to look for issues similar to the following\.

```
[launch_file.launch] is neither a launch file in package [package_name] nor is [package_name] a launch file name
```

### Is the Node Package Named Correctly in the Launch File?<a name="troubleshooting-launch-badnode"></a>

Use CloudWatch Logs to verify the node package name used by the simulation job\. Filter to `cannot launch node` events, and then expand each event to look for issues similar to the following\.

```
ERROR: cannot launch node of type [node_package_name/node_type]: node_package_name
```

### Did you Include an Incorrect Launch File?<a name="troubleshooting-launch-badnode"></a>

Use CloudWatch Logs to check if the launch file was not found\. Filter to `roslaunch` events, and then expand each event to look for issues similar to the following\. 

```
while processing directory/path/to/launch/launch_file
Invalid roslaunch XML syntax: [Errno 2] No such file or directory: 'directory/path/to/launch/launch_file'
```

### Are Your World File Model References Correct?<a name="troubleshooting-launch-modelref"></a>

Use CloudWatch Logs to verify all of the models in your world file are correct\. If a model could not be located, you see information like the following\. 

```
[Wrn] [ModelDatabase.cc:340] Getting models from[http://models.gazebosim.org/]. This may take a few seconds.
[Wrn] [ModelDatabase.cc:212] Unable to connect to model database using [http://models.gazebosim.org//database.config]. Only locally installed models will be available.
[Err] [ModelDatabase.cc:414] Unable to download model[model://model_name]
[Err] [SystemPaths.cc:429] File or path does not exist[""]
Error [parser.cc:581] Unable to find uri[model://model_name]
```
# Registering and Deregistering Robots<a name="register-deregister-fleet"></a>

You can register \(add\) and deregister \(remove\) robots from fleets\. This is useful if you want to remove a robot from a fleet for maintenance or move a robot from one fleet to another fleet\.

You can register a robot to a single fleet only\. 

## Register a robot<a name="register-deregister-reg"></a>

To register a robot to a fleet, follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-register-robot-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet Management**, and then choose **Fleets**\.

1. Select the **Name** of the fleet you want to modify\.

1. In the **Fleet details** page, select **Register**\.

1. In the **Register robots** page, select the robot you want to register, then select **Register robots**\.

------
#### [ Using the AWS CLI ]<a name="proc-register-robot-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based robot registration on the other tab\.  

```
$ aws robomaker register-robot --fleet my-fleet-arn --robot my-robot-arn
```

------

## Deregister a robot<a name="register-deregister-dereg"></a>

To deregister a robot, follow the steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-deregister-robot-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet Management**, and then choose **Fleets**\.

1. Select the **Name** of the fleet you want to modify\.

1. In the **Fleet details** page, select the robot you want to deregister, then select **Deregister**\.

------
#### [ Using the AWS CLI ]<a name="proc-deregister-robot-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based robot deregistration on the other tab\.  

```
$ aws robomaker deregister-robot --fleet my-fleet-arn --robot my-robot-arn
```

------
# Deleting a Fleet<a name="delete-fleet"></a>

When you no longer need a fleet, you can delete it\. When you do this, robots registered to the fleet are deregistered\. 

**To delete a fleet**  
Follow these steps under one of the following tabs:

------
#### [ Using the console ]<a name="proc-delete-fleet-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet Management**, and then choose **Fleets**\.

1. Select the fleet you want to delete, then select **Delete**\.

------
#### [ Using the AWS CLI ]<a name="proc-delete-fleet-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based fleet deletion on the other tab\.  

```
$ aws robomaker delete-fleet --fleet my-fleet-arn
```

------
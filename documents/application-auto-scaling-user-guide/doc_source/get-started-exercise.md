# Getting Started Using the AWS CLI<a name="get-started-exercise"></a>

In this tutorial, you use the AWS CLI to explore Application Auto Scaling\. Before you begin, make sure that you have an AWS account and that you've set up the AWS CLI\. For more information, see [Setting Up](setting-up.md)\. In this tutorial, you create scheduled actions to scale your scalable resources based on a schedule\. With scheduled scaling, you can specify either a one\-time action or a recurring action\. 

The exercises in this tutorial assume that you are using administrator credentials \(`adminuser` profile\) that you set up in [Set Up the AWS CLI](setup-awscli.md)\. If you don't provide this profile, the default profile is assumed\. Note that to create, update, delete, or list Application Auto Scaling resources, you need permissions to perform the action, and you need permission to access the corresponding resources\. For more information, see [Identity and Access Management for Application Auto Scaling](auth-and-access-control.md)\.

The CLI commands in this tutorial were tested on Linux\. To use the samples with Microsoft Windows, change the line breaks from backslashes \(\\\) to carets \(^\)\. For information about using the CLI commands on Windows, see [Specifying Parameter Values for the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html) in the *AWS Command Line Interface User Guide*\.

**Note**  
You may incur AWS charges as part of this tutorial\. Please monitor your [Free Tier](https://aws.amazon.com/free/) usage and make sure that you understand the AWS charges involved\.

**Topics**
+ [Step 1: Register Your Scalable Target](#gs-register-scalable-target)
+ [Step 2: Create Two Scheduled Actions](#gs-create-scheduled-action)
+ [Step 3: View the Scaling Activities](#gs-view-scaling-activities)
+ [Step 4: Next Steps](#gs-next-steps)
+ [Step 5: Clean Up](#gs-clean-up)

## Step 1: Register Your Scalable Target<a name="gs-register-scalable-target"></a>

Begin by registering your resource as a scalable target with Application Auto Scaling\. A scalable target is a resource that Application Auto Scaling can scale out or scale in\.

You can use any resource that works with Application Auto Scaling, but for these examples, let's assume that you want to scale a DynamoDB table called `my-table`\. If you don't already have a DynamoDB table, you can create one now \([Step 1: Create a DynamoDB Table](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/AutoScaling.CLI.html#AutoScaling.CLI.CreateTable) in the *Amazon DynamoDB Developer Guide*\)\.

To use a DynamoDB global secondary index or a resource for a different service, update the examples accordingly\. Specify its namespace in `--service-namespace`, its scalable dimension in `--scalable-dimension`, and its resource ID in `--resource-id`\. For a list of valid values for each option, see [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html)\.

**To register your scalable target with Application Auto Scaling**

1. \(Optional\) Use the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scalable-targets.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scalable-targets.html) command to check whether any DynamoDB resources are already registered\. This helps you verify whether to register the `my-table` table\. For example, if you previously configured automatic scaling for this table from the DynamoDB console, it may already be registered with Application Auto Scaling\. 

   ```
   aws application-autoscaling describe-scalable-targets \
     --service-namespace dynamodb \
     --profile adminuser
   ```

   If there are no existing scalable targets, this is the response\.

   ```
   {
       "ScalableTargets": []
   }
   ```

1. Use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html) command to register or update the write capacity of a DynamoDB table called `my-table`\. Set a minimum desired capacity of 5 write capacity units and a maximum desired capacity of 10 write capacity units\.

   ```
   aws application-autoscaling register-scalable-target \
     --service-namespace dynamodb \
     --scalable-dimension dynamodb:table:WriteCapacityUnits \
     --resource-id table/my-table \
     --min-capacity 5 --max-capacity 10 \
     --profile adminuser
   ```

   This command does not return any output if it is successful\.

## Step 2: Create Two Scheduled Actions<a name="gs-create-scheduled-action"></a>

Application Auto Scaling allows you to schedule the time when a scaling action should occur\. You specify the scalable target, the schedule, and the minimum and maximum capacity\. At the specified time, Application Auto Scaling updates the minimum and maximum value for the scalable target\. If its current capacity is outside of this range, this results in a scaling activity\. 

Scheduling updates to the minimum and maximum capacity is also helpful if you decide to create a scaling policy\. A scaling policy allows your resources to scale dynamically based on current resource utilization\. A common guardrail for a scaling policy is having appropriate values for minimum and maximum capacity\.

For this exercise, we create two one\-time actions for scale out and scale in\. 

**To create and view the scheduled actions**

1. To create the first scheduled action, use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scheduled-action.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scheduled-action.html) command\. 

   The **at** command in `--schedule` schedules the action to be run once at a specified date and time in the future\. Hours are in 24\-hour format in UTC\. Schedule the action to occur about 5 minutes from now\. 

   At the date and time specified, Application Auto Scaling updates the `MinCapacity` and `MaxCapacity` values\. Assuming the table currently has 5 write capacity units, Application Auto Scaling scales out to `MinCapacity` to put the table within the new desired range of 15\-20 write capacity units\.

   ```
   aws application-autoscaling put-scheduled-action \
     --service-namespace dynamodb \
     --scalable-dimension dynamodb:table:WriteCapacityUnits \
     --resource-id table/my-table \
     --scheduled-action-name my-first-scheduled-action \
     --schedule "at(2019-05-20T17:05:00)" \
     --scalable-target-action MinCapacity=15,MaxCapacity=20 \
     --profile adminuser
   ```

   This command does not return any output if it is successful\.

1. To create the second scheduled action that Application Auto Scaling uses to scale in, use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scheduled-action.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scheduled-action.html) command\. 

   Schedule the action to occur about 10 minutes from now\. 

   At the date and time specified, Application Auto Scaling updates the table's `MinCapacity` and `MaxCapacity`, and scales in to `MaxCapacity` to return the table to the original desired range of 5\-10 write capacity units\.

   ```
   aws application-autoscaling put-scheduled-action \
     --service-namespace dynamodb \
     --scalable-dimension dynamodb:table:WriteCapacityUnits \
     --resource-id table/my-table \
     --scheduled-action-name my-second-scheduled-action \
     --schedule "at(2019-05-20T17:10:00)" \
     --scalable-target-action MinCapacity=5,MaxCapacity=10 \
     --profile adminuser
   ```

1. \(Optional\) Get a list of scheduled actions for the specified service namespace using the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scheduled-actions.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scheduled-actions.html) command\.

   ```
   aws application-autoscaling describe-scheduled-actions \
     --service-namespace dynamodb \
     --profile adminuser
   ```

   The following is example output\.

   ```
   {
       "ScheduledActions": [
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Schedule": "at(2019-05-20T18:35:00)",
               "ResourceId": "table/my-table",
               "CreationTime": 1561571888.361,
               "ScheduledActionARN": "arn:aws:autoscaling:us-east-1:123456789012:scheduledAction:2d36aa3b-cdf9-4565-b290-81db519b227d:resource/dynamodb/table/my-table:scheduledActionName/my-first-scheduled-action",
               "ScalableTargetAction": {
                   "MinCapacity": 15,
                   "MaxCapacity": 20
               },
               "ScheduledActionName": "my-first-scheduled-action",
               "ServiceNamespace": "dynamodb"
           },
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Schedule": "at(2019-05-20T18:40:00)",
               "ResourceId": "table/my-table",
               "CreationTime": 1561571946.021,
               "ScheduledActionARN": "arn:aws:autoscaling:us-east-1:123456789012:scheduledAction:2d36aa3b-cdf9-4565-b290-81db519b227d:resource/dynamodb/table/my-table:scheduledActionName/my-second-scheduled-action",
               "ScalableTargetAction": {
                   "MinCapacity": 5,
                   "MaxCapacity": 10
               },
               "ScheduledActionName": "my-second-scheduled-action",
               "ServiceNamespace": "dynamodb"
           }
       ]
   }
   ```

## Step 3: View the Scaling Activities<a name="gs-view-scaling-activities"></a>

In this step, you view the scaling activities triggered by the scheduled actions, and then verify that DynamoDB changed the table's write capacity\.

**To view the scaling activities**

1. Wait for the time you chose, and verify that your scheduled actions are working by using the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-activities.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-activities.html) command\. 

   ```
   aws application-autoscaling describe-scaling-activities \
     --service-namespace dynamodb \
     --profile adminuser
   ```

   The following is example output for the first scheduled action while the scheduled action is in progress\.

   Scaling activities are ordered by creation date, with the newest scaling activities returned first\.

   ```
   {
       "ScalingActivities": [
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Description": "Setting write capacity units to 15.",
               "ResourceId": "table/my-table",
               "ActivityId": "d8ea4de6-9eaa-499f-b466-2cc5e681ba8b",
               "StartTime": 1561574108.904,
               "ServiceNamespace": "dynamodb",
               "Cause": "minimum capacity was set to 15",
               "StatusMessage": "Successfully set write capacity units to 15. Waiting for change to be fulfilled by dynamodb.",
               "StatusCode": "InProgress"
           },
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Description": "Setting min capacity to 15 and max capacity to 20",
               "ResourceId": "table/my-table",
               "ActivityId": "3250fd06-6940-4e8e-bb1f-d494db7554d2",
               "StartTime": 1561574108.512,
               "ServiceNamespace": "dynamodb",
               "Cause": "scheduled action name my-first-scheduled-action was triggered",
               "StatusMessage": "Successfully set min capacity to 15 and max capacity to 20",
               "StatusCode": "Successful"
           }
       ]
   }
   ```

   The following is example output after both scheduled actions have run\.

   ```
   {
       "ScalingActivities": [
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Description": "Setting write capacity units to 10.",
               "ResourceId": "table/my-table",
               "ActivityId": "4d1308c0-bbcf-4514-a673-b0220ae38547",
               "StartTime": 1561574415.086,
               "ServiceNamespace": "dynamodb",
               "EndTime": 1561574449.51,
               "Cause": "maximum capacity was set to 10",
               "StatusMessage": "Successfully set write capacity units to 10. Change successfully fulfilled by dynamodb.",
               "StatusCode": "Successful"
           },
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Description": "Setting min capacity to 5 and max capacity to 10",
               "ResourceId": "table/my-table",
               "ActivityId": "f2b7847b-721d-4e01-8ef0-0c8d3bacc1c7",
               "StartTime": 1561574414.644,
               "ServiceNamespace": "dynamodb",
               "Cause": "scheduled action name my-second-scheduled-action was triggered",
               "StatusMessage": "Successfully set min capacity to 5 and max capacity to 10",
               "StatusCode": "Successful"
           },
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Description": "Setting write capacity units to 15.",
               "ResourceId": "table/my-table",
               "ActivityId": "d8ea4de6-9eaa-499f-b466-2cc5e681ba8b",
               "StartTime": 1561574108.904,
               "ServiceNamespace": "dynamodb",
               "EndTime": 1561574140.255,
               "Cause": "minimum capacity was set to 15",
               "StatusMessage": "Successfully set write capacity units to 15. Change successfully fulfilled by dynamodb.",
               "StatusCode": "Successful"
           },
           {
               "ScalableDimension": "dynamodb:table:WriteCapacityUnits",
               "Description": "Setting min capacity to 15 and max capacity to 20",
               "ResourceId": "table/my-table",
               "ActivityId": "3250fd06-6940-4e8e-bb1f-d494db7554d2",
               "StartTime": 1561574108.512,
               "ServiceNamespace": "dynamodb",
               "Cause": "scheduled action name my-first-scheduled-action was triggered",
               "StatusMessage": "Successfully set min capacity to 15 and max capacity to 20",
               "StatusCode": "Successful"
           }
       ]
   }
   ```

1. After running the scheduled actions successfully, go to the DynamoDB console and choose the table that you want to work with\. View the **Write capacity units** under the **Capacity** tab\. After the second scaling action ran, the write capacity units should have been scaled from 15 to 10\. 

   You can also view this information through the AWS CLI\.

   Verify the table's current write capacity by using the DynamoDB [https://docs.aws.amazon.com/cli/latest/reference/dynamodb/describe-table.html](https://docs.aws.amazon.com/cli/latest/reference/dynamodb/describe-table.html) command\. 

   ```
   aws dynamodb describe-table --table-name my-table \
     --query "Table.[TableName,TableStatus,ProvisionedThroughput]" \
     --profile adminuser
   ```

   The following is example output\.

   ```
   [
       "my-table",
       "ACTIVE",
       {
           "NumberOfDecreasesToday": 1,
           "WriteCapacityUnits": 10,
           "LastIncreaseDateTime": 1561574133.264,
           "ReadCapacityUnits": 5,
           "LastDecreaseDateTime": 1561574435.607
       }
   ]
   ```

## Step 4: Next Steps<a name="gs-next-steps"></a>

Now that you have familiarized yourself with Application Auto Scaling and some of its features, consider doing the following: 
+ If you want to try scaling on a recurring schedule, see the example in [Scheduled Scaling for Application Auto Scaling](application-auto-scaling-scheduled-scaling.md)\.
+ If you want to try scaling dynamically in response to changes in resource utilization \(for example, by using the `DynamoDBWriteCapacityUtilization` metric\), follow the steps in [Target Tracking Scaling Policies for Application Auto Scaling](application-auto-scaling-target-tracking.md)\.

## Step 5: Clean Up<a name="gs-clean-up"></a>

When you are done working with the getting started exercises, you can clean up the associated resources as follows\.

**To delete the scheduled actions**  
The following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/delete-scheduled-action.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/delete-scheduled-action.html) command deletes a specified scheduled action\. You can skip this step if you want to keep the scheduled action for future use\.

```
aws application-autoscaling delete-scheduled-action \
  --service-namespace dynamodb \
  --scalable-dimension dynamodb:table:WriteCapacityUnits \
  --resource-id table/my-table \
  --scheduled-action-name my-second-scheduled-action \
  --profile adminuser
```

**To deregister the scalable target**  
Use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/deregister-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/deregister-scalable-target.html) command to deregister the scalable target\. If you have any scaling policies that you created or any scheduled actions that have not yet been deleted, they are deleted by this command\. You can skip this step if you want to keep the scalable target registered for future use\.

```
aws application-autoscaling deregister-scalable-target \
  --service-namespace dynamodb \
  --scalable-dimension dynamodb:table:WriteCapacityUnits \
  --resource-id table/my-table \
  --profile adminuser
```

**To delete the DynamoDB table**  
Use the following [https://docs.aws.amazon.com/cli/latest/reference/dynamodb/delete-table.html](https://docs.aws.amazon.com/cli/latest/reference/dynamodb/delete-table.html) command to delete the table that you used in this tutorial\. You can skip this step if you want to keep the table for future use\.

```
aws dynamodb delete-table --table-name my-table \
  --profile adminuser
```
# Step 5: Clean Up<a name="gs-delete-scaling-plan"></a>

After you have completed the Getting Started tutorial, you can choose to keep your scaling plan\. However, if you are not actively using your scaling plan, you should consider deleting it so that your account does not incur unnecessary charges\. 

Deleting a scaling plan deletes the target tracking scaling policies, their associated CloudWatch alarms, and the predictive scaling actions that AWS Auto Scaling created on your behalf\. 

Deleting a scaling plan does not delete your AWS CloudFormation stack, Auto Scaling group, or other scalable resources\. 

**To delete a scaling plan**

1. Open the AWS Auto Scaling console at [https://console\.aws\.amazon\.com/awsautoscaling/](https://console.aws.amazon.com/awsautoscaling/)\.

1. On the **Scaling plans** page, select the scaling plan that you created for this tutorial and choose **Delete**\.

1. When prompted for confirmation, choose **Delete**\.

After you delete your scaling plan, your resources do not revert to their original capacity\. For example, if your Auto Scaling group is scaled to 10 instances when you delete the scaling plan, your group is still scaled to 10 instances after the scaling plan is deleted\. You can update the capacity of specific resources by accessing the console for each individual service\.

## Delete Your Auto Scaling Group<a name="gs-delete-asg"></a>

To prevent your account from accruing Amazon EC2 charges, you should also delete the Auto Scaling group that you created for this tutorial\.

For step\-by\-step instructions, see [Delete Your Auto Scaling Group](https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-process-shutdown.html#as-shutdown-lbs-delete-asg-cli) in the *Amazon EC2 Auto Scaling User Guide*\.
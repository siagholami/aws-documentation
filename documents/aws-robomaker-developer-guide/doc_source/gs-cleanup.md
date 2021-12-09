# Step 6: Clean up<a name="gs-cleanup"></a>

To avoid extra charges, use the AWS Management Console to delete items that you created for this exercise\. 

1. Open the AWS RoboMaker console at `[https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)` \. Choose **Simulation jobs** and then choose the **Hello World** simulation job\. In the **Simulation job details** page, choose **Actions**, choose **Cancel**, and then choose **Yes, cancel**\. 
**Note**  
Simulation jobs are automatically deleted after 90 days\.

1. Open the AWS CloudFormation console at `[https://console\.aws\.amazon\.com/cloudformation/](https://console.aws.amazon.com/cloudformation/)` and delete the stack with **HelloWorld**\. If there are multiple entries, choose by date and time\.

1. Open the IAM console at `[https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)` and delete the IAM role\. If you created permissions policies, delete them\.

1. Open the AWS Cloud9 console at `[https://console\.aws\.amazon\.com/cloud9/](https://console.aws.amazon.com/cloud9/)`\. Choose the **HelloWorld** environment and then choose **Delete**\. Confirm by typing **Delete** and then selecting **Delete**\.
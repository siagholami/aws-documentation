# Delete AWS DeepLens Resources Using the AWS Console<a name="deeplens-delete-resources-using-console"></a>

**Topics**
+ [Delete an AWS DeepLens Project](#deeplens-delete-project-using-console)
+ [Delete an AWS DeepLens Model](#deeplens-delete-model-using-console)
+ [Delete an AWS DeepLens Device Profile](#deeplens-delete-device-profile-using-console)
+ [Delete AWS DeepLens Logs from CloudWatch Logs](#deeplens-delete-cloudwatch-logs-using-console)

## Delete an AWS DeepLens Project<a name="deeplens-delete-project-using-console"></a>

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/home?region=us\-east\-1\#firstrun/](https://console.aws.amazon.com/deeplens/home?region=us-east-1#firstrun)\.

1. In the navigation pane, choose **Projects**\.

1. On the **Projects** page, choose the button next to the project that you want to delete\.

1. In the **Actions** list, choose **Delete**\.

1. In the **Delete *project\-name*** dialog box, choose **Delete** to confirm that you want to delete the project\.

## Delete an AWS DeepLens Model<a name="deeplens-delete-model-using-console"></a>

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/home?region=us\-east\-1\#firstrun/](https://console.aws.amazon.com/deeplens/home?region=us-east-1#firstrun)\.

1. In the navigation pane, choose **Models**\.

1. On the **Models** page, choose the button next to the model that you want to delete\.

1. In the **Action** list, choose **Delete**\.

1. In the **Delete *model\-name*** dialog box, choose **Delete** to confirm that you want to delete the model\.

## Delete an AWS DeepLens Device Profile<a name="deeplens-delete-device-profile-using-console"></a>

 To deleting an unused device profile, you deregister the device\. For more information, see [Deregistering Your AWS DeepLens Device](deeplens-deregister-device.md)\. 

## Delete AWS DeepLens Logs from CloudWatch Logs<a name="deeplens-delete-cloudwatch-logs-using-console"></a>

If you exposed personally identifiable information in the AWS IoT Greengrass user logs that were created in Amazon CloudWatch Logs when you ran your AWS DeepLens project, use the CloudWatch Logs console to delete them\. 

1. Sign in to the AWS Management Console and open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Logs**\.

1. On the **Log Groups** page, choose the button next to the AWS IoT Greengrass user log that you want to delete\. The log begins with `/aws/greengrass/Lambda/...`\.

1. In the **Actions** list, choose **Delete log group**\.

1. In the **Delete log group** dialog box, choose **Yes, Delete** to confirm that you want to delete the logs\.
**Note**  
When the Lambda function for your project runs again, the deleted log group will be recreated\. 
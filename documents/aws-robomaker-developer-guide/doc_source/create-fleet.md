# Creating a Fleet<a name="create-fleet"></a>

To create a fleet, follow the steps under one of the following tabs:<a name="proc-create-fleet-con"></a>

------
#### [ Using the console ]<a name="proc-create-fleet-con"></a>

1. Sign in to the AWS RoboMaker console at [https://console\.aws\.amazon\.com/robomaker/](https://console.aws.amazon.com/robomaker/)\.

1. In the left navigation pane, choose **Fleet Management**, and then choose **fleets**\.

1. Select **Create fleet**\.

1. In the **Create fleet** page, type a **name** for the fleet\.

1. Optionally, under **Tags**, specify one or more tags for the fleet\. Tags are words or phrases that act as metadata for identifying and organizing your AWS resources\. Each tag consists of a key and a value\. You can manage tags for your fleet on the **Fleet details** page\.

   For more about tagging, see [Tagging Your AWS RoboMaker Resources](tagging-robomaker.md)\. 

1. Click **Create** to create the deployment job\. 

------
#### [ Using the AWS CLI ]<a name="proc-create-fleet-api"></a>

**Example**  
Here's an example AWS CLI command that performs the equivalent of the console\-based fleet creation on the other tab\.  

```
$ aws robomaker create-fleet --name my-fleet
```

------
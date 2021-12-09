# Publishing property value updates to Amazon DynamoDB<a name="publish-to-amazon-dynamodb"></a>

You can store your data in [Amazon DynamoDB](http://aws.amazon.com/dynamodb/) to easily access historical asset data without needing to repeatedly query the AWS IoT SiteWise API, which returns paginated value histories\. After you complete this tutorial, you can easily create custom software that consumes your asset data, such as a live map of wind speed and direction over an entire wind farm\. If you're looking to monitor and visualize your data without implementing a custom software solution, see [Monitoring data with AWS IoT SiteWise Monitor](monitor-data.md)\.

In this tutorial, you build on the AWS IoT SiteWise demo that provides a sample set of data for a wind farm\. You configure property value updates from the wind farm demo to send data, through AWS IoT Core rules, to a DynamoDB table that you create\. When you enable property value updates, AWS IoT SiteWise sends your data to AWS IoT Core in MQTT messages\. Then, you can define AWS IoT Core rules that perform actions, such as the DynamoDB action, depending on the contents of those messages\. For more information, see [Interacting with other AWS services](interact-with-other-services.md)\.

**Topics**
+ [Prerequisites](#dynamodb-tutorial-prerequisites)
+ [Configuring AWS IoT SiteWise to publish property value updates](#dynamodb-tutorial-enable-value-notifications)
+ [Creating a rule in AWS IoT Core](#dynamodb-tutorial-create-iot-rule)
+ [Creating a DynamoDB table](#dynamodb-tutorial-create-dynamodb-table)
+ [Configuring the DynamoDB rule action](#dynamodb-tutorial-configure-rule-action)
+ [Exploring data in DynamoDB](#dynamodb-tutorial-explore-dynamodb-data)
+ [Cleaning up resources after the tutorial](#dynamodb-tutorial-clean-up-resources)
+ [Troubleshooting a rule](#dynamodb-tutorial-troubleshoot-rule)

## Prerequisites<a name="dynamodb-tutorial-prerequisites"></a>

To complete this tutorial, you need the following:
+ An AWS account\. If you don't have one, see [Setting up an AWS account](set-up-aws-account.md)\.
+ A development computer running Windows, macOS, Linux, or Unix to access the AWS Management Console\. For more information, see [Getting Started with the AWS Management Console](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/getting-started.html)\.
+ An IAM user with administrator permissions\.
+ A running AWS IoT SiteWise wind farm demo\. When you set up the demo, it defines models and assets in AWS IoT SiteWise and streams data to them to represent a wind farm\. For more information, see [Using the AWS IoT SiteWise demo](getting-started-demo.md)\.

## Configuring AWS IoT SiteWise to publish property value updates<a name="dynamodb-tutorial-enable-value-notifications"></a>

In this procedure, you enable property value notifications on your demo turbine assets' **Wind Speed** properties\. After you enable property value notifications, AWS IoT SiteWise publishes each value update in an MQTT message to AWS IoT Core\.

**To enable property value update notifications on asset properties**

1. Sign in to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. Review the [AWS Regions](getting-started.md#requirements) where AWS IoT SiteWise is supported and switch AWS Regions, if necessary\. Switch to a Region where you're running the AWS IoT SiteWise demo\.

1. In the left navigation pane, choose **Assets**\.  
![\[AWS IoT SiteWise "Assets" left navigation element screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-open-assets-console.png)

1. Choose the arrow next to **Demo Wind Farm Asset** to expand the wind farm asset's hierarchy\.  
![\[AWS IoT SiteWise "Demo Wind Farm Asset" hierarchy screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-expand-hierarchy-console.png)

1. Choose a demo turbine and choose **Edit**\.  
![\[AWS IoT SiteWise "Demo Turbine Asset" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-choose-edit-asset-console.png)

1. Update the **Wind Speed** property's **Notification status** to **ENABLED**\.  
![\[AWS IoT SiteWise "Edit notification status" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-enable-notification-status-console.png)

1. Choose **Save asset** at the bottom of the page\.

1. Repeat steps 5 through 7 for each demo turbine asset\.

1. Choose a demo turbine \(for example, **Demo Turbine Asset 1**\)\.

1. Choose **Measurements**\.

1. Choose the copy icon next to the **Wind Speed** property to copy the notification topic to your clipboard\. Save the notification topic to use later in this tutorial\. You only need to record the notification topic from one turbine\.  
![\[AWS IoT SiteWise "Copy notification topic" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-copy-notification-topic-console.png)

   The notification topic should look like the following example\.

   ```
   $aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE
   ```

## Creating a rule in AWS IoT Core<a name="dynamodb-tutorial-create-iot-rule"></a>

In this procedure, you create a rule in AWS IoT Core that parses the property value notification messages and inserts data into a DynamoDB table\. AWS IoT Core rules parse MQTT messages and perform actions based on the contents and topic of each message\. You can create a rule with a DynamoDB action to insert data to a DynamoDB table that you create as part of this tutorial\.

**To create a rule with a DynamoDB action**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\. If a **Get started** button appears, choose it\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.  
![\[AWS IoT Core "Create a rule" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-choose-create-rule-console.png)

1. If a **You don't have any rules yet** dialog box appears, choose **Create a rule**\. Otherwise, choose **Create**\.

1. Enter a name and description for the rule\.  
![\[AWS IoT Core "Create a rule" page screenshot with "Name" and "Description" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-define-name-description-console.png)

1. Find the notification topic that you saved earlier in this tutorial\.

   ```
   $aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE
   ```

   Replace the asset ID \(the ID after `assets/`\) in the topic with a `+` to select the wind speed property for all demo wind turbine assets\. The `+` topic filter accepts all nodes from a single level in a topic\. Your topic should look the following example\.

   ```
   $aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/+/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE
   ```

1. Enter the following rule query statement\. Replace the topic in the `FROM` section with your notification topic\.

   ```
   SELECT
     payload.assetId AS asset,
     (SELECT VALUE (value.doubleValue) FROM payload.values) AS windspeed,
     timestamp() AS timestamp
   FROM
     '$aws/sitewise/asset-models/a1b2c3d4-5678-90ab-cdef-11111EXAMPLE/assets/+/properties/a1b2c3d4-5678-90ab-cdef-33333EXAMPLE' 
   WHERE
     type = 'PropertyValueUpdate'
   ```

1. Under **Set one or more actions**, choose **Add action**\.  
![\[AWS IoT Core "Create a rule" page screenshot with "Add action" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-add-action-console.png)

1. On the **Select an action** page, choose **Split message into multiple columns of a DynamoDB table \(DynamoDBv2\)**\.  
![\[AWS IoT Core "Select an action" page screenshot with the DynamoDBv2 action highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-choose-dynamodbv2-action-console.png)

1. Choose **Configure action** at the bottom of the page\.

1. On the **Configure action** page, choose **Create a new resource**\.

   The DynamoDB console opens in a new tab\. Keep the rule action tab open while you complete the following procedures\.

## Creating a DynamoDB table<a name="dynamodb-tutorial-create-dynamodb-table"></a>

In this procedure, you create a DynamoDB table to receive wind speed data from the rule action\.

**To create a DynamoDB table**

1. In the DynamoDB console dashboard, choose **Create table**\.

1. Enter a name for your table\.  
![\[DynamoDB "Create table" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/dynamodb-create-table-console.png)

1. For **Primary key**, do the following:

   1. Enter **timestamp** as the partition key\.

   1. Choose the **Number** type\.

   1. Select the **Add sort key** check box\.

   1. Enter **asset** as the sort key, and leave the default sort key type of **String**\.

1. Choose **Create**\.

   When the **Table is being created** notice disappears, your table is ready\.

1. Return to the tab with the **Configure action** page\. Keep the DynamoDB tab open while you complete the following procedures\.

## Configuring the DynamoDB rule action<a name="dynamodb-tutorial-configure-rule-action"></a>

In this procedure, you configure the DynamoDB rule action to insert data from property value updates to your new DynamoDB table\.

**To configure the DynamoDB rule action**

1. On the **Configure action** page, refresh the **Table name** list, and choose your new DynamoDB table\.  
![\[AWS IoT Core "Configure DynamoDBv2 action" page screenshot with the table finder highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-configure-dynamodbv2-action-choose-table-console.png)

1. Choose **Create role** to create an IAM role that grants AWS IoT Core access to perform the rule action\.

1. Enter a role name and choose **Create role**\.  
![\[AWS IoT Core "Configure DynamoDBv2 action" page screenshot with "Create role" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-create-role-console.png)

1. Choose **Add action**\.

1. Choose **Create rule** at the bottom of the page to finish creating the rule\.

   Your demo asset data should start appearing in your DynamoDB table\.

## Exploring data in DynamoDB<a name="dynamodb-tutorial-explore-dynamodb-data"></a>

In this procedure, you explore the demo assets' wind speed data in your new DynamoDB table\.

**To explore asset data in DynamoDB**

1. Return to the tab with the DynamoDB table open\.

1. In the table you created earlier, choose the **Items** tab to view the data in the table\. Refresh the page if you don't see rows in the table\. If rows don't appear after a few minutes, see [Troubleshooting a rule](#dynamodb-tutorial-troubleshoot-rule)\.  
![\[DynamoDB table page screenshot with the "Items" tab highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/dynamodb-view-table-items-console.png)

1. In a row in the table, choose the edit icon to expand the data\.  
![\[DynamoDB table page screenshot with the edit icon on a row highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/dynamodb-expand-table-row-console.png)

1. Choose the arrow next to the **windspeed** structure to expand the list of wind speed data points\. Each list reflects a batch of wind speed data points sent to AWS IoT SiteWise by the wind farm demo\. You might want a different data format if you set up a rule action for your own use\. For more information, see [Querying asset property notification messages](interact-with-other-services.md#query-notification-messages)\.  
![\[DynamoDB "Edit table row" panel screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/dynamodb-view-expanded-data-console.png)

Now that you completed the tutorial, you can disable or delete the rule and delete your DynamoDB table to avoid incurring additional charges\. Follow the next procedure to clean up your resources\.

## Cleaning up resources after the tutorial<a name="dynamodb-tutorial-clean-up-resources"></a>

After you complete the tutorial, clean up your resources to avoid incurring additional charges\. Your demo wind farm assets are deleted at the end of the duration that you chose when you created the demo, or you can delete the demo manually\. For more information, see [Deleting the AWS IoT SiteWise demo](getting-started-demo.md#delete-getting-started-demo)\.

Use the following procedures to disable property value update notifications \(if you didn't delete the demo\), disable or delete your AWS IoT rule, and delete your DynamoDB table\.

**To disable property value update notifications on asset properties**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Assets**\.  
![\[AWS IoT SiteWise "Assets" left navigation element screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-open-assets-console.png)

1. Choose the arrow next to **Demo Wind Farm Asset** to expand the wind farm asset's hierarchy\.  
![\[AWS IoT SiteWise "Demo Wind Farm Asset" hierarchy screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-expand-hierarchy-console.png)

1. Choose a demo turbine and choose **Edit**\.  
![\[AWS IoT SiteWise "Demo Turbine Asset" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-choose-edit-asset-console.png)

1. Update the **Wind Speed** property's **Notification status** to **DISABLED**\.  
![\[AWS IoT SiteWise "Edit notification status" screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/sitewise-disable-notification-status-console.png)

1. Choose **Save asset** at the bottom of the page\.

1. Repeat steps 4 through 6 for each demo turbine asset\.

**To disable or delete a rule in AWS IoT Core**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.

1. Choose the menu on your rule and choose **Disable** or **Delete**\.  
![\[AWS IoT Core "Rules" page screenshot with a rule's menu open and highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-disable-delete-rule-console.png)

**To delete a DynamoDB table**

1. Navigate to the [DynamoDB console](https://console.aws.amazon.com/dynamodb/)\.

1. In the left navigation pane, choose **Tables**\.

1. Choose the table you created earlier, **WindSpeedData**\.

1. Choose **Delete table**\.  
![\[DynamoDB "Table" page screenshot with "Delete table" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/dynamodb-delete-table-console.png)

1. In the **Delete table** dialog, choose **Delete**\.  
![\[DynamoDB "Delete table" dialog screenshot with "Delete" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/dynamodb-confirm-delete-table-console.png)

## Troubleshooting a rule<a name="dynamodb-tutorial-troubleshoot-rule"></a>

Follow the steps in this procedure to troubleshoot your rule if the demo asset data isn't appearing in the DynamoDB table as expected\. In this procedure, you configure the republish rule action as an error action to view error messages in the MQTT test client\. You can also configure logging to CloudWatch Logs to troubleshoot\. For more information, see [Monitoring with CloudWatch Logs](https://docs.aws.amazon.com/iot/latest/developerguide/cloud-watch-logs.html) in the *AWS IoT Developer Guide*\.

**To add a republish error action to a rule**

1. Navigate to the [AWS IoT console](https://console.aws.amazon.com/iot/)\.

1. In the left navigation pane, choose **Act** and then choose **Rules**\.

1. Choose the rule that you created earlier\.  
![\[AWS IoT Core "Rules" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-choose-rule-console.png)

1. Under **Error action**, choose **Add action**\.

1. Choose **Republish a message to an AWS IoT topic**\.  
![\[AWS IoT Core "Select an action" page screenshot with the Republish action highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-choose-republish-action-console.png)

1. Choose **Configure action** at the bottom of the page\.

1. In **Topic**, enter **windspeed/error**\. AWS IoT Core will republish error messages to this topic\.  
![\[AWS IoT Core "Configure Republish action" page screenshot with the "Topic" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-configure-republish-action-console.png)

1. Choose **Select** to grant AWS IoT Core access to perform the error action using the role that you created earlier\.

1. Choose **Select** next to your role\.  
![\[AWS IoT Core "Configure Republish action" page screenshot with the role select button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-select-role-console.png)

1. Choose **Update Role** to add the additional permissions to the role\.  
![\[AWS IoT Core "Configure Republish action" page screenshot with the update role button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-update-role-console.png)

1. Choose **Add action** to finish adding the error action\.

1. Choose the back arrow in the upper left of the console to return to the AWS IoT Core console home\.

After you set up the republish error action, you can view the error messages in the MQTT test client in AWS IoT Core\.

In the following procedure, you subscribe to the error topic in the MQTT test client\.

**To subscribe to the error action topic**

1. In the AWS IoT Core console's left navigation page, choose **Test**\.

1. In the **Subscription topic** field, enter **windspeed/error** and choose **Subscribe to topic**\.  
![\[AWS IoT Core "MQTT client" page screenshot with the "Subscribe to topic" button highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/interact-dynamo-db/rule-subscribe-error-topic-console.png)

1. Watch for error messages to appear and explore the `failures` array in an error message to diagnose the following common issues:
   + Typos in the rule query statement
   + Insufficient role permissions

   If errors don't appear, check that your rule is enabled and that you subscribed to the same topic that you configured in the republish error action\. If errors still don't appear, check that your demo wind farm assets still exist and that you enabled notifications on the wind speed properties\. If your demo assets expired and disappeared from AWS IoT SiteWise, you can create a new demo and update the rule query statement to reflect the updated asset model and property IDs\.
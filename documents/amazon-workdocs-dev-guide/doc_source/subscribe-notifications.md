# Subscribe to notifications<a name="subscribe-notifications"></a>

You can subscribe to notifications that Amazon WorkDocs sends when specific actions occur\.

**To subscribe to WorkDocs notifications**

1. Prepare your endpoint to process Amazon SNS messages\. For more information, see [Make sure your endpoint is ready to process Amazon SNS messages](https://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.html#SendMessageToHttp.prepare) in the *Amazon Simple Notification Service Developer Guide*\.

1. Enable notifications for the IAM role that your application is using\. See [Managing notifications for an IAM user or a role](manage-notifications.md)\.

1. Create the subscription request as follows:

   ```
   CreateNotificationSubscriptionRequest request = new CreateNotificationSubscriptionRequest();
   request.setOrganizationId("d-1234567890");
   request.setProtocol(SubscriptionProtocolType.Https);
   request.setEndpoint("https://my-webhook-service.com/webhook");
   request.setSubscriptionType(SubscriptionType.ALL);
   CreateNotificationSubscriptionResult result = amazonWorkDocsClient.createNotificationSubscription(request);
   System.out.println("WorkDocs notifications subscription-id: " result.getSubscription().getSubscriptionId());
   ```

**SNS Notifications**

The message includes the following information:
+ `organizationId` — The ID of the organization\.
+ `parentEntityType` — The type of the parent \(`Document` \| `DocumentVersion` \| `Folder`\)\.
+ `parentEntityId` — The ID of the parent\.
+ `entityType` — The type of the entity \(`Document` \| `DocumentVersion` \| `Folder`\)\.
+ `entityId` — The ID of the entity\.
+ action — The action, which can be one of the following values:
  + `delete_document`
  + `move_document`
  + `recycle_document`
  + `rename_document`
  + `revoke_share_document`
  + `share_document`
  + `upload_document_version`

You can get a Amazon WorkDocs organization ID from the AWS console using the following steps:

**To get an organization ID**

1. In the [AWS Directory Service console](https://console.aws.amazon.com/directoryservicev2/) navigation pane, select **Directories**\.

1. The **Directory ID** corresponding to your Amazon WorkDocs site is the Organization ID for that site\.
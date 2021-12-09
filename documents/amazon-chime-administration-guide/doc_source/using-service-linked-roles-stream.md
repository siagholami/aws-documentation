# Using roles to stream Amazon Chime Voice Connector media to Kinesis<a name="using-service-linked-roles-stream"></a>

Amazon Chime uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Amazon Chime\. Service\-linked roles are predefined by Amazon Chime and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up Amazon Chime more efficient because you aren't required to manually add the necessary permissions\. Amazon Chime defines the permissions of its service\-linked roles, and unless defined otherwise, only Amazon Chime can assume its roles\. The defined permissions include the trust policy and the permissions policy\. The permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting their related resources\. This protects your Amazon Chime resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html)\. Look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-linked role permissions for Amazon Chime Voice Connectors<a name="service-linked-role-permissions-stream"></a>

Amazon Chime Voice Connectors use the service\-linked role named **AWSServiceRoleForAmazonChimeVoiceConnector** – Allows Amazon Chime Voice Connectors to call AWS services on your behalf\. For more information about how to start media streaming for your Amazon Chime Voice Connector, see [Streaming Amazon Chime Voice Connector media to Kinesis](start-kinesis-vc.md)\.

The AWSServiceRoleForAmazonChimeVoiceConnector service\-linked role trusts the following services to assume the role:
+ `voiceconnector.chime.amazonaws.com`

The role permissions policy allows Amazon Chime to complete the following actions on the specified resources:
+ Action: `chime:GetVoiceConnector*` on `all AWS resources`
+ Action: `kinesisvideo:*` on `arn:aws:kinesisvideo:us-east-1:111122223333:stream/ChimeVoiceConnector-*`

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a service\-linked role for Amazon Chime Voice Connectors<a name="create-service-linked-role-stream"></a>

You don't need to manually create a service\-linked role\. When you start Kinesis media streaming for your Amazon Chime Voice Connector in the AWS Management Console, the AWS CLI, or the AWS API, Amazon Chime creates the service\-linked role for you\. 

You can also use the IAM console to create a service\-linked role with the **Chime Voice Connector** use case\. In the AWS CLI or the AWS API, create a service\-linked role with the `voiceconnector.chime.amazonaws.com` service name\. For more information, see [Creating a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\. If you delete this service\-linked role, you can use this same process to create the role again\.

## Editing a service\-linked role for Amazon Chime Voice Connectors<a name="edit-service-linked-role-stream"></a>

Amazon Chime does not allow you to edit the AWSServiceRoleForAmazonChimeVoiceConnector service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for Amazon Chime Voice Connectors<a name="delete-service-linked-role-stream"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up your service\-linked role before you can manually delete it\.

### Cleaning up a service\-linked role<a name="service-linked-role-review-before-delete-stream"></a>

Before you can use IAM to delete a service\-linked role, you must first delete any resources used by the role\.

**Note**  
If the Amazon Chime service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To delete Amazon Chime resources used by the AWSServiceRoleForAmazonChimeVoiceConnector \(console\)**
+ Stop media streaming for all the Amazon Chime Voice Connectors in your Amazon Chime account\.

  1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

  1. For **Calling**, choose **Voice connectors**\.

  1. Choose the name of the Amazon Chime Voice Connector\.

  1. Choose **Streaming**\.

  1. For **Send to Kinesis Video Streams**, choose **Stop**\.

  1. Choose **Save**\.

**To delete Amazon Chime resources used by the AWSServiceRoleForAmazonChimeVoiceConnector \(AWS CLI\)**
+ Use the **delete\-voice\-connector\-streaming\-configuration** command in the AWS CLI to stop media streaming for all Amazon Chime Voice Connectors in your account\.

  ```
  aws chime delete-voice-connector-streaming-configuration --voice-connector-id abcdef1ghij2klmno3pqr4
  ```

**To delete Amazon Chime resources used by the AWSServiceRoleForAmazonChimeVoiceConnector \(API\)**
+ Use the **DeleteVoiceConnectorStreamingConfiguration** API operation to stop media streaming for all Amazon Chime Voice Connectors in your account\. For more information, see [DeleteVoiceConnectorStreamingConfiguration](https://docs.aws.amazon.com/chime/latest/APIReference/API_DeleteVoiceConnectorStreamingConfiguration.html) in the *Amazon Chime API Reference*\.

### Manually delete the service\-linked role<a name="slr-manual-delete-stream"></a>

Use the IAM console, the AWS CLI, or the AWS API operation to delete the AWSServiceRoleForAmazonChimeVoiceConnector service\-linked role\. For more information, see [Deleting a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Amazon Chime service\-linked roles<a name="slr-regions-stream"></a>

Amazon Chime supports using service\-linked roles in all of the AWS Regions where the service is available\. For more information, see [Amazon Chime endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/chime.html#chime_region)\.
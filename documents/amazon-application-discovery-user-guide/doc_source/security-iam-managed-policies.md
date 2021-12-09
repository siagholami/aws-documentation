# AWS Managed \(Predefined\) Policies for Application Discovery Service<a name="security-iam-managed-policies"></a>

An *AWS managed policy* is an AWS Identity and Access Management \(IAM\) policy that is created and administered by AWS\. Managed policies are predefined to provide permissions for common use cases\. For more information about managed policies, see [Managed Policies and Inline Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html) in the *IAM User Guide*\.

The AWS managed policies listed in this topic are used to control access to AWS Application Discovery Service\. An administrator AWS account by default inherits all the policies required for accessing Application Discovery Service\. 

If your account is a non\-administrative account, to access Application Discovery Service, you need to request that your administrator add one or more of the following managed policies to your IAM user account\. For information about how to attach managed policies to an account, see [Creating an IAM Non\-Administrative User](setting-up-iam.md#setting-up-iam-non-admin)\. 

**AWSApplicationDiscoveryServiceFullAccess**  
The `AWSApplicationDiscoveryServiceFullAccess` policy grants an IAM user account access to the Application Discovery Service and Migration Hub APIs\.   
An IAM user account with this policy attached can configure Application Discovery Service, start and stop agents, start and stop agentless discovery, and query data from the AWS Discovery Service database\. For an example of this policy, see [Granting Full Access to Application Discovery Service](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-ads-fullaccess)\.

**AWSApplicationDiscoveryAgentAccess**  
The `AWSApplicationDiscoveryAgentAccess` policy grants the Application Discovery Agent access to register and communicate with Application Discovery Service\.  
You attach this policy to any user whose credentials are used by Application Discovery Agent\.   
This policy also grants the user access to Arsenal\. Arsenal is an agent service that is managed and hosted by AWS\. Arsenal forwards data to Application Discovery Service in the cloud\. For an example of this policy, see [Granting Access to Discovery Agents](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-ads-agentaccess)\.

**AWSAgentlessDiscoveryService**  
The `AWSAgentlessDiscoveryService` policy grants the AWS Agentless Discovery Connector that is running in your VMware vCenter Server access to register, communicate with, and share connector health metrics with Application Discovery Service\.   
You attach this policy to any user whose credentials are used by the connector\.  
For an example of this policy, see [Granting AWS Agentless Discovery Connector Access](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-ads-agentless)\.

**ApplicationDiscoveryServiceContinuousExportServiceRolePolicy**  
If your IAM account has the `AWSApplicationDiscoveryServiceFullAccess` policy attached, `ApplicationDiscoveryServiceContinuousExportServiceRolePolicy` is automatically attached to your account when you turn on Data Exploration in Amazon Athena\.  
This policy allows AWS Application Discovery Service to create Amazon Kinesis Data Firehose streams to transform and deliver data collected by AWS Application Discovery Service agents to an Amazon S3 bucket in your AWS account\.   
In addition, this policy creates an AWS Glue Data Catalog with a new database called *application\_discovery\_service\_database* and table schemas for mapping data collected by the agents\. For an example of this policy, see [ Granting permissions for Agent Data Collection](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-ads-export-service)\.

**AWSDiscoveryContinuousExportFirehosePolicy**  
The `AWSDiscoveryContinuousExportFirehosePolicy` policy is required to use Data Exploration in Amazon Athena\. It allows Amazon Kinesis Data Firehose to write data collected from Application Discovery Service to Amazon S3\. For information about using this policy, see [ Creating the AWSApplicationDiscoveryServiceFirehose Role](#security-iam-managed-policies-create-firehouse-role)\. For an example of this policy, see [ Granting Permissions for Data Collection](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-ads-export-firehose)\.

## Creating the AWSApplicationDiscoveryServiceFirehose Role<a name="security-iam-managed-policies-create-firehouse-role"></a>

An administrator attaches managed policies to your IAM user account\. When using the `AWSDiscoveryContinuousExportFirehosePolicy` policy, the administrator must first create a role named **AWSApplicationDiscoveryServiceFirehose** with Kinesis Data Firehose as a trusted entity and then attach the `AWSDiscoveryContinuousExportFirehosePolicy` policy to the role, as shown in the following procedure\.

**To create the **AWSApplicationDiscoveryServiceFirehose** IAM role**

1. In the IAM console, choose **Roles** on the navigation pane\.

1. Choose **Create Role**\.

1. Choose **Kinesis**\.

1. Choose **Kinesis Firehose** as your use case\.

1. Choose **Next: Permissions**\.

1. Under **Filter Policies** search for **AWSDiscoveryContinuousExportFirehosePolicy**\.

1. Select the box beside **AWSDiscoveryContinuousExportFirehosePolicy**, and then choose **Next: Review**\.

1. Enter **AWSApplicationDiscoveryServiceFirehose** as the role name, and then choose **Create role**\.
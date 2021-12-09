--------

--------

# Prepare for Cloud Deployments<a name="iot-tg-gs-environment-cloud"></a>

This topic explains how to allow AWS IoT Things Graph to assume an IAM role with the appropriate permissions when it executes your flows in the cloud\.

## Create and Configure an IAM Role for Cloud Deployments<a name="iot-tg-gs-environment-cloud-role"></a>

Cloud deployments require you to use an IAM role to allow AWS IoT Things Graph to execute the flows in the deployments on your behalf\. A role that a service assumes to perform actions on your behalf is called a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role)\. For more information about this kind of role, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html)\.

 The role you create should have policies that allow AWS IoT Things Graph to perform all of the actions in your workflow\. Workflows that contain devices or device models that publish and subscribe to MQTT messages need permission for `Iot:Connect`, `Iot:DescribeEndpoint`, and `Iot:Publish`\. The getting started examples in this section also need permission for `Lambda`\. If you are using any other web service in your workflows, add the appropriate policies\. For sample AWS IoT policies that assign MQTT publish and subscribe permissions, see [Publish/Subscribe Policy Examples](https://docs.aws.amazon.com/iot/latest/developerguide/pub-sub-policy.html)\.

When you deploy AWS IoT Things Graph flows to the cloud, you need to specify the IAM role that AWS IoT Things Graph assumes when it executes the flow in the cloud\. If your flow uses other services, then your role must also have the appropriate permissions for those services\.

For information about securing AWS resources, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html)\. For information about best practices for attaching policies to IAM roles, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) and [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies)\.

This must have a trust relationship with AWS IoT Things Graph\. The following instructions describe how to create this role\.

1. In the IAM console \([https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\), choose **Roles**, and then choose **Create Role**\.

1. On the **Choose the service that will use this role** page, choose **IoT Things Graph**, and then choose **Next: Permissions**\.

1. On the **Attach permissions policies** page, choose policies that contain permissions that your flows require\. All flows require read\-write permissions to AWS IoT, and the example flows in this section require read permission to AWS Lambda\. Choose **Next: Tags**\.

1. On the **Add tags \(optional\)** page, add optional tags that help you categorize your role\. Choose **Next: Review**\.

1. On the **Create role** page, enter a name for your role\. Choose **Create role**\.

After you create this role, copy the role ARN so that you can use it when you create cloud flow configurations\.
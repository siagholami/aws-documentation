# AWS Identity and Access Management in AWS IoT Analytics<a name="security-iam"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that helps an administrator securely control access to AWS resources\. IAM administrators control who can be *authenticated* \(signed in\) and *authorized* \(have permissions\) to use AWS IoT Analytics resources\. IAM is an AWS service that you can use with no additional charge\.

## Audience<a name="iam-audience"></a>

How you use AWS Identity and Access Management \(IAM\) differs\. depending on the work you do in AWS IoT Analytics\.

**Service user** \- If you use the AWS IoT Analytics service to do your job, then your administrator provides you with the credentials and permissions that you need\. As you use more AWS IoT Analytics features to do your work, you might need additional permissions\. understanding how access is managed can help you request the right permissions from your administrator\. If you cannot access a feature in AWS IoT Analytics, see [Troubleshooting AWS IoT Analytics identity and access](https://docs.aws.amazon.com/iotanalytics/latest/userguide/security.html#security-iam-troubleshoot)\.

**Service administrator** \- If you're in charge of AWS IoT Analytics resources at your company, you probably have full access to AWS IoT Analytics\. It's your job to determine which AWS IoT Analytics features and resources your employees should access\. You must then submit requests to your IAM administrator to change the permissions of your service users\. Review the information on this page to understand the basic concepts of IAM\. To learn more about how your company can use IAM with AWS IoT Analytics, see [https://docs.aws.amazon.com/iotanalytics/latest/userguide/security.html#security-iam-service-with-iam](https://docs.aws.amazon.com/iotanalytics/latest/userguide/security.html#security-iam-service-with-iam)\.

**IAM administrator** \- If you're an IAM administrator, you might want to learn details about how you can write policies that you can use in IAM, see [ AWS IoT Analytics identity\-based policy examples](https://docs.aws.amazon.com/iotanalytics/latest/userguide/security.html#security-iam-id-based-policy-examples)\.
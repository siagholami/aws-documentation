# Disabling Sharing with AWS Organizations<a name="disable-sharing"></a>

If you previously enabled sharing with AWS Organizations and you no longer need to share resources with your entire organization or organizational units, you can disable sharing\. When you disable sharing with AWS Organizations, all organizations or organizational units are removed from the resource shares that you have created and they lose access to the shared resources\.

**To disable sharing with AWS Organizations**

1. Disable trusted access to AWS Organizations using the AWS Organizations [disable\-aws\-service\-access](https://docs.aws.amazon.com/cli/latest/reference/organizations/disable-aws-service-access.html) AWS CLI command\.

   ```
   $  aws organizations disable-aws-service-access --service-principal ram.amazonaws.com
   ```
**Important**  
When you disable trusted access to AWS Organizations, principals within your organizations are removed from all resource shares and lose access to those shared resources\.

1. Use the IAM console, the IAM AWS CLI, or the IAM API to delete the **AWSServiceRoleForResourceAccessManager** service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.
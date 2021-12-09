# Deleting a Service\-Linked Role for Application Discovery Service<a name="delete-service-linked-role"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up your service\-linked role before you can manually delete it\.

## Cleaning Up the Service\-Linked Role<a name="service-linked-role-review-before-delete"></a>

Before you can use IAM to delete a service\-linked role, you must first delete any resources used by the role\.

**Note**  
If Application Discovery Service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To delete Application Discovery Service resources used by the AWSServiceRoleForApplicationDiscoveryServiceContinuousExport service\-linked role from the Migration Hub Console**

1. In the navigation pane, choose **Data Collectors**\.

1. Choose the **Agents** tab\.

1. Toggle the **Data exploration in Athena** slider to the Off position\.

**To delete Application Discovery Service resources used by the AWSServiceRoleForApplicationDiscoveryServiceContinuousExport service\-linked role from the AWS CLI**

1. Install the AWS CLI for your operating system \(Linux, macOS, or Windows\)\. See the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/) for instructions\.

1. Open the Command prompt \(Windows\) or Terminal \(Linux or macOS\)\.

   1. Type `aws configure` and press Enter\.

   1. Enter your AWS Access Key Id and AWS Secret Access Key\.

   1. Enter `us-west-2` for the Default Region Name\.

   1. Enter `text` for Default Output Format\.

1. Type the following command:

   ```
   aws discovery stop-continuous-export --export-id <export ID>
   ```

   1. If you don't know the export\-ID of the continuous export you want to stop, enter the following command to see the continuous export's ID:

     ```
     aws discovery describe-continuous-exports
     ```

1. Enter the follow command to ensure that Continuous Export has stopped by verifying its return status is "INACTIVE":

   ```
   aws discovery describe-continuous-export
   ```

## Manually Delete the Service\-Linked Role<a name="slr-manual-delete"></a>

You can delete the AWSServiceRoleForApplicationDiscoveryServiceContinuousExport service\-linked role by using the IAM console, the IAM CLI, or the IAM API\. If you no longer need to use the Discovery Service \- Continuous Export features that require this service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

**Note**  
You must first clean up your service\-linked role before you can delete it\. See [Cleaning Up the Service\-Linked Role](#service-linked-role-review-before-delete)\.

 

 
# Creating a Service\-Linked Role for Application Discovery Service<a name="create-service-linked-role"></a>

You don't need to manually create a service\-linked role\. The AWSServiceRoleForApplicationDiscoveryServiceContinuousExport service\-linked role is automatically created when Continuous Export is implicitly turned on by a\) confirming options in the dialog box presented from the Data Collectors page after you choose “Start data collection”, or click the slider labeled, “Data exploration in Athena”, or b\) when you call the StartContinuousExport API using the AWS CLI\.  

**Important**  
This service\-linked role can appear in your account if you completed an action in another service that uses the features supported by this role\.  To learn more, see [A New Role Appeared in My IAM Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_roles.html#troubleshoot_roles_new-role-appeared)\.

## Creating the Service\-Linked Role from the Migration Hub Console<a name="create-service-linked-role-service-console"></a>

You can use the Migration Hub console to create the AWSServiceRoleForApplicationDiscoveryServiceContinuousExport service\-linked role\.

**To create the service\-linked role \(console\)**

1. In the navigation pane, choose **Data Collectors**\.

1. Choose the **Agents** tab\.

1. Toggle the **Data exploration in Athena** slider to the On position\.

1. In the dialog box generated from the previous step, click the checkbox agreeing to associated costs and choose **Continue** or **Enable**\.

## Creating the Service\-Linked Role from the AWS CLI<a name="create-service-linked-role-service-cli"></a>

You can use Application Discovery Service commands from the AWS Command Line Interface to create the AWSServiceRoleForApplicationDiscoveryServiceContinuousExport service\-linked role\.

This service\-linked role is automatically created when you start Continuous Export from the AWS CLI \(the AWS CLI must first be installed in your environment\)\.

**To create the service\-linked role \(CLI\) by starting Continuous Export from the AWS CLI**

1. Install the AWS CLI for your operating system \(Linux, macOS, or Windows\)\. See the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/) for instructions\.

1. Open the Command prompt \(Windows\) or Terminal \(Linux or macOS\)\.

   1. Type `aws configure` and press Enter\.

   1. Enter your AWS Access Key Id and AWS Secret Access Key\.

   1. Enter `us-west-2` for the Default Region Name\.

   1. Enter `text` for Default Output Format\.

1. Type the following command:

   ```
   aws discovery start-continuous-export
   ```

You can also use the IAM console to create a service\-linked role with the **Discovery Service \- Continuous Export** use case\. In the IAM CLI or the IAM API, create a service\-linked role with the `continuousexport.discovery.amazonaws.com` service name\. For more information, see [Creating a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\. If you delete this service\-linked role, you can use this same process to create the role again\.
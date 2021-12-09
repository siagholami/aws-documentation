# Troubleshooting AWS Launch Wizard for SAP<a name="launch-wizard-sap-troubleshooting"></a>

Each application in your account in the same AWS Region can be uniquely identified by the application name specified at the time of a deployment\. The application name can be used to view the details related to the application launch\.

**Topics**
+ [Launch Wizard provisioning events](#launch-wizard-sap-provisioning)
+ [CloudWatch Logs](#launch-wizard-sap-logs)
+ [AWS CloudFormation stack](#launch-wizard-sap-cloudformation)
+ [Application launch quotas](#launch-wizard-sap-quotas)
+ [Errors](#launch-wizard-sap-errors)

## Launch Wizard provisioning events<a name="launch-wizard-sap-provisioning"></a>

Launch Wizard captures events from SSM Automation and AWS CloudFormation to track the status of an ongoing application deployment\. If an application deployment fails, you can view the deployment events for this application by selecting **Deployments** from the navigation pane\. A failed event shows a status of **Failed** along with a failure message\. 

## CloudWatch Logs<a name="launch-wizard-sap-logs"></a>

Launch Wizard streams provisioning logs from all of the AWS log sources, such as AWS CloudFormation, SSM, and CloudWatch Logs\. CloudWatch Logs for a given application name can be viewed on the CloudWatch console for the log group name `LaunchWizard-APPLICATION_NAME` and log stream `ApplicationLaunchLog`\. 

## AWS CloudFormation stack<a name="launch-wizard-sap-cloudformation"></a>

Launch Wizard uses AWS CloudFormation to provision the infrastructure resources of an application\. AWS CloudFormation stacks can be found in your account using the AWS CloudFormation [describe\-stacks](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-cfn-describing-stacks.html) API\. Launch Wizard launches various stacks in your account for validation and application resource creation\. The following are the relevant filters for the [describe\-stacks](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-cfn-describing-stacks.html) API\.
+ **Application resources**

  `LaunchWizard-APPLICATION_NAME`\. 

You can view the status of these AWS CloudFormation stacks\. If any of them fail, you can view the cause of the failure\.

## Application launch quotas<a name="launch-wizard-sap-quotas"></a>

Launch Wizard allows for a maximum of 50 active applications \(with status `in progress` or `completed`\) for any given application type\. If you want to increase this limit, contact [AWS Support](https://aws.amazon.com/contact-us)\.

## Errors<a name="launch-wizard-sap-errors"></a>

**Your requested instance type is not supported in your requested Availability Zone**
+ **Cause:** This failure might occur during the launch of your instance, or during the validation of the instances that Launch Wizard launches in your selected subnets\. 
+ **Solution:** For this scenario, you must choose a different Availability Zone and retry the deployment from the initial page of the Launch Wizard console\.

**Infrastructure template already exists**
+ **Cause:** This failure occurs when you choose to create a new infrastructure configuration and then navigate back to the first step in the wizard to review or adjust any settings\. Launch Wizard has already registered the configuration template, so choosing **Next** results in the error "Template name already exists\. Select a new template name\." 
+ **Solution:** 

  Perform one of the following actions to continue with your deployment\.
  + Change the name of the configuration template and continue\.
  + Choose another template and continue\.
  + Delete the template causing the error by navigating to the **Saved Infrastructure Setting** tab under **Deployments – SAP**, and then continue with your configuration using the same configuration name\.
# AWS Service Catalog Service Actions<a name="using-service-actions"></a>

AWS Service Catalog enables you to reduce administrative maintenance and end user training while adhering to compliance and security measures\. With service actions, as the administrator you can enable end users to perform operational tasks, troubleshoot issues, run approved commands, or request permissions in AWS Service Catalog\. You use [AWS Systems Manager documents](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-ssm-docs.html) to define service actions\. The [AWS Systems Manager documents](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-ssm-docs.html) provide access to pre\-defined actions that implement AWS best practices, such as Amazon EC2 stop and reboot, and you can define custom actions too\.

In this tutorial, you provide end users with the ability to restart an Amazon EC2 instance\. You add the necessary permissions, define the service action, associate the service action with a product, and test the end user experience using the action with a provisioned product\.

## Prerequisites<a name="service-actions-prerequisites"></a>

This tutorial assumes that you have full AWS administrator permissions, you are already familiar with AWS Service Catalog, and that you already have a base set of products, portfolios, and users\. If you are not familiar with AWS Service Catalog, complete the [Setting Up](setup.md) and [Getting Started](getstarted.md) tasks before using this tutorial\.

**Topics**
+ [Prerequisites](#service-actions-prerequisites)
+ [Step 1: Configure end user permissions](#service-actions-configure-end-user-permissions)
+ [Step 2: Create a service action](#service-actions-create-new-service-action)
+ [Step 3: Associate the service action with a product version](#service-actions-associate-with-product-version)
+ [Step 4: Test the end user experience](#service-actions-test-end-user-experience)
+ [Step 5: Troubleshooting](#service-actions-troubleshooting)

## Step 1: Configure end user permissions<a name="service-actions-configure-end-user-permissions"></a>

End user accounts must have the necessary permissions to view and perform specific service actions\. In this example, the end user needs permission to access the AWS Service Catalog service actions feature and to perform an Amazon EC2 restart\.

**To update permissions**

1. Open the AWS Identity and Access Management \(IAM\) console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. From the menu, choose **Groups**\.

1. On the **Groups** page, select the groups used by end users to access AWS Service Catalog resources\. In this example, we select the end user group\. In your own implementation, choose the group that is used by the relevant end users\.

1. On the **Permissions** tab of your group’s detail page, you either create a new policy or edit an existing policy\. In this example, we add permissions to the existing policy by selecting the custom policy created for the group’s AWS Service Catalog Provision and Terminate permissions\.

1. On the **Policy** page, choose **Edit Policy** to add the necessary permissions\. You can use either the visual editor or the JSON editor to edit the policy\. In this example, we use the JSON editor to add the permissions\. For this tutorial, add the following permissions to the policy:

   ```
   {
   	"Version": "2012-10-17",
   	"Statement": [
   		{
   			"Sid": "Stmt1536341175150",
   			"Action": [
   				"servicecatalog:ListServiceActionsForProvisioningArtifact",
   				"servicecatalog:ExecuteprovisionedProductServiceAction",
   				"ssm:DescribeDocument",
   				"ssm:GetAutomationExecution",
   				"ssm:StartAutomationExecution",
   				"ssm:StopAutomationExecution",
   				"cloudformation:ListStackResources",
   				"ec2:DescribeInstanceStatus",
   				"ec2:StartInstances",
   				"ec2:StopInstances"
   			],
   			"Effect": "Allow",
   			"Resource": "*"
   		}
   	]
   }
   ```

1. After you edit the policy, review and approve the change to the policy\. Users in the end user group now have the necessary permissions to perform the Amazon EC2 restart action in AWS Service Catalog\.

## Step 2: Create a service action<a name="service-actions-create-new-service-action"></a>

Next, you create a service action to restart Amazon EC2 instances\.

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/sc/](https://console.aws.amazon.com/servicecatalog/)\.

1. From the menu, choose **Service actions**\.

1. On the **service actions** page, choose **Create new action**\.

1. On the **Create action** page, choose an AWS Systems Manager document to define the service action\. The Amazon EC2 Instance Restart action is defined by an AWS Systems Manager document, so we keep the default option on the drop\-down menu, **Amazon documents**\.

1. Choose the **AWS\-RestartEC2Instance** action\.

1. Provide a name and description for the action that make sense for your environment and team\. The end user will see this description, so choose something that helps them understand what the action does\.

1. Under **Parameter and target configuration**, choose the SSM document parameter that will be the target of the action \(for example, the **Instance ID**\), and choose the target of the parameter\. Choose **Add parameter** to add additional parameters\. 

1. Under **Permissions**, choose a role\. We are using default permissions for this example\. Other permission configurations are possible and are defined on this page\.

1. After you have reviewed the configuration, choose **Create action**\.

1. On the next page, a confirmation appears when the action has been created and is ready to use\.

## Step 3: Associate the service action with a product version<a name="service-actions-associate-with-product-version"></a>

After you define an action, you must associate a product with that action\.

1. On the **Service actions** page, choose **AWS\-RestartEC2instance**, and then choose **Associate action**\. 

1. On the **Associate action** page, choose the product that you want your end users to take the service action on\. In this example, we choose **Linux Desktop**\.

1. Select a product version\. Note that you can use the topmost check box to select all versions\.

1. Choose **Associate action**\.

1. On the next page, a confirmation message appears\.

You have now created the service action in AWS Service Catalog\. The next step of this tutorial is to use the service action as an end user\.

## Step 4: Test the end user experience<a name="service-actions-test-end-user-experience"></a>

End users can perform service actions on provisioned products\. For the purposes of this tutorial, the end user must have at least one provisioned product\. The provisioned product should be launched from the product version that you associated with the service action in the previous step\.

**To access the service action as an end user**

1. Log in to the AWS Service Catalog console as an end user\. 

1. On the AWS Service Catalog dashboard, in the navigation pane, choose **Provisioned products list**\. The list shows the products that are provisioned for the end user's account\.

1. On the **Provisioned products list** page, choose the instance that is provisioned\.

1. On the **Provisioned product details** page, choose **Actions** in the upper right side, and then choose the **AWS\-RestartEC2instance** action\. 

1. Confirm that you want to execute the custom action\. You receive confirmation that the action has been sent\.

## Step 5: Troubleshooting<a name="service-actions-troubleshooting"></a>

If your service action execution fails, you can find the error message in the **Outputs** section of the service action execution event on the **Provisioned product** page\. Below you can see explanations for common error messages you may find\.

**Note**  
The exact text of the error message is subject to change, so you should avoid using these in any kind of automated process\.

 **Internal failure**

AWS Service Catalog experienced an internal error\. Try again later\. If the issue persists, contact customer support\. 

 **An error occurred \(ThrottlingException\) when calling the StartAutomationExecution operation**

The service action execution was throttled by the backend service, such as SSM\. 

 **Access denied while assuming the role**

 AWS Service Catalog was unable to assume the role specified in the service action definition\. Make sure that the *servicecatalog\.amazonaws\.com* principal, or a regional principal such as *servicecatalog\.us\-east\-1\.amazonaws\.com*, is whitelisted in the role's trust policy\. 

 **An error occurred \(AccessDeniedException\) when calling the StartAutomationExecution operation: User is not authorized to perform: ssm:StartAutomationExecution on the resource\.**

The role specified in the service action definition does not have permissions to invoke ssm:StartAutomationExecution\. Make sure the role has the appropriate SSM permissions\. 

 **Cannot find any resources with type *TargetType* in provisioned product**

The provisioned product does not contain any resources that match the target type specified in the SSM document, such as AWS::EC2::Instance\. Check your provisioned product for these resources or confirm the document is correct\. 

 **Document with that name does not exist**

The document specified in the service action definition does not exist\. 

 **Failed to describe SSM Automation document**

AWS Service Catalog encountered an unknown exception from SSM when trying to describe the specified document\. 

 **Failed to retrieve credentials for role**

AWS Service Catalog encountered an unknown error when assuming the specified role\. 

 **Parameter has value "*InvalidValue*" not found in *\{ValidValue1\}, \{ValidValue2\}***

 The parameter value passed to SSM is not in the allowed values list for the document\. Confirm the parameters provided are valid, and try again\. 

 **Parameter type error\. The value supplied for *ParameterName* is not a valid string\.**

The value of the parameter passed to SSM is not valid for the type on the document\. 

 **Parameter is not defined in service action definition**

A parameter was passed to AWS Service Catalog that is not defined in the service action definition\. You can only use parameters defined in the service action definition\. 

 **Step fails when it is executing/canceling action\. *Error message\.* Please refer to Automation Service Troubleshooting Guide for more diagnosis details\.**

 A step in the SSM automation document failed\. See the error in the message to troubleshoot further\. 

 **The following values for the parameter are not allowed because they are not in the provisioned product: *InvalidResourceId***

The user requested action on a resource that is not in the provisioned product\. 

 **TargetType not defined for SSM Automation document**

Service actions require SSM automation documents to have a TargetType defined\. Check your SSM automation document\. 
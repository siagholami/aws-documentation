# Validating Configurations<a name="jsd-validate-configurations"></a>

 You are now ready to validate the AWS Service Management Connector for Jira Service Desk installation procedures\. 

## AWS Service Catalog<a name="validate-sc"></a>

**To order an AWS Service Catalog product**

1. Log in to your Jira Service Desk customer portal as the end user\. 

1. In the Jira Service Desk customer portal, choose **Request AWS product**\.

1. Enter **Summary** details\.

1. Open the **AWS product request detail** menu and select a product to provision\.

1. Fill in the product request details, including product reference name, parameters, and tags\.

1.  Choose **Create** to submit the Jira Service Desk request and provision the AWS Service Catalog product\. 

1. After the request processes, a message appears indicating that your request was created\. When the product is ready to provision, the end user is notified that the product is launching\.

**To view provisioned products**

1. In the Jira Service Desk customer portal, go to **Requests** in the upper right corner\.

1. Select **My Requests** in the Jira Service Desk customer portal view\.

1. Select the AWS product you requested\.

1. The AWS product details will display, including the status of the product request, product events, and activities\. 

1. Once the product is in the **Available** status, end users can request post\-provision operations actions such as **Request update**, **Request termination**, and **Request self\-service actions**\. These actions render additional product events and activities within the request\. Once the product is terminated, the request closes in a resolved state\. 

## Systems Manager Automation<a name="jsd-sys-automation"></a>

**To execute an automation document**

1.  Log in to your Jira Service Desk customer portal as the end user\. 

1.  In the Jira Service Desk customer portal, choose **Request AWS automation**\. 

1.  Enter **Summary** details\. 

1.  Open the **AWS automation request detail** menu and select an automation document to execute\. 

1.  Fill in the automation request details, parameters and tags\. 

1.  Choose **Create** to submit the Jira Service Desk request and execute the AWS Systems Manager Automation Document\. 

1.  After the request processes, a message appears indicating that your request was created\. As the automation executes, the end user is notified of progress\. 

**To view automation executions**

1.  In the Jira Service Desk customer portal, go to **Requests** in the upper right corner\. 

1.  Select **My Requests** in the Jira Service Desk customer portal view\. 

1.  Select the AWS automation execution you requested\. The AWS automation execution details will display, including the status of the execution, request details, and steps\. 
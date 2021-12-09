# Configuring Jira Service Desk<a name="jsd-integration-configure-jsd"></a>

 The AWS Service Management Connector for Jira Service Desk is released as a conventional Jira Service Desk add\-on\. Add\-ons are code changes to the Jira software that extend its functionality or extend the functionality of Jira Service Desk software\. The Connector for Jira Service Desk add\-on is available to download in the [Atlassian Marketplace](https://marketplace.atlassian.com/apps/1221283/aws-service-catalog-connector-for-jsd)\. 

 After completing the IAM and AWS Service Catalog configurations, you must configure Jira Service Desk\. Installation tasks within Jira Service Desk include: 
+ Clear your web browser cache\.
+ Install the Jira Service Desk Connector add\-on\. 
+ Configure AWS Service Management Connector add\-on, including accounts, schedule sync, and request/approval permissions\.

## Clear Web Browser Cache<a name="jsd-clear-cache"></a>

 Clear your web browser cache to remove previously rendered Jira Service Desk forms\. 

## Installing Jira Service Desk Connector Add\-on<a name="install-jsd-connector"></a>

1. Log in to your Jira instance as an admin\.

1.  Open the admin menu and choose **Add\-ons**\. 

1.  On the **Manage add\-ons** screen, choose **Find new apps** or **Find new add\-ons** from the left side of the page\. 

1.  Find AWS Service Management Connector for JSD\. The search results should include app versions compatible with your Jira instance\. 

1.  Choose **Install** to download and install your app\. 

1.  Proceed to **Configuring AWS Accounts and Regions**\. 

 Alternatively, you can download the code from the OBR file: [AWS Service Management Connector for Jira Service Desk v1\.5\.0 OBR](https://servicecatalogconnector.s3.amazonaws.com/jira-servicedesk-connector-1.5.0-final.obr)\. 

1.  Go to **Manage apps**\. 

1.  Select **Upload app** and upload the OBR file\. 

1.  Proceed to **Configuring AWS Accounts and Regions**\. 

 The Connector for Jira Service Desk version 1\.5\.0 add\-on can be applied to the following Jira software \(Jira Service Desk\) releases: 7\.11\.2 \(JSD 3\.14\.2\) to Jira 8\.5\.1 \(JSD 4\.5\.1\)\. 

## Configuring AWS Accounts and Regions<a name="jsd-configure-accounts-regions"></a>

 Once the AWS Service Management Connector is installed, configure it by choosing the Jira administration icon in the top right, then choosing **Add\-ons**\. 

1.  From the AWS Service Catalog section on the left navigation menu, choose **AWS Accounts**\. 

1. Choose **Connect new account**\.

1. Enter the account alias \(used to identify the AWS account in the Connector\)\.

1. Enter the credentials for SC\-sync\-user\. This is the access key identity and credentials for a sync user saved from the AWS configuration\. SC\-sync\-user credentials are used to retrieve portfolios and products to make them available through Jira Service Desk\. You will have the opportunity to set the groups allowed to access these\.

1. Enter the credentials for SC\-end\-user\. This is the access key identity and credentials for the end user saved from the AWS configuration\. The SC\-end\-user credentials are used to provision products on behalf of a Jira user\.

1. Add AWS Regions containing AWS Service Catalog products and portfolios that you want available in Jira Service Desk\.

1. Choose **Test Connectivity**\.

1. Upon successful connection status, choose **Connect**\.

**Note**  
 We recommend that the sync user and end user be new users in AWS used only with AWS Service Management Connectors\. These users should have minimum required privileges\. An AWS CloudFormation template with the minimal permissions for AWS Service Management Connectors is available\. 

## Configuring AWS Service Catalog Portfolios within Jira<a name="jsd-configure-sc-portfolios"></a>

### AWS Product Access<a name="jsd-aws-product-access"></a>

This section describes how to configure AWS Service Catalog portfolios within Jira\. 

 Once your account or accounts are set up and connectivity is successful, use the **AWS Account** page to manage, for each account, which groups are permitted to access each portfolio in each Region\. You can expand and collapse each Region and edit and add groups for each portfolio\. Only users in the designated groups have access to those products\. By default, no groups have access\. 

**Note**  
At least one group must be associated to an AWS Service Catalog portfolio in order for Jira Service Desk end users to request AWS products\.

**To provision products and portfolios**

1. Choose **AWS Accounts**\.

1. Choose **Manage** for the AWS account on which you want to configure portfolios\.

1. Under **Portfolios**, expand the Region associated with the account\. Portfolios are displayed under each Region\. 

1. In the **Permission to request** column, choose **Add groups** for the portfolios that you want to make visible in Jira Service Desk\. Select the group that you want to be able to see and request AWS Service Catalog products\.
**Note**  
Because the AWS Service Management Connector for Jira Service Desk allows Jira users to provision AWS products in the portfolios their groups have access to, and to control those provisioned products, users should be reminded of the importance of maintaining the security of their Jira accounts\.

1.  If products in this portfolio do not require approvals, choose **Save**\. 

### Jira Service Desk Approvals for Products in AWS Service Catalog Portfolios<a name="jsd-product-approvals"></a>

 The AWS Service Management Connector for Jira Service Desk enables administrators to configure approvals for products at the portfolio level\. All products within a portfolio that contains approval permissions will require approval, so AWS and Jira administrators may need to collaborate on the AWS Service Catalog portfolio structure\. 

**To configure the approval process**

1. Choose **AWS Accounts**\.

1. Choose **Manage** on the AWS account for which you want to configure portfolio approvals\.

1. In the **Permission to approve** column, choose **Add groups** for the portfolios that require product approvals\.

1. Select **Require approval for provisioning**\.

1. Under **Permission to approve**, choose **Add group**\.

1. Choose **Save**\.

**Note**  
If a portfolio only has a group associated with **Permissions to request**, products within the portfolio immediately provision when the product request is submitted\. 

### Viewing Products and Budgets<a name="jsd-view-budgets"></a>

 Two other tabs in the **Admin \-> AWS Accounts \-> Manage** section let you view information on portfolios, for reference\. The **Available Products** tab lists the products in the portfolio and budgetary information on each\. The **Budgets** tab gives overall budgetary information on the portfolio\. 

### Account Settings for Other Connector Features<a name="jsd-account-settings"></a>

There are no per\-account settings for the other aspects of AWS exposed through the JSD Connector, such as AWS Config and AWS Systems Manager Automation\.

## Configuring Connector Settings \(Jira Project Enablement and Request Type\)<a name="jsd-configure-connector"></a>

 Next, the AWS Service Management Connector for Jira Service Desk requires the add\-on to be associated to a Jira project and a request type\. You can configure which Connector features are enabled for each Jira project\.

For a new installation of Connector, the default project configuration is for all Connector features \(AWS Service Catalog, AWS Config, and AWS Systems Manager\) to be enabled\. If you are upgrading an existing installation, for security reasons, new features are initially not enabled\.

**To configure the default Connector features for specific AWS services**

1. In the left navigation menu, under **AWS Service Catalog**, select **Connector settings**\. 

1. At the top, under **Connector features enabled by default**, select each feature depending whether you want projects using the default configuration to be able to use them or not\.

1. Choose **Save**\.

**To configure the Jira projects for which the AWS Service Management Connector for Jira Service Desk is enabled**

1. In the left navigation menu, under **AWS Service Management Connector**, select **Connector settings**\. 

1. Under **Projects enabled for Connector**, you must enable at least one Jira project\. You can [create a new Jira Service Desk project](https://confluence.atlassian.com/servicedeskserver043/setting-up-your-service-desk-974367545.html) or add an existing one\. Only users with access to the associated project will be able to access the Connector\. When this update is applied, the Connector adds the necessary issue types and other Jira items needed for AWS Service Catalog products to be available in those projects\. You can return to this screen and add or remove projects at any time\. 

1.  Projects initially take the default configuration in regards which Connector features are enabled\. Click **Edit** in a project row to change the configuration for individual projects\. It is permitted for projects to use more features than the default\. 

1. Choose **Save**\.

**Note**  
 For end users to be able to request AWS Service Catalog products, one or more projects must be enabled and users must have Jira permissions to create issues in the Jira project and Permission to Request in the Jira settings for the AWS Account for at least one portfolio with products\. 

 * AWS Systems Manager enablement considerations:* It Is not currently supported to have fine\-grained permissions in Jira for which users/groups should be allowed to access which AWS Systems Manager automation documents\. If a project is enabled for Systems Manager Automation, then any user with permission to create issues in that project will have the ability to run any of the automations\. Access can be restricted by limiting which users have access to projects with AWS Systems Manager Automation enabled\. 

**To configure operational settings for the AWS Service Management Connector for Jira Service Desk**

1. In the left navigation menu, under **AWS Service Management Connector**, select **Connector settings**\. 

1. Under **Operational settings**, in the **Synchronization interval** field, you can change the sync interval if you want\. This interval determines how often Jira Service Desk syncs with AWS\. Increasing this number will reduce the number of API calls to AWS but will mean it takes longer for updates in AWS portfolios and automation documents to be reflected in the Connector\. Information on actively provisioning products and ongoing automation executions updates more frequently\.

1. Choose **Save**\.

### Configuring Project Request Type Groups<a name="jsd-configure-request-type"></a>

 The AWS request type must be in a group for users to be able to access it in Jira Service Desk\. Enabling Jira projects, as described in [Configuring Connector Settings \(Jira Project Enablement and Request Type\)](#jsd-configure-connector), makes AWS product request types available, but Jira Service Desk users won't see the request type until it is added to a **Request Type Group**\. 

**To configure request types**

1. In the AWS Service Management Connector for Jira Service Desk, go to the **Connector settings ** page\.

1. In the **Projects** section, choose **add the AWS request type**\.

1. Select **Add existing request type** in the upper right\-hand corner\.

1. Select **Request AWS product** from the available request type\.

1. Select **Edit Groups** for the **Request AWS product** request type\.

1. On the **Edit groups** form, select **General**, then choose **Save**\.

**Note**  
A custom **Request AWS Product** request type was created for the Connector for Jira Service Desk, so edits to the **Request AWS Product** request type are not required\. You can add a request type to an existing group\. If you don't have a group, create a new group and add the request type to it\.
# Configuring ServiceNow<a name="configure-snow"></a>

After completing the IAM and AWS Service Catalog configurations, the next configuration area to set up is ServiceNow\. Installation tasks within ServiceNow include:
+ Clear the ServiceNow platform cache\.
+ Clear the web browser cache\.
+ Install the ServiceNow Connector scoped application, and upload and commit the ServiceNow Connector Update Set\.
+ Configure ServiceNow platform system admin components\.
+ Configure AWS Service Catalog Connector scoped application, including accounts, scheduled jobs sync, and permissions\.

## Clear the ServiceNow Platform Cache<a name="clear-cache"></a>

Before installing the AWS Service Catalog scoped app, we recommend that you clear the ServiceNow platform cache by typing in the following URL: `https://[InsertServiceNowInstanceNameHere]/cache.do`

**Note**  
Ensure that you install the update set in a non\-production/sandbox environment\. Consult a ServiceNow system administrator if you need approval to clear the ServiceNow platform cache\.

## Clear the Web Browser Cache<a name="clear-browser-cache"></a>

Clear the web browser cache to clear previous rendered product forms\. 

## Installing ServiceNow Connector Scoped Application<a name="install-snow-connector"></a>

The AWS Service Catalog Connector for ServiceNow is released as a conventional ServiceNow scoped application via a [ServiceNow Update Set](https://servicecatalogconnector.s3.amazonaws.com/AWS_SC_update_set_2.3.4.xml)\. ServiceNow update sets are code changes to the out\-of\-the\-box platform and enable developers to move code across ServiceNow instance environments\. The Connector for ServiceNow update set is available to download in the [ServiceNow store](https://store.servicenow.com/sn_appstore_store.do#!/store/application/f0b117a3db32320093a7d7a0cf961912/)\. For users installing the update set on a ServiceNow Personal Developer Instance \(PDI\), download the code from [Connector for ServiceNow version 2\.3\.4 update set\.](https://servicecatalogconnector.s3.amazonaws.com/AWS_SC_update_set_2.3.4.xml) 

 The Connector for ServiceNow version 2\.3\.4 update set may be applied to a "Madrid," "New York," or "Orlando" platform release of ServiceNow\. 

 If you do not already have a ServiceNow instance, begin with the first step below\. If you already have a ServiceNow instance, proceed to **To download AWS Service Catalog Connector for ServiceNow**\. 

**To obtain a ServiceNow instance**

1. Go to [ Obtaining a Personal Developer Instance](https://developer.servicenow.com/app.do#!/document/content/app_store_doc_getting_started_newyork_topic_lyf_bf2_3r?v=newyork)\.

1. Create ServiceNow developer program credentials\.

1. Follow the instructions for requesting a ServiceNow instance\.

1. Capture your instance details, including URL, administrative ID, and temporary password credentials\.

**To download AWS Service Catalog Connector for ServiceNow**

1.  From your ServiceNow dashboard, type **plugins** into the navigation panel in the upper left\. 

1.  When the **System Plugins** page populates, next to the dropdown that says **Name**, search for **user criteria**\. 

1.  Choose **User Criteria Scoped API** and then choose **Activate**\. 

1.  From the [ ServiceNow Store](https://store.servicenow.com/sn_appstore_store.do#!/store/application/f0b117a3db32320093a7d7a0cf961912/), download the AWS Service Catalog Connector\. When prompted, log in with your administrator credentials\. 

**To install the update set**

1.  From your ServiceNow dashboard, type **update sets** into the navigation panel in the upper left\. 

1.  Choose **Retrieved Update Sets** from the results\. 

1.  Select **Import Update Set from XML** and upload the release XML file\. 

1.  Select the **AWS Service Catalog \- 2\.3\.4** update set\. 

1.  Choose **Preview Update Set**, which makes ServiceNow validate the connector update set\. 

1.  Choose **Update**\. 

1.  Choose **Commit Update Set** to apply the update set and create the application\. This procedure should complete 100%\. 

## Configuring ServiceNow Platform System Admin Components<a name="configure-snow-connector"></a>

To enable the AWS Service Catalog Connector for ServiceNow scoped application named **AWS Service Catalog**, the system admin must configure specific platform tables, forms, and views\.

**Note**  
If you are upgrading from an earlier version, the permissions on ServiceNow Platform tables \(User Criteria, Catalog Variable Set, and Category\) are no longer needed for the Connector for ServiceNow\.

**Enable permissions on ServiceNow Platform table \(Catalog Item Category\)**

For AWS products to display under AWS portfolios as sub\-categories in the ServiceNow Service Catalog, you need to modify the Application Access form for Catalog Item Category tables\. This action is necessary because a ServiceNow scoped API is not available for the Catalog Item Category table\. 

1. Enter "Tables" in the Navigator and choose **System Definition**, then choose **Tables**\.

1. In the list of tables, search for a table with label "Catalog Item Category" \(or with the name "sc\_cat\_item\_category"\)\. The list of tables will be displayed\. Choose **Category** to view the form defining the table\.\.

1. Choose the "Application Access" tab on the form and choose the "Can Create", “Can Update, and "Can delete" checkboxes on the form\. Choose the "Update" button\.

## ServiceNow Permissions for Administrators of the Connector Scoped App\.<a name="admin-permissions-scoped-app"></a>

The AWS Service Catalog scoped app comes with two ServiceNow roles that enable access to configure the application\. This enables system admins to grant one or more users privileges to administer the application without having to open up full sysadmin access to them\. These roles can be assigned either to individual users or to one administrator user\.

**To set up application administrator privileges**

1. Type **Users** in the navigator and select **System Security – Users**\. 

1.  Select a user to grant one or both previous roles \(such as admin\) to\. You can also [Create a User](https://docs.servicenow.com/bundle/newyork-platform-administration/page/administer/users-and-groups/task/t_CreateAUser.html)\. 

1.  Choose **Edit** on the **Roles** tab of the form\. 

1.  Filter the collection of roles by the prefix “x\_”\. 

1.  Choose one or both of the following and add them to the user: **x\_126749\_aws\_sc\_account\_admin**, **x\_126749\_aws\_sc\_portfolio\_manager** 

1.  Choose **Save**\. 

**To add AWS Service Catalog to ServiceNow Service Catalog categories**

1.  Navigate to **Self Service \| Service Catalog** and select the **Add content** icon in the upper right\. 

1.  Select the **AWS Service Catalog Product** entry\. Add it to your catalog home page by choosing the first **Add Here** link on the second row of the selection panel at the bottom of the page\. 

**To add a change request type**

1.  If you are upgrading from a previous version of the AWS Service Catalog scoped app, you must remove the **AWS Product Termination** change request type before creating a new change request type\. 

1.  You must add a new change request type called **AWS Provisioned Product Event** for the scoped application to trigger an automated change request in Change Management\. For instructions, see [Add a new change request type](https://docs.servicenow.com/bundle/newyork-it-service-management/page/product/change-management/task/t_AddNewChangeType.html)\. 

1.  Open an existing change request\. 

1.  Open the context \(right\-click\) menu for **Type** and then choose **Show Choice List**\. 

1.  Choose **New** and fill in the following fields: 
   + **Table**: **Change Request**
   + **Label**: **AWS Provisioned Product Event**
   + **Value**: **AWSProvisionedProductEvent**
   + **Sequence**: pick the next unused value

1. Submit the form\.

## Configuring AWS Service Catalog Connector Scoped Application<a name="configure-sc-connector-scoped-app"></a>

Having installed and configured the AWS Service Catalog Connector for ServiceNow in the previous procedure, you must configure the AWS Service Catalog scoped application and applicable roles\.

**To configure the AWS Service Catalog scoped application and applicable roles**

1.  On your ServiceNow dashboard, create a role called **order\_aws\_sc\_products**\. This role is granted to any users with permission to order AWS Service Catalog products\. For instructions, see [Create a role](https://docs.servicenow.com/bundle/newyork-platform-administration/page/administer/roles/task/t_CreateARole.html)\. 

1.  Grant roles to the following users: 
   + **System Administrator \(admin\)**: For simplicity in this example, user **admin** is designated as the administrator of the AWS Service Catalog scoped application\. Grant this user both of the administrative permissions from the adapter, **x\_126749\_aws\_sc\_portfolio\_manager** and **x\_126749\_aws\_sc\_account\_admin**\. In a real scenario, these roles would likely be granted to two different users\.
   + **Abel Tuter**: The user **abel\.tuter** is chosen as an illustrative end user\. Grant Abel the new role **order\_aws\_sc\_products**\. This allows him to order products from AWS\.

## Fix Script for AWS Account Type Entries<a name="servicenow-script"></a>

 Version 2\.3\.4 of the Connector for ServiceNow enables ServiceNow administrators to identify AWS account type entries as End User or Sync User\. If you've installed previous versions of the Connector for ServiceNow, version 2\.3\.4 comes with a ServiceNow Fix Script that automatically updates the account type entries\. 

**To run the Fix Script**

1. In the ServiceNow dashboard, in the left menu, search for **Fix scripts**\.

1. Find the script named **Update AWS account type**\.

1. Choose **Run Fix Script**\.

## Configuring Accounts<a name="configure-accounts"></a>

1. Log in as the system administrator\. 

1. In the AWS Service Catalog scoped app **Accounts** menu, create two entries for every AWS account, one for sync and one for provisioning: **snow\-stsuser\-account** and **snow\-sync\-account\.** You need to use the keys and secret keys from the users you created in AWS\. Note that the names here are chosen for convenience to make it easy to see which IAM user they correspond to \(these are the users created in the AWS setup\)\.

   For the GovCloud regions and account entry type "Type" are required for the Connector to point to the appropriate GovCloud endpoints\. There are two new regions available: **US GovCloud \(US West\) \- FIPS 2**, and **US GovCloud \(US West\)**, used for Non\-FIPS\.

**To create SyncUser account entry**

1. Enter the name as an account entry identifier, such as **snow\-sync\-account** \(for Commercial region\), or **snow\-sync\-account\_GovCloud** \(for GovCloud region\)\.

1. Enter AWS access key and secret access key from the AWS account sync user IAM configurations\.

1. Enter account entry type of **Sync User**\. Note that this feature was added to address the unique GovCloud endpoints\.

1. Choose the Commercial or GovCloud region\. Validate this in the next section\.

1. Save or update the sync user information\.

**To create EndUser account entry**

1. Enter the name as an account entry identifier, such as **snow\-stsuser\-account** \(for Commercial region\), or **snow\-stsuser\-account\_GovCloud** \(for GovCloud region\)\.

1. Enter AWS access key and secret access key from the AWS account sync user IAM configurations\.

1. Enter account entry type of **End User**\. Note that this feature was added to address the unique GovCloud endpoints\.

1. For GovCloud users only: select the GovCloud region\. This is required to address the unique service endpoints in GovCloud\.
**Note**  
For commercial regions, do not select a region in the End User account entry\.

1. Save or update the end user information\.

## Validating Connectivity to AWS Regions<a name="validate-regions"></a>

You can now validate connectivity to AWS regions between the ServiceNow **snow\-sync\-account** and the AWS IAM SyncUser\.

**To validate connectivity to AWS regions**

1.  In the AWS Service Catalog scoped app, choose **Accounts**\. 

1.  Select **snow\-sync\-account** and choose **Validate Regions**\. 

1.  A successful connection result in the message, “Successfully performed AWS Service Catalog SearchProductsAsAdmin action in each referenced Region\.” 

 If the AWS IAM access key or secret access key are incorrect, you will receive the message similar to the following: `Error performing AWS Service Catalog SearchProductsAsAdmin action in one or more Regions: us-east-1: The security token included in the request is invalid. Check that the access key and secret access key are correct`\. 

## Manually Syncing Scheduled Jobs<a name="manual-sync-scheduled-jobs"></a>

During the initial setup, manually execute the sync instead of waiting for Scheduled Jobs to run\.

**To sync the accounts manually**

1.  Log in as system administrator\. 

1.  Find **Scheduled Jobs** in the navigator panel\. 

1.  Search for job **Sync all Accounts**, select it, and choose **Execute Now**\. 
**Note**  
If you do not see **Execute Now** in the upper left corner, choose **Configure Job Definition**\. **Execute Now** will be visible\.

## Granting Access to Portfolios<a name="grant-access-portfolios"></a>

Data is visible in the AWS Service Catalog scoped app menus after the adapter’s scheduled synchronization job has run\.

To grant access to AWS Service Catalog products in ServiceNow, you must establish a link between the AWS SnowEndUser role discovered from the **Sync All Scheduled Job** and snow\-stsuser\-account entry created in the ServiceNow AWS Service Catalog scoped app\.

**To grant access to AWS Service Catalog products in ServiceNow**

1.  In the AWS Service Catalog scoped app, choose the **Identities** module\. 

1.  Select the ARN address for the AWS SnowEndUser role and assign it to account **snow\-stsuser\-account**\. You can double\-click the cell in the account column, or click the SCEndUser user name and edit the form presented\. 

    ** Role Grants** is available within the **Identities** modules to conveniently associate the ServiceNow role **order\_aws\_sc\_products** to the AWS SnowEndUser role identity\. 

1.  Choose **New** and enter the **Role** of **order\_aws\_sc\_products** and the SnowEndUser identity\. 

1.  Choose **Submit**\. 

 The **Identities** module now has a view of the associated role\. You can test the AWS identity to determine if the ServiceNow end user with the **order\_aws\_sc\_products** role can order an AWS Service Catalog product\. 

**To test access to portfolios**

1.  Choose the **Test Authorization** button shown in the AWS identity module\.

1. If the test is successful, the message `Successfully performed SearchProducts action as arn:aws:iam::AWS Account:role/SnowEndUser` is returned\. 

1.  An unsuccessful test returns the message `Error using account…` 

1.  Given the preceding setup, Abel Tuter can now order products from AWS Service Catalog in ServiceNow\. 
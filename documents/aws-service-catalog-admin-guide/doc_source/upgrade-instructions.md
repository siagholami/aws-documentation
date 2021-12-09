# Upgrade Instructions<a name="upgrade-instructions"></a>

This section provides steps for upgrading from an earlier version of the AWS Service Catalog Connector for ServiceNow\.

**To upgrade to the latest version of the Connector**

1. Clear the ServiceNow platform cache by typing in the following URL: `https://[InsertServiceNowInstanceNameHere]/cache.do`
**Note**  
Make sure you are installing the update set in a non\-production/sandbox environment\. Consult a ServiceNow system administrator if you need approval to clear the ServiceNow platform cache\.

1. Clear the web browser cache\.

1. If you are upgrading from an earlier version, the permissions on ServiceNow Platform tables \(User Criteria and Catalog Variable Set\) are no longer needed for the Connector for ServiceNow\.

1. Enable permissions on ServiceNow Platform tables \(Category and Catalog Item Category\)\.

1. For AWS products to display under AWS portfolios as sub\-categories in the ServiceNow Service Catalog, you need to modify the Application Access form for Category and Catalog Item Category tables\.

1. Enter "Tables" in the Navigator and choose **System Definition**, **Tables**\.

1. In the list of tables, search for a table with label "Category" \(or name "sc\_category"\)\. The list of tables will be displayed\. Choose **Category** to view the form defining the table\.

1. Choose the "Application Access" tab on the form and choose the "Can Create", “Can Update, and "Can delete" checkboxes on the form\. Choose the "Update" button\.

1. Repeat the steps used on the Category table above for the "Catalog Item Category" table \(type sc\_cat\_item\_category in the “Go to Name Search” field\)\.

1.  From your ServiceNow dashboard, type **plugins** in the navigation panel in the upper left\. 

1.  When the **System Plugins** page populates, next to the dropdown that says **Name**, search for **user criteria**\. 

1.  Choose **User Criteria Scoped API** and then choose **Activate**\. 

1.  Download the **Connector for ServiceNow update set** from the [ServiceNow store](https://store.servicenow.com/sn_appstore_store.do#!/store/application/f0b117a3db32320093a7d7a0cf961912/)\. For users installing the update set on a ServiceNow Personal Developer Instance \(PDI\), download the code from [Connector for ServiceNow version 2\.3\.4 update set\.](https://servicecatalogconnector.s3.amazonaws.com/AWS_SC_update_set_2.3.4.xml) 

    The Connector for ServiceNow version 2\.3\.4 update set may be applied to a “Madrid,” "New York," or "Orlando" platform release of ServiceNow\. 

1.  From your ServiceNow dashboard, type **update sets** in the navigation panel in the upper left\. 

1.  Choose **Retrieved Update Sets** from the results\. 

1.  Select **Import Update Set from XML** and upload the release XML file\. 

1.  Select the **AWS Service Catalog Connector for ServiceNow** update set\. 

1.  Choose **Preview Update Set**, which makes ServiceNow validate the connector update set\. 

1.  Choose **Update**\. 

1.  Choose **Commit Update Set** to apply the update set and create the application\. This procedure should complete 100%\. 

**To update AWS permissions**

1. Go to [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)\. Following the instructions there, create a policy called **SCConnectorAdmin** for ServiceNow administrators to delete AWS Service Catalog products in ServiceNow that do not have self\-service actions associated\. ServiceNow administrators can also view budgets associated to AWS Service Catalog portfolios and products\. Copy the following policy and paste it into **Policy Document**:

   ```
                                   {
                   "Version": "2012-10-17",
                   "Statement": [
                       {
                           "Sid": "VisualEditor0",
                           "Effect": "Allow",
                           "Action": [
                               "servicecatalog:DisassociateProductFromPortfolio",
                               "servicecatalog:DeleteProduct",
                               "servicecatalog:DeleteConstraint",
                               "servicecatalog:DeleteProvisionedProductPlan",
                               "servicecatalog:DeleteProvisioningArtifact",
                               "servicecatalog:ListBudgetsForResource",
                               "budgets:ViewBudget"
                           ],
                           "Resource": "*"
                       }
                   ]
               }
   ```
**Note**  
The **ServiceCatalogServiceNowAdditionalPermissions** AWS policy is no longer needed for the Connector for ServiceNow\.

1. Create a policy called **ServiceCatalogSSMActionsBaseline**\. Follow the instructions at [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html), and paste the following into the JSON editor: 

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

1. Update the **AWSCloudFormationFullAccess** policy\. Choose **create policy** and then paste the following in the JSON editor:

   ```
           {
           "Version": "2012-10-17",
           "Statement": [
           {
               "Effect": "Allow",
               "Action": [
               "cloudformation:DescribeStackResource",
               "cloudformation:DescribeStackResources",
               "cloudformation:GetTemplate",
               "cloudformation:List*",
               "cloudformation:DescribeStackEvents",
               "cloudformation:DescribeStacks",
               "cloudformation:CreateStack",
               "cloudformation:DeleteStack",
               "cloudformation:DescribeStackEvents",
               "cloudformation:DescribeStacks",
               "cloudformation:GetTemplateSummary",
               "cloudformation:SetStackPolicy",
               "cloudformation:ValidateTemplate",
               "cloudformation:UpdateStack",
               "cloudformation:CreateChangeSet",
               "cloudformation:DescribeChangeSet",
               "cloudformation:ExecuteChangeSet",
               "cloudformation:DeleteChangeSet",
               "s3:GetObject"
               ],
               "Resource": "*"
           }
       ]
   }
   ```
**Note**  
**AWSCloudFormationFullAccess** now includes additional permissions for ChangeSets\.

1.  Attach the **ServiceCatalogSSMActionsBaseline** and **AWSCloudFormationFullAccess ** IAM policies to the **SCConnectLaunch** role, which were created during the [Baseline Permissions](baseline-permissions.md) setup\. 

1.  The Connector for ServiceNow includes the ability for ServiceNow administrators to view budgets related to AWS Service Catalog products and portfolios\. AWS Service Catalog administrators can create or associate budgets to portfolios and products\. For information about creating and associating budgets, see [Managing Budgets](catalogs_budgets.md)\. 

**To add a change request type**

1.  When upgrading from a previous version of the AWS Service Catalog scoped app, you must remove the **AWS Product Termination** change request type before creating a new change request type\. 

1.  You also must add a new change request type called **AWS Provisioned Product Event** for the scoped application to trigger an automated change request in Change Management\. For instructions, see [Add a new change request type](https://docs.servicenow.com/bundle/madrid-it-service-management/page/product/change-management/task/t_AddNewChangeType.html)\. 
   + Open an existing change request\.
   + Open the context menu for **Type** and then choose **Show Choice List**\.
   + Choose **New** and fill in the following fields:

     **Table** \- **Change request**

     **Label** \- **AWS Provisioned Product Event**

     **Value** \- **AWSProvisionedProductEvent**

     **Sequence** \- pick the next unused value
   + Submit the form\.
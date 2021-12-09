# Using Service Quotas Request Templates<a name="organization-templates"></a>

A *quota request template *helps you save time when customizing quotas for new accounts in your organization\. To use a template, configure the desired service quota increases for new accounts\. Then, associate the template with your organization\. Whenever new accounts are created in your organization, the template automatically requests quota increases for you\.

**Important**  
A request template can include up to 10 quota increases\.

To use a request template, you must use AWS Organizations and the new accounts must be created in the same organization\. Your organization must use the features set, [all features](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_org_support-all-features.html)\. If you use consolidated billing features, you can't use quota request templates\.

You can update the request template by adding or deleting service quotas\. You can also increase the values for any adjustable quotas\. As soon as you adjust the template, those service quota values are requested for new accounts\. Updating a request template does not update quota values for existing accounts\.

**To configure a request template**

Use the following steps to configure the quotas request template\.

1. Open the Service Quotas console at [https://console\.aws\.amazon\.com/servicequotas/](https://console.aws.amazon.com/servicequotas/)\.

1. In the navigation pane, choose **Quota request template**\. If the **Quota request template** isn't visible, choose **Organization** to open it\.

1. On the console, choose a **Region**, **service**, **quota**, and **quota value**, and then choose **Add**\.

   To add more quota increase requests to the template, choose **Repeat the previous step**\.

1. To associate the template with your organization, choose **Associate**\.

**To disassociate a request template from an organization**

If you disassociate the template from the organization, new accounts receive the AWS default quota values for all quotas\. Disassociating the template from the organization doesn't delete the service quota requests from the template\. You can edit the service quotas in the template\.

1. Open the Service Quotas console at [https://console\.aws\.amazon\.com/servicequotas/](https://console.aws.amazon.com/servicequotas/)\.

1. In the navigation pane, choose **Quota request template**\. If the **Quota request template** isn't visible, choose **Organization** to open it\.

1. To disassociate the template from the organization, choose **Disassociate**\.

**To delete a quota increase request from a request template**

You can remove, or delete, service quota requests from the template whether the template is associated with an organization, or not\. If you reach the maximum number of service quota requests, it may be necessary to delete some service quota requests\.

1. Open the Service Quotas console at [https://console\.aws\.amazon\.com/servicequotas/](https://console.aws.amazon.com/servicequotas/)\.

1. In the navigation pane, choose **Quota request template**\.

1. Select the radio button for a quota increase request\.

1. Choose **Remove**\.
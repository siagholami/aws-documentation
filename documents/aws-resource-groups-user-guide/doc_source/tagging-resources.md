# Manage tags<a name="tagging-resources"></a>

After you [find the resources](find-resources-to-tag.md) that you want to tag, you can add, remove, and edit the tags for some or all of your search results\. Tag Editor shows you any tags that are attached to resources, and whether those tags were added in Tag Editor or by using the resource's service console or by using the API\.

**Important**  
Do not store personally identifiable information \(PII\) or other confidential or sensitive information in tags\. We use tags to provide you with billing and administration services\. Tags are not intended to be used for private or sensitive data\.

**Other ways to manage your tags**  
This topic discusses tagging resources by using the Tag Editor in the AWS console\. However, there are other tools you can use to manage the tags on your AWS resources:  
You can type or script commands at your shell prompt by using the [`resourcegroupstaggingapi` commands](https://docs.aws.amazon.com/cli/latest/reference/resourcegroupstaggingapi/index.html#cli-aws-resourcegroupstaggingapi) in the AWS Command Line Interface \(AWS CLI\)\.
You can create and run PowerShell scripts by using the [AWS Resource Groups tagging API](https://docs.aws.amazon.com/powershell/latest/reference/items/ResourceGroupsTaggingAPI_cmdlets.html) in the AWS Tools for PowerShell\.
You can create and run programs with any of the available [AWS SDKs](https://docs.aws.amazon.com/index.html#sdks) by using the [Resource groups tagging APIs](https://docs.aws.amazon.com/resourcegroupstagging/latest/APIReference/), such as the [tagging APIs for Python](https://boto3.amazonaws.com/v1/documentation/api/latest/reference/services/resourcegroupstaggingapi.html) or the [tagging APIs for Java](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/ResourceGroupsTaggingAPI.html)\.

When you add, remove, or edit existing tags, you are changing tags only on those resources that you select in of the results of your **Find resources to tag** query\. You can select up to 500 resources on which to manage tags\.

**Topics**
+ [Add tags to selected resources](#tagging-resources-add)
+ [Edit tags of selected resources](#tagging-resources-edit)
+ [Remove tags from selected resources](#tagging-resources-delete)
+ [Retry failed tag changes](#tagging-resources-retry)
+ [Related information](#related-info-manage-tags)

## Add tags to selected resources<a name="tagging-resources-add"></a>

You can use Tag Editor to add tags to selected resources that are in the results of your **Find resources to tag** query\.

1. In the results of your **Find resources to tag** query, select the check boxes next to the resources you want to add tags to\. Enter a text string in **Filter resources** to filter for part of a resource's name, ID, tag keys, or tag values\. In the **Tags** column, note that resources in the results already have tags applied to them\. In the following example, the first selected EC2 instance already has two tags\.  
![\[Find resources query results with resources selected.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_results.png)

1. Choose **Manage tags of the selected resources**\.

1. On the **Manage tags** page, view the tags on the resources that you selected\. Although your original query returned more resources, note that you are adding tags only to the resources that you selected in step 1\. Choose **Add tag**\.  
![\[Manage tags page, editing tags of a selected resource.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_manage_tags_selected.png)

1. Enter a tag key and an optional tag value\. In this walkthrough, we add the tag key **Team** and the tag value **Development**\.  
![\[Manage tags page, adding a new tag.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_manage_addtag.png)
**Note**  
A resource can have a maximum of 50 user\-applied tags\. You might not be able to add new tags to a resource if you are approaching 50 user\-applied tags\. Typically, read\-only system tags do not apply to the 50\-tag limit\. Tag keys must also be unique within your selected resources\. You cannot add a new tag with a key that matches an existing tag key in your selected resources\. 

1. When you are finished adding tags, choose **Review and apply changes**\.

1. If you accept the changes, choose **Apply changes to all selected**\.  
![\[Apply tag changes confirmation window.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_apply_add_tag.png)

1. Depending on the number of resources you selected, applying new tags can take a few minutes\. Do not leave the page or open a different page in the same browser tab\. If changes were successful, a green success banner is displayed at the top of the page\. Wait for a success or failure banner to appear on the page before you continue\.

   If tag changes to some or all resources were not successful, see [Troubleshooting Tag Changes](troubleshooting-tags.md)\. After you troubleshoot and resolve the root causes of unsuccessful tag changes \(such as insufficient permissions\), you can retry tag changes on resources for which tag changes failed\. For more information, see [Retry failed tag changes](#tagging-resources-retry)\.

## Edit tags of selected resources<a name="tagging-resources-edit"></a>

You can use Tag Editor to change existing tag values on selected resources that are in the results of your [**Find resources to tag**](find-resources-to-tag.md) query\. Editing a tag changes the tag's value on all selected resources that have the same tag key\. You cannot edit a tag key, but you can delete a tag and create a new tag to replace a tag key\. This deletes all tags with that key on selected resources\.

**Important**  
Do not store personally identifiable information \(PII\) or other confidential or sensitive information in tags\. We use tags to provide you with billing and administration services\. Tags are not intended to be used for private or sensitive data\.

1. In the results of your **Find resources to tag** query, select the check boxes next to the resources for which you want to change existing tags\. Enter a text string in **Filter resources** to filter for part of a resource's name or ID\. In the **Tags** column, note that resources in the results already have tags applied to them\. In the following example, the first selected EC2 instance already has two tags\.  
![\[Find resources query results with resources selected.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_results.png)

1. Choose **Manage tags of the selected resources**\.

1. On the **Manage tags** page, in **Edit tags of selected resources**, view the tags on the resource that you selected\. Although your original query returned more resources, note that you are changing tags only on the resources that you selected in step 1\.  
![\[Manage tags page, editing tags of a selected resource.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_edit_tag.png)

1. Change, add, or delete tag values\. Existing tags must have a tag key, but tag values are optional\. In this walkthrough, we change the value of the **Team** tag to **QA**\.  
![\[Manage tags page, editing tags of a selected resource.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_change_tagvalue.png)

   **Selected resources have different tag values** is displayed in the tag value field if resources in your selection have different values for the same key\. In this case, placing your cursor in the box opens a drop\-down list of all available values for this tag key in your selected resources\.  
![\[Manage tags page, multiple tag values for selected resources.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_multiple_values_same_key.png)

   If resources in your selection have the tag value you want, the tag value is highlighted as you type it\. For example, if resources in your selection already have the tag value **QA**, the value is highlighted as you type **Q**\. The values in the drop\-down list help keep tag values consistent across resources\. The tag value is changed on all selected resources\. In this example, the tag value is changed to **QA** for all selected resources that had a **Team** tag key\. For selected resources that did not have the **Team** tag, the **Team** tag with the value **QA** is added\.

1. When you are finished changing tags, choose **Review and apply changes**\.

1. If you accept the changes, choose **Apply changes to all selected**\.  
![\[Apply tag changes confirmation window.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_apply_edittag.png)

1. Depending on the number of resources you selected, editing tags can take a few minutes\. Do not leave the page or open a different page in the same browser tab\. If changes were successful, a green success banner is displayed at the top of the page\. Wait for a success or failure banner to appear on the page before you continue\.

   If tag changes to some or all resources were not successful, see [Troubleshooting Tag Changes](troubleshooting-tags.md)\. After you troubleshoot and resolve the root causes of unsuccessful tag changes \(such as insufficient permissions\), you can retry tag changes on resources for which tag changes failed\. For more information, see [Retry failed tag changes](#tagging-resources-retry)\.

## Remove tags from selected resources<a name="tagging-resources-delete"></a>

You can use Tag Editor to remove tags from selected resources that are in the results of your [**Find resources to tag**](find-resources-to-tag.md) query\. Removing a tag deletes the tag from all selected resources that have the tag\. Because you cannot edit tag keys, you can remove tags and replace them with new tags if you need to edit a tag key\. This deletes all tags with that key on selected resources\.

1. In the results of your **Find resources to tag** query, select the check boxes next to the resources you want to remove tags from\. Enter a text string in **Filter resources** to filter for part of a resource's name or ID\.  
![\[Find resources query results with resource selected.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_results.png)

1. Choose **Manage tags of the selected resources**\.

1. On the **Manage tags** page, in **Edit tags of selected resources**, view the tags on the resources that you selected\. Although your original query returned more resources, note that you are changing tags only on the resources that you selected in step 1\.  
![\[Manage tags page, editing tags of selected resources.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_change_tagvalue.png)

1. Choose **Remove tag** next to any tags that you want to delete\. In this walkthrough, we remove the **Team** tag\.
**Note**  
Choosing **Remove tag** removes a tag from all selected resources that have the tag\. In the example shown, this removes the **Team** tag from all selected resources that currently have the **Team** tag, regardless of the tag's value\.  
![\[Manage tags page, removing tags of a selected resource.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_change_tagvalue.png)

1. Choose **Review and apply changes**\.

1. On the confirmation page, choose **Apply changes to all selected**\.

1. Depending on the number of resources you selected, removing tags can take a few minutes\. Do not leave the page or open a different page in the same browser tab\. If changes were successful, a green success banner is displayed at the top of the page\. Wait for a success or failure banner to appear on the page before you continue\.

   If tag changes to some or all resources were not successful, see [Troubleshooting Tag Changes](troubleshooting-tags.md)\. After you troubleshoot and resolve the root causes of unsuccessful tag changes \(such as insufficient permissions\), you can retry tag changes on resources for which tag changes failed\. For more information, see [Retry failed tag changes](#tagging-resources-retry)\.

## Retry failed tag changes<a name="tagging-resources-retry"></a>

If tag changes fail on at least one of your selected resources, Tag Editor displays a red banner at the bottom of the page\. The banner shows error messages for each type of failure that occurred\. For each error, the banner identifies the specific resources on which Tag Editor could not make tag changes\. After you review and [troubleshoot the errors](troubleshooting-tags.md), choose **Retry failed tag changes on resources** to retry changes only on those resources on which tag changes failed\.

![\[Manage tags results, retry failed tag changes on some resources.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_retry_failed_tag_changes_resources.png)

## Related information<a name="related-info-manage-tags"></a>
+ [AWS tagging strategies](http://aws.amazon.com/answers/account-management/aws-tagging-strategies/)
+ [Using cost allocation tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html#allocation-what)
+ [Tag Editor](tag-editor.md)
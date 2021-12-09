# Troubleshooting tag changes<a name="troubleshooting-tags"></a>

The following checklist might be helpful if errors occur when you try to apply or change tags on selected resources in [**Find resources to tag**](find-resources-to-tag.md) query results\.
+ The resource might already have the maximum number of tags\. Generally, resources can have a maximum of 50 user\-applied tags\. Read\-only system tags do not usually count toward the 50\-tag maximum\. Other users might also be adding tags to the same resource at the same time, which could raise the resource's tags to the maximum\.
+ Some services allow a different character set \(or restrict the character set that is allowed\) for creating tags\. If you have added or changed tags using special characters, review the tag requirements in the resource's service documentation to verify that those characters are allowed by the service\.
+ You might not have permissions to modify the tags for the resource\. If you do not have permissions to view existing tags on a resource, you cannot make changes to the resource's tags\.
+ You might not have adequate permissions to change the resource\. Changes to the resource's metadata might be restricted by another administrator\.
+ The resource might have been edited or deleted by another user or process\. For example, if the resource was launched as part of the creation of an AWS CloudFormation stack, and the stack was deleted or is no longer in an active state, the resource might no longer be available\.
+ Tag changes might not be possible if a resource is offline or terminated, or if other updates \(such as software upgrades\) to the resource are in progress\.
+ Tag changes can fail if you did not allow the changes to finish before leaving the page\. Let tag changes finish, and wait for the success or failure banner to appear on the page, before you leave the page\.

## Related information<a name="related-info-troubleshooting"></a>
+ [AWS tagging strategies](http://aws.amazon.com/answers/account-management/aws-tagging-strategies/)
+ [Using cost allocation tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html#allocation-what)
+ [Tag Editor](tag-editor.md)
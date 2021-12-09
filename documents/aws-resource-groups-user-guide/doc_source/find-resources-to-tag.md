# Find resources to tag<a name="find-resources-to-tag"></a>

With Tag Editor, you build a query to find resources in one or more AWS Regions that are available for tagging\. You can choose up to 20 individual resource types, or build a query on **All resource types**\. Your query can include resources that already have tags, or resources that have no tags\. For more information, see [Resources you can use with AWS Resource Groups](supported-resources.md)\.

After you find resources to tag, you can use Tag Editor to add tags, or view, edit, or delete tags\.

**To find resources to tag**

1. Sign in to the [AWS Management Console](), choose **Resource Groups**, and then choose **Tag Editor**\.

1. \(Optional\.\) Choose regions in which to search for resources to tag\. By default, your current region is selected\. For this walkthrough, choose **us\-east\-1** and **us\-west\-2**\.  
![\[Find resources to tag page with us-east-1 and us-west-2 selected as regions.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_regions.png)

1. Choose at least one resource type from the **Resource type** drop\-down list\. You can add or edit tags for up to 20 individual resource types at a time, or choose **All resource types**\. For this walkthrough, choose **AWS::EC2::Instance** and **AWS::S3::Bucket**\.  
![\[Find resources to tag page with EC2 instances and S3 buckets selected as the resource type.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresource.png)

1. \(Optional\.\) In the **Tags** fields, enter a tag key, or a tag key and value pair, to limit the resources in the current AWS Region to only those that are tagged with your specified values\. As you type a tag key, matching tag keys in the current region appear in a list below; you can choose a tag key from the list\. Tag Editor auto\-completes the tag key for you as you type enough characters to match an existing key\. Choose **Add** or press **Enter** when you've finished your tag\. In this example, filter for resources that have a tag key of **Stage**\. The tag value is optional, but narrows the results of the query further\. To add more tags, choose **Add**\. Queries assign an `AND` operator to tags, so any resource that matches the specified resource type and all specified tags is returned by the query\.

   To find resources with multiple values for a tag key, add another tag with the same key to the query, but specify a different value\. The results include all resources that are tagged with the same tag key and that have any of the selected values\. The search is case sensitive\.

   Leave the **Tags** boxes empty to find all resources of the specified type in the current AWS Region\. This query returns resources that have any tags, and includes those that have no tags\. To remove a tag from your query, choose **X** on the tag's label\.

   To find resources that have an empty value for a tag, choose **\(empty value\)** when your cursor is in the tag value box\. To find resources that have a tag key but no tag value, choose **\(not tagged\)**\.  
![\[Find resources to tag page with empty value chosen as the tag value.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresource_emptyvalue.png)
**Note**  
Before you can find resources with the specified tags, they must have been applied to at least one resource of the specified type in the current AWS Region\.

1. When your query is ready, choose **Search resources**\. Results are displayed in the **Resource search results** area\.  
![\[Find resources query results.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_results.png)

   To filter a large number of resources, enter any filter text, such as part of the name of a resource, in **Filter resources**\.

1. \(Optional\.\) To configure the columns that Tag Editor displays in your resource search results, choose the **Preferences** gear icon in your results\.  
![\[Preferences icon in Find resources query results.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_columnsettings.png)

   On the **Preferences** page, choose the number of rows that you want displayed in your search results\. Turn on columns that you want Tag Editor to display in your results\. You can show columns for tag keys that occur in your search results or a selected subset of your search results\. You can do this any time after you find resources to tag\.  
![\[Preferences page.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_findresources_preferences.png)

   When you are finished configuring visible columns and number of displayed rows, choose **Confirm**\.

## View Tags of Selected Resources<a name="tagging-resources-view"></a>

Tag Editor shows you existing tags on selected resources that are in the results of your **Find resources to tag** query\.

1. In the results of your **Find resources to tag** query, choose a number in the **Total tags** column for any resource, selected or not, for which you want to view existing tags\. Resources with a dash in the **Total tags** column do not have existing tags\.  
![\[Find resources query results with no resources selected.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_view_tags_query.png)

1. View existing tags in **Resource tags**\. You can also open this window on the **Manage tags** page, when you are changing or removing tags\.  
![\[Resource tags page.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_view_tags.png)
**Note**  
If you don’t see a tag that you recently applied to a resource, try refreshing your browser window\.

## Export Results to CSV<a name="tagging-resources-csv"></a>

You can export the results of a **Find resources to tag** query to a comma\-separated values \(CSV\) file\. The CSV file includes the resource names, services, region, resource IDs, the total number of tags, and a column for each unique tag key in the collection\. The CSV file can help you develop a tagging strategy for resources in your organization, or determine where there are overlaps or inconsistencies in tagging across resources\.

1. In the results of your **Find resources to tag** query, choose **Export resources to CSV**\.  
![\[Find resources query results with Export 8 resources to CSV command button shown.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/te_view_tags_query.png)

1. When you are prompted by your browser, choose to open the CSV file \(typically in Microsoft Excel\), or save it to a convenient location\.

## Related information<a name="related-info-finding-resources"></a>
+ [AWS Tagging Strategies](http://aws.amazon.com/answers/account-management/aws-tagging-strategies/)
+ [Using cost allocation tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/cost-alloc-tags.html#allocation-what)
+ [Tag Editor](tag-editor.md)
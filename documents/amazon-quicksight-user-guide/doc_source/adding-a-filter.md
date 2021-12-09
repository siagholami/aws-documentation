# Adding a Filter<a name="adding-a-filter"></a>

You can use filters to refine the data in a data set\. Each filter applies only to a single field\. You can apply filters to both regular and calculated fields\. 

If you create multiple filters, all top\-level filters apply together using AND\. If you group filters by adding them inside a top\-level filter, the filters in the group apply using OR\. 

Amazon QuickSight applies all of the enabled filters to the field\. For example, if there is one filter of `state = WA` and another filter of `sales >= 500`, then the data set only contains records that meet both of those criteria\. If you disable one of these, only one filter applies\.

Take care that multiple filters applied to the same field aren't mutually exclusive\. 

**Note**  
The data preview shows you the results of your combined filters only as they apply to the first 1000 rows\. If all of the first 1000 rows are filtered out, then no rows show in the preview\. This effect occurs even when rows after the first 1000 aren't filtered out\.

**Topics**
+ [Viewing Filters](viewing-filters-data-prep.md)
+ [Adding a Filter](add-a-filter-data-prep.md)
+ [Editing a Filter](edit-a-filter-data-prep.md)
+ [Deleting a Filter](delete-a-filter-data-prep.md)
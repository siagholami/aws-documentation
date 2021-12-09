# Filtering Visual Data in Amazon QuickSight<a name="filtering-visual-data"></a>

You can use filters to refine the data displayed in a visual\. Filters are applied to the data before any aggregate functions that you specify\.

A filter is associated with a single data set in an analysis\. It can be scoped to one, several, or all visuals in the analysis that use that data set\. By default, a filter applies only to the visual that was selected when the filter was created\. You can change the scope of a filter after you create it\.

Each filter applies only to a single field\. You can apply filters to both regular and calculated fields\. 

If you create multiple filters, all top\-level filters apply together using AND\. If you group filters by adding them inside a top\-level filter, the filters in the group apply using OR\. 

Amazon QuickSight applies all of the enabled filters to the field\. For example, if there is one filter of `state = WA` and another filter of `sales >= 500`, then the data set only contains records that meet both of those criteria\. If you disable one of these, only one filter applies\.

Take care that multiple filters applied to the same field aren't mutually exclusive\. 

Amazon QuickSight uses filters to focus on or exclude a visual element representing a particular value\. For more information about focusing on a visual element, see [Focusing on Visual Elements](focusing-on-visual-elements.md)\. For more information about excluding a visual element, see [Excluding Visual Elements](excluding-visual-elements.md)\.

**Topics**
+ [Viewing Filters](viewing-filters.md)
+ [Adding a Filter](add-a-filter.md)
+ [Editing a Filter](edit-a-filter.md)
+ [Deleting a Filter](delete-a-filter.md)
+ [Parameterize a Filter](parameterize-a-filter.md)
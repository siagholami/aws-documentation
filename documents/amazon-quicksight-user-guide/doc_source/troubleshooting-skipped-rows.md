# My Rows Were Skipped During Data Preparation<a name="troubleshooting-skipped-rows"></a>

When you prepare data, Amazon QuickSight previews a portion of your data for you to work with\. If it can't interpret a row for any reason, it skips this row\. Then it displays a message to say how many rows are skipped\.

Here is a list of things to check:
+ Inconsistency between the field data type and the field data, for example text data in a field with a numeric data type\.
+ Having a file that contains a header but having the **Contains header** upload setting deselected\.
+ Having the data source data violate one or more [Data Source Limits](data-source-limits.md)\.
+ Field data that is incompatible with or excluded by the function used in a calculated field\. For example, if you have a calculated field that uses [`parseDate`](parseDate-function.md), rows with data that doesn't evaluate to a valid date are skipped\.
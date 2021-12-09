# Parameterize a Filter<a name="parameterize-a-filter"></a>

To use an existing parameter in a filter on your analysis, you select **Use parameters**, and choose the parameter or parameters that you want to use\. If you are filtering a text field \(string\), you need to choose a filter for **Custom filter**\.

Before you can add a parameter to a filter, the parameter must exist already\. If you want to filter on date parameters, create one each for start and end dates\. If you want to filter on relative dates, create an integer parameter first\. If you need to create a parameter, use the **Parameters** pane at left\. For more information, see [Parameters in Amazon QuickSight](parameters-in-quicksight.md)\.

Use the following procedure to use a parameter with a new or existing filter\.

1. Choose the visual that you want to work with, and then choose the **Filter** pane on the left side of the screen\. 

1. Choose the filter that you want work with, so that you see the options that belong to that filter\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/parameter-add-to-filter.png)

1. Choose one of the following:
   + For a text field \(string\), choose **Custom filter**\. The **Use parameters** option appears after you choose **Custom filter**\. 
   + For a time range, choose **Time range** and **Use parameters**\. If you want to filter for data between two dates, use the lists to choose your start and end date parameters\. Alternatively, you can choose to filter for a date that is before, after, or equal to a single date parameter\.
   + For relative dates, choose **Relative dates** and **Use parameters**\. Then use the list to choose your integer parameter\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/parameter-filter-by-date-range.png)

1. Choose **Apply** to save your changes\.
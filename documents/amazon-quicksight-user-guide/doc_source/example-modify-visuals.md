# Tutorial: Modify Visuals<a name="example-modify-visuals"></a>

Use the following procedures to modify the visuals created using the procedures in [Tutorial: Create an Analysis](example-create-an-analysis.md)\. 

## Modify the Line Chart Visual<a name="example-line-visual"></a>

Modify the line chart visual by making it show an additional measure by date, and also by changing the chart color\.

1. In the analysis, select the line chart visual\.

1. Add another measure to the visual\.

   Select the **New visitors SEO** field in the **Fields list** pane\. This measure is added to the **Value** field well, and the line chart updates with a line to represent it\. Note that the visual title updates as well\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-measures.png)

1. Change the color of the line used to represent the **Return visitors** measure\.

   Choose the line on the chart that represents **Return visitors**\. To do this, choose the end of the line, not the middle of the line\. 

   Choose **Color Return visitors**, and then choose the red icon from the color selector\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-color1.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-color3.png)

## Modify the Scatter Plot Visual<a name="example-scatter-plot-visual"></a>

Modify the scatter plot visual by changing the data granularity\.

1. In the analysis, select the scatter plot visual\.

1. Expand the **Field wells** pane by choosing the expand icon\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-field-expand.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-field-expand2.png)

1. Choose the **Group/Color** field well, choose **Aggregate**, and then choose **Month**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-change-date.png)

   The scatter plot updates to show the measures by month, rather than by the default of by year\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-change-date2.png)

## Modify Both Visuals by Changing Visual Layout and Adding a Filter<a name="example-both-visuals"></a>

Modify both visuals by changing visual size and location, and by adding a filter and applying it to both of them\.

### Change the Visual Layout<a name="example-both-visuals-layout"></a>

Modify both visuals by changing visual size and location\.

1. In the analysis, select the line chart visual\.

1. Choose the resize handle in the lower right corner of the visual and drag up and to the left, until the visual is half its former size both horizontally and vertically\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/shrink-visual.png)

1. Repeat this procedure on the scatter plot visual\.

1. Choose the move handle on the scatter plot visual, and drag it up to the right of the line chart visual so that they are side\-by\-side\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/shrink-visual4.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/shrink-visual5.png)

### Modify Both Visuals by Adding a Filter<a name="example-both-visuals-filter"></a>

Modify both visuals by adding a filter and applying it to both of them\.

1. In the analysis, choose the scatter plot visual\.

1. Choose **Filter** in the tool bar\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/pick-filter.png)

1. On the **Applied filters** pane, choose the new filter icon, and then choose the **Date** field to filter on\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter.png)

1. Choose the new filter to expand it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter2.png)

1. Choose the **After** comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter3.png)

1. Enter a start date value of 1/1/2014\.

   Choose **Start Date**, choose the month expander, and then choose **January**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter4.png)

   Choose the year expander and then choose **2014**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter5.png)

   Choose the calendar and then choose **1**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter6.png)

1. Choose **Apply**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter7.png)

   The filter is applied to the currently selected visual, which is the scatter plot visual\. This is indicated with a filter icon next to the visual title\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter8.png)

1. Apply the filter to the line chart visual as well\.

   Choose the selector next to the filter name, and then choose **All visuals for this data set**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-date-filter9.png)

## Next Steps<a name="example-next-step-visuals"></a>

Create a dashboard from the analysis by using the procedure in [Tutorial: Create a Dashboard](example-create-a-dashboard.md)\.
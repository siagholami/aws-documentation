# Formatting a Visual in Amazon QuickSight<a name="formatting-a-visual"></a>

Use visual formatting to choose display options for your data visualization\. 

**Topics**
+ [Customizing a Visual Title](#displaying-visual-title)
+ [Customizing Visual Labels](#customizing-visual-labels)
+ [Customizing the Visual Legend](#customizing-visual-legend)
+ [Customizing Data Labels on Visuals](#customizing-visual-data-labels)
+ [Changing the Visual Scale with the Axis Range](#changing-visual-scale-axis-range)
+ [Customizing a Visual Title](#supported-formatting-on-visual-types)

## Customizing a Visual Title<a name="displaying-visual-title"></a>

Use the following procedure to hide or display the title for a visual\. The visual title displays by default\.

1. On the analysis page, select the visual that you want to format\. You can change the title by putting your cursor in the title and editing it directly\. To revert to the default name, delete your entry\.

1. Choose the on\-visual menu at the upper\-right corner of the visual, and then choose **Format visual**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-visual.png)

1. On the **Format Visual** pane, enable or disable **Show title**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/show-title.png)

1. Close the **Format Visual** pane by choosing the X icon in the upper\-right corner of the pane\.

## Customizing Visual Labels<a name="customizing-visual-labels"></a>

Use the following procedure to customize, display, or hide the labels for a visual\. 

1. On the analysis page, select the visual that you want to format\. You can change the labels by choosing the label directly on the visual, and choosing **Rename**\. To revert to the default name, delete your entry\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/customize-visual-labels-direct-edit.png)

1. To see more options, choose the on\-visual menu at the upper\-right corner of the visual, and then choose **Format visual**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-visual.png)

1. On the **Format Visual** pane, enable or disable **Show label**\. This option takes its name from the name of the axis, for example **Show X\-Axis label**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/customize-visual-labels.png)

1. Close the **Format Visual** pane by choosing the X icon in the upper\-right corner of the pane\.

## Customizing the Visual Legend<a name="customizing-visual-legend"></a>

The visual legend helps you identify what a visual element represents by mapping its value to a color\. For example, on a line chart, line color might represent store location\.

To hide or display the legend, you can use the visual menu\. You can also use the **Format Visual** pane, which provides more options\. The visual legend displays to the right of the visual by default\.

When you move your cursor over the legend, a handle appears that you can use to adjust the width of the legend pane by dragging it wider or narrower\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/legend-resize.png)

Use the following procedure to hide or display the visual title\. The visual title displays by default\.

1. On the analysis page, select the visual that you want to format\.

1. Choose the on\-visual menu at the upper\-right corner of the visual, and choose **Display legend** or **Hide legend**\. 

1. Choose **Format visual** to see formatting options\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-visual.png)

1. On the **Format Visual** pane, expand the **Legend** section\.

1. Enable or disable **Show legend** and **Show legend title**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/show-legend2.png)

1. To customize the title of the legend, enter a new title in the **Legend** text box\. To revert to the default name, delete your entry\.

1. For **POSITION**, choose **Right**, **Bottom**, or **Top** to determine where on the visual the legend displays\.

1. Close the **Format Visual** pane by choosing the X icon in the upper\-right corner of the pane\.

## Customizing Data Labels on Visuals<a name="customizing-visual-data-labels"></a>

To customize data labels on a visual, you can use the **Format Visual** pane to show data labels, and then use the settings to configure them\. Data label customization is supported on bar, line, combo, scatter, and pie charts\.

You can customize the following options:
+ Position, which determines where the label appears in relation to the data point \(for bar, combo, and line charts\):
  + For vertical bar charts, you can customize to set position:
    + Above bars
    + Inside of bars
    + Bottom of bars
    + Top of bars
  + For horizontal bar charts, you can customize to set position:
    + Right of bars
    + Inside of bars
  + For line charts, you can customize to set position:
    + Above lines
    + Left or right of points on lines
    + Below lines
  + For scatter charts, you can customize to set position:
    + Above points
    + Left or right of points
    + Below points
+ Font size and color \(for bar, combo, line, scatter, and pie charts\)
+ Label pattern, which determines how data is labeled \(for bar, combo, line, and scatter charts\):
  + For bar, combo, line, and scatter charts, you can label:
    + All 
    + By group/color
  + For lines, the following additional label options are available:
    + Line ends
    + Minimum or maximum value only
    + Minimum and maximum values
+ Group selection \(for bars and lines, when the label pattern is "by group/color"\)
+ Allow labels to overlap \(for bars and lines\), for use with fewer data points

Use the following procedure to configure data labels\.

1. On the analysis page, choose the visual that you want to format\.

1. Choose the on\-visual menu at the upper\-right corner of the visual, and then choose **Format visual**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-visual.png)

1. On the **Format Visual** pane, choose **Data Labels**\. 

1. Enable **Show data labels** to show and customize labels\. Disable this option to hide data labels\.

1. Choose the settings that you want to use\. The settings offered are slightly different for each chart type\. To see all available options, see the list before this procedure\. 

   You can immediately view the effect of each change on the visual\. 

1. Close the **Format Visual** pane by choosing the X icon in the upper\-right corner of the pane\.

## Changing the Visual Scale with the Axis Range<a name="changing-visual-scale-axis-range"></a>

To change the scale of the values shown on the visual, you can use the **Format Visual** pane to set the range for one or both axes of the visual\. This option is available for the value axis on bar charts, combo charts, line charts, and scatter plots\. 

By default, the axis range starts at 0 and ends with the highest value for the measure being displayed\. For the group\-by axis, you can use the data zoom tool on the visual to dynamically adjust the scale\.

Use the following procedure to set the axis range for a visual\. 

1. On the analysis page, select the visual that you want to format\.

1. Choose the on\-visual menu at the upper\-right corner of the visual, and then choose **Format visual**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-visual.png)

1. On the **Format Visual** pane, choose **X\-Axis** or **Y\-axis**, depending on what type of visual you are customizing\. This is the **X\-Axis** section for horizontal bar charts, the **Y\-Axis** section for vertical bar charts and line charts, and both axes are available for scatter plots\. On combo charts, use **Bars** and **Lines** instead\. 

1. Enter a new name in the box to rename the axis\. To revert to the default name, delete your entry\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/customize-visual-scale.png)

1. Set the range for the axis by choosing one of the following options:
   + Choose **Auto \(starting at 0\)** to have the range start at 0 and end around the highest value for the measure being displayed\.
   + Choose **Auto \(based on data range\)** to have the range start at the lowest value for the measure being displayed and end around the highest value for the measure being displayed\.
   + Choose **Custom range** to have the range start and end at values that you specify\.

     If you choose **Custom range**, enter the start and end values in the fields in that section\. Typically, you use integers for the range values\. For stacked 100 percent bar charts, use a decimal value to indicate the percentage that you want\. For example, if you want the range to be 0–30 percent instead of 0–100 percent, enter 0 for the start value and \.3 for the end value\.

1. To customize the number of values to show on the axis, enter in an integer between 1 and 50\.

1. Close the **Format Visual** pane by choosing the X icon in the upper\-right corner of the pane\.

## Customizing a Visual Title<a name="supported-formatting-on-visual-types"></a>

Use the following list to see which visuals support what type of formatting\.
+ Bar charts \(both horizontal and vertical\) support the following formatting:
  + Customize, display, or hide title, field labels, and data labels
  + Customize, display, or hide legend \(exception: simple charts without clustering or multiple measures don't show a legend\)
  + Specify axis range and steps on x\-axis for horizontal bar charts, and on y\-axis for vertical bar charts
  + Show or hide the “other” category
+ Combo charts support the following formatting:
  + Customize, display, or hide title, field labels, and data labels
  + Customize, display, or hide legend \(exception: simple charts without clustering, stacking, or multiple measures don't show a legend\)
  + Specify axis range on bars and lines
  + Show or hide the “other” category
+ Geospatial charts \(maps\) support the following formatting:
  + Customize, display, or hide title and legend
+ Heat maps support the following formatting:
  + Customize, display, or hide title, legend, and labels
+ Key performance indicators \(KPIs\) support the following formatting:
  + Customize, display, or hide title
  + Display or hide trend arrows and progress bar
  + Customize comparison method as auto, difference, percent \(%\), or difference as percent \(%\)
  + Customize primary value displayed to be comparison or actual
+ Line charts support the following formatting:
  + Customize, display, or hide title, field labels, and data labels
  + Customize, display, or hide legend \(exception: simple charts don't show a legend\)
  + Specify axis range and steps \(on y\-axis\)
  + Show or hide the “other” category, except when the x\-axis is a date
+ Pie charts support the following formatting:
  + Customize, display, or hide title, data labels, and legend
  + Customize, display, or hide the labels for group/color and value fields
  + Show or hide the “other” category
+ Pivot tables support the following formatting:
  + Customize, display, or hide title
  + Customize, display, or hide the column names for row and value fields
  + Show or hide the “other” category
+ Scatter plots support the following formatting:
  + Customize, display, or hide title, legend, field labels, and data labels
  + Specify axis range \(on x\-axis and y\-axis\)
+ Tabular reports support the following formatting:
  + Customize, display, or hide title and legend
  + Customize, display, or hide the column names for group\-by and value fields
  + Display or hide totals at the top or bottom of the table
+ Tree maps support the following formatting:
  + Customize, display, or hide title and legend
  + Customize, display, or hide the labels for group\-by, size, and color fields
  + Show or hide the “other” category
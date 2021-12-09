# Configuring trend lines<a name="configure-trend-lines"></a>

As a project owner, you can configure trend lines to display statistical analyses on your data\. When you add a trend line, you choose the type of analysis and the property to analyze\. This lets you and your team identify trends in your data to better understand your operation\.

The following visualization types support trend lines:
+ [Line](choose-visualization-types.md#line-charts)
+ [Scatter](choose-visualization-types.md#scatter-charts)
+ [Bar](choose-visualization-types.md#bar-charts)

The following is an example visualization with a linear trend line\.

![\[A line graph visualization with a linear trend line.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-trend-line-graph-console.png)

**Note**  
The dashboard uses only data from the selected time range to compute trend lines\. This means that trend lines only show trends for visible data\.

## Adding a trend line to a visualization<a name="add-trend-line"></a>

As a project owner, you can define trend lines for each visualization\.

**Note**  
You can add one of each type of trend line to each property in a visualization\.

**To add a trend line to a visualization**

1. Choose the **Configuration** icon for the visualization to change\.  
![\[A visualization with the "Configuration" icon highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-configure-visualization-settings-console.png)

1. Choose **Add a trend line**\.  
![\[The visualization configuration panel with "Add a trend line" highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-add-trend-console.png)

1. Choose the type of trend line to display from the following option:
   + **Linear** – A linear regression line\. SiteWise Monitor uses the [least squares](https://en.wikipedia.org/wiki/Least_squares) method to calculate the linear regression\.

1. Choose the property for which the trend line displays\.

   The trend line displays in the same color as the property data\.

1. <a name="dashboard-save-changes"></a>After you finish editing the dashboard, choose **Save dashboard** to save your changes\. The dashboard editor closes\. If you try to close a dashboard that has unsaved changes, you're prompted to save them\.

## Removing a trend line from a visualization<a name="remove-trend-line"></a>

As a project owner, you can remove a trend line from a visualization if you no longer need it\.

**To remove a trend line from a visualization**

1. Choose the **Configuration** icon for the visualization to change\.

1. Choose the **X** icon for the trend line to remove\.  
![\[A visualization trend line with the remove icon highlighted.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-remove-trend-console.png)

1. <a name="dashboard-save-changes"></a>After you finish editing the dashboard, choose **Save dashboard** to save your changes\. The dashboard editor closes\. If you try to close a dashboard that has unsaved changes, you're prompted to save them\.
# Choosing visualization types<a name="choose-visualization-types"></a>

This section describes the available visualization types\. To understand your devices, processes, and equipment, you should choose the right type of visualization for each asset property that you add to a dashboard\. Each visualization type is covered in detail in this section\. Changing the visualization type doesn't change your data, so you can try different visualizations to discover which type helps you and your project's viewers gain insights from the data\.


| Type | Description | 
| --- | --- | 
| [Line](#line-charts) | Best used for properties with frequently reported values where you want to see the continuous trend over time\. | 
| [Scatter](#scatter-charts) | Best used for properties with frequently reported values where you want to see individual data points\. | 
| [Bar](#bar-charts) | Best used for properties with infrequently reported values, such as daily metrics, where you want to see the trend over time\. You can also use bar charts to compare values between multiple properties\. | 
| [KPI](#kpi-charts) | Best used for properties where the latest value is the most important piece of information\. | 

## Line<a name="line-charts"></a>

**Example**  
The following line chart shows four asset properties\.  

![\[A sample line chart showing four properties.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-line-graph-console.png)

A line graph is a good way to visualize time series data that fluctuates over time\. When you drag a time series property to the dashboard, the values for that property are shown as a line graph by default\.

To display a line graph, choose the line graph icon from the visualization type menu\.

![\[The line graph visualization type icon.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-line-visualization-type-console.png)

## Scatter<a name="scatter-charts"></a>

**Example**  
The following scatter chart shows one asset property\.  

![\[A sample scatter chart showing four properties.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-scatter-chart-console.png)

You can use a scatter chart to visualize time series data with distinct data points\. A scatter chart looks like a line graph without lines between data points\.

To display a scatter chart, choose the scatter icon from the visualization type menu\.

![\[The scatter chart visualization type icon.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-scatter-chart-visualization-type-console.png)

## Bar<a name="bar-charts"></a>

**Example**  
The following bar chart shows four asset properties\.  

![\[A sample bar chart showing four properties as a time series.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-bar-graph-console.png)

A bar chart is another way to visualize time series data\. You might use a bar chart when your data values change infrequently, such as daily readings\.

To display a bar graph, choose the bar graph icon from the visualization type menu\.

![\[The bar graph visualization type icon.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-bar-visualization-type-console.png)

## KPI<a name="kpi-charts"></a>

**Example**  
The following is a key performance indicator \(KPI\) visualization that shows four asset properties\.  

![\[A sample KPI visualization.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-kpi-chart-console.png)

The KPI visualization provides a compact representation when you need an overview of your asset properties\. This overview gives you the most critical insights into the overall performance of your devices, equipment, or processes\. You can change the title of each property within the visualization\.

The KPI visualization shows the following information:
+ The latest value for an asset property for the selected time range\.
+ The trend for that value compared to a previous value, which is the first data point before the selected time range\.

To display a KPI, choose the KPI icon from the visualization type menu\.

![\[The KPI visualization type icon.\]](http://docs.aws.amazon.com/iot-sitewise/latest/appguide/images/dashboard-kpi-visualization-type-console.png)
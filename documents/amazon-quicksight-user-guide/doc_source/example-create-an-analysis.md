# Tutorial: Create an Analysis<a name="example-create-an-analysis"></a>

Create an analysis, add a visual using AutoGraph, and add another visual by choosing a specific visual type\. This procedure builds on the data set you create and prepare using the steps in [Tutorial: Create a Prepared Data Set](example-prepared-data-set.md)\.

## Create the Analysis<a name="example-create-the-analysis"></a>

Create the analysis\.

1. On the Amazon QuickSight start page, choose **New analysis**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tutorial-new-analysis.png)

1. On the **Your data sets** page, choose the **Marketing Sample** data set and then choose **Create Analysis**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/quickstart-analysis2.png)

## Create a Visual By Using AutoGraph<a name="example-create-autograph-visual"></a>

Create a visual by using AutoGraph, which is selected by default\.

On the analysis page, choose **Date** and **Return visitors** in the **Fields list** pane\.

Amazon QuickSight creates a line chart using this data\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-line-chart.png)

## Create a Scatter Plot Visual<a name="example-create-scatter-plot-visual"></a>

Create a visual by choosing a visual type and dragging fields to the field wells\.

1. On the analysis page, choose **Add** and then **Add visual** on the application bar\. A new, blank visual is created, and AutoGraph is selected by default\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-add-visual.png)

1. In the **Visual types** pane, choose the scatter plot icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-choose-scatter.png)

1. Choose fields in the **Fields list** pane to add to the **Field wells** pane\.
   + Choose **Desktop Uniques** to populate the **X axis** field well\.
   + Choose **Mobile Uniques** to populate the **Y axis** field well\. 
   + Choose **Date** to populate the **Group/Color** field well\. 

   A scatter plot is created using these fields\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/example-scatter-plot.png)

## Next Steps<a name="example-next-step-analysis"></a>

Modify the visuals in the analysis by using the procedure in [Tutorial: Modify Visuals](example-modify-visuals.md)\.
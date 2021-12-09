# Changing Visual Colors in Amazon QuickSight<a name="changing-visual-colors"></a>

You can change the color of one, some, or all elements on visuals that use scatter plot, pie chart, or any of the bar chart or line chart visual types\. You can change the chart color used by all elements on the chart, and also change the color of individual elements\. When you set the color for an individual element, it overrides the chart color\. For example, suppose that you set the color for the **Arts** bar to blue\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-priority1.png)

Then you change the chart color to green\. The **Arts** bar remains blue\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-priority2.png)

When you change the color of an element that is grouped, for example a bar in a clustered bar chart, the color for that element is changed in all of the groups\. For example, if you have the following visual and you modify the color for the **West** region from purple to red:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-group1.png)

It is modified in all of the clusters:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-group2.png)

## Setting New Colors for a Visual<a name="change-visual-color"></a>

Use the following procedure to change the colors for a visual\.

1. On the analysis page, select the visual that you want to modify\.

1. To change the chart color, choose any element on the visual, and then choose **Chart Color**\.

   To select elements, do the following: 
   +  On a bar chart, choose any bar\. 
   +  On a line chart, choose the end of a line\. 
   +  On a scatter plot, choose an element\. The field must be in the **Group/Color** section of **Field wells**\. 

1. Choose the color that you want\. All elements on the visual are changed to use this color, except for any that have previously had their color individually set\. In that case, the element color overrides the chart color\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-selection1.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-selection2.png)

1. To change the color for a single element on the visual, choose that element, choose **Color <fieldname>**, and then choose the color that you want\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-selection3.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-selection4.png)

   Repeat this step until you have set the color on all elements that you want to modify\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-selection5.png)

## Setting Visual Colors Back to Defaults<a name="reset-visual-color"></a>

Use the following procedure to return to using the default colors on a visual\.

1. On the analysis page, select the visual that you want to modify\.

1. To change the chart color back to the default color for that visual type, choose any element on the visual, choose **Chart Color**, and then choose **Reset to Default**\. All elements on the visual are changed to the default color for the visual type, except for any that have previously had their color individually set\. In that case, the element color setting overrides the chart color setting\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-reset1.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-reset2.png)

1. To change the color for a single element back to the default, choose that element, choose **Color <fieldname>**, and then choose **Reset to Default**\. The default color for individual elements is the chart color if you have specified one, or the default color for the visual type otherwise\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-reset3.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/color-reset4.png)
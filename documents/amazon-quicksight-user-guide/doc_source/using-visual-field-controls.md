# Using Visual Field Controls<a name="using-visual-field-controls"></a>

You can edit the fields used by a visual by using the following user interface \(UI\) controls:
+ The **Fields list** pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/fields-list.png)
+ The field wells\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/field-wells2.png)
+ The on\-visual editors\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/on-visual-editor.png)
+ The drop targets on the visual\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/drop-targets.png)

You can use these controls as follows:
+ You can create a visual and assign fields to different elements on it by selecting fields in the **Fields list** pane, or dragging fields to field wells or drop targets\.
+ You can change the field associated with a visual element by dragging a field to a drop target or field well, or selecting a different field in a field well or on\-visual editor\.
+ You can change field aggregation or date granularity by using the field wells or the on\-visual editors\.

The field wells, on\-visual editors, and drop targets available on a specific visual depends on the visual type selected\. 

## Dragging Fields to Drop Targets or Field Wells<a name="dragging-a-field"></a>

When you drag a field to either a drop target or field well, Amazon QuickSight provides you with information about whether the target element expects a measure or a dimension\. Amazon QuickSight also provides you with information about whether that element is available for field assignment\.

For example, when you drag a measure to the value drop target on a new single\-measure line chart, you see the drop target color\-coded green\. That green color coding indicates that the drop target expects a measure\. The drag label indicates that the target is available to add a field\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/drop-target1.png)

When you drag a dimension to the X axis or color drop target on a new line chart, you see a label color\-coded blue\. That blue color coding indicates that the drop target expects a dimension\. The drag label indicates that the target is available to add a field\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/drop-target2.png)

You can also drag a measure or dimension to a drop target on a line chart where the element is already associated with a field\. In this case, the drag label indicates that you are replacing the field currently associated with the drop target\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/drop-target-replace.png)
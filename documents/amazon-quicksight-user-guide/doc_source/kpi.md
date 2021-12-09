# Using KPIs<a name="kpi"></a>

Use a KPI to visualize a comparison between a key value and its target value\.

A KPI displays a value comparison, the two values being compared, and a progress bar\. For example, the following KPI shows how closely revenue is meeting its forecast\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/kpi-sample.png)

The icon for a KPI is as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/kpi-icon.png)

## KPI Features<a name="kpi-features"></a>

Use the following table to understand the features supported by the KPI visual type in Amazon QuickSight\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Removing the title | Yes | You can choose not to display a title\. |  | 
| Changing comparison method | Yes | By default, Amazon QuickSight automatically chooses a method\. The settings are auto, difference, percent, and difference as percent\. |  | 
| Changing the primary value displayed | Yes | You can choose comparison \(default\) or actual\. |  | 
| Display or remove the progress bar | Yes | You can format the visual to either display \(default\) or not display a progress bar\. |  | 

## Creating a KPI<a name="create-KPI"></a>

Use the following procedure to create a KPI\.

1. Create a new analysis for your data set\.

1. In the **Visual types** pane, choose the KPI icon\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. You must use measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.

   To create a KPI, drag a measure to the **Value** field well\. To compare that value to a target value, drag a different measure to the **Target value** field well\. 

1. \(Optional\) Choose formatting options by selecting the on\-visual menu at the upper\-right corner of the visual, then choosing **Format visual**\. 
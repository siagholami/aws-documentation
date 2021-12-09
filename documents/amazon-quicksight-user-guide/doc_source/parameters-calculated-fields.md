# Using Calculated Fields with Parameters in Amazon QuickSight<a name="parameters-calculated-fields"></a>

You can pass the value of a parameter to a calculated field in an analysis\. When you create a calculation, you can choose existing parameters from the list of parameters under **Parameter list**\. You can't create a calculated field that contains a multivalued parameter—those with a multiselect drop\-down control\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-calc-field3.png)

For the formula, you can use any of the available functions\. You can pass the viewer's selection from the parameter control, to the `ifElse()` function, and then return a metric accordingly, as shown in the following example: 

```
ifelse(

${KPIMetric} = 'Sales',sum({Weighted Revenue}),

${KPIMetric} = 'Forecast',sum({Forecasted Monthly Revenue}),

${KPIMetric} = '# Active', distinct_count(ActiveItem),

Null

)
```

The preceding example creates a metric \(a decimal\) that you can use in a field well\. Then, when a user chooses a value from the parameter control, the visual updates to reflect their selection\.
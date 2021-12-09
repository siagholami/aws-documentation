# Working with Calculated Fields<a name="working-with-calculated-fields"></a>

Create calculated fields to use operators or functions to analyze or transform field data\. For details about supported functions and operators, see [Calculated Field Function and Operator Reference for Amazon QuickSight Functions and Operators](calculated-field-reference.md)\.

You can use multiple functions and operators in a calculated field\. For example, you might use the `formatDate` function to extract the year from a date field, and then the `ifelse` function to segment records based on the year\.

```
ifelse(formatDate(order_date, 'yyyy') > '2000', 'this 
century', 'last century')
```

You can create a calculated field based on one or more data set fields or existing calculated fields\. For example, you can use the `ifelse` function to create a **quarter** field extrapolated from a month value\.

```
ifelse(month <=3, 1, month > 3 AND month <= 6, 2, 
month > 6 AND month <= 9, 3, 4)
```

You can then use that calculated **quarter** field and a sales amount field to identify high\-spending customers for the first quarter\.

```
ifelse(quarter = 1 AND sales_amount >= 10000, 'review 
account', 'n/a')
```

You can add calculated fields to a data set during data preparation or from the analysis page\. When you add a calculated field to a data set during data preparation, it's available to all analyses that use that data set\. When you add a calculated field to a data set in an analysis, it's available only in that analysis\. For information about adding calculated fields during data preparation, see [Adding a Calculated Field During Data Preparation](#adding-a-calculated-field)\. For information about adding calculated fields in an analysis, see [Adding a Calculated Field to an Analysis](adding-a-calculated-field-analysis.md)\.

## Handling Decimal Values in Calculated Fields<a name="handling-decimal-fields"></a>

The decimal data type supports up to four decimal places to the right of the decimal point\. During data preparation, calculated fields that use decimal data with more than four decimal places use the full value to perform the calculation\. If the result is again decimal data that uses more than four decimal places, the result is then truncated when the data set is imported into [SPICE](welcome.md#spice) or displayed in an analysis\.

As an example, take decimal field FieldA with a value of 0\.00006, which is displayed in the user interface as 0\.0\. The full value 0\.00006 is still used in all calculations\. The following are some examples of how you can use this value in calculations:
+ FieldA > 0 = true\. The calculated field value displayed in the analysis or imported into SPICE is **true**\.
+ ceil\(FieldA\) = 1\. The calculated field value displayed in the analysis or imported into SPICE is **1**\.
+ FieldA \+ 0\.00009 = 0\.00015\. The calculated field value displayed in the analysis or imported into SPICE is **0\.0001**\.
+ FieldA \* 1\.5 = 0\.00009\. The calculated field value displayed in the analysis or imported into SPICE is **0\.0**\.

## Adding a Calculated Field During Data Preparation<a name="adding-a-calculated-field"></a>

Create calculated fields to use functions and operators to analyze or transform field data\. For details about supported functions and operators, see [Calculated Field Function and Operator Reference for Amazon QuickSight Functions and Operators](calculated-field-reference.md)\. For more information about using calculated fields, see [Working with Calculated Fields](#working-with-calculated-fields)\.

You can add calculated fields to a data set during data preparation or from the analysis page\. When you add a calculated field to a data set during data preparation, it's available to all analyses that use that data set\. When you add a calculated field to a data set in an analysis, it's available only in that analysis\.

Use this topic to learn about adding calculated fields during data preparation\. For information about adding calculated fields in an analysis, see [Adding a Calculated Field to an Analysis](adding-a-calculated-field-analysis.md)\.

### Adding a Calculated Field<a name="add-a-calculated-field"></a>

Use the following procedure to add a calculated field\.

1. Do one of the following:
   + Create a calculated field without having the formula populated by a field\.

     On the data preparation page, expand the **Fields** pane, and then choose **New Field**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-field.png)
   + Create a calculated field and have the formula populated with a specified field\.

     On the data preparation page, expand the **Fields** pane\. Hover over the field that you want to use as the basis for the calculated field, choose the ellipsis at its right, and then choose **Add calculation based on <field name>**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/function-field.png)

1. In the **Calculated field** pane, highlight the value in **Calculated field name**, and then type a name for the calculated field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/function-field-name.png)

1. Add a function to the calculated field formula by doing one of the following:
   + If you created the calculated field by choosing **New Field**, choose a function from **Function list** and then choose **Add**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-function.png)
   + If you created the calculated field by choosing a specific field to use, place your cursor in front of the field name in **Formula**\. Then type the name of the function that you want to use and an open parenthesis, then place your cursor after the field name and type a close parenthesis\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/type-function.png)

1. In **Formula**, type any parameters needed by the function \(help for the function displays below **Formula**\)\. As needed, choose fields from **Field list** and then choose **Add** to add them to the formula\. You can also choose additional functions from the **Function list** to complete the formula\.

   If you use a field name that has a space or a nonalphanumeric character other than an underscore, enclose the field name in curly braces when referencing it, for example **\{customer id\}**\. Curly braces are optional if the field name has no space or a nonalphanumeric character\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/ifelse-function.png)

1. Choose **Create**\.

   The new calculated field is created, and appears in the **Calculated fields** section at the top of the **Fields** pane\.

### Editing a Calculated Field<a name="edit-a-calculated-field"></a>

To edit a calculated field, locate the field you want to edit in the **Calculated fields** section of the **Fields** pane, hover over it, choose the ellipsis that appears to the right of it, and then choose **Edit <field name>**\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/calc-fields.png)

### Deleting a Calculated Field<a name="delete-a-calculated-field"></a>

To delete a calculated field, locate the field you want to delete in the **Calculated fields** section of the **Fields** pane, hover over it, choose the ellipsis that appears to the right of it, and then choose **Delete <field name>**\. 

As with regular fields, if you delete a calculated field that is used in a visual, that visual breaks\. You then need fix it the next time you open the relevant analysis\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/calc-fields2.png)
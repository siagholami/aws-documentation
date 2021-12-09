# Setting Up Parameters in Amazon QuickSight<a name="parameters-set-up"></a>

**Topics**
+ [Creating or Editing Parameters](#parameters-basic-create-or-edit)
+ [Parameter Controls](#parameters-controls)
+ [Parameter Defaults](#parameters-default-values)

## Creating or Editing Parameters in Amazon QuickSight<a name="parameters-basic-create-or-edit"></a>

Use the following procedure to create or edit a basic parameter\.

1. Choose an analysis to work with, and decide which field you want to parameterize\. 

1. Choose the **Parameters** pane from the left side of the screen\. 

1. Add a new parameter by choosing the add icon \(**\+**\) near the top of the pane\. 

   Edit an existing parameter by first choosing the `v`\-shaped icon near the parameter name and then choosing **Edit parameter**\. 

1. The following screen appears\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/parameter-create-or-edit.png)

   A parameter consists of the following parts, which you enter on this screen:  
Name  
Enter an alphanumeric value for the parameter **Name**\. This name is used as a reference in the consumers of the parameters \(for example, calculated field, filter, custom URL action, and so on\)\. For ease of use, you can choose a name that reflects the data type and purpose of the parameter\.  
Data type  
Choose a value for **Data type**\. This data type can't be altered after you create the parameter\. If you want to use the parameter for a text box or drop\-down list, choose `String`\.  
Values  
Choose one of the following:  
   + **Single value** – for parameters that can contain only one value\.
   + **Multiple values** – for parameters that can contain one or more values\. Multivalue parameters can't be `datetime` data types\. They also don't support dynamic default values\.
To switch an existing parameter between single and multiple values, delete and recreate the parameter\.  
Static default value  
Choose a static default value for the parameter\. This static value is used during the first page load, if a dynamic default value or URL parameter isn't provided\.   
Dynamic default value  
Choose **Set a dynamic default** to create a default that is user\-specific\. A *dynamic default *is a per\-user default value for the first page load of the dashboard\. Using a dynamic default, you can create a personalized view for each user\.   
Calculated fields can't be used as dynamic defaults\.   
Dynamic defaults don't prevent a user from selecting a different value\. If you want to also secure the data, you can add row\-level locking\. For more information, see [Restricting Access to a Data Set by Using Row\-Level Security](restrict-access-to-a-data-set-using-row-level-security.md)\.  
This option only appears if you choose a single value parameter\. Multivalue parameters can't have dynamic defaults\.  
If you choose a multivalue parameter, the screen changes to remove the default options\. Instead, you see a box with the text **Enter values you want to use for this control**\. You can enter multiple values in this box, each on a single line\. These values are used as the default selected values in the parameter control\. The values here are unioned with what you choose to enter for the parameter control\. For more information on parameter controls, see [](#parameters-controls)\.

1. Choose **Create** or **Update** to complete creating or updating the parameter\.

After you create a parameter, you can use it in a variety of ways\. You can create a control \(such as a button\) so that you can choose a value for your parameter\. For more information, see the following sections\.

## Using a Control with a Parameter in Amazon QuickSight<a name="parameters-controls"></a>

In dashboards, parameter controls appear at the top of the data sheet, which contains a set of visuals\. Providing a control allows users to choose a value to use in a predefined filter or URL action\. Dashboard users can use controls to apply filtering across all visuals data sets on a dashboard, without having to create the filters themselves\. 

Use the following procedure to create or edit a control for an existing parameter\. You need to have an existing parameter to create or edit a control for it\.

1. Choose an existing parameter's context menu, the `v` icon near the parameter name, and choose **Add control**\.

1. Enter a name to give the new control a label\. This label displays at the top of the workspace, and later at the top of the sheet that a dashboard displays on\. 

1. Choose a style for the control from the following:
   + **Text box**

     A text box lets a user type in their own value\. A text box works with numbers and text \(strings\)\.
   + **Drop\-down \(single\-select or multiselect\)**

     A *single select drop\-down* lets a user select one value from a list\. A *multiselect drop\-down* lets a user select multiple values\. Both type of lists work with numbers and text \(strings\)\. 

     Multiselect lists used by a control can work with the following:
     + Custom URL actions
     + Dashboard or analysis URLs
     + Custom filters \(these must either equal or not equal the values provided; no other comparisons are supported\)
   + **Slider**

     A slider lets a user select a numeric value by sliding the control from one end of the bar to another\. A slider works with numbers\.
   + **Date\-picker**

     A date\-picker lets a user select a date from a calendar control\. 

   The **Style** option displays only the style types that are appropriate for the parameter's data type and single or multivalue setting\. If the style that you want to use isn't in the list, you can recreate your parameter with the appropriate settings and try again\.

1. \(Optional\) If you choose a drop\-down control, the screen expands so you can choose the values to display\. You can either specify a list of values, or use a field in a data set\. Choose one of the following:
   + **Specific values**

     To create a list of specific values, type in one per line, with no separating spaces or commas, as shown in the following screenshot\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/parameters-controls-specific-values.png)

     In the control, the values display in the order you typed them, not alphabetically\.
   + **Link to a data set field**

     To link to a field, choose the data set that contains your field, then choose the field from the list\. It can't be a calculated field\. The values display alphabetically in the control\. Using more than 10,000 distinct values for linked data isn't supported\. If you need more than 10,000 values, you can enter them in **Specific values**\.

     If you change the default values in the parameter, choose **Reset** on the control to show the new values\.

   The values that you choose here are unioned with the static default values in the parameter settings\.

1. \(Optional\) You can limit the values displayed in the controls, so they only show values that are valid for what is selected in other controls\. This is called a cascading control\. 

   To create one, choose **Show relevant values only**\. Choose one or more controls that can change what displays in this control\. 

1. When you finish choosing options for your control, choose **Add**\.

The finished control appears at the top of the workspace\. The context menu, shaped like a `v`, offers four options:
+ **Reset** restores the user's selection to its default state\.
+ **Refresh list** applies only to drop\-downs that are linked to a field in a data set\. Choosing **Refresh list** queries the data to check for changes\. Data used in the control is cached\.
+ **Edit** reopens the control creation screen so that you can change your settings\.
+ **Delete** removes the control\. You can recreate it by choosing the parameter context menu\.

In the workspace, you can also resize and rearrange your controls\. The dashboard users see them as you do, except without being able to edit or delete them\.

## Creating Parameter Defaults in Amazon QuickSight<a name="parameters-default-values"></a>

Use this section to learn more about the types of parameter defaults that are available, and how to set up each of them\. If you set up a dynamic default, the parameter's control automatically uses that user's preselected default\. In the absence of a dynamic default, the parameter's control uses the static default\.

Use the following procedure to create or edit a static \(unchanging\) default value for a parameter\. 

1. Choose the context menu \(`v`\) by the parameter you want to edit, or create a new parameter by following the steps in [Creating or Editing Parameters in Amazon QuickSight](#parameters-basic-create-or-edit)\. 

1. To set a static default, enter a value for **Static default value**\. Otherwise, leave this blank\. The value you set for a static default can't be changed by the dashboard user\. 

To create or edit an optional dynamic default value for a parameter, use the following procedure\. The data set for dynamic defaults can use a database query or an uploaded file\. You can't use dynamic defaults with multivalued parameters—those that use a multiselect drop\-down control\. 

1. Create a database table or SQL query similar to the following\. To maintain this table or query more easily, the names of other fields \(columns\) should closely match those in the data set that you are analyzing\. It doesn't matter what order the fields are in\. It also doesn't matter if there are fields in this data set that aren't in the current analysis\. 

   `UserID` must be unique in the data set\.     
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/parameters-set-up.html)

   After you finish this procedure, you can use these fields to choose the default settings for each user, based on a filter you create\. To learn more about using filters with parameters, see [Using Filters with Parameters in Amazon QuickSight](parameters-filtering-by.md)\.

   We recommend that you put all dynamic default definitions in a single table\. 

1. Create a data set based on this data, and add it to your analysis\.

1. Open the **Parameters** pane, choose a parameter's context \(`v`\) menu, and choose **Edit parameter**\. 

1. Choose **Set a dynamic default**\. 

1. Choose the data set that you put your user ID and dynamic default values in\. Then choose the `UserID` column for the **User name column**\. Next, choose the relevant value field for the **Default value column**, for example `Region` or `Segment`\. 

   For example, in the following screenshot, the user chooses the data set they created for this \(`DynamicDefaultsForSales`\), then chooses the user name column \(`userID`\)\. Then the user chooses the column that contains the default values \(`Region`\) to use for each user in `DynamicDefaultsForSales`\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/parameter-dynamic-defaults.png)

1. Choose **Apply** to save your changes\. Each user's dynamic default value is used in the parameter controls, the first time the user opens the page\. You can have more columns in your data set to choose dynamic defaults for additional columns\. 

   Amazon QuickSight uses the static default value for users who don't exist in the data set, don't have a default assigned to them, or don't have unique defaults\. Each user must have only a single set of defaults\. If you don't want to use dynamic defaults, you can choose to set a static default\. 

   If there is no static default either, then the user can still choose values from the controls\. Also, having a dynamic default set doesn't stop users from choosing a different value from the control\. 
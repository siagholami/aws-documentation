# Restricting Access to a Data Set by Using Row\-Level Security<a name="restrict-access-to-a-data-set-using-row-level-security"></a>

In the Enterprise edition of Amazon QuickSight, you can restrict access to a data set by configuring row\-level security on it\. You can do this before or after you have shared the data set\. Only the people you shared with can see any of the data\. By adding row\-level security, you can further control their access\.

To do this, you create a query or file that has one column named `UserName`, `GroupName`, or both\. You can also think of this as *adding a rule* for that user or group\. Then you can add one column to the query or file for each field that you want to grant or restrict access to\. For each user or group name that you add, you add the values for each field\. You can use NULL \(no value\) to mean all values\. To see examples of data set rules, see [Creating Data Set Rules for Row\-Level Security](#create-data-set-rules-for-row-level-security)\.

To apply the data set rules, you add the rules as a permissions data set to your data set\. Then you choose to explicitly allow or deny access based on the data set rules\. Allowing access is the default\. Keep in mind these points when you allow and deny access:
+ The permissions data set can't contain duplicate values\. Duplicates are ignored when evaluating how to apply the rules\.
+ If you use the rules to *grant access*, each user or group specified can see only the rows that *match* the field values in the data set rules\. 
+ If you add a rule for a user or group and leave all the other columns with no value \(NULL\), you grant them access to all the data\. 
+ If you don't add a rule for a user or group, that user or group can't see any of the data\. 
+ If you use the rules to *deny access*, each user or group specified can see only the rows that *don't match* the field values in the data set rules\. 
+ If you add a rule for a user or group and leave all the other columns with no value \(NULL\), you deny the user or group access to all the data\.
+ If you don't add a rule for a user or group, they are denied nothing—in other words, they can see all the data\. 

Amazon QuickSight treats spaces as literal values\. If you have a space in a field that you are restricting, the data set rule applies to those rows\. Amazon QuickSight treats both NULLs and blanks \(empty strings “”\) as "no value"\. A NULL is an empty field value\. 

Depending on what data source your data set is coming from, you can configure a direct query to access a table of permissions\. Terms with spaces inside them don't need to be delimited with quotes\. If you use a direct query, you can easily change the query in the original data source\. 

Alternatively, you can upload data set rules from a text file or spreadsheet\. If you are using a comma\-separated value \(CSV\) file, don't include any spaces on the given line\. Terms with spaces inside them need to be delimited with quotes\. If you use data set rules that are file\-based, apply any changes by overwriting the existing rules in the data set's permissions settings\.

Data sets that are restricted are marked with the word **RESTRICTED** in the **Your Data Sets** screen\.

Row\-level security only works for fields containing textual data \(string, char, varchar, and so on\)\. It doesn't currently work for dates or numeric fields\. 

## Creating Data Set Rules for Row\-Level Security<a name="create-data-set-rules-for-row-level-security"></a>

Use the following procedure to create a permissions files or query to use as data set rules\.

1. Create a file or a query that contains the data set rules \(permissions\)\. 

   It doesn't matter what order the fields are in\. However, all the fields are case\-sensitive\. They must exactly match the field names and values\. 

   The structure should look similar to the following\.     
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/restrict-access-to-a-data-set-using-row-level-security.html)

   Alternatively, if you prefer to use a \.csv file, the structure should look similar to the following\.

   ```
   UserName,Region,Segment
   AlejandroRosalez,EMEA,"Enterprise,SMB,Startup"
   MarthaRivera,US,Enterprise
   NikhilJayashankars,US,SMB
   PauloSantos,US,Startup
   SaanviSarkar,APAC,"SMB,Startup"
   sales-tps@example.com,"",""
   ZhangWei,APAC,"Enterprise,Startup"
   ```

   Following is a SQL example\.

   ```
   select User as UserName, Region, Segment
   from tps-permissions
   ```

1. Create a data set for the data set rules\. To make sure you can easily find it, give it a meaningful name, for example “Permissions\-Sales\-Pipeline”\.

## Creating Row\-Level Security<a name="create-row-level-security"></a>

Use the following procedure to apply row\-level permissions by using a file or query that contains data set rules\.

1. Confirm that you have added your rules as a new data set\. If you added them, but don't see them under the list of data sets, refresh the screen\.

1. On the **Your Data Sets** page, choose the data set, and then choose **Permissions**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-set-permissions.png)

1. From the list of data sets, choose your permissions data set\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-set-rules.png)

   If your permissions data set doesn't appear on this screen, return to your data sets, and refresh the page\.

1. Choose the permissions policy\. There are two choices: 
   + To use the data set rules to allow access to the data, choose **Grant access to data set**\.
   + To use the data set rules to prevent access to the data, choose **Deny access to data set**\.

   Each data set has only one active permissions data set\. If you try to add a second permissions data set, it overwrites the existing one\.
**Important**  
Some restrictions apply to NULL and empty string values when working with row\-level security\.   
If your data set has NULL values or empty strings \(“”\) in the restricted fields, these rows are ignored when the restrictions are applied\.   
Inside the permissions data set, NULL values and empty strings are treated differently\. For more information, see the following table\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/restrict-access-to-a-data-set-using-row-level-security.html)

   Anyone you shared your dashboard with can see all the data in it, unless the data set is restricted by data set rules\. 

   There are two ways to create a super user\. If you use your permissions data set to grant access, list all possible values for each field for that user\. Alternatively, if you use your permissions data set to deny access, leave the values blank for all restricted fields for that user\. In either case, a user configured this way can see all values\. 

1. To save your changes, choose **Apply data set**\. Then, on the **Confirm: saving data set rules** screen, choose **Apply data set**\. Changes in permissions apply immediately to existing users\. 

1. \(Optional\) To remove permissions, first remove the data set rules from the data set\. 

   Make certain the data set rules are removed\. Then, choose the permissions data set and choose **Remove data set**\.

   To overwrite permissions, choose a new permissions data set and apply it\. You can reuse the same data set name, but you need to apply the new permissions in the **Permissions** screen to make these permissions active\. SQL queries dynamically update, so these can be managed outside of Amazon QuickSight\. In this case, permissions refresh when the direct query cache is automatically refreshed\.

If you delete a file\-based permissions data set before you remove it from the target data set, restricted users can't access the data set\. While the data set is in this state, it remains marked as **RESTRICTED**\. However, when you view **Permissions** for that data set, you can see that it has no selected data set rules\. To fix this, you can specify new data set rules\. Creating a data set with the same name is not enough to fix this\. You must choose the new permissions data set in the **Permissions** screen\. This restriction doesn't apply to direct SQL queries\.
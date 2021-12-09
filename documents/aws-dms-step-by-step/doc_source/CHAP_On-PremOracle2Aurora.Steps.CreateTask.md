# Step 6: Create a Migration Task<a name="CHAP_On-PremOracle2Aurora.Steps.CreateTask"></a>

When you create a migration task you tell AWS DMS exactly how you want your data migrated\. Within a task you define which tables you’d like migrated, where you’d like them migrated, and how you’d like them migrated\. If you’re planning to use the change capture and apply capability of AWS DMS it’s important to know transactions are maintained within a single task\. In other words, you should migrate all tables that participate in a single transaction together in the same task\.

Using an AWS DMS task, you can specify what schema to migrate and the type of migration\. You can migrate existing data, migrate existing data and replicate ongoing changes, or replicate data changes only\. This walkthrough migrates existing data only\.

**To create a migration task**

1. On the navigation pane, choose **Tasks**\. 

1. Choose **Create Task**\. 

1. On the **Create Task** page, specify the task options\. The following table describes the settings\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateTask.html)

1. Next, set the Advanced settings as shown following\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateTask.html)

1. Set additional parameters\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_On-PremOracle2Aurora.Steps.CreateTask.html)

1. Specify any table mapping settings\.

   Table mappings tell AWS DMS which tables a task should migrate from source to target\. Table mappings are expressed in JSON, though some settings can be made using the AWS Management Console\. Table mappings can also include transformations such as changing table names from upper case to lower case\.

   AWS DMS generates default table mappings for each \(non\-system\) schema in the source database\. In most cases you’ll want to customize your table mapping\. To customize your table mapping select the custom radio button\. For details on creating table mappings see the AWS DMS documentation\. The following table mapping does these things:
   + It includes the DMS\_SAMPLE schema in the migration\.
   + It excludes the tables NFL\_DATA, MLB\_DATA, NAME\_DATE, and STADIUM\_DATA\.
   + It converts the schema, table, and column names to lower case\.

   ```
   {
     "rules": [
       {
         "rule-type": "selection",
         "rule-id": "1",
         "rule-name": "1",
         "object-locator": {
           "schema-name": "DMS_SAMPLE",
           "table-name": "%"
         },
         "rule-action": "include"
       },
       
       {
         "rule-type": "selection",
         "rule-id": "2",
         "rule-name": "2",
         "object-locator": {
           "schema-name": "DMS_SAMPLE",
           "table-name": "MLB_DATA"
         },
         "rule-action": "exclude"
       },
   {
         "rule-type": "selection",
         "rule-id": "3",
         "rule-name": "3",
         "object-locator": {
           "schema-name": "DMS_SAMPLE",
           "table-name": "NAME_DATA"
         },
         "rule-action": "exclude"
       },
       
       {
         "rule-type": "selection",
         "rule-id": "4",
         "rule-name": "4",
         "object-locator": {
           "schema-name": "DMS_SAMPLE",
           "table-name": "NFL_DATA"
         },
         "rule-action": "exclude"
       },
   
       {
         "rule-type": "selection",
         "rule-id": "5",
         "rule-name": "5",
         "object-locator": {
           "schema-name": "DMS_SAMPLE",
           "table-name": "NFL_STADIUM_DATA"
         },
         "rule-action": "exclude"
       },{
         "rule-type": "transformation",
         "rule-id": "6",
         "rule-name": "6",
         "rule-action": "convert-lowercase",
         "rule-target": "schema",
         "object-locator": {
           "schema-name": "%"
         }
       },
       {
         "rule-type": "transformation",
         "rule-id": "7",
         "rule-name": "7",
         "rule-action": "convert-lowercase",
         "rule-target": "table",
         "object-locator": {
           "schema-name": "%",
           "table-name": "%"
         }
       },
       {
         "rule-type": "transformation",
         "rule-id": "8",
         "rule-name": "8",
         "rule-action": "convert-lowercase",
         "rule-target": "column",
         "object-locator": {
           "schema-name": "%",
           "table-name": "%",
           "column-name": "%"
         }
       }
     ]
   }
   ```
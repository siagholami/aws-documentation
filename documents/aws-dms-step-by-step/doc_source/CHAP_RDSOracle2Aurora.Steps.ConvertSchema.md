# Step 5: Use the AWS Schema Conversion Tool \(AWS SCT\) to Convert the Oracle Schema to Aurora MySQL<a name="CHAP_RDSOracle2Aurora.Steps.ConvertSchema"></a>

Before you migrate data to Aurora MySQL, you convert the Oracle schema to an Aurora MySQL schema as described following\.

**To convert an Oracle schema to an Aurora MySQL schema using AWS Schema Conversion Tool \(AWS SCT\)**

1. Launch the AWS Schema Conversion Tool \(AWS SCT\)\. In the AWS SCT, choose **File**, then choose **New Project**\. Create a new project called **DMSDemoProject**\. Enter the following information in the New Project window and then choose **OK**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.ConvertSchema.html)  
![\[Creating a new project in the AWS Schema Conversion Tool\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora10.9.png)

1. Choose **Connect to Oracle**\. In the **Connect to Oracle** dialog box, enter the following information, and then choose **Test Connection**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.ConvertSchema.html)  
![\[Creating a new project in the AWS Schema Conversion Tool\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora11.png)

1. Choose **OK** to close the alert box, then choose OK to close the dialog box and to start the connection to the Oracle DB instance\. The database structure on the Oracle DB instance is shown\. Select only the HR schema\.  
![\[Testing a connection\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora12.png)

1. Choose **Connect to Amazon Aurora**\. In the **Connect to Amazon Aurora** dialog box, enter the following information and then choose **Test Connection**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.ConvertSchema.html)  
![\[Creating a new project in the AWS Schema Conversion Tool\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora12.5.png)

   AWS SCT analyses the HR schema and creates a database migration assessment report for the conversion to Amazon Aurora MySQL\. 

1. Choose **OK** to close the alert box, then choose **OK** to close the dialog box to start the connection to the Amazon Aurora MySQL DB instance\.

1. Right\-click the HR schema and select **Create Report**\.  
![\[Database migration report in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora12.7.png)

1.  Check the report and the action items it suggests\. The report discusses the type of objects that can be converted by using AWS SCT, along with potential migration issues and actions to resolve these issues\. For this walkthrough, you should see something like the following\.  
![\[Database migration report in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora13.png)

1. Save the report as \.csv or \.pdf format for detailed analysis, and then choose the **Action Items** tab\. In the action items, you will see two issues: 1\. MySQL does not support Check constraints and 2\. MySQL does not support Sequences\.

    Regarding action item \#1, SCT automatically provisions triggers to simulate check constraints in Aurora MySQL database \(Emulating triggers\)\. For example, a check constraint for SAL > 0 in the EMPLOYEES table \(in Oracle\) is enforced with the help of before and update trigger statements in Aurora MySQL\. If you would like to have this logic handled at the application layer, then you can drop or update the triggers if required\.

   Regarding action item \#2, there are three sequence objects in the source database that are used to generate primary keys for the EMPLOYEES \(EMPLOYEE\_ID\), DEPARTMENTS \(DEPARTMENT\_ID\), LOCATIONS \(LOCATION\_ID\) tables\. As mentioned earlier in this walkthrough, one alternative to using sequences for Surrogate keys in Aurora MySQL is using the auto\_increment feature\. To enable the auto\_increment feature, you must change the settings for SCT\. For brevity, the following substeps show enabling auto\_increment for EMPLOYEE\_ID column in the EMPLOYEES table only\. The same procedure can be repeated for the other sequence objects\.

   Before starting, please note enabling the auto\_increment option requires some additional steps via SCT due to the below reasons:
   + SCT by default converts all NUMBER \(Oracle\) data types into DECIMAL in Aurora MySQL \([http://docs\.aws\.amazon\.com/dms/latest/userguide/SchemaConversionTool/latest/userguide/CHAP\_SchemaConversionTool\.Reference\.ConversionSupport\.Oracle\.html\#d0e50104](http://docs.aws.amazon.com/SchemaConversionTool/latest/userguide/CHAP_SchemaConversionTool.Reference.ConversionSupport.Oracle.html#d0e50104)\)\.
   + Aurora MySQL doesn’t support auto\_increment for the DECIMAL data type\. Therefore, the data type of the primary key column and corresponding foreign key columns needs to be changed to one of the INTEGER data types such as INT, SMALLINT, MEDIUMINT or BIGINT as part of the schema conversion\.

   The good news is that the latest release of SCT provides a **Mapping Rules** feature that can be used to achieve the above transformation using the following steps:

   1. For the EMPLOYEES table, you must identify the primary key and foreign key relationships by running the following query on the source Oracle database\. Note the columns that need to be specified in the SCT Mapping rules\.

      ```
      SELECT * FROM
      (SELECT 
       PK.TABLE_NAME, 
       C.COLUMN_NAME,
       PK.CONSTRAINT_TYPE
          FROM DBA_CONSTRAINTS PK,
         DBA_CONS_COLUMNS C
          WHERE PK.CONSTRAINT_NAME = C.CONSTRAINT_NAME
          AND PK.OWNER = 'HR' AND PK.TABLE_NAME = 'EMPLOYEES' AND PK.CONSTRAINT_TYPE = 'P'
      UNION
       SELECT 
       FK.TABLE_NAME, 
       COL.COLUMN_NAME,
       FK.CONSTRAINT_TYPE
          FROM DBA_CONSTRAINTS PK,
          DBA_CONSTRAINTS FK,
          DBA_CONS_COLUMNS COL
          WHERE PK.CONSTRAINT_NAME = FK.R_CONSTRAINT_NAME
           AND FK.CONSTRAINT_TYPE = 'R'
          AND FK.CONSTRAINT_NAME = COL.CONSTRAINT_NAME
        AND PK.OWNER = 'HR' AND PK.TABLE_NAME = 'EMPLOYEES' AND PK.CONSTRAINT_TYPE = 'P' )
        ORDER BY 3 ASC;
      ```

      The results of the query should be similar to the following:

      ```
      TABLE_NAME	COLUMN_NAME	CONSTRAINT_TYPE
      EMPLOYEES	EMPLOYEE_ID	P
      JOB_HISTORY	EMPLOYEE_ID	R
      EMPLOYEES	MANAGER_ID	R
      DEPARTMENTS	MANAGER_ID	R
      ```

   1. Choose **Settings**, and then choose **Mapping Rules**\.

   1. Specify the Mapping rule for Data type conversions for the list of identified columns in Step1\. You will need to specify 4 rules, one for each column as described below\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Aurora.Steps.ConvertSchema.html)

      Note that in a real\-world scenario you would choose the data type based on your requirements\.  
![\[Choosing Convert schema in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora15a.png)

   1. Choose **Yes** for “Would you like to save Mapping Rule settings?”

1. Right\-click the HR schema, and then choose **Convert schema**\.  
![\[Choosing Convert schema in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora16.png)

1. Choose **Yes** for the confirmation message\. AWS SCT then converts your schema to the target database format\.  
![\[AWS SCT schema conversion\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora17.png)

1. Choose the HR schema, and then choose **Apply to database** to apply the schema scripts to the target Aurora MySQL instance, as shown following\.  
![\[Applying AWS SCT schema scripts\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora18.png)

1. Choose the HR schema, and then choose **Refresh from Database** to refresh from the target database, as shown following\.  
![\[Refreshing from the target database\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2aurora19.png)

The database schema has now been converted and imported from source to target\.
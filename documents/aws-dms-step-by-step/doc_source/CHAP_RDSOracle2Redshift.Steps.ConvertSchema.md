# Step 5: Use AWS SCT to Convert the Oracle Schema to Amazon Redshift<a name="CHAP_RDSOracle2Redshift.Steps.ConvertSchema"></a>

Before you migrate data to Amazon Redshift, you convert the Oracle schema to an Amazon Redshift schema as described following\.

**To convert an Oracle schema to an Amazon Redshift schema using AWS SCT**

1. Launch AWS SCT\. In AWS SCT, choose **File**, then choose **New Project**\. Create a new project called **DWSchemaMigrationDemoProject**\. Enter the following information in the New Project window, and then choose **OK**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.ConvertSchema.html)  
![\[Creating a new project in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift11.png)

1. Choose **Connect to Oracle**\. In the **Connect to Oracle** dialog box, enter the following information, and then choose **Test Connection**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.ConvertSchema.html)  
![\[Creating a new project in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift11.5.png)

1. Choose **OK** to close the alert box, then choose OK to close the dialog box and to start the connection to the Oracle DB instance\. The database structure on the Oracle DB instance is shown following\. Select only the SH schema\.
**Note**  
If the SH schema does not appear in the list, choose **Actions**, then choose **Refresh from Database**\.  
![\[Testing a connection\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift12.png)

1. Choose **Connect to Amazon Redshift**\. In the **Connect to Amazon Redshift** dialog box, enter the following information and then choose **Test Connection**\.    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/dms/latest/sbs/CHAP_RDSOracle2Redshift.Steps.ConvertSchema.html)  
![\[Creating a new project in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift12.5.png)

   AWS SCT analyzes the SH schema and creates a database migration assessment report for the conversion to Amazon Redshift\. 

1. Choose **OK** to close the alert box, then choose **OK** to close the dialog box to start the connection to the Amazon Redshift DB instance\.

1. In the **Oracle DW** view, open the context \(right\-click\) menu for the **SH** schema and select **Create Report**\.

1. Review the report summary\. To save the report, choose either **Save to CSV** or **Save to PDF**\.

   The report discusses the type of objects that can be converted by using AWS SCT, along with potential migration issues and actions to resolve these issues\. For this walkthrough, you should see something like the following\.  
![\[Database migration report in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift13.png)

1. Choose the **Action Items** tab\. The report discusses the type of objects that can be converted by using AWS SCT, along with potential migration issues and actions to resolve these issues\. For this walkthrough, you should see something like the following\.  
![\[Choosing Action Items in AWS SCT\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift15a.png)

1. Open the context \(right\-click\) menu for the **SH** item in the **Schemas** list, and then choose **Collect Statistics**\. AWS SCT analyzes the source data to recommend the best keys for the target Amazon Redshift database\. For more information, see [Collecting or Uploading Statistics for the AWS Schema Conversion Tool](http://docs.aws.amazon.com/dms/latest/userguide/CHAP_SchemaConversionTool.DW.Statistics.html)\.

1. Open the context \(right\-click\) menu for the **SH** schema, and then choose **Convert schema**\.

1. Choose **Yes** for the confirmation message\. AWS SCT then converts your schema to the target database format\.  
![\[AWS SCT schema conversion\]](http://docs.aws.amazon.com/dms/latest/sbs/images/sbs-rdsor2redshift17.png)
**Note**  
The choice of the Amazon Redshift sort keys and distribution keys is critical for optimal performance\. You can use key management in AWS SCT to customize the choice of keys\. For this walkthrough, we use the defaults recommended by AWS SCT\. For more information, see [Optimizing Amazon Redshift by Using the AWS Schema Conversion Tool](http://docs.aws.amazon.com/SchemaConversionTool/latest/userguide/CHAP_SchemaConversionTool.RedshiftOpt.html)\.

1. In the Amazon Redshift view, open the context \(right\-click\) menu for the **SH** schema, and then choose **Apply to database** to apply the schema scripts to the target Amazon Redshift instance\.

1. Open the context \(right\-click\) menu for the **SH** schema, and then choose **Refresh from Database** to refresh from the target database\.

The database schema has now been converted and imported from source to target\.
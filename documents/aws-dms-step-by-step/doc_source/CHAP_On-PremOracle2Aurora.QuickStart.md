# Migration High\-Level Outline<a name="CHAP_On-PremOracle2Aurora.QuickStart"></a>

To migrate your data from Oracle to Aurora MySQL using AWS DMS, you take the following steps\. If you’ve used AWS DMS before or prefer clicking a mouse to reading, the following summary should help you kick\-start your migration\. To get the details about migration or if you run into questions, see the step\-by\-step guide\.

## Step 1: Prepare Your Oracle Source Database<a name="CHAP_On-PremOracle2Aurora.QuickStart.StepOne"></a>

To use AWS DMS to migrate data from an Oracle source database requires some preparation and we also recommend a few additional steps as best practices\.
+ AWS DMS account – It’s a good practice to create a separate account for the specific purpose of migrating your data\. This account should have the minimal set of privileges required to migrate your data\. Specific details regarding those privileges are outlined below\. If you are simply interested in testing AWS DMS on a non\-production database, any DBA account will be sufficient\.
+ Supplemental logging – To capture changes, you must enable supplemental logging in order to use DMS\. To enable supplemental logging at the database level issue the following command\.

  ```
  ALTER DATABASE ADD SUPPLEMENTAL LOG DATA
  ```

  Additionally, AWS DMS requires for each table being migrated, you set at least key\-level supplemental logging\. AWS DMS automatically adds this supplemental logging for you if you include the following extra connection parameter for your source connection\.

  ```
  addSupplementalLogging=Y
  ```
+ Source database – To migrate your data, the AWS DMS replication server needs access to your source database\. Make sure that your firewall rules give the AWS DMS replication server ingress\.

## Step 2: Launch and Prepare Your Aurora MySQL Target Database<a name="CHAP_On-PremOracle2Aurora.QuickStart.StepTwo"></a>

Following are some things to consider when launching your Aurora MySQL instance:
+ For best results, we recommend that you locate your Aurora MySQL instance and your replication instance in the same VPC and, if possible, the same Availability Zone\.  
+ We recommend that you create a separate account with minimal privileges for migrating your data\. The AWS DMS account needs the following privileges on all databases to which data is being migrated\. 

  ```
  ALTER, CREATE, DROP, INDEX, INSERT, UPDATE, DELETE, SELECT
  ```

  Additionally, AWS DMS needs complete access to the awsdms\_control database\. This database holds information required by AWS DMS specific to the migration\. To provide access, run the following command\.

  ```
  ALL PRIVILEGES ON awsdms_control.* TO 'dms_user'
  ```

## Step 3: Launch a Replication Instance<a name="CHAP_On-PremOracle2Aurora.QuickStart.StepThree"></a>

The AWS DMS service connects to your source and target databases from a replication instance\. Here are some things to consider when launching your replication instance:
+ For best results, we recommend that you locate your replication instance in the same VPC and Availability Zone as your target database, in this case Aurora MySQL\.
+ If either your source or target database is outside of the VPC where you launch your replication server, the replication server must be publicly accessible\.
+ AWS DMS can consume a fair bit of memory and CPU\. However, it’s easy enough to scale up if necessary\. If you anticipate running several tasks on a single replication server or 
+ The default storage is usually enough for most migrations\.

## Step 4: Create a Source Endpoint<a name="CHAP_On-PremOracle2Aurora.QuickStart.StepFour"></a>

For AWS DMS to access your Oracle source database you’ll need to create a source endpoint\. The source endpoint defines all the information required for AWS DMS to connect to your source database from the replication server\. Following are some requirements for the source endpoint\.
+ Your source endpoint needs to be accessible from the replication server\. To allow this, you will likely need to modify your firewall rules to whitelist the replication server\. You can find the IP address of your replication server in the AWS DMS Management Console\.
+ For AWS DMS to capture changes, Oracle requires supplemental logging be enabled\. If you want AWS DMS to enable supplemental logging for you, add the following to the extra connection attributes for your Oracle source endpoint\.

  ```
  addSupplementalLogging=Y
  ```

## Step 5: Create a Target Endpoint<a name="CHAP_On-PremOracle2Aurora.QuickStart.StepFive"></a>

For AWS DMS to access your Aurora MySQL target database you’ll need to create a target endpoint\. The target endpoint defines all the information required for DMS to connect to your Aurora MySQL database\.
+ Your target endpoint needs to be accessible from the replication server\. You might need to modify your security groups to make the target endpoint accessible\.
+ If you’ve pre\-created the database on your target, it’s a good idea to disable foreign key checks during the full load\. To do so, add the following to your extra connection attributes\.

  ```
  initstmt=SET FOREIGN_KEY_CHECKS=0
  ```

## Step 6: Create and Run a Migration Task<a name="CHAP_On-PremOracle2Aurora.QuickStart.StepSix"></a>

A migration task tells AWS DMS where and how you want your data migrated\. When creating your migration task, you should consider setting migration parameters as follows\.

**Endpoints and replication server** — Choose the endpoints and replication server created above\. 

**Migration type** — In most cases you’ll want to choose **migrate existing data and replication ongoing changes**\. With this option, AWS DMS loads your source data while capturing changes to that data\. When the data is fully loaded, AWS DMS applies any outstanding changes and keeps the source and target databases in sync until the task is stopped\.

**Target table preparation mode ** — If you’re having AWS DMS create your tables, **choose drop tables on target**\. If you’re using some other method to create your target tables such as the AWS Schema Conversion Tool, choose **truncate\.**

**LOB parameters ** — If you’re just trying AWS DMS, choose **include LOB columns in replication**, **Limited LOB mode**, and set your **max LOB size to 16** \(which is 16k\.\) For more information regarding LOBs, read the details in the step\-by\-step guide\.

**Enable logging ** — To help with debugging migration issues, always enable logging\.

**Table mappings ** — When migrating from Oracle to Aurora MySQL, we recommend that you convert your schema, table, and column names to lowercase\. To do so, create a custom table mapping\. The following example migrates the schema DMS\_SAMPLE and converts schema, table and column names to lower case\.

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
# Tracking Non\-API Events by Using CloudTrail Logs<a name="logging-non-api"></a>

Following is a list of the non\-API events you can track\.

**User Management**
+  **CreateAccount** – Create Account
+ **BatchCreateUser** – Create User
+ **BatchResendUserInvite** – Invite User
+ **UpdateGroups** – Update Groups

  This event works with Enterprise edition only\.
+ **UpdateSpiceCapacity** – Update SPICE Capacity
+ **DeleteUser** – Delete User
+ **Unsubscribe** – Unsubscribe User

**Subscription**
+ **CreateSubscription** – Create Subscription
+ **UpdateSubscription** – Update Subscription
+ **DeleteSubscription** – Delete Subscription

**Dashboard**
+ **GetDashboard** – Get Dashboard
+ **CreateDashboard** – Create Dashboard
+ **UpdateDashboard** – Update Dashboard
+ **UpdateDashboardAccess** – Update Dashboard Access
+ **DeleteDashboard** – Delete Dashboard

**Analysis**
+ **GetAnalysis** – Get Analysis
+ **CreateAnalysis** – Create Analysis
+ **UpdateAnalysisAccess** – Update Analysis Access
+ **UpdateAnalysis** – Update Analysis
  + **RenameAnalysis** – Rename Analysis
  + **CreateVisual** – Create Visual
  + **RenameVisual** – Rename Visual
  + **DeleteVisual** – Delete Visual
  + **DeleteAnalysis** – Delete Analysis

**Data Source**
+ **CreateDataSource** – Create Data Source
  + **FlatFile** – Flat file
  + **External** – External
  + **S3** – S3
  + **ImportS3ManifestFile** – S3 Manifest File
  + **Presto** – Presto
  + **RDS** – RDS
  + **Redshift** – Redshift \(manual\)
+ **UpdateDataSource** – Update Data Source
+ **DeleteDataSource** – Delete Data Source

**Data Set**
+  **CreateDataSet** – Create Data Set
  + **CustomSQL** – Custom SQL
  + **SQLTable** – SQL Table
  + **File** – CSV or XLSX
+ **UpdateDataSet** – Update SQL Join Dataset
+ **UpdateDatasetAccess** – Update Dataset Access
+ **DeleteDataSet** – Delete Dataset
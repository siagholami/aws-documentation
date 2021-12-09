# Step 3: Configure Your Aurora MySQL Target Database<a name="CHAP_SQLServer2Aurora.Steps.ConfigureAurora"></a>

AWS DMS migrates the data from the SQL Server source into an Amazon Aurora MySQL target\. In this step, you configure the Aurora MySQL target database\.

1. Create the AWS DMS user to connect to your target database, and grant Superuser or the necessary individual privileges \(or for Amazon RDS, use the master username\)\.

   Alternatively, you can grant the privileges to an existing user\.

   ```
   CREATE USER 'aurora_dms_user' IDENTIFIED BY 'password'; 
   
   GRANT ALTER, CREATE, DROP, INDEX, INSERT, UPDATE, DELETE, 
   SELECT ON target_database.* TO 'aurora_dms_user';
   ```

1. AWS DMS uses control tables on the target in the database `awsdms_control`\. Use the following command to ensure that the user has the necessary access to the `awsdms_control` database:

   ```
   GRANT ALL PRIVILEGES ON awsdms_control.* TO 'aurora_dms_user';
   FLUSH PRIVILEGES;
   ```
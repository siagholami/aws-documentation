# Step 3: Configure Your PostgreSQL Target Database<a name="CHAP_Oracle2PostgreSQL.Steps.ConfigurePostgreSQL"></a>

1. If the schemas you are migrating do not exist on the PostgreSQL database, then create the schemas\.

1. Create the AWS DMS user to connect to your target database, and grant Superuser or the necessary individual privileges \(or use the master username for RDS\)\.

   ```
   CREATE USER postgresql_dms_user WITH PASSWORD 'password'; 
   ALTER USER postgresql_dms_user WITH SUPERUSER;
   ```

1. Create a user for AWS SCT\.

   ```
   CREATE USER postgresql_sct_user WITH PASSWORD 'password';
   
   GRANT CONNECT ON DATABASE database_name TO postgresql_sct_user;
   GRANT USAGE ON SCHEMA schema_name TO postgresql_sct_user;
   GRANT SELECT ON ALL TABLES IN SCHEMA schema_name TO postgresql_sct_user;
   GRANT ALL ON SEQUENCES IN SCHEMA schema_name TO postgresql_sct_user;
   ```
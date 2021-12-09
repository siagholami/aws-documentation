# Step 2: Configure Your Aurora Target Database<a name="CHAP_On-PremOracle2Aurora.Steps.ConfigureAurora"></a>

As with your source database, it’s a good idea to restrict access of the user you’re connecting with\. You can also create a temporary user that you can remove after the migration\.

```
CREATE USER 'dms_user'@'%' IDENTIFIED BY 'dms_user';
GRANT ALTER, CREATE, DROP, INDEX, INSERT, UPDATE, DELETE, 
SELECT ON <target database(s)>.* TO 'dms_user'@'%';
```

AWS DMS uses some control tables on the target in the database awsdms\_control\. The following command ensures that your dms\_user has the necessary access to the awsdms\_control database:

```
GRANT ALL PRIVILEGES ON awsdms_control.* TO 'dms_user'@'%';
flush privileges;
```
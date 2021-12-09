# Rolling Back the Migration<a name="CHAP_Oracle2PostgreSQL.Rollback"></a>

If there are major issues with the migration that cannot be resolved in a timely manner, you can roll back the migration\. These steps assume that you have already prepared for the rollback as described in [Step 8: Cut Over to PostgreSQL](CHAP_RDSOracle2PostgreSQL.Steps.CutOver.md)\.

**To roll back the migration**

1. Stop all application services on the target PostgreSQL database\.

1. Let the AWS DMS task replicate remaining changes back to the source Oracle database\.

1. Stop the PostgreSQL to Oracle AWS DMS task\.

1. Start all applications back on the source Oracle database\.
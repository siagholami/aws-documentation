# IAM Database Authentication<a name="UsingWithRDS.IAMDBAuth"></a>

You can authenticate to your DB cluster using AWS Identity and Access Management \(IAM\) database authentication\. IAM database authentication works with Aurora MySQL and Aurora PostgreSQL\. With this authentication method, you don't need to use a password when you connect to a DB cluster\. Instead, you use an authentication token\.

An *authentication token* is a unique string of characters that Amazon Aurora generates on request\. Authentication tokens are generated using AWS Signature Version 4\. Each token has a lifetime of 15 minutes\. You don't need to store user credentials in the database, because authentication is managed externally using IAM\. You can also still use standard database authentication\.

IAM database authentication provides the following benefits:
+ Network traffic to and from the database is encrypted using Secure Sockets Layer \(SSL\)\.
+ You can use IAM to centrally manage access to your database resources, instead of managing access individually on each DB cluster\.
+ For applications running on Amazon EC2, you can use profile credentials specific to your EC2 instance to access your database instead of a password, for greater security\.

**Topics**
+ [Availability for IAM Database Authentication](#UsingWithRDS.IAMDBAuth.Availability)
+ [Limitations for IAM Database Authentication](#UsingWithRDS.IAMDBAuth.Limitations)
+ [Aurora MySQL Recommendations for IAM Database Authentication](#UsingWithRDS.IAMDBAuth.ConnectionsPerSecond)
+ [Enabling and Disabling IAM Database Authentication](UsingWithRDS.IAMDBAuth.Enabling.md)
+ [Creating and Using an IAM Policy for IAM Database Access](UsingWithRDS.IAMDBAuth.IAMPolicy.md)
+ [Creating a Database Account Using IAM Authentication](UsingWithRDS.IAMDBAuth.DBAccounts.md)
+ [Connecting to Your DB Cluster Using IAM Authentication](UsingWithRDS.IAMDBAuth.Connecting.md)

## Availability for IAM Database Authentication<a name="UsingWithRDS.IAMDBAuth.Availability"></a>

IAM database authentication is available for the following database engines and DB instance classes:
+ Aurora with MySQL compatibility version 1\.10 or higher\. All DB instance classes are supported, except for db\.t2\.small and db\.t3\.small\.
+ Aurora with PostgreSQL compatibility, PostgreSQL versions 9\.6\.9 and 10\.4 or higher\.

## Limitations for IAM Database Authentication<a name="UsingWithRDS.IAMDBAuth.Limitations"></a>

When using IAM database authentication, the following limitations apply:
+ The maximum number of connections per second for your DB cluster might be limited depending on its DB instance class and your workload\.
+ Currently, IAM database authentication doesn't support global condition context keys\.

  For more information about global condition context keys, see [ AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.
+ Currently, IAM database authentication isn't supported for CNAMEs\.
+ Currently, Aurora MySQL parallel query doesn't support IAM database authentication\.

## Aurora MySQL Recommendations for IAM Database Authentication<a name="UsingWithRDS.IAMDBAuth.ConnectionsPerSecond"></a>

We recommend the following when using the Aurora MySQL DB engine:
+ Use IAM database authentication as a mechanism for temporary, personal access to databases\.
+ Use IAM database authentication only for workloads that can be easily retried\.
+ Use IAM database authentication when your application requires fewer than 200 new IAM database authentication connections per second\.

  The database engines that work with Amazon Aurora don't impose any limits on authentication attempts per second\. However, when you use IAM database authentication, your application must generate an authentication token\. Your application then uses that token to connect to the DB cluster\. If you exceed the limit of maximum new connections per second, then the extra overhead of IAM database authentication can cause connection throttling\. The extra overhead can cause even existing connections to drop\.   For information about the maximum total connections for Aurora MySQL, see [Maximum Connections to an Aurora MySQL DB Instance](AuroraMySQL.Managing.Performance.md#AuroraMySQL.Managing.MaxConnections)\. 
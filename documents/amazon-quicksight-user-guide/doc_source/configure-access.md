# Network and Database Configuration Requirements<a name="configure-access"></a>

To serve as data sources, databases need to be configured so that Amazon QuickSight can access them\. Use the following sections to make sure that your database is configured appropriately\. 

**Important**  
Because a database instance on Amazon EC2 is administered by you rather than AWS, it must meet both the [Network Configuration Requirements](#network-configuration-requirements) as well as the [Database Configuration Requirements for Self\-Administered Instances](#database-configuration-requirements)\.

## Network Configuration Requirements<a name="network-configuration-requirements"></a>

To be usable from Amazon QuickSight, a database server must be accessible from the internet\. It must also allow inbound traffic from Amazon QuickSight servers\. 

If the database is on AWS and in the same AWS Region as your Amazon QuickSight account, you can auto\-discover the instance to make connecting to it easier\. To do this, you must grant Amazon QuickSight permissions to access it\. For more information, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\.

### Network Configuration for an AWS Instance in a Default VPC<a name="network-configuration-aws-default-vpc"></a>

In some cases, your database might be on an AWS cluster or instance that you created in a default VPC and so is publicly accessible \(that is, you didn't choose to make private\)\. In such cases, your database is already appropriately configured to be accessible from the internet\. However, you still need to enable access from Amazon QuickSight servers to your AWS cluster or instance\. For further details on how to do this, choose the appropriate topic following:
+ [Authorizing Connections from Amazon QuickSight to Amazon RDS DB Instances](enabling-access-rds.md)
+ [Authorizing Connections from Amazon QuickSight to Amazon Redshift Clusters](enabling-access-redshift.md)
+ [Authorizing Connections from Amazon QuickSight to Amazon EC2 Instances](enabling-access-ec2.md)

### Network Configuration for an AWS Instance in a Non\-Default VPC<a name="network-configuration-aws-nondefault-vpc"></a>

If you are configuring an AWS instance in a non\-default VPC, make sure that the instance is publicly accessible and that the VPC has the following: 
+ An internet gateway\.
+ A public subnet\.
+ A route in the route table between the internet gateway and the AWS instance\.
+ Network access control lists \(ACLs\) in your VPC that allow traffic between the cluster or instance and Amazon QuickSight servers\. These ACLs must do the following:
  + Allow inbound traffic from the appropriate Amazon QuickSight IP address range and all ports to the IP address and port that the database is listening on\.
  + Allow outbound traffic from the database’s IP address and port to the appropriate Amazon QuickSight IP address range and all ports\.

  For more information about Amazon QuickSight IP address ranges, see [IP Address Ranges for Amazon QuickSight](#ip-address-ranges) following\.

  For more information about configuring VPC ACLs, see [Network ACLs](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_ACLs.html)\.
+ Security group rules that allow traffic between the cluster or instance and Amazon QuickSight servers\. For further details on how to create appropriate security group rules, see [Authorizing Connections from Amazon QuickSight to AWS Data Stores](enabling-access.md)\.

For more information about configuring a VPC in the Amazon VPC service, see [Networking in Your VPC](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Networking.html)\.

### Network Configuration for an AWS Instance in a Private VPC<a name="network-configuration-aws-private-vpc"></a>

If your database is on an AWS cluster or instance that you created in a private VPC, you can use it with Amazon QuickSight\. For more information, see [Working with Amazon VPC](working-with-aws-vpc.md)\. 

For more information on Amazon Virtual Private Cloud, see [Amazon VPC](https://aws.amazon.com/vpc/) and [Amazon VPC Documentation](https://docs.aws.amazon.com/vpc/)\.

### Network Configuration for an AWS Instance That is Not in a VPC<a name="network-configuration-aws-no-vpc"></a>

If you are configuring an AWS instance that is not in a VPC, make sure that the instance is publicly accessible\. Also, make sure that there is a security group rule that allows traffic between the cluster or instance and Amazon QuickSight servers\. For further details on how to do this, choose the appropriate topic following:
+ [Authorizing Connections from Amazon QuickSight to Amazon RDS DB Instances](enabling-access-rds.md)
+ [Authorizing Connections from Amazon QuickSight to Amazon Redshift Clusters](enabling-access-redshift.md)
+ [Authorizing Connections from Amazon QuickSight to Amazon EC2 Instances](enabling-access-ec2.md)

### Network Configuration for a Non\-AWS Database Instance<a name="network-configuration-not-aws"></a>

If you want to use SSL to secure your connections to your database \(*recommended*\), make sure that you have a certificate signed by a recognized certificate authority \(CA\)\. Amazon QuickSight doesn't accept certificates that are self\-signed or issued from a non\-public CA\. For more information, see [Amazon QuickSight SSL and CA Certificates](#ca-certificates)\.

If your database is on a non\-AWS server, you must change that server's firewall configuration to accept traffic from the appropriate Amazon QuickSight IP address range\. For more information about Amazon QuickSight IP address ranges, see [IP Address Ranges for Amazon QuickSight](#ip-address-ranges)\. Refer to your operating system documentation for any other steps you need to take to enable internet connectivity\.

#### Amazon QuickSight SSL and CA Certificates<a name="ca-certificates"></a>

Following is a list of accepted public Certificate Authorities\. If you are using a non\-AWS database instance, your certificate must be on this list, or it won't work\.


****  

|  |  | 
| --- |--- |
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/configure-access.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/configure-access.html)  | 

#### IP Address Ranges for Amazon QuickSight<a name="ip-address-ranges"></a>

For more information on the IP address ranges for Amazon QuickSight in supported regions, see [AWS Regions and IP Address Ranges](regions.md)\.

## Database Configuration Requirements for Self\-Administered Instances<a name="database-configuration-requirements"></a>

For a database to be accessible to Amazon QuickSight, it must meet the following criteria: 
+ It must be accessible from the internet\. To enable internet connectivity, see your database management system documentation\.
+ It must be configured to accept connections and authenticate access using the user credentials that you provide as part of creating the data set\.
+ If you are connecting to MySQL or PostgreSQL, the database engine must be accessible from your host or IP range\. This optional security limitation is specified in MySQL or PostgreSQL connection settings\. If this limitation is in place, any attempt to connect from a nonspecified host or IP address is rejected, even if you have the correct user name and password\.
+ In MySQL, the server accepts the connection only if the user and host are verified in the user table\. For more information, see [Access Control, Stage 1: Connection Verification](https://dev.mysql.com/doc/refman/5.7/en/connection-access.html) in the MySQL documentation\.
+ In PostgreSQL, you must control client authentication by using the `pg_hba.conf` file in the database cluster's data directory, although this file might be named and located differently on your system\. For more information, see [Client Authentication](https://www.postgresql.org/docs/9.3/static/client-authentication.html) in the PostgreSQL documentation\.
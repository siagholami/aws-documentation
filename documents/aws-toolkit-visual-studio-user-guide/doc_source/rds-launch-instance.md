# Launch an Amazon RDS Database Instance<a name="rds-launch-instance"></a>

With AWS Explorer, you can launch an instance of any of the database engines supported by Amazon RDS\. The following walkthrough shows the user experience for launching an instance of Microsoft SQL Server Standard Edition, but the user experience is similar for all supported engines\.

 **To launch an Amazon RDS instance** 

1. In AWS Explorer, open the context \(right\-click\) menu for the **Amazon RDS** node and choose **Launch DB Instance**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/rds-db-launch-menu.png)

   Alternatively, on the **DB Instances** tab, choose **Launch DB Instance**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/rds-db-launch-dashboard.png)

1. In the **DB Engine Selection** dialog box, choose the type of database engine to launch\. For this walkthrough, choose Microsoft SQL Server Standard Edition \(sqlserver\-se\), and then choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/rds-db-instance-db-engine.png)

1. In the **DB Engine Instance Options** dialog box, choose configuration options\.

   In the **DB Engine Instance Options and Class** section, you can specify the following settings\.

    *License Model*   
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/rds-launch-instance.html)

   The license model varies, depending on the type of database engine\. Engine Type License Microsoft SQL Server license\-included MySql general\-public\-license Oracle bring\-your\-own\-license  
** *DB Instance Version* **  
Choose the version of the database engine you would like to use\. If only one version is supported, it is selected for you\.  
** *DB Instance Class* **  
Choose the instance class for the database engine\. Pricing for instance classes varies\. For more information, see [Amazon RDS Pricing](https://aws.amazon.com/rds/pricing)\.  
** *Perform a multi AZ deployment* **  
Select this option to create a multi\-AZ deployment for enhanced data durability and availability\. Amazon RDS provisions and maintains a standby copy of your database in a different Availability Zone for automatic failover in the event of a scheduled or unplanned outage\. For information about pricing for multi\-AZ deployments, see the pricing section of the [Amazon RDS](https://aws.amazon.com/rds) detail page\. This option is not supported for Microsoft SQL Server\.  
** *Upgrade minor versions automatically* **  
Select this option to have AWS automatically perform minor version updates on your RDS instances for you\.

In the **RDS Database Instance** section, you can specify the following settings\.

** *Allocated Storage* **    
****    
[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/rds-launch-instance.html)
The minimums and maximums for allocated storage depend on the type of database engine\. Engine Minimum \(GB\) Maximum \(GB\) MySQL 5 1024 Oracle Enterprise Edition 10 1024 Microsoft SQL Server Express Edition 30 1024 Microsoft SQL Server Standard Edition 250 1024 Microsoft SQL Server Web Edition 30 1024

** *DB Instance Identifier* **  
Specify a name for the database instance\. This name is not case\-sensitive\. It will be displayed in lowercase form in AWS Explorer\.

** *Master User Name* **  
Type a name for the administrator of the database instance\.

** *Master User Password* **  
Type a password for the administrator of the database instance\.

** *Confirm Password* **  
Type the password again to verify it is correct\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/rds-db-instance-engine-options.png)

1. In the **Additional Options** dialog box, you can specify the following settings\.  
** *Database Port* **  
This is the TCP port the instance will use to communicate on the network\. If your computer accesses the Internet through a firewall, set this value to a port through which your firewall allows traffic\.  
** *Availability Zone* **  
Use this option if you want the instance to be launched in a particular Availability Zone in your region\. The database instance you have specified might not be available in all Availability Zones in a given region\.  
** *RDS Security Group* **  
Select an RDS security group \(or groups\) to associate with your instance\. RDS security groups specify the IP address, Amazon EC2 instances, and AWS accounts that are allowed to access your instance\. For more information about RDS security groups, see [Amazon RDS Security Groups](rds-security-groups.md#tkv-amazon-rds-security-groups)\. The Toolkit for Visual Studio attempts to determine your current IP address and provides the option to add this address to the security groups associated with your instance\. However, if your computer accesses the Internet through a firewall, the IP address the Toolkit generates for your computer may not be accurate\. To determine which IP address to use, consult your system administrator\.  
** *DB Parameter Group* **  
\(Optional\) From this drop\-down list, choose a DB parameter group to associate with your instance\. DB parameter groups enable you to change the default configuration for the instance\. For more information, go to the [Amazon Relational Database Service User Guide](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_WorkingWithParamGroups.html) and [this article](https://aws.amazon.com/articles/2935)\.

   When you have specified settings on this dialog box, choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/rds-db-instance-add-options.png)

1. The **Backup and Maintenance** dialog box enables you to specify whether Amazon RDS should back up your instance and if so, for how long the backup should be retained\. You can also specify a window of time during which the backups should occur\.

   This dialog box also enables you to specify if you would like Amazon RDS to perform system maintenance on your instance\. Maintenance includes routine patches and minor version upgrades\.

   The window of time you specify for system maintenance cannot overlap with the window specified for backups\.

   Choose **Next**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/rds-db-instance-back-up-maintenance.png)

1. The final dialog box in the wizard allows you to review the settings for your instance\. If you need to modify settings, use the **Back** button\. If all the settings are correct, choose **Launch**\.
# Administering AWS Resources Using AWS Management Portal for vCenter<a name="administer-resources"></a>

Administrators for AWS Management Portal for vCenter are responsible for managing an AWS network, known as a virtual private cloud \(VPC\), creating environments, and granting users permission to access environments\.

![\[Deploying an instance from a template\]](http://docs.aws.amazon.com/amp/latest/userguide/images/environment.png)

**Topics**
+ [Managing Administrators](#manage-admins)
+ [Managing VPCs and Subnets](#manage-vpcs)
+ [Managing Security Groups](#manage-sg)
+ [Managing Environments](#manage-environments)
+ [Managing User Permissions](#manage-permissions)

## Managing Administrators<a name="manage-admins"></a>

We recommend that you select several users to administer the management portal\. To add an administrator for the management portal, you must be an administrator for both vCenter and the management portal\.

**To add an administrator**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. From the top pane, click **Admin Users**\.

1. Click **Add**\.
**Tip**  
If you are using the connector to authenticate users and it is in maintenance mode, you'll receive the error "Unable to contact User Provider\. Please contact your Administrator\." We recommend that you wait a few minutes and then try again\.

1. In the **Select Users** dialog box, select the domain and one or more users, and then click **OK**\.

   Note that domains and users are disabled if their names don't meet certain requirements\. If a user is a domain user, *domain*\\*user* must not exceed 32 characters\. If a user is a local user, *user* must not exceed 32 characters\. The *domain* and *user* values must each begin with a letter and contain only the following characters: a\-z, A\-Z, 0\-9, periods \(\.\), underscores \(\_\), and dashes \(\-\)\. 

1. When you are finished adding administrators, click **Save**\.

To remove an administrator for the management portal, you must be an administrator for the management portal\.

**To remove an administrator**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **Admin Users**\.

1. Select the user from the list\.

1. Click **Remove**, and then click **Save**\.

## Managing VPCs and Subnets<a name="manage-vpcs"></a>

By default, you can create up to five VPCs per region\. You can create one or more subnets per VPC and one or more security groups per VPC\. To configure route tables, network ACLs, and other advanced VPC features, you must use the AWS Management Console or the AWS CLI\. For more information about VPCs, see the [Amazon VPC User Guide](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/)\.

Note that each region might also have a default VPC, depending on when you created your AWS account\.

**To create a VPC and subnets**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. From the top pane, click **VPC**\.

1. Select a region for the VPC\. On the **Getting Started** tab, click **Create a virtual private cloud**\.

1. Enter a name for the VPC in **VPC Name**\.

1. Select the configuration that meets your needs, **VPC with a single public subnet** or **VPC with public and private subnets**, and then click **Next**\.

   Note that you can add additional subnets after you create the VPC\. Also, the Amazon VPC console supports additional configurations for your VPC\.

1. Enter an IP address range for the VPC, in CIDR notation \(for example, `10.0.0.0/16`\)\.

1. For each subnet, enter an IP address range, in CIDR notation \(for example, `10.0.0.0/24`\), and select an Availability Zone\. Note that if you create multiple subnets in a VPC, the IP address ranges for the subnets must not overlap\. When you are finished, click **Next**\.

1. \(Optional\) Specify one or more tags for your VPC\. For each tag, click **Add**, enter the tag key, and enter the tag value\.

1. When you are finished adding tags, click **Finish**\.

1. \(Optional\) To add another subnet to your VPC, select the VPC, and then click **Create a subnet** on the **Getting Started** tab\. Enter a name, select an Availability Zone, and enter an IP address range for the subnet, in CIDR notation\. By default, the subnet is a public subnet\. To create a private subnet, click **Make this a private subnet**\. You can also specify one or more tags for the subnet\. When you are finished, click **Finish**\.

You can delete a nondefault VPC only if there are no running instances in its subnets\. You can't delete a default VPC using the management portal\.

**To delete a VPC**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **VPC**\.

1. Expand the region for the VPC, and then select the VPC\.

1. On the **Getting Started** tab, click **Delete the virtual private cloud**\.

1. In the **Delete VPC** dialog box, click **Yes**\.

## Managing Security Groups<a name="manage-sg"></a>

A security group acts as a firewall that controls the traffic for one of more EC2 instances\. You'll create a security group and add rules that allow users to connect to EC2 instances in the VPC associated with the security group\. Users select one or more security groups when they create a template\.

**To create a security group**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. From the top pane, click **VPC**\.

1. Expand the region for the VPC, and then select the VPC\.

1. On the **Getting Started** tab, click **Create a security group**\.

1. Enter a name and a description for the security group, and then click **Next**\.

1. To connect to an EC2 Linux instance, you must add a rule that allows inbound traffic using SSH\. \(Note that you can skip this step and add the rule later by selecting the security group and clicking **Add a rule** on the **Getting Started** tab\.\)

   1. Click **Add**\.

   1. From the **Type** list, select **SSH**\.

   1. From the **Source** list, select **Custom IP**\.

   1. Enter the IP address range in **IP**, in CIDR notation\. For example, if your IP address is `203.0.113.25`, specify `203.0.113.25/32` to list this single IP address in CIDR notation\. If your company allocates addresses from a range, specify the entire range, such as `203.0.113.0/24`\.

   1. Verify that **Inbound** is selected\.

   1. Click **Add**\.

1. To connect to an EC2 Windows instance, you must add a rule that allows inbound traffic using RDP\. \(Note that you can skip this step and add the rule later by selecting the security group and clicking **Add a rule** on the **Getting Started** tab\.\)

   1. Click **Add**\.

   1. From the **Type** list, select **RDP**\.

   1. From the **Source** list, select **Custom IP**\.

   1. Enter the IP address range in **IP**, in CIDR notation\. For example, if your IP address is `203.0.113.25`, specify `203.0.113.25/32` to list this single IP address in CIDR notation\. If your company allocates addresses from a range, specify the entire range, such as `203.0.113.0/24`\.

   1. Verify that **Inbound** is selected\.

   1. Click **Add**\.

1. When you are finished adding rules, click **Next**\.

1. \(Optional\) Specify one or more tags for your security group\. For each tag, click **Add**, enter the tag key, and enter the tag value\. When you are finished entering tags, click **Next**\.

1. Review the properties for your security group\. To make changes, click **Back**\. When you are ready to create the security group, click **Finish**\.

You can delete a security group only if it's not currently associated with an instance\.

**To delete a security group**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **VPC**\.

1. Expand the region and the VPC for the security group, and then select the security group\.

1. On the **Getting Started** tab, click **Delete the security group**\.

1. In the **Delete Security Group** dialog box, click **Yes**\.

To change the security groups for a running instance, you must use the Amazon EC2 console or the AWS CLI\. For more information, see [Security Groups for Your VPC](http://docs.aws.amazon.com/AmazonVPC/latest/UserGuide/VPC_SecurityGroups.html) in the *Amazon VPC User Guide*\.

## Managing Environments<a name="manage-environments"></a>

Administrators use *environments* to organize and manage AWS resources\. They grant permissions to users at the environment level\.

As an administrator, you can create environments, and you have access to default environments\. The *default environment* for a region enables you to manage EC2 instances that were created for your AWS account in that region using tools such as the AWS Management Console, the AWS CLI, or an AWS SDK, instead of using the management portal\.

**To create an environment**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. From the top pane, click **Dashboard**\.

1. Select a region for the environment\. On the **Getting Started** page, click **Create an environment**\.

1. Enter a name for the environment in **Name**\.

1. Select a VPC from **VPC**\. Note that this list includes all VPCs for the region, including VPCs created using the Amazon VPC console and the default VPC \(if it exists\)\. If this list is empty, you must create a VPC in this region\.

1. Select one or more subnets from **Subnets**\. Note that this list includes all subnets for the selected VPC, including any default subnets\. If this list is empty, you must add a subnet to the VPC or select a different VPC\.

1. Click **Finish**\.

After you create an environment, you create one or more templates and use these templates to launch EC2 instances into your environment\. For more information, see [Managing EC2 Instances Using AWS Management Portal for vCenter](manage-instances.md)\. When you launch an instance, we add a tag with the name `aws-management-portal/environment-id` and the value set to the ID of the environment\. You can use this tag to track resources using [detailed billing reports](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/DetailedBillingReports.html) or [EC2 usage reports](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/usage-reports.html)\. Users can't modify this tag using the management portal\. However, users may have access to modify or delete this tag using the Amazon EC2 console, CLI, or API\. If someone modifies or deletes this tag, it can affect users' permissions to access the instance\. Therefore, we recommend that you limit the users who can create, modify, or delete tags\.

You can delete an environment only after you've deleted its templates\.

**To delete an environment**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **Dashboard**\.

1. Expand the region for the environment, and then select the environment\.

1. Right\-click the environment and select **Delete**\.

1. In the **Delete Environment** dialog box, click **Yes**\.

Administrators can describe, start, stop, reboot, and terminate EC2 instances in the default environment for a region using the management portal\.

**To manage instances in the default environment**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **Dashboard** and expand the region\.

1. To list your instances, do one of the following:
   + Expand **Default Environment**\.
   + Click **Default Environment** and then click the **Instances** tab\.

1. To start, stop, reboot, or terminate an instance, expand **Default Environment** and select the instance\. From the **Getting Started** tab, click the desired task under **Basic Tasks**\.

## Managing User Permissions<a name="manage-permissions"></a>

Administrators can manage users' permissions to access an environment\. To grant permissions, you must be an administrator for both vCenter and the management portal\. To edit or delete permissions, you must be an administrator for the management portal\.

The specific permissions granted to a user depend on the role that you assign to the user\. The management portal defines the following roles:

`No-Access`  
No permissions\.

`Read-Only`  
Permissions to view the environment, including its templates and instances\.

`General`  
Includes permissions from `Read-Only`, plus permissions to run, rename, reboot, stop, start, terminate, and import instances\.

`Owner`  
Includes permissions from `General`, plus permissions to create, delete, and rename templates, to import and delete key pairs, and to create images\.

**To grant permissions to a user**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. From the top pane, click **Dashboard**\.

1. Expand the region for the environment, right\-click the environment, and then click **Add Permission**\.

1. Click **Add**\. In the **Select Users** dialog box, select the domain and one or more users, and then click **OK**\.

   Note that domains and users are disabled if their names don't meet certain requirements\. If a user is a domain user, *domain*\\*user* must not exceed 32 characters\. If a user is a local user, *user* must not exceed 32 characters\. The *domain* and *user* values must each begin with a letter and contain only the following characters: a\-z, A\-Z, 0\-9, periods \(\.\), underscores \(\_\), and dashes \(\-\)\. Capitalization of domain and user should match that of the vCenter user\. 

1. Select one or more users from **Users**, and then select a role from **Assigned Role**\.

1. Click **Save**\. The changes are displayed in the **Permissions** tab\.

**To change the permissions granted to a user**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **Dashboard**\.

1. Expand the region for the environment, and then select the environment\.

1. From the **Permissions** tab, right\-click the user and select **Properties**\.

1. Select a different role and click **Save**\. The updates are displayed in the **Permissions** tab\.

**To revoke the permissions granted to a user**

1. Sign in to vCenter as an administrator, click **Home**, and then click **AWS Management Portal**\.

1. Click **Dashboard**\.

1. Expand the region for the environment, and then select the environment\.

1. From the **Permissions** tab, right\-click the user and select **Delete**\.

1. When prompted for confirmation, click **OK**\. The updates are displayed in the **Permissions** tab\.
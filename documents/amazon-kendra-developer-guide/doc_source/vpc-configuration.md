--------

--------

# Configuring Amazon Kendra to use a VPC<a name="vpc-configuration"></a>

Amazon Kendra connects to your Amazon virtual private cloud \(VPC\) to index information stored in databases running in your private cloud\. When you create the database data source, you provide security group and subnet identifiers for the subnet that contains your database\. Amazon Kendra uses this information to create an elastic network interface that it uses to securely communicate with your database\.

If your database isn't running on an Amazon VPC, you can connect your database to your Amazon VPC using a virtual private network \(VPN\)\. You get a default VPC when you create your Amazon account\. For information about setting up a VPN, see the [ AWS Virtual Private Network Documentation](https://docs.aws.amazon.com/vpn/)\. 

To use a VPC, you must tell Amazon Kendra the identifier of the subnet that the database belongs to and the identifiers of any security groups that Amazon Kendra must use to access the subnet\. For example, if you are using the default port for a MySQL database, the security groups must enable Amazon Kendra to access port 3306 on the host that runs the database\.

The identifiers for subnets and security groups are configured in the Amazon VPC control panel\. To see the identifiers, open the Amazon VPC console as follows:

**To view subnet identifiers**

1. Sign in to the AWS Management Console and open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. From the navigation pane, choose **Subnets**\.

1. From the subnet list, choose the subnet that contains your database server\.

1. From the description tab, make a note of the identifier in the **Subnet ID** field\.

**To view security group identifiers**

1. Sign in to the AWS Management Console and open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. From the navigation pane, choose **Security Groups**\.

1. From the security group list, choose the group that you want the identifier for\.

1. From the description tab, make a note of the identifier in the **Group ID** field\.

If Amazon Kendra must route the connection between two or more subnets, you can provide more than one subnet\. For example, if the subnet that contains your database server is out of IP addresses, Amazon Kendra can connect to a subnet with free IP addresses and route the connection to the first subnet\. If you list multiple subnets, the subnets must be able to communicate with each other\. Each subnet should be associated with a route table that provides outbound internet access using a network address translator \(NAT\) device\. 

You can also provide multiple security groups\. The combined effect of the security groups should allow Amazon Kendra to access the database server that you have specified in the connection configuration for the data source\.

## Connecting to a database in a VPC<a name="vpc-example"></a>

The following example shows how to connect a database data source to a MySQL database running in a VPC\. The example assumes that you are starting with your default VPC and that you need to create a MySQL database\. If you already have a VPC, make sure that it is configured as shown\. If you have a MySQL database, you can use that instead of creating a new one\.

**Topics**
+ [Step 1: Configure a VPC](#vpc-create-vpc)
+ [Step 2: Configure security](#vpc-create-database)
+ [Step 3: Create a database](#vpc-create-database)
+ [Step 4: Create a MySQL data source](#vpc-connect)

### Step 1: Configure a VPC<a name="vpc-create-vpc"></a>

Configure your VPC so that you have a private subnet and a security group that enables Amazon Kendra to access a MySQL database running in the subnet\.

**To configure a VPC**

1. Sign in to the AWS Management Console and open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. From the navigation pane, choose **Route tables**, then choose **Create route table**\.

1. For the **Name tag** field, enter **Private subnet route table**\. In the **VPC field**, choose your VPC, and then choose **Create**\. Choose **Close** to return to the list of route tables\.

1. From the navigation pane, choose **NAT Gateways** then choose **Create NAT Gateway**\.

1. In the **Subnet** field, choose the subnet that should be the public subnet and note the subnet ID\.

1. If you don't have an Elastic IP address, choose **Create New EIP**, choose **Create a NAT Gateway**, and then choose **Close**\.

1. From the navigation pane, choose **Route Tables**\.

1. From the route table list, choose the **Private subnet route table** that you created in step 3\. From **Actions**, choose **Edit Routes**\. 

1. Choose **Add route**\. Add the destination 0\.0\.0\.0/0 to allow all outgoing traffic to the internet\. For **Target**, choose **NAT Gateway** and then choose the gateway that you created in step 4\. Choose **Save routes**, and then choose **Close**\.

1. From **Actions**, choose **Edit subnet associations\.**

1. Choose the subnets that you want to be private\. Do not choose the subnet with the NAT gateway that you noted above\.

### Step 2: Configure security<a name="vpc-create-database"></a>

Next, configure security groups for your database\.

**To create security groups**

1. Sign in to the AWS Management Console and open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. From the description of your VPC, note the IPv4 CIDR\.

1. From the navigation pane, choose **Security Groups** and then choose **Create security group**\.

1. In **Security group name** enter **MySQLSecurityGroup**\. Provide a description, then choose your VPC from the ist\. Choose **Create** and then choose **Close**\.

1. Choose the **Inbound** tab\.

1. Choose **Edit rules**, and then choose **Add Rule**

1. For a MySQL database, enter **3306** for the **Port Range**\. For the **Source**, type the CIDR of your VPC\. Choose **Save rules** and then choose **Close**\.

The security group allows anyone within the VPC to connect to the database, and it allows outbound connections to the internet\.

### Step 3: Create a database<a name="vpc-create-database"></a>

Now create a database to hold your documents\. If you already have a database, you can use that instead\.

**To create a MySQL database**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. From the navigation pane, choose **Subnet groups** and then choose **Create DB Subnet Group**\.

1. Name the group and choose your VPC\.

1. Add your VPC's private subnets\. Your private subnets are the ones that are not connected to your NAT\. Choose **Create**\.

1. From the navigation pane, choose **Databases** and then choose **Create database\.**

1. Use the following parameters to create the database\. Leave all of the other parameters at their defaults\.
   + **Engine options** – MySQL
   + **Templates** – Free tier
   + **Credential Settings** – Enter and confirm a password
   + Under **Connectivity**, choose **Additional connectivity configuration**\. Make the following choices\.
     + **Subnet group** – Choose the subnet group that you created in step 4\.
     + **VPC security group** – Choose the group that you created in the VPC \(**MySQLSecurityGroup**\)\.
   + Under **Additional configuration**, set the **Initial database name** to **content**\.

1. Choose **Create database**\.

1. From the list of databases, choose your new database\. Make a note of the database endpoint\.

1. After you create your database, you must create a table to hold your documents\. Creating a table is outside the scope of these instructions\. When you create your table, note the following:
   + Database name – **content**
   + Table name – **documents**
   + Columns – **ID**, **Title**, **Body**, and **LastUpdate**\. You can include additional columns if you want\.

### Step 4: Create a MySQL data source<a name="vpc-connect"></a>

Now that you have configured your VPC and created your database, you can create a data source for the database\.

**To create a MySQL data source**

1. Sign in to the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/](https://console.aws.amazon.com/kendra/)\.

1. From the navigation pane, choose **Indexes** and then choose your index\.

1. Choose **Add data sources** and then choose **Amazon RDS**\.

1. Type a name and description for the data source and then choose **Next**\.

1. Choose **MySQL**\.

1. Under **Connection access**, enter the following information:
   + **Endpoint** – The endpoint of the database that you created earlier\.
   + **Port** – The port number for the database\. For MySQL, the default is 3306\.
   + **Type of authentication** – Choose **New**\.
   + **New secret container name** – A name for the Secrets Manager container for the database credentials\.
   + **Username** – The name of a user with administrative access to the database\.
   + **Password** – The password for the user, and then choose **Save authentication**\.
   + **Database name** – **content**\.
   + **Table name** – **documents**\.
   + **IAM role** – Choose **Create a new role**, and then type a name for the role\.

1. In **Column configuration** enter the following:
   + **Document ID column name** – **ID**
   + **Document title column name** – **Title**
   + **Document data column name** – **Body**

1. In **Column change detection** enter the following:
   + **Change detecting columns** – **LastUpdate**

1. In **Configure VPC & security group** provide the following:
   + In **Virtual Private Cloud \(VPC\)**, choose your VPC\.
   + In **Subnets**, choose the private subnets that you created in your VPC\.
   + In **VPC security groups**, choose the security group that you created in your VPC for MySQL databases \(**MySQLSecurityGroup**\)\.

1. In **Set sync run schedule**, choose **Run on demand** and then choose **Next**\.

1. In **Data source field mapping**, choose **Next**\.

1. Review the configuration of your data source to make sure that it is correct\. When you're satisfied that everything is correct, choose **Create**\.
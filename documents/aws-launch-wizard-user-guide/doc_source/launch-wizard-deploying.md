# Accessing and deploying an application with AWS Launch Wizard for SQL Server<a name="launch-wizard-deploying"></a>

## Accessing AWS Launch Wizard<a name="accessing-launch-wizard"></a>

You can launch AWS Launch Wizard from the following locations\.
+ **AWS Console\.** From the [AWS Management Console](https://console.aws.amazon.com) under **Management and Governance**\.
+ **AMI launch page in EC2 console\.** From the Launch Wizard banner that appears when you select **AMIs**, under **Images**, in the EC2 console\. The banner appears when you search for SQL AMIs\. 
+ **AWS Launch Wizard landing page\.** From the AWS Launch Wizard page, located at [https://aws\.amazon\.com/launchwizard/](https://aws.amazon.com/launchwizard/)\.

## Deploying AWS Launch Wizard<a name="deploy-console-launch-wizard"></a>

The following steps guide you through a SQL Server Always On application deployment with AWS Launch Wizard after you have launched it from the console\.

1. When you select **Create deployment** from the AWS Launch Wizard landing page, you are directed to the **Choose application** page where you are prompted to select the type of application that you want to deploy\. Select **Microsoft SQL Server Always On**\.

1. After you select an application type, under **Permissions**, Launch Wizard displays the AWS Identity and Access Management \(IAM\) policy required for Launch Wizard to access other AWS services on your behalf\. For more information about setting up IAM for Launch Wizard, see [AWS Identity and Access Management \(IAM\)](launch-wizard-setting-up.md#launch-wizard-iam)\. Select **Next** \.

1. After selecting the type of application to deploy, you are prompted to enter specifications for the new deployment on the **Configure application settings** page\. The following tabs provide information about the specification fields\.

------
#### [ General ]
   + **Deployment name**\. Enter a unique application name for your deployment\.
   + **Simple Notification Service \(SNS\) topic ARN \(Optional\)**\. Specify an SNS topic where AWS Launch Wizard can send notifications and alerts\. For more information, see the [https://docs.aws.amazon.com/sns/latest/dg/welcome.html](https://docs.aws.amazon.com/sns/latest/dg/welcome.html)\.
   + **CloudWatch application monitoring \(Optional\)**\. Select the checkbox to set up monitors and automated insights for your deployment using CloudWatch Application Insights\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/cloudwatch-application-insights.html)\.

------
#### [ Connectivity ]

   Enter specifications for how you want to connect to your application instance and what kind of Virtual Private Cloud \(VPC\) you want to set up\. 

   **Key pair name**
   + Select an existing key pair from the dropdown list or create a new one\. If you select **Create new key pair name** to create a new key pair, you are directed to the Amazon EC2 console\. From there, under **Network and Security**, choose **Key Pairs**\. Choose **Create a new key pair**, enter a name for the key pair, and then choose **Download Key Pair**\.
**Important**  
This is the only chance for you to save the private key file, so be sure to download it and save it in a safe place\. You must provide the name of your key pair when you launch an instance, and provide the corresponding private key each time that you connect to the instance\. 

     Return to the Launch Wizard console and choose the refresh button next to the **Key Pairs** dropdown list\. The newly created key pair appears in the dropdown list\. For more information about key pairs, see [Amazon EC2 Key Pairs and Windows Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html)\.

   **Virtual Private Cloud \(VPC\)**\. Choose whether you want to use an existing VPC or create a new VPC\.
   + **Select Virtual Private Cloud \(VPC\)**\. Choose the VPC that you want to use from the dropdown list\. Your VPC must contain one public subnet and, at least, two private subnets\. Your VPC must be associated with a [DHCP Options Set](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_DHCP_Options.html) to enable DNS translations to work\. The private subnets must have outbound connectivity to the internet and other AWS services \(S3, CFN, SSM, Logs\)\. We recommend that you enable this connectivity with a NAT Gateway\. For more information about NAT Gateways, see [NAT Gateways](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html) in the Amazon VPC User Guide\.
     + **Public Subnet**\. Your VPC must contain one public subnet and, at least, two private subnets\. Choose a public subnet for your VPC from the dropdown list\. To continue, you must select the check box that indicates that the Public subnet has been set up and each of the selected private subnets have outbound connectivity enabled\. 

**To add a new public subnet**

       If a subnet's traffic is routed to an internet gateway, the subnet is known as a public subnet\. If, however, a subnet doesn't have a route to the internet gateway, the subnet is known as a private subnet\. To use an existing VPC that does not have a public subnet, you can add a new public subnet using the following steps\.
       + Follow the steps in [Creating a Subnet in the Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html#Add_IGW_Create_Subnet) using the existing VPC you intend to use AWS Launch Wizard\.
       + To add an internet gateway to your VPC, follow the steps in [Attaching an Internet Gateway](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html#Add_IGW_Attach_Gateway) in the Amazon VPC User Guide\.
       + To configure your subnets to route internet traffic through the internet gateway, follow the steps in [Creating a Custom Route Table](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html#Add_IGW_Routing) in the Amazon VPC User Guide\. Use IPv4 format \(0\.0\.0\.0/0\) for Destination\.
       + The public subnet should have the “auto\-assign public IPv4 address” setting enabled\. To enable this setting, follow the steps in [Modifying the Public IPv4 Addressing Attribute for Your Subnet](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-ip-addressing.html#subnet-public-ip) in the Amazon VPC User Guide\.
     + **Availability Zone \(AZ\) and private subnets**\. You must choose at least two Availability Zones, with one private subnet for each zone that you select\. From the dropdown lists, select the **Availability Zones \(AZ\)** within which you want to deploy your **primary** and **secondary** SQL nodes\. Depending on the number of secondary nodes that you plan to use to set up a SQL Server Always On deployment, you may have to specify private subnets for each of them\. Cross\-Region replication is not supported\. 

**To create a private subnet**

       If a subnet doesn't have a route to an internet gateway, the subnet is known as a private subnet\. To create a private subnet, you can use the following steps\. We recommend that you enable the outbound connectivity for each of your selected private subnets using a NAT Gateway\. To enable outbound connectivity from private subnets with public subnet, see the steps in [Creating a NAT Gateway](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html#nat-gateway-creating) to create a NAT Gateway in your chosen public subnet\. Then, follow the steps in [Updating Your Route Table ](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html#nat-gateway-create-route)for each of your chosen private subnets\.
       + Follow the steps in [Creating a Subnet](https://docs.aws.amazon.com/vpc/latest/userguide/working-with-vpcs.html#AddaSubnet) in the Amazon VPC User Guide using the existing VPC you will use in AWS Launch Wizard\. 
       + When you create a VPC, it includes a main route table by default\. On the **Route Tables** page in the Amazon VPC console, you can view the main route table for a VPC by looking for Yes in the Main column\. The main route table controls the routing for all subnets that are not explicitly associated with any other route table\. If the main route table for your VPC has an outbound route to an internet gateway, then any subnet created using the previous step, by default, becomes a public subnet\. To ensure the subnets are private, you may need to create separate route table\(s\) for your private subnets\. These route tables must not contain any routes to an internet gateway\. Alternatively, you can create a custom route table for your public subnet and remove the internet gateway entry from the main route table\.
     + **Remote Desktop Gateway CIDR**\. Select **Custom IP** from the dropdown list\. Enter the CIDR block\. If you do not specify any value for the Custom IP parameter, Launch Wizard does not set the inbound RDP access \(Port 3389\) from any IP\. You can choose to do this later by modifying the security group settings via the Amazon EC2 console\. See [Adding a Rule for Inbound RDP Traffic to a Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/authorizing-access-to-an-instance.html#add-rule-authorize-access) for instructions on adding a rule that allows inbound RDP traffic to your RDGW instance\. 
   + **New VPC**\. Launch Wizard creates your VPC\. You can optionally enter a VPC name tag\.
     + **Remote Desktop Gateway CIDR**\. Select **Custom IP** from the dropdown list\. Enter the CIDR block\. If you do not specify any value for the Custom IP parameter, Launch Wizard does not set the inbound RDP access \(Port 3389\) from any IP\. You can choose to do this later by modifying the security group settings via the Amazon EC2 Console\. See [Adding a Rule for Inbound RDP Traffic to a Windows Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/authorizing-access-to-an-instance.html#add-rule-authorize-access) for instructions on adding a rule that allows inbound RDP traffic to your RDGW instance\. 

------
#### [ Active Directory ]

   You can connect to an existing Active Directory or create a new one\. If you selected the **Create new Virtual Private Cloud \(VPC\)** option, you must select **Create a new Active Directory**\.

**Connecting to existing AWS Managed Active Directory**

   Follow the steps for granting permissions in the Managed Active Directory Default Organizational Unit \(OU\)\. 
   + **Domain user name and password**\. Enter the user name and password for your directory\. For required permissions for the domain user, see [Active Directory](launch-wizard-setting-up.md#launch-wizard-ad)\. Launch Wizard stores the password in the Systems Manager Parameter Store of your account as a secure string parameter\. It does not store the password on the service side\. To create a functional SQL Server Always On deployment, it reads from the Parameter Store\.
   + **DNS address**\. Enter the IP address of the DNS servers to which you are connecting\. These servers must be reachable from within the VPC that you selected\. 
   + **Optional DNS address**\. If you would like to use a backup DNS server, enter the IP address of the DNS server that you want to use as backup\. These servers must be reachable from within the VPC that you selected\. 
   + **Domain DNS name**\. Enter the Fully Qualified Domain Name \(FQDN\) of the [ forest root domain ](https://docs.microsoft.com/en-us/windows-server/identity/ad-ds/plan/selecting-the-forest-root-domain) used for the Active Directory\. When you choose to create a new Active Directory, Launch Wizard creates a domain admin user on your Active Directory\.

**Creating a new AWS Managed Active Directory through Launch Wizard**
   + **Domain user name and password**\. The domain user name is preset to “admin\.” Enter a password for your directory\. Launch Wizard stores the password in the Systems Manager Parameter Store of your account as a secure string parameter\. It does not store the password on the server side\. To create a functional SQL Server Always On deployment, it reads from the Parameter Store\.
   + **Domain DNS name**\. Enter a Fully Qualified Domain Name \(FQDN\) of the forest root domain used for the Active Directory\. When you choose to create a new Active Directory, Launch Wizard creates a domain admin user on your Active Directory\.

**Creating an on\-premises Active Directory through Launch Wizard**  
Launch Wizard allows you to connect to your on\-premises environment with [AWS Direct Connect](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html)\. 

------
#### [ SQL Server ]

   When you use an existing Active Directory, you have the option of using an existing SQL Server service account or creating a new account\. If you create a new Active Directory account, you must create a new SQL Server account\. 
   + **User name and password**\. If you are using an existing SQL Server service account, provide your user name and password\. This SQL Server service account should be part of the Managed Active Directory in which you are deploying\. If you are creating a new SQL Server service account through Launch Wizard, enter a user name for the SQL Server service account\. Create a complex Password that is at least 8 characters long, and then reenter the password to verify it\. See [Password Policy](https://docs.microsoft.com/en-us/sql/relational-databases/security/password-policy?view=sql-server-2017) for more information\.
   + **SQL Server install type**\. Select the version of SQL Server Enterprise that you want to deploy\. You can select an AMI from either the License\-included AMI or Custom AMI dropdown lists\.
   + **Additional SQL Server settings \(Optional\)**\. You can optionally specify additional nodes and their subnets\.
     + **Nodes**\. Enter a **Primary SQL node name** and a **Secondary SQL node name**\. 
     + **Additional secondary SQL node \(maximum of 5\)**\. Enter a secondary **Node name**, select the **Access type** from the dropdown list, and select the **Private subnet** for the additional secondary SQL node from the dropdown list\. You can add more secondary nodes by selecting **Add an additional secondary node**\. 
     + Additional naming\. Enter a **Database name**, **Availability group name**, a **Listener name**, or a **Cluster name**\. 

------

1. When you are satisfied with your configuration selections, select **Next**\. If you don't want to complete the configuration, select **Cancel**\. When you select **Cancel**, all of the selections on the specification page are lost and you are returned to the landing page\. To go to the previous screen, select **Previous**\.

1. After configuring your application, you are prompted to define the infrastructure requriements for the new deployment on the **Define infrastructure requirements** page\. The following tabs provide information about the specification fields\.

------
#### [ Storage and Compute ]

   You can choose to select your instance and volume types, or to use AWS recommended resources\. If you choose to use AWS recommended resources, you have the option of defining your high availability cluster needs\. If no selections are made, default values are assigned\.
   + **Number of instance cores**\. Choose the number of CPU cores for your infrastructure\. The default value assigned is 4\. 
   + **Network performance**\. Choose your preferred network performance in Gbps\.
   + **Expected RAM size \(Memory\)**\. Choose the amount of RAM that you want to attach to your EC2 instances\. The default value assigned is 4 GB\.
   + **Type of storage drive**\. Select the storage drive type for the SQL data, logs, and tempdb volumes\. The default value assigned is SSD\. 
   + **SQL Server throughput**\. Select the sustained SQL Server throughput that you need\. 
   + **Recommended resources**\. Launch Wizard displays the system\-recommended resources based on your infrastructure selections\. If you want to change the recommended resources, select different infrastructure requirements\. 
   + 

**Drive letters and volume size**
     + **Drive letter**\. Select the storage drive letter for **Root drive**, **Logs**, **Data**, and **Backup** volumes\.
**Important**  
For custom AMIs, Launch Wizard assumes the root volume drive is `C:`\.
     + **Volume size**\. Select the size of the SQL Server data volume in Gb for **Root drive**, **Logs**, **Data**, and **Backup** volumes\.
     + **Provisioned IOPS\. ** Select the IOPS value of the SQL Server data volume in IOPS for **Root drive**, **Logs**, **Data**, and **Backup** volumes\.

       For throughput limits and volume characteristics, see [Amazon EBS Volume Types](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-volume-types.html) in the Amazon EC2 User Guide\.

------
#### [ Tags\-Optional ]

   You can provide optional custom tags for the resources Launch Wizard creates on your behalf\. For example, you can set different tags for EC2 instances, EBS volumes, VPC, and subnets\. If you select **All**, you can assign a common set of tags to your resources\. Launch Wizard assigns tags with a fixed key LaunchWizardResourceGroupID and value that corresponds to the ID of the AWS Resource Group created for a deployment\. Launch Wizard does not support custom tagging for root volumes\. 

------
#### [ Estimated On\-Demand Cost to Deploy Additional Resources ]

   AWS Launch Wizard provides an estimate for application charges incurred to deploy the selected resources\. The estimate updates each time you change a resource type in the Wizard\. The provided estimates are only for general comparisons\. They are based upon On\-Demand costs and your actual costs may be lower\. 

------

1. When you are satisfied with your infrastructure selections, select **Next**\. If you don't want to complete the configuration, select **Cancel**\. When you select **Cancel**, all of the selections on the specification page are lost and you are returned to the landing page\. To go to the previous screen, select **Previous**\.

1. On the **Review and deploy** page, review your configuration details\. If you want to make changes, select **Previous**\. To stop, select **Cancel**\. When you select **Cancel**, all of the selections on the specification page are lost and you are returned to the landing page\. If you are ready to deploy, read and select the check box next to the Acknowledgment\. Then choose **Deploy**\.

1. Launch Wizard validates the inputs and notifies you if something must be addressed\. 

1. When validation is complete, Launch Wizard deploys your AWS resources and configures your SQL Server Always On application\. Launch Wizard provides you with status updates about the progress of the deployment on the Deployments page\. From the Deployments page, you can also view the list of current and previous deployments\.

1. When your deployment is ready, you see notification that your SQL Server Always On application was successfully deployed\. If you have set up SNS notification, you are also alerted through SNS\. You can manage and access all of the resources related to your SQL Server Always On application by selecting **Manage**\.

1. When the SQL Server Always On application is deployed, you can access your Amazon EC2 instances through the EC2 console\. You can also use [AWS Systems Manager](https://docs.aws.amazon.com/systems-manager/latest/userguide/what-is-systems-manager.html) to manage your SQL Server Always On application for future updates and patches through built\-in integration via resource groups\.
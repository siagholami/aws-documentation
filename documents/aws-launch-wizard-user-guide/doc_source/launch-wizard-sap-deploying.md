# Accessing and deploying an SAP application with AWS Launch Wizard<a name="launch-wizard-sap-deploying"></a>

## Accessing AWS Launch Wizard<a name="accessing-launch-wizard-sap"></a>

You can launch AWS Launch Wizard from the following locations\.
+ **AWS Console\.** From the [AWS Management Console](https://console.aws.amazon.com) under **Management and Governance**\.
+ **AWS Launch Wizard landing page\.** From the AWS Launch Wizard page, located at [https://aws\.amazon\.com/launchwizard/](https://aws.amazon.com/launchwizard/)\.

## Deploying an SAP application with AWS Launch Wizard<a name="deploy-console-launch-wizard-sap"></a>

The following steps guide you through deploying an SAP application with AWS Launch Wizard after you have launched it from the console\.

**Topics**
+ [Create a deployment](#launch-wizard-sap-deploy)
+ [Define infrastructure](#launch-wizard-sap-infrastructure)
+ [Application and deployment settings](#launch-wizard-sap-application-settings)

### Create a deployment<a name="launch-wizard-sap-deploy"></a>

1. From the AWS Launch Wizard landing page, choose **Create deployment**\.

1. Choose **SAP**\.

1. Under **Permissions**, Launch Wizard displays the AWS Identity and Access Management \(IAM\) roles required for Launch Wizard to access other AWS services on your behalf\. For more information about these roles and setting up IAM for Launch Wizard, see [Identity and Access Management for AWS Launch Wizard](launch-wizard-security.md#identity-access-management)\. Choose **Next**\.

### Define infrastructure<a name="launch-wizard-sap-infrastructure"></a>

On the **Define infrastructure** page, define your deployment name and infrastructure settings\.

1. Under the **General** subheading, define the following:
   + **Deployment name**\. Enter a unique application name for your deployment\.
   + **Description \(Optional\)**\. Provide an optional description of your deployment\.
   + **Tags \(Optional\)**\. Enter a key and value to assign metadata to your deployment\. For help with tagging, see [Tagging Your Amazon EC2 Resources](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html)\.

1. Under the **Infrastructure – SAP landscape** subheading, configure the following infrastructure settings for your SAP landscape\.

------
#### [ Configuration options ]
   + Under **Configuration type**, choose whether to **Create new configuration** or **Apply saved configuration**\. 
   +  Enter the following information: 
     + **Configuration name**\. Enter a name or short description to identify your configuration\. You can save this configuration for future use\.
     + **Deployment environment**\. \(**Create new configuration**, only\) Choose whether to deploy into a **Production** or **Non\-Production** environment\.

------
#### [ Configuration details ]

   If you choose to create a new configuration, enter the following information\. 
   + **Key pair name**\. Choose an existing key pair from the dropdown list or select the link to create one\. If you select **Create new key pair name**, you are directed to the Amazon EC2 console\. From the Amazon EC2 console, under **Network and Security**, choose **Key Pairs**\. Choose **Create a new key pair**, enter a name for the key pair, and then choose **Download Key Pair**\.
**Important**  
This is the only time that you can save the private key file, so download and save it in a safe place\. You must specify the name of your key pair when you launch an instance, and provide the corresponding private key each time that you connect to the instance\.

     Return to the Launch Wizard console, and choose the refresh button next to the **Key Pair name** dropdown list\. The new key pair appears in the dropdown list\. For more information about key pairs, see [Amazon EC2 Key Pairs](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html)\.
   + **Virtual Private Cloud**\. Choose a VPC from the dropdown list or select the **Create VPC** link\. If you select **Create VPC**, you are redirected to the VPC console to create a VPC\.
   + **Availability Zone \(AZ\) and private subnets**\. You can deploy into one or two Availability Zones \(AZs\) with up to two private subnets per Availability Zone\. Different requirements are needed for different systems in the landscape\. You must select two Availability Zones with a required primary and optional secondary subnet for each Availability Zone\. These selections are used for each deployment according to the deployment model that you selected\. 

     From the dropdown lists, choose the **Availability Zones ** within which you want to deploy your SAP systems and choose the private subnets\. The private subnets must have outbound connectivity to the internet and to other AWS services, such as Amazon S3, AWS CloudFormation, and CloudWatch Logs\. They must also be able to access the Linux repositories required for instance configuration\. 

     For high availability deployments, the following subnets must share a common route table: 
     +  subnet 1 in Availability Zone 1 and subnet 1 in Availability Zone 2
     + subnet 2 in Availability Zone 1 and subnet 2 in Availability Zone 2

**To create a private subnet**
     + If a subnet doesn't have a route to an internet gateway, the subnet is known as a private subnet\. Use the following procedure to create a private subnet\. We recommend that you enable the outbound connectivity for each of your selected private subnets using a NAT gateway\. To enable outbound connectivity from private subnets with public subnets, [create a NAT Gateway](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html#nat-gateway-creating) in your chosen public subnet\. Then, follow the steps in [Updating Your Route Table](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-gateway.html#nat-gateway-create-route) for each of your private subnets\.
       + Follow the steps in [Creating a Subnet](https://docs.aws.amazon.com/vpc/latest/userguide/working-with-vpcs.html#AddaSubnet) in the Amazon VPC User Guide using the existing VPC that you will use in Launch Wizard\.
       + When you create a VPC, it includes a main route table by default\. On the **Route Tables** page in the Amazon VPC console, you can view the main route table for a VPC by looking for **Yes** in the **Main** column\. The main route table controls the routing for all subnets that are not explicitly associated with any other route table\. If the main route table for your VPC has an outbound route to an internet gateway, then any subnet created using the previous step, by default, becomes a public subnet\. To ensure the subnets are private, you may need to create separate route tables for your private subnets\. These route tables must not contain any routes to an internet gateway\. Alternatively, you can create a custom route table for your public subnet and remove the internet gateway entry from the main route table\.
   + **Verify Connectivity**\. Select the check box to verify that your private subnets have outbound internet connectivity\.
   + **Security groups**\. You can choose already existing security groups or Launch Wizard can create security groups that will be assigned to the EC2 instances that Launch Wizard deploys\. If you choose already existing security groups, you must ensure that all of the necessary ports required to access the SAP and SAP HANA databases are open\. If you choose to allow Launch Wizard to create the security groups, the security groups are created to enable the components of the cluster to communicate\. Systems that are deployed with the same configuration settings can also communicate\. 

     If you choose an existing security group, Launch Wizard displays the security groups that will be assigned to the EC2 instances that Launch Wizard deploys\. This enables the components to communicate and systems that are deployed with the same configuration settings to communicate\.
   + **Connectivity to external systems or users**\. If you allowed Launch Wizard to create the security groups, then choose the **Connection type** and **Value** of the IP address or security groups required to access the SAP systems\. These values can be a network segment from which the end users access the SAP systems, or downstream/upstream systems assigned a different security group in AWS or on premises\.
   + **Proxy setting**\. During the launch process, the deployed Amazon EC2 instances require outbound internet access in order to:
     + Access the operating system \(SUSE/RHEL\) repositories\.
     + Access AWS services, such as Amazon S3, CloudWatch and Systems Manager\.

     An [internet gateway](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html) is typically configured for outbound internet access\. If you want to route internet traffic through a proxy server, enter the proxy server details\. When proxy server information is provided, Launch Wizard will make the necessary environment changes to the EC2 instances during launch so that outbound internet traffic is routed through the proxy server\. 
     + **PROXY**\. Enter the proxy server name and port, for example `http://10.0.0.140:3128` or `https://10.0.0.140.3128`\.
     + **NO\_PROXY**\. When a proxy server is used for outbound communication, the `NO_PROXY` environment variable is used to route traffic without using the proxy for the following types of traffic:
       + local communication
       + traffic to other instances within the VPC
       + traffic to other AWS services for which VPC endpoints are created

       Enter a list of comma\-separated values to denote hostnames, domain names, or a combination of both\.

     We recommend that you add all AWS service endpoints \(if defined\) to the `NO_PROXY` environment variable so that a private connection between the VPC and the service endpoint can be established in the AWS VPN\. For more information on AWS service endpoints, see [AWS service endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html)\. 

     `NO_PROXY` is an optional parameter\. If no value is entered, the following default URLs are added to the environment\. Values entered for `NO_PROXY` at a later time are added to this list\.

     ```
     NO_PROXY="localhost,127.0.0.1,169.254.169.254,.internal,{VPC_CIDR_RANGE}"
     ```

**Default `NO_PROXY` URL details**
     + **localhost**—loopback hostname
     + **127\.0\.0\.1**—loopback adapter IP
     + **169\.254\.169\.254**—EC2 metadata link\-local address
     + **\.internal**—default DNS for the VPC
     + **\{VPC\_CIDR\_RANGE\}**—CIDR block of the VPC, for example, 10\.0\.0/24
   + **Time zone**\. Choose the time zone settings to configure the timezone on the instances from the dropdown list\.
   + **EBS encryption**\. From the dropdown list, choose whether or not to enable EBS encryption for all of the EBS volumes that are created for the SAP systems\. For more information, see [Amazon EBS Encryption](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSEncryption.html)\.
   + **Domain name \(DNS\) settings \(Optional\)**\. Select **Domain Name** or **Route 53** from the **DNS type** dropdown list\. 
     + If you select **Domain Name**, you have the option to enter a domain name to maintain a Fully Qualified Domain Name \(FQDN\) in the `/etc/hosts` file for each instance that is launched and configured by Launch Wizard\.
     + If you select **Route 53**, select a Route 53 hosted zone from the dropdown list\. Launch Wizard will create a DNS entry for each EC2 instance launched\.
**Note**  
Before you use a Route 53 hosted zone, verify that the hosted zone is [integrated with the VPC](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/hosted-zones-private.html), and that the [VPC DHCP options](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_DHCP_Options.html) are correctly set up\.
   + **SAP landscape settings**\. Enter the system settings for your SAP landscape\.
     + **SAP System Admin User ID**\. Enter the user ID for the SAP system administrator\.
     + **SAP System Admin Group ID**\. Enter the group ID for SAPSYS\. We recommend that you replicate this number across all of your SAP systems because SAPSYS GID must be the same between systems that are part of the transport domain\.
     + **SAPINST Group ID**\. Enter the group ID for the SAPINST\.
   + **Simple Notification Service \(SNS\) topic ARN \(Optional\)**\. Specify an SNS topic where Launch Wizard can send notifications and alerts\. For more information, see the [Amazon Simple Notification Service Developer Guide](https://docs.aws.amazon.com/sns/latest/dg/welcome.html)\. You can also choose **Create SNS topic** and then create one in the Amazon SNS console\. After you create an SNS topic, you can enter it in the Launch Wizard SNS field\.
   + After you specify the infrastructure settings, choose **Next**\. You are then prompted to save your infrastructure configuration\. If you choose **Save as new configuration**, enter the configuration name\. The configuration is added to the saved list and can be modified when selected\.

------

1. Choose **Next**\. You are then prompted to save your infrastructure configuration to apply to future deployments\. Choose **Save as a new configuration**, or **Do not save changes\. Continue without saving**\. If you save as a new configuration, enter the **Configuration name** and choose **Ok**\.

### Application and deployment settings<a name="launch-wizard-sap-application-settings"></a>

The following steps show the deployment paths for **Netweaver stack on SAP HANA database** and **SAP HANA database**\. Please follow the deployment steps for your deployment path\.

**Topics**
+ [Netweaver stack on SAP HANA database](#netweaver-on-hana)
+ [SAP HANA database](#launch-wizard-hana)

#### Netweaver stack on SAP HANA database<a name="netweaver-on-hana"></a>

------
#### [ Application settings  ]

On the **Configure application settings** page, enter your Netweaver stack on SAP HANA database application settings\.

1. **Application type**\. Select **Netweaver stack on SAP HANA database**\. This configuration includes:
   + Netweaver stack for a single instance , distributed instance, or multi\-AZ for high availability \(HA\) deployment\.
   + EC2 instances for the Netweaver application tier
   + EC2 instances for SAP HANA database and optional SAP HANA database install

1. **General settings – SAP system**\. Enter the settings for your SAP system\.
   + **SAP System ID \(SAPSID\)**\. An identifier for your system\. The ID must be a three character, alphanumeric string\.
   + **EBS Volume Type for Netweaver application stack instances**\. Choose which volume type to use for the NW application file system `/usr/sap/SAPSID` from the dropdown list\.
   + **Transport Domain Controller**\. Specify whether the SAP system will be the domain controller for the SAP landscape\. If not, select the transport file system of the domain controller to be mounted\.

1. **General Settings – SAP HANA**\. Enter the settings for your SAP HANA installation\.
   + **SAP HANA System ID\.** Enter the identifier for your SAP HANA database\. The ID must be a three character, alphanumeric string\.
   + **SAP HANA Instance number\.** Enter the instance number to be used for the SAP HANA installation and setup\. The ID must be a two\-digit number\.
   + **EBS Volume Type for SAP HANA**\. Select the EBS volume types to use for both **SAP HANA Data** and **SAP HANA Logs** from the dropdown lists\.
   + **SAP HANA software install**\. Choose whether to download the SAP HANA software\.
     + If you choose **Yes**, enter the Amazon S3 location to store the SAP software files\. The S3 bucket must have the prefix “launchwizard” in the bucket name to ensure that the Launch Wizard IAM role policy for EC2 has read\-only access to the bucket\. For steps to set up the folder structure for your S3 bucket, see [Making SAP HANA software available for AWS Launch Wizard to deploy HANA databaseMaking SAP HANA software available for Launch Wizard ](launch-wizard-sap-structure.md)\.
     + If you choose **No**, only AWS infrastructure is provisioned\.
   + **S3 location for SAP HANA media \- *optional*\.** Enter the path for the S3 bucket in which you want to store SAP HANA media\. 
   + **SAP HANA password**\. Enter a password for your SAP HANA installation\.

1. After you enter your application settings, choose **Next**\. 

\(Use the tab for **Single instance deployment**, **Distributed instance deployment**, or **High availability deployment**, depending on your configuration\)

------
#### [ Single instance deployment ]

On the **Configure deployment model** page, enter the deployment details for a single instance deployment\.

1. **Deployment details**\. Launch Wizard supports single instance deployments, distributed instance deployments, and high availability deployments\. Select **Single instance deployment**\. 

1. **ASCS, PAS, and DB on one EC2 instance**\. Enter the deployment settings for your instance\.
   + **Instance details**\.
     + Under **Instance sizing**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
     + **Operating System**\. Select a supported operating system version for the ASCS instance\. For a complete list of operating system versions supported for ASCS, see [Supported operating system versions for SAP deployments](launch-wizard-sap-ascs-support-os.md)\.
     + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
     + **Host name**\. Enter the host name for the EC2 instance\.
     + **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the checkbox to enable EC2 automatic recovery for the instance\. For more information, see [Recover Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-recover.html) in the Amazon EC2 User Guide\.
   + 
     + Under **Instance sizing**, choose whether to **Use AWS recommended resources** or **Choose instance**\.
       + **Use AWS recommended resources**\.
         + **Infrastructure requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
           + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
           + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
       + **Choose your instance**\.
         + **Instance type**\. Choose the instance type from the dropdown list\.
       + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections and the EBS volumes that will be created and attached to the launched instances\. This is an estimate of AWS costs to deploy additional resources and does not include any image costs, EC2 reservations, applicable taxes, or discounts\.

1. After you have entered your deployment settings, choose **Next**\.

\(See the **Review** tab\)

------
#### [ Distributed instance deployment ]

On the **Configure SAP HANA deployment model** page, enter the deployment details for a distributed instance deployment\.

1. **Deployment details**\. Launch Wizard supports single instance deployments, distributed instance deployments, and high availability deployments\. Select **Distributed instance deployment**\. 

1. **ABAP System Central Services \(ASCS\) Server and Primary Application Server \(PAS**\. Enter the deployment settings for your instance\.
   + **Instance details**\. 
     + Under **Instance sizing**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the ASCS and PAS instances\. For a complete list of operating system versions supported for ASCS, see [Supported operating system versions for SAP deployments](launch-wizard-sap-ascs-support-os.md)\.
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
     + **Host name**\. Enter the host name for the EC2 instances\.
     + **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the checkbox to enable EC2 automatic recovery for the instance\. For more information, see [Recover Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-recover.html) in the Amazon EC2 User Guide\.
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Infrastructure requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

1. **Settings for Database \(DB\) Server**\. Enter the deployment settings for your instance\.
   + **Instance details**\. 
     + Under **Instance sizing**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the ASCS and PAS instances\. For a complete list of operating system versions supported for ASCS, see [Supported operating system versions for SAP deployments](launch-wizard-sap-ascs-support-os.md)\.
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
     + **Scale up and Scale out**\. Select an upgrade strategy for your system hardware to upgrade for increased data and workload\. 
       + **Scale\-up deployment**\.If you choose this deployment upgrade model, enter the host name for the database
       + **Scale\-out deployment**\. If you choose this deployment upgrade model, enter the **SAP HANA master host name**, the **Number of worker nodes**, and the **Worker node hostname prefix** under **Instance sizing**\. 
   + Under **Instance sizing**, choose whether to **Use AWS recommended resources** or **Choose instance**\.
     + **Use AWS recommended resources**\.
       + **Define requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the checkbox to enable EC2 automatic recovery for the instance\. For more information, see [Recover Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-recover.html) in the Amazon EC2 User Guide\.
     + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

1. **Settings for Additional App Servers \(AAS\) \- *optional***\. Enter the deployment settings for your AAS instances\.
   + **Instance details**\. 
     + **Number of Additional App Servers \(AAS\)**\. Enter the number of additional application servers\. 
     + **Naming convention for host name**\. Enter the naming convention for the host name\.
     +  **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the checkbox to enable EC2 automatic recovery for the instance\. For more information, see [Recover Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-recover.html) in the Amazon EC2 User Guide\.
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Define requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

   After you have entered your deployment settings, choose **Next**\.

\(See the **Review** tab\)

------
#### [ High availability deployment ]

On the **Configure SAP HANA deployment model** page, enter the deployment details for the high availability deployment\.

1. **Deployment details**\. Launch Wizard supports single instance deployments, distributed instance deployments, and high availability deployments\. Select **High availability deployment**\. 

1. **Settings for ABAP System Central Services \(ASCS\) server**\. Enter the deployment settings for your instance\.
   + **Instance details**\. 
     + Under **Image type**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the ASCS instances\. For a complete list of operating system versions supported for ASCS, see [Supported operating system versions for SAP deployments](launch-wizard-sap-ascs-support-os.md)\.
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
     + **Host name**\. Enter the host name for the EC2 instance\.
     + **ASCS instance number**\. Enter the instance number for the SAP installation and setup, and to open up ports for security groups\. 
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
       + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance type\.
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
   + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

1. **Settings for Enqueue Replication Server \(ERS\)**\. Enter the deployment settings for your ERS\.
   + **Instance details**\. 
     + Under **Instance sizing**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the ERS instance\. 
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
     + **Host name**\. Enter the host name for the EC2 instance\.
     + **ERS instance number**\. Enter the instance number for the SAP installation and setup, and to open up ports for security groups\. 
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
       + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance type\.
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
   + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

1. **Settings for database \(DB\) Server**\. Enter the deployment settings for your database\.
   + Under **Instance sizing**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
     + **Instance details\.**
       + **Operating System**\. Select a supported operating system version for the ERS instance\. 
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
   + **Primary and secondary instance details**\. Enter details for both the primary and secondary instances\.
     + **SAP HANA host name**\. Enter the host name for the SAP HANA primary and secondary instances\.
     + **Server site name**\. Enter the primary and secondary site name for the SAP HANA system replication\. 
   + **Overlay IP address**\. Enter the overlay IP address to assign to the active node\. The IP address should be outside of the VPC CIDR and must not be used by any other HA cluster\. It is configured to always point to the active SAP HANA node\. 
   + **Pacemaker tag name**\. Enter the tag to assign to each EC2 instance\. This tag is used by the pacemaker component of SLES HAE and RHEL for SAP high availability solutions and must not be used by any other EC2 instance in your account\. 
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
       + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance type\.
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
   + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

1. **Primary Application Server \(PAS\)**\. Enter the deployment settings for your instance\.
   + **Instance details**\. 
     + Under **Image type**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the ERS instance\. 
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\. 
     + **Host name**\. Enter the host name for the EC2 instance\.
     + **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the check box to enable EC2 automatic recovery for the instance\. For more information, see [Recover Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-recover.html) in the Amazon EC2 User Guide\.
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Define requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

1. **Settings for Additional App Servers \(AAS\) \- *optional***\. Enter the deployment settings for your AAS instances\. 
   + **Instance details**
     + **Number of Additional App Servers \(AAS\)**\. Enter the number of additional application servers\. 
     + **Naming convention for host name**\. Enter the naming convention for the host name\.
     +  **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the check box to enable EC2 automatic recovery for the instance\. For more information, see [Recover Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-recover.html) in the Amazon EC2 User Guide\.
   + Under **Instance sizing**, choose whether to Use **AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Infrastructure requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Recommended Resources**\. AWS Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include any applicable taxes or discounts\.

   After you have entered all of your deployment settings, choose **Next**\.

\(See the **Review** tab\)

------
#### [ Review  ]
+ On the **Review ** page, review your infrastructure, application, and deployment model settings\. If you are satisfied with your selections, choose **Deploy**\. If you want to change settings, choose **Previous**\.
+ When you choose **Deploy**, you are redirected to the **Deployments** page, where you can view the status of your deployment, and also the deployment details\.

------

#### SAP HANA database<a name="launch-wizard-hana"></a>

------
#### [ Application settings  ]

On the **Configure application settings** page, enter your SAP HANA database application settings\.

1. **Application type**\. Select **SAP HANA database**\. This configuration includes:
   + EC2 instances for an SAP HANA database 
   + Optional installation of SAP HANA database software

1. **General Settings – SAP HANA**\. Enter the settings for your SAP HANA database installation\.
   + **SAP HANA System ID \(SID\)**\. Enter the SAP HANA system ID for your system\. The HANASID must be different from SAPSID if you are configuring a single instance deployment\.
   + **SAP HANA Instance number**\. Enter the instance number to use for your SAP HANA system\. This must be a two\-digit number from 00 through 99\.
   + **EBS Volume Type for SAP HANA**\. Select the EBS volume types that you want to use for both **SAP HANA Data** and **SAP HANA Logs** from the dropdown lists\.
   + **SAP HANA software install**\. Select whether you want to download the SAP HANA software\.
     + If you select **Yes**, enter the Amazon S3 location where the SAP HANA software is located\. The S3 bucket must have the prefix “launchwizard” in the bucket name to ensure that the Launch Wizard IAM role policy for EC2 has read\-only access to the bucket\. For steps to set up the folder structure for your S3 bucket, see [Making SAP HANA software available for AWS Launch Wizard to deploy HANA databaseMaking SAP HANA software available for Launch Wizard ](launch-wizard-sap-structure.md)\. Enter a password to use for your SAP HANA installation\.
     + If you select **No**, only the AWS infrastructure is provisioned so you can manually deploy an SAP HANA database post deployment \.

1. After you enter your application settings, choose **Next**\.

\(Use the tab for **Single instance deployment**, **Multiple instance deployment**, or **High availability deployment**, depending on your configuration\)

------
#### [ Single instance deployment ]

On the **Configure deployment model** page, enter the deployment details for the SAP HANA database deployment\.

1. **Deployment model**\. Launch Wizard supports single instance deployments, multiple instance deployments, and high availability deployments\. Select **Single instance deployment**\. 

1. **Settings for SAP HANA database on one instance**
   + **Instance details\.**
     + Under **Image type**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the ERS instance\. 
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\.
     + **Host name**\. Enter the host name for the EC2 instance\.
     + **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the checkbox to enable EC2 automatic recovery for the instance\. For more information, see Recover Your Instance in the Amazon EC2 User Guide\.
   + Under **Instance sizing**, choose **Use AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Define requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Recommended Resources**\. Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include applicable taxes or discounts\.
   + After you enter your deployment settings, choose **Next**\.

\(See the **Review** tab\)

------
#### [ Multiple instance deployment ]

On the **Configure deployment model** page, enter the deployment details for the SAP HANA database deployment\.

1. **Deployment model**\. Launch Wizard supports single instance deployments, multiple instance deployments, and high availability deployments\. Select **Multiple instance deployment**\. 

1. 

**SAP HANA on multiple EC2 instances**
   + **Instance details\.**
     + Under **Instance sizing**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the SAP HANA servers\. 
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\.
   + Under **Instance sizing**, choose **Use AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Infrastructure requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Host Name for SAP system**\. Enter the host name for the EC2 instance\.
     + **Number of worker nodes**\. Enter the number of EC2 instances to be configured as worker nodes for this SAP HANA system\. 
     + **Worker node hostname prefix**\. Enter the hostname prefix for the worker nodes\.
     + **Auto Recovery**\. Auto recovery is an Amazon EC2 feature to increase instance availability\. Select the checkbox to enable EC2 automatic recovery for the instance\. For more information, see Recover Your Instance in the Amazon EC2 User Guide\.
     + **Recommended Resources**\. Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include applicable taxes or discounts\.
   + After you enter your deployment settings, choose **Next**\.

\(See **Review** tab\)

------
#### [ High availability deployment ]

On the **Configure deployment model** page, enter the deployment details for the SAP HANA database deployment\.

1. **Deployment model**\. Launch Wizard supports single instance deployments, multiple instance deployments, and high availability deployments\. Select **High availability deployment**\. 

1. 
   + **Instance details\.**
     + Under **Instance details**, choose whether to use **AWS/Marketplace/Community images** or **Bring your own images \(BYOI\)**\.
       + **Operating System**\. Select a supported operating system version for the SAP HANA servers\. 
       + **AMI ID**\. For BYOI, select the AMI that you want to use from the dropdown\.
     + **Primary and secondary instance details**\. Enter details for both the primary and secondary instances\.
       + **SAP HANA host name**\. Enter the host name for the SAP HANA primary and secondary instances\.
       + **Server site name**\. Enter the primary and secondary site name for the SAP HANA system replication\. 
     + **Overlay IP address**\. Enter the overlay IP address to assign to the active node\. The IP address should be outside of the VPC CIDR and must not be used by any other HA cluster\. It is configured to always point to the active SAP HANA node\. 
     + **Pacemaker tag name**\. Enter the tag to assign to each EC2 instance\. This tag is used by the pacemaker component of SLES HAE and RHEL for SAP high availability solutions and must not be used by any other EC2 instance in your account\. 
   + Under **Instance sizing**, choose **Use AWS recommended resources** or **Choose your instance**\.
     + **Use AWS recommended resources**\.
       + **Infrastructure requirements**\. Choose the requirements for your recommended resources from the dropdown list\.
         + **Based on CPU/Memory**\. If you select this option, enter the required number of vCPU **Cores** and **Memory**\. Amazon EC2supports up to 448 logical processors\. If the amount of memory required exceeds 4TB, [dedicated hosts](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/dedicated-hosts-overview.html) are required\.
         + **SAPS \(SAP Application Performance Standard\)**\. If you select this option, enter the **SAPS** rating for the SAP certified instance types\. 
     + **Choose your instance**\.
       + **Instance type**\. Choose the instance type from the dropdown list\.
     + **Recommended Resources**\. Launch Wizard displays the **Estimated monthly cost of operation** based on your instance sizing selections\. This is an estimate of AWS costs to deploy additional resources and does not include applicable taxes or discounts\.
   + After you enter your deployment settings, choose **Next**\.

\(See **Review** tab\)

------
#### [ Review ]
+ On the **Review** page, review your infrastructure, application, and deployment model settings\. If you are satisfied with your selections, choose **Deploy** \. If you want to change settings, choose **Previous**\.
+ When you choose **Deploy** , you are redirected to the **Deployments page**, where you can view the status of your deployment, and also the deployment details\.

------
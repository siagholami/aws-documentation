# Walkthrough 1: Prerequisites for Getting Started<a name="walkthrough01-prereqs"></a>

Before you can complete the getting started exercise, you must already have a Microsoft Windows–based Amazon EC2 instance joined to your AWS Directory Service directory\. You must also be signed into the instance over Windows Remote Desktop Protocol as the Admin user for your directory\. The following walkthrough shows you how to perform these necessary prerequisite actions\.

**Topics**
+ [Step 1: Set Up Active Directory](#prereq-step1)
+ [Step 2: Launch a Windows Instance in the Amazon EC2 Console](#prereqs-step2)
+ [Step 3: Connect to Your Instance](#prereqs-step3)
+ [Step 4: Join Your Instance to Your AWS Directory Service Directory](#prereqs-step4)

## Step 1: Set Up Active Directory<a name="prereq-step1"></a>

With Amazon FSx, you can operate fully managed file storage for Windows\-based workloads\. Likewise, AWS Directory Service provides fully managed directories to use in your workload deployment\. If you have an existing corporate AD domain running in AWS in a virtual private cloud \(VPC\) using EC2 instances, you can enable user\-based authentication and access control\. You do this by establishing a trust relationship between your AWS Managed Microsoft AD and your corporate domain\. For Windows authentication in Amazon FSx, you only need a one\-way directional forest trust, where the AWS managed forest trusts the corporate domain forest\.

Your corporate domain takes the role of the trusted domain, and the AWS Directory Service managed domain takes the role of the trusting domain\. Validated authentication requests travel between the domains in only one direction—allowing accounts in your corporate domain to authenticate against resources shared in the managed domain\. In this case, Amazon FSx interacts only with the managed domain\. The managed domain then passes on the authentication requests to your corporate domain\.

**Note**  
You can also use an external trust type with Amazon FSx for trusted domains\.

Your Active Directory security group must enable inbound access from the Amazon FSx file system’s security group\.

**To create an AWS Directory Services for Microsoft AD**
+ If you don't already have one, use the AWS Directory Service to create your AWS Managed Microsoft AD directory\. For more information, see [Create Your AWS Managed Microsoft AD directory](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_getting_started_create_directory.html) in the *AWS Directory Service Administration Guide*\.
**Important**  
Remember the password you assign to your Admin user; you need it later in this getting started exercise\. If you forget the password, you need to repeat steps in this exercise with the new AWS Directory Service directory and Admin user\.
+ If you have an existing AD, create a trust relationship between your AWS Managed Microsoft AD and your existing AD\. For more information, see [When to Create a Trust Relationship](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/ms_ad_setup_trust.html) in the *AWS Directory Service Administration Guide\.*

## Step 2: Launch a Windows Instance in the Amazon EC2 Console<a name="prereqs-step2"></a>

You can launch a Windows instance using the AWS Management Console as described in the following procedure\. This is intended to help you launch your first instance quickly, so it doesn't cover all possible options\. For more information about the advanced options, see [Launching an Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/launching-instance.html)\.

**To launch an instance**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. From the console dashboard, choose **Launch Instance**\.

1. The **Choose an Amazon Machine Image \(AMI\)** page displays a list of basic configurations, called *Amazon Machine Images \(AMIs\)*, that serve as templates for your instance\. Select the AMI for Windows Server 2016 Base or Windows Server 2012 R2 Base\. Notice that these AMIs are marked "Free tier eligible\."

1. On the **Choose an Instance Type** page, you can select the hardware configuration of your instance\. Select the `t2.micro` type, which is selected by default\. Notice that this instance type is eligible for the free tier\.

1. Choose **Review and Launch** to let the wizard complete the other configuration settings for you\.

1. On the **Review Instance Launch** page, under **Security Groups**, a security group appears that the wizard created and selected for you\. You can use this security group, or you can choose the security group that you created when getting set up using the following steps:

   1. Choose **Edit security groups**\.

   1. On the **Configure Security Group** page, ensure that **Select an existing security group** is selected\.

   1. Select your security group from the list of existing security groups, and then choose **Review and Launch**\.

1. On the **Review Instance Launch** page, choose **Launch**\.

1. When prompted for a key pair, select **Choose an existing key pair**, then select the key pair that you created when getting set up\.

   Alternatively, you can create a new key pair\. Select **Create a new key pair**, enter a name for the key pair, and then choose **Download Key Pair**\. This is the only chance for you to save the private key file, so be sure to download it\. Save the private key file in a safe place\. You'll need to provide the name of your key pair when you launch an instance and the corresponding private key each time you connect to the instance\.
**Warning**  
Don't select the **Proceed without a key pair** option\. If you launch your instance without a key pair, then you can't connect to it\.

   When you are ready, select the acknowledgement check box, and then choose **Launch Instances**\. 

1. A confirmation page lets you know that your instance is launching\. Choose **View Instances** to close the confirmation page and return to the console\.

1. On the **Instances** screen, you can view the status of the launch\. It takes a short time for an instance to launch\. When you launch an instance, its initial state is `pending`\. After the instance starts, its state changes to `running` and it receives a public DNS name\. \(If the **Public DNS \(IPv4\)** column is hidden, choose **Show/Hide Columns** \(the gear\-shaped icon\) in the top right corner of the page and then select **Public DNS \(IPv4\)**\.\)

1. It can take a few minutes for the instance to be ready so that you can connect to it\. Check that your instance has passed its status checks; you can view this information in the **Status Checks** column\.

**Important**  
Make a note of the ID of the security group that was created when you launched this instance\. You'll need it when you create your Amazon FSx file system\.

Now that your instance is launched, you can connect to your instance\.

## Step 3: Connect to Your Instance<a name="prereqs-step3"></a>

To connect to a Windows instance, you must retrieve the initial administrator password and then specify this password when you connect to your instance using Remote Desktop\.

The name of the administrator account depends on the language of the operating system\. For example, for English it's Administrator, for French it's Administrateur, and for Portuguese it's Administrador\. For more information, see [Localized Names for Administrator Account in Windows](http://social.technet.microsoft.com/wiki/contents/articles/13813.localized-names-for-administrator-account-in-windows.aspx) in the Microsoft TechNet Wiki\.

If you joined your instance to a domain, you can connect to your instance using domain credentials you defined in AWS Directory Service\. On the Remote Desktop login screen, don't use the local computer name and the generated password\. Instead, use the fully qualified user name for the administrator and the password for this account\. An example is **corp\.example\.com\\Admin**\. 

The license for the Windows Server operating system \(OS\) allows two simultaneous remote connections for administrative purposes\. The license for Windows Server is included in the price of your Windows instance\. If you need more than two simultaneous remote connections, you must purchase a Remote Desktop Services \(RDS\) license\. If you attempt a third connection, an error occurs\. For more information, see [Configure the Number of Simultaneous Remote Connections Allowed for a Connection](http://technet.microsoft.com/en-us/library/cc753380.aspx)\.

**To connect to your Windows instance using an RDP client**

1. In the Amazon EC2 console, select the instance, and then choose **Connect**\.

1. In the **Connect to Your Instance** dialog box, choose **Get Password** \(it takes a few minutes after the instance is launched before the password is available\)\.

1. Choose **Browse** and navigate to the private key file you created when you launched the instance\. Select the file and choose **Open** to copy the entire contents of the file into the **Contents** field\.

1. Choose **Decrypt Password**\. The console displays the default administrator password for the instance in the **Connect to Your Instance** dialog box, replacing the link to **Get Password** shown previously with the actual password\.

1. Record the default administrator password, or copy it to the clipboard\. You need this password to connect to the instance\.

1. Choose **Download Remote Desktop File**\. Your browser prompts you to either open or save the \.rdp file\. Either option is fine\. When you have finished, you can choose **Close** to dismiss the **Connect to Your Instance** dialog box\. 
   + If you opened the \.rdp file, you see the **Remote Desktop Connection** dialog box\.
   + If you saved the \.rdp file, navigate to your downloads directory, and open the \.rdp file to display the dialog box\.

1. You may get a warning that the publisher of the remote connection is unknown\. You can continue to connect to your instance\.

1. When prompted, log in to the instance, using the administrator account for the operating system and the password that you recorded or copied previously\. If your **Remote Desktop Connection** already has an administrator account set up, you might have to choose the **Use another account** option and type the user name and password manually\.
**Note**  
Sometimes copying and pasting content can corrupt data\. If you encounter a "Password Failed" error when you log in, try typing in the password manually\.

1. Due to the nature of self\-signed certificates, you may get a warning that the security certificate could not be authenticated\. Use the following steps to verify the identity of the remote computer, or simply choose **Yes** or **Continue** to continue if you trust the certificate\.

   1. If you are using **Remote Desktop Connection** from a Windows PC, choose **View certificate**\. If you are using **Microsoft Remote Desktop** on a Mac, choose **Show Certificate**\.

   1. Choose the **Details** tab, and scroll down to the **Thumbprint** entry on a Windows PC, or the **SHA1 Fingerprints** entry on a Mac\. This is the unique identifier for the remote computer's security certificate\.

   1. In the Amazon EC2 console, select the instance, choose **Actions**, and then choose **Get System Log**\.

   1. In the system log output, look for an entry labeled `RDPCERTIFICATE-THUMBPRINT`\. If this value matches the thumbprint or fingerprint of the certificate, you have verified the identity of the remote computer\.

   1. If you are using **Remote Desktop Connection** from a Windows PC, return to the **Certificate** dialog box and choose **OK**\. If you are using **Microsoft Remote Desktop** on a Mac, return to the **Verify Certificate** and choose **Continue**\.

   1. \[Windows\] Choose **Yes** in the **Remote Desktop Connection** window to connect to your instance\.

Now that you're connected to your instance, you can join the instance to your AWS Directory Service directory\.

## Step 4: Join Your Instance to Your AWS Directory Service Directory<a name="prereqs-step4"></a>

The following procedure shows you how to manually join an existing Amazon EC2 Windows instance to your AWS Directory Service directory\. 

**To join a Windows instance to your AWS Directory Service directory**

1. Connect to the instance using any Remote Desktop Protocol client\.

1. Open the TCP/IPv4 properties dialog box on the instance\.

   1. Open **Network Connections**\.
**Tip**  
You can open **Network Connections** directly by running the following from a command prompt on the instance\.  

      ```
      %SystemRoot%\system32\control.exe ncpa.cpl
      ```

   1. Open the context \(right\-click\) menu for any enabled network connection and then choose **Properties**\.

   1. In the connection properties dialog box, open \(double\-click\) **Internet Protocol Version 4**\.

1. \(Optional\) Select **Use the following DNS server addresses**, change the **Preferred DNS server** and **Alternate DNS server** addresses to the IP addresses of the AWS Directory Service–provided DNS servers, and choose **OK**\.

1. Open the **System Properties** dialog box for the instance, choose the **Computer Name** tab, and choose **Change**\.
**Tip**  
You can open the **System Properties** dialog box directly by running the following from a command prompt on the instance\.  

   ```
   %SystemRoot%\system32\control.exe sysdm.cpl
   ```

1. In the **Member of** box, choose **Domain**, enter the fully qualified name of your AWS Directory Service directory, and choose **OK**\.

1. When prompted for the name and password for the domain administrator, enter the user name and password of the Admin account\.
**Note**  
You can enter either the fully qualified name of your domain or the NetBios name, followed by a backslash \(\\\), and then the user name, in this case, **Admin**\. For example, **corp\.example\.com\\Admin** or **corp\\Admin**\.

1. After you receive the message welcoming you to the domain, restart the instance to have the changes take effect\.

1. Reconnect to your instance over RDP, and sign into the instance using the user name and password for your AWS Directory Service directory's Admin user\.

Now that your instance has been joined to the domain, you're ready to create your Amazon FSx file system\. You can then go on to finish the other tasks in the getting started exercise\. For more information, see [Getting Started with Amazon FSx](getting-started.md)\.
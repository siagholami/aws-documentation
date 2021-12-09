# Install the Server Migration Connector on VMware<a name="VMware"></a>

Use the following information to install the Server Migration Connector, so that you can use AWS SMS to migrate VMs from a VMware environment to Amazon EC2\.

This information applies only to VMs in an on\-premises VMware environment\. For information about installing the connector on other environments, see [Install the Server Migration Connector](SMS_setup.md)\.

**Requirements for VMware connector**
+ vCenter version 5\.1 or higher \(validated up to 6\.7\)
+ ESXi 5\.1 or higher \(validated up to 6\.7\)
+ Minimum 8 GiB RAM
+ Minimum available disk storage of 20 GiB \(thin\-provisioned\) or 250 GiB \(thick\-provisioned\)
+ Support for the following network services\. Note that you might need to reconfigure your firewall to permit stateful outbound connections from the connector to these services\.
  + DNS—Allow the connector to initiate connections to port 53 for name resolution\.
  + HTTPS on vCenter—Allow the connector to initiate secure web connections to port 443 of vCenter\. You can also configure a non\-default port at your discretion\. If your vCenter Server is configured to use a non\-default port, specify both the vCenter's hostname and port, separated by a colon \(for example, `HOSTNAME:PORT` or `IP:PORT`\) in the vCenter Service Account page in **Connector setup**\.
  + HTTPS on ESXi—Allow the connector to initiate secure web connections to port 443 of the ESXi hosts containing the VMs you intend to migrate\.
  + NTP—Optionally allow the connector outbound access to port 123 for time synchronization\. If the connector synchronizes its clock with the ESXi host, this is unnecessary\.
+ Allow outbound connections from the connector to the following URL ranges: 
  + \*\.amazonaws\.com
  + \*\.aws\.amazon\.com

**To set up the connector for a VMware environment**

1. Open the **AWS Server Migration Service** console and choose **Connectors**, **SMS Connector setup guide**\. 

1. On the **AWS Server Migration Connector setup** page, choose **Download OVA** to download the connector for VMware environments\. You can also download the connector using the URL provided\. The connector is a preconfigured FreeBSD VM in OVA format that is ready for deployment in your vCenter\.

1. Set up your vCenter service account\. Create a vCenter user with permissions necessary to create and delete snapshots on VMs that need be migrated to AWS and download their delta disks\.
**Note**  
As a best practice, we recommend that you limit vCenter permissions for the connector service account to only those vCenter data centers that contain the VMs that you intend to migrate\. We also recommend that you lock down your vCenter service account permissions by assigning this user the NoAccess role in vCenter on the hosts, folders, and datastores that do not have any VMs for migration\.

1. Create a role in vCenter with the following privileges:
   + **Datastore** > **Browse datastore and Low level file operations** \(Datastore\.Browse and Datastore\.FileManagement\)
   + **Host** > **Configuration** > **System Management** \(Host\.Config\.SystemManagement\) 
   + **vApp** > **Export** \(VApp\.Export\)
   + **Virtual Machine** > **Snapshot management** > **Create snapshot and Remove Snapshot** \(VirtualMachine\.State\.CreateSnapshot and VirtualMachine\.State\.RemoveSnapshot\)

1. Assign the role as follows:

   1. Assign this vCenter role to the service account for the connector to use to log in to vCenter\.

   1. Assign this role with propagating permissions to the data centers that contain the VMs to migrate\.

1. To manually verify your vCenter service account’s permissions, verify that you can log in to vSphere Client with your connector service account credentials\. Then, export your VMs as OVF templates, use the datastore browser to download files off the datastores that contain your VMs, and view the properties on the **Summary** tab of the ESXi hosts of your VMs\.

**To configure the connector**

1. Deploy the connector OVA downloaded in the previous procedure to your VMware environment using vSphere Client\.

1. Open the connector's virtual machine console and log in as `ec2-user` with the password `ec2pass`\. Supply a new password if prompted\.

1. Obtain the IP address of the connector as follows:

   1. Run the command sudo setup\.rb\. This displays a configuration menu:

      ```
      Choose one of the following options:
            1. Reset password
            2. Reconfigure network settings
            3. Restart services
            4. Factory reset
            5. Delete unused upgrade-related files
            6. Enable/disable SSL certificate validation
            7. Display connector's SSL certificate
            8. Generate log bundle
            0. Exit
      Please enter your option [1-9]:
      ```

   1. Enter option 2\. This displays current network information and a submenu for making changes to the network settings\. The output should resemble the following:

      ```
      Current network configuration: DHCP
      IP: 192.0.2.100
      Netmask: 255.255.254.0
      Gateway: 192.0.2.1
      DNS server 1: 192.0.2.200
      DNS server 2: 192.0.2.201
      DNS suffix search list: subdomain.example.com
      Web proxy: not configured
       
      Reconfigure your network:
            1. Renew or acquire a DHCP lease
            2. Set up a static IP
            3. Set up a web proxy for AWS communication
            4. Set up a DNS suffix search list
            5. Exit
      Please enter your option [1-5]:
      ```

   You need to enter this IP address in later procedures\.

1. \[Optional\] Configure a static IP address for the connector\. This prevents you from having to reconfigure the trusted hosts lists on your LAN each time DHCP assigns a new address to the connector\.

   In the **Reconfigure your network** menu, enter option **2**\. This displays a form to supply network settings:

   For each field, provide an appropriate value and press Enter\. You should see output similar to the following:

   ```
   Setting up static IP:
         1. Enter IP address: 192.0.2.50
         2. Enter netmask: 255.255.254.0
         3. Enter gateway: 192.0.2.1
         4. Enter DNS 1: 192.0.2.200
         5. Enter DNS 2: 192.0.2.201
    
   Static IP address configured.
   ```

1. In the connector's network configuration menu, configure domain suffix values for the DNS suffix search list\.

1. If your environment uses a web proxy to reach the internet, configure that now\.

1. Before leaving the connector console, use ping to verify network access to the following targets inside and outside your LAN:
   + Inside your LAN, to your ESXi hosts and vCenter by hostname, FQDN, and IP address
   + Outside your LAN, to AWS

1. In a web browser, access the connector VM at its IP address \(https://*ip\-address\-of\-connector*/\) to open the setup wizard, and choose **Get started now**\.

1. Review the license agreement, select the check box, and choose **Next**\.

1. Create a password for the connector\.

1. Choose **Upload logs automatically** and **Server Migration Connector auto\-upgrade**\.

1. For **AWS Region**, choose your Region from the list\. For **AWS Credentials**, enter the IAM credentials that you created in [Permissions for IAM users](prereqs.md#permissions-roles)\. Choose **Next**\.

1. For **vCenter Service Account**, enter the vCenter hostname, user name, and password from step 3\. Choose **Next**\.

1. After accepting the vCenter certificate, complete registration and then view the connector configuration dashboard\.

1. Verify that the connector you registered shows up on the **Connectors** page\. If you encounter an issue registering the connector, contact [sms\-service@amazon\.com](mailto:sms-service@amazon.com)\.
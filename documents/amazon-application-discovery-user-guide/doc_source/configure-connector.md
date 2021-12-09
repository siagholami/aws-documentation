# Configure the AWS Discovery Connector<a name="configure-connector"></a>

To finish the setup process, complete the following procedure and the optional connector configuration tasks as needed\. 

**Reminder**  
Before starting the procedure select a [Migration Hub home region](https://docs.aws.amazon.com/migrationhub/latest/ug/home-region.html), if you haven't already done so\. 

**To configure the connector using it's console**

1. In a web browser, type the following URL in the address bar:  **https://***<ip\_address>***/**, where *ip\_address* is the IP address of the connector console that you saved earlier\. 

1. Choose **Get started now** and then follow the directions to complete the following setup pages: **License Agreement**, **Create a Password**, and **Network Info\.** 

1. On the **Log Uploads and Upgrades** page, we recommend that you select **Upload logs automatically**\. When your logs are made available through automatic uploads, AWS can better help you troubleshoot connector issues\. 

   The **AWS Agentless Discovery Connector auto\-upgrade** feature is enabled by default\. Running the latest version of the connector ensures that the latest security patches are installed\. You can disable auto\-upgrades at any time, see [Disabling auto\-upgrades on AWS Discovery Connector](#connector_auto_upgrade)\.

1. On the ** Discovery Connector Set Up** page, perform the following:

   1. Under **Configure vCenter credentials**:

      1. For **vCenter Host**, enter the hostname or IP address of your VMware vCenter Server host\.

      1. For **vCenter Username**, enter the name of a local or domain user that the connector uses to communicate with vCenter\. For domain users, use the form *domain*\\*username* or *username*@*domain*\.

      1. For **vCenter Password**, enter the local or domain user password\.

      1. Choose **Ignore security certificate** to bypass SSL certificate validation with vCenter\.

   1. Under **Configure AWS credentials**, enter the credentials for the IAM user who is assigned the `AWSAgentlessDiscoveryService` IAM managed policy\. For more information about managed policies, see [AWS Managed \(Predefined\) Policies for Application Discovery Service](security-iam-managed-policies.md)\. 

      Then choose **Next**\.

   1. Under **Configure where to publish data**, select to publish to a local file or to a specific AWS Regional endpoint\. If you select to publish to a local file, your Discovery Connector will not send data about your on\-premise servers to AWS\. However, the Discovery Connector will continue to send data about the connector itself to AWS\. 

      Then choose **Next** to go back to the AWS Agentless Discovery Connector console\.

The following topics describe optional connector configuration tasks\.

**Topics**
+ [Configure a static IP address for the connector](#connector_static_ip)
+ [Control the scope of data collection](#data-collection-scope)
+ [Disabling auto\-upgrades on AWS Discovery Connector](#connector_auto_upgrade)

## Configure a static IP address for the connector<a name="connector_static_ip"></a>

Follow this procedure if your environment requires that you use a static IP address\.

**To Configure a static IP address for the connector**

1. Open the connector's virtual machine console and log in as **ec2\-user** with the password **ec2pass**\. Supply a new password if prompted\.

1. Run the command **sudo setup\.rb** and enter the password for *ec2\-user* when prompted to display the configuration menu\.

1. Enter **2** to select **Reconfigure network settings**\. This displays current network information and a submenu for making changes to the network settings\.

1. In the submenu generated from the previous step, enter **2** to select **Set up a static IP**\. This will display a form to supply network settings:

   1. For each field, provide an appropriate value and press Enter\. You should see output similar to the following where *nnn\.nnn\.nnn\.nnn* is populated with the address numbers you entered for each field:

     ```
     Setting up static IP:
          1. Enter IP address: <nnn.nnn.nnn.nnn>
          2. Enter netmask: <nnn.nnn.nnn.nnn>
          3. Enter gateway: <nnn.nnn.nnn.nnn>
          4. Enter DNS 1: <nnn.nnn.nnn.nnn>
          5. Enter DNS 2: <nnn.nnn.nnn.nnn>
      
     Static IP address configured.
     ```

## Control the scope of data collection<a name="data-collection-scope"></a>

The vCenter user requires read\-only permissions on each ESX host or VM to inventory using Application Discovery Service\. Using the permission settings, you can control which hosts and VMs are included in the data collection\. You can either allow all hosts and VMs under the current vCenter to be inventoried, or grant permissions on a case\-by\-case basis\.

**Note**  
As a security best practice, we recommend against granting additional, unneeded permissions to the vCenter user of the Discovery Connector\.

The following procedures describe configuration scenarios ordered from least granular to most granular\.

**To discover data about *all* ESX hosts and VMs under the current vCenter**

1. In your VMware vSphere client, choose **vCenter** and then choose either **Hosts and Clusters** or **VMs and Templates**\. 

1. Choose **Manage**, **Permissions**\.

1. Select the vCenter user, open the context \(right\-click\) menu, and choose **Change Role**\.

1. In the **Assigned Role** pane, choose **Read\-only**\.

1.  Choose **Propagate to children**, **OK**\.

**To discover data about a *specific* ESX host and *all* of its child objects**

1. In your VMware vSphere client, choose **vCenter** and then choose either **Hosts and Clusters** or **VMs and Templates**\. 

1. Choose **Related Objects**, **Hosts**\. 

1. Open the context \(right\-click\) menu for the host name and choose **All vCenter Actions**, **Add Permission**\.

1. Under **Add Permission**, add the vCenter user to the host\. For **Assigned Role**, choose **Read\-only**\. 

1. Choose **Propagate to children**, **OK**\.

**Discover data about a *specific* ESX host or child VM**

1. In your VMware vSphere client, choose **vCenter** and then choose either **Hosts and Clusters** or **VMs and Templates**\. 

1. Choose **Related Objects**\.

1. Choose **Hosts** \(showing a list of ESX hosts known to vCenter\) or **Virtual Machines** \(showing a list of VMs across all ESX hosts\)\. 

1. Open the context \(right\-click\) menu for the host or VM name and choose **All vCenter Actions**, **Add Permission**\.

1.  Under **Add Permission**, add the vCenter user to the host or VM\. For **Assigned Role**, choose **Read\-only**, \. 

1. Choose **OK**\. 

**Note**  
If you chose **Propagate to children**, you can still remove the read\-only permission from ESX hosts and VMs on a case\-by\-case basis\. This option has no effect on inherited permissions applying to other ESX hosts and VMs\. 

## Disabling auto\-upgrades on AWS Discovery Connector<a name="connector_auto_upgrade"></a>

To ensure that you are running the latest version of AWS Discovery Connector, the auto\-upgrade feature is enabled by default upon installation\. However, you may disable the auto\-upgrade feature as shown below\.

**To disable auto\-upgrades**

1. In a web browser, type the following URL in the address bar:  **https://***<ip\_address>***/**, where *ip\_address* is the IP address of the AWS Discovery Connector\.

1. In the Discovery Connector console, under **Actions**, choose **Disable Auto\-Upgrade**\.

**Warning**  
Disabling auto\-upgrades will prevent the latest security patches from being installed\.
# Getting Started with cloudhsm\_mgmt\_util<a name="cloudhsm_mgmt_util-getting-started"></a>

AWS CloudHSM includes two command line tools with the [AWS CloudHSM client software](install-and-configure-client-linux.md#install-client)\. The [cloudhsm\_mgmt\_util](cloudhsm_mgmt_util-reference.md) tool includes commands to manage HSM users\. The [key\_mgmt\_util](key_mgmt_util-reference.md) tool includes commands to manage keys\. To get started with the cloudhsm\_mgmt\_util command line tool, complete the following tasks\.

**Topics**
+ [Prepare to run cloudhsm\_mgmt\_util](#cloudhsm_mgmt_util-setup)
+ [Basic Usage of cloudhsm\_mgmt\_util](#cloudhsm_mgmt_util-basics)
+ [Using cloudhsm\_mgmt\_util Across Cloned Clusters](#cloudhsm_mgmt_util-syncConfig)

## Prepare to run cloudhsm\_mgmt\_util<a name="cloudhsm_mgmt_util-setup"></a>

Complete the following tasks before you use cloudhsm\_mgmt\_util\. You need to do these steps the first time you use cloudhsm\_mgmt\_util and after you add or remove HSMs in your cluster\. The steps update the HSM list in the configuration files that the AWS CloudHSM client and command line tools use\. Keeping these files updated helps AWS CloudHSM to synchronize data and maintain consistency across all HSMs in the cluster\. 

**Topics**
+ [Step 1: Stop the AWS CloudHSM Client](#cloudhsm_mgmt_util-stop-cloudhsm-client)
+ [Step 2: Update the AWS CloudHSM Configuration Files](#cloudhsm_mgmt_util-config-a)
+ [Step 3: Start the AWS CloudHSM Client](#cloudhsm_mgmt_util-start-cloudhsm-client)
+ [Step 4: Update the cloudhsm\_mgmt\_util Configuration File](#cloudhsm_mgmt_util-update-configuration)

### Step 1: Stop the AWS CloudHSM Client<a name="cloudhsm_mgmt_util-stop-cloudhsm-client"></a>

Before you update the configuration files that the AWS CloudHSM and command line tools use, stop the AWS CloudHSM client\. If the client is already stopped, running the stop command has no harmful effect\. 

------
#### [ Amazon Linux ]

```
$ sudo stop cloudhsm-client
```

------
#### [ Amazon Linux 2 ]

```
$ sudo service cloudhsm-client stop
```

------
#### [ CentOS 6 ]

```
$ sudo stop cloudhsm-client
```

------
#### [ CentOS 7 ]

```
$ sudo service cloudhsm-client stop
```

------
#### [ RHEL 6 ]

```
$ sudo stop cloudhsm-client
```

------
#### [ RHEL 7 ]

```
$ sudo service cloudhsm-client stop
```

------
#### [ Ubuntu 16\.04 LTS ]

```
$ sudo service cloudhsm-client stop
```

------
#### [ Windows ]
+ For Windows client 1\.1\.2\+:

  ```
  C:\Program Files\Amazon\CloudHSM>net.exe stop AWSCloudHSMClient
  ```
+ For Windows clients 1\.1\.1 and older:

  Use **Ctrl**\+**C** in the command window where you started the AWS CloudHSM client\.

------

### Step 2: Update the AWS CloudHSM Configuration Files<a name="cloudhsm_mgmt_util-config-a"></a>

This step uses the `-a` parameter of the [configure tool](configure-tool.md) to add the elastic network interface \(ENI\) IP address of one of the HSMs in the cluster to the configuration file\.

------
#### [ Amazon Linux ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ Amazon Linux 2 ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ CentOS 6 ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ CentOS 7 ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ RHEL 6 ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ RHEL 7 ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ Ubuntu 16\.04 LTS ]

```
$ sudo /opt/cloudhsm/bin/configure -a <HSM ENI IP>
```

------
#### [ Windows ]

```
c:\Program Files\Amazon\CloudHSM>configure.exe -a <HSM ENI IP>
```

------

To get the ENI IP address of an HSM in your cluster, navigate to the AWS CloudHSM console, choose **clusters**, and select the desired cluster\. You can also use the [DescribeClusters](https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html) operation, the [describe\-clusters](https://docs.aws.amazon.com/cli/latest/reference/cloudhsmv2/describe-clusters.html) command, or the [Get\-HSM2Cluster](https://docs.aws.amazon.com/powershell/latest/reference/items/Get-HSM2Cluster.html) PowerShell cmdlet\. Type only one ENI IP address\. It does not matter which ENI IP address you use\. 

### Step 3: Start the AWS CloudHSM Client<a name="cloudhsm_mgmt_util-start-cloudhsm-client"></a>

Next, start or restart the AWS CloudHSM client\. When the AWS CloudHSM client starts, it uses the ENI IP address in its configuration file to query the cluster\. Then it adds the ENI IP addresses of all HSMs in the cluster to the cluster information file\.

------
#### [ Amazon Linux ]

```
$ sudo start cloudhsm-client
```

------
#### [ Amazon Linux 2 ]

```
$ sudo service cloudhsm-client start
```

------
#### [ CentOS 6 ]

```
$ sudo start cloudhsm-client
```

------
#### [ CentOS 7 ]

```
$ sudo service cloudhsm-client start
```

------
#### [ RHEL 6 ]

```
$ sudo start cloudhsm-client
```

------
#### [ RHEL 7 ]

```
$ sudo service cloudhsm-client start
```

------
#### [ Ubuntu 16\.04 LTS ]

```
$ sudo service cloudhsm-client start
```

------
#### [ Windows ]
+ For Windows client 1\.1\.2\+:

  ```
  C:\Program Files\Amazon\CloudHSM>net.exe start AWSCloudHSMClient
  ```
+ For Windows clients 1\.1\.1 and older:

  ```
  C:\Program Files\Amazon\CloudHSM>start "cloudhsm_client" cloudhsm_client.exe C:\ProgramData\Amazon\CloudHSM\data\cloudhsm_client.cfg
  ```

------

### Step 4: Update the cloudhsm\_mgmt\_util Configuration File<a name="cloudhsm_mgmt_util-update-configuration"></a>

The final step uses the `-m` parameter of the [configure tool](configure-tool.md) to copy the updated ENI IP addresses from the cluster information file to the configuration file that cloudhsm\_mgmt\_util uses\. If you skip this step, you might run into synchronization problems, such as [inconsistent user data](troubleshooting-keep-hsm-users-in-sync.md) in your cluster's HSMs\. 

------
#### [ Amazon Linux ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ Amazon Linux 2 ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ CentOS 6 ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ CentOS 7 ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ RHEL 6 ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ RHEL 7 ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ Ubuntu 16\.04 LTS ]

```
$ sudo /opt/cloudhsm/bin/configure -m
```

------
#### [ Windows ]

```
c:\Program Files\Amazon\CloudHSM>configure.exe -m
```

------

When this step is complete, you are ready to start cloudhsm\_mgmt\_util\. If you add or delete HSMs at any time, be sure to repeat this procedure before using cloudhsm\_mgmt\_util\. 

## Basic Usage of cloudhsm\_mgmt\_util<a name="cloudhsm_mgmt_util-basics"></a>

The following tasks cover the basic usage of the cloudhsm\_mgmt\_util tool\.

**Warning**  
The cloudhsm\_mgmt\_util tool doesn't support auto\-completion using the Tab key\. Using the Tab key with cloudhsm\_mgmt\_util can make it unresponsive\.

**Topics**
+ [Start cloudhsm\_mgmt\_util](#cloudhsm_mgmt_util-start)
+ [Enable End\-to\-End Encryption](#cloudhsm_mgmt_util-enable_e2e)
+ [Log in to the HSMs](#cloudhsm_mgmt_util-log-in)
+ [Log Out from the HSMs](#cloudhsm_mgmt_util-log-out)
+ [Stop cloudhsm\_mgmt\_util](#cloudhsm_mgmt_util-stop)

### Start cloudhsm\_mgmt\_util<a name="cloudhsm_mgmt_util-start"></a>

Use the following command to start cloudhsm\_mgmt\_util\.

------
#### [ Amazon Linux ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ Amazon Linux 2 ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ CentOS 6 ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ CentOS 7 ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ RHEL 6 ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ RHEL 7 ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ Ubuntu 16\.04 LTS ]

```
$ /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_util.cfg
```

------
#### [ Windows ]

```
C:\Program Files\Amazon\CloudHSM>cloudhsm_mgmt_util.exe C:\ProgramData\Amazon\CloudHSM\data\cloudhsm_mgmt_util.cfg
```

------

Output should be similar to the following depending on how many HSMs you have\.

```
Connecting to the server(s), it may take time
depending on the server(s) load, please wait...

Connecting to server '10.0.2.9': hostname '10.0.2.9', port 2225...
Connected to server '10.0.2.9': hostname '10.0.2.9', port 2225.

Connecting to server '10.0.3.11': hostname '10.0.3.11', port 2225...
Connected to server '10.0.3.11': hostname '10.0.3.11', port 2225.

Connecting to server '10.0.1.12': hostname '10.0.1.12', port 2225...
Connected to server '10.0.1.12': hostname '10.0.1.12', port 2225.
```

The prompt changes to aws\-cloudhsm> when cloudhsm\_mgmt\_util is running\.

### Enable End\-to\-End Encryption<a name="cloudhsm_mgmt_util-enable_e2e"></a>

Starting with version 1\.1\.1 of the client and related software libraries, end\-to\-end encrypted communication between cloudhsm\_mgmt\_util and the HSMs in your cluster is enabled by default\. If you are using an earlier version, you can use the enable\_e2e command to enable end\-to\-end encryption each time you start cloudhsm\_mgmt\_util\.

```
aws-cloudhsm>enable_e2e
E2E enabled on server 0(10.0.2.9)
E2E enabled on server 1(10.0.3.11)
E2E enabled on server 2(10.0.1.12)
```

### Log in to the HSMs<a name="cloudhsm_mgmt_util-log-in"></a>

Use the loginHSM command to log in to the HSMs\. Any user of any type can use this command to log in to the HSMs\. 

The command in the following example logs in *admin*, which is the default [crypto officer \(CO\)](hsm-users.md)\. You set this user's password when you [activated the cluster](activate-cluster.md)\. The output shows that the command logged in the *admin* user to all of the HSMs in the cluster\. 

**Warning**  
When you log in to cloudhsm\_mgmt\_util, verify that the ENI IP addresses in the success messages *exactly match* the ENI IP addresses of all HSMs in the cluster\. If they do not, stop and run all steps in the [Prepare to run cloudhsm\_mgmt\_util](#cloudhsm_mgmt_util-setup) procedure\.   
To get the ENI IP addresses of the HSMs in your cluster, the [DescribeClusters](https://docs.aws.amazon.com/cloudhsm/latest/APIReference/API_DescribeClusters.html) operation, the [describe\-clusters](https://docs.aws.amazon.com/cli/latest/reference/cloudhsmv2/describe-clusters.html) command, or the [Get\-HSM2Cluster](https://docs.aws.amazon.com/powershell/latest/reference/items/Get-HSM2Cluster.html) PowerShell cmdlet\. 

```
aws-cloudhsm>loginHSM CO admin <password>
loginHSM success on server 0(10.0.2.9)
loginHSM success on server 1(10.0.3.11)
loginHSM success on server 2(10.0.1.12)
```

The following shows the syntax for the loginHSM command\.

```
aws-cloudhsm>loginHSM <user type> <user name> <password>
```

### Log Out from the HSMs<a name="cloudhsm_mgmt_util-log-out"></a>

Use the logoutHSM command to log out of the HSMs\.

```
aws-cloudhsm>logoutHSM
logoutHSM success on server 0(10.0.2.9)
logoutHSM success on server 1(10.0.3.11)
logoutHSM success on server 2(10.0.1.12)
```

### Stop cloudhsm\_mgmt\_util<a name="cloudhsm_mgmt_util-stop"></a>

Use the quit command to stop cloudhsm\_mgmt\_util\.

```
aws-cloudhsm>quit

disconnecting from servers, please wait...
```

## Using cloudhsm\_mgmt\_util Across Cloned Clusters<a name="cloudhsm_mgmt_util-syncConfig"></a>

In some cases, you will use cloudhsm\_mgmt\_util to synchronize changes across cloned clusters\. In order to do so, you will need to manually create a new cloudhsm\_mgmt\_util configuration file that specifies the HSMs you want to sync\. For this example, create a copy of your current config file \(`/opt/cloudhsm/etc/cloudhsm_mgmt_config.cfg`\) and change the copy's name to `syncConfig.cfg`\.

Edit `syncConfig.cfg` to include the Elastic Network Interface \(ENI\) IPs of the HSMs to be synced\. We recommend that you specify the source HSM first, followed by the destination HSMs\. To find the ENI IP of an HSM, see [Update the AWS CloudHSM Configuration Files](#cloudhsm_mgmt_util-config-a)\.

Initialize `cloudhsm_mgmt_util` with the new config file by issuing the following command:

```
aws-cloudhsm> /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/userSync.cfg
```

Check the status messages returned to ensure that the `cloudhsm_mgmt_util` is connected to all desired HSMs and determine which of the returned ENI IPs corresponds to each cluster\.

When you are done synchronizing HSMs or clusters, initialize cloudhsm\_mgmt\_util with the original configuration file\.

```
aws-cloudhsm> /opt/cloudhsm/bin/cloudhsm_mgmt_util /opt/cloudhsm/etc/cloudhsm_mgmt_config.cfg
```
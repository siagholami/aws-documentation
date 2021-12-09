# Working with Amazon Inspector agents on Windows\-based operating systems<a name="inspector_agents-on-win"></a>

You can start, stop, and modify the behavior of Amazon Inspector agents\. Sign in to your EC2 instance running a Windows\-based operating system and perform any of the procedures in this chapter\. For more information about the operating systems that are supported for Amazon Inspector, see [Amazon Inspector supported operating systems and Regions](inspector_supported_os_regions.md)\.

**Important**  
The Amazon Inspector agent relies on Amazon EC2 instance metadata to function correctly\. It accesses instance metadata using version 1 or version 2 of the Instance Metadata Service \(IMDSv1or IMDSv2\)\. See [Instance Metadata and User Data](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html) to learn more about EC2 instance metadata and access methods\.

**Note**  
The commands in this chapter function in all AWS Regions that are supported by Amazon Inspector\.

**Topics**
+ [Starting or stopping an Amazon Inspector agent or verifying that the agent is running](#stop-start-windows)
+ [Modifying Amazon Inspector agent settings](#inspector-agent-modify-settings)
+ [Configuring proxy support for an Amazon Inspector agent](#inspector-agent-proxy)
+ [Uninstalling the Amazon Inspector agent](#uninstall-windows)

## Starting or stopping an Amazon Inspector agent or verifying that the agent is running<a name="stop-start-windows"></a>

**To start, stop, or verify an agent**

1. On your EC2 instance, choose **Start**, **Run**, and then enter **services\.msc**\.

1. If the agent is successfully running, two services are listed with their status set to **Started** or **Running** in the **Services** window: **AWS Agent Service** and **AWS Agent Updater Service**\.

1. To start the agent, right\-click **AWS Agent Service**, and then choose **Start**\. If the service successfully starts, the status is updated to **Started** or **Running**\.

1. To stop the agent, right\-click **AWS Agent Service**, and then choose **Stop**\. If the service successfully stops, the status is cleared \(appears as blank\)\. We don't recommend stopping the **AWS Agent Updater Service** because it disables the installation of all future enhancements and fixes to the agent\.

1. To verify that the agent is installed and running, sign in to your EC2 instance, and open a command prompt using administrative permissions\. Navigate to `C:/Program Files/Amazon Web Services/AWS Agent`, and then run the following command:

   AWSAgentStatus\.exe

   This command returns the status of the currently running agent, or an error stating that the agent can't be contacted\.

## Modifying Amazon Inspector agent settings<a name="inspector-agent-modify-settings"></a>

After the Amazon Inspector agent is installed and running on your EC2 instance, you can modify the settings in the `agent.cfg` file to alter the agent's behavior\. On Windows\-based operating systems, the file is located in the `C:\ProgramData\Amazon Web Services\AWS Agent` directory\. After you modify and save the `agent.cfg` file, you must stop and start the agent for the changes to take effect\.

**Important**  
We highly recommend that you modify the `agent.cfg` file only with the guidance of AWS Support\.

## Configuring proxy support for an Amazon Inspector agent<a name="inspector-agent-proxy"></a>

To get proxy support for an agent on a Windows\-based operating system, use the `WinHTTP` proxy\. To set up the `WinHTTP` proxy using the `netsh` utility, see [Netsh Commands for Windows Hypertext Transfer Protocol \(WINHTTP\)](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc731131(v=ws.10))\.

**Important**  
Only HTTPS proxies are supported for Windows\-based instances\.

Complete one of the following procedures:

**To install an agent on an EC2 instance that uses a proxy server**

1. Download the following \.exe file: `https://d1wk0tztpsntt1.cloudfront.net/windows/installer/latest/AWSAgentInstall.exe`\.

1. Open a command prompt window or PowerShell window \(using administrative permissions\)\. Navigate to the location where you saved the downloaded `AWSAgentInstall.exe`, and then run the following command:

   `./AWSAgentInstall.exe \install USEPROXY=1`

**To configure proxy support on an EC2 instance with a running agent**

1. To configure proxy support, the version of the Amazon Inspector agent that is running on your EC2 instance must be 1\.0\.0\.59 or later\. If you enabled the auto\-update process for the agent, you can verify that your agent's version is 1\.0\.0\.59 or later by using the [Starting or stopping an Amazon Inspector agent or verifying that the agent is running](#stop-start-windows) procedure\. If you didn't enable the auto\-update process for the agent, you must install the agent on this EC2 instance again by following the [Installing the agent on a Windows\-based EC2 instance](inspector_installing-uninstalling-agents.md#install-windows) procedure\.

1. Open the registry editor \(`regedit.exe`\)\.

1. Navigate to the following registry key: `"HKEY_LOCAL_MACHINE/SOFTWARE/Amazon Web Services/AWS Agent Updater"`\.

1. Inside this registry key, create a registry `DWORD(32bit)` value called `"UseProxy"`\.

1. Double\-click on the value, and set the value to 1\.

1. Enter **services\.msc**, locate the **AWS Agent Service** and the **AWS Agent Updater Service** in the **Services** window, and restart each process\. After both processes have successfully restarted, run the `AWSAgentStatus.exe` file \(see step 5 in [Starting or stopping an Amazon Inspector agent or verifying that the agent is running](#stop-start-windows)\)\. View the status of your agent and verify that it is using the configured proxy\.

## Uninstalling the Amazon Inspector agent<a name="uninstall-windows"></a>

**To uninstall the agent**

1. Sign in to your EC2 instance running a Windows\-based operating system where you want to uninstall the Amazon Inspector agent\.
**Note**  
For more information about the operating systems that are supported for Amazon Inspector, see [Amazon Inspector supported operating systems and Regions](inspector_supported_os_regions.md)\.

1. On your EC2 instance, navigate to **Control Panel**, **Add/Remove Programs**\.

1. In the list of installed programs, choose **AWS Agent**, and then choose **Uninstall**\.
# Installing Amazon Inspector agents<a name="inspector_installing-uninstalling-agents"></a>

You can install the Amazon Inspector agent using the [Systems Manager Run Command](http://docs.aws.amazon.com/systems-manager/latest/userguide/execute-remote-commands.html) on multiple instances \(including both Linux\-based and Windows\-based instances\)\. Alternatively, you can install the agent individually by signing in to each EC2 instance\. The procedures in this chapter provide instructions for both methods\.

As another option, you can quickly install the agent on all Amazon EC2 instances included in an assessment target by selecting the **Install Agents** check box on the **Define an Assessment target** page on the console\.

**Topics**
+ [Amazon Linux 2 AMI with the Amazon Inspector Agent](#ami-with-agent)
+ [Installing the agent on multiple EC2 instances using the Systems Manager Run Command](#install-run-command)
+ [Installing the agent on a Linux\-based EC2 instance](#install-linux)
+ [Installing the agent on a Windows\-based EC2 instance](#install-windows)

**Note**  
The procedures in this chapter apply to all AWS Regions that are supported by Amazon Inspector\.

## Amazon Linux 2 AMI with the Amazon Inspector Agent<a name="ami-with-agent"></a>

To skip the manual Amazon Inspector agent installation on the Amazon Linux EC2 instances that you want to include in your assessment targets, you can use the **Amazon Linux 2 AMI with Amazon Inspector Agent**\. This AMI has the agent preinstalled and requires no additional steps to install or set up the agent\. To start using Amazon Inspector with these EC2 instances, tag them to match the assessment target that you want\. The configuration of **Amazon Linux 2 AMI with Amazon Inspector Agent** enhances security by focusing on two main security goals: limiting access and reducing software vulnerabilities\. 

This is the only currently available EC2 instance AMI with the preinstalled Amazon Inspector agent\. For the EC2 instances that run Ubuntu Server or Windows Server, you must complete the manual agent installation steps\.

The **Amazon Linux 2 AMI with Amazon Inspector Agent** is available on the EC2 console and also at the [AWS Marketplace](https://aws.amazon.com/marketplace/pp/B07PWHGXQG)\.

## Installing the agent on multiple EC2 instances using the Systems Manager Run Command<a name="install-run-command"></a>

You can install the Amazon Inspector agent on your EC2 instances using the [Systems Manager Run Command](http://docs.aws.amazon.com/systems-manager/latest/userguide/execute-remote-commands.html)\. This enables you to install the agent remotely and on multiple instances \(both Linux\-based and Windows\-based instances with the same command\) at once\. 

**Important**  
Agent installation using the Systems Manager Run Command is not currently supported for the Debian operating system\.

**Important**  
To use this option, make sure that your EC2 instance has the SSM Agent installed and has an IAM role that allows Run Command\. The SSM Agent is installed, by default, on Amazon EC2 Windows instances and Amazon Linux instances\. Amazon EC2 Systems Manager requires an IAM role for EC2 instances that processes commands and a separate role for users executing commands\. For more information, see [Installing and configuring SSM Agent](http://docs.aws.amazon.com/systems-manager/latest/userguide/ssm-agent.html) and [Configuring security roles for System Manager](http://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-access.html)\. 

**To install the agent on multiple EC2 instances using the Systems Manager Run Command**

1. Open the AWS Systems Manager console at [https://console\.aws\.amazon\.com/systems\-manager/](https://console.aws.amazon.com/systems-manager/)\.

1. In the navigation pane under **Instances & nodes**, choose **Run Command**\. 

1. Choose **Run a command**\.

1. For **Command document**, choose the document named **AmazonInspector\-ManageAWSAgent** that is owned by **Amazon**\. This document contains the script for installing the Amazon Inspector agent on EC2 instances\.

1. For **Targets**, you can select EC2 instances using different methods\. To install the agent on all of the instances in the assessment target, you can specify the tags that were used to create the assessment target\.

1. Provide your choices for the rest of the available options using the instructions in [Running commands from the console](https://docs.aws.amazon.com/systems-manager/latest/userguide/rc-console.html), and then choose **Run**\.

**Note**  
You can also install the agent on multiple EC2 instances \(both Linux\-based and Windows\-based\) when you create an assessment target, or you can use the **Install Agents with Run Command** button for an existing target\. For more information, see [Creating an assessment target](inspector_applications.md#create_application_via_console)\. 

## Installing the agent on a Linux\-based EC2 instance<a name="install-linux"></a>

Perform the following procedure to install the Amazon Inspector agent on a Linux\-based EC2 instance\.

**To install the agent on a Linux\-based EC2 instance**

1. Sign in to your EC2 instance running a Linux\-based operating system where you want to install the Amazon Inspector agent\.
**Note**  
For information about the operating systems that Amazon Inspector supports, see [Amazon Inspector supported operating systems and Regions](inspector_supported_os_regions.md)\.

1. Download the agent installation script by running one of the following commands:
   + wget https://inspector\-agent\.amazonaws\.com/linux/latest/install
   + curl \-O https://inspector\-agent\.amazonaws\.com/linux/latest/install

1. \(Optional\) Verify that the agent installation script is not altered or corrupted\. For more information, see [\(Optional\) Verify the signature of the Amazon Inspector agent installation script on Linux\-based operating systems](inspector_verify-sig-agent-download-linux.md)\.

1. To install the agent, run sudo bash install\.
**Note**  
As updates for the agent become available, they are automatically downloaded from Amazon S3 and applied\. For more information, see [Amazon Inspector agent updates](inspector_agents.md#agent-updates)\.  
If you want to skip this auto\-update process, run the following command when you install the agent:  
sudo bash install \-u false
**Note**  
\(Optional\) To remove the agent installation script, run rm install\.

1. Verify that the following files required for the agent to be successfully installed and functioning properly are installed:
   + `libcurl4` \(required to install the agent on Ubuntu 18\.04\)
   + `libcurl3`
   + `libgcc1`
   + `libc6`
   + `libstdc++6`
   + `libssl1.0.1`
   + `libssl1.0.2` \(required to install the agent on Debian 9\)
   + `libpcap0.8`

## Installing the agent on a Windows\-based EC2 instance<a name="install-windows"></a>

Perform the following procedure to install the Amazon Inspector agent on a Windows\-based EC2 instance\.

**To install the agent on a Windows\-based EC2 instance**

1. Sign in to your EC2 instance running a Windows\-based operating system where you want to install the agent\.
**Note**  
For more information about the operating systems that Amazon Inspector supports, see [Amazon Inspector supported operating systems and Regions](inspector_supported_os_regions.md)\.

1. Download the following \.exe file: 

   `https://inspector-agent.amazonaws.com/windows/installer/latest/AWSAgentInstall.exe`

1. Open a command prompt window \(with administrative permissions\), navigate to the location where you saved the downloaded `AWSAgentInstall.exe`, and run the \.exe file to install the agent\.
**Note**  
As updates for the agent become available, they are automatically downloaded from Amazon S3 and applied\. For more information, see [Amazon Inspector agent updates](inspector_agents.md#agent-updates)\.  
If you want to skip this auto\-update process, run the following command when you install the agent:  
AWSAgentInstall\.exe AUTOUPDATE=No
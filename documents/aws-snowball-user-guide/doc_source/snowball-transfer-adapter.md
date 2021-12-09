--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Transferring Data with the Amazon S3 Adapter for Snowball<a name="snowball-transfer-adapter"></a>

The Amazon S3 Adapter for Snowball is a programmatic tool that you can use to transfer data between your on\-premises data center and a Snowball\. When programmatically transferring data to a Snowball, all data goes through the Amazon S3 Adapter for Snowball, without exception\.

The Amazon S3 Adapter for Snowball must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\.

We highly recommend that your workstation be a powerful computer\. It should be able to meet high demands in terms of processing, memory, and networking\. For more information, see [Workstation Specifications](specifications.md#workstationspecs)\.

## Downloading and Installing the Amazon S3 Adapter for Snowball<a name="adapter-install"></a>

The Amazon S3 Adapter for Snowball must be downloaded from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page and installed on a powerful workstation that you own\. Once there, find the installation package for your operating system, and follow the instructions to install the Amazon S3 Adapter for Snowball\. Running the adapter from a terminal in your workstation might require using a specific path, depending on your operating system\.

To install the adapter, first download the snowball\-adapter\-*operating\_system*\.zip file from the [AWS Snowball Resources](http://aws.amazon.com/snowball/resources/) page\. Unzip the file, and navigate the extracted folder\. For the Mac and Linux versions of the adapter, to make the snowball\-adapter file executable, change the permissions on this file within the bin directory with the following commands\.

`chmod +x snowball-adapter`

**To confirm the adapter was installed successfully**

1. Open a terminal window on the workstation with the installed adapter\.

1. Navigate to the directory where you installed the snowball\-adapter\-*operating\_system* subdirectory\.

1. Navigate to snowball\-adapter\-*operating\_system*/bin\.

1. Type the following command to confirm that the adapter was installed correctly: `./snowball-adapter --help`\. 

   If the adapter was successfully installed, its usage information appears in the terminal\.

Installing the adapter also adds the snowball subdirectory to your \.aws directory\. Within this snowball directory, you can find the logs and config subdirectories\. Their contents are as follows:
+ The logs directory is where you find the log files for your data transfers to the Snowball through the Amazon S3 Adapter for Snowball\.
+ The config directory contains two files:
  + The snowball\-adapter\-logging\.config file contains the configuration settings for the log files written to the \~/\.aws/snowball/logs directory\.
  + The snowball\-adapter\.config file contains the configuration settings for the adapter itself\.

**Note**  
The \.aws directory is located at \~/\.aws in Linux, OS X, or Unix, or at C:\\User\\*USERNAME*\\\.aws on Windows\.

## Downloading and Installing Version 1\.16\.14 of the AWS CLI<a name="cli-version"></a>

Currently, only version 1\.16\.14 and earlier of the AWS CLI are supported for use with Snowball Edge devices\. You can download and install this version of the AWS CLI from GitHub\. Use the following procedure to perform this task\.

**Note**  
Make sure that you install version 2\.6\.5\+ or 3\.4\+ of Python before you install version 1\.16\.14 of the AWS CLI\.

**To download and install version 1\.16\.14 of the AWS CLI**

1. Uninstall existing installations of the AWS CLI\. This step is optional for Linux installations\.
   + **Windows** – For more information, see [Uninstalling](https://docs.aws.amazon.com/cli/latest/userguide/awscli-install-windows.html#install-msi-uninstall) in the *AWS Command Line Interface User Guide*\.
   + **Linux** – This step is optional for Linux installations\. However, to uninstall a existing installation of the AWS CLI, run the following commands from a terminal:

     ```
     sudo rm -rf /usr/local/aws
     sudo rm /usr/local/bin/aws
     ```

1. Download the AWS CLI as [a \.zip file](https://github.com/aws/aws-cli/archive/1.16.14.zip) from the AWS GitHub repository where it resides\.

1. Install the AWS CLI version 1\.16\.14 from the `1.16.14.zip` file with one of the following procedures:
   + **Windows**

     1. Extract the archive to a location on your computer, for example: `C:\Users\username\aws_cli\aws-cli-1.6.14`

     1. Open a command prompt, navigate to the folder that you extracted the archive to, and run the setup script with the following command\.

        ```
        py setup.py install
        ```

     1. Add the AWS CLI to your `PATH` environment variable\. 

     Doing this installs version 1\.6\.14 of the AWS CLI\.
   + **Linux**

     1. Extract the archive to a location on your computer, for example: `/home/username/aws_cli/aws-cli-1.6.14`

     1. Open a terminal window, navigate to the directory that you extracted the archive to, and run the setup script with the following command\.

        ```
        python setup.py install
        ```
**Note**  
You might need to run the command with `sudo`\.

        This command installs version 1\.6\.14 of the AWS CLI, and overwrites files created by any previously installed AWS CLI version\.
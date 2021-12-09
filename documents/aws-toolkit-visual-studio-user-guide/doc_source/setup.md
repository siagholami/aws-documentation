# Setting Up the AWS Toolkit for Visual Studio<a name="setup"></a>

This topic describes how to install and configure the Toolkit for Visual Studio\.

## Prerequisites<a name="prereqs"></a>

To install and configure the Toolkit for Visual Studio, you must:
+ Have an AWS account\. This account enables you to use AWS services\. To get an AWS account, on the [AWS home page](https://aws.amazon.com/), choose **Create an AWS Account**\.
+ Run a supported operating system: Windows 10, Windows 8, or Windows 7\.

  We recommend that you install the latest service packs and updates for the Windows version you're using\.
+ Visual Studio 2013 or later \(including Community editions\)\.

  We recommend that you install the latest service packs and updates\.

**Note**  
The Toolkit for Visual Studio is still available if you're using Visual Studio versions 2008, 2010, and 2012 \(including Express editions where available\)\. However, it is not supported\. For Express editions, the installation includes only the AWS project templates and the [standalone deployment tool](deployment-tool.md#tkv-deployment-tool)\. Visual Studio Express editions don't support third\-party extensions, such as AWS Explorer\. Find links to these older versions of the Toolkit for Visual Studio below in [Older Versions of the Toolkit for Visual Studio](#older-versions)\.

## Install the Toolkit for Visual Studio<a name="install"></a>

------
#### [ Install for Visual Studio 2017 and Visual Studio 2019 ]

The Toolkit for Visual Studio for Visual Studio 2017 and Visual Studio 2019 is distributed in the [Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=AmazonWebServices.AWSToolkitforVisualStudio2017)\. You can also install and update the toolkit within Visual Studio by using **Tools** ≫ **Extensions and Updates** \(Visual Studio 2017\) or **Extensions** ≫ **Manage Extensions** \(Visual Studio 2019\)\.

After the toolkit has been installed, open it by choosing **AWS Explorer** from the **View** menu\.

------
#### [ Install for Visual Studio 2013 and Visual Studio 2015 ]

The Toolkit for Visual Studio for Visual Studio 2013 and Visual Studio 2015 are part of the AWS Tools for Windows\. You can install the AWS Tools for Windows for these versions as follows\.

1. Navigate to the page [AWS Toolkit for Visual Studio](https://aws.amazon.com/visualstudio)\.

1. In the **Download** section, choose **Toolkit for Visual Studio 2013\-2015** to download the installer\.

1. To start the installation, run the downloaded installer and follow the instructions\.

**Note**  
By default, the Toolkit for Visual Studio is installed in the Program Files directory, which requires administrator privileges\. To install the Toolkit for Visual Studio as a non\-administrator, specify a different installation directory\.

------

## Uninstall the Toolkit for Visual Studio<a name="uninstall"></a>

------
#### [ Uninstall for Visual Studio 2017 and Visual Studio 2019 ]

Uninstall the Toolkit for Visual Studio from within Visual Studio by using **Tools** ≫ **Extensions and Updates** \(Visual Studio 2017\) or **Extensions** ≫ **Manage Extensions** \(Visual Studio 2019\)\.

------
#### [ Uninstall for Visual Studio 2013 and Visual Studio 2015 ]

To uninstall the Toolkit for Visual Studio, you must uninstall the AWS Tools for Windows\.

1. In Control Panel, open **Programs and Features**\.
**Note**  
To open **Programs and Features** directly, run `appwiz.cpl` from a command prompt or the Windows **Run** dialog\. 

1. Choose AWS Tools for Windows, and then choose **Uninstall**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/uninstall.png)

1. If prompted, choose **Yes**\.

Uninstalling the AWS Tools for Windows doesn't remove the Samples directory\. This directory is preserved in case you have modified the samples\. You have to manually remove this directory\.

------

## Older Versions of the Toolkit for Visual Studio<a name="older-versions"></a>

 **Visual Studio 2008**—Install the Toolkit for Visual Studio 2008 from [https://sdk\-for\-net\.amazonwebservices\.com/latest/AWSToolkitForVisualStudio2008\.msi](https://sdk-for-net.amazonwebservices.com/latest/AWSToolkitForVisualStudio2008.msi)\.

 **Visual Studio 2010 and 2012**—Install the Toolkit for Visual Studio for Visual Studio 2010 and 2012 from [https://sdk\-for\-net\.amazonwebservices\.com/latest/AWSToolkitForVisualStudio2010\-2012\.msi](https://sdk-for-net.amazonwebservices.com/latest/AWSToolkitForVisualStudio2010-2012.msi)\.
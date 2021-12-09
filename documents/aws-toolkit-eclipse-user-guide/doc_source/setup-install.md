# Set up the Toolkit<a name="setup-install"></a>

This section desribes how to install or upgrade the AWS Toolkit for Eclipse\.

## Prerequisites<a name="prerequisites"></a>

The AWS Toolkit for Eclipse has the following prerequisites:
+  *An Amazon Web Services account*– To obtain an AWS account, go to the [AWS home page](https://aws.amazon.com/) and click **Sign Up Now**\. Signing up will enable you to use all of the services offered by AWS\.
+  *A supported operating system*– The AWS Toolkit for Eclipse is supported on Windows, Linux, macOS, or Unix\.
+  *Java 1\.8* 
+  *Eclipse IDE for Java Developers 4\.2 or later*– We attempt to keep the AWS Toolkit for Eclipse current with the default version available on the [Eclipse download page](https://eclipse.org/downloads/)\.
**Note**  
Eclipse provides a number of different downloads\. We recommend installing the *Eclipse IDE for Enterprise Java Developers*, which includes the [Eclipse Web Tools Platform](https://projects.eclipse.org/projects/webtools) required by Elastic Beanstalk, the [Eclipse Data Tools Platform](http://www.eclipse.org/datatools/) required for Amazon SimpleDB features, the [Eclipse EGit](http://www.eclipse.org/egit/), and the [M2Eclipse](http://www.eclipse.org/m2e/)\. If you install another version of Eclipse, make sure that you have \(or that you install, using the provided links\) support for these features\.
+  *\(Optional\) Google Android Development Tools \(ADT\)*– if you want AWS Toolkit for Eclipse support for the [AWS Mobile SDK for Android](https://aws.amazon.com/mobile/sdk/), you must [install the ADT](https://developer.android.com/studio/tools/sdk/eclipse-adt.html) first\.

## Install the AWS Toolkit for Eclipse<a name="install-tke"></a>

**To install the AWS Toolkit for Eclipse**

1. Within Eclipse, click **Help** and then click **Install New Software**\.

1. In the **Work with** box, type https://aws\.amazon\.com/eclipse and then press `Enter`\.

1. Choose the components of the AWS Toolkit for Eclipse that you want to install\. Click **Select All** to install all components at once\.
**Note**  
 *AWS Toolkit for Eclipse Core* \(in the *AWS Core Management Tools* section\) is **required**; all other components are optional\.
Support for the [AWS Mobile SDK for Android](https://aws.amazon.com/mobile/sdk/) *requires* that you have the Google Android Developer Tools \(ADT\) for Eclipse installed first\. If you have not yet installed the ADT, make sure that **AWS SDK for Android** is *unchecked*, or installation will fail\.
Support for the Amazon RDS or Amazon SimpleDB managers requires that the *Eclipse Data Tools Platform* \(DTP\) is installed\. The DTP is installed by default with the “Java EE Developers” version of Eclipse, or can be [installed separately](https://eclipse.org/datatools/downloads.php)\.

1. Once you have made your selections, click **Next** \(or **Finish**\) to complete installation\.

Once you have set up the AWS Toolkit for Eclipse you should [configure your AWS Credentials](setup-credentials.md)\.

**Note**  
Depending on the options selected, and on factors such as network speed, server latency and system capabilities, it may take up to 30 minutes for the installation to complete\.

## Upgrade the AWS Toolkit for Eclipse<a name="upgrade-the-tke"></a>

To upgrade or reinstall the AWS Toolkit for Eclipse, use the same instructions for [installing the toolkit](#install-tke)\.

Some versions of Eclipse, \(notably *Mars* and *Neon*\), may fail to fetch the latest artifacts due to a bug in old versions of the [Oomph plugin](https://projects.eclipse.org/projects/tools.oomph)\. To work around this issue:

1. Make sure that you’re using `https://aws.amazon.com/eclipse/site.xml` as the AWS Toolkit for Eclipse update site\.

1. Delete the `~/.eclipse/org.eclipse.oomph.p2/cache/` directory to remove cached content\.

1. Install the latest version of [Oomph \(Eclipse Installer\)](https://wiki.eclipse.org/Eclipse_Installer)\.
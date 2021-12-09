# Installing the Media for Microsoft SQL Server<a name="installing-media"></a>

If you are using Microsoft SQL Server, an on\-premises customer provided license is required\. In this case, make sure that you install your operating system media and database media before you create Amazon RDS DB instances\.

**Important**  
MySQL and PostgreSQL don't require you to install media\. If you plan to use one of these DB engines, you can move on to [Choosing the On\-Premises DB Instance Class](db-instance-class-on-premises.md)\.

## Supported Media<a name="installing-media.supported"></a>

Currently, the following media are supported:
+ **OS Installation Media**
  + Windows Server 2016 \(x64\) \- DVD \(English\)

    Released: 10/12/2016

    File name: en\_windows\_server\_2016\_x64\_dvd\_9327751\.iso
  + Windows Server 2016 \(Updated January 2017\) \(x64\) \- DVD \(English\)

    Released: 1/12/2017

    File name: en\_windows\_server\_2016\_x64\_dvd\_9718492\.iso
  + Windows Server 2016 \(Updated February 2018\) \(x64\) \- DVD \(English\)

    Released: 2/15/2018

    File name: en\_windows\_server\_2016\_updated\_feb\_2018\_x64\_dvd\_11636692\.iso

  For more information, see [ https://my\.visualstudio\.com/Downloads?q=windows%20server%202016](https://my.visualstudio.com/Downloads?q=windows%20server%202016)\.
+ **Engine Installation Media**
  + SQL Server 2016 Enterprise \(x64\) \- DVD \(English\)

    Released: 6/1/2016

    File name: en\_sql\_server\_2016\_enterprise\_x64\_dvd\_8701793\.iso
  + SQL Server 2016 Enterprise with Service Pack 1 \(x64\) \- DVD \(English\)

    Released: 11/16/2016

    File name: en\_sql\_server\_2016\_enterprise\_with\_service\_pack\_1\_x64\_dvd\_9542382\.iso
  + SQL Server 2016 Enterprise with Service Pack 2 \(x64\) \- DVD \(English\)

    Released: 5/22/2018

    File name: en\_sql\_server\_2016\_enterprise\_with\_service\_pack\_2\_x64\_dvd\_12124051\.iso

  For more information, see [ https://my\.visualstudio\.com/Downloads?q=sql%20server%202016](https://my.visualstudio.com/Downloads?q=sql%20server%202016)\.

## Install the Media<a name="installing-media.install"></a>

You can install the media using the AWS Management Console, the AWS CLI, or the RDS API\.

### Console<a name="installing-media.console"></a>

**To install media in a custom AZ**

1. Sign in to the AWS Management Console and open the Amazon RDS console at [https://console\.aws\.amazon\.com/rds/](https://console.aws.amazon.com/rds/)\.

1. In the top\-right corner of the console, choose the AWS Region that contains the custom AZ in which you want to create the DB instance\. 

1. In the navigation pane, choose **Custom AZs**\.

   The **Custom AZs** page appears\.  
![\[Custom AZs page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/custom-azs.png)

1. Choose the name of the custom AZ on which you want to install media to show the custom AZ details\.

   The details page for the custom AZ appears\.  
![\[Custom AZs page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/custom-az-details.png)

1. In the **Install media** section, choose **Import**\.

   The **Import media** page appears\.  
![\[Import media page\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/install-media.png)

1. In the **Engine options** section, choose the DB engine, the edition, and the version\.

1. In the **Importation settings** section, complete the settings:
   + **OS installation path** – The absolute path to the operating system media on your VMware cluster datastore
   + **Engine installation path** – The absolute path to the DB engine media on your VMware cluster datastore
**Important**  
The edition and version of the media referenced in the **Engine installation path** must match the DB engine edition and version that you chose in the previous step\.  
For information about supported media, see [Supported Media](#installing-media.supported)\.

   Both paths must be present on the same datastore that was specified in the Installer during onboarding\. Don't include the datastore name in the path\. The following are examples of valid paths:
   + **OS installation path** – `WindowsISO/en_windows_server_2016_x64_dvd_9327751.iso`
   + **Engine installation path** – `SQLServerISO/en_sql_server_2016_enterprise_x64_dvd_8701793.iso`

1. Choose **Import media**\.

   You can monitor the status of the import on the details page for the custom AZ\.  
![\[Media installation status\]](http://docs.aws.amazon.com/AmazonRDS/latest/RDSonVMwareUserGuide/images/custom-az-details-install-status.png)

### AWS CLI<a name="installing-media.cli"></a>

To install media by using the AWS CLI, call the [import\-installation\-media](https://docs.aws.amazon.com/cli/latest/reference/rds/import-installation-media.html) command with the options following\. All of the options are required\. 
+ `--custom-availability-zone-id` – The identifier of the custom Availability Zone \(AZ\) to import the installation media to
+ `--engine` – The name of the database engine to be used for this instance
+ `--engine-installation-media-path` – The absolute path to the DB engine media on your VMware cluster datastore
**Important**  
The edition and version of the media specified in the `--engine-installation-media-path` must match the DB engine edition and version specified in the `--engine` option\.  
The path must be present on the same datastore that was specified in the installer during onboarding\. Don't include the datastore name in the path\.
+ `--engine-version` – The version number of the database engine to use
+ `--os-installation-media-path` – The absolute path to the operating system media on your VMware cluster datastore
**Important**  
The path must be present on the same datastore that was specified in the installer during onboarding\. Do not include the datastore name in the path\.

For information about supported media, see [Supported Media](#installing-media.supported)\.

**Example**  
The following example imports the installation media for a `sqlserver-ee` engine\.  
For Linux, OS X, or Unix:  

```
1.      
2. aws rds import-installation-media \
3.     --custom-availability-zone-id mycustomaz_identifier \
4.     --engine sqlserver-ee \
5.     --engine-version 13.00.5292.0.v1 \
6.     --engine-installation-media-path SQLServerISO/en_sql_server_2016_enterprise_x64_dvd_8701793.iso \
7.     --os-installation-media-path WindowsISO/en_windows_server_2016_x64_dvd_9327751.iso
```
For Windows:  

```
1. aws rds import-installation-media ^
2.     --custom-availability-zone-id mycustomaz_identifier ^
3.     --engine sqlserver-ee ^
4.     --engine-version 13.00.5292.0.v1 ^
5.     --engine-installation-media-path SQLServerISO/en_sql_server_2016_enterprise_x64_dvd_8701793.iso ^
6.     --os-installation-media-path WindowsISO/en_windows_server_2016_x64_dvd_9327751.iso
```

Replace the placeholders with appropriate values\.

### RDS API<a name="installing-media.api"></a>

To install media by using the Amazon RDS API, call the [ImportInstallationMedia](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_ImportInstallationMedia.html) operation with the parameters following\. All of the parameters are required\. 
+ `CustomAvailabilityZoneId` – The identifier of the custom Availability Zone \(AZ\) to import the installation media to
+ `Engine` – The name of the database engine to be used for this instance
+ `EngineInstallationMediaPath` – The path to the installation media for the specified DB engine
+ `EngineVersion` – The version number of the database engine to use
+ `OSInstallationMediaPath` – The path to the installation media for the operating system associated with the specified DB engine

## Troubleshooting Media Installation Issues for Microsoft SQL Server<a name="installing-media.troubleshooting"></a>

Use the following sections to troubleshoot problems that you have with installing the media for Microsoft SQL Server\.

**Topics**
+ [Media Not Found](#installing-media.troubleshooting.media-not-found)
+ [Media Not Supported](#installing-media.troubleshooting.media-not-found)
+ [Custom AZ Disconnected](#installing-media.troubleshooting.custom-az-disconnected)

### Media Not Found<a name="installing-media.troubleshooting.media-not-found"></a>

In this case, the media wasn't found in the specified location, and the following errors can be returned\.

```
OS media not found at provided location                
Engine media not found at provided location
```

The cause for this issue is almost always one of the following:
+ The specified path for the media is incorrect\.
+ The datastore is included in the path\.
+ The media path isn't in the datastore that was specified during onboarding\.

To solve the issue, make sure that the path is correct and that the datastore isn't included in the path\. Also, make sure that the media is in the datastore that was specified in the installer during onboarding\.

For information about onboarding, see [Getting Started with Amazon RDS on VMware](getting-started-with-rds-on-vmware.md)\.

### Media Not Supported<a name="installing-media.troubleshooting.media-not-found"></a>

In this case, the specified media isn't supported by Amazon RDS on VMware, and the following errors can be returned:

```
OS media validation failed               
Engine media validation failed
```

To solve the issue, specify supported installation media\. For information about supported media, see [Supported Media](#installing-media.supported)\.

### Custom AZ Disconnected<a name="installing-media.troubleshooting.custom-az-disconnected"></a>

In this case, the custom AZ that you attempted to attach installation media to can't currently be reached\.

To solve the issue, see [Custom AZ Is Disconnected](troubleshooting-rds-on-vmware.md#troubleshooting-rds-on-vmware.disconnected)\.
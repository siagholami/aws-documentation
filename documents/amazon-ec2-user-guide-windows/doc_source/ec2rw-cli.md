# Using EC2Rescue for Windows Server with the command line<a name="ec2rw-cli"></a>

The EC2Rescue for Windows Server command line interface \(CLI\) allows you to run an EC2Rescue for Windows Server plugin \(referred as an "action"\) programmatically\.

The EC2Rescue for Windows Server tool has two execution modes:
+ **/online**—This allows you to take action on the instance that EC2Rescue for Windows Server is installed on, such as collect log files\.
+ **/offline:<device\_id>**—This allows you to take action on the offline root volume that is attached to a separate Amazon EC2 Windows instance, on which you have installed EC2Rescue for Windows Server\.

Download the [EC2Rescue for Windows Server](https://s3.amazonaws.com/ec2rescue/windows/EC2Rescue_latest.zip?x-download-source=docs) tool to your Windows instance and extract the files\. You can view the help file using the following command:

```
EC2RescueCmd.exe /help
```

EC2Rescue for Windows Server can perform the following actions on an Amazon EC2 Windows instance:
+ [Collect action](#ec2rw-collect)
+ [Rescue action](#ec2rw-rescue)
+ [Restore action](#ec2rw-restore)

## Collect action<a name="ec2rw-collect"></a>

EC2Rescue for Windows Server can collect the following data from active and offline instances\. You can collect all logs, an entire log group, or an individual log within a group\.


| Log group | Available logs | Description | 
| --- | --- | --- | 
| all |  | Collects all available logs\. | 
| system\-info | 'MSInfo32 Output' | Collects MSInfo32\. | 
| eventlog |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects application, system, and EC2Config event logs\. | 
| memory\-dump |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects any memory dump files that exist on the instance\. | 
| ec2config |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects log files generated by the EC2Config service\. | 
| ec2launch |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects log files generated by the EC2Launch scripts\. | 
| ssm\-agent | 'Log Files' | Collects log files generated by SSM Agent\. | 
| sysprep | 'Log Files' | Collects log files generated by the Windows System Preparation tool\. | 
| driver\-setup |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects Windows SetupAPI logs \(setupapi\.dev\.log and setupapi\.setup\.log\)\. | 
| registry |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects SYSTEM and SOFTWARE hives\. | 
| gpresult | 'GPResult Output' |  Collects a Group Policy report\.  | 
| egpu |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | Collects event logs related to elastic GPUs\. | 
| boot\-config | 'BCDEDIT Output' | Collects HKEY\_LOCAL\_MACHINE\\BCD00000000 hive\. | 
| windows\-update | 'Log Files' | Collects information about the updates that are installed on the instance\.  Windows Update logs are not captured on Windows Server 2016 instances\.  | 

The following are the available options:
+ **/output:<outputFilePath>** ‐ Required destination file path location to save collected log files in zip format\.
+ **/no\-offline** ‐ Optional attribute used in offline mode\. Does not set the volume offline after completing the action\.
+ **/no\-fix\-signature** ‐ Optional attribute used in offline mode\. Does not fix a possible disk signature collision after completing the action\.

### Examples<a name="ec2rw-collect-examples"></a>

The following are examples using the EC2Rescue for Windows Server CLI\.

#### Online mode examples<a name="ec2rw-collect-examples-online"></a>

Collect all available logs:

```
EC2RescueCmd /accepteula /online /collect:all /output:<outputFilePath>
```

Collect only a specific log group:

```
EC2RescueCmd /accepteula /online /collect:ec2config /output:<outputFilePath>
```

Collect individual logs within a log group:

```
EC2RescueCmd /accepteula /online /collect:'ec2config.Log Files,driver-setup.SetupAPI Log Files' /output:<outputFilePath>
```

#### Offline mode examples<a name="ec2rw-collect-examples-offline"></a>

Collect all available logs from an EBS volume\. The volume is specified by the device\_id value\.

```
EC2RescueCmd /accepteula /offline:xvdf /collect:all /output:<outputFilePath>
```

Collect only a specific log group:

```
EC2RescueCmd /accepteula /offline:xvdf /collect:ec2config /output:<outputFilePath>
```

## Rescue action<a name="ec2rw-rescue"></a>

EC2Rescue for Windows Server can detect and address issues with the following service settings:


|  Service group  | Available actions |  Description  | 
| --- | --- | --- | 
| all |  |  | 
| system\-time | 'RealTimeIsUniversal' | System Time[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html) | 
| firewall |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  |  Windows Firewall [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | 
| rdp |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  |  Remote Desktop [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | 
| ec2config |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  |  EC2Config [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | 
| ec2launch | 'Reset Administrator Password' | Generates a new Windows administrator password\. | 
| network | 'DHCP Service Startup' |  Network Interface [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/ec2rw-cli.html)  | 

The following are the available options:
+ **/level:<level>** ‐ Optional attribute for the check level that the action should trigger\. Allowed values are: `information`, `warning`, `error`, `all`\. By default, it is set to `error`\.
+ **/check\-only** ‐ Optional attribute that generates a report but makes no modifications to the offline volume\.
+ **/no\-offline** ‐ Optional attribute that prevents the volume from being set offline after completing the action\.
+ **/no\-fix\-signature** ‐ Optional attribute that does not fix a possible disk signature collision after completing the action\.

### Rescue examples<a name="ec2rw-rescue-examples"></a>

The following are examples using the EC2Rescue for Windows Server CLI\. The volume is specified using the device\_id value\.

Attempt to fix all identified issues on a volume:

```
EC2RescueCmd /accepteula /offline:xvdf /rescue:all
```

Attempt to fix all issues within a service group on a volume:

```
EC2RescueCmd /accepteula /offline:xvdf /rescue:firewall
```

Attempt to fix a specific item within a service group on a volume:

```
EC2RescueCmd /accepteula /offline:xvdf /rescue:rdp.'Service Start'
```

Specify multiple issues to attempt to fix on a volume:

```
EC2RescueCmd /accepteula /offline:xvdf /rescue:'system-time.RealTimeIsUniversal,ec2config.Service Start'
```

## Restore action<a name="ec2rw-restore"></a>

EC2Rescue for Windows Server can detect and address issues with the following service settings:


|  Service Group  | Available Actions |  Description  | 
| --- | --- | --- | 
|  Restore Last Known Good Configuration  | lkgc | Last Known Good Configuration ‐ Attempts to boot the instance into the last known bootable state\. | 
| Restore Windows registry from latest backup | regback | Restore registry from backup ‐ Restores the registry from \\Windows\\System32\\config\\RegBack\. | 

The following are the available options:
+ **/no\-offline**—Optional attribute that prevents the volume from being set offline after completing the action\.
+ **/no\-fix\-signature**—Optional attribute that does not fix a possible disk signature collision after completing the action\.

### Restore examples<a name="ec2rw-restore-examples"></a>

The following are examples using the EC2Rescue for Windows Server CLI\. The volume is specified using the device\_id value\.

Restore last known good configuration on a volume:

```
EC2RescueCmd /accepteula /offline:xvdf /restore:lkgc
```

Restore the last Windows registry backup on a volume:

```
EC2RescueCmd /accepteula /offline:xvdf /restore:regback
```
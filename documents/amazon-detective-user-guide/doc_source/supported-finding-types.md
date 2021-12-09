# Supported finding types<a name="supported-finding-types"></a>

Amazon Detective only ingests and provides profiles for the Amazon GuardDuty finding types that are listed below\. GuardDuty detects some of these findings from CloudTrail data, and some from VPC flow data\.

For a detailed description of each finding type, see the [list of finding types](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_finding-types-active.html) in the *Amazon GuardDuty User Guide*

## AWS CloudTrail\-based findings<a name="supported-findings-cloudtrail"></a>

These findings are detected using CloudTrail data:

`PenTest:IAMUser/KaliLinux`  
An API was invoked from a Kali Linux EC2 instance\.

`PenTest:IAMUser/ParrotLinux`  
An API was invoked from a Parrot Security Linux EC2 instance\.

`PenTest:IAMUser/PentooLinux`  
An API was invoked from a Pentoo Linux EC2 instance\.

`Persistence:IAMUser/NetworkPermissions`  
A principal invoked an API commonly used to change the network access permissions for security groups, routes, and ACLs in your AWS account\.

`Persistence:IAMUser/ResourcePermissions`  
A principal invoked an API commonly used to change the security access policies of various resources in your AWS account\.

`Persistence:IAMUser/UserPermissions`  
A principal invoked an API commonly used to add, modify, or delete IAM users, groups, or policies in your AWS account\.

`Policy:IAMUser/RootCredentialUsage`  
An API was invoked using root credentials\.

`Recon:IAMUser/MaliciousIPCaller`  
An API was invoked from a known malicious IP address\.

`Recon:IAMUser/MaliciousIPCaller.Custom`  
An API was invoked from an IP address on a custom threat list\.

`Recon:IAMUser/NetworkPermissions`  
A principal invoked an API commonly used to discover the network access permissions of existing security groups, ACLs, and routes in your AWS account\.

`Recon:IAMUser/ResourcePermissions`  
A principal invoked an API commonly used to discover the permissions associated with various resources in your AWS account\.

`Recon:IAMUser/TorIPCaller`  
An API was invoked from a Tor exit node IP address

`Recon:IAMUser/UserPermissions`  
A principal invoked an API commonly used to discover the users, groups, policies and permissions in your AWS account\.

`ResourceConsumption:IAMUser/ComputeResources`  
A principal invoked an API commonly used to launch compute resources such as EC2 instances\.

`Stealth:IAMUser/CloudTrailLoggingDisabled`  
AWS CloudTrail trail was disabled\.

`Stealth:IAMUser/LoggingConfigurationModified`  
A principal invoked an API commonly used to stop CloudTrail logging, delete existing logs, and otherwise eliminate traces of activity in your AWS account\.

`Stealth:IAMUser/PasswordPolicyChange`  
Account password policy was weakened\.

`UnauthorizedAccess:IAMUser/ConsoleLogin`  
An unusual console sign\-in by a principal in your AWS account was observed\.

`UnauthorizedAccess:IAMUser/ConsoleLoginSuccess.B`  
Multiple worldwide successful console sign\-ins were observed\.

`UnauthorizedAccess:IAMUser/InstanceCredentialExfiltration`  
Credentials that were created exclusively for an EC2 instance through an instance launch role are being used from an external IP address\.

`UnauthorizedAccess:IAMUser/MaliciousIPCaller`  
An API was invoked from a known malicious IP address\.

`UnauthorizedAccess:IAMUser/MaliciousIPCaller.Custom`  
EC2 instance is communicating outbound with an IP address that is on a custom threat list\.

`UnauthorizedAccess:IAMUser/TorIPCaller`  
EC2 instance is receiving inbound connections from a Tor exit node\.

## VPC flow\-based findings<a name="supported-findings-vpc"></a>

These findings are detected using VPC flow data:

`Backdoor:EC2/DenialOfService.Dns`  
An EC2 instance is behaving in a manner that may indicate it is being used to perform a Denial of Service \(DoS\) attack using the DNS protocol\.

`Backdoor:EC2/DenialOfService.Tcp`  
An EC2 instance is behaving in a manner that may indicate it is being used to perform a Denial of Service \(DoS\) attack using the TCP protocol\.

`Backdoor:EC2/DenialOfService.Udp`  
An EC2 instance is behaving in a manner that may indicate it is being used to perform a Denial of Service \(DoS\) attack using the UDP protocol\.

`Backdoor:EC2/DenialOfService.UdpOnTcpPorts`  
An EC2 instance is behaving in a manner that may indicate it is being used to perform a Denial of Service \(DoS\) attack using the UDP protocol on a TCP port\.

`Backdoor:EC2/DenialOfService.UnusualProtocol`  
An EC2 instance is behaving in a manner that may indicate it is being used to perform a Denial of Service \(DoS\) attack using an unusual protocol\.

`Backdoor:EC2/Spambot`  
EC2 instance is exhibiting unusual behavior by communicating with a remote host on port 25\.

`Behavior:EC2/NetworkPortUnusual`  
EC2 instance is communicating with a remote host on an unusual server port\.

`Behavior:EC2/TrafficVolumeUnusual`  
EC2 instance is generating unusually large amounts of network traffic to a remote host\.

`CryptoCurrency:EC2/BitcoinTool.B`  
EC2 instance is querying an IP address that is associated with cryptocurrency\-related activity\.

`Recon:EC2/PortProbeEMRUnprotectedPort`  
EC2 instance in an EMR cluster has an unprotected Amazon EMR\-related, sensitive port that is being probed by a known malicious host\.

`Recon:EC2/PortProbeUnprotectedPort`  
EC2 instance has an unprotected port that is being probed by a known malicious host\.

`Recon:EC2/Portscan`  
EC2 instance is performing outbound port scans to a remote host\.

`Trojan:EC2/BlackholeTraffic`  
EC2 instance is attempting to communicate with an IP address of a remote host that is a known black hole\.

`Trojan:EC2/DropPoint`  
An EC2 instance is attempting to communicate with an IP address of a remote host that is known to hold credentials and other stolen data captured by malware\.

`UnauthorizedAccess:EC2/MaliciousIPCaller.Custom`  
EC2 instance is communicating outbound with an IP address on a custom threat list\.

`UnauthorizedAccess:EC2/RDPBruteForce`  
EC2 instance has been involved in RDP brute force attacks\.

`UnauthorizedAccess:EC2/SSHBruteForce`  
EC2 instance has been involved in SSH brute force attacks\.

`UnauthorizedAccess:EC2/TorClient`  
EC2 instance is making connections to a Tor Guard or an Authority node\.

`UnauthorizedAccess:EC2/TorIPCaller`  
EC2 instance is receiving inbound connections from a Tor exit node\.

`UnauthorizedAccess:EC2/TorRelay`  
EC2 instance is making connections to a Tor network as a Tor relay\.
--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Supported Instance Metadata and User Data<a name="edge-compute-instance-metadata"></a>

*Instance metadata *is data about your instance that you can use to configure or manage the running instance\. Snowball Edge supports a subset of instance metadata categories for your compute instances\. For more information, see [Instance Metadata and User Data](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-metadata.html) in the *Amazon EC2 User Guide for Linux Instances\.*

The following categories are supported\. Using any other categories returns a `404` error message\.


**Supported Instance Metadata Categories on a Snowball Edge**  

| Data | Description | 
| --- | --- | 
|  ami\-id  | The AMI ID used to launch the instance\. | 
| hostname | The private IPv4 DNS hostname of the instance\. | 
|  instance\-id  | The ID of this instance\. | 
|  instance\-type  | The type of instance\. | 
|  local\-hostname  | The private IPv4 DNS hostname of the instance\. | 
|  local\-ipv4  | The private IPv4 address of the instance\. | 
|  mac  | The instance's media access control \(MAC\) address\. | 
|  network/interfaces/macs/mac/local\-hostname  | The interface's local hostname\. | 
|  network/interfaces/macs/mac/local\-ipv4s  | The private IPv4 addresses associated with the interface\. | 
|  network/interfaces/macs/mac/mac  | The instance's MAC address\. | 
|  network/interfaces/macs/mac/public\-ipv4s  | The Elastic IP addresses associated with the interface\. | 
|  public\-ipv4  | The public IPv4 address\. | 
|  public\-keys/0/openssh\-key  | Public key\. Only available if supplied at instance launch time\. | 
|  reservation\-id  | The ID of the reservation\. | 
| userData | Shell scripts to send instructions to an instance at launch\. | 


**Supported Instance Dynamic Data Categories on a Snowball Edge**  

| Data | Description | 
| --- | --- | 
| instance\-identity/document | JSON containing instance attributes\. Only instanceId, imageId, privateIp, and instanceType have values, and the other returned attributes are null\. For more information, see [Instance Identity Documents](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-identity-documents.html) in the Amazon EC2 User Guide for Linux Instances\. | 

## User Data in Snowball Compute Instances<a name="userdatasupport"></a>

User data is supported for use with shell scripts for compute instances on a Snowball Edge\. Using shell scripts, you can send instructions to an instance at launch\. You can change user data with the `modify-instance-attribute` AWS CLI command, or the `ModifyInstanceAttribute` API action\.

**To change user data**

1. Stop your compute instance with the `stop-instances` AWS CLI command\.

1. Using the `modify-instance-attribute` AWS CLI command, modify the `userData` attribute\.

1. Restart your compute instance with the `start-instances` AWS CLI command\.

Only shell scripts are supported with compute instances\. There is no support for `cloud-init` package directives on compute instances running on a Snowball Edge\. For more information about working with AWS CLI commands, see the *[AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/)\.* 
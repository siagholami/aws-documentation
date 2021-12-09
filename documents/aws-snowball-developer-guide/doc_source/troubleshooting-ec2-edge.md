--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Troubleshooting Compute Instances on Snowball Edge Devices<a name="troubleshooting-ec2-edge"></a>

Following, you can find troubleshooting tips for Snowball Edge jobs with compute instances\.

**Topics**
+ [Virtual Network Interface Has an IP Address of 0\.0\.0\.0](#troubleshoot-vnic-ipaddress)
+ [Snowball Edge Hangs When Launching a Large Compute Instance](#ec2-edge-launch-stopped)
+ [My Instance Has One Root Volume](#multiple-root-volume)
+ [Unprotected Private Key File Error](#pem-key-perms-ec2-edge)

## Virtual Network Interface Has an IP Address of 0\.0\.0\.0<a name="troubleshoot-vnic-ipaddress"></a>

This issue can occur if the physical network interface \(NIC\) you associated with your virtual network interface \(VNIC\) also has an IP address of 0\.0\.0\.0\. This effect can happen if the NIC wasn't configured with an IP address \(for instance, if you've just powered on the device\)\. It can also happen if you're using the wrong interface\. For example, you might be trying to get the IP address of the SFP\+ interface, but it's the RJ45 interface that's connected to your network\.

**Action to Take**  
If this occurs, you can do the following:
+ Create a new VNIC, associated with a NIC that has an IP address\. For more information, see [Network Configuration for Compute Instances](network-config-ec2-edge.md)\.
+ Update an existing VNIC\. For more information, see [Updating a Virtual Network Interface](using-ec2-edge-client.md#ec2-edge-update-vnic)\.

## Snowball Edge Hangs When Launching a Large Compute Instance<a name="ec2-edge-launch-stopped"></a>

It can appear that your Snowball Edge has stopped launching an instance\. This is generally not the case\. However, it can take an hour or more for the largest compute instances to launch\. You can check the status of your instances with the AWS CLI command `aws ec2 describe-instances` run against the HTTP or HTTPS Amazon EC2 endpoint on the Snowball Edge\.

## My Instance Has One Root Volume<a name="multiple-root-volume"></a>

Instances have one root volume by design\. All `sbe` instances have a single root volume\.

## Unprotected Private Key File Error<a name="pem-key-perms-ec2-edge"></a>

This error can occur if your \.pem file on your compute instance has insufficient read/write permissions\.

**Action to Take**  
You can resolve this by changing the permissions for the file with the following procedure:

1. Open a terminal and navigate to the location that you saved your \.pem file to\.

1. Enter the following command\.

   ```
   chmod 400 filename.pem
   ```
--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Snowball Client Commands for Compute Instances<a name="using-ec2-edge-client"></a>

The Snowball client is a standalone terminal application that you can run on your local server\. It enables you to perform some administrative tasks on your Snowball Edge device or cluster of devices\. For more information about how to use the Snowball client, including how to start and stop services with it, see [Using the Snowball Client](using-client.md)\.

Following, you can find information on the Snowball client commands that are specific to compute instances, including examples of use\.

For a list of Amazon EC2 commands you can use on your AWS Snowball Edge device, see [Supported AWS CLI Commands for Amazon EC2 on a Snowball Edge](using-ec2-endpoint.md#cli-support-ec2-edge)

## Creating a Launch Configuration to Autostart Amazon EC2 Instances<a name="ec2-edge-create-autostart-config"></a>

To automatically start Amazon EC2 compute instances on your AWS Snowball Edge device after it is unlocked, you can create a launch configuration\. To do so, use the `snowballEdge create-autostart-configuration` command, whose usage is shown following\. 

**Usage**

```
                snowballEdge create-autostart-configuration --physical-connector-type [SFP_PLUS or RJ45 or QSFP]
                                            --ip-address-assignment [DHCP or STATIC] 
                                            [--static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]]
                                            --launch-template-id
                                            [--launch-template-version]
```

## Updating a Launch Configuration to Autostart EC2 Instances<a name="ec2-edge-update-autostart-config"></a>

To update an existing launch configuration on your Snowball Edge, use the `snowballEdge update-autostart-configuration` command\. You can find its usage following\. To enable or disable a launch configuration, specify the `--enabled` parameter\.

**Usage**

```
                snowballEdge update-autostart-configuration --autostart-configuration-arn
                                            [--physical-connector-type [SFP_PLUS or RJ45 or QSFP]]
                                            [--ip-address-assignment [DHCP or STATIC]] 
                                            [--static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]]
                                            [--launch-template-id]
                                            [--launch-template-version]
                                            [--enabled]
```

## Deleting a Launch Configuration to Autostart EC2 Instances<a name="ec2-edge-delete-autostart-config"></a>

To delete a launch configuration that's no longer in use, use the `snowballEdge delete-autostart-configuration` command\. You can find its usage following\.

**Usage**

```
                snowballEdge delete-autostart-configuration --autostart-configuration-arn
```

## Listing Launch Configurations to Autostart EC2 Instances<a name="ec2-edge-describe-autostart-configs"></a>

To list the launch configurations that you have created on your Snowball Edge, use the `describe-autostart-configurations` command\. You can find its usage following\.

**Usage**

```
                snowballEdge describe-autostart-configurations
```

## Creating a Virtual Network Interface<a name="ec2-edge-create-vnic"></a>

To run a compute instance on your Snowball Edge or start the file interface on your Snowball Edge, you first create a virtual network interface \(VNIC\)\. Each Snowball Edge has three network interfaces \(NICs\), the physical network interface controllers for the device\. These are the RJ45, SFP, and QSFP ports on the back of the device\.

Each VNIC is based on a physical one, and you can have any number of VNICs associated with each NIC\. To create a virtual network interface, use the `snowballEdge create-virtual-network-interface` command\.

**Note**  
The `--static-ip-address-configuration` parameter is valid only when using the `STATIC` option for the `--ip-address-assignment` parameter\.

**Usage **

You can use this command in two ways: with the Snowball client configured, or without the Snowball client configured\. The following usage example shows the method with the Snowball client configured\.

```
snowballEdge create-virtual-network-interface --ip-address-assignment [DHCP or STATIC] --physical-network-interface-id [physical network interface id] --static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]
```

The following usage example shows the method without the Snowball client configured\.

```
snowballEdge create-virtual-network-interface --endpoint https://[ip address] --manifest-file /path/to/manifest --unlock-code [unlock code] --ip-address-assignment [DHCP or STATIC] --physical-network-interface-id [physical network interface id] --static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]
```

**Example Example: Creating VNICs \(Using DHCP\)**  

```
./snowballEdge create-virtual-network-interface --ip-address-assignment dhcp --physical-network-interface-id s.ni-8EXAMPLEaEXAMPLEd
{
  "VirtualNetworkInterface" : {
    "VirtualNetworkInterfaceArn" : "arn:aws:snowball-device:::interface/s.ni-8EXAMPLE8EXAMPLEf",
    "PhysicalNetworkInterfaceId" : "s.ni-8EXAMPLEaEXAMPLEd",
    "IpAddressAssignment" : "DHCP",
    "IpAddress" : "192.0.2.0",
    "Netmask" : "255.255.255.0",
    "DefaultGateway" : "192.0.2.1",
    "MacAddress" : "EX:AM:PL:E1:23:45"
  }
}
```

## Describing Your Virtual Network Interfaces<a name="ec2-edge-describe-vnic"></a>

To describe the VNICs that you previously created on your device, use the `snowballEdge describe-virtual-network-interfaces` command\. You can find its usage following\.

**Usage **

You can use this command in two ways: with the Snowball client configured, or without the Snowball client configured\. The following usage example shows the method with the Snowball client configured\.

```
snowballEdge describe-virtual-network-interfaces
```

The following usage example shows the method without the Snowball client configured\.

```
snowballEdge describe-virtual-network-interfaces --endpoint https://[ip address] --manifest-file /path/to/manifest --unlock-code [unlock code]
```

**Example Example: Describing VNICs**  

```
./snowballEdge describe-virtual-network-interfaces
[
  {
    "VirtualNetworkInterfaceArn" : "arn:aws:snowball-device:::interface/s.ni-8EXAMPLE8EXAMPLE8",
    "PhysicalNetworkInterfaceId" : "s.ni-8EXAMPLEaEXAMPLEd",
    "IpAddressAssignment" : "DHCP",
    "IpAddress" : "192.0.2.0",
    "Netmask" : "255.255.255.0",
    "DefaultGateway" : "192.0.2.1",
    "MacAddress" : "EX:AM:PL:E1:23:45"
  },{
    "VirtualNetworkInterfaceArn" : "arn:aws:snowball-device:::interface/s.ni-1EXAMPLE1EXAMPLE1",
    "PhysicalNetworkInterfaceId" : "s.ni-8EXAMPLEaEXAMPLEd",
    "IpAddressAssignment" : "DHCP",
    "IpAddress" : "192.0.2.2",
    "Netmask" : "255.255.255.0",
    "DefaultGateway" : "192.0.2.1",
    "MacAddress" : "12:34:5E:XA:MP:LE"
  }  
]
```

## Updating a Virtual Network Interface<a name="ec2-edge-update-vnic"></a>

After creating a virtual network interface \(VNIC\), you can update its configuration using the `snowballEdge update-virtual-network-interface` command\. After providing the Amazon Resource Name \(ARN\) for a particular VNIC, you provide values only for whatever elements you are updating\.

**Usage**

You can use this command in two ways: with the Snowball client configured, or without the Snowball client configured\. The following usage example shows the method with the Snowball client configured\.

```
snowballEdge update-virtual-network-interface --virtual-network-interface-arn [virtual network-interface-arn] --ip-address-assignment [DHCP or STATIC] --physical-network-interface-id [physical network interface id] --static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]
```

 The following usage example shows the method without the Snowball client configured\. 

```
snowballEdge update-virtual-network-interface --endpoint https://[ip address] --manifest-file /path/to/manifest --unlock-code [unlock code] --virtual-network-interface-arn [virtual network-interface-arn] --ip-address-assignment [DHCP or STATIC] --physical-network-interface-id [physical network interface id] --static-ip-address-configuration IpAddress=[IP address],NetMask=[Netmask]
```

**Example Example: Updating a VNIC \(Using DHCP\)**  

```
./snowballEdge update-virtual-network-interface --virtual-network-interface-arn arn:aws:snowball-device:::interface/s.ni-8EXAMPLEbEXAMPLEd --ip-address-assignment dhcp
```

## Deleting a Virtual Network Interface<a name="ec2-edge-delete-vnic"></a>

To delete a virtual network interface, you can use the` snowballEdge delete-virtual-network-interface` command\. 

**Usage**

You can use this command in two ways: with the Snowball client configured, or without the Snowball client configured\. The following usage example shows the method with the Snowball client configured\.

```
snowballEdge delete-virtual-network-interface --virtual-network-interface-arn [virtual network-interface-arn]
```

The following usage example shows the method without the Snowball client configured\.

```
snowballEdge delete-virtual-network-interface --endpoint https://[ip address] --manifest-file /path/to/manifest --unlock-code [unlock code] --virtual-network-interface-arn [virtual network-interface-arn]
```

**Example Example: Deleting a VNIC**  

```
./snowballEdge delete-virtual-network-interface --virtual-network-interface-arn arn:aws:snowball-device:::interface/s.ni-8EXAMPLEbEXAMPLEd
```
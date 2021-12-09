--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Network Configuration for Compute Instances<a name="network-config-ec2-edge"></a>

After you’ve launched your compute instances on a Snowball Edge device, you need to set up your network configuration for each instance\. Use the following procedure whenever you launch a new instance to give that instance a virtual network interface and IP address\.

1. Make sure there's power to your device and that one of your physical network interfaces, like the RJ45 port, are connected with an IP address\.

1. Get the IP address associated with the physical network interface that you're using on the Snowball Edge\. For more information, see [Connect to Your Local Network](getting-started-connect.md)\.

1. Configure your Snowball client\. For more information, see [Configuring a Profile for the Snowball Client](using-client-commands.md#client-configuration)\.

1. Unlock the device\. For more information, see [Unlocking Snowball Edge Devices](using-client-commands.md#setting-up-client)\.

1. Run the `snowballEdge describe-device` command to get the list of physical network interface IDs\.

1. Identify the ID for the physical network interface that you want to use, and make a note of it\.

1. Run the `snowballEdge create-virtual-network-interface` command\. The following examples show running this command with the two different IP address assignment methods, either `DHCP` or `STATIC`\. The `DHCP` method uses Dynamic Host Configuration Protocol \(DHCP\)\.

   ```
   snowballEdge create-virtual-network-interface \
   --physical-network-interface-id s.ni-abcd1234 \
   --ip-address-assignment DHCP
            
           //OR//
           
   snowballEdge create-virtual-network-interface \
   --physical-network-interface-id s.ni-abcd1234 \
   --ip-address-assignment STATIC \
   --static-ip-address-configuration IpAddress=192.0.2.0,Netmask=255.255.255.0
   ```

   The command returns a JSON structure that includes the IP address\. Make a note of that IP address for the `ec2 associate-address` AWS CLI command later in the process\.

   Anytime you need this IP address, you can use the `snowballEdge describe-virtual-network-interfaces` Snowball client command, or the `aws ec2 describe-addresses` AWS CLI command to get it\.

1. To deploy the Amazon EC2 instance on your Snowball Edge using the Amazon Machine Image \(AMI\) that you chose when you created your job, run these AWS CLI commands, replacing the red text with your own values: 

   1. To describe the AMI, run this command, replacing the red text with your Snowball Edge IP address: 

      ```
      aws ec2 describe-images --endpoint http://Snowball Edge physical IP address:8008
      ```

      After you run this command, the output provides image details about the AMI\. In this example, the image details for the AMI are `s.ami-12345678`\. Your AMI image details will be different\. 

   1. To deploy the EC2 intsance from the AMI described in the previous step, run the command shown below, replacing the red text with your values:

      ```
      aws ec2 run-instance --image-id s.ami-12345678 --instance-type sbe-c.large  --endpoint http://Snowball Edge physical IP address:8008
      ```

   1. To confirm the instance ID, run this command, replacing the red text with your Snowball Edge IP address:

      ```
      aws ec2 describe-instances --endpoint http:// Snowball Edge physical IP address:8008
      ```

   1. To describe the instance details, run this command, replacing your own intsance ID and Snowball Edge IP address\.
**Note**  
`s.i-01234567890123456` is an example instance ID\. Your instance ID will be different\.

      ```
      aws ec2 describe-instances --instance-id s.i-01234567890123456 --endpoint http://Snowball Edge physical IP address:8008
      ```

1. To associate your newly created IP address with the instance, use the following command, replacing the red text with your values:

   ```
   aws ec2 associate-address --public-ip 192.0.2.0 --instance-id s.i-01234567890123456 --endpoint Snowball Edge physical IP address:8008
   ```
# Download the Discovery Connector<a name="setting-up-agentless"></a>

**Download, Set Up, and Start Collecting Data**  
To set up agentless discovery, you must download and deploy the Discovery Connector, which is a virtual appliance, on a VMware vCenter Server host in your on\-premises environment\. The Discovery Connector is an Open Virtualization Archive \(OVA\) file that you must install in your on\-premises VMware environment\.

**Reminder**  
Discovery Connector supports VMware vCenter versions V5\.5, V6, and V6\.5\.

Beginning with this section and those that follow on this page, you will be instructed how to download, deploy, configure, and start collecting data using the Discovery Connector\.

**To download the Discovery Connector OVA file and verify its checksum\.**

1. Sign in to vCenter as a VMware administrator and switch to the directory where you want to download the Discovery Connector OVA file\.

1. Download the [Discovery Connector OVA](https://s3.us-west-2.amazonaws.com/aws.agentless.discovery.connector.bundle/latest/AWSDiscoveryConnector.ova)\.

1. Depending on which hashing algorithm you use in your system environment, download either the [MD5](https://s3.us-west-2.amazonaws.com/aws.agentless.discovery.connector.bundle/latest/AWSDiscoveryConnector.ova.md5) or [SHA256](https://s3.us-west-2.amazonaws.com/aws.agentless.discovery.connector.bundle/latest/AWSDiscoveryConnector.ova.sha256) to get the file containing the checksum value\. Use this value to verify the `AWSDiscoveryConnector.ova` file downloaded in the preceding step\.

1. Depending on your variation of Linux, run the version appropriate MD5 command or SHA256 command to verify that the cryptographic signature of the `AWSDiscoveryConnector.ova` file matches the value in the respective MD5/SHA256 file that you downloaded\. 

   ```
   $ md5sum AWSDiscoveryConnector.ova
   ```

   ```
   $ sha256sum AWSDiscoveryConnector.ova
   ```
# Components<a name="launch-wizard-sap-components"></a>

An SAP application deployed with Launch Wizard includes the following components\.

**SAP applications:**
+ **SAP HANA Database** supports the following:
  + single instance deployment 
  + distributed instance deployment in a single Availability Zone
  + cross\-Availability Zone, high\-availability deployment
+ **SAP applications based on Netweaver on SAP HANA database** supports the following:
  + single instance deployment
  + distributed instance deployment
  + cross\-Availability Zone, high\-availability deployment

**Security groups**  
Launch Wizard creates optional security groups to ensure that all of the systems sharing the same configuration template can communicate with each other and with systems and end users who access the SAP systems from an IP CIDR range, an external IP address, or security groups\. For more information about how Launch Wizard creates security groups and how they are configured, see [Security groups in AWS Launch Wizard](launch-wizard-sap-security-groups.md)\.

**SAP transport group configuration**  
You can create an SAP transport file system, or attach an existing transport file system that was created as part of a previous deployment with AWS Launch Wizard\. Transport file systems are created with Amazon Elastic File System\. For more information, see [Amazon Elastic File System setup for transport directory](how-launch-wizard-sap-works.md#launch-wizard-sap-efs)\. 
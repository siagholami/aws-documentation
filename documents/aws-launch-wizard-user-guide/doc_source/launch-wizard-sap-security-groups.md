# Security groups in AWS Launch Wizard<a name="launch-wizard-sap-security-groups"></a>

**Topics**
+ [Security groups](#launchwizard-sap-security-groups-configuration)
+ [Connectivity to external systems and users](#launchwizard-sap-security-groups-connectivity)

## Security groups<a name="launchwizard-sap-security-groups-configuration"></a>

A security group acts as a virtual firewall that controls the traffic for one or more instances\. When you allow Launch Wizard to create security groups, it creates a set of security groups and assigns them to the SAP database and application instances to allow for inbound traffic\. Security groups use the following naming conventions:
+ `<Infrastructure_Configuration_Name>_App_SecurityGroup`
+ `<Infrastructure_Configuration_Name>_DB_SecurityGroup`

**<Infrastructure\_Configuration\_Name>\_App\_SecurityGroup**  
`<Infrastructure_Configuration_Name>_App_SecurityGroup` is configured as follows to allow inbound access to the database servers\.


| Source | Protocol | Port Range | 
| --- | --- | --- | 
| All instances attached to this security group | all |  | 
| All instances attached to the DB security group |  TCP  | 1\-65535 | 

This configuration allows:
+ inbound communication on all TCP ports from all of the SAP application servers deployed using the same configuration name 
+ inbound communication on all TCP ports from all of the database servers deployed using the same configuration name\. 

**<Infrastructure\_Configuration\_Name >\_DB\_SecurityGroup**  
`<Infrastructure_Configuration_Name>_DB_SecurityGroup` is configured as follows to allow inbound access to the database servers\.


| Source | Protocol | Port Range | 
| --- | --- | --- | 
| All instances attached to this security group | all |  | 
| All instances attached to the App security group |  TCP  | 1\-65535 | 
| All instances attached to the App security group | UDP | 111 | 
| All instances attached to the App security group | UDP | 2049 | 
| All instances attached to the App security group | UDP | 4000\-4002 | 

This configuration allows:
+ inbound communication on all TCP ports from all of the SAP database servers deployed using the same configuration name\.
+ inbound communication on all TCP ports from all of the SAP application servers deployed using the same configuration name\.
+ inbound communication on UDP 111,2049 and 4000 to 4002 from all the SAP application servers deployed using the same configuration name\.

## Connectivity to external systems and users<a name="launchwizard-sap-security-groups-connectivity"></a>

CIDR/IP address and security group entries are entered in the infrastructure configuration\. This allows access to SAP systems by front end users and upstream/downstream systems that are running in that CIDR block, or by end users \(IP address\) or systems assigned to those security groups\. Port ranges are included in the rule definition that allow inbound access so that you can reuse the infrastructure configuration and deploy SAP systems with an instance number 00 to 99\. Each entry in the outbound and inbound communication rules for a database security group, created either by the service or provided by the user, are updated as follows\. 


| Source | Protocol | Port Range | 
| --- | --- | --- | 
| Input |  TCP  | 22 | 
| Input |  TCP  | 1128 \- 1129 | 
| Input |  TCP  | 4300 \- 4399 | 
| Input |  TCP  | 8000 \- 8099 | 
| Input |  TCP  | 8443 | 
| Input |  TCP  | 30013 \- 39913 | 
| Input |  TCP  | 30015 \- 39915 | 
| Input |  TCP  | 30017 \- 39917 | 
| Input |  TCP  | 30041 \- 39941 | 
| Input |  TCP  | 30044 \- 39944 | 
| Input |  TCP  | 50013 \- 59914 | 

Each entry in the outbound and inbound communication rules for the application security group, created either by the service or by the user, are updated as follows\.


| Source | Protocol | Port Range | 
| --- | --- | --- | 
| Input |  TCP  | 22 | 
| Input |  TCP  | 3200 \- 3399 | 
| Input |  TCP  | 8080 | 
| Input |  TCP  | 8443 | 
| Input |  TCP  | 3600\-3699 | 
| Input | TCP  | 4237 | 

**Note**  
When the deployment is complete, you can update the security group information by adjusting the port range and source information\.

**Note**  
Launch Wizard considers a security group that it created as a shared resource\. It does not delete the security group if you delete a deployment or if a deployment is rolled back\. 
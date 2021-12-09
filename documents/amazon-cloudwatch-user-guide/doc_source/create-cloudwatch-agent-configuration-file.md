# Create the CloudWatch Agent Configuration File<a name="create-cloudwatch-agent-configuration-file"></a>

Before running the CloudWatch agent on any servers, you must create a CloudWatch agent configuration file\. 

The agent configuration file is a JSON file that specifies the metrics and logs that the agent is to collect, including custom metrics\. You can create it by using the wizard or by creating it yourself from scratch\. You could also use the wizard to initially create the configuration file and then modify it manually\. If you create or modify the file manually, the process is more complex, but you have more control over the metrics collected and can specify metrics not available through the wizard\.

Any time you change the agent configuration file, you must then restart the agent to have the changes take effect\.

After you have created a configuration file, you can save it manually as a JSON file and then use this file when installing the agent on your servers\. Alternatively, you can store it in Systems Manager Parameter Store if you're going to use Systems Manager when you install the agent on servers\.

**Topics**
+ [Create the CloudWatch Agent Configuration File with the Wizard](create-cloudwatch-agent-configuration-file-wizard.md)
+ [Manually Create or Edit the CloudWatch Agent Configuration File](CloudWatch-Agent-Configuration-File-Details.md)
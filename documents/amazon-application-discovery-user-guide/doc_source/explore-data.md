# Data Exploration in Amazon Athena<a name="explore-data"></a>

Data Exploration in Amazon Athena allows you to analyze the data collected from all the discovered on\-premises servers by Discovery Agents in one place\. Once Data Exploration in Amazon Athena is enabled from the Migration Hub console \(or by using the StartContinousExport API\) and the data collection for agents is turned on, data collected by agents will automatically get stored in your S3 bucket at regular intervals\.

You can then visit Amazon Athena to run pre\-defined queries to analyze the time\-series system performance for each server, the type of processes that are running on each server and the network dependencies between different servers\. In addition, you can write your own custom queries using Amazon Athena, upload additional existing data sources such as configuration management database \(CMDB\) exports, and associate the discovered servers with the actual business applications\. You can also integrate the Athena database with Amazon QuickSight to visualize the query outputs and perform additional analysis

**Steps**

1. [Enabling Data Exploration in Amazon Athena](ce-prep-agents.md)

1. [Working with Data Exploration in Amazon Athena](working-with-data-athena.md)
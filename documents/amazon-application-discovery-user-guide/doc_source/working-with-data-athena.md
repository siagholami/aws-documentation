# Working with Data Exploration in Amazon Athena<a name="working-with-data-athena"></a>

After you enable Data Exploration in Amazon Athena, you can begin exploring and working with detailed current data that was discovered by your agents by querying the data directly in Athena\. You can use the data to generate spreadsheets, run a cost analysis, port the query to a visualization program to diagram network dependencies, and more\.

The topics in this section describe the ways that you can work with your data in Athena to assess and plan for migrating your local environment to AWS\.

**Topics**
+ [Exploring Data Directly in Amazon Athena](#explore-direct-in-ate)
+ [Visualizing Amazon Athena Data](#port-query-to-visualization)
+ [Predefined Queries to use in Athena](#predefined-queries)

## Exploring Data Directly in Amazon Athena<a name="explore-direct-in-ate"></a>

These instructions guide you to all your agent data directly in the Athena console\. If you don’t have any data in Athena or have not enabled Data Exploration in Amazon Athena, you will be prompted by a dialog box to enable Data Exploration in Amazon Athena, as explained in [Enabling Data Exploration in Amazon Athena](ce-prep-agents.md)\.

**To explore agent\-discovered data directly in Athena**

1. In the AWS Migration Hub console, choose **Servers** in the navigation pane\.

1. To open the Amazon Athena console, choose **Explore data in Amazon Athena**\. 

1. On the **Query Editor** page, in the navigation pane under **Database**, make sure that **application\_discovery\_service\_database** is selected\.
**Note**  
Under **Tables** the following tables represent the datasets grouped by the agents\.  
**os\_info\_agent**
**network\_interface\_agent**
**sys\_performance\_agent**
**processes\_agent**
**inbound\_connection\_agent**
**outbound\_connection\_agent**
**id\_mapping\_agent**

1. Query the data in the Amazon Athena console by writing and running SQL queries in the Athena Query Editor\. For example, you can use the following query to see all of the discovered server IP addresses\. 

   ```
   SELECT * FROM network_interface_agent;
   ```

   For more example queries, see [Predefined Queries to use in Athena](#predefined-queries)\.

## Visualizing Amazon Athena Data<a name="port-query-to-visualization"></a>

To visualize your data, a query can be ported to a visualization program such as Amazon QuickSight or other open\-source visualization tools such as Cytoscape, yEd, or Gelphi\. Use these tools to render network diagrams, summary charts, and other graphical representations\. When this method is used, you connect to Athena through the visualization program so that it can access your collected data as a source to produce the visualization\.

**To visualize your Amazon Athena data using Amazon QuickSight**

1. Sign in to [Amazon QuickSight](http://aws.amazon.com/quicksight/)\.

1. Choose **Connect to another data source or upload a file**\.

1. Choose **Athena**\. The **New Athena data source** dialog box displays\.

1. Enter a name in the **Data source name** field\.

1. Choose **Create data source**\.

1. Select the **Agents\-servers\-os** table in the **Choose your table** dialog box and choose **Select**\.

1. In the **Finish dataset creation** dialog box, select **Import to SPICE for quicker analytics**, and choose **Visualize**\.

   Your visualization is rendered\.

## Predefined Queries to use in Athena<a name="predefined-queries"></a>

This section contains a set of predefined queries that perform typical use cases, such as TCO analysis and network visualization\. You can use these queries as is or modify them to suit your needs\.

**To use a predefined query**

1. In the AWS Migration Hub console, choose **Servers** in the navigation pane\.

1. To open the Amazon Athena console, choose **Explore data in Amazon Athena**\. 

1. On the **Query Editor** page, in the navigation pane under **Database**, make sure that **application\_discovery\_service\_database** is selected\.

1. Choose the plus \(**\+**\) sign in the Query Editor to create a tab for a new query\.

1. Copy one of the queries from [Predefined Queries](#pq-query-examples)\.

1. Paste the query into the query pane of the new query tab you just created\.

1. Choose **Run Query**\.

### Predefined Queries<a name="pq-query-examples"></a>

Choose a title to see information about the query\.

#### Obtain IP Addresses and Hostnames for Servers<a name="pq-helper-function"></a>

This view helper function retrieves IP addresses and hostnames for a given server\. You can use this view in other queries\. For information about how to create a view, see [CREATE VIEW](https://docs.aws.amazon.com/athena/latest/ug/create-view.html) in the *Amazon Athena User Guide*\.

```
CREATE OR REPLACE VIEW hostname_ip_helper AS 
SELECT DISTINCT
  "os"."host_name"
, "nic"."agent_id"
, "nic"."ip_address"
FROM
  os_info_agent os
, network_interface_agent nic
WHERE ("os"."agent_id" = "nic"."agent_id");
```

#### Identify Servers With or Without Agents<a name="pq-agents-installed-or-not"></a>

This query can help you perform data validation\. If you've deployed agents on a number of servers in your network, you can use this query to understand if there are other servers in your network without agents deployed on them\. In this query, we look into the inbound and outbound network traffic, and filter the traffic for private IP addresses only\. That is, IP addresses starting with `192`, `10`, or `172`\.

```
SELECT DISTINCT "destination_ip" "IP Address" ,
         (CASE
    WHEN (
    (SELECT "count"(*)
    FROM network_interface_agent
    WHERE ("ip_address" = "destination_ip") ) = 0) THEN
        'no'
        WHEN (
        (SELECT "count"(*)
        FROM network_interface_agent
        WHERE ("ip_address" = "destination_ip") ) > 0) THEN
            'yes' END) "agent_running"
    FROM outbound_connection_agent
WHERE ((("destination_ip" LIKE '192.%')
        OR ("destination_ip" LIKE '10.%'))
        OR ("destination_ip" LIKE '172.%'))
UNION
SELECT DISTINCT "source_ip" "IP ADDRESS" ,
         (CASE
    WHEN (
    (SELECT "count"(*)
    FROM network_interface_agent
    WHERE ("ip_address" = "source_ip") ) = 0) THEN
        'no'
        WHEN (
        (SELECT "count"(*)
        FROM network_interface_agent
        WHERE ("ip_address" = "source_ip") ) > 0) THEN
            'yes' END) "agent_running"
    FROM inbound_connection_agent
WHERE ((("source_ip" LIKE '192.%')
        OR ("source_ip" LIKE '10.%'))
        OR ("source_ip" LIKE '172.%'));
```

#### Analyze System Performance Data for Servers With Agents<a name="pq-agents-server-performance"></a>

You can use this query to analyze system performance and utilization pattern data for your on\-premises servers that have agents installed on them\. The query combines the `system_performance_agent` table with the `os_info_agent` table to identify the hostname for each server\. This query returns the time series utilization data \(in 15 minute intervals\) for all the servers where agents are running\.

```
SELECT "OS"."os_name" "OS Name" ,
    "OS"."os_version" "OS Version" ,
    "OS"."host_name" "Host Name" ,
     "SP"."agent_id" ,
     "SP"."total_num_cores" "Number of Cores" ,
     "SP"."total_num_cpus" "Number of CPU" ,
     "SP"."total_cpu_usage_pct" "CPU Percentage" ,
     "SP"."total_disk_size_in_gb" "Total Storage (GB)" ,
     "SP"."total_disk_free_size_in_gb" "Free Storage (GB)" ,
     ("SP"."total_disk_size_in_gb" - "SP"."total_disk_free_size_in_gb") "Used Storage" ,
     "SP"."total_ram_in_mb" "Total RAM (MB)" ,
     ("SP"."total_ram_in_mb" - "SP"."free_ram_in_mb") "Used RAM (MB)" ,
     "SP"."free_ram_in_mb" "Free RAM (MB)" ,
     "SP"."total_disk_read_ops_per_sec" "Disk Read IOPS" ,
     "SP"."total_disk_bytes_written_per_sec_in_kbps" "Disk Write IOPS" ,
     "SP"."total_network_bytes_read_per_sec_in_kbps" "Network Reads (kbps)" ,
     "SP"."total_network_bytes_written_per_sec_in_kbps" "Network Write (kbps)"
FROM "sys_performance_agent" "SP" , "OS_INFO_agent" "OS"
WHERE ("SP"."agent_id" = "OS"."agent_id") limit 10;
```

#### Track Outbound Communication Between Servers Based On Port Number and Process Details<a name="pq-analyze-outbound-connections"></a>

This query gets the details on the outbound traffic for each service, along with the port number and process details\. 

Before running the query, if you have not already done so, you must create the `iana_service_ports_import` table that contains the IANA port registry database downloaded from IANA\. For information about how to create this table, see [Creating the IANA Port Registry Import Table](#pq-create-iana-import-table)\.

After the `iana_service_ports_import` table is created, create two view helper functions for tracking outbound traffic\. For information about how to create a view, see [CREATE VIEW](https://docs.aws.amazon.com/athena/latest/ug/create-view.html) in the *Amazon Athena User Guide*\. 

**To create outbound tracking helper functions**

1. Open the Athena console at [https://console\.aws\.amazon\.com/athena/](https://console.aws.amazon.com/athena/home)\.

1. Create the `valid_outbound_ips_helper` view, using the following helper function that lists all distinct outbound source IP addresses\.

   ```
   CREATE OR REPLACE VIEW valid_outbound_ips_helper AS 
   SELECT DISTINCT "source_ip"
   FROM
     outbound_connection_agent;
   ```

1. Create the `outbound_query_helper` view, using the following helper function that determines the frequency of communication for outbound traffic\.

   ```
   CREATE OR REPLACE VIEW outbound_query_helper AS 
   SELECT
     "agent_id"
   , "source_ip"
   , "destination_ip"
   , "destination_port"
   , "agent_assigned_process_id"
   , "count"(*) "frequency"
   FROM
     outbound_connection_agent
   WHERE (("ip_version" = 'IPv4') AND ("destination_ip" IN (SELECT *
   FROM
     valid_outbound_ips_helper
   )))
   GROUP BY "agent_id", "source_ip", "destination_ip", "destination_port", "agent_assigned_process_id";
   ```

1. After you create the `iana_service_ports_import` table and your two helper functions, you can run the following query to get the details on the outbound traffic for each service, along with the port number and process details\.

   ```
   SELECT DISTINCT
     "hin1"."host_name" "Source Host Name"
   , "hin2"."host_name" "Destination Host Name"
   , "o"."source_ip" "Source IP Address"
   , "o"."destination_ip" "Destination IP Address"
   , "o"."frequency" "Connection Frequency"
   , "o"."destination_port" "Destination Communication Port"
   , "p"."name" "Process Name"
   , "ianap"."servicename" "Process Service Name"
   , "ianap"."description" "Process Service Description"
   FROM
     outbound_query_helper o
   , hostname_ip_helper hin1
   , hostname_ip_helper hin2
   , processes_agent p
   , iana_service_ports_import ianap
   WHERE ((((("o"."source_ip" = "hin1"."ip_address") AND ("o"."destination_ip" = "hin2"."ip_address")) AND ("p"."agent_assigned_process_id" = "o"."agent_assigned_process_id")) AND ("hin1"."host_name" <> "hin2"."host_name")) AND (("o"."destination_port" = TRY_CAST("ianap"."portnumber" AS integer)) AND ("ianap"."transportprotocol" = 'tcp')))
   ORDER BY "hin1"."host_name" ASC, "o"."frequency" DESC;
   ```

#### Track Inbound Communication Between Servers Based On Port Number and Process Details<a name="pq-analyze-inbound-connections"></a>

This query gets information about inbound traffic for each service, along with the port number and process details\.

Before running this query, if you have not already done so, you must create the `iana_service_ports_import` table that contains the IANA port registry database downloaded from IANA\. For information about how to create this table, see [Creating the IANA Port Registry Import Table](#pq-create-iana-import-table)\.

After the `iana_service_ports_import` table is created, create two view helper functions for tracking inbound traffic\. For information about how to create a view, see [CREATE VIEW](https://docs.aws.amazon.com/athena/latest/ug/create-view.html) in the *Amazon Athena User Guide*\. 

**To create import tracking helper functions**

1. Open the Athena console at [https://console\.aws\.amazon\.com/athena/](https://console.aws.amazon.com/athena/home)\.

1. Create the `valid_inbound_ips_helper` view, using the following helper function that lists all distinct inbound source IP addresses\.

   ```
   CREATE OR REPLACE VIEW valid_inbound_ips_helper AS 
   SELECT DISTINCT "source_ip"
   FROM
     inbound_connection_agent;
   ```

1. Create the `inbound_query_helper` view, using the following helper function that determines the frequency of communication for inbound traffic\.

   ```
   CREATE OR REPLACE VIEW inbound_query_helper AS 
   SELECT
     "agent_id"
   , "source_ip"
   , "destination_ip"
   , "destination_port"
   , "agent_assigned_process_id"
   , "count"(*) "frequency"
   FROM
     inbound_connection_agent
   WHERE (("ip_version" = 'IPv4') AND ("source_ip" IN (SELECT *
   FROM
     valid_inbound_ips_helper
   )))
   GROUP BY "agent_id", "source_ip", "destination_ip", "destination_port", "agent_assigned_process_id";
   ```

1. After you create the `iana_service_ports_import` table and your two helper functions, you can run the following query to get the details on the inbound traffic for each service, along with the port number and process details\.

   ```
   SELECT DISTINCT
     "hin1"."host_name" "Source Host Name"
   , "hin2"."host_name" "Destination Host Name"
   , "i"."source_ip" "Source IP Address"
   , "i"."destination_ip" "Destination IP Address"
   , "i"."frequency" "Connection Frequency"
   , "i"."destination_port" "Destination Communication Port"
   , "p"."name" "Process Name"
   , "ianap"."servicename" "Process Service Name"
   , "ianap"."description" "Process Service Description"
   FROM
     inbound_query_helper i
   , hostname_ip_helper hin1
   , hostname_ip_helper hin2
   , processes_agent p
   , iana_service_ports_import ianap
   WHERE ((((("i"."source_ip" = "hin1"."ip_address") AND ("i"."destination_ip" = "hin2"."ip_address")) AND ("p"."agent_assigned_process_id" = "i"."agent_assigned_process_id")) AND ("hin1"."host_name" <> "hin2"."host_name")) AND (("i"."destination_port" = TRY_CAST("ianap"."portnumber" AS integer)) AND ("ianap"."transportprotocol" = 'tcp')))
   ORDER BY "hin1"."host_name" ASC, "i"."frequency" DESC;
   ```

#### Identify Running Software From Port Number<a name="pq-identify-software"></a>

This query identifies the running software based on port numbers\.

Before running this query, if you have not already done so, you must create the `iana_service_ports_import` table that contains the IANA port registry database downloaded from IANA\. For information about how to create this table, see [Creating the IANA Port Registry Import Table](#pq-create-iana-import-table)\.

Run the following query to identify the running software based on port numbers\.

```
SELECT DISTINCT
  "o"."host_name" "Host Name"
, "ianap"."servicename" "Service"
, "ianap"."description" "Description"
, "con"."destination_port"
, "count"("con"."destination_port") "Destination Port Count"
FROM
  inbound_connection_agent con
, os_info_agent o
, iana_service_ports_import ianap
, network_interface_agent ni
WHERE ((((("con"."destination_ip" = "ni"."ip_address") AND (NOT ("con"."destination_ip" LIKE '172%'))) AND (("con"."destination_port" = "ianap"."portnumber") AND ("ianap"."transportprotocol" = 'tcp'))) AND ("con"."agent_id" = "o"."agent_id")) AND ("o"."agent_id" = "ni"."agent_id"))
GROUP BY "o"."host_name", "ianap"."servicename", "ianap"."description", "con"."destination_port"
ORDER BY "Destination Port Count" DESC;
```

### Creating the IANA Port Registry Import Table<a name="pq-create-iana-import-table"></a>

Some of the predefined queries require a table named `iana_service_ports_import` that contains information downloaded from Internet Assigned Numbers Authority \(IANA\)\.

**To create the iana\_service\_ports\_import table**

1. Download the IANA port registry database **CSV** file from [Service Name and Transport Protocol Port Number Registry](https://www.iana.org/assignments/service-names-port-numbers/service-names-port-numbers.xhtml) on *iana\.org*\.

1. Upload the file to Amazon S3\. For more information, see [How Do I Upload Files and Folders to an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/upload-objects.html)\.

1. Create a new table in Athena named `iana_service_ports_import`\. For instructions, see [Create a Table](https://docs.aws.amazon.com/athena/latest/ug/getting-started.html#step-2-create-a-table) in the *Amazon Athena User Guide*\. In the following example, you need to replace `my_bucket_name` with the name of the S3 bucket that you uploaded the CSV file to in the previous step\.

   ```
   CREATE EXTERNAL TABLE IF NOT EXISTS iana_service_ports_import (
   ServiceName STRING,
   PortNumber INT,
   TransportProtocol STRING,
   Description STRING,
   Assignee STRING,
   Contact STRING,
   RegistrationDate STRING,
   ModificationDate STRING,
   Reference STRING,
   ServiceCode STRING,
   UnauthorizedUseReported STRING,
   AssignmentNotes STRING)
   ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
   WITH SERDEPROPERTIES (
     'serialization.format' = ',',
     'quoteChar' = '"',
     'field.delim' = ','
   ) LOCATION 's3://my_bucket_name/'
   TBLPROPERTIES ('has_encrypted_data'='false',"skip.header.line.count"="1");
   ```
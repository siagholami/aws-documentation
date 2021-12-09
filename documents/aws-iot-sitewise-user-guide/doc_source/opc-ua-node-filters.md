# Using OPC\-UA node filters<a name="opc-ua-node-filters"></a>

When you define OPC\-UA data sources for an AWS IoT SiteWise gateway, you can define node filters\. Node filters let you limit which data stream paths the gateway sends to the cloud\. You can use node filters to reduce your gateway's startup time and CPU usage by only including paths to data that you model in AWS IoT SiteWise\. By default, gateways upload all OPC\-UA paths except those that start with `/Server/`\. You can use the `*` and `**` wildcard characters in your node filters to include multiple data stream paths with one filter\. To learn how to set up OPC\-UA sources for your gateway, see [Configuring data sources](configure-sources.md)\.

**Note**  
AWS IoT SiteWise restarts your gateway each time you add or edit a source\. Your gateway won't ingest data while it's restarting\. The time to restart your gateway depends on the number of OPC\-UA tags on your gateway's OPC\-UA sources\. Restart time can range from a few seconds \(for a gateway with few tags\) to several minutes \(for a gateway with many tags\)\.

The following table lists the wildcards that you can use to filter OPC\-UA data sources\.


**OPC\-UA node filter wildcards**  

| Wildcard | Description | 
| --- | --- | 
| \* | Matches a single level in a data stream path\. | 
| \*\* | Matches multiple levels in a data stream path\. | 

**Note**  
If you configure a source with a broad filter and then later change the source to use a more restrictive filter, AWS IoT SiteWise stops storing data that doesn't match the new filter\.

**Example scenario using node filters**  
Consider the following hypothetical data streams:  
+ `/WA/Factory 1/Line 1/PCL1`
+ `/WA/Factory 1/Line 1/PCL2`
+ `/WA/Factory 1/Line 2/Counter1`
+ `/WA/Factory 1/Line 2/PCL1`
+ `/OR/Factory 1/Line 1/PCL1`
+ `/OR/Factory 1/Line 2/Counter2`
Using the previous data streams, you can define node filters to limit what data to include from your OPC\-UA source\.  

1. To select all nodes in the state of Washington, use `/WA/`\.

1. To select all `PCL` data streams, use `/*/*/*/PCL*` or `/**/PCL*`\. You can include multiple directories or folders with the `**` wildcard characters\.

1. To select all counters in the state of Washington, use `/WA/**/Counter*`\.

1. To select all counters from `Line 2`, use `/**/Line 2/Counter*`\.
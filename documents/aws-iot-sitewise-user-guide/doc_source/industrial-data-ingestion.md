# Ingesting data to AWS IoT SiteWise<a name="industrial-data-ingestion"></a>

AWS IoT SiteWise consumes industrial data and matches data to assets that represent your industrial operations\. You must create assets and asset models to receive data in AWS IoT SiteWise\. You can configure your data sources before building assets, but AWS IoT SiteWise won't receive any data sent until you create assets and set asset property aliases to your data stream paths\. For instructions to build your virtual industrial operation, see [Modeling industrial assets](industrial-asset-models.md)\.

You can send industrial data to AWS IoT SiteWise using any of the following options:
+ [Use an AWS IoT SiteWise gateway](gateways.md) to upload data from [OPC\-UA](https://en.wikipedia.org/wiki/OPC_Unified_Architecture) servers\. The gateway serves as the intermediary between AWS IoT SiteWise and your OPC\-UA servers\. AWS IoT SiteWise provides an AWS IoT Greengrass connector that you can deploy on any platform that can run AWS IoT Greengrass to set up a gateway\.
+ [Use AWS IoT Core rules](iot-rules.md) to upload data from MQTT messages published by an AWS IoT thing or another AWS service\.
+ [Use AWS IoT Events actions](iot-events.md) to upload data from AWS IoT Events when an event occurs\.
+ [Use AWS IoT Greengrass stream manager](greengrass-stream-manager.md) to upload data from local data sources using an edge device\.
+ [Use the AWS IoT SiteWise API](ingest-api.md) to upload data from any other source\.
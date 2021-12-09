# What is AWS IoT SiteWise?<a name="what-is-sitewise"></a>

AWS IoT SiteWise is a managed service that lets you collect, organize, and analyze data from industrial equipment at scale\. With AWS IoT SiteWise Monitor, you can quickly create web applications for non\-technical users to view and analyze your industrial data in real time\. You can gain insights about your industrial operations by configuring and monitoring metrics such as *mean time between failures* and *overall equipment effectiveness* \(OEE\)\.

The following diagram shows the basic architecture of AWS IoT SiteWise\.

![\[AWS IoT Greengrass "How AWS IoT SiteWise works" page screenshot.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/how-sitewise-works.png)

## How AWS IoT SiteWise works<a name="how-sitewise-works"></a>

AWS IoT SiteWise provides an asset modeling framework that you can use to build representations of your industrial devices, processes, and facilities\. With asset models, you define what raw data to consume and how to process your raw data into complex metrics\. You can build and visualize assets and models for your industrial operation in the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

You can upload industrial data to AWS IoT SiteWise in the following ways:
+ Use AWS IoT SiteWise gateway software that runs on any platform that supports AWS IoT Greengrass, such as common industrial gateways or virtual servers\. This software can read data directly from on\-site servers over the OPC\-UA protocol\. You can connect up to 100 OPC\-UA servers to a single AWS IoT SiteWise gateway\. For more information, see [Ingesting data using a gateway](gateways.md)\.
+ Use AWS IoT Core rules\. If you have devices connected to AWS IoT Core sending MQTT messages, you can use the AWS IoT Core rules engine to route those messages to AWS IoT SiteWise\. For more information, see [Ingesting data using AWS IoT Core rules](iot-rules.md)\.
+ Use AWS IoT Events actions\. You can configure the IoT SiteWise action in AWS IoT Events to send data to AWS IoT SiteWise when events occur\. For more information, see [Ingesting data from AWS IoT Events](iot-events.md)\.
+ Use AWS IoT Greengrass stream manager\. You can configure solutions on the edge that send high\-volume IoT data to AWS IoT SiteWise\. For more information, see [Ingesting data using AWS IoT Greengrass stream manager](greengrass-stream-manager.md)\.
+ Use the AWS IoT SiteWise API\. Your applications at the edge or in the cloud can directly send data to AWS IoT SiteWise\. For more information, see [Ingesting data using the AWS IoT SiteWise API](ingest-api.md)\.

You can set up SiteWise Monitor to create web applications for your non\-technical employees to visualize your operations\. With AWS SSO, you can configure unique logins and permissions for each employee to view specific subsets of an entire industrial operation\. AWS IoT SiteWise provides an [application guide](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/) for these employees to learn how to use SiteWise Monitor\.

## Why use AWS IoT SiteWise?<a name="why-use-sitewise"></a>

### Benefits<a name="sitewise-benefits"></a>

**Collect data consistently from all your sources**  
With AWS IoT SiteWise, you can gather data reliably from multiple facilities, structure it, and make it accessible and understandable without developing additional software\. You can index information and metrics about equipment or processes across multiple facilities, so it’s readily available for applications\.

**Identify issues quickly with remote monitoring**  
Assess the performance of your industrial equipment remotely, across locations, with AWS IoT SiteWise\. You can remotely diagnose a problem and only dispatch technicians when needed to fix issues\. You can spend less time coordinating onsite diagnostic activities and let your engineers focus on what they do best: understanding your operations and designing better systems\.

**Improve cross\-facility processes with a central data source**  
Visibility across industrial facilities lets you streamline operations, and identify gaps in production and waste\. With AWS IoT SiteWise, you can create models of industrial processes and equipment across multiple facilities, and then visualize live and historical data through customizable charts and dashboards\. Through SiteWise Monitor, you can launch private web applications with your asset data in minutes with AWS\. You and your industrial engineers can use these web applications to better understand your operations, improve processes, and reduce waste across your entire organization\.

### Use cases<a name="sitewise-use-cases"></a>

**Manufacturing**  
Manufacturing companies employ complex processes on their factory floors\. Quality assurance engineers and assembly robots inspect each product at various points in the assembly line, but this often involves manual work and can be subject to human error\. AWS IoT SiteWise helps you collect data from manufacturing lines and assembly robots, transfer it to the AWS Cloud, and structure performance metrics for your specific equipment and processes\. You can view production line output in SiteWise Monitor to assist in production planning and identify equipment and process deficiencies, production gaps, or product defects\. You can also use these metrics to understand the overall effectiveness of your operations and identify opportunities for innovation and improvement\.

**Food and beverage**  
Food and beverage industry facilities handle a wide variety of food processing, including grinding grain to flour, butchering and packing meat, and assembling, cooking, and freezing microwaveable meals\. These processing plants often span multiple locations with process engineers and equipment operators in a centralized location monitoring processes and equipment\. For example, they might monitor refrigeration units, assess ingredient handling and expiration, or monitor waste creation across facilities to ensure operational efficiency\. With AWS IoT SiteWise, you can group sensor data streams from multiple locations by production line and facilities so that your engineers and operators can better understand and improve processes across facilities\.

**Energy and utilities**  
Companies often deploy their power generation assets in remote areas, far from the technicians who are trained to fix the equipment\. When there's an issue, the technicians receive a notification, travel to the site to diagnose the problem, and then make another trip to fix it\. With AWS IoT SiteWise, you can resolve equipment issues easier and more efficiently\. With SiteWise Monitor, you can monitor asset performance remotely in real time and access historical equipment data from anywhere\. This lets you pinpoint potential problems, dispatch the right resources, and both prevent and fix issues faster\. 

## Are you new to AWS IoT SiteWise?<a name="first-time-user"></a>

If you're a first\-time user of AWS IoT SiteWise, we recommend that you read about the components and concepts of AWS IoT SiteWise and set up the [AWS IoT SiteWise demo](getting-started.md#requirements)\.
+ [Key components of AWS IoT SiteWise](feature-overview.md)
+ [AWS IoT SiteWise concepts](concept-overview.md)

You can complete the following tutorials to explore certain features of AWS IoT SiteWise:
+ [Ingesting data to AWS IoT SiteWise from AWS IoT things](ingest-data-from-iot-things.md)
+ [Visualizing and sharing wind farm data in AWS IoT SiteWise Monitor](monitor-wind-farm.md)
+ [Publishing property value updates to Amazon DynamoDB](publish-to-amazon-dynamodb.md)

See the following topics to learn more about AWS IoT SiteWise:
+ [Ingesting data to AWS IoT SiteWise](industrial-data-ingestion.md)
+ [Modeling industrial assets](industrial-asset-models.md)
+ [Monitoring data with AWS IoT SiteWise Monitor](monitor-data.md)
+ [Querying asset property values and aggregates](query-industrial-data.md)
+ [Interacting with other AWS services](interact-with-other-services.md)

## Related services<a name="related-services"></a>

AWS IoT SiteWise integrates with the following AWS services so that you can develop a complete AWS IoT solution in the AWS Cloud:
+ **AWS IoT Core** – Register and control AWS IoT devices that upload sensor data to AWS IoT SiteWise\. You can configure AWS IoT SiteWise to publish notifications to the AWS IoT message broker, which lets you send AWS IoT SiteWise data to other AWS services\. For more information, see the following topics:
  + [Ingesting data using AWS IoT Core](iot-rules.md)
  + [Interacting with other AWS services](interact-with-other-services.md)
  + [What is AWS IoT?](https://docs.aws.amazon.com/iot/latest/developerguide/) in the *AWS IoT Developer Guide*
+ **AWS IoT Greengrass** – Deploy edge devices that have AWS Cloud capabilities and can communicate with local AWS IoT devices\. AWS IoT SiteWise gateways run on AWS IoT Greengrass to collect data from local servers and publish data to the AWS Cloud\. For more information, see the following topics:
  + [Ingesting data using a gateway](gateways.md)
  + [What is AWS IoT Greengrass?](https://docs.aws.amazon.com/greengrass/latest/developerguide/) in the *AWS IoT Greengrass Developer Guide*
+ **AWS IoT Events** – Monitor your IoT data for process failures or changes in operation, and trigger actions when such events occur\. You can configure an alarm detection system in AWS IoT Events and send it data through AWS IoT Core\. For more information, see the following topics:
  + [Configuring alarms for asset property values with AWS IoT Events](iot-events-alarms.md)
  + [What is AWS IoT Events?](https://docs.aws.amazon.com/iotevents/latest/developerguide/) in the *AWS IoT Events Developer Guide*
+ **AWS Single Sign\-On** – Create and manage user identities and permissions\. SiteWise Monitor users sign in to web portals with AWS SSO, and you can define which users have access to which assets' data\. For more information, see the following topics:
  + [Monitoring data with AWS IoT SiteWise Monitor](monitor-data.md)
  + [What is SiteWise Monitor?](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/) in the *AWS IoT SiteWise Monitor Application Guide*
  + [What is AWS SSO?](https://docs.aws.amazon.com/singlesignon/latest/userguide/) in the *AWS Single Sign\-On User Guide*

## We want to hear from you<a name="contact-us"></a>

We welcome your feedback\. To contact us, visit the [AWS IoT SiteWise Discussion Forums](https://forums.aws.amazon.com/forum.jspa?forumID=336) or use one of the feedback links:
+ **Provide feedback** at the bottom of the page\.
+ **Feedback** at the top right of the page\.
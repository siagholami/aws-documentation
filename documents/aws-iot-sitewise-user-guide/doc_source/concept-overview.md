# AWS IoT SiteWise concepts<a name="concept-overview"></a>

The following are the core concepts of AWS IoT SiteWise:

**Gateway**  
A gateway connects to [OPC\-UA](https://en.wikipedia.org/wiki/OPC_Unified_Architecture) servers to deliver your industrial data streams to AWS IoT SiteWise\. You can create a gateway on any device or platform that can run AWS IoT Greengrass\. The gateway software exists as a connector that you can add to your AWS IoT Greengrass group\. For more information, see [Ingesting data using a gateway](gateways.md)\.

**Asset**  
When you ingest data into AWS IoT SiteWise from your industrial equipment, your devices, equipment, and processes are each represented as assets\. Each asset has data associated with it\. For example, a piece of equipment might have a serial number, a location, a make and model, and an install date\. It might also have time series values for availability, performance, quality, temperature, pressure, and so on\. You can organize assets into hierarchies, where assets have access to the data stored in its child assets\. For more information, see [Modeling industrial assets](industrial-asset-models.md)\.

**Asset model**  
Every asset is created from an asset model\. Asset models are declarative structures that standardize the format of your assets\. Asset models enforce consistent information across multiple assets of the same type, so that you can process data in assets that represent groups of devices\. In each asset model, you can define [attributes](#concept-attribute), time series inputs \([measurements](#concept-measurement)\), time series transformations \([transforms](#concept-transform)\), time series aggregations \([metrics](#concept-metric)\), and [asset hierarchies](#concept-hierarchy)\. For more information, see [Modeling industrial assets](industrial-asset-models.md)\.

**Asset property**  
Asset properties are the structures within each asset that contain industrial data\. Each property has a data type and can have a unit\. A property can be an [attribute](#concept-attribute), a [measurement](#concept-measurement), a [transform](#concept-transform), or a [metric](#concept-metric)\. For more information, see [Defining data properties](asset-properties.md)\.

**Attribute**  
Attributes are asset properties that represent information that generally doesn't change, such as device manufacturer or device location\. Attributes can have default values\. Each asset that you create from an asset model contains the default values of the attributes of that model\. For more information, see [Defining static data \(attributes\)](attributes.md)\.

**Measurement**  
Measurements are asset properties that represent a device or equipment's raw sensor time series data streams\. For more information, see [Defining data streams from equipment \(measurements\)](measurements.md)\.

**Transform**  
Transforms are asset properties that represent transformed time series data\. Every transform has a mathematical expression \([formula](#concept-formula)\) that defines how to transform data points from one form to another\. The transformed data points hold a one\-to\-one relationship with the input data points\. For more information, see [Transforming data \(transforms\)](transforms.md)\.

**Metric**  
Metrics are asset properties that represent aggregated time series data\. Every metric has a mathematical expression \([formula](#concept-formula)\) that defines how to aggregate data points, and a time interval over which to compute that aggregation\. Metrics output a single data point per given time interval\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

**Aggregate**  
Aggregates are basic metrics that AWS IoT SiteWise automatically computes for all time series data\. For more information, see [Querying asset property aggregates](query-industrial-data.md#aggregates)\.

**Asset hierarchy**  
You can define asset hierarchies to create logical representations of your industrial operations\. To create a hierarchy, you define a hierarchy definition in an asset model, and then you associate assets created from that model and the model specified in the hierarchy definition\. Metrics in parent assets can aggregate data from child assets' properties, so you can calculate statistics that provide insight to your operation or a subset of your operation\. For more information, see [Defining relationships between assets \(hierarchies\)](asset-hierarchies.md)\.

**Formula**  
Every [transform](#concept-transform) and [metric](#concept-metric) property has a formula that defines how that property transforms or aggregates data\. Formulas consist of property inputs, operators, and functions offered by AWS IoT SiteWise\. For more information, see [Using formula expressions](formula-expressions.md)\.

**Property alias**  
You can define aliases on asset properties to easily identify an asset property when you ingest or retrieve asset data\. When you use a [gateway](#concept-gateway) to ingest data from OPC\-UA servers, your property aliases must match the OPC\-UA paths of your raw data streams\. For more information, see [Mapping industrial data streams to asset properties](connect-data-streams.md)\.

**Property notification**  
When you enable property notifications for an asset property, AWS IoT SiteWise publishes an MQTT message to AWS IoT Core each time that property receives a new value\. The message payload contains information about that property value update\. You can use property value notifications to create solutions that connect your industrial data in AWS IoT SiteWise with other AWS services\. For more information, see [Interacting with other AWS services](interact-with-other-services.md)\.

**Portal**  <a name="monitor-concept-portal"></a>
An SiteWise Monitor portal is a web application that you can use to visualize and share your AWS IoT SiteWise data\. A portal has one or more administrators and contains zero or more projects\.

**Portal administrator**  
Each SiteWise Monitor portal has one or more portal administrators\. Portal administrators use the portal to create projects that contain collections of assets and dashboards\. The portal administrator then assigns assets and owners to each project\. By controlling access to the project, portal administrators specify which assets that project owners and viewers can see\.

**Project**  <a name="monitor-concept-project"></a>
Each SiteWise Monitor portal contains a set of projects\. Each project has a subset of your AWS IoT SiteWise assets associated with it\. Project owners create one or more dashboards to provide a consistent way to view the data associated with those assets\. Project owners can invite viewers to the project to allow them to view the assets and dashboards in the project\. The project is the basic unit of sharing within SiteWise Monitor\. Project owners can invite users who were given access to the portal by the AWS administrator\. A user must have access to a portal before a project in that portal can be shared with that user\.

**Project owner**  
Each SiteWise Monitor project has owners\. Project owners create visualizations in the form of dashboards to represent operational data in a consistent manner\. When dashboards are ready to share, the project owner can invite viewers to the project\. Project owners can also assign other owners to the project\.

**Project viewer**  
Each SiteWise Monitor project has viewers\. Project viewers can connect to the portal to view the dashboards that project owners created\. In each dashboard, project viewers can adjust the time range to better understand operational data\. Project viewers can only view dashboards in the projects to which they have access\.

**Dashboard**  <a name="monitor-concept-dashboard"></a>
Each project contains a set of dashboards\. Dashboards provide a set of visualizations for the values of a set of assets\. Project owners create the dashboards and the visualizations that it contains\. When a project owner is ready to share the set of dashboards, the owner can invite viewers to the project, which gives them access to all dashboards in the project\. If you want a different set of viewers for different dashboards, you must divide the dashboards between projects\. When viewers look at dashboards, they can adjust the time range\.

**Visualization**  <a name="monitor-concept-visualization"></a>
In each dashboard, project owners decide how to display the values for the properties of the assets associated with the project\. Availability might best be represented as a line chart, while other values might be displayed as bar charts or key performance indicators \(KPIs\)\. Project owners customize each visualization to provide the best understanding of the data for that asset\.
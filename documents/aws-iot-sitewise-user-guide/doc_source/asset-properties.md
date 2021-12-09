# Defining data properties<a name="asset-properties"></a>

Asset properties are the structures within each asset that contain asset data\. Asset properties can be any of the following types:
+ **Attributes** – An asset's generally static properties, such as device manufacturer or geographic region\. For more information, see [Defining static data \(attributes\)](attributes.md)\.
+ **Measurements** – An asset's raw device's sensor data streams, such as timestamped rotation speed values or timestamped temperature values in Celsius\. A measurement is defined by a data stream alias\. For more information, see [Defining data streams from equipment \(measurements\)](measurements.md)\.
+ **Transforms** – An asset's transformed time\-series values, such as timestamped temperature values in Fahrenheit\. A transform is defined by an expression and the variables to consume with that expression\. For more information, see [Transforming data \(transforms\)](transforms.md)\.
+ **Metrics** – An asset's data aggregated over a specified time interval, such as the hourly average temperature\. A metric is defined by a time interval, an expression, and the variables to consume with that expression\. Metric expressions can input associated assets' metric properties, so that you can calculate metrics that represent your operation or a subset of your operation\. For more information, see [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

For an example of how to use measurements, transforms, and metrics to calculate Overall Equipment Effectiveness \(OEE\), see [Calculating OEE in AWS IoT SiteWise](calculate-oee.md)\.

**Topics**
+ [Defining static data \(attributes\)](attributes.md)
+ [Defining data streams from equipment \(measurements\)](measurements.md)
+ [Transforming data \(transforms\)](transforms.md)
+ [Aggregating data from properties and other assets \(metrics\)](metrics.md)
+ [Using formula expressions](formula-expressions.md)
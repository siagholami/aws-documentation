# Modeling industrial assets<a name="industrial-asset-models"></a>

You can create virtual representations of your industrial operation with AWS IoT SiteWise assets\. An asset represents a device, a piece of equipment, or a process that uploads one or more data streams to the AWS Cloud\. For example, an asset device can be a wind turbine that sends air temperature, propeller rotation speed, and power output time\-series measurements to asset properties in AWS IoT SiteWise\. Each data stream corresponds to unique property alias\. For example, the alias `/company/windfarm/3/turbine/7/temperature` uniquely identifies the temperature data stream coming from turbine \#7 in wind farm \#3\. You can configure AWS IoT SiteWise assets to transform incoming measurement data using mathematical expressions, such as to convert temperature data from Celsius to Fahrenheit\.

![\[AWS IoT SiteWise assets represent the devices in your industrial operation.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-asset.png)

An asset can also represent a logical grouping of devices, such as an entire wind farm\. You can associate assets to other assets to create asset hierarchies that represent complex industrial operations\. Assets can access the data within their associated child assets so that you can use AWS IoT SiteWise expressions to calculate aggregate metrics, such as the net power output of a wind farm\.

![\[AWS IoT SiteWise asset hierarchies represent the relationships between the devices in your industrial operation.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-asset-hierarchy.png)

You must create every asset from an asset model\. Asset models are declarative structures that standardize the format of your assets\. Asset models enforce consistent information across multiple assets of the same type, so that you can process data in assets that represent groups of devices\. In the preceding diagram, you use the same asset model for all three turbines because all turbines share a common set of properties\.

After you define your asset models, you can create your industrial assets\. To create an asset, select an `ACTIVE` asset model to create an asset from that model\. Then, you can populate asset\-specific information such as data stream aliases and attributes\. In the preceding diagram, you create three turbine assets from one asset model and then associate data stream aliases like `/company/windfarm/3/turbine/7/temperature` for each turbine\.

You can also update and delete existing assets and asset models\. When you update an asset model, every asset based on that asset model reflects any changes that you make to the underlying model\.

**Topics**
+ [Asset and model states](asset-and-model-states.md)
+ [Creating asset models](create-asset-models.md)
+ [Creating assets](create-assets.md)
+ [Mapping industrial data streams to asset properties](connect-data-streams.md)
+ [Updating attribute values](update-attribute-values.md)
+ [Associating and disassociating assets](add-associated-assets.md)
+ [Updating assets and models](update-assets-and-models.md)
+ [Deleting assets and models](delete-assets-and-models.md)
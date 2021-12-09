# Using Geospatial Charts \(Maps\)<a name="geospatial-charts"></a>

Use geospatial charts to show differences in data values across a geographical map\. The map allows you to zoom in and out\. As you zoom in closer, you can see more geographical features\. The map retains the chosen zoom level and size\. 

Each circle represents a geographical location on the map chart\. This can be latitude and longitude, or geographical components such as state or city\. The size of the circles represents the magnitude of the field in the **Size** well, in relation to other values in the same field\. The color of the circles represents the values in the **Color** well\. The field in the **Color** well displays in the legend, if you choose to display one\.

Here is a sample of a map chart\. The latitude, longitude, country, state, and city are identified by a place marker icon, showing that they are a geospatial data type\. State and city are inside of a hierarchy named Geo\. Data types must be correctly configured in the data set before geospatial mapping can work\. Predefined hierarchies, called *geospatial groupings*, are optional\. They allow Amazon QuickSight to resolve locations on the map, in case of any ambiguities\. If the data types are correct, the mapping can work for supported geographies without geospatial groupings\.

For more information about setting up geospatial data types and hierarchies, see [Adding Geospatial Data](geospatial-data-prep.md)\.

**Important**  
Geospatial charts in Amazon QuickSight currently aren't supported in some geographies, including India and China\. We are working on adding support for more regions\.  
For now, automatic geocoding works only for US locations\. However, you can add latitude and longitude coordinates to your data to make geospatial charts\. For help with geospatial issues, see [Geospatial Troubleshooting](geospatial-troubleshooting.md)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/geo-mapchart-sample-1.png)

Use the following table to understand the features supported by geospatial maps\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Legend display | Yes | Displays contents of the field in the Color well | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the visual colors | Partial | You can change the color of the circles on the map, but not for individual values\. | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the Geospatial and Color field wells\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 
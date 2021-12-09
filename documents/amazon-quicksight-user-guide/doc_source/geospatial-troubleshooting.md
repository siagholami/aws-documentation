# Geospatial Troubleshooting<a name="geospatial-troubleshooting"></a>

Use this section to discover QuickSight's requirements for correctly processing geospatial data\. If QuickSight doesn't recognize your geospatial data as geospatial, use this section to help troubleshoot the issue\. Make sure that your data follows the guidelines listed, so that it works in geospatial visuals\.

**Note**  
Geospatial charts in Amazon QuickSight currently aren't supported in some geographies, including India and China\. We are working on adding support for more regions\.  
If your geography follows all the guidelines listed here, and still generates errors, contact the Amazon QuickSight team from within the Amazon QuickSight console\. 

**Topics**
+ [Geocoding Issues](#geocoding)
+ [Issues with Latitude and Longitude](#latitude-and-longitude)

## Geocoding Issues<a name="geocoding"></a>

Amazon QuickSight geocodes place names into latitude and longitude coordinates\. It uses these coordinates to display place names on the map\. Amazon QuickSight skips any places that it can't geocode\.

For this process to work properly, your data must include at least the country\. Also, there can't be duplicate place names inside of a parent place name\. 

A few issues prevent place names from showing up on a map chart\. These issues include unsupported, ambiguous, or invalid locations, as described following\.

**Topics**
+ [Issues with Unsupported Areas](#geospatial-unsupported-areas)
+ [Issues with Ambiguous Locations](#geospatial-ambiguous-locations)
+ [Issues with Invalid Geospatial Data](#geospatial-invalid-data)
+ [Issues with the Default Country in Geocoding](#geospatial-default-country)

### Issues with Unsupported Areas<a name="geospatial-unsupported-areas"></a>

**Important**  
At this time, Amazon QuickSight only supports geographical place names in data related to the US\.

To map locations in countries other than the US, include latitude and longitude coordinates in your data\. Use these coordinates in the geospatial field well to make locations show on a map chart\. 

### Issues with Ambiguous Locations<a name="geospatial-ambiguous-locations"></a>

Geospatial data can't contain ambiguous locations\. For example, suppose that the data contains a city named **Springfield**, but the next level in the hierarchy is country\. Because multiple states have a city named **Springfield**, it isn't possible to geocode the location to a specific point on a map\. 

To avoid this problem, you can add enough geographical data to indicate what location should show on a map chart\. For example, you can add a state level into your data and its hierarchy\. Or, you might add latitude and longitude\.

### Issues with Invalid Geospatial Data<a name="geospatial-invalid-data"></a>

Invalid geospatial data occurs when a place name \(a city, for example\) is listed under an incorrect parent \(a state, for example\)\. This issue might be a simple misspelling, or data entry error\. 

**Note**  
Amazon QuickSight doesn't support regions \(for example, West Coast or South\) as geospatial data\. However, you can use a region as a filter in a visual\.

### Issues with the Default Country in Geocoding<a name="geospatial-default-country"></a>

Make sure that you are using the correct default country\. 

The default for each hierarchy is based on the country or country field that you choose when you create the hierarchy\. 

To change this default, you can return to the **Create hierarchy** screen\. Then edit or create a hierarchy, and choose a different country\. 

If you don't create a hierarchy, your default country is based on your region\. For details, see the following table\.


| Region | Default Country | 
| --- | --- | 
| US West \(Oregon\) Region US East \(Ohio\) Region US East \(N\. Virginia\) Region | US | 
| Asia Pacific \(Singapore\) | Singapore | 
| Asia Pacific \(Sydney\) | Australia | 
| EU \(Ireland\) Region | Ireland | 

## Issues with Latitude and Longitude<a name="latitude-and-longitude"></a>

Amazon QuickSight uses latitude and longitude coordinates in the background to find place names on a map\. However, you can also use coordinates to create a map without using place names\. This approach also works with unsupported place names\. 

Latitude and longitude values must be numeric\. For example, the map point indicated by **28\.5383355 \-81\.3792365** is compatible with Amazon QuickSight\. But **28° 32' 18\.0096'' N 81° 22' 45\.2424'' W** is not\. 

**Topics**
+ [Valid Ranges for Latitude and Longitude Coordinates](#valid-ranges-for-coordinates)
+ [Using Coordinates in Degrees, Minutes, and Seconds \(DMS\) Format](#using-coordinates-in-dms-format)

### Valid Ranges for Latitude and Longitude Coordinates<a name="valid-ranges-for-coordinates"></a>

Amazon QuickSight supports latitude and longitude coordinates within specific ranges\. 


| Coordinate | Valid Range | 
| --- | --- | 
| Latitude | Between \-90 and 90 | 
| Longitude | Between \-180 to 180 | 

Amazon QuickSight skips any data outside these ranges\. Out\-of\-range points can't be mapped on a map chart\. 

### Using Coordinates in Degrees, Minutes, and Seconds \(DMS\) Format<a name="using-coordinates-in-dms-format"></a>

You can use a calculated field with a formula to create a numeric latitude and longitude out of character strings\. Use this section to find different ways that you can create calculated fields in Amazon QuickSight, to parse GPS latitude and longitude into numeric latitude and longitude\. 

The following sample converts latitude and longitude to numeric format from separate fields\. For example, suppose that you parse **51° 30' 26\.4636'' N 0° 7' 39\.9288'' W** using space as a delimiter\. In this case, you can use something like the following sample to convert the resulting fields to numeric latitude and longitude\. 

In this example, the seconds are followed by two single quotation marks\. If your data has a double quotation mark instead, then you can use `strlen(LatSec)-1)` instead of `strlen(LatSec)-2)`\.

```
/*Latitude*/
        ifelse( 
        LatDir = "N", 
        parseInt(split(LatDeg, "°", 1)) + 
            (parseDecimal(split(LatMin, "'", 1) ) /60) +
            (parseDecimal((substring(LatSec, 1, strlen(LatSec)-2) ) ) /3600), 
        (parseInt(split(LatDeg, "°", 1)) + 
            (parseDecimal(split(LatMin, "'", 1) ) /60) +
            (parseDecimal((substring(LatSec, 1, strlen(LatSec)-2) ) ) /3600)) * -1
        )
        
/*Longitude*/
        ifelse( 
        LongDir = "E", 
        parseInt(split(LongDeg, "°", 1)) + 
            (parseDecimal(split(LongMin, "'", 1) ) /60) +
            (parseDecimal((substring(LongSec, 1, strlen(LongSec)-2) ) ) /3600), 
        (parseInt(split(LongDeg, "°", 1)) + 
            (parseDecimal(split(LongMin, "'", 1) ) /60) +
            (parseDecimal((substring(LongSec, 1, strlen(LongSec)-2) ) ) /3600)) * -1
        )
```

If your data doesn't include the symbols for degree, minute and second, the formula looks like the following\.

```
/*Latitude*/
    ifelse( 
        LatDir = "N", 
        (LatDeg + (LatMin / 60) + (LatSec / 3600)), 
        (LatDeg + (LatMin / 60) + (LatSec / 3600)) * -1
    )
    
/*Longitude*/
    ifelse( 
        LongDir = "E", 
        (LongDeg + (LongMin / 60) + (LongSec / 3600)), 
        (LongDeg + (LongMin / 60) + (LongSec / 3600)) * -1
    )
```

The following sample converts **53°21'N 06°15'W** to numeric format\. However, without the seconds, this location doesn't map as accurately\.

```
/*Latitude*/
ifelse( 
    right(Latitude, 1) = "N", 
    (parseInt(split(Latitude, '°', 1)) +
        parseDecimal(substring(Latitude, (locate(Latitude, '°',3)+1),  2) ) / 60) , 
    (parseInt(split(Latitude, '°', 1)) +
        parseDecimal(substring(Latitude, (locate(Latitude, '°',3)+1),  2) ) / 60) * -1
)

/*Longitude*/
ifelse( 
    right(Longitude, 1) = "E", 
    (parseInt(split(Longitude, '°', 1)) +
        parseDecimal(substring(Longitude, (locate(Longitude, '°',3)+1),  2) ) / 60) , 
    (parseInt(split(Longitude, '°', 1)) +
        parseDecimal(substring(Longitude, (locate(Longitude, '°',3)+1),  2) ) / 60) * -1
)
```

The formats of GPS latitude and longitude can vary, so customize your formulas to match your data\. For more information, see the following links:
+ [Degrees Minutes Seconds to Decimal Degrees](https://www.latlong.net/degrees-minutes-seconds-to-decimal-degrees) on LatLong\.net
+ [Converting Degrees/Minutes/Seconds to Decimals using SQL](https://stackoverflow.com/questions/12186110/converts-degrees-minutes-seconds-to-decimals-using-sql) on Stack Overflow
+ [Geographic Coordinate Conversion](https://en.wikipedia.org/wiki/Geographic_coordinate_conversion) on Wikipedia
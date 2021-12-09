# Creating dashboards \(AWS Command Line Interface\)<a name="create-dashboards-using-aws-cli"></a>

When you define visualizations \(or widgets\) in dashboards using the AWS CLI, you must specify the following information in the `dashboardDefinition` JSON document\. This definition is a parameter of the [CreateDashboard](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateDashboard.html) and [UpdateDashboard](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_UpdateDashboard.html) operations\.

`widgets`  
A list of widget definition structures that each contain the following information:    
`type`  
The type of widget\. AWS IoT SiteWise provides the following widget types:  
+ `monitor-line-chart` – A line chart\. For more information, see [Line charts](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/choose-visualization-types.html#line-charts) in the *AWS IoT SiteWise Monitor Application Guide*\.
+ `monitor-scatter-chart` – A scatter chart\. For more information, see [Scatter charts](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/choose-visualization-types.html#scatter-charts) in the *AWS IoT SiteWise Monitor Application Guide*\.
+ `monitor-bar-chart` – A bar chart\. For more information, see [Bar charts](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/choose-visualization-types.html#bar-charts) in the *AWS IoT SiteWise Monitor Application Guide*\.
+ `monitor-kpi` – A key performance indicator \(KPI\) visualization\. For more information, see [KPI visualizations](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/choose-visualization-types.html#kpi-charts) in the *AWS IoT SiteWise Monitor Application Guide*\.  
`title`  
The title of the widget\.  
`x`  
The horizontal position of the widget, starting from the left of the grid\. This value refers to the widget's position in the dashboard's grid\.  
`y`  
The vertical position of the widget, starting from the top of the grid\. This value refers to the widget's position in the dashboard's grid\.  
`width`  
The width of the widget, expressed in number of spaces on the dashboard's grid\.  
`height`  
The height of the widget, expressed in number of spaces on the dashboard's grid\.  
`metrics`  
A list of metric structures that each define a data stream for this widget\. Each structure in the list must contain the following information:    
`label`  
A label to display for this metric\.  
`type`  
The type of data source for this metric\. AWS IoT SiteWise provides the following metric types:  
+ `iotsitewise` – The dashboard fetches data for an asset property in AWS IoT SiteWise\. If you choose this option, you must define `assetId` and `propertyId` for this metric\.  
`assetId`  
\(Optional\) The ID of an asset in AWS IoT SiteWise\.  
This field is required if you choose `iotsitewise` for `type` in this metric\.  
`propertyId`  
\(Optional\) The ID of an asset property in AWS IoT SiteWise\.  
This field is required if you choose `iotsitewise` for `type` in this metric\.  
`analysis`  
\(Optional\) A structure that defines the analysis, such as trend lines, to display for the widget\. For more information, see [Configuring trend lines](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/configure-trend-lines.html) in the *AWS IoT SiteWise Monitor Application Guide*\. You can add one of each type of trend line per property in the widget\. The analysis structure contains the following information:    
`trends`  
\(Optional\) A list of trend structures that each define a trend analysis for this widget\. Each structure in the list contains the following information:    
`type`  
The type of trend line\. Choose the following option:  
+ `linear-regression` – Display a linear regression line\. SiteWise Monitor uses the [least squares](https://en.wikipedia.org/wiki/Least_squares) method to calculate the linear regression\.  
`annotations`  
\(Optional\) An annotations structure that defines thresholds for the widget\. For more information, see [Configuring thresholds](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/configure-thresholds.html) in the *AWS IoT SiteWise Monitor Application Guide*\. You can add up to six annotations per widget\. The annotations structure contains the following information:    
`y`  
\(Optional\) A list of annotation structures that each define a horizontal threshold for this widget\. Each structure in the list contains the following information:    
`comparisonOperator`  
The comparison operator for the threshold\. Choose one of the following:  
+ `LT` – Highlight properties that have at least one data point less than the `value`\.
+ `GT` – Highlight properties that have at least one data point greater than the `value`\.
+ `LTE` – Highlight properties that have at least one data point less than or equal to the `value`\.
+ `GTE` – Highlight properties that have at least one data point greater than or equal to the `value`\.  
`value`  
The threshold value to compare data points with the `comparisonOperator`\.  
`color`  
\(Optional\) The 6\-digit hexadecimal code of the threshold color\. The visualization displays property legends in this color for properties with at least one data point that meets the threshold rule\. Defaults to black \(`#000000`\)\.  
`showValue`  
\(Optional\) Whether or not to show the value of the threshold in the margins of the widget\. Defaults to `true`\.  
`properties`  
\(Optional\) A flat dictionary of properties for the widget\. The members of this structure are context\-dependent\. AWS IoT SiteWise provides the following widgets that use `properties`:  
+ Widgets that support [thresholds](https://docs.aws.amazon.com/iot-sitewise/latest/appguide/configure-thresholds.html) support the following property:  
`colorDataAcrossThresholds`  
\(Optional\) Whether or not to change the color of the data that crosses the thresholds in this widget\. When you enable this option, the data that crosses a threshold appears in the color that you choose\. Defaults to `true`\.

**Example dashboard definition**  
The following example defines a dashboard from a payload stored in a JSON file\.  

```
aws iotsitewise create-dashboard \
  --project-id a1b2c3d4-5678-90ab-cdef-eeeeeEXAMPLE \
  --dashboard-name "Wind Farm Dashboard" \
  --dashboard-definition file://dashboard-definition.json
```
The following JSON example for `dashboard-definition.json` defines dashboard with the following visualization widgets:  
+ A line chart that visualizes total wind farm power in the upper left of the dashboard\. This line chart includes a threshold that indicates when the wind farm outputs less power than its minimum expected output\. This line chart also includes a linear regression trend line\.
+ A bar chart that visualizes wind speed for four turbines in the upper right of the dashboard\.
This example represents the line and bar chart visualizations on a dashboard\. This dashboard is similar to the [example wind farm dashboard](monitor-data.md)\.

```
{
  "widgets": [
    {
      "type": "monitor-line-chart",
      "title": "Total Average Power",
      "x": 0,
      "y": 0,
      "height": 3,
      "width": 3,
      "metrics": [
        {
          "label": "Power",
          "type": "iotsitewise",
          "assetId": "a1b2c3d4-5678-90ab-cdef-22222EXAMPLE",
          "propertyId": "a1b2c3d4-5678-90ab-cdef-33333EXAMPLE",
          "analysis": {
            "trends": [
              {
                "type": "linear-regression"
              }
            ]
          }
        }
      ],
      "annotations": {
        "y": [
          {
            "comparisonOperator": "LT",
            "value": 20000,
            "color": "#D13212",
            "showValue": true
          }
        ]
      }
    },
    {
      "type": "monitor-bar-chart",
      "title": "Wind Speed",
      "x": 3,
      "y": 3,
      "height": 3,
      "width": 3,
      "metrics": [
        {
          "label": "Turbine 1",
          "type": "iotsitewise",
          "assetId": "a1b2c3d4-5678-90ab-cdef-2a2a2EXAMPLE",
          "propertyId": "a1b2c3d4-5678-90ab-cdef-55555EXAMPLE"
        },
        {
          "label": "Turbine 2",
          "type": "iotsitewise",
          "assetId": "a1b2c3d4-5678-90ab-cdef-2b2b2EXAMPLE",
          "propertyId": "a1b2c3d4-5678-90ab-cdef-55555EXAMPLE"
        },
        {
          "label": "Turbine 3",
          "type": "iotsitewise",
          "assetId": "a1b2c3d4-5678-90ab-cdef-2c2c2EXAMPLE",
          "propertyId": "a1b2c3d4-5678-90ab-cdef-55555EXAMPLE"
        },
        {
          "label": "Turbine 4",
          "type": "iotsitewise",
          "assetId": "a1b2c3d4-5678-90ab-cdef-2d2d2EXAMPLE",
          "propertyId": "a1b2c3d4-5678-90ab-cdef-55555EXAMPLE"
        }
      ]
    }
  ]
}
```
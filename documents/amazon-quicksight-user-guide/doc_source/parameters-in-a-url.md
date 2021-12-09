# Using Parameters in a URL<a name="parameters-in-a-url"></a>

You can use a parameter name and value in a URL in Amazon QuickSight to set a default value for that parameter in a dashboard or analysis\. 

The following example shows the URL of a dashboard that sets a parameter for another dashboard\.

```
https://us-east-2.quicksight.aws.amazon.com/sn/dashboards/abc123-abc1-abc2-abc3-abcdefef1234#p.myParameter=12345
```

In the previous example, the first part is the link to the target dashboard: `https://us-east-2.quicksight.aws.amazon.com/sn/dashboards/abc123-abc1-abc2-abc3-abcdefef1234`\. The hash sign \(`#)` follows the first part to introduce the *fragments*, which contain the values that you want to set\.

The values in the fragments aren't received or logged by AWS servers\. This functionality keeps your data values more secure\.

The fragment after `#` follows these rules: 
+ Parameters are prefixed with `p.`\. The names are the parameter name, not the control name\. You can view the parameter name by opening the analysis, and choosing **Parameter** on the left sidebar\.
+ The value is set using equals \(`=`\)\. The following rules apply:
  + Literal values don't use quotation marks\. 
  + Spaces inside values are automatically encoded by the browser, so you don't need to use escape characters when manually creating a URL\. 
  + In custom URL actions, target parameter names begin with `$`, for example: `<<$passThroughParameter>>`
  + In custom URL actions, parameter values display with angle brackets `<< >>`, for example `<<dashboardParameter1>>`\)\. The dashboard user sees the lookup value, not the variable\. 
+ For a custom URL action, multivalue parameters only need one instance of the same parameter in the fragment, for example: `p.city=<<$city>>`
+ For a direct URL, multiple values for a single parameter have two instances of the same parameter in the fragment\. For an example, see following\.
+ Ampersands \(`&`\) separate multiple parameters\. For an example, see following\.

The server converts the date to UTC and sends it to the backend as a string without a time zone\. To use Universal Coordinated Time \(UTC\) dates, exclude the time zone\. Following are some examples of date formats that work: 
+ `2017-05-29T00%3A00%3A00` 
+ `2018-04-04 14:51 -08:00`
+ `Wed Apr 04 2018 22:51 GMT+0000`

```
https://us-east-2.quicksight.aws.amazon.com/sn/dashboards/abc123-abc1-abc2-abc3-abcdefef1234#p.shipdate=2018-09-30 08:01&p.city=New York&p.city=Seattle&p.teamMember=12&.p.percentageRank=2.3
```

In the browser, this code becomes the following\.

```
https://us-east-2.quicksight.aws.amazon.com/sn/dashboards/abc123-abc1-abc2-abc3-abcdefef1234#p.shipdate=2018-09-30%2008:01&p.city=New%20York&p.city=Seattle&p.teamMember=12&.p.percentageRank=2.3
```

The previous example sets four parameters:
+ `shipDate` is a date parameter: `Sept 30, 2018`\.
+ `city` is a multivalued string parameter: `New York`, and `Seattle`
+ `teamMember` is an integer parameter: `12`\.
+ `percentageRank` is a decimal parameter: `2.3`\.

The following example shows how to set values for a parameter that accepts multiple values\.

```
https://us-east-2.quicksight.aws.amazon.com/sn/dashboards/abc123-abc1-abc2-abc3-abcdefef1234#p.MultiParam=WA&p.MultiParam=OR&p.MultiParam=CA
```

To pass values from one dashboard \(or analysis\) to another dashboard based on the user's data point selection, use [custom URL actions](custom-url-actions.md)\. If you choose, you can also generate these URLs manually, and use them to share a specific view of the data\.
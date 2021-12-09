# Using formula expressions<a name="formula-expressions"></a>

With formula expressions, you can define the mathematical functions to transform and aggregate your raw industrial data to gain insights about your operation\. For more information about how to define properties that use formula expressions, see [Transforming data \(transforms\)](transforms.md) and [Aggregating data from properties and other assets \(metrics\)](metrics.md)\.

**Topics**
+ [Operators](#expression-operators)
+ [Common functions](#expression-common-functions)
+ [Relational functions](#expression-relational-functions)
+ [Aggregation functions](#expression-aggregation-functions)
+ [Temporal functions](#expression-temporal-functions)
+ [Late data ingestion](#late-data)
+ [Data quality in transforms and metrics](#data-quality)
+ [Undefined, infinite, and overflow values](#undefined-values)
+ [Counting filtered data points](#count-filtered-data)

## Operators<a name="expression-operators"></a>

You can use the following common mathematical operators in your expressions\.


| Operator | Description | 
| --- | --- | 
| \+ | Adds the left and right operands\. | 
| \- | Subtracts the right operand from the left operand\. | 
| / | Divides the left operand by the right operand\. | 
| \* | Multiplies the left and right operands\. | 
| ^ | Raises the left operand to the power of the right operand \(exponentiation\)\. | 
| % | Returns the remainder from dividing the left operand by the right operand \(modulo\)\. The result has the same sign as the left operand\. | 

## Common functions<a name="expression-common-functions"></a>

You can use the following functions to calculate common mathematical functions\.


| Function | Description | 
| --- | --- | 
| abs\(x\) | Returns the absolute value of x\. | 
| acos\(x\) | Returns the arccosine of x\. | 
| asin\(x\) | Returns the arcsine of x\. | 
| atan\(x\) | Returns the arctangent of x\. | 
| cbrt\(x\) | Returns the cubic root of x\. | 
| ceil\(x\) | Returns the nearest integer greater than x\. | 
| cos\(x\) | Returns the cosine of x\. | 
| cosh\(x\) | Returns the hyperbolic cosine of x\. | 
| exp\(x\) | Returns e to the power of x\. | 
| floor\(x\) | Returns the nearest integer less than x\. | 
| log\(x\) | Returns the loge \(base e\) of x\. | 
| log10\(x\) | Returns the log10 \(base 10\) of x\. | 
| log2\(x\) | Returns the log2 \(base 2\) of x\. | 
| sin\(x\) | Returns the sine of x\. | 
| sinh\(x\) | Returns the hyperbolic sine of x\. | 
| sqrt\(x\) | Returns the square root of x\. | 
| tan\(x\) | Returns the tangent of x\. | 
| tanh\(x\) | Returns the hyperbolic tangent of x\. | 
| signum\(x\) | Returns the sign of x \(\-1 for negative inputs, 0 for zero inputs, \+1 for positive inputs\)\. | 

## Relational functions<a name="expression-relational-functions"></a>

In [transform properties](transforms.md) only, you can use the following relational functions to compare two values and output `1` \(true\) or `0` \(false\)\.


| Function | Description | 
| --- | --- | 
| gt\(x, y\) | Returns 1 if x is greater than y, otherwise 0 \(x > y\)\. | 
| gte\(x, y\) | Returns 1 if x is greater than or equal to y, otherwise 0 \(x ≥ y\)\. | 
| eq\(x, y\) | Returns 1 if x is equal to y, otherwise 0 \(x == y\)\. | 
| lt\(x, y\) | Returns 1 if x is less than y, otherwise 0 \(x < y\)\. | 
| lte\(x, y\) | Returns 1 if x is less than or equal to y, otherwise 0 \(x ≤ y\)\. | 

## Aggregation functions<a name="expression-aggregation-functions"></a>

In [metric properties](metrics.md) only, you can use the following functions that aggregate input values over each time interval and calculate a single output value\. Aggregation functions can aggregate data from associated assets\.


| Function | Description | 
| --- | --- | 
| avg\(x0, \.\.\., xn\) | Returns the mean of the given variables' values over the current time interval\. | 
| sum\(x0, \.\.\., xn\) | Returns the sum of the given variables' values over the current time interval\. | 
| min\(x0, \.\.\., xn\) | Returns the minimum of the given variables' values over the current time interval\. | 
| max\(x0, \.\.\., xn\) | Returns the maximum of the given variables' values over the current time interval\. | 
| count\(x0, \.\.\., xn\) |  Returns the total number of data points for the given variables over the current time interval\. For more information about how to count the number of data points that meet a condition, see [Counting filtered data points](#count-filtered-data)\. This function computes a data point for every time interval\.  | 

AWS IoT SiteWise also automatically computes aggregates over certain time intervals for all properties\. For more information, see [Querying asset property aggregates](query-industrial-data.md#aggregates)\.

## Temporal functions<a name="expression-temporal-functions"></a>

In [metric properties](metrics.md) only, you can use the following functions that return values based on timestamps of data points\. Temporal functions can't input data from associated assets\.


| Function | Description | 
| --- | --- | 
| first\(x\) | Returns the given variable's value with the earliest timestamp over the current time interval\. | 
| last\(x\) | Returns the given variable's value with the latest timestamp over the current time interval\. | 
| earliest\(x\) |  Returns the given variable's value with the latest timestamp before the current time interval\. This function computes a data point for every time interval, if the input property has at least one data point in its history\.  | 
| latest\(x\) |  Returns the given variable's value with the latest timestamp\. This function computes a data point for every time interval, if the input property has at least one data point in its history\.  | 
| statetime\(x\) |  Returns the amount of time in seconds that the given variables are positive over the current time interval\. You can use the [relational functions](#expression-relational-functions) to create a transform property for the `statetime` function to consume\.  For example, if you have an `Idle` property that is `0` or `1`, you can calculate idle time per time interval with this expression: `IdleTime = statetime(Idle)`\. For more information, see the [example statetime scenario](#statetime-example)\. This function doesn't support metric properties as input variables\. This function computes a data point for every time interval, if the input property has at least one data point in its history\.  | 

The following diagram shows how AWS IoT SiteWise computes the temporal functions `first`, `last`, `earliest`, and `latest`, relative to the current time interval\.

![\[AWS IoT SiteWise temporal functions return data points based on their timestamp.\]](http://docs.aws.amazon.com/iot-sitewise/latest/userguide/images/sitewise-temporal-functions.png)

**Example statetime scenario**  
Consider an example where you have an asset with the following properties:  
+ `Idle` – A measurement that is `0` or `1`\. When the value is `1`, the machine is idle\.
+ `Idle Time` – A metric that uses the formula `statetime(Idle)` to calculate the amount of time in seconds where the machine is idle, per 1 minute interval\.
The `Idle` property has the following data points\.  


|  |  |  |  |  |  | 
| --- |--- |--- |--- |--- |--- |
| Timestamp | 2:00:00 PM | 2:00:30 PM | 2:01:15 PM | 2:02:45 PM | 2:04:00 PM | 
| Idle | 0 | 1 | 1 | 0 | 0 | 
AWS IoT SiteWise calculates the `Idle Time` property every minute from the values of `Idle`\. After this calculation completes, the `Idle Time` property has the following data points\.  


|  |  |  |  |  |  | 
| --- |--- |--- |--- |--- |--- |
| Timestamp | 2:00:00 PM | 2:01:00 PM | 2:02:00 PM | 2:03:00 PM | 2:04:00 PM | 
| Idle Time | N/A | 30 | 60 | 45 | 0 | 
AWS IoT SiteWise performs the following calculations for `Idle Time` at the end of each minute\.  
+ At 2:00 PM \(for 1:59 PM to 2:00 PM\)
  + There is no data for `Idle` before 2:00 PM, so no data point is calculated\.
+ At 2:01 PM \(for 2:00 PM to 2:01 PM\)
  + At 2:00:00 PM, the machine is active \(`Idle` is `0`\)\.
  + At 2:00:30 PM, the machine is idle \(`Idle` is `1`\)\.
  + `Idle` doesn't change again before the end of the interval at 2:01:00 PM, so `Idle Time` is 30 seconds\.
+ At 2:02 PM \(for 2:01 PM to 2:02 PM\)
  + At 2:01:00 PM, the machine is idle \(per the last data point at 2:00:30 PM\)\.
  + At 2:01:15 PM, the machine is still idle\.
  + `Idle` doesn't change again before the end of the interval at 2:02:00 PM, so `Idle Time` is 60 seconds\.
+ At 2:03 PM \(for 2:02 PM to 2:03 PM\)
  + At 2:02:00 PM, the machine is idle \(per the last data point at 2:01:15 PM\)\.
  + At 2:02:45 PM, the machine is active\.
  + `Idle` doesn't change again before the end of the interval at 2:03:00 PM, so `Idle Time` is 45 seconds\.
+ At 2:04 PM \(for 2:03 PM to 2:04 PM\)
  + At 2:03:00 PM, the machine is active \(per the last data point at 2:02:45 PM\)\.
  + `Idle` doesn't change again before the end of the interval at 2:04:00 PM, so `Idle Time` is 0 seconds\.

## Late data ingestion<a name="late-data"></a>

AWS IoT SiteWise supports late data ingestion up to 15 minutes in the past\. When AWS IoT SiteWise receives late data, it recalculates existing values for any metric that inputs the late data in a past window\. These recalculations result in data processing charges\.

After AWS IoT SiteWise recalculates a past window for a metric, it replaces the previous value for that window\. If you enabled notifications for that metric, AWS IoT SiteWise also emits a property value notification\. This means that you can receive a new property value update notification for the same property and timestamp for which you previously received a notification\. If your applications or data lakes consume property value notifications, you must update the previous value with the new value so that their data is accurate\.

This behavior includes data that is late due to unexpected events that temporarily prevent AWS IoT SiteWise from computing transforms\. In this case, AWS IoT SiteWise collects the failed transforms in a queue until it can compute them\. AWS IoT SiteWise also recalculates any metrics affected by the transforms\.

## Data quality in transforms and metrics<a name="data-quality"></a>

In AWS IoT SiteWise, each data point has a quality code, which can be one of the following:
+ `GOOD` – The data isn't affected by any issues\.
+ `BAD` – The data is affected by an issue such as sensor failure\.
+ `UNCERTAIN` – The data is affected by an issue such as sensor inaccuracy\.

AWS IoT SiteWise consumes only `GOOD` quality data when it computes transforms and metrics\. AWS IoT SiteWise outputs only `GOOD` quality data for successful computations\. If a computation is unsuccessful, then AWS IoT SiteWise doesn't emit a data point for that computation\. This can occur if a computation results in an undefined, infinite, or overflow value\.

For more information about how to query data and filter by data quality, see [Querying asset property values and aggregates](query-industrial-data.md)\.

## Undefined, infinite, and overflow values<a name="undefined-values"></a>

Some formula expressions \(such as `x / 0`, `sqrt(-1)`, or `log(0)`\) calculate values that are undefined in a real number system, infinite, or outside the range supported by AWS IoT SiteWise\. When an asset property's expression calculates an undefined, infinite, or overflow value, AWS IoT SiteWise discards the data point that contains that value\.

## Counting filtered data points<a name="count-filtered-data"></a>

You can use [relational functions](#expression-relational-functions) and [sum\(\)](#sum-definition) to count the number of data points for which a condition is true\.

**To count filtered data points**

1. Create a transform that uses a relational function to define a filter condition on another property\.

1. Create a metric that sums the data points where that condition is met\.

**Example: Count the number of data points where water is boiling**  
You have a measurement, `temp_c`, that provides the temperature \(in Celsius\) of water in a machine\. You can define the following transform and metric properties to count the number of data points where the water is boiling:  
+ Transform: `is_boiling = gte(temp_c, 100)` – Computes `1` if the temperature is greater than or equal to 100 degrees Celsius, otherwise computes `0`\.
+ Metric: `boiling_count = sum(is_boiling)` – Computes the number of data points where water is boiling\.
# Calculated Field Function and Operator Reference for Amazon QuickSight<a name="calculated-field-reference"></a>

You can use the following functions and operators to create calculated fields\. 

For information on aggregating calculated fields, see [Using Aggregate Functions in Calculated Fields ](adding-a-calculated-field-analysis.md#calculated-field-aggregations)\. You can only aggregate calculated fields in an analysis, not in a data set\.

**Topics**
+ [Arithmetic and Comparison Operators](#arithmetic-and-comparison-operators)
+ [Functions by Category](#functions-by-category)
+ [Function Index](#functions)
+ [Table Calculation Functions Index](#table-calculation-functions)

## Arithmetic and Comparison Operators<a name="arithmetic-and-comparison-operators"></a>

You can use the following arithmetic and comparison operators in calculated fields:
+ Addition \(\+\)
+ Subtraction \(−\)
+ Multiplication \(\*\)
+ Division \(/\)
+ Power \(^\)
+ Equal \(=\)
+ Not equal \(<>\)
+ Greater than \(>\)
+ Greater than or equal to \(>=\)
+ Less than \(<\)
+ Less than or equal to \(<=\)
+ AND
+ OR
+ NOT

Equal \(=\) and not equal \(<>\) comparisons are case\-sensitive\. For example, if the condition is `state = 'WA'` and the value in the field is **wa**, those values are not considered to be equivalent\.

Amazon QuickSight uses the standard order of operations: parentheses, exponents, multiplication, division, addition, subtraction\. 

To make lengthy calculations easier to read, you can use parenthesis to clarify groupings and precedence in calculations\. 

In the following statement, you don't need parentheses\. The multiplication statement is processed first, and then the result is added to five, returning a value of 26\. However, parentheses make the statement easier to read and thus maintain\.

```
5 + (7 * 3)
```

Because parenthesis are first in the order of operations, you can change the order in which other operators are applied\. For example, in the following statement the addition statement is processed first, and then the result is multiplied by three, returning a value of 36\.

```
(5 + 7) * 3
```

### Example: Arithmetic Operators<a name="operator-example-multiple-operators"></a>

The following example uses multiple arithmetic operators to determine a sales total after discount\.

```
(Quantity * Amount) - Discount
```

### Example: \(=\) Equal<a name="operator-example-equal"></a>

Using = performs a case\-sensitive comparison of values\. Rows where the comparison is TRUE are included in the result set\. 

In the following example, rows where the `Region` field is **South** are included in the results\. If the `Region` is **south**, these rows are excluded\.

```
Region = 'South'
```

#### <a name="operator-example-equal-false"></a>

In the following example, the comparison evaluates to FALSE\. 

```
Region = 'south'
```

#### <a name="operator-example-equal-upper"></a>

The following example shows a comparison that converts `Region` to all uppercase \(**SOUTH**\), and compares it to **SOUTH**\. This returns rows where the region is **south**, **South**, or **SOUTH**\.

```
toUpper(Region) = 'SOUTH'
```

### Example: \(<>\)<a name="operator-example-not-equal"></a>

The not equal symbol <> means *less than or greater than*\. 

So, if we say **x<>1**, then we are saying *if x is less than 1 OR if x is greater than 1*\. Both < and > are evaluated together\. In other words, *if x is any value except 1*\. Or, *x is not equal to 1*\. 

**Note**  
Use <>, not \!=\.

The following example compares `Status Code` to a numeric value\. This returns rows where the `Status Code` is not equal to **1**\.

```
statusCode <> 1
```

The following example compares multiple `statusCode` values\. In this case, active records have an activeFlag = 1\. This example returns rows where one of the following applies:
+ For active records, show rows where the status isn't 1 or 2
+ For inactive records, show rows where the status is 99 or \-1

```
( activeFlag = 1 AND (statusCode <> 1 AND statusCode <> 2) )
OR
( activeFlag = 0 AND (statusCode= 99 OR statusCode= -1) )
```

### Example: \(^\)<a name="operator-example-power"></a>

The power symbol `^` means *to the power of*\. 

The following example is a simple expression of 2 to the power of 4 or \(2 \* 2 \* 2 \* 2\)\. This returns a value of 16\.

```
2^4
```

### Example: AND, OR, and NOT<a name="operator-example-and-or-not"></a>

The following example uses AND, OR, and NOT to compare multiple expressions using conditional operators to tag top customers NOT in Washington or Oregon with a special promotion, who made more than 10 orders\. If no values are returned, the value 'n/a' is used\.

```
ifelse(( (NOT (State = 'WA' OR State = 'OR')) AND Orders > 10), 'Special Promotion XYZ', 'n/a')
```

### Example: Creating Comparison Lists Like "in" or "not in"<a name="operator-example-not-in-or-not-in"></a>

This example uses operators to create a comparison to find values that exist, or don't exist, in a specified list of values\.

The following example compares `promoCode` a specified list of values\. This example returns rows where the `promoCode` is in the list **\(1, 2, 3\)**\.

```
promoCode    = 1
OR promoCode = 2
OR promoCode = 3
```

The following example compares `promoCode` a specified list of values\. This example returns rows where the `promoCode` is NOT in the list **\(1, 2, 3\)**\.

```
NOT(promoCode = 1
OR promoCode  = 2
OR promoCode  = 3
)
```

Another way to express this is to provide a list where the `promoCode` is not equal to any items in the list\.

```
promoCode     <> 1
AND promoCode <> 2
AND promoCode <> 3
```

### Example: Creating a "between" Comparison<a name="operator-example-between"></a>

This example uses comparison operators to create a comparison showing values that exist between one value and another\.

The following example examines `OrderDate` and returns rows where the `OrderDate` is between the first day and last day of 2016\. In this case, we want the first and last day included, so we use "or equal to" on the comparison operators\. 

```
OrderDate >= "1/1/2016" AND OrderDate <= "12/31/2016"
```

## Functions by Category<a name="functions-by-category"></a>

In this section, you can find a list of the functions available in Amazon QuickSight sorted by category\.

**Topics**
+ [Aggregate Functions](#aggregate-functions)
+ [Conditional Functions](#conditional-functions)
+ [Date Functions](#date-functions)
+ [Numeric Functions](#numeric-functions)
+ [String Functions](#string-functions)
+ [Table Calculations](#table-calculations)

### Aggregate Functions<a name="aggregate-functions"></a>

The aggregate functions for calculated fields in Amazon QuickSight include the following\. These are only available in SPICE, while you are in the analysis screen\. Each of these functions returns values grouped by the chosen dimension or dimensions\.
+ [avg](avg-function.md) averages the set of numbers in the specified measure\.
+ [count](count-function.md) calculates the number of values in a dimension or measure\.
+ [distinct\_count](distinct_count-function.md) calculates the number of distinct values in a dimension or measure\.
+ [max](max-function.md) returns the maximum value of the specified measure\.
+ [min](min-function.md) returns the minimum value of the specified measure\. 
+ [sum](sum-function.md) adds the set of numbers in the specified measure\.

### Conditional Functions<a name="conditional-functions"></a>

The conditional functions for calculated fields in Amazon QuickSight include the following:
+ [`coalesce`](coalesce-function.md) returns the value of the first argument that is not null\.
+ [`ifelse`](ifelse-function.md) evaluates a set of *if*, *then* expression pairings, and returns the value of the *then* argument for the first *if* argument that evaluates to true\.
+ [`isNotNull`](isNotNull-function.md) evaluates an expression to see if it is not null\.
+ [`isNull`](isNull-function.md) evaluates an expression to see if it is null\. If the expression is null, `isNull` returns true, and otherwise it returns false\.
+ [`nullIf`](nullIf-function.md) compares two expressions\. If they are equal, the function returns null\. If they are not equal, the function returns the first expression\.

### Date Functions<a name="date-functions"></a>

The date functions for calculated fields in Amazon QuickSight include the following:
+ [`addDateTime`](addDateTime-function.md) adds or subtracts a unit of time to the date or time provided\.
+ [`dateDiff`](dateDiff-function.md) returns the difference in days between two date fields\. \(SPICE enabled\)
+ [`epochDate`](epochDate-function.md) converts an epoch date into a standard date\. \(SPICE enabled\)
+ [`extract`](extract-function.md) returns a specified portion of a date value\. \(SPICE enabled\)
+ [`formatDate`](formatDate-function.md) formats a date using a pattern you specify\. 
+ [`now`](now-function.md) returns the current date and time, using either settings for a database, or UTC for file and Salesforce\. 
+ [`truncDate`](truncDate-function.md) returns a date value that represents a specified portion of a date\. \(SPICE enabled\)

### Numeric Functions<a name="numeric-functions"></a>

The numeric functions for calculated fields in Amazon QuickSight include the following:
+ [`ceil`](ceil-function.md) rounds a decimal value to the next highest integer\. \(SPICE enabled\)
+ [`decimalToInt`](decimalToInt-function.md) converts a decimal value to an integer\. \(SPICE enabled\)
+ [`floor`](floor-function.md) decrements a decimal value to the next lowest integer\. \(SPICE enabled\)
+ [`intToDecimal`](intToDecimal-function.md) converts an integer value to a decimal\. \(SPICE enabled\)
+ [`round`](round-function.md) rounds a decimal value to the closest integer or, if scale is specified, to the closest decimal place\. \(SPICE enabled\)

### String Functions<a name="string-functions"></a>

The string \(text\) functions for calculated fields in Amazon QuickSight include the following:
+ [`concat`](concat-function.md) concatenates two or more strings\.
+ [`left`](left-function.md) returns the specified number of leftmost characters from a string\. 
+ [`locate`](locate-function.md) locates a substring within another string, and returns the number of characters before the substring\.
+ [`ltrim`](ltrim-function.md) removes preceding whitespace from a string\.
+ [`parseDate`](parseDate-function.md) parses a string to determine if it contains a date value, and returns the date if found\.
+ [`parseDecimal`](parseDecimal-function.md) parses a string to determine if it contains a decimal value\. 
+ [`parseInt`](parseInt-function.md) parses a string to determine if it contains an integer value\.
+ [`parseJson`](parseJson-function.md) parses values from a native JSON or from a JSON object in a text field\.
+ [`replace`](replace-function.md) replaces part of a string with a new string\.
+ [`right`](right-function.md) returns the specified number of rightmost characters from a string\.
+ [`rtrim`](rtrim-function.md) removes following whitespace from a string\.
+ [`split`](split-function.md) splits a string into an array of substrings, based on a delimiter that you choose, and returns the item specified by the position\.
+ [`strlen`](strlen-function.md) returns the number of characters in a string\.
+ [`substring`](substring-function.md) returns the specified number of characters in a string, starting at the specified location\.
+ [`toLower`](toLower-function.md) formats a string in all lowercase\.
+ [`toString`](toString-function.md) formats the input expression as a string\.
+ [`toUpper`](toUpper-function.md) formats a string in all uppercase\.
+ [`trim`](trim-function.md) removes both preceding and following whitespace from a string\. 

### Table Calculations<a name="table-calculations"></a>

Table calculations form a group of functions that provide context in an analysis\. They provide support for enriched aggregated analysis\. By using these calculations, you can address common business scenarios such as calculating percentage of total, running sum, difference, common baseline, and rank\. 

When you are analyzing data in a specific visual, you can apply table calculations to the current set of data to discover how dimensions influence measures or each other\. Visualized data is your result set based on your current data set, with all the filters, field selections, and customizations applied\. To see exactly what this result set is, you can export your visual to comma\-separated value \(CSV\) format\. A table calculation function performs operations on the data to reveal relationships between fields\. 

The table calculations available in Amazon QuickSight for both [SPICE](welcome.md#spice) and direct query data include the following:
+ [`runningSum`](runningSum-function.md) calculates a running sum for a measure\. 
+ [`percentOfTotal`](percentOfTotal-function.md) calculates the percentage a measure contributes to the total\. 
+ [`difference`](difference-function.md) calculates the difference between a measure based on one set of partitions and sorts, and a measure based on another\. 
+ [`percentDifference`](percentDifference-function.md) calculates the percentage difference between the current value and a comparison value\. 
+ [`rank`](rank-function.md) calculates the rank of a measure or a dimension\. 
+ [`denseRank`](denseRank-function.md) calculates the rank of a measure or a dimension, ignoring duplicates\. 
+ [`percentile`](percentileRank-function.md) calculates the rank of a measure or a dimension, based on percentile\.
+ [`sumOver`](sumOver-function.md) calculates the sum of a measure over one or more dimensions\. 
+ [`avgOver`](avgOver-function.md) calculates the average of a measure over one or more dimensions\. 
+ [`minOver`](minOver-function.md) calculates the minimum of a measure over one or more dimensions\. 
+ [`maxOver`](maxOver-function.md) calculates the maximum of a measure over one or more dimensions\. 
+ [`countOver`](countOver-function.md) calculates the count of a measure over one or more dimensions\. 
+ [`lead`](lead-function.md) calculates the lead \(following\) value for a measure\. 
+ [`lag`](lag-function.md) calculates the lag \(previous\) value for a measure\. 

## Function Index<a name="functions"></a>

In this section, you can find a list of functions available in Amazon QuickSight\. Some functions are available in [SPICE](welcome.md#spice), while you are in the analysis screen\.

To view a list of functions sorted by category, with brief definitions, see [Functions by Category](#functions-by-category)\.

**Topics**
+ [`addDateTime`](addDateTime-function.md)
+ [`ceil`](ceil-function.md)
+ [`coalesce`](coalesce-function.md)
+ [`concat`](concat-function.md)
+ [`decimalToInt`](decimalToInt-function.md)
+ [`dateDiff`](dateDiff-function.md)
+ [`epochDate`](epochDate-function.md)
+ [`extract`](extract-function.md)
+ [`floor`](floor-function.md)
+ [`formatDate`](formatDate-function.md)
+ [`ifelse`](ifelse-function.md)
+ [`intToDecimal`](intToDecimal-function.md)
+ [`isNotNull`](isNotNull-function.md)
+ [`isNull`](isNull-function.md)
+ [`left`](left-function.md)
+ [`locate`](locate-function.md)
+ [`ltrim`](ltrim-function.md)
+ [`now`](now-function.md)
+ [`nullIf`](nullIf-function.md)
+ [`parseDate`](parseDate-function.md)
+ [`parseDecimal`](parseDecimal-function.md)
+ [`parseInt`](parseInt-function.md)
+ [`parseJson`](parseJson-function.md)
+ [`replace`](replace-function.md)
+ [`right`](right-function.md)
+ [`round`](round-function.md)
+ [`rtrim`](rtrim-function.md)
+ [`split`](split-function.md)
+ [`strlen`](strlen-function.md)
+ [`substring`](substring-function.md)
+ [`toLower`](toLower-function.md)
+ [`toString`](toString-function.md)
+ [`toUpper`](toUpper-function.md)
+ [`trim`](trim-function.md)
+ [`truncDate`](truncDate-function.md)

## Table Calculation Functions Index<a name="table-calculation-functions"></a>

When you are analyzing data in a specific visual, you can apply table calculations to the current set of data to discover how dimensions influence measures or each other\. *Visualized data* is your result set based on your current data set, with all the filters, field selections, and customizations applied\. To see exactly what this result set is, you can export your visual to comma\-separated value \(CSV\) format\. A *table calculation function* performs operations on the data to reveal relationships between fields\. 

In this section, you can find a list of the functions available in table calculations that you can perform on visualized data in Amazon QuickSight\. 

To view a list of functions sorted by category, with brief definitions, see [Functions by Category](#functions-by-category)\.

**Topics**
+ [`runningSum`](runningSum-function.md)
+ [`percentOfTotal`](percentOfTotal-function.md)
+ [`difference`](difference-function.md)
+ [`percentDifference`](percentDifference-function.md)
+ [`rank`](rank-function.md)
+ [`denseRank`](denseRank-function.md)
+ [`percentile`](percentileRank-function.md)
+ [`sumOver`](sumOver-function.md)
+ [`avgOver`](avgOver-function.md)
+ [`minOver`](minOver-function.md)
+ [`maxOver`](maxOver-function.md)
+ [`countOver`](countOver-function.md)
+ [`lead`](lead-function.md)
+ [`lag`](lag-function.md)

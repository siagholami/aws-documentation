# Searching for Numbers in Amazon CloudSearch<a name="searching-numbers"></a>

You can use structured queries to search any search enabled numeric field for a particular value or [range of values](searching-ranges.md)\. Amazon CloudSearch supports four numeric field types: `double`, `double-array`, `int`, and `int-array`\. For more information, see [Configuring Index Fields](configuring-index-fields.md)\.

The basic syntax for searching a field for a single value is **FIELD**:**VALUE**\. For example, `year:2010` searches the sample movie data for movies released in 2010\.

You must use the structured query parser to use the field syntax\. Note that numeric values are *not* enclosed in quotes—quotes designate a value as a string\. To search for a range of values, use a comma \(,\) to separate the upper and lower bounds, and enclose the range using brackets or braces\. For more information, see [Searching for a Range of Values](searching-ranges.md)\. 

In a compound query, you use the `term` operator syntax to search for a single value: `(term field=year 2010)`\.
# Searching for a Range of Values in Amazon CloudSearch<a name="searching-ranges"></a>

You can use structured queries to search a field for a range of values\. To specify a range of values, use a comma \(,\) to separate the upper and lower bounds and enclose the range using brackets or braces\. A square brace, \[ or \], indicates that the bound is included in the range, a curly brace, \{ or \}, excludes the bound\. 

For example, to search the sample data set for movies released from 2008 to 2010 \(inclusive\), specify the range as `[2008,2010]`\.

To specify an open\-ended range, omit the bound\. For example, `year:[2002,}` matches all movies released from 2002 onward, and `year:{,1970]` matches all movies released through 1970\. When you omit a bound, you must use a curly brace\.

In a compound query, you use the `range` operator syntax to search for a range of values; for example: `(range field=year [1967,})`\.

## Searching for a Date Range<a name="searching-ranges-dates"></a>

To search for a range of dates \(or times\) in a `date` field, you use the same bracketed range syntax that you use for numeric values, but you must enclose the date string in single quotes\. For example, the following request searches the movie data for all movies with a release date of January 1, 2013 or later:

```
q.parser=structured&q=release_date:['2013-01-01T00:00:00Z',}
```

Use the following syntax to search for a fixed range:

```
q.parser=structured&q=release_date:['2013-01-01T00:00:00Z','2013-01-02T23:59:59Z']
```

## Searching for a Location Range<a name="searching-ranges-locations"></a>

You can perform a bounding box search by searching for a range of locations\. To search for a range of locations in a `latlon` field, you use the same bracketed range syntax that you use for numeric values, but you must enclose the latitude/longitude pair in single quotes\. 

For example, if you include a `location` field in each document, you could specify your bounding box filter as `location:['nn.n,nn.n','nn.n,nn.n']`\. In the following example, the matches for *restaurant* are filtered so that only matches within the downtown area of Paso Robles, CA are included in the results\. 

```
q='restaurant'&fq=location:['35.628611,-120.694152','35.621966,-120.686706']&q.parser=structured
```

For more information, see [Searching and Ranking Results by Geographic Location in Amazon CloudSearch](searching-locations.md)\.

## Searching for a Text Range<a name="searching-ranges-text"></a>

You can also search a text or literal field for a range of values using the bracketed range syntax\. Like dates, the text strings must be enclosed in single quotes\. For example, the following request searches the movie data for a range of document IDs\. To reference a document's ID, you use the special field name `_id`\.

```
_id:['tt1000000','tt1005000']
```
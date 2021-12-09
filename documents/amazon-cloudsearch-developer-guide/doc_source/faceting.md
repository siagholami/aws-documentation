# Getting and Using Facet Information in Amazon CloudSearch<a name="faceting"></a>

**Topics**
+ [Getting Facet Information in Amazon CloudSearch](#getting-facet-info)
+ [Using Facet Information in Amazon CloudSearch](#using-facet-info)

A *facet* is an index field that represents a category that you want to use to refine and filter search results\. When you submit search requests to Amazon CloudSearch, you can request facet information to find out how many documents share the same value in a particular field\. You can display this information along with the search results, and use it to enable users to interactively refine their searches\. \(This is often referred to as faceted navigation or faceted search\.\)

You can get facet information for any facet\-enabled field by specifying the `facet.FIELD` parameter in your search request\. By default, Amazon CloudSearch returns facet counts for the top 10 values\. For more information about enabling a field to return facets, see [Configuring Index Fields](configuring-index-fields.md)\. For a description of the `facet.FIELD` parameter, see [Search Request Parameters](search-api.md#search-request-parameters) in the Search API reference\.

You can specify facet options to control the sorting of the facet values for each field, limit the number of facet values returned, or choose what facet values to count and return\. 

## Getting Facet Information in Amazon CloudSearch<a name="getting-facet-info"></a>

To get facet information for a field, you use the `facet.FIELD` parameter\. `FIELD` is the name of a facet\-enabled field\. You specify facet options as a JSON object\. If the JSON object is empty \(`facet.FIELD={}`\), facet counts are computed for all field values, the facets are sorted by facet count, and the top 10 facets are returned in the results\. You can request facet information for multiple fields in the same request\.

You can retrieve facet information in two ways:
+ `sort`—Returns facet information sorted either by facet counts or facet values\.
+ `buckets`—Returns facet information for particular facet values or ranges\.

### Sorting Facet Information<a name="sorting-facets"></a>

You specify the `sort` option to control how the facet information is sorted\. There are two sort options: `count` and `bucket`: 
+ Use `count` to sort the facets by facet counts\. For example, `facet.year={sort:'count'}` counts the number of matches that have the same year value and sorts the facet information by that number\. 
+ Use `bucket` to sort the facets by the facet values\. For example, `facet.year={sort:'bucket'}` \. 

When you use the `sort` option, you can specify the `size` option to control the maximum number of facet values returned in the results\. The `size` option is valid only when you use the `sort` option\.

In the following example, facet information is calculated for the `genres` field, the genres are sorted by facet value, and the first 5 genres are returned in the results:

```
facet.genres={sort:'bucket', size:5}
```

### Bucketing Facet Information<a name="bucketing-facets"></a>

You can explicitly specify the facet values or ranges that you want to count by using the `buckets` option\. Buckets are specified as an array of values or ranges, for example, `facet.color={buckets:["red","green","blue"]}`\. 

 To specify a range of values, use a comma \(,\) to separate the upper and lower bounds and enclose the range using brackets or braces\. A square bracket, \[ or \], indicates that the bound is included in the range, a curly brace, \{ or \}, excludes the bound\. You can omit the upper or lower bound to specify an open\-ended range\. When omitting a bound, you must use a curly brace\. For example, `facet.year={buckets:["[1970,1979]","[1980,1989]", "[1990,1999]","[2000,2009]","[2010,}"]}`\. For a timestamp, you can use `q=-poet&facet.release_date={buckets:["[\'1980-01-01T00:00:00Z\',\'1986-01-01T00:00:01Z\']"]}`\.

The `sort` and `size` options are not valid if you specify buckets\.

Amazon CloudSearch supports two methods for calculating bucket counts, `filter` and `interval`\. By default, the `filter` method is used, which simply submits an additional filter query for each bucket to get the bucket counts\. While this works well in many cases, if you have a high update rate or are retrieving a large number of facets, performance can suffer because those queries can't take advantage of the internal caching mechanism\. 

 If you're experiencing slow query performance for bucketed facets, try setting the buckets method to `interval`, which post\-processes the result set rather than submitting multiple queries:

```
facet.year={buckets:["[1970,1979]","[1980,1989]","[1990,1999]"],method:"interval"}
```

We recommend doing your own performance testing to determine which method is best for your application\. In general, the `filter` method is faster if you have a fairly low update rate and aren't retrieving a large number of buckets\. However, if you have a high update rate or a lot of buckets, using the `interval` method to post\-process the result set can result in significantly faster query performance\.

## Using Facet Information in Amazon CloudSearch<a name="using-facet-info"></a>

You can display facet information to enable users to more easily browse search results and identify the information they are interested in\. For example, if a user is trying to find one of the Star Trek movies, but can't remember the full title, he might start by searching for *star*\. If you want to display top facets for *genre*, you would include `facet.FIELD` in the query, along with the number of facet values that you want to retrieve for each facet:

```
search?q=star&facet.genres={sort:'count',size:5}&format=xml&return=_no_fields
```

The preceding example gives you the following information in the search response:

```
<results>
    <status rid="v7r9hs8oFQqMHnk=" time-ms="3"/>
    <hits found="85" start="0">
        <hit id="tt1411664"/>
        <hit id="tt1911658"/>
        <hit id="tt0086190"/>
        <hit id="tt0120601"/>
        <hit id="tt2141761"/>
        <hit id="tt1674771"/>
        <hit id="tt0056687"/>
        <hit id="tt0397892"/>
        <hit id="tt0258153"/>
        <hit id="tt0796366"/>
    </hits>
    <facets>
        <facet name="genres">
            <bucket value="Comedy" count="41"/><bucket value="Drama" count="35"/>
            <bucket value="Adventure" count="29"/>
            <bucket value="Sci-Fi" count="24"/>
            <bucket value="Action" count="20"/>
        </facet>
    </facets>
</results>
```

### Multi\-Select Facets in Amazon CloudSearch<a name="multi-select-facets"></a>

If you want to display the available facets and enable users to select multiple values to refine the results, you can submit one request to get the documents that match the facet constraints and additional requests to get the facet counts\. 

For example, in the sample movie data, the `genres`, `rating`, and `year` fields are facet enabled\. If the user searches for the term *poet*, you can submit the following request to get the matching movies and the facet counts for the `genres`, `rating`, and `year` fields:

```
q=poet&facet.genres={}&facet.rating={}&facet.year={}&return=_no_fields
```

Because no `facet.FIELD` options are specified, Amazon CloudSearch counts all of the facet values and returns the top 10 values for each facet:

```
{
  "status" : {
    "rid" : "it3T8tIoDgrUSvA=",
    "time-ms" : 5
  },
  "hits" : {
    "found" : 14,
    "start" : 0,
    "hit" : [ 
       {"id" : "tt0097165"}, 
       {"id" : "tt0059113"}, 
       { "id" : "tt0108174"}, 
       {"id" : "tt1067765"}, 
       { "id" : "tt1311071"}, 
       {"id" : "tt0810784"}, 
       {"id" : "tt0819714"}, 
       {"id" : "tt0203009"}, 
       {"id" : "tt0114702"}, 
       {"id" : "tt0107840"} ]
  },
  "facets" : {
    "genres" : {
      "buckets" : [ 
         {"value" : "Drama","count" : 12}, 
         {"value" : "Romance","count" : 9}, 
         {"value" : "Biography", "count" : 4}, 
         {"value" : "Comedy","count" : 2}, 
         {"value" : "Thriller","count" : 2}, 
         {"value" : "War","count" : 2}, 
         {"value" : "Crime","count" : 1}, 
         {"value" : "History","count" : 1}, 
         {"value" : "Musical","count" : 1} ]
    },
    "rating" : {
      "buckets" : [ 
         {"value" : "6.3","count" : 3}, 
         {"value" : "6.2","count" : 2}, 
         {"value" : "7.1","count" : 2}, 
         {"value" : "7.9","count" : 2}, 
         {"value" : "5.3","count" : 1}, 
         {"value" : "6.1""count" : 1}, 
         {"value" : "6.4","count" : 1}, 
         {"value" : "6.9","count" : 1}, 
         {"value" : "7.6","count" : 1} ]
    },
    "year" : {
      "buckets" : [ 
         {"value" : "2013","count" : 3}, 
         {"value" : "1993","count" : 2}, 
         {"value" : "1965","count" : 1}, 
         {"value" : "1989","count" : 1}, 
         {"value" : "1995","count" : 1}, 
         {"value" : "2001","count" : 1}, 
         {"value" : "2004","count" : 1}, 
         {"value" : "2006","count" : 1}, 
         {"value" : "2008","count" : 1}, 
         {"value" : "2009","count" : 1} ]
    }
  }
}
```

When the user refines the search by selecting facet values, you use those facet selections to filter the results\. For example, if the user selects *2013*, *2012*, and *1993*, the following request gets the matching movies released during those years:

```
q=poet&fq=(or year:2013 year:2012 year:1993)&facet.genres={}&facet.rating={}
&facet.year={}&return=_no_fields
```

This gets the documents that match the user's selection and the facet counts with the filter applied:

```
{
  "status" : {
    "rid" : "zMP38tIoDwrUSvA=",
    "time-ms" : 6
  },
  "hits" : {
    "found" : 6,
    "start" : 0,
    "hit" : [ 
       {"id" : "tt0108174"}, 
       {"id" : "tt1067765"}, 
       {"id" : "tt1311071"}, 
       {"id" : "tt0107840"}, 
       {"id" : "tt1462411"}, 
       {"id" : "tt0455323"} ]
  },
  "facets" : {
    "genres" : {
      "buckets" : [ 
         {"value" : "Drama","count" : 4}, 
         {"value" : "Romance","count" : 3}, 
         {"value" : "Comedy","count" : 2}, 
         {"value" : "Thriller","count" : 2}, 
         {"value" : "Biography","count" : 1}, 
         {"value" : "Crime","count" : 1} ]
    },
    "rating" : {
      "buckets" : [ 
         {"value" : "6.3","count" : 2}, 
         {"value" : "5.3","count" : 1}, 
         {"value" : "6.2","count" : 1}, 
         {"value" : "6.4","count" : 1}, 
         {"value" : "7.1","count" : 1} ]
    },
    "year" : {
      "buckets" : [ 
         {"value" : "2013","count" : 3}, 
         {"value" : "1993","count" : 2}, 
         {"value" : "2012","count" : 1} ]
    }
  }
}
```

This is what you want to show for the genres and ratings\. However, to enable the user to change the year filter, you need to get the facet counts for the years that *aren't* selected\. To do this, you submit a second request to retrieve the facet counts for the year field without the filter:

```
q=poet&facet.year={}&size=0
```

There's no need to retrieve the matching documents, so the `size` parameter is set to zero to minimize the request latency\. The request returns just the facet information for the `year` field:

```
{
  "status" : {
    "rid" : "x/7r0NIoRwqlHfo=",
    "time-ms" : 4
  },
  "hits" : {
    "found" : 14,
    "start" : 0,
    "hit" : [ ]
  },
  "facets" : {
    "year" : {
      "buckets" : [ 
         {"value" : "2013","count" : 3}, 
         {"value" : "1993","count" : 2}, 
         {"value" : "1965","count" : 1}, 
         {"value" : "1989","count" : 1}, 
         {"value" : "1995","count" : 1}, 
         {"value" : "2001","count" : 1}, 
         {"value" : "2004","count" : 1}, 
         {"value" : "2006","count" : 1}, 
         {"value" : "2008","count" : 1}, 
         {"value" : "2009","count" : 1} ]
    }
  }
}
```

To minimize the response time, you can send this request in parallel with the request to get the filtered results\. However, keep in mind that these additional requests can impact your overall query performance, and it might be necessary to scale your domain up to handle the additional traffic\. \(For more information about scaling, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.\)

If the user further refines the search by selecting a genre or rating, you add that to the filter criteria to get the matching documents\. For example, the following request gets the movies released in 2013, 2012, or 1993 that have a rating of 6\.3:

```
q=poet&fq=(and rating:6.3 (or year:2013 year:2012 year:1993))&facet.genres={}&return=_no_fields
```

Getting the facet information for genres in this request returns the facet counts with the rating and year filters applied:

```
{
  "status" : {
    "rid" : "l66b89IoEArUSvA=",
    "time-ms" : 6
  },
  "hits" : {
    "found" : 2,
    "start" : 0,
    "hit" : [ 
       {"id" : "tt1462411"}, 
       {"id" : "tt0455323"} ]
  },
  "facets" : {
    "genres" : {
      "buckets" : [ 
         {"value" : "Drama","count" : 2} ]
    }
  }
}
```

To enable the user to select a different rating, you submit an additional request to get the rating facet counts with only the year filter applied: 

```
q=poet&fq=(or year:2013 year:2012 year:1993)&facet.rating={}&size=0
```

This request gets the following response:

```
{
  "status" : {
    "rid" : "jqWj89IoEQrUSvA=",
    "time-ms" : 5
  },
  "hits" : {
    "found" : 6,
    "start" : 0,
    "hit" : [ ]
  },
  "facets" : {
    "rating" : {
      "buckets" : [ 
         {"value" : "6.3","count" : 2}, 
         {"value" : "5.3","count" : 1}, 
         {"value" : "6.2","count" : 1}, 
         {"value" : "6.4","count" : 1}, 
         {"value" : "7.1","count" : 1} ]
    }
  }
}
```

Similarly, you need another request to get the year facet counts with only the rating filter applied:

```
q=poet&fq=rating:6.3&facet.year={}&size=0
```

This request gets the following response:

```
{
  "status" : {
    "rid" : "4L6F8NIoDQrUSvA=",
    "time-ms" : 4
  },
  "hits" : {
    "found" : 3,
    "start" : 0,
    "hit" : [ ]
  },
  "facets" : {
    "year" : {
      "buckets" : [ 
         {"value" : "1995","count" : 1}, 
         {"value" : "2012","count" : 1}, 
         {"value" : "2013","count" : 1} ]
    }
  }
}
```
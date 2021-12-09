# Searching and Ranking Results by Geographic Location in Amazon CloudSearch<a name="searching-locations"></a>

If you store locations in your document data using a `latlon` field, you can use the `haversin` function in an Amazon CloudSearch expression to compute the distance between two locations\. Storing locations with your document data also enables you to easily search within particular areas\.

**Topics**
+ [Searching Within an Area in Amazon CloudSearch](#within-area)
+ [Sorting Results by Distance in Amazon CloudSearch](#sorting-by-distance)

## Searching Within an Area in Amazon CloudSearch<a name="within-area"></a>

To associate a location with a search document, you can store the location's latitude and longitude in a `latlon` field using decimal degree notation\. The values are specified as a comma\-separated list, `lat,lon`—for example `35.628611,-120.694152`\. Associating a location with a document enables you to easily constrain search hits to a particular area with the `fq` parameter\. 

**To use a bounding box to constrain results to a particular area**

1. Determine the latitude and longitude of the upper\-left and lower\-right corners of the area you are interested in\. 

1. Use the `fq` parameter to filter the matching documents using those bounding box coordinates\. For example, if you include a `location` field in each document, you could specify your bounding box filter as `fq=location:['nn.n,nn.n','nn.n,nn.n'] `\. In the following example, the matches for *restaurant* are filtered so that only matches within the downtown area of Paso Robles, CA are included in the results\. 

   ```
   q='restaurant'&fq=location:['35.628611,-120.694152','35.621966,-120.686706']&q.parser=structured
   ```

## Sorting Results by Distance in Amazon CloudSearch<a name="sorting-by-distance"></a>

You can define an expression as part of your search request to sort results by distance\. Amazon CloudSearch expressions support the `haversin` function, which computes the great\-circle distance between two points on a sphere using the latitude and longitude of each point\. \(For more information, see [Haversine formula](http://en.wikipedia.org/wiki/Haversine_formula)\.\) The resulting distance is returned in kilometers\.

To calculate the distance between each matching document and the user, you pass the user's location into the `haversin` function and reference the document locations stored in a `latlon` field\. You specify the user latitude and longitude in decimal degree notation and access the latitude and longitude stored in a `latlon` as `FIELD.latitude` and `FIELD.longitude`\. For example, `expr.distance=haversin(userlat,userlon, location.latitude,location.longitude)`\. 

To use the expression to sort the search results, you specify the `sort` parameter\.

For example, the following query searches for restaurants and sorts the results by distance from the user\. 

```
q=restaurant&expr.distance=haversin(35.621966,-120.686706,location.latitude,location.longitude)&sort=distance asc
```

Note that you must explicitly specify the sort direction, `asc` or `desc`\. 

You can include the distance calculated for each document in the search results by specifying the name of the expression with the `return` parameter\. For example, `return=distance`\.

You can also use the distance value in more complex expressions to take other characteristics into account, such as a document's relevance `_score`\. In the following example, a second rank expression uses both the document's calculated `distance` and its relevance `_score`\.

```
expr.distance=haversin(38.958687,-77.343149,latitude,longitude)&expr.myrank=_score/log10(distance)&sort=myrank+desc
```

**Tip**  
For these sample queries to work, you must [configure your index](configuring-index-fields.md) with a `latlon` field and have `location` data in your documents:  

```
{
  "fields": {
    "location": "40.05830,-74.40570"
  }
}
```
If the field doesn't exist, you might receive the following error message when performing a search:  

```
Syntax error in query: field (location) does not exist.
```

For more information about using expressions to sort search results, see [Controlling Search Results](controlling-search-results.md)\.
# Retrieving Data from Index Fields in Amazon CloudSearch<a name="retrieving-data"></a>

By default, the search results include all return enabled fields\. To return a subset of the return enabled fields or return expression values for the matching documents, you can specify the `return` parameter\. To return only the document IDs for the matching documents, specify `return=_no_fields`\. To retrieve the relevance score calculated for each document, specify `return=_score`\. You specify multiple return fields as a comma separated list\. For example, `return=title,_score` returns just the title and relevance score of each matching document\.

Only fields configured to be return enabled can be included in the search results\. Making fields return enabled increases the size of your index, which can increase the cost of running your domain\. You should only store document data in the search index by making fields return enabled when it's difficult or costly to retrieve the data using other means\. Because it can take some time to apply document updates across the domain, you should retrieve critical data such as pricing information by using the returned document IDs instead of returned from the index\.

For example, to include the *title* and relevance *\_score* in the search results, specify the following:

```
search?q=star -wars&return=title,_score&size=3
```

The specified fields are included with each hit in the search results:

```
{
  "status" : {
    "rid" : "y9Dzhs8oEwqMHnk=",
    "time-ms" : 2
  },
  "hits" : {
    "found" : 76,
    "start" : 0,
    "hit" : [ {
      "id" : "tt1411664",
      "fields" : {
        "title" : "Bucky Larson: Born to Be a Star",
        "_score" : "9.231539"
      }
    }, {
      "id" : "tt1911658",
      "fields" : {
        "title" : "The Penguins of Madagascar",
        "_score" : "7.1051397"
      }
    }, {
      "id" : "tt0120601",
      "fields" : {
        "title" : "Being John Malkovich",
        "_score" : "6.206055"
      }
    } ]
  }
}
```
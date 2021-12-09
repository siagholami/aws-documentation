# Paginating Results in Amazon CloudSearch<a name="paginating-results"></a>

By default, Amazon CloudSearch returns the top ten hits according to the specified sort order\. To control the number of hits returned in a result set, you use the `size` parameter\. 

To get the next set of hits beginning from a particular offset, you can use the `start` parameter\. Note that the result set is zero\-based—the first result is at index 0\. You can get the first 10,000 hits using the `size` and `start` parameters\. To page through more than 10,000 hits, use the `cursor` parameter\. For more information, see [Deep Paging Beyond 10,000 Hits ](#deep-paging)\.

For example, `search?q=wolverine` returns the first 10 hits that contain *wolverine*, starting at index 0\. The following example sets the `start` parameter to 10 to get the next set of ten hits\.

```
search?q=wolverine&start=10
```

If you want to retrieve 25 hits at a time, set the `size` parameter to 25\. To get the first set of hits, you don't have to set the `start` parameter\. 

```
search?q=wolverine&size=25
```

For subsequent requests, use the `start` parameter to retrieve the set of hits you want\. For example, to get the third batch of 25 hits, specify the following:

```
search?q=wolverine&size=25&start=50
```

## Deep Paging Beyond 10,000 Hits in Amazon CloudSearch<a name="deep-paging"></a>

Using `size` and `start` to page through results works well if you only need to access the first few pages of results\. However, if you need to page through thousands of hits, using a cursor is more efficient\. To page through more than 10,000 hits, you must use a `cursor`\. \(You can only access the first 10,000 hits using the `start` and `size` parameters\.\)

To page through results using a cursor, you specify `cursor=initial` in your initial search request and include the `size` parameter to specify how many hits you want to get\. Amazon CloudSearch returns a cursor value in the response that you use to get the next set of hits\. Cursors return sequential sets of hits; however, you can use them to simulate random access of a deep page if you need to\. Keep in mind that cursors are intended to be used to page through a result set within a reasonable amount of time of the initial request\. Using a stale cursor can return stale results if updates have been posted to the index in the interim\. 

**Important**  
When you use a cursor to page through a result set that is sorted by document score \(`_score`\), you can get inconsistent results if the index is updated between requests\. This can also occur if your domain's replication count is greater than one, because updates are applied in an eventually consistent manner across the instances in the domain\. If this is an issue, avoid sorting the results by score\. You can either use the `sort` option to sort by a particular field, or use `fq` instead of `q` to specify your search criteria\. \(Document scores are not calculated for filter queries\.\)

For example, the following request sets the `cursor` value to `initial` and the `size` parameter to `100` to get the first set of hits\.

```
search?q=-star&cursor=initial&size=100
```

The cursor for the next set of hits is included in the response\.

```
{
    "status": {
        "rid": "z67+3L0oHgo6swY=",
        "time-ms": 7
    },
    "hits": {
        "found": 1649,
        "start": 0,
        "cursor": "Vb-HSS4YQW9JSVFKeFpvQ2wwZERBek16SXpOems9Aw",
        "hit": [
            {
                "id": "tt0397892"
            },
            .
            .
            .
            {
                "id": "tt0332379"
            }
        ]
    }
}
```

In the next request, the `cursor` parameter specifies the returned cursor value\.

```
search?q=-star&cursor=Vb-HSS4YQW9JSVFKeFpvQ2wwZERBek16SXpOems9Aw&size=100
```
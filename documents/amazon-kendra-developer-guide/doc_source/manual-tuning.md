--------

--------

# Manually tuning an index<a name="manual-tuning"></a>

Amazon Kendra queries produce search results ranked by their relevance\. The searchable fields in the index all contribute to this ranking\. 

You can modify the effect of field or attribute on the relevance of a document through *relevance tuning*\. When you use relevance tuning, a result is given a boost in the response when the query includes terms that match the field or attribute\. You also specify how much of a boost the document receives when there is a match\. Relevance tuning doesn't cause Amazon Kendra to include a document in the query response, it is only one of the factors that Amazon Kendra uses to determine the relevance of a document\.

You can boost certain fields in your index to assign more importance to specific responses\. Amazon Kendra enables you to tune for specific data sources or document freshness\. For example when searching for "When is re:Invent?" you boost the relevance of document freshness so that the latest date is the suggested answer\. Or, in an index of research reports, you could boost a more reputable data source\.

Amazon Kendra also supports boosting documents based on votes or view counts which is common in forums and other support knowledge bases\. You can combine boosts to, for example, boost documents that are not only viewed more but that are also more recent, like trending news or updates\.

You set the amount of boost that a document receives using the `Importance` parameter\. The larger the number in this parameter, the more the field or attribute will boost the relevance of the document\. When you are tuning your index, you should increase the value of the `Importance` parameter in small increments until you get the effect that you want\. Query your index and compare the results to previous queries to determine if you are getting improved search results\.

You can specify date, number, or string fields and attributes to tune an index\. Each type of field or attribute has specific criteria for when it boosts a result\.
+ **Date fields and attributes** – There are three specific criteria for date fields, `Duration`, `Freshness` and rank order\.

   

   `Duration` sets the time period that the boost applies to\. For example, if you set the time period to 86400 seconds \(1 day\) the boost begins to drop off after one day\. The higher the importance, the faster the boost effect drops off\.

   

  `Freshness` indicates that the field or attribute should be used to determine how "fresh" a document is\. For example, if document 1 was created on November 14, and document 2 was created on November 5, document 1 is "fresher" than document 2\. The fresher the document, the more this boost is applied\. You can only have one `Freshness` field in your index\. 

   

  Rank order applies the boost in either ascending or descending order\. When you use `ASCENDING`, later dates have precedence\. If you specify `DESCENDING`, earlier dates have precedence\.

   
+ **Number fields and attributes** – For number fields or attributes you can specify the rank order that Amazon Kendra should use when determining the relevance of the field or attribute\. If you specify `ASCENDING` larger numbers are given precedence\. If you specify `DESCENDING`, lower numbers have precedence\.

   
+ **String fields and attributes** – For string fields or attributes you can create subcategories of a field to give a different boost to different values in the field or attribute\. For example, if your are boosting a field or attribute called "Department," you can give a different boost to documents from "HR" to those from "Legal"\.

You tune the relevance of a field or attribute using the console or the [UpdateIndex](API_UpdateIndex.md) operation\. For example, the following example marks the "\_last\_updated\_at" field as the freshness field for a document\.

```
"DocumentMetadataConfigurationUpdates" : [
    "Name": "_last_updated_at",
    "Type": "DATE_VALUE",
    "Relevance": {
        "Freshness": TRUE,
        "Importance": 2
    }
]
```

The following example applies a different importance to values in the "department" field\.

```
"DocumentMetadataConfigurationUpdates" : [
    "Name": "department",
    "Type": "STRING_VALUE",
    "Relevance": {
        "Importance": 2,
        "ValueImportanceMap": {
            "HR": 3,
            "Legal": 1
        }
    }
]
```
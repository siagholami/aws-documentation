--------

--------

# Sorting responses<a name="sorting"></a>

By default, query responses are sorted by the relevance score that Amazon Kendra determines for each result in the response\. To change the sort order, make a document attribute sortable and then configure Amazon Kendra to use that attribute to sort responses\.

 Amazon Kendra uses the sorting attribute as part of the criteria for the documents returned by the query\. For example, the results returned by a query sorted by "\_created\_at" might not contain the same results as a query sorted by "\_version"\.

You can sort results on any built\-in or custom attribute of the following types:
+ Date value
+ Long value
+ String value

You can't sort attributes of the following type:
+ String list values

You can sort on only one document attribute in each query\. Queries return 100 results\. If there are fewer than 100 documents with the sorting attribute set, documents without a value for the sorting attribute are returned at the end of the results, sorted by relevance to the query\.

**To sort document results \(AWS SDK\)**

1. To use the [UpdateIndex](API_UpdateIndex.md) operation to make an attribute sortable, set the `Sortable` parameter to `true`\. The following JSON example is a `DocumentMetadataConfigurationUpdates` structure that adds an attribute called "Department" to the index and makes it sortable\.

   ```
   "DocumentMetadataConfigurationUpdates": [
      {
          "Name": "Department",
          "Type": "STRING_VALUE",
          "Search": {
              "Sortable": "true"
          }
      }
   ]
   ```

1. To use a sortable attribute in a query, set the `SortingConfiguration` parameter of the [Query](API_Query.md) operation\. Specify the name of the attribute to sort and whether to sort the response in ascending or descending order\.

   The following JSON example shows the `SortingConfiguration` parameter that you use to sort the results of a query by the "Department" attribute in ascending order\.

   ```
      "SortingConfiguration": { 
         "DocumentAttributeKey": "Department",
         "SortOrder": "ASC"
      }
   ```

**To sort document results \(console\)**

1. To make an attribute sortable in the console, choose **Sortable** in the attribute definition\. You can make an attribute sortable when you create the attribute, or you can modify it later\.

1. To sort a query response in the console, choose the attribute to sort the response from the **Sort** menu\. Only attributes that were marked sortable during datasource configuration appear in the list\.
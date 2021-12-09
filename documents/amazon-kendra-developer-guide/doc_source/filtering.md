--------

--------

# Filtering queries<a name="filtering"></a>

You can improve the response from the [Query](API_Query.md) operation by using filters\. Filters restrict the documents in the response to ones that directly apply to the query\. You can create faceted search suggestions, use Boolean logic to filter out documents that don't match a specified criteria, or filter out specific document attributes from the response\.

## Facets<a name="search-facets"></a>

Facets are scoped views of a set of search results\. For example, if your index provides search results for cities across the world, you can use facets to offer your users search results filtered to a specific city\. Or, you can create facets for search results that are written by a specific author\. The following example shows how to get facet information for the `_category` custom attribute\. 

```
response=kendra.query(
        QueryText = query,
        IndexId = index,
        Facets = [
            {
                "DocumentAttributeKey" : "_category"
            }
        ]
        )
```

Facet information is returned in the `FacetResults` response array\. You use the contents to display faceted search suggestions in your application\. For example, if the document attribute `Category` contains the city that a search could apply to, use that information to display a list of city searches\. Users can choose a city to get faceted search results scoped to the city\. To make the faceted search, call [Query](API_Query.md) and use the chosen document attribute to filter the results\. For an example, see [Using document attributes to filter queries](#search-filtering)\.

The following sample JSON response shows facets scoped to the `_category` document attribute\. The response includes the count of documents that include the value of the document attribute\.

```
{
    'FacetResults': [
        {
            'DocumentAttributeKey': '_category',
            'DocumentAttributeValueCountPairs': [
                {
                    'Count': 3,
                    'DocumentAttributeValue': {
                        'StringValue': 'Dubai'
                    }
                },
                {
                    'Count': 3,
                    'DocumentAttributeValue': {
                        'StringValue': 'Seattle'
                    }
                },
                {
                    'Count': 1,
                    'DocumentAttributeValue': {
                        'StringValue': 'Paris'
                    }
                }
            ]
        }
    ]
```

When you use a string list field to create facets, the facet results returned are based on the contents of the string list\. For example, if you have a string list field that contains two items, one with the value "corgi","dachshund," and one with the value "husky," you get a `FacetsResults` structure with three facets\.

For more information, see [Query responses](query-response.md)\.

## Using document attributes to filter queries<a name="search-filtering"></a>

By default, `Query` returns all search results\. To filter responses, you can perform logical operations on the document attributes\. For example, if you only want documents for a specific city, you can filter on the `City` and `State` custom document attributes\. You use the [AttributeFilter](API_AttributeFilter.md) input parameter to create a Boolean operation on filters that you supply\.

The following example shows how to perform a logical AND operation by filtering on a specific city, *Seattle*, and state, *Washington*\. 

```
response=kendra.query(
        QueryText = query,
        IndexId = index,
        AttributeFilter = {'AndAllFilters': 
            [ 
                {"EqualsTo": {"Key": "City","Value": {"StringValue": "Seattle"}}},
                {"EqualsTo": {"Key": "State","Value": {"StringValue": "Washington"}}}
            ]
            }
        )
```

The following example shows how to perform a logical OR operation for when any of the `Fileformat`, `Author`, or `SourceURI` keys match the specified values\. 

```
response=kendra.query(
        QueryText = query,
        IndexId = index,
        AttributeFilter = {'OrAllFilters': 
            [ 
                {"EqualsTo": {"Key": "Fileformat","Value": {"StringValue": "AUTO_DETECT"}}},
                {"EqualsTo": {"Key": "Author","Value": {"StringValue": "Ana Carolina"}}},
                {"EqualsTo": {"Key": "SourceURI","Value": {"StringValue": "https://aws.amazonaws.com/234234242342"}}}
            ]
            }
        )
```

For `StringList` fields, use the `ContainsAny` or `ContainsAll` attribute filters to return documents with the specified string\. The following example shows how to return all documents that have the values "Seattle" or "Portland" in their `Locations` custom attribute\.

```
response=kendra.query(
        QueryText = query,
        IndexId = index,
        AttributeFilter = {
                "ContainsAny": { "Key": "Locations", "Value": { "StringListValue": [ "Seattle", "Portland"] }}
            }
        )
```

## Filtering a document's attributes<a name="filtering-document-attributes"></a>

By default, all document attributes for a document are returned in the `DocumentAttributes` response field\. You can choose to include only specific document attributes by using the `IncludeDocumentAttributes` input parameter\. In the following example, only the `SourceURI` and `Author` document attributes are included in the response for a document\. 

```
response=kendra.query(
        QueryText = query,
        IndexId = index,
        IncludeDocumentAttributes = ["SourceURI", "Author"]
        )
```
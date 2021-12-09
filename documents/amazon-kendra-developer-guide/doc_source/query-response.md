--------

--------

# Query responses<a name="query-response"></a>

A call to [Query](API_Query.md) returns information about the results of a search\. The results are in an array of [QueryResultItem](API_QueryResultItem.md) objects \(`ResultItems`\)\. Each `QueryResultItem` includes a summary of the result\. Document attributes associated with the query result are included\. 

**Summary information**  
The summary information varies depending on the type of result\. In each case, it includes document text that matches the search term\. It also includes highlight information that you can use to highlight the search text in your application's output\. For example, if the search term is *what is the height of the Space Needle?*, the summary information includes text location for the words *height* and *space needle*\. For information about response types, see [Response types ](response-types.md)\. 

**Document attributes**  
Each result contains document attributes for the document that matches a query\. Some of the attributes are predefined, such as `DocumentId`, `DocumentTitle`, and `DocumentUri`\. Others are custom attributes that you define\. You can use document attributes to filter the response from the `Query` operation\. For example, you might want only the documents written by a specific author or a specific version of a document\. For more information, see [Filtering queries](filtering.md)\. You specify document attributes when you add documents to an index\. For more information, see [Creating custom document attributes](custom-attributes.md)\.

The following is sample JSON code for a query result\. Note the document attributes in `DocumentAttributes` and `AdditionalAttributes`\. 

```
{
    "QueryId": "query-id",
    "ResultItems": [
        {
            "Id": "result-id",
            "Type": "ANSWER",
            "AdditionalAttributes": [
                {
                    "Key": "AnswerText",
                    "ValueType": "TEXT_WITH_HIGHLIGHTS_VALUE",
                    "Value": {
                        "TextWithHighlightsValue": {
                            "Text": "text",
                            "Highlights": [
                                {
                                    "BeginOffset": 55,
                                    "EndOffset": 90,
                                    "TopAnswer": false
                                }
                            ]
                        }
                    }
                }
            ],
            "DocumentId": "document-id",
            "DocumentTitle": {
                "Text": "title"
            },
            "DocumentExcerpt": {
                "Text": "text",
                "Highlights": [
                    {
                        "BeginOffset": 0,
                        "EndOffset": 300,
                        "TopAnswer": false
                    }
                ]
            },
            "DocumentURI": "uri",
            "DocumentAttributes": []
        },
        {
            "Id": "result-id",
            "Type": "DOCUMENT",
            "AdditionalAttributes": [],
            "DocumentId": "document-id",
            "DocumentTitle": {
                "Text": "title",
                "Highlights": []
            },
            "DocumentExcerpt": {
                "Text": "text",
                "Highlights": [
                    {
                        "BeginOffset": 74,
                        "EndOffset": 77,
                        "TopAnswer": false
                    }
                ]
            },
            "DocumentURI": "uri",
            "DocumentAttributes": [
                {
                    "Key": "_source_uri",
                    "Value": {
                        "StringValue": "uri"
                    }
                }
            ]
        }
    ],
    "FacetResults": [],
    "TotalNumberOfResults": number
}
```
# Getting Autocomplete Suggestions in Amazon CloudSearch<a name="getting-suggestions"></a>

This section describes how to configure suggesters so you can retrieve suggestions\. Suggestions are possible matches for an incomplete search query—they enable you to display likely matches before users finish typing their queries\. In Amazon CloudSearch, suggestions are based on the contents of a particular text field\. When you request suggestions, Amazon CloudSearch finds all of the documents whose values in the suggester field start with the specified query string—the beginning of the field must match the query string to be considered a match\. The return data includes the field value and document ID for each match\. You can configure suggesters to find matches for the exact query string, or to perform approximate string matching \(fuzzy matching\) to correct for typographical errors and misspellings\. 

For more information about the suggest API, see [Suggest](search-api.md#suggest) in the [Search API Reference](search-api.md)\.

**Topics**
+ [Configuring Suggesters for Amazon CloudSearch](#configuring-suggesters)
+ [Retrieving Suggestions in Amazon CloudSearch](#retrieving-suggestions)

## Configuring Suggesters for Amazon CloudSearch<a name="configuring-suggesters"></a>

When you configure a suggester, you must specify the name of the text field you want to search for possible matches and a unique name for the suggester\. Fields used for suggestions must be return enabled\. Only the first 512 bytes of data in the field are used to generate suggestions\. 

Suggester names must begin with a letter and be at least three and no more than 64 characters long\. The allowed characters are: a\-z \(lower\-case letters\), 0\-9, and \_ \(underscore\)\. The suggester name is specified in the query string when you retrieve suggestions, so it's best to use short names\. The name *score* is reserved and cannot be used as a suggester name\. 

Suggesters also support two options:
+ `FuzzyMatching`—You can set the level of fuzziness allowed when suggesting matches for a string to none, low, or high\. With none, the specified string is treated as an exact prefix\. With low, suggestions must differ from the specified string by no more than one character\. With high, suggestions can differ by up to two characters\. The default is none\. 
+ `SortExpression`—You can configure this expression to compute a score for each suggestion to control how they are sorted\. The scores are rounded to the nearest integer, with a floor of 0 and a ceiling of 2^31\-1\. A document's relevance score is not computed for suggestions, so sort expressions cannot reference the `_score` value\. To sort suggestions using a numeric field or existing expression, simply specify the name of the field or expression\. If no expression is configured for the suggester, the suggestions are sorted in alphabetical order\. Note that an expression defined within a suggester cannot be referenced in search requests or other expressions\. If want to use an expression for other purposes, add it to your domain configuration and reference it by name from the suggester\. For more information about expressions, see [Configuring Expressions](configuring-expressions.md)\.

If you want to get suggestions from multiple text fields, you define a suggester for each field and submit separate suggestion requests to get matches from each suggester\. You can configure up to ten suggesters\. Suggesters can consume significant amounts of memory and disk space, particularly if you use text\-heavy source fields and set fuzzy matching to high\.

**Tip**  
Instead of configuring suggesters to use *all* possibilities from *all* documents, consider indexing the most popular 1,000 or 10,000 search queries and configuring suggesters to use those\. You can store the queries in a separate Amazon CloudSearch index or in a field used only for suggestions\.

The easiest way to define suggesters is through the [**Suggesters** page](#configuring-suggesters-console) in the Amazon CloudSearch console\. You can also define suggesters using the AWS SDKs or AWS CLI\.

**Important**  
After you add a suggester to your search domain, you must run indexing before you can use it to retrieve suggestions\. As you add and delete documents, you must periodically rebuild your index to update the suggestions\. Suggestions won't reflect added or deleted documents until you call `IndexDocuments`\. 

### Configuring Suggesters through the Amazon CloudSearch Console<a name="configuring-suggesters-console"></a>

You can easily add, update, and delete suggesters through the Amazon CloudSearch console\. 

**To add a suggester**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the navigation pane, click the name of the domain, and then click the domain's **Suggesters** link\.

1. In the **Suggesters** pane, click the **Add a New Suggester** button\. The button is below the list of suggesters configured for the domain\.

1. Enter a name for the new suggester in the **Name** field\. 

1. Specify the text field you want to use for suggestions in the **Source** field\. 

1. If you want to include suggestions that correct for minor misspellings or typos, set the **Fuzzy Matching** option to **low** or **high**\. When set to low, the suggestions include terms that differ from the user query string by a single character\. When set to high, the suggestions include terms that differ by up to two characters\. 

1. If you want to control how the suggestions are sorted, enter a numeric expression in the **Sort Expression** field\. The expression can simply be the name of the numeric field you want to use to sort the suggestions, the name of an existing expression, or any valid expression\. For more information about expressions, see [Configuring Expressions](configuring-expressions.md)\. 

1. Click **Submit** to save your changes\.

1. When you are done configuring suggesters for your search domain, you must re\-index your domain before you can use the suggesters\. To run indexing, go to the domain dashboard and click the **Run Indexing** button on the domain dashboard\. 

**To update a suggester**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain, and then click the domain's **Suggesters** link\.

1. In the **Suggesters** pane, modify the suggester settings\.

1. Click **Submit** to save your changes\.

**To delete a suggester**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** pane, click the name of the domain, and then click the domain's **Suggesters** link\.

1. In the **Suggesters** pane, click the **Delete this Suggester** link for the suggester\(s\) you want to remove\.

1. Click **Submit** to save your changes\.

### Configuring Suggesters with the AWS CLI<a name="configuring-suggesters-clt"></a>

You can add or update suggesters with the `aws cloudsearch define-suggester` command\. To remove a suggester, you use `aws cloudsearch delete-suggester`\.

**To add or update a suggester**
+ Run the `aws cloudsearch define-suggester` command\. You specify the configuration of the suggester in JSON with the `--suggester` option\. The suggester configuration must be enclosed in quotes and all quotes within the configuration must be escaped with a backslash\. For the format of the suggester configuration, see [define\-suggester](https://docs.aws.amazon.com/cli/latest/reference/cloudsearch/define-suggester.html) in the AWS CLI Command Reference\. For example, the following command configures a suggester called `mysuggester` to return suggestions based on the `title` field\.

  ```
  aws cloudsearch define-suggester --domain-name movies --suggester "{\"SuggesterName\": \"mysuggester\", \"DocumentSuggesterOptions\": {\"SourceField\":\"title\"}}" 
  {
    "Suggester": {
      "Status": {
        "PendingDeletion": false,
        "State": "RequiresIndexDocuments",
        "CreationDate": "2014-06-26T17:26:43Z",
        "UpdateVersion": 27,
        "UpdateDate": "2014-06-26T17:26:43Z"
      },
      "Options": {
        "DocumentSuggesterOptions": {
          "SourceField": "title"
        },
        "SuggesterName": "mysuggester"
      }
    }
  }
  ```

  You can use the `--fuzzy-matching` option to include suggestions that correct for minor misspellings or typos\. Valid values for fuzzy matching are `none`, `low`, and `high`\. \(The default is `none`\.\) When set to `low`, the suggestions will include terms that differ from the user query string by a single character\. When set to `high`, the suggestions will include terms that differ by up to two characters\. For example, the following command configures `mysuggester` to include suggestions that differ from the user query string by just one character: 

  ```
  aws cloudsearch  --name mysuggester --source title 
    --fuzzy-matching low
  ```

  You can use the `--sort-expression` option to control how the returned suggestions are sorted\. You can use any valid expression for sorting\. \(Often, this will just be the name of a numeric field or a predefined expression\.\) For example, to sort the suggestions returned by `mysuggester` according to the value in the `year` field, specify:

  ```
  aws cloudsearch define-suggester --name mysuggester --source title 
    --fuzzy-matching low --sort-expression year
  ```

**To delete a suggester**
+ Run the `aws cloudsearch delete-suggester` command and specify the `--name` option\. For example, to delete `mysuggester`:

  ```
  aws cloudsearch delete-suggester --name mysuggester --delete
  ```

### Configuring Suggesters Using the AWS SDKs<a name="configuring-suggesters-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[DefineSuggester](API_DefineSuggester.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.

## Retrieving Suggestions in Amazon CloudSearch<a name="retrieving-suggestions"></a>

You retrieve suggestions by sending requests to the `suggest` resource on a domain's search endpoint via HTTP GET\. For example:

```
http://search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.
amazonaws.com/2013-01-01/suggest?q=kat&suggester=mysuggester
```

You must specify the API version in the request and the query string must be URL\-encoded\. The maximum size of a suggestion request is 8190 bytes, including the HTTP method, URI, and protocol version\.

 The `suggest` resource supports four parameters:
+ `q`—The string that you want to get suggestions for\. 
+ `suggester`—The name of the suggester you want to use\.
+ `size`—The number of suggestions to retrieve\. By default, the top ten suggestions are returned\. \(The suggestions are sorted according the sort expression defined in the suggester\. If no sort expression is defined in the suggester, the suggestions are sorted in alphabetical order\.\)
+ `format`—The content type of the response, `json` or `xml`\. By default, suggestions are returned in JSON\.

The `q` and `suggester` parameters must be specified\. No suggestions are returned if you request suggestions for an empty string\. The `size` and `format` parameters are optional\. 

The following example gets suggestions for the string `oce` based on the contents of the `title` field\.

```
http://search-imdb2-m2brrr7ex7z6sqhgwsjdmcuvd4.us-east-1.cloudsearch.amazonaws.com/2013-01-01/suggest?q=san&suggester=citystate
{
  "status": {
    "rid": "646f5s0oDAr8pVk=",
    "time-ms": 2
  },
  "suggest": {
    "query": "oce",
    "found": 3,
    "suggestions": [{
        "suggestion": "Ocean's Eleven",
        "score": 0,
        "id": "tt0054135"
      },
      {
        "suggestion": "Ocean's Thirteen",
        "score": 0,
        "id": "tt0496806"
      },
      {
        "suggestion": "Ocean's Twelve",
        "score": 0,
        "id": "tt0349903"
      }
    ]
  }
}
```
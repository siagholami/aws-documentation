# Searching for Text in Amazon CloudSearch<a name="searching-text"></a>

You can search both text and literal fields for a text string: 
+ `Text` and `text-array` fields are always searchable\. You can search for individual terms as well as phrases\. Searches within `text` and `text-array` fields are not case\-sensitive\.
+ `Literal` and `literal-array` fields can only be searched if they are search enabled in the domain's indexing options\. You can search for an exact match of your search string\. Searches in literal fields are case\-sensitive\.

If you use the simple query parser or do not specify a field when searching with the structured query parser, by default all `text` and `text-array` fields are searched\. Literal fields are *not* searched by default\. You can specify which fields you want to search with the `q.options` parameter\. 

You can search the unique document ID field like any text field\. To reference the document ID field in a search request, you use the field name `_id`\. Document IDs are always returned in the search results\. 

**Topics**
+ [Searching for Individual Terms in Amazon CloudSearch](#searching-text-terms)
+ [Searching for Phrases in Amazon CloudSearch](#searching-text-phrases)
+ [Searching for Literal Strings in Amazon CloudSearch](#searching-text-literals)
+ [Searching for Prefixes in Amazon CloudSearch](#searching-text-prefixes)

## Searching for Individual Terms in Amazon CloudSearch<a name="searching-text-terms"></a>

When you search `text` and `text-array` fields for individual terms, Amazon CloudSearch finds all documents that contain the search terms anywhere within the specified field, in any order\. For example, in the sample movie data, the `title` field is configured as a `text` field\. If you search the `title` field for *star*, you will find all of the movies that contain *star* anywhere in the `title` field, such as *star*, *star wars*, and *a star is born*\. This differs from searching `literal` fields, where the field value must be identical to the search string to be considered a match\. 

The `simple` query parser provides an easy way to search `text` and `text-array` fields for one or more terms\. The `simple` query parser is used by default unless you use the `q.parser` parameter to specify a different query parser\. 

For example, to search for *katniss*, specify `katniss` in the query string\. By default, Amazon CloudSearch includes all return enabled fields in the search results\. You can specify the `return` parameter to specify which fields you want to return\.

```
https://search-domainname-domainid.us-east-1.cloudsearch.amazonaws.com/
2013-01-01/search?q=katniss&return=title
```

By default, the response is returned in JSON:

```
{
    "status": {
        "rid": "rd+5+r0oMAo6swY=",
        "time-ms": 9
    },
    "hits": {
        "found": 3,
        "start": 0,
        "hit": [
            {
                "id": "tt1951265",
                "fields": {
                    "title": "The Hunger Games: Mockingjay - Part 1"
                }
            },
            {
                "id": "tt1951264",
                "fields": {
                    "title": "The Hunger Games: Catching Fire"
                }
            },
            {
                "id": "tt1392170",
                "fields": {
                    "title": "The Hunger Games"
                }
            }
        ]
    }
}
```

To specify multiple terms, separate the terms with a space\. For example: `star wars`\. When you specify multiple search terms, by default documents must contain all of the terms to be considered a match\. The terms can occur anywhere within the text field, in any order\. 

By default, all `text` and `text-array` fields are searched when you use the simple query parser\. You can specify which fields you want to search by specifying the `q.options` parameter\. For example, this query constrains the search to the `title` and `description` fields and boosts the importance of matches in the `title` field over matches in the `description` field\.

```
q=star wars&q.options={fields: ['title^5','description']}
```

When you use the simple query parser, you can use the following prefixes to designate individual terms as required, optional, or to be excluded from the search results: 
+ **`+`**—matching documents must contain the term\. This is the default—separating terms with a space is equivalent to preceding them with the `+` prefix\.
+ **`-`**—exclude documents that contain the term from the search results\. The `-` operator only applies to individual terms\. For example, to exclude documents that contain the term *star* in the default search field, specify: `-star`\. Searching for `search?q=-star wars` retrieves all documents that do not contain the term *star*, but do contain the term *wars*\. 
+ **`|`**—include documents that contain the term in the search results, even if they don't contain the other terms\. The `|` operator only applies to individual terms\. For example, to include documents that contain either of two terms, specify: `term1 |term2`\. Searching for `search?q=star wars |trek` includes documents that contain both *star* and *wars*, or the term *trek*\.

These prefixes only apply to individual terms in a simple query\. To construct compound queries, you need to use the structured query parser, rather than the simple query parser\. For example, to search for the terms *star* and *wars* using the structured query parser you would specify:

```
(and 'star' 'wars')
```

Note that this query matches documents that contain each of the terms in any of the fields being searched\. The terms do not have to be in the same field to be considered a match\. If, however, you specify `(and 'star wars' 'luke')`, *star* and *wars* must occur within the same field, and *luke* can occur in any of the fields\.

If you don't specify any fields when you use the `structured` query parser, all `text` and `text-array` fields are searched by default, just like with the `simple` parser\. Similarly, you can use the `q.options` parameter to control which fields are searched and to boost the importance of selected fields\. For more information, see [Constructing Compound Queries](searching-compound-queries.md)\.

You can also perform *fuzzy* searches with the simple query parser\. To perform a fuzzy search, append the `~` operator and a value that indicates how much terms can differ from the user query string and still be considered a match\. For example, the specifying `planit~1` searches for the term *planit* and allows matches to differ by up to one character, which means the results will include hits for *planet*\.

## Searching for Phrases in Amazon CloudSearch<a name="searching-text-phrases"></a>

When you search for a phrase, Amazon CloudSearch finds all documents that contain the complete phrase in the order specified\. You can also perform *sloppy* phrase searches where the terms appear within the specified distance of one another\.

To match a complete phrase rather than the individual terms in the phrase when you search with the simple query parser, enclose the phrase in double quotes\. For example, the following query searches for the phrase *with love*\.

```
q="with love"
```

To perform a sloppy phrase search with the simple query parser, append the `~` operator and a distance value\. The distance value specifies the maximum number of words that can separate the words in the phrase\. For example, the following query searches for the terms *with love* within three words of one another\. 

```
q="with love"~3
```

In a compound query, you use the `phrase` operator to specify the phrase you want to match; for example:

```
(phrase field=title 'star wars')
```

To perform a sloppy phrase search in a compound query, you use the `near` operator\. The `near` operator enables you to specify the phrase you are looking for and how far apart the terms can be within a field and still be considered a match\. For example, the following query matches documents that have the terms *star* and *wars* no more than three words apart in the `title` field\.

```
(near field=title distance=3 'star wars')
```

For more information, see [Constructing Compound Queries](searching-compound-queries.md)\.

## Searching for Literal Strings in Amazon CloudSearch<a name="searching-text-literals"></a>

When you search a literal field for a string, Amazon CloudSearch returns only those documents that contain an exact match for the complete search string in the specified field, including case\. For example, if the `title` field is configured as a literal field and you search for *Star*, the value of the `title` field must be *Star* to be considered a match—*star*, *star wars* and *a star is born* will not be included in the search results\. This differs from text fields, where searches are not case\-sensitive and the specified search terms can appear anywhere within the field in any order\.

To search a literal field, prefix the search string with the name of the literal field you want to search, followed by a colon\. The search string must be enclosed in single quotes\. For example, the following query searches for the literal string *Sci\-Fi*\.

```
genres:'Sci-Fi'
```

This example searches the genre field of each document and matches all documents whose genre field contains the value *Sci\-Fi*\. To be a match, the field value must be an exact match for the search string, including case\. For example, documents that contain the value *Sci\-Fi* in the genre field will not be included in the search results if you search for *sci\-fi* or *young adult sci\-fi*\.

In a compound query, you use the `term` operator syntax to search literal fields\. For example, `(term field=genres 'Sci-Fi')`\. For more information, see [Constructing Compound Queries](searching-compound-queries.md)\.

You can use literal fields in conjunction with faceting to enable users to drill down into the results according to the faceted attributes\. For more information about faceting, see [Getting and Using Facet Information in Amazon CloudSearch](faceting.md)\.

## Searching for Prefixes in Amazon CloudSearch<a name="searching-text-prefixes"></a>

You can search `text`, `text-array`, `literal`, and `literal-array` fields for a *prefix* rather than for a complete term\. This matches results that contain the prefix followed by zero or more characters\. You must specify at least one character as the prefix\. \(To match all documents, use the `matchall` operator in a structured query\.\) In general, you should use a prefix that contains at least two characters to avoid matching an excessive number of documents\.

When you search a `text` or `text-array` field, terms that match the prefix can occur anywhere within the contents of the field\. When you search literal fields, the entire search string, up to and including the prefix characters, must match exactly\. 
+ Simple query parser—use the `*` \(asterisk\) wildcard operator to search for a prefix, for example `pre*`\.
+ Structured query parser—use the `prefix` operator to search for a prefix, for example `prefix 'pre'` 

For example, the following query searches for the prefix *oce* in the title field and returns the title of each hit:

```
q=oce*&q.options={fields:['title']}&return=title
```

If you perform this search against the sample movie data, it returns as *Ocean's Eleven* and *Ocean's Twelve*: 

```
{

    "status": {
        "rid": "hIbIxb8oRAo6swY=",
        "time-ms": 2
    },
    "hits": {
        "found": 2,
        "start": 0,
        "hit": [
            {
                "id": "tt0240772",
                "fields": {
                    "title": "Ocean's Eleven"
                }
            },
            {
                "id": "tt0349903",
                "fields": {
                    "title": "Ocean's Twelve"
                }
            }
        ]
    }

}
```

In a compound query, you use the `prefix` operator to search for prefixes\. For example, to search the `title` field for the prefix *oce*, you specify:

```
q.parser=structured&q=(prefix field%3Dtitle 'oce')
```

Note the URL encoding\. For more information, see [Constructing Compound Queries](searching-compound-queries.md)\.

**Note**  
When performing wildcard searches on text fields, keep in mind that Amazon CloudSearch tokenizes the text fields during indexing and performs stemming according to the analysis scheme configured for the field\. Normally, Amazon CloudSearch performs the same text processing on the search query\. However, when you search for a prefix with the wildcard operator \(\*\) or `prefix` operator, no stemming is performed on the prefix\. This means that a search for a prefix that ends in `s` won't match the singular version of the term\. This can happen for any term that ends in `s`, not just plurals\. For example, if you search the `actor` field in the sample movie data for `Anders`, there are three matching movies\. If you search for `Ander*`, you get those movies as well as several others\. However, if you search for `Anders*` there are no matches\. This is because the term is stored in the index as `ander`, `anders` does not appear in the index\. For more information about how Amazon CloudSearch processes text and how it can affect searches, see [Text Processing in Amazon CloudSearch](text-processing.md)\.
# Highlighting Search Hits in Amazon CloudSearch<a name="highlighting"></a>

Amazon CloudSearch can return excerpts with the search results to show where the search terms occur within a particular field of a matching document\. For example, in the following excerpt the search terms *luke skywalker* are highlighted within the `plot` field:

```
highlights": {
    "plot": "After the rebels have been brutally overpowered by the Empire on
    their newly established base, *Luke* *Skywalker* takes advanced Jedi 
    training with Master Yoda, while his friends are pursued by Darth Vader 
    as part of his plan to capture *Luke*."
}
```

If you search for a phrase, the matching documents must contain that phrase\. However, when you retrieve highlights, the terms in the phrase are highlighted individually\. If you search for the phrase `"Luke Skywalker"` and retrieve highlights for the `plot` field as shown in the previous example, the term `Luke` is highlighted even when it isn't followed by `Skywalker`\. Highlights are returned for the first 10 KB of data in a field\. If the field contains more than 10 KB of data and the search terms appear past the 10 KB limit, they are not highlighted\.

You can get highlights for any highlight enabled field by specifying the `highlight.FIELD` parameter in your search request\. For example, to get highlights for the `plot` field shown, you could specify the following:

```
search?q=star wars&highlight.plot={}
```

For more information about enabling a field to return highlights, see [Configuring Index Fields](configuring-index-fields.md)\.

You can control how many occurrences of the search term\(s\) within an excerpt are highlighted, how they should be highlighted, and whether the excerpt is returned as plain text or HTML\. When Amazon CloudSearch returns excerpts as HTML, non\-alphanumeric characters are escaped with HTML entity encoding\. This is done to minimize the risks associated with embedding untrusted HTML content, since the field might have originally been populated with user\-generated content\. 

You specify highlight options as a JSON object\. If the JSON object is empty, `highlight.FIELD={}`, Amazon CloudSearch highlights all occurrences of the search term\(s\) by enclosing them in HTML emphasis tags, <em>*term*</em>, and the excerpts are returned as HTML\. 
+ To specify whether the excerpt should be returned as `text` or `html`, use the `format` option; for example, `highlight.plot={format:'text'}`\.
+ To specify the maximum number of occurrences of the search term\(s\) you want to highlight, use the `max_phrases` option; for example, `highlight.plot={max_phrases:3}`\. The default is 1, the maximum is 5\.
+ To specify the string to prepend to each highlighted term, use the `pre_tag` option; for example, `highlight.plot={pre_tag:'<strong>', post_tag:'</strong>'}`\.
+ To specify the string to append to each highlighted term, use the `post_tag` option; for example, `highlight.plot={pre_tag:'<strong>', post_tag:'</strong>'}`\.
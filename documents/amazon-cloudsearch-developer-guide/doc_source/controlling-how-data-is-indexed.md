# Controlling How Data is Indexed in Amazon CloudSearch<a name="controlling-how-data-is-indexed"></a>

You control how your data is indexed by configuring indexing options and analysis schemes for your domain\. Indexing options control how your data is mapped to index fields and what information you can search and retrieve from the index\. The data you upload must contain the same fields configured in your domain's indexing options, and the field values must be compatible with the configured field types\. Analysis schemes control how `text` and `text-array` fields are processed during indexing by defining language\-specific stemming, stopword, and synonym options\. 

**Topics**
+ [Preparing Your Data for Amazon CloudSearch](preparing-data.md)
+ [configure indexing options](configuring-index-fields.md)
+ [Using Dynamic Fields in Amazon CloudSearch](using-dynamic-fields.md)
+ [Configuring Text Analysis Schemes for Amazon CloudSearch](configuring-analysis-schemes.md)
+ [Text Processing in Amazon CloudSearch](text-processing.md)